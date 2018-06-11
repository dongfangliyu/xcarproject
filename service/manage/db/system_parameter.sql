/*
Navicat MySQL Data Transfer

Source Server         : 192.168.3.2:3306
Source Server Version : 50721
Source Host           : 192.168.3.2:3306
Source Database       : carfl_dev

Target Server Type    : MYSQL
Target Server Version : 50721
File Encoding         : 65001

Date: 2018-04-23 10:31:22
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `system_parameter`
-- ----------------------------
DROP TABLE IF EXISTS `system_parameter`;
CREATE TABLE `system_parameter` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键id',
  `param_name` varchar(200) DEFAULT NULL COMMENT '参数名称',
  `param_code` varchar(200) DEFAULT NULL COMMENT '参数自定义code',
  `param_status` int(4) DEFAULT NULL COMMENT '是否启用（0是启用 1是停用）',
  `param_type` varchar(200) DEFAULT NULL COMMENT '参数类型（服务的端口号）',
  `param_value` varchar(200) DEFAULT NULL COMMENT '参数值',
  `param_sign` int(4) DEFAULT NULL COMMENT '标识（0是可以修改 1是不能修改）',
  `operator` bigint(20) DEFAULT NULL COMMENT '创建人',
  `operate_time` datetime DEFAULT NULL COMMENT '创建时间',
  `param_remark` varchar(500) DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8 COMMENT='系统参数';

-- ----------------------------
-- Records of system_parameter
-- ----------------------------
INSERT INTO `system_parameter` VALUES ('1', '申请用户默认密码', 'UserDefaultPassword', '0', '9002', '888888', '0', '1', '2018-01-04 13:06:50', '测试被指');
INSERT INTO `system_parameter` VALUES ('2', '重置用户默认密码', 'UserResetPassword', '0', '9002', '888888', '0', '1', '2018-01-04 15:06:18', null);
INSERT INTO `system_parameter` VALUES ('3', 'mysql数据库脚本地址', 'SysBackupAddress', '0', '9002', '/data/mysqlbackup.sh', '0', '1', '2018-01-10 13:55:18', null);
INSERT INTO `system_parameter` VALUES ('4', '审批原因上传excel模板', 'ApproveReasonTemplate', '1', '9002', 'http://carfl-server-dev.daocloudapp.com/service-file/fileUploadController/view/5ac3531e46e0fb00123b6fd2', '0', '1', '2018-01-19 15:48:44', null);
INSERT INTO `system_parameter` VALUES ('5', '密码过时月数', 'PasswordObsoleteMonths', '0', '9002', '2', '0', '1', '2018-01-29 11:31:02', null);
INSERT INTO `system_parameter` VALUES ('6', '软件注册返回码', 'SoftwareRegistrationReturnCode', '0', '9002', '2FD5CDD8C5F0CF86', '0', '1', '2018-03-22 10:35:47', null);
INSERT INTO `system_parameter` VALUES ('7', '产品包上传excel模板', 'ProductPackageTemplate', '1', '9002', 'http://carfl-server-test.daocloudapp.com/service-file/fileUploadController/view/5abcab8bc9e77c0014569a16', '0', '1', '2018-02-02 10:16:14', null);
INSERT INTO `system_parameter` VALUES ('9', '客户默认密码', 'PersonalDefaultPassword', '0', '9003', '888888', '0', '1', '2018-03-22 10:35:49', null);
INSERT INTO `system_parameter` VALUES ('10', '是否开启虚拟划扣', 'IsOpenVirtualDeduction', '0', '9003', '0', '0', '1', '2018-03-27 18:28:59', '是否开启虚拟划扣 0 开启 1 未开启');
