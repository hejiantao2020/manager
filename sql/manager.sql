/*
SQLyog Ultimate v12.08 (64 bit)
MySQL - 5.7.12-log : Database - manager
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`manager` /*!40100 DEFAULT CHARACTER SET utf8 */;

USE `manager`;

/*Table structure for table `base_info` */

DROP TABLE IF EXISTS `base_info`;

CREATE TABLE `base_info` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键ID',
  `redio` varchar(11) COLLATE utf8_unicode_ci NOT NULL DEFAULT '' COMMENT '单选',
  `checkbox` varchar(124) COLLATE utf8_unicode_ci NOT NULL DEFAULT '' COMMENT '多选',
  `select_choice` varchar(124) COLLATE utf8_unicode_ci NOT NULL DEFAULT '' COMMENT '下拉',
  `start_live_time` datetime DEFAULT NULL COMMENT '开始时间',
  `end_live_time` datetime DEFAULT NULL COMMENT '结束时间',
  `deleted` int(1) DEFAULT '0' COMMENT '逻辑删除0-未删除;1-已删除',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `update_time` datetime DEFAULT NULL COMMENT '修改时间',
  `resource_id` int(11) DEFAULT '0' COMMENT '资源ID',
  `resource_name` varchar(54) COLLATE utf8_unicode_ci DEFAULT '' COMMENT '资源名称',
  `resource_upload_url` varchar(500) COLLATE utf8_unicode_ci DEFAULT '' COMMENT '资源上传路径',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

/*Data for the table `base_info` */

insert  into `base_info`(`id`,`redio`,`checkbox`,`select_choice`,`start_live_time`,`end_live_time`,`deleted`,`create_time`,`update_time`,`resource_id`,`resource_name`,`resource_upload_url`) values (1,'2','2','2','2020-08-22 00:00:00','2020-09-12 00:00:00',0,'2020-08-20 16:50:41','2020-08-20 16:50:43',1,'',''),(2,'1','1','7','2020-08-31 00:00:00','2020-09-30 00:00:00',0,NULL,NULL,0,'a4457c7b-0c69-4905-8821-ce07f0627fdf.sql','D:/home/file/a4457c7b-0c69-4905-8821-ce07f0627fdf.sql'),(3,'2','2','2','2020-08-21 00:00:00','2020-09-30 00:00:00',0,NULL,NULL,0,'c6ccbe3b-d546-473d-84e3-401e8448c4d1.sql','D:/home/file/c6ccbe3b-d546-473d-84e3-401e8448c4d1.sql');

/*Table structure for table `classroom` */

DROP TABLE IF EXISTS `classroom`;

CREATE TABLE `classroom` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '班级ID',
  `course_id` int(11) DEFAULT NULL COMMENT '课程ID',
  `class_name` varchar(32) DEFAULT NULL COMMENT '班级名称',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=21 DEFAULT CHARSET=utf8;

/*Data for the table `classroom` */

insert  into `classroom`(`id`,`course_id`,`class_name`) values (1,1,'3-1班'),(2,1,'3-2班'),(3,1,'3-3班'),(4,1,'3-4班'),(5,2,'4-4班'),(6,2,'4-4班'),(7,2,'4-4班'),(8,2,'4-4班'),(9,3,'5-1班'),(10,3,'5-2班'),(11,3,'5-3班'),(12,3,'5-4班'),(13,4,'6-1班'),(14,4,'6-2班'),(15,4,'6-3班'),(16,4,'6-4班'),(17,5,'7-1班'),(18,5,'7-2班'),(19,5,'7-3班'),(20,5,'7-4班');

/*Table structure for table `course` */

DROP TABLE IF EXISTS `course`;

CREATE TABLE `course` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '课程ID',
  `name` varchar(32) COLLATE utf8_unicode_ci DEFAULT NULL COMMENT '课程名称',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

/*Data for the table `course` */

insert  into `course`(`id`,`name`) values (1,'语文'),(2,'数学'),(3,'物理'),(4,'化学'),(5,'编程');

/*Table structure for table `student` */

DROP TABLE IF EXISTS `student`;

CREATE TABLE `student` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `user_name` varchar(255) DEFAULT NULL COMMENT '用户昵称',
  `sex` int(1) NOT NULL DEFAULT '0' COMMENT '性别',
  `mobile` varchar(20) DEFAULT NULL COMMENT '电话号码',
  `login_password` varchar(50) NOT NULL COMMENT '密码',
  `deleted` int(1) NOT NULL DEFAULT '0' COMMENT '删除状态(0-未删除;1-已删除)',
  `course_id` int(11) DEFAULT '0' COMMENT '课程ID',
  `course_name` varchar(32) DEFAULT '' COMMENT '课程名称',
  `classroom_id` int(11) DEFAULT '0' COMMENT '班级ID',
  `classroom_name` varchar(21) DEFAULT '' COMMENT '班级名称',
  `buy_status` int(1) DEFAULT '0' COMMENT '是否购买课程(0-未购买;1-已购买)',
  `create_time` datetime DEFAULT NULL COMMENT '该记录创建时间',
  `update_time` datetime DEFAULT NULL COMMENT '更新时间',
  PRIMARY KEY (`id`),
  UNIQUE KEY `vr_user_mobile_uindex` (`mobile`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `student` */

/*Table structure for table `t_menu` */

DROP TABLE IF EXISTS `t_menu`;

CREATE TABLE `t_menu` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `icon` varchar(100) DEFAULT NULL,
  `name` varchar(50) DEFAULT NULL,
  `state` int(11) DEFAULT NULL,
  `url` varchar(200) DEFAULT NULL,
  `p_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=200001 DEFAULT CHARSET=utf8;

/*Data for the table `t_menu` */

insert  into `t_menu`(`id`,`icon`,`name`,`state`,`url`,`p_id`) values (1,'menu-plugin','系统菜单',1,NULL,-1),(10,'&#xe68e;','基础管理',1,NULL,1),(60,'&#xe631;','系统管理',1,NULL,1),(61,'&#xe705;','新闻资讯',1,'http://www.ifeng.com/',1),(1000,'&#xe608;','基础信息',2,'admin/baseInfo/getbaseinfolist',10),(6000,'&#xe631;','菜单管理',2,'admin/menu/tomunemanage',60),(6010,'icon-icon10','角色管理',2,'admin/role/torolemanage',60),(6020,'&#xe612;','用户管理',2,'admin/user/tousermanage',60),(6030,'&#xe631;','sql监控',2,'druid/index.html',60),(6040,'icon-ziliao','修改密码',2,'admin/user/toUpdatePassword',60),(6050,'icon-tuichu','安全退出',2,'user/logout',60),(6100,'icon-text','凤凰网',2,'http://www.ifeng.com/',61),(200000,'44','44',3,'44',2000);

/*Table structure for table `t_role` */

DROP TABLE IF EXISTS `t_role`;

CREATE TABLE `t_role` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `bz` varchar(1000) DEFAULT NULL,
  `name` varchar(50) DEFAULT NULL,
  `remarks` varchar(1000) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=22 DEFAULT CHARSET=utf8;

/*Data for the table `t_role` */

insert  into `t_role`(`id`,`bz`,`name`,`remarks`) values (1,'系统管理员 最高权限','管理员',NULL),(2,'主管','主管',NULL),(4,'采购员','采购员',NULL),(5,'销售经理','销售经理','22'),(7,'仓库管理员','仓库管理员',NULL),(9,'总经理','总经理',NULL),(15,'111111','111111',NULL),(16,'222','222222',NULL),(17,'33','333333',NULL),(18,'444444','444444',NULL),(19,'555','555555',NULL),(20,'666666','666666',NULL),(21,'1111','11111111',NULL);

/*Table structure for table `t_role_menu` */

DROP TABLE IF EXISTS `t_role_menu`;

CREATE TABLE `t_role_menu` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `menu_id` int(11) DEFAULT NULL,
  `role_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=300 DEFAULT CHARSET=utf8;

/*Data for the table `t_role_menu` */

insert  into `t_role_menu`(`id`,`menu_id`,`role_id`) values (36,10,2),(42,1,2),(45,1,4),(48,1,5),(55,1,9),(65,1,7),(66,10,7),(126,60,15),(127,6010,15),(128,6020,15),(129,6030,15),(130,6040,15),(131,6050,15),(248,2000,1),(259,100000,1),(289,10,1),(290,1000,1),(291,60,1),(292,6000,1),(293,6010,1),(294,6020,1),(295,6030,1),(296,6040,1),(297,6050,1),(298,61,1),(299,6100,1);

/*Table structure for table `t_user` */

DROP TABLE IF EXISTS `t_user`;

CREATE TABLE `t_user` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `bz` varchar(1000) DEFAULT NULL,
  `password` varchar(50) DEFAULT NULL,
  `true_name` varchar(50) DEFAULT NULL,
  `user_name` varchar(50) DEFAULT NULL,
  `remarks` varchar(1000) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=15 DEFAULT CHARSET=utf8;

/*Data for the table `t_user` */

insert  into `t_user`(`id`,`bz`,`password`,`true_name`,`user_name`,`remarks`) values (1,'管理员','1','赵佳涛','admin','1'),(2,'主管','123','王大锤','jack','2'),(3,'销售经理','123','玛丽','marry','33'),(5,'1','111111','1','111111',NULL),(6,'2','222222','2','222222',NULL),(7,'3','333333','3','333333',NULL),(8,'','444444','44','444444',NULL),(9,'5','555555','5','555555',NULL),(11,'7','777777','7','777777',NULL),(12,'88','888888','88','888888',NULL),(13,'9','999999','9','999999',NULL),(14,'121212','121212','121212','121212',NULL);

/*Table structure for table `t_user_role` */

DROP TABLE IF EXISTS `t_user_role`;

CREATE TABLE `t_user_role` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `role_id` int(11) DEFAULT NULL,
  `user_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=51 DEFAULT CHARSET=utf8;

/*Data for the table `t_user_role` */

insert  into `t_user_role`(`id`,`role_id`,`user_id`) values (1,1,1),(19,2,2),(20,4,2),(21,5,2),(28,2,3),(29,4,3),(30,5,3),(31,7,3),(49,15,5),(50,1,5);

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
