package com.liu.admin.service;

import com.liu.admin.util.ParameterMap;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.Map;

/**
 * Create by liumce on 18/10/09
 */
public interface IQueryService {
    public List<ParameterMap> getAllQueryList();
    public Map<String,Object> getQuery(ParameterMap pm);
    public Map<String,Object> edit(ParameterMap pm);
    public Map<String,Object> add(ParameterMap pm, HttpSession session);
    public Map<String,Object> del(String trafficId);
    /**
     * 查询菜单
     * @param pm
     * @return
     */
    public Map<String,Object> findMenu(String menuId);
}
