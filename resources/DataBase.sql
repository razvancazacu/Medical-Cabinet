CREATE TABLE `users` (
                        `user_id` int(11) NOT NULL AUTO_INCREMENT,
                        `username` varchar(16) NOT NULL,
                        `password` varchar(32) NOT NULL,
                        `create_time` timestamp NULL DEFAULT CURRENT_TIMESTAMP,
                        PRIMARY KEY (`user_id`),
                        UNIQUE KEY `username_UNIQUE` (`username`)
);
INSERT INTO `pao-db`.`users`
(`username`,
 `password`
)
VALUES
("dummyPatient1",
 "dummyPassword"
);
INSERT INTO `pao-db`.`users`
(`username`,
 `password`
)
VALUES
("dummyPatient2",
 "dummyPassword"
);
INSERT INTO `pao-db`.`users`
(`username`,
 `password`
)
VALUES
("dummyMedic1",
 "dummyPassword"
);
INSERT INTO `pao-db`.`users`
(`username`,
 `password`
)
VALUES
("dummyMedic2",
 "dummyPassword"
);
