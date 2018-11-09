package com.liu.admin.dao;

import com.liu.admin.entity.Menu;
import com.liu.admin.entity.Shipment;
import com.liu.admin.util.ParameterMap;

import java.util.List;

public interface ShipmentDao {

	public List<ParameterMap> getAllShipmentList(ParameterMap pm);
//	public List<ParameterMap> getShipmentByuId(ParameterMap pm);
//	public ParameterMap getShipmentById(ParameterMap pm);
//	public void updateShipmentQX(ParameterMap pm);
	public void addShipment(ParameterMap pm);
//	public void delShipment(String orderId);
//	public void delUserShipment(String orderId);
//	public ParameterMap findMenu(String orderId);
}
