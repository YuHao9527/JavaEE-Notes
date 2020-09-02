/*
Navicat MySQL Data Transfer

Source Server         : localhost_3306
Source Server Version : 50722
Source Host           : localhost:3306
Source Database       : mytest

Target Server Type    : MYSQL
Target Server Version : 50722
File Encoding         : 65001

Date: 2020-06-15 20:15:00
*/

SET FOREIGN_KEY_CHECKS=0;

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
INSERT INTO `student` VALUES ('110', 's110', 'abc', '66', '2');
INSERT INTO `student` VALUES ('111', 's111', '谢大脚1', '77', '2');
INSERT INTO `student` VALUES ('112', 'sno110', '广坤', '88', '2');
INSERT INTO `student` VALUES ('113', 'sno11', '谢广坤', '99', '3');
INSERT INTO `student` VALUES ('114', 'sno001', '广坤1', '1', '3');
INSERT INTO `student` VALUES ('115', 's00111', '谢大脚2', '2', '3');
INSERT INTO `student` VALUES ('116', 's00113', '谢大脚3', '3', '3');
INSERT INTO `student` VALUES ('117', 's00114', '谢大脚4', '4', '3');
INSERT INTO `student` VALUES ('120', 'a1101', '张娜', '18', null);
INSERT INTO `student` VALUES ('121', 'c101', '广坤', '50', null);
