-- MySQL dump 10.13  Distrib 8.0.26, for Win64 (x86_64)
--
-- Host: localhost    Database: my_bank_app
-- ------------------------------------------------------
-- Server version	8.0.26

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
-- Table structure for table `user_details`
--

DROP TABLE IF EXISTS `user_details`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `user_details` (
  `user_id` int NOT NULL AUTO_INCREMENT,
  `fname` varchar(255) NOT NULL,
  `lname` varchar(255) NOT NULL,
  `mobile_no` varchar(10) DEFAULT NULL,
  `dob` date DEFAULT NULL,
  `email` varchar(30) DEFAULT NULL,
  `address` varchar(255) DEFAULT NULL,
  `adhaar_no` varchar(12) DEFAULT NULL,
  `pan_no` varchar(10) DEFAULT NULL,
  `role_id` int NOT NULL,
  `status_id` int NOT NULL,
  `Balance` varchar(12) DEFAULT NULL,
  PRIMARY KEY (`user_id`),
  UNIQUE KEY `adhaar_no_UNIQUE` (`adhaar_no`),
  UNIQUE KEY `pan_no_UNIQUE` (`pan_no`),
  KEY `role_id` (`role_id`),
  KEY `status_id` (`status_id`),
  CONSTRAINT `user_details_ibfk_1` FOREIGN KEY (`role_id`) REFERENCES `user_role` (`role_id`),
  CONSTRAINT `user_details_ibfk_2` FOREIGN KEY (`status_id`) REFERENCES `acc_status` (`status_id`)
) ENGINE=InnoDB AUTO_INCREMENT=100000027 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user_details`
--

LOCK TABLES `user_details` WRITE;
/*!40000 ALTER TABLE `user_details` DISABLE KEYS */;
INSERT INTO `user_details` VALUES (100000000,'Jatin','Rawat','2837426347','1999-10-19','jatin@gmail.com','Dwarka','128192837482','ASDFS2387R',2,1,'1000000'),(100000001,'Arko','Biswas','6473883726','1997-01-09','arko@gmail.com','Noida','227692837582','GFDFS2787Q',2,2,'2000'),(100000002,'Utkarsh','Srivastva',NULL,NULL,NULL,NULL,NULL,NULL,1,1,NULL),(100000003,'Nareen','kannan',NULL,NULL,NULL,NULL,NULL,NULL,1,2,NULL),(100000004,'Urvashi','Tyagi',NULL,NULL,NULL,NULL,NULL,NULL,1,2,NULL),(100000005,'Yasir','Ali',NULL,NULL,NULL,NULL,NULL,NULL,1,1,NULL),(100000006,'Shivank','Sharma','2637485995','1999-11-11','shivank@gmail.com','Burari','374463526374','JRCFG7657E',2,1,'97'),(100000008,'Mohit','Rathi','3244329876','2000-01-21','Mohit@gmail.com','Dashrathpuri','374463512374','TYCFG7457V',2,2,'500000'),(100000009,'Avi','Singh','9811232543','2021-09-29','Avi@gmail.com','Greater Noida','123999384755','ABVER2345G',2,1,'9999'),(100000010,'Sid','Chauhan','2817227362','2017-02-28','sid@gmail.com','Nirman Vihar','382771625345','YUVER2345G',2,1,'555'),(100000011,'Abhishek','Rawat','9844322876','2003-07-22','Abhishek@gmail.com','Dashrathpuri','564463512378','YUCFG5453W',2,1,'0'),(100000012,'Rajat','Rathuri','8374663829','2010-01-05','rajat@gmail.com','Bijwasan','002938271662','SSDFS9887K',2,2,'30000'),(100000013,'Sachin','Verma','2293884726','2010-01-07','sachin@yahoo.com','Trilokpuri','892983271699','OODFS9867T',2,1,'83459'),(100000019,'vivek','singh','8837495930','2008-02-08','vivek@yahoo.com','Ashok nagar','845983271688','RSDFS9887A',2,2,'733'),(100000021,'Anu','Sharma','2773644875','1990-07-12','anu@nexxo.com','Mayur Vihar','883999384799','CJVER8945T',2,1,'4999');
/*!40000 ALTER TABLE `user_details` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2021-10-12 17:51:37
