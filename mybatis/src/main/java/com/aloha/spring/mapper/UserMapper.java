package com.aloha.spring.mapper;

import org.apache.ibatis.annotations.Mapper;

import com.aloha.spring.dto.User;

@Mapper
public interface UserMapper {
	
	public int insert(User user) throws Exception;

}
