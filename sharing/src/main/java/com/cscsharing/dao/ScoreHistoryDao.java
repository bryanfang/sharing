package com.cscsharing.dao;

import javax.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import com.cscsharing.repositories.ScoreHistory;

@Repository
@Transactional
public interface ScoreHistoryDao extends JpaRepository<ScoreHistory, Long> {
	
	//Get the average score of the speaker, SUM/RECORDS_NUM
	@Query(value = "SELECT AVG(sh.workImportance+sh.PPT+sh.expression+sh.timeSpeaker+sh.QASpeaker) FROM ScoreHistory sh WHERE sh.spleakerId = ?1", nativeQuery = true)
	float getSpeakerScoreBySpeakerId(String speakerId);
	
	//Get the total score of one member
	@Query(value = "SELECT SUM(sh.timeMember+sh.QAMemeber+sh.comments+sh.bestAnswer+sh.newQuestion) FROM ScoreHistory sh WHERE sh.memberId = ?1", nativeQuery = true)
	float getMemberScoreByMemberId(String memberId);
	
	ScoreHistory findByLoginUserIdAndEventId(String loginUserId, String eventId);
	
	ScoreHistory findByLoginUserIdAndEventIdAndMemberId(String loginUserId, String eventId, String memberId);
}