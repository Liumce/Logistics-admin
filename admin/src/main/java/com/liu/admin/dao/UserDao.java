package com.liu.admin.dao;

import java.util.List;

import com.liu.admin.entity.Role;
import com.liu.admin.entity.User;
import com.liu.admin.util.ParameterMap;

public interface UserDao {
	public User getUserInfo(ParameterMap pm);
	public List<Role> getUserRoleList(ParameterMap pm);
	public List<ParameterMap> getUserList();
	public void saveLoginTime(String userId);
	public void saveUser(ParameterMap pm);
	public void bathSaveUserRole(List<ParameterMap> parame);
	public void editUser(ParameterMap pm);
	public void delUser(String userId);
	public void delUserRole(String userId);
}
