package com.liu.admin.service;


import com.liu.admin.util.ParameterMap;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.Map;

@Component
public interface IOrderService {
	public List<ParameterMap> list();
	public Map<String,Object> add(ParameterMap pm, HttpSession session);
}
