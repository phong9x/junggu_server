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


-- Dumping structure for table junggu.category
CREATE TABLE IF NOT EXISTS `category` (
  `_id` int(11) NOT NULL AUTO_INCREMENT,
  `PARENT_ID` int(11) NOT NULL,
  `CAT_NAME` varchar(255) NOT NULL,
  `CAT_NAME_ADMIN` varchar(255) DEFAULT NULL,
  `IMAGE` varchar(500) DEFAULT NULL,
  `CREATE_DATE` datetime DEFAULT NULL,
  `UPDATE_DATE` datetime DEFAULT NULL,
  `IS_DELETE` int(1) DEFAULT '0',
  PRIMARY KEY (`_id`)
) ENGINE=InnoDB AUTO_INCREMENT=108 DEFAULT CHARSET=utf8;

-- Dumping data for table junggu.category: ~107 rows (approximately)
DELETE FROM `category`;
/*!40000 ALTER TABLE `category` DISABLE KEYS */;
INSERT INTO `category` (`_id`, `PARENT_ID`, `CAT_NAME`, `CAT_NAME_ADMIN`, `IMAGE`, `CREATE_DATE`, `UPDATE_DATE`, `IS_DELETE`) VALUES
	(1, 0, '소공동', '소공동', NULL, '2015-11-18 10:20:33', '2015-11-18 10:20:34', 0),
	(2, 0, '회현동', '회현동', NULL, '2015-11-18 10:20:33', '2015-11-18 10:20:34', 0),
	(3, 0, '명동', '명동', NULL, '2015-11-18 10:20:33', '2015-11-18 10:20:34', 0),
	(4, 0, '필동', '필동', NULL, '2015-11-18 10:20:33', '2015-11-18 10:20:34', 0),
	(5, 0, '장충동', '장충동', NULL, '2015-11-18 10:20:33', '2015-11-18 10:20:34', 0),
	(6, 0, '광희동', '광희동', NULL, '2015-11-18 10:20:33', '2015-11-18 10:20:34', 0),
	(7, 0, '을지로동', '을지로동', NULL, '2015-11-18 10:20:33', '2015-11-18 10:20:34', 0),
	(8, 0, '신당동', '신당동', NULL, '2015-11-18 10:20:33', '2015-11-18 10:20:34', 0),
	(9, 0, '다산동', '다산동', NULL, '2015-11-18 10:20:33', '2015-11-18 10:20:34', 0),
	(10, 0, '약수동', '약수동', NULL, '2015-11-18 10:20:33', '2015-11-18 10:20:34', 0),
	(11, 0, '청구동', '청구동', NULL, '2015-11-18 10:20:33', '2015-11-18 10:20:34', 0),
	(12, 0, '동화동', '동화동', NULL, '2015-11-18 10:20:33', '2015-11-18 10:20:34', 0),
	(13, 0, '신당6동', '신당6동', NULL, '2015-11-18 10:20:33', '2015-11-18 10:20:34', 0),
	(14, 0, '황학동', '황학동', NULL, '2015-11-18 10:20:33', '2015-11-18 10:20:34', 0),
	(15, 0, '중림동', '중림동', NULL, '2015-11-18 10:20:33', '2015-11-18 10:20:34', 0),
	(16, 1, '소공동', '소공동', NULL, '2015-11-18 10:20:33', '2015-11-18 10:20:34', 0),
	(17, 1, '북창동', '북창동', NULL, '2015-11-18 10:20:33', '2015-11-18 10:20:34', 0),
	(18, 1, '충정로1가', '충정로1가', NULL, '2015-11-18 10:20:33', '2015-11-18 10:20:34', 0),
	(19, 1, '서소문동', '서소문동', NULL, '2015-11-18 10:20:33', '2015-11-18 10:20:34', 0),
	(20, 1, '정동', '정동', NULL, '2015-11-18 10:20:33', '2015-11-18 10:20:34', 0),
	(21, 1, '태평로2가', '태평로2가', NULL, '2015-11-18 10:20:33', '2015-11-18 10:20:34', 0),
	(22, 1, '의주로1가', '의주로1가', NULL, '2015-11-18 10:20:33', '2015-11-18 10:20:34', 0),
	(23, 1, '순화동', '순화동', NULL, '2015-11-18 10:20:33', '2015-11-18 10:20:34', 0),
	(24, 1, '봉래동1가', '봉래동1가', NULL, '2015-11-18 10:20:33', '2015-11-18 10:20:34', 0),
	(25, 1, '남대문로2가', '남대문로2가', NULL, '2015-11-18 10:20:33', '2015-11-18 10:20:34', 0),
	(26, 1, '남대문로3가', '남대문로3가', NULL, '2015-11-18 10:20:33', '2015-11-18 10:20:34', 0),
	(27, 1, '남대문로4가', '남대문로4가', NULL, '2015-11-18 10:20:33', '2015-11-18 10:20:34', 0),
	(28, 2, '남대문로3가', '남대문로3가', NULL, '2015-11-18 10:20:33', '2015-11-18 10:20:34', 0),
	(29, 2, '남대문로4가', '남대문로4가', NULL, '2015-11-18 10:20:33', '2015-11-18 10:20:34', 0),
	(30, 2, '남대문로5가', '남대문로5가', NULL, '2015-11-18 10:20:33', '2015-11-18 10:20:34', 0),
	(31, 2, '남창동', '남창동', NULL, '2015-11-18 10:20:33', '2015-11-18 10:20:34', 0),
	(32, 2, '봉래동1가', '봉래동1가', NULL, '2015-11-18 10:20:33', '2015-11-18 10:20:34', 0),
	(33, 2, '봉래동2가', '봉래동2가', NULL, '2015-11-18 10:20:33', '2015-11-18 10:20:34', 0),
	(34, 2, '충무로1가', '충무로1가', NULL, '2015-11-18 10:20:33', '2015-11-18 10:20:34', 0),
	(35, 2, '순화동', '순화동', NULL, '2015-11-18 10:20:33', '2015-11-18 10:20:34', 0),
	(36, 2, '회현동1가', '회현동1가', NULL, '2015-11-18 10:20:33', '2015-11-18 10:20:34', 0),
	(37, 2, '회현동2가', '회현동2가', NULL, '2015-11-18 10:20:33', '2015-11-18 10:20:34', 0),
	(38, 3, '회현동1가', '회현동1가', NULL, '2015-11-18 10:20:33', '2015-11-18 10:20:34', 0),
	(39, 3, '회현동2가', '회현동2가', NULL, '2015-11-18 10:20:33', '2015-11-18 10:20:34', 0),
	(40, 3, '회현동3가', '회현동3가', NULL, '2015-11-18 10:20:33', '2015-11-18 10:20:34', 0),
	(41, 3, '무교동', '무교동', NULL, '2015-11-18 10:20:33', '2015-11-18 10:20:34', 0),
	(42, 3, '다동', '다동', NULL, '2015-11-18 10:20:33', '2015-11-18 10:20:34', 0),
	(43, 3, '태평로1가', '태평로1가', NULL, '2015-11-18 10:20:33', '2015-11-18 10:20:34', 0),
	(44, 3, '을지로1가', '을지로1가', NULL, '2015-11-18 10:20:33', '2015-11-18 10:20:34', 0),
	(45, 3, '을지로2가', '을지로2가', NULL, '2015-11-18 10:20:33', '2015-11-18 10:20:34', 0),
	(46, 3, '남대문로1가', '남대문로1가', NULL, '2015-11-18 10:20:33', '2015-11-18 10:20:34', 0),
	(47, 3, '남대문로2가', '남대문로2가', NULL, '2015-11-18 10:20:33', '2015-11-18 10:20:34', 0),
	(48, 3, '삼각동', '삼각동', NULL, '2015-11-18 10:20:33', '2015-11-18 10:20:34', 0),
	(49, 3, '수하동', '수하동', NULL, '2015-11-18 10:20:33', '2015-11-18 10:20:34', 0),
	(50, 3, '장교동', '장교동', NULL, '2015-11-18 10:20:33', '2015-11-18 10:20:34', 0),
	(51, 3, '수표동', '수표동', NULL, '2015-11-18 10:20:33', '2015-11-18 10:20:34', 0),
	(52, 3, '명동1가', '명동1가', NULL, '2015-11-18 10:20:33', '2015-11-18 10:20:34', 0),
	(53, 3, '명동2가', '명동2가', NULL, '2015-11-18 10:20:33', '2015-11-18 10:20:34', 0),
	(54, 3, '남산동1가', '남산동1가', NULL, '2015-11-18 10:20:33', '2015-11-18 10:20:34', 0),
	(55, 3, '남산동2가', '남산동2가', NULL, '2015-11-18 10:20:33', '2015-11-18 10:20:34', 0),
	(56, 3, '남산동3가', '남산동3가', NULL, '2015-11-18 10:20:33', '2015-11-18 10:20:34', 0),
	(57, 3, '저동1가', '저동1가', NULL, '2015-11-18 10:20:33', '2015-11-18 10:20:34', 0),
	(58, 3, '예장동', '예장동', NULL, '2015-11-18 10:20:33', '2015-11-18 10:20:34', 0),
	(59, 3, '충무로1가', '충무로1가', NULL, '2015-11-18 10:20:33', '2015-11-18 10:20:34', 0),
	(60, 3, '충무로2가', '충무로2가', NULL, '2015-11-18 10:20:33', '2015-11-18 10:20:34', 0),
	(61, 4, '충무로3가', '충무로3가', NULL, '2015-11-18 10:20:33', '2015-11-18 10:20:34', 0),
	(62, 4, '충무로4가', '충무로4가', NULL, '2015-11-18 10:20:33', '2015-11-18 10:20:34', 0),
	(63, 4, '충무로5가', '충무로5가', NULL, '2015-11-18 10:20:33', '2015-11-18 10:20:34', 0),
	(64, 4, '묵정동', '묵정동', NULL, '2015-11-18 10:20:33', '2015-11-18 10:20:34', 0),
	(65, 4, '필동1가', '필동1가', NULL, '2015-11-18 10:20:33', '2015-11-18 10:20:34', 0),
	(66, 4, '필동2가', '필동2가', NULL, '2015-11-18 10:20:33', '2015-11-18 10:20:34', 0),
	(67, 4, '필동3가', '필동3가', NULL, '2015-11-18 10:20:33', '2015-11-18 10:20:34', 0),
	(68, 4, '남학동', '남학동', NULL, '2015-11-18 10:20:33', '2015-11-18 10:20:34', 0),
	(69, 4, '주자동', '주자동', NULL, '2015-11-18 10:20:33', '2015-11-18 10:20:34', 0),
	(70, 4, '예장동', '예장동', NULL, '2015-11-18 10:20:33', '2015-11-18 10:20:34', 0),
	(71, 4, '장충동2가', '장충동2가', NULL, '2015-11-18 10:20:33', '2015-11-18 10:20:34', 0),
	(72, 5, '장충동2가', '장충동2가', NULL, '2015-11-18 10:20:33', '2015-11-18 10:20:34', 0),
	(73, 5, '장충동1가', '장충동1가', NULL, '2015-11-18 10:20:33', '2015-11-18 10:20:34', 0),
	(74, 5, '묵정동', '묵정동', NULL, '2015-11-18 10:20:33', '2015-11-18 10:20:34', 0),
	(75, 6, '충무로4가', '충무로4가', NULL, '2015-11-18 10:20:33', '2015-11-18 10:20:34', 0),
	(76, 6, '충무로5가', '충무로5가', NULL, '2015-11-18 10:20:33', '2015-11-18 10:20:34', 0),
	(77, 6, '인현동2가', '인현동2가', NULL, '2015-11-18 10:20:33', '2015-11-18 10:20:34', 0),
	(78, 6, '예관동', '예관동', NULL, '2015-11-18 10:20:33', '2015-11-18 10:20:34', 0),
	(79, 6, '광희동1가', '광희동1가', NULL, '2015-11-18 10:20:33', '2015-11-18 10:20:34', 0),
	(80, 6, '광희동2가', '광희동2가', NULL, '2015-11-18 10:20:33', '2015-11-18 10:20:34', 0),
	(81, 6, '쌍림동', '쌍림동', NULL, '2015-11-18 10:20:33', '2015-11-18 10:20:34', 0),
	(82, 6, '오장동', '오장동', NULL, '2015-11-18 10:20:33', '2015-11-18 10:20:34', 0),
	(83, 6, '을지로6가', '을지로6가', NULL, '2015-11-18 10:20:33', '2015-11-18 10:20:34', 0),
	(84, 6, '을지로7가', '을지로7가', NULL, '2015-11-18 10:20:33', '2015-11-18 10:20:34', 0),
	(85, 7, '을지로3가', '을지로3가', NULL, '2015-11-18 10:20:33', '2015-11-18 10:20:34', 0),
	(86, 7, '을지로4가', '을지로4가', NULL, '2015-11-18 10:20:33', '2015-11-18 10:20:34', 0),
	(87, 7, '을지로5가', '을지로5가', NULL, '2015-11-18 10:20:33', '2015-11-18 10:20:34', 0),
	(88, 7, '주교동', '주교동', NULL, '2015-11-18 10:20:33', '2015-11-18 10:20:34', 0),
	(89, 7, '방산동', '방산동', NULL, '2015-11-18 10:20:33', '2015-11-18 10:20:34', 0),
	(90, 7, '입정동', '입정동', NULL, '2015-11-18 10:20:33', '2015-11-18 10:20:34', 0),
	(91, 7, '산림동', '산림동', NULL, '2015-11-18 10:20:33', '2015-11-18 10:20:34', 0),
	(92, 7, '초동', '초동', NULL, '2015-11-18 10:20:33', '2015-11-18 10:20:34', 0),
	(93, 7, '인현동1가', '인현동1가', NULL, '2015-11-18 10:20:33', '2015-11-18 10:20:34', 0),
	(94, 7, '저동2가', '저동2가', NULL, '2015-11-18 10:20:33', '2015-11-18 10:20:34', 0),
	(95, 8, '흥인동', '흥인동', NULL, '2015-11-18 10:20:33', '2015-11-18 10:20:34', 0),
	(96, 8, '무학동', '무학동', NULL, '2015-11-18 10:20:33', '2015-11-18 10:20:34', 0),
	(97, 8, '신당동', '신당동', NULL, '2015-11-18 10:20:33', '2015-11-18 10:20:34', 0),
	(98, 9, '신당2동', '신당2동', NULL, '2015-11-18 10:20:33', '2015-11-18 10:20:34', 0),
	(99, 10, '신당3동', '신당3동', NULL, '2015-11-18 10:20:33', '2015-11-18 10:20:34', 0),
	(100, 11, '신당4동', '신당4동', NULL, '2015-11-18 10:20:33', '2015-11-18 10:20:34', 0),
	(101, 12, '신당5동', '신당5동', NULL, '2015-11-18 10:20:33', '2015-11-18 10:20:34', 0),
	(102, 13, '신당5동', '신당5동', NULL, '2015-11-18 10:20:33', '2015-11-18 10:20:34', 0),
	(103, 14, '황학동', '황학동', NULL, '2015-11-18 10:20:33', '2015-11-18 10:20:34', 0),
	(104, 15, '의주로2가', '의주로2가', NULL, '2015-11-18 10:20:33', '2015-11-18 10:20:34', 0),
	(105, 15, '중림동', '중림동', NULL, '2015-11-18 10:20:33', '2015-11-18 10:20:34', 0),
	(106, 15, '만리동1가', '만리동1가', NULL, '2015-11-18 10:20:33', '2015-11-18 10:20:34', 0),
	(107, 15, '만리동2가', '만리동2가', NULL, '2015-11-18 10:20:33', '2015-11-18 10:20:34', 0);
/*!40000 ALTER TABLE `category` ENABLE KEYS */;
/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IF(@OLD_FOREIGN_KEY_CHECKS IS NULL, 1, @OLD_FOREIGN_KEY_CHECKS) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
