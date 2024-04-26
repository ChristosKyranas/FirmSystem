-- phpMyAdmin SQL Dump
-- version 5.0.2
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1:3306
-- Generation Time: Apr 26, 2024 at 07:25 AM
-- Server version: 5.7.31
-- PHP Version: 7.4.9

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `company`
--

-- --------------------------------------------------------

--
-- Table structure for table `branch`
--

DROP TABLE IF EXISTS `branch`;
CREATE TABLE IF NOT EXISTS `branch` (
                                        `branch_id` int(11) NOT NULL AUTO_INCREMENT,
    `name` varchar(255) NOT NULL,
    `address` varchar(255) NOT NULL,
    `city` varchar(100) NOT NULL,
    `country` varchar(100) NOT NULL,
    `budget` double NOT NULL,
    `worth` double NOT NULL,
    `establishment` varchar(4) NOT NULL,
    `firm` int(11) NOT NULL,
    `created_at` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
    `updated_at` timestamp NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP,
    PRIMARY KEY (`branch_id`),
    KEY `name` (`name`),
    KEY `firm` (`firm`)
    ) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8;

--
-- Dumping data for table `branch`
--

INSERT INTO `branch` (`branch_id`, `name`, `address`, `city`, `country`, `budget`, `worth`, `establishment`, `firm`, `created_at`, `updated_at`) VALUES
                                                                                                                                                     (6, 'test_cy', 'kwstakh 1', 'ioannina', 'greece', 10000, 1000000, '1900', 1, '2024-03-27 13:58:08', '2024-04-01 11:33:28'),
                                                                                                                                                     (7, 'test123', 'kwstakh 1', 'ioannina', 'greece', 10000, 1000000, '1900', 1, '2024-03-27 13:59:00', NULL),
                                                                                                                                                     (8, 'temp123', 'kwstakh 1', 'ioannina', 'greece', 10000000, 100000, '1900', 1, '2024-04-02 11:24:50', NULL);

--
-- Constraints for dumped tables
--

--
-- Constraints for table `branch`
--
ALTER TABLE `branch`
    ADD CONSTRAINT `firm` FOREIGN KEY (`firm`) REFERENCES `firm` (`firm_id`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
