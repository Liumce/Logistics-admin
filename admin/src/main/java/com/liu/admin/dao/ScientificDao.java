package com.liu.admin.dao;

import com.liu.admin.util.ParameterMap;

import java.util.List;

public interface ScientificDao {
    public List<ParameterMap> list();
    public List<ParameterMap> getScientificByuId(ParameterMap pm);
    public ParameterMap getScientificById(ParameterMap pm);
    public void updateScientificContent(ParameterMap pm);
    public void addScientific(ParameterMap pm);
    public void delScientific(String roleId);
    public void delUserScientific(String roleId);
}
