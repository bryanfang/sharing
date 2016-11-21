package com.cscsharing.service;

import com.cscsharing.repositories.ScoreHistory;

public interface ScoreHistoryService {
	void save(ScoreHistory scoreHistory);
	
	//Get specific user score by given user id
	float getScoreByUserId(String userId);
}
