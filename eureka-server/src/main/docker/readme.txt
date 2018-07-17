第一步:
1.1 修改docker配置文件
vi /usr/lib/systemd/system/docker.service

1.2 在配置文件下处修改内容为:
ExecStart=/usr/bin/dockerd-current \
          -H tcp://0.0.0.0:2375 -H unix:///var/run/docker.sock \
1.3 重启docker服务
service docker restart

1.4 查看端口是否启动
netstat -anp|grep 2375

1.5 防火墙开放2375端口
firewall-cmd --zone=public --add-port=2375/tcp --permanent
firewall-cmd --reload

1.6 配置WINDOWS系统环境变量
DOCKER_HOST tcp://10.10.0.136:2375

第二步:
2.1 maven 编译生成docker/文件
mvn clean package docker:build -DskipTests

2.2 将生成的jar包拷贝到LINUX环境中

2.3 LINUX环境中, 在jar包拷贝的目录下, 执行命令
docker run -it  --name eureka-server -p 8761:8761 -v $PWD/eureka-server-1.0-SNAPSHOT.jar:/app.jar  forep/eureka-server

第三步:
浏览器访问: 10.10.0.136:8761

注意:
指定
spring.profiles.active:dev