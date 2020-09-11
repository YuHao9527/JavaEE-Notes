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

 Date: 12/09/2020 00:37:48
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

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
  `status` int(11) NULL DEFAULT 0,
  `createTime` timestamp(0) NULL DEFAULT CURRENT_TIMESTAMP(0),
  PRIMARY KEY (`id`) USING BTREE,
  UNIQUE INDEX `username`(`username`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 2 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of eadmin
-- ----------------------------
INSERT INTO `eadmin` VALUES (1, 'admin', '123456', '2020-09-12 00:00:00', '0:0:0:0:0:0:0:1', 0, '2020-09-08 18:29:59');

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
) ENGINE = InnoDB AUTO_INCREMENT = 15 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of express
-- ----------------------------
INSERT INTO `express` VALUES (1, '600123', '张三', '120110', '顺丰', '465132', '2020-09-10 22:20:44', NULL, 0, '18888887988');
INSERT INTO `express` VALUES (2, '600124', '张三', '120110', '顺丰', '478212', '2020-09-10 22:20:50', NULL, 0, '13546456121');
INSERT INTO `express` VALUES (3, '600125', '张三', '120110', '韵达', NULL, '2020-09-10 22:20:53', '2020-09-11 16:55:36', 1, '12335555411');
INSERT INTO `express` VALUES (4, '600126', '李四', '100365', '顺丰', '555444', '2020-09-11 17:13:38', '2020-09-10 22:21:05', 0, '45648745961');
INSERT INTO `express` VALUES (5, '600127', '李四', '100365', '韵达', NULL, '2020-09-11 11:51:27', '2020-09-11 11:51:38', 1, '18888887988');
INSERT INTO `express` VALUES (9, '600128', '张三', '120110', '顺丰', '666666', '2020-09-11 17:17:13', NULL, 0, '18888887988');
INSERT INTO `express` VALUES (13, '600129', '王五', '17778779742', '顺丰速运', '521841', '2020-09-11 18:50:21', NULL, 0, '18888887988');
INSERT INTO `express` VALUES (14, '600130', '张三', '120110', '百世快运', '543105', '2020-09-11 18:53:12', NULL, 0, '18888887988');

SET FOREIGN_KEY_CHECKS = 1;
