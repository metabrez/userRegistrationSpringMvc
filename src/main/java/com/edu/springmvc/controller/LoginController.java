package com.edu.springmvc.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import com.edu.springmvc.model.Login;
import com.edu.springmvc.model.User;
import com.edu.springmvc.service.UserService;

@Controller
public class LoginController {

	@Autowired
	public UserService userService;
	
	@GetMapping(value="/login")
	public ModelAndView showLogin(HttpServletRequest request, HttpServletResponse response) {
		
		ModelAndView mav = new ModelAndView("login");
		mav.addObject("login", new Login());
		
		return mav;
	}
	
	@PostMapping(value="/loginProcess")
	public ModelAndView loginProcess(HttpServletRequest request, HttpServletResponse response, @ModelAttribute("login") Login login) {
		ModelAndView mav = null;
		
		User user = userService.validateUser(login);
		if(null != user) {
			mav = new ModelAndView("welcome");
			mav.addObject("firstName", user.getFirstname());
		}else {
				mav = new ModelAndView("login");
				mav.addObject("message", "username or password is wrong");
			}
		return mav;
		
	}
}
