package com.liu.admin.entity;

import java.util.Date;

/**
 * 查询
 * Create by liumce on 18/10/03
 */
public class Query {


    private Integer orderId;
    private String senter;
    private String senterPhone;
    private String sentAddress;
    private String sentAddMsg;
    private String collecter;
    private String collectPhone;
    private String collectAddress;
    private String weight;
    private String note;
    private Integer salesmanId;


    public Query(Integer orderId, String senter, String senterPhone, String sentAddress, String sentAddMsg, String collecter, String collectPhone, String collectAddress, String weight, String note, Integer salesmanId) {
        this.orderId = orderId;
        this.senter = senter;
        this.senterPhone = senterPhone;
        this.sentAddress = sentAddress;
        this.sentAddMsg = sentAddMsg;
        this.collecter = collecter;
        this.collectPhone = collectPhone;
        this.collectAddress = collectAddress;
        this.weight = weight;
        this.note = note;
        this.salesmanId = salesmanId;
    }

    public Integer getOrderId() {
        return orderId;
    }

    public void setOrderId(Integer orderId) {
        this.orderId = orderId;
    }

    public String getSenter() {
        return senter;
    }

    public void setSenter(String senter) {
        this.senter = senter;
    }

    public String getSenterPhone() {
        return senterPhone;
    }

    public void setSenterPhone(String senterPhone) {
        this.senterPhone = senterPhone;
    }

    public String getSentAddress() {
        return sentAddress;
    }

    public void setSentAddress(String sentAddress) {
        this.sentAddress = sentAddress;
    }

    public String getSentAddMsg() {
        return sentAddMsg;
    }

    public void setSentAddMsg(String sentAddMsg) {
        this.sentAddMsg = sentAddMsg;
    }

    public String getCollecter() {
        return collecter;
    }

    public void setCollecter(String collecter) {
        this.collecter = collecter;
    }

    public String getCollectPhone() {
        return collectPhone;
    }

    public void setCollectPhone(String collectPhone) {
        this.collectPhone = collectPhone;
    }

    public String getCollectAddress() {
        return collectAddress;
    }

    public void setCollectAddress(String collectAddress) {
        this.collectAddress = collectAddress;
    }

    public String getWeight() {
        return weight;
    }

    public void setWeight(String weight) {
        this.weight = weight;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public Integer getSalesmanId() {
        return salesmanId;
    }

    public void setSalesmanId(Integer salesmanId) {
        this.salesmanId = salesmanId;
    }

    @Override
    public String toString() {
        return "Order{" +
                "orderId=" + orderId +
                ", senter='" + senter + '\'' +
                ", senterPhone='" + senterPhone + '\'' +
                ", sentAddress='" + sentAddress + '\'' +
                ", sentAddMsg='" + sentAddMsg + '\'' +
                ", collecter='" + collecter + '\'' +
                ", collectPhone='" + collectPhone + '\'' +
                ", collectAddress='" + collectAddress + '\'' +
                ", weight='" + weight + '\'' +
                ", note='" + note + '\'' +
                ", salesmanId=" + salesmanId +
                '}';
    }
}
