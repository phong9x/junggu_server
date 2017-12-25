-- --------------------------------------------------------
-- Host:                         192.168.170.150
-- Server version:               5.6.25 - Homebrew
-- Server OS:                    osx10.10
-- HeidiSQL Version:             9.3.0.4984
-- --------------------------------------------------------

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET NAMES utf8mb4 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;

-- Dumping database structure for junggu
DROP DATABASE IF EXISTS `junggu`;
CREATE DATABASE IF NOT EXISTS `junggu` /*!40100 DEFAULT CHARACTER SET utf8 */;
USE `junggu`;


-- Dumping structure for table junggu.ACCESSIBILITY
DROP TABLE IF EXISTS `ACCESSIBILITY`;
CREATE TABLE IF NOT EXISTS `ACCESSIBILITY` (
  `_id` int(11) NOT NULL AUTO_INCREMENT,
  `NAME` varchar(255) NOT NULL,
  `DESCRIPTION` varchar(255) NOT NULL,
  `CREATE_DATE` datetime DEFAULT NULL,
  `UPDATE_DATE` datetime DEFAULT NULL,
  `SELECTED` int(11) DEFAULT '1',
  PRIMARY KEY (`_id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;

-- Dumping data for table junggu.ACCESSIBILITY: ~6 rows (approximately)
DELETE FROM `ACCESSIBILITY`;
/*!40000 ALTER TABLE `ACCESSIBILITY` DISABLE KEYS */;
INSERT INTO `ACCESSIBILITY` (`_id`, `NAME`, `DESCRIPTION`, `CREATE_DATE`, `UPDATE_DATE`, `SELECTED`) VALUES
	(1, '장애진전용 주차장이 있음', 'Có nơi đỗ xe cho người khuyết tật', NULL, NULL, 1),
	(2, '계단이나 턱이 없음', 'Không có cầu thang bộ hoặc hầm', NULL, NULL, 1),
	(3, '경사로가 있어서 휠체어 접근이 용이함', 'Có lối đi lên dành cho người khuyết tật, đường dốc nghiêng xe lăn và đẩy lên được', NULL, NULL, 1),
	(4, '10Cm이하 턱이 있음', 'nên thấp hơn 10cm so với mặt đường', NULL, NULL, 1),
	(5, '시각장애인용 점자안내판 있음', 'Có biển cảnh báo chướng ngại vật', NULL, NULL, 1),
	(6, '장애인화장실 있음', 'Có nhà vệ sinh dành cho người khuyết tật', NULL, NULL, 1);
/*!40000 ALTER TABLE `ACCESSIBILITY` ENABLE KEYS */;


-- Dumping structure for table junggu.CATEGORY
DROP TABLE IF EXISTS `CATEGORY`;
CREATE TABLE IF NOT EXISTS `CATEGORY` (
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

-- Dumping data for table junggu.CATEGORY: ~59 rows (approximately)
DELETE FROM `CATEGORY`;
/*!40000 ALTER TABLE `CATEGORY` DISABLE KEYS */;
INSERT INTO `CATEGORY` (`_id`, `PARENT_ID`, `CAT_NAME`, `DESCRIPTION`, `IMAGE`, `ETC`, `CREATE_DATE`, `UPDATE_DATE`) VALUES
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
/*!40000 ALTER TABLE `CATEGORY` ENABLE KEYS */;


-- Dumping structure for table junggu.COMMENT
DROP TABLE IF EXISTS `COMMENT`;
CREATE TABLE IF NOT EXISTS `COMMENT` (
  `_id` int(11) NOT NULL AUTO_INCREMENT,
  `DETAILS` varchar(1000) NOT NULL,
  `USER_ID` int(11) NOT NULL,
  `STORE_ID` int(11) NOT NULL,
  `GRADE` int(11) DEFAULT '0',
  `CREATE_DATE` datetime DEFAULT NULL,
  `UPDATE_DATE` datetime DEFAULT NULL,
  PRIMARY KEY (`_id`),
  KEY `FK_COMMENT_STORE` (`STORE_ID`),
  CONSTRAINT `FK_COMMENT_STORE` FOREIGN KEY (`STORE_ID`) REFERENCES `STORE` (`_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- Dumping data for table junggu.COMMENT: ~0 rows (approximately)
DELETE FROM `COMMENT`;
/*!40000 ALTER TABLE `COMMENT` DISABLE KEYS */;
/*!40000 ALTER TABLE `COMMENT` ENABLE KEYS */;


-- Dumping structure for table junggu.FACILITY
DROP TABLE IF EXISTS `FACILITY`;
CREATE TABLE IF NOT EXISTS `FACILITY` (
  `_id` int(11) NOT NULL AUTO_INCREMENT,
  `NAME` varchar(255) NOT NULL,
  `DESCRIPTION` varchar(255) NOT NULL,
  `CREATE_DATE` datetime DEFAULT NULL,
  `UPDATE_DATE` datetime DEFAULT NULL,
  PRIMARY KEY (`_id`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8;

-- Dumping data for table junggu.FACILITY: ~10 rows (approximately)
DELETE FROM `FACILITY`;
/*!40000 ALTER TABLE `FACILITY` DISABLE KEYS */;
INSERT INTO `FACILITY` (`_id`, `NAME`, `DESCRIPTION`, `CREATE_DATE`, `UPDATE_DATE`) VALUES
	(1, '문화관광지', 'Cultural Attractions', NULL, NULL),
	(2, '숙박시설', 'Accommodation', NULL, NULL),
	(3, '영화관·공연장', 'Cinemas , theaters', NULL, NULL),
	(4, '약국□음식점', 'Pharmacy Restaurant', NULL, NULL),
	(5, '이·미용실', 'The beauty salon', NULL, NULL),
	(6, '제과점(카페) ', 'Bakery ( Café )', NULL, NULL),
	(7, '판매상점', 'Sell ​​Stores', NULL, NULL),
	(8, '패스트푸드점', 'Fast food restaurants', NULL, NULL),
	(9, '화장실', 'restroom', NULL, NULL),
	(10, 'etc..', 'etc...', NULL, NULL);
/*!40000 ALTER TABLE `FACILITY` ENABLE KEYS */;


-- Dumping structure for table junggu.FIELD
DROP TABLE IF EXISTS `FIELD`;
CREATE TABLE IF NOT EXISTS `FIELD` (
  `_id` int(11) NOT NULL AUTO_INCREMENT,
  `NAME` varchar(255) NOT NULL,
  `DESCRIPTION` varchar(255) NOT NULL,
  `CREATE_DATE` datetime DEFAULT NULL,
  `UPDATE_DATE` datetime DEFAULT NULL,
  PRIMARY KEY (`_id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

-- Dumping data for table junggu.FIELD: ~4 rows (approximately)
DELETE FROM `FIELD`;
/*!40000 ALTER TABLE `FIELD` DISABLE KEYS */;
INSERT INTO `FIELD` (`_id`, `NAME`, `DESCRIPTION`, `CREATE_DATE`, `UPDATE_DATE`) VALUES
	(1, '먹거리', 'Food', NULL, NULL),
	(2, '관광지', 'Sight', NULL, NULL),
	(3, '숙박', 'accommodation', NULL, NULL),
	(4, 'Living', 'Living', NULL, NULL);
/*!40000 ALTER TABLE `FIELD` ENABLE KEYS */;


-- Dumping structure for table junggu.NOTICE
DROP TABLE IF EXISTS `NOTICE`;
CREATE TABLE IF NOT EXISTS `NOTICE` (
  `_id` int(11) NOT NULL AUTO_INCREMENT,
  `TITLE` varchar(1000) NOT NULL DEFAULT '',
  `CONTENT` text,
  `NOTICE_TYPE` int(11) DEFAULT NULL,
  `CREATE_DATE` datetime DEFAULT NULL,
  `UPDATE_DATE` datetime DEFAULT NULL,
  `USER_ID` int(11) NOT NULL,
  PRIMARY KEY (`_id`)
) ENGINE=InnoDB AUTO_INCREMENT=18 DEFAULT CHARSET=utf8;

-- Dumping data for table junggu.NOTICE: ~11 rows (approximately)
DELETE FROM `NOTICE`;
/*!40000 ALTER TABLE `NOTICE` DISABLE KEYS */;
INSERT INTO `NOTICE` (`_id`, `TITLE`, `CONTENT`, `NOTICE_TYPE`, `CREATE_DATE`, `UPDATE_DATE`, `USER_ID`) VALUES
	(6, 'Gangnam Style statue built in South Korea\'s Seoul', 'A statue dedicated to the South Korean music hit Gangnam Style is to be unveiled in the Seoul district made famous by the song.\r\nThe metal sculpture will show two fists overlapped in the style of the song\'s "horse-riding" dance move.\r\nIt will be erected outside the COEX shopping centre, where part of the video was filmed.\r\nGangnam Style was released by South Korean singer Psy in 2012 and remains the most-watched YouTube video ever.\r\nIt has been viewed more than 2.4 billion times.\r\nGangnam tourism director Park Hee-Soo said he hoped the statue would "become a landmark for our district".\r\n"Tourists can take pictures under the statue and the song will play automatically when you stand there," he added.', 1, '2015-11-07 22:20:48', '2015-11-07 22:20:48', 25),
	(7, 'China and Taiwan leaders hail historic talks', 'The leaders of China and Taiwan have held historic talks in Singapore - their first in more than 60 years.\r\nChinese President Xi Jinping and Taiwan\'s President Ma Ying-jeou shook hands at the start of the talks, which were seen as largely symbolic.\r\nChina views Taiwan as a breakaway province which will one day be reunited with the mainland.\r\nBut many Taiwanese see it as independent and are concerned at China\'s growing influence.\r\nThe awkward questions that could crop up\r\nWhat\'s behind the China-Taiwan divide?\r\n"Both sides should respect each other\'s values and way of life," Mr Ma said as the talks began at a luxury hotel.\r\nMr Xi told the Taiwanese leader: "We are one family."\r\nThe Chinese and Taiwanese leaders meet in Singapore, 7 November 2015Image copyrightEPA\r\nThe meeting "has opened a historic chapter in the cross-Strait relations, and history will remember today", he added.\r\nThe meeting took place in neutral territory on the sidelines of a state visit by Mr Xi to Singapore.\r\nRelations between China and Taiwan have improved under Mr Ma since he took office in 2008, with better economic ties, improving tourism links, and a trade pact signed.\r\nThe two sides split in 1949 when the Kuomintang lost to the Chinese Communist Party in the civil war and set up a new government in Taiwan.\r\nJump media playerMedia player helpOut of media player. Press enter to return or tab to continue.\r\nMedia captionCindy Sui reports on protests in Taipei against the meeting between Taiwan and China\r\nWhat wasn\'t discussed\r\nMr Ma described the talks as "positive and friendly", but no major agreements or deals appear to have been reached.\r\nMr Ma said in advance that the issue of the South China Sea disputes, which has dominated recent concerns in the region, would not be brought up.\r\nWhat was discussed\r\nMr Ma proposed reducing hostility across the Taiwan Strait, expanding exchanges and establishing a cross-strait hotline, according to Taiwan\'s central news agency.\r\nHe said this was part of consolidating the "1992 consensus" - the agreement under which both sides recognise the principle of "one China" but define it in their own ways.\r\nSimilar remarks were made by Mr Xi, who said upholding the consensus would help "the great rejuvenation of the Chinese nation".\r\nJump media playerMedia player helpOut of media player. Press enter to return or tab to continue.\r\nMedia captionChina-Taiwan relations in 60 seconds\r\nWhy are they meeting now?\r\nIt is not entirely clear why the meeting has happened at this time, as neither side has properly said.\r\nMr Ma has built his presidency on closer links with China, so there is a good reason for him to meet Mr Xi, says the BBC World Service\'s Asia editor, Michael Bristow.\r\nThere is also a presidential election in Taiwan in January. Mr Ma might think the meeting will give a boost to his party\'s candidate, who is trailing in the polls, our correspondent says.\r\nChina also has something to gain, and that also concerns Taiwan\'s election. Mr Xi\'s decision to talk reminds Taiwanese voters that China is far friendlier to a government of Mr Ma\'s nationalist party than one formed by the opposition, which leans towards independence for Taiwan.\r\nIt is a calculated gamble for Mr Xi, as China\'s attempts to influence Taiwanese voters have previously backfired, our correspondent adds.', 1, '2015-11-07 22:21:39', '2015-11-07 22:21:39', 25),
	(8, 'Maldives police raid TV station over \'threatening video\'', 'Police in the Maldives raided a private television station in connection with a YouTube video allegedly threatening President Abdulla Yameen.\r\nPolice removed hard discs from Sangu TV\'s studios in the capital Male.\r\nThe video reportedly shows three masked men issuing a death threat against the president.\r\nPresident Yameen imposed a state of emergency on Wednesday after the military said it found a bomb in a vehicle near the presidential palace.\r\n"The station has come to a complete standstill," Sangu TV\'s managing director Ibrahim Waheed said.\r\n"They turned the whole office upside down in search of evidence. The office safe has also been broken into and searched. They\'ve taken all the hard drives of all our computer systems."\r\nHe added that was certain Sangu TV\'s staff and management had not uploaded the video, Minivan News reported.', 1, '2015-11-07 22:22:29', '2015-11-07 22:22:29', 25),
	(9, 'India v South Africa: Ravindra Jadeja spins hosts to victory', 'Spinner Ravindra Jadeja took his third five-wicket Test haul as India beat South Africa by 108 runs inside three days in the first Test in Mohali.\r\n\r\nThe Proteas, needing 218 to win, never recovered after a disastrous start left them 10-3 and were bowled out for 109.\r\n\r\nSlow left-armer Jadeja took 5-21 on his comeback after being dropped for recent tours of Bangladesh and Sri Lanka.\r\n\r\nIndia began the day on 125-2 in their second innings but were skittled for 200, with Cheteshwar Pujara hitting 77.\r\n\r\nSouth Africa had won the Twenty20 series 2-0 and taken the five-match one-day series 3-2 to raise hopes of a first Test series win on Indian soil in 15 years - and gave themselves a chance by bowling India out cheaply for a second time.', 1, '2015-11-07 22:23:01', '2015-11-07 22:23:01', 25),
	(10, 'China-Taiwan meeting: Awkward questions Xi and Ma could ask', 'On Saturday, for the first time since their bitter split at the end of the Chinese civil war in 1949, the leaders of China and Taiwan will meet.\r\nThis is on a par with US President Barack Obama meeting with Cuba\'s Raul Castro except, unlike Washington and Havana, the two sides still haven\'t normalised relations. In fact they haven\'t even signed a peace treaty and in 66 years they have taken very different paths.\r\nNo agreements will be signed, no joint statements made, but China\'s Xi Jinping and Taiwan\'s Ma Ying-jeou will have an hour-long meeting and a casual dinner afterwards. It could get awkward and here are some of the questions that could crop up.\r\nWhy do you still have missiles pointed at me?\r\nFile photo of China missiles on a military parade from 2009.Image copyrightFREDERIC J. BROWN\r\nImage caption\r\nChina has not renounced the use of force to take Taiwan back and its might is regularly put on display at military parades\r\nProtesters display two mock missiles to demand the Chinese government pull out their weapons aimed at the island from across the Taiwan Strait, during a demonstration outside the hotel in the central city of Taichung where Chen Yunlin, the mainland\'s top Taiwan negotiator, is staying during his visit on December 22, 2009Image copyrightPATRICK LIN\r\nImage caption\r\nThe missiles have also inspired protests in Taiwan in the past\r\nChina has hundreds of missiles targeted at Taiwan to warn the island against declaring formal independence. Beijing still considers Taiwan a province to be reunified with the mainland one day and has not renounced the use of force to take it back. In fact, one of the main reasons for its military build-up is to counter possible US assistance to Taiwan if Beijing were to try to take back militarily.\r\nMr. Ma would argue: "If you want to be friends, you must remove these missiles."\r\n"Not that simple," Mr Xi might answer. Doing so could embolden pro-independence groups in Taiwan who want the island to be recognised as a completely separate country from China.', 1, '2015-11-07 22:23:41', '2015-11-07 22:23:41', 25),
	(11, 'US rejects Keystone XL pipeline from Canada', 'US President Barack Obama has announced he is rejecting an application to build the Keystone XL pipeline from Canada.\r\nSpeaking from the White House, he said it would not have served the "national interests" of the US.\r\nIts construction has been hotly disputed for seven years, with environmentalists saying it would do irreparable damage.\r\nBut the president said the pipeline had taken on an "overinflated role" in the climate change debate.\r\nThe proposed pipeline would have run 1,179-miles (1,897km) taking 800,000 barrels of oil a day from Alberta, Canada, to Steele City, Nebraska.\r\nBut Mr Obama said it would not have:\r\nlowered petrol prices\r\ncreated long-term jobs\r\naffected energy dependence\r\n"The pipeline would not make a meaningful long-term contribution to our economy," he said.\r\nRepublican presidential candidates condemned the news, with Jeb Bush calling it an attack on the US economy.\r\nIn February, the Republican-led Congress voted to begin construction immediately, but Mr Obama vetoed the bill to await environmental reports.\r\nLarge factories and industry\r\nImage caption\r\nAlberta tar sands in Canada, where the pipeline would have connected\r\nAnalysis: Anthony Zurcher - North America politics reporter\r\nIt took more than seven years, but Barack Obama has finally got to "no".\r\nMaybe it was the election of a Liberal government in Canada that is more suspicious of big energy projects. Maybe it was the sharp decline in oil prices over the past year. Or maybe it was Friday\'s announcement that the US unemployment rate has dropped to 5%, the lowest of Mr Obama\'s presidency.\r\nWhatever the explanation, the president decided now was the time to finally strike the death blow to the controversial pipeline. It\'s a move that will be heralded by environmentalists, condemned by Republicans on the presidential campaign trail and - almost certainly - largely overlooked by an American public that was never really engaged on the issue.\r\nThe president\'s decision puts Democratic presidential frontrunner Hillary Clinton in a comfortable spot. She had recently come out against the pipeline, and Mr Obama\'s move takes the issue off the table - at least for now.\r\nThe decision comes as world leaders plan to meet in Paris at the end of the month to finalise a major global climate agreement.\r\nThe agreement, which could be reached at the meeting known as the UN Climate Change Conference or COP 21, would be a major part of the president\'s legacy.\r\nVideo: Why does Paris climate change conference matter?\r\nWhile the project is dead for now, the pipeline controversy will not end any time soon.\r\nProponents will almost certainly challenge the decision in court and if a Republican is elected president next year, construction could yet be approved.\r\nThe pipeline also generated controversy outside of Washington, souring relations between the former Canadian Prime Minister Stephen Harper and the US president.\r\nPresident Obama said he had spoken to newly-elected Canadian Prime Minister Justin Trudeau and they agreed the issue of climate change trumped any differences of opinion over the pipeline.\r\nMap of pipeline', 1, '2015-11-07 22:24:29', '2015-11-07 22:24:29', 25),
	(12, 'Activision Blizzard to launch a TV and film studio', 'Activision Blizzard, maker of the Call of Duty video game, announced it will make original films and TV series.\r\nThe newly formed Activision Blizzard Studios will base the shows and movies on the company\'s games.\r\nIt plans to release a TV series based on Skylanders Academy in 2016 and films based of the military videogame Call of Duty starting in 2018 or 2019.\r\nThe firm made the announcement during its annual fan convention called BlizzCon.\r\nNick van Dyk co-president of Activision Blizzard Studios said the studio would deliver the "action that fans expect from this franchise".\r\n"We\'ll have a fraction of the overhead of the typical studio since we\'re starting with a blank page and building an organization that is right-sized for our intended creative output and for the future of the industry," he said.\r\nBranching out\r\nActivision already had plans to release a film based on its game franchise Warcraft in 2016 through a partnership with Legendary Pictures.\r\nIt is a further effort by the company to expand beyond games for games consoles.\r\nOn Monday Activision announced plans to buy mobile phone game maker King Digital Entertainment, the creator of Candy Crush.\r\nThat deal is valued at $5.9bn (£3.9bn).', 1, '2015-11-07 22:25:05', '2015-11-07 22:25:05', 25),
	(13, 'Greenpeace loses Indian registration', 'Greenpeace says its charitable registration to operate in India has been revoked.\r\nThe environmental campaign group says that the decision effectively shuts it down in India.\r\nThe government of Narendra Modi has previously accused Greenpeace of flouting tax laws and having an anti-development agenda.\r\nThe pressure group has been working in India for 14 years and employs more than 300 people.\r\nThe BBC\'s correspondent in Delhi, Justin Rowlatt, says Mr Modi\'s government has been accused of a major crackdown on NGOs and charitable groups ever since he came to power in 2014.\r\nGreenpeace says it plans to challenge this latest decision. It follows a ruling that the organisation could not raise money abroad - which was itself successfully challenged.\r\nInterim Executive Director Vinuta Gopal said in a statement:\r\n"We are confident that we are on strong legal ground. We have faith in the legal process and are confident of overcoming this order."', 1, '2015-11-07 22:26:14', '2015-11-07 22:26:14', 25),
	(14, 'Tim Peake aims to rekindle excitement of Moon missions', 'British astronaut Tim Peake says he hopes his mission to the space station will generate an Apollo-like fervour.\r\nMr Peake told BBC News that he is going to the orbiting lab primarily to do science, but that his priority will be to share his experiences.\r\nHe believes his mission can inspire more young people to become interested in science and engineering.\r\nMr Peake\'s six-month stint on the station begins in December when he leaves Earth on a Russian Soyuz rocket.\r\nADVERTISING\r\n \r\n\r\nThe Union flag is going to be flown and worn in space again\r\nTim Peake, on being British\r\n"The legacy I hope is that this will inspire a new generation to look at science, to look at space, as an exciting career path, and to make choices that push them in that direction," he said.\r\nFriday saw him go in front of the media in his home country for the final time before his great adventure gets under way.\r\nHe now heads to Moscow to complete final training, before then flying to the Baikonur Cosmodrome in Kazakhstan for the launch.\r\nNot having fresh air for 6 months is what I\'ll miss most\r\nTim Peake, on what he\'ll miss\r\nHis Soyuz is scheduled to lift off at 11:02 GMT on 15 December.\r\nBy 18:33 GMT that evening, he should be floating through the hatch into the International Space Station.\r\nAmerican astronaut Tim Kopra and Russian cosmonaut Yuri Malenchenko will be going up with him, to form a six-person crew with the three residents already on the platform.\r\nTim Peake: Career in brief\r\nBorn on 7 April 1972 in Chichester, West Sussex\r\nStudied at Chichester High School for Boys, leaving to attend the Royal Military Academy in Sandhurst\r\nAfter graduating, he served in the Army Air Corps and flew Apache helicopters\r\nRetired from the Army in 2009 and was employed as a senior helicopter test pilot for AgustaWestland\r\nSelected as a European Space Agency astronaut in May 2009 and completed basic training the following year.\r\nHas been training for his six-month mission aboard the International Space Station, scheduled for launch on 15 December 2015\r\nEnjoys skiing, scuba diving, cross-country running, climbing, and mountaineering, and he is interested in quantum physics and aviation\r\nTim Peake: How I became a British astronaut\r\nTim Peake: 360 degree photos\r\nAware that he will be stuck inside a sealed complex for a half year, Mr Peake says the thing he is likely to miss the most, other than his family, is fresh air.\r\nThomas Reiter is the director of human spaceflight at the European Space Agency, and is himself a hugely experienced astronaut.\r\nHis advice for the Briton: "It\'s important to use every second you have to look at our beautiful planet and to enjoy the view.\r\nThe vacuum is what keeps everything moving in the right direction\r\nTim Peake, on using a space loo\r\n"Even if you are there for half a year, it\'s important to take every opportunity to look down, or up in space because this view is just as fascinating."\r\nTim Peake\'s stay will be dominated by doing science - everything from investigating future materials to finding better ways to fight disease.\r\nMany of these experiments will be commanded from the ground, and Mr Peake will be acting as a kind of high-flying lab technician, checking equipment is doing what it should and changing set-ups when required.\r\nBut he will also be a guinea pig for a series of medical tests. Twenty-three in total.\r\nTim PeakeImage copyrightEPA\r\nThese will study a range of conditions, from asthma to problems associated with the immune system.\r\nA major imperative for Mr Peake, though, will be his educational programme.\r\nWith the help of the UK Space Agency, he has activities planned for all ages - from four up to graduate level.\r\nIt\'s our moonshot moment and we\'ve got to make the most of it\r\nJo Johnson, UK science minister\r\nThese include, for example, programming and running Raspberry Pi computers in orbit.\r\n"It will take a few years to identify the educational legacy but we\'re working as hard as we can to make sure we have the biggest impact across all the schools in the UK during the mission - by running competitions, by raising awareness of what\'s going on, by having fun with science, but with a more serious undertone to get more people involved in science, engineering and maths," he said.\r\nTim Peake is the first "official" UK astronaut. That is, he is the first to fly on a government-supported programme.\r\nAll those "Brits" that have gone before him have done so either as US citizens or as part of private ventures - like Helen Sharman, who went to the Mir space station in 1991.\r\nScience Minister Jo Johnson said it was a big event for the country: "We\'re spending as a country £400m a year on our UK Space Agency and much of that is spending in collaboration with the European Space Agency which is a real force multiplier for us.\r\n"And I want to say that this is such a brilliant moment for science in the UK. Nothing is going to be more inspiring than what Tim is going to be doing on 15 December. It\'s our moonshot moment and we\'ve got to make the most of it."', 1, '2015-11-07 22:26:58', '2015-11-07 22:26:58', 25),
	(15, 'Former Putin aide Mikhail Lesin found dead in US hotel', 'A former aide to Russian President Vladimir Putin has been found dead in Washington DC, Russian officials say.\r\nMikhail Lesin, 57, Russia\'s former press minister and a one-time head of the powerful Gazprom-Media Holding group, died on Thursday, they said.\r\nRussian media, quoting his family, said he suffered a heart attack.\r\nThe Washington Post quoted Russian embassy officials as saying Mr Lesin\'s body was found in a room at the Dupont Circle hotel.\r\nIt reported that police were investigating the death of a man but that he had not yet been formally identified.\r\nLast year, Mississippi senator Roger Wicker called for an investigation into Mr Lesin, saying his fortune "raises serious questions".\r\nIn a letter to the US Department of Justice, Sen Wicker said Mr Lesin bought property worth $28m (£18.6m) in Los Angeles for his family after finishing work as a civil servant.\r\nSen Wicker asked how a former civil servant would have been able to buy and maintain expensive property, and expressed concern their purchase may have involved people and groups on a US sanctions list.\r\nRUSSIAN PRESIDENT VLADIMIR PUTIN AND THEN-MASS MEDIA MINISTER, MIKHAIL LESIN, AT NEWS CONFERENCE - 22 January 2002Image copyrightReuters\r\nImage caption\r\nVladimir Putin spoke of Mikhail Lesin\'s "enormous contribution" to Russian media\r\nBBC Russian said Mr Lesin was for a long time considered one of the most influential figures in the Russian media market and in the corridors of power.\r\nMr Lesin worked as an aide to the presidency between 2004 and 2009, when he helped advise on the creation of the news channel Russia Today.\r\nLate on Friday, Mr Putin hailed "the enormous contribution made by Mikhail Lesin to the formation of modern Russian media", according to Tass.\r\nLast year, Mr Lesin was accused of trying to force a radio station in which he was a shareholder to cut an interview with opposition figure Alexei Navalny.\r\nAnd Sen Wicker\'s letter said Mr Lesin "led the Kremlin\'s effort to censor Russia\'s independent television outlets".\r\nHe resigned from Gazprom-Media last year.\r\nThe Ria-Novosti agency said he leaves a wife, son and daughter.', 1, '2015-11-07 22:27:51', '2015-11-07 22:27:51', 25),
	(16, 'Louisiana marshals face murder charge over boy\'s gun death', 'Two marshals in the US state of Louisiana are to be charged with murder after the fatal shooting of a six-year-old boy.\r\nJeremy Mardis and his father, Chris Few, were in a car when they were shot in Marksville on Tuesday night.\r\nOfficers Norris Greenhouse and Derrick Stafford were arrested after a vehicle chase that left Mr Few, who was driving, critically injured.\r\nJeremy died at the scene and Mr Few remains in hospital.\r\nThe two officers were arrested on Friday after body-camera footage taken from them was assessed.\r\nIt is still unclear what led them to pursue Mr Few and what triggered the shooting.', 1, '2015-11-07 22:28:22', '2015-11-07 22:28:22', 25),
	(17, 'Why Phil Collins is returning from \'miserable\' retirement', '29 October 2015 Last updated at 10:08 GMT\r\nBritish singer Phil Collins has said he is coming out of retirement and is even planning to tour.\r\nTelegraph music critic Neil McCormick, who recently interviewed Collins, told the Today programme that his retirement “sounded pretty dull” and that the world would welcome back the Genesis drummer and solo artist.\r\nCollins announced in 2011 that he was no longer able to play the drums because of health problems “so it\'ll be Phil without a fill” McCormick told presenter Mishal Husain.\r\n“He says he can sing. I think music is for life, and if you can sing and you can do it, then it’s a wonderful decision.”\r\nRead more\r\nPhil Collins \'no longer retired\'', 1, '2015-11-07 22:29:12', '2015-11-07 22:29:12', 25);
/*!40000 ALTER TABLE `NOTICE` ENABLE KEYS */;


-- Dumping structure for table junggu.REPORT
DROP TABLE IF EXISTS `REPORT`;
CREATE TABLE IF NOT EXISTS `REPORT` (
  `_id` int(11) NOT NULL AUTO_INCREMENT,
  `PHONE_NUMBER` varchar(200) NOT NULL,
  `DETAILS` varchar(1000) NOT NULL,
  `USER_ID` int(11) NOT NULL,
  `STORE_ID` int(11) NOT NULL,
  `CREATE_DATE` datetime DEFAULT NULL,
  `UPDATE_DATE` datetime DEFAULT NULL,
  PRIMARY KEY (`_id`),
  KEY `FK_REPORT_STORE` (`STORE_ID`),
  CONSTRAINT `FK_REPORT_STORE` FOREIGN KEY (`STORE_ID`) REFERENCES `STORE` (`_id`)
) ENGINE=InnoDB AUTO_INCREMENT=14 DEFAULT CHARSET=utf8;

-- Dumping data for table junggu.REPORT: ~13 rows (approximately)
DELETE FROM `REPORT`;
/*!40000 ALTER TABLE `REPORT` DISABLE KEYS */;
INSERT INTO `REPORT` (`_id`, `PHONE_NUMBER`, `DETAILS`, `USER_ID`, `STORE_ID`, `CREATE_DATE`, `UPDATE_DATE`) VALUES
	(1, '0973425295', 'test,test,test,test,test', 1, 2, '2015-11-09 14:09:10', '2015-11-09 14:09:11'),
	(2, '0973425295', 'test,test,test,test,test', 1, 2, '2015-11-09 14:09:10', '2015-11-09 14:09:11'),
	(3, '0973425295', 'test,test,test,test,test', 1, 2, '2015-11-09 14:09:10', '2015-11-09 14:09:11'),
	(4, '0973425295', 'test,test,test,test,test', 1, 2, '2015-11-09 14:09:10', '2015-11-09 14:09:11'),
	(5, '0973425295', 'test,test,test,test,test', 1, 2, '2015-11-09 14:09:10', '2015-11-09 14:09:11'),
	(6, '0973425295', 'test,test,test,test,test', 1, 2, '2015-11-09 14:09:10', '2015-11-09 14:09:11'),
	(7, '0973425295', 'test,test,test,test,test', 1, 2, '2015-11-09 14:09:10', '2015-11-09 14:09:11'),
	(8, '0973425295', 'test,test,test,test,test', 1, 2, '2015-11-09 14:09:10', '2015-11-09 14:09:11'),
	(9, '0973425295', 'test,test,test,test,test', 1, 2, '2015-11-09 14:09:10', '2015-11-09 14:09:11'),
	(10, '0973425295', 'test,test,test,test,test', 1, 2, '2015-11-09 14:09:10', '2015-11-09 14:09:11'),
	(11, '0973425295', 'test,test,test,test,test', 1, 2, '2015-11-09 14:09:10', '2015-11-09 14:09:11'),
	(12, '0973425295', 'test,test,test,test,test', 1, 2, '2015-11-09 14:09:10', '2015-11-09 14:09:11'),
	(13, '0973425295', 'test,test,test,test,test', 1, 2, '2015-11-09 14:09:10', '2015-11-09 14:09:11');
/*!40000 ALTER TABLE `REPORT` ENABLE KEYS */;


-- Dumping structure for table junggu.STORE
DROP TABLE IF EXISTS `STORE`;
CREATE TABLE IF NOT EXISTS `STORE` (
  `_id` int(11) NOT NULL AUTO_INCREMENT,
  `NAME` varchar(255) NOT NULL,
  `TAG` varchar(255) NOT NULL,
  `SERVICE_HOURS` varchar(255) NOT NULL,
  `HOLIDAY` varchar(255) NOT NULL,
  `BUILDING_FORM` varchar(255) NOT NULL,
  `FLOOR` varchar(255) NOT NULL,
  `FACILITY_LIST` varchar(255) NOT NULL,
  `REPRESENTATIVE` varchar(255) NOT NULL,
  `PHONE` varchar(255) NOT NULL,
  `ADDRESS` varchar(255) NOT NULL,
  `MONITORING_DATE` datetime NOT NULL,
  `MONITORING_MAN` varchar(255) NOT NULL,
  `MORNITORING_MAN_PHONE` varchar(255) NOT NULL,
  `FIELD_LIST` varchar(255) DEFAULT NULL,
  `IMAGE_BASE_ATTACH` varchar(255) DEFAULT NULL,
  `IMAGE_EXTEND_ATTACH` varchar(255) DEFAULT NULL,
  `GRADE` varchar(255) NOT NULL,
  `ACCESSIBILITY_LIST` varchar(255) NOT NULL,
  `LONGITUDE` varchar(100) NOT NULL,
  `LATITUDE` varchar(100) NOT NULL DEFAULT '',
  `CREATE_DATE` datetime DEFAULT NULL,
  `UPDATE_DATE` datetime DEFAULT NULL,
  `CAT_ID` varchar(255) DEFAULT NULL,
  `USER_ID` int(11) DEFAULT NULL,
  `LATIUDE` varchar(100) NOT NULL,
  PRIMARY KEY (`_id`)
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8;

-- Dumping data for table junggu.STORE: ~11 rows (approximately)
DELETE FROM `STORE`;
/*!40000 ALTER TABLE `STORE` DISABLE KEYS */;
INSERT INTO `STORE` (`_id`, `NAME`, `TAG`, `SERVICE_HOURS`, `HOLIDAY`, `BUILDING_FORM`, `FLOOR`, `FACILITY_LIST`, `REPRESENTATIVE`, `PHONE`, `ADDRESS`, `MONITORING_DATE`, `MONITORING_MAN`, `MORNITORING_MAN_PHONE`, `FIELD_LIST`, `IMAGE_BASE_ATTACH`, `IMAGE_EXTEND_ATTACH`, `GRADE`, `ACCESSIBILITY_LIST`, `LONGITUDE`, `LATITUDE`, `CREATE_DATE`, `UPDATE_DATE`, `CAT_ID`, `USER_ID`, `LATIUDE`) VALUES
	(1, 'Samsung 2222', 'samsung,korean', '7', 'festival', '7', '13th', '8,12', 'ok', '0988907709', 'Seul,Guong-ul', '2015-11-06 11:29:16', 'won', '0988907706', 'dfdasf', 'sdfsf', 'dsfdasf', 'ok', '25,26,28', 'dfsdaf', 'dsfdsaf', '2015-11-06 11:28:58', '2015-11-06 11:30:21', '20,22', 1, ''),
	(2, 'Samsung', 'samsung', '7', 'festival', 'Seul', '13th', 'dasfasf', 'ok', '0988907709', 'Seul,Guong-ul', '2015-11-06 11:29:16', 'won', '0988907706', 'dfdasf', 'sdfsf', 'dsfdasf', 'ok', 'dsassaads', 'dfsdaf', 'dsfdsaf', '2015-11-06 11:28:58', '2015-11-06 11:30:21', '1,2,3,4', 1, ''),
	(3, 'Samsung', 'samsung', '7', 'festival', 'Seul', '13th', 'dasfasf', 'ok', '0988907709', 'Seul,Guong-ul', '2015-11-06 11:29:16', 'won', '0988907706', 'dfdasf', 'sdfsf', 'dsfdasf', 'ok', 'dsassaads', 'dfsdaf', 'dsfdsaf', '2015-11-06 11:28:58', '2015-11-06 11:30:21', '1,2,3,4', 1, ''),
	(4, 'Samsung', 'samsung', '7', 'festival', 'Seul', '13th', 'dasfasf', 'ok', '0988907709', 'Seul,Guong-ul', '2015-11-06 11:29:16', 'won', '0988907706', 'dfdasf', 'sdfsf', 'dsfdasf', 'ok', 'dsassaads', 'dfsdaf', 'dsfdsaf', '2015-11-06 11:28:58', '2015-11-06 11:30:21', '1,2,3,4', 1, ''),
	(5, 'Samsung', 'samsung', '7', 'festival', 'Seul', '13th', 'dasfasf', 'ok', '0988907709', 'Seul,Guong-ul', '2015-11-06 11:29:16', 'won', '0988907706', 'dfdasf', 'sdfsf', 'dsfdasf', 'ok', 'dsassaads', 'dfsdaf', 'dsfdsaf', '2015-11-06 11:28:58', '2015-11-06 11:30:21', '1,2,3,4', 1, ''),
	(6, 'Samsung', 'samsung', '7', 'festival', 'Seul', '13th', 'dasfasf', 'ok', '0988907709', 'Seul,Guong-ul', '2015-11-06 11:29:16', 'won', '0988907706', 'dfdasf', 'sdfsf', 'dsfdasf', 'ok', 'dsassaads', 'dfsdaf', 'dsfdsaf', '2015-11-06 11:28:58', '2015-11-06 11:30:21', '1,2,3,4', 1, ''),
	(7, 'Samsung', 'samsung', '7', 'festival', 'Seul', '13th', 'dasfasf', 'ok', '0988907709', 'Seul,Guong-ul', '2015-11-06 11:29:16', 'won', '0988907706', 'dfdasf', 'sdfsf', 'dsfdasf', 'ok', 'dsassaads', 'dfsdaf', 'dsfdsaf', '2015-11-06 11:28:58', '2015-11-06 11:30:21', '1,2,3,4', 1, ''),
	(8, 'Samsung', 'samsung', '7', 'festival', 'Seul', '13th', 'dasfasf', 'ok', '0988907709', 'Seul,Guong-ul', '2015-11-06 11:29:16', 'won', '0988907706', 'dfdasf', 'sdfsf', 'dsfdasf', 'ok', 'dsassaads', 'dfsdaf', 'dsfdsaf', '2015-11-06 11:28:58', '2015-11-06 11:30:21', '1,2,3,4', 1, ''),
	(9, 'Samsung', 'samsung', '7', 'festival', 'Seul', '13th', 'dasfasf', 'ok', '0988907709', 'Seul,Guong-ul', '2015-11-06 11:29:16', 'won', '0988907706', 'dfdasf', 'sdfsf', 'dsfdasf', 'ok', 'dsassaads', 'dfsdaf', 'dsfdsaf', '2015-11-06 11:28:58', '2015-11-06 11:30:21', '1,2,3,4', 1, ''),
	(10, 'Samsung', 'samsung', '7', 'festival', 'Seul', '13th', 'dasfasf', 'ok', '0988907709', 'Seul,Guong-ul', '2015-11-06 11:29:16', 'won', '0988907706', 'dfdasf', 'sdfsf', 'dsfdasf', 'ok', 'dsassaads', 'dfsdaf', 'dsfdsaf', '2015-11-06 11:28:58', '2015-11-06 11:30:21', '1,2,3,4', 1, ''),
	(11, 'Samsung', 'samsung', '7', 'festival', 'Seul', '13th', 'dasfasf', 'ok', '0988907709', 'Seul,Guong-ul', '2015-11-06 11:29:16', 'won', '0988907706', 'dfdasf', 'sdfsf', 'dsfdasf', 'ok', 'dsassaads', 'dfsdaf', 'dsfdsaf', '2015-11-06 11:28:58', '2015-11-06 11:30:21', '1,2,3,4', 1, '');
/*!40000 ALTER TABLE `STORE` ENABLE KEYS */;


-- Dumping structure for table junggu.USER
DROP TABLE IF EXISTS `USER`;
CREATE TABLE IF NOT EXISTS `USER` (
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
  `CREATE_DATE` datetime DEFAULT NULL,
  `UPDATE_DATE` datetime DEFAULT NULL,
  PRIMARY KEY (`_id`),
  UNIQUE KEY `USERNAME` (`USERNAME`)
) ENGINE=InnoDB AUTO_INCREMENT=66 DEFAULT CHARSET=utf8;

-- Dumping data for table junggu.USER: ~14 rows (approximately)
DELETE FROM `USER`;
/*!40000 ALTER TABLE `USER` DISABLE KEYS */;
INSERT INTO `USER` (`_id`, `USERNAME`, `PASSWORD`, `NICKNAME`, `FULLNAME`, `ROLE`, `SEX`, `PHONE`, `EMAIL`, `AGE`, `CREATE_DATE`, `UPDATE_DATE`) VALUES
	(6, 'admin', '698d51a19d8a121ce581499d7b701668', 'dfsfs', 'dfsfs', 1, 'sex', '09482843', 'dfsfs', 22, '2015-11-06 11:23:47', '2015-11-06 11:23:47'),
	(10, 'user1', '698d51a19d8a121ce581499d7b701668', 'dfsfs', NULL, NULL, NULL, '11111', NULL, NULL, '2015-11-06 11:23:49', '2015-11-06 11:23:48'),
	(12, 'user2', '698d51a19d8a121ce581499d7b701668', 'dfsfs', 'dfsfs', 0, 'sex', '11111', 'dfsfs', 22, '2015-11-06 11:23:50', '2015-11-06 11:23:51'),
	(18, 'user3', '698d51a19d8a121ce581499d7b701668', 'dfsfs', 'dfsfs', 0, 'sex', '09430294023', 'dfsfs', 22, '2015-11-06 11:23:52', '2015-11-06 11:23:51'),
	(22, 'user4', '698d51a19d8a121ce581499d7b701668', 'dfsfs', 'dfsfs', 0, 'sex', '40230489302', 'dfsfs', 22, '2015-11-06 11:23:53', '2015-11-06 11:23:53'),
	(24, 'user5', '698d51a19d8a121ce581499d7b701668', 'aa', 'aa', 1, 'aa', '99999999999', 'fadfd@gmail.com', 1, '1970-01-01 08:00:00', '2015-11-06 11:23:54'),
	(25, 'quyetdd', '698d51a19d8a121ce581499d7b701668', '', '', 1, '', '09430294023', '', NULL, '2015-11-06 11:24:01', '2015-11-06 11:23:55'),
	(27, 'user6', '698d51a19d8a121ce581499d7b701668', '', '', NULL, '', '09430294023', '', NULL, '2015-11-06 11:24:00', '2015-11-06 11:23:56'),
	(35, 'user7', '698d51a19d8a121ce581499d7b701668', '', '', NULL, '', '09430294023', '', NULL, '2015-11-06 11:23:59', '2015-11-06 11:23:56'),
	(38, 'user8', '698d51a19d8a121ce581499d7b701668', '', '', NULL, '', '09430294023', '', NULL, '2015-11-06 11:23:58', '2015-11-06 11:23:57'),
	(39, 'abc', 'def', '', '', NULL, '', '', '', NULL, NULL, NULL),
	(43, 'rrr', '698d51a19d8a121ce581499d7b701668', NULL, NULL, 0, NULL, NULL, NULL, NULL, '2015-11-06 12:58:05', '2015-11-06 12:58:05'),
	(63, 'quyetdd1', '698d51a19d8a121ce581499d7b701668', NULL, NULL, 0, NULL, NULL, NULL, NULL, '2015-11-06 23:22:40', '2015-11-06 23:22:40'),
	(64, 'quyetdd123', '207462d2fdaa209532ee2e5541860dd1', '', '', 0, '', '', '', NULL, '2015-11-09 09:42:40', '2015-11-09 09:42:40');
/*!40000 ALTER TABLE `USER` ENABLE KEYS */;


-- Dumping structure for table junggu.VERSION
DROP TABLE IF EXISTS `VERSION`;
CREATE TABLE IF NOT EXISTS `VERSION` (
  `_id` int(11) NOT NULL AUTO_INCREMENT,
  `NAME` varchar(200) NOT NULL,
  `STATUS` varchar(100) NOT NULL,
  `ETC` varchar(255) DEFAULT NULL,
  `CREATE_DATE` datetime DEFAULT NULL,
  `UPDATE_DATE` datetime DEFAULT NULL,
  PRIMARY KEY (`_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- Dumping data for table junggu.VERSION: ~0 rows (approximately)
DELETE FROM `VERSION`;
/*!40000 ALTER TABLE `VERSION` DISABLE KEYS */;
/*!40000 ALTER TABLE `VERSION` ENABLE KEYS */;
/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IF(@OLD_FOREIGN_KEY_CHECKS IS NULL, 1, @OLD_FOREIGN_KEY_CHECKS) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
