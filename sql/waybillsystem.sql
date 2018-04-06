/*
Navicat MySQL Data Transfer

Source Server         : mysql_local
Source Server Version : 50626
Source Host           : localhost:3306
Source Database       : waybillsystem

Target Server Type    : MYSQL
Target Server Version : 50626
File Encoding         : 65001

Date: 2018-04-06 17:47:11
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
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of admin
-- ----------------------------
INSERT INTO `admin` VALUES ('1', '123', 'm', '梁立威', '123', '15521608979', '', '广州', '2018-02-18 01:22:02', '激活', '2018-02-18 01:22:10');
INSERT INTO `admin` VALUES ('4', '123', 'm', '梁立威', '123', '15521608979', '', '广州', '2018-02-18 01:22:02', '激活', '2018-02-18 01:22:10');
INSERT INTO `admin` VALUES ('5', '123456', null, null, null, null, null, null, null, null, '2018-02-20 22:49:33');
INSERT INTO `admin` VALUES ('6', '1234567', null, null, null, null, null, null, null, null, '2018-02-20 22:52:11');
INSERT INTO `admin` VALUES ('7', '111222', null, null, null, null, null, null, null, null, '2018-02-22 00:42:23');
INSERT INTO `admin` VALUES ('8', '1112222', null, null, '123456789', null, null, null, null, null, '2018-02-22 00:45:33');
INSERT INTO `admin` VALUES ('9', '11121222', null, null, '1234567890', null, null, null, null, null, '2018-02-22 01:19:53');
INSERT INTO `admin` VALUES ('10', '123', 'm', '梁立威', '123', '15521608979', null, '广州', '2018-02-18 01:22:02', '激活', '2018-02-18 01:22:10');

-- ----------------------------
-- Table structure for code_token_openid
-- ----------------------------
DROP TABLE IF EXISTS `code_token_openid`;
CREATE TABLE `code_token_openid` (
  `id` bigint(255) NOT NULL AUTO_INCREMENT,
  `code` varchar(255) DEFAULT NULL COMMENT '微信code',
  `token` varchar(255) DEFAULT NULL COMMENT '微信token 有两种token 一种是从微信服务器获取的用于验证的access_token 两个小时过期 另外一种是微信用户授权登录的网页的access_token 只能使用一次 未使用的话5分钟过期',
  `openid` varchar(255) DEFAULT NULL COMMENT '微信用户openid',
  `create_time` datetime NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=31 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of code_token_openid
-- ----------------------------
INSERT INTO `code_token_openid` VALUES ('1', '021VEtme2s5YgE0iZQke2klAme2VEtml', '7_1DMt7OggLBPmY_DDGCFPS6wsGx6ahdH-yfXOvikB3HttMGYtjxxQKzURQmit_Ybslrh4MflvFQ3JwmKOIoOyweg0ZxLOndZHt3Ij-EDHQi8', 'oZHEd1Vj9nOAzC9F1WEuKRqzXqnQ', '2018-03-11 00:59:54');
INSERT INTO `code_token_openid` VALUES ('2', '021esijX1apS0T074fhX1xw5jX1esijz', '7_lI3SZOU3HyF6ncYHz8ewty_HXI-Z4KWv_nq8hZogFSlfSaryuj3jw6G-Dv69xe5eN31bie_wK9nbsfHr3B2q9WzE6UcVNwxQ4CJ71eMP0VU', 'oZHEd1Vj9nOAzC9F1WEuKRqzXqnQ', '2018-03-11 01:10:09');
INSERT INTO `code_token_openid` VALUES ('3', '081ylAP11W7IXN1rtLO11Z2DP11ylAPP', '7_k10IkmVRwISsf4-0alpGyIRnw1D4cfcQu0Y0US-tkfzCpzQb6GXFrf3JRroV95j-Gz-V3TkED4qit7RIH98IuMuJ39rJo0tJUut2Ks2vrdg', 'oZHEd1Vj9nOAzC9F1WEuKRqzXqnQ', '2018-03-11 01:10:39');
INSERT INTO `code_token_openid` VALUES ('4', '001PwSJ40IiKkJ1z6zK40PCaK40PwSJj', '7_khM2JbQXFa6EaihZLCPVwxIcmVjdKb8QrWXaRza7wtNGstkEKLBXsWK_exA9g6cZDC0TkK86MG6I6h3-YaNsQoCxocnkIxVrrC92VHIZuk8', 'oZHEd1W8OA-bRNgAIYhio5wEdApI', '2018-03-11 01:46:21');
INSERT INTO `code_token_openid` VALUES ('5', '061hNQCZ1UAzCZ0wZtEZ1O8sCZ1hNQC9', '7_1DMt7OggLBPmY_DDGCFPS3H87Q1vjukUS9lGwbSB1-jw5_dS2uYd6I8MT9baS4t1dYN8xYJexZzRuAXPhVKHZRuJoR_XuLYwHbWigbSjlU0', 'oZHEd1Vj9nOAzC9F1WEuKRqzXqnQ', '2018-03-11 01:47:10');
INSERT INTO `code_token_openid` VALUES ('6', '081MVrq00LqM3F1ex3t00Qsyq00MVrqp', '7_wecDiM-FSqi8Xmv3UOl6HDTeJEA1anNB0gbD8ke1h4kwu_PA8bq41_6QVnjR-e5kItsRGoKjPNXh8MNWxgEXMOajHlFyrK1fsPLCsIrl-l4', 'oZHEd1Vj9nOAzC9F1WEuKRqzXqnQ', '2018-03-11 22:32:43');
INSERT INTO `code_token_openid` VALUES ('7', '021trvZn1yQSjj05sSWn1ADnZn1trvZ-', '8_0l17DbjvLLZlxno0Wl1YHoB3rgjZBKJM8A7kpPhUB-U_U1A7-eLz5bxHYwIUFo6AOhguXV8DxKKyYfCRLIbTmdSOtSlY1mvxk1Dd0iEkmJo', 'oZHEd1Vj9nOAzC9F1WEuKRqzXqnQ', '2018-03-26 16:47:30');
INSERT INTO `code_token_openid` VALUES ('8', '061zWVpD1m4I340D28sD1LLOpD1zWVpm', '8_giXS1kgj4LxfYkXX1gksWwguIgu4P_qdgk7VqLvg6TxPMhLrBSG08ap5AjTA4XfNjnlFMT97AtnOqIw4hCHsYLqux5ofyQ0mscy9Knxzf2g', 'oZHEd1Vj9nOAzC9F1WEuKRqzXqnQ', '2018-04-02 16:57:32');
INSERT INTO `code_token_openid` VALUES ('9', '001kSf8g21sTdC0lF27g24Uh8g2kSf8F', '8_uS0SAyHu9MUCuAL6yfXz7uDsZx89hbNc4MxgK8WiaC4N24sVh5y1PTwQZWiDvVfF3q7tHMq7COnXyv_wm2jjWwGQvD0pnrR9fB0-QDzXIt8', 'oZHEd1Vj9nOAzC9F1WEuKRqzXqnQ', '2018-04-02 17:27:20');
INSERT INTO `code_token_openid` VALUES ('10', '011lxGwJ1uy14501TXzJ199ZwJ1lxGwb', '8_0l17DbjvLLZlxno0Wl1YHvo9B1Y7iwSUR-LZn3FKDxcoohS0blO306Ruw1mD4EC7j1olI1_w_kGoaEfDDSrVhen-T0yiT3iKLRK0An3ayvc', 'oZHEd1Vj9nOAzC9F1WEuKRqzXqnQ', '2018-04-02 17:29:08');
INSERT INTO `code_token_openid` VALUES ('11', '001D032T1kl3c81fHF1T1VEH1T1D032T', '8_7PYOxbcb_22VsWAzSe-xfZKgBglo3H0ikTnyotyOlpmfS59yqqDN3EVSKsCGR_YOdrobAFVev-vJFfGvsVkDlhedVQtIYy_1CsabNvC5UDs', 'oZHEd1Vj9nOAzC9F1WEuKRqzXqnQ', '2018-04-02 17:30:43');
INSERT INTO `code_token_openid` VALUES ('12', '021qSxGM0wYij32zf3HM0l0JGM0qSxGU', '8_4qAyl_RXB3CAfo_YEIfbq1Hn-kEp7jbyjftCRDBCzrlBEXdZt8N5_SmKWWYVu4TVmErK6x6RpwF4cDs_INL_gSiNMS9p-aA3rNIb7DLenfQ', 'oZHEd1Vj9nOAzC9F1WEuKRqzXqnQ', '2018-04-02 17:34:32');
INSERT INTO `code_token_openid` VALUES ('13', '001ohtHD1YZ9M30mz3JD1xwmHD1ohtHY', '8_aqqBHWuIv9RZR0U7k8ep5MIrMaRGz0aFqcxHL3_6OwndnTYJdlzHRq5hzf9Ixne8twgHmMzTbu8Qeq-VXtiQk1AO72MCiBfB-0uUPPjf4po', 'oZHEd1Vj9nOAzC9F1WEuKRqzXqnQ', '2018-04-02 17:35:46');
INSERT INTO `code_token_openid` VALUES ('14', '021OmNku1U9Q8d0ENzku1gdQku1OmNkk', '8_Xhd0Wiscgo6SrlGR_PzPkG5IzDme_PraYleQajzkjGVYJqyZss4ukatcizNLhw9WK_RQbrLJMwAGQWrP5Nt9v-7UF0b__tLr79yunz-7_II', 'oZHEd1Vj9nOAzC9F1WEuKRqzXqnQ', '2018-04-02 17:36:42');
INSERT INTO `code_token_openid` VALUES ('15', '0816wX3f0KM8nB1rbG3f0bBW3f06wX3F', '8_wKCT8U-voGtwiEP1bWU_qTterbnjab_51vJY7YQL-VRkMWp_IUAivxssatuEUbBbeI7_xQQT07hmOgixN8Zn-beuG4DU15uu-8vsxYQhSSQ', 'oZHEd1Vj9nOAzC9F1WEuKRqzXqnQ', '2018-04-02 17:37:46');
INSERT INTO `code_token_openid` VALUES ('16', '001d47Dy1GO40i0mDOAy18eiDy1d47Dk', '8_T1CdlFAAt90UPFI3RcUV-V5D_EiqNpjguwMDu9Yvuh4IRnIYJUuFPSzD5fMn8DxCqJxqB5lGskrFWq4Lv__sHmI72vlFKTQM99sAWxc3MFg', 'oZHEd1Vj9nOAzC9F1WEuKRqzXqnQ', '2018-04-02 17:40:46');
INSERT INTO `code_token_openid` VALUES ('17', '061z5jQ40czZjJ10fLP405VjQ40z5jQg', '8_3u-Q39gFhL6s6NCmk_IWenXHyI8B8NGBu2RyXKn14V4ytuPNJVv_ds9Fjo2zxT7EvWDf38amigPEJWCHAGLmLdA5h6aI5kvIJZOrlkXnoeQ', 'oZHEd1Vj9nOAzC9F1WEuKRqzXqnQ', '2018-04-02 17:41:41');
INSERT INTO `code_token_openid` VALUES ('18', '061NPBxI1Pih280wH7xI14rxxI1NPBx6', '8_AvUOWiDeFjYEw1QIJ4938kGXNvxeZeMjHrY6oDWAIBqzrVKnYLQjqjhB26xFxW-w7kW3L3p5yKi8FALe3T9l_EcZAn5HwuUG2-KLQWROjwg', 'oZHEd1Vj9nOAzC9F1WEuKRqzXqnQ', '2018-04-02 17:42:10');
INSERT INTO `code_token_openid` VALUES ('19', '071HI3fd2NkNKC0UMJhd2ntqfd2HI3fr', '8_H9K1gID5ZOkuecvSvFfNvFO-M6x6q9IxHlqCwi3D64nGsYbUaKfiGtC3P07vH4xzrKtBf_FLrm2i80bujdXX8mV0h0qNpvYW9jSJtK3E1c0', 'oZHEd1Vj9nOAzC9F1WEuKRqzXqnQ', '2018-04-02 17:43:37');
INSERT INTO `code_token_openid` VALUES ('20', '0815QzB91qPqBR1XXZC91HgNB915QzBR', '8_UdQo34EY1eCEXIceYYrKoQOX640051x8rYwfEALh2b1Uh7QvBj3xHXEOfanJNEu3T5CLVNoI1ZHb1oD7O3khfvxGGXILzoEI8rwxMqhBRag', 'oZHEd1Vj9nOAzC9F1WEuKRqzXqnQ', '2018-04-02 17:44:51');
INSERT INTO `code_token_openid` VALUES ('21', '061yPCKv0nLN2c1Ru2Nv04jkKv0yPCK0', '8_Ofa2T8RZbt5xg5NE8-mpFnDomRXHd6_tTSv6J8oTj1xqVBRZ18FsVtzPEW8JCRU67v4BUV3Gu89Ir90WrYfk-AJkXbQrxKutuOjNmqWTP_k', 'oZHEd1Vj9nOAzC9F1WEuKRqzXqnQ', '2018-04-02 17:48:08');
INSERT INTO `code_token_openid` VALUES ('22', '071rc6Bd2RjlOE0CmZDd2MJiBd2rc6Bq', '8_KwQWhSYo4kLrD0zsUg5O8DhJH2xFTDdZiyALSWbnBzWbieQTk4RKFrx1UuuRR_Euly36ZoJsrZgNne3y_ECDfFKNPG20lDZEU91t6sy2h8A', 'oZHEd1Vj9nOAzC9F1WEuKRqzXqnQ', '2018-04-02 17:49:02');
INSERT INTO `code_token_openid` VALUES ('23', '071Tr1Ai04yjIm1p6Uyi0ej7Ai0Tr1Am', '8_URolCnbVGm-7DkmKUx9P2nvUowgXFXR49VfrrRZGF3yL7sztueVS6SSBX1uQOCwj-qvz4V1NFLuiSaysiwbahNN-KphlYgS7eDUm6-1Bxrg', 'oZHEd1Vj9nOAzC9F1WEuKRqzXqnQ', '2018-04-02 17:49:27');
INSERT INTO `code_token_openid` VALUES ('24', '071RB6aa1JqN1R1UEd7a1JUsaa1RB6aQ', '8_zGTIFUznT-eHcDW8MhAAVwfb90uVgfmhIhbfwD4tjadqP9gO9HbiIYU9ismWX8VLcH6aB3gG2wwv2sRlPB8fs2cdtb8KnuUz_TtM8GrIbcY', 'oZHEd1Vj9nOAzC9F1WEuKRqzXqnQ', '2018-04-02 17:51:16');
INSERT INTO `code_token_openid` VALUES ('25', '001QNf630PNksC1gHC6303Qg630QNf69', '8_-y85NBoeKuTSFqLusjBaxcw0vdNozbYthXgjh317NEq0YR5wWNA3_3LFIALWAv4gwFWr0vDE6jbTa2s0mP70Axd1vZoGkCVuYsy_8bk14ps', 'oZHEd1Vj9nOAzC9F1WEuKRqzXqnQ', '2018-04-03 09:19:12');
INSERT INTO `code_token_openid` VALUES ('26', '081MHlm61qowUS1Iwrn61ehmm61MHlmM', '8_YgWT4DXe8k_p6RbOX96bf43wSQ_Lr9mmzdumxmJ9oFh8yEPNR5784kcPyBBIB1EtbkiLXv-LuxFI7rVItJOCeh7IhpbN2pplH019WJy-HhQ', 'oZHEd1Vj9nOAzC9F1WEuKRqzXqnQ', '2018-04-03 09:27:49');
INSERT INTO `code_token_openid` VALUES ('27', '071Vm2nN0jYE852fzHnN0LOJmN0Vm2nA', '8_AvUOWiDeFjYEw1QIJ4938tx_kgqlUOoPNxR8IvAemWiueId3VqRzofGGH9kqoGj6Mg4tb8FN3i4-a8Ol2IOJC9umcflUz-ks3gd8MGlEFi4', 'oZHEd1Vj9nOAzC9F1WEuKRqzXqnQ', '2018-04-06 17:29:10');
INSERT INTO `code_token_openid` VALUES ('28', '081e1hlQ033cH82055jQ0TVVkQ0e1hlS', '8_c9Tnxo1eCKIncbeno9iWCx3sPa9wmmF6tUfi7WUrZSg9JIdCyUty45d8W286wbSqJcgkv4MFsU--oudT-GKLi2v07CSC4iHEPrwlAJo9n3c', 'oZHEd1Vj9nOAzC9F1WEuKRqzXqnQ', '2018-04-06 17:29:33');
INSERT INTO `code_token_openid` VALUES ('29', '021E8FBd0P5jeu1lx3Cd0ZnSBd0E8FBm', '8_F5for_bheocsjBOX8QBuRN4KRJzPnjtez9ckEM3_AGmetITuoN5neMujG1A01u0u_wQwJwkJTGmgHdjXkkRtB9Is90cbP6-hNC3Oq_X3KsI', 'oZHEd1Vj9nOAzC9F1WEuKRqzXqnQ', '2018-04-06 17:31:13');
INSERT INTO `code_token_openid` VALUES ('30', '081iiGtF0IBFpj2uVcsF01wLtF0iiGtZ', '8_HgQFztuBsrYpLqVRVqO3jCVUPrsx92hx6U4CEXeoPSSWQBFTBAfCAXrWTayeukocx_Qw-zooN3VFnGO0qCjwy3Qm0CzMvx_JlNOKs67Jwt8', 'oZHEd1Vj9nOAzC9F1WEuKRqzXqnQ', '2018-04-06 17:39:29');

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
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of employee
-- ----------------------------
INSERT INTO `employee` VALUES ('1', '刘师傅', '123', 'f', '12', '', '', null, '2018-03-06 00:07:44');
INSERT INTO `employee` VALUES ('2', '王师傅', '123', 'm', '123', '', '', null, '2018-03-06 00:08:08');

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
INSERT INTO `location` VALUES ('0', '广东肇庆营业厅');
INSERT INTO `location` VALUES ('1', '广东肇庆端州分部');
INSERT INTO `location` VALUES ('2', '广东肇庆中转部');
INSERT INTO `location` VALUES ('3', '广东广州中转部');
INSERT INTO `location` VALUES ('4', '广东广州分部');
INSERT INTO `location` VALUES ('5', '广东广州营业厅');

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
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of status
-- ----------------------------
INSERT INTO `status` VALUES ('1', '已收入');
INSERT INTO `status` VALUES ('2', '已揽件');
INSERT INTO `status` VALUES ('3', '运输中');
INSERT INTO `status` VALUES ('4', '派送中');
INSERT INTO `status` VALUES ('5', '已签收');

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
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES ('1', '123', 'm', '123', '123', null, '123123', 'oZHEd1Vj9nOAzC9F1WEuKRqzXqnQ', null, null, null);
INSERT INTO `user` VALUES ('2', 'aaa', 'f', 'scartlet', 'aaa', null, '12312312300', '', null, '2018-03-05 22:23:41', '2018-02-28 22:23:44');
INSERT INTO `user` VALUES ('5', '3', 'm', '', '', '', '', '', '', null, '2018-03-07 11:29:39');
INSERT INTO `user` VALUES ('6', '333', null, null, '333', null, null, null, null, null, '2018-03-26 23:43:56');
INSERT INTO `user` VALUES ('7', '999', 'm', '', '999', '', '', 'oZHEd1Vj9nOAzC9F1WEuKRqzXqnQ', '', null, '2018-04-06 17:32:57');

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
INSERT INTO `waybill` VALUES ('1', null, '1', '1', null, null, null, '1', '1', null, null, '1', null, null, null, '1', '1', '1', null, null, null, null, null, null, null, null, '1', null, null, null, null, null, null, null, '2018-03-07 11:05:47');
INSERT INTO `waybill` VALUES ('2', null, '2', 'qqq', '', null, '', '', '', '', '', '', '', null, '', '', '', '', null, null, '', null, null, null, null, null, null, null, null, '', '', '', '', '', '2018-03-07 11:28:27');
INSERT INTO `waybill` VALUES ('10010', null, '7', '李小姐', null, '2018-04-06 22:23:44', null, '广州番禺', '15521608979', null, null, '梁先生', null, null, null, '广州天河', '15521608979', '王师傅', null, null, null, null, null, null, null, null, '20', null, null, null, null, null, null, null, '2018-04-06 17:35:44');
INSERT INTO `waybill` VALUES ('10001111', null, null, '啊啊', null, '2018-03-07 11:29:39', null, '啊啊', '123123', null, null, '啊啊', null, null, null, '啊啊', '123123', '啊啊', null, null, null, null, null, null, null, null, '10', null, null, null, null, null, null, null, '2018-04-06 17:45:41');

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
) ENGINE=InnoDB AUTO_INCREMENT=32 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of waybill_status
-- ----------------------------
INSERT INTO `waybill_status` VALUES ('1', '1', '1', '1', '2018-03-07 12:11:27', '1', '2018-03-07 12:11:37');
INSERT INTO `waybill_status` VALUES ('2', '1', '2', '2', '2018-03-06 12:11:53', '123', '2018-03-06 12:11:57');
INSERT INTO `waybill_status` VALUES ('3', '2', '1', '1', '2018-03-05 12:18:25', '123', '2018-03-20 12:18:30');
INSERT INTO `waybill_status` VALUES ('4', '1', '1', '3', '2018-03-04 12:18:45', '123', '2018-03-05 12:18:50');
INSERT INTO `waybill_status` VALUES ('20', '1', '1', '1', '2018-03-25 16:11:40', '1', '2018-03-25 16:11:40');
INSERT INTO `waybill_status` VALUES ('27', '1', '3', '0', '2018-04-02 18:32:07', '2', '2018-04-02 18:39:21');
INSERT INTO `waybill_status` VALUES ('28', '1', '4', '2', '2018-04-03 11:05:47', '2', '2018-04-03 09:32:16');
INSERT INTO `waybill_status` VALUES ('29', '10010', '2', '0', '2018-04-06 22:23:44', '1', '2018-04-06 17:36:53');
INSERT INTO `waybill_status` VALUES ('30', '10010', '2', '3', '2018-03-07 11:29:39', '2', '2018-04-06 17:37:53');
INSERT INTO `waybill_status` VALUES ('31', '10010', '2', '1', '2018-03-07 11:29:39', '2', '2018-04-06 17:40:58');

-- ----------------------------
-- Table structure for wechat_token
-- ----------------------------
DROP TABLE IF EXISTS `wechat_token`;
CREATE TABLE `wechat_token` (
  `id` bigint(255) NOT NULL AUTO_INCREMENT,
  `code` varchar(255) DEFAULT NULL COMMENT '微信code',
  `token` varchar(255) DEFAULT NULL COMMENT '微信token 有两种token 一种是从微信服务器获取的用于验证的access_token 两个小时过期 另外一种是微信用户授权登录的网页的access_token 只能使用一次 未使用的话5分钟过期',
  `openid` varchar(255) DEFAULT NULL COMMENT '微信用户openid',
  `create_time` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=68 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of wechat_token
-- ----------------------------
INSERT INTO `wechat_token` VALUES ('12', null, '7_oueGiW66TwZIArKy2SPE7toPsjmyNkxggpEu9U8sVTDm91CcTJrR_fMpz_yJbf9qgf8I3zA12KEkgxL6sYMUAvTESZTcOtBMV_UHZ3yj5CQw2Nh5TQC7eA1uPeoDFDbAHARTR', null, '2018-03-03 20:02:00');
INSERT INTO `wechat_token` VALUES ('13', null, '7_LR9TniRrP5FP8d2ZfDxgAlvPhPmv6nnPnI7pO-Mnz-nWAun83smGFWyHFJWF3nZVZcNQTW_bhFIE1ZEYkEtBzwZ7z_5K_7GoKcYdKBT9DvhFGDP8wbPMlabVb4kMBTnpPxiH9A8y9jpZs3pOZPSaAHAUKN', null, '2018-03-03 22:11:00');
INSERT INTO `wechat_token` VALUES ('14', null, '7_S3xumrf7nfCTKDA2fDxgAlvPhPmv6nnPnI7pO-Mnz-nWAun83smGFWyHFJU2rr0Rh7Qqz6eUa_HrkkwW2574H7TfrTGIBvJGK535CRcnMz6RUTGAyWpxqkW8BQ-wi_fH9U23W_gra_8EGarsVVLaAHAQQG', null, '2018-03-03 22:11:01');
INSERT INTO `wechat_token` VALUES ('15', null, '7_Xe7_m_YDmGYxERpTMT5UnfY1UwuyDL_B70NnQWfkhlXG6zC8fAyIO9Du9lf_01YUcaDtzaSHxurJBsvs4616WLri2Fz8R38b6PaXChR2PpEcEaVbaEM0LWTwygwhQhNSsTipe4izIJq9Zs27VXKeAJAOQD', null, '2018-03-04 01:15:01');
INSERT INTO `wechat_token` VALUES ('16', null, '7_ii-S4lUE7hbjjYKRbsNKjMG-yabqYmcemiN68kWhIV7viuzcjKApDbZhVblfM2yovcN9hkJcDWESj0xhRBCwurRByu4UqOspocRKgDyO2-spCeZlBxCK4xoXzTJe1bEx5Xj7JqM0lWAvgMaBPMHgACAGDY', null, '2018-03-04 12:31:00');
INSERT INTO `wechat_token` VALUES ('17', null, '7_wC_XRWFYj5jH3TDeSPQJRT9pdLShCBFs_O5yG9bIbx5L7LAUE483gZndWkIJfnevMT1IJoWyxGepUi7PRoIzkcrhZN-AZ9Ivr7xR4_bU7-uUrTK4XJlx46GQBf_twsHPdVDLaYwCcJYtNJ7VIQEbAHABJX', null, '2018-03-04 15:00:01');
INSERT INTO `wechat_token` VALUES ('18', null, '7_Zvuz9O_R4fADfMMgNdnRPeuqSdWOwYeCpKhL3KtohUHdvzXwxRgmxFNSq7vw2LAaAAnCmwhosfVDCilEP2Ov6VnyNqBnV2O3nxmYk63b7WEnVo2ytrKcK7WtvUszEEoIot3wbIyPGuR9-ETeXIFbAIAJUR', null, '2018-03-04 17:41:10');
INSERT INTO `wechat_token` VALUES ('19', null, '7_HH0tbc8Z26K7OwPuhrlvGQvDFkKXS_wZwHmzQN2fSEuAFoZenlulTHSAGSKnm2Xj3vAhDHsZ6ErC_taE-KjQCY_RI7QB6Aiz_4PfOd869oMSLATh9dh-kb_LwsZPT6FqkEfwDAQ1OETrJvj2FBIbAJAJFM', null, '2018-03-04 20:00:02');
INSERT INTO `wechat_token` VALUES ('20', null, '7_DPW-_O2w0t3kyFtm3sk7LM6SUpEffEVBVPvwUsmcG9sSR2blsu8CPoYYq2WlcwsNJs546eFG0f5CDKS_Ja5rhDQQF_cho2I6eFp49SAMe2uFmVYvWCvx-iZJYBhIcfSVhRrzimGdRQIxL3QwYLIhAHASFC', null, '2018-03-04 22:00:01');
INSERT INTO `wechat_token` VALUES ('21', null, '7_-mdbOCt_Il42SgHzhJ2tHi8ZFVbwcAJv8k_U5HaybES4eCWm2KF25IJh1a0YRP828IOY7Cq6_GOe087Bhun1ETr_CdUXZ2SlwT8w0VlfXgTxHWaRe8cpbyUWf6vhPk0NxojpzqMp8xwNGMEJYMNhAJALZA', null, '2018-03-05 21:06:21');
INSERT INTO `wechat_token` VALUES ('22', null, '7_GP-SdXTpMHG-tGWLa4DYNMPA2Lc7zPoC01Ih16G18t40gWYzcd9L1Br6tiVFPdvX8oHFUgHDIZfLvsSC1gB5SWZsD42lYte9w7OHG74gD9xZFaqis75iseNK7v2Dz95jGmICOgIbVVyTqqGiLQLcAIADID', null, '2018-03-05 22:37:39');
INSERT INTO `wechat_token` VALUES ('23', null, '7_1I7Wb2c3bTpz4oXrCWKQ1pN8ZFZ1Acs_VtsfqgeGvFJSeekvzWXOFLLPBWA6hBWGmWyRb5z2-Z2Q8hy_yY0GTTmmjTHoFipMAtf7InGAUSaawyJ_DQq4VT5xjlN1MnBh9DSSPTcoPJTmNHKbYBVcAFASVP', null, '2018-03-06 00:15:25');
INSERT INTO `wechat_token` VALUES ('24', null, '7_M5iO2S6PKJjfkDmiyKwkh4zqRNSKxo5Y7qkMrDXZ4cR2IbJqGqiAXPHBrbK-FfukczSulH34GWcrZHftgPZM0PtvWKsIDqkvxnv57M8nR7dWh03VDsasibcYjk2yyepAJbz1S6do31YBmxl_LLKjACAZZY', null, '2018-03-10 11:51:21');
INSERT INTO `wechat_token` VALUES ('25', null, '7_D5wc4aFSkms1a46HcScFUuczcl4u1ubPssU0vozrz416LCJo9MPhWsRdM1uqhZBGKDzzXMjK3pgMmovo7_PQaZ4x6aqUP75kyOjRU-CNODmFcqMKrLmsg0h1NWH0a1Z2-uknsTBF5O0TQRb4NXNbAFASCS', null, '2018-03-10 14:00:00');
INSERT INTO `wechat_token` VALUES ('26', null, '7_RT7mL01rkdWp-vglNA50pUMyJgxHXyyzMJ8LSwajXK3SdE7ZxhkGKZYUmVrcMJty1ojZHEpadJDhcK_KdTVK1caxITH_kjjQf1XYPJloTkCxy41MaYOXsCnqxoqKJb1nsTmcDfXI3m4tmduGSRScADAZYZ', null, '2018-03-10 16:00:00');
INSERT INTO `wechat_token` VALUES ('27', null, '7_SeP8dNbUIvFB73xNNA50pUMyJgxHXyyzMJ8LS4RL-koSGAfsVIzrWZcGvAOoPxwV5Y5PuZg8-2cmVptyvSOypzR48KOgC2AfkAaK9PFrUPuc_HxCztDTfGFyCsnSylMKzQz03QN2M4gn2A-VKLLeAAAABB', null, '2018-03-10 17:30:59');
INSERT INTO `wechat_token` VALUES ('28', null, '7_op78hveYRiVASkUhdTrSvF-hZwtv98dO6z0k33pEJbh1ckFmP8XTV6zrd4iwsn0O8ecGinVfek-ZXxlWvmfGcwNOfcGxr6Udq6KO-e-YJf8iSghjUA2zJvc9wpsPZHdAGAZJR', null, '2018-03-10 20:04:11');
INSERT INTO `wechat_token` VALUES ('29', null, '7_-3RYRaEsuf5Y5tGIOL2ohiLb_5Mb595RQJ_QAPBR-xW0Qr1u4Wzb1Zba7yES2EqHoBLSoMNPUIlGRvuZMxX3RSI2wx3ziNzDJpAysiSZ06sb1oDjDPuA7JcW7fayrffma7BoPJvsdAeztga1NUGaABAIPB', null, '2018-03-10 22:01:02');
INSERT INTO `wechat_token` VALUES ('38', null, '7_NpYMvKqJhTGea3uwOZZTx__2XWQ_875ejmLluI2u3Syc4IsE8zdUAlMVydcN2BMpkZ1xZaI00CZtV5lHdORhAocsSnbqSG9SvDrJq5ZFemu3tm77KL40u8_rwD4NROhABAFJG', null, '2018-03-11 00:55:37');
INSERT INTO `wechat_token` VALUES ('40', null, '7_l4on9eEtC9rqA0O10xLrAN75pi1irt13j0UGRskdPouB-WwTwY4L5f_BfYZcbZszzcY8H-8jR10UKxfPFc51cwNv1uITs63sXuLZwKFwKc2RpDLkl4GVW39HS6gSth40bGbWSfyFBVQAqy9_GPBiAEAXGS', null, '2018-03-11 19:54:53');
INSERT INTO `wechat_token` VALUES ('41', null, '7_VNiooc2Ekmd_YqN4BXQOSTsdVWLS5Oxtf_i-DcfxvKzB5_NgfRRpN2y6hQClDblLPUFCCjsx1ohwwFP9kCoJgxaITF-pd7Cukm4nm3Mj8uQHyFygE5ajGpszmKYKBWjAHAEVQ', null, '2018-03-11 22:00:01');
INSERT INTO `wechat_token` VALUES ('42', null, '7_IQ47f5CZHOfYpcc-jhOaDazt-jt_Uzr4iVwi48l1Lf8EtU7DflLgbBrQv1wz7bfJ__FjbDhY3TaSToL0_n3aZ9t-e6lOSJ5xROZvpGe4Wthsaon-Qb11SHnGI1cCWHhAGAMGR', null, '2018-03-12 00:00:02');
INSERT INTO `wechat_token` VALUES ('43', null, '8_GRgzbvl2jkK2HSNd0Q-Qyy1q0OftgWX8JXk5qkavNMRYrNXcdXFc_qQpN1LyX8eM_mXhXIdx58ZodyzPNu_Xq1X4kKrhCY1AcO24O8zQVYHv7XAcuKWg7uzJdikPLNiAEATPR', null, '2018-03-25 12:24:58');
INSERT INTO `wechat_token` VALUES ('44', null, '8_pCWXcYhLIWgQSnnRh96UkgjYFNXQLxM5WOFnwC37G0890c0OlQUOCwzitUyiuVMeeNbZOohoFBfSAv5NFbSmjYo2gLgbdjfewU7wFk5pHgvhE1LtcQ66_Ed8YWDc7lDL05KFxNvOMoQdFd7FYRGcACASLA', null, '2018-03-25 14:00:02');
INSERT INTO `wechat_token` VALUES ('45', null, '8_Dn55jwF57yKs93y-oAhaXU9TSG743NNsYIF0sQH9TFT0e4Cy4uEcm83sFTdOKbTrICjRzlwqW1fPw6QxriEf3MtZxvN_J9xESqAtuNmxpf2u7AIxR-zxQruZ5Dug1z1TmI3gitQBvkZFeyOFAQCiAIAUKW', null, '2018-03-25 15:37:05');
INSERT INTO `wechat_token` VALUES ('46', null, '8_9GmlhewR-zWHwmJ4juJXJuLlDPrBytkqrGn9yZ-ZP6p4rbmCpletZtjR8NGajBQmmGdYBUn6ncRv7ioSWE8TL3Wp4IxKtbji4bgvGWc_GgfB21LtYN2MSBHeMuD7ascR2-rh-_yYS_o4G_D2MDWeAAAXOH', null, '2018-03-25 18:00:00');
INSERT INTO `wechat_token` VALUES ('47', null, '8_35co2lKwoAk8n55MWNIZCbeCJwiYZDphgJQlVv-6HsOCr3PvHZkhXLn6ic9y8X2KrDbHwAM0k-r6t166xrWf-iQ1kyM8ugZU6vLEe4827WpZrOcuDnVOcPl3Kfp8T1u_NXxpEIZ-2jpctPyWSZDeAFAZGK', null, '2018-03-25 20:01:46');
INSERT INTO `wechat_token` VALUES ('48', null, '8_VPWmw4C0m_UkcQGAdNAP6Phrhf1nnuo8jeAoaOicAGaXwOnMSJ7EPR2CM5VXNE2OKxOhod9ZT6yBGNY_dNrTnMhT6GzQ_axwtVw1WB1wx_ZYPHltSOf-vYlpxX4i4NiV1S_P_HJ4yeZgrHJBBYBaADASPS', null, '2018-03-26 14:52:27');
INSERT INTO `wechat_token` VALUES ('49', null, '8_JpbMiSyaFAKjQLGouGAeQnQec1NTnH_IdvsQoiQmpdv9KuifWWwLEt19-tnVyI3UzCEe0sLqhQC7DSUWQD5iAoZr-zStJp3Exvr5700uosjcpxsAEaMo_bFlSlrkkO4E3-WhGqYHyLkWuzp2CIEdACARXT', null, '2018-03-26 16:56:08');
INSERT INTO `wechat_token` VALUES ('50', null, '8_OLxDIzfmehj4-jGTafrg0WOs0Q-ig-pXCyx7buSJ2xfSGJ8Yn9erQegOqBjtIkq4yDNo1umMXN40sJ3DTPrbz7n-jfaiwel61fqgniKBrcJ-TKuHZChl81ywjSHZnJN4JQ8ihGOn-8nmJJcpYODeAHALBQ', null, '2018-03-26 22:28:08');
INSERT INTO `wechat_token` VALUES ('51', null, '8_NkrQi26zIIFK0Nlu9ofDf-HbS_roW2PXE9e5JEoIgfMDrIaWutuErDWYlf94z6jRUGP7A9PvEz904o2CLXr5lTIZxO5t2WUI07i3baBpTWRyWkFzRVFvqDduXycLSxjZMfuF49FuSZwSpLoNAUJhAJATNC', null, '2018-03-27 00:00:02');
INSERT INTO `wechat_token` VALUES ('52', null, '8_z_lppS5V41p8vS3eBQCUL7TXojxb9-CvwjxBgjBNrUE3jlNxF8e73KXgEzNXNhJJye1YMwt0AetQCgUK5Uh9HQPXkwWuT9Vm5uqefT43srbBHCW757yLX3fcOcQTTFeAIAKKW', null, '2018-04-01 20:30:42');
INSERT INTO `wechat_token` VALUES ('53', null, '8_4PIc7cHXSdIy1tcHHsqpNAynZa6semWzDiFXd5ymcRpaRDj_Ubiqr5L1ZjZGVaLDv3nfnGDCpl1IMZA6ky5uPZFNKm4evr1yEeO9yPT9c8lpFs24zngnaCJrZ7mgjlBypCmAs6vjDou5UgHVAQHcAAALBS', null, '2018-04-01 22:44:39');
INSERT INTO `wechat_token` VALUES ('54', null, '8_LrjKZr_I6bvruq_osFvMM-vEJtW3T_7qQmQTBiAkrM4ogjLf2ywZdi08ckBx6Z4q3FCJrjOzqZz4XcQyQsPPRbCnTHMm8WR0g2aZwUYzackqr4JKGrrq1XbAPyvrPLyteeqzN4AV_LiTS9IlLRMjAEAFLG', null, '2018-04-02 01:00:01');
INSERT INTO `wechat_token` VALUES ('55', null, '8_VVKnFx_hjq41PFBn1bPhgJh5JOOogy7ZTLSct7t6lZl4e098waV174BjP7RtEFrLqxeDkFDmN5Kfq1FkQfyQhkiCFQPMWP9zI08KNBt4155OhLqo5HW784gEqb8Fu6uFGKl3CrWxei6wtd6pVJCfACAOCV', null, '2018-04-02 11:53:16');
INSERT INTO `wechat_token` VALUES ('56', null, '8_vNAcZcyt24AEk48YCq7Vtb5hgjCUg6hgZRjxaP0VnKgBVkaRXxdCkMeRiiZfzfqqZHUw0Om-NsVuiQPdO0bwteJteOV8XkdAJibJEf5y1xAKZIy61RUu6ORezNFL-yOu8vaUHKFPGdc2frhIZXZfAAADBD', null, '2018-04-02 14:00:01');
INSERT INTO `wechat_token` VALUES ('57', null, '8_WmDAADUy4ZsjGqBbuGAeQnQec1NTnH_IdvsQor6x78DHzcAT6Rgom3K6ps_2RXCx8mBm9jMTsZyRArCZca56_Gu8R6pj1p4vcCfnOBrQWyJ0rp3CA0B4MfVoHY60PYpeP7KV2w3t1HagaFxWZVYhAIAUQT', null, '2018-04-02 16:00:01');
INSERT INTO `wechat_token` VALUES ('58', null, '8_S-g5tWfwgtrs1z5DuGAeQnQec1NTnH_IdvsQouX3WD3YFss8SyodRC7hEBScIDhvVANApf5YfAZ1bUMLm-AvHh9tkGxo5-G_vL1VqVTa4z7Or7k6slxjjLXd9kpfuvMVl6HU924lNSNAXNJRVIFbAHADQN', null, '2018-04-02 17:34:30');
INSERT INTO `wechat_token` VALUES ('59', null, '8_389F1FXjlBtfyCgc_DSCzTKI4Ff_6hbxgmBevcHddoXy8YDQlGMcFlsaIYsmKqdIpwfRnOJtHuojnJpyW7m8j1d-vtj1Ha0UmU2_0mcAR5ItlhhDs8CzKNiPiBdHs4wbf2by1Q0f1UD7kSieELUeADAKRA', null, '2018-04-03 09:15:07');
INSERT INTO `wechat_token` VALUES ('60', null, '8_QVvd-SDpkaKGyoBA0Q-Qyy1q0OftgWX8JXk5qjhYcia-2qLf2MmSdGieK-Lpywj7d0ZNJ2vYmrlsXpuFuzrZYt2JPJx0HG7xwZgdWnblZ7RokE-sxFs7CaV1ss8VUQcAFAZYU', null, '2018-04-03 11:00:01');
INSERT INTO `wechat_token` VALUES ('61', null, '8_ojBF8-o0TbUnF56A7s8PRuccVbaBtMkGXy0YKPfM3oZU929nBijQnuzteYkXTM9SjCxhZAGkicpKb4QVsyi5oFXZ6d_3X2z5dL-BBmOXQDz3_EgRIH4e7NpWKpFJh5b-RZy_TmXwOdIKZQSWRKJaABAUNM', null, '2018-04-03 13:00:01');
INSERT INTO `wechat_token` VALUES ('62', null, '8_vYiIkj87NVX5Kkn66Wj2jNJStWTlxWr5HquRiSUb1youVPTXHpURi2lfKPaWC_i1XVZ0qa3Ml4T0IwkxuBATfROz3xgjkYLypPu9qDYapwDBJb3vr87BPIt8vPbOF4XUfUdt70v4nPCz2OosWOUbAFAQIO', null, '2018-04-03 15:00:01');
INSERT INTO `wechat_token` VALUES ('63', null, '8_F4pe7wTgDCpAo_qH0IU_H_RnxYjx_CZpbWxrinoV2gnhWs3Bawf2Tkf7wOGfW1NDa-pMeNFezjyowBF2rgBLJdr1Q0whyCXJN5ljDZoMSU2i75aKyu0YU7P9jPeytdpuuLT3cVCQaMzsXM4XGDChAFAURQ', null, '2018-04-03 17:00:01');
INSERT INTO `wechat_token` VALUES ('64', null, '8_HFtBrWas6Hg0bLpotDsElaog4bPfkSteP419LoKT87U4vIVtVdYeNuCytDKK4uOf_7paWiqpDSwtguM4JxQJdjf0WKlroV494qAygmAbn8I2yCNxP0IOhWtKudWHHqGQqY42z3N2KUr_kqbQUGHgAEAQCD', null, '2018-04-03 19:00:01');
INSERT INTO `wechat_token` VALUES ('65', null, '8_ks7X9tD5j43qNCT5Cq7Vtb5hgjCUg6hgZRjxaKBWA0rZv5iSfFG0eTdVclvky-uqR14vzY_2wBWOCa-sYXV2OzjHhVklvnWAf16tsyRuURVq5A_DlhoRfXIXGIALBZhAHAHXV', null, '2018-04-03 21:00:01');
INSERT INTO `wechat_token` VALUES ('66', null, '8_7KBn-Cmjz_hvH1QEayVyLUQC6VOiDAZ0ZbZI3kRPSfdg36iGgveFB_nQoVvdhgQp1zkRu9vMf1iwd4_S7bv71ogkJXCord20Pk_Y0Hu2HD86Qorhl9mtdcZaSuD72oVs5TYNffncnBhiq3nQHMXgABAZEP', null, '2018-04-04 21:29:39');
INSERT INTO `wechat_token` VALUES ('67', null, '8_upiQ0sqCsswZTzOstRur9Y0gPXCt71gYNDEAk6sIZdusxZWwKBg62fyiSIKN6ECrlt5R6nHrHX9DkscnkSg8X-L_lCpIhQG0VCrso_VfcT7htGe7YCUwxlFbTcvmSoBBvcEfxSlnMSTPolXHFZObAGAUOD', null, '2018-04-06 17:28:50');
