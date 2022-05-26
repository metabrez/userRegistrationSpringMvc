package com.edu.springmvc.service;

import com.edu.springmvc.model.Login;
import com.edu.springmvc.model.User;

public interface UserService {

	int register(User user);
	
	User validateUser(Login login);
}
