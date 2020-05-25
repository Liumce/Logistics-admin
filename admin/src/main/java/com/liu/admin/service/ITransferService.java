package com.liu.admin.service;

import com.liu.admin.util.ParameterMap;

import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.Map;

/**
 * Create by liumce on 18/10/09
 */
public interface ITransferService {
    public List<ParameterMap> getAllTransferList();
    public Map<String,Object> getTransfer(ParameterMap pm);
    public Map<String,Object> edit(ParameterMap pm);
    public Map<String,Object> add(ParameterMap pm, HttpSession session);
    public Map<String,Object> del(String orderId);
    /**
     * 查询菜单
     * @param pm
     * @return
     */
    public Map<String,Object> findMenu(String menuId);
}
