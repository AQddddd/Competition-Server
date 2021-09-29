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
  `xp_no` varchar(16) DEFAULT NULL,
  `name` varchar(16) NOT NULL,
  `id_card` varchar(32) DEFAULT NULL,
  `password` varchar(256) NOT NULL,
  `sex` varchar(2) DEFAULT NULL,
  `region` varchar(64) DEFAULT NULL,
  `grade` varchar(16) DEFAULT NULL,
  `stu_mentor_id` int DEFAULT NULL,
  `stu_mentor_name` varchar(16) DEFAULT NULL,
  `hk_mentor_id` int DEFAULT NULL,
  `hk_mentor_name` varchar(16) DEFAULT NULL,
  `high_school` varchar(32) DEFAULT NULL,
  `university` varchar(32) DEFAULT NULL,
  `school_year` int DEFAULT NULL,
  `major` varchar(32) DEFAULT NULL,
  `living` varchar(64) DEFAULT NULL,
  `email` varchar(32) NOT NULL,
  `weixin` varchar(32) DEFAULT NULL,
  `qq` varchar(32) DEFAULT NULL,
  `phone` varchar(16) DEFAULT NULL,
  `high_sch_region` varchar(45) DEFAULT NULL,
  `bank_card_no` varchar(32) DEFAULT NULL,
  `bank_name` varchar(45) DEFAULT NULL,
  `bank_address` varchar(64) DEFAULT NULL,
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
  KEY `id_index` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2021-09-29 14:38:46
