-- phpMyAdmin SQL Dump
-- version 5.0.4
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Waktu pembuatan: 08 Jan 2021 pada 10.41
-- Versi server: 10.4.14-MariaDB
-- Versi PHP: 7.4.11

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `guild`
--

-- --------------------------------------------------------

--
-- Struktur dari tabel `hunter`
--

CREATE TABLE `hunter` (
  `id` int(11) NOT NULL,
  `name` varchar(128) NOT NULL,
  `rank` varchar(2) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data untuk tabel `hunter`
--

INSERT INTO `hunter` (`id`, `name`, `rank`) VALUES
(1, 'Natsu Dragneel', 'S'),
(2, 'Erza Scarlet', 'S');

-- --------------------------------------------------------

--
-- Struktur dari tabel `quest`
--

CREATE TABLE `quest` (
  `id` int(11) NOT NULL,
  `title` varchar(128) NOT NULL,
  `rank` varchar(2) NOT NULL,
  `type` varchar(128) NOT NULL,
  `maxhunter` int(11) NOT NULL,
  `minpower` int(11) NOT NULL,
  `reward` double NOT NULL,
  `availability` varchar(128) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data untuk tabel `quest`
--

INSERT INTO `quest` (`id`, `title`, `rank`, `type`, `maxhunter`, `minpower`, `reward`, `availability`) VALUES
(2, 'Escort Goods', 'C', 'Escort', 1, 20, 0.05, 'Available'),
(12, 'Hunt Shark', 'S', 'Subjugation', 5, 70, 10, 'Available');

-- --------------------------------------------------------

--
-- Struktur dari tabel `users`
--

CREATE TABLE `users` (
  `id` int(11) NOT NULL,
  `name` varchar(128) NOT NULL,
  `username` varchar(128) NOT NULL,
  `password` varchar(128) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data untuk tabel `users`
--

INSERT INTO `users` (`id`, `name`, `username`, `password`) VALUES
(1, 'admin', 'admin', '21232f297a57a5a743894a0e4a801fc3'),
(2, 'mirajane', 'mirajane', '7926ef2e2d112a3ed9c340f4694da479');

--
-- Indexes for dumped tables
--

--
-- Indeks untuk tabel `hunter`
--
ALTER TABLE `hunter`
  ADD PRIMARY KEY (`id`);

--
-- Indeks untuk tabel `quest`
--
ALTER TABLE `quest`
  ADD PRIMARY KEY (`id`);

--
-- Indeks untuk tabel `users`
--
ALTER TABLE `users`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT untuk tabel yang dibuang
--

--
-- AUTO_INCREMENT untuk tabel `hunter`
--
ALTER TABLE `hunter`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT untuk tabel `users`
--
ALTER TABLE `users`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
