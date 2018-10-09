package com.liu.admin.service.impl;

import com.liu.admin.dao.QueryDao;
import com.liu.admin.entity.Const;
import com.liu.admin.entity.Menu;
import com.liu.admin.entity.ReturnModel;
import com.liu.admin.entity.User;
import com.liu.admin.service.IQueryService;
import com.liu.admin.util.ParameterMap;
import com.liu.admin.util.RightsHelper;
import com.liu.admin.util.Tools;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.interceptor.TransactionAspectSupport;

import javax.servlet.http.HttpSession;
import java.math.BigInteger;
import java.util.List;
import java.util.Map;

/**
 * Create by liumce on 18/10/09
 */
@Service
public class QueryService implements IQueryService {

    @Autowired
    private QueryDao queryDao;

    @Autowired
    private MenuService menuService;

    private Logger log = Logger.getLogger(this.getClass());



    @Override
    public List<ParameterMap> list() {
        return queryDao.list();
    }

    /**
     * 判断角色对各个菜单的各个权限
     */
    @Override
    public Map<String, Object> getQuery(ParameterMap pm) {
        String qx;
        List<Menu> menus;
        String QXtype = pm.getString("qx");
        ParameterMap role = queryDao.getRoleById(pm);
        try {
            if("rights".equalsIgnoreCase(QXtype)){
                qx = role.getString("rights");
            }else if("add_qx".equalsIgnoreCase(QXtype)){
                qx = role.getString("add_qx");
            }else if("del_qx".equalsIgnoreCase(QXtype)){
                qx = role.getString("del_qx");
            }else if("edit_qx".equalsIgnoreCase(QXtype)){
                qx = role.getString("edit_qx");
            }else if("query_qx".equalsIgnoreCase(QXtype)){
                qx = role.getString("query_qx");
            }else{
                return ReturnModel.getModel("你请求的是一个冒牌接口", "failed", null);
            }			menus = menuService.getAllMenuList();

            for(Menu m:menus){
                List<Menu> subm = m.getSubMenu();
                if(subm != null && subm.size() > 0){
                    int subNumber = subm.size();
                    int index = 0;
                    for(Menu sm:subm){
                        boolean ishas = RightsHelper.testRights(qx, sm.getMENU_ID());
                        System.out.println("qx="+qx+",menu_id="+sm.getMENU_ID()+",result="+ishas);
                        sm.setHasMenu(ishas);
                        if(ishas){
                            index++;
                        }
                    }

                    //判断子菜单是否全部选中
                    if(subNumber == index){
                        m.setHasMenu(true);
                    }
                }
            }

        } catch (Exception e) {
            log.error("error", e);
            return ReturnModel.getModel("error", "failed", null);
        }
        return ReturnModel.getModel("ok", "success", menus);
    }

    @Override
    public Map<String, Object> edit(ParameterMap pm) {
        try {
            String idstr = pm.getString("ids");
            if(Tools.notEmpty(idstr)){
                String[] ids = idstr.split(",");
                BigInteger newRights = RightsHelper.sumRights(ids);
                String qxKey = pm.getString("qx");
                pm.put(qxKey,newRights);
            }
            System.out.println("query_desc="+pm.getString("query_desc"));
            pm.put("query_desc", pm.getString("query_desc").trim());
            queryDao.updateRoleQX(pm);
        } catch (Exception e) {
            log.error("error", e);
            return ReturnModel.getModel("error", "failed", null);
        }
        return ReturnModel.getModel("ok", "success", null);
    }

    @Override
    public Map<String, Object> add(ParameterMap pm,HttpSession session) {
        try {
            pm.put("user_id",((User)session.getAttribute(Const.SESSION_USER)).getUserId());
            pm.put("query_desc", pm.getString("query_desc").trim());
            queryDao.addQuery(pm);
        } catch (Exception e) {
            e.printStackTrace();
            log.error("add query error", e);
            return ReturnModel.getModel("error", "falied", null);
        }
        return ReturnModel.getModel("ok", "success", null);
    }

    @Override
    public Map<String, Object> del(String queryId) {
        try {
            if(Tools.isEmpty(queryId) || !Tools.isNumber(queryId)){
                return ReturnModel.getModel("你请求的是一个冒牌接口", "failed", null);
            }
            queryDao.delQuery(queryId);
            queryDao.delUserQuery(queryId);
        } catch (Exception e) {
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
            e.printStackTrace();
            log.error("del query error", e);
            return ReturnModel.getModel("error", "falied", null);
        }
        return ReturnModel.getModel("ok", "success", null);
    }
}
