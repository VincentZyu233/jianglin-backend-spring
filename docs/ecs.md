```shell
ssh root@120.55.113.175

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
sudo cp /data/jar-repo/jianglin-0.0.5-SNAPSHOT.jar /etc/systemd/system/

sudo rm -rf /etc/systemd/system/jianglin-0.0.4-SNAPSHOT.jar

ls -l /etc/systemd/system/jianglin.service
ls -l /etc/systemd/system/jianglin-0.0.5-SNAPSHOT.jar

sudo systemctl daemon-reload
sudo systemctl start jianglin
sudo systemctl enable jianglin

sudo journalctl -u jianglin --since "5 minutes ago" -f


````



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

