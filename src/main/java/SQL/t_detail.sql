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
-- Table structure for `t_detail`
-- ----------------------------
DROP TABLE IF EXISTS `t_detail`;
CREATE TABLE `t_detail` (
  `id` bigint(11) NOT NULL auto_increment,
  `imageUrl` varchar(255) default NULL COMMENT '图片地址',
  `description` varchar(255) default NULL COMMENT '描述',
  `type` varchar(32) default NULL COMMENT '类型',
  `content` varchar(255) default NULL COMMENT '内容',
  `infoId` varchar(32) default NULL COMMENT '信息类型',
  `date` datetime default NULL COMMENT '创建时间',
  PRIMARY KEY  (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=34 DEFAULT CHARSET=utf8 COMMENT='动漫详情';

-- ----------------------------
-- Records of t_detail
-- ----------------------------
INSERT INTO `t_detail` VALUES ('1', 'http://192.168.1.103:8080/static/one_piece.jpg', '20话', 'hot', '海贼王', '1', '2016-09-15 00:00:00');
INSERT INTO `t_detail` VALUES ('2', 'http://192.168.1.103:8080/static/bleach.jpg', '20话', 'hot', '死神', '1', '2016-09-15 00:00:00');
INSERT INTO `t_detail` VALUES ('3', 'http://192.168.1.103:8080/static/jiajiao.jpg', '20话', 'hot', '家庭教师', '1', '2016-09-15 00:00:00');
INSERT INTO `t_detail` VALUES ('4', 'http://192.168.1.103:8080/static/meishi.jpg', '20话', 'hot', '美食的俘虏', '1', '2016-09-15 00:00:00');
INSERT INTO `t_detail` VALUES ('5', 'http://192.168.1.103:8080/static/qumo.jpg', '20话', 'hot', '驱魔少年', '1', '2016-09-15 00:00:00');
INSERT INTO `t_detail` VALUES ('6', 'http://192.168.1.103:8080/static/natura.jpg', '20话', 'hot', '火隐忍者', '1', '2016-09-15 00:00:00');
INSERT INTO `t_detail` VALUES ('7', 'http://192.168.1.103:8080/static/fate.jpg', '20话', 'hot', '命运之夜', '1', '2016-09-15 00:00:00');
INSERT INTO `t_detail` VALUES ('8', 'http://192.168.1.103:8080/static/ling100.jpg', '20话', 'hot', '灵能百分百', '1', '2016-09-15 00:00:00');
INSERT INTO `t_detail` VALUES ('9', 'http://192.168.1.103:8080/static/kongbai.jpg', '20话', 'hot', '空白兄妹', '1', '2016-09-15 00:00:00');
INSERT INTO `t_detail` VALUES ('10', 'http://192.168.1.103:8080/static/slove.jpg', '20话', 'hot', '刀剑神域', '1', '2016-09-15 00:00:00');
INSERT INTO `t_detail` VALUES ('11', 'http://192.168.1.103:8080/static/shiling.jpg', '20话', 'feed', '食戟之灵', '1', '2016-09-15 00:00:00');
INSERT INTO `t_detail` VALUES ('12', 'http://192.168.1.103:8080/static/meishi.jpg', '20话', 'feed', '美食的俘虏', '1', '2016-09-15 00:00:00');
INSERT INTO `t_detail` VALUES ('13', 'http://192.168.1.103:8080/static/one_piece.jpg', '20话', 'feed', '海贼王', '1', '2016-09-15 00:00:00');
INSERT INTO `t_detail` VALUES ('14', 'http://192.168.1.103:8080/static/ling100.jpg', '20话', 'ability', '灵能百分百', '1', '2016-09-15 00:00:00');
INSERT INTO `t_detail` VALUES ('15', 'http://192.168.1.103:8080/static/zero.jpg', '20话', 'ability', '从零开始', '1', '2016-09-15 00:00:00');
INSERT INTO `t_detail` VALUES ('16', 'http://192.168.1.103:8080/static/jiajiao.jpg', '20话', 'ability', '家庭教师', '1', '2016-09-15 00:00:00');
INSERT INTO `t_detail` VALUES ('17', 'http://192.168.1.103:8080/static/qumo.jpg', '20话', 'ability', '驱魔少年', '1', '2016-09-15 00:00:00');
INSERT INTO `t_detail` VALUES ('18', 'http://192.168.1.103:8080/static/slove.jpg', '20话', 'ability', '刀剑神域', '1', '2016-09-15 00:00:00');
INSERT INTO `t_detail` VALUES ('19', 'http://192.168.1.103:8080/static/slove.jpg', '20话', 'world', '刀剑神域', '1', '2016-09-15 00:00:00');
INSERT INTO `t_detail` VALUES ('20', 'http://192.168.1.103:8080/static/kongbai.jpg', '20话', 'world', '空白兄妹', '1', '2016-09-15 00:00:00');
INSERT INTO `t_detail` VALUES ('21', 'http://192.168.1.103:8080/static/jiajiao.jpg', '20话', 'world', '家庭教师', '1', '2016-09-15 00:00:00');
INSERT INTO `t_detail` VALUES ('22', 'http://192.168.1.103:8080/static/qumo.jpg', '20话', 'world', '驱魔少年', '1', '2016-09-15 00:00:00');
INSERT INTO `t_detail` VALUES ('23', 'http://192.168.1.103:8080/static/zero.jpg', '20话', 'world', '从零开始', '1', '2016-09-15 00:00:00');
INSERT INTO `t_detail` VALUES ('24', 'http://192.168.1.103:8080/static/zero.jpg', '20话', 'meng', '从零开始', '1', '2016-09-15 00:00:00');
INSERT INTO `t_detail` VALUES ('25', 'http://192.168.1.103:8080/static/kongbai.jpg', '20话', 'meng', '空白兄妹', '1', '2016-09-15 00:00:00');
INSERT INTO `t_detail` VALUES ('26', 'http://192.168.1.103:8080/static/qingyin.jpg', '20话', 'meng', '轻音', '1', '2016-09-15 00:00:00');
INSERT INTO `t_detail` VALUES ('27', 'http://192.168.1.103:8080/static/huyao.jpg', '20话', 'meng', '狐妖小红娘', '1', '2016-09-15 00:00:00');
INSERT INTO `t_detail` VALUES ('28', 'http://192.168.1.103:8080/static/shiling.jpg', '20话', 'meng', '食戟之灵', '1', '2016-09-15 00:00:00');
INSERT INTO `t_detail` VALUES ('29', 'http://192.168.1.103:8080/static/zero.jpg', '20话', 'big', '从零开始', '1', '2016-09-15 00:00:00');
INSERT INTO `t_detail` VALUES ('30', 'http://192.168.1.103:8080/static/kongbai.jpg', '20话', 'big', '空白兄妹', '1', '2016-09-15 00:00:00');
INSERT INTO `t_detail` VALUES ('31', 'http://192.168.1.103:8080/static/qingyin.jpg', '20话', 'big', '轻音', '1', '2016-09-15 00:00:00');
INSERT INTO `t_detail` VALUES ('32', 'http://192.168.1.103:8080/static/huyao.jpg', '20话', 'big', '狐妖小红娘', '1', '2016-09-15 00:00:00');
INSERT INTO `t_detail` VALUES ('33', 'http://192.168.1.103:8080/static/shiling.jpg', '20话', 'big', '食戟之灵', '1', '2016-09-15 00:00:00');
