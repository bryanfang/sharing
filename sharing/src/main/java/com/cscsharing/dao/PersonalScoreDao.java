package com.cscsharing.dao;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cscsharing.repositories.PersonalScore;
import com.cscsharing.repositories.UserEventPrimaryKey;

@Repository
@Transactional
public interface PersonalScoreDao extends JpaRepository<PersonalScore, UserEventPrimaryKey> {
	PersonalScore findById(UserEventPrimaryKey id);
	int countById(UserEventPrimaryKey id);
	double sumScoreById(UserEventPrimaryKey id);
}
