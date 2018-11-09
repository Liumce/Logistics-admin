package com.liu.admin.controller;

import com.liu.admin.controller.base.BaseController;
import com.liu.admin.entity.ReturnModel;
import com.liu.admin.service.IMenuService;
import com.liu.admin.service.IShipmentService;
import com.liu.admin.service.ITransferService;
import com.liu.admin.util.Jurisdiction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/shipment")
public class ShipmentController extends BaseController{
	
	private String shipments = "shipment/list";

	@Autowired
	private ITransferService transferService;
	
	@Autowired
	private IShipmentService shipmentService;

	/**
	 * 订单列表
	 * @return
	 */
	@RequestMapping(value="/list",method=RequestMethod.GET)
	public Object list(Model model){
		model.addAttribute("shipments", transferService.getAllTransferList());
		return "page/shipment/list";
	}
	
	/**
	 * 查询列表
	 * @return
	 */
	@RequestMapping(value="/querylist",method=RequestMethod.GET)
	public Object querylist(Model model){
		model.addAttribute("list", shipmentService.getAllShipmentList(this.getParameterMap()));
		model.addAttribute("order_id", this.getParameterMap().getString("order_id"));
		return "page/shipment/querylist";
	}
//
//	/**
//	 * 获取权限
//	 * @return
//	 */
//	@RequestMapping(value="/qx",method=RequestMethod.POST)
//	@ResponseBody
//	public Object qx(){
//		if(!Jurisdiction.buttonJurisdiction(shipments, "add",this.getSession())){return ReturnModel.getNotAuthModel();} //校验权限
//		return transferService.getTransfer(this.getParameterMap());
//	}
//
//	/**
//	 * 更改
//	 * @return
//	 */
//	@RequestMapping(value="/edit",method=RequestMethod.POST)
//	@ResponseBody
//	public Object edit(){
//		if(!Jurisdiction.buttonJurisdiction(shipments, "edit",this.getSession())){return ReturnModel.getNotAuthModel();} //校验权限
//		return transferService.edit(this.getParameterMap());
//	}
	/**
	 * 添加物流中转
	 * @return
	 */
	@RequestMapping(value="/add",method=RequestMethod.POST)
	@ResponseBody
	public Object add(){
		if(!Jurisdiction.buttonJurisdiction(shipments, "add",this.getSession())){return ReturnModel.getNotAuthModel();} //校验权限
		return shipmentService.add(this.getParameterMap(),this.getSession());
	}
//	/**
//	 * 删除角色
//	 * @return
//	 */
//	@RequestMapping(value="/del/{orderId}",method=RequestMethod.GET)
//	@ResponseBody
//	public Object del(@PathVariable("orderId") String orderId){
//		if(!Jurisdiction.buttonJurisdiction(shipments, "del",this.getSession())){return ReturnModel.getNotAuthModel();} //校验权限
//		return transferService.del(orderId);
//	}
//
//	@RequestMapping(value="/shipment/{order_id}",method=RequestMethod.GET)
//	@ResponseBody
//	public Object find(@PathVariable("order_id") String orderId){
//		if(!Jurisdiction.buttonJurisdiction(shipments, "",this.getSession())){return ReturnModel.getNotAuthModel();} //校验权限
//		return transferService.findMenu(orderId);
//	}
}
