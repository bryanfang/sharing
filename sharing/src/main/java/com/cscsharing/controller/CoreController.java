package com.cscsharing.controller;
import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import com.cscsharing.service.JAMService;
import com.cscsharing.utils.Constraints;
import com.sap.security.um.service.UserManagementAccessor;
import com.sap.security.um.user.UnsupportedUserAttributeException;
import com.sap.security.um.user.User;
import com.sap.security.um.user.UserProvider;

@Controller
public class CoreController {
    
	private static final Log logger = LogFactory.getLog(CoreController.class);
	@Autowired
	private JAMService jamService;
	
    @RequestMapping("/")
    public String index(@RequestParam("id") String id, 
    		HttpServletRequest request,
    		HttpSession session) {
    	String user = request.getRemoteUser();
    	logger.debug("Current login user: " + user);
    	logger.debug("post id is: " + id);
    	session.setAttribute("postId", id);
    	session.setAttribute("user", user);
    	return "redirect:myfeedback";
    }
    
    @RequestMapping("/myfeedback")
    public String rewards(){
    	logger.debug("Redirect to rewards.html page.");
    	return "feedback";
    }
    
    @RequestMapping(value="/allmembers")
    public @ResponseBody String getAllMemebrsByPostID(String postID){
    	logger.debug("Retrive all memebers belong to the creator of post id");
    	String mockJsonData = "[{'userId':'001','time':'Good','qa':'Excellent','comment':'Good'},{'userId':'002','time':'Good','qa':'Excellent','comment':'Good'}]";
    	return mockJsonData;
    }
    
    @RequestMapping(value="/getAllGroups")
    public @ResponseBody String getAllGroups() {
    	return jamService.getAllGroups();
    }
    
    @RequestMapping(value="/myprofile")
    public String myProfile(HttpServletRequest request) throws UnsupportedUserAttributeException{
    	User user = this.getUserInfor(request);
    	request.setAttribute("id", request.getUserPrincipal().getName());
    	request.setAttribute("firstName", user.getAttribute("firstname"));
    	request.setAttribute("lastName", user.getAttribute("lastname"));
		request.setAttribute("email", user.getAttribute("email"));
    	return "profile";
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
    
    @RequestMapping("/logout")
    public void logout(HttpServletRequest request, HttpServletResponse response){
    	request.getSession().invalidate();
    	try {
			response.sendRedirect(Constraints.JAM_COMMUNICATION_URL);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
}
