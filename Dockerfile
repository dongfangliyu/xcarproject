FROM maven:3.5.2-jdk-8-slim

COPY . /usr/local/src/service/xcarloan
WORKDIR /usr/local/src/service/xcarloan

ENV TZ=Asia/Shanghai
RUN ln -snf /usr/share/zoneinfo/$TZ /etc/localtime && echo $TZ > /etc/timezone


# 更换maven源
RUN sed -Ee "s/(<mirrors>)/\1\n    <mirror>\n      <id>nexus-daocloud<\/id>\n      <mirrorOf>central<\/mirrorOf>\n      <name>Nexus daocloud<\/name>\n      <url>http:\/\/nexus.daocloud.io\/repository\/maven-public\/<\/url>\n    <\/mirror>/" -i /usr/share/maven/conf/settings.xml

# 安装supervisor
RUN apt-get update  && \
apt-get install -y supervisor && \
mkdir -p /var/log/supervisor

# 添加 supervisord 的配置文件，并复制配置文件到对应目录下面。（supervisord.conf文件和Dockerfile文件在同一路径）
COPY supervisord.conf /etc/supervisor/conf.d/supervisord.conf

# 安装依赖
RUN mvn clean install -Dmaven.test.skip=true  -P dev

# 容器需要开放SSH 22端口
EXPOSE 8762

CMD ["/usr/bin/supervisord"]
