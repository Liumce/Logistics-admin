package com.liu.admin.entity;

/**
 * 查询
 * Create by liumce on 18/10/03
 */
public class Query {

    private Integer queryId;
    private String orderName;
    private String orderType;

    public Integer getQueryId() {
        return queryId;
    }

    public void setQueryId(Integer queryId) {
        this.queryId = queryId;
    }

    public String getOrderName() {
        return orderName;
    }

    public void setOrderName(String orderName) {
        this.orderName = orderName;
    }

    public String getOrderType() {
        return orderType;
    }

    public void setOrderType(String orderType) {
        this.orderType = orderType;
    }

    public Query(Integer queryId, String orderName, String orderType) {
        this.queryId = queryId;
        this.orderName = orderName;
        this.orderType = orderType;
    }

    @Override
    public String toString() {
        return "Query{" +
                "queryId=" + queryId +
                ", orderName='" + orderName + '\'' +
                ", orderType='" + orderType + '\'' +
                '}';
    }
}
