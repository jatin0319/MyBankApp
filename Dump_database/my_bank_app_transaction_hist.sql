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
-- Table structure for table `transaction_hist`
--

DROP TABLE IF EXISTS `transaction_hist`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `transaction_hist` (
  `trans_id` int NOT NULL AUTO_INCREMENT,
  `user_id` int NOT NULL,
  `trans_desc` varchar(10) NOT NULL,
  `date_time` datetime NOT NULL,
  `amount` varchar(45) NOT NULL,
  `trans_type` int NOT NULL,
  PRIMARY KEY (`trans_id`),
  KEY `trans_type` (`trans_type`),
  KEY `transaction_hist_ibfk_2_idx` (`user_id`),
  CONSTRAINT `transaction_hist_ibfk_1` FOREIGN KEY (`trans_type`) REFERENCES `transaction_type` (`trans_id`),
  CONSTRAINT `transaction_hist_ibfk_2` FOREIGN KEY (`user_id`) REFERENCES `user_details` (`user_id`)
) ENGINE=InnoDB AUTO_INCREMENT=16 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `transaction_hist`
--

LOCK TABLES `transaction_hist` WRITE;
/*!40000 ALTER TABLE `transaction_hist` DISABLE KEYS */;
INSERT INTO `transaction_hist` VALUES (1,100000000,'shivank','2021-10-01 01:00:00','1000',1),(2,100000001,'Jatin','2021-10-19 02:00:00','999',1),(3,100000001,'Jatin','2021-10-19 02:10:00','10',2),(4,100000000,'Arko','2021-09-30 18:03:49','200',2),(5,100000005,'Avi','2021-10-01 10:41:19','9000',2),(6,100000005,'Avi','2021-10-06 16:28:35','9000',2),(7,100000000,'Nishtha','2021-10-07 12:06:28','200',2),(8,100000006,'Arko','2021-10-07 22:11:59','55',2),(10,100000000,'Nishtha','2021-10-08 13:37:31','100',2),(12,100000000,'utkarsh','2021-10-08 16:38:19','111',2),(13,100000000,'Nishtha','2021-10-11 17:40:11','200',2),(14,100000006,'Jatin','2021-10-12 11:46:07','1',2),(15,100000006,'Avi','2021-10-12 11:48:55','2',2);
/*!40000 ALTER TABLE `transaction_hist` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2021-10-12 17:51:40
