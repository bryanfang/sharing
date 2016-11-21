package com.cscsharing.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cscsharing.dao.ScoreHistoryDao;
import com.cscsharing.repositories.ScoreHistory;

@Service
@Transactional
public class ScoreHistoryServiceImpl implements ScoreHistoryService {
	
	@Autowired
	private ScoreHistoryDao scoreHistoryDao;
	
	//save one score record to database
	public void save(ScoreHistory scoreHistory){
		scoreHistoryDao.save(scoreHistory);
	}

	@Override
	public float getScoreByUserId(String userId) {
		// TODO Auto-generated method stub
		return 0;
	}
}
