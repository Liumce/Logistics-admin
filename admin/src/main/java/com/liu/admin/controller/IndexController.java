package com.liu.admin.controller;

import java.util.List;

import com.liu.admin.service.IScientificService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.liu.admin.controller.base.BaseController;
import com.liu.admin.entity.Const;
import com.liu.admin.entity.Menu;
import com.liu.admin.entity.User;
import com.liu.admin.service.IUserService;

@Controller
public class IndexController extends BaseController{
	
	@Value("${admin.name}")
	private String adminName;
	
	@Autowired
	private IUserService userService;

	@Autowired
	private IScientificService scientificService;

	/**
	 * 入口
	 * @return
	 */
	@RequestMapping(value={"/","/toLogin"},method=RequestMethod.GET)
	public String toLogin(){
		return "login";
	}
	
	/**
	 * 首页
	 * @param model
	 * @return
	 */
	@SuppressWarnings("unchecked")
	@RequestMapping("/index")
	public String index(Model model){
		try {
			List<Menu> allMenu = (List<Menu>) this.getSession().getAttribute(Const.SESSION_ALL_MENU);
			if(allMenu != null){
				model.addAttribute("menus", allMenu);
			}
			model.addAttribute("adminName", adminName);
			model.addAttribute("userName", ((User)this.getSession().getAttribute(Const.SESSION_USER)).getNickName());
			model.addAttribute("userPath", ((User)this.getSession().getAttribute(Const.SESSION_USER)).getPicPath());
			model.addAttribute("userStatus", "在线");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "index";
	}
	@GetMapping("/index_scientifics_list")
	public void list(Model model){
		model.addAttribute("index_scientifics", scientificService.list());
	}
	
	/**
	 * 用户登录
	 * @return
	 */
	@RequestMapping(value={"/login"},method=RequestMethod.POST)
	@ResponseBody
	public Object login(){
		return userService.login(this.getParameterMap(), this.getSession());
	}
	
	/**
	 * 用户注销
	 * @return
	 */
	@RequestMapping("/logout")
	public String logout(){
		return userService.logout(this.getSession());
	}

}
