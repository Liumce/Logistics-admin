package com.liu.admin.service;

import com.liu.admin.entity.Menu;
import com.liu.admin.entity.Shipment;
import com.liu.admin.entity.Transfer;
import com.liu.admin.util.ParameterMap;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.Map;


public interface IShipmentService {
//
	public List<ParameterMap> getAllShipmentList(ParameterMap pm);
//	public Map<String,Object> getShipment(ParameterMap pm);
//	public Map<String,Object> edit(ParameterMap pm);
	public Map<String,Object> add(ParameterMap pm, HttpSession session);
//	public Map<String,Object> del(String orderId);
//	/**
//	 * 查询菜单
//	 * @param pm
//	 * @return
//	 */
//	public Map<String,Object> findMenu(String menuId);
}
