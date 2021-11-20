/*
 Navicat Premium Data Transfer

 Source Server         : navicat-localhost
 Source Server Type    : MySQL
 Source Server Version : 50719
 Source Host           : localhost:3306
 Source Schema         : rail-ticketing-system

 Target Server Type    : MySQL
 Target Server Version : 50719
 File Encoding         : 65001

 Date: 20/11/2021 19:40:48
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for admin
-- ----------------------------
DROP TABLE IF EXISTS `admin`;
CREATE TABLE `admin`  (
  `id` int(11) NULL DEFAULT NULL,
  `username` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `password` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  PRIMARY KEY (`username`) USING BTREE
) ENGINE = MyISAM CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of admin
-- ----------------------------
INSERT INTO `admin` VALUES (1, 'admin', '123456');

-- ----------------------------
-- Table structure for order
-- ----------------------------
DROP TABLE IF EXISTS `order`;
CREATE TABLE `order`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `car_info_id` int(11) NULL DEFAULT NULL,
  `person_id` int(11) NULL DEFAULT NULL,
  `change_times` int(22) NULL DEFAULT NULL,
  `status` int(11) NULL DEFAULT NULL,
  `stauts_msg` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 81 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of order
-- ----------------------------
INSERT INTO `order` VALUES (79, 11, 19, 0, 2, NULL);
INSERT INTO `order` VALUES (80, 11, 19, 0, 3, NULL);

-- ----------------------------
-- Table structure for trips
-- ----------------------------
DROP TABLE IF EXISTS `trips`;
CREATE TABLE `trips`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `orgin_location` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `destination_location` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `start_time` datetime NULL DEFAULT NULL,
  `reach_time` datetime NULL DEFAULT NULL,
  `span_days` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `car_num` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `ticket_price` double NULL DEFAULT NULL,
  `ticket_num` int(11) NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = MyISAM AUTO_INCREMENT = 12 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of trips
-- ----------------------------
INSERT INTO `trips` VALUES (8, '北京', '天津', '2021-11-10 14:05:00', '2021-11-10 15:19:00', '0', 'K5167', 80.5, 2);
INSERT INTO `trips` VALUES (6, '天津', '北京西', '2021-11-01 08:21:00', '2021-11-01 08:51:00', '0', 'G116', 43.5, 20);
INSERT INTO `trips` VALUES (7, '天津', '北京', '2021-11-01 16:53:00', '2021-11-19 17:43:00', '0', 'Y7', 20, 100);
INSERT INTO `trips` VALUES (10, '北京', '天津', '2021-11-10 17:12:00', '2021-11-10 17:39:00', '0', 'Z999', 50.5, 100);
INSERT INTO `trips` VALUES (9, '天津', '南京', '2021-11-01 14:06:00', '2021-11-02 14:06:00', '1', 'G6533', 123.5, 15);
INSERT INTO `trips` VALUES (11, '北京', '天津', '2021-11-10 09:13:00', '2021-11-10 10:13:00', '0', 'K555', 50.4, 99);

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user`  (
  `id` int(10) NOT NULL AUTO_INCREMENT,
  `username` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `password` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `true_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `id_card_num` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `phone_num` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `age` int(11) NULL DEFAULT NULL,
  `sex` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`username`) USING BTREE,
  UNIQUE INDEX `id`(`id`) USING BTREE,
  INDEX `test`(`id`) USING BTREE
) ENGINE = MyISAM AUTO_INCREMENT = 20 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES (19, 'chz', '123456', '曹汉宗', '131181200109152711', '13754447831', 20, '男');

SET FOREIGN_KEY_CHECKS = 1;
