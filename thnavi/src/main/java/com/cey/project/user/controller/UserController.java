package com.cey.project.user.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.cey.project.user.service.UserService;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@Controller
@RequestMapping("/user")
public class UserController {
	
	@Autowired
	private UserService userService;
	
//	@RequestMapping("/loginAction")
//	public ModelAndView loginAction(String userId, String userPw, HttpServletRequest request, HttpServletResponse response) throws Exception {
//		ModelAndView mv = new ModelAndView();
//		
//		System.out.println("userId : " + userId);
//		System.out.println("userPw : " + userPw);
//		
//		mv.setViewName("/main/adminMain");
//		return mv;
//	}
}
