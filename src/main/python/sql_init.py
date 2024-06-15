import subprocess

def install_mysql():
    # 安装MySQL
    subprocess.run(['sudo', 'apt', 'update'])
    subprocess.run(['sudo', 'apt', 'install', 'mysql-server', '-y'])

def start_mysql():
    # 启动MySQL服务
    subprocess.run(['sudo', 'systemctl', 'start', 'mysql'])

def enable_mysql_autostart():
    # 设置MySQL在系统启动时自动启动
    subprocess.run(['sudo', 'systemctl', 'enable', 'mysql'])

def login_mysql():
    # 登录MySQL，设置root用户密码
    mysql_password = 'diding2014'
    subprocess.run(f"sudo mysqladmin -u root password '{mysql_password}'", shell=True)

def create_database_and_tables():
    # 创建数据库和表
    mysql_commands = """
        CREATE DATABASE IF NOT EXISTS jianglin;
        USE jianglin;
        CREATE TABLE IF NOT EXISTS banner (
            id INT AUTO_INCREMENT PRIMARY KEY,
            image_path VARCHAR(255) NOT NULL,
            text VARCHAR(255)
        );
        CREATE TABLE IF NOT EXISTS product (
            id INT AUTO_INCREMENT PRIMARY KEY,
            name VARCHAR(255) NOT NULL,
            description LONGTEXT,
            image_path VARCHAR(255) NOT NULL
        );
        ALTER TABLE banner ADD deleted BOOLEAN DEFAULT FALSE;
        ALTER TABLE product ADD deleted BOOLEAN DEFAULT FALSE;
        INSERT INTO banner (image_path, text) VALUES
            ('/path/to/images/banner1.gif', 'Banner Text 1'),
            ('/path/to/images/banner2.gif', 'Banner Text 2'),
            ('/path/to/images/banner3.gif', 'Banner Text 3'),
            ('/path/to/images/banner4.gif', 'Banner Text 4'),
            ('/path/to/images/banner5.gif', 'Banner Text 5'),
            ('/path/to/images/banner6.gif', 'Banner Text 6'),
            ('/path/to/images/banner7.gif', 'Banner Text 7'),
            ('/path/to/images/banner8.gif', 'Banner Text 8'),
            ('/path/to/images/banner9.gif', 'Banner Text 9'),
            ('/path/to/images/banner10.gif', 'Banner Text 10');
        INSERT INTO product (name, description, image_path) VALUES
            ('Product 1', 'Description for Product 1', '/path/to/images/product1.gif'),
            ('Product 2', 'Description for Product 2', '/path/to/images/product2.gif'),
            ('Product 3', 'Description for Product 3', '/path/to/images/product3.gif'),
            ('Product 4', 'Description for Product 4', '/path/to/images/product4.gif'),
            ('Product 5', 'Description for Product 5', '/path/to/images/product5.gif'),
            ('Product 6', 'Description for Product 6', '/path/to/images/product6.gif'),
            ('Product 7', 'Description for Product 7', '/path/to/images/product7.gif'),
            ('Product 8', 'Description for Product 8', '/path/to/images/product8.gif'),
            ('Product 9', 'Description for Product 9', '/path/to/images/product9.gif'),
            ('Product 10', 'Description for Product 10', '/path/to/images/product10.gif');
    """
    mysql_command_list = mysql_commands.split(';')

    for command in mysql_command_list:
        command = command.strip()
        if command:
            subprocess.run(['sudo', 'mysql', '-e', command])

if __name__ == "__main__":
    install_mysql()
    start_mysql()
    enable_mysql_autostart()
    login_mysql()
    create_database_and_tables()

