package com.yun.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yun.mapper.UserMapper;
import com.yun.model.User;

@Service
public class UserService {
    @Autowired
    private UserMapper userMapper;
    
	public User getById(Integer id) {
        return userMapper.getById(id);
    }
}