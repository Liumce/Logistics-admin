package com.liu.admin.controller;

import com.liu.admin.controller.base.BaseController;
import com.liu.admin.entity.ReturnModel;
import com.liu.admin.service.IHelpService;
import com.liu.admin.service.IQueryService;
import com.liu.admin.util.Jurisdiction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Create by liumce on 18/10/16
 */
@Controller
@RequestMapping("/help")
public class HelpController extends BaseController {

    private String querys = "help/list";
    @Autowired
    private IHelpService helpService;

    /**
     * 角色列表
     * @return
     */
    @RequestMapping(value="/list",method=RequestMethod.GET)
    public Object list(Model model){
        model.addAttribute("helps", helpService.getAllList());
        return "page/help/list";
    }




}
