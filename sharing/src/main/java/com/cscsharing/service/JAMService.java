package com.cscsharing.service;

import java.util.List;

import com.cscsharing.jampojo.Events;
import com.cscsharing.jampojo.Group;
import com.cscsharing.jampojo.Member;

public interface JAMService {
	public Member getCreatorByEventId(String eventId);
	public List<Member> getMembersByGroupId(String groupId);
	public Group getGroupInforByEventId(String eventId);
	public String getAllGroups();
	public Events getEventByEventId(String eventId);
	public int getDurationTypeByEventId(String eventId);
	public List<Member> getInviteesByEventId(String eventId);
}
