package com.liu.admin.dao;

import com.liu.admin.util.ParameterMap;

import java.util.List;

/**
 * Create by liumce on 18/10/09
 */
public interface HelpDao {

    public List<ParameterMap> list();

    public ParameterMap findMenu(String trafficId);
}
