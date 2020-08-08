/*
Navicat MySQL Data Transfer

Source Server         : connect
Source Server Version : 50716
Source Host           : localhost:3306
Source Database       : myblog

Target Server Type    : MYSQL
Target Server Version : 50716
File Encoding         : 65001

Date: 2020-08-08 17:29:42
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `article_category`
-- ----------------------------
DROP TABLE IF EXISTS `article_category`;
CREATE TABLE `article_category` (
  `id` bigint(40) NOT NULL AUTO_INCREMENT,
  `category_id` bigint(40) NOT NULL COMMENT '对应分类ID',
  `article_id` bigint(40) NOT NULL COMMENT '对应文章ID',
  `create_by` datetime NOT NULL COMMENT '文章创建时间',
  `modified_by` datetime NOT NULL COMMENT '文章修改时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=26 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of article_category
-- ----------------------------
INSERT INTO `article_category` VALUES ('1', '24', '5', '2019-03-26 08:00:00', '2019-03-26 08:00:00');
INSERT INTO `article_category` VALUES ('2', '24', '6', '2019-03-29 08:00:00', '2019-03-29 08:00:00');
INSERT INTO `article_category` VALUES ('3', '24', '7', '2019-03-31 08:00:00', '2019-03-31 08:00:00');
INSERT INTO `article_category` VALUES ('4', '25', '7', '2019-03-31 08:00:00', '2019-03-31 08:00:00');
INSERT INTO `article_category` VALUES ('5', '31', '7', '2019-03-31 08:00:00', '2019-03-31 08:00:00');
INSERT INTO `article_category` VALUES ('6', '24', '8', '2019-03-26 19:38:20', '2019-03-26 19:38:20');
INSERT INTO `article_category` VALUES ('7', '25', '8', '2019-03-26 19:38:20', '2019-03-26 19:38:20');
INSERT INTO `article_category` VALUES ('8', '31', '8', '2019-03-26 19:38:20', '2019-03-26 19:38:20');
INSERT INTO `article_category` VALUES ('9', '24', '9', '2019-03-26 11:38:20', '2019-03-26 11:38:20');
INSERT INTO `article_category` VALUES ('10', '1', '10', '2019-03-27 10:07:34', '2019-03-27 10:07:34');
INSERT INTO `article_category` VALUES ('11', '29', '11', '2019-03-27 11:20:53', '2019-03-27 11:20:53');
INSERT INTO `article_category` VALUES ('12', '31', '12', '2019-03-27 11:46:42', '2019-03-27 11:46:42');
INSERT INTO `article_category` VALUES ('13', '31', '13', '2019-03-27 11:47:21', '2019-03-27 11:47:21');
INSERT INTO `article_category` VALUES ('14', '31', '14', '2019-03-27 11:48:47', '2019-03-27 11:48:47');
INSERT INTO `article_category` VALUES ('15', '1', '15', '2019-03-27 15:00:58', '2019-03-27 15:00:58');
INSERT INTO `article_category` VALUES ('16', '31', '16', '2019-03-28 11:28:24', '2019-03-28 11:28:24');
INSERT INTO `article_category` VALUES ('17', '31', '17', '2019-03-28 11:34:14', '2019-03-28 11:34:14');
INSERT INTO `article_category` VALUES ('18', '31', '18', '2019-03-29 09:58:09', '2019-03-29 09:58:09');
INSERT INTO `article_category` VALUES ('19', '1', '19', '2019-04-01 11:52:21', '2019-04-01 11:52:21');
INSERT INTO `article_category` VALUES ('20', '31', '20', '2019-04-01 13:26:39', '2019-04-01 13:26:39');
INSERT INTO `article_category` VALUES ('21', '3', '21', '2019-04-01 13:31:32', '2019-04-01 13:31:32');
INSERT INTO `article_category` VALUES ('22', '1', '22', '2019-04-09 14:17:48', '2019-04-09 14:17:48');
INSERT INTO `article_category` VALUES ('23', '32', '23', '2019-04-30 17:29:03', '2019-04-30 17:29:03');
INSERT INTO `article_category` VALUES ('24', '28', '24', '2019-04-30 17:32:12', '2019-04-30 17:32:12');
INSERT INTO `article_category` VALUES ('25', '28', '25', '2019-04-30 17:33:22', '2019-04-30 17:33:22');

-- ----------------------------
-- Table structure for `article_comment`
-- ----------------------------
DROP TABLE IF EXISTS `article_comment`;
CREATE TABLE `article_comment` (
  `id` bigint(40) NOT NULL AUTO_INCREMENT,
  `comment_id` bigint(40) NOT NULL COMMENT '文章对应评论ID',
  `article_id` bigint(40) NOT NULL COMMENT '对应文章ID',
  `create_by` datetime NOT NULL COMMENT '文章创建时间',
  `modified_by` datetime NOT NULL COMMENT '文章修改时间',
  `is_effective` tinyint(1) NOT NULL DEFAULT '1' COMMENT '是否有效，默认1有效，0无效',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=32 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of article_comment
-- ----------------------------
INSERT INTO `article_comment` VALUES ('1', '1', '21', '2019-04-09 13:50:53', '2019-04-09 13:50:53', '1');
INSERT INTO `article_comment` VALUES ('2', '2', '21', '2019-04-09 14:20:53', '2019-04-09 14:20:53', '1');
INSERT INTO `article_comment` VALUES ('3', '3', '22', '2019-04-09 14:28:14', '2019-04-09 14:28:14', '1');
INSERT INTO `article_comment` VALUES ('4', '4', '22', '2019-04-09 14:31:06', '2019-04-09 14:31:06', '1');
INSERT INTO `article_comment` VALUES ('5', '5', '22', '2019-04-09 16:26:59', '2019-04-09 16:26:59', '1');
INSERT INTO `article_comment` VALUES ('6', '6', '15', '2019-04-10 14:43:19', '2019-04-10 14:43:19', '1');
INSERT INTO `article_comment` VALUES ('7', '7', '10', '2019-04-10 14:43:56', '2019-04-10 14:43:56', '1');
INSERT INTO `article_comment` VALUES ('8', '8', '10', '2019-04-10 14:44:32', '2019-04-10 14:44:32', '1');
INSERT INTO `article_comment` VALUES ('9', '9', '10', '2019-04-10 14:45:12', '2019-04-10 14:45:12', '1');
INSERT INTO `article_comment` VALUES ('10', '10', '10', '2019-04-10 14:46:00', '2019-04-10 14:46:00', '1');
INSERT INTO `article_comment` VALUES ('11', '11', '10', '2019-04-10 14:46:00', '2019-04-10 14:46:00', '1');
INSERT INTO `article_comment` VALUES ('12', '12', '14', '2019-04-18 10:48:21', '2019-04-18 10:48:21', '1');
INSERT INTO `article_comment` VALUES ('13', '13', '22', '2019-04-18 15:36:37', '2019-04-18 15:36:37', '1');
INSERT INTO `article_comment` VALUES ('14', '14', '19', '2019-04-18 15:41:09', '2019-04-18 15:41:09', '1');
INSERT INTO `article_comment` VALUES ('15', '15', '20', '2019-04-18 15:44:40', '2019-04-18 15:44:40', '1');
INSERT INTO `article_comment` VALUES ('16', '16', '20', '2019-04-18 15:44:40', '2019-04-18 15:44:40', '1');
INSERT INTO `article_comment` VALUES ('17', '17', '9', '2019-04-18 15:51:45', '2019-04-18 15:51:45', '1');
INSERT INTO `article_comment` VALUES ('18', '18', '17', '2019-04-18 15:53:37', '2019-04-18 15:53:37', '1');
INSERT INTO `article_comment` VALUES ('19', '19', '10', '2019-04-18 16:54:25', '2019-04-18 16:54:25', '1');
INSERT INTO `article_comment` VALUES ('20', '20', '22', '2019-04-19 10:21:37', '2019-04-19 10:21:37', '1');
INSERT INTO `article_comment` VALUES ('21', '21', '19', '2019-04-19 13:22:50', '2019-04-19 13:22:50', '1');
INSERT INTO `article_comment` VALUES ('22', '22', '16', '2019-04-30 13:25:12', '2019-04-30 13:25:12', '1');
INSERT INTO `article_comment` VALUES ('23', '23', '25', '2019-05-06 10:00:41', '2019-05-06 10:00:41', '1');
INSERT INTO `article_comment` VALUES ('24', '24', '8', '2019-05-06 14:03:42', '2019-05-06 14:03:42', '1');
INSERT INTO `article_comment` VALUES ('25', '25', '10', '2019-05-08 11:20:09', '2019-05-08 11:20:09', '1');
INSERT INTO `article_comment` VALUES ('26', '26', '10', '2019-05-08 11:20:09', '2019-05-08 11:20:09', '1');
INSERT INTO `article_comment` VALUES ('27', '27', '10', '2019-05-08 11:24:40', '2019-05-08 11:24:40', '1');
INSERT INTO `article_comment` VALUES ('28', '28', '10', '2019-05-08 11:24:48', '2019-05-08 11:24:48', '1');
INSERT INTO `article_comment` VALUES ('29', '29', '23', '2019-05-08 14:49:22', '2019-05-08 14:49:22', '1');
INSERT INTO `article_comment` VALUES ('30', '30', '25', '2019-05-09 09:52:10', '2019-05-09 09:52:10', '1');
INSERT INTO `article_comment` VALUES ('31', '31', '22', '2019-05-13 15:09:05', '2019-05-13 15:09:05', '1');

-- ----------------------------
-- Table structure for `article_content`
-- ----------------------------
DROP TABLE IF EXISTS `article_content`;
CREATE TABLE `article_content` (
  `id` bigint(40) NOT NULL AUTO_INCREMENT,
  `article_id` bigint(40) NOT NULL COMMENT '对应文章ID',
  `content` text NOT NULL,
  `create_by` datetime NOT NULL COMMENT '创建时间',
  `modified_by` datetime NOT NULL COMMENT '更新时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=24 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of article_content
-- ----------------------------
INSERT INTO `article_content` VALUES ('1', '3', '论mysql的安装与卸载的过程,这是所有的内容啊啊啊啊啊啊啊啊 啊啊啊啊啊啊啊啊啊啊', '2019-03-25 08:00:00', '2019-03-25 08:00:00');
INSERT INTO `article_content` VALUES ('2', '4', '论mysql的安装与卸载的过程,这是所有的内容啊啊啊啊啊啊啊啊 啊啊啊啊啊啊啊啊啊啊', '2019-03-26 08:00:00', '2019-03-26 08:00:00');
INSERT INTO `article_content` VALUES ('3', '5', '论mysql的安装与卸载的过程,这是所有的内容啊啊啊啊啊啊啊啊 啊啊啊啊啊啊啊啊啊啊', '2019-03-26 08:00:00', '2019-03-26 08:00:00');
INSERT INTO `article_content` VALUES ('4', '6', '论mysql的安装与卸载的过程,这是所有的内容啊啊啊啊啊啊啊啊 啊啊啊啊啊啊啊啊啊啊', '2019-03-29 08:00:00', '2019-03-29 08:00:00');
INSERT INTO `article_content` VALUES ('5', '7', '论mysql的安装与卸载的过程,这是所有的内容啊啊啊啊啊啊啊啊 啊啊啊啊啊啊啊啊啊啊', '2019-03-31 08:00:00', '2019-03-31 08:00:00');
INSERT INTO `article_content` VALUES ('6', '8', '论mysql的安装与卸载的过程,这是所有的内容啊啊啊啊啊啊啊啊 啊啊啊啊啊啊啊啊啊啊', '2019-03-26 19:38:20', '2019-03-26 19:38:20');
INSERT INTO `article_content` VALUES ('7', '9', '论mysql的安装与卸载的过程,这是所有的内容啊啊啊啊啊啊啊啊 啊啊啊啊啊啊啊啊啊啊', '2019-03-26 11:38:20', '2019-03-26 11:38:20');
INSERT INTO `article_content` VALUES ('8', '10', '请输入内梵蒂冈的肉体几乎一天规范化北京容看，ilk，i与老婆；屠洪刚5二try和规范化反对他忽然一个框架和\n#### 不过好几个\n![b94951503106f95d822836e5b10eeeb2.jpg](/server/images/43129f6aca794c068cdd005a8e46a54f.jpg)', '2019-03-27 10:07:34', '2019-03-27 10:07:34');
INSERT INTO `article_content` VALUES ('9', '11', '的v饭否嘀咕', '2019-03-27 11:20:53', '2019-03-27 11:20:53');
INSERT INTO `article_content` VALUES ('10', '12', '从v钢板弹簧一天', '2019-03-27 11:46:42', '2019-03-27 11:46:42');
INSERT INTO `article_content` VALUES ('11', '13', '刚孵化幼体恐惧', '2019-03-27 11:47:21', '2019-03-27 11:47:21');
INSERT INTO `article_content` VALUES ('12', '14', '村干部合同法', '2019-03-27 11:48:47', '2019-03-27 11:48:47');
INSERT INTO `article_content` VALUES ('13', '15', '的风格v头发的', '2019-03-27 15:00:58', '2019-03-27 15:00:58');
INSERT INTO `article_content` VALUES ('14', '16', '**都是肥肉**\n## 上的斐然斐然\n### 法国和try回头有机会\n![b94951503106f95d822836e5b10eeeb2.jpg](/server/images/68d0ccbee21d45acbe55c3e3913abe00.jpg)', '2019-03-28 11:28:24', '2019-03-28 11:28:24');
INSERT INTO `article_content` VALUES ('15', '17', '电费人叹分v分的高分微软', '2019-03-28 11:34:14', '2019-03-28 11:34:14');
INSERT INTO `article_content` VALUES ('16', '18', 'safewrtgffdbvgf', '2019-03-29 09:58:09', '2019-03-29 09:58:09');
INSERT INTO `article_content` VALUES ('17', '19', '被大风过后#### 滚动条然后给他人\n![a1f2dbb118146c1601c6bcfa23fba4a9.jpg](/server/images/cd6a4c334b81411eb3db09ec95709ec1.jpg)', '2019-04-01 11:52:21', '2019-04-01 11:52:21');
INSERT INTO `article_content` VALUES ('18', '20', '被大风过后#### 滚动条然后给他人\n![a1f2dbb118146c1601c6bcfa23fba4a9.jpg](/server/images/cd6a4c334b81411eb3db09ec95709ec1.jpg)\n## 二级标题', '2019-04-01 13:26:39', '2019-04-01 13:26:39');
INSERT INTO `article_content` VALUES ('19', '21', '**都是肥肉**\n## 上的斐然斐然\n### 法国和try回头有机会\n![b94951503106f95d822836e5b10eeeb2.jpg](/server/images/68d0ccbee21d45acbe55c3e3913abe00.jpg)', '2019-04-01 13:31:32', '2019-04-01 13:31:32');
INSERT INTO `article_content` VALUES ('20', '22', '![773a23547116bb1b1321928e2e648712.jpg](/server/images/3ab97b27e9964b76a185f34ba0d6db5f.jpg)\n骄傲可是定向增发二十年发动机的时刻妓女觉得需恢复大会IKEA今晚你是个v势单力薄愤怒的撒谎改变附件为非\n上的方便乘客，叫啥的逆反心理恐惧擦但是\n|世界|column2|column3|\n|-|-|-|\n|content1|content2|content3|\n# 时光笔墨\n骄傲可是定向增发二十年发动机的时刻妓女觉得需恢复大会IKEA今晚你是个v势单力薄愤怒的撒谎改变附件为非\n上的方便乘客，叫啥的逆反心理恐惧擦但是\n|世界|column2|column3|\n|-|-|-|\n|content1|content2|content3|', '2019-04-09 14:17:48', '2019-04-09 14:17:48');
INSERT INTO `article_content` VALUES ('21', '23', '|第一列|第二列|第三列|\n|-|-|-|\n|值1|值2|值3|', '2019-04-30 17:29:03', '2019-04-30 17:29:03');
INSERT INTO `article_content` VALUES ('22', '24', 'lkjzvshdfvlsnvpihs岸边的方式楼上的v从\n|column1|column2|column3|\n|-|-|-|\n|content1|content2|content3|', '2019-04-30 17:32:12', '2019-04-30 17:32:12');
INSERT INTO `article_content` VALUES ('23', '25', 'lkjzvshdfvlsnvpihs岸边的方式楼上的v从。\n\n|column1|column2|column3|\n|-|-|-|\n|content1|content2|content3|', '2019-04-30 17:33:22', '2019-04-30 17:33:22');

-- ----------------------------
-- Table structure for `article_image`
-- ----------------------------
DROP TABLE IF EXISTS `article_image`;
CREATE TABLE `article_image` (
  `id` bigint(40) NOT NULL AUTO_INCREMENT,
  `article_id` bigint(40) NOT NULL COMMENT '对应文章ID',
  `image_url` varchar(100) NOT NULL DEFAULT '' COMMENT '文章题图的链接地址',
  `create_by` datetime NOT NULL COMMENT '文章创建时间',
  `modified_by` datetime NOT NULL COMMENT '文章修改时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=26 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of article_image
-- ----------------------------
INSERT INTO `article_image` VALUES ('1', '2', 'images/136f2f37a1324b8b8240aec6c6c0805a.jpg', '2019-03-25 08:00:00', '2019-03-25 08:00:00');
INSERT INTO `article_image` VALUES ('2', '3', 'images/136f2f37a1324b8b8240aec6c6c0805a.jpg', '2019-03-25 08:00:00', '2019-03-25 08:00:00');
INSERT INTO `article_image` VALUES ('3', '4', 'images/136f2f37a1324b8b8240aec6c6c0805a.jpg', '2019-03-26 08:00:00', '2019-03-26 08:00:00');
INSERT INTO `article_image` VALUES ('4', '5', 'images/136f2f37a1324b8b8240aec6c6c0805a.jpg', '2019-03-26 08:00:00', '2019-03-26 08:00:00');
INSERT INTO `article_image` VALUES ('5', '6', 'images/136f2f37a1324b8b8240aec6c6c0805a.jpg', '2019-03-29 08:00:00', '2019-03-29 08:00:00');
INSERT INTO `article_image` VALUES ('6', '7', 'images/136f2f37a1324b8b8240aec6c6c0805a.jpg', '2019-03-31 08:00:00', '2019-03-31 08:00:00');
INSERT INTO `article_image` VALUES ('7', '8', 'images/136f2f37a1324b8b8240aec6c6c0805a.jpg', '2019-03-26 19:38:20', '2019-03-26 19:38:20');
INSERT INTO `article_image` VALUES ('8', '9', 'images/136f2f37a1324b8b8240aec6c6c0805a.jpg', '2019-03-26 11:38:20', '2019-03-26 11:38:20');
INSERT INTO `article_image` VALUES ('9', '10', 'images/5a41e290c6fd4c09ab2c5d015135afc5.jpeg', '2019-03-27 10:07:34', '2019-03-27 10:07:34');
INSERT INTO `article_image` VALUES ('10', '11', 'images/188cc12b5ce6477fb1ef1ed31fde847c.jpg', '2019-03-27 11:20:53', '2019-03-27 11:20:53');
INSERT INTO `article_image` VALUES ('11', '12', 'images/188cc12b5ce6477fb1ef1ed31fde847c.jpg', '2019-03-27 11:46:42', '2019-03-27 11:46:42');
INSERT INTO `article_image` VALUES ('12', '13', 'images/188cc12b5ce6477fb1ef1ed31fde847c.jpg', '2019-03-27 11:47:21', '2019-03-27 11:47:21');
INSERT INTO `article_image` VALUES ('13', '14', 'images/188cc12b5ce6477fb1ef1ed31fde847c.jpg', '2019-03-27 11:48:47', '2019-03-27 11:48:47');
INSERT INTO `article_image` VALUES ('14', '15', 'images/27a574115cbe4dc5b3fb6effe259840e.jpg', '2019-03-27 15:00:58', '2019-03-27 15:00:58');
INSERT INTO `article_image` VALUES ('15', '16', 'images/188cc12b5ce6477fb1ef1ed31fde847c.jpg', '2019-03-28 11:28:24', '2019-03-28 11:28:24');
INSERT INTO `article_image` VALUES ('16', '17', 'images/188cc12b5ce6477fb1ef1ed31fde847c.jpg', '2019-03-28 11:34:14', '2019-03-28 11:34:14');
INSERT INTO `article_image` VALUES ('17', '1', 'images/188cc12b5ce6477fb1ef1ed31fde847c.jpg', '2019-03-28 17:03:04', '2019-03-28 17:03:10');
INSERT INTO `article_image` VALUES ('18', '18', 'images/188cc12b5ce6477fb1ef1ed31fde847c.jpg', '2019-03-29 09:58:09', '2019-03-29 09:58:09');
INSERT INTO `article_image` VALUES ('19', '19', 'images/188cc12b5ce6477fb1ef1ed31fde847c.jpg', '2019-04-01 11:52:21', '2019-04-01 11:52:21');
INSERT INTO `article_image` VALUES ('20', '20', 'images/188cc12b5ce6477fb1ef1ed31fde847c.jpg', '2019-04-01 13:26:39', '2019-04-01 13:26:39');
INSERT INTO `article_image` VALUES ('21', '21', 'images/188cc12b5ce6477fb1ef1ed31fde847c.jpg', '2019-04-01 13:31:32', '2019-04-01 13:31:32');
INSERT INTO `article_image` VALUES ('22', '22', 'images/66b280a8d027448884b7d92e6e7ee964.jpg', '2019-04-09 14:17:48', '2019-04-09 14:17:48');
INSERT INTO `article_image` VALUES ('23', '23', 'images/9ca2a8b17f874c2f9d0352ba8d7d04c2.jpg', '2019-04-30 17:29:03', '2019-04-30 17:29:03');
INSERT INTO `article_image` VALUES ('24', '24', 'images/6147626fd0f14cefb12065798a1640e0.jpeg', '2019-04-30 17:32:12', '2019-04-30 17:32:12');
INSERT INTO `article_image` VALUES ('25', '25', 'images/6147626fd0f14cefb12065798a1640e0.jpeg', '2019-04-30 17:33:22', '2019-04-30 17:33:22');

-- ----------------------------
-- Table structure for `article_information`
-- ----------------------------
DROP TABLE IF EXISTS `article_information`;
CREATE TABLE `article_information` (
  `id` bigint(40) NOT NULL AUTO_INCREMENT,
  `title` varchar(50) NOT NULL DEFAULT '' COMMENT '文章标题',
  `summary` varchar(300) NOT NULL DEFAULT '' COMMENT '文章简介',
  `is_top` tinyint(1) NOT NULL DEFAULT '1' COMMENT '是否置顶，1为置顶，0为不置顶',
  `hits` int(10) NOT NULL DEFAULT '0' COMMENT '文章访问量',
  `create_by` datetime NOT NULL COMMENT '文章创建时间',
  `modified_by` datetime NOT NULL COMMENT '文章修改时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=26 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of article_information
-- ----------------------------
INSERT INTO `article_information` VALUES ('1', '论mysql的安装与卸载的过程', 'mysql相关知识点', '1', '6', '2019-03-25 08:00:00', '2019-03-25 08:00:00');
INSERT INTO `article_information` VALUES ('2', '论mysql的安装与卸载的过程', 'mysql相关知识点', '1', '0', '2019-03-25 08:00:00', '2019-03-25 08:00:00');
INSERT INTO `article_information` VALUES ('3', '论mysql的安装与卸载的过程', 'mysql相关知识点', '1', '6', '2019-03-25 08:00:00', '2019-03-25 08:00:00');
INSERT INTO `article_information` VALUES ('4', '论mysql的安装与卸载s的过程', 'mysql相关知识点', '1', '0', '2019-03-26 08:00:00', '2019-03-26 08:00:00');
INSERT INTO `article_information` VALUES ('5', '论mysql的安装与卸载s的过程', 'mysql相关知识点', '1', '12', '2019-03-26 08:00:00', '2019-03-26 08:00:00');
INSERT INTO `article_information` VALUES ('6', '论mysql的安装与卸载s的过程', 'mysql相关知识点', '1', '6', '2019-03-29 08:00:00', '2019-03-29 08:00:00');
INSERT INTO `article_information` VALUES ('7', '论mysql的安装与卸载s的过程', 'mysql相关知识点', '1', '40', '2019-03-31 08:00:00', '2019-03-31 08:00:00');
INSERT INTO `article_information` VALUES ('8', '论mysql的安装与卸载s的过程', 'mysql相关知识点', '1', '94', '2019-03-26 19:38:20', '2019-03-26 19:38:20');
INSERT INTO `article_information` VALUES ('9', '论mysql的安装与卸载s的过程', 'mysql相关知识点', '1', '78', '2019-03-26 11:38:20', '2019-03-26 11:38:20');
INSERT INTO `article_information` VALUES ('10', '梵蒂冈一天就混一天', '跟他如何有条件', '1', '4207', '2019-03-27 10:07:34', '2019-03-27 10:07:34');
INSERT INTO `article_information` VALUES ('11', '获得释放九零后都是', '是否电热管', '1', '0', '2019-03-27 11:20:53', '2019-03-27 11:20:53');
INSERT INTO `article_information` VALUES ('12', '法国v发', '对方沟通然', '1', '16', '2019-03-27 11:46:42', '2019-03-27 11:46:42');
INSERT INTO `article_information` VALUES ('13', 'v分布广泛', '风格统一和', '1', '14', '2019-03-27 11:47:21', '2019-03-27 11:47:21');
INSERT INTO `article_information` VALUES ('14', 'v的头发和共同', '刚踏入婚姻他', '1', '87', '2019-03-27 11:48:47', '2019-03-27 11:48:47');
INSERT INTO `article_information` VALUES ('15', '的v发v', '对方沟通然', '1', '809', '2019-03-27 15:00:58', '2019-03-27 15:00:58');
INSERT INTO `article_information` VALUES ('16', '房东沟通如果', '福特容易被v', '1', '84', '2019-03-28 11:28:24', '2019-03-28 11:28:24');
INSERT INTO `article_information` VALUES ('17', '阿斯顿侧王妃', '深度访谈如风', '1', '93', '2019-03-28 11:34:14', '2019-03-28 11:34:14');
INSERT INTO `article_information` VALUES ('18', 'ddddddd', 'fdgsdgrth', '1', '15', '2019-03-29 09:58:09', '2019-03-29 09:58:09');
INSERT INTO `article_information` VALUES ('19', '吧v发短信给还不够发达', '发表共同对付还不同意地方', '1', '190', '2019-04-01 11:52:21', '2019-04-01 11:52:21');
INSERT INTO `article_information` VALUES ('20', '吧v发短信给还不够发达', '发表共同对付还不同意地方', '1', '171', '2019-04-01 13:26:39', '2019-04-01 13:26:39');
INSERT INTO `article_information` VALUES ('21', '房东沟通如果', '福特容易被v', '1', '1587', '2019-04-01 13:31:32', '2019-04-01 13:31:32');
INSERT INTO `article_information` VALUES ('22', '非官方', '发表的观点', '1', '2639', '2019-04-09 14:17:48', '2019-04-09 14:17:48');
INSERT INTO `article_information` VALUES ('23', '表格test', '表格test', '1', '30', '2019-04-30 17:29:03', '2019-04-30 17:29:03');
INSERT INTO `article_information` VALUES ('24', '表格test2', '表格test2', '1', '14', '2019-04-30 17:32:12', '2019-04-30 17:32:12');
INSERT INTO `article_information` VALUES ('25', '表格test2', '表格test2', '1', '330', '2019-04-30 17:33:22', '2019-04-30 17:33:22');

-- ----------------------------
-- Table structure for `category`
-- ----------------------------
DROP TABLE IF EXISTS `category`;
CREATE TABLE `category` (
  `id` bigint(40) NOT NULL AUTO_INCREMENT,
  `name` varchar(20) NOT NULL COMMENT '分类名称',
  `art_number` tinyint(10) NOT NULL DEFAULT '0' COMMENT '每个分类下的文章数量',
  `create_by` datetime NOT NULL COMMENT '分类创建时间',
  `modified_by` datetime NOT NULL COMMENT '分类修改时间',
  `is_effective` tinyint(1) NOT NULL DEFAULT '1' COMMENT '是否有效，默认1有效，0无效',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=33 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of category
-- ----------------------------
INSERT INTO `category` VALUES ('1', 'React', '4', '2019-04-04 10:44:05', '2019-04-03 10:44:14', '1');
INSERT INTO `category` VALUES ('3', 'c++', '1', '2019-03-04 08:00:00', '2019-03-04 08:00:00', '1');
INSERT INTO `category` VALUES ('4', 'newType', '0', '2019-03-04 08:00:00', '2019-03-04 08:00:00', '1');
INSERT INTO `category` VALUES ('5', 'spring1234', '0', '2019-03-04 08:00:00', '2019-03-04 08:00:00', '1');
INSERT INTO `category` VALUES ('19', 'nodeJS', '0', '2019-03-19 14:20:50', '2019-03-19 14:20:50', '1');
INSERT INTO `category` VALUES ('20', '三十七', '0', '2019-03-19 14:22:09', '2019-04-09 14:34:44', '1');
INSERT INTO `category` VALUES ('24', 'JAVA', '5', '2019-03-19 16:08:48', '2019-03-19 16:08:48', '1');
INSERT INTO `category` VALUES ('25', 'ReactJS', '2', '2019-03-19 16:09:43', '2019-03-19 16:09:43', '1');
INSERT INTO `category` VALUES ('26', 'React123', '0', '2019-03-19 16:18:25', '2019-03-19 16:18:25', '1');
INSERT INTO `category` VALUES ('27', 'vUE1234', '0', '2019-03-19 16:20:41', '2019-03-19 16:20:41', '1');
INSERT INTO `category` VALUES ('28', 'LLLLL', '2', '2019-03-19 16:22:47', '2019-04-08 15:12:22', '1');
INSERT INTO `category` VALUES ('31', '随笔', '9', '2019-03-26 08:56:56', '2019-03-26 08:56:56', '1');
INSERT INTO `category` VALUES ('32', 'VUE', '1', '2019-04-18 10:51:51', '2019-04-18 10:51:51', '1');

-- ----------------------------
-- Table structure for `comment`
-- ----------------------------
DROP TABLE IF EXISTS `comment`;
CREATE TABLE `comment` (
  `id` bigint(40) NOT NULL AUTO_INCREMENT COMMENT '游客id主键',
  `content` varchar(200) NOT NULL DEFAULT '' COMMENT '留言/评论内容',
  `create_by` datetime NOT NULL COMMENT '评论时间',
  `email` varchar(20) NOT NULL DEFAULT '' COMMENT '用户邮箱',
  `name` varchar(20) NOT NULL DEFAULT '' COMMENT '用户名',
  `ip` varchar(20) NOT NULL DEFAULT '' COMMENT '访问的ip地址',
  `is_effective` tinyint(1) NOT NULL DEFAULT '1' COMMENT '是否有效，默认1有效，0无效',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=32 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of comment
-- ----------------------------
INSERT INTO `comment` VALUES ('1', '写的不错，点个赞', '2019-04-09 13:50:53', '', '', '0:0:0:0:0:0:0:1', '1');
INSERT INTO `comment` VALUES ('2', '再来测试下评论啊啊', '2019-04-09 14:20:53', '', '猴子大王', '0:0:0:0:0:0:0:1', '1');
INSERT INTO `comment` VALUES ('3', '哇咔咔，超级好看的了', '2019-04-09 14:28:14', '', '时光笔墨', '127.0.0.1', '1');
INSERT INTO `comment` VALUES ('4', '真是最最好看的啦，打call!打call!', '2019-04-09 14:31:06', '', '颖宝宝', '127.0.0.1', '1');
INSERT INTO `comment` VALUES ('5', 'sdf5terhgythgfn', '2019-04-09 16:26:59', '', 'dsfsd', '127.0.0.1', '1');
INSERT INTO `comment` VALUES ('6', '手机打开', '2019-04-10 14:43:19', '', '我的妈耶', '127.0.0.1', '1');
INSERT INTO `comment` VALUES ('7', '史蒂芬给v让它发挥哥特如果法官的人提供方便v吃干饭的内部v吃v方式相比v头发的和个人体育馆和北方的让他发的', '2019-04-10 14:43:56', '', '梵蒂冈', '127.0.0.1', '1');
INSERT INTO `comment` VALUES ('8', '梵蒂冈和法国的你', '2019-04-10 14:44:32', '', '而通过的', '127.0.0.1', '1');
INSERT INTO `comment` VALUES ('9', '的风格的认同感', '2019-04-10 14:45:12', '', '法国', '127.0.0.1', '1');
INSERT INTO `comment` VALUES ('10', '官方后备干部', '2019-04-10 14:46:00', '', 'vbvc', '127.0.0.1', '1');
INSERT INTO `comment` VALUES ('11', '肯定没法给劳动模范蒙古包，负担的看法据科学，美女们面向女', '2019-04-10 14:46:00', '', '很干净', '127.0.0.1', '1');
INSERT INTO `comment` VALUES ('12', '你真的好好呀', '2019-04-18 10:48:21', '', '不不不', '127.0.0.1', '1');
INSERT INTO `comment` VALUES ('13', '许校长', '2019-04-18 15:36:37', '', '现场v下', '127.0.0.1', '1');
INSERT INTO `comment` VALUES ('14', '已不大', '2019-04-18 15:41:09', '', '啊哈哈', '127.0.0.1', '1');
INSERT INTO `comment` VALUES ('15', '不管不管，就是测试呀', '2019-04-18 15:44:40', '', '我不管', '127.0.0.1', '1');
INSERT INTO `comment` VALUES ('16', '我是谁，你又是谁？', '2019-04-18 15:44:40', '', '你猜测你', '127.0.0.1', '1');
INSERT INTO `comment` VALUES ('17', 'mysql测试测试呀', '2019-04-18 15:51:45', '', '123', '127.0.0.1', '1');
INSERT INTO `comment` VALUES ('18', '的方式', '2019-04-18 15:53:37', '', '热', '127.0.0.1', '1');
INSERT INTO `comment` VALUES ('19', '我就是小小的你啊', '2019-04-18 16:54:25', '', '小小', '127.0.0.1', '1');
INSERT INTO `comment` VALUES ('20', '所有的深沉啊', '2019-04-19 10:21:37', '', '寻不到', '127.0.0.1', '1');
INSERT INTO `comment` VALUES ('21', '的地方', '2019-04-19 13:22:50', '', '顶顶顶', '127.0.0.1', '1');
INSERT INTO `comment` VALUES ('22', '傻大个如同一个但是否过热统一公布v奋斗过而为人父v的风格v辅导班', '2019-04-30 13:25:12', '', '风格的', '127.0.0.1', '1');
INSERT INTO `comment` VALUES ('23', 'tttte', '2019-05-06 10:00:41', '', 'kkkk', '127.0.0.1', '1');
INSERT INTO `comment` VALUES ('24', 'fgertg', '2019-05-06 14:03:42', '', 'cxv', '127.0.0.1', '1');
INSERT INTO `comment` VALUES ('25', '坚持不懈的评论', '2019-05-08 11:20:09', '', '小小', '127.0.0.1', '1');
INSERT INTO `comment` VALUES ('26', '我就是我，颜色不一样的烟火', '2019-05-08 11:20:09', '', '小小', '127.0.0.1', '1');
INSERT INTO `comment` VALUES ('27', '是我呀', '2019-05-08 11:24:40', '', '小熊啊', '127.0.0.1', '1');
INSERT INTO `comment` VALUES ('28', '你是谁呢', '2019-05-08 11:24:48', '', '小熊啊', '127.0.0.1', '1');
INSERT INTO `comment` VALUES ('29', 'dfgfd', '2019-05-08 14:49:22', '', 'vcfds', '127.0.0.1', '1');
INSERT INTO `comment` VALUES ('30', 'ndsnfs', '2019-05-09 09:52:10', '', 'nfd.s', '127.0.0.1', '1');
INSERT INTO `comment` VALUES ('31', 'sfs', '2019-05-13 15:09:05', '', 'jlh', '127.0.0.1', '1');

-- ----------------------------
-- Table structure for `comment_reply`
-- ----------------------------
DROP TABLE IF EXISTS `comment_reply`;
CREATE TABLE `comment_reply` (
  `id` bigint(40) NOT NULL AUTO_INCREMENT COMMENT '游客评论id主键',
  `comment_id` bigint(40) NOT NULL COMMENT '所回复的评论的id',
  `content` varchar(200) NOT NULL DEFAULT '' COMMENT '留言/评论内容',
  `create_by` datetime NOT NULL COMMENT '评论时间',
  `email` varchar(20) NOT NULL DEFAULT '' COMMENT '用户邮箱',
  `name` varchar(20) NOT NULL DEFAULT '' COMMENT '用户名',
  `ip` varchar(20) NOT NULL DEFAULT '' COMMENT '访问的ip地址',
  `is_effective` tinyint(1) NOT NULL DEFAULT '1' COMMENT '是否有效，默认1有效，0无效',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=16 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of comment_reply
-- ----------------------------
INSERT INTO `comment_reply` VALUES ('1', '7', '没有错，不能更赞同你的观点啦', '2019-05-07 14:37:00', '', '猴子请来的逗比', '0:0:0:0:0:0:0:1', '1');
INSERT INTO `comment_reply` VALUES ('2', '7', '同意楼上', '2019-05-07 15:07:00', '', '猴子逗比', '0:0:0:0:0:0:0:1', '1');
INSERT INTO `comment_reply` VALUES ('3', '7', '臣附议', '2019-05-07 15:07:00', '', '猴子逗比是', '0:0:0:0:0:0:0:1', '1');
INSERT INTO `comment_reply` VALUES ('4', '7', '你猜猜我是谁呢', '2019-05-08 11:17:05', '', '小小呀', '127.0.0.1', '1');
INSERT INTO `comment_reply` VALUES ('5', '8', '嘿嘿嘿', '2019-05-08 11:17:05', '', '小小呀', '127.0.0.1', '1');
INSERT INTO `comment_reply` VALUES ('6', '8', '啧啧啧', '2019-05-08 11:17:05', '', '小小呀', '127.0.0.1', '1');
INSERT INTO `comment_reply` VALUES ('7', '8', '好天气', '2019-05-08 11:20:13', '', 'kkk', '127.0.0.1', '1');
INSERT INTO `comment_reply` VALUES ('8', '8', '楼上说的甚是有理', '2019-05-08 11:20:35', '', 'kkk', '127.0.0.1', '1');
INSERT INTO `comment_reply` VALUES ('9', '7', 'sdfdfdcxv', '2019-05-08 17:06:11', '', 'cd', '127.0.0.1', '1');
INSERT INTO `comment_reply` VALUES ('10', '25', 'dsfvcv', '2019-05-09 09:52:59', '', 'nvjx', '0:0:0:0:0:0:0:1', '1');
INSERT INTO `comment_reply` VALUES ('11', '6', '试点房产税的', '2019-05-10 11:53:23', '', '啊速度测试', '0:0:0:0:0:0:0:1', '1');
INSERT INTO `comment_reply` VALUES ('12', '6', '678', '2019-05-10 11:53:39', '', '7777', '127.0.0.1', '1');
INSERT INTO `comment_reply` VALUES ('13', '3', '回复测试', '2019-05-13 15:09:09', '', 'KKK', '127.0.0.1', '1');
INSERT INTO `comment_reply` VALUES ('14', '3', '哈哈哈哈哈', '2019-05-13 15:09:44', '', '888', '0:0:0:0:0:0:0:1', '1');
INSERT INTO `comment_reply` VALUES ('15', '3', '楼上，我们是兄弟啊', '2019-05-13 15:09:56', '', '8888', '0:0:0:0:0:0:0:1', '1');

-- ----------------------------
-- Table structure for `draft`
-- ----------------------------
DROP TABLE IF EXISTS `draft`;
CREATE TABLE `draft` (
  `id` bigint(40) NOT NULL AUTO_INCREMENT,
  `author` varchar(20) NOT NULL DEFAULT 'chenxq',
  `title` varchar(50) NOT NULL DEFAULT '' COMMENT '文章标题',
  `summary` varchar(300) NOT NULL DEFAULT '' COMMENT '文章简介',
  `content` text NOT NULL,
  `create_by` datetime NOT NULL COMMENT '创建时间',
  `modified_by` datetime NOT NULL COMMENT '更新时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of draft
-- ----------------------------
INSERT INTO `draft` VALUES ('4', 'chenxq', '方沟通然', '广泛认同个人', '重复感染他也人', '2019-03-27 15:16:17', '2019-03-27 15:16:17');
INSERT INTO `draft` VALUES ('5', 'chenxq', 'V》nhg；u以方便v能力和官方；，哪怕【一套房，和b', '可促进面部v弄i应该分开今后try【i考核表v；看美女有【‘投个票会更明白v美女平衡各方', '风格和加内特翻译看见美女表面划过附近有静安大火附属卡红色反扑额外三回复觉得你夫君奥克苏瓦而非角色的画风讲究的是几点睡啊防火卷帘卡和尚房价跌幅扩大解放阿斯顿回复就撒了回复\n你觉得双方距离喀什发的链接而我i\n的那份垃圾啊开始的覅破二级台风\n框架搭建诺福克例如覅偶尔怕人家覅的\n#### v看见你们电视机分厘卡女郎单身妇女\ndjsfoiejmc.nv虚空假面v付款\n++反对v看电视了JFK男方女方++\n![3b63c6921668aa3d5d17736ea1a33cc5.jpeg](/server/images/98527d460e494f31942eb133e380b317.jpeg)', '2019-04-02 10:39:29', '2019-04-02 10:39:29');
INSERT INTO `draft` VALUES ('6', 'chenxq', 'sdfer', 'dsfewf', 'dsff', '2019-04-08 15:04:07', '2019-04-08 15:04:07');

-- ----------------------------
-- Table structure for `recommend`
-- ----------------------------
DROP TABLE IF EXISTS `recommend`;
CREATE TABLE `recommend` (
  `id` mediumint(6) unsigned NOT NULL AUTO_INCREMENT,
  `url` varchar(50) NOT NULL DEFAULT '',
  `title` varchar(40) NOT NULL DEFAULT '',
  `summary` varchar(200) DEFAULT '',
  `create_by` datetime NOT NULL COMMENT '推荐的创建时间',
  `is_effective` tinyint(1) NOT NULL DEFAULT '1' COMMENT '是否有效，默认1有效，0无效',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of recommend
-- ----------------------------
INSERT INTO `recommend` VALUES ('1', 'http://www.baidu.com', '百度', 'ds', '2019-04-27 11:11:38', '1');
INSERT INTO `recommend` VALUES ('2', 'https://element.eleme.cn/#/zh-CN', '网站快速成型工具', 'Element，一套为开发者、设计师和产品经理准备的基于 Vue 2.0 的桌面端组件库', '2019-04-26 11:38:20', '1');
INSERT INTO `recommend` VALUES ('5', 'http://pro.ant.design/docs/getting-started-cn', 'ant-design-pro文档', 'Ant Design Pro 是一个企业级中后台前端/设计解决方案，适合后台管理系统的搭建', '2019-04-27 16:10:25', '1');

-- ----------------------------
-- Table structure for `system_log`
-- ----------------------------
DROP TABLE IF EXISTS `system_log`;
CREATE TABLE `system_log` (
  `id` bigint(40) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `requestip` varchar(20) NOT NULL DEFAULT ' ' COMMENT '访问的ip地址',
  `operate_type` varchar(5) NOT NULL DEFAULT ' ' COMMENT '操作类型',
  `userid` varchar(20) DEFAULT NULL COMMENT '操作人ID',
  `exceptioncode` varchar(20) DEFAULT NULL COMMENT '异常code',
  `exceptiondetail` varchar(255) DEFAULT NULL COMMENT '异常详情',
  `actiondate` datetime NOT NULL COMMENT '操作时间',
  `description` varchar(255) NOT NULL DEFAULT '' COMMENT '操作内容',
  `actionmethod` varchar(20) DEFAULT NULL COMMENT '请求方法',
  `params` varchar(50) DEFAULT NULL COMMENT '请求参数',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of system_log
-- ----------------------------

-- ----------------------------
-- Table structure for `sys_log`
-- ----------------------------
DROP TABLE IF EXISTS `sys_log`;
CREATE TABLE `sys_log` (
  `id` bigint(40) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `ip` varchar(20) NOT NULL DEFAULT ' ' COMMENT '访问的ip地址',
  `create_by` datetime NOT NULL COMMENT '操作时间',
  `remark` varchar(255) NOT NULL DEFAULT '' COMMENT '操作内容',
  `operate_url` varchar(50) NOT NULL DEFAULT '' COMMENT '操作的访问地址',
  `operate_by` varchar(20) DEFAULT '' COMMENT '操作的浏览器',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=102 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of sys_log
-- ----------------------------
INSERT INTO `sys_log` VALUES ('1', '0:0:0:0:0:0:0:1', '2019-04-08 13:58:01', '成功', '', 'chenxiaoqing');
INSERT INTO `sys_log` VALUES ('2', '172.18.225.49', '2019-04-08 14:02:30', '成功', '', 'chenxiaoqing');
INSERT INTO `sys_log` VALUES ('3', '172.18.225.49', '2019-04-08 14:16:32', '成功', '', 'chenxiaoqing');
INSERT INTO `sys_log` VALUES ('4', '172.18.225.49', '2019-04-08 14:21:03', '根据用户名查找用户详情信息成功', '', 'chenxiaoqing');
INSERT INTO `sys_log` VALUES ('5', '172.18.225.49', '2019-04-08 14:21:33', '根据用户名查找用户详情信息成功', '', 'chenxiaoqing');
INSERT INTO `sys_log` VALUES ('6', '172.18.225.49', '2019-04-08 14:21:43', '根据用户名查找用户详情信息成功', '', 'chenxiaoqing');
INSERT INTO `sys_log` VALUES ('7', '172.18.225.49', '2019-04-08 14:23:40', '此用户不存在', '', 'chenxiaoqing');
INSERT INTO `sys_log` VALUES ('8', '172.18.225.49', '2019-04-08 14:27:39', '操作结果:404,原因：此用户不存在', '', 'chenxiaoqing');
INSERT INTO `sys_log` VALUES ('9', '172.18.225.49', '2019-04-08 14:45:48', '操作结果:404,原因：此用户不存在', 'http://172.18.130.222:8080/admin/finduser', 'chenxiaoqing');
INSERT INTO `sys_log` VALUES ('10', '0:0:0:0:0:0:0:1', '2019-04-08 14:50:05', '操作结果:1,原因：成功', 'http://localhost:8080/admin/category/add', 'chenxiaoqing');
INSERT INTO `sys_log` VALUES ('11', '0:0:0:0:0:0:0:1', '2019-04-08 14:51:40', '操作结果:102,原因：此分类已存在', 'http://localhost:8080/admin/category/add', 'chenxiaoqing');
INSERT INTO `sys_log` VALUES ('12', '127.0.0.1', '2019-04-08 15:06:34', '操作结果:1,原因：添加分类成功', 'http://127.0.0.1:8080/admin/category/add', 'chenxiaoqing');
INSERT INTO `sys_log` VALUES ('13', '127.0.0.1', '2019-04-08 15:07:43', '操作结果:1,删除分类spring123成功', 'http://127.0.0.1:8080/admin/category/delete', 'chenxiaoqing');
INSERT INTO `sys_log` VALUES ('14', '127.0.0.1', '2019-04-08 15:12:23', '操作结果:1,修改分类为LLLLL成功', 'http://127.0.0.1:8080/admin/category/update', 'chenxiaoqing');
INSERT INTO `sys_log` VALUES ('15', '127.0.0.1', '2019-04-09 09:33:50', '操作结果:1,添加分类沟通成功', 'http://127.0.0.1:8080/admin/category/add', 'chenxiaoqing');
INSERT INTO `sys_log` VALUES ('16', '0:0:0:0:0:0:0:1', '2019-04-09 13:52:22', '操作结果:1,发表文章评论成功', 'http://localhost:8080/admin/comment/add', 'chenxiaoqing');
INSERT INTO `sys_log` VALUES ('17', '0:0:0:0:0:0:0:1', '2019-04-09 13:54:45', '操作结果:1,发表文章评论成功', 'http://localhost:8080/admin/comment/add', 'chenxiaoqing');
INSERT INTO `sys_log` VALUES ('18', '127.0.0.1', '2019-04-09 14:17:49', '操作结果:1,添加文章成功', 'http://127.0.0.1:8080/admin/article/add', 'chenxiaoqing');
INSERT INTO `sys_log` VALUES ('19', '127.0.0.1', '2019-04-09 14:28:37', '操作结果:1,发表文章评论成功', 'http://127.0.0.1:8080/admin/comment/add', 'chenxiaoqing');
INSERT INTO `sys_log` VALUES ('20', '127.0.0.1', '2019-04-09 14:32:15', '操作结果:1,发表文章评论成功', 'http://127.0.0.1:8080/admin/comment/add', 'chenxiaoqing');
INSERT INTO `sys_log` VALUES ('21', '127.0.0.1', '2019-04-09 14:34:45', '操作结果:1,修改分类为三十七成功', 'http://127.0.0.1:8080/admin/category/update', 'chenxiaoqing');
INSERT INTO `sys_log` VALUES ('22', '127.0.0.1', '2019-04-09 16:27:26', '操作结果:1,发表文章评论成功', 'http://127.0.0.1:8080/admin/comment/add', 'chenxiaoqing');
INSERT INTO `sys_log` VALUES ('23', '127.0.0.1', '2019-04-10 14:43:33', '操作结果:1,发表文章评论成功', 'http://127.0.0.1:8080/admin/comment/add', 'chenxiaoqing');
INSERT INTO `sys_log` VALUES ('24', '127.0.0.1', '2019-04-10 14:44:09', '操作结果:1,发表文章评论成功', 'http://127.0.0.1:8080/admin/comment/add', 'chenxiaoqing');
INSERT INTO `sys_log` VALUES ('25', '127.0.0.1', '2019-04-10 14:44:47', '操作结果:1,发表文章评论成功', 'http://127.0.0.1:8080/admin/comment/add', 'chenxiaoqing');
INSERT INTO `sys_log` VALUES ('26', '127.0.0.1', '2019-04-10 14:45:21', '操作结果:1,发表文章评论成功', 'http://127.0.0.1:8080/admin/comment/add', 'chenxiaoqing');
INSERT INTO `sys_log` VALUES ('27', '127.0.0.1', '2019-04-10 14:46:10', '操作结果:1,发表文章评论成功', 'http://127.0.0.1:8080/admin/comment/add', 'chenxiaoqing');
INSERT INTO `sys_log` VALUES ('28', '127.0.0.1', '2019-04-10 14:47:06', '操作结果:1,发表文章评论成功', 'http://127.0.0.1:8080/admin/comment/add', 'chenxiaoqing');
INSERT INTO `sys_log` VALUES ('29', '127.0.0.1', '2019-04-10 14:48:57', '操作结果:1,删除分类沟通成功', 'http://127.0.0.1:8080/admin/category/delete', 'chenxiaoqing');
INSERT INTO `sys_log` VALUES ('30', '127.0.0.1', '2019-04-18 10:48:35', '操作结果:1,发表文章评论成功', 'http://127.0.0.1:8080/admin/comment/add', 'chenxiaoqing');
INSERT INTO `sys_log` VALUES ('31', '127.0.0.1', '2019-04-18 10:51:51', '操作结果:1,添加分类VUE成功', 'http://127.0.0.1:8080/admin/category/add', 'chenxiaoqing');
INSERT INTO `sys_log` VALUES ('32', '127.0.0.1', '2019-04-18 15:37:54', '操作结果:1,发表文章评论成功', 'http://127.0.0.1:8080/client/comment/add', 'chenxiaoqing');
INSERT INTO `sys_log` VALUES ('33', '127.0.0.1', '2019-04-18 15:41:30', '操作结果:1,发表文章评论成功', 'http://127.0.0.1:8080/client/comment/add', 'chenxiaoqing');
INSERT INTO `sys_log` VALUES ('34', '127.0.0.1', '2019-04-18 15:45:03', '操作结果:1,发表文章评论成功', 'http://127.0.0.1:8080/client/comment/add', 'chenxiaoqing');
INSERT INTO `sys_log` VALUES ('35', '127.0.0.1', '2019-04-18 15:46:01', '操作结果:1,发表文章评论成功', 'http://127.0.0.1:8080/client/comment/add', 'chenxiaoqing');
INSERT INTO `sys_log` VALUES ('36', '127.0.0.1', '2019-04-18 15:52:07', '操作结果:1,发表文章评论成功', 'http://127.0.0.1:8080/client/comment/add', 'chenxiaoqing');
INSERT INTO `sys_log` VALUES ('37', '127.0.0.1', '2019-04-18 15:53:46', '操作结果:1,发表文章评论成功', 'http://127.0.0.1:8080/client/comment/add', 'chenxiaoqing');
INSERT INTO `sys_log` VALUES ('38', '127.0.0.1', '2019-04-18 16:54:57', '操作结果:1,发表文章评论成功', 'http://127.0.0.1:8080/client/comment/add', 'chenxiaoqing');
INSERT INTO `sys_log` VALUES ('39', '127.0.0.1', '2019-04-19 10:22:08', '操作结果:1,发表文章评论成功', 'http://127.0.0.1:8080/client/comment/add', 'chenxiaoqing');
INSERT INTO `sys_log` VALUES ('40', '127.0.0.1', '2019-04-19 13:25:00', '操作结果:1,发表文章评论成功', 'http://127.0.0.1:8080/client/comment/add', 'chenxiaoqing');
INSERT INTO `sys_log` VALUES ('41', '0:0:0:0:0:0:0:1', '2019-04-27 11:19:20', '操作结果:1,成功', 'http://localhost:8080/admin/recommend/add', 'chenxiaoqing');
INSERT INTO `sys_log` VALUES ('42', '0:0:0:0:0:0:0:1', '2019-04-27 11:20:02', '操作结果:1,成功', 'http://localhost:8080/admin/recommend/add', 'chenxiaoqing');
INSERT INTO `sys_log` VALUES ('43', '0:0:0:0:0:0:0:1', '2019-04-27 11:20:49', '操作结果:1,成功', 'http://localhost:8080/admin/recommend/delete', 'chenxiaoqing');
INSERT INTO `sys_log` VALUES ('44', '0:0:0:0:0:0:0:1', '2019-04-27 11:22:33', '操作结果:1,成功', 'http://localhost:8080/admin/recommend/delete', 'chenxiaoqing');
INSERT INTO `sys_log` VALUES ('45', '0:0:0:0:0:0:0:1', '2019-04-27 15:39:13', '操作结果:1,成功', 'http://localhost:8080/admin/recommend/update', 'chenxiaoqing');
INSERT INTO `sys_log` VALUES ('46', '127.0.0.1', '2019-04-27 16:10:26', '操作结果:1,成功', 'http://127.0.0.1:8080/admin/recommend/add', 'chenxiaoqing');
INSERT INTO `sys_log` VALUES ('47', '127.0.0.1', '2019-04-27 16:47:33', '操作结果:1,成功', 'http://127.0.0.1:8080/admin/recommend/delete', 'chenxiaoqing');
INSERT INTO `sys_log` VALUES ('48', '127.0.0.1', '2019-04-27 16:48:28', '操作结果:1,成功', 'http://127.0.0.1:8080/admin/recommend/delete', 'chenxiaoqing');
INSERT INTO `sys_log` VALUES ('49', '127.0.0.1', '2019-04-30 13:25:29', '操作结果:1,发表文章评论成功', 'http://127.0.0.1:8080/client/comment/add', 'chenxiaoqing');
INSERT INTO `sys_log` VALUES ('50', '127.0.0.1', '2019-04-30 17:29:04', '操作结果:1,添加文章成功', 'http://127.0.0.1:8080/admin/article/add', 'chenxiaoqing');
INSERT INTO `sys_log` VALUES ('51', '127.0.0.1', '2019-04-30 17:32:12', '操作结果:1,添加文章成功', 'http://127.0.0.1:8080/admin/article/add', 'chenxiaoqing');
INSERT INTO `sys_log` VALUES ('52', '127.0.0.1', '2019-04-30 17:33:23', '操作结果:1,添加文章成功', 'http://127.0.0.1:8080/admin/article/add', 'chenxiaoqing');
INSERT INTO `sys_log` VALUES ('53', '127.0.0.1', '2019-05-06 10:00:53', '操作结果:1,发表文章评论成功', 'http://127.0.0.1:8080/client/comment/add', 'chenxiaoqing');
INSERT INTO `sys_log` VALUES ('54', '127.0.0.1', '2019-05-06 14:03:49', '操作结果:1,发表文章评论成功', 'http://127.0.0.1:8080/client/comment/add', 'chenxiaoqing');
INSERT INTO `sys_log` VALUES ('55', '127.0.0.1', '2019-05-08 11:22:59', '操作结果:1,发表文章评论成功', 'http://127.0.0.1:8080/client/comment/add', 'chenxiaoqing');
INSERT INTO `sys_log` VALUES ('56', '127.0.0.1', '2019-05-08 11:23:32', '操作结果:1,发表文章评论成功', 'http://127.0.0.1:8080/client/comment/add', 'chenxiaoqing');
INSERT INTO `sys_log` VALUES ('57', '127.0.0.1', '2019-05-08 11:24:40', '操作结果:1,发表文章评论成功', 'http://127.0.0.1:8080/client/comment/add', 'chenxiaoqing');
INSERT INTO `sys_log` VALUES ('58', '127.0.0.1', '2019-05-08 11:24:48', '操作结果:1,发表文章评论成功', 'http://127.0.0.1:8080/client/comment/add', 'chenxiaoqing');
INSERT INTO `sys_log` VALUES ('59', '127.0.0.1', '2019-05-08 14:49:30', '操作结果:1,发表文章评论成功', 'http://127.0.0.1:8080/admin/comment/add', 'chenxiaoqing');
INSERT INTO `sys_log` VALUES ('60', '127.0.0.1', '2019-05-09 09:52:11', '操作结果:1,发表文章评论成功', 'http://localhost:8080/client/comment/add', 'chenxiaoqing');
INSERT INTO `sys_log` VALUES ('61', '127.0.0.1', '2019-05-13 15:09:05', '操作结果:1,发表文章评论成功', 'http://localhost:8080/client/comment/add', 'chenxiaoqing');
INSERT INTO `sys_log` VALUES ('62', '0:0:0:0:0:0:0:1', '2019-07-01 13:24:11', '操作结果:1,根据用户名查找用户详情信息成功', 'http://localhost:8080/admin/finduser', 'chenxiaoqing');
INSERT INTO `sys_log` VALUES ('63', '0:0:0:0:0:0:0:1', '2019-07-01 13:29:17', '操作结果:404,此用户不存在', 'http://localhost:8080/admin/finduser', 'chenxiaoqing');
INSERT INTO `sys_log` VALUES ('64', '0:0:0:0:0:0:0:1', '2019-07-01 13:29:33', '操作结果:1,根据用户名查找用户详情信息成功', 'http://localhost:8080/admin/finduser', 'chenxiaoqing');
INSERT INTO `sys_log` VALUES ('65', '0:0:0:0:0:0:0:1', '2019-07-01 13:35:31', '操作结果:404,此用户不存在', 'http://localhost:8080/admin/finduser', 'chenxiaoqing');
INSERT INTO `sys_log` VALUES ('66', '0:0:0:0:0:0:0:1', '2019-07-01 13:36:19', '操作结果:1,根据用户名查找用户详情信息成功', 'http://localhost:8080/admin/finduser', 'chenxiaoqing');
INSERT INTO `sys_log` VALUES ('67', '0:0:0:0:0:0:0:1', '2019-07-01 13:43:30', '操作结果:404,此用户不存在', 'http://localhost:8080/admin/finduser', 'chenxiaoqing');
INSERT INTO `sys_log` VALUES ('68', '0:0:0:0:0:0:0:1', '2019-07-01 13:44:22', '操作结果:1,根据用户名查找用户详情信息成功', 'http://localhost:8080/admin/finduser', 'chenxiaoqing');
INSERT INTO `sys_log` VALUES ('69', '0:0:0:0:0:0:0:1', '2019-07-01 13:44:57', '操作结果:1,根据用户名查找用户详情信息成功', 'http://localhost:8080/admin/finduser', 'chenxiaoqing');
INSERT INTO `sys_log` VALUES ('70', '0:0:0:0:0:0:0:1', '2019-07-01 13:47:45', '操作结果:1,根据用户名查找用户详情信息成功', 'http://localhost:8080/admin/finduser', 'chenxiaoqing');
INSERT INTO `sys_log` VALUES ('71', '0:0:0:0:0:0:0:1', '2019-07-01 13:47:53', '操作结果:1,根据用户名查找用户详情信息成功', 'http://localhost:8080/admin/finduser', 'chenxiaoqing');
INSERT INTO `sys_log` VALUES ('72', '0:0:0:0:0:0:0:1', '2019-07-01 13:48:57', '操作结果:1,根据用户名查找用户详情信息成功', 'http://localhost:8080/admin/finduser', 'chenxiaoqing');
INSERT INTO `sys_log` VALUES ('73', '0:0:0:0:0:0:0:1', '2019-07-01 14:02:22', '操作结果:1,根据用户名查找用户详情信息成功', 'http://localhost:8080/admin/finduser', 'chenxiaoqing');
INSERT INTO `sys_log` VALUES ('74', '0:0:0:0:0:0:0:1', '2019-07-01 14:02:40', '操作结果:1,根据用户名查找用户详情信息成功', 'http://localhost:8080/admin/finduser', 'chenxiaoqing');
INSERT INTO `sys_log` VALUES ('75', '0:0:0:0:0:0:0:1', '2019-07-01 14:03:23', '操作结果:1,根据用户名查找用户详情信息成功', 'http://localhost:8080/admin/finduser', 'chenxiaoqing');
INSERT INTO `sys_log` VALUES ('76', '0:0:0:0:0:0:0:1', '2019-07-01 16:24:04', '操作结果:404,此用户不存在', 'http://localhost:8080/admin/finduser', 'chenxiaoqing');
INSERT INTO `sys_log` VALUES ('77', '0:0:0:0:0:0:0:1', '2019-07-01 16:58:14', '操作结果:404,此用户不存在', 'http://localhost:8080/admin/finduser', 'chenxiaoqing');
INSERT INTO `sys_log` VALUES ('78', '0:0:0:0:0:0:0:1', '2019-07-01 16:58:22', '操作结果:404,此用户不存在', 'http://localhost:8080/admin/finduser', 'chenxiaoqing');
INSERT INTO `sys_log` VALUES ('79', '0:0:0:0:0:0:0:1', '2019-07-01 17:02:13', '操作结果:404,此用户不存在', 'http://localhost:8080/admin/finduser', 'chenxiaoqing');
INSERT INTO `sys_log` VALUES ('80', '0:0:0:0:0:0:0:1', '2019-07-01 17:05:29', '操作结果:404,此用户不存在', 'http://localhost:8080/admin/finduser', 'chenxiaoqing');
INSERT INTO `sys_log` VALUES ('81', '0:0:0:0:0:0:0:1', '2019-07-01 17:05:33', '操作结果:404,此用户不存在', 'http://localhost:8080/admin/finduser', 'chenxiaoqing');
INSERT INTO `sys_log` VALUES ('82', '0:0:0:0:0:0:0:1', '2019-07-01 17:24:27', '操作结果:404,此用户不存在', 'http://localhost:8080/admin/finduser', 'chenxiaoqing');
INSERT INTO `sys_log` VALUES ('83', '0:0:0:0:0:0:0:1', '2019-07-02 10:06:37', '操作结果:404,此用户不存在', 'http://localhost:8080/admin/finduser', 'chenxiaoqing');
INSERT INTO `sys_log` VALUES ('84', '0:0:0:0:0:0:0:1', '2019-07-02 17:41:38', '操作结果:404,此用户不存在', 'http://localhost:8080/admin/finduser', 'chenxiaoqing');
INSERT INTO `sys_log` VALUES ('85', '0:0:0:0:0:0:0:1', '2019-07-02 17:41:45', '操作结果:404,此用户不存在', 'http://localhost:8080/admin/finduser', 'chenxiaoqing');
INSERT INTO `sys_log` VALUES ('86', '0:0:0:0:0:0:0:1', '2019-07-05 11:22:39', '操作结果:404,此用户不存在', 'http://localhost:8080/admin/finduser', 'chenxiaoqing');
INSERT INTO `sys_log` VALUES ('87', '0:0:0:0:0:0:0:1', '2019-07-05 11:22:43', '操作结果:404,此用户不存在', 'http://localhost:8080/admin/finduser', 'chenxiaoqing');
INSERT INTO `sys_log` VALUES ('88', '0:0:0:0:0:0:0:1', '2019-07-05 14:08:05', '操作结果:404,此用户不存在', 'http://localhost:8080/admin/finduser', 'chenxiaoqing');
INSERT INTO `sys_log` VALUES ('89', '0:0:0:0:0:0:0:1', '2019-07-05 14:09:43', '操作结果:404,此用户不存在', 'http://localhost:8080/admin/finduser', 'chenxiaoqing');
INSERT INTO `sys_log` VALUES ('90', '0:0:0:0:0:0:0:1', '2019-07-05 14:10:09', '操作结果:404,此用户不存在', 'http://localhost:8080/admin/finduser', 'chenxiaoqing');
INSERT INTO `sys_log` VALUES ('91', '0:0:0:0:0:0:0:1', '2019-07-05 14:10:59', '操作结果:404,此用户不存在', 'http://localhost:8080/admin/finduser', 'chenxiaoqing');
INSERT INTO `sys_log` VALUES ('92', '0:0:0:0:0:0:0:1', '2019-07-05 14:12:07', '操作结果:404,此用户不存在', 'http://localhost:8080/admin/finduser', 'chenxiaoqing');
INSERT INTO `sys_log` VALUES ('93', '0:0:0:0:0:0:0:1', '2019-07-05 14:12:30', '操作结果:404,此用户不存在', 'http://localhost:8080/admin/finduser', 'chenxiaoqing');
INSERT INTO `sys_log` VALUES ('94', '0:0:0:0:0:0:0:1', '2019-07-05 14:20:19', '操作结果:404,此用户不存在', 'http://localhost:8080/admin/finduser', 'chenxiaoqing');
INSERT INTO `sys_log` VALUES ('95', '0:0:0:0:0:0:0:1', '2019-07-05 14:20:49', '操作结果:1,根据用户名查找用户详情信息成功', 'http://localhost:8080/admin/finduser', 'chenxiaoqing');
INSERT INTO `sys_log` VALUES ('96', '0:0:0:0:0:0:0:1', '2019-07-05 14:23:43', '操作结果:404,此用户不存在', 'http://localhost:8080/admin/finduser', 'chenxiaoqing');
INSERT INTO `sys_log` VALUES ('97', '0:0:0:0:0:0:0:1', '2019-07-05 14:23:56', '操作结果:1,根据用户名查找用户详情信息成功', 'http://localhost:8080/admin/finduser', 'chenxiaoqing');
INSERT INTO `sys_log` VALUES ('98', '0:0:0:0:0:0:0:1', '2019-07-26 17:02:14', '操作结果:1,根据用户名查找用户详情信息成功', 'http://localhost:8080/admin/finduser', 'chenxiaoqing');
INSERT INTO `sys_log` VALUES ('99', '0:0:0:0:0:0:0:1', '2019-08-27 10:49:04', '操作结果:404,此用户不存在', 'http://localhost:8080/admin/finduser', 'chenxiaoqing');
INSERT INTO `sys_log` VALUES ('100', '0:0:0:0:0:0:0:1', '2020-08-08 17:24:49', '操作结果:1,根据用户名查找用户详情信息成功', 'http://localhost:8080/admin/finduser', 'chenxiaoqing');
INSERT INTO `sys_log` VALUES ('101', '0:0:0:0:0:0:0:1', '2020-08-08 17:27:02', '操作结果:1,添加用户chenxq成功', 'http://localhost:8080/admin/adduser', 'chenxiaoqing');

-- ----------------------------
-- Table structure for `sys_view`
-- ----------------------------
DROP TABLE IF EXISTS `sys_view`;
CREATE TABLE `sys_view` (
  `id` bigint(40) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `ip` varchar(20) NOT NULL DEFAULT '' COMMENT '访问的ip地址',
  `create_by` datetime NOT NULL COMMENT '浏览时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of sys_view
-- ----------------------------

-- ----------------------------
-- Table structure for `user`
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `user_id` mediumint(6) unsigned NOT NULL AUTO_INCREMENT,
  `username` varchar(20) NOT NULL DEFAULT '',
  `password` varchar(32) NOT NULL DEFAULT '',
  `lastloginip` varchar(15) DEFAULT '0',
  `lastlogintime` int(10) unsigned DEFAULT '0',
  `email` varchar(40) DEFAULT '',
  `realname` varchar(50) NOT NULL DEFAULT '',
  `status` tinyint(1) NOT NULL DEFAULT '1',
  PRIMARY KEY (`user_id`),
  KEY `username` (`username`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES ('5', 'xiaoqing_chen', 'ad3GB/ziWoV+GOAEIEEMTA==', '0', '0', '', '陈小青', '1');
INSERT INTO `user` VALUES ('6', 'chenxq', 'UZWpkottddE15xGRaXGWPQ==', '0', '0', '', '', '1');
