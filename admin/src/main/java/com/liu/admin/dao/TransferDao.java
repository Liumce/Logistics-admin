package com.liu.admin.dao;

import com.liu.admin.util.ParameterMap;

import java.util.List;

/**
 * Create by liumce on 18/10/09
 */
public interface TransferDao {

    public List<ParameterMap> list();
    public List<ParameterMap> getTransferByuId(ParameterMap pm);
    public ParameterMap getTransferById(ParameterMap pm);
    public void updateTransferQX(ParameterMap pm);
    public void addTransfer(ParameterMap pm);
    public void delTransfer(String orderId);
    public void delUserTransfer(String orderId);
    public ParameterMap findMenu(String orderId);
}
