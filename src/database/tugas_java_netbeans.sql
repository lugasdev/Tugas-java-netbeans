-- Adminer 4.6.3 MySQL dump

SET NAMES utf8;
SET time_zone = '+00:00';
SET foreign_key_checks = 0;
SET sql_mode = 'NO_AUTO_VALUE_ON_ZERO';

DROP TABLE IF EXISTS `anamnesa`;
CREATE TABLE `anamnesa` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `registration_id` int(11) NOT NULL,
  `height` int(11) NOT NULL,
  `weight` int(11) NOT NULL,
  `blood_pressure` varchar(10) NOT NULL,
  `temperature` int(11) NOT NULL,
  `is_smoking` tinyint(1) NOT NULL DEFAULT '0',
  `is_alcohol` tinyint(1) NOT NULL DEFAULT '0',
  `disease_history` text,
  `complaint` text,
  `created_at` datetime DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `reg_foreign` (`registration_id`),
  CONSTRAINT `anamnesa_ibfk_1` FOREIGN KEY (`registration_id`) REFERENCES `registrations` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=latin1;

INSERT INTO `anamnesa` (`id`, `registration_id`, `height`, `weight`, `blood_pressure`, `temperature`, `is_smoking`, `is_alcohol`, `disease_history`, `complaint`, `created_at`) VALUES
(1,	6,	170,	69,	'110/80',	34,	1,	0,	'sadaswqeqwe',	'wqeqweqw',	'2024-04-06 10:35:37'),
(2,	7,	159,	65,	'110/85',	36,	1,	0,	'oasdasbndiua riwa',	'asnjidohasiod askdhasjiod \nkelu',	'2024-04-08 06:07:13');

DROP TABLE IF EXISTS `doctors`;
CREATE TABLE `doctors` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(150) DEFAULT NULL,
  `clinic` varchar(100) DEFAULT NULL,
  `stat` tinyint(1) NOT NULL,
  `created_at` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=latin1;

INSERT INTO `doctors` (`id`, `name`, `clinic`, `stat`, `created_at`) VALUES
(2,	'Maman Sumanarna',	'Poli Kebidanan & Kandungan',	0,	'2024-03-31 06:01:33'),
(3,	'Sugiman',	'Poli Umum',	0,	'2024-03-31 06:03:57'),
(4,	'Cendekia Mecca',	'Poli Anak',	1,	'2024-03-31 06:49:04'),
(5,	'Amalia Septianti',	'Poli Kebidanan & Kandungan',	1,	'2024-03-31 06:53:41'),
(6,	'Ibrahim Oke',	'Poli Kebidanan & Kandungan',	0,	'2024-03-31 06:55:36');

DROP TABLE IF EXISTS `medical_records`;
CREATE TABLE `medical_records` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `registration_id` int(11) NOT NULL,
  `physical` text NOT NULL,
  `diagnosis` text NOT NULL,
  `therapy` text NOT NULL,
  `created_at` datetime NOT NULL,
  PRIMARY KEY (`id`),
  KEY `registration_id` (`registration_id`)
) ENGINE=MyISAM AUTO_INCREMENT=2 DEFAULT CHARSET=latin1;

INSERT INTO `medical_records` (`id`, `registration_id`, `physical`, `diagnosis`, `therapy`, `created_at`) VALUES
(1,	7,	'asdsad\nqweqweasd \nfisik',	'asd asdklqweb\nasdas\ndiagnosis',	'asdnjias daseiqwuge\n\nterapi',	'2024-04-08 07:02:40');

DROP TABLE IF EXISTS `patients`;
CREATE TABLE `patients` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `identity_number` varchar(100) NOT NULL,
  `name` varchar(150) NOT NULL,
  `gender` tinyint(1) NOT NULL,
  `date_of_birth` date NOT NULL,
  `address` text NOT NULL,
  `phone` varchar(15) NOT NULL,
  `created_at` datetime NOT NULL,
  `blood_type` char(5) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=latin1;

INSERT INTO `patients` (`id`, `identity_number`, `name`, `gender`, `date_of_birth`, `address`, `phone`, `created_at`, `blood_type`) VALUES
(1,	'345612436512',	'Varkhan Ajie',	1,	'1996-07-25',	'sidommulto',	'6347865427',	'2024-04-05 06:31:22',	'B +'),
(2,	'321r612346',	'skdjaijsh',	2,	'0200-01-30',	'd sadwqe',	'67354322',	'2024-04-05 07:11:38',	'AB +'),
(3,	'3432423',	'asdasdas',	2,	'2000-02-24',	'sadwq sadasdq',	'54735762',	'2024-04-05 07:12:26',	'AB +'),
(4,	'131231231',	'dasdasdas',	1,	'1996-10-10',	'dsasdwqeqw',	'442343242',	'2024-04-05 07:12:57',	'A -'),
(5,	'asd21312',	'wqeqwe',	1,	'1995-10-10',	'asdw asdqweq',	'0852712312',	'2024-04-05 07:14:16',	'A -'),
(6,	'3124126',	'asdbasbd ',	1,	'1990-05-20',	'nasjkd huwqheiuqw',	'08572512111',	'2024-04-06 05:16:17',	'AB +'),
(7,	'2131231231',	'asddasdqw',	1,	'1967-07-25',	'asd asd as',	'1231231',	'2024-04-08 06:06:17',	'B +');

DROP TABLE IF EXISTS `registrations`;
CREATE TABLE `registrations` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `doctor_id` int(11) NOT NULL,
  `patient_id` int(11) NOT NULL,
  `registration_at` datetime NOT NULL,
  `created_at` datetime NOT NULL,
  `stat` tinyint(1) NOT NULL DEFAULT '0',
  PRIMARY KEY (`id`),
  KEY `doctor_id` (`doctor_id`),
  KEY `patient_id` (`patient_id`),
  CONSTRAINT `registrations_ibfk_1` FOREIGN KEY (`doctor_id`) REFERENCES `doctors` (`id`),
  CONSTRAINT `registrations_ibfk_2` FOREIGN KEY (`patient_id`) REFERENCES `patients` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=latin1;

INSERT INTO `registrations` (`id`, `doctor_id`, `patient_id`, `registration_at`, `created_at`, `stat`) VALUES
(1,	4,	1,	'2024-04-05 08:29:00',	'2024-04-05 06:31:22',	0),
(2,	5,	2,	'2024-04-05 07:11:00',	'2024-04-05 07:11:38',	0),
(3,	5,	3,	'2024-04-05 07:30:00',	'2024-04-05 07:12:26',	0),
(4,	4,	4,	'2024-04-05 07:12:00',	'2024-04-05 07:12:57',	0),
(5,	5,	5,	'2024-04-05 07:14:00',	'2024-04-05 07:14:16',	0),
(6,	4,	6,	'2024-04-06 12:15:00',	'2024-04-06 05:16:17',	1),
(7,	4,	7,	'2024-04-08 15:05:00',	'2024-04-08 06:06:17',	2);

DROP TABLE IF EXISTS `users`;
CREATE TABLE `users` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(150) NOT NULL,
  `password` varchar(150) NOT NULL,
  `created_at` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=latin1;

INSERT INTO `users` (`id`, `username`, `password`, `created_at`) VALUES
(1,	'kia',	'3a40ba938a827532b984662a0329ba618653',	'2024-03-30 09:30:39');

-- 2024-04-08 00:25:51
