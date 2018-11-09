package com.liu.admin.util;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.text.SimpleDateFormat;

/**
 * 订购业务唯一订单号实现
 * @author lenovo
 *
 */
public class IdGeneratorUtils {

	private long workerId;   //用ip地址最后几个字节标示
	private long datacenterId = 0L; //可配置在properties中,启动时加载,此处默认先写成0
	private long sequence = 0L;
	private long workerIdBits = 8L; //节点ID长度
	//private long datacenterIdBits = 2L; //数据中心ID长度,可根据时间情况设定位数
	private long sequenceBits = 12L; //序列号12位
	private long workerIdShift = sequenceBits; //机器节点左移12位
	private long datacenterIdShift = sequenceBits + workerIdBits; //数据中心节点左移17位
	private long sequenceMask = -1L ^ (-1L << sequenceBits); //4095
	private long lastTimestamp = -1L;
 
	public IdGeneratorUtils() {
	    workerId = 0x000000FF & getLastIP();
	}
 
	/**
	 * 调用该方法，获取序列ID
	 * @return
	 */
	public synchronized String nextId() {
	    long timestamp = currentTime(); //获取当前毫秒数
	    //如果服务器时间有问题(时钟后退) 报错。
	    if (timestamp < lastTimestamp) {
	        throw new RuntimeException(String.format("时钟向后移动。拒绝在%d毫秒内生成id", lastTimestamp - timestamp));
	    }
	    //如果上次生成时间和当前时间相同,在同一毫秒内
	    if (lastTimestamp == timestamp) {
	        //sequence自增，因为sequence只有12bit，所以和sequenceMask相与一下，去掉高位
	        sequence = (sequence + 1) & sequenceMask;
	        //判断是否溢出,也就是每毫秒内超过4095，当为4096时，与sequenceMask相与，sequence就等于0
	        if (sequence == 0) {
	            timestamp = nextMillis(lastTimestamp); //自旋等待到下一毫秒
	        }
	    } else {
	        sequence = 0L; //如果和上次生成时间不同,重置sequence，就是下一毫秒开始，sequence计数重新从0开始累加
	    }
	    lastTimestamp = timestamp;
 
	    long suffix = (datacenterId << datacenterIdShift) | (workerId << workerIdShift) | sequence;
 
	    // 格式化日期
	    SimpleDateFormat timePe = new SimpleDateFormat("yyyyMMddHHMMssSSS");
	    String datePrefix = timePe.format(timestamp);
 
	    return datePrefix + suffix;
	}
 
	/**
	 * 比较当前时间戳和下一个时间戳，如果下一个时间戳等于或小于当前时间戳，则循环获取下个时间戳
	 * 该方法主要是避免同一时间获取同一时间戳
	 * @param lastTimestamp
	 * @return
	 */
	protected long nextMillis(long lastTimestamp) {
		long timestamp = currentTime();
		while (timestamp <= lastTimestamp) {
			timestamp = currentTime();
		}
		return timestamp;
	}
 
	/**
	 * 获取系统当前时间戳
	 * @return
	 */
	protected long currentTime() {
		return System.currentTimeMillis();
	}
 
	/**
	 * 获取当前本地IP
	 * @return
	 */
	private byte getLastIP(){
	    byte lastip = 0;
	    try{
	        InetAddress ip = InetAddress.getLocalHost();
	        byte[] ipByte = ip.getAddress();
	        lastip = ipByte[ipByte.length - 1];
	    } catch (UnknownHostException e) {
	        e.printStackTrace();
	    }
	    return lastip;
	}
}
