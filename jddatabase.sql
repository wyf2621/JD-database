-- MySQL dump 10.13  Distrib 5.6.42, for Win64 (x86_64)
--
-- Host: localhost    Database: jddatabase
-- ------------------------------------------------------
-- Server version	5.6.42

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
-- Table structure for table `addr`
--

DROP TABLE IF EXISTS `addr`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `addr` (
  `addr_id` int(11) NOT NULL AUTO_INCREMENT,
  `addr_country` varchar(20) NOT NULL,
  `addr_province` varchar(20) NOT NULL,
  `addr_city` varchar(20) NOT NULL,
  `addr_area` varchar(20) NOT NULL,
  `addr_detail` varchar(50) NOT NULL,
  `addr_is_default` tinyint(1) NOT NULL DEFAULT '0',
  `addr_name` varchar(20) NOT NULL,
  `addr_tel` varchar(20) NOT NULL,
  `user_user_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`addr_id`),
  KEY `fk_addr_user1_idx` (`user_user_id`),
  CONSTRAINT `fk_addr_user1` FOREIGN KEY (`user_user_id`) REFERENCES `user` (`user_id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=20 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `addr`
--

LOCK TABLES `addr` WRITE;
/*!40000 ALTER TABLE `addr` DISABLE KEYS */;
INSERT INTO `addr` VALUES (1,'China','Beijing','Beijing','Haidian','Xueyuanlu Street BJFU',1,'duanqiulin','6324',1),(2,'China','Beijing','Beijing','Haidian','Xueyuanlu Street BJFU',1,'heqinzi','5432',3),(3,'China','Beijing','Beijing','Haidian','Xueyuanlu Street BJFU',1,'swin','7564321',2),(4,'China','Shanxi','Yuncheng','Yanhuqu','7654',0,'duanqiulin','7654',1),(13,'abc','abc','change','abc','abc',1,'abc','123',1);
/*!40000 ALTER TABLE `addr` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `advertise`
--

DROP TABLE IF EXISTS `advertise`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `advertise` (
  `ad_id` int(11) NOT NULL AUTO_INCREMENT,
  `ad_location` varchar(50) NOT NULL,
  `ad_channel` varchar(50) NOT NULL,
  `ad_name` varchar(50) NOT NULL,
  `ad_detail` varchar(50) NOT NULL,
  `ad_type` varchar(50) NOT NULL,
  `ad_media_width` float NOT NULL,
  `ad_media_height` float NOT NULL,
  `ad_media_type` varchar(20) NOT NULL,
  `ad_media_size` float NOT NULL,
  `ad_create_time` datetime NOT NULL,
  `ad_update_time` datetime NOT NULL,
  PRIMARY KEY (`ad_id`)
) ENGINE=InnoDB AUTO_INCREMENT=20 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `advertise`
--

LOCK TABLES `advertise` WRITE;
/*!40000 ALTER TABLE `advertise` DISABLE KEYS */;
INSERT INTO `advertise` VALUES (1,'a','a','a','a','a',0,0,'4',20,'2018-01-01 00:00:00','2018-01-02 00:00:00'),(2,'a','a','a','a','a',0,0,'4',20,'2018-01-01 00:00:00','2018-01-02 00:00:00'),(3,'a','a','a','a','a',0,0,'4',20,'2018-01-01 00:00:00','2018-01-02 00:00:00'),(4,'a','a','a','a','a',0,0,'4',20,'2018-01-01 00:00:00','2018-01-02 00:00:00'),(18,'abc','abc','abc','change','abc',1,1,'abc',2,'2008-08-08 00:00:00','2008-08-08 00:00:00');
/*!40000 ALTER TABLE `advertise` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `advertise_info`
--

DROP TABLE IF EXISTS `advertise_info`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `advertise_info` (
  `ad_info_id` int(11) NOT NULL AUTO_INCREMENT,
  `ad_info_title` varchar(20) NOT NULL,
  `ad_file_path` varchar(50) NOT NULL,
  `ad_file_type` varchar(20) NOT NULL,
  `ad_file_size` float NOT NULL,
  `ad_link_url` varchar(50) NOT NULL,
  `ad_scan_time` int(11) NOT NULL DEFAULT '0',
  `ad_click_time` int(11) NOT NULL DEFAULT '0',
  `ad_is_period` tinyint(1) NOT NULL DEFAULT '1',
  `ad_create_time` datetime NOT NULL,
  `ad_during_time` datetime NOT NULL,
  `ad_begin_time` datetime NOT NULL,
  `ad_end_time` datetime NOT NULL,
  `ad_info_status` int(11) NOT NULL DEFAULT '1',
  `ad_note` varchar(50) DEFAULT NULL,
  `store_store_id` int(11) NOT NULL,
  `advertise_ad_id` int(11) NOT NULL,
  PRIMARY KEY (`ad_info_id`),
  KEY `fk_advertise_info_store1_idx` (`store_store_id`),
  KEY `fk_advertise_info_advertise1_idx` (`advertise_ad_id`),
  CONSTRAINT `fk_advertise_info_advertise1` FOREIGN KEY (`advertise_ad_id`) REFERENCES `advertise` (`ad_id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_advertise_info_store1` FOREIGN KEY (`store_store_id`) REFERENCES `store` (`store_id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=20 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `advertise_info`
--

LOCK TABLES `advertise_info` WRITE;
/*!40000 ALTER TABLE `advertise_info` DISABLE KEYS */;
INSERT INTO `advertise_info` VALUES (1,'adfddf','dgdg','hdg',30,'https',2018,2018,1,'2018-02-02 00:00:00','2018-02-02 00:00:00','2018-02-02 00:00:00','2018-02-02 00:00:00',1,'dfdff',1,1),(2,'adfddf','dgdg','hdg',30,'https',2018,2018,1,'2018-02-02 00:00:00','2018-02-02 00:00:00','2018-02-02 00:00:00','2018-02-02 00:00:00',1,'dfdff',2,2),(18,'change','abc','abc',1,'abc',1,1,1,'2008-08-08 00:00:00','2008-08-08 00:00:00','2008-08-08 00:00:00','2008-08-08 00:00:00',1,'abc',1,1);
/*!40000 ALTER TABLE `advertise_info` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `attr`
--

DROP TABLE IF EXISTS `attr`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `attr` (
  `attr_id` int(11) NOT NULL AUTO_INCREMENT,
  `attr_name` varchar(50) NOT NULL,
  PRIMARY KEY (`attr_id`)
) ENGINE=InnoDB AUTO_INCREMENT=20 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `attr`
--

LOCK TABLES `attr` WRITE;
/*!40000 ALTER TABLE `attr` DISABLE KEYS */;
INSERT INTO `attr` VALUES (1,'color'),(2,'size'),(3,'capacity'),(4,'memory'),(5,'waistline'),(18,'change');
/*!40000 ALTER TABLE `attr` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `attr_value`
--

DROP TABLE IF EXISTS `attr_value`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `attr_value` (
  `attr_value_id` int(11) NOT NULL AUTO_INCREMENT,
  `attr_value_name` varchar(50) NOT NULL,
  `attr_attr_id` int(11) NOT NULL,
  PRIMARY KEY (`attr_value_id`),
  KEY `fk_attr_value_attr1_idx` (`attr_attr_id`),
  CONSTRAINT `fk_attr_value_attr1` FOREIGN KEY (`attr_attr_id`) REFERENCES `attr` (`attr_id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=20 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `attr_value`
--

LOCK TABLES `attr_value` WRITE;
/*!40000 ALTER TABLE `attr_value` DISABLE KEYS */;
INSERT INTO `attr_value` VALUES (1,'CHANGE',1),(2,'black',1),(3,'gold',1),(4,'silver',1),(5,'32G',4),(6,'64G',4),(7,'128G',4),(19,'abc',1);
/*!40000 ALTER TABLE `attr_value` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `attr_value_has_sku`
--

DROP TABLE IF EXISTS `attr_value_has_sku`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `attr_value_has_sku` (
  `attr_value_attr_value_id` int(11) NOT NULL,
  `sku_sku_id` int(11) NOT NULL,
  PRIMARY KEY (`attr_value_attr_value_id`,`sku_sku_id`),
  KEY `fk_attr_value_has_sku_sku1_idx` (`sku_sku_id`),
  KEY `fk_attr_value_has_sku_attr_value1_idx` (`attr_value_attr_value_id`),
  CONSTRAINT `fk_attr_value_has_sku_attr_value1` FOREIGN KEY (`attr_value_attr_value_id`) REFERENCES `attr_value` (`attr_value_id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_attr_value_has_sku_sku1` FOREIGN KEY (`sku_sku_id`) REFERENCES `sku` (`sku_id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `attr_value_has_sku`
--

LOCK TABLES `attr_value_has_sku` WRITE;
/*!40000 ALTER TABLE `attr_value_has_sku` DISABLE KEYS */;
INSERT INTO `attr_value_has_sku` VALUES (3,2),(5,2),(4,3),(5,3);
/*!40000 ALTER TABLE `attr_value_has_sku` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `brand`
--

DROP TABLE IF EXISTS `brand`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `brand` (
  `brand_id` int(11) NOT NULL AUTO_INCREMENT,
  `brand_name` varchar(50) NOT NULL,
  PRIMARY KEY (`brand_id`)
) ENGINE=InnoDB AUTO_INCREMENT=20 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `brand`
--

LOCK TABLES `brand` WRITE;
/*!40000 ALTER TABLE `brand` DISABLE KEYS */;
INSERT INTO `brand` VALUES (1,'Nike'),(2,'Apple'),(3,'Only'),(4,'Huawei'),(5,'Samsung'),(6,'Oppo'),(7,'Veromoda'),(8,'Vivo'),(9,'Microsoft'),(13,'change');
/*!40000 ALTER TABLE `brand` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `coupon`
--

DROP TABLE IF EXISTS `coupon`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `coupon` (
  `coupon_id` int(11) NOT NULL AUTO_INCREMENT,
  `coupon_name` varchar(20) NOT NULL,
  `coupon_how_many` int(11) NOT NULL,
  `coupon_type` float NOT NULL DEFAULT '1',
  `coupon_lower_bound` float NOT NULL,
  `coupon_value` float NOT NULL,
  `coupon_cost_allocation` int(11) NOT NULL DEFAULT '0',
  `coupon_user_lever` varchar(20) NOT NULL,
  `coupon_use_range` int(11) NOT NULL DEFAULT '1',
  `coupon_begin_time` datetime NOT NULL,
  `coupon_end_time` datetime NOT NULL,
  `coupon_status` int(11) NOT NULL DEFAULT '1',
  `coupon_verifier` varchar(20) NOT NULL,
  `coupon_is_deleted` tinyint(1) NOT NULL DEFAULT '0',
  `coupon_note` varchar(50) DEFAULT NULL,
  `COUPON_USER_RANGE` int(11) DEFAULT NULL,
  PRIMARY KEY (`coupon_id`)
) ENGINE=InnoDB AUTO_INCREMENT=20 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `coupon`
--

LOCK TABLES `coupon` WRITE;
/*!40000 ALTER TABLE `coupon` DISABLE KEYS */;
INSERT INTO `coupon` VALUES (1,'twer',30,1,400,50,0,'a',1,'2018-11-11 00:00:00','2018-11-12 00:00:00',1,'a',0,'ddf',2),(2,'twer',30,1,400,50,0,'a',1,'2018-11-11 00:00:00','2018-11-12 00:00:00',1,'a',0,'ddf',2),(3,'twer',30,1,400,50,0,'a',1,'2018-11-11 00:00:00','2018-11-12 00:00:00',1,'a',0,'ddf',2),(4,'twer',30,1,400,50,0,'a',1,'2018-11-11 00:00:00','2018-11-12 00:00:00',1,'a',0,'ddf',2),(5,'twer',30,1,400,50,0,'a',1,'2018-11-11 00:00:00','2018-11-12 00:00:00',1,'a',0,'ddf',2),(13,'change',123,1,123,21,123,'high',1,'2008-08-11 12:21:12','2019-09-11 12:00:00',1,'as',0,'dfghjk',2);
/*!40000 ALTER TABLE `coupon` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `coupon_has_user`
--

DROP TABLE IF EXISTS `coupon_has_user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `coupon_has_user` (
  `coupon_coupon_id` int(11) NOT NULL,
  `user_user_id` int(11) NOT NULL,
  `received_time` datetime NOT NULL,
  `coupon_has_user_is_deleted` tinyint(1) NOT NULL DEFAULT '0',
  `coupon_has_user_status` int(11) NOT NULL DEFAULT '0',
  PRIMARY KEY (`coupon_coupon_id`,`user_user_id`),
  KEY `fk_coupon_has_user_user1_idx` (`user_user_id`),
  KEY `fk_coupon_has_user_coupon1_idx` (`coupon_coupon_id`),
  CONSTRAINT `fk_coupon_has_user_coupon1` FOREIGN KEY (`coupon_coupon_id`) REFERENCES `coupon` (`coupon_id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_coupon_has_user_user1` FOREIGN KEY (`user_user_id`) REFERENCES `user` (`user_id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `coupon_has_user`
--

LOCK TABLES `coupon_has_user` WRITE;
/*!40000 ALTER TABLE `coupon_has_user` DISABLE KEYS */;
INSERT INTO `coupon_has_user` VALUES (1,1,'2018-11-11 00:00:00',0,1),(1,2,'2018-11-11 00:00:00',0,1),(2,1,'2018-11-11 00:00:00',0,1),(2,2,'2018-11-11 00:00:00',0,1);
/*!40000 ALTER TABLE `coupon_has_user` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `coupon_use_range`
--

DROP TABLE IF EXISTS `coupon_use_range`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `coupon_use_range` (
  `coupon_use_range_id` int(11) NOT NULL AUTO_INCREMENT,
  `coupon_coupon_id` int(11) NOT NULL,
  `use_range_id` int(11) NOT NULL DEFAULT '0',
  PRIMARY KEY (`coupon_use_range_id`),
  KEY `fk_coupon_use_range_coupon1_idx` (`coupon_coupon_id`),
  CONSTRAINT `fk_coupon_use_range_coupon1` FOREIGN KEY (`coupon_coupon_id`) REFERENCES `coupon` (`coupon_id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=14 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `coupon_use_range`
--

LOCK TABLES `coupon_use_range` WRITE;
/*!40000 ALTER TABLE `coupon_use_range` DISABLE KEYS */;
INSERT INTO `coupon_use_range` VALUES (1,1,1),(2,2,1),(3,2,3),(4,2,5),(13,1,2);
/*!40000 ALTER TABLE `coupon_use_range` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `order`
--

DROP TABLE IF EXISTS `order`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `order` (
  `order_id` int(11) NOT NULL AUTO_INCREMENT,
  `order_no` varchar(20) NOT NULL,
  `order_sku_sum` int(11) NOT NULL DEFAULT '0',
  `order_total_price` float NOT NULL DEFAULT '0',
  `order_real_price` float NOT NULL DEFAULT '0',
  `order_delivery_price` float NOT NULL DEFAULT '0',
  `order_store_discount` float NOT NULL DEFAULT '0',
  `order_platform_discount` float NOT NULL DEFAULT '0',
  `order_time_order` datetime NOT NULL,
  `order_time_pay` datetime NOT NULL,
  `order_time_delivery` datetime NOT NULL,
  `order_time_deal` datetime NOT NULL,
  `order_delivery_no` varchar(20) NOT NULL,
  `order_note` varchar(50) DEFAULT NULL,
  `order_status` int(11) NOT NULL DEFAULT '1',
  `pay_channel_pay_channel_id` int(11) NOT NULL,
  `user_user_id` int(11) NOT NULL,
  `addr_addr_id` int(11) NOT NULL,
  PRIMARY KEY (`order_id`),
  KEY `fk_order_pay_channel1_idx` (`pay_channel_pay_channel_id`),
  KEY `fk_order_user1_idx` (`user_user_id`),
  KEY `fk_order_addr1_idx` (`addr_addr_id`),
  CONSTRAINT `fk_order_addr1` FOREIGN KEY (`addr_addr_id`) REFERENCES `addr` (`addr_id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_order_pay_channel1` FOREIGN KEY (`pay_channel_pay_channel_id`) REFERENCES `pay_channel` (`pay_channel_id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_order_user1` FOREIGN KEY (`user_user_id`) REFERENCES `user` (`user_id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=20 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `order`
--

LOCK TABLES `order` WRITE;
/*!40000 ALTER TABLE `order` DISABLE KEYS */;
INSERT INTO `order` VALUES (1,'23452345',10,445243,445200,0,43,0,'2018-12-01 00:00:00','2018-12-01 01:00:00','2018-12-05 00:00:00','2018-12-10 00:00:00','567745675547','none',3,1,1,1),(2,'23452345',10,445243,445200,0,43,0,'2018-12-01 00:00:00','2018-12-01 01:00:00','2018-12-05 00:00:00','2018-12-10 00:00:00','567745675547','none',3,2,1,4),(18,'123',1,1,1,1,1,1,'2018-12-01 01:00:00','2018-12-01 01:00:00','2018-12-01 01:00:00','2018-12-01 01:00:00','123','change',1,1,1,1);
/*!40000 ALTER TABLE `order` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `order_has_coupon`
--

DROP TABLE IF EXISTS `order_has_coupon`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `order_has_coupon` (
  `order_order_id` int(11) NOT NULL,
  `coupon_coupon_id` int(11) NOT NULL,
  PRIMARY KEY (`order_order_id`,`coupon_coupon_id`),
  KEY `fk_order_has_coupon_coupon1_idx` (`coupon_coupon_id`),
  KEY `fk_order_has_coupon_order1_idx` (`order_order_id`),
  CONSTRAINT `fk_order_has_coupon_coupon1` FOREIGN KEY (`coupon_coupon_id`) REFERENCES `coupon` (`coupon_id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_order_has_coupon_order1` FOREIGN KEY (`order_order_id`) REFERENCES `order` (`order_id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `order_has_coupon`
--

LOCK TABLES `order_has_coupon` WRITE;
/*!40000 ALTER TABLE `order_has_coupon` DISABLE KEYS */;
INSERT INTO `order_has_coupon` VALUES (1,1),(2,1),(1,2),(2,2);
/*!40000 ALTER TABLE `order_has_coupon` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `pay_channel`
--

DROP TABLE IF EXISTS `pay_channel`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `pay_channel` (
  `pay_channel_id` int(11) NOT NULL AUTO_INCREMENT,
  `pay_channel_type` int(11) NOT NULL DEFAULT '1',
  `pay_channel_type_no` varchar(20) NOT NULL,
  `user_user_id` int(11) NOT NULL,
  PRIMARY KEY (`pay_channel_id`),
  KEY `fk_pay_channel_user1_idx` (`user_user_id`),
  CONSTRAINT `fk_pay_channel_user1` FOREIGN KEY (`user_user_id`) REFERENCES `user` (`user_id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=20 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `pay_channel`
--

LOCK TABLES `pay_channel` WRITE;
/*!40000 ALTER TABLE `pay_channel` DISABLE KEYS */;
INSERT INTO `pay_channel` VALUES (1,0,'19980811',1),(2,0,'34567890345678',1),(3,0,'753241',3),(4,0,'987542345678634',3),(5,0,'562rj',5),(13,2,'1234',1);
/*!40000 ALTER TABLE `pay_channel` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `return`
--

DROP TABLE IF EXISTS `return`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `return` (
  `return_id` int(11) NOT NULL,
  `return_no` int(11) NOT NULL,
  `return_delivery_no` varchar(20) NOT NULL,
  `return_amount` int(11) NOT NULL,
  `return_status` int(11) NOT NULL DEFAULT '0',
  `return_apply_time` datetime NOT NULL,
  `return_start_time` datetime NOT NULL,
  `return_end_time` datetime NOT NULL,
  `return_reason` varchar(50) DEFAULT NULL,
  `return_note` varchar(50) DEFAULT NULL,
  `order_order_id` int(11) NOT NULL,
  `user_user_id` int(11) NOT NULL,
  PRIMARY KEY (`return_id`),
  KEY `fk_return_order1_idx` (`order_order_id`),
  KEY `fk_return_user1_idx` (`user_user_id`),
  CONSTRAINT `fk_return_order1` FOREIGN KEY (`order_order_id`) REFERENCES `order` (`order_id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_return_user1` FOREIGN KEY (`user_user_id`) REFERENCES `user` (`user_id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `return`
--

LOCK TABLES `return` WRITE;
/*!40000 ALTER TABLE `return` DISABLE KEYS */;
INSERT INTO `return` VALUES (1,78654,'234567',4324,1,'2018-11-11 00:00:00','2018-11-11 00:00:00','2018-11-11 00:00:00','dfg','fsd',1,1),(18,123,'123',1,1,'2008-08-08 00:00:00','2008-08-08 00:00:00','2008-08-08 00:00:00',NULL,'change',1,1);
/*!40000 ALTER TABLE `return` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `return_addr`
--

DROP TABLE IF EXISTS `return_addr`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `return_addr` (
  `return_addr_id` int(11) NOT NULL AUTO_INCREMENT,
  `return_addr_country` varchar(20) NOT NULL,
  `return_addr_province` varchar(20) NOT NULL,
  `return_addr_city` varchar(20) NOT NULL,
  `return_addr_area` varchar(20) NOT NULL,
  `return_addr_detail` varchar(50) NOT NULL,
  `return_addr_is_default` tinyint(1) NOT NULL DEFAULT '0',
  `return_addr_name` varchar(20) NOT NULL,
  `return_addr_tel` varchar(20) NOT NULL,
  `store_store_id` int(11) NOT NULL,
  PRIMARY KEY (`return_addr_id`),
  KEY `fk_return_addr_store1_idx` (`store_store_id`),
  CONSTRAINT `fk_return_addr_store1` FOREIGN KEY (`store_store_id`) REFERENCES `store` (`store_id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=20 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `return_addr`
--

LOCK TABLES `return_addr` WRITE;
/*!40000 ALTER TABLE `return_addr` DISABLE KEYS */;
INSERT INTO `return_addr` VALUES (1,'China','Beijing','Beijing','Haidian','6453423',0,'duanqiulin','4532',1),(18,'abc','abc','abc','change','abc',1,'abc','123',1);
/*!40000 ALTER TABLE `return_addr` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `shopping_cart`
--

DROP TABLE IF EXISTS `shopping_cart`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `shopping_cart` (
  `shopping_cart_id` int(11) NOT NULL AUTO_INCREMENT,
  `shopping_cart_sku_num` int(11) NOT NULL DEFAULT '1',
  `shopping_cart_create_time` datetime NOT NULL,
  `shopping_cart_is_exist` tinyint(1) NOT NULL DEFAULT '1',
  `user_user_id` int(11) NOT NULL,
  PRIMARY KEY (`shopping_cart_id`),
  KEY `fk_shopping_cart_user1_idx` (`user_user_id`),
  CONSTRAINT `fk_shopping_cart_user1` FOREIGN KEY (`user_user_id`) REFERENCES `user` (`user_id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=20 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `shopping_cart`
--

LOCK TABLES `shopping_cart` WRITE;
/*!40000 ALTER TABLE `shopping_cart` DISABLE KEYS */;
INSERT INTO `shopping_cart` VALUES (1,5,'2019-01-01 00:00:00',1,1),(2,20,'2019-01-01 00:00:00',1,2),(3,5,'2019-01-01 00:00:00',1,1),(13,10,'2008-08-11 12:12:12',1,1);
/*!40000 ALTER TABLE `shopping_cart` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `shopping_cart_has_sku`
--

DROP TABLE IF EXISTS `shopping_cart_has_sku`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `shopping_cart_has_sku` (
  `shopping_cart_shopping_cart_id` int(11) NOT NULL,
  `sku_sku_id` int(11) NOT NULL,
  PRIMARY KEY (`shopping_cart_shopping_cart_id`,`sku_sku_id`),
  KEY `fk_shopping_cart_has_sku_sku1_idx` (`sku_sku_id`),
  KEY `fk_shopping_cart_has_sku_shopping_cart1_idx` (`shopping_cart_shopping_cart_id`),
  CONSTRAINT `fk_shopping_cart_has_sku_shopping_cart1` FOREIGN KEY (`shopping_cart_shopping_cart_id`) REFERENCES `shopping_cart` (`shopping_cart_id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_shopping_cart_has_sku_sku1` FOREIGN KEY (`sku_sku_id`) REFERENCES `sku` (`sku_id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `shopping_cart_has_sku`
--

LOCK TABLES `shopping_cart_has_sku` WRITE;
/*!40000 ALTER TABLE `shopping_cart_has_sku` DISABLE KEYS */;
INSERT INTO `shopping_cart_has_sku` VALUES (1,1),(2,2),(3,3);
/*!40000 ALTER TABLE `shopping_cart_has_sku` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `sku`
--

DROP TABLE IF EXISTS `sku`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `sku` (
  `sku_id` int(11) NOT NULL AUTO_INCREMENT,
  `sku_name` varchar(50) NOT NULL,
  `spu_spu_id` int(11) NOT NULL,
  `sku_price` float DEFAULT NULL,
  `sku_store` int(11) DEFAULT NULL,
  `spec_spec_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`sku_id`),
  KEY `fk_sku_spu1_idx` (`spu_spu_id`),
  KEY `fk_sku_spec1_idx` (`spec_spec_id`),
  CONSTRAINT `fk_sku_spec1` FOREIGN KEY (`spec_spec_id`) REFERENCES `spec` (`spec_id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_sku_spu1` FOREIGN KEY (`spu_spu_id`) REFERENCES `spu` (`spu_id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=20 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `sku`
--

LOCK TABLES `sku` WRITE;
/*!40000 ALTER TABLE `sku` DISABLE KEYS */;
INSERT INTO `sku` VALUES (1,'Apple iPhone 6s Plus (A1699) 128G Silver',1,10,5,1),(2,'Apple iPhone 6s Plus (A1699) 32G Gold',1,231,3423,3),(3,'Apple iPhone 6s Plus (A1699) 32G Silver',1,23412,34,2),(4,'Apple iPhone 6s Plus (A1699) 32G Gold',1,234,234,1),(13,'change',1,1,21,1);
/*!40000 ALTER TABLE `sku` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `sku_has_order`
--

DROP TABLE IF EXISTS `sku_has_order`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `sku_has_order` (
  `sku_sku_id` int(11) NOT NULL,
  `order_order_id` int(11) NOT NULL,
  `sku_has_order_sku_num` int(11) NOT NULL,
  PRIMARY KEY (`sku_sku_id`,`order_order_id`),
  KEY `fk_sku_has_order_order1_idx` (`order_order_id`),
  KEY `fk_sku_has_order_sku1_idx` (`sku_sku_id`),
  CONSTRAINT `fk_sku_has_order_order1` FOREIGN KEY (`order_order_id`) REFERENCES `order` (`order_id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_sku_has_order_sku1` FOREIGN KEY (`sku_sku_id`) REFERENCES `sku` (`sku_id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `sku_has_order`
--

LOCK TABLES `sku_has_order` WRITE;
/*!40000 ALTER TABLE `sku_has_order` DISABLE KEYS */;
INSERT INTO `sku_has_order` VALUES (1,1,10),(2,2,5),(3,2,5);
/*!40000 ALTER TABLE `sku_has_order` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `sku_has_return`
--

DROP TABLE IF EXISTS `sku_has_return`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `sku_has_return` (
  `sku_sku_id` int(11) NOT NULL,
  `return_return_id` int(11) NOT NULL,
  PRIMARY KEY (`sku_sku_id`,`return_return_id`),
  KEY `fk_sku_has_return_return1_idx` (`return_return_id`),
  KEY `fk_sku_has_return_sku1_idx` (`sku_sku_id`),
  CONSTRAINT `fk_sku_has_return_return1` FOREIGN KEY (`return_return_id`) REFERENCES `return` (`return_id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_sku_has_return_sku1` FOREIGN KEY (`sku_sku_id`) REFERENCES `sku` (`sku_id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `sku_has_return`
--

LOCK TABLES `sku_has_return` WRITE;
/*!40000 ALTER TABLE `sku_has_return` DISABLE KEYS */;
INSERT INTO `sku_has_return` VALUES (1,1);
/*!40000 ALTER TABLE `sku_has_return` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `spec`
--

DROP TABLE IF EXISTS `spec`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `spec` (
  `spec_id` int(11) NOT NULL AUTO_INCREMENT,
  `spec_name` varchar(100) NOT NULL,
  `spec_group_spec_group_id` int(11) NOT NULL,
  PRIMARY KEY (`spec_id`),
  KEY `fk_spec_spec_group1_idx` (`spec_group_spec_group_id`),
  CONSTRAINT `fk_spec_spec_group1` FOREIGN KEY (`spec_group_spec_group_id`) REFERENCES `spec_group` (`spec_group_id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=14 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `spec`
--

LOCK TABLES `spec` WRITE;
/*!40000 ALTER TABLE `spec` DISABLE KEYS */;
INSERT INTO `spec` VALUES (1,'gold 32G',5),(2,'silver 64G',5),(3,'gold 64G',5),(13,'name',2);
/*!40000 ALTER TABLE `spec` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `spec_group`
--

DROP TABLE IF EXISTS `spec_group`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `spec_group` (
  `spec_group_id` int(11) NOT NULL AUTO_INCREMENT,
  `spec_group_name` varchar(90) NOT NULL,
  PRIMARY KEY (`spec_group_id`)
) ENGINE=InnoDB AUTO_INCREMENT=14 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `spec_group`
--

LOCK TABLES `spec_group` WRITE;
/*!40000 ALTER TABLE `spec_group` DISABLE KEYS */;
INSERT INTO `spec_group` VALUES (1,'color length waistline'),(2,'color size capcity memory resolution-ratio'),(3,'color size capcity memory'),(4,'color length '),(5,'color memory'),(13,'chenge');
/*!40000 ALTER TABLE `spec_group` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `spu`
--

DROP TABLE IF EXISTS `spu`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `spu` (
  `spu_id` int(11) NOT NULL,
  `spu_name` varchar(50) NOT NULL,
  `store_store_id` int(11) NOT NULL,
  `brand_brand_id` int(11) NOT NULL,
  `spu_type_spu_type_id` int(11) NOT NULL,
  PRIMARY KEY (`spu_id`),
  KEY `fk_spu_store1_idx` (`store_store_id`),
  KEY `fk_spu_brand1_idx` (`brand_brand_id`),
  KEY `fk_spu_spu_type1_idx` (`spu_type_spu_type_id`),
  CONSTRAINT `fk_spu_brand1` FOREIGN KEY (`brand_brand_id`) REFERENCES `brand` (`brand_id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_spu_spu_type1` FOREIGN KEY (`spu_type_spu_type_id`) REFERENCES `spu_type` (`spu_type_id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_spu_store1` FOREIGN KEY (`store_store_id`) REFERENCES `store` (`store_id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `spu`
--

LOCK TABLES `spu` WRITE;
/*!40000 ALTER TABLE `spu` DISABLE KEYS */;
INSERT INTO `spu` VALUES (1,'iPhone6',1,2,2),(2,'iPhone6',2,2,2),(3,'jeans_A',4,3,5),(4,'jeans_A',4,1,5),(13,'change',1,1,1);
/*!40000 ALTER TABLE `spu` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `spu_type`
--

DROP TABLE IF EXISTS `spu_type`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `spu_type` (
  `spu_type_id` int(11) NOT NULL AUTO_INCREMENT,
  `spu_type_name` varchar(50) NOT NULL,
  `spu_type_father_id` int(11) NOT NULL DEFAULT '0',
  PRIMARY KEY (`spu_type_id`)
) ENGINE=InnoDB AUTO_INCREMENT=20 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `spu_type`
--

LOCK TABLES `spu_type` WRITE;
/*!40000 ALTER TABLE `spu_type` DISABLE KEYS */;
INSERT INTO `spu_type` VALUES (1,'electronic equipment',0),(2,'Mobile Phone',1),(3,'clothing',0),(4,'women clothing',3),(5,'jeans',4),(6,'men clothing',3),(7,'jeans',6),(13,'change',1);
/*!40000 ALTER TABLE `spu_type` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `spu_type_has_spec_group`
--

DROP TABLE IF EXISTS `spu_type_has_spec_group`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `spu_type_has_spec_group` (
  `spu_type_spu_type_id` int(11) NOT NULL,
  `spec_group_spec_group_id` int(11) NOT NULL,
  PRIMARY KEY (`spu_type_spu_type_id`,`spec_group_spec_group_id`),
  KEY `fk_spu_type_has_spec_group_spec_group1_idx` (`spec_group_spec_group_id`),
  KEY `fk_spu_type_has_spec_group_spu_type1_idx` (`spu_type_spu_type_id`),
  CONSTRAINT `fk_spu_type_has_spec_group_spec_group1` FOREIGN KEY (`spec_group_spec_group_id`) REFERENCES `spec_group` (`spec_group_id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_spu_type_has_spec_group_spu_type1` FOREIGN KEY (`spu_type_spu_type_id`) REFERENCES `spu_type` (`spu_type_id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `spu_type_has_spec_group`
--

LOCK TABLES `spu_type_has_spec_group` WRITE;
/*!40000 ALTER TABLE `spu_type_has_spec_group` DISABLE KEYS */;
INSERT INTO `spu_type_has_spec_group` VALUES (5,1),(7,1),(2,2),(2,3),(5,4);
/*!40000 ALTER TABLE `spu_type_has_spec_group` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `spu_type_has_store_info`
--

DROP TABLE IF EXISTS `spu_type_has_store_info`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `spu_type_has_store_info` (
  `spu_type_spu_type_id` int(11) NOT NULL,
  `store_info_store_id` int(11) NOT NULL,
  `spec_info_store_id` int(11) NOT NULL,
  PRIMARY KEY (`spu_type_spu_type_id`,`store_info_store_id`),
  KEY `fk_spu_type_has_store_info_store_info1_idx` (`store_info_store_id`),
  KEY `fk_spu_type_has_store_info_spu_type1_idx` (`spu_type_spu_type_id`),
  CONSTRAINT `fk_spu_type_has_store_info_spu_type1` FOREIGN KEY (`spu_type_spu_type_id`) REFERENCES `spu_type` (`spu_type_id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_spu_type_has_store_info_store_info1` FOREIGN KEY (`store_info_store_id`) REFERENCES `store` (`store_id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `spu_type_has_store_info`
--

LOCK TABLES `spu_type_has_store_info` WRITE;
/*!40000 ALTER TABLE `spu_type_has_store_info` DISABLE KEYS */;
INSERT INTO `spu_type_has_store_info` VALUES (2,1,0),(2,2,0),(5,4,0),(7,4,0);
/*!40000 ALTER TABLE `spu_type_has_store_info` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `store`
--

DROP TABLE IF EXISTS `store`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `store` (
  `store_id` int(11) NOT NULL AUTO_INCREMENT,
  `store_name` varchar(20) NOT NULL,
  `store_keyword` varchar(20) NOT NULL,
  `store_tel` varchar(20) NOT NULL,
  `store_is_direct_sale` tinyint(1) NOT NULL DEFAULT '0',
  `store_url` varchar(50) NOT NULL,
  `store_logo_url` varchar(50) NOT NULL,
  `store_license_url` varchar(50) NOT NULL,
  `store_introduction` varchar(50) NOT NULL,
  `store_status` int(11) NOT NULL DEFAULT '1',
  `store_create_time` datetime NOT NULL,
  `store_pass_time` datetime NOT NULL,
  `store_end_time` datetime NOT NULL,
  `store_verifier` varchar(20) NOT NULL,
  `user_user_id` int(11) NOT NULL,
  PRIMARY KEY (`store_id`),
  KEY `fk_store_user1_idx` (`user_user_id`),
  CONSTRAINT `fk_store_user1` FOREIGN KEY (`user_user_id`) REFERENCES `user` (`user_id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=20 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `store`
--

LOCK TABLES `store` WRITE;
/*!40000 ALTER TABLE `store` DISABLE KEYS */;
INSERT INTO `store` VALUES (1,'Apple','Apple','6534',1,'https://mall.jd.com/index-1000000127.html','https://item.jd.com/100001860767.html','https://item.jd.com/100001860767.html','none',2,'2008-08-08 12:00:00','2008-08-10 00:00:00','0000-00-00 00:00:00','A',4),(2,'MingRi','MingRi','6534868',2,'https://mall.jd.com/index-MingRi','https://mall.jd.com/index','https://mall.jd.com/index','none',2,'2008-10-08 12:00:00','2008-11-10 00:00:00','0000-00-00 00:00:00','B',5),(3,'HUAWEI','HUAWEI','4567',1,'https://mall.jd.com/index-1000004259.html','https://mall.jd.com/index-1000004259.html','https://mall.jd.com/index-1000004259.html','none',2,'2008-08-08 12:00:00','2008-08-10 00:00:00','0000-00-00 00:00:00','E',3),(4,'Only','Only','6534868',2,'https://mall.jd.com/index','https://mall.jd.com/index','https://mall.jd.com/index','none',2,'2008-10-08 12:00:00','2008-11-10 00:00:00','0000-00-00 00:00:00','B',3),(18,'name','change','123',1,'abc','abc','abc','abc',1,'2008-08-08 00:00:00','2008-08-08 00:00:00','2008-08-08 00:00:00','abc',1);
/*!40000 ALTER TABLE `store` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user`
--

DROP TABLE IF EXISTS `user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `user` (
  `user_id` int(11) NOT NULL AUTO_INCREMENT,
  `user_username` varchar(20) NOT NULL,
  `user_email` varchar(50) NOT NULL,
  `user_tel` varchar(20) NOT NULL,
  `user_password` varchar(20) NOT NULL,
  `user_status` int(11) NOT NULL DEFAULT '0',
  PRIMARY KEY (`user_id`)
) ENGINE=InnoDB AUTO_INCREMENT=20 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user`
--

LOCK TABLES `user` WRITE;
/*!40000 ALTER TABLE `user` DISABLE KEYS */;
INSERT INTO `user` VALUES (1,'Tony','123456@qq.com','1123456789','12345',1),(2,'Boy','654321@163.com','8763241','543',1),(3,'Andy','7432465432@126.com','23456789','98654',0),(4,'Apple','9876543@163.com','456789','23456789',1),(5,'Peter','456789@163.com','45678','345678',0),(13,'change','abc','abc','abc',1);
/*!40000 ALTER TABLE `user` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user_info`
--

DROP TABLE IF EXISTS `user_info`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `user_info` (
  `user_info_id` int(11) NOT NULL AUTO_INCREMENT,
  `user_info_realname` varchar(20) NOT NULL,
  `user_info_sex` varchar(2) NOT NULL DEFAULT '0',
  `user_info_pid` varchar(50) NOT NULL,
  `user_info_birth` date DEFAULT NULL,
  `user_info_face_url` varchar(50) DEFAULT NULL,
  `user_info_level` varchar(20) NOT NULL,
  `user_info_cost` float NOT NULL,
  `user_info_return_credit` int(11) DEFAULT NULL,
  `user_info_regist_time` datetime NOT NULL,
  `user_info_login_time` datetime NOT NULL,
  `user_info_login_count` int(11) NOT NULL,
  `user_user_id` int(11) NOT NULL,
  PRIMARY KEY (`user_info_id`),
  KEY `fk_user_info_user1_idx` (`user_user_id`),
  CONSTRAINT `fk_user_info_user1` FOREIGN KEY (`user_user_id`) REFERENCES `user` (`user_id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=20 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user_info`
--

LOCK TABLES `user_info` WRITE;
/*!40000 ALTER TABLE `user_info` DISABLE KEYS */;
INSERT INTO `user_info` VALUES (1,'duanqiul','0','76798876','1998-08-11','http://baidu.com','gold',765,0,'2018-12-31 00:00:00','2018-12-31 00:00:00',5,1),(2,'wangxiny','1','54678','1998-08-11','http://baidu.com','gold',765,0,'2018-12-31 00:00:00','2018-12-31 00:00:00',10,2),(3,'heqinzi','1','756544','1998-08-11','http://baidu.com','gold',765,0,'2018-12-31 00:00:00','2018-12-31 00:00:00',10,3),(4,'majia','1','54678','1998-08-11','http://baidu.com','gold',765,0,'2018-12-31 00:00:00','2018-12-31 00:00:00',10,5),(13,'abc','a','abc','2008-08-08','abc','change',1,1,'2008-08-08 00:00:00','2008-08-08 00:00:00',1,1);
/*!40000 ALTER TABLE `user_info` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user_login_open`
--

DROP TABLE IF EXISTS `user_login_open`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `user_login_open` (
  `user_login_open_id` int(11) NOT NULL AUTO_INCREMENT,
  `user_login_open_qq_no` varchar(20) DEFAULT NULL,
  `user_login_open_wechat_no` varchar(20) DEFAULT NULL,
  `user_user_id` int(11) NOT NULL,
  PRIMARY KEY (`user_login_open_id`),
  KEY `fk_user_login_open_user1_idx` (`user_user_id`),
  CONSTRAINT `fk_user_login_open_user1` FOREIGN KEY (`user_user_id`) REFERENCES `user` (`user_id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=14 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user_login_open`
--

LOCK TABLES `user_login_open` WRITE;
/*!40000 ALTER TABLE `user_login_open` DISABLE KEYS */;
INSERT INTO `user_login_open` VALUES (1,'3256788664','345y98y76',1),(2,'8765679','7769857gyu',2),(3,'54566789','gudy7',5),(13,'change','abc',13);
/*!40000 ALTER TABLE `user_login_open` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2019-01-04 22:51:51
