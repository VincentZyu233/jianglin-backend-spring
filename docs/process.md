
```sql
CREATE DATABASE jianglin;

USE jianglin;

CREATE TABLE banner (
    id INT AUTO_INCREMENT PRIMARY KEY,
    image_data MEDIUMBLOB NOT NULL,
    text VARCHAR(255)
);

CREATE TABLE product (
    id INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(255) NOT NULL,
    description LONGTEXT,
    image_data MEDIUMBLOB NOT NULL
);

ALTER TABLE banner
ADD deleted BOOLEAN DEFAULT FALSE;

ALTER TABLE product
ADD deleted BOOLEAN DEFAULT FALSE;

INSERT INTO banner (image_data, text) VALUES 
  (LOAD_FILE('D:/MySqlData/Uploads/mengbimao.gif'), 'Banner Text 1'),
  (LOAD_FILE('D:/MySqlData/Uploads/mengbimao.gif'), 'Banner Text 2'),
  (LOAD_FILE('D:/MySqlData/Uploads/mengbimao.gif'), 'Banner Text 3');  

INSERT INTO product (name, description, image_data) VALUES 
  ('Product 1', 'Description for Product 1', LOAD_FILE('D:/MySqlData/Uploads/mengbimao.gif')),
  ('Product 2', 'Description for Product 2', LOAD_FILE('D:/MySqlData/Uploads/mengbimao.gif')),
  ('Product 3', 'Description for Product 3', LOAD_FILE('D:/MySqlData/Uploads/mengbimao.gif'));
```



