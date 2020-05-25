package com.liu.admin.controller;

import com.liu.admin.controller.base.BaseController;
import com.liu.admin.entity.ReturnModel;
import com.liu.admin.service.IOrderService;
import com.liu.admin.service.IRoleService;
import com.liu.admin.util.Jurisdiction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/order")
public class OrderController extends BaseController{
	
	private String orders="order/list";
	
	@Autowired
	private IOrderService orderService;
	
	/**
	 * 角色列表
	 * @return
	 */
	@RequestMapping(value="/list",method=RequestMethod.GET)
	public Object list(Model model){
		model.addAttribute("orders", orderService.list());
		return "page/order/list";
	}

	/**
	 * 添加订单
	 * @return
	 */
	@RequestMapping(value="/add",method=RequestMethod.POST)
	@ResponseBody
	public Object add(){
		if(!Jurisdiction.buttonJurisdiction(orders, "add",this.getSession())){return ReturnModel.getNotAuthModel();} //校验权限
		return orderService.add(this.getParameterMap(),this.getSession());
	}

}
