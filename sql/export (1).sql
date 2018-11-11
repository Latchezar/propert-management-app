CREATE DATABASE  IF NOT EXISTS `propertymanagement` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci */;
USE `propertymanagement`;
-- MySQL dump 10.16  Distrib 10.3.9-MariaDB, for Win64 (AMD64)
--
-- Host: localhost    Database: propertymanagement
-- ------------------------------------------------------
-- Server version	10.3.9-MariaDB

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
-- Table structure for table `chat`
--

DROP TABLE IF EXISTS `chat`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `chat` (
  `MessageID` timestamp NOT NULL DEFAULT current_timestamp(),
  `MessageType` int(11) NOT NULL,
  `PropertyID` int(11) NOT NULL,
  `SenderID` int(11) NOT NULL,
  `MessageText` text COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  PRIMARY KEY (`MessageID`),
  KEY `MessageType` (`MessageType`),
  KEY `PropertyID` (`PropertyID`),
  KEY `SenderID` (`SenderID`),
  CONSTRAINT `chat_ibfk_1` FOREIGN KEY (`MessageType`) REFERENCES `messagetypes` (`MessageType`),
  CONSTRAINT `chat_ibfk_2` FOREIGN KEY (`PropertyID`) REFERENCES `properties` (`PropertyID`),
  CONSTRAINT `chat_ibfk_3` FOREIGN KEY (`SenderID`) REFERENCES `users` (`UserID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `chat`
--

LOCK TABLES `chat` WRITE;
/*!40000 ALTER TABLE `chat` DISABLE KEYS */;
INSERT INTO `chat` VALUES ('2018-11-07 14:19:37',1,2,1,'Hello, I am Latcho'),('2018-11-07 14:20:16',1,2,2,'Hello Latcho, I am Ivan! Nice to meet you!'),('2018-11-07 14:32:24',1,2,1,'When are you paying rent?!'),('2018-11-07 14:37:21',1,2,2,'I will pay tomorrow, I am sorry for the delay'),('2018-11-07 14:39:16',1,2,1,'Okay, I will wait until tomorrow, But NO MORE!'),('2018-11-07 14:45:18',1,2,2,'Test 2'),('2018-11-07 14:52:33',1,2,1,'Test 11'),('2018-11-09 07:20:26',1,2,1,'test message from postman'),('2018-11-09 07:46:48',1,2,1,'test 11092018'),('2018-11-09 07:48:42',1,2,1,'test 11092018'),('2018-11-09 07:49:22',1,2,1,'test 11092018'),('2018-11-09 07:49:31',1,2,1,'test 11092018'),('2018-11-09 07:52:24',1,2,1,'test 11092018'),('2018-11-09 07:53:25',1,2,1,'test 11092018'),('2018-11-09 07:53:56',1,2,1,'test 11092018'),('2018-11-09 09:08:50',1,2,1,'Testov 2233'),('2018-11-09 09:10:42',1,2,1,'Djdhdhdhddjdj'),('2018-11-09 09:14:08',1,2,1,'Lalalala'),('2018-11-09 09:15:43',1,2,1,'Joro test'),('2018-11-09 09:48:59',1,2,1,'Testtttt'),('2018-11-09 09:49:00',1,2,1,'Jorexa test'),('2018-11-09 09:49:31',1,2,1,'Lalalalaalal'),('2018-11-09 09:53:49',1,2,1,'Pak test'),('2018-11-09 10:00:10',1,2,1,'Everesr'),('2018-11-09 10:02:00',1,2,1,'Gogo'),('2018-11-09 10:02:32',1,2,1,'Uraaaa'),('2018-11-09 10:04:46',1,2,1,'Probaaaaa'),('2018-11-09 11:12:46',1,2,1,'Telerik'),('2018-11-09 11:13:58',1,2,1,'Ehooo 1234'),('2018-11-09 11:14:34',1,2,1,'Raboti chata'),('2018-11-09 11:15:14',1,2,1,'????? ?? ????????'),('2018-11-09 11:15:46',1,2,1,'Hop trop'),('2018-11-09 11:20:52',1,2,1,'Tuka Li si? '),('2018-11-09 11:25:22',1,2,1,'Visok mi e naema :-ddd'),('2018-11-09 11:27:48',1,2,1,'hi'),('2018-11-09 11:28:04',1,2,1,'Kak e? '),('2018-11-09 11:28:29',1,2,1,'Mai raboti'),('2018-11-09 11:28:44',1,2,1,'Sami trqbva day opravim interface-a\n'),('2018-11-09 11:29:16',1,2,1,'Da ima oshte rabota'),('2018-11-09 11:29:53',1,2,1,'she go nap[racquet ball vseki send Da Chisti edittext-a'),('2018-11-09 11:30:23',1,2,1,'she go napravq* :D\n'),('2018-11-09 11:30:27',1,2,1,'Ostavi go Sega taka'),('2018-11-09 11:30:46',1,2,1,'Malko da dovursha'),('2018-11-09 11:31:06',1,2,1,'da, zasega nqma da go pipam'),('2018-11-09 11:32:45',1,2,1,'Minavam v slack'),('2018-11-09 13:25:41',1,2,1,'Ff'),('2018-11-10 05:43:17',1,2,1,'Gogo'),('2018-11-10 06:14:50',1,2,1,'Ffffff'),('2018-11-10 06:26:26',1,2,1,'Sjdjdfjfjfjfjjfjfjdjddj'),('2018-11-10 06:32:40',1,2,1,'Dada'),('2018-11-10 06:36:28',1,2,1,'Ghjjj'),('2018-11-10 06:36:48',1,2,1,'Subota'),('2018-11-10 18:10:36',1,2,1,'Teeeeee'),('2018-11-10 18:15:09',1,6,1,'Fffffff'),('2018-11-10 18:16:01',1,11,1,'Proba'),('2018-11-10 18:16:23',1,2,1,'Ihuuu'),('2018-11-10 18:16:40',1,9,1,'Hristo, lala'),('2018-11-10 18:48:26',1,2,1,'Test 123'),('2018-11-10 18:48:40',1,2,1,'Lala'),('2018-11-10 19:08:44',1,2,1,'Ffff*ff'),('2018-11-10 19:11:33',1,2,1,'Twgsgd'),('2018-11-10 19:11:51',1,2,1,'Twgsgdggggh'),('2018-11-10 19:22:26',1,2,1,'Web'),('2018-11-10 19:23:41',1,7,22,'Az sym ivan'),('2018-11-10 19:24:54',1,7,23,'Az sym mitko'),('2018-11-10 19:25:25',1,7,23,'Az sym mitko 22'),('2018-11-10 19:25:45',1,7,23,'Az sym mitko 22 33'),('2018-11-10 19:26:09',1,7,23,'Hi'),('2018-11-10 19:26:32',1,7,23,'Kak e? '),('2018-11-10 19:37:32',1,2,1,'Proba '),('2018-11-10 19:38:32',1,9,1,'Tyrsq Hristo'),('2018-11-10 19:39:13',1,9,1,'Tyrsq Hristo 222'),('2018-11-10 19:39:32',1,9,1,'Tyrsq Hristo 222 666'),('2018-11-10 19:42:27',1,9,1,'Tyrsq Hristo'),('2018-11-10 19:43:31',1,9,25,'Tuk sym'),('2018-11-10 19:48:40',1,2,1,'zdr'),('2018-11-10 19:48:54',1,2,1,'zdr:D'),('2018-11-10 19:52:01',1,9,25,'Testttt'),('2018-11-10 19:52:41',1,9,25,'Gdgdgd'),('2018-11-10 20:00:39',1,9,1,'Sega bi trqbvalo'),('2018-11-10 20:01:01',1,9,1,'da sum on'),('2018-11-10 20:02:01',1,9,25,'Da'),('2018-11-10 20:02:12',1,9,1,'super'),('2018-11-10 20:02:19',1,9,25,'Mai raboti'),('2018-11-10 20:02:37',1,9,1,'da Sega raboti'),('2018-11-10 20:03:02',1,9,25,'Uraaa'),('2018-11-10 20:03:30',1,9,1,'super'),('2018-11-11 05:31:37',1,2,1,'Testt'),('2018-11-11 05:37:23',1,2,1,'Fofo'),('2018-11-11 05:37:32',1,2,1,'250'),('2018-11-11 05:37:51',1,12,1,'150?'),('2018-11-11 06:01:22',1,2,1,'240'),('2018-11-11 06:11:13',1,2,1,'567'),('2018-11-11 06:19:40',1,2,1,'789123'),('2018-11-11 06:19:50',1,2,1,'Tyuio'),('2018-11-11 06:23:01',1,9,25,'250?'),('2018-11-11 06:23:16',1,9,25,'500?'),('2018-11-11 06:28:55',1,9,1,'Zas'),('2018-11-11 09:29:06',1,2,1,'Hello'),('2018-11-11 09:41:22',1,2,2,'hi'),('2018-11-11 09:41:30',1,2,1,'How you doin'),('2018-11-11 09:41:40',1,2,2,'I\'m good ;)'),('2018-11-11 09:41:58',1,2,2,'How are you?'),('2018-11-11 09:42:45',1,2,1,'I\'m good too, thank you :)'),('2018-11-11 09:42:54',1,2,2,'You are quite welcome'),('2018-11-11 12:30:58',1,6,1,'Fafffffffffghhh'),('2018-11-11 12:31:10',1,6,1,'Hdjfjdhdhdhdeg'),('2018-11-11 12:31:21',1,6,1,'Rqqqqqq');
/*!40000 ALTER TABLE `chat` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `messagetypes`
--

DROP TABLE IF EXISTS `messagetypes`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `messagetypes` (
  `MessageType` int(11) NOT NULL AUTO_INCREMENT,
  `TypeName` varchar(45) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  PRIMARY KEY (`MessageType`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `messagetypes`
--

LOCK TABLES `messagetypes` WRITE;
/*!40000 ALTER TABLE `messagetypes` DISABLE KEYS */;
INSERT INTO `messagetypes` VALUES (1,'text'),(2,'image');
/*!40000 ALTER TABLE `messagetypes` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `properties`
--

DROP TABLE IF EXISTS `properties`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `properties` (
  `PropertyID` int(11) NOT NULL AUTO_INCREMENT,
  `PropertyName` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `Address` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `PropertyPrice` int(11) DEFAULT NULL,
  `LandlordID` int(11) DEFAULT NULL,
  `TenantID` int(11) DEFAULT NULL,
  PRIMARY KEY (`PropertyID`),
  UNIQUE KEY `PropertyID` (`PropertyID`),
  KEY `LandlordID` (`LandlordID`),
  KEY `TenantID` (`TenantID`),
  CONSTRAINT `properties_ibfk_1` FOREIGN KEY (`LandlordID`) REFERENCES `users` (`UserID`),
  CONSTRAINT `properties_ibfk_2` FOREIGN KEY (`TenantID`) REFERENCES `users` (`UserID`)
) ENGINE=InnoDB AUTO_INCREMENT=18 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `properties`
--

LOCK TABLES `properties` WRITE;
/*!40000 ALTER TABLE `properties` DISABLE KEYS */;
INSERT INTO `properties` VALUES (2,'Mladost 1 apartment','mladost 1, bl. 50, ap 3',400,1,2),(6,'Centre Apartment','Sofia, ul. Rakovska 13 apartment.1',850,1,21),(7,'Apartment Centre','Sofia, ul. Rakovska 5, apartment.3',850,22,23),(8,'Bojurishte House','Bojurishte, ul. Stefanov 3',1500,22,24),(9,'drujba apartment','Sofia drujba 2 bl.120 apartment.3',300,1,25),(10,'Apartment mladost 3','Sofia mladost 3 bl.325 apartment. 6',400,22,26),(11,'Apartment maxi','Sofia Maxi Complex, bl.25, apartment.4',1900,1,27),(12,'new property','address test',150,1,1),(13,'new test new','address',123,1,1),(14,'property 1','address',1000,1,1),(16,'property 6','address',100,1,1),(17,'Stug grad','Sofia, stud. Grad bl. 12 ',1200,1,1);
/*!40000 ALTER TABLE `properties` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `requests`
--

DROP TABLE IF EXISTS `requests`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `requests` (
  `RequestTime` timestamp NOT NULL DEFAULT current_timestamp(),
  `PropertID` int(11) DEFAULT NULL,
  `fromUser` int(11) DEFAULT NULL,
  `toUser` int(11) DEFAULT NULL,
  `RequestType` int(11) DEFAULT NULL,
  `Message` text COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `Amount` int(11) DEFAULT NULL,
  PRIMARY KEY (`RequestTime`),
  KEY `PropertID` (`PropertID`),
  KEY `fromUser` (`fromUser`),
  KEY `toUser` (`toUser`),
  KEY `RequestType` (`RequestType`),
  CONSTRAINT `requests_ibfk_1` FOREIGN KEY (`PropertID`) REFERENCES `properties` (`PropertyID`),
  CONSTRAINT `requests_ibfk_2` FOREIGN KEY (`fromUser`) REFERENCES `users` (`UserID`),
  CONSTRAINT `requests_ibfk_3` FOREIGN KEY (`toUser`) REFERENCES `users` (`UserID`),
  CONSTRAINT `requests_ibfk_4` FOREIGN KEY (`RequestType`) REFERENCES `requesttype` (`RequestType`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `requests`
--

LOCK TABLES `requests` WRITE;
/*!40000 ALTER TABLE `requests` DISABLE KEYS */;
/*!40000 ALTER TABLE `requests` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `requesttype`
--

DROP TABLE IF EXISTS `requesttype`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `requesttype` (
  `RequestType` int(11) NOT NULL AUTO_INCREMENT,
  `ReqeustName` varchar(45) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  PRIMARY KEY (`RequestType`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `requesttype`
--

LOCK TABLES `requesttype` WRITE;
/*!40000 ALTER TABLE `requesttype` DISABLE KEYS */;
INSERT INTO `requesttype` VALUES (1,'lowerRent'),(2,'higherRent'),(3,'maintenance'),(4,'other');
/*!40000 ALTER TABLE `requesttype` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `users`
--

DROP TABLE IF EXISTS `users`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `users` (
  `UserID` int(11) NOT NULL AUTO_INCREMENT,
  `FirstName` varchar(65) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `LastName` varchar(65) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `Password` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `UserType` int(11) DEFAULT NULL,
  `Email` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  PRIMARY KEY (`UserID`),
  UNIQUE KEY `Email` (`Email`),
  KEY `UserType` (`UserType`),
  CONSTRAINT `users_ibfk_1` FOREIGN KEY (`UserType`) REFERENCES `usertypes` (`UserType`)
) ENGINE=InnoDB AUTO_INCREMENT=29 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `users`
--

LOCK TABLES `users` WRITE;
/*!40000 ALTER TABLE `users` DISABLE KEYS */;
INSERT INTO `users` VALUES (1,'Latchezar','Nikolov','17a3e48bce37be5226490e750202ad3a9a1a3fe9',1,'latcho.nikolov@gmail.com'),(2,'Ivan','Ivanov','17a3e48bce37be5226490e750202ad3a9a1a3fe9',2,'ivan.ivanov@gmail.com'),(21,'Ivailo','Petrov','06caf82127274b18c89824d761c300de2ac9c5f8',2,'ivailo@gmail.com'),(22,'Ivan','Ivanov','09531e9b778e3f9dc87a04cf231b61953101a967',1,'ivan@gmail.com'),(23,'Dimitar','Dimitrov','a1def14491363f9d8437db586278771d0eaa304c',2,'dimitar@gmail.com'),(24,'Petar','Petkov','b172e302657277d4837e2e38625eacb890961279',2,'petar@gmail.com'),(25,'Hristo','Hristov','72bf11c75470c271af9cf9089333dc09ef5cfd33',2,'hristo@gmail.com'),(26,'Ivanka','Petkova','2753d176092296ad21b7fc78590b615217118a42',2,'ivanka@gmail.com'),(27,'Puff','Daddy','640dac60e9d2a0e9eaf836106c62a1d4a13b8bd3',2,'puff@gmail.com'),(28,'Milena','Ivanova','47cea8db095a396756ed667d70c24b61d81d99d3',1,'milena@gmail.com');
/*!40000 ALTER TABLE `users` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `usertypes`
--

DROP TABLE IF EXISTS `usertypes`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `usertypes` (
  `UserType` int(11) NOT NULL AUTO_INCREMENT,
  `TypeName` varchar(45) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  PRIMARY KEY (`UserType`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `usertypes`
--

LOCK TABLES `usertypes` WRITE;
/*!40000 ALTER TABLE `usertypes` DISABLE KEYS */;
INSERT INTO `usertypes` VALUES (1,'landlord'),(2,'tenant');
/*!40000 ALTER TABLE `usertypes` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2018-11-11 15:14:49
