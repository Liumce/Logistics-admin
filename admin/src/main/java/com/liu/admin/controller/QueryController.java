package com.liu.admin.controller;

import com.liu.admin.controller.base.BaseController;
import com.liu.admin.entity.Const;
import com.liu.admin.entity.ReturnModel;
import com.liu.admin.entity.User;
import com.liu.admin.service.IQueryService;
import com.liu.admin.service.IRoleService;
import com.liu.admin.util.Jurisdiction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Create by liumce on 18/10/03
 */
@Controller
@RequestMapping("/query")
public class QueryController extends BaseController {

    private String querys = "query/list";

    @Autowired
    private IQueryService queryService;

    /**
     * 角色列表
     * @return
     */
    @RequestMapping(value="/list",method=RequestMethod.GET)
    public Object list(Model model){
        model.addAttribute("querys", queryService.getAllQueryList());
        return "page/query/list";
    }

    /**
     * 获取权限
     * @return
     */
    @RequestMapping(value="/qx",method=RequestMethod.POST)
    @ResponseBody
    public Object qx(){
        if(!Jurisdiction.buttonJurisdiction(querys, "add",this.getSession())){return ReturnModel.getNotAuthModel();} //校验权限
        return queryService.getQuery(this.getParameterMap());
    }

    /**
     * 更改角色
     * @return
     */
    @RequestMapping(value="/edit",method=RequestMethod.POST)
    @ResponseBody
    public Object edit(){
        if(!Jurisdiction.buttonJurisdiction(querys, "edit",this.getSession())){return ReturnModel.getNotAuthModel();} //校验权限
        return queryService.edit(this.getParameterMap());
    }
    /**
     * 添加角色
     * @return
     */
    @RequestMapping(value="/add",method=RequestMethod.POST)
    @ResponseBody
    public Object add(){
        if(!Jurisdiction.buttonJurisdiction(querys, "add",this.getSession())){return ReturnModel.getNotAuthModel();} //校验权限
        return queryService.add(this.getParameterMap(),this.getSession());
    }
    /**
     * 删除角色
     * @return
     */
    @RequestMapping(value="/del/{trafficId}",method=RequestMethod.GET)
    @ResponseBody
    public Object del(@PathVariable("trafficId") String trafficId){
        if(!Jurisdiction.buttonJurisdiction(querys, "del",this.getSession())){return ReturnModel.getNotAuthModel();} //校验权限
        return queryService.del(trafficId);
    }

    @RequestMapping(value="/query/{traffic_id}",method=RequestMethod.GET)
    @ResponseBody
    public Object find(@PathVariable("traffic_id") String trafficId){
        if(!Jurisdiction.buttonJurisdiction(querys, "query",this.getSession())){return ReturnModel.getNotAuthModel();} //校验权限
        return queryService.findMenu(trafficId);
    }

}
