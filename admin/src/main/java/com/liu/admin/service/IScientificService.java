package com.liu.admin.service;

import com.liu.admin.util.ParameterMap;

import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.Map;

public interface IScientificService{
    public List<ParameterMap> list();
    public Map<String,Object> edit(ParameterMap pm);
    public Map<String,Object> add(ParameterMap pm, HttpSession session);
    public Map<String,Object> del(String roleId);
}
