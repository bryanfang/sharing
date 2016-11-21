package com.cscsharing.service;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import com.cscsharing.jampojo.Member;
import com.cscsharing.utils.Constraints;
import com.cscsharing.utils.Formatter;

import net.sf.json.JSONObject;

@Service
public class JAMServiceImpl implements JAMService {

	private static final Log logger = LogFactory.getLog(JAMServiceImpl.class);

	@Autowired
	private RestTemplate restTemplate;
	
	private String getJAMInforByURL(String url) {
		assert(url != null);
    	logger.info("getJAMInforByURL - Current reqeust URL: " + url);
    	HttpHeaders headers = new HttpHeaders();
    	headers.add("Content-type", "application/json");
    	headers.add("Accept", "application/json");
    	headers.add("Authorization", String.format("Bearer %s", Constraints.OATH2_ACCESSTOKEN));
    	HttpEntity<String> request = new HttpEntity<String>(null, headers);
    	ResponseEntity<String> responseEntity = restTemplate.exchange(url, HttpMethod.GET, request, String.class);
    	logger.info(responseEntity.getHeaders() + responseEntity.getBody());
    	return responseEntity.getBody();
    }
	
	@Override
	public Member getCreatorByEventId(String eventId) {
		// TODO Auto-generated method stub
		String creatorURL = Constraints.BASE_SERVICE_URL + "Events('"+eventId+"')/Creator";
		String creatorResults = this.getJAMInforByURL(creatorURL);
		JSONObject creatorResult = Formatter.convertToJSON(creatorResults);
		Member creator = new Member();
		creator.setId(creatorResult.getString("Id"));
		creator.setFirstName(creatorResult.getString("FirstName"));
		creator.setLastName(creatorResult.getString("LastName"));
		creator.setNickname(creatorResult.getString("Nickname"));
		creator.setTitle(creatorResult.getString("Title"));
		creator.setEmail(creatorResult.getString("Email"));
		creator.setFullName(creatorResult.getString("Fullname"));
		creator.setRole(creatorResult.getString("Role"));
		creator.setFollowing(creatorResult.getBoolean("IsFollowing"));
		creator.setWebURL(creatorResult.getString("WebURL"));
		creator.setIsAway(creatorResult.getBoolean("IsAway"));
		return creator;
	}

	
	@Override
	public List<Member> getMembersByGroupId(String groupId) {
		// TODO Auto-generated method stub
		return null;
	}

	
	@Override
	public String getGroupInforByEventId(String eventId) {
		// TODO Auto-generated method stub
		String groupURL = Constraints.BASE_SERVICE_URL + "Events('"+eventId+"')/Group";
		String groupData = this.getJAMInforByURL(groupURL);
		return groupData;
	}

	@Override
	public String getAllGroups() {
		// TODO Auto-generated method stub
		return this.getJAMInforByURL(Constraints.GROUP_SERVICE_URL);
	}

}
