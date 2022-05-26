package com.edu.springmvc.service;

import org.springframework.beans.factory.annotation.Autowired;

import com.edu.springmvc.dao.UserDao;
import com.edu.springmvc.model.Login;
import com.edu.springmvc.model.User;

public class UserServiceImpl implements UserService {

	@Autowired
	public UserDao userDao;
	
	public int register(User user) {
		return userDao.register(user);
	}

	public User validateUser(Login login) {
		return userDao.validateUser(login);
	}

}
