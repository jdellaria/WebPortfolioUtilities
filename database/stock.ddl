DROP DATABASE IF EXISTS  `mkyong`;
CREATE SCHEMA `mkyong` ;

DROP TABLE IF EXISTS `stock`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `stock` (
  `ID` int(10) DEFAULT NULL,
  `Symbol` varchar(10) NOT NULL,
  `DateStamp` datetime NOT NULL,
  `StringTimeStamp` varchar(20) NOT NULL,
  `Open` decimal(10,2) DEFAULT NULL,
  `High` decimal(10,2) DEFAULT NULL,
  `Low` decimal(10,2) DEFAULT NULL,
  `Close` decimal(10,2) DEFAULT NULL,
  `AdjClose` decimal(10,2) DEFAULT NULL,
  PRIMARY KEY (`Symbol`,`DateStamp`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;
/*!40101 SET character_set_client = @saved_cs_client */;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;
