/*
Navicat MySQL Data Transfer

Source Server         : 3507
Source Server Version : 50722
Source Host           : 192.168.3.2:3507
Source Database       : carloan_demo

Target Server Type    : MYSQL
Target Server Version : 50722
File Encoding         : 65001

Date: 2018-05-03 14:44:35
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for role_reso
-- ----------------------------
DROP TABLE IF EXISTS `role_reso`;
CREATE TABLE `role_reso` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键id',
  `reso_pid` bigint(20) DEFAULT NULL COMMENT '父id',
  `reso_sysname` varchar(200) DEFAULT NULL COMMENT '系统名称',
  `reso_init_name` varchar(200) DEFAULT NULL COMMENT '资源初始名称',
  `reso_name` varchar(200) DEFAULT NULL COMMENT '资源名称',
  `reso_code` varchar(64) DEFAULT NULL COMMENT '资源码',
  `reso_level` int(4) DEFAULT NULL COMMENT '资源级别',
  `reso_status` int(4) DEFAULT NULL COMMENT '状态',
  `reso_path` varchar(500) DEFAULT NULL COMMENT '资源路径',
  `reso_init_icon` varchar(500) DEFAULT NULL COMMENT '资源初始图标',
  `reso_icon` varchar(500) DEFAULT NULL COMMENT '资源图标',
  `reso_type` int(4) DEFAULT NULL COMMENT '资源类型',
  `reso_filetype` int(4) DEFAULT NULL COMMENT '资源文件类型',
  `reso_remark` varchar(500) DEFAULT NULL COMMENT '备注',
  `operator` bigint(200) DEFAULT NULL COMMENT '创建人',
  `operate_time` datetime DEFAULT NULL COMMENT '创建日期',
  `flag` int(4) DEFAULT NULL COMMENT '数据库排序标识',
  `color` varchar(50) DEFAULT NULL,
  `sort` int(4) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=10001 DEFAULT CHARSET=utf8 COMMENT='角色资源管理';

-- ----------------------------
-- Records of role_reso
-- ----------------------------
INSERT INTO `role_reso` VALUES ('3', '499', '融资租赁', '机构与用户管理', '机构与用户管理', null, null, null, 'system-manage/power-config/org-user-manage', null, null, null, '421', '我是描述', null, null, '3', null, '2');
INSERT INTO `role_reso` VALUES ('4', '3', '融资租赁', '添加机构', '添加机构', null, null, null, null, null, null, null, '423', '我是描述', null, null, '4', null, null);
INSERT INTO `role_reso` VALUES ('5', '3', '融资租赁', '搜索', '搜索', null, null, null, null, null, null, null, '423', '我是描述', null, null, '5', null, null);
INSERT INTO `role_reso` VALUES ('6', '3', '融资租赁', '新增用户', '新增用户', null, null, null, null, null, null, null, '423', '我是描述', null, null, '6', null, null);
INSERT INTO `role_reso` VALUES ('7', '3', '融资租赁', '批量分配角色', '批量分配角色', null, null, null, null, null, null, null, '423', '我是描述', null, null, '7', null, null);
INSERT INTO `role_reso` VALUES ('8', '3', '融资租赁', '批量管理设备', '批量管理设备', null, null, null, null, null, null, null, '423', '我是描述', null, null, '8', null, null);
INSERT INTO `role_reso` VALUES ('9', '3', '融资租赁', '机构与用户管理列表', '机构与用户管理列表', null, null, null, null, null, null, null, '425', '我是描述', null, null, '9', null, null);
INSERT INTO `role_reso` VALUES ('10', '3', '融资租赁', '分配角色', '分配角色', null, null, null, null, null, null, null, '423', '我是描述', null, null, '10', null, null);
INSERT INTO `role_reso` VALUES ('11', '3', '融资租赁', '修改', '修改', null, null, null, null, null, null, null, '423', '我是描述', null, null, '11', null, null);
INSERT INTO `role_reso` VALUES ('12', '3', '融资租赁', '重置密码', '重置密码', null, null, null, null, null, null, null, '423', '我是描述', null, null, '12', null, null);
INSERT INTO `role_reso` VALUES ('13', '3', '融资租赁', '设备管理', '设备管理', null, null, null, null, null, null, null, '423', '我是描述', null, null, '13', null, null);
INSERT INTO `role_reso` VALUES ('14', '3', '融资租赁', '用户名', '用户名', null, null, null, null, null, null, null, '424', '我是描述', null, null, '14', null, null);
INSERT INTO `role_reso` VALUES ('15', '3', '融资租赁', '姓名', '姓名', null, null, null, null, null, null, null, '424', '我是描述', null, null, '15', null, null);
INSERT INTO `role_reso` VALUES ('16', '3', '融资租赁', '姓名', '姓名', null, null, null, null, null, null, null, '424', '我是描述', null, null, '16', null, null);
INSERT INTO `role_reso` VALUES ('17', '499', '融资租赁', '角色维护', '角色维护', null, null, null, 'system-manage/power-config/role-maintenance', null, null, null, '421', '我是描述', null, null, '17', null, '3');
INSERT INTO `role_reso` VALUES ('18', '17', '融资租赁', '搜索', '搜索', null, null, null, null, null, null, null, '423', '我是描述', null, null, '18', null, null);
INSERT INTO `role_reso` VALUES ('19', '17', '融资租赁', '新增角色', '新增角色', null, null, null, null, null, null, null, '423', '我是描述', null, null, '19', null, null);
INSERT INTO `role_reso` VALUES ('20', '17', '融资租赁', '角色维护列表', '角色维护列表', null, null, null, null, null, null, null, '425', '我是描述', null, null, '20', null, null);
INSERT INTO `role_reso` VALUES ('21', '17', '融资租赁', '修改', '修改', null, null, null, null, null, null, null, '423', '我是描述', null, null, '21', null, null);
INSERT INTO `role_reso` VALUES ('22', '17', '融资租赁', '删除', '删除', null, null, null, null, null, null, null, '423', '我是描述', null, null, '22', null, null);
INSERT INTO `role_reso` VALUES ('23', '17', '融资租赁', '模块权限', '模块权限', null, null, null, null, null, null, null, '423', '我是描述', null, null, '23', null, null);
INSERT INTO `role_reso` VALUES ('24', '17', '融资租赁', '用户列表', '用户列表', null, null, null, null, null, null, null, '423', '我是描述', null, null, '24', null, null);
INSERT INTO `role_reso` VALUES ('25', '17', '融资租赁', '待办事项配置', '待办事项配置', null, null, null, null, null, null, null, '423', '我是描述', null, null, '25', null, null);
INSERT INTO `role_reso` VALUES ('26', '17', '融资租赁', '角色名称', '角色名称', null, null, null, null, null, null, null, '424', '我是描述', null, null, '26', null, null);
INSERT INTO `role_reso` VALUES ('27', '17', '融资租赁', '状态', '状态', null, null, null, null, null, null, null, '424', '我是描述', null, null, '27', null, null);
INSERT INTO `role_reso` VALUES ('28', '499', '融资租赁', '模块功能', '模块功能', null, null, null, 'system-manage/power-config/module-function', null, null, null, '421', '我是描述', null, null, '28', null, '1');
INSERT INTO `role_reso` VALUES ('29', '28', '融资租赁', '重置名称', '重置名称', null, null, null, null, null, null, null, '423', '我是描述', null, null, '29', null, null);
INSERT INTO `role_reso` VALUES ('30', '28', '融资租赁', '重置图标', '重置图标', null, null, null, null, null, null, null, '423', '我是描述', null, null, '30', null, null);
INSERT INTO `role_reso` VALUES ('31', '28', '融资租赁', '修改图标', '修改图标', null, null, null, null, null, null, null, '423', '我是描述', null, null, '31', null, null);
INSERT INTO `role_reso` VALUES ('32', '28', '融资租赁', '修改名称', '修改名称', null, null, null, null, null, null, null, '423', '我是描述', null, null, '32', null, null);
INSERT INTO `role_reso` VALUES ('33', '28', '融资租赁', '查看', '查看', null, null, null, null, null, null, null, '423', '我是描述', null, null, '33', null, null);
INSERT INTO `role_reso` VALUES ('34', '28', '融资租赁', '模块功能列表', '模块功能列表', null, null, null, null, null, null, null, '425', '我是描述', null, null, '34', null, null);
INSERT INTO `role_reso` VALUES ('51', '499', '融资租赁', '系统日志', '系统日志', null, null, null, 'system-manage/operation-config/system-log-download', null, null, null, '421', '我是描述', null, null, '51', null, '7');
INSERT INTO `role_reso` VALUES ('52', '51', '融资租赁', '用户姓名', '用户姓名', null, null, null, null, null, null, null, '424', '我是描述', null, null, '52', null, null);
INSERT INTO `role_reso` VALUES ('53', '51', '融资租赁', '用户端IP', '用户端IP', null, null, null, null, null, null, null, '424', '我是描述', null, null, '53', null, null);
INSERT INTO `role_reso` VALUES ('54', '51', '融资租赁', '执行参数', '执行参数', null, null, null, null, null, null, null, '424', '我是描述', null, null, '54', null, null);
INSERT INTO `role_reso` VALUES ('55', '51', '融资租赁', '执行类型', '执行类型', null, null, null, null, null, null, null, '424', '我是描述', null, null, '55', null, null);
INSERT INTO `role_reso` VALUES ('56', '51', '融资租赁', '执行时间', '执行时间', null, null, null, null, null, null, null, '424', '我是描述', null, null, '56', null, null);
INSERT INTO `role_reso` VALUES ('57', '51', '融资租赁', '系统日志下载列表', '系统日志下载列表', null, null, null, null, null, null, null, '425', '我是描述', null, null, '57', null, null);
INSERT INTO `role_reso` VALUES ('58', '51', '融资租赁', '搜索', '搜索', null, null, null, null, null, null, null, '423', '我是描述', null, null, '58', null, null);
INSERT INTO `role_reso` VALUES ('59', '51', '融资租赁', '下载', '下载', null, null, null, null, null, null, null, '423', '我是描述', null, null, '59', null, null);
INSERT INTO `role_reso` VALUES ('60', '499', '融资租赁', '批量管理', '批量管理', null, null, null, 'system-manage/operation-config/batch-manage', null, null, null, '421', '我是描述', null, null, '60', null, '6');
INSERT INTO `role_reso` VALUES ('61', '60', '融资租赁', '启用', '启用', null, null, null, null, null, null, null, '423', '我是描述', null, null, '61', null, null);
INSERT INTO `role_reso` VALUES ('62', '60', '融资租赁', '暂停', '暂停', null, null, null, null, null, null, null, '423', '我是描述', null, null, '62', null, null);
INSERT INTO `role_reso` VALUES ('63', '60', '融资租赁', '批量管理列表', '批量管理列表', null, null, null, null, null, null, null, '425', '我是描述', null, null, '63', null, null);
INSERT INTO `role_reso` VALUES ('64', '499', '融资租赁', '系统备份', '系统备份', null, null, null, 'system-manage/operation-config/system-backups', null, null, null, '421', '我是描述', null, null, '64', null, '5');
INSERT INTO `role_reso` VALUES ('65', '64', '融资租赁', 'mysql文件名', 'mysql文件名', null, null, null, null, null, null, null, '424', '我是描述', null, null, '65', null, null);
INSERT INTO `role_reso` VALUES ('66', '64', '融资租赁', 'mongodb文件名', 'mongodb文件名', null, null, null, null, null, null, null, '424', '我是描述', null, null, '66', null, null);
INSERT INTO `role_reso` VALUES ('67', '64', '融资租赁', '备份类型', '备份类型', null, null, null, null, null, null, null, '424', '我是描述', null, null, '67', null, null);
INSERT INTO `role_reso` VALUES ('68', '64', '融资租赁', '备份时间', '备份时间', null, null, null, null, null, null, null, '424', '我是描述', null, null, '68', null, null);
INSERT INTO `role_reso` VALUES ('69', '64', '融资租赁', '系统备份列表列表', '系统备份列表列表', null, null, null, null, null, null, null, '425', '我是描述', null, null, '69', null, null);
INSERT INTO `role_reso` VALUES ('70', '64', '融资租赁', '搜索', '搜索', null, null, null, null, null, null, null, '423', '我是描述', null, null, '70', null, null);
INSERT INTO `role_reso` VALUES ('71', '64', '融资租赁', '新增备份', '新增备份', null, null, null, null, null, null, null, '423', '我是描述', null, null, '71', null, null);
INSERT INTO `role_reso` VALUES ('72', '64', '融资租赁', '恢复数据', '恢复数据', null, null, null, null, null, null, null, '423', '我是描述', null, null, '72', null, null);
INSERT INTO `role_reso` VALUES ('73', '64', '融资租赁', '删除备份', '删除备份', null, null, null, null, null, null, null, '423', '我是描述', null, null, '73', null, null);
INSERT INTO `role_reso` VALUES ('74', '499', '融资租赁', '系统参数管理', '系统参数管理', null, null, null, 'system-manage/operation-config/system-param-manage', null, null, null, '421', '我是描述', null, null, '74', null, '4');
INSERT INTO `role_reso` VALUES ('75', '74', '融资租赁', '参数名称', '参数名称', null, null, null, null, null, null, null, '424', '我是描述', null, null, '75', null, null);
INSERT INTO `role_reso` VALUES ('76', '74', '融资租赁', '是否启用', '是否启用', null, null, null, null, null, null, null, '424', '我是描述', null, null, '76', null, null);
INSERT INTO `role_reso` VALUES ('77', '74', '融资租赁', '系统参数管理列表', '系统参数管理列表', null, null, null, null, null, null, null, '425', '我是描述', null, null, '77', null, null);
INSERT INTO `role_reso` VALUES ('78', '74', '融资租赁', '搜索', '搜索', null, null, null, null, null, null, null, '423', '我是描述', null, null, '78', null, null);
INSERT INTO `role_reso` VALUES ('79', '74', '融资租赁', '修改', '修改', null, null, null, null, null, null, null, '423', '我是描述', null, null, '79', null, null);
INSERT INTO `role_reso` VALUES ('80', '10000', '融资租赁', '首页', '首页', null, null, null, 'home', null, null, null, '429', '我是描述', null, null, '80', null, '1');
INSERT INTO `role_reso` VALUES ('92', '498', '融资租赁', '车辆维护', '车辆维护', null, null, null, 'base/base-data/vehicle-maintenance', null, null, null, '421', '我是描述', null, null, '92', null, '5');
INSERT INTO `role_reso` VALUES ('93', '92', '融资租赁', '新增车辆', '新增车辆', null, null, null, null, null, null, null, '423', '我是描述', null, null, '93', null, null);
INSERT INTO `role_reso` VALUES ('94', '92', '融资租赁', '新增品牌', '新增品牌', null, null, null, null, null, null, null, '423', '我是描述', null, null, '94', null, null);
INSERT INTO `role_reso` VALUES ('95', '92', '融资租赁', '搜索', '搜索', null, null, null, null, null, null, null, '423', '我是描述', null, null, '95', null, null);
INSERT INTO `role_reso` VALUES ('96', '92', '融资租赁', '可选颜色', '可选颜色', null, null, null, null, null, null, null, '423', '我是描述', null, null, '96', null, null);
INSERT INTO `role_reso` VALUES ('97', '92', '融资租赁', '编辑参数', '编辑参数', null, null, null, null, null, null, null, '423', '我是描述', null, null, '97', null, null);
INSERT INTO `role_reso` VALUES ('98', '92', '融资租赁', '车辆维护列表', '车辆维护列表', null, null, null, null, null, null, null, '425', '我是描述', null, null, '98', null, null);
INSERT INTO `role_reso` VALUES ('99', '92', '融资租赁', '添加类别', '添加类别', null, null, null, null, null, null, null, '423', '我是描述', null, null, '99', null, null);
INSERT INTO `role_reso` VALUES ('100', '498', '融资租赁', '数据字典', '数据字典', null, null, null, 'base/base-data/data-dict', null, null, null, '421', '我是描述', null, null, '100', null, '1');
INSERT INTO `role_reso` VALUES ('101', '100', '融资租赁', '数据名称', '数据名称', null, null, null, null, null, null, null, '424', '我是描述', null, null, '101', null, null);
INSERT INTO `role_reso` VALUES ('102', '100', '融资租赁', '查询', '查询', null, null, null, null, null, null, null, '423', '我是描述', null, null, '102', null, null);
INSERT INTO `role_reso` VALUES ('103', '100', '融资租赁', '新增数据', '新增数据', null, null, null, null, null, null, null, '423', '我是描述', null, null, '103', null, null);
INSERT INTO `role_reso` VALUES ('104', '100', '融资租赁', '编辑', '编辑', null, null, null, null, null, null, null, '423', '我是描述', null, null, '104', null, null);
INSERT INTO `role_reso` VALUES ('105', '100', '融资租赁', '删除', '删除', null, null, null, null, null, null, null, '423', '我是描述', null, null, '105', null, null);
INSERT INTO `role_reso` VALUES ('106', '100', '融资租赁', '名称', '名称', null, null, null, null, null, null, null, '424', '我是描述', null, null, '106', null, null);
INSERT INTO `role_reso` VALUES ('107', '100', '融资租赁', '添加', '添加', null, null, null, null, null, null, null, '423', '我是描述', null, null, '107', null, null);
INSERT INTO `role_reso` VALUES ('108', '100', '融资租赁', '数据字典列表', '数据字典列表', null, null, null, null, null, null, null, '425', '我是描述', null, null, '108', null, null);
INSERT INTO `role_reso` VALUES ('109', '498', '融资租赁', '审批原因管理', '审批原因管理', null, null, null, 'base/base-data/approval-reason-manage', null, null, null, '421', '我是描述', null, null, '109', null, '2');
INSERT INTO `role_reso` VALUES ('110', '109', '融资租赁', '类型', '类型', null, null, null, null, null, null, null, '424', '我是描述', null, null, '110', null, null);
INSERT INTO `role_reso` VALUES ('111', '109', '融资租赁', '一级', '一级', null, null, null, null, null, null, null, '424', '我是描述', null, null, '111', null, null);
INSERT INTO `role_reso` VALUES ('112', '109', '融资租赁', '二级', '二级', null, null, null, null, null, null, null, '424', '我是描述', null, null, '112', null, null);
INSERT INTO `role_reso` VALUES ('113', '109', '融资租赁', '详细内容', '详细内容', null, null, null, null, null, null, null, '424', '我是描述', null, null, '113', null, null);
INSERT INTO `role_reso` VALUES ('114', '109', '融资租赁', '查询', '查询', null, null, null, null, null, null, null, '423', '我是描述', null, null, '114', null, null);
INSERT INTO `role_reso` VALUES ('115', '109', '融资租赁', '导入', '导入', null, null, null, null, null, null, null, '423', '我是描述', null, null, '115', null, null);
INSERT INTO `role_reso` VALUES ('116', '109', '融资租赁', '模板下载', '模板下载', null, null, null, null, null, null, null, '423', '我是描述', null, null, '116', null, null);
INSERT INTO `role_reso` VALUES ('117', '109', '融资租赁', '编辑', '编辑', null, null, null, null, null, null, null, '423', '我是描述', null, null, '117', null, null);
INSERT INTO `role_reso` VALUES ('118', '109', '融资租赁', '删除', '删除', null, null, null, null, null, null, null, '423', '我是描述', null, null, '118', null, null);
INSERT INTO `role_reso` VALUES ('119', '109', '融资租赁', '新增审批原因', '新增审批原因', null, null, null, null, null, null, null, '423', '我是描述', null, null, '119', null, null);
INSERT INTO `role_reso` VALUES ('120', '109', '融资租赁', '审批原因管理列表', '审批原因管理列表', null, null, null, null, null, null, null, '425', '我是描述', null, null, '120', null, null);
INSERT INTO `role_reso` VALUES ('121', '498', '融资租赁', '分公司管理', '分公司管理', null, null, null, 'base/base-data/branch-company-info', null, null, null, '421', '我是描述', null, null, '121', null, '3');
INSERT INTO `role_reso` VALUES ('122', '121', '融资租赁', '关键字搜索', '关键字搜索', null, null, null, null, null, null, null, '424', '我是描述', null, null, '122', null, null);
INSERT INTO `role_reso` VALUES ('123', '121', '融资租赁', '查询', '查询', null, null, null, null, null, null, null, '423', '我是描述', null, null, '123', null, null);
INSERT INTO `role_reso` VALUES ('124', '121', '融资租赁', '启用', '启用', null, null, null, null, null, null, null, '423', '我是描述', null, null, '124', null, null);
INSERT INTO `role_reso` VALUES ('125', '121', '融资租赁', '修改', '修改', null, null, null, null, null, null, null, '423', '我是描述', null, null, '125', null, null);
INSERT INTO `role_reso` VALUES ('126', '121', '融资租赁', '停用', '停用', null, null, null, null, null, null, null, '423', '我是描述', null, null, '126', null, null);
INSERT INTO `role_reso` VALUES ('127', '121', '融资租赁', '新增分公司', '新增分公司', null, null, null, null, null, null, null, '423', '我是描述', null, null, '127', null, null);
INSERT INTO `role_reso` VALUES ('129', '500', '融资租赁', '产品配置', '产品配置', null, null, null, 'base/base-data/prod-config', null, null, null, '421', '我是描述', null, null, '129', null, '1');
INSERT INTO `role_reso` VALUES ('130', '129', '融资租赁', '新增产品', '新增产品', null, null, null, null, null, null, null, '423', '我是描述', null, null, '130', null, null);
INSERT INTO `role_reso` VALUES ('131', '129', '融资租赁', '新增产品系列', '新增产品系列', null, null, null, null, null, null, null, '423', '我是描述', null, null, '131', null, null);
INSERT INTO `role_reso` VALUES ('132', '129', '融资租赁', '资金渠道选择', '资金渠道选择', null, null, null, null, null, null, null, '423', '我是描述', null, null, '132', null, null);
INSERT INTO `role_reso` VALUES ('133', '129', '融资租赁', '客户素材配置', '客户素材配置', null, null, null, null, null, null, null, '423', '我是描述', null, null, '133', null, null);
INSERT INTO `role_reso` VALUES ('134', '129', '融资租赁', '新增产品期数', '新增产品期数', null, null, null, null, null, null, null, '423', '我是描述', null, null, '134', null, null);
INSERT INTO `role_reso` VALUES ('135', '129', '融资租赁', '启用/停用', '启用/停用', null, null, null, null, null, null, null, '423', '我是描述', null, null, '135', null, null);
INSERT INTO `role_reso` VALUES ('136', '129', '融资租赁', '查看', '查看', null, null, null, null, null, null, null, '423', '我是描述', null, null, '136', null, null);
INSERT INTO `role_reso` VALUES ('137', '129', '融资租赁', '编辑期数', '编辑期数', null, null, null, null, null, null, null, '423', '我是描述', null, null, '137', null, null);
INSERT INTO `role_reso` VALUES ('138', '129', '融资租赁', '发布', '发布', null, null, null, null, null, null, null, '423', '我是描述', null, null, '138', null, null);
INSERT INTO `role_reso` VALUES ('139', '498', '融资租赁', '客户素材维护', '客户素材维护', null, null, null, 'base/base-data/customer-fodder-maintain', null, null, null, '421', '我是描述', null, null, '139', null, '4');
INSERT INTO `role_reso` VALUES ('140', '139', '融资租赁', '素材名称', '素材名称', null, null, null, null, null, null, null, '424', '我是描述', null, null, '140', null, null);
INSERT INTO `role_reso` VALUES ('141', '139', '融资租赁', '查询', '查询', null, null, null, null, null, null, null, '423', '我是描述', null, null, '141', null, null);
INSERT INTO `role_reso` VALUES ('142', '139', '融资租赁', '新增素材', '新增素材', null, null, null, null, null, null, null, '423', '我是描述', null, null, '142', null, null);
INSERT INTO `role_reso` VALUES ('143', '139', '融资租赁', '是否必传', '是否必传', null, null, null, null, null, null, null, '423', '我是描述', null, null, '143', null, null);
INSERT INTO `role_reso` VALUES ('144', '139', '融资租赁', '客户素材维护列表', '客户素材维护列表', null, null, null, null, null, null, null, '425', '我是描述', null, null, '144', null, null);
INSERT INTO `role_reso` VALUES ('155', '10000', '融资租赁', '客户中心', '客户中心', null, null, null, 'customer-center/customer-index', '', '', null, '429', '我是描述', null, null, '155', '', '2');
INSERT INTO `role_reso` VALUES ('159', '483', '融资租赁', '客户开户', '客户开户', null, null, null, 'purchase/purchase-manage/open-account', '', '', null, '421', '我是描述', null, null, '159', '', '1');
INSERT INTO `role_reso` VALUES ('160', '483', '融资租赁', '客户签约', '客户签约', null, null, null, 'purchase/purchase-manage/customer-sign', '', '', null, '421', '我是描述', null, null, '160', '', '2');
INSERT INTO `role_reso` VALUES ('161', '214', '融资租赁', '订单交接', '订单交接', null, null, null, 'purchase/purchase-manage/order-transfer', '', '', null, '421', '我是描述', null, null, '161', '', '4');
INSERT INTO `role_reso` VALUES ('162', '214', '融资租赁', '进件查询', '进件查询', null, null, null, 'purchase/purchase-query', 'jinjianchaxun', 'jinjianchaxun', null, '422', '我是描述', null, null, '162', '#36B48C', '3');
INSERT INTO `role_reso` VALUES ('163', '162', '融资租赁', '订单查询', '订单查询', null, null, null, 'purchase/purchase-query/order-query', '', '', null, '421', '我是描述', null, null, '163', '', '1');
INSERT INTO `role_reso` VALUES ('164', '497', '融资租赁', '客户资料查询', '客户资料查询', null, null, null, 'purchase/purchase-query/customer-data-query', '', '', null, '421', '我是描述', null, null, '164', '', '1');
INSERT INTO `role_reso` VALUES ('165', '497', '融资租赁', '产品包查询', '产品包查询', null, null, null, 'purchase/purchase-query/product-package-query', '', '', null, '421', '我是描述', null, null, '165', '', '2');
INSERT INTO `role_reso` VALUES ('167', '494', '融资租赁', '收款申请', '收款申请', null, null, null, 'purchase/finance-account/sale-gathering-apply', '', '', null, '421', '我是描述', null, null, '167', '', '1');
INSERT INTO `role_reso` VALUES ('168', '494', '融资租赁', '提前结清申请', '提前结清申请', null, null, null, 'purchase/finance-account/early-payment-apply', '', '', null, '421', '我是描述', null, null, '168', '', '3');
INSERT INTO `role_reso` VALUES ('169', '494', '融资租赁', '提前收回申请', '提前收回申请', null, null, null, 'purchase/finance-account/early-recover-apply', '', '', null, '421', '我是描述', null, null, '169', '', '4');
INSERT INTO `role_reso` VALUES ('170', '497', '融资租赁', '收款记录查询', '收款记录查询', null, null, null, 'purchase/finance-account/receipt-record-query', '', '', null, '421', '我是描述', null, null, '170', '', '3');
INSERT INTO `role_reso` VALUES ('171', '494', '融资租赁', '付款申请', '付款申请', null, null, null, 'purchase/finance-account/pay-apply', '', '', null, '421', '我是描述', null, null, '171', '', '2');
INSERT INTO `role_reso` VALUES ('173', '479', '融资租赁', '收款审批', '收款审批', null, null, null, 'purchase/purchase-approve/receipt-approve', '', '', null, '421', '我是描述', null, null, '173', '', '7');
INSERT INTO `role_reso` VALUES ('174', '479', '融资租赁', '付款审批', '付款审批', null, null, null, 'purchase/purchase-approve/payment-approve', '', '', null, '421', '我是描述', null, null, '174', '', '8');
INSERT INTO `role_reso` VALUES ('175', '121', '融资租赁', '分公司管理列表', '分公司管理列表', null, null, null, '', null, null, null, '425', '我是描述', null, null, '175', null, null);
INSERT INTO `role_reso` VALUES ('176', '159', '融资租赁', '多条件查询', '多条件查询', null, null, null, null, null, null, null, '424', '我是描述', null, null, '176', null, null);
INSERT INTO `role_reso` VALUES ('177', '159', '融资租赁', '7条时间查询', '7条时间查询', null, null, null, null, null, null, null, '423', '我是描述', null, null, '177', null, null);
INSERT INTO `role_reso` VALUES ('178', '159', '融资租赁', '打印', '打印', null, null, null, null, null, null, null, '423', '我是描述', null, null, '178', null, null);
INSERT INTO `role_reso` VALUES ('179', '159', '融资租赁', '导出', '导出', null, null, null, null, null, null, null, '423', '我是描述', null, null, '179', null, null);
INSERT INTO `role_reso` VALUES ('180', '159', '融资租赁', '客户开户列表', '客户开户列表', null, null, null, null, null, null, null, '425', '我是描述', null, null, '180', null, null);
INSERT INTO `role_reso` VALUES ('181', '160', '融资租赁', '日期搜索', '日期搜索', null, null, null, null, null, null, null, '424', '我是描述', null, null, '181', null, null);
INSERT INTO `role_reso` VALUES ('182', '160', '融资租赁', '多条件查询', '多条件查询', null, null, null, null, null, null, null, '424', '我是描述', null, null, '182', null, null);
INSERT INTO `role_reso` VALUES ('183', '160', '融资租赁', '7条时间查询', '7条时间查询', null, null, null, null, null, null, null, '423', '我是描述', null, null, '183', null, null);
INSERT INTO `role_reso` VALUES ('184', '160', '融资租赁', '客户签约列表', '客户签约列表', null, null, null, null, null, null, null, '425', '我是描述', null, null, '184', null, null);
INSERT INTO `role_reso` VALUES ('185', '160', '融资租赁', '打印', '打印', null, null, null, null, null, null, null, '423', '我是描述', null, null, '185', null, null);
INSERT INTO `role_reso` VALUES ('186', '160', '融资租赁', '导出', '导出', null, null, null, null, null, null, null, '423', '我是描述', null, null, '186', null, null);
INSERT INTO `role_reso` VALUES ('187', '161', '融资租赁', '日期搜索', '日期搜索', null, null, null, null, null, null, null, '424', '我是描述', null, null, '187', null, null);
INSERT INTO `role_reso` VALUES ('188', '161', '融资租赁', '多条件查询', '多条件查询', null, null, null, null, null, null, null, '424', '我是描述', null, null, '188', null, null);
INSERT INTO `role_reso` VALUES ('189', '161', '融资租赁', '打印', '打印', null, null, null, null, null, null, null, '423', '我是描述', null, null, '189', null, null);
INSERT INTO `role_reso` VALUES ('190', '161', '融资租赁', '导出', '导出', null, null, null, null, null, null, null, '423', '我是描述', null, null, '190', null, null);
INSERT INTO `role_reso` VALUES ('191', '161', '融资租赁', '一键交接', '一键交接', null, null, null, null, null, null, null, '423', '我是描述', null, null, '191', null, null);
INSERT INTO `role_reso` VALUES ('192', '161', '融资租赁', '订单交接列表', '订单交接列表', null, null, null, null, null, null, null, '423', '我是描述', null, null, '192', null, null);
INSERT INTO `role_reso` VALUES ('193', '10000', '融资租赁', '押品管理', '押品管理', null, null, null, null, '', '', null, '429', '我是描述', null, null, '193', '', '3');
INSERT INTO `role_reso` VALUES ('195', '495', '融资租赁', '收款', '收款', null, null, null, 'finance/initial-payment-manage/gathering', '', '', null, '421', '我是描述', null, null, '195', '', '4');
INSERT INTO `role_reso` VALUES ('196', '495', '融资租赁', '付款', '付款', null, null, null, 'finance/initial-payment-manage/payment', '', '', null, '421', '我是描述', null, null, '196', '', '5');
INSERT INTO `role_reso` VALUES ('198', '495', '融资租赁', '客户还款', '客户还款', null, null, null, 'finance/repay-manage/customer-repay', '', '', null, '421', '我是描述', null, null, '198', '', '6');
INSERT INTO `role_reso` VALUES ('199', '495', '融资租赁', '提前结清', '提前结清', null, null, null, 'finance/repay-manage/early-pay', '', '', null, '421', '我是描述', null, null, '199', '', '7');
INSERT INTO `role_reso` VALUES ('200', '495', '融资租赁', '提前收回', '提前收回', null, null, null, 'finance/repay-manage/early-withdraw', '', '', null, '421', '我是描述', null, null, '200', '', '8');
INSERT INTO `role_reso` VALUES ('201', '497', '融资租赁', '已结清订单查询', '已结清订单查询', null, null, null, 'finance/repay-manage/closed-order-query', '', '', null, '421', '我是描述', null, null, '201', '', '6');
INSERT INTO `role_reso` VALUES ('203', '495', '融资租赁', '个人开户列表', '个人开户列表', null, null, null, 'finance/deduct-manage/personal-account-list', '', '', null, '421', '我是描述', null, null, '203', '', '9');
INSERT INTO `role_reso` VALUES ('204', '495', '融资租赁', '企业开户列表', '企业开户列表', null, null, null, 'finance/deduct-manage/company-account-list', '', '', null, '421', '我是描述', null, null, '204', '', '10');
INSERT INTO `role_reso` VALUES ('205', '495', '融资租赁', '划扣记录查询', '划扣记录查询', null, null, null, 'finance/deduct-manage/deduct-record-query', '', '', null, '421', '我是描述', null, null, '205', '', '11');
INSERT INTO `role_reso` VALUES ('207', '495', '融资租赁', '财务开票', '财务开票', null, null, null, 'finance/invoice-manage/finance-make-invoice', '', '', null, '421', '我是描述', null, null, '207', '', '12');
INSERT INTO `role_reso` VALUES ('209', '501', '融资租赁', '清结算日报表', '清结算日报表', null, null, null, 'finance/finance-statistics/clear-account-report', '', '', null, '421', '我是描述', null, null, '209', '', '1');
INSERT INTO `role_reso` VALUES ('210', '501', '融资租赁', '月还款报表', '月还款报表', null, null, null, 'finance/finance-statistics/month-repay-report', '', '', null, '421', '我是描述', null, null, '210', '', '2');
INSERT INTO `role_reso` VALUES ('214', '10000', '融资租赁', '进件管理', '进件管理', null, null, null, 'purchase/purchase-manage', 'jinjianguanli', 'jinjianguanli', null, '429', '我是描述', null, null, '214', '', '4');
INSERT INTO `role_reso` VALUES ('216', '479', '融资租赁', '审核资源池', '审核资源池', null, null, null, 'approval/approval-manage/approval-resource-pool', '', '', null, '421', '我是描述', null, null, '216', '', '1');
INSERT INTO `role_reso` VALUES ('217', '479', '融资租赁', '面审资源池', '面审资源池', null, null, null, 'approval/approval-manage/face-approval', '', '', null, '421', '我是描述', null, null, '217', '', '3');
INSERT INTO `role_reso` VALUES ('218', '479', '融资租赁', '复审资源池', '复审资源池', null, null, null, 'approval/approval-manage/second-approval', '', '', null, '421', '我是描述', null, null, '218', '', '4');
INSERT INTO `role_reso` VALUES ('219', '479', '融资租赁', '终审资源池', '终审资源池', null, null, null, 'approval/approval-manage/last-approval', '', '', null, '421', '我是描述', null, null, '219', '', '5');
INSERT INTO `role_reso` VALUES ('220', '479', '融资租赁', '合规检查', '合规检查', null, null, null, 'approval/approval-manage/meet-condition-check', '', '', null, '421', '我是描述', null, null, '220', '', '6');
INSERT INTO `role_reso` VALUES ('221', '479', '融资租赁', '我的审核', '我的审核', null, null, null, 'approval/approval-manage/my-approval', '', '', null, '421', '我是描述', null, null, '221', '', '2');
INSERT INTO `role_reso` VALUES ('222', '500', '融资租赁', '流程配置', '流程配置', null, null, null, 'approval/approval-manage/flow-config', '', '', null, '421', '我是描述', null, null, '222', '', '2');
INSERT INTO `role_reso` VALUES ('224', '479', '融资租赁', '内审管理', '内审管理', null, null, null, 'approval/approval-manage/internal-audit-manage', '', '', null, '421', '我是描述', null, null, '224', '', '9');
INSERT INTO `role_reso` VALUES ('225', '479', '融资租赁', '灰名单', '灰名单', null, null, null, 'approval/approval-manage/gray-list', '', '', null, '421', '我是描述', null, null, '225', '', '10');
INSERT INTO `role_reso` VALUES ('226', '479', '融资租赁', '黑名单', '黑名单', null, null, null, 'approval/approval-manage/black-list', '', '', null, '421', '我是描述', null, null, '226', '', '11');
INSERT INTO `role_reso` VALUES ('229', '495', '融资租赁', '客户还款查询', '客户还款查询', null, null, null, 'approval/repay-manage/customer-repay-query', '', '', null, '421', '我是描述', null, null, '229', '', '1');
INSERT INTO `role_reso` VALUES ('230', '495', '融资租赁', '减免申请记录', '减免申请记录', null, null, null, 'approval/repay-manage/derate-apply-record', '', '', null, '421', '我是描述', null, null, '230', '', '2');
INSERT INTO `role_reso` VALUES ('231', '495', '融资租赁', '冻结申请记录', '冻结申请记录', null, null, null, 'approval/repay-manage/frozen-apply-record', '', '', null, '421', '我是描述', null, null, '231', '', '3');
INSERT INTO `role_reso` VALUES ('233', '497', '融资租赁', '审核记录表', '审核记录表', null, null, null, 'approval/synthesize-query/approval-record-table', '', '', null, '421', '我是描述', null, null, '233', '', '5');
INSERT INTO `role_reso` VALUES ('234', '497', '融资租赁', '合同下载监控', '合同下载监控', null, null, null, 'approval/synthesize-query/compact-monitor', '', '', null, '421', '我是描述', null, null, '234', '', '7');
INSERT INTO `role_reso` VALUES ('313', '226', '融资租赁', '黑名单data-box', '黑名单data-box', null, null, null, null, null, null, null, '425', '我是描述', null, null, '313', null, null);
INSERT INTO `role_reso` VALUES ('314', '226', '融资租赁', '7条时间查询', '7条时间查询', null, null, null, null, null, null, null, '423', '我是描述', null, null, '314', null, null);
INSERT INTO `role_reso` VALUES ('315', '226', '融资租赁', '多条件查询', '多条件查询', null, null, null, null, null, null, null, '424', '我是描述', null, null, '315', null, null);
INSERT INTO `role_reso` VALUES ('316', '226', '融资租赁', '日期搜索', '日期搜索', null, null, null, null, null, null, null, '424', '我是描述', null, null, '316', null, null);
INSERT INTO `role_reso` VALUES ('317', '226', '融资租赁', '省市搜索', '省市搜索', null, null, null, null, null, null, null, '424', '我是描述', null, null, '317', null, null);
INSERT INTO `role_reso` VALUES ('318', '226', '融资租赁', '产品类型搜索', '产品类型搜索', null, null, null, null, null, null, null, '424', '我是描述', null, null, '318', null, null);
INSERT INTO `role_reso` VALUES ('319', '226', '融资租赁', '打印', '打印', null, null, null, null, null, null, null, '423', '我是描述', null, null, '319', null, null);
INSERT INTO `role_reso` VALUES ('320', '226', '融资租赁', '导出', '导出', null, null, null, null, null, null, null, '423', '我是描述', null, null, '320', null, null);
INSERT INTO `role_reso` VALUES ('321', '226', '融资租赁', '查看', '查看', null, null, null, null, null, null, null, '423', '我是描述', null, null, '321', null, null);
INSERT INTO `role_reso` VALUES ('331', '229', '融资租赁', '客户还款查询data-box', '客户还款查询data-box', null, null, null, null, null, null, null, '425', '我是描述', null, null, '331', null, null);
INSERT INTO `role_reso` VALUES ('332', '229', '融资租赁', '7条时间查询', '7条时间查询', null, null, null, null, null, null, null, '423', '我是描述', null, null, '332', null, null);
INSERT INTO `role_reso` VALUES ('333', '229', '融资租赁', '多条件查询', '多条件查询', null, null, null, null, null, null, null, '424', '我是描述', null, null, '333', null, null);
INSERT INTO `role_reso` VALUES ('334', '229', '融资租赁', '全部还款状态', '全部还款状态', null, null, null, null, null, null, null, '424', '我是描述', null, null, '334', null, null);
INSERT INTO `role_reso` VALUES ('335', '229', '融资租赁', '全部结算通道', '全部结算通道', null, null, null, null, null, null, null, '424', '我是描述', null, null, '335', null, null);
INSERT INTO `role_reso` VALUES ('336', '229', '融资租赁', '打印', '打印', null, null, null, null, null, null, null, '423', '我是描述', null, null, '336', null, null);
INSERT INTO `role_reso` VALUES ('337', '229', '融资租赁', '导出', '导出', null, null, null, null, null, null, null, '423', '我是描述', null, null, '337', null, null);
INSERT INTO `role_reso` VALUES ('338', '229', '融资租赁', '还款总览', '还款总览', null, null, null, null, null, null, null, '423', '我是描述', null, null, '338', null, null);
INSERT INTO `role_reso` VALUES ('339', '229', '融资租赁', '还款详情', '还款详情', null, null, null, null, null, null, null, '423', '我是描述', null, null, '339', null, null);
INSERT INTO `role_reso` VALUES ('340', '230', '融资租赁', '减免申请记录data-box', '减免申请记录data-box', null, null, null, null, null, null, null, '425', '我是描述', null, null, '340', null, null);
INSERT INTO `role_reso` VALUES ('341', '230', '融资租赁', '7条时间查询', '7条时间查询', null, null, null, null, null, null, null, '423', '我是描述', null, null, '341', null, null);
INSERT INTO `role_reso` VALUES ('342', '230', '融资租赁', '多条件查询', '多条件查询', null, null, null, null, null, null, null, '424', '我是描述', null, null, '342', null, null);
INSERT INTO `role_reso` VALUES ('343', '230', '融资租赁', '日期搜索', '日期搜索', null, null, null, null, null, null, null, '424', '我是描述', null, null, '343', null, null);
INSERT INTO `role_reso` VALUES ('344', '230', '融资租赁', '全部结算通道', '全部结算通道', null, null, null, null, null, null, null, '424', '我是描述', null, null, '344', null, null);
INSERT INTO `role_reso` VALUES ('345', '230', '融资租赁', '打印', '打印', null, null, null, null, null, null, null, '423', '我是描述', null, null, '345', null, null);
INSERT INTO `role_reso` VALUES ('346', '230', '融资租赁', '导出', '导出', null, null, null, null, null, null, null, '423', '我是描述', null, null, '346', null, null);
INSERT INTO `role_reso` VALUES ('347', '230', '融资租赁', '撤销', '撤销', null, null, null, null, null, null, null, '423', '我是描述', null, null, '347', null, null);
INSERT INTO `role_reso` VALUES ('348', '231', '融资租赁', '冻结申请记录data-box', '冻结申请记录data-box', null, null, null, null, null, null, null, '425', '我是描述', null, null, '348', null, null);
INSERT INTO `role_reso` VALUES ('349', '231', '融资租赁', '7条时间查询', '7条时间查询', null, null, null, null, null, null, null, '423', '我是描述', null, null, '349', null, null);
INSERT INTO `role_reso` VALUES ('350', '231', '融资租赁', '多条件查询', '多条件查询', null, null, null, null, null, null, null, '424', '我是描述', null, null, '350', null, null);
INSERT INTO `role_reso` VALUES ('351', '231', '融资租赁', '日期搜索', '日期搜索', null, null, null, null, null, null, null, '424', '我是描述', null, null, '351', null, null);
INSERT INTO `role_reso` VALUES ('352', '231', '融资租赁', '全部结算通道', '全部结算通道', null, null, null, null, null, null, null, '424', '我是描述', null, null, '352', null, null);
INSERT INTO `role_reso` VALUES ('353', '231', '融资租赁', '打印', '打印', null, null, null, null, null, null, null, '423', '我是描述', null, null, '353', null, null);
INSERT INTO `role_reso` VALUES ('354', '231', '融资租赁', '导出', '导出', null, null, null, null, null, null, null, '423', '我是描述', null, null, '354', null, null);
INSERT INTO `role_reso` VALUES ('355', '231', '融资租赁', '解冻', '解冻', null, null, null, null, null, null, null, '423', '我是描述', null, null, '355', null, null);
INSERT INTO `role_reso` VALUES ('356', '233', '融资租赁', '审核记录表data-box', '审核记录表data-box', null, null, null, null, null, null, null, '425', '我是描述', null, null, '356', null, null);
INSERT INTO `role_reso` VALUES ('357', '233', '融资租赁', '全部状态', '全部状态', null, null, null, null, null, null, null, '424', '我是描述', null, null, '357', null, null);
INSERT INTO `role_reso` VALUES ('358', '233', '融资租赁', '全部拒单原因', '全部拒单原因', null, null, null, null, null, null, null, '424', '我是描述', null, null, '358', null, null);
INSERT INTO `role_reso` VALUES ('359', '233', '融资租赁', '全部拒单细节', '全部拒单细节', null, null, null, null, null, null, null, '424', '我是描述', null, null, '359', null, null);
INSERT INTO `role_reso` VALUES ('360', '233', '融资租赁', '日期搜索', '日期搜索', null, null, null, null, null, null, null, '424', '我是描述', null, null, '360', null, null);
INSERT INTO `role_reso` VALUES ('361', '233', '融资租赁', '打印', '打印', null, null, null, null, null, null, null, '423', '我是描述', null, null, '361', null, null);
INSERT INTO `role_reso` VALUES ('362', '233', '融资租赁', '导出', '导出', null, null, null, null, null, null, null, '423', '我是描述', null, null, '362', null, null);
INSERT INTO `role_reso` VALUES ('363', '233', '融资租赁', '查看', '查看', null, null, null, null, null, null, null, '423', '我是描述', null, null, '363', null, null);
INSERT INTO `role_reso` VALUES ('364', '234', '融资租赁', '合同下载监控data-box', '合同下载监控data-box', null, null, null, null, null, null, null, '425', '我是描述', null, null, '364', null, null);
INSERT INTO `role_reso` VALUES ('365', '234', '融资租赁', '7条时间查询', '7条时间查询', null, null, null, null, null, null, null, '423', '我是描述', null, null, '365', null, null);
INSERT INTO `role_reso` VALUES ('366', '234', '融资租赁', '日期搜索', '日期搜索', null, null, null, null, null, null, null, '424', '我是描述', null, null, '366', null, null);
INSERT INTO `role_reso` VALUES ('367', '234', '融资租赁', '员工姓名搜索', '员工姓名搜索', null, null, null, null, null, null, null, '424', '我是描述', null, null, '367', null, null);
INSERT INTO `role_reso` VALUES ('368', '234', '融资租赁', '门店搜索', '门店搜索', null, null, null, null, null, null, null, '424', '我是描述', null, null, '368', null, null);
INSERT INTO `role_reso` VALUES ('369', '234', '融资租赁', '打印', '打印', null, null, null, null, null, null, null, '423', '我是描述', null, null, '369', null, null);
INSERT INTO `role_reso` VALUES ('370', '234', '融资租赁', '导出', '导出', null, null, null, null, null, null, null, '423', '我是描述', null, null, '370', null, null);
INSERT INTO `role_reso` VALUES ('371', '234', '融资租赁', '查看', '查看', null, null, null, null, null, null, null, '423', '我是描述', null, null, '371', null, null);
INSERT INTO `role_reso` VALUES ('392', '165', '融资租赁', '产品包查询data-box', '产品包查询data-box', null, null, null, null, null, null, null, '425', '我是描述', null, null, '392', null, null);
INSERT INTO `role_reso` VALUES ('393', '165', '融资租赁', '多条件查询', '多条件查询', null, null, null, null, null, null, null, '424', '我是描述', null, null, '393', null, null);
INSERT INTO `role_reso` VALUES ('394', '165', '融资租赁', '7条时间查询', '7条时间查询', null, null, null, null, null, null, null, '423', '我是描述', null, null, '394', null, null);
INSERT INTO `role_reso` VALUES ('395', '165', '融资租赁', '打印', '打印', null, null, null, null, null, null, null, '423', '我是描述', null, null, '395', null, null);
INSERT INTO `role_reso` VALUES ('396', '165', '融资租赁', '导出', '导出', null, null, null, null, null, null, null, '423', '我是描述', null, null, '396', null, null);
INSERT INTO `role_reso` VALUES ('397', '165', '融资租赁', '下载', '下载', null, null, null, null, null, null, null, '423', '我是描述', null, null, '397', null, null);
INSERT INTO `role_reso` VALUES ('398', '165', '融资租赁', '查看', '查看', null, null, null, null, null, null, null, '423', '我是描述', null, null, '398', null, null);
INSERT INTO `role_reso` VALUES ('399', '195', '融资租赁', '收款data-box', '收款data-box', null, null, null, null, null, null, null, '425', '我是描述', null, null, '399', null, null);
INSERT INTO `role_reso` VALUES ('400', '195', '融资租赁', '多条件查询', '多条件查询', null, null, null, null, null, null, null, '424', '我是描述', null, null, '400', null, null);
INSERT INTO `role_reso` VALUES ('401', '195', '融资租赁', '7条时间查询', '7条时间查询', null, null, null, null, null, null, null, '423', '我是描述', null, null, '401', null, null);
INSERT INTO `role_reso` VALUES ('402', '195', '融资租赁', '打印', '打印', null, null, null, null, null, null, null, '423', '我是描述', null, null, '402', null, null);
INSERT INTO `role_reso` VALUES ('403', '195', '融资租赁', '导出', '导出', null, null, null, null, null, null, null, '423', '我是描述', null, null, '403', null, null);
INSERT INTO `role_reso` VALUES ('404', '195', '融资租赁', '确认收款', '确认收款', null, null, null, null, null, null, null, '423', '我是描述', null, null, '404', null, null);
INSERT INTO `role_reso` VALUES ('405', '196', '融资租赁', '付款data-box', '付款data-box', null, null, null, null, null, null, null, '425', '我是描述', null, null, '405', null, null);
INSERT INTO `role_reso` VALUES ('406', '196', '融资租赁', '多条件查询', '多条件查询', null, null, null, null, null, null, null, '424', '我是描述', null, null, '406', null, null);
INSERT INTO `role_reso` VALUES ('407', '196', '融资租赁', '7条时间查询', '7条时间查询', null, null, null, null, null, null, null, '423', '我是描述', null, null, '407', null, null);
INSERT INTO `role_reso` VALUES ('408', '196', '融资租赁', '打印', '打印', null, null, null, null, null, null, null, '423', '我是描述', null, null, '408', null, null);
INSERT INTO `role_reso` VALUES ('409', '196', '融资租赁', '导出', '导出', null, null, null, null, null, null, null, '423', '我是描述', null, null, '409', null, null);
INSERT INTO `role_reso` VALUES ('410', '196', '融资租赁', '确认付款', '确认付款', null, null, null, null, null, null, null, '423', '我是描述', null, null, '410', null, null);
INSERT INTO `role_reso` VALUES ('411', '196', '融资租赁', '查看', '查看', null, null, null, null, null, null, null, '423', '我是描述', null, null, '411', null, null);
INSERT INTO `role_reso` VALUES ('412', '198', '融资租赁', '客户还款data-box', '客户还款data-box', null, null, null, null, null, null, null, '425', '我是描述', null, null, '412', null, null);
INSERT INTO `role_reso` VALUES ('413', '198', '融资租赁', '多条件查询', '多条件查询', null, null, null, null, null, null, null, '424', '我是描述', null, null, '413', null, null);
INSERT INTO `role_reso` VALUES ('414', '198', '融资租赁', '7条时间查询', '7条时间查询', null, null, null, null, null, null, null, '423', '我是描述', null, null, '414', null, null);
INSERT INTO `role_reso` VALUES ('415', '198', '融资租赁', '打印', '打印', null, null, null, null, null, null, null, '423', '我是描述', null, null, '415', null, null);
INSERT INTO `role_reso` VALUES ('416', '198', '融资租赁', '导出', '导出', null, null, null, null, null, null, null, '423', '我是描述', null, null, '416', null, null);
INSERT INTO `role_reso` VALUES ('417', '198', '融资租赁', '确认付款', '确认付款', null, null, null, null, null, null, null, '423', '我是描述', null, null, '417', null, null);
INSERT INTO `role_reso` VALUES ('418', '198', '融资租赁', '还款详情', '还款详情', null, null, null, null, null, null, null, '423', '我是描述', null, null, '418', null, null);
INSERT INTO `role_reso` VALUES ('419', '198', '融资租赁', '划扣记录', '划扣记录', null, null, null, null, null, null, null, '423', '我是描述', null, null, '419', null, null);
INSERT INTO `role_reso` VALUES ('420', '199', '融资租赁', '提前结清data-box', '提前结清data-box', null, null, null, null, null, null, null, '425', '我是描述', null, null, '420', null, null);
INSERT INTO `role_reso` VALUES ('421', '199', '融资租赁', '多条件查询', '多条件查询', null, null, null, null, null, null, null, '424', '我是描述', null, null, '421', null, null);
INSERT INTO `role_reso` VALUES ('422', '199', '融资租赁', '7条时间查询', '7条时间查询', null, null, null, null, null, null, null, '423', '我是描述', null, null, '422', null, null);
INSERT INTO `role_reso` VALUES ('423', '199', '融资租赁', '打印', '打印', null, null, null, null, null, null, null, '423', '我是描述', null, null, '423', null, null);
INSERT INTO `role_reso` VALUES ('424', '199', '融资租赁', '导出', '导出', null, null, null, null, null, null, null, '423', '我是描述', null, null, '424', null, null);
INSERT INTO `role_reso` VALUES ('425', '199', '融资租赁', '确认结清', '确认结清', null, null, null, null, null, null, null, '423', '我是描述', null, null, '425', null, null);
INSERT INTO `role_reso` VALUES ('426', '199', '融资租赁', '还款详情', '还款详情', null, null, null, null, null, null, null, '423', '我是描述', null, null, '426', null, null);
INSERT INTO `role_reso` VALUES ('427', '199', '融资租赁', '划扣记录', '划扣记录', null, null, null, null, null, null, null, '423', '我是描述', null, null, '427', null, null);
INSERT INTO `role_reso` VALUES ('428', '200', '融资租赁', '提前收回data-box', '提前收回data-box', null, null, null, null, null, null, null, '425', '我是描述', null, null, '428', null, null);
INSERT INTO `role_reso` VALUES ('429', '200', '融资租赁', '多条件查询', '多条件查询', null, null, null, null, null, null, null, '424', '我是描述', null, null, '429', null, null);
INSERT INTO `role_reso` VALUES ('430', '200', '融资租赁', '7条时间查询', '7条时间查询', null, null, null, null, null, null, null, '423', '我是描述', null, null, '430', null, null);
INSERT INTO `role_reso` VALUES ('431', '200', '融资租赁', '打印', '打印', null, null, null, null, null, null, null, '423', '我是描述', null, null, '431', null, null);
INSERT INTO `role_reso` VALUES ('432', '200', '融资租赁', '导出', '导出', null, null, null, null, null, null, null, '423', '我是描述', null, null, '432', null, null);
INSERT INTO `role_reso` VALUES ('433', '200', '融资租赁', '确认收回', '确认收回', null, null, null, null, null, null, null, '423', '我是描述', null, null, '433', null, null);
INSERT INTO `role_reso` VALUES ('434', '200', '融资租赁', '还款详情', '还款详情', null, null, null, null, null, null, null, '423', '我是描述', null, null, '434', null, null);
INSERT INTO `role_reso` VALUES ('435', '201', '融资租赁', '已结清订单查询data-box', '已结清订单查询data-box', null, null, null, null, null, null, null, '425', '我是描述', null, null, '435', null, null);
INSERT INTO `role_reso` VALUES ('436', '201', '融资租赁', '多条件查询', '多条件查询', null, null, null, null, null, null, null, '424', '我是描述', null, null, '436', null, null);
INSERT INTO `role_reso` VALUES ('437', '201', '融资租赁', '7条时间查询', '7条时间查询', null, null, null, null, null, null, null, '423', '我是描述', null, null, '437', null, null);
INSERT INTO `role_reso` VALUES ('438', '201', '融资租赁', '打印', '打印', null, null, null, null, null, null, null, '423', '我是描述', null, null, '438', null, null);
INSERT INTO `role_reso` VALUES ('439', '201', '融资租赁', '导出', '导出', null, null, null, null, null, null, null, '423', '我是描述', null, null, '439', null, null);
INSERT INTO `role_reso` VALUES ('440', '201', '融资租赁', '还款详情', '还款详情', '', null, null, '', '', '', null, '423', null, null, null, '440', null, null);
INSERT INTO `role_reso` VALUES ('441', '497', '融资租赁', '付款记录查询', '付款记录查询', null, null, null, 'purchase/finance-account/payment-record-querypurchase/finance-account/payment-record-query', null, null, null, '421', null, null, null, '441', null, '4');
INSERT INTO `role_reso` VALUES ('442', '170', '融资租赁', '日期搜索', '日期搜索', null, null, null, null, null, null, null, '424', null, null, null, '442', null, '1');
INSERT INTO `role_reso` VALUES ('443', '170', '融资租赁', '全部收款类型', '全部收款类型', null, null, null, null, null, null, null, '424', null, null, null, '443', null, '2');
INSERT INTO `role_reso` VALUES ('444', '170', '融资租赁', '申请状态', '申请状态', null, null, null, null, null, null, null, '424', null, null, null, '444', null, '3');
INSERT INTO `role_reso` VALUES ('445', '170', '融资租赁', '包含已归档订单', '包含已归档订单', null, null, null, null, null, null, null, '424', null, null, null, '445', null, '4');
INSERT INTO `role_reso` VALUES ('446', '170', '融资租赁', '查看', '查看', null, null, null, null, null, null, null, '423', null, null, null, '446', null, '5');
INSERT INTO `role_reso` VALUES ('447', '170', '融资租赁', '收款记录查询data-box', '收款记录查询data-box', null, null, null, null, null, null, null, '425', null, null, null, '447', null, '6');
INSERT INTO `role_reso` VALUES ('448', '170', '融资租赁', '订单编号', '订单编号', null, null, null, null, null, null, null, '424', null, null, null, '448', null, '7');
INSERT INTO `role_reso` VALUES ('449', '441', '融资租赁', '日期搜索', '日期搜索', null, null, null, null, null, null, null, '424', null, null, null, '449', null, '1');
INSERT INTO `role_reso` VALUES ('450', '441', '融资租赁', '全部付款类型', '全部付款类型', null, null, null, null, null, null, null, '424', null, null, null, '450', null, '2');
INSERT INTO `role_reso` VALUES ('451', '441', '融资租赁', '申请状态', '申请状态', null, null, null, null, null, null, null, '424', null, null, null, '451', null, '3');
INSERT INTO `role_reso` VALUES ('452', '441', '融资租赁', '包含已归档订单', '包含已归档订单', null, null, null, null, null, null, null, '424', null, null, null, '452', null, '4');
INSERT INTO `role_reso` VALUES ('453', '441', '融资租赁', '查看', '查看', null, null, null, null, null, null, null, '423', null, null, null, '453', null, '5');
INSERT INTO `role_reso` VALUES ('454', '441', '融资租赁', '订单编号', '订单编号', null, null, null, null, null, null, null, '424', null, null, null, '454', null, '6');
INSERT INTO `role_reso` VALUES ('455', '441', '融资租赁', '付款记录查询data-box', '付款记录查询data-box', null, null, null, null, null, null, null, '425', null, null, null, '455', null, '7');
INSERT INTO `role_reso` VALUES ('456', '203', '融资租赁', '个人开户列表data-box', '个人开户列表data-box', null, null, null, null, null, null, null, '425', null, null, null, '456', null, null);
INSERT INTO `role_reso` VALUES ('457', '203', '融资租赁', '多条件查询', '多条件查询', null, null, null, null, null, null, null, '424', null, null, null, '457', null, null);
INSERT INTO `role_reso` VALUES ('458', '203', '融资租赁', '7条时间查询', '7条时间查询', null, null, null, null, null, null, null, '423', null, null, null, '458', null, null);
INSERT INTO `role_reso` VALUES ('459', '203', '融资租赁', '导出', '导出', null, null, null, null, null, null, null, '423', null, null, null, '459', null, null);
INSERT INTO `role_reso` VALUES ('460', '203', '融资租赁', '客户开户', '客户开户', null, null, null, null, null, null, null, '423', null, null, null, '460', null, null);
INSERT INTO `role_reso` VALUES ('461', '203', '融资租赁', '银行卡信息', '银行卡信息', null, null, null, null, null, null, null, '423', null, null, null, '461', null, null);
INSERT INTO `role_reso` VALUES ('462', '203', '融资租赁', '划扣', '划扣', null, null, null, null, null, null, null, '423', null, null, null, '462', null, null);
INSERT INTO `role_reso` VALUES ('463', '204', '融资租赁', '划扣记录查询data-box', '划扣记录查询data-box', null, null, null, null, null, null, null, '425', null, null, null, '463', null, null);
INSERT INTO `role_reso` VALUES ('464', '204', '融资租赁', '多条件查询', '多条件查询', null, null, null, null, null, null, null, '424', null, null, null, '464', null, null);
INSERT INTO `role_reso` VALUES ('465', '204', '融资租赁', '导出', '导出', null, null, null, null, null, null, null, '423', null, null, null, '465', null, null);
INSERT INTO `role_reso` VALUES ('466', '163', '融资租赁', '订单查询', '订单查询', null, null, null, null, null, null, null, '425', null, null, null, '466', null, '1');
INSERT INTO `role_reso` VALUES ('467', '163', '融资租赁', '7条时间查询', '7条时间查询', null, null, null, null, null, null, null, '423', null, null, null, '467', null, '2');
INSERT INTO `role_reso` VALUES ('468', '163', '融资租赁', '多条件查询', '多条件查询', null, null, null, null, null, null, null, '424', null, null, null, '468', null, '3');
INSERT INTO `role_reso` VALUES ('469', '163', '融资租赁', '日期搜索', '日期搜索', null, null, null, null, null, null, null, '424', null, null, null, '469', null, '4');
INSERT INTO `role_reso` VALUES ('470', '163', '融资租赁', '进度查询', '进度查询', null, null, null, null, null, null, null, '423', null, null, null, '470', null, '5');
INSERT INTO `role_reso` VALUES ('471', '163', '融资租赁', '申请收款', '申请收款', null, null, null, null, null, null, null, '423', null, null, null, '471', null, '6');
INSERT INTO `role_reso` VALUES ('472', '163', '融资租赁', '编辑', '编辑', null, null, null, null, null, null, null, '423', null, null, null, '472', null, '7');
INSERT INTO `role_reso` VALUES ('473', '498', '融资租赁', '导出模版管理', '导出模版管理', null, null, null, ' base/base-data/export-template-manage', null, null, null, '421', null, null, null, '473', null, '6');
INSERT INTO `role_reso` VALUES ('474', '473', '融资租赁', '模板名称', '模板名称', null, null, null, null, null, null, null, '425', null, null, null, '474', null, null);
INSERT INTO `role_reso` VALUES ('475', '193', '融资租赁', '评估申请', '评估申请', null, null, null, 'purchase/purchase-manage/evaluation-application.tsx', null, null, null, '421', null, null, null, '475', null, '1');
INSERT INTO `role_reso` VALUES ('476', '193', '融资租赁', '评估任务池', '评估任务池', null, null, null, 'purchase/purchase-manage/evaluation-task-pool', null, null, null, '421', null, null, null, '476', null, '2');
INSERT INTO `role_reso` VALUES ('477', '193', '融资租赁', '押品评估', '押品评估', null, null, null, 'purchase/purchase-manage/evaluation-of-collateral', null, null, null, '421', null, null, null, '477', null, '3');
INSERT INTO `role_reso` VALUES ('478', '500', '融资租赁', '冲抵配置', '冲抵配置', null, null, null, 'base/base-data/flushing-config', null, null, null, '421', null, null, null, '478', null, '3');
INSERT INTO `role_reso` VALUES ('479', '10000', '融资租赁', '审核管理', '审核管理', null, null, null, null, null, null, null, '429', null, null, null, '479', null, '5');
INSERT INTO `role_reso` VALUES ('481', '496', '融资租赁', '押品入库', '押品入库', null, null, null, 'inventory-management/inventory-data/goods-in-treasury', null, null, null, '421', null, null, null, '481', null, '1');
INSERT INTO `role_reso` VALUES ('482', '496', '融资租赁', '押品出库', '押品出库', null, null, null, 'inventory-management/inventory-data/goods-out-treasury', null, null, null, '421', null, null, null, '482', null, '2');
INSERT INTO `role_reso` VALUES ('483', '10000', '融资租赁', '开户签约', '开户签约', null, null, null, null, null, null, null, '429', null, null, null, '483', null, '6');
INSERT INTO `role_reso` VALUES ('485', '155', '融资租赁', '个人意向客户', '个人意向客户', null, null, null, 'customer-center/customer-data/personal-client', null, null, null, '421', null, null, null, '485', null, '1');
INSERT INTO `role_reso` VALUES ('486', '155', '融资租赁', '个人正式客户', '个人正式客户', null, null, null, 'customer-center/customer-data/personal-customer', null, null, null, '421', null, null, null, '486', null, '2');
INSERT INTO `role_reso` VALUES ('487', '155', '融资租赁', '个人黑名单', '个人黑名单', null, null, null, 'customer-center/customer-data/personal-blacklist', null, null, null, '421', null, null, null, '487', null, '3');
INSERT INTO `role_reso` VALUES ('488', '155', '融资租赁', '企业意向客户', '企业意向客户', null, null, null, 'customer-center/customer-data/enterprise-intent-customer', null, null, null, '421', null, null, null, '488', null, '4');
INSERT INTO `role_reso` VALUES ('489', '155', '融资租赁', '企业正式客户', '企业正式客户', null, null, null, 'customer-center/customer-data/enterprise-formal-customer', null, null, null, '421', null, null, null, '489', null, '5');
INSERT INTO `role_reso` VALUES ('490', '155', '融资租赁', '企业黑名单', '企业黑名单', null, null, null, 'customer-center/customer-data/enterprises-blacklist', null, null, null, '421', null, null, null, '490', null, '6');
INSERT INTO `role_reso` VALUES ('492', '214', '融资租赁', '企业抵押贷款申请', '企业抵押贷款申请', null, null, null, 'purchase/mortgage/enterprise-mortgage-application', null, null, null, '421', null, null, null, '492', null, '2');
INSERT INTO `role_reso` VALUES ('493', '214', '融资租赁', '个人抵押贷款申请', '个人抵押贷款申请', null, null, null, 'purchase/mortgage/personal-mortgage-application', null, null, null, '421', null, null, null, '493', null, '1');
INSERT INTO `role_reso` VALUES ('494', '10000', '融资租赁', '运营管理', '运营管理', null, null, null, null, null, null, null, '429', null, null, null, '494', null, '7');
INSERT INTO `role_reso` VALUES ('495', '10000', '融资租赁', '财务管理', '财务管理', null, null, null, null, null, null, null, '429', null, null, null, '495', null, '8');
INSERT INTO `role_reso` VALUES ('496', '10000', '融资租赁', '库存管理', '库存管理', null, null, null, null, null, null, null, '429', null, null, null, '496', null, '9');
INSERT INTO `role_reso` VALUES ('497', '10000', '融资租赁', '综合查询', '综合查询', null, null, null, null, null, null, null, '429', null, null, null, '497', null, '10');
INSERT INTO `role_reso` VALUES ('498', '10000', '融资租赁', '基础数据', '基础数据', null, null, null, null, null, null, null, '429', null, null, null, '498', null, '11');
INSERT INTO `role_reso` VALUES ('499', '10000', '融资租赁', '系统管理', '系统管理', null, null, null, null, null, null, null, '429', null, null, null, '499', null, '12');
INSERT INTO `role_reso` VALUES ('500', '10000', '融资租赁', '配置管理', '配置管理', null, null, null, null, null, null, null, '429', null, null, null, '500', null, '13');
INSERT INTO `role_reso` VALUES ('501', '10000', '融资租赁', '报表统计', '报表统计', null, null, null, null, null, null, null, '429', null, null, null, '501', null, '14');
INSERT INTO `role_reso` VALUES ('502', '498', '指旺汽车金融', '产品包管理', '产品包管理', null, null, null, 'base/base-data/prod-package-info', null, '', null, '421', '我是描述', null, null, '502', null, '7');
INSERT INTO `role_reso` VALUES ('10000', '0', '融资租赁', '汽车金融', '汽车金融', null, null, null, null, null, null, null, '428', '我是描述', null, null, '10000', null, '5');
