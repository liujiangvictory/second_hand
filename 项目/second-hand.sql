/*
Navicat MySQL Data Transfer

Source Server         : MySQL
Source Server Version : 80017
Source Host           : localhost:3306
Source Database       : second-hand

Target Server Type    : MYSQL
Target Server Version : 80017
File Encoding         : 65001

Date: 2023-03-08 14:02:24
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for admins
-- ----------------------------
DROP TABLE IF EXISTS `admins`;
CREATE TABLE `admins` (
  `u_id` int(11) NOT NULL AUTO_INCREMENT,
  `u_name` varchar(20) COLLATE utf8_bin DEFAULT NULL,
  `tel` varchar(20) COLLATE utf8_bin DEFAULT NULL,
  `email` varchar(20) COLLATE utf8_bin DEFAULT NULL,
  `sex` varchar(20) COLLATE utf8_bin DEFAULT NULL,
  `password` varchar(20) COLLATE utf8_bin DEFAULT NULL,
  `password1` varchar(20) COLLATE utf8_bin DEFAULT NULL,
  `create_time` datetime DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP,
  `u_state` tinyint(20) DEFAULT NULL,
  `avatar` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  PRIMARY KEY (`u_id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- ----------------------------
-- Records of admins
-- ----------------------------
INSERT INTO `admins` VALUES ('1', '李飒', '13047217142', '3147007393@qq.com', '女', '123', '123', '2023-03-08 13:31:15', '1', 'http://localhost:9090/api/adminlogin/file/download/1678253473534?play=1');

-- ----------------------------
-- Table structure for categorize
-- ----------------------------
DROP TABLE IF EXISTS `categorize`;
CREATE TABLE `categorize` (
  `c_id` int(11) NOT NULL AUTO_INCREMENT,
  `c_name` varchar(20) COLLATE utf8_bin DEFAULT NULL,
  PRIMARY KEY (`c_id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- ----------------------------
-- Records of categorize
-- ----------------------------
INSERT INTO `categorize` VALUES ('1', '数码产品');
INSERT INTO `categorize` VALUES ('2', '服装配饰');
INSERT INTO `categorize` VALUES ('3', '学习用品');
INSERT INTO `categorize` VALUES ('4', '美妆个护');
INSERT INTO `categorize` VALUES ('5', '运动健身');

-- ----------------------------
-- Table structure for collects
-- ----------------------------
DROP TABLE IF EXISTS `collects`;
CREATE TABLE `collects` (
  `col_id` int(11) NOT NULL AUTO_INCREMENT,
  `g_id` int(11) DEFAULT NULL,
  `login_id` int(11) DEFAULT NULL,
  `c_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`col_id`),
  KEY `c_id` (`c_id`),
  KEY `g_id` (`g_id`),
  CONSTRAINT `collects_ibfk_1` FOREIGN KEY (`c_id`) REFERENCES `categorize` (`c_id`),
  CONSTRAINT `collects_ibfk_2` FOREIGN KEY (`g_id`) REFERENCES `goods` (`g_id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- ----------------------------
-- Records of collects
-- ----------------------------
INSERT INTO `collects` VALUES ('4', '16', '1', '1');

-- ----------------------------
-- Table structure for goods
-- ----------------------------
DROP TABLE IF EXISTS `goods`;
CREATE TABLE `goods` (
  `g_id` int(11) NOT NULL AUTO_INCREMENT,
  `c_id` int(11) DEFAULT NULL,
  `g_name` varchar(20) COLLATE utf8_bin DEFAULT NULL,
  `price` float(10,0) DEFAULT NULL,
  `remark` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `sub_time` datetime DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP,
  `g_state` varchar(20) COLLATE utf8_bin DEFAULT NULL,
  `image` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `describe` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin DEFAULT NULL,
  `login_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`g_id`),
  KEY `c_id` (`c_id`),
  CONSTRAINT `goods_ibfk_1` FOREIGN KEY (`c_id`) REFERENCES `categorize` (`c_id`)
) ENGINE=InnoDB AUTO_INCREMENT=39 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- ----------------------------
-- Records of goods
-- ----------------------------
INSERT INTO `goods` VALUES ('1', '3', '西游记', '20', null, '2023-03-07 00:56:45', '在售', 'http://localhost:9090/api/fabu/file/download/1678121545903?play=1', '9成新！！！', '1');
INSERT INTO `goods` VALUES ('2', '1', 'iPad  mini 2', '200', null, '2023-03-07 00:58:31', '在售', 'http://localhost:9090/api/fabu/file/download/1678121812230?play=1', 'ipad mini2  16g  93新！', '1');
INSERT INTO `goods` VALUES ('3', '3', '红楼梦', '15', null, '2023-03-07 01:10:18', '在售', 'http://localhost:9090/api/fabu/file/download/1678122589572?play=1', '8成新！', '1');
INSERT INTO `goods` VALUES ('4', '3', '水浒传', '13', null, '2023-03-07 01:11:51', '在售', 'http://localhost:9090/api/fabu/file/download/1678122671014?play=1', '全新！', '1');
INSERT INTO `goods` VALUES ('5', '1', '电子手表', '280', null, '2023-03-07 01:13:44', '在售', 'http://localhost:9090/api/fabu/file/download/1678122720870?play=1', '400买的，现在不需要了，低价卖出，盒子还在', '1');
INSERT INTO `goods` VALUES ('6', '1', 'ipad 6', '1588', null, '2023-03-07 01:16:09', '在售', 'http://localhost:9090/api/fabu/file/download/1678122828600?play=1', '二手的iPad，金色的，外观都完美，有指纹，wifi版的，128G，要的dd我呀', '1');
INSERT INTO `goods` VALUES ('7', '1', '联想小新pad  ', '1000', null, '2023-03-07 01:17:44', '在售', 'http://localhost:9090/api/fabu/file/download/1678122976755?play=1', '基本全新的，128G,价格可以小刀一下的', '1');
INSERT INTO `goods` VALUES ('8', '3', '一千零一夜', '12', null, '2023-03-07 01:30:23', '在售', 'http://localhost:9090/api/fabu/file/download/1678123785894?play=1', '全新！', '1');
INSERT INTO `goods` VALUES ('9', '1', '华硕电脑', '3000', null, '2023-03-07 01:33:53', '在售', 'http://localhost:9090/api/fabu/file/download/1678123858908?play=1', '华硕(ASUS)天选2 11代英特尔酷睿i515.6英寸游戏笔记本电脑(6核i5-11400H 16G 512G RTX3060 144Hz)日蚀灰送鼠标键盘急用钱急出\n', '1');
INSERT INTO `goods` VALUES ('10', '1', '小米路由器', '80', null, '2023-03-07 01:35:41', '在售', 'http://localhost:9090/api/fabu/file/download/1678124040225?play=1', '由于学校原因出售95新小米路由器 4A千兆版', '1');
INSERT INTO `goods` VALUES ('11', '3', '儒林外史', '20', null, '2023-03-07 01:36:53', '在售', 'http://localhost:9090/api/fabu/file/download/1678124165263?play=1', '全新！', '1');
INSERT INTO `goods` VALUES ('12', '1', '联名拍立得', '1700', null, '2023-03-07 01:39:10', '在售', 'http://localhost:9090/api/fabu/file/download/1678124220268?play=1', '用过五次，淘宝买的，Taylor swift已绝版', '1');
INSERT INTO `goods` VALUES ('13', '3', '醒世恒言', '10', null, '2023-03-07 01:43:29', '在售', 'http://localhost:9090/api/fabu/file/download/1678124572370?play=1', '7成新！', '1');
INSERT INTO `goods` VALUES ('14', '3', '诗经', '10', null, '2023-03-07 01:44:02', '在售', 'http://localhost:9090/api/fabu/file/download/1678124616085?play=1', '全新！', '1');
INSERT INTO `goods` VALUES ('15', '3', '红楼梦', '15', null, '2023-03-07 01:44:55', '在售', 'http://localhost:9090/api/fabu/file/download/1678124650771?play=1', '8成新！', '1');
INSERT INTO `goods` VALUES ('16', '1', '华为手表', '384', null, '2023-03-07 01:46:22', '在售', 'http://localhost:9090/api/fabu/file/download/1678124719247?play=1', '基本未佩戴，九成新！', '1');
INSERT INTO `goods` VALUES ('17', '1', 'ipad pro', '4000', null, '2023-03-07 01:47:47', '在售', 'http://localhost:9090/api/fabu/file/download/1678124789109?play=1', '家里做外贸生意的朋友送的美版的ipad pro 2022 11寸全新未拆封未激活的比官网便宜1000出了建议去搜一下区别再来说可以在国内保修(有购买凭证)\n', '1');
INSERT INTO `goods` VALUES ('18', '5', '哑铃', '28', null, '2023-03-08 11:38:27', '在售', 'http://localhost:9090/api/fabu/file/download/1678246561701?play=1', '成色:全新，哑铃男士健身器材家用- -对10/15/20/30/40公斤可调节锻炼杠铃哑铃 材质:哑铃外面是环保塑料静音不伤害地板，里面水泥混合物;', '1');
INSERT INTO `goods` VALUES ('19', '5', '哑铃', '36', null, '2023-03-08 11:40:15', '在售', 'http://localhost:9090/api/fabu/file/download/1678246745042?play=1', '低价出总重20斤哑铃，左右个十斤，六角哑铃，-体设计，可做俯卧撑，实心内胆，内置砂铁水泥混合物，加固防滑手柄，耐磨更坚固!!\n', '1');
INSERT INTO `goods` VALUES ('20', '4', 'mac粉底液', '65', null, '2023-03-08 11:44:08', '在售', 'http://localhost:9090/api/fabu/file/download/1678246918035?play=1', 'mac，色号n18,于2024.1月到期，专柜购买，有小票,使用次数不到10次\n', '1');
INSERT INTO `goods` VALUES ('21', '4', '美瞳', '35', null, '2023-03-08 11:45:48', '在售', 'http://localhost:9090/api/fabu/file/download/1678247088267?play=1', '半年抛冰丝加仑灰全新，完整的包装盒含有取戴工具眼睛护理润滑液\n', '1');
INSERT INTO `goods` VALUES ('22', '4', '奥迪口红', '150', null, '2023-03-08 11:49:17', '在售', 'http://localhost:9090/api/fabu/file/download/1678247286966?play=1', '全新奥迪口红999，包装盒都在', '1');
INSERT INTO `goods` VALUES ('23', '4', '完美日记', '30', null, '2023-03-08 11:52:59', '在售', 'http://localhost:9090/api/fabu/file/download/1678247489769?play=1', '完美日记粉底液(象牙白)\n\n适合油皮，买多了出，现已断货，保质期到2024/12/04\n', '1');
INSERT INTO `goods` VALUES ('24', '4', '粉底液', '100', null, '2023-03-08 11:54:07', '在售', 'http://localhost:9090/api/fabu/file/download/1678247600739?play=1', 'Mac粉底正装全新官网正价购买很少化妆所以粉底液闲置\n', '1');
INSERT INTO `goods` VALUES ('25', '4', '兰蔻眼霜', '300', null, '2023-03-08 11:57:34', '在售', 'http://localhost:9090/api/fabu/file/download/1678247752408?play=1', '未开封，全新兰蔻发光眼霜，礼盒装。官网刚刚到的男朋友买的不想要，有需要的朋友可以联系我加我微信。官网要卖550。', '1');
INSERT INTO `goods` VALUES ('26', '4', '防晒喷雾', '30', null, '2023-03-08 12:01:56', '在售', 'http://localhost:9090/api/fabu/file/download/1678248036483?play=1', '全新JM珍珠防晒喷雾', '1');
INSERT INTO `goods` VALUES ('27', '4', '植村秀', '150', null, '2023-03-08 12:10:24', '在售', 'http://localhost:9090/api/fabu/file/download/1678248473091?play=1', '全新！', '1');
INSERT INTO `goods` VALUES ('28', '4', '水乳', '200', null, '2023-03-08 12:12:26', '在售', 'http://localhost:9090/api/fabu/file/download/1678248677435?play=1', '保湿三件套，非常好用', '1');
INSERT INTO `goods` VALUES ('29', '4', '三部曲', '50', null, '2023-03-08 12:14:40', '在售', 'http://localhost:9090/api/fabu/file/download/1678248792563?play=1', '竹炭祛黑头三步曲护理套装，这是一套去黑头护理三件套装，是在实体店买的，之前拆开过包装，但里面的东西九成新\n', '1');
INSERT INTO `goods` VALUES ('30', '4', '粉底液', '200', null, '2023-03-08 12:17:09', '在售', 'http://localhost:9090/api/fabu/file/download/1678248935469?play=1', '雅诗兰黛白金粉底液正装30ml，雅诗兰黛白金粉底液，色号2C0，买回来就用过一-次，色号不适合我，血亏处理。\n', '1');
INSERT INTO `goods` VALUES ('31', '4', '小白瓶', '150', null, '2023-03-08 12:19:31', '在售', 'http://localhost:9090/api/fabu/file/download/1678249168870?play=1', '出售全新欧缇丽淡斑小奶瓶美白精华，闲置-瓶没有 使用，礼盒为拆封，原价480- -瓶，现150出售\n', '1');
INSERT INTO `goods` VALUES ('32', '4', 'SK', '1000', null, '2023-03-08 12:23:16', '在售', 'http://localhost:9090/api/fabu/file/download/1678249212053?play=1', 'SK专柜版五件套礼盒实拍国内专柜五件套VSKII专柜版礼盒5件套现特SK正装礼盒五件套，神仙水230ml+多元磨砂面霜80g+磨砂眼霜15g+护肤洁面120+小灯泡50ml\n', '1');
INSERT INTO `goods` VALUES ('33', '4', 'skii', '70', null, '2023-03-08 12:25:16', '在售', 'http://localhost:9090/api/fabu/file/download/1678249464095?play=1', '全新ski小灯泡正装50ml,带盒\n', '1');
INSERT INTO `goods` VALUES ('34', '4', '修护眼霜', '90', null, '2023-03-08 12:27:55', '在售', 'http://localhost:9090/api/fabu/file/download/1678249554779?play=1', '海蓝之谜浓缩密集修护眼霜,产地加拿大，米黄色的霜，有淡淡青瓜味。这个眼霜涂抹的位置跟一般眼霜不同,要涂在眉骨上面和眼下睫毛下面，然后打圈。由于这是5ml的小样，所以不配按摩棒。这个眼霜比雅诗兰黛和兰蔻都要厚重一点，比较适合秋冬天或者皮肤比较干的宝宝。\n', '1');
INSERT INTO `goods` VALUES ('35', '4', '兰蔻小黑瓶', '160', null, '2023-03-08 12:31:22', '在售', 'http://localhost:9090/api/fabu/file/download/1678249791883?play=1', '全新兰蔻小黑瓶三件套[ 肌底液100ml眼霜15ml-面霜50ml]\n', '1');
INSERT INTO `goods` VALUES ('36', '4', '柳丝木', '30', null, '2023-03-08 12:37:31', '在售', 'http://localhost:9090/api/fabu/file/download/1678250135362?play=1', '只用过一次，色号不合适，基本上是新的。从官网上买的，正品。价格可商议。学生党可入，妆效还不错，会有点干，需要做好保湿。\n', '1');
INSERT INTO `goods` VALUES ('37', '4', 'AVID雅妃', '60', null, '2023-03-08 12:43:03', '在售', 'http://localhost:9090/api/fabu/file/download/1678250386299?play=1', 'AVID雅妃德沁水遮瑕粉底液干皮亲妈补水持久遮瑕水润奶油肌粉底女，最白色号，我色号买错了用过几次\n', '1');

-- ----------------------------
-- Table structure for orders
-- ----------------------------
DROP TABLE IF EXISTS `orders`;
CREATE TABLE `orders` (
  `o_id` int(11) NOT NULL AUTO_INCREMENT,
  `g_id` int(11) DEFAULT NULL,
  `login_id` int(11) DEFAULT NULL,
  `post_time` datetime DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP,
  `end_time` datetime DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP,
  `o_state` varchar(20) COLLATE utf8_bin DEFAULT NULL,
  PRIMARY KEY (`o_id`),
  KEY `g_id` (`g_id`),
  CONSTRAINT `orders_ibfk_1` FOREIGN KEY (`g_id`) REFERENCES `goods` (`g_id`)
) ENGINE=InnoDB AUTO_INCREMENT=40 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- ----------------------------
-- Records of orders
-- ----------------------------
INSERT INTO `orders` VALUES ('9', '17', '2', '2023-02-08 23:54:54', null, '交易中');
INSERT INTO `orders` VALUES ('11', '17', '2', '2023-02-10 00:43:21', null, '交易中');
INSERT INTO `orders` VALUES ('12', '20', '1', '2023-03-01 11:37:57', '2023-03-01 11:37:57', '交易完成');
INSERT INTO `orders` VALUES ('13', '12', '1', '2023-03-08 11:03:31', '2023-03-08 11:03:32', '交易完成');
INSERT INTO `orders` VALUES ('14', '21', '2', '2023-02-11 10:56:30', null, '交易中');
INSERT INTO `orders` VALUES ('16', '21', '1', '2023-02-13 23:43:50', null, '交易中');
INSERT INTO `orders` VALUES ('17', '18', '1', '2023-02-21 22:24:49', null, '交易中');
INSERT INTO `orders` VALUES ('18', '20', '1', '2023-03-01 11:37:16', '2023-03-01 11:37:17', '交易完成');
INSERT INTO `orders` VALUES ('19', '20', '1', '2023-02-22 00:26:42', null, '交易中');
INSERT INTO `orders` VALUES ('20', '20', '1', '2023-03-01 11:37:03', '2023-03-01 11:37:03', '交易完成');
INSERT INTO `orders` VALUES ('21', '20', '1', '2023-02-22 00:28:01', null, '交易中');
INSERT INTO `orders` VALUES ('22', '20', '1', '2023-02-22 00:29:27', null, '交易中');
INSERT INTO `orders` VALUES ('23', '25', '1', '2023-02-23 20:09:44', null, '交易中');
INSERT INTO `orders` VALUES ('24', '25', '1', '2023-02-24 00:53:05', null, '交易中');
INSERT INTO `orders` VALUES ('25', '21', '1', '2023-02-24 01:09:18', null, '交易中');
INSERT INTO `orders` VALUES ('27', '25', '1', '2023-02-24 01:13:56', null, '交易中');
INSERT INTO `orders` VALUES ('29', '20', '1', '2023-02-24 01:21:47', null, '交易中');
INSERT INTO `orders` VALUES ('30', '20', '1', '2023-02-24 01:24:06', null, '交易中');
INSERT INTO `orders` VALUES ('33', '25', '1', '2023-02-24 23:34:56', null, '交易中');
INSERT INTO `orders` VALUES ('34', '25', '1', '2023-02-24 23:36:53', null, '交易中');
INSERT INTO `orders` VALUES ('37', '25', '1', '2023-02-27 15:22:09', null, '交易中');
INSERT INTO `orders` VALUES ('38', '31', '2', '2023-03-05 08:44:43', null, '交易中');
INSERT INTO `orders` VALUES ('39', '17', '1', '2023-03-08 10:58:16', '2023-03-08 10:58:16', '交易完成');

-- ----------------------------
-- Table structure for users
-- ----------------------------
DROP TABLE IF EXISTS `users`;
CREATE TABLE `users` (
  `u_id` int(10) NOT NULL AUTO_INCREMENT,
  `u_name` varchar(20) CHARACTER SET utf8 COLLATE utf8_bin DEFAULT NULL,
  `tel` varchar(20) COLLATE utf8_bin DEFAULT NULL,
  `email` varchar(20) COLLATE utf8_bin DEFAULT NULL,
  `sex` varchar(20) COLLATE utf8_bin DEFAULT NULL,
  `password` varchar(20) COLLATE utf8_bin DEFAULT NULL,
  `password1` varchar(20) COLLATE utf8_bin DEFAULT NULL,
  `create_time` datetime DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP,
  `u_state` tinyint(20) DEFAULT NULL,
  `avatar` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  PRIMARY KEY (`u_id`),
  UNIQUE KEY `email` (`email`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=24 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- ----------------------------
-- Records of users
-- ----------------------------
INSERT INTO `users` VALUES ('1', '张三', '18627462558', '2779727496@qq.com', '男', '123456', '123456', '2023-03-08 13:24:32', '1', 'http://localhost:9090/api/login/file/download/1678253071077?play=1');
INSERT INTO `users` VALUES ('2', '李飒飒', '13047217142', '1958858017@qq.com', '女', '123456', '123456', '2023-03-08 13:59:57', '1', 'http://localhost:9090/api/login/file/download/1678253071077?play=1');
INSERT INTO `users` VALUES ('3', '李思', '18867244416', '3066166261@qq.com', '女', '123456', '123456', '2023-03-08 13:25:15', '1', 'http://localhost:9090/api/login/file/download/1678253071077?play=1');
INSERT INTO `users` VALUES ('4', '王五', '18187446228', '1557442584@qq.com', '男', '123456', '123456', '2023-03-08 13:25:17', null, 'http://localhost:9090/api/login/file/download/1678253071077?play=1');
INSERT INTO `users` VALUES ('5', '李琦', '15546744255', '123455611@qq.com', '男', '123456', '123456', '2023-03-08 13:25:19', null, 'http://localhost:9090/api/login/file/download/1678253071077?play=1');
INSERT INTO `users` VALUES ('6', '李克', '15547661662', '1552746461@qq.com', '男', '123456', '123456', '2023-03-08 13:25:21', '1', 'http://localhost:9090/api/login/file/download/1678253071077?play=1');
INSERT INTO `users` VALUES ('7', '莉莉', '15576744462', '1552746462@qq.com', '女', '123456', '123456', '2023-03-08 13:25:24', '1', 'http://localhost:9090/api/login/file/download/1678253071077?play=1');
INSERT INTO `users` VALUES ('8', '林国荣', '15574462225', '1552746463@qq.com', '男', '123456', '123456', '2023-03-08 13:25:26', '1', 'http://localhost:9090/api/login/file/download/1678253071077?play=1');
INSERT INTO `users` VALUES ('9', '林延安', '15546744203', '1552746464@qq.com', '男', '123456', '123456', '2023-03-08 13:25:28', '1', 'http://localhost:9090/api/login/file/download/1678253071077?play=1');
INSERT INTO `users` VALUES ('10', '王乐怡', '18874462456', '1552746465@qq.com', '女', '123456', '123456', '2023-03-08 13:25:29', '1', 'http://localhost:9090/api/login/file/download/1678253071077?play=1');
INSERT INTO `users` VALUES ('21', '陈舒', '18646744245', '1552746466@qq.com', '女', '123456', '123456', '2023-03-08 13:25:33', '1', 'http://localhost:9090/api/login/file/download/1678253071077?play=1');
