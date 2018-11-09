package com.liu.admin.service.impl;

import com.alibaba.druid.util.StringUtils;
import com.liu.admin.dao.MenuDao;
import com.liu.admin.dao.OrderDao;
import com.liu.admin.dao.ShipmentDao;
import com.liu.admin.dao.TransferDao;
import com.liu.admin.entity.*;
import com.liu.admin.service.IMenuService;
import com.liu.admin.service.IShipmentService;
import com.liu.admin.util.DateUtil;
import com.liu.admin.util.ParameterMap;
import com.liu.admin.util.RightsHelper;
import com.liu.admin.util.Tools;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.interceptor.TransactionAspectSupport;

import javax.servlet.http.HttpSession;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Service
public class ShipmentService implements IShipmentService{
//
//	@Autowired
//	private MenuService menuService;
//
	@Autowired
	private ShipmentDao shipmentDao;

	@Autowired
	private OrderDao orderDao;
//
//
	private Logger log = Logger.getLogger(this.getClass());
//
	@Override
	public List<ParameterMap> getAllShipmentList(ParameterMap pm) {
		if(StringUtils.isEmpty(pm.getString("order_id"))) {
			return new ArrayList<>();
		}
		return shipmentDao.getAllShipmentList(pm);
	}
//
//
//	@Override
//	public Map<String, Object> getShipment(ParameterMap pm) {
//		String qx;
//		List<Menu> menus;
//		String QXtype = pm.getString("qx");
//		ParameterMap role = transferDao.getTransferById(pm);
//		try {
//			if("rights".equalsIgnoreCase(QXtype)){
//				qx = role.getString("rights");
//			}else if("add_qx".equalsIgnoreCase(QXtype)){
//				qx = role.getString("add_qx");
//			}else if("del_qx".equalsIgnoreCase(QXtype)){
//				qx = role.getString("del_qx");
//			}else if("edit_qx".equalsIgnoreCase(QXtype)){
//				qx = role.getString("edit_qx");
//			}else if("query_qx".equalsIgnoreCase(QXtype)){
//				qx = role.getString("query_qx");
//			}else{
//				return ReturnModel.getModel("你请求的是一个冒牌接口", "failed", null);
//			}			menus = menuService.getAllMenuList();
//
//			for(Menu m:menus){
//				List<Menu> subm = m.getSubMenu();
//				if(subm != null && subm.size() > 0){
//					int subNumber = subm.size();
//					int index = 0;
//					for(Menu sm:subm){
//						boolean ishas = RightsHelper.testRights(qx, sm.getMENU_ID());
//						System.out.println("qx="+qx+",menu_id="+sm.getMENU_ID()+",result="+ishas);
//						sm.setHasMenu(ishas);
//						if(ishas){
//							index++;
//						}
//					}
//					//判断子菜单是否全部选中
//					if(subNumber == index){
//						m.setHasMenu(true);
//					}
//				}
//			}
//
//		} catch (Exception e) {
//			log.error("error", e);
//			return ReturnModel.getModel("error", "failed", null);
//		}
//		return ReturnModel.getModel("ok", "success", menus);
//	}
//	@Override
//	public Map<String, Object> edit(ParameterMap pm) {
//		try {
//			String idstr = pm.getString("ids");
//			if(Tools.notEmpty(idstr)){
//				String[] ids = idstr.split(",");
//				BigInteger newRights = RightsHelper.sumRights(ids);
//				String qxKey = pm.getString("qx");
//				pm.put(qxKey,newRights);
//			}
//			System.out.println("senter="+pm.getString("senter"));
//			pm.put("senter", pm.getString("senter").trim());
//			transferDao.updateTransferQX(pm);
//		} catch (Exception e) {
//			log.error("error", e);
//			return ReturnModel.getModel("error", "failed", null);
//		}
//		return ReturnModel.getModel("ok", "success", null);
//	}
//
	@Override
	public Map<String, Object> add(ParameterMap pm,HttpSession session) {
		try {
			if(StringUtils.isEmpty(pm.getString("receive_date"))) {
				pm.put("receive_date", DateUtil.getTime());
			}
			pm.put("create_time", DateUtil.getTime());
			shipmentDao.addShipment(pm);
			if("3".equals(pm.getString("status"))){
				orderDao.editOrder(pm);
			}
		} catch (Exception e) {
			e.printStackTrace();
			log.error("add addShipment error", e);
			return ReturnModel.getModel("error", "falied", null);
		}
		return ReturnModel.getModel("ok", "success", null);
	}
//
//	@Override
//	public Map<String, Object> del(String orderId) {
//		try {
//			if(Tools.isEmpty(orderId) || !Tools.isNumber(orderId)){
//				return ReturnModel.getModel("你请求的是一个冒牌接口", "failed", null);
//			}
//			transferDao.delTransfer(orderId);
//			transferDao.delUserTransfer(orderId);
//		} catch (Exception e) {
//			TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
//			e.printStackTrace();
//			log.error("del order error", e);
//			return ReturnModel.getModel("error", "falied", null);
//		}
//		return ReturnModel.getModel("ok", "success", null);
//	}
//
//	@Override
//	public Map<String, Object> findMenu(String orderId) {
//		ParameterMap menu = null;
//		try {
//			if(Tools.isEmpty(orderId) || !Tools.isNumber(orderId)){
//				return ReturnModel.getModel("你请求的是一个冒牌接口", "failed", null);
//			}
//			menu = transferDao.findMenu(orderId);
//		} catch (Exception e) {
//			e.printStackTrace();
//			log.error("add menu error", e);
//			return ReturnModel.getModel("error", "falied", null);
//		}
//		return ReturnModel.getModel("ok", "success", menu);
//	}
}
