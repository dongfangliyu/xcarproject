# xcarloan-server

《汽车金融》服务端项目

## 项目说明

##禁止用于商业盈利 ，如有需要 请联系 1339811979@qq.com

本项目基于SpringCould框架

### 服务与端口对应关系
1. 服务配置 xc-config 8760
2. 服务注册 xc-registry 8761
3. 服务网关 xc-gateway 8762
4. 服务监控 xc-monitor 8763
5. 文件服务管理 xc-service-file 9001
6. 汽车金融服务 xc-service-manage 9002
7. 报表服务 xc-service-report 9006
8. 合同打印服务 xc-service-contract 9007
9. 进销存服务 xc-service-sims 9008
10. 服务公共目录 xc-service-common
11. 配置管理 xc-service-generator
12. 消息提醒服务 xc-service-message 

## 主要技术

#### spring

https://spring.io/

#### spring boot

http://projects.spring.io/spring-boot

#### spring data jpa

http://projects.spring.io/spring-data-jpa

#### spring data mongodb

http://projects.spring.io/spring-data-mongodb/

#### spring cloud

http://projects.spring.io/spring-cloud

#### daocloud

https://dashboard.daocloud.io

## 相关技术文档说明

linux系统下服务启动脚本位置: xcarloan/service/manage/db/bootstart.sh

docke技术启动脚本位置：xcarloan/Dockerfile和xcarloan/supervisord.conf

汽车金融演示环境数据库脚本： xcarloan/service/manage/db/carfl_demo.sql

汽车金融数据库结构脚本： xcarloan/service/manage/db/carfl_dev.sql

汽车金融开发数据库脚本： xcarloan/service/manage/db/carfl_dev_develop.sql

汽车金融开发数据库脚本： xcarloan/service/manage/db/carfl_dev_develop.sql

汽车金融初始化数据库脚本： xcarloan/service/manage/db/clear_db.sql

汽车金融数据字典项数据库脚本： xcarloan/service/manage/db/data_dict.sql

汽车金融开发阶段新增的数据库脚本： xcarloan/service/manage/db/develop.sql

汽车金融开发阶段新增的数据库脚本： xcarloan/service/manage/db/develop.sql

汽车金融角色资源的数据库脚本： xcarloan/service/manage/db/role_reso.sql

汽车金融系统参数的数据库脚本： xcarloan/service/manage/db/system_parameter.sql

汽车金融用户资源的数据库脚本： xcarloan/service/manage/db/user_reso.sql

开发代码流程  dev-master-test-demo 
