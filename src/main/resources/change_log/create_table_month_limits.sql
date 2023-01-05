
CREATE TABLE `month_limit` (
  `m_limit_id` int NOT NULL AUTO_INCREMENT,
  `currency` varchar(255) DEFAULT NULL,
  `month_limit` decimal(19,2) DEFAULT NULL,
  `month` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  PRIMARY KEY (`m_limit_id`)
)