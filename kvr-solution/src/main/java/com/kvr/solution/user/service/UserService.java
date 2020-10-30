package com.kvr.solution.user.service;

import com.kvr.solution.common.entity.User;
import com.kvr.solution.user.dao.UserRepository;

public interface UserService extends CommonService{
	
	public UserRepository getUserRepository();
	
	public User save(User user);
}
