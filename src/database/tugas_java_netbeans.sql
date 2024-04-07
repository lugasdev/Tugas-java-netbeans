SET FOREIGN_KEY_CHECKS=0;
SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;


CREATE TABLE `anamnesa` (
  `id` int NOT NULL,
  `registation_id` int NOT NULL,
  `height` int NOT NULL,
  `weight` int NOT NULL,
  `blood_pressure` varchar(10) NOT NULL,
  `temperature` int NOT NULL,
  `is_smoking` tinyint(1) NOT NULL DEFAULT '0',
  `is_alcohol` tinyint(1) NOT NULL DEFAULT '0',
  `disease_history` text,
  `complaint` text,
  `created_at` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

INSERT INTO `anamnesa` (`id`, `registation_id`, `height`, `weight`, `blood_pressure`, `temperature`, `is_smoking`, `is_alcohol`, `disease_history`, `complaint`, `created_at`) VALUES
(1, 6, 170, 69, '110/80', 34, 1, 0, 'sadaswqeqwe', 'wqeqweqw', '2024-04-06 10:35:37');

CREATE TABLE `doctors` (
  `id` int NOT NULL,
  `name` varchar(150) DEFAULT NULL,
  `clinic` varchar(100) DEFAULT NULL,
  `stat` tinyint(1) NOT NULL,
  `created_at` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

INSERT INTO `doctors` (`id`, `name`, `clinic`, `stat`, `created_at`) VALUES
(2, 'Maman Sumanarna', 'Poli Kebidanan & Kandungan', 0, '2024-03-31 06:01:33'),
(3, 'Sugiman', 'Poli Umum', 0, '2024-03-31 06:03:57'),
(4, 'Cendekia Mecca', 'Poli Anak', 1, '2024-03-31 06:49:04'),
(5, 'Amalia Septianti', 'Poli Kebidanan & Kandungan', 1, '2024-03-31 06:53:41'),
(6, 'Ibrahim Oke', 'Poli Kebidanan & Kandungan', 0, '2024-03-31 06:55:36');

CREATE TABLE `patients` (
  `id` int NOT NULL,
  `identity_number` varchar(100) NOT NULL,
  `name` varchar(150) NOT NULL,
  `gender` tinyint(1) NOT NULL,
  `date_of_birth` date NOT NULL,
  `address` text NOT NULL,
  `phone` varchar(15) NOT NULL,
  `created_at` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `blood_type` char(5) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

INSERT INTO `patients` (`id`, `identity_number`, `name`, `gender`, `date_of_birth`, `address`, `phone`, `created_at`, `blood_type`) VALUES
(1, '345612436512', 'Varkhan Ajie', 1, '1996-07-25', 'sidommulto', '6347865427', '2024-04-05 06:31:22', 'B +'),
(2, '321r612346', 'skdjaijsh', 2, '0200-01-30', 'd sadwqe', '67354322', '2024-04-05 07:11:38', 'AB +'),
(3, '3432423', 'asdasdas', 2, '2000-02-24', 'sadwq sadasdq', '54735762', '2024-04-05 07:12:26', 'AB +'),
(4, '131231231', 'dasdasdas', 1, '1996-10-10', 'dsasdwqeqw', '442343242', '2024-04-05 07:12:57', 'A -'),
(5, 'asd21312', 'wqeqwe', 1, '1995-10-10', 'asdw asdqweq', '0852712312', '2024-04-05 07:14:16', 'A -'),
(6, '3124126', 'asdbasbd ', 1, '1990-05-20', 'nasjkd huwqheiuqw', '08572512111', '2024-04-06 05:16:17', 'AB +');

CREATE TABLE `registrations` (
  `id` int NOT NULL,
  `doctor_id` int NOT NULL,
  `patient_id` int NOT NULL,
  `registration_at` datetime NOT NULL,
  `created_at` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `stat` tinyint(1) NOT NULL DEFAULT '0'
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

INSERT INTO `registrations` (`id`, `doctor_id`, `patient_id`, `registration_at`, `created_at`, `stat`) VALUES
(1, 4, 1, '2024-04-05 08:29:00', '2024-04-05 06:31:22', 0),
(2, 5, 2, '2024-04-05 07:11:00', '2024-04-05 07:11:38', 0),
(3, 5, 3, '2024-04-05 07:30:00', '2024-04-05 07:12:26', 0),
(4, 4, 4, '2024-04-05 07:12:00', '2024-04-05 07:12:57', 0),
(5, 5, 5, '2024-04-05 07:14:00', '2024-04-05 07:14:16', 0),
(6, 4, 6, '2024-04-06 12:15:00', '2024-04-06 05:16:17', 1);

CREATE TABLE `users` (
  `id` int NOT NULL,
  `username` varchar(150) NOT NULL,
  `password` varchar(150) NOT NULL,
  `created_at` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

INSERT INTO `users` (`id`, `username`, `password`, `created_at`) VALUES
(1, 'kia', '3a40ba938a827532b984662a0329ba618653', '2024-03-30 09:30:39');


ALTER TABLE `anamnesa`
  ADD PRIMARY KEY (`id`),
  ADD KEY `reg_foreign` (`registation_id`);

ALTER TABLE `doctors`
  ADD PRIMARY KEY (`id`);

ALTER TABLE `patients`
  ADD PRIMARY KEY (`id`);

ALTER TABLE `registrations`
  ADD PRIMARY KEY (`id`),
  ADD KEY `patient_id` (`patient_id`),
  ADD KEY `doctor_id` (`doctor_id`);

ALTER TABLE `users`
  ADD PRIMARY KEY (`id`);


ALTER TABLE `anamnesa`
  MODIFY `id` int NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

ALTER TABLE `doctors`
  MODIFY `id` int NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=9;

ALTER TABLE `patients`
  MODIFY `id` int NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=7;

ALTER TABLE `registrations`
  MODIFY `id` int NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=7;

ALTER TABLE `users`
  MODIFY `id` int NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;


ALTER TABLE `anamnesa`
  ADD CONSTRAINT `reg_foreign` FOREIGN KEY (`registation_id`) REFERENCES `registrations` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT;
SET FOREIGN_KEY_CHECKS=1;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
