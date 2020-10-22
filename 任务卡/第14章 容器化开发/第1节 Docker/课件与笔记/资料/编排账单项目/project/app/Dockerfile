# 基于java镜像创建新镜像
FROM java:8
# 作者
MAINTAINER Howinfun
# 将jar包添加到容器中并更名为app.jar
ADD  jar/app.jar /root/docker_test/app.jar
# 运行jar包
ENTRYPOINT ["nohup","java","-jar","/root/docker_test/app.jar","&"]
