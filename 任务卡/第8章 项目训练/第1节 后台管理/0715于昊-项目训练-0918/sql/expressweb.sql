/*
 Navicat Premium Data Transfer

 Source Server         : mysql
 Source Server Type    : MySQL
 Source Server Version : 50731
 Source Host           : localhost:3306
 Source Schema         : expressweb

 Target Server Type    : MySQL
 Target Server Version : 50731
 File Encoding         : 65001

 Date: 18/09/2020 11:30:53
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for courier
-- ----------------------------
DROP TABLE IF EXISTS `courier`;
CREATE TABLE `courier`  (
  `id` int(10) UNSIGNED NOT NULL AUTO_INCREMENT,
  `name` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `phone` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `idCard` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `password` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `numberDispatch` int(10) UNSIGNED NULL DEFAULT 0,
  `status` int(11) NULL DEFAULT 0,
  `signUpTime` timestamp(0) NULL DEFAULT NULL,
  `loginTime` timestamp(0) NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE,
  UNIQUE INDEX `idCode`(`idCard`) USING BTREE,
  UNIQUE INDEX `courier_phone_uindex`(`phone`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 114 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of courier
-- ----------------------------
INSERT INTO `courier` VALUES (1, '赵日天', '13578771243', '360428198012300002', '12345678', 8620, 0, '2020-09-14 16:20:53', '2020-09-14 16:20:59');
INSERT INTO `courier` VALUES (2, '王二狗', '17899881325', '360428198012300001', '123456', 0, 0, '2020-09-14 18:32:51', NULL);
INSERT INTO `courier` VALUES (102, '大帅B', '13588983612', '360428198012300006', '12345678', 0, 0, '2020-09-14 21:52:22', NULL);
INSERT INTO `courier` VALUES (112, '大帅哥哥', '13578996632#', '360428198712300036#', '123456', 0, 1, '2020-09-14 19:31:55', NULL);
INSERT INTO `courier` VALUES (113, '于昊1', '15797977100', '360428198012300045', '12345678', 0, 0, '2020-09-16 23:24:12', '2020-09-18 11:26:20');

-- ----------------------------
-- Table structure for eadmin
-- ----------------------------
DROP TABLE IF EXISTS `eadmin`;
CREATE TABLE `eadmin`  (
  `id` int(11) UNSIGNED NOT NULL AUTO_INCREMENT,
  `username` varchar(18) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `password` varchar(18) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `loginTime` timestamp(0) NULL DEFAULT NULL,
  `loginIp` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `createTime` timestamp(0) NULL DEFAULT CURRENT_TIMESTAMP(0),
  PRIMARY KEY (`id`) USING BTREE,
  UNIQUE INDEX `username`(`username`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 2 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of eadmin
-- ----------------------------
INSERT INTO `eadmin` VALUES (1, 'admin', '123456', '2020-09-18 00:00:00', '0:0:0:0:0:0:0:1', '2020-09-08 18:29:59');

-- ----------------------------
-- Table structure for express
-- ----------------------------
DROP TABLE IF EXISTS `express`;
CREATE TABLE `express`  (
  `id` int(10) UNSIGNED NOT NULL AUTO_INCREMENT,
  `number` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `username` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `userPhone` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `company` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `code` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `inTime` timestamp(0) NULL DEFAULT NULL,
  `outTime` timestamp(0) NULL DEFAULT NULL,
  `status` int(11) NULL DEFAULT 0,
  `sysPhone` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE,
  UNIQUE INDEX `number`(`number`) USING BTREE,
  UNIQUE INDEX `CODE`(`code`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 141 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of express
-- ----------------------------
INSERT INTO `express` VALUES (13, '600129', '王五', '17778779742', '顺丰速运', NULL, '2020-09-11 18:50:21', '2020-09-17 12:27:11', 1, '15797977100');
INSERT INTO `express` VALUES (20, '600128', '张三', '13789824461', '顺丰速运', NULL, '2020-09-14 11:42:54', '2020-09-17 12:19:00', 1, '15797977100');
INSERT INTO `express` VALUES (122, '600120', '于昊', '15797977100', '顺丰速运', NULL, '2020-09-16 23:25:28', '2020-09-17 10:00:05', 1, '15797977100');
INSERT INTO `express` VALUES (123, '600150', '于昊', '15797977100', '安能物流', NULL, '2020-09-16 23:25:45', '2020-09-16 23:25:54', 1, '15797977100');
INSERT INTO `express` VALUES (124, '600258', '大哥大', '13578779864', '顺丰速运', NULL, '2020-09-17 09:38:13', '2020-09-17 09:56:18', 1, '15797977100');
INSERT INTO `express` VALUES (125, '600178', '大哥大', '13578779864', '顺丰速递', NULL, '2020-09-17 09:38:23', '2020-09-17 10:32:30', 1, '15797977100');
INSERT INTO `express` VALUES (126, '600356', '牛逼PLUS', '13578779864', '顺丰速运', NULL, '2020-09-17 12:28:58', '2020-09-17 12:29:39', 1, '15797977100');
INSERT INTO `express` VALUES (138, '600425', '李四', '15787876400', '民邦快递', '885642', '2020-09-17 21:17:13', NULL, 0, '15797977100');
INSERT INTO `express` VALUES (139, '600989', '王五', '17889886400', '马其顿邮政', '841748', '2020-09-17 21:20:57', NULL, 0, '15797977100');
INSERT INTO `express` VALUES (140, '600787', '赵六', '18978556420', '龙邦速递', '114808', '2020-09-17 21:21:54', NULL, 0, '15797977100');

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user`  (
  `id` int(10) UNSIGNED NOT NULL AUTO_INCREMENT,
  `nickName` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `phone` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `idCard` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `password` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `status` int(10) UNSIGNED NULL DEFAULT 0,
  `signUpTime` timestamp(0) NULL DEFAULT NULL,
  `loginTime` timestamp(0) NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE,
  UNIQUE INDEX `phone`(`phone`) USING BTREE,
  UNIQUE INDEX `idCard`(`idCard`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 11 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES (1, '牛逼PLUS', '13578779864', '3604287198012031126', '123456', 2, '2020-09-15 09:31:39', '2020-09-17 23:55:41');
INSERT INTO `user` VALUES (2, '小哥哥啊', '15374621263#', '360418198012040256#', '123456', 1, '2020-09-15 10:54:01', NULL);
INSERT INTO `user` VALUES (3, '大哥大', '15797977100', '360428198012031127', '123456', 0, '2020-09-15 18:44:13', '2020-09-17 23:39:28');
INSERT INTO `user` VALUES (9, '大王饶命', '18364821223', '360428198712120644', '123456', 2, '2020-09-18 00:28:48', '2020-09-18 01:03:02');
INSERT INTO `user` VALUES (10, NULL, '18779634600', NULL, NULL, 0, '2020-09-18 10:16:08', '2020-09-18 10:16:08');

SET FOREIGN_KEY_CHECKS = 1;
