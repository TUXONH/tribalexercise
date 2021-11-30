-- phpMyAdmin SQL Dump
-- version 5.1.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1:3306
-- Generation Time: Nov 30, 2021 at 10:52 PM
-- Server version: 5.7.36
-- PHP Version: 7.4.26

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `creditlinedb`
--

-- --------------------------------------------------------

--
-- Table structure for table `credit_line`
--

DROP TABLE IF EXISTS `credit_line`;
CREATE TABLE IF NOT EXISTS `credit_line` (
    `id` bigint(20) NOT NULL,
    `cash_balance` decimal(12,2) DEFAULT NULL,
    `fail_times` bigint(20) DEFAULT NULL,
    `founding_types` varchar(10) DEFAULT NULL,
    `monthly_revenue` decimal(12,2) DEFAULT NULL,
    `requested_credit_line` decimal(12,2) DEFAULT NULL,
    `requested_date` datetime(6) DEFAULT NULL,
    `valid` bit(1) DEFAULT NULL,
    PRIMARY KEY (`id`),
    UNIQUE KEY `UK_q4vlp75rpdbdckdgbdnxqvi7e` (`requested_credit_line`)
    ) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `credit_line`
--

INSERT INTO `credit_line` (`id`, `cash_balance`, `fail_times`, `founding_types`, `monthly_revenue`, `requested_credit_line`, `requested_date`, `valid`) VALUES
(29, '435.30', 1, 'SME', '10.45', '100.00', '2021-11-30 16:52:04.099000', b'0');
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
