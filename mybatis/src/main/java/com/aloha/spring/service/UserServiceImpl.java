package com.aloha.spring.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aloha.spring.dto.User;
import com.aloha.spring.mapper.UserMapper;

@Service
public class UserServiceImpl implements UserService {
	
	@Autowired
	private UserMapper userMapper;

	@Override
	public boolean insert(User user) throws Exception {
		return userMapper.insert(user) > 0;
	}

}





