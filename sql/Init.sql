//sql scripts for creating tables for MonthLimit and ExpenseTransaction

CREATE DATABASE solva;

CREATE TABLE `daily_exchange_report` (
  `der_id` int NOT NULL AUTO_INCREMENT,
  `close` decimal(19,5) DEFAULT NULL,
  `date_time` datetime(6) DEFAULT NULL,
  `exchange` varchar(255) DEFAULT NULL,
  `symbol` varchar(255) DEFAULT NULL,
  `timestamp` bigint NOT NULL,
  PRIMARY KEY (`der_id`)
);

CREATE TABLE `expense_transaction` (
  `e_tran_id` int NOT NULL AUTO_INCREMENT,
  `currency` varchar(255) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `date_time` datetime(6) DEFAULT NULL,
  `limit_exceeded` bit(1) DEFAULT NULL,
  `sum` decimal(19,2) DEFAULT NULL,
  PRIMARY KEY (`e_tran_id`)
);

CREATE TABLE `month_limit` (
  `m_limit_id` int NOT NULL AUTO_INCREMENT,
  `currency` varchar(255) DEFAULT NULL,
  `month_limit` decimal(19,2) DEFAULT NULL,
  `month` int DEFAULT NULL,
  PRIMARY KEY (`m_limit_id`)
);