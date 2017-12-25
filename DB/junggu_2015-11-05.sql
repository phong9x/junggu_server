# ************************************************************
# Sequel Pro SQL dump
# Version 4096
#
# http://www.sequelpro.com/
# http://code.google.com/p/sequel-pro/
#
# Host: 127.0.0.1 (MySQL 5.6.25)
# Database: junggu
# Generation Time: 2015-11-05 14:11:31 +0000
# ************************************************************


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;


# Dump of table ACCESSIBILITY
# ------------------------------------------------------------

DROP TABLE IF EXISTS `ACCESSIBILITY`;

CREATE TABLE `ACCESSIBILITY` (
  `_id` int(11) NOT NULL AUTO_INCREMENT,
  `CREATE_DATE` datetime DEFAULT NULL,
  `DESCRIPTION` varchar(255) NOT NULL,
  `NAME` varchar(255) NOT NULL,
  `UPDATE_DATE` datetime DEFAULT NULL,
  PRIMARY KEY (`_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;



# Dump of table CATEGORY
# ------------------------------------------------------------

DROP TABLE IF EXISTS `CATEGORY`;

CREATE TABLE `CATEGORY` (
  `_id` int(11) NOT NULL AUTO_INCREMENT,
  `CAT_NAME` varchar(255) NOT NULL,
  `CREATE_DATE` datetime DEFAULT NULL,
  `DESCRIPTION` varchar(255) DEFAULT NULL,
  `ETC` varchar(255) DEFAULT NULL,
  `IMAGE` varchar(255) DEFAULT NULL,
  `PARENT_ID` int(11) NOT NULL,
  `UPDATE_DATE` datetime DEFAULT NULL,
  PRIMARY KEY (`_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;



# Dump of table FACILITY
# ------------------------------------------------------------

DROP TABLE IF EXISTS `FACILITY`;

CREATE TABLE `FACILITY` (
  `_id` int(11) NOT NULL AUTO_INCREMENT,
  `CREATE_DATE` datetime DEFAULT NULL,
  `DESCRIPTION` varchar(255) NOT NULL,
  `NAME` varchar(255) NOT NULL,
  `UPDATE_DATE` datetime DEFAULT NULL,
  PRIMARY KEY (`_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;



# Dump of table FIELD
# ------------------------------------------------------------

DROP TABLE IF EXISTS `FIELD`;

CREATE TABLE `FIELD` (
  `_id` int(11) NOT NULL AUTO_INCREMENT,
  `CREATE_DATE` datetime DEFAULT NULL,
  `DESCRIPTION` varchar(255) NOT NULL,
  `NAME` varchar(255) NOT NULL,
  `UPDATE_DATE` datetime DEFAULT NULL,
  PRIMARY KEY (`_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;



# Dump of table NOTICE
# ------------------------------------------------------------

DROP TABLE IF EXISTS `NOTICE`;

CREATE TABLE `NOTICE` (
  `_id` int(11) NOT NULL AUTO_INCREMENT,
  `CONTENT` varchar(255) DEFAULT NULL,
  `CREATE_DATE` datetime DEFAULT NULL,
  `NOTICE_TYPE` int(11) DEFAULT NULL,
  `TITLE` varchar(255) NOT NULL,
  `UPDATE_DATE` datetime DEFAULT NULL,
  `USER_ID` int(11) NOT NULL,
  PRIMARY KEY (`_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;



# Dump of table STORE
# ------------------------------------------------------------

DROP TABLE IF EXISTS `STORE`;

CREATE TABLE `STORE` (
  `_id` int(11) NOT NULL AUTO_INCREMENT,
  `ACCESSIBILITY_LIST` varchar(255) NOT NULL,
  `ADDRESS` varchar(255) NOT NULL,
  `BUILDING_FORM` varchar(255) NOT NULL,
  `CAT_ID` varchar(255) DEFAULT NULL,
  `CREATE_DATE` datetime DEFAULT NULL,
  `FACILITY_LIST` varchar(255) NOT NULL,
  `FIELD_LIST` varchar(255) DEFAULT NULL,
  `FLOOR` varchar(255) NOT NULL,
  `GRADE` varchar(255) NOT NULL,
  `HOLIDAY` varchar(255) NOT NULL,
  `IMAGE_BASE_ATTACH` varchar(255) DEFAULT NULL,
  `IMAGE_EXTEND_ATTACH` varchar(255) DEFAULT NULL,
  `LATIUDE` varchar(100) NOT NULL,
  `LONGITUDE` varchar(100) NOT NULL,
  `MONITORING_DATE` datetime NOT NULL,
  `MONITORING_MAN` varchar(255) NOT NULL,
  `MORNITORING_MAN_PHONE` varchar(255) NOT NULL,
  `NAME` varchar(255) NOT NULL,
  `PHONE` varchar(255) NOT NULL,
  `REPRESENTATIVE` varchar(255) NOT NULL,
  `SERVICE_HOURS` varchar(255) NOT NULL,
  `TAG` varchar(255) NOT NULL,
  `UPDATE_DATE` datetime DEFAULT NULL,
  `USER_ID` int(11) DEFAULT NULL,
  PRIMARY KEY (`_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;



# Dump of table USER
# ------------------------------------------------------------

DROP TABLE IF EXISTS `USER`;

CREATE TABLE `USER` (
  `_id` int(11) NOT NULL AUTO_INCREMENT,
  `AGE` int(11) DEFAULT NULL,
  `CREATE_DATE` datetime DEFAULT NULL,
  `EMAIL` varchar(255) DEFAULT NULL,
  `FULLNAME` varchar(255) DEFAULT NULL,
  `NICKNAME` varchar(200) DEFAULT NULL,
  `PASSWORD` varchar(100) NOT NULL,
  `PHONE` varchar(200) DEFAULT NULL,
  `ROLE` int(11) DEFAULT '0',
  `SEX` varchar(50) DEFAULT NULL,
  `UPDATE_DATE` datetime DEFAULT NULL,
  `USERNAME` varchar(200) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL,
  PRIMARY KEY (`_id`),
  UNIQUE KEY `USERNAME` (`USERNAME`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

LOCK TABLES `USER` WRITE;
/*!40000 ALTER TABLE `USER` DISABLE KEYS */;

INSERT INTO `USER` (`_id`, `AGE`, `CREATE_DATE`, `EMAIL`, `FULLNAME`, `NICKNAME`, `PASSWORD`, `PHONE`, `ROLE`, `SEX`, `UPDATE_DATE`, `USERNAME`)
VALUES
	(6,22,NULL,'dfsfs','dfsfs','dfsfs','dfsfs','dfsfs',0,'sex',NULL,X''),
	(10,NULL,NULL,NULL,NULL,'dfsfs','dfsfs',NULL,NULL,NULL,NULL,X'7272');

/*!40000 ALTER TABLE `USER` ENABLE KEYS */;
UNLOCK TABLES;


# Dump of table VERSION
# ------------------------------------------------------------

DROP TABLE IF EXISTS `VERSION`;

CREATE TABLE `VERSION` (
  `_id` int(11) NOT NULL AUTO_INCREMENT,
  `CREATE_DATE` datetime DEFAULT NULL,
  `ETC` varchar(255) DEFAULT NULL,
  `NAME` varchar(200) NOT NULL,
  `STATUS` varchar(100) NOT NULL,
  `UPDATE_DATE` datetime DEFAULT NULL,
  PRIMARY KEY (`_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;




/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
