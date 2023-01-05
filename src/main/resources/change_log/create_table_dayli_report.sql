
CREATE TABLE `daily_exchange_report` (
  `der_id` int NOT NULL AUTO_INCREMENT,
  `close` decimal(19,5) DEFAULT NULL,
  `date_time` datetime(6) DEFAULT NULL,
  `exchange` varchar(255) DEFAULT NULL,
  `symbol` varchar(255) DEFAULT NULL,
  `timestamp` bigint NOT NULL,
  PRIMARY KEY (`der_id`)
)