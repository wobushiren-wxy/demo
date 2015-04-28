/*
Navicat MySQL Data Transfer

Source Server         : 10.125.159.217
Source Server Version : 50612
Source Host           : 10.125.159.217:3306
Source Database       : card

Target Server Type    : MYSQL
Target Server Version : 50612
File Encoding         : 65001

Date: 2014-08-21 15:23:55
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `words_cat`
-- ----------------------------
DROP TABLE IF EXISTS `words_cat`;
CREATE TABLE `words_cat` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `name` varchar(50) NOT NULL COMMENT '分类名称',
  `comment` varchar(200) DEFAULT '' COMMENT '分类描述',
  `addtime` datetime NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of words_cat
-- ----------------------------
INSERT INTO `words_cat` VALUES ('2', '分类1', '分类1', '2014-08-04 16:43:52');
INSERT INTO `words_cat` VALUES ('3', '分类2', '分类2', '2014-08-05 10:04:19');
INSERT INTO `words_cat` VALUES ('4', '分类3', '分类3', '2014-08-05 10:04:29');
INSERT INTO `words_cat` VALUES ('6', '分类4', '分类4', '2014-08-20 15:21:21');
