package com.cscsharing.service;

import com.cscsharing.repositories.PersonalScore;

public interface PersonalScoreService {
	boolean checkExist(String userId, String eventId);
	void save(PersonalScore ps);
}
