CREATE DATABASE IF NOT EXISTS `oop-put-courier-warehouse`;
USE `oop-put-courier-warehouse`;

DROP SCHEMA IF EXISTS `oop-put-courier-warehouse`;

CREATE SCHEMA `oop-put-courier-warehouse`;

use `oop-put-courier-warehouse`;

SET FOREIGN_KEY_CHECKS = 0;

DROP TABLE IF EXISTS `working_hours`;
CREATE TABLE `working_hours` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `date` DATE,
  `starting_hour` TIME,
  `finishing_hour` TIME,
  `sum` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
  ) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=latin1;

DROP TABLE IF EXISTS `employee`;
CREATE TABLE `employee` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `first_name` varchar(45) DEFAULT NULL,
  `last_name` varchar(45) DEFAULT NULL,
  `date_of_birth` DATE,
  `login` varchar(45) DEFAULT NULL,
  `password` varchar(45) DEFAULT NULL,
  `position` varchar(45) DEFAULT NULL,
  `is_admin` int(1) DEFAULT 0,
  `working_hours_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `F_Key_idx` (`working_hours_id`),
  CONSTRAINT `F_Key` FOREIGN KEY (`working_hours_id`) REFERENCES `working_hours` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
  ) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=latin1;

SET FOREIGN_KEY_CHECKS = 1;

DROP TABLE IF EXISTS `package`;
CREATE TABLE `package` (
	`id` int(11) NOT NULL AUTO_INCREMENT,
    `tracking_number` int(11) NOT NULL,
    `status` varchar(45) DEFAULT NULL,
    `height` int(11),
    `width` int(11),
    `depth` int(11),
    `weight`int(11),
    `date_of_entry` DATE,
    `date_of_delivery` DATE,
    PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=latin1;

DROP TABLE IF EXISTS `equipment`;
CREATE TABLE `equipment` (
	`id` int(11) NOT NULL AUTO_INCREMENT,
    `type` varchar(45) DEFAULT NULL,
    `amount` int(11),
    PRIMARY KEY (`id`)
)