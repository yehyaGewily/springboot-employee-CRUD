CREATE DATABASE  IF NOT EXISTS `fraud_directory`;
USE `fraud_directory`;

--
-- Table structure for table `employee`
--

DROP TABLE IF EXISTS `fraud`;

CREATE TABLE `fraud` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `customer_id` int(11) DEFAULT NULL,
  `is_fraudster` Boolean  DEFAULT false,
  `time` timestamp  DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=latin1;


