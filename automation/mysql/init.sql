USE jianglin;

CREATE TABLE banner (
                        id INT AUTO_INCREMENT PRIMARY KEY,
                        image_path VARCHAR(255) NOT NULL,
                        text VARCHAR(255),
                        deleted BOOLEAN DEFAULT FALSE
);

CREATE TABLE product (
                         id INT AUTO_INCREMENT PRIMARY KEY,
                         name VARCHAR(255) NOT NULL,
                         description LONGTEXT,
                         image_path VARCHAR(255) NOT NULL
                             deleted BOOLEAN DEFAULT FALSE;
);