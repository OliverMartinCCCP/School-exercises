CREATE DATABASE  IF NOT EXISTS `howest` /*!40100 DEFAULT CHARACTER SET latin1 */;
USE `howest`;
-- MySQL dump 10.13  Distrib 5.6.13, for osx10.6 (i386)
--
-- Host: 127.0.0.1    Database: howest
-- ------------------------------------------------------
-- Server version	5.7.15

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
-- Table structure for table `partim`
--

DROP TABLE IF EXISTS `partim`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `partim` (
  `idpartim` varchar(5) NOT NULL,
  `name` varchar(45) NOT NULL,
  `sp` int(11) DEFAULT NULL,
  PRIMARY KEY (`idpartim`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `partim`
--

LOCK TABLES `partim` WRITE;
/*!40000 ALTER TABLE `partim` DISABLE KEYS */;
INSERT INTO `partim` VALUES ('C01','Java Web Technology',3),('C02','Advanced JavaScript',2),('C03','Business Solutions and Digital Marketing',2),('C04','User Experience Design',2),('C10','Information Modeling',2),('C11','Advanced SQL',2),('C12','Webservices and Information Exchange',2),('C20','Server Operating Systems Concepts',3),('C21','Windows Server Lab',3),('C22','Linux Server Lab',3),('C30','Advanced Server Web',2),('C31','Mobile Web Apps',3),('C32','Native Mobile Apps',2),('C33','Smart Devices',2);
/*!40000 ALTER TABLE `partim` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `student`
--

DROP TABLE IF EXISTS `student`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `student` (
  `idstudent` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(25) NOT NULL,
  `password` varchar(25) NOT NULL,
  PRIMARY KEY (`idstudent`),
  UNIQUE KEY `name_UNIQUE` (`name`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `student`
--

LOCK TABLES `student` WRITE;
/*!40000 ALTER TABLE `student` DISABLE KEYS */;
INSERT INTO `student` VALUES (1,'jan','jan123');
/*!40000 ALTER TABLE `student` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `student_partims`
--

DROP TABLE IF EXISTS `student_partims`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `student_partims` (
  `student` int(11) NOT NULL,
  `partim` varchar(5) NOT NULL,
  UNIQUE KEY `student` (`student`,`partim`),
  KEY `fkStudent_idx` (`student`),
  KEY `fkPartim_idx` (`partim`),
  CONSTRAINT `fkPartim` FOREIGN KEY (`partim`) REFERENCES `partim` (`idpartim`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fkStudent` FOREIGN KEY (`student`) REFERENCES `student` (`idstudent`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `student_partims`
--

LOCK TABLES `student_partims` WRITE;
/*!40000 ALTER TABLE `student_partims` DISABLE KEYS */;
INSERT INTO `student_partims` VALUES (1,'C01'),(1,'C02'),(1,'C03'),(1,'C10');
/*!40000 ALTER TABLE `student_partims` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2016-10-14  7:51:39
