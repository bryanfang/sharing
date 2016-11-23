package com.cscsharing.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cscsharing.dao.PersonalScoreDao;
import com.cscsharing.repositories.PersonalScore;
import com.cscsharing.repositories.UserEventPrimaryKey;

@Service
@Transactional
public class PersonalScoreServiceImpl implements PersonalScoreService {
	
	@Autowired
	private PersonalScoreDao personalScoreDao;
	
	@Override
	public boolean checkExist(String userId, String eventId) {
		// TODO Auto-generated method stub
		PersonalScore ps = personalScoreDao.findOne(new UserEventPrimaryKey(userId, eventId));
		if(ps != null) {
			return true;
		}
		return false;
	}

	@Override
	public void save(PersonalScore ps) {
		// TODO Auto-generated method stub
		personalScoreDao.save(ps);
	}

}
