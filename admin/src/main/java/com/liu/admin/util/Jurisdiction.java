package com.liu.admin.util;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import com.liu.admin.entity.*;


/**
 * 权限校验
 * @author liumce
 *
 */
public class Jurisdiction {

	/**
	 * 给当前的请求 校验增删改查权限
	 * @param menuUrl  菜单路径
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public static boolean hasJurisdiction(String menuUrl,HttpSession session){
		//获取菜单列表
		List<Menu> menuList = (List<Menu>)session.getAttribute(Const.SESSION_ALL_MENU);
		for(int i=0;i<menuList.size();i++){
			for(int j=0;j<menuList.get(i).getSubMenu().size();j++){
				if(menuUrl.equals(menuList.get(i).getSubMenu().get(j).getMENU_URL())){
					//判断有无此菜单权限
					if(!menuList.get(i).getSubMenu().get(j).isHasMenu()){				
						return false;
					}else{																
						//获取上一个按钮权限，并移除
						UserRole userRole = ((User)session.getAttribute(Const.SESSION_USER)).getUserRole();
						System.out.println("userRole="+userRole);
						Map<String, String> map = new HashMap<>();
						long MENU_ID =  menuList.get(i).getSubMenu().get(j).getMENU_ID();
						//获取当前登录者的用户，判断是否是admin
						String USERNAME = ((User)session.getAttribute(Const.SESSION_USER)).getUsername();	
						Boolean isAdmin = "admin".equals(USERNAME);
						map.put("add", (RightsHelper.testRights(userRole.getAdds_qx(), MENU_ID)) || isAdmin?"1":"0");
						map.put("del", RightsHelper.testRights(userRole.getDels_qx(), MENU_ID) || isAdmin?"1":"0");
						map.put("edit", RightsHelper.testRights(userRole.getEdits_qx(), MENU_ID) || isAdmin?"1":"0");
						map.put("query", RightsHelper.testRights(userRole.getQuerys_qx(), MENU_ID) || isAdmin?"1":"0");
						session.removeAttribute(Const.SESSION_QX);
						//重新分配按钮权限
						session.setAttribute(Const.SESSION_QX, map);
						System.out.println("map="+map);
						return true;
					}
				}
			}
		}
		return true;
	}
	
	/**
	 * 按钮权限(方法中校验)
	 * @param menuUrl  菜单路径
	 * @param type  类型(add、del、edit、cha)
	 * @return
	 */
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public static boolean buttonJurisdiction(String menuUrl, String type,HttpSession session){
		/**
		 * 判断是否拥有当前点击菜单的权限（内部过滤,防止通过url进入跳过菜单权限）
		 */
		System.out.println("menuUrl="+menuUrl+",type="+type);
		List<Menu> menuList = (List)session.getAttribute(Const.SESSION_ALL_MENU); //获取菜单列表
		for(int i=0;i<menuList.size();i++){
			for(int j=0;j<menuList.get(i).getSubMenu().size();j++){
				if(menuList.get(i).getSubMenu().get(j).getMENU_URL().equals(menuUrl)){
					if(!menuList.get(i).getSubMenu().get(j).isHasMenu()){				//判断有无此菜单权限
						return false;
					}else{																//按钮判断
						UserRole userRole = ((User)session.getAttribute(Const.SESSION_USER)).getUserRole();
						System.out.println("userRole="+userRole);
						long MENU_ID =  menuList.get(i).getSubMenu().get(j).getMENU_ID();
						String USERNAME = ((User)session.getAttribute(Const.SESSION_USER)).getUsername();
						Boolean isAdmin = "admin".equals(USERNAME);
						if("add".equals(type)){
							return ((RightsHelper.testRights(userRole.getAdds_qx(), MENU_ID)) || isAdmin);
						}else if("del".equals(type)){
							return ((RightsHelper.testRights(userRole.getDels_qx(), MENU_ID)) || isAdmin);
						}else if("edit".equals(type)){
							return ((RightsHelper.testRights(userRole.getEdits_qx(), MENU_ID)) || isAdmin);
						}else if("query".equals(type)){
							return ((RightsHelper.testRights(userRole.getQuerys_qx(), MENU_ID)) || isAdmin);
						}
					}
				}
			}
		}
		return true;
	}
}
