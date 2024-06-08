-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Jun 08, 2024 at 05:24 PM
-- Server version: 10.4.32-MariaDB
-- PHP Version: 8.2.12

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `udruzenje_zus`
--

-- --------------------------------------------------------

--
-- Table structure for table `atmosfera`
--

CREATE TABLE `atmosfera` (
  `id_atmosfere` int(20) NOT NULL,
  `procenat_kiseonika` int(20) NOT NULL,
  `procenat_otrovnog_gasa` int(20) NOT NULL,
  `procenat_neotrovnog_gasa` int(20) NOT NULL,
  `id_objekta` int(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `atmosfera`
--

INSERT INTO `atmosfera` (`id_atmosfere`, `procenat_kiseonika`, `procenat_otrovnog_gasa`, `procenat_neotrovnog_gasa`, `id_objekta`) VALUES
(1, 24, 1, 73, 1),
(2, 21, 8, 71, 2),
(3, 11, 18, 71, 3),
(4, 5, 80, 15, 4),
(5, 24, 2, 74, 5),
(6, 2, 45, 53, 6);

-- --------------------------------------------------------

--
-- Table structure for table `boravak`
--

CREATE TABLE `boravak` (
  `id_boravka` int(20) NOT NULL,
  `datum_dolaska` date NOT NULL,
  `datum_odlaska` date NOT NULL,
  `prevozno_sredstvo` varchar(50) NOT NULL,
  `id_osobe` int(20) NOT NULL,
  `id_objekta` int(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `boravak`
--

INSERT INTO `boravak` (`id_boravka`, `datum_dolaska`, `datum_odlaska`, `prevozno_sredstvo`, `id_osobe`, `id_objekta`) VALUES
(1, '2124-06-28', '2124-06-08', 'MILLENNIUM FALCON', 14, 1),
(2, '2121-08-20', '2118-02-15', 'HIGHLINER', 1, 5);

-- --------------------------------------------------------

--
-- Table structure for table `misije`
--

CREATE TABLE `misije` (
  `id_misije` int(20) NOT NULL,
  `naziv` varchar(20) NOT NULL,
  `id_poznatog_objekta` int(20) NOT NULL,
  `svemirski_brod` varchar(100) NOT NULL,
  `Predvidjeno_vreme_putovanja` int(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `misije`
--

INSERT INTO `misije` (`id_misije`, `naziv`, `id_poznatog_objekta`, `svemirski_brod`, `Predvidjeno_vreme_putovanja`) VALUES
(1, 'ZUS 1', 1, 'USS ENTERPRISE', 105),
(2, 'ZUS 2', 2, 'MILLENNIUM FALCON', 55),
(3, 'ZUS 3', 3, 'MILLENNIUM FALCON', 48),
(4, 'ZUS 4', 4, 'USS ENTERPRISE', 155),
(5, 'ZUS 4', 5, 'HIGHLINER', 58),
(6, 'ZUS 6', 6, 'SPACEX STARSHIP', 4);

-- --------------------------------------------------------

--
-- Table structure for table `objekti`
--

CREATE TABLE `objekti` (
  `id_objekta` int(20) NOT NULL,
  `naziv` varchar(20) NOT NULL,
  `udaljenost_od_zvezde` int(20) NOT NULL,
  `najniza_zabelezena_temperatura` int(20) NOT NULL,
  `najvisa_zabelezena_temperatura` int(20) NOT NULL,
  `limit_gravitacionog_polja` int(20) NOT NULL,
  `brzina_orbite` int(20) NOT NULL,
  `nastanljiva` varchar(20) NOT NULL DEFAULT 'nije',
  `id_poznatog_objekta` int(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `objekti`
--

INSERT INTO `objekti` (`id_objekta`, `naziv`, `udaljenost_od_zvezde`, `najniza_zabelezena_temperatura`, `najvisa_zabelezena_temperatura`, `limit_gravitacionog_polja`, `brzina_orbite`, `nastanljiva`, `id_poznatog_objekta`) VALUES
(1, 'Terra Nova', 105, 207, 305, 1200, 32, 'jeste', 1),
(2, 'Gaia Prime', 166, 90, 300, 980, 35, 'nije', 2),
(3, 'Aurora', 160, 166, 270, 1800, 27, 'nije', 3),
(4, 'Elysium', 50, 300, 500, 1005, 44, 'nije', 4),
(5, 'Harmonioa', 120, 210, 300, 2000, 30, 'jeste', 5),
(6, 'Europa', 140, 160, 270, 1030, 34, 'nije', 6);

-- --------------------------------------------------------

--
-- Table structure for table `osobe`
--

CREATE TABLE `osobe` (
  `id_osobe` int(20) NOT NULL,
  `ime` varchar(20) NOT NULL,
  `prezime` varchar(20) NOT NULL,
  `datum_rodjenja` date NOT NULL,
  `korisnicko_ime` varchar(20) NOT NULL,
  `lozinka` varchar(20) NOT NULL,
  `id_stambenog_objekta` int(20) DEFAULT NULL COMMENT 'mesto trenutnog stanovanja'
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `osobe`
--

INSERT INTO `osobe` (`id_osobe`, `ime`, `prezime`, `datum_rodjenja`, `korisnicko_ime`, `lozinka`, `id_stambenog_objekta`) VALUES
(1, 'Mile', 'Kitic', '2034-04-20', 'mileKitic123', 'NemaViseCileMile', 4),
(2, 'Kobi', 'Brajant', '2024-06-28', 'xX_Kobi_Xx', 'KobiKralj', 4),
(5, 'Profesor', 'Snejp', '2016-06-22', 'Snejp_XD', 'lozinka', 1),
(6, 'Vuk', 'Mob', '2030-06-12', 'Vucina', 'qwerty', 1),
(7, 'VuK', 'Karadzic', '2104-06-07', 'UsamljeniVuk', 'BuboLenja', 3),
(14, 'Pavle', 'Milic', '2103-07-10', 'pavle', 'pavleskola', NULL),
(15, 'Sofija', 'Stefanovic', '2102-06-15', 'sssofija', 'sof', NULL),
(16, 'Aleksa', 'Milic', '2104-06-07', 'ggf', 'ggf', NULL),
(17, 'Milos', 'Pantelic', '2104-08-12', 'milos', 'pantelic', NULL),
(18, 'Jovan', 'Hrnjak', '2101-09-08', 'JasonTheLord', 'jasamkralj', NULL);

-- --------------------------------------------------------

--
-- Table structure for table `person`
--

CREATE TABLE `person` (
  `person_id` int(20) NOT NULL,
  `first_name` varchar(20) NOT NULL,
  `last_name` int(20) NOT NULL,
  `date_od_birth` date NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Table structure for table `poznati_objekat`
--

CREATE TABLE `poznati_objekat` (
  `id_poznatog_objekta` int(20) NOT NULL,
  `vrsta` varchar(20) NOT NULL,
  `velicina` int(20) NOT NULL,
  `udaljenost` int(20) NOT NULL,
  `prvobitni_naziv` varchar(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `poznati_objekat`
--

INSERT INTO `poznati_objekat` (`id_poznatog_objekta`, `vrsta`, `velicina`, `udaljenost`, `prvobitni_naziv`) VALUES
(1, 'planeta', 490, 103, 'Kepler-452b'),
(2, 'planeta', 600, 150, 'Kepler-186f'),
(3, 'planeta', 420, 190, 'Gliese 667 Cc'),
(4, 'planeta', 200, 90, 'kepler-442b'),
(5, 'planeta', 510, 148, '55 Cancri e'),
(6, 'satelit', 300, 0, 'Jupiter II');

-- --------------------------------------------------------

--
-- Table structure for table `smrt`
--

CREATE TABLE `smrt` (
  `id_smrti` int(20) NOT NULL,
  `datum_smrti` date NOT NULL,
  `id_osobe` int(20) NOT NULL,
  `uzrok` varchar(100) NOT NULL,
  `datm_sahrane` date NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Table structure for table `stambeni_objekat`
--

CREATE TABLE `stambeni_objekat` (
  `id_stambenog_objekta` int(20) NOT NULL,
  `vrednost` int(20) NOT NULL,
  `kvadratura` int(20) NOT NULL,
  `ocena` float NOT NULL,
  `id_objekta` int(20) NOT NULL,
  `id_osobe` int(20) DEFAULT NULL COMMENT 'vlasnik'
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `stambeni_objekat`
--

INSERT INTO `stambeni_objekat` (`id_stambenog_objekta`, `vrednost`, `kvadratura`, `ocena`, `id_objekta`, `id_osobe`) VALUES
(1, 10500, 100, 4.5, 1, 5),
(2, 40300, 250, 4, 1, NULL),
(3, 5000, 40, 3.4, 1, 7),
(4, 250600, 300, 5, 1, 1),
(5, 20700, 120, 4.9, 5, NULL),
(6, 5600, 50, 3.9, 1, NULL);

--
-- Indexes for dumped tables
--

--
-- Indexes for table `atmosfera`
--
ALTER TABLE `atmosfera`
  ADD PRIMARY KEY (`id_atmosfere`),
  ADD KEY `atmosfera_ibfk_1` (`id_objekta`);

--
-- Indexes for table `boravak`
--
ALTER TABLE `boravak`
  ADD PRIMARY KEY (`id_boravka`),
  ADD KEY `boravak_ibfk_1` (`id_osobe`),
  ADD KEY `id_objekta` (`id_objekta`);

--
-- Indexes for table `misije`
--
ALTER TABLE `misije`
  ADD PRIMARY KEY (`id_misije`),
  ADD KEY `id_poznatog_objekta` (`id_poznatog_objekta`);

--
-- Indexes for table `objekti`
--
ALTER TABLE `objekti`
  ADD PRIMARY KEY (`id_objekta`),
  ADD KEY `objekti_ibfk_1` (`id_poznatog_objekta`);

--
-- Indexes for table `osobe`
--
ALTER TABLE `osobe`
  ADD PRIMARY KEY (`id_osobe`);

--
-- Indexes for table `person`
--
ALTER TABLE `person`
  ADD PRIMARY KEY (`person_id`);

--
-- Indexes for table `poznati_objekat`
--
ALTER TABLE `poznati_objekat`
  ADD PRIMARY KEY (`id_poznatog_objekta`);

--
-- Indexes for table `smrt`
--
ALTER TABLE `smrt`
  ADD PRIMARY KEY (`id_smrti`),
  ADD KEY `id_osobe` (`id_osobe`);

--
-- Indexes for table `stambeni_objekat`
--
ALTER TABLE `stambeni_objekat`
  ADD PRIMARY KEY (`id_stambenog_objekta`),
  ADD KEY `id_osobe` (`id_osobe`),
  ADD KEY `id_objekta` (`id_objekta`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `atmosfera`
--
ALTER TABLE `atmosfera`
  MODIFY `id_atmosfere` int(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=7;

--
-- AUTO_INCREMENT for table `boravak`
--
ALTER TABLE `boravak`
  MODIFY `id_boravka` int(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT for table `misije`
--
ALTER TABLE `misije`
  MODIFY `id_misije` int(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=7;

--
-- AUTO_INCREMENT for table `objekti`
--
ALTER TABLE `objekti`
  MODIFY `id_objekta` int(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=7;

--
-- AUTO_INCREMENT for table `osobe`
--
ALTER TABLE `osobe`
  MODIFY `id_osobe` int(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=19;

--
-- AUTO_INCREMENT for table `person`
--
ALTER TABLE `person`
  MODIFY `person_id` int(20) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `poznati_objekat`
--
ALTER TABLE `poznati_objekat`
  MODIFY `id_poznatog_objekta` int(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=7;

--
-- AUTO_INCREMENT for table `smrt`
--
ALTER TABLE `smrt`
  MODIFY `id_smrti` int(20) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `stambeni_objekat`
--
ALTER TABLE `stambeni_objekat`
  MODIFY `id_stambenog_objekta` int(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=7;

--
-- Constraints for dumped tables
--

--
-- Constraints for table `atmosfera`
--
ALTER TABLE `atmosfera`
  ADD CONSTRAINT `atmosfera_ibfk_1` FOREIGN KEY (`id_objekta`) REFERENCES `objekti` (`id_objekta`);

--
-- Constraints for table `boravak`
--
ALTER TABLE `boravak`
  ADD CONSTRAINT `boravak_ibfk_1` FOREIGN KEY (`id_osobe`) REFERENCES `osobe` (`id_osobe`),
  ADD CONSTRAINT `boravak_ibfk_2` FOREIGN KEY (`id_objekta`) REFERENCES `objekti` (`id_objekta`);

--
-- Constraints for table `misije`
--
ALTER TABLE `misije`
  ADD CONSTRAINT `misije_ibfk_1` FOREIGN KEY (`id_poznatog_objekta`) REFERENCES `poznati_objekat` (`id_poznatog_objekta`);

--
-- Constraints for table `objekti`
--
ALTER TABLE `objekti`
  ADD CONSTRAINT `objekti_ibfk_1` FOREIGN KEY (`id_poznatog_objekta`) REFERENCES `poznati_objekat` (`id_poznatog_objekta`);

--
-- Constraints for table `smrt`
--
ALTER TABLE `smrt`
  ADD CONSTRAINT `smrt_ibfk_1` FOREIGN KEY (`id_osobe`) REFERENCES `osobe` (`id_osobe`);

--
-- Constraints for table `stambeni_objekat`
--
ALTER TABLE `stambeni_objekat`
  ADD CONSTRAINT `stambeni_objekat_ibfk_1` FOREIGN KEY (`id_osobe`) REFERENCES `osobe` (`id_osobe`),
  ADD CONSTRAINT `stambeni_objekat_ibfk_2` FOREIGN KEY (`id_objekta`) REFERENCES `objekti` (`id_objekta`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
