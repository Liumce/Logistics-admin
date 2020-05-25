package com.liu.admin.service.impl;

import com.liu.admin.dao.HelpDao;
import com.liu.admin.dao.QueryDao;
import com.liu.admin.service.IHelpService;
import com.liu.admin.util.ParameterMap;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * Create by liumce on 18/10/16
 */
@Service
public class HelpService implements IHelpService {

    @Autowired
    private HelpDao helpDao;

    @Autowired
    private HelpService helpService;

    private Logger log = Logger.getLogger(this.getClass());

    @Override
    public List<ParameterMap> getAllList() {
        return helpDao.list();
    }

    @Override
    public Map<String, Object> getHelp(ParameterMap pm) {
        return null;
    }

}
