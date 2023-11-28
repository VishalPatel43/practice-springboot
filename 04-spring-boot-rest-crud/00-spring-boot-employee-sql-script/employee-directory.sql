CREATE DATABASE  IF NOT EXISTS `employee_directory`;
USE `employee_directory`;

--
-- Table structure for table `employee`
--

DROP TABLE IF EXISTS `employee`;

CREATE TABLE `employee` (
  `id` int NOT NULL AUTO_INCREMENT,
  `first_name` varchar(45) DEFAULT NULL,
  `last_name` varchar(45) DEFAULT NULL,
  `email` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=latin1;

--
-- Data for table `employee`
--

INSERT INTO `employee` VALUES 
	(1001,'Leslie','Andrews','leslie@luv2code.com'),
	(1002,'Emma','Baumgarten','emma@luv2code.com'),
	(1003,'Avani','Gupta','avani@luv2code.com'),
	(1004,'Yuri','Petrov','yuri@luv2code.com'),
	(1005,'Juan','Vega','juan@luv2code.com');


-- start employee id with 1001
ALTER TABLE employee AUTO_INCREMENT = 1001;
