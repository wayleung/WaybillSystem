/*
Navicat MySQL Data Transfer

Source Server         : localhost_3306
Source Server Version : 50626
Source Host           : localhost:3306
Source Database       : waybillsystem

Target Server Type    : MYSQL
Target Server Version : 50626
File Encoding         : 65001

Date: 2018-02-22 23:44:44
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for admin
-- ----------------------------
DROP TABLE IF EXISTS `admin`;
CREATE TABLE `admin` (
  `id` int(255) NOT NULL AUTO_INCREMENT COMMENT '管理员id',
  `account` varchar(255) DEFAULT NULL COMMENT '管理员登录账户名',
  `sex` varchar(255) DEFAULT NULL COMMENT '管理员性别',
  `name` varchar(255) DEFAULT NULL COMMENT '管理员用户名',
  `password` varchar(255) DEFAULT NULL COMMENT '管理员登录密码',
  `phone` varchar(255) DEFAULT NULL COMMENT '管理员联系电话',
  `photo` varchar(255) DEFAULT NULL COMMENT '管理员头像路径',
  `location` varchar(255) DEFAULT NULL,
  `logtime_last` datetime DEFAULT NULL COMMENT '最后一次登录时间',
  `status` varchar(255) DEFAULT NULL,
  `create_time` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of admin
-- ----------------------------
INSERT INTO `admin` VALUES ('0', '123', '男', '梁立威', '123', '15521608979', null, '广州', '2018-02-18 01:22:02', '激活', '2018-02-18 01:22:10');
INSERT INTO `admin` VALUES ('1', '123', '男', '梁立威', '123', '15521608979', '', '广州', '2018-02-18 01:22:02', '激活', '2018-02-18 01:22:10');
INSERT INTO `admin` VALUES ('4', '123', '男', '梁立威', '123', '15521608979', '', '广州', '2018-02-18 01:22:02', '激活', '2018-02-18 01:22:10');
INSERT INTO `admin` VALUES ('5', '123456', null, null, null, null, null, null, null, null, '2018-02-20 22:49:33');
INSERT INTO `admin` VALUES ('6', '1234567', null, null, null, null, null, null, null, null, '2018-02-20 22:52:11');
INSERT INTO `admin` VALUES ('7', '111222', null, null, null, null, null, null, null, null, '2018-02-22 00:42:23');
INSERT INTO `admin` VALUES ('8', '1112222', null, null, '123456789', null, null, null, null, null, '2018-02-22 00:45:33');
INSERT INTO `admin` VALUES ('9', '11121222', null, null, '1234567890', null, null, null, null, null, '2018-02-22 01:19:53');

-- ----------------------------
-- Table structure for company_information
-- ----------------------------
DROP TABLE IF EXISTS `company_information`;
CREATE TABLE `company_information` (
  `name` varchar(255) DEFAULT NULL,
  `location` varchar(255) DEFAULT NULL COMMENT '公司所在地',
  `website` varchar(255) DEFAULT NULL COMMENT '公司网站',
  `email` varchar(255) DEFAULT NULL COMMENT '公司邮箱',
  `phone` varchar(255) DEFAULT NULL COMMENT '公司电话',
  `slogan` varchar(255) DEFAULT NULL COMMENT '公司口号',
  `description_title` varchar(255) DEFAULT NULL COMMENT '公司描述标题',
  `description_content1` varchar(255) DEFAULT NULL COMMENT '公司描述内容1',
  `description_content2` varchar(255) DEFAULT NULL COMMENT '公司描述内容',
  `description_content3` varchar(255) DEFAULT NULL COMMENT '公司描述内容3'
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of company_information
-- ----------------------------

-- ----------------------------
-- Table structure for employee
-- ----------------------------
DROP TABLE IF EXISTS `employee`;
CREATE TABLE `employee` (
  `id` bigint(255) NOT NULL AUTO_INCREMENT COMMENT '员工编号',
  `name` varchar(255) DEFAULT NULL COMMENT '员工名字',
  `phone` varchar(255) DEFAULT NULL COMMENT '员工联系电话',
  `sex` varchar(255) DEFAULT NULL,
  `age` int(11) DEFAULT NULL,
  `location` varchar(255) DEFAULT NULL,
  `status` varchar(255) DEFAULT NULL,
  `start_time` datetime DEFAULT NULL,
  `create_time` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of employee
-- ----------------------------

-- ----------------------------
-- Table structure for fee
-- ----------------------------
DROP TABLE IF EXISTS `fee`;
CREATE TABLE `fee` (
  `fee_id` int(11) NOT NULL AUTO_INCREMENT,
  `location_send` int(255) DEFAULT NULL COMMENT '始发地代码',
  `loacation_receive` int(255) DEFAULT NULL COMMENT '目的地代码',
  `fee` decimal(10,0) DEFAULT NULL COMMENT '两地的运费',
  PRIMARY KEY (`fee_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of fee
-- ----------------------------

-- ----------------------------
-- Table structure for location
-- ----------------------------
DROP TABLE IF EXISTS `location`;
CREATE TABLE `location` (
  `location_id` int(11) NOT NULL COMMENT '可以用邮政编码做id',
  `location_name` varchar(255) DEFAULT NULL COMMENT '城市名  地名  快递分部名',
  PRIMARY KEY (`location_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of location
-- ----------------------------

-- ----------------------------
-- Table structure for message
-- ----------------------------
DROP TABLE IF EXISTS `message`;
CREATE TABLE `message` (
  `message_id` int(11) NOT NULL COMMENT '留言编号',
  `name` varchar(255) DEFAULT NULL COMMENT '留言人姓名',
  `email` varchar(255) DEFAULT NULL COMMENT '留言人邮箱',
  `subject` varchar(255) DEFAULT NULL COMMENT '留言主题',
  `content` varchar(255) DEFAULT NULL COMMENT '留言内容',
  `create_time` datetime DEFAULT NULL,
  PRIMARY KEY (`message_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of message
-- ----------------------------

-- ----------------------------
-- Table structure for pay_charge
-- ----------------------------
DROP TABLE IF EXISTS `pay_charge`;
CREATE TABLE `pay_charge` (
  `pc_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '付费方式id',
  `pc_name` varchar(255) DEFAULT NULL COMMENT '付费方式名字',
  PRIMARY KEY (`pc_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of pay_charge
-- ----------------------------

-- ----------------------------
-- Table structure for pay_option
-- ----------------------------
DROP TABLE IF EXISTS `pay_option`;
CREATE TABLE `pay_option` (
  `po_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '资费方式id',
  `po_name` varchar(255) DEFAULT NULL COMMENT '资费方式名字',
  PRIMARY KEY (`po_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of pay_option
-- ----------------------------

-- ----------------------------
-- Table structure for status
-- ----------------------------
DROP TABLE IF EXISTS `status`;
CREATE TABLE `status` (
  `status_id` int(11) NOT NULL AUTO_INCREMENT,
  `status_name` varchar(255) DEFAULT NULL COMMENT '如1 已揽件2中转中3运送中4 到达某地  5  派送中 6   已签收）',
  PRIMARY KEY (`status_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of status
-- ----------------------------

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `id` bigint(255) NOT NULL AUTO_INCREMENT COMMENT '用户id',
  `account` varchar(255) DEFAULT NULL COMMENT '用户登录账号名',
  `sex` varchar(255) DEFAULT NULL COMMENT '用户性别',
  `name` varchar(255) DEFAULT NULL COMMENT '用户昵称 名字',
  `password` varchar(255) DEFAULT NULL COMMENT '用户登录密码',
  `photo` varchar(255) DEFAULT NULL COMMENT '用户头像路径',
  `phone` varchar(255) DEFAULT NULL COMMENT '用户电话',
  `wechat_id` varchar(255) DEFAULT NULL COMMENT '绑定的微信id',
  `wechat_name` varchar(255) DEFAULT NULL COMMENT '绑定的微信的用户名',
  `logtime_last` datetime DEFAULT NULL COMMENT '最后一次登录时间',
  `create_time` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of user
-- ----------------------------

-- ----------------------------
-- Table structure for waybill
-- ----------------------------
DROP TABLE IF EXISTS `waybill`;
CREATE TABLE `waybill` (
  `waybill_number` bigint(255) NOT NULL COMMENT '运单号',
  `ws_id_newest` bigint(11) DEFAULT NULL COMMENT '最新一条状态',
  `user_id` bigint(11) DEFAULT NULL COMMENT '用户id int  对应User表 可修改',
  `from_name` varchar(255) DEFAULT NULL COMMENT '寄件人姓名',
  `departure` varchar(255) DEFAULT NULL COMMENT '始发地',
  `send_date` datetime DEFAULT NULL COMMENT '寄件日期',
  `from_company_name` varchar(255) DEFAULT NULL COMMENT '寄件人单位名称',
  `from_address` varchar(255) DEFAULT NULL COMMENT '寄件人地址',
  `from_phone` varchar(255) DEFAULT NULL COMMENT '寄件人电话',
  `is_msg` varchar(1) DEFAULT NULL COMMENT '是否短信通知',
  `contents` varchar(255) DEFAULT NULL COMMENT '物品',
  `to_name` varchar(255) DEFAULT NULL COMMENT '收件人姓名',
  `destination` varchar(255) DEFAULT NULL COMMENT '目的地',
  `receive_date` datetime DEFAULT NULL COMMENT '收件日期',
  `to_company_name` varchar(255) DEFAULT NULL COMMENT '收件人单位名称',
  `to_address` varchar(255) DEFAULT NULL COMMENT '收件人地址',
  `to_phone` varchar(255) DEFAULT NULL COMMENT '收件人电话',
  `pickedup_by` varchar(255) DEFAULT NULL COMMENT '揽件人',
  `weight` double DEFAULT NULL COMMENT '重量 kg',
  `dimensionl` double DEFAULT NULL COMMENT '体积 （与体积相关 长x宽x高 cm）',
  `is_ins` varchar(1) DEFAULT NULL COMMENT '是否保价',
  `insurance_fee` decimal(10,0) DEFAULT NULL COMMENT '保价费（保价时）',
  `insurance_amount` decimal(10,0) DEFAULT NULL COMMENT '保价金额（保价时）',
  `times_of_charge` decimal(10,0) DEFAULT NULL COMMENT '运费的多少倍(非保价时)',
  `charge` decimal(10,0) DEFAULT NULL COMMENT '运费（不算包装）',
  `package_charge` decimal(10,0) DEFAULT NULL COMMENT '包装费',
  `total_charge` decimal(10,0) DEFAULT NULL COMMENT '费用总计',
  `payment_option` int(11) DEFAULT NULL COMMENT '资费方式  对应Pay_Option表',
  `payment_charge` int(11) DEFAULT NULL COMMENT '付费方式 对应Pay_Charge表 ',
  `from_signature` varchar(255) DEFAULT NULL COMMENT '寄件人签名  图片路径',
  `from_id` varchar(255) DEFAULT NULL COMMENT '寄件人身份证',
  `to_id` varchar(255) DEFAULT NULL COMMENT '收件人身份证',
  `waybill_pic` varchar(255) DEFAULT NULL COMMENT '运单图片路径',
  `to_signature` varchar(255) DEFAULT NULL COMMENT '收件人签名  图片路径',
  `create_time` datetime DEFAULT NULL,
  PRIMARY KEY (`waybill_number`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of waybill
-- ----------------------------

-- ----------------------------
-- Table structure for waybill_status
-- ----------------------------
DROP TABLE IF EXISTS `waybill_status`;
CREATE TABLE `waybill_status` (
  `ws_id` bigint(11) NOT NULL AUTO_INCREMENT COMMENT '运单状态编号',
  `waybill_number` bigint(255) DEFAULT NULL COMMENT '运单号码',
  `status` int(11) DEFAULT NULL COMMENT '状态',
  `location_now` int(11) DEFAULT NULL COMMENT '现在位置',
  `lacation_time` datetime DEFAULT NULL COMMENT '到达位置时间',
  `employee_charge` bigint(11) DEFAULT NULL COMMENT '负责员工',
  `create_time` datetime DEFAULT NULL,
  PRIMARY KEY (`ws_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of waybill_status
-- ----------------------------

-- ----------------------------
-- Table structure for wechat_token
-- ----------------------------
DROP TABLE IF EXISTS `wechat_token`;
CREATE TABLE `wechat_token` (
  `id` bigint(255) NOT NULL AUTO_INCREMENT,
  `code` varchar(255) DEFAULT NULL COMMENT '微信code',
  `token` varchar(255) DEFAULT NULL COMMENT '微信token',
  `openid` varchar(255) DEFAULT NULL COMMENT '微信用户openid',
  `create_time` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of wechat_token
-- ----------------------------
