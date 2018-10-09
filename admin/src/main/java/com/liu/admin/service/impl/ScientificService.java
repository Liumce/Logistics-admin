package com.liu.admin.service.impl;

import com.liu.admin.dao.ScientificDao;
import com.liu.admin.service.IScientificService;
import com.liu.admin.util.ParameterMap;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.Map;

@Service
public class ScientificService implements IScientificService{

    @Autowired
    private ScientificDao scientificDao;

    @Autowired
    private MenuService menuService;

    private Logger log = Logger.getLogger(this.getClass());

    @Override
    public List<ParameterMap> list() {
        return scientificDao.list();
    }

    @Override
    public Map<String, Object> edit(ParameterMap pm) {
        return null;
    }

    @Override
    public Map<String, Object> add(ParameterMap pm, HttpSession session) {
        return null;
    }

    @Override
    public Map<String, Object> del(String roleId) {
        return null;
    }
}
