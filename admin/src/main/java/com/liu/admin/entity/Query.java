package com.liu.admin.entity;

import java.util.Date;

/**
 * 查询
 * Create by liumce on 18/10/03
 */
public class Query {

    private Integer trafficId;
    private String trafficName;
    private Date sendTime;
    private String sendAddress;
    private String trafficStatus;
    private String trafficSamanName;
    private String trafficSamanPhone;
    private Integer trafficSamanSarId;
    private Integer orderId;

    public Query(Integer trafficId, String trafficName, Date sendTime, String sendAddress, String trafficStatus, String trafficSamanName, String trafficSamanPhone, Integer trafficSamanSarId, Integer orderId) {
        this.trafficId = trafficId;
        this.trafficName = trafficName;
        this.sendTime = sendTime;
        this.sendAddress = sendAddress;
        this.trafficStatus = trafficStatus;
        this.trafficSamanName = trafficSamanName;
        this.trafficSamanPhone = trafficSamanPhone;
        this.trafficSamanSarId = trafficSamanSarId;
        this.orderId = orderId;
    }

    public Integer getTrafficId() {
        return trafficId;
    }

    public void setTrafficId(Integer trafficId) {
        this.trafficId = trafficId;
    }

    public String getTrafficName() {
        return trafficName;
    }

    public void setTrafficName(String trafficName) {
        this.trafficName = trafficName;
    }

    public Date getSendTime() {
        return sendTime;
    }

    public void setSendTime(Date sendTime) {
        this.sendTime = sendTime;
    }

    public String getSendAddress() {
        return sendAddress;
    }

    public void setSendAddress(String sendAddress) {
        this.sendAddress = sendAddress;
    }

    public String getTrafficStatus() {
        return trafficStatus;
    }

    public void setTrafficStatus(String trafficStatus) {
        this.trafficStatus = trafficStatus;
    }

    public String getTrafficSamanName() {
        return trafficSamanName;
    }

    public void setTrafficSamanName(String trafficSamanName) {
        this.trafficSamanName = trafficSamanName;
    }

    public String getTrafficSamanPhone() {
        return trafficSamanPhone;
    }

    public void setTrafficSamanPhone(String trafficSamanPhone) {
        this.trafficSamanPhone = trafficSamanPhone;
    }

    public Integer getTrafficSamanSarId() {
        return trafficSamanSarId;
    }

    public void setTrafficSamanSarId(Integer trafficSamanSarId) {
        this.trafficSamanSarId = trafficSamanSarId;
    }

    public Integer getOrderId() {
        return orderId;
    }

    public void setOrderId(Integer orderId) {
        this.orderId = orderId;
    }

    @Override
    public String toString() {
        return "Query{" +
                "trafficId=" + trafficId +
                ", trafficName='" + trafficName + '\'' +
                ", sendTime=" + sendTime +
                ", sendAddress='" + sendAddress + '\'' +
                ", trafficStatus='" + trafficStatus + '\'' +
                ", trafficSamanName='" + trafficSamanName + '\'' +
                ", trafficSamanPhone='" + trafficSamanPhone + '\'' +
                ", trafficSamanSarId=" + trafficSamanSarId +
                ", orderId=" + orderId +
                '}';
    }
}
