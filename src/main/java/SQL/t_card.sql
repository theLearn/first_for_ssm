/*
Navicat MySQL Data Transfer

Source Server         : hongcheng
Source Server Version : 50051
Source Host           : localhost:3306
Source Database       : db_ssm

Target Server Type    : MYSQL
Target Server Version : 50051
File Encoding         : 65001

Date: 2017-04-17 13:23:09
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `t_card`
-- ----------------------------
DROP TABLE IF EXISTS `t_card`;
CREATE TABLE `t_card` (
  `id` bigint(11) NOT NULL auto_increment,
  `name` varchar(255) default NULL COMMENT '名称',
  `imageUrl` varchar(255) default NULL COMMENT '图片地址',
  `description` varchar(255) default NULL COMMENT '描述',
  `type` varchar(32) default NULL COMMENT '类型',
  PRIMARY KEY  (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8 COMMENT='动漫卡片分类';

-- ----------------------------
-- Records of t_card
-- ----------------------------
INSERT INTO `t_card` VALUES ('1', '童年的热血', 'http://192.168.1.103:8080/static/one_piece.jpg', '血液沸腾的感觉还记得吗?', 'hot');
INSERT INTO `t_card` VALUES ('2', '美食的诱惑', 'http://192.168.1.103:8080/static/shiling.jpg', '肚子饿了吗?', 'feed');
INSERT INTO `t_card` VALUES ('3', '酷炫的能力', 'http://192.168.1.103:8080/static/fate.jpg', '画面太美我不敢看', 'ability');
INSERT INTO `t_card` VALUES ('4', '奇幻的世界', 'http://192.168.1.103:8080/static/slove.jpg', '不一样的世界，不一样的体验', 'world');
INSERT INTO `t_card` VALUES ('5', '萌萌哒', 'http://192.168.1.103:8080/static/zero.jpg', '萌即是正义', 'meng');
INSERT INTO `t_card` VALUES ('6', '大脑洞', 'http://192.168.1.103:8080/static/kongbai.jpg', '我表示思考不能', 'big');
