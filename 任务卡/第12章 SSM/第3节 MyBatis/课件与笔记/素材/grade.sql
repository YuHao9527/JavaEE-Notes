/*
Navicat MySQL Data Transfer

Source Server         : localhost_3306
Source Server Version : 50722
Source Host           : localhost:3306
Source Database       : mytest

Target Server Type    : MYSQL
Target Server Version : 50722
File Encoding         : 65001

Date: 2020-06-10 11:49:21
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `grade`
-- ----------------------------
DROP TABLE IF EXISTS `grade`;
CREATE TABLE `grade` (
  `gid` int(11) NOT NULL AUTO_INCREMENT,
  `gname` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`gid`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

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
  `husid` int(11) NOT NULL AUTO_INCREMENT,
  `husname` varchar(20) DEFAULT NULL,
  `wid` int(11) DEFAULT NULL,
  PRIMARY KEY (`husid`),
  UNIQUE KEY `uq_husband_wid` (`wid`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of husband
-- ----------------------------
INSERT INTO `husband` VALUES ('1', '张杰', '1');

-- ----------------------------
-- Table structure for `menu`
-- ----------------------------
DROP TABLE IF EXISTS `menu`;
CREATE TABLE `menu` (
  `menuid` int(11) NOT NULL AUTO_INCREMENT,
  `menuname` varchar(255) DEFAULT NULL,
  `upmenuid` int(11) DEFAULT NULL,
  `menupath` varchar(255) DEFAULT NULL,
  `menustate` int(11) DEFAULT NULL,
  `menuremark` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`menuid`)
) ENGINE=InnoDB AUTO_INCREMENT=119 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of menu
-- ----------------------------
INSERT INTO `menu` VALUES ('28', '个人中心', '-1', null, '1', null);
INSERT INTO `menu` VALUES ('29', '教务中心', '-1', null, '1', null);
INSERT INTO `menu` VALUES ('30', '学员中心', '-1', null, '1', null);
INSERT INTO `menu` VALUES ('31', '学习中心', '-1', null, '1', null);
INSERT INTO `menu` VALUES ('32', '资料管理', '-1', null, '1', null);
INSERT INTO `menu` VALUES ('33', '权限管理', '-1', null, '1', null);
INSERT INTO `menu` VALUES ('34', '我的资料', '28', 'user/MyUser.jsp', '1', null);
INSERT INTO `menu` VALUES ('35', '班级信息', '28', 'user/class.html', '1', null);
INSERT INTO `menu` VALUES ('36', '修改密码', '28', 'user/password.jsp', '1', null);
INSERT INTO `menu` VALUES ('37', '班级管理', '29', 'Educational/class/list', '1', null);
INSERT INTO `menu` VALUES ('38', '学生管理', '29', 'Educational/student/selectall', '1', null);
INSERT INTO `menu` VALUES ('39', '组织考试', '29', 'Educational/exam/exam.html', '1', null);
INSERT INTO `menu` VALUES ('40', '班级审核', '29', 'Educational/Auditing', '1', null);
INSERT INTO `menu` VALUES ('41', '学员信息', '30', null, '1', null);
INSERT INTO `menu` VALUES ('42', '我的成绩', '30', null, '1', null);
INSERT INTO `menu` VALUES ('43', '我的书籍', '30', null, '1', null);
INSERT INTO `menu` VALUES ('44', '资料下载', '31', null, '1', null);
INSERT INTO `menu` VALUES ('45', '资料上传', '32', null, '1', null);
INSERT INTO `menu` VALUES ('46', '书籍管理', '32', null, '1', null);
INSERT INTO `menu` VALUES ('47', '用户管理', '33', null, '1', null);
INSERT INTO `menu` VALUES ('48', '角色管理', '33', 'power/role/list', '1', null);
INSERT INTO `menu` VALUES ('49', '菜单管理', '33', '/power/menu/getmenus', '1', null);
INSERT INTO `menu` VALUES ('50', '业务管理', '-1', null, null, null);
INSERT INTO `menu` VALUES ('51', '流程管理', '-1', '', '1', null);
INSERT INTO `menu` VALUES ('54', '请假管理', '50', '/qingjia/getleavebills', null, null);
INSERT INTO `menu` VALUES ('117', '部署管理', '51', '/bushu/getdeploys', null, null);
INSERT INTO `menu` VALUES ('118', '任务管理', '51', '/renwu/gettastlist', null, null);

-- ----------------------------
-- Table structure for `middle`
-- ----------------------------
DROP TABLE IF EXISTS `middle`;
CREATE TABLE `middle` (
  `middleid` int(11) NOT NULL AUTO_INCREMENT,
  `menuid` int(11) DEFAULT NULL,
  `roleid` int(11) DEFAULT NULL,
  PRIMARY KEY (`middleid`)
) ENGINE=InnoDB AUTO_INCREMENT=131 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of middle
-- ----------------------------
INSERT INTO `middle` VALUES ('1', '50', '1');
INSERT INTO `middle` VALUES ('2', '54', '1');
INSERT INTO `middle` VALUES ('3', '51', '6');
INSERT INTO `middle` VALUES ('4', '118', '6');
INSERT INTO `middle` VALUES ('49', '28', '1');
INSERT INTO `middle` VALUES ('50', '34', '1');
INSERT INTO `middle` VALUES ('51', '36', '1');
INSERT INTO `middle` VALUES ('52', '29', '1');
INSERT INTO `middle` VALUES ('53', '37', '1');
INSERT INTO `middle` VALUES ('54', '38', '1');
INSERT INTO `middle` VALUES ('55', '39', '1');
INSERT INTO `middle` VALUES ('66', '29', '4');
INSERT INTO `middle` VALUES ('67', '40', '4');
INSERT INTO `middle` VALUES ('72', '28', '6');
INSERT INTO `middle` VALUES ('73', '34', '6');
INSERT INTO `middle` VALUES ('74', '35', '6');
INSERT INTO `middle` VALUES ('75', '36', '6');
INSERT INTO `middle` VALUES ('76', '30', '6');
INSERT INTO `middle` VALUES ('77', '41', '6');
INSERT INTO `middle` VALUES ('78', '42', '6');
INSERT INTO `middle` VALUES ('79', '43', '6');
INSERT INTO `middle` VALUES ('96', '28', '7');
INSERT INTO `middle` VALUES ('97', '34', '7');
INSERT INTO `middle` VALUES ('98', '35', '7');
INSERT INTO `middle` VALUES ('99', '36', '7');
INSERT INTO `middle` VALUES ('109', '28', '5');
INSERT INTO `middle` VALUES ('110', '34', '5');
INSERT INTO `middle` VALUES ('111', '35', '5');
INSERT INTO `middle` VALUES ('112', '36', '5');
INSERT INTO `middle` VALUES ('113', '33', '5');
INSERT INTO `middle` VALUES ('114', '47', '5');
INSERT INTO `middle` VALUES ('115', '48', '5');
INSERT INTO `middle` VALUES ('116', '49', '5');
INSERT INTO `middle` VALUES ('117', '50', '5');
INSERT INTO `middle` VALUES ('118', '52', '5');
INSERT INTO `middle` VALUES ('119', '53', '5');
INSERT INTO `middle` VALUES ('120', '54', '5');
INSERT INTO `middle` VALUES ('121', '51', '5');
INSERT INTO `middle` VALUES ('122', '117', '5');
INSERT INTO `middle` VALUES ('123', '118', '5');
INSERT INTO `middle` VALUES ('124', '51', '4');
INSERT INTO `middle` VALUES ('125', '118', '4');
INSERT INTO `middle` VALUES ('126', '28', '8');
INSERT INTO `middle` VALUES ('127', '34', '8');
INSERT INTO `middle` VALUES ('128', '35', '8');
INSERT INTO `middle` VALUES ('129', '36', '8');
INSERT INTO `middle` VALUES ('130', '29', '8');

-- ----------------------------
-- Table structure for `role`
-- ----------------------------
DROP TABLE IF EXISTS `role`;
CREATE TABLE `role` (
  `roleid` int(11) NOT NULL AUTO_INCREMENT,
  `rolename` varchar(255) DEFAULT NULL,
  `rolestate` int(11) DEFAULT NULL,
  PRIMARY KEY (`roleid`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of role
-- ----------------------------
INSERT INTO `role` VALUES ('1', '班主任', '0');
INSERT INTO `role` VALUES ('2', '教务主任', '0');
INSERT INTO `role` VALUES ('4', '院长', '1');
INSERT INTO `role` VALUES ('5', '超级管理员2', '0');
INSERT INTO `role` VALUES ('6', '教学总监', '0');
INSERT INTO `role` VALUES ('7', '管理员33', '1');
INSERT INTO `role` VALUES ('8', '管理员a', '0');

-- ----------------------------
-- Table structure for `student`
-- ----------------------------
DROP TABLE IF EXISTS `student`;
CREATE TABLE `student` (
  `studentid` int(11) NOT NULL AUTO_INCREMENT,
  `studentno` varchar(20) DEFAULT NULL,
  `stuname` varchar(5) DEFAULT NULL,
  `stuage` int(11) DEFAULT NULL,
  `gradeid` int(11) DEFAULT NULL,
  PRIMARY KEY (`studentid`)
) ENGINE=InnoDB AUTO_INCREMENT=122 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of student
-- ----------------------------
INSERT INTO `student` VALUES ('1', 's1101', '张三', '11', '1');
INSERT INTO `student` VALUES ('2', 's1102', '李四', '22', '1');
INSERT INTO `student` VALUES ('3', 's1103', '王五', '33', '1');
INSERT INTO `student` VALUES ('4', 's1104', '赵柳', '44', '2');
INSERT INTO `student` VALUES ('5', 's1105', '田七', '55', '2');
INSERT INTO `student` VALUES ('110', 's110', '???', '66', '2');
INSERT INTO `student` VALUES ('111', 's111', '谢大脚1', '77', '2');
INSERT INTO `student` VALUES ('112', 'sno110', '广坤', '88', '2');
INSERT INTO `student` VALUES ('113', 'sno11', '谢广坤', '99', '3');
INSERT INTO `student` VALUES ('114', 'sno001', '广坤1', '1', '3');
INSERT INTO `student` VALUES ('115', 's00111', '谢大脚2', '2', '3');
INSERT INTO `student` VALUES ('116', 's00113', '谢大脚3', '3', '3');
INSERT INTO `student` VALUES ('117', 's00114', '谢大脚4', '4', '3');
INSERT INTO `student` VALUES ('120', 'a1101', '张娜', '18', null);
INSERT INTO `student` VALUES ('121', 'c101', '广坤', '50', null);

-- ----------------------------
-- Table structure for `wife`
-- ----------------------------
DROP TABLE IF EXISTS `wife`;
CREATE TABLE `wife` (
  `wifeid` int(11) NOT NULL AUTO_INCREMENT,
  `wifename` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`wifeid`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of wife
-- ----------------------------
INSERT INTO `wife` VALUES ('1', '谢娜');
