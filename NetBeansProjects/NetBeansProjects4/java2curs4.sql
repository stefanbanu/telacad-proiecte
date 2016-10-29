-- phpMyAdmin SQL Dump
-- version 4.0.4.1
-- http://www.phpmyadmin.net
--
-- Host: 127.0.0.1
-- Generation Time: Mar 16, 2016 at 08:37 PM
-- Server version: 5.5.32
-- PHP Version: 5.4.19

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- Database: `java2curs4`
--
CREATE DATABASE IF NOT EXISTS `java2curs4` DEFAULT CHARACTER SET latin1 COLLATE latin1_swedish_ci;
USE `java2curs4`;

-- --------------------------------------------------------

--
-- Table structure for table `angajati`
--

CREATE TABLE IF NOT EXISTS `angajati` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `nume` varchar(100) NOT NULL,
  `prenume` varchar(100) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=4 ;

--
-- Dumping data for table `angajati`
--

INSERT INTO `angajati` (`id`, `nume`, `prenume`) VALUES
(1, 'Pop', 'Gigel'),
(2, 'Pop', 'Mirel');

-- --------------------------------------------------------

--
-- Table structure for table `produse`
--

CREATE TABLE IF NOT EXISTS `produse` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `nume` varchar(100) NOT NULL,
  `pret` double NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=11 ;

--
-- Dumping data for table `produse`
--

INSERT INTO `produse` (`id`, `nume`, `pret`) VALUES
(1, 'PRODUS 1', 1),
(2, 'PRODUS 2', 2),
(3, 'PRODUS 3', 3),
(4, 'PRODUS 4', 4),
(5, 'PRODUS 5', 5),
(6, 'PRODUS 6', 6),
(7, 'PRODUS 7', 7),
(8, 'PRODUS 8', 8),
(9, 'PRODUS 9', 9),
(10, 'PRODUS 10', 10);

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
