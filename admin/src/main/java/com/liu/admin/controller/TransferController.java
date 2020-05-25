package com.liu.admin.controller;

import com.liu.admin.controller.base.BaseController;
import com.liu.admin.entity.ReturnModel;
import com.liu.admin.service.IQueryService;
import com.liu.admin.service.ITransferService;
import com.liu.admin.util.Jurisdiction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Create by liumce on 18/10/29
 * 接单
 */
@Controller
@RequestMapping("/transfer")
public class TransferController extends BaseController {

    private String transfers = "transfer/copy";

    @Autowired
    private ITransferService transferService;

    /**
     * 订单列表
     * @return
     */
    @RequestMapping(value="/list",method=RequestMethod.GET)
    public Object list(Model model){
        model.addAttribute("transfers", transferService.getAllTransferList());
        return "page/transfer/copy";
    }

    /**
     * 获取权限
     * @return
     */
    @RequestMapping(value="/qx",method=RequestMethod.POST)
    @ResponseBody
    public Object qx(){
        if(!Jurisdiction.buttonJurisdiction(transfers, "add",this.getSession())){return ReturnModel.getNotAuthModel();} //校验权限
        return transferService.getTransfer(this.getParameterMap());
    }

    /**
     * 更改
     * @return
     */
    @RequestMapping(value="/edit",method=RequestMethod.POST)
    @ResponseBody
    public Object edit(){
        if(!Jurisdiction.buttonJurisdiction(transfers, "edit",this.getSession())){return ReturnModel.getNotAuthModel();} //校验权限
        return transferService.edit(this.getParameterMap());
    }
    /**
     * 添加角色
     * @return
     */
    @RequestMapping(value="/add",method=RequestMethod.POST)
    @ResponseBody
    public Object add(){
        if(!Jurisdiction.buttonJurisdiction(transfers, "add",this.getSession())){return ReturnModel.getNotAuthModel();} //校验权限
        return transferService.add(this.getParameterMap(),this.getSession());
    }
    /**
     * 删除角色
     * @return
     */
    @RequestMapping(value="/del/{orderId}",method=RequestMethod.GET)
    @ResponseBody
    public Object del(@PathVariable("orderId") String orderId){
        if(!Jurisdiction.buttonJurisdiction(transfers, "del",this.getSession())){return ReturnModel.getNotAuthModel();} //校验权限
        return transferService.del(orderId);
    }

    @RequestMapping(value="/transfer/{order_id}",method=RequestMethod.GET)
    @ResponseBody
    public Object find(@PathVariable("order_id") String orderId){
        if(!Jurisdiction.buttonJurisdiction(transfers, "",this.getSession())){return ReturnModel.getNotAuthModel();} //校验权限
        return transferService.findMenu(orderId);
    }

}
