/*
Navicat MySQL Data Transfer

Source Server         : mariadb
Source Server Version : 100216
Source Host           : localhost:3306
Source Database       : admin

Target Server Type    : MYSQL
Target Server Version : 100216
File Encoding         : 65001

Date: 2018-12-29 11:17:52
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for sys_login
-- ----------------------------
DROP TABLE IF EXISTS `sys_login`;
CREATE TABLE `sys_login` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `user_id` int(11) NOT NULL COMMENT '用户ID',
  `last_login_time` timestamp NULL DEFAULT current_timestamp() ON UPDATE current_timestamp() COMMENT '最后登录时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=318 DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Table structure for sys_logistics
-- ----------------------------
DROP TABLE IF EXISTS `sys_logistics`;
CREATE TABLE `sys_logistics` (
  `order_id` int(11) NOT NULL,
  `order_name` varchar(50) DEFAULT NULL,
  `order_type` enum('1','2','3','4') DEFAULT '1' COMMENT '1--普通快递，2--玻璃类，3--食品类，4--其他',
  PRIMARY KEY (`order_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for sys_menu
-- ----------------------------
DROP TABLE IF EXISTS `sys_menu`;
CREATE TABLE `sys_menu` (
  `menu_id` int(11) NOT NULL COMMENT '菜单ID',
  `parent_id` int(11) DEFAULT NULL,
  `menu_name` varchar(50) DEFAULT '' COMMENT '菜单名称',
  `menu_url` varchar(50) DEFAULT '#' COMMENT '菜单地址',
  `menu_type` enum('2','1','3','4') DEFAULT '2' COMMENT '1 -- 系统菜单，2 -- 业务菜单',
  `menu_icon` varchar(50) DEFAULT '#' COMMENT '菜单图标',
  `sort_num` int(11) DEFAULT 1 COMMENT '排序',
  `user_id` int(11) DEFAULT 1 COMMENT '创建这个菜单的用户id',
  `is_del` int(11) DEFAULT 0 COMMENT '1-- 删除状态，0 -- 正常',
  `update_time` timestamp NULL DEFAULT current_timestamp() ON UPDATE current_timestamp() COMMENT '更新时间',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  PRIMARY KEY (`menu_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Table structure for sys_order
-- ----------------------------
DROP TABLE IF EXISTS `sys_order`;
CREATE TABLE `sys_order` (
  `order_id` int(11) NOT NULL AUTO_INCREMENT,
  `senter` varchar(50) DEFAULT '' COMMENT '寄件人',
  `senter_phone` varchar(50) DEFAULT '' COMMENT '寄件人电话',
  `sent_address` varchar(255) DEFAULT '' COMMENT '寄件人上门地址',
  `sent_addmsg` varchar(255) DEFAULT '' COMMENT '寄件人详细地址',
  `collecter` varchar(50) DEFAULT '' COMMENT '收件人',
  `collect_phone` varchar(255) DEFAULT '' COMMENT '收件人电话',
  `collect_address` varchar(255) DEFAULT '' COMMENT '收件人上门地址',
  `collect_addmsg` varchar(255) DEFAULT '' COMMENT '收件人详细地址',
  `weight` varchar(255) DEFAULT '' COMMENT '物品重量',
  `note` varchar(255) DEFAULT '' COMMENT '备注',
  `salesman_id` varchar(20) DEFAULT '' COMMENT '业务员编号',
  `order_number` varchar(20) DEFAULT '' COMMENT '订单编号',
  `price` decimal(20,2) DEFAULT NULL COMMENT '订单价格',
  `shipment_status` varchar(255) DEFAULT '0' COMMENT '物流状态: 0 -- 未接单，1 -- 已接单',
  PRIMARY KEY (`order_id`)
) ENGINE=InnoDB AUTO_INCREMENT=123158 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for sys_role
-- ----------------------------
DROP TABLE IF EXISTS `sys_role`;
CREATE TABLE `sys_role` (
  `role_id` int(11) NOT NULL AUTO_INCREMENT,
  `role_name` varchar(50) DEFAULT NULL COMMENT '角色名',
  `role_desc` varchar(255) DEFAULT '' COMMENT '解释',
  `rights` varchar(255) DEFAULT '0' COMMENT '最大权限的值',
  `add_qx` varchar(255) DEFAULT '0',
  `del_qx` varchar(255) DEFAULT '0',
  `edit_qx` varchar(255) DEFAULT '0',
  `query_qx` varchar(255) DEFAULT '0',
  `user_id` varchar(10) DEFAULT NULL,
  `create_time` timestamp NULL DEFAULT current_timestamp() ON UPDATE current_timestamp(),
  PRIMARY KEY (`role_id`)
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Table structure for sys_shipment
-- ----------------------------
DROP TABLE IF EXISTS `sys_shipment`;
CREATE TABLE `sys_shipment` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `order_id` varchar(50) DEFAULT NULL COMMENT '物流id',
  `order_number` varchar(20) DEFAULT '' COMMENT '订单编号',
  `status` int(1) DEFAULT NULL COMMENT '物流状态：0---已发货 ，1 -- 已揽件，2 -- 正在路上，3 --- 已签收',
  `address` varchar(255) DEFAULT NULL COMMENT '物流地址',
  `mark` text DEFAULT NULL COMMENT '备注',
  `receive_date` varchar(50) DEFAULT NULL COMMENT '接收时间',
  `is_del` varchar(1) DEFAULT 'N' COMMENT '是否已删除',
  `create_time` varchar(50) DEFAULT NULL COMMENT '创建时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=38 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for sys_traffic
-- ----------------------------
DROP TABLE IF EXISTS `sys_traffic`;
CREATE TABLE `sys_traffic` (
  `traffic_id` int(11) NOT NULL,
  `traffic_name` varchar(50) DEFAULT NULL,
  `send_time` timestamp NULL DEFAULT NULL ON UPDATE current_timestamp(),
  `send_address` varchar(50) DEFAULT NULL,
  `traffic_status` varchar(50) DEFAULT '下单中',
  `traffic_saman_id` int(11) DEFAULT NULL,
  `traffic_saman_name` varchar(50) DEFAULT NULL,
  `traffic_saman_phone` varchar(50) DEFAULT NULL,
  `traffic_saman_carid` int(11) DEFAULT NULL,
  `order_id` int(11) NOT NULL,
  PRIMARY KEY (`traffic_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for sys_traffic_order
-- ----------------------------
DROP TABLE IF EXISTS `sys_traffic_order`;
CREATE TABLE `sys_traffic_order` (
  `id` int(11) NOT NULL,
  `traffic_id` int(11) DEFAULT NULL,
  `order_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for sys_user
-- ----------------------------
DROP TABLE IF EXISTS `sys_user`;
CREATE TABLE `sys_user` (
  `user_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '用户ID',
  `username` varchar(50) DEFAULT '' COMMENT '用户名称',
  `nick_name` varchar(50) DEFAULT '' COMMENT '名称',
  `password` varchar(50) DEFAULT '' COMMENT '密码',
  `pic_path` varchar(200) DEFAULT '/images/logo.png' COMMENT '头像路径',
  `status` enum('unlock','lock') DEFAULT 'unlock' COMMENT '状态',
  `sessionId` varchar(50) DEFAULT NULL,
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  PRIMARY KEY (`user_id`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Table structure for sys_user_role
-- ----------------------------
DROP TABLE IF EXISTS `sys_user_role`;
CREATE TABLE `sys_user_role` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `user_id` int(11) DEFAULT NULL,
  `role_id` int(11) DEFAULT NULL,
  `create_time` timestamp NULL DEFAULT current_timestamp() ON UPDATE current_timestamp(),
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=21 DEFAULT CHARSET=utf8mb4;
