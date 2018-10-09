package com.liu.admin.service;


import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Component;

import com.liu.admin.util.ParameterMap;

@Component
public interface IRoleService {
	public List<ParameterMap> list();
	public Map<String,Object> getMenu(ParameterMap pm);
	public Map<String,Object> edit(ParameterMap pm); 
	public Map<String,Object> add(ParameterMap pm, HttpSession session);
	public Map<String,Object> del(String roleId); 
}
