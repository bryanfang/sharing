package com.cscsharing.controller;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.cscsharing.jampojo.Events;
import com.cscsharing.jampojo.Member;
import com.cscsharing.repositories.PersonalScore;
import com.cscsharing.repositories.ScoreHistory;
import com.cscsharing.repositories.UserEventPrimaryKey;
import com.cscsharing.service.JAMService;
import com.cscsharing.service.PersonalScoreService;
import com.cscsharing.service.ScoreHistoryService;
import com.cscsharing.utils.Constraints;
import com.sap.security.um.service.UserManagementAccessor;
import com.sap.security.um.user.UnsupportedUserAttributeException;
import com.sap.security.um.user.User;
import com.sap.security.um.user.UserProvider;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

@Controller
public class FeedBackController {
	
	private static final Log logger = LogFactory.getLog(FeedBackController.class);
	
	@Autowired
	private JAMService jamService;
	
	@Autowired
	private ScoreHistoryService scoreHistoryService;
	
	@Autowired
	private PersonalScoreService personalScoreService;
	

	@RequestMapping("/myfeedback")
	public ModelAndView feedback(HttpSession session) {
		ModelAndView view = new ModelAndView();
		// String eventId = (String)session.getAttribute("eventId");
		String eventId = "DiTYTRylgLdnftFYUpgmeK";
		Member creator = jamService.getCreatorByEventId(eventId);
		Events evt = jamService.getEventByEventId(eventId);
		Map<String, String> map = new HashMap<String, String>();
		map.put("creator", creator.getFullName());
		map.put("description", evt.getDescription());
		map.put("user", session.getAttribute("user").toString());
		map.put("eventId", eventId);
		view.addObject("viewModel", map);
		view.setViewName("feedback");
		return view;
	}

	@RequestMapping("/memberfeedback")
	public @ResponseBody String memberFeed(@RequestParam("objective") String objective,
			@RequestParam("encouraged") String encouraged, @RequestParam("easy") String easy,
			@RequestParam("knowledgeable") String knowledgeable, @RequestParam("preparation") String preparation,
			@RequestParam("time") String time, @RequestParam("eventId") String eventId, HttpServletRequest request) {
		User loginUser = this.getUserInfor(request);
		Date createDate = new Date();
		ScoreHistory scoreHistory = new ScoreHistory();
		String loginUserEmail = "";
		try {
			loginUserEmail = loginUser.getAttribute("email");
		} catch (UnsupportedUserAttributeException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String speakerEmail = jamService.getCreatorByEventId(eventId).getEmail(); 
		if (loginUserEmail.equals(speakerEmail)) { // login user = speaker
			return "Error: Can't comment on your self!";
		} else if (scoreHistoryService.checkIfMemberCommented(loginUserEmail, eventId)) {
			return "Error: You'd put your comment for this session!";
		} else { // member is commenting on speaker
			// 1. save the comment in history table
			scoreHistory.setEventId(eventId);
			scoreHistory.setSpeakerId(speakerEmail);
			scoreHistory.setEasy(Integer.parseInt(easy));
			scoreHistory.setKnowledgeable(Integer.parseInt(knowledgeable));
			scoreHistory.setEncouraged(Integer.parseInt(encouraged));
			scoreHistory.setLoginUserId(loginUserEmail);
			scoreHistory.setObjective(Integer.parseInt(objective));
			scoreHistory.setPreparation(Integer.parseInt(preparation));
			scoreHistory.setCreateDate(createDate);
			scoreHistoryService.save(scoreHistory);

			// 2. insert or update the related speaker score in personal score table
			/***
			 * 2.1 check if there is a record existed in the table first
			 * 2.1.1 if there is one, then update the new record to over write the previous one
			 * 2.1.2 if there is no one, then insert a new record into the database
			 */

		}
		return "Thanks, Your voice was being heared!";
	}

	// handling on feedback from speaker
	@RequestMapping("/speakerfeeback")
	public @ResponseBody String speakerFeed(String jsonFeed, @RequestParam("eventId") String eventId,
			HttpServletRequest request) {
		User loginUser = this.getUserInfor(request);
		Date createDate = new Date();
		
		String loginUserEmail = "";
		try {
			loginUserEmail = loginUser.getAttribute("email");
		} catch (UnsupportedUserAttributeException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String speakerEmail = jamService.getCreatorByEventId(eventId).getEmail(); // use email as identifier
		if(!speakerEmail.equals(loginUserEmail)){
			return "Error: You are not the speaker of this session!";
		}
		
		//if the login user is the speaker, then the user can give feedback to the participants
		JSONArray registers = JSONArray.fromObject(jsonFeed);
		for (int i = 0; i < registers.size(); i++) {
			String email = "";
			boolean registered = false;
			boolean honered = false;
			ScoreHistory scoreHistory = new ScoreHistory();
			JSONObject register = registers.getJSONObject(i);
			if (register != null && register.containsKey("email")) { //target member
				email = register.getString("email");
			}
			if (register != null && register.containsKey("registered")) {
				registered = register.getBoolean("registered");
			}
			if (register != null && register.containsKey("honored")) {
				honered = register.getBoolean("honored");
			}
			
			//check if the speaker had commented on the session, if commented, then can't save the data
			if(scoreHistoryService.checkIfSpeakerCommented(loginUserEmail, eventId, email)){
				return "Error: You had commented on " + email + " before!";
			}
			
			// 1. insert the data into score history table
			scoreHistory.setEventId(eventId);
			if(registered) {
				scoreHistory.setAttendPoints(Constraints.DEFAULT_SCORE_PARTICIPANT);
			}
			if(honered){
				scoreHistory.setHonoredStudent(Constraints.DEFAULT_HONORED);
			}
			scoreHistory.setCreateDate(createDate);
			
			scoreHistoryService.save(scoreHistory);
			
			// 2. insert or update data in personal table
			PersonalScore ps = new PersonalScore();
			ps.setId(new UserEventPrimaryKey(email, eventId));
			ps.setScore(Constraints.DEFAULT_SCORE_PARTICIPANT);
			ps.setExtraBonus(1);
			ps.setValid(true);
			personalScoreService.save(ps);
			
		}
		return "Thanks, Your comment is saved";
	}

	//JUST used for retrieve user information
    private User getUserInfor(HttpServletRequest request){
    	User user = null;
    	if(request.getUserPrincipal() != null){
    		try {
    			UserProvider userProvider = UserManagementAccessor.getUserProvider();
    			user = userProvider.getUser(request.getUserPrincipal().getName());
    		}catch(Exception e){
    			logger.debug(e.getMessage());
    		}
    	}
    	return user;
    }
    
	
}
