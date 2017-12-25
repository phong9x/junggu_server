# ************************************************************
# Sequel Pro SQL dump
# Version 4096
#
# http://www.sequelpro.com/
# http://code.google.com/p/sequel-pro/
#
# Host: 127.0.0.1 (MySQL 5.6.25)
# Database: junggu
# Generation Time: 2015-11-04 01:54:07 +0000
# ************************************************************


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;


# Dump of table accessibility
# ------------------------------------------------------------

DROP TABLE IF EXISTS `accessibility`;

CREATE TABLE `accessibility` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(500) NOT NULL,
  `description` varchar(500) NOT NULL,
  `createDate` datetime DEFAULT NULL,
  `updateDate` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

LOCK TABLES `accessibility` WRITE;
/*!40000 ALTER TABLE `accessibility` DISABLE KEYS */;

INSERT INTO `accessibility` (`id`, `name`, `description`, `createDate`, `updateDate`)
VALUES
	(1,'장애진전용 주차장이 있음','Có nơi đỗ xe cho người khuyết tật',NULL,NULL),
	(2,'계단이나 턱이 없음','Không có cầu thang bộ hoặc hầm',NULL,NULL),
	(3,'경사로가 있어서 휠체어 접근이 용이함','Có lối đi lên dành cho người khuyết tật, đường dốc nghiêng xe lăn và đẩy lên được',NULL,NULL),
	(4,'10Cm이하 턱이 있음','nên thấp hơn 10cm so với mặt đường',NULL,NULL),
	(5,'시각장애인용 점자안내판 있음','Có biển cảnh báo chướng ngại vật',NULL,NULL),
	(6,'장애인화장실 있음','Có nhà vệ sinh dành cho người khuyết tật',NULL,NULL);

/*!40000 ALTER TABLE `accessibility` ENABLE KEYS */;
UNLOCK TABLES;


# Dump of table category
# ------------------------------------------------------------

DROP TABLE IF EXISTS `category`;

CREATE TABLE `category` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `catName` varchar(200) NOT NULL,
  `description` varchar(200) DEFAULT NULL,
  `parentId` int(11) NOT NULL DEFAULT '0',
  `image` varchar(500) DEFAULT NULL,
  `etc` text,
  `createDate` datetime DEFAULT NULL,
  `updateDate` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;



# Dump of table facility
# ------------------------------------------------------------

DROP TABLE IF EXISTS `facility`;

CREATE TABLE `facility` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(500) NOT NULL,
  `description` varchar(500) NOT NULL,
  `createDate` datetime DEFAULT NULL,
  `updateDate` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

LOCK TABLES `facility` WRITE;
/*!40000 ALTER TABLE `facility` DISABLE KEYS */;

INSERT INTO `facility` (`id`, `name`, `description`, `createDate`, `updateDate`)
VALUES
	(1,'문화관광지','Cultural Attractions',NULL,NULL),
	(2,'숙박시설','Accommodation',NULL,NULL),
	(3,'영화관·공연장','Cinemas , theaters',NULL,NULL),
	(4,'약국□음식점','Pharmacy Restaurant',NULL,NULL),
	(5,'이·미용실','The beauty salon',NULL,NULL),
	(6,'제과점(카페) ','Bakery ( Café )',NULL,NULL),
	(7,'판매상점','Sell ​​Stores',NULL,NULL),
	(8,'패스트푸드점','Fast food restaurants',NULL,NULL),
	(9,'화장실','restroom',NULL,NULL),
	(10,'etc..','etc...',NULL,NULL);

/*!40000 ALTER TABLE `facility` ENABLE KEYS */;
UNLOCK TABLES;


# Dump of table field
# ------------------------------------------------------------

DROP TABLE IF EXISTS `field`;

CREATE TABLE `field` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(500) NOT NULL,
  `description` varchar(500) NOT NULL,
  `createDate` datetime DEFAULT NULL,
  `updateDate` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

LOCK TABLES `field` WRITE;
/*!40000 ALTER TABLE `field` DISABLE KEYS */;

INSERT INTO `field` (`id`, `name`, `description`, `createDate`, `updateDate`)
VALUES
	(1,'먹거리','Food',NULL,NULL),
	(2,'관광지','Sight',NULL,NULL),
	(3,'숙박','accommodation',NULL,NULL),
	(4,'Living','Living',NULL,NULL);

/*!40000 ALTER TABLE `field` ENABLE KEYS */;
UNLOCK TABLES;


# Dump of table notice
# ------------------------------------------------------------

DROP TABLE IF EXISTS `notice`;

CREATE TABLE `notice` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `userId` int(11) NOT NULL,
  `title` varchar(300) NOT NULL DEFAULT '',
  `content` text,
  `createDate` datetime DEFAULT NULL,
  `updateDate` datetime DEFAULT NULL,
  `noticeType` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;



# Dump of table store
# ------------------------------------------------------------

DROP TABLE IF EXISTS `store`;

CREATE TABLE `store` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `userId` int(11) DEFAULT NULL,
  `catId` varchar(100) DEFAULT NULL,
  `name` varchar(500) NOT NULL,
  `tag` varchar(1000) NOT NULL,
  `serviceHours` varchar(200) NOT NULL,
  `hodiday` varchar(200) NOT NULL,
  `buidingForm` varchar(200) NOT NULL,
  `floor` varchar(200) NOT NULL,
  `facilityList` varchar(200) NOT NULL DEFAULT '',
  `representative` varchar(200) NOT NULL,
  `phone` varchar(200) NOT NULL,
  `address` varchar(200) NOT NULL,
  `monitoring_date` datetime NOT NULL,
  `monitoring_man` varchar(200) NOT NULL,
  `monitoring_man_phone` varchar(200) NOT NULL,
  `fieldList` varchar(200) DEFAULT '',
  `imageBaseAttach` text COMMENT '{\\n  "list": [\\n    "/image/2.jpg",\\n    "/image/2.jpg",\\n    "/image/2.jpg",\\n    "/image/2.jpg",\\n    "/image/2.jpg"\\n  ]\\n}',
  `imageExtendAttach` text COMMENT '{\n  "list": [\n      {\n      "title extra image": [\n        "/image/2.jpg",\n        "/image/2.jpg",\n        "/image/2.jpg",\n        "/image/2.jpg",\n        "/image/2.jpg"\n      ]\n    },\n     {\n      "title extra image": [\n        "/image/2.jpg",\n        "/image/2.jpg",\n        "/image/2.jpg",\n        "/image/2.jpg",\n        "/image/2.jpg"\n      ]\n    }\n  ]\n}',
  `grade` varchar(1000) NOT NULL DEFAULT '',
  `accessibilityList` varchar(200) NOT NULL,
  `longtitude` varchar(100) NOT NULL DEFAULT '',
  `latitude` varchar(100) NOT NULL DEFAULT '',
  `createDate` datetime DEFAULT NULL,
  `updateDate` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;



# Dump of table user
# ------------------------------------------------------------

DROP TABLE IF EXISTS `user`;

CREATE TABLE `user` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(200) NOT NULL,
  `password` varchar(100) NOT NULL,
  `nickname` varchar(200) DEFAULT '',
  `fullname` varchar(400) DEFAULT NULL,
  `role` int(11) NOT NULL DEFAULT '0' COMMENT '0 is member - 1 is admin',
  `sex` varchar(50) DEFAULT NULL,
  `phone` varchar(200) DEFAULT NULL,
  `email` varchar(400) DEFAULT '',
  `age` int(3) DEFAULT NULL,
  `updatedDate` datetime DEFAULT NULL,
  `createDate` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;



# Dump of table version
# ------------------------------------------------------------

DROP TABLE IF EXISTS `version`;

CREATE TABLE `version` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(200) NOT NULL,
  `status` varchar(100) NOT NULL DEFAULT '0',
  `etc` text,
  `updatedDate` datetime DEFAULT NULL,
  `createDate` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;




/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
