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
  image_path VARCHAR(255), -- 产品图片URL
  type_id INT, FOREIGN KEY (type_id) REFERENCES type(id) -- 设置外键，引用分类表的ID
  deleted BOOLEAN DEFAULT FALSE;
);

CREATE TABLE wx_user (
    open_id VARCHAR(255) PRIMARY KEY,
    wx_avatar_path VARCHAR(255),
    wx_gender VARCHAR(100),
    name VARCHAR(100),
    phone VARCHAR(20)
);

CREATE TABLE appointment (
    id INT AUTO_INCREMENT PRIMARY KEY, -- 预约编号
    appointment_time DATETIME NOT NULL, -- 预约时间
    user_open_id VARCHAR(255) NOT NULL, -- 用户openid
    FOREIGN KEY (user_open_id) REFERENCES wx_user(open_id)
);

CREATE TABLE message (
    id INT AUTO_INCREMENT PRIMARY KEY,
    user_open_id VARCHAR(255),
    message_content TEXT,
    message_time DATETIME,
    deleted BOOLEAN DEFAULT FALSE,
    FOREIGN KEY (user_open_id) REFERENCES wx_user(open_id)
);

CREATE TABLE work_favorite(
    id INT AUTO_INCREMENT PRIMARY KEY,
    user_open_id VARCHAR(255),
    work_id BIGINT,
    FOREIGN KEY (user_open_id) REFERENCES wx_user(open_id),
    FOREIGN KEY (work_id) REFERENCES work(id)
);




-- clothingCategory服装分类表
CREATE TABLE clothing_category (
    clothing_category_id BIGINT AUTO_INCREMENT PRIMARY KEY,
    category_name VARCHAR(255) NOT NULL,
    deleted BOOLEAN DEFAULT FALSE
);

-- clothing服装表
CREATE TABLE clothing (
    clothing_id BIGINT AUTO_INCREMENT PRIMARY KEY,
    clothing_name VARCHAR(255) NOT NULL,
    clothing_description TEXT,
    deleted BOOLEAN DEFAULT FALSE
);

-- clothingImage服装图片表
CREATE TABLE clothing_image (
    clothing_image_id BIGINT AUTO_INCREMENT PRIMARY KEY,
    image_path VARCHAR(255) NOT NULL,
    deleted BOOLEAN DEFAULT FALSE
);

-- clothingCategoryMapping服装分类对应表
CREATE TABLE clothing_category_mapping (
    clothing_category_mapping_id BIGINT AUTO_INCREMENT PRIMARY KEY,
    clothing_id BIGINT NOT NULL,
    category_id BIGINT NOT NULL,
    deleted BOOLEAN DEFAULT FALSE,
    FOREIGN KEY (clothing_id) REFERENCES clothing(clothing_id),
    FOREIGN KEY (category_id) REFERENCES clothing_category(clothing_category_id)
);

-- clothingImageMapping服装图片对应表
CREATE TABLE clothing_image_mapping (
    clothing_image_mapping_id BIGINT AUTO_INCREMENT PRIMARY KEY,
    clothing_id BIGINT NOT NULL,
    image_id BIGINT NOT NULL,
    deleted BOOLEAN DEFAULT FALSE,
    FOREIGN KEY (clothing_id) REFERENCES clothing(clothing_id),
    FOREIGN KEY (image_id) REFERENCES clothing_image(clothing_image_id)
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


INSERT INTO wx_user (open_id, wx_avatar_path, wx_gender, name, phone) VALUES
('openid1', 'https://example.com/avatar1.jpg', '0', 'Alice', '1234567890'),
('openid2', 'https://example.com/avatar2.jpg', '1', 'Bob', '0987654321'),
('openid3', 'https://example.com/avatar3.jpg', '0', 'Charlie', '1122334455'),
('openid4', 'https://example.com/avatar4.jpg', '1', 'David', '6677889900'),
('openid5', 'https://example.com/avatar5.jpg', '0', 'Eve', '5566778899');

INSERT INTO appointment (appointment_time, user_open_id)
VALUES
    ('2024-07-01 10:00:00', 'openid1'),
    ('2024-07-02 14:30:00', 'openid2'),
    ('2024-07-03 08:45:00', 'openid3'),
    ('2024-07-04 11:15:00', 'openid4'),
    ('2024-07-05 13:00:00', 'openid1'),
    ('2024-07-06 09:30:00', 'openid2'),
    ('2024-07-07 15:20:00', 'openid3'),
    ('2024-07-08 12:00:00', 'openid4'),
    ('2024-07-09 16:45:00', 'openid1'),
    ('2024-07-10 10:30:00', 'openid2');


INSERT INTO message (user_open_id, message_content, message_time) VALUES
('openid1', '这是来自 openid1 的第一条测试留言', '2024-06-27 10:00:00'),
('openid2', '这是来自 openid2 的第二条测试留言', '2024-06-27 10:05:00'),
('openid3', '这是来自 openid3 的第三条测试留言', '2024-06-27 10:10:00'),
('openid4', '这是来自 openid4 的第四条测试留言', '2024-06-27 10:15:00'),
('openid1', '这是来自 openid1 的第五条测试留言', '2024-06-27 10:20:00'),
('openid2', '这是来自 openid2 的第六条测试留言', '2024-06-27 10:25:00'),
('openid3', '这是来自 openid3 的第七条测试留言', '2024-06-27 10:30:00'),
('openid4', '这是来自 openid4 的第八条测试留言', '2024-06-27 10:35:00'),
('openid1', '这是来自 openid1 的第九条测试留言', '2024-06-27 10:40:00'),
('openid2', '这是来自 openid2 的第十条测试留言', '2024-06-27 10:45:00');


```






