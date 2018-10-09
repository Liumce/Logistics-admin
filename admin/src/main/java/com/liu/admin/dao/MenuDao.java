package com.liu.admin.dao;

import java.util.List;

import com.liu.admin.entity.Menu;
import com.liu.admin.util.ParameterMap;

public interface MenuDao {
	
	public List<Menu> getAllParentMenu(Object obj);
	public List<Menu> getSubMenuByParentId(long ParentId);
	public long getMaxIdByName();
	public void saveMenu(ParameterMap pm);
	/**
	 * 逻辑删除，实际是更新
	 * @param pm
	 */
	public void delMenu(String menuId);
	public void editMenu(ParameterMap pm);
	public ParameterMap findMenu(String menuId);
}
