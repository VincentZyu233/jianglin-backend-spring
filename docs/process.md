```roomsql

CREATE DATABASE jianglin;

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

-- 创建产品分类表 type
CREATE TABLE type (
  id INT AUTO_INCREMENT PRIMARY KEY, -- 分类ID，自增主键
  category_name VARCHAR(255) NOT NULL, -- 分类名
  category_description TEXT -- 分类描述
  deleted BOOLEAN DEFAULT FALSE;
);

-- 创建产品表 work
CREATE TABLE work (
  id INT AUTO_INCREMENT PRIMARY KEY, -- 产品ID，自增主键
  work_name VARCHAR(255) NOT NULL, -- 产品名
  work_image_url VARCHAR(255), -- 产品图片URL
  type_id INT, FOREIGN KEY (type_id) REFERENCES type(id) -- 设置外键，引用分类表的ID
  deleted BOOLEAN DEFAULT FALSE;
);


-- 插入 banner 表数据
INSERT INTO banner (image_path, text) VALUES 
  ('/path/to/images/banner1.gif', 'Banner Text 1'),
  ('/path/to/images/banner2.gif', 'Banner Text 2'),
  ('/path/to/images/banner3.gif', 'Banner Text 3'),
  ('/path/to/images/banner4.gif', 'Banner Text 4'),
  ('/path/to/images/banner5.gif', 'Banner Text 5');

-- 插入 product 表数据
INSERT INTO product (name, description, image_path) VALUES 
  ('Product 1', 'Description for Product 1', '/path/to/images/product1.gif'),
  ('Product 2', 'Description for Product 2', '/path/to/images/product2.gif'),
  ('Product 3', 'Description for Product 3', '/path/to/images/product3.gif'),
  ('Product 4', 'Description for Product 4', '/path/to/images/product4.gif'),
  ('Product 5', 'Description for Product 5', '/path/to/images/product5.gif');




```