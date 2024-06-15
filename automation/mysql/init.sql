USE jianglin;

CREATE TABLE banner (
                        id INT AUTO_INCREMENT PRIMARY KEY,
                        image_data MEDIUMBLOB NOT NULL,
                        text VARCHAR(255),
                        deleted BOOLEAN DEFAULT FALSE
);

CREATE TABLE product (
                         id INT AUTO_INCREMENT PRIMARY KEY,
                         name VARCHAR(255) NOT NULL,
                         description LONGTEXT,
                         image_data MEDIUMBLOB NOT NULL,
                         deleted BOOLEAN DEFAULT FALSE;
);