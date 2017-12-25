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

-- Dumping database structure for bao
CREATE DATABASE IF NOT EXISTS `bao` /*!40100 DEFAULT CHARACTER SET utf8 */;
USE `bao`;


-- Dumping structure for table bao.board
CREATE TABLE IF NOT EXISTS `board` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `categoryId` int(11) DEFAULT NULL,
  `categotyName` varchar(50) DEFAULT NULL,
  `title` varchar(50) DEFAULT NULL,
  `content` text,
  `picture` text,
  `updateDate` timestamp NULL DEFAULT NULL,
  `createDate` timestamp NULL DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- Dumping data for table bao.board: ~0 rows (approximately)
DELETE FROM `board`;
/*!40000 ALTER TABLE `board` DISABLE KEYS */;
/*!40000 ALTER TABLE `board` ENABLE KEYS */;


-- Dumping structure for table bao.category
CREATE TABLE IF NOT EXISTS `category` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(50) DEFAULT NULL,
  `updateDate` timestamp NULL DEFAULT NULL,
  `createDate` timestamp NULL DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

-- Dumping data for table bao.category: ~3 rows (approximately)
DELETE FROM `category`;
/*!40000 ALTER TABLE `category` DISABLE KEYS */;
INSERT INTO `category` (`id`, `name`, `updateDate`, `createDate`) VALUES
	(1, '育儿', '2015-11-20 10:14:08', '2015-11-20 10:14:09'),
	(2, '美容', '2015-11-20 10:14:28', '2015-11-20 10:14:29'),
	(3, '食品', '2015-11-20 10:14:35', '2015-11-20 10:14:36');
/*!40000 ALTER TABLE `category` ENABLE KEYS */;


-- Dumping structure for table bao.comment
CREATE TABLE IF NOT EXISTS `comment` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `userId` int(11) DEFAULT NULL,
  `comtent` varchar(900) DEFAULT NULL,
  `updateDate` timestamp NULL DEFAULT NULL,
  `createDate` timestamp NULL DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- Dumping data for table bao.comment: ~0 rows (approximately)
DELETE FROM `comment`;
/*!40000 ALTER TABLE `comment` DISABLE KEYS */;
/*!40000 ALTER TABLE `comment` ENABLE KEYS */;


-- Dumping structure for table bao.event
CREATE TABLE IF NOT EXISTS `event` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `prize` varchar(50) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `mainBanner` text,
  `detailBanner` text,
  `startDate` timestamp NULL DEFAULT NULL,
  `endDate` timestamp NULL DEFAULT NULL,
  `drawStatus` varchar(50) DEFAULT NULL,
  `prizewinnerId` varchar(50) DEFAULT NULL,
  `prizewinnerNickname` varchar(50) DEFAULT NULL,
  `updateDate` timestamp NULL DEFAULT NULL,
  `createDate` timestamp NULL DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=24 DEFAULT CHARSET=utf8;

-- Dumping data for table bao.event: ~23 rows (approximately)
DELETE FROM `event`;
/*!40000 ALTER TABLE `event` DISABLE KEYS */;
INSERT INTO `event` (`id`, `prize`, `name`, `mainBanner`, `detailBanner`, `startDate`, `endDate`, `drawStatus`, `prizewinnerId`, `prizewinnerNickname`, `updateDate`, `createDate`) VALUES
	(1, '아이폰', 'Welcome to Trams', 'Welcome to Trams', 'demo', '2015-11-27 13:41:04', '2015-11-27 13:41:05', '1', '1', 'Kenny', '2015-11-27 13:41:14', '2015-11-27 13:41:15'),
	(2, '아이폰', '이벤트(9/20-9/26)', '이벤트(9/20-9/26)', 'demo', '2015-11-27 13:41:04', '2015-11-27 13:41:05', '1', '1', 'Kenny', '2015-11-27 13:41:14', '2015-11-27 13:41:15'),
	(3, '아이폰', '이벤트(9/20-9/26)', '이벤트(9/20-9/26)', 'demo', '2015-11-27 13:41:04', '2015-11-27 13:41:05', '1', '1', 'Kenny', '2015-11-27 13:41:14', '2015-11-27 13:41:15'),
	(4, '아이폰', 'Welcome to Trams', '이벤트(9/20-9/26)', 'demo', '2015-11-27 13:41:04', '2015-11-27 13:41:05', '1', '1', 'Kenny', '2015-11-27 13:41:14', '2015-11-27 13:41:15'),
	(5, '아이폰', '이벤트(9/20-9/26)', 'Welcome to Trams', 'demo', '2015-11-27 13:41:04', '2015-11-27 13:41:05', '1', '1', 'Kenny', '2015-11-27 13:41:14', '2015-11-27 13:41:15'),
	(6, '아이폰', '이벤트(9/20-9/26)', 'Welcome to Trams', 'demo', '2015-11-27 13:41:04', '2015-11-27 13:41:05', '1', '1', 'Kenny', '2015-11-27 13:41:14', '2015-11-27 13:41:15'),
	(7, '아이폰', '이벤트(9/20-9/26)', 'Welcome to Trams', 'demo', '2015-11-27 13:41:04', '2015-11-27 13:41:05', '1', '1', 'Kenny', '2015-11-27 13:41:14', '2015-11-27 13:41:15'),
	(8, '아이폰', '이벤트(9/20-9/26)', 'Welcome to Trams', 'demo', '2015-11-27 13:41:04', '2015-11-27 13:41:05', '1', '1', 'Kenny', '2015-11-27 13:41:14', '2015-11-27 13:41:15'),
	(9, '아이폰', '이벤트(9/20-9/26)', 'Welcome to Trams', 'demo', '2015-11-27 13:41:04', '2015-11-27 13:41:05', '1', '1', 'Kenny', '2015-11-27 13:41:14', '2015-11-27 13:41:15'),
	(10, '아이폰', '이벤트(9/20-9/26)', 'Welcome to Trams', 'demo', '2015-11-27 13:41:04', '2015-11-27 13:41:05', '1', '1', 'Kenny', '2015-11-27 13:41:14', '2015-11-27 13:41:15'),
	(11, '아이폰', '이벤트(9/20-9/26)', 'Welcome to Trams', 'demo', '2015-11-27 13:41:04', '2015-11-27 13:41:05', '1', '1', 'Kenny', '2015-11-27 13:41:14', '2015-11-27 13:41:15'),
	(12, '아이폰', '이벤트(9/20-9/26)', 'Welcome to Trams', 'demo', '2015-11-27 13:41:04', '2015-11-27 13:41:05', '1', '1', 'Kenny', '2015-11-27 13:41:14', '2015-11-27 13:41:15'),
	(13, '아이폰', 'Welcome to Trams', 'Welcome to Trams', 'demo', '2015-11-27 13:41:04', '2015-11-27 13:41:05', '1', '1', 'Kenny', '2015-11-27 13:41:14', '2015-11-27 13:41:15'),
	(14, '아이폰', 'Welcome to Trams', '이벤트(9/20-9/26)', 'demo', '2015-11-27 13:41:04', '2015-11-27 13:41:05', '1', '1', 'Kenny', '2015-11-27 13:41:14', '2015-11-27 13:41:15'),
	(15, '아이폰', 'Welcome to Trams', '이벤트(9/20-9/26)', 'demo', '2015-11-27 13:41:04', '2015-11-27 13:41:05', '1', '1', 'Kenny', '2015-11-27 13:41:14', '2015-11-27 13:41:15'),
	(16, '아이폰', 'Welcome to Trams', '이벤트(9/20-9/26)', 'demo', '2015-11-27 13:41:04', '2015-11-27 13:41:05', '1', '1', 'Kenny', '2015-11-27 13:41:14', '2015-11-27 13:41:15'),
	(17, '2', '2', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL),
	(18, 'qeeqweq', 'Samsung 2222', NULL, NULL, '2015-11-04 00:00:00', '2015-11-03 23:59:00', NULL, NULL, NULL, '2015-11-30 15:58:37', '2015-11-30 15:58:37'),
	(19, 'qeeqweq', 'This is a event', 'upload/event/2015-11-30 12-00-00-nguoi-dep-yem-do-13.jpg', NULL, '2015-11-10 00:00:00', '2015-11-26 23:59:00', NULL, NULL, NULL, '2015-11-30 16:23:30', '2015-11-30 16:23:30'),
	(20, 'qeeqweq', 'This is a event', 'upload/event/2015-11-30 12-00-00-download (1).jpg', 'upload/event/2015-11-30 12-00-00-download (1).jpg', '2015-11-11 00:00:00', '2015-11-10 23:59:00', NULL, NULL, NULL, '2015-11-30 17:11:15', '2015-11-30 17:11:15'),
	(21, 'qeeqweq', 'Samsung 2222', 'upload/event/2015-12-01 12-00-00-download (2).jpg', 'upload/event/2015-12-01 12-00-00-download (3).jpg', '2015-11-17 00:00:00', '2015-11-03 23:59:00', NULL, NULL, NULL, '2015-12-01 09:15:25', '2015-12-01 09:15:25'),
	(22, 'qeeqweq2', 'This is a event 2', 'upload/event/2015-11-30 12-00-00-download (3).jpg', 'upload/event/2015-11-30 12-00-00-download (4).jpg', '2015-11-10 00:02:00', '2015-11-09 00:01:00', NULL, NULL, NULL, '2015-11-30 17:41:24', '2015-11-30 17:41:24'),
	(23, 'test 2', 'This is a event 2', 'upload/event/2015-12-01 12-00-00-download (1).jpg', 'upload/event/2015-11-30 12-00-00-download (3).jpg', '2015-11-21 00:04:00', '2015-11-01 00:04:00', NULL, NULL, NULL, '2015-12-01 09:02:37', '2015-12-01 09:02:37');
/*!40000 ALTER TABLE `event` ENABLE KEYS */;


-- Dumping structure for table bao.event_pick
CREATE TABLE IF NOT EXISTS `event_pick` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `eventId` int(11) DEFAULT NULL,
  `userId` int(11) DEFAULT NULL,
  `entryDate` timestamp NULL DEFAULT NULL,
  `applicationNumber` int(11) DEFAULT NULL,
  `prizewinner` int(11) DEFAULT NULL,
  `drawStatus` int(1) DEFAULT '0',
  `updateDate` timestamp NULL DEFAULT NULL,
  `createDate` timestamp NULL DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;

-- Dumping data for table bao.event_pick: ~5 rows (approximately)
DELETE FROM `event_pick`;
/*!40000 ALTER TABLE `event_pick` DISABLE KEYS */;
INSERT INTO `event_pick` (`id`, `eventId`, `userId`, `entryDate`, `applicationNumber`, `prizewinner`, `drawStatus`, `updateDate`, `createDate`) VALUES
	(1, 1, 1, '2015-12-01 13:09:31', 1, 2, 1, '2015-12-01 13:09:31', '2015-12-01 13:09:31'),
	(2, 1, 1, '2015-11-30 17:53:28', 1, 2, 1, '2015-11-30 17:53:44', '2015-11-30 17:53:45'),
	(3, 1, 1, '2015-11-30 17:53:28', 1, 2, 0, '2015-11-30 17:53:44', '2015-11-30 17:53:45'),
	(4, 1, 1, '2015-11-30 17:53:28', 1, 2, 1, '2015-11-30 17:53:44', '2015-11-30 17:53:45'),
	(5, 1, 1, '2015-11-30 17:53:28', 1, 2, 1, '2015-11-30 17:53:44', '2015-11-30 17:53:45');
/*!40000 ALTER TABLE `event_pick` ENABLE KEYS */;


-- Dumping structure for table bao.residence
CREATE TABLE IF NOT EXISTS `residence` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `parrentId` int(11) DEFAULT NULL,
  `cityName` varchar(50) DEFAULT NULL,
  `provinceName` varchar(50) DEFAULT NULL,
  `updateDate` timestamp NULL DEFAULT NULL,
  `createaDate` timestamp NULL DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8;

-- Dumping data for table bao.residence: ~8 rows (approximately)
DELETE FROM `residence`;
/*!40000 ALTER TABLE `residence` DISABLE KEYS */;
INSERT INTO `residence` (`id`, `parrentId`, `cityName`, `provinceName`, `updateDate`, `createaDate`) VALUES
	(1, 0, '安徽', '', '2015-11-25 17:56:42', '2015-10-25 17:56:43'),
	(2, 0, '北京', '', '2015-11-25 17:57:53', '2015-11-25 17:57:54'),
	(3, 0, '福建', '', '2015-11-25 17:58:03', '2015-11-25 17:58:03'),
	(5, 1, '东城区', '安徽', '2015-11-25 17:59:39', '2015-11-25 17:59:39'),
	(6, 1, '西城区', '安徽', '2015-11-25 17:59:39', '2015-11-25 17:59:39'),
	(7, 2, '朝阳区', '北京', '2015-11-25 17:59:39', '2015-11-25 17:59:39'),
	(8, 3, '海淀区', '福建', '2015-11-25 17:59:39', '2015-11-25 17:59:39'),
	(9, 3, '丰台区', '福建', '2015-11-25 17:59:39', '2015-11-25 17:59:39');
/*!40000 ALTER TABLE `residence` ENABLE KEYS */;


-- Dumping structure for table bao.save_survey
CREATE TABLE IF NOT EXISTS `save_survey` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `surveyId` int(11) DEFAULT NULL,
  `answer` text,
  `updateDate` timestamp NULL DEFAULT NULL,
  `createDate` timestamp NULL DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- Dumping data for table bao.save_survey: ~0 rows (approximately)
DELETE FROM `save_survey`;
/*!40000 ALTER TABLE `save_survey` DISABLE KEYS */;
/*!40000 ALTER TABLE `save_survey` ENABLE KEYS */;


-- Dumping structure for table bao.survey
CREATE TABLE IF NOT EXISTS `survey` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(300) NOT NULL,
  `earnPoint` double NOT NULL DEFAULT '0',
  `startDate` timestamp NULL DEFAULT NULL,
  `endDate` timestamp NULL DEFAULT NULL,
  `numberParticipants` int(11) DEFAULT NULL,
  `content` text,
  `updateDate` datetime DEFAULT NULL,
  `createDate` timestamp NULL DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- Dumping data for table bao.survey: ~0 rows (approximately)
DELETE FROM `survey`;
/*!40000 ALTER TABLE `survey` DISABLE KEYS */;
/*!40000 ALTER TABLE `survey` ENABLE KEYS */;


-- Dumping structure for table bao.user
CREATE TABLE IF NOT EXISTS `user` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(50) DEFAULT NULL,
  `password` varchar(50) DEFAULT NULL,
  `phone` varchar(50) DEFAULT NULL,
  `nickname` varchar(50) DEFAULT NULL,
  `gender` varchar(50) DEFAULT NULL,
  `yob` int(11) DEFAULT NULL,
  `role` int(11) DEFAULT NULL,
  `province` int(11) DEFAULT NULL,
  `provinceName` varchar(50) DEFAULT NULL,
  `city` int(11) DEFAULT NULL,
  `cityName` char(50) DEFAULT NULL,
  `rank` int(11) DEFAULT NULL,
  `address` varchar(50) DEFAULT NULL,
  `authCode` varchar(50) DEFAULT NULL,
  `apiId` varchar(50) DEFAULT NULL,
  `registorResouce` varchar(50) DEFAULT NULL,
  `updateDate` timestamp NULL DEFAULT NULL,
  `createDate` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

-- Dumping data for table bao.user: ~1 rows (approximately)
DELETE FROM `user`;
/*!40000 ALTER TABLE `user` DISABLE KEYS */;
INSERT INTO `user` (`id`, `username`, `password`, `phone`, `nickname`, `gender`, `yob`, `role`, `province`, `provinceName`, `city`, `cityName`, `rank`, `address`, `authCode`, `apiId`, `registorResouce`, `updateDate`, `createDate`) VALUES
	(1, 'admin', '111111', '01685899892', 'Kenny Phong', '여', 1990, 1, 0, '0', 0, '0', 0, 'so 10 Hang Chao', '', NULL, 'BAO', '2015-11-25 00:00:00', '2015-11-25 00:00:00');
/*!40000 ALTER TABLE `user` ENABLE KEYS */;


-- Dumping structure for table bao.user_coupon
CREATE TABLE IF NOT EXISTS `user_coupon` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `userId` int(11) NOT NULL DEFAULT '0',
  `pauseDate` timestamp NULL DEFAULT NULL,
  `history` varchar(500) DEFAULT NULL,
  `earn` double DEFAULT NULL,
  `used` double DEFAULT NULL,
  `createDate` timestamp NULL DEFAULT NULL,
  `updateDate` timestamp NULL DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8;

-- Dumping data for table bao.user_coupon: ~11 rows (approximately)
DELETE FROM `user_coupon`;
/*!40000 ALTER TABLE `user_coupon` DISABLE KEYS */;
INSERT INTO `user_coupon` (`id`, `userId`, `pauseDate`, `history`, `earn`, `used`, `createDate`, `updateDate`) VALUES
	(1, 1, '2015-11-30 14:29:25', 'coupon', 11, 10, NULL, NULL),
	(2, 1, '2015-11-30 14:29:25', 'coupon', 13, 10, NULL, NULL),
	(3, 1, '2015-11-30 14:29:25', 'coupon', NULL, 10, NULL, NULL),
	(4, 1, '2015-11-30 14:29:25', 'coupon', 10, NULL, NULL, NULL),
	(5, 1, '2015-11-30 14:29:25', 'coupon', 30, 10, NULL, NULL),
	(6, 1, '2015-11-30 14:29:25', 'coupon', 10, NULL, NULL, NULL),
	(7, 1, '2015-11-30 14:29:25', 'coupon', NULL, 10, NULL, NULL),
	(8, 1, '2015-11-30 14:29:25', 'coupon', 10, 10, NULL, NULL),
	(9, 1, '2015-11-30 14:29:25', 'coupon', NULL, NULL, NULL, NULL),
	(10, 1, '2015-11-30 14:29:25', 'coupon', 10, 10, NULL, NULL),
	(11, 1, '2015-11-30 14:29:25', 'coupon', NULL, 10, NULL, NULL);
/*!40000 ALTER TABLE `user_coupon` ENABLE KEYS */;


-- Dumping structure for table bao.user_point
CREATE TABLE IF NOT EXISTS `user_point` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `userId` int(11) NOT NULL DEFAULT '0',
  `pauseDate` timestamp NULL DEFAULT NULL,
  `history` varchar(500) DEFAULT NULL,
  `earn` double DEFAULT NULL,
  `used` double DEFAULT NULL,
  `updateDate` timestamp NULL DEFAULT NULL,
  `createDate` timestamp NULL DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

-- Dumping data for table bao.user_point: ~3 rows (approximately)
DELETE FROM `user_point`;
/*!40000 ALTER TABLE `user_point` DISABLE KEYS */;
INSERT INTO `user_point` (`id`, `userId`, `pauseDate`, `history`, `earn`, `used`, `updateDate`, `createDate`) VALUES
	(1, 1, '2015-11-30 13:51:05', 'test', 1390, 1233, '2015-11-30 13:51:21', '2015-11-30 13:51:22'),
	(2, 0, NULL, 'test', 11, NULL, NULL, NULL),
	(3, 0, NULL, 'test', NULL, NULL, NULL, NULL);
/*!40000 ALTER TABLE `user_point` ENABLE KEYS */;
/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IF(@OLD_FOREIGN_KEY_CHECKS IS NULL, 1, @OLD_FOREIGN_KEY_CHECKS) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
