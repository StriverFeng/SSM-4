package com.silence.ssm.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.silence.ssm.entity.User;
import com.silence.ssm.mapper.UserMapper;
import com.silence.ssm.service.UserService;

@Service("userService")
public class UserServiceImpl implements UserService{

	@Autowired UserMapper userMapper;
	
	@Override
	public int addUser(User user) {
		return userMapper.insert(user);
	}

	@Override
	public User findUserById(Integer id) {
		return userMapper.selectByPrimaryKey(id);
	}

}
