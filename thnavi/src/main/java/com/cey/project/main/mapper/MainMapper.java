package com.cey.project.main.mapper;

import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface MainMapper {
	public Map<String, Object> loginAction(Map<String, Object> paramMap);
}
