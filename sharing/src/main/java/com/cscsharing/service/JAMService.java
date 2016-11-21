package com.cscsharing.service;

import java.util.List;

import com.cscsharing.jampojo.Member;

public interface JAMService {
	public Member getCreatorByEventId(String eventId);
	public List<Member> getMembersByGroupId(String groupId);
	public String getGroupInforByEventId(String eventId);
	public String getAllGroups();
}
