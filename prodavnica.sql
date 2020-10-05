-- phpMyAdmin SQL Dump
-- version 5.0.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Oct 06, 2020 at 12:06 AM
-- Server version: 10.4.11-MariaDB
-- PHP Version: 7.2.27

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `prodavnica`
--

-- --------------------------------------------------------

--
-- Table structure for table `korisnici`
--

CREATE TABLE `korisnici` (
  `id` int(11) NOT NULL,
  `username` varchar(255) NOT NULL,
  `password` varchar(255) NOT NULL,
  `ime` varchar(255) NOT NULL,
  `prezime` varchar(255) NOT NULL,
  `mesto` varchar(255) NOT NULL,
  `godine` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `korisnici`
--

INSERT INTO `korisnici` (`id`, `username`, `password`, `ime`, `prezime`, `mesto`, `godine`) VALUES
(1, 'Akisa', '1234', 'Aleksa', 'Ristic', 'Smederevo', 23),
(2, 'Fica', '1234', 'Filip', 'Krstic', 'Beograd', 24),
(3, 'Kaca', '1234', 'Katarina', 'Jovanic', 'Smederevo', 22),
(4, 'Jova', '1234', 'Jovan', 'Jeremic', 'Mladenovac', 40),
(5, 'Djole', '1234', 'Djordje', 'Stamenkovic', 'Papazovac', 34),
(6, 'Makisa', '1234', 'Marijan', 'Bijelic', 'Badljevica', 23);

-- --------------------------------------------------------

--
-- Table structure for table `naruceno`
--

CREATE TABLE `naruceno` (
  `id` int(11) NOT NULL,
  `korisnik_id` int(11) NOT NULL,
  `telefon_id` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Table structure for table `telefoni`
--

CREATE TABLE `telefoni` (
  `id` int(11) NOT NULL,
  `naziv` varchar(255) NOT NULL,
  `proizvodjac` varchar(255) NOT NULL,
  `opis` varchar(255) NOT NULL,
  `cena` int(11) NOT NULL,
  `godina` int(11) NOT NULL,
  `stanje` int(11) NOT NULL DEFAULT 0,
  `slika` text NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `telefoni`
--

INSERT INTO `telefoni` (`id`, `naziv`, `proizvodjac`, `opis`, `cena`, `godina`, `stanje`, `slika`) VALUES
(1, 'iPhone 11 Pro Max', 'Apple', 'Procesor: Apple A13 Bionic, Takt procesora: Dual-core 2.65 GHz, OS: IOS 13 ', 900, 2020, 15, 'https://pngimg.com/uploads/iphone_11/iphone_11_PNG28.png'),
(2, 'Mate 20 Lite', 'Huawei', 'Procesor: Qualcomm SM8250 Snapdragon 865 , Takt procesora: Octa-core  , OS: Android 10, MIUI 12', 999, 2020, 20, 'https://consumer-img.huawei.com/content/dam/huawei-cbg-site/common/mkt/list-image/phones/mate20-lite/mate20-lite-listimage-black.png'),
(3, 'Galaxy Note 20', 'Samsung', 'Procesor: Snapdragon 820, Radni takt: Quad-core, OS: Android 6.0.1 (Marshmallow)', 130, 2016, 45, 'https://zdnet4.cbsistatic.com/hub/i/2020/08/04/68774b61-af8d-4042-8e6d-2b95c23e8ed7/galaxy-note-20-ultra.png'),
(5, 'S20', 'Samsung', 'Fin telefon', 1200, 2019, 0, 'https://images.samsung.com/is/image/samsung/in-galaxy-s20-plus-sm-g985-sm-g985fzpdinu-frontbpurple-thumb-261486036');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `korisnici`
--
ALTER TABLE `korisnici`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `naruceno`
--
ALTER TABLE `naruceno`
  ADD PRIMARY KEY (`id`),
  ADD KEY `korisnik_id` (`korisnik_id`),
  ADD KEY `telefon_id` (`telefon_id`);

--
-- Indexes for table `telefoni`
--
ALTER TABLE `telefoni`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `korisnici`
--
ALTER TABLE `korisnici`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=24;

--
-- AUTO_INCREMENT for table `naruceno`
--
ALTER TABLE `naruceno`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=48;

--
-- AUTO_INCREMENT for table `telefoni`
--
ALTER TABLE `telefoni`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;

--
-- Constraints for dumped tables
--

--
-- Constraints for table `naruceno`
--
ALTER TABLE `naruceno`
  ADD CONSTRAINT `korisnik_id` FOREIGN KEY (`korisnik_id`) REFERENCES `korisnici` (`id`),
  ADD CONSTRAINT `telefon_id` FOREIGN KEY (`telefon_id`) REFERENCES `telefoni` (`id`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
