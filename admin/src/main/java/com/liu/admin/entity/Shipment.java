package com.liu.admin.entity;

import java.util.Date;

/**
 * Create by liumce on 18/11/02
 */
public class Shipment {

//
//    private Integer id;
//    private String shipment_id;
//    private String shipmentOneadr;
//    private Date shipmentOnedate;
//    private String shipmentTwoadr;
//    private Date shipmentTwodate;
//    private String shipmentThradr;
//    private Date  shipmentThrdate;
//    private String shipmentFouradr;
//    private Date shipmentFourdate;
//    private String shipmentFiveadr;
//    private Date  shipmentFivedate;
//
//    private Integer orderId;
//    private String senter;
//    private String senterPhone;
//    private String sentAddress;
//    private String sentAddMsg;
//    private String collecter;
//    private String collectPhone;
//    private String collectAddress;
//    private String weight;
//    private String note;
//    private Integer salesmanId;
//
//
//    public Shipment(Integer id, String shipment_id, String shipmentOneadr, Date shipmentOnedate, String shipmentTwoadr, Date shipmentTwodate, String shipmentThradr, Date shipmentThrdate, String shipmentFouradr,
//                    Date shipmentFourdate, String shipmentFiveadr, Date shipmentFivedate, Integer orderId, String senter, String senterPhone, String sentAddress, String sentAddMsg, String collecter, String collectPhone, String collectAddress, String weight, String note, Integer salesmanId) {
//        this.id = id;
//        this.shipment_id = shipment_id;
//        this.shipmentOneadr = shipmentOneadr;
//        this.shipmentOnedate = shipmentOnedate;
//        this.shipmentTwoadr = shipmentTwoadr;
//        this.shipmentTwodate = shipmentTwodate;
//        this.shipmentThradr = shipmentThradr;
//        this.shipmentThrdate = shipmentThrdate;
//        this.shipmentFouradr = shipmentFouradr;
//        this.shipmentFourdate = shipmentFourdate;
//        this.shipmentFiveadr = shipmentFiveadr;
//        this.shipmentFivedate = shipmentFivedate;
//        this.orderId = orderId;
//        this.senter = senter;
//        this.senterPhone = senterPhone;
//        this.sentAddress = sentAddress;
//        this.sentAddMsg = sentAddMsg;
//        this.collecter = collecter;
//        this.collectPhone = collectPhone;
//        this.collectAddress = collectAddress;
//        this.weight = weight;
//        this.note = note;
//        this.salesmanId = salesmanId;
//    }
//
//    public Integer getId() {
//        return id;
//    }
//
//    public void setId(Integer id) {
//        this.id = id;
//    }
//
//    public String getShipment_id() {
//        return shipment_id;
//    }
//
//    public void setShipment_id(String shipment_id) {
//        this.shipment_id = shipment_id;
//    }
//
//    public String getShipmentOneadr() {
//        return shipmentOneadr;
//    }
//
//    public void setShipmentOneadr(String shipmentOneadr) {
//        this.shipmentOneadr = shipmentOneadr;
//    }
//
//    public Date getShipmentOnedate() {
//        return shipmentOnedate;
//    }
//
//    public void setShipmentOnedate(Date shipmentOnedate) {
//        this.shipmentOnedate = shipmentOnedate;
//    }
//
//    public String getShipmentTwoadr() {
//        return shipmentTwoadr;
//    }
//
//    public void setShipmentTwoadr(String shipmentTwoadr) {
//        this.shipmentTwoadr = shipmentTwoadr;
//    }
//
//    public Date getShipmentTwodate() {
//        return shipmentTwodate;
//    }
//
//    public void setShipmentTwodate(Date shipmentTwodate) {
//        this.shipmentTwodate = shipmentTwodate;
//    }
//
//    public String getShipmentThradr() {
//        return shipmentThradr;
//    }
//
//    public void setShipmentThradr(String shipmentThradr) {
//        this.shipmentThradr = shipmentThradr;
//    }
//
//    public Date getShipmentThrdate() {
//        return shipmentThrdate;
//    }
//
//    public void setShipmentThrdate(Date shipmentThrdate) {
//        this.shipmentThrdate = shipmentThrdate;
//    }
//
//    public String getShipmentFouradr() {
//        return shipmentFouradr;
//    }
//
//    public void setShipmentFouradr(String shipmentFouradr) {
//        this.shipmentFouradr = shipmentFouradr;
//    }
//
//    public Date getShipmentFourdate() {
//        return shipmentFourdate;
//    }
//
//    public void setShipmentFourdate(Date shipmentFourdate) {
//        this.shipmentFourdate = shipmentFourdate;
//    }
//
//    public String getShipmentFiveadr() {
//        return shipmentFiveadr;
//    }
//
//    public void setShipmentFiveadr(String shipmentFiveadr) {
//        this.shipmentFiveadr = shipmentFiveadr;
//    }
//
//    public Date getShipmentFivedate() {
//        return shipmentFivedate;
//    }
//
//    public void setShipmentFivedate(Date shipmentFivedate) {
//        this.shipmentFivedate = shipmentFivedate;
//    }
//
//    public Integer getOrderId() {
//        return orderId;
//    }
//
//    public void setOrderId(Integer orderId) {
//        this.orderId = orderId;
//    }
//
//    public String getSenter() {
//        return senter;
//    }
//
//    public void setSenter(String senter) {
//        this.senter = senter;
//    }
//
//    public String getSenterPhone() {
//        return senterPhone;
//    }
//
//    public void setSenterPhone(String senterPhone) {
//        this.senterPhone = senterPhone;
//    }
//
//    public String getSentAddress() {
//        return sentAddress;
//    }
//
//    public void setSentAddress(String sentAddress) {
//        this.sentAddress = sentAddress;
//    }
//
//    public String getSentAddMsg() {
//        return sentAddMsg;
//    }
//
//    public void setSentAddMsg(String sentAddMsg) {
//        this.sentAddMsg = sentAddMsg;
//    }
//
//    public String getCollecter() {
//        return collecter;
//    }
//
//    public void setCollecter(String collecter) {
//        this.collecter = collecter;
//    }
//
//    public String getCollectPhone() {
//        return collectPhone;
//    }
//
//    public void setCollectPhone(String collectPhone) {
//        this.collectPhone = collectPhone;
//    }
//
//    public String getCollectAddress() {
//        return collectAddress;
//    }
//
//    public void setCollectAddress(String collectAddress) {
//        this.collectAddress = collectAddress;
//    }
//
//    public String getWeight() {
//        return weight;
//    }
//
//    public void setWeight(String weight) {
//        this.weight = weight;
//    }
//
//    public String getNote() {
//        return note;
//    }
//
//    public void setNote(String note) {
//        this.note = note;
//    }
//
//    public Integer getSalesmanId() {
//        return salesmanId;
//    }
//
//    public void setSalesmanId(Integer salesmanId) {
//        this.salesmanId = salesmanId;
//    }
//
//    @Override
//    public String toString() {
//        return "Shipment{" +
//                "id=" + id +
//                ", shipment_id='" + shipment_id + '\'' +
//                ", shipmentOneadr='" + shipmentOneadr + '\'' +
//                ", shipmentOnedate=" + shipmentOnedate +
//                ", shipmentTwoadr='" + shipmentTwoadr + '\'' +
//                ", shipmentTwodate=" + shipmentTwodate +
//                ", shipmentThradr='" + shipmentThradr + '\'' +
//                ", shipmentThrdate=" + shipmentThrdate +
//                ", shipmentFouradr='" + shipmentFouradr + '\'' +
//                ", shipmentFourdate=" + shipmentFourdate +
//                ", shipmentFiveadr='" + shipmentFiveadr + '\'' +
//                ", shipmentFivedate=" + shipmentFivedate +
//                ", orderId=" + orderId +
//                ", senter='" + senter + '\'' +
//                ", senterPhone='" + senterPhone + '\'' +
//                ", sentAddress='" + sentAddress + '\'' +
//                ", sentAddMsg='" + sentAddMsg + '\'' +
//                ", collecter='" + collecter + '\'' +
//                ", collectPhone='" + collectPhone + '\'' +
//                ", collectAddress='" + collectAddress + '\'' +
//                ", weight='" + weight + '\'' +
//                ", note='" + note + '\'' +
//                ", salesmanId=" + salesmanId +
//                '}';
//    }
}
