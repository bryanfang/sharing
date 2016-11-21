package com.cscsharing.dao;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cscsharing.repositories.UserEntity;

@Repository
@Transactional
public interface UserDao extends JpaRepository<UserEntity, Long>{
	UserEntity findByUserId(String userId);
	UserEntity findByUserIdAndPassword(String userId, String password);
}
