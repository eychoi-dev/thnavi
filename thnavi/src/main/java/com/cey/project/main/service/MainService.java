package com.cey.project.main.service;

import java.util.Map;

import org.springframework.stereotype.Service;

import com.cey.project.main.mapper.MainMapper;

@Service
public class MainService {
	
	private final MainMapper mainMapper;
	
	public MainService(MainMapper mainMapper) {
		this.mainMapper = mainMapper;
	}
	
	public Map<String, Object> loginAction(Map<String, Object> paramMap) throws Exception{
		return mainMapper.loginAction(paramMap);
	}
}
