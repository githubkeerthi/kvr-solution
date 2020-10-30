package com.kvr.solution.user.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kvr.solution.common.dao.SequenceDAO;
import com.kvr.solution.common.entity.User;
import com.kvr.solution.user.dao.UserRepository;

@Service
public class UserServiceImpl implements UserService{

	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private SequenceDAO sequenceDao;
	
	public UserRepository getUserRepository() {
		return userRepository;
	}

	public User save(User user) {
		user.setId(sequenceDao.getNextSequenceId(User.SEQ_KEY));
		return userRepository.save(user);
	}
}
