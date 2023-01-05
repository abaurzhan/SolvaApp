

CREATE TABLE `expense_transaction` (
  `e_tran_id` int NOT NULL AUTO_INCREMENT,
  `currency` varchar(255) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `date_time` datetime(6) DEFAULT NULL,
  `limit_exceeded` bit(1) DEFAULT NULL,
  `sum` decimal(19,2) DEFAULT NULL,
  PRIMARY KEY (`e_tran_id`)
)