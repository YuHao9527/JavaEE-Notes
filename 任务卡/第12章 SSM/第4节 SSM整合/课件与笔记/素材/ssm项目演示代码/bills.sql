/*
Navicat MySQL Data Transfer

Source Server         : localhost_3306
Source Server Version : 50722
Source Host           : localhost:3306
Source Database       : mytest

Target Server Type    : MYSQL
Target Server Version : 50722
File Encoding         : 65001

Date: 2020-06-11 19:45:57
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `bills`
-- ----------------------------
DROP TABLE IF EXISTS `bills`;
CREATE TABLE `bills` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `title` varchar(50) DEFAULT NULL,
  `billtime` date DEFAULT NULL,
  `typeid` int(11) DEFAULT NULL,
  `price` double DEFAULT NULL,
  `explains` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of bills
-- ----------------------------
INSERT INTO `bills` VALUES ('2', '快递费2', '2000-02-01', '1', '11', '邮寄快递费用');
INSERT INTO `bills` VALUES ('3', '快递费3', '2000-03-01', '1', '22', '邮寄快递费用');
INSERT INTO `bills` VALUES ('4', '快递费4', '2000-04-01', '2', '33', '邮寄快递费用');
INSERT INTO `bills` VALUES ('5', '快递费5', '2000-05-01', '2', '44', '邮寄快递费用');
INSERT INTO `bills` VALUES ('6', '快递费6', '2000-06-01', '3', '55', '邮寄快递费用');
INSERT INTO `bills` VALUES ('7', '快递费7', '2000-07-01', '3', '66', '邮寄快递费用');
INSERT INTO `bills` VALUES ('8', '快递费8', '2000-08-01', '4', '77', '邮寄快递费用');

-- ----------------------------
-- Table structure for `billtype`
-- ----------------------------
DROP TABLE IF EXISTS `billtype`;
CREATE TABLE `billtype` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `bname` varchar(5) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of billtype
-- ----------------------------
INSERT INTO `billtype` VALUES ('1', '支出');
INSERT INTO `billtype` VALUES ('2', '收入');
INSERT INTO `billtype` VALUES ('3', '转账');
INSERT INTO `billtype` VALUES ('4', '借出');
INSERT INTO `billtype` VALUES ('5', '借入');
INSERT INTO `billtype` VALUES ('6', '还入');
INSERT INTO `billtype` VALUES ('7', '还出');
