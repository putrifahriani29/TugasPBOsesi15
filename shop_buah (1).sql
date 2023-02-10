-- phpMyAdmin SQL Dump
-- version 5.1.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Feb 03, 2023 at 04:02 AM
-- Server version: 10.4.22-MariaDB
-- PHP Version: 8.1.2

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `shop_buah`
--

-- --------------------------------------------------------

--
-- Table structure for table `tbl_admin`
--

CREATE TABLE `tbl_admin` (
  `id_admin` char(10) NOT NULL,
  `username` varchar(100) NOT NULL,
  `password` char(25) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `tbl_admin`
--

INSERT INTO `tbl_admin` (`id_admin`, `username`, `password`) VALUES
('A001', 'Ahmad busaeri', 'ahmad123'),
('A002', 'Ali', 'ali123');

-- --------------------------------------------------------

--
-- Table structure for table `tbl_buah_sb`
--

CREATE TABLE `tbl_buah_sb` (
  `kd_buah` char(25) NOT NULL,
  `nama_buah` varchar(50) NOT NULL,
  `harga` int(25) NOT NULL,
  `QTY` int(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `tbl_buah_sb`
--

INSERT INTO `tbl_buah_sb` (`kd_buah`, `nama_buah`, `harga`, `QTY`) VALUES
('b-001', 'rambutan', 6000, 50),
('b-002', 'jambu', 15000, 25),
('b-003', 'manggis', 10000, 25),
('b-004', 'Durian', 50000, 25),
('b-005', 'semangka', 18000, 10),
('b-006', 'mangga', 12000, 12);

-- --------------------------------------------------------

--
-- Table structure for table `tbl_transaksi`
--

CREATE TABLE `tbl_transaksi` (
  `kd_transaksi` char(25) NOT NULL,
  `id_admin` char(10) NOT NULL,
  `kd_buah` char(25) NOT NULL,
  `tanggal` date NOT NULL,
  `QTY` int(100) NOT NULL,
  `Total_Harga` int(25) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `tbl_transaksi`
--

INSERT INTO `tbl_transaksi` (`kd_transaksi`, `id_admin`, `kd_buah`, `tanggal`, `QTY`, `Total_Harga`) VALUES
('1673eab', 'A001', 'b-006', '2023-02-02', 20, 240000),
('2fe080a', 'A001', 'b-003', '2023-02-01', 3, 30000),
('3a2a04b', 'A001', 'b-004', '2023-02-02', 2, 100000),
('3da5046', 'A001', 'b-003', '2023-02-02', 4, 40000),
('ca0d9b2', 'A001', 'b-005', '2023-02-02', 4, 72000);

--
-- Indexes for dumped tables
--

--
-- Indexes for table `tbl_admin`
--
ALTER TABLE `tbl_admin`
  ADD PRIMARY KEY (`id_admin`);

--
-- Indexes for table `tbl_buah_sb`
--
ALTER TABLE `tbl_buah_sb`
  ADD PRIMARY KEY (`kd_buah`);

--
-- Indexes for table `tbl_transaksi`
--
ALTER TABLE `tbl_transaksi`
  ADD PRIMARY KEY (`kd_transaksi`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
