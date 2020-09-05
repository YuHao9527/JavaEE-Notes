/*
Navicat MySQL Data Transfer

Source Server         : demo1
Source Server Version : 50536
Source Host           : localhost:3306
Source Database       : myfirstdb

Target Server Type    : MYSQL
Target Server Version : 50536
File Encoding         : 65001

Date: 2020-08-18 12:02:41
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `grade`
-- ----------------------------
DROP TABLE IF EXISTS `grade`;
CREATE TABLE `grade` (
  `gradeid` int(11) NOT NULL,
  `gname` varchar(5) DEFAULT NULL,
  PRIMARY KEY (`gradeid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of grade
-- ----------------------------
INSERT INTO `grade` VALUES ('1', '一年级');
INSERT INTO `grade` VALUES ('2', '二年级');
INSERT INTO `grade` VALUES ('3', '三年级');

-- ----------------------------
-- Table structure for `husband`
-- ----------------------------
DROP TABLE IF EXISTS `husband`;
CREATE TABLE `husband` (
  `husid` int(11) NOT NULL,
  `husname` varchar(5) DEFAULT NULL,
  `wid` int(11) DEFAULT NULL,
  PRIMARY KEY (`husid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of husband
-- ----------------------------
INSERT INTO `husband` VALUES ('1', 'baby', '1');
INSERT INTO `husband` VALUES ('2', '孙俪', '2');

-- ----------------------------
-- Table structure for `menu`
-- ----------------------------
DROP TABLE IF EXISTS `menu`;
CREATE TABLE `menu` (
  `menuid` int(11) NOT NULL,
  `menuname` varchar(10) DEFAULT NULL,
  PRIMARY KEY (`menuid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of menu
-- ----------------------------
INSERT INTO `menu` VALUES ('1', '用户管理');
INSERT INTO `menu` VALUES ('2', '菜单管理');
INSERT INTO `menu` VALUES ('3', '角色管理');

-- ----------------------------
-- Table structure for `middle`
-- ----------------------------
DROP TABLE IF EXISTS `middle`;
CREATE TABLE `middle` (
  `middleid` int(11) NOT NULL,
  `mid` int(11) DEFAULT NULL,
  `rid` int(11) DEFAULT NULL,
  PRIMARY KEY (`middleid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of middle
-- ----------------------------
INSERT INTO `middle` VALUES ('1', '1', '1');
INSERT INTO `middle` VALUES ('2', '2', '1');
INSERT INTO `middle` VALUES ('3', '3', '1');
INSERT INTO `middle` VALUES ('4', '1', '2');
INSERT INTO `middle` VALUES ('5', '2', '2');
INSERT INTO `middle` VALUES ('6', '1', '3');

-- ----------------------------
-- Table structure for `role`
-- ----------------------------
DROP TABLE IF EXISTS `role`;
CREATE TABLE `role` (
  `roleid` int(11) NOT NULL,
  `rolename` varchar(10) DEFAULT NULL,
  PRIMARY KEY (`roleid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of role
-- ----------------------------
INSERT INTO `role` VALUES ('1', '超级管理员');
INSERT INTO `role` VALUES ('2', '管理员');
INSERT INTO `role` VALUES ('3', '总经理');

-- ----------------------------
-- Table structure for `student`
-- ----------------------------
DROP TABLE IF EXISTS `student`;
CREATE TABLE `student` (
  `stuid` int(11) NOT NULL,
  `stuname` varchar(5) DEFAULT NULL,
  `stuage` int(11) DEFAULT NULL,
  `gid` int(11) DEFAULT NULL,
  PRIMARY KEY (`stuid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of student
-- ----------------------------
INSERT INTO `student` VALUES ('1', '张三', '18', '1');
INSERT INTO `student` VALUES ('2', '李四', '14', '2');
INSERT INTO `student` VALUES ('3', '富贵', '13', '3');
INSERT INTO `student` VALUES ('4', '王芳', '17', '1');
INSERT INTO `student` VALUES ('5', '甜甜', '15', '2');

-- ----------------------------
-- Table structure for `users`
-- ----------------------------
DROP TABLE IF EXISTS `users`;
CREATE TABLE `users` (
  `usid` int(11) DEFAULT NULL,
  `username` varchar(10) DEFAULT NULL,
  `password` varchar(10) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of users
-- ----------------------------
INSERT INTO `users` VALUES ('1', 'admin', '111');
INSERT INTO `users` VALUES ('2', 'zhangsan', '111');
INSERT INTO `users` VALUES ('3', 'lisi', '111');

-- ----------------------------
-- Table structure for `wife`
-- ----------------------------
DROP TABLE IF EXISTS `wife`;
CREATE TABLE `wife` (
  `wifeid` int(11) NOT NULL,
  `wifename` varchar(5) DEFAULT NULL,
  PRIMARY KEY (`wifeid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of wife
-- ----------------------------
INSERT INTO `wife` VALUES ('1', '黄晓明');
INSERT INTO `wife` VALUES ('2', '邓超');
