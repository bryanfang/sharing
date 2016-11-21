package com.cscsharing.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

import com.cscsharing.repositories.UserEntity;

public interface UserService{
	void saveUser(UserEntity userEntity);
	void deleteUser(Long id);
	List<UserEntity> findAllUsers();
	Page<UserEntity> findAllUserByPage(PageRequest page);
	UserEntity findById(Long Id);
	UserEntity findByUserId(String userId);
	UserEntity findByUserIdAndPassword(String userId, String password);
}