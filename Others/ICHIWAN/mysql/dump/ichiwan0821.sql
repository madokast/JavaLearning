-- MySQL dump 10.13  Distrib 5.5.62, for Win64 (AMD64)
--
-- Host: localhost    Database: ichiwan
-- ------------------------------------------------------
-- Server version	5.5.62

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `entries`
--

DROP TABLE IF EXISTS `entries`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `entries` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `dateDone` date NOT NULL,
  `name` varchar(20) NOT NULL,
  `lengthMinute` int(11) DEFAULT NULL,
  `describing` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=129 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `entries`
--

LOCK TABLES `entries` WRITE;
/*!40000 ALTER TABLE `entries` DISABLE KEYS */;
INSERT INTO `entries` VALUES (1,'2019-06-10','basic',63,NULL),(2,'2019-06-10','Internet',18,NULL),(3,'2019-06-10','java',68,NULL),(4,'2019-06-11','web',42,NULL),(5,'2019-06-11','basic',51,NULL),(6,'2019-06-11','java',20,NULL),(7,'2019-06-11','basic',42,NULL),(8,'2019-06-11','java',20,NULL),(9,'2019-06-12','java',57,NULL),(10,'2019-06-12','basic',59,NULL),(11,'2019-06-14','java',85,NULL),(12,'2019-06-15','dataStruct',70,NULL),(13,'2019-06-17','dataStruct',110,NULL),(14,'2019-06-18','basic',66,NULL),(15,'2019-06-18','basic',51,NULL),(16,'2019-06-18','basic',73,NULL),(17,'2019-06-18','basic',47,NULL),(18,'2019-06-18','dataStruct',140,NULL),(19,'2019-06-19','basic',60,NULL),(20,'2019-06-25','algorithm',60,NULL),(21,'2019-06-27','web',30,NULL),(22,'2019-06-27','basic',30,NULL),(23,'2019-06-28','java',62,NULL),(24,'2019-06-28','algorithm',119,NULL),(25,'2019-06-28','basic',11,NULL),(26,'2019-06-28','web',50,NULL),(27,'2019-06-28','java',60,NULL),(28,'2019-06-28','algorithm',62,NULL),(29,'2019-06-29','java',100,NULL),(30,'2019-06-29','algorithm',22,NULL),(31,'2019-06-29','algorithm',54,NULL),(32,'2019-06-29','web',36,NULL),(33,'2019-06-30','basic',71,NULL),(34,'2019-06-30','web',38,NULL),(35,'2019-06-30','algorithm',57,NULL),(36,'2019-07-01','java',105,NULL),(37,'2019-07-01','java',30,NULL),(38,'2019-07-01','basic',33,NULL),(39,'2019-07-02','web',25,NULL),(40,'2019-07-02','java',101,NULL),(41,'2019-07-02','web',76,NULL),(42,'2019-07-02','Internet',62,NULL),(43,'2019-07-02','machineLearn',15,NULL),(44,'2019-07-04','Internet',38,NULL),(45,'2019-07-04','Internet',45,NULL),(46,'2019-07-04','basic',53,NULL),(47,'2019-07-04','algorithm',60,NULL),(48,'2019-07-04','java',60,NULL),(49,'2019-07-04','web',51,NULL),(50,'2019-07-04','dataStruct',83,NULL),(51,'2019-07-05','basic',71,NULL),(52,'2019-07-06','Internet',68,NULL),(53,'2019-07-06','Internet',40,NULL),(54,'2019-07-07','Internet',20,NULL),(55,'2019-07-09','Internet',64,NULL),(56,'2019-07-10','Internet',64,NULL),(57,'2019-07-10','basic',60,NULL),(58,'2019-07-11','dataStruct',129,NULL),(59,'2019-07-11','dataStruct',28,NULL),(60,'2019-07-11','java',64,NULL),(61,'2019-07-11','Internet',86,NULL),(62,'2019-07-12','java',55,NULL),(63,'2019-07-12','dataStruct',45,NULL),(64,'2019-07-12','dataStruct',69,NULL),(65,'2019-07-13','web',61,NULL),(66,'2019-07-13','java',55,NULL),(67,'2019-07-13','java',59,NULL),(68,'2019-07-14','basic',92,NULL),(69,'2019-07-14','Internet',70,NULL),(70,'2019-07-15','dataStruct',85,NULL),(71,'2019-07-15','Internet',64,NULL),(72,'2019-07-19','Internet',34,NULL),(73,'2019-07-20','java',48,NULL),(74,'2019-07-20','basic',67,NULL),(75,'2019-07-20','java',73,NULL),(76,'2019-07-20','java',93,NULL),(77,'2019-07-21','java',71,NULL),(78,'2019-07-22','java',79,NULL),(79,'2019-07-26','java',92,NULL),(80,'2019-07-26','Internet',40,NULL),(81,'2019-07-26','basic',50,NULL),(82,'2019-07-26','java',71,NULL),(83,'2019-07-26','java',23,NULL),(84,'2019-07-27','java',98,NULL),(85,'2019-07-27','Internet',20,NULL),(86,'2019-07-27','java',100,NULL),(87,'2019-07-27','java',15,NULL),(88,'2019-07-28','java',55,NULL),(89,'2019-07-28','Internet',42,NULL),(90,'2019-07-29','java',60,NULL),(91,'2019-07-29','java',65,NULL),(92,'2019-07-29','java',60,NULL),(93,'2019-07-29','java',75,NULL),(94,'2019-07-30','java',60,NULL),(95,'2019-07-30','java',40,NULL),(96,'2019-07-30','java',60,NULL),(97,'2019-07-30','java',60,NULL),(98,'2019-07-30','java',105,NULL),(99,'2019-07-31','java',90,NULL),(100,'2019-07-31','java',60,NULL),(101,'2019-07-31','java',65,NULL),(102,'2019-07-31','java',60,NULL),(103,'2019-07-31','java',60,NULL),(104,'2019-07-31','java',55,NULL),(105,'2019-08-01','java',30,NULL),(106,'2019-08-01','java',61,NULL),(107,'2019-08-01','java',36,NULL),(108,'2019-08-02','java',74,NULL),(109,'2019-08-03','java',105,NULL),(110,'2019-08-03','java',20,NULL),(111,'2019-08-03','java',20,NULL),(112,'2019-08-04','java',105,NULL),(113,'2019-08-04','java',35,NULL),(114,'2019-08-04','java',45,NULL),(115,'2019-08-05','java',65,NULL),(116,'2019-08-05','java',65,NULL),(117,'2019-08-05','java',65,NULL),(118,'2019-08-05','java',85,NULL),(119,'2019-08-05','java',60,NULL),(120,'2019-08-06','java',57,NULL),(121,'2019-08-06','java',50,NULL),(122,'2019-08-06','java',109,NULL),(123,'2019-08-07','java',107,NULL),(124,'2019-08-07','java',130,NULL),(125,'2019-08-15','java',5,NULL),(126,'2019-08-16','java',25,NULL),(127,'2019-08-18','java',75,NULL),(128,'2019-08-21','java',92,NULL);
/*!40000 ALTER TABLE `entries` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2019-08-21 22:37:03
