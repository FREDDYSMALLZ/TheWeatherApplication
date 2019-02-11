CREATE DATABASE  IF NOT EXISTS `WeatherDb` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci */;
USE `WeatherDb`;
-- MySQL dump 10.13  Distrib 8.0.13, for macos10.14 (x86_64)
--
-- Host: localhost    Database: WeatherDb
-- ------------------------------------------------------
-- Server version	8.0.13

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
 SET NAMES utf8 ;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `userTbl`
--

DROP TABLE IF EXISTS `userTbl`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `userTbl` (
  `userTbl_id` int(11) NOT NULL,
  `username` varchar(255) NOT NULL,
  `email` varchar(255) NOT NULL,
  `location` varchar(255) NOT NULL,
  `password` varchar(255) NOT NULL,
  PRIMARY KEY (`userTbl_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `userTbl`
--

LOCK TABLES `userTbl` WRITE;
/*!40000 ALTER TABLE `userTbl` DISABLE KEYS */;
INSERT INTO `userTbl` VALUES (1,'fredrick','fredieondieki@yahoo.com','Arlington','Welcome123'),(2,'judy','judymaranga16@gmail.com','GrandPrairie','Admin123'),(3,'Jack123','jakstallone@gmail.com','Phoenix','Jack247'),(4,'mango234','mangookengo@gmail.com','Manila','Manila876'),(5,'maurice789','mauricekenyamo6@gmail.com','washington','washington234');
/*!40000 ALTER TABLE `userTbl` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `weatherTbl`
--

DROP TABLE IF EXISTS `weatherTbl`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `weatherTbl` (
  `weatherTbl_id` int(11) NOT NULL,
  `day` varchar(255) NOT NULL,
  `high` varchar(255) NOT NULL,
  `low` varchar(255) NOT NULL,
  `forecast` varchar(255) NOT NULL,
  PRIMARY KEY (`weatherTbl_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `weatherTbl`
--

LOCK TABLES `weatherTbl` WRITE;
/*!40000 ALTER TABLE `weatherTbl` DISABLE KEYS */;
INSERT INTO `weatherTbl` VALUES (1,'Sunday','89','58','Precipitation'),(2,'Monday','91','70','Summer'),(3,'Tuesday','67','23','Hot and Windy'),(4,'Wednesday','78','56','Windy'),(5,'Thurday','84','76','Rainny'),(6,'Friday','90','45','Hot and Dry'),(7,'Saturday','102','65','Cold and Windy');
/*!40000 ALTER TABLE `weatherTbl` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping events for database 'WeatherDb'
--

--
-- Dumping routines for database 'WeatherDb'
--
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2019-02-11  8:15:38
