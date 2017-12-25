

-- Dumping database structure for junggu
DROP DATABASE IF EXISTS `junggu`;
CREATE DATABASE IF NOT EXISTS `junggu` /*!40100 DEFAULT CHARACTER SET utf8 */;
USE `junggu`;


-- Dumping structure for table junggu.accessibility
DROP TABLE IF EXISTS `accessibility`;
CREATE TABLE IF NOT EXISTS `accessibility` (
  `_id` int(11) NOT NULL AUTO_INCREMENT,
  `NAME` varchar(255) NOT NULL,
  `DESCRIPTION` varchar(255) NOT NULL,
  `CREATE_DATE` datetime DEFAULT NULL,
  `UPDATE_DATE` datetime DEFAULT NULL,
  `SELECTED` int(11) DEFAULT '1',
  PRIMARY KEY (`_id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;

-- Dumping data for table junggu.accessibility: ~6 rows (approximately)
DELETE FROM `accessibility`;
/*!40000 ALTER TABLE `accessibility` DISABLE KEYS */;
INSERT INTO `accessibility` (`_id`, `NAME`, `DESCRIPTION`, `CREATE_DATE`, `UPDATE_DATE`, `SELECTED`) VALUES
	(1, '장애진전용 주차장이 있음', 'Có nơi đỗ xe cho người khuyết tật', '2015-11-09 16:30:47', '2015-11-09 16:30:49', 1),
	(2, '계단이나 턱이 없음', 'Không có cầu thang bộ hoặc hầm', '2015-11-09 16:30:50', '2015-11-09 16:30:56', 1),
	(3, '경사로가 있어서 휠체어 접근이 용이함', 'Có lối đi lên dành cho người khuyết tật, đường dốc nghiêng xe lăn và đẩy lên được', '2015-11-09 16:30:51', '2015-11-09 16:30:56', 1),
	(4, '10Cm이하 턱이 있음', 'nên thấp hơn 10cm so với mặt đường', '2015-11-09 16:30:52', '2015-11-09 16:30:57', 1),
	(5, '시각장애인용 점자안내판 있음', 'Có biển cảnh báo chướng ngại vật', '2015-11-09 16:30:53', '2015-11-09 16:30:58', 1),
	(6, '장애인화장실 있음', 'Có nhà vệ sinh dành cho người khuyết tật', '2015-11-09 16:30:54', '2015-11-09 16:30:59', 1);
/*!40000 ALTER TABLE `accessibility` ENABLE KEYS */;


-- Dumping structure for table junggu.category
DROP TABLE IF EXISTS `category`;
CREATE TABLE IF NOT EXISTS `category` (
  `_id` int(11) NOT NULL AUTO_INCREMENT,
  `PARENT_ID` int(11) NOT NULL,
  `CAT_NAME` varchar(255) NOT NULL,
  `DESCRIPTION` varchar(255) DEFAULT NULL,
  `IMAGE` varchar(255) DEFAULT NULL,
  `ETC` varchar(255) DEFAULT NULL,
  `CREATE_DATE` datetime DEFAULT NULL,
  `UPDATE_DATE` datetime DEFAULT NULL,
  PRIMARY KEY (`_id`)
) ENGINE=InnoDB AUTO_INCREMENT=66 DEFAULT CHARSET=utf8;

-- Dumping data for table junggu.category: ~65 rows (approximately)
DELETE FROM `category`;
/*!40000 ALTER TABLE `category` DISABLE KEYS */;
INSERT INTO `category` (`_id`, `PARENT_ID`, `CAT_NAME`, `DESCRIPTION`, `IMAGE`, `ETC`, `CREATE_DATE`, `UPDATE_DATE`) VALUES
	(1, 0, 'HA', NULL, NULL, NULL, '2015-11-11 00:00:00', '2015-11-11 00:00:00'),
	(2, 0, 'HCM', NULL, NULL, NULL, '2015-11-11 00:00:00', '2015-11-11 00:00:00'),
	(3, 0, 'DN', NULL, NULL, NULL, '2015-11-11 00:00:00', '2015-11-11 00:00:00'),
	(4, 0, 'HUE', NULL, NULL, NULL, '2015-11-11 00:00:00', '2015-11-11 00:00:00'),
	(5, 0, 'HOIAN', NULL, NULL, NULL, '2015-11-11 00:00:00', '2015-11-11 00:00:00'),
	(6, 1, '문화관광지', 'Building form', NULL, NULL, '2015-11-06 15:38:49', '2015-11-06 15:38:49'),
	(7, 1, '□ 건물내부시설 및 상점', 'Building form', NULL, NULL, '2015-11-06 15:38:49', '2015-11-06 15:38:49'),
	(8, 2, '문화관광지', 'Facility type', NULL, NULL, '2015-11-06 15:38:49', '2015-11-06 15:38:49'),
	(9, 2, '숙박시설', 'Facility type', NULL, NULL, '2015-11-06 15:38:49', '2015-11-06 15:38:49'),
	(10, 2, '영화관·공연장', 'Facility type', NULL, NULL, '2015-11-06 15:38:49', '2015-11-06 15:38:49'),
	(11, 2, '약국', 'Facility type', NULL, NULL, '2015-11-06 15:38:49', '2015-11-06 15:38:49'),
	(12, 2, '음식점', 'Facility type', NULL, NULL, '2015-11-06 15:38:49', '2015-11-06 15:38:49'),
	(13, 2, '이·미용실', 'Facility type', NULL, NULL, '2015-11-06 15:38:49', '2015-11-06 15:38:49'),
	(14, 2, '제과점(카페)', 'Facility type', NULL, NULL, '2015-11-06 15:38:49', '2015-11-06 15:38:49'),
	(15, 2, '판매상점', 'Facility type', NULL, NULL, '2015-11-06 15:38:49', '2015-11-06 15:38:49'),
	(16, 2, '패스트푸드점', 'Facility type', NULL, NULL, '2015-11-06 15:38:49', '2015-11-06 15:38:49'),
	(17, 2, '화장실', 'Facility type', NULL, NULL, '2015-11-06 15:38:49', '2015-11-06 15:38:49'),
	(18, 2, '기타', 'Facility type', NULL, NULL, '2015-11-06 15:38:49', '2015-11-06 15:38:49'),
	(19, 3, '먹거리', 'Category', NULL, NULL, '2015-11-06 15:38:49', '2015-11-06 15:38:49'),
	(20, 3, '관광지', 'Category', NULL, NULL, '2015-11-06 15:38:49', '2015-11-06 15:38:49'),
	(21, 3, '숙박', 'Category', NULL, NULL, '2015-11-06 15:38:49', '2015-11-06 15:38:49'),
	(22, 3, '쇼핑', 'Category', NULL, NULL, '2015-11-06 15:38:49', '2015-11-06 15:38:49'),
	(23, 3, '생활', 'Category', NULL, NULL, '2015-11-06 15:38:49', '2015-11-06 15:38:49'),
	(24, 4, '장애진전용 주차장이 있음', 'Accessibility information ', NULL, NULL, '2015-11-06 15:38:49', '2015-11-06 15:38:49'),
	(25, 4, '계단이나 턱이 없음', 'Accessibility information ', NULL, NULL, '2015-11-06 15:38:49', '2015-11-06 15:38:49'),
	(26, 4, '경사로가 있어서 휠체어 접근이 용이함', 'Accessibility information ', NULL, NULL, '2015-11-06 15:38:49', '2015-11-06 15:38:49'),
	(27, 4, '10Cm이하 턱이 있음', 'Accessibility information ', NULL, NULL, '2015-11-06 15:38:49', '2015-11-06 15:38:49'),
	(28, 4, '시각장애인용 점자안내판 있음', 'Accessibility information ', NULL, NULL, '2015-11-06 15:38:49', '2015-11-06 15:38:49'),
	(29, 4, '장애인화장실 있음', 'Accessibility information ', NULL, NULL, '2015-11-06 15:38:49', '2015-11-06 15:38:49'),
	(30, 5, '있음', '생활시설(상점) 내 엘리베이터', NULL, NULL, '2015-11-06 15:38:49', '2015-11-06 15:38:49'),
	(31, 5, '있으나 접근 불가', '생활시설(상점) 내 엘리베이터', NULL, NULL, '2015-11-06 15:38:49', '2015-11-06 15:38:49'),
	(32, 5, '없음', '생활시설(상점) 내 엘리베이터', NULL, NULL, '2015-11-06 15:38:49', '2015-11-06 15:38:49'),
	(33, 5, '도보로 5분 안에 접근 가능', '역으로부터의 거리', NULL, NULL, '2015-11-06 15:38:49', '2015-11-06 15:38:49'),
	(34, 5, '도보로 10분 안에 접근 가능', '역으로부터의 거리', NULL, NULL, '2015-11-06 15:38:49', '2015-11-06 15:38:49'),
	(35, 5, '도보로 15분 안에 접근 가능', '역으로부터의 거리', NULL, NULL, '2015-11-06 15:38:49', '2015-11-06 15:38:49'),
	(36, 6, '가능', '엘리베이터 전동휠체어 이용가능여부', NULL, NULL, '2015-11-06 15:38:49', '2015-11-06 15:38:49'),
	(37, 6, '어려움', '엘리베이터 전동휠체어 이용가능여부', NULL, NULL, '2015-11-06 15:38:49', '2015-11-06 15:38:49'),
	(38, 6, '불가능', '엘리베이터 전동휠체어 이용가능여부', NULL, NULL, '2015-11-06 15:38:49', '2015-11-06 15:38:49'),
	(39, 7, '불가능', '엘리베이터 전동스쿠터 이용가능여부', NULL, NULL, '2015-11-06 15:38:49', '2015-11-06 15:38:49'),
	(40, 7, '불가능', '엘리베이터 전동스쿠터 이용가능여부', NULL, NULL, '2015-11-06 15:38:49', '2015-11-06 15:38:49'),
	(41, 7, '불가능', '엘리베이터 전동스쿠터 이용가능여부', NULL, NULL, '2015-11-06 15:38:49', '2015-11-06 15:38:49'),
	(42, 8, '있음', '장애인용 버튼', NULL, NULL, '2015-11-06 15:38:49', '2015-11-06 15:38:49'),
	(43, 8, '있으나 이용 불가', '장애인용 버튼', NULL, NULL, '2015-11-06 15:38:49', '2015-11-06 15:38:49'),
	(44, 8, '없음', '장애인용 버튼', NULL, NULL, '2015-11-06 15:38:49', '2015-11-06 15:38:49'),
	(45, 9, '전면에 설치되어 있어서 편함', '엘리베이터 까지 시각장애인용 점자블럭과 안내표시판이', NULL, NULL, '2015-11-06 15:38:49', '2015-11-06 15:38:49'),
	(46, 9, '부분별로 설치돼서 불편', '엘리베이터 까지 시각장애인용 점자블럭과 안내표시판이', NULL, NULL, '2015-11-06 15:38:49', '2015-11-06 15:38:49'),
	(47, 9, '없음', '엘리베이터 까지 시각장애인용 점자블럭과 안내표시판이', NULL, NULL, '2015-11-06 15:38:49', '2015-11-06 15:38:49'),
	(48, 10, '10인 ~ 20인 이용가능', '내부공간', NULL, NULL, '2015-11-06 15:38:49', '2015-11-06 15:38:49'),
	(49, 10, '20인이상 이용가능', '내부공간', NULL, NULL, '2015-11-06 15:38:49', '2015-11-06 15:38:49'),
	(50, 11, ' 장애인전용 주차장이 있음', '주차구역', NULL, NULL, '2015-11-06 15:38:49', '2015-11-06 15:38:49'),
	(51, 11, ' 일반 주차장만 있음', '주차구역', NULL, NULL, '2015-11-06 15:38:49', '2015-11-06 15:38:49'),
	(52, 11, '주차장 없음', '주차구역', NULL, NULL, '2015-11-06 15:38:49', '2015-11-06 15:38:49'),
	(53, 12, '가능', '내부공간 - 전동휠체어를 타고 이동', NULL, NULL, '2015-11-06 15:38:49', '2015-11-06 15:38:49'),
	(54, 12, '어려움', '내부공간 - 전동휠체어를 타고 이동', NULL, NULL, '2015-11-06 15:38:49', '2015-11-06 15:38:49'),
	(55, 12, '불가능', '내부공간 - 전동휠체어를 타고 이동', NULL, NULL, '2015-11-06 15:38:49', '2015-11-06 15:38:49'),
	(56, 13, '불가능', '내부공간 - 전동스쿠터를 타고 이동', NULL, NULL, '2015-11-06 15:38:49', '2015-11-06 15:38:49'),
	(57, 13, '불가능', '내부공간 - 전동스쿠터를 타고 이동', NULL, NULL, '2015-11-06 15:38:49', '2015-11-06 15:38:49'),
	(58, 13, '불가능', '내부공간 - 전동스쿠터를 타고 이동', NULL, NULL, '2015-11-06 15:38:49', '2015-11-06 15:38:49'),
	(59, 14, '있음', '내부공간 계단이나 단차 존재여부', NULL, NULL, '2015-11-06 15:38:49', '2015-11-06 15:38:49'),
	(60, 14, '없음', '내부공간 계단이나 단차 존재여부', NULL, NULL, '2015-11-06 15:38:49', '2015-11-06 15:38:49'),
	(61, 15, '있음', '장애인과 함께 동석하거나 이동할 있는 자리', NULL, NULL, '2015-11-06 15:38:49', '2015-11-06 15:38:49'),
	(62, 15, '없음', '장애인과 함께 동석하거나 이동할 있는 자리', NULL, NULL, '2015-11-06 15:38:49', '2015-11-06 15:38:49'),
	(63, 16, '10m 이하 ', '주차장에서 상점입구까지 거리', NULL, NULL, '2015-11-06 15:38:49', '2015-11-06 15:38:49'),
	(64, 16, '10m 이상', '주차장에서 상점입구까지 거리', NULL, NULL, '2015-11-06 15:38:49', '2015-11-06 15:38:49'),
	(65, 16, '10m 이상', '주차장에서 상점입구까지 거리', NULL, NULL, '2015-11-06 15:38:49', '2015-11-06 15:38:49');
/*!40000 ALTER TABLE `category` ENABLE KEYS */;


-- Dumping structure for table junggu.comment
DROP TABLE IF EXISTS `comment`;
CREATE TABLE IF NOT EXISTS `comment` (
  `_id` int(11) NOT NULL AUTO_INCREMENT,
  `DETAILS` varchar(1000) NOT NULL,
  `USER_ID` int(11) NOT NULL,
  `STORE_ID` int(11) NOT NULL,
  `GRADE` int(11) DEFAULT '0',
  `IS_DELETE` int(11) DEFAULT '0',
  `CREATE_DATE` datetime DEFAULT NULL,
  `UPDATE_DATE` datetime DEFAULT NULL,
  PRIMARY KEY (`_id`),
  KEY `FK_COMMENT_STORE` (`STORE_ID`),
  CONSTRAINT `FK_COMMENT_STORE` FOREIGN KEY (`STORE_ID`) REFERENCES `store` (`_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- Dumping data for table junggu.comment: ~0 rows (approximately)
DELETE FROM `comment`;
/*!40000 ALTER TABLE `comment` DISABLE KEYS */;
/*!40000 ALTER TABLE `comment` ENABLE KEYS */;


-- Dumping structure for table junggu.facility
DROP TABLE IF EXISTS `facility`;
CREATE TABLE IF NOT EXISTS `facility` (
  `_id` int(11) NOT NULL AUTO_INCREMENT,
  `NAME` varchar(255) NOT NULL,
  `DESCRIPTION` varchar(255) NOT NULL,
  `CREATE_DATE` datetime DEFAULT NULL,
  `UPDATE_DATE` datetime DEFAULT NULL,
  PRIMARY KEY (`_id`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8;

-- Dumping data for table junggu.facility: ~10 rows (approximately)
DELETE FROM `facility`;
/*!40000 ALTER TABLE `facility` DISABLE KEYS */;
INSERT INTO `facility` (`_id`, `NAME`, `DESCRIPTION`, `CREATE_DATE`, `UPDATE_DATE`) VALUES
	(1, '문화관광지', 'Cultural Attractions', NULL, NULL),
	(2, '숙박시설', 'Accommodation', NULL, NULL),
	(3, '영화관·공연장', 'Cinemas , theaters', NULL, NULL),
	(4, '약국□음식점', 'Pharmacy Restaurant', NULL, NULL),
	(5, '이·미용실', 'The beauty salon', NULL, NULL),
	(6, '제과점(카페) ', 'Bakery ( Café )', NULL, NULL),
	(7, '판매상점', 'Sell ​​Stores', NULL, NULL),
	(8, '패스트푸드점', 'Fast food restaurants', NULL, NULL),
	(9, '화장실', 'restroom', NULL, NULL),
	(10, '기타 ', '기타', NULL, NULL);
/*!40000 ALTER TABLE `facility` ENABLE KEYS */;


-- Dumping structure for table junggu.field
DROP TABLE IF EXISTS `field`;
CREATE TABLE IF NOT EXISTS `field` (
  `_id` int(11) NOT NULL AUTO_INCREMENT,
  `NAME` varchar(255) NOT NULL,
  `DESCRIPTION` varchar(255) NOT NULL,
  `CREATE_DATE` datetime DEFAULT NULL,
  `UPDATE_DATE` datetime DEFAULT NULL,
  PRIMARY KEY (`_id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

-- Dumping data for table junggu.field: ~4 rows (approximately)
DELETE FROM `field`;
/*!40000 ALTER TABLE `field` DISABLE KEYS */;
INSERT INTO `field` (`_id`, `NAME`, `DESCRIPTION`, `CREATE_DATE`, `UPDATE_DATE`) VALUES
	(1, '먹거리', 'Food', NULL, NULL),
	(2, '관광지', 'Sight', NULL, NULL),
	(3, '숙박', 'accommodation', NULL, NULL),
	(4, 'Living', 'Living', NULL, NULL);
/*!40000 ALTER TABLE `field` ENABLE KEYS */;


-- Dumping structure for table junggu.intro
DROP TABLE IF EXISTS `intro`;
CREATE TABLE IF NOT EXISTS `intro` (
  `_id` int(11) NOT NULL AUTO_INCREMENT,
  `TITLE` varchar(200) DEFAULT NULL,
  `IMAGE_URL` varchar(1000) NOT NULL,
  `DESCRIPTION` text,
  `IS_DELETE` int(11) DEFAULT '0',
  `CREATE_DATE` datetime DEFAULT NULL,
  `UPDATE_DATE` datetime DEFAULT NULL,
  PRIMARY KEY (`_id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

-- Dumping data for table junggu.intro: ~1 rows (approximately)
DELETE FROM `intro`;
/*!40000 ALTER TABLE `intro` DISABLE KEYS */;
INSERT INTO `intro` (`_id`, `TITLE`, `IMAGE_URL`, `DESCRIPTION`, `IS_DELETE`, `CREATE_DATE`, `UPDATE_DATE`) VALUES
	(1, 'Image', '', NULL, 0, NULL, NULL);
/*!40000 ALTER TABLE `intro` ENABLE KEYS */;


-- Dumping structure for table junggu.notice
DROP TABLE IF EXISTS `notice`;
junggu

-- Dumping data for table junggu.report: ~0 rows (approximately)
DELETE FROM `report`;
/*!40000 ALTER TABLE `report` DISABLE KEYS */;
/*!40000 ALTER TABLE `report` ENABLE KEYS */;


-- Dumping structure for table junggu.store
DROP TABLE IF EXISTS `store`;
CREATE TABLE IF NOT EXISTS `store` (
  `_id` int(11) NOT NULL AUTO_INCREMENT,
  `NAME` varchar(255) NOT NULL,
  `TAG` varchar(255) NOT NULL,
  `SERVICE_HOURS` varchar(255) NOT NULL,
  `HOLIDAY` varchar(255) NOT NULL,
  `BUILDING_FORM` text NOT NULL,
  `FLOOR` varchar(255) NOT NULL,
  `FACILITY_LIST` text NOT NULL,
  `REPRESENTATIVE` varchar(255) NOT NULL,
  `PHONE` varchar(255) NOT NULL,
  `ADDRESS` varchar(255) NOT NULL,
  `MONITORING_DATE` datetime NOT NULL,
  `MONITORING_MAN` varchar(255) NOT NULL,
  `MORNITORING_MAN_PHONE` varchar(255) NOT NULL,
  `FIELD_LIST` varchar(255) DEFAULT NULL,
  `IMAGE_BASE_ATTACH` text,
  `STORE_NAME` varchar(300) DEFAULT NULL,
  `STORE_EXIT` varchar(300) DEFAULT NULL,
  `STORE_ELEVATOR_POSITON` varchar(300) DEFAULT NULL,
  `DISTANCE` text,
  `BUILDING_STRUCTURE` text,
  `PARKING_AREA` text,
  `ENTRANCE_STATUS` text,
  `PURPOSE_NOTE` text,
  `ROOF_OF_REFECTOR` text,
  `TOILETTE_FOR_DEFECTOR` text,
  `MAIN_GOOD_SERVICE` text,
  `STAFF_HELP_DEFECTOR` text,
  `IMAGE_EXTEND_ATTACH` text,
  `GRADE` varchar(255) NOT NULL,
  `ACCESSIBILITY_LIST` text NOT NULL,
  `LONGITUDE` varchar(100) NOT NULL,
  `LATITUDE` varchar(100) NOT NULL DEFAULT '',
  `IS_DELETE` int(11) NOT NULL DEFAULT '0',
  `CREATE_DATE` datetime DEFAULT NULL,
  `UPDATE_DATE` datetime DEFAULT NULL,
  `CAT_ID` varchar(255) DEFAULT NULL,
  `USER_ID` int(11) DEFAULT NULL,
  PRIMARY KEY (`_id`)
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8;

-- Dumping data for table junggu.store: ~1 rows (approximately)
DELETE FROM `store`;
/*!40000 ALTER TABLE `store` DISABLE KEYS */;
INSERT INTO `store` (`_id`, `NAME`, `TAG`, `SERVICE_HOURS`, `HOLIDAY`, `BUILDING_FORM`, `FLOOR`, `FACILITY_LIST`, `REPRESENTATIVE`, `PHONE`, `ADDRESS`, `MONITORING_DATE`, `MONITORING_MAN`, `MORNITORING_MAN_PHONE`, `FIELD_LIST`, `IMAGE_BASE_ATTACH`, `STORE_NAME`, `STORE_EXIT`, `STORE_ELEVATOR_POSITON`, `DISTANCE`, `BUILDING_STRUCTURE`, `PARKING_AREA`, `ENTRANCE_STATUS`, `PURPOSE_NOTE`, `ROOF_OF_REFECTOR`, `TOILETTE_FOR_DEFECTOR`, `MAIN_GOOD_SERVICE`, `STAFF_HELP_DEFECTOR`, `IMAGE_EXTEND_ATTACH`, `GRADE`, `ACCESSIBILITY_LIST`, `LONGITUDE`, `LATITUDE`, `IS_DELETE`, `CREATE_DATE`, `UPDATE_DATE`, `CAT_ID`, `USER_ID`) VALUES
	(11, 'TRAMS VIETNAME', 'coder,it,programer,game,dev', '24', '65', '{"BUILDING_FORM":["6","7"]}', '5', '{"FACILITY_LIST":["1","2","3","4","5","7","9"]}', 'representative', '01685899892', '10 Hang chao', '2015-11-10 02:59:00', '{"MONITORING_MAN":["monitoring_man","monitoring_man","monitoring_man"]}', '{"MORNITORING_MAN_PHONE":["01685899892","01685899892","01685899892"]}', '{"FIELD_LIST":[]}', '{"IMAGE_BASE_ATTACH":[]}', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, '{"IMAGE_EXTEND_ATTACH":[{"name_of_relevant":"66","photos":["\\/images\\/upload\\/1447148933245.jpg","\\/images\\/upload\\/1447148933414.jpg","\\/images\\/upload\\/1447148933567.jpg","\\/images\\/upload\\/1447148933757.jpg","\\/images\\/upload\\/1447148933910.jpg"]},{"name_of_relevant":"33","photos":["\\/images\\/upload\\/1447148934085.jpg"]}]}', 'grade', '{"ACCESSIBILITY_LIST":["1","2","3","4","5","6"]}', 'longitude', 'latitude', 0, '2015-11-10 16:48:54', '2015-11-10 16:48:54', '{"CATEGORY_ID":["19","20","21"],"CATEGORY_NAME":["먹거리","관광지","숙박"]}', 66);
/*!40000 ALTER TABLE `store` ENABLE KEYS */;


-- Dumping structure for table junggu.user
DROP TABLE IF EXISTS `user`;
CREATE TABLE IF NOT EXISTS `user` (
  `_id` int(11) NOT NULL AUTO_INCREMENT,
  `USERNAME` varchar(200) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL,
  `PASSWORD` varchar(100) NOT NULL,
  `NICKNAME` varchar(200) DEFAULT NULL,
  `FULLNAME` varchar(255) DEFAULT NULL,
  `ROLE` int(11) DEFAULT '0',
  `SEX` varchar(50) DEFAULT NULL,
  `PHONE` varchar(200) DEFAULT NULL,
  `EMAIL` varchar(255) DEFAULT NULL,
  `AGE` int(11) DEFAULT NULL,
  `IS_DELETE` int(11) DEFAULT '0',
  `CREATE_DATE` datetime DEFAULT NULL,
  `UPDATE_DATE` datetime DEFAULT NULL,
  PRIMARY KEY (`_id`),
  UNIQUE KEY `USERNAME` (`USERNAME`)
) ENGINE=InnoDB AUTO_INCREMENT=70 DEFAULT CHARSET=utf8;

-- Dumping data for table junggu.user: ~7 rows (approximately)
DELETE FROM `user`;
/*!40000 ALTER TABLE `user` DISABLE KEYS */;
INSERT INTO `user` (`_id`, `USERNAME`, `PASSWORD`, `NICKNAME`, `FULLNAME`, `ROLE`, `SEX`, `PHONE`, `EMAIL`, `AGE`, `IS_DELETE`, `CREATE_DATE`, `UPDATE_DATE`) VALUES
	(10, 'user1', '698d51a19d8a121ce581499d7b701668', 'dfsfs', NULL, 1, 'sex', '11111', NULL, NULL, 0, '2015-11-06 11:23:49', '2015-11-06 11:23:48'),
	(12, 'user2', '698d51a19d8a121ce581499d7b701668', 'dfsfs', 'dfsfs', 0, 'sex', '11111', 'dfsfs', 22, 0, '2015-11-06 11:23:50', '2015-11-06 11:23:51'),
	(22, 'user4', '698d51a19d8a121ce581499d7b701668', 'dfsfs', 'dfsfs', 0, 'sex', '40230489302', 'dfsfs', 22, 0, '2015-11-06 11:23:53', '2015-11-06 11:23:53'),
	(27, 'user6', '698d51a19d8a121ce581499d7b701668', '', '', 1, '', '09430294023', '', NULL, 0, '2015-11-06 11:24:00', '2015-11-06 11:23:56'),
	(66, 'admin', '698d51a19d8a121ce581499d7b701668', '', '', 1, '', '09430294023', '', NULL, 0, '2015-11-06 11:24:00', '2015-11-06 11:23:56'),
	(67, 'abc', '4ed9407630eb1000c0f6b63842defa7d', 'def', 'faf', 0, 'male', '1165516', 'daf@gmail.com', 33, 0, '2015-11-09 22:03:32', '2015-11-09 22:03:32'),
	(68, 'snnmxnx', '60d46ae9dd82f97888d8b1f1f029fede', NULL, NULL, 0, NULL, NULL, NULL, NULL, 0, '2015-11-10 08:54:05', '2015-11-10 08:54:05');
/*!40000 ALTER TABLE `user` ENABLE KEYS */;


-- Dumping structure for table junggu.version
DROP TABLE IF EXISTS `version`;
CREATE TABLE IF NOT EXISTS `version` (
  `_id` int(11) NOT NULL AUTO_INCREMENT,
  `NAME` varchar(200) NOT NULL,
  `STATUS` varchar(100) NOT NULL,
  `ETC` varchar(255) DEFAULT NULL,
  `CREATE_DATE` datetime DEFAULT NULL,
  `UPDATE_DATE` datetime DEFAULT NULL,
  PRIMARY KEY (`_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- Dumping data for table junggu.version: ~0 rows (approximately)
DELETE FROM `version`;
/*!40000 ALTER TABLE `version` DISABLE KEYS */;
/*!40000 ALTER TABLE `version` ENABLE KEYS */;
/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IF(@OLD_FOREIGN_KEY_CHECKS IS NULL, 1, @OLD_FOREIGN_KEY_CHECKS) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
