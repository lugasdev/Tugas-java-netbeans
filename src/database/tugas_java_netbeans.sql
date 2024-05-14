SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;


DROP TABLE IF EXISTS `anamnesa`;
CREATE TABLE `anamnesa` (
  `id` int NOT NULL,
  `registration_id` int NOT NULL,
  `height` int NOT NULL,
  `weight` int NOT NULL,
  `blood_pressure` varchar(10) NOT NULL,
  `temperature` int NOT NULL,
  `is_smoking` tinyint(1) NOT NULL DEFAULT '0',
  `is_alcohol` tinyint(1) NOT NULL DEFAULT '0',
  `disease_history` text,
  `complaint` text,
  `created_at` datetime DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

INSERT INTO `anamnesa` (`id`, `registration_id`, `height`, `weight`, `blood_pressure`, `temperature`, `is_smoking`, `is_alcohol`, `disease_history`, `complaint`, `created_at`) VALUES
(2, 7, 159, 65, '110/85', 36, 1, 0, 'oasdasbndiua riwa', 'asnjidohasiod askdhasjiod \nkelu', '2024-04-08 06:07:13'),
(3, 11, 165, 60, '110/90', 36, 0, 0, '', 'sakit leher', '2024-05-02 21:45:00');

DROP TABLE IF EXISTS `doctors`;
CREATE TABLE `doctors` (
  `id` int NOT NULL,
  `name` varchar(150) DEFAULT NULL,
  `clinic` varchar(100) DEFAULT NULL,
  `stat` tinyint(1) NOT NULL,
  `created_at` datetime DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

INSERT INTO `doctors` (`id`, `name`, `clinic`, `stat`, `created_at`) VALUES
(2, 'Maman Sumanarna', 'Poli Kebidanan & Kandungan', 0, '2024-03-31 06:01:33'),
(3, 'Sugiman', 'Poli Umum', 0, '2024-03-31 06:03:57'),
(4, 'Cendekia Mecca', 'Poli Anak', 1, '2024-03-31 06:49:04'),
(5, 'Amalia Septianti', 'Poli Kebidanan & Kandungan', 1, '2024-03-31 06:53:41'),
(6, 'Ibrahim Oke', 'Poli Kebidanan & Kandungan', 0, '2024-03-31 06:55:36');

DROP TABLE IF EXISTS `medical_records`;
CREATE TABLE `medical_records` (
  `id` int NOT NULL,
  `registration_id` int NOT NULL,
  `physical` text NOT NULL,
  `diagnosis` text NOT NULL,
  `therapy` text NOT NULL,
  `created_at` datetime NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

INSERT INTO `medical_records` (`id`, `registration_id`, `physical`, `diagnosis`, `therapy`, `created_at`) VALUES
(1, 0, 'asdsad\nqweqweasd \nfisik', 'asd asdklqweb\nasdas\ndiagnosis', 'asdnjias daseiqwuge\n\nterapi', '2024-04-08 07:02:40'),
(2, 11, '', 'asam urat', 'obat', '2024-05-02 21:45:17');

DROP TABLE IF EXISTS `medicines`;
CREATE TABLE `medicines` (
  `id` int NOT NULL,
  `name` varchar(45) DEFAULT NULL,
  `created_at` datetime DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;

INSERT INTO `medicines` (`id`, `name`, `created_at`) VALUES
(1, 'Antihistamin', '2024-04-27 17:06:11'),
(2, 'Analgesik', '2024-04-27 17:06:11'),
(3, 'Antasida', '2024-04-27 17:06:39'),
(4, 'Antipiretik', '2024-04-27 17:06:39'),
(5, 'Paracetamol', '2024-04-27 17:07:06'),
(6, 'Metformin', '2024-04-27 17:07:06'),
(7, 'Antibiotik', '2024-05-14 22:34:51');

DROP TABLE IF EXISTS `pasien_tugas`;
CREATE TABLE `pasien_tugas` (
  `id` char(50) NOT NULL,
  `nama` varchar(150) NOT NULL,
  `alamat` text NOT NULL,
  `goldar` char(3) NOT NULL,
  `jk` varchar(10) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

INSERT INTO `pasien_tugas` (`id`, `nama`, `alamat`, `goldar`, `jk`) VALUES
('2463252', 'Veronica Pokemon', 'asdas\n21312', 'O', 'Perempuan'),
('64783264726', 'Gigi Sugigi', 'asdas\nqweqweqw\n97483 update', 'A', 'Perempuan');

DROP TABLE IF EXISTS `patients`;
CREATE TABLE `patients` (
  `id` int NOT NULL,
  `identity_number` varchar(100) NOT NULL,
  `name` varchar(150) NOT NULL,
  `gender` tinyint(1) NOT NULL,
  `date_of_birth` date NOT NULL,
  `address` text NOT NULL,
  `phone` varchar(15) NOT NULL,
  `created_at` datetime NOT NULL,
  `blood_type` char(5) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

INSERT INTO `patients` (`id`, `identity_number`, `name`, `gender`, `date_of_birth`, `address`, `phone`, `created_at`, `blood_type`) VALUES
(1, '345612436512', 'Varkhan Ajie', 1, '1996-07-25', 'sidommulto', '6347865427', '2024-04-05 06:31:22', 'B +'),
(2, '321r612346', 'Siti Tanah', 1, '1991-03-05', 'd sadwqe', '08572121231', '2024-04-05 07:11:38', 'A -'),
(3, '343242311', 'asdasdas1', 1, '2000-02-21', 'sadwq sadasdq 1', '54735761', '2024-04-05 07:12:26', 'B+'),
(4, '131231231', 'dasdasdas', 1, '1996-10-10', 'dsasdwqeqw', '442343242', '2024-04-05 07:12:57', 'A -'),
(6, '3124126', 'asdbasbd ', 1, '1990-05-20', 'nasjkd huwqheiuqw', '08572512111', '2024-04-06 05:16:17', 'AB +'),
(7, '2131231231', 'asddasdqw', 1, '1967-07-25', 'asd asd as', '1231231', '2024-04-08 06:06:17', 'B +'),
(8, '12321312312', 'sdasdasdas', 1, '1997-06-19', 'asdas dsaedqweqw', '12312312', '2024-04-08 11:13:10', 'AB +'),
(9, '624623647237', 'Eci Dita', 1, '1990-02-11', 'sad sadqwe\nasdas', '085725008001', '2024-04-16 14:31:00', 'A +'),
(10, '111211', 'Go Lang', 1, '1995-02-16', 'asd sadqwe\nadsad', '085725008014', '2024-04-27 17:17:17', 'A -'),
(11, '12312', 'wahyu', 1, '1990-02-26', 'sad jaktim', '085725008014', '2024-05-02 21:44:32', 'A -'),
(14, '212121', 'Malam Hari Saja', 2, '1984-07-17', 'alamat 17 jul 84', '13126351273', '2024-05-03 23:52:09', 'B +'),
(15, '1232131231', 'saman', 1, '1986-03-11', 'jaktim', '085724123123', '2024-05-14 21:36:11', 'A +');

DROP TABLE IF EXISTS `prescriptions`;
CREATE TABLE `prescriptions` (
  `id` int NOT NULL,
  `registration_id` int DEFAULT NULL,
  `medicine_id` int DEFAULT NULL,
  `name` varchar(150) DEFAULT NULL,
  `dose` varchar(100) DEFAULT NULL,
  `note` text NOT NULL,
  `created_at` datetime NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

INSERT INTO `prescriptions` (`id`, `registration_id`, `medicine_id`, `name`, `dose`, `note`, `created_at`) VALUES
(1, 7, 1, 'Antihistamin', '3x1 setelah makan ', 'dikonsumsi 1 minggu x', '2024-04-09 10:46:01'),
(5, 7, 7, 'antibiotik', '2x1', 'sebelum makan, dikonsumsi sampai habis', '2024-04-09 10:51:01'),
(6, 11, 6, 'Metformin', '1x1', 'setelah sarapan', '2024-05-02 22:02:15'),
(7, 7, 4, 'Antipiretik', '2x1', 'setelah sarapan dan makan malam', '2024-05-14 22:55:51');

DROP TABLE IF EXISTS `registrations`;
CREATE TABLE `registrations` (
  `id` int NOT NULL,
  `doctor_id` int NOT NULL,
  `patient_id` int NOT NULL,
  `registration_at` datetime NOT NULL,
  `created_at` datetime NOT NULL,
  `stat` tinyint(1) NOT NULL DEFAULT '0'
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

INSERT INTO `registrations` (`id`, `doctor_id`, `patient_id`, `registration_at`, `created_at`, `stat`) VALUES
(1, 4, 1, '2024-04-05 08:29:00', '2024-04-05 06:31:22', 0),
(2, 5, 2, '2024-04-05 07:11:00', '2024-04-05 07:11:38', 0),
(3, 5, 3, '2024-04-05 07:30:00', '2024-04-05 07:12:26', 0),
(4, 4, 4, '2024-04-05 07:12:00', '2024-04-05 07:12:57', 0),
(7, 4, 1, '2024-06-10 16:05:00', '2024-04-08 06:06:17', 2),
(9, 5, 9, '2024-04-16 16:30:00', '2024-04-16 14:31:00', 0),
(10, 5, 10, '2024-04-27 18:00:00', '2024-04-27 17:17:18', 0),
(11, 4, 11, '2024-05-02 21:42:00', '2024-05-02 21:44:33', 2),
(12, 4, 14, '2024-06-30 20:52:00', '2024-05-03 23:52:09', 0),
(13, 5, 2, '2024-05-08 15:00:00', '2024-05-07 22:30:06', 0),
(14, 5, 15, '2024-05-15 10:30:00', '2024-05-14 21:36:11', 0);

DROP TABLE IF EXISTS `users`;
CREATE TABLE `users` (
  `id` int NOT NULL,
  `username` varchar(150) NOT NULL,
  `password` varchar(150) NOT NULL,
  `created_at` datetime DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

INSERT INTO `users` (`id`, `username`, `password`, `created_at`) VALUES
(1, 'kia', '3a40ba938a827532b984662a0329ba618653', '2024-03-30 09:30:39');


ALTER TABLE `anamnesa`
  ADD PRIMARY KEY (`id`),
  ADD KEY `reg_foreign` (`registration_id`);

ALTER TABLE `doctors`
  ADD PRIMARY KEY (`id`);

ALTER TABLE `medical_records`
  ADD PRIMARY KEY (`id`),
  ADD KEY `fk_medical_records_registrations1_idx` (`registration_id`);

ALTER TABLE `medicines`
  ADD PRIMARY KEY (`id`);

ALTER TABLE `pasien_tugas`
  ADD PRIMARY KEY (`id`);

ALTER TABLE `patients`
  ADD PRIMARY KEY (`id`);

ALTER TABLE `prescriptions`
  ADD PRIMARY KEY (`id`),
  ADD KEY `fk_prescriptions_registrations1_idx` (`registration_id`),
  ADD KEY `fk_prescriptions_medicines1_idx` (`medicine_id`);

ALTER TABLE `registrations`
  ADD PRIMARY KEY (`id`),
  ADD KEY `doctor_id` (`doctor_id`),
  ADD KEY `patient_id` (`patient_id`);

ALTER TABLE `users`
  ADD PRIMARY KEY (`id`);


ALTER TABLE `anamnesa`
  MODIFY `id` int NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

ALTER TABLE `doctors`
  MODIFY `id` int NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=7;

ALTER TABLE `medical_records`
  MODIFY `id` int NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

ALTER TABLE `medicines`
  MODIFY `id` int NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=8;

ALTER TABLE `patients`
  MODIFY `id` int NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=16;

ALTER TABLE `prescriptions`
  MODIFY `id` int NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=10;

ALTER TABLE `registrations`
  MODIFY `id` int NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=15;

ALTER TABLE `users`
  MODIFY `id` int NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;


ALTER TABLE `anamnesa`
  ADD CONSTRAINT `anamnesa_ibfk_1` FOREIGN KEY (`registration_id`) REFERENCES `registrations` (`id`) ON DELETE CASCADE ON UPDATE CASCADE;

ALTER TABLE `medical_records`
  ADD CONSTRAINT `fk_medical_records_registrations1` FOREIGN KEY (`registration_id`) REFERENCES `registrations` (`id`) ON DELETE CASCADE ON UPDATE CASCADE;

ALTER TABLE `prescriptions`
  ADD CONSTRAINT `fk_prescriptions_medicines1` FOREIGN KEY (`medicine_id`) REFERENCES `medicines` (`id`),
  ADD CONSTRAINT `fk_prescriptions_registrations1` FOREIGN KEY (`registration_id`) REFERENCES `registrations` (`id`) ON DELETE CASCADE ON UPDATE CASCADE;

ALTER TABLE `registrations`
  ADD CONSTRAINT `registrations_ibfk_1` FOREIGN KEY (`doctor_id`) REFERENCES `doctors` (`id`),
  ADD CONSTRAINT `registrations_ibfk_2` FOREIGN KEY (`patient_id`) REFERENCES `patients` (`id`) ON DELETE CASCADE ON UPDATE CASCADE;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
