-- --------------------------------------------------------
-- Host:                         127.0.0.1
-- Server version:               5.1.35-community - MySQL Community Server (GPL)
-- Server OS:                    Win32
-- HeidiSQL Version:             9.3.0.4984
-- --------------------------------------------------------

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET NAMES utf8 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;

-- Dumping database structure for junggu
CREATE DATABASE IF NOT EXISTS `junggu` /*!40100 DEFAULT CHARACTER SET utf8 */;
USE `junggu`;


-- Dumping structure for table junggu.report
CREATE TABLE IF NOT EXISTS `report` (
  `_id` int(11) NOT NULL AUTO_INCREMENT,
  `PHONE_NUMBER` varchar(200) NOT NULL,
  `DETAILS` varchar(1000) NOT NULL,
  `USER_ID` int(11) NOT NULL,
  `STORE_ID` int(11) NOT NULL,
  `CREATE_DATE` datetime DEFAULT NULL,
  `UPDATE_DATE` datetime DEFAULT NULL,
  `IS_DELETE` int(1) DEFAULT '0',
  PRIMARY KEY (`_id`),
  KEY `FK_report_store` (`STORE_ID`),
  CONSTRAINT `FK_report_store` FOREIGN KEY (`STORE_ID`) REFERENCES `store` (`_id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;

-- Dumping data for table junggu.report: ~6 rows (approximately)
DELETE FROM `report`;
/*!40000 ALTER TABLE `report` DISABLE KEYS */;
INSERT INTO `report` (`_id`, `PHONE_NUMBER`, `DETAILS`, `USER_ID`, `STORE_ID`, `CREATE_DATE`, `UPDATE_DATE`, `IS_DELETE`) VALUES
	(1, '15555215554', 'tr ert eer e', 70, 1, '2015-11-16 14:38:38', '2015-11-16 14:38:38', 0),
	(2, '12123123', 'aaa', 77, 10, '2015-12-01 15:36:15', '2015-12-01 15:36:15', 0),
	(3, '111111', 'asdasdasd', 77, 11, '2015-12-01 15:52:19', '2015-12-01 15:52:19', 0),
	(4, '11111', 'adadsad', 77, 12, '2015-12-01 15:56:19', '2015-12-01 15:56:19', 0),
	(5, '1234567890', 'Test', 77, 13, '2015-12-09 00:31:05', '2015-12-09 00:31:05', NULL),
	(6, '5789', 'Test test', 77, 2, '2015-12-09 16:43:51', '2015-12-09 16:43:51', NULL);
/*!40000 ALTER TABLE `report` ENABLE KEYS */;
/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IF(@OLD_FOREIGN_KEY_CHECKS IS NULL, 1, @OLD_FOREIGN_KEY_CHECKS) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
