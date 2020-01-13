DROP DATABASE IF EXISTS  `mkyong`;
CREATE SCHEMA `mkyong` ;
DROP TABLE IF EXISTS `mkyong`.`stock`;
CREATE TABLE  `mkyong`.`stock` (
  `STOCK_ID` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `STOCK_CODE` varchar(10) NOT NULL,
  `STOCK_NAME` varchar(20) NOT NULL,
  PRIMARY KEY (`STOCK_ID`) USING BTREE,
  UNIQUE KEY `UNI_STOCK_NAME` (`STOCK_NAME`),
  UNIQUE KEY `UNI_STOCK_ID` (`STOCK_CODE`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8mb4;


DROP TABLE IF EXISTS `stock`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `stock` (
  `ID` int(10) DEFAULT NULL,
  `Symbol` varchar(10) NOT NULL,
  `TimeStamp` varchar(20) NOT NULL,
  `Open` decimal(10,2) DEFAULT NULL,
  `High` decimal(10,2) DEFAULT NULL,
  `Low` decimal(10,2) DEFAULT NULL,
  `Close` decimal(10,2) DEFAULT NULL,
  `AdjClose` decimal(10,2) DEFAULT NULL,
  PRIMARY KEY (`Symbol`,`TimeStamp`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;
