-- phpMyAdmin SQL Dump
-- version 5.0.2
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1:3306
-- Generation Time: Apr 26, 2024 at 07:24 AM
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
-- Table structure for table `firm`
--

DROP TABLE IF EXISTS `firm`;
CREATE TABLE IF NOT EXISTS `firm` (
                                      `firm_id` int(11) NOT NULL AUTO_INCREMENT,
    `name` varchar(255) NOT NULL,
    `active` tinyint(1) NOT NULL DEFAULT '1',
    `created_at` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
    `updated_at` timestamp NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP,
    PRIMARY KEY (`firm_id`),
    UNIQUE KEY `name_2` (`name`),
    KEY `name` (`name`)
    ) ENGINE=InnoDB AUTO_INCREMENT=38 DEFAULT CHARSET=utf8;

--
-- Dumping data for table `firm`
--

INSERT INTO `firm` (`firm_id`, `name`, `active`, `created_at`, `updated_at`) VALUES
                                                                                 (1, 'test', 1, '2024-03-21 08:38:29', NULL),
                                                                                 (4, 'test1', 1, '2024-04-01 11:29:27', NULL),
                                                                                 (5, 'test123', 1, '2024-04-12 11:59:55', NULL),
                                                                                 (11, 'x', 1, '2024-04-24 13:08:03', NULL),
                                                                                 (17, 'a&', 1, '2024-04-24 13:15:30', NULL),
                                                                                 (19, 'asd', 1, '2024-04-25 07:34:20', NULL),
                                                                                 (20, 'fds', 1, '2024-04-25 07:34:32', NULL),
                                                                                 (23, 'hello', 1, '2024-04-25 12:02:23', NULL),
                                                                                 (24, '123', 1, '2024-04-25 12:09:07', NULL);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
