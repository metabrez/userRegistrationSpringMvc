package com.edu.springmvc.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import com.edu.springmvc.model.User;
import com.edu.springmvc.service.UserService;

@Controller
public class RegistrationController {

	@Autowired
	UserService userService;
	
	@GetMapping(value="/register")
	public ModelAndView showRegister(HttpServletRequest request, HttpServletResponse response) {
		
		ModelAndView mav = new ModelAndView("register");
		mav.addObject("user", new User());
		return mav;
		
	}
	
	@PostMapping(value="/registerProcess")
	public ModelAndView addUser(HttpServletRequest request, HttpServletResponse response, @ModelAttribute("user") User user) {
		userService.register(user);
		return new ModelAndView("welcome","firstName",user.getFirstname());
	}
}
