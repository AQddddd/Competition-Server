-- MySQL dump 10.13  Distrib 8.0.23, for Win64 (x86_64)
--
-- Host: localhost    Database: xpef
-- ------------------------------------------------------
-- Server version	8.0.22

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `user`
--

DROP TABLE IF EXISTS `user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `user` (
  `id` int NOT NULL AUTO_INCREMENT,
  `xp_no` varchar(16) NOT NULL,
  `name` varchar(16) NOT NULL,
  `id_card` varchar(32) NOT NULL,
  `password` varchar(256) NOT NULL,
  `sex` varchar(2) NOT NULL,
  `region` varchar(64) NOT NULL,
  `grade` varchar(16) NOT NULL,
  `stu_mentor_id` int DEFAULT NULL,
  `stu_mentor_name` varchar(16) DEFAULT NULL,
  `hk_mentor_id` int DEFAULT NULL,
  `hk_mentor_name` varchar(16) DEFAULT NULL,
  `high_school` varchar(32) NOT NULL,
  `university` varchar(32) NOT NULL,
  `school_year` int NOT NULL,
  `major` varchar(32) NOT NULL,
  `living` varchar(64) NOT NULL,
  `email` varchar(32) DEFAULT NULL,
  `weixin` varchar(32) DEFAULT NULL,
  `qq` varchar(32) DEFAULT NULL,
  `phone` varchar(16) NOT NULL,
  `high_sch_region` varchar(45) NOT NULL,
  `bank_card_no` varchar(32) NOT NULL,
  `bank_name` varchar(45) NOT NULL,
  `bank_address` varchar(64) NOT NULL,
  `is_system` int DEFAULT '0',
  `is_mentor` int DEFAULT '0',
  `is_funded` int DEFAULT '0',
  `is_qualified` int DEFAULT '1',
  `is_deleted` int DEFAULT '0',
  `gmt_created` datetime DEFAULT NULL,
  `gmt_modified` datetime DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `xp_no_UNIQUE` (`xp_no`),
  UNIQUE KEY `id_card_UNIQUE` (`id_card`),
  KEY `name_index` (`name`) /*!80000 INVISIBLE */,
  KEY `id_index` (`id`),
  KEY `idcard_index` (`id_card`) /*!80000 INVISIBLE */,
  KEY `highschool_index` (`high_school`) /*!80000 INVISIBLE */,
  KEY `grade_index` (`grade`) /*!80000 INVISIBLE */
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user`
--

LOCK TABLES `user` WRITE;
/*!40000 ALTER TABLE `user` DISABLE KEYS */;
INSERT INTO `user` VALUES (1,'GZ001','test','520123199806151216','123456','男','贵州省贵阳市修文县','2018',NULL,NULL,NULL,NULL,'修文中学','厦门大学',4,'软件工程','福建省厦门市','1725993571@qq.com',NULL,NULL,'18786044750','修文县','111111111','中国银行','厦门市厦大分行',0,0,0,1,0,NULL,'2021-09-23 00:00:00'),(2,'GZ002','test1','520123199806151217','123456','男','贵州省贵阳市修文县','2018',NULL,NULL,NULL,NULL,'修中学','厦大学',4,'软件工程','福建省厦门市','1725993571@qq.com',NULL,NULL,'18786044750','修文县','11112211','中国银行','厦门市厦大分行',0,0,0,1,0,NULL,'2021-09-23 00:00:00');
/*!40000 ALTER TABLE `user` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2021-09-23 16:12:03
