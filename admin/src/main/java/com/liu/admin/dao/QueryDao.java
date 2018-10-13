package com.liu.admin.dao;

import com.liu.admin.util.ParameterMap;

import java.util.List;

/**
 * Create by liumce on 18/10/09
 */
public interface QueryDao {

    public List<ParameterMap> list();
    public List<ParameterMap> getQueryByuId(ParameterMap pm);
    public ParameterMap getRoleById(ParameterMap pm);
    public void updateRoleQX(ParameterMap pm);
    public void addQuery(ParameterMap pm);
    public void delQuery(String trafficId);
    public void delUserRole(String trafficId);
}
