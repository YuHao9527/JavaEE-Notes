/*
SQLyog Ultimate v12.5.0 (64 bit)
MySQL - 5.5.27 : Database - springcloud
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`springcloud` /*!40100 DEFAULT CHARACTER SET utf8 */;

USE `springcloud`;

/*Table structure for table `tb_user` */

DROP TABLE IF EXISTS `tb_user`;

CREATE TABLE `tb_user` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `user_name` varchar(50) DEFAULT NULL,
  `password` varchar(50) DEFAULT NULL,
  `name` varchar(50) DEFAULT NULL,
  `age` int(11) DEFAULT NULL,
  `sex` int(11) DEFAULT NULL,
  `birthday` date DEFAULT NULL,
  `created` date DEFAULT NULL,
  `updated` date DEFAULT NULL,
  `note` varchar(2000) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8;

/*Data for the table `tb_user` */

insert  into `tb_user`(`id`,`user_name`,`password`,`name`,`age`,`sex`,`birthday`,`created`,`updated`,`note`) values 
(1,'zhangsan','1','张三a',18,1,'2019-02-27','2019-02-27','2019-02-27','在学习Java...'),
(2,'lisi','1','李四ab',18,1,'2019-02-27','2019-02-27','2019-02-27','在学习Java...'),
(3,'wangwu','1','王五abc',18,1,'2019-02-27','2019-02-27','2019-02-27','在学习Java...'),
(4,'fanbingbing','1','范冰冰aa',18,2,'2019-02-27','2019-02-27','2019-02-27','在学习Java...'),
(5,'guodegang','1','郭德纲bb',18,1,'2019-02-27','2019-02-27','2019-02-27','在学习Java...'),
(6,NULL,NULL,'周星驰cc',18,NULL,'2020-06-01','2020-06-01',NULL,NULL),
(7,'kaikeba',NULL,'开课吧',NULL,NULL,NULL,NULL,NULL,NULL);

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
