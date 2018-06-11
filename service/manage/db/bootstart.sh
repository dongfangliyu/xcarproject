# echo "关闭所有进程"
# ps -ef|grep pangolin-service|grep -v grep|cut -c 9-15|xargs --no-run-if-empty kill -9
project=/usr/xcarloan
echo  $project
cd $project
echo "开始构建项目"
mvn clean install -Dmaven.test.skip=true  -P dev


echo "开始构建registry服务"
cd $project
cd registry
ps -ef | grep xc-registry | grep -v grep | awk '{print $2}'|xargs --no-run-if-empty kill -9
cd target
nohup java -Xms128m -Xmx128m -jar xc-registry.jar >/home/logs/xc-registry.log&
echo "开始构建gateway服务"
cd $project
cd gateway
ps -ef | grep xc-gateway | grep -v grep | awk '{print $2}'|xargs --no-run-if-empty kill -9
cd target
nohup java -Xms128m -Xmx128m -jar xc-gateway.jar >/home/logs/xc-gateway.log&
echo "开始构建manage服务"
cd $project
cd service
cd manage
ps -ef | grep xc-service-manage | grep -v grep | awk '{print $2}'|xargs --no-run-if-empty kill -9
cd target
nohup java -Xms256m -Xmx256m -jar xc-service-manage-1.0-SNAPSHOT.jar >/home/logs/xc-service-manage.log&
echo "开始构建file服务"
cd $project
cd service
cd file
ps -ef | grep xc-service-file | grep -v grep | awk '{print $2}'|xargs --no-run-if-empty kill -9
cd target
nohup java -Xms256m -Xmx256m -jar xc-service-file-1.0-SNAPSHOT.jar >/home/logs/xc-service-file.log&
echo "开始构建report服务"
cd $project
cd service
cd report
ps -ef | grep xc-service-report | grep -v grep | awk '{print $2}'|xargs --no-run-if-empty kill -9
cd target
nohup java -Xms256m -Xmx256m -jar xc-service-report-1.0-SNAPSHOT.jar >/home/logs/xc-service-report.log&
echo "开始构建contract服务"
cd $project
cd service
cd contract
ps -ef | grep xc-service-contract | grep -v grep | awk '{print $2}'|xargs --no-run-if-empty kill -9
cd target
nohup java -Xms256m -Xmx256m -jar xc-service-contract-1.0-SNAPSHOT.jar >/home/logs/xc-service-contract.log&
