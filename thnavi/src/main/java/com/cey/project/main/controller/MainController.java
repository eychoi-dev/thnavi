package com.cey.project.main.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.cey.project.main.service.MainService;
import com.cey.project.user.controller.UserController;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@Controller
public class MainController {
	
	@Autowired
	MainService mainService;
	
	@Value("${kakao.map.api.key}")
	private String mapUrl;
	
	//사용자 메인
	@RequestMapping("/")
	public ModelAndView userMain(HttpServletRequest request) {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("/main/userMain");
		mv.addObject("mapUrl", mapUrl);
		return mv;
	}
	
	//관리자 메인
	@RequestMapping("/admin")
	public ModelAndView adminMain(HttpServletRequest request) {
		ModelAndView mv = new ModelAndView();
		HttpSession session = request.getSession();
		
		if(session == null || session.getAttribute("loginInfo") == null) { //세션이 없거나 로그인 정보가 없을 경우
			mv.setViewName("/main/adminLogin"); //관리자 로그인 먼저
		}else {
			mv.setViewName("/main/adminMain"); //로그인 정보가 있다면 관리자 메인으로 이동
		}
		return mv;
	}
	
	//관리자 로그인
	@RequestMapping("/loginAction")
	public ModelAndView loginAction(String userId, String userPw, HttpServletRequest request, HttpServletResponse response) throws Exception {
		ModelAndView mv = new ModelAndView();
		
		Map<String, Object> paramMap = new HashMap<>();
		paramMap.put("userId", userId);
		paramMap.put("userPw", userPw);
				
		Map<String, Object> loginInfo = mainService.loginAction(paramMap);
		//세션에 로그인 정보 set
		request.getSession().setAttribute("loginInfo", loginInfo);
		
		if(loginInfo != null && !loginInfo.isEmpty()) {
			mv.setViewName("redirect:/admin/main");
		}else {
			mv.setViewName("redirect:/login");
		}
		return mv;
	}
	
	//redirect 용
	@RequestMapping("/login")
	public String goLogin(HttpServletRequest request) {
		return "/main/adminLogin";
	}
	@RequestMapping("/admin/main")
	public String goMain(HttpServletRequest request) {		
		return "/main/adminMain";
	}
}
