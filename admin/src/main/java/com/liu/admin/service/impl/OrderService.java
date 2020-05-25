package com.liu.admin.service.impl;

import com.liu.admin.dao.OrderDao;
import com.liu.admin.dao.RoleDao;
import com.liu.admin.entity.Const;
import com.liu.admin.entity.Menu;
import com.liu.admin.entity.ReturnModel;
import com.liu.admin.entity.User;
import com.liu.admin.service.IOrderService;
import com.liu.admin.service.IRoleService;
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
import java.util.List;
import java.util.Map;


@Service
public class OrderService implements IOrderService{

	@Autowired
	private OrderDao orderDao;

	
	private Logger log = Logger.getLogger(this.getClass());
	
	@Override
	public List<ParameterMap> list() {
		return orderDao.list();
	}


	@Override
	public Map<String, Object> add(ParameterMap pm,HttpSession session) {
		try {
			System.out.println("pm====="+pm);
			//随机生成订单编号
			pm.put("order_number", DateUtil.getDays()+Tools.random(5));
			orderDao.addOrder(pm);
		} catch (Exception e) {
			e.printStackTrace();
			log.error("add order error", e);
			return ReturnModel.getModel("error", "falied", null);
		}
		return ReturnModel.getModel("ok", "success", null);
	}
}
