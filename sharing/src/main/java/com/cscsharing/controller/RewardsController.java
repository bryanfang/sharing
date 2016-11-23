package com.cscsharing.controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.sap.security.um.service.UserManagementAccessor;
import com.sap.security.um.user.UnsupportedUserAttributeException;
import com.sap.security.um.user.User;
import com.sap.security.um.user.UserProvider;

@Controller
public class RewardsController {
	
	private static final Log logger = LogFactory.getLog(RewardsController.class);
	
	@RequestMapping(value="/myrewards")
    public ModelAndView toRewards(HttpServletRequest request) throws UnsupportedUserAttributeException{
    	ModelAndView view = new ModelAndView();
    	Map<String, String> map = new HashMap<String, String>();
    	User user = this.getUserInfor(request);
    	map.put("id", request.getUserPrincipal().getName());
    	map.put("firstName", user.getAttribute("firstname"));
    	map.put("lastName", user.getAttribute("lastname"));
    	map.put("email", user.getAttribute("email"));
    	view.addObject("viewModel", map);
    	view.setViewName("rewards");
    	return view;
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
