package com.cscsharing.controller;
import javax.security.auth.login.LoginContext;
import javax.security.auth.login.LoginException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import com.cscsharing.service.JAMService;
import com.sap.security.auth.login.LoginContextFactory;

@Controller
public class CoreController {
    
	private static final Log logger = LogFactory.getLog(CoreController.class);
	@Autowired
	private JAMService jamService;
	
    @RequestMapping("/layout")
    public String layout() {
        return "layout";
    }
    
    @RequestMapping("/")
    public String index(@RequestParam("id") String id, 
    		HttpServletRequest request,
    		HttpSession session) {
    	String user = request.getRemoteUser();
    	logger.debug("Current login user: " + user);
    	logger.debug("post id is: " + id);
    	session.setAttribute("postId", id);
    	session.setAttribute("user", user);
    	return "redirect:reward";
    }
    
    @RequestMapping("/reward")
    public String rewards(){
    	logger.debug("Redirect to rewards.html page.");
    	return "rewards";
    }
    
    @RequestMapping(value="/allmembers")
    public @ResponseBody String getAllMemebrsByPostID(String postID){
    	logger.debug("Retrive all memebers belong to the creator of post id");
    	String mockJsonData = "[{'userId':'001','time':'Good','qa':'Excellent','comment':'Good'},{'userId':'002','time':'Good','qa':'Excellent','comment':'Good'}]";
    	return mockJsonData;
    }
    
    @RequestMapping(value="/userinfor")
    public String user(){
    	return "user";
    }
    
    @RequestMapping(value={"/user/info"}, method = RequestMethod.GET)
	public @ResponseBody String index(HttpServletRequest request,
			HttpServletResponse response){
		String user = request.getRemoteUser();
		if(user != null){
			return "Hello: "+ user;
		}
		else{
			LoginContext loginContext;
			try{
				loginContext = LoginContextFactory.createLoginContext("FORM");
				loginContext.login();
				return "Hello: " + request.getRemoteUser();
			}catch (LoginException e) {
				e.printStackTrace();
			}
		}
		return "error";
	}
    
    @RequestMapping(value="/getAllGroups")
    public @ResponseBody String getAllGroups() {
    	return jamService.getAllGroups();
    }
    
}
