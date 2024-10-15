```shell
ssh root@120.55.113.175
ssh root@47.98.62.21

# ↓ 这个是zyu自己的服务器域名
ssh root@47.121.123.138

http://120.55.113.175:8080/login

 
cd /etc/nginx/


scp D:\AAAstuffsAAA\AAAqwqAAA\111qwq-projects-stuffs111\zhaixiang-jianglin\jianglin5\backend_spring\jianglin\target\jianglin-0.0.1-SNAPSHOT.jar root@120.55.113.175:/data


sudo apt update

sudo apt install openjdk-17-jdk

java -version

cd /data

git clone https://gitee.com/vincent-zyu/jar-repo

git fetch
git merge origin/main

# or
git pull

sudo cp /data/jar-repo/jianglin.service /etc/systemd/system/
sudo cp /data/jar-repo/jianglin-0.0.18-SNAPSHOT.jar /etc/systemd/system/


sudo rm -rf /etc/systemd/system/jianglin-0.0.18-SNAPSHOT.jar


sudo vim /etc/systemd/system/jianglin.service
sudo ls -l /etc/systemd/system/jianglin-0.0.19-SNAPSHOT.jar



sudo apt install mysql-client-core-8.0
sudo apt install mysql-server
sudo systemctl restart mysql
sudo systemctl status mysql

mysql -u root -p
alter user 'root'@'localhost' identified with mysql_native_password by 'diding2014';
CREATE DATABASE jianglin
  CHARACTER SET utf8mb4
  COLLATE utf8mb4_general_ci;

sudo systemctl daemon-reload
sudo systemctl restart jianglin
sudo systemctl enable jianglin

sudo journalctl -u jianglin --since "1 minutes ago" -f
sudo journalctl -u jianglin --since "5 minutes ago" -f




sudo find /etc/mysql/ -name "mysqld.cnf"
sudo vim /etc/mysql/mysql.conf.d/mysqld.cnf
sudo vim /etc/mysql/mysql.conf.d/mysqld.cnf

sudo apt install nginx
sudo nano /etc/nginx/nginx.conf

```

### 系统服务指令

```shell
sudo systemctl daemon-reload

# 启动服务
sudo systemctl start jianglin

# 停止服务
sudo systemctl stop jianglin

# 重启服务
sudo systemctl restart jianglin

# 查看服务状态
sudo systemctl status jianglin

# 设置开机自启动
sudo systemctl enable jianglin

# 禁止开机自启动
sudo systemctl disable jianglin

```



在/etc/nginx/nginx.conf添加这样的内容：

# HTTPS server
        server {
            listen 443 ssl;
            server_name pxqctn.cn;  # 将域名替换为你的域名

            ssl_certificate   /data/jar-repo/pxqctn.cn.pem;  # 替换为你的SSL证书路径
            ssl_certificate_key  /data/jar-repo/pxqctn.cn.key;  # 替换为你的SSL密钥路径

            ssl_session_timeout 5m;
            ssl_ciphers ECDHE-RSA-AES128-GCM-SHA256:ECDHE:ECDH:AES:HIGH:!NULL:!aNULL:!MD5:!ADH:!RC4;
            ssl_protocols TLSv1 TLSv1.1 TLSv1.2;
            ssl_prefer_server_ciphers on;

            location / {
                proxy_pass   http://127.0.0.1:8080;  # 将代理端口设置为8080
            }
        }


# HTTPS server
        server {
            listen 443 ssl;
            server_name vincentzyu233.xyz;  # 将域名替换为你的域名

            ssl_certificate   /data/jar-repo/vincentzyu233.xyz.pem;  # 替换为你的SSL证书路径
            ssl_certificate_key  /data/jar-repo/vincentzyu233.xyz.key;  # 替换为你的SSL密钥路径

            ssl_session_timeout 5m;
            ssl_ciphers ECDHE-RSA-AES128-GCM-SHA256:ECDHE:ECDH:AES:HIGH:!NULL:!aNULL:!MD5:!ADH:!RC4;
            ssl_protocols TLSv1 TLSv1.1 TLSv1.2;
            ssl_prefer_server_ciphers on;

            location / {
                proxy_pass   http://127.0.0.1:8080;  # 将代理端口设置为8080
            }
        }


```bash
nginx -s reload
sudo systemctl reload nginx
sudo systemctl restart nginx
sudo systemctl status nginx

netstat -lan | grep 443 #(查看443端口是否在监听) 
#tcp 0 0 0.0.0.0:443 0.0.0.0:* LISTEN (有看到这一行 就表示HTTPS已经在工作了) 
```

```sql
GRANT ALL PRIVILEGES ON *.* TO 'root'@'%' IDENTIFIED BY 'diding2014' WITH GRANT OPTION;
FLUSH PRIVILEGES;

SHOW VARIABLES LIKE 'bind_address';
SHOW VARIABLES LIKE 'bind_address';

select * from wx_user;
TRUNCATE TABLE wx_user;


```

let's encrypt证书
```bash
sudo apt update && sudo apt upgrade
sudo apt install certbot python3-certbot-nginx
sudo certbot --nginx


```

