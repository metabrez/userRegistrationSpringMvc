package com.edu.springmvc.dao;

import com.edu.springmvc.model.Login;
import com.edu.springmvc.model.User;

public interface UserDao {
	
	int register(User user);
	
	User validateUser(Login login);

}
