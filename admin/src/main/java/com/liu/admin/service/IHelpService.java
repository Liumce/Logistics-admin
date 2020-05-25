package com.liu.admin.service;

import com.liu.admin.util.ParameterMap;

import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.Map;

/**
 * Create by liumce on 18/10/16
 */

public interface IHelpService {

    public List<ParameterMap> getAllList();
    public Map<String,Object> getHelp(ParameterMap pm);

}
