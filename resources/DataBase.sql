CREATE TABLE `clinic` (
                          `clinic_id` int(11) NOT NULL AUTO_INCREMENT,
                          `name` varchar(45) DEFAULT NULL,
                          `country` varchar(45) DEFAULT NULL,
                          `state` varchar(45) DEFAULT NULL,
                          `city` varchar(45) DEFAULT NULL,
                          PRIMARY KEY (`clinic_id`)
);
CREATE TABLE `consultations` (
                                 `consultation_id` int(11) NOT NULL AUTO_INCREMENT,
                                 `medfile_id` int(11) NOT NULL,
                                 `patient_id` int(11) NOT NULL,
                                 `medic_id` int(11) NOT NULL,
                                 `date` date NOT NULL,
                                 `receipt_id` int(11) DEFAULT NULL,
                                 PRIMARY KEY (`consultation_id`)
);
CREATE TABLE `medicdetails` (
                                `username` varchar(45) NOT NULL,
                                `adress` varchar(45) DEFAULT 'none',
                                `DOB` date DEFAULT NULL,
                                `CNP` varchar(45) DEFAULT 'none',
                                `telephone` varchar(45) DEFAULT 'none',
                                `email` varchar(45) DEFAULT 'none',
                                `f_name` varchar(45) DEFAULT 'none',
                                `l_name` varchar(45) DEFAULT 'none',
                                `medical_fiels` varchar(45) DEFAULT 'none',
                                PRIMARY KEY (`username`)
);
CREATE TABLE `medicine` (
                            `medicine_id` int(11) NOT NULL AUTO_INCREMENT,
                            `name` varchar(45) DEFAULT NULL,
                            `prescription` varchar(45) DEFAULT NULL,
                            PRIMARY KEY (`medicine_id`)
);
CREATE TABLE `patientdetails` (
                                  `username` varchar(45) DEFAULT NULL,
                                  `adress` varchar(45) DEFAULT 'none',
                                  `weight` double DEFAULT '-1',
                                  `height` double DEFAULT '-1',
                                  `DOB` date DEFAULT NULL,
                                  `f_name` varchar(45) DEFAULT 'none',
                                  `l_name` varchar(45) DEFAULT 'none',
                                  `CNP` varchar(45) DEFAULT NULL,
                                  `telephone` varchar(45) DEFAULT 'none',
                                  `email` varchar(45) DEFAULT 'none',
                                  `father_f_name` varchar(45) DEFAULT 'none',
                                  `medfile_id` int(11) NOT NULL AUTO_INCREMENT,
                                  PRIMARY KEY (`medfile_id`),
                                  UNIQUE KEY `username_UNIQUE` (`username`)
) ;
CREATE TABLE `users` (
                         `user_id` int(11) NOT NULL AUTO_INCREMENT,
                         `username` varchar(16) NOT NULL,
                         `password` varchar(32) NOT NULL,
                         `create_time` timestamp NULL DEFAULT CURRENT_TIMESTAMP,
                         `clinic_id` int(11) DEFAULT NULL,
                         `account_type` varchar(45) NOT NULL,
                         PRIMARY KEY (`user_id`),
                         UNIQUE KEY `username_UNIQUE` (`username`)
);