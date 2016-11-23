package com.cscsharing.service;

import java.util.ArrayList;
import java.util.Date;
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

import com.cscsharing.jampojo.Events;
import com.cscsharing.jampojo.Group;
import com.cscsharing.jampojo.Member;
import com.cscsharing.utils.Constraints;
import com.cscsharing.utils.Formatter;

import net.sf.json.JSONArray;
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
		creator.setFullName(creatorResult.getString("FullName"));
		creator.setRole(creatorResult.getString("Role"));
		creator.setFollowing(creatorResult.getBoolean("IsFollowing"));
		creator.setWebURL(creatorResult.getString("WebURL"));
		creator.setIsAway(creatorResult.getBoolean("IsAway"));
		return creator;
	}

	
	@Override
	public List<Member> getMembersByGroupId(String groupId) {
		// TODO Auto-generated method stub
		List<Member> members = new ArrayList<Member>();
		String memberURL = Constraints.BASE_SERVICE_URL + "Groups('"+ groupId + "')/Memberships";
		String memberResult = this.getJAMInforByURL(memberURL);
		JSONArray memberArr = Formatter.convertToJSONArray(memberResult);
		for(int i = 0; i < memberArr.size(); i++){
			JSONObject member = memberArr.getJSONObject(i);
			if(null != member && member.containsKey("MemberId")) {
				String memberId = member.getString("MemberId");
				String memberInforURL = Constraints.BASE_SERVICE_URL + "Members('"+ memberId + "')";
				String memberInforResult = this.getJAMInforByURL(memberInforURL);
				JSONObject memberInfor = Formatter.convertToJSON(memberInforResult);
				if(memberInfor != null) {
					Member memberEntity = new Member();
					memberEntity.setId(memberInfor.getString("Id"));
					memberEntity.setFirstName(memberInfor.getString("FirstName"));
					memberEntity.setLastName(memberInfor.getString("LastName"));
					memberEntity.setNickname(memberInfor.get("Nickname"));
					memberEntity.setTitle(memberInfor.getString("Title"));
					memberEntity.setEmail(memberInfor.getString("Email"));
					memberEntity.setFullName(memberInfor.getString("FullName"));
					memberEntity.setRole(memberInfor.getString("Role"));
					memberEntity.setFollowing(memberInfor.getBoolean("IsFollowing"));
					memberEntity.setWebURL(memberInfor.getString("WebURL"));
					memberEntity.setIsAway(memberInfor.getBoolean("IsAway"));
					members.add(memberEntity);
				}
			}
		}
		return members;
	}

	
	@Override
	public Group getGroupInforByEventId(String eventId) {
		// TODO Auto-generated method stub
		String groupURL = Constraints.BASE_SERVICE_URL + "Events('"+eventId+"')/Group";
		String groupData = this.getJAMInforByURL(groupURL);
		JSONObject groupObj = Formatter.convertToJSON(groupData);
		Group group = new Group();
		group.setId(groupObj.getString("Id"));
		return group;
	}

	@Override
	public String getAllGroups() {
		// TODO Auto-generated method stub
		return this.getJAMInforByURL(Constraints.GROUP_SERVICE_URL);
	}

	@Override
	public Events getEventByEventId(String eventId) {
		// TODO Auto-generated method stub
		String events = this.getJAMInforByURL(Constraints.BASE_SERVICE_URL + "Events('" + eventId + "')");
		JSONObject evtObj = Formatter.convertToJSON(events);
		Events evt = new Events();
		evt.setDescription(evtObj.getString("Description"));
		evt.setAllDay(evtObj.getBoolean("AllDay"));
		evt.setId(eventId);
		evt.setName(evtObj.getString("Name"));
		Date createdAt = Formatter.convertToDate(evtObj.getString("CreatedAt"));
		Date lastModifiedAt = Formatter.convertToDate(evtObj.getString("LastModifiedAt"));
		Date startAt = Formatter.convertToDate(evtObj.getString("StartAt"));
		Date endAt = Formatter.convertToDate(evtObj.getString("EndAt"));	
		evt.setCreatedAt(createdAt);
		evt.setLastModifiedAt(lastModifiedAt);
		evt.setStartAt(startAt);
		evt.setEndAt(endAt);
		evt.setLocation(evtObj.getString("Location"));
		evt.setPriority(evtObj.getString("Priority"));
		evt.setLiked(evtObj.getBoolean("Liked"));
		evt.setLikesCount(evtObj.getInt("LikesCount"));
		evt.setFeedCommentsCount(evtObj.getInt("FeedCommentsCount"));
		return evt;
	}

	/**
	 * Get the duration type by start time and end time
	 * 1 - 0.5 hr
	 * 2 - 1 hr
	 * 3 - 2 hr
	 * 4 - 4 hr
	 * 5 - 1 day
	 */
	@Override
	public int getDurationTypeByEventId(String eventId) {
		// TODO Auto-generated method stub
		Events evt = this.getEventByEventId(eventId);
		if(evt.isAllDay()) {
			return 5;
		}
		else{
			long duration = evt.getEndAt().getTime() - evt.getStartAt().getTime(); //mms
			long durations = duration/1000; //seconds
			long durationm = durations/60; //minutes
			if(durationm <= 30) {
				return 1;
			}
			else if (duration > 30 && duration <= 60) {
				return 2;
			}
			else if (duration > 60 && duration <= 120) {
				return 3;
			}
			else if (duration > 120 && duration <= 240) {
				return 4;
			}
		}
		return 0;
	}

	@Override
	public List<Member> getInviteesByEventId(String eventId) {
		// TODO Auto-generated method stub
		String inviteesURL = Constraints.BASE_SERVICE_URL + "Events('" + eventId+"')/Invitees";
		String invitessResult = this.getJAMInforByURL(inviteesURL);
		JSONArray invitees = Formatter.convertToJSONArray(invitessResult);
		List<Member> inviteeList = new ArrayList<Member>();
		for(int i = 0; i < invitees.size(); i++) {
			Member m = new Member();
			inviteeList.add(m);
		}
		return inviteeList;
	}

}
