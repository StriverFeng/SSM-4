package com.silence.ssm.service;

import com.silence.ssm.entity.User;

public interface UserService {

	public void addUser(User user);
	
	public User findUserById(Integer id);
	
}
