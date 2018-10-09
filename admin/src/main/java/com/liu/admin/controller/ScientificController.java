package com.liu.admin.controller;

import com.liu.admin.controller.base.BaseController;
import com.liu.admin.service.IScientificService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/scientific")
public class ScientificController extends BaseController{

	@Autowired
	private IScientificService scientificService;

	private String menuUrl = "scientific/list";

	/**
	 * 用户列表
	 * @return
	 */
	@GetMapping("/list")
	public Object list(Model model){
		model.addAttribute("scientifics", scientificService.list());
		return "page/scientific/list";
	}

	/*@PostMapping("/add")
	public Object add(Model model){
		return "page/scientific_add/list";
	}*/
	 /* 获取用户角色
	 * @return
	 */
	/*@RequestMapping(value="/getRole",method=RequestMethod.GET)
	@ResponseBody
	public Object userRole(){
		if(!Jurisdiction.buttonJurisdiction(menuUrl,"edit", this.getSession())){return ReturnModel.getNotAuthModel();}
		return scientificService.getRole(this.getParameterMap());
	}
	*/
	/**
	 * 添加用户
	 * @return
	 */
	/*@RequestMapping(value="/add",method=RequestMethod.POST)
	@ResponseBody
	public Object add(){
		if(!Jurisdiction.buttonJurisdiction(menuUrl,"add", this.getSession())){return ReturnModel.getNotAuthModel();}
		return scientificService.add(this.getParameterMap());
	}*/
	
	
	/**
	 * 编辑用户
	 * @return
	 */
	/*@RequestMapping(value="/edit",method=RequestMethod.POST)
	@ResponseBody
	public Object edit(){
		if(!Jurisdiction.buttonJurisdiction(menuUrl,"edit", this.getSession())){return ReturnModel.getNotAuthModel();}
		return scientificService.edit(this.getParameterMap());
	}
	*/
	/**
	 * 编辑用户
	 * @return
	 */
/*	@RequestMapping(value="/editRole",method=RequestMethod.POST)
	@ResponseBody
	public Object editRole(){
		if(!Jurisdiction.buttonJurisdiction(menuUrl,"edit", this.getSession())){return ReturnModel.getNotAuthModel();}
		return scientificService.editRole(this.getParameterMap());
	}*/
	
	/**
	 * 删除用户
	 * @return
	 */
	/*@RequestMapping(value="/del",method=RequestMethod.POST)
	@ResponseBody
	public Object del(){
		if(!Jurisdiction.buttonJurisdiction(menuUrl,"del", this.getSession())){return ReturnModel.getNotAuthModel();}
		return scientificService.del(this.getParameterMap());
	}*/
	
	
}
