package com.cscsharing.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cscsharing.dao.UserDao;
import com.cscsharing.repositories.UserEntity;


@Service
@Transactional
public class UserServiceImpl implements UserService {
	
	@Autowired
	public UserDao userDao;
	
	@Override
	public void saveUser(UserEntity userEntity) {
		userDao.save(userEntity);
	}

	@Override
	public void deleteUser(Long id) {
		// TODO Auto-generated method stub
		userDao.delete(id);
	}

	@Override
	public List<UserEntity> findAllUsers() {
		// TODO Auto-generated method stub
		return (List<UserEntity>) userDao.findAll();
	}

	@Override
	public Page<UserEntity> findAllUserByPage(PageRequest page) {
		// TODO Auto-generated method stub
		return (Page<UserEntity>) userDao.findAll(page);
	}

	@Override
	public UserEntity findById(Long Id) {
		// TODO Auto-generated method stub
		return userDao.findOne(Id);
	}

	@Override
	public UserEntity findByUserId(String userId) {
		// TODO Auto-generated method stub
		return userDao.findByUserId(userId);
	}

	/**
	 * Get user Id and password from front end, compare them with database
	 * call BCryptPasswordEncoder to check if they are matching
	 * if they are matching, return the instance of existing user,
	 * else return null.
	 */
	@Override
	public UserEntity findByUserIdAndPassword(String userId, String password) {
		// TODO Auto-generated method stub
		UserEntity userEntity = userDao.findByUserId(userId);
		if(userEntity != null){
			return userEntity;
		}
		return null;
	}
}
