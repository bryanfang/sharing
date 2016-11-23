package com.cscsharing.service;

import com.cscsharing.repositories.ScoreHistory;

public interface ScoreHistoryService {
	void save(ScoreHistory scoreHistory);
	
	//Get specific user score by given user id
	float getScoreByUserId(String userId);
	//check if the member had commented the speaker before
	boolean checkIfMemberCommented(String loginUserId, String eventId);
	
	//check if the speaker had commented the speaker before
	boolean checkIfSpeakerCommented(String loginUserId, String eventId, String memebrId);
}
