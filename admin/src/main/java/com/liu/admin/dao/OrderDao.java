package com.liu.admin.dao;

import com.liu.admin.util.ParameterMap;

import java.util.List;

public interface OrderDao {
	public List<ParameterMap> list();
	public List<ParameterMap> getOrderByuId(ParameterMap pm);
	public void addOrder(ParameterMap pm);
	public void editOrder(ParameterMap pm);

}
