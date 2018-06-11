-- --2017-09-25
-- --新增数据库备份表
-- --胡开甲
-- DROP TABLE IF EXISTS `system_backup`;
-- CREATE TABLE `system_backup` (
--   `id` varchar(64) NOT NULL,
--   `company_code` varchar(64) DEFAULT NULL COMMENT '公司的标识',
--   `type` int(4) DEFAULT NULL COMMENT '备份类型 0：自动 1：手动',
--   `mysql_name` varchar(255) DEFAULT NULL COMMENT 'mysql数据库文件名称',
--   `mongdb_name` varchar(255) DEFAULT NULL COMMENT 'mongdb数据库名称',
--   `operator` varchar(200) DEFAULT NULL COMMENT '操作人',
--   `operate_time` datetime DEFAULT NULL COMMENT '备份时间',
--   PRIMARY KEY (`id`)
-- ) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--运维设置删除的
INSERT INTO `carfl_dev`.`role_reso` (`id`, `reso_pid`, `reso_sysname`, `reso_init_name`, `reso_name`, `reso_code`, `reso_level`, `reso_status`, `reso_path`, `reso_init_icon`, `reso_icon`, `reso_type`, `reso_filetype`, `reso_remark`, `operator`, `operate_time`, `flag`, `color`, `sort`) VALUES ('35', '1', '指旺汽车金融', '运维设置', '运维设置', NULL, NULL, NULL, 'system-manage/operation-config', 'yunweishezhi', 'yunweishezhi', NULL, '422', '我是描述', NULL, NULL, '35', '#36B48C', '2');
INSERT INTO `carfl_dev`.`role_reso` (`id`, `reso_pid`, `reso_sysname`, `reso_init_name`, `reso_name`, `reso_code`, `reso_level`, `reso_status`, `reso_path`, `reso_init_icon`, `reso_icon`, `reso_type`, `reso_filetype`, `reso_remark`, `operator`, `operate_time`, `flag`, `color`, `sort`) VALUES ('36', '35', '指旺汽车金融', '客户还款撤销', '客户还款撤销', NULL, NULL, NULL, 'system-manage/operation-config/customer-repay-revert', NULL, NULL, NULL, '421', '我是描述', NULL, NULL, '36', NULL, '2');
INSERT INTO `carfl_dev`.`role_reso` (`id`, `reso_pid`, `reso_sysname`, `reso_init_name`, `reso_name`, `reso_code`, `reso_level`, `reso_status`, `reso_path`, `reso_init_icon`, `reso_icon`, `reso_type`, `reso_filetype`, `reso_remark`, `operator`, `operate_time`, `flag`, `color`, `sort`) VALUES ('37', '36', '指旺汽车金融', '客户姓名', '客户姓名', NULL, NULL, NULL, NULL, NULL, NULL, NULL, '424', '我是描述', NULL, NULL, '37', NULL, NULL);
INSERT INTO `carfl_dev`.`role_reso` (`id`, `reso_pid`, `reso_sysname`, `reso_init_name`, `reso_name`, `reso_code`, `reso_level`, `reso_status`, `reso_path`, `reso_init_icon`, `reso_icon`, `reso_type`, `reso_filetype`, `reso_remark`, `operator`, `operate_time`, `flag`, `color`, `sort`) VALUES ('38', '36', '指旺汽车金融', '证件号码', '证件号码', NULL, NULL, NULL, NULL, NULL, NULL, NULL, '424', '我是描述', NULL, NULL, '38', NULL, NULL);
INSERT INTO `carfl_dev`.`role_reso` (`id`, `reso_pid`, `reso_sysname`, `reso_init_name`, `reso_name`, `reso_code`, `reso_level`, `reso_status`, `reso_path`, `reso_init_icon`, `reso_icon`, `reso_type`, `reso_filetype`, `reso_remark`, `operator`, `operate_time`, `flag`, `color`, `sort`) VALUES ('39', '36', '指旺汽车金融', '联系号码', '联系号码', NULL, NULL, NULL, NULL, NULL, NULL, NULL, '424', '我是描述', NULL, NULL, '39', NULL, NULL);
INSERT INTO `carfl_dev`.`role_reso` (`id`, `reso_pid`, `reso_sysname`, `reso_init_name`, `reso_name`, `reso_code`, `reso_level`, `reso_status`, `reso_path`, `reso_init_icon`, `reso_icon`, `reso_type`, `reso_filetype`, `reso_remark`, `operator`, `operate_time`, `flag`, `color`, `sort`) VALUES ('40', '36', '指旺汽车金融', '订单编号', '订单编号', NULL, NULL, NULL, NULL, NULL, NULL, NULL, '424', '我是描述', NULL, NULL, '40', NULL, NULL);
INSERT INTO `carfl_dev`.`role_reso` (`id`, `reso_pid`, `reso_sysname`, `reso_init_name`, `reso_name`, `reso_code`, `reso_level`, `reso_status`, `reso_path`, `reso_init_icon`, `reso_icon`, `reso_type`, `reso_filetype`, `reso_remark`, `operator`, `operate_time`, `flag`, `color`, `sort`) VALUES ('41', '36', '指旺汽车金融', '搜索', '搜索', NULL, NULL, NULL, NULL, NULL, NULL, NULL, '423', '我是描述', NULL, NULL, '41', NULL, NULL);
INSERT INTO `carfl_dev`.`role_reso` (`id`, `reso_pid`, `reso_sysname`, `reso_init_name`, `reso_name`, `reso_code`, `reso_level`, `reso_status`, `reso_path`, `reso_init_icon`, `reso_icon`, `reso_type`, `reso_filetype`, `reso_remark`, `operator`, `operate_time`, `flag`, `color`, `sort`) VALUES ('42', '36', '指旺汽车金融', '客户还款撤销列表', '客户还款撤销列表', NULL, NULL, NULL, NULL, NULL, NULL, NULL, '425', '我是描述', NULL, NULL, '42', NULL, NULL);
INSERT INTO `carfl_dev`.`role_reso` (`id`, `reso_pid`, `reso_sysname`, `reso_init_name`, `reso_name`, `reso_code`, `reso_level`, `reso_status`, `reso_path`, `reso_init_icon`, `reso_icon`, `reso_type`, `reso_filetype`, `reso_remark`, `operator`, `operate_time`, `flag`, `color`, `sort`) VALUES ('43', '35', '指旺汽车金融', '订单状态变更', '订单状态变更', NULL, NULL, NULL, 'system-manage/operation-config/order-status-change', NULL, NULL, NULL, '421', '我是描述', NULL, NULL, '43', NULL, '1');
INSERT INTO `carfl_dev`.`role_reso` (`id`, `reso_pid`, `reso_sysname`, `reso_init_name`, `reso_name`, `reso_code`, `reso_level`, `reso_status`, `reso_path`, `reso_init_icon`, `reso_icon`, `reso_type`, `reso_filetype`, `reso_remark`, `operator`, `operate_time`, `flag`, `color`, `sort`) VALUES ('44', '43', '指旺汽车金融', '客户姓名', '客户姓名', NULL, NULL, NULL, NULL, NULL, NULL, NULL, '424', '我是描述', NULL, NULL, '44', NULL, NULL);
INSERT INTO `carfl_dev`.`role_reso` (`id`, `reso_pid`, `reso_sysname`, `reso_init_name`, `reso_name`, `reso_code`, `reso_level`, `reso_status`, `reso_path`, `reso_init_icon`, `reso_icon`, `reso_type`, `reso_filetype`, `reso_remark`, `operator`, `operate_time`, `flag`, `color`, `sort`) VALUES ('45', '43', '指旺汽车金融', '证件号码', '证件号码', NULL, NULL, NULL, NULL, NULL, NULL, NULL, '424', '我是描述', NULL, NULL, '45', NULL, NULL);
INSERT INTO `carfl_dev`.`role_reso` (`id`, `reso_pid`, `reso_sysname`, `reso_init_name`, `reso_name`, `reso_code`, `reso_level`, `reso_status`, `reso_path`, `reso_init_icon`, `reso_icon`, `reso_type`, `reso_filetype`, `reso_remark`, `operator`, `operate_time`, `flag`, `color`, `sort`) VALUES ('46', '43', '指旺汽车金融', '联系号码', '联系号码', NULL, NULL, NULL, NULL, NULL, NULL, NULL, '424', '我是描述', NULL, NULL, '46', NULL, NULL);
INSERT INTO `carfl_dev`.`role_reso` (`id`, `reso_pid`, `reso_sysname`, `reso_init_name`, `reso_name`, `reso_code`, `reso_level`, `reso_status`, `reso_path`, `reso_init_icon`, `reso_icon`, `reso_type`, `reso_filetype`, `reso_remark`, `operator`, `operate_time`, `flag`, `color`, `sort`) VALUES ('47', '43', '指旺汽车金融', '订单编号', '订单编号', NULL, NULL, NULL, NULL, NULL, NULL, NULL, '424', '我是描述', NULL, NULL, '47', NULL, NULL);
INSERT INTO `carfl_dev`.`role_reso` (`id`, `reso_pid`, `reso_sysname`, `reso_init_name`, `reso_name`, `reso_code`, `reso_level`, `reso_status`, `reso_path`, `reso_init_icon`, `reso_icon`, `reso_type`, `reso_filetype`, `reso_remark`, `operator`, `operate_time`, `flag`, `color`, `sort`) VALUES ('48', '43', '指旺汽车金融', '订单状态变更列表', '订单状态变更列表', NULL, NULL, NULL, NULL, NULL, NULL, NULL, '425', '我是描述', NULL, NULL, '48', NULL, NULL);
INSERT INTO `carfl_dev`.`role_reso` (`id`, `reso_pid`, `reso_sysname`, `reso_init_name`, `reso_name`, `reso_code`, `reso_level`, `reso_status`, `reso_path`, `reso_init_icon`, `reso_icon`, `reso_type`, `reso_filetype`, `reso_remark`, `operator`, `operate_time`, `flag`, `color`, `sort`) VALUES ('49', '43', '指旺汽车金融', '搜索', '搜索', NULL, NULL, NULL, NULL, NULL, NULL, NULL, '423', '我是描述', NULL, NULL, '49', NULL, NULL);


-- 2018-2-11
-- schedule_job 表添加running字段
-- Add by peng.cx
ALTER TABLE schedule_job ADD running SMALLINT(4) DEFAULT 0 COMMENT '是否正在跑批 0-未跑批 1-正在跑批' AFTER is_async;

-- 2018-2-12
-- collect_money_detail 表添加client_number字段
-- Add by peng.cx
ALTER TABLE collect_money_detail ADD client_number VARCHAR(64) COMMENT '客户号' AFTER defray_card_number;

-- 2018-2-12
-- 吴小川
-- 修改划扣记录表（charge_back_recode），增加字段
ALTER TABLE `charge_back_recode`
ADD COLUMN `deposit_bank`  varchar(64) NULL AFTER `operator_time`,
ADD COLUMN `client_number`  varchar(64) NULL AFTER `deposit_bank`,
ADD COLUMN `card_number`  varchar(64) NULL AFTER `client_number`;

-- 2018-2-12
-- schedule_job 表添加job_description字段
-- Add by peng.cx
ALTER TABLE schedule_job ADD job_description VARCHAR(200) COMMENT '任务描述' AFTER job_group;


-- 2018-2-22
-- 吴小川
-- 增加模板配置表
CREATE TABLE `template` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `template_code` varchar(40) DEFAULT NULL COMMENT '模板编号',
  `template_name` varchar(50) DEFAULT NULL COMMENT '模板名称',
  `is_default` int(2) DEFAULT NULL COMMENT '是否是默认模板',
  `template_style` int(10) DEFAULT NULL COMMENT '模板形式',
  `template_type` int(10) DEFAULT NULL COMMENT '模板类别',
  `template_status` int(10) DEFAULT NULL COMMENT '模板状态',
  `template_content` varchar(255) DEFAULT NULL COMMENT '模板内容',
  `operator` bigint(20) DEFAULT NULL COMMENT '操作人',
  `operate_time` datetime DEFAULT NULL COMMENT '操作时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='模板配置表';


-- 2018-2-23
-- 吴小川
-- 修改模板配置表，增加模板路径字段
ALTER TABLE `template`
ADD COLUMN `template_url`  varchar(255) NULL AFTER `operate_time`;
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='模板配置表';ALTER TABLE schedule_job ADD job_description VARCHAR(200) COMMENT '任务描述' AFTER job_group;

-- 2018-2-22
-- withdraw_application 表添加final_cash字段
-- Add by peng.cx
ALTER TABLE withdraw_application add final_cash DECIMAL(18,4) COMMENT '尾付款' AFTER  initial_payment;

-- 2018-2-24
-- collect_money_history 表添加remark字段
-- Add by peng.cx
ALTER TABLE collect_money_history add remark VARCHAR(200) COMMENT '备注' AFTER  start_term;
-- 2018-2-27
-- 吴小川
-- 修改订单表，增加销售员ID字段
ALTER TABLE `product_order`
ADD COLUMN `salesman_id`  bigint(20) NULL COMMENT '销售员ID' AFTER `remark`;


-- 2018-2-28
-- 吴小川
-- 修改订单表，增加生效类型字段
ALTER TABLE `product_order`
ADD COLUMN `effective_type`  int(20) NULL COMMENT '生效类型' AFTER `salesman_id`;


-- 2018-3-1
-- 吴小川
-- 修改付款申请表，增加处理状态字段
ALTER TABLE `refund_application`
ADD COLUMN `process_status`  int(4) NULL COMMENT '处理状态' AFTER `operator_time`;


-- 2018-3-2
-- 吴小川
-- 修改客户表，增加默认通道字段
ALTER TABLE `personal`
ADD COLUMN `default_channel`  int(4) NULL COMMENT '默认通道' AFTER `is_delete`;



--2018-03-02
--夏群
--产品报表新增是否删除字段
ALTER TABLE `product_package`
ADD COLUMN `is_delete`  int(4) NULL DEFAULT 1 COMMENT '是否删除 0-是 1-不是' AFTER `data_type`;

--2018-03-07
--夏群
--修改产品计划表字段默认值
ALTER TABLE `product_plan_issue`
MODIFY COLUMN `product_rate`  decimal(18,4) NULL DEFAULT NULL COMMENT '产品利率(%/月)' AFTER `payment_type`,
MODIFY COLUMN `penalty_rate`  decimal(18,4) NULL DEFAULT NULL COMMENT '罚息费率' AFTER `overdue_protect_days`,
MODIFY COLUMN `contract_break_rate`  decimal(18,4) NULL DEFAULT NULL COMMENT '合同违约金费率' AFTER `penalty_rate`,
MODIFY COLUMN `prepayment_rate`  decimal(18,4) NULL DEFAULT NULL COMMENT '提前还款费率' AFTER `contract_break_rate`;

--2018-03-07
--白章宇
--修改账户类型 类型
ALTER TABLE `personal_bank`
MODIFY COLUMN `account_type`  int(4) NULL DEFAULT NULL COMMENT '账户类型' AFTER `client_number`;

--2018-03-08
--彭长须
--添加结清类型数据字典
insert into data_dict_type values(118,'0118','结清类型',0);
insert into data_dict values(185,'0118',NULL,'正常结清',1);
insert into data_dict values(186,'0118',NULL,'提前结清',2);
insert into data_dict values(187,'0118',NULL,'提前收回',3);

--2018-03-09
--彭长须
--添加结清类型数据字典
insert into data_dict values(324,'0302',NULL,'已归档',21);
insert into data_dict values(182,'0104',NULL,'提前结清',5);
insert into data_dict values(183,'0104',NULL,'提前收回',6);

--2018-03-13
--彭长须
--添加收款项数据字典
insert into data_dict values(159,'0113',NULL,'月租金',22);
insert into data_dict values(188,'0109',NULL,'财务开票',23);
insert into data_dict_type values(119, '0119', '开票状态', 0);
insert into data_dict values(190, '0119', NULL, '未开票', 1);
insert into data_dict values(191, '0119', NULL, '已开票', 2);
insert into data_dict values(192, '0119', NULL, '开票撤销', 3);

--新增财务开票表
drop table if exists finance_invoice;

/*==============================================================*/
/* Table: finance_invoice                                       */
/*==============================================================*/
create table finance_invoice
(
   id                   bigint(20) not null comment '主键',
   collect_money_detail_id bigint(20) comment '收款明细Id',
   invoice_number       varchar(50) comment '发票号',
   invoicing_amount     decimal(18,4) comment '开票金额',
   invoicing_date       datetime comment '开票日期',
   invoice_title        varchar(500) comment '发票抬头',
   is_undo              tinyint comment '是否已撤销(0-正常，1-已撤销)',
   remark               varchar(2000) comment '备注',
   operator             bigint(20) comment '操作人',
   operator_date        datetime comment '操作时间',
   primary key (id)
);
alter table finance_invoice comment '财务开票'

--修改收款历史表 添加还款期数
ALTER TABLE `collect_money_history`
ADD COLUMN `periods`  int(4) NULL COMMENT '还款期数' AFTER `start_term`;
--修改收款明细表 添加开票状态
ALTER TABLE `collect_money_detail`
ADD COLUMN `invoicing_status`  int(4) NULL COMMENT '开票状态' AFTER `deal_status`;


-- 2018-03-15
--新增意向期数数据字典项
INSERT INTO `data_dict_type` (`id`, `code`, `name`, `type`) VALUES ('314', '0314', '意向期数', '0');

INSERT INTO `data_dict` (`id`, `type_code`, `code`, `name`, `sort`) VALUES ('440', '0314', NULL, '12期', '0');
INSERT INTO `data_dict` (`id`, `type_code`, `code`, `name`, `sort`) VALUES ('441', '0314', NULL, '24期', '1');
INSERT INTO `data_dict` (`id`, `type_code`, `code`, `name`, `sort`) VALUES ('442', '0314', NULL, '36期', '2');

-- 2018-03-15
--夏群
--新增数据字典
INSERT INTO  `data_dict` (`id`, `type_code`, `code`, `name`, `sort`) VALUES ('1170', '0435', NULL, '12', '0');
INSERT INTO  `data_dict` (`id`, `type_code`, `code`, `name`, `sort`) VALUES ('1171', '0435', NULL, '24', '1');
INSERT INTO  `data_dict` (`id`, `type_code`, `code`, `name`, `sort`) VALUES ('1172', '0435', NULL, '36', '2');

INSERT INTO  `data_dict_type` (`id`, `code`, `name`, `type`) VALUES ('435', '0435', '产品期数', '0');
-- 2018-03-16
-- 党文祥
-- 新增列配置
INSERT INTO  `user_reso` (`id`, `reso_id`, `reso_pid`, `reso_name`, `reso_code`, `sort`) VALUES ('403', '403', '48', '客户姓名', 'personalName', '1');
INSERT INTO  `user_reso` (`id`, `reso_id`, `reso_pid`, `reso_name`, `reso_code`, `sort`) VALUES ('404', '404', '48', '环节', 'orderLink', '2');
INSERT INTO  `user_reso` (`id`, `reso_id`, `reso_pid`, `reso_name`, `reso_code`, `sort`) VALUES ('405', '405', '48', '证件号码', 'idCard', '3');
INSERT INTO  `user_reso` (`id`, `reso_id`, `reso_pid`, `reso_name`, `reso_code`, `sort`) VALUES ('406', '406', '48', '联系号码', 'mobileMain', '4');
INSERT INTO  `user_reso` (`id`, `reso_id`, `reso_pid`, `reso_name`, `reso_code`, `sort`) VALUES ('407', '407', '48', '订单创建时间', 'createTime', '5');
INSERT INTO  `user_reso` (`id`, `reso_id`, `reso_pid`, `reso_name`, `reso_code`, `sort`) VALUES ('408', '408', '48', '订单编号', 'orderNumber', '6');
INSERT INTO  `user_reso` (`id`, `reso_id`, `reso_pid`, `reso_name`, `reso_code`, `sort`) VALUES ('409', '409', '48', '订单类型', 'orderType', '7');
INSERT INTO  `user_reso` (`id`, `reso_id`, `reso_pid`, `reso_name`, `reso_code`, `sort`) VALUES ('410', '410', '48', '产品名称', 'productName', '8');
INSERT INTO  `user_reso` (`id`, `reso_id`, `reso_pid`, `reso_name`, `reso_code`, `sort`) VALUES ('411', '411', '48', '产品期数', 'periods', '9');
INSERT INTO  `user_reso` (`id`, `reso_id`, `reso_pid`, `reso_name`, `reso_code`, `sort`) VALUES ('412', '412', '48', '利率（月）', 'productRate', '10');
INSERT INTO  `user_reso` (`id`, `reso_id`, `reso_pid`, `reso_name`, `reso_code`, `sort`) VALUES ('413', '413', '48', '还款方式', 'payWay', '11');
INSERT INTO  `user_reso` (`id`, `reso_id`, `reso_pid`, `reso_name`, `reso_code`, `sort`) VALUES ('414', '414', '48', '融资总额', 'financingAmount', '12');
INSERT INTO  `user_reso` (`id`, `reso_id`, `reso_pid`, `reso_name`, `reso_code`, `sort`) VALUES ('415', '415', '48', '订单状态', 'orderStatus', '13');

--2018-03-22
--党文祥
--新增客户密码，头像地址字段
INSERT INTO personal (`personal_password`, `personal_url`) VALUES (NULL, NULL);

--2018-03-26
--hukaijia
--新增数据库字段
ALTER TABLE `collect_money_detail`
ADD COLUMN `is_account_checking`  int(4) NULL DEFAULT 0 COMMENT '是否对帐 0 对账完成 1 未对账' AFTER `remark`;

--2018-03-28
--党文祥
--新增页面权限
INSERT INTO `role_reso` (`id`, `reso_pid`, `reso_name`, `reso_filetype`, `sort`) VALUES ('466', '163', '订单查询', '425', '1');
INSERT INTO `role_reso` (`id`, `reso_pid`, `reso_name`, `reso_filetype`, `sort`) VALUES ('467', '163', '7条时间查询', '423', '2');
INSERT INTO `carfl_dev`.`role_reso` (`id`, `reso_pid`, `reso_name`, `reso_filetype`, `sort`) VALUES ('468', '163', '多条件查询', '424', '3');
INSERT INTO `role_reso` (`id`, `reso_pid`, `reso_name`, `reso_filetype`, `sort`) VALUES ('469', '163', '日期搜索', '424', '4');
INSERT INTO `role_reso` (`id`, `reso_pid`, `reso_name`, `reso_filetype`, `sort`) VALUES ('470', '163', '进度查询', '423', '5');
INSERT INTO `role_reso` (`id`, `reso_pid`, `reso_name`, `reso_filetype`, `sort`) VALUES ('471', '163', '申请收款', '423', '6');
INSERT INTO `role_reso` (`id`, `reso_pid`, `reso_name`, `reso_filetype`, `sort`) VALUES ('472', '163', '编辑', '423', '7');
--2018-03-28
--党文祥
--新增列配置
INSERT INTO `user_reso` (`id`, `reso_id`, `reso_pid`, `reso_name`, `sort`) VALUES ('417', '417', '466', '订单号', '1');
INSERT INTO `user_reso` (`id`, `reso_id`, `reso_pid`, `reso_name`, `sort`) VALUES ('418', '418', '466', '订单创建时间', '2');
INSERT INTO `user_reso` (`id`, `reso_id`, `reso_pid`, `reso_name`, `sort`) VALUES ('419', '419', '466', '客户', '3');
INSERT INTO `user_reso` (`id`, `reso_id`, `reso_pid`, `reso_name`, `sort`) VALUES ('420', '420', '466', '订单类型', '4');
INSERT INTO `user_reso` (`id`, `reso_id`, `reso_pid`, `reso_name`, `sort`) VALUES ('421', '421', '466', '产品名称', '5');
INSERT INTO `user_reso` (`id`, `reso_id`, `reso_pid`, `reso_name`, `sort`) VALUES ('422', '422', '466', '产品期数', '6');
INSERT INTO `user_reso` (`id`, `reso_id`, `reso_pid`, `reso_name`, `sort`) VALUES ('423', '423', '466', '利率(月)', '7');
INSERT INTO `user_reso` (`id`, `reso_id`, `reso_pid`, `reso_name`, `sort`) VALUES ('424', '424', '466', '还款方式', '8');
INSERT INTO `user_reso` (`id`, `reso_id`, `reso_pid`, `reso_name`, `sort`) VALUES ('425', '425', '466', '融资总额', '9');
INSERT INTO `user_reso` (`id`, `reso_id`, `reso_pid`, `reso_name`, `sort`) VALUES ('426', '426', '466', '环节', '10');
INSERT INTO `user_reso` (`id`, `reso_id`, `reso_pid`, `reso_name`, `sort`) VALUES ('427', '427', '466', '订单状态', '11');

-- 2018-04-11
-- 马金瑞
-- 新增企业开户表
CREATE TABLE `company_account` (
`id`  bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键' ,
`account_channel`  varchar(50) NULL DEFAULT NULL COMMENT '开户渠道' ,
`account_type`  varchar(50) NULL DEFAULT NULL COMMENT '账户类型' ,
`account_name`  varchar(50) NULL DEFAULT NULL COMMENT '账户名' ,
`account_number`  varchar(50) NULL DEFAULT NULL COMMENT '账户号' ,
`account_province`  varchar(50) NULL DEFAULT NULL COMMENT '开户省份' ,
`account_city`  varchar(50) NULL DEFAULT NULL COMMENT '开户市' ,
`account_bankname`  varchar(50) NULL DEFAULT NULL COMMENT '开户银行' ,
`bankcard_number`  bigint(20) NULL DEFAULT NULL COMMENT '银行卡号' ,
`create_time`  datetime NULL DEFAULT NULL COMMENT '开户时间',

PRIMARY KEY (`id`)
)ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8 COMMENT='企业开户信息';
;

-- 2018-04-11
-- 马金瑞
-- 新增银行卡信息表
CREATE TABLE `bankcard_detail` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `companyaccount_id` bigint(20) DEFAULT NULL COMMENT '企业账户id',
  `companybaccount_name` varchar(100) DEFAULT NULL COMMENT '企业账户名',
  `deposit_bank` varchar(200) DEFAULT NULL COMMENT '开户行',
  `branch_name` varchar(200) DEFAULT NULL COMMENT '支行名称',
  `isdefault` varchar(10) DEFAULT NULL COMMENT '是否是默认银行卡',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='银行卡信息';

-- 2018-04-11
-- 马金瑞
-- 交易记录表
CREATE TABLE `transaction_detail` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键id',
  `bankcard_id` bigint(20) DEFAULT NULL COMMENT '银行卡id',
  `customer_name` varchar(50) DEFAULT NULL COMMENT '交易客户名称',
  `transaction_time` datetime DEFAULT NULL COMMENT '交易日期',
  `account_number` varchar(50) DEFAULT NULL COMMENT '企业账户号',
  `transbank` varchar(50) DEFAULT NULL COMMENT '支付银行',
  `transbank_number` int(50) DEFAULT NULL COMMENT '交易卡号',
  `amount` int(100) DEFAULT NULL COMMENT '交易金额',
  `order_number` varchar(100) DEFAULT NULL COMMENT '订单号',
  `transaction_status` varchar(50) DEFAULT NULL COMMENT '交易状态',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='交易记录信息';


-- zhangmingming 2018/4/16 0016 上午 11:40 修改付款记录查询 列配置
UPDATE user_reso SET reso_code = 'applicationStatus' WHERE id = '382';
-- 马金瑞 2018-04-14 修改企业银行卡信息表字段
ALTER TABLE `bankcard_detail`
  ADD COLUMN `account_province`  varchar(200) NULL AFTER `branch_name`,
  ADD COLUMN `account_city`  varchar(200) NULL AFTER `account_province`;
-- 马金瑞 2018 -04 -14 修改企业开户表信息
ALTER TABLE `company_account`
  DROP COLUMN `account_province`,
  DROP COLUMN `account_city`,
  DROP COLUMN `account_bankname`,
  DROP COLUMN `bankcard_number`;
-- 2018-04-16
-- 曹璞
-- 订单评估申请表
DROP TABLE IF EXISTS `assessment_apply`;
CREATE TABLE `assessment_apply` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键id',
  `assessmentno` varchar(255) DEFAULT NULL COMMENT '评估编号',
  `carid` bigint(20) DEFAULT NULL COMMENT '车型ID',
  `ownername` varchar(50) DEFAULT NULL COMMENT '车主姓名',
  `ownphone` bigint(20) DEFAULT NULL COMMENT '车主电话',
  `idcard` varchar(18) DEFAULT NULL COMMENT '身份证号',
  `province` bigint(10) DEFAULT NULL COMMENT '省',
  `city` bigint(10) DEFAULT NULL COMMENT '市',
  `carcolor` varchar(20) DEFAULT NULL COMMENT '车身颜色',
  `engineno` varchar(20) DEFAULT NULL COMMENT '发动机号',
  `frameno` varchar(30) DEFAULT NULL COMMENT '车架号',
  `carno` varchar(10) DEFAULT NULL COMMENT '车牌号',
  `applicant` bigint(20) DEFAULT NULL COMMENT '申请人',
  `applytime` datetime DEFAULT NULL COMMENT '申请时间',
  `assessmentperson` bigint(20) DEFAULT NULL COMMENT '评估人',
  `assessmenttime` datetime DEFAULT NULL COMMENT '评估时间',
  `assessmentstatus` int(4) DEFAULT NULL COMMENT '审核状态',
  `isdelete` int(4) DEFAULT NULL COMMENT '是否删除',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8;

-- 2018-04-16
-- 曹璞
-- 订单评估记录表
DROP TABLE IF EXISTS `assessment_apply_record`;
CREATE TABLE `assessment_apply_record` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `applyid` bigint(20) DEFAULT NULL COMMENT '评估申请单id',
  `applystatus` int(4) DEFAULT NULL COMMENT '订单状态',
  `statusstatements` varchar(500) DEFAULT NULL COMMENT '状态说明',
  `approvaldate` datetime DEFAULT NULL COMMENT '审批日期',
  `intopooldate` datetime DEFAULT NULL COMMENT '进入审核资源池的时间',
  `receivedate` datetime DEFAULT NULL COMMENT '领取日期',
  `operator` bigint(20) DEFAULT NULL COMMENT '操作员',
  `operatetime` datetime DEFAULT NULL COMMENT '操作时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8;

-- 2018-04-16
-- 曹璞
-- 订单评估基本信息表
DROP TABLE IF EXISTS `assessment_basic`;
CREATE TABLE `assessment_basic` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键id',
  `applyid` bigint(20) DEFAULT NULL COMMENT '车辆值_主键id',
  `firsttime` datetime DEFAULT NULL COMMENT '初登日期',
  `factorytime` datetime DEFAULT NULL COMMENT '出厂日期',
  `mileage` int(10) DEFAULT NULL COMMENT '行驶里程',
  `drivingno` varchar(50) DEFAULT NULL COMMENT '行驶证号',
  `transferno` int(2) DEFAULT NULL COMMENT '过户次数',
  `carpurpose` int(4) DEFAULT NULL COMMENT '车辆用途',
  `transmission` int(4) DEFAULT NULL COMMENT '变速箱形式',
  `driver` int(4) DEFAULT NULL COMMENT '驱动形式',
  `displacement` varchar(10) DEFAULT NULL COMMENT '排量',
  `carsituation` int(4) DEFAULT NULL COMMENT '车况',
  `evaluation` double(10,0) DEFAULT NULL COMMENT '估价',
  `remarks` varchar(255) DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=17 DEFAULT CHARSET=utf8;

-- 2018-04-16
-- 曹璞
-- 车辆属性表
DROP TABLE IF EXISTS `car_attribute`;
CREATE TABLE `car_attribute` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键id',
  `attrtype` int(4) DEFAULT NULL COMMENT '属性类型',
  `attrname` varchar(20) DEFAULT NULL COMMENT '属性名称',
  `attrvalue` varchar(20) DEFAULT NULL COMMENT '属性值',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=utf8;

-- 2018-04-16
-- 曹璞
-- 车辆属性值表
DROP TABLE IF EXISTS `car_attr_value`;
CREATE TABLE `car_attr_value` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键id',
  `basicid` bigint(20) DEFAULT NULL COMMENT '申请id',
  `attrname` varchar(20) DEFAULT NULL COMMENT '属性id',
  `attrvalue` varchar(20) DEFAULT NULL COMMENT '属性值',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=57 DEFAULT CHARSET=utf8;

-- 2018-04-16
-- 曹璞
-- 订单评估附件表
DROP TABLE IF EXISTS `car_basic_file`;
CREATE TABLE `car_basic_file` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `basicid` bigint(20) DEFAULT NULL COMMENT '评估信息id',
  `originname` varchar(100) DEFAULT NULL COMMENT '资料原名称',
  `filename` varchar(100) DEFAULT NULL COMMENT '资料上传名称',
  `datasize` int(4) DEFAULT NULL COMMENT '资料大小',
  `materialurl` varchar(255) DEFAULT NULL COMMENT '上传资料路径',
  `isdelete` int(4) DEFAULT NULL COMMENT '是否删除',
  `operator` bigint(20) DEFAULT NULL COMMENT '操作员',
  `operatetime` datetime DEFAULT NULL COMMENT '上传时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

-- 2018-04-16
-- 曹璞
-- 融资租赁申请产品信息新增尾付比例字段
ALTER TABLE `product_order`
ADD COLUMN `final_ratio`  decimal(18,4) DEFAULT '0.0000' COMMENT '尾付比例';

-- zhangmingming 2018/4/16 0016 下午 2:34 修改付款记录查询 列配置
UPDATE user_reso SET reso_code = 'applicationStatus' WHERE id = '382';

-- 2018-04-17
-- 马金瑞
-- 更改company表
ALTER TABLE `company`
  DROP COLUMN `company_license_number`,
  DROP COLUMN `organization_code`,
  DROP COLUMN `tax_registration`,
  DROP COLUMN `social_credit_code`,
  DROP COLUMN `certificate_type`,
  DROP COLUMN `company_type`,
  DROP COLUMN `license_begin_time`,
  DROP COLUMN `license_end_time`,
  DROP COLUMN `Controll_shareholder`,
  DROP COLUMN `regist_addr`,
  DROP COLUMN `busness_scope`,
  DROP COLUMN `legperson_certificate`,
  DROP COLUMN `legperson_certificate_number`,
  DROP COLUMN `legperson_certificate_stime`,
  DROP COLUMN `legperson_certificate_etime`,
  DROP COLUMN `legperson_phone_number`,
  DROP COLUMN `legperson_mail`,
  DROP COLUMN `companyaccount_id`;

-- 2018-04-17
-- 马金瑞
-- 增加企业账户表字段

ALTER TABLE `company_account`
  ADD COLUMN `company_id` BIGINT(100) NULL DEFAULT NULL COMMENT '企业id',
  ADD COLUMN `company_license_number` varchar(100) NULL DEFAULT NULL COMMENT '营业执照注册号',
  ADD COLUMN `organization_code`  varchar(100) NULL DEFAULT NULL COMMENT '组织机构代码',
  ADD COLUMN `tax_registration` varchar(100) DEFAULT NULL COMMENT '税务登记证号',
  ADD COLUMN `social_credit_code` varchar(100) DEFAULT NULL COMMENT '统一社会信用代码',
  ADD COLUMN  `certificate_type` varchar(50) DEFAULT NULL COMMENT '企业证照类型',
  ADD COLUMN  `company_type` varchar(50) DEFAULT NULL COMMENT '企业类型',
  ADD COLUMN  `license_begin_time` date DEFAULT NULL COMMENT '证照起始日期',
  ADD COLUMN  `license_end_time` date DEFAULT NULL COMMENT '证照结束日期',
  ADD COLUMN  `Controll_shareholder` varchar(100) DEFAULT NULL COMMENT '控股股东',
  ADD COLUMN  `regist_addr` varchar(200) DEFAULT NULL COMMENT '企业注册地址',
  ADD COLUMN  `busness_scope` varchar(200) DEFAULT NULL COMMENT '经营范围',
  ADD COLUMN  `legperson_Certificate` varchar(50) DEFAULT NULL COMMENT '法人证件类型',
  ADD COLUMN  `legperson_Certificate_number` varchar(50) DEFAULT NULL COMMENT '法人证件号码',
  ADD COLUMN  `legperson_Certificate_stime` date DEFAULT NULL COMMENT '法人证件起始日期',
  ADD COLUMN  `legperson_Certificate_etime` date DEFAULT NULL COMMENT '法人证件结束日期',
  ADD COLUMN `legperson_phone_number` bigint(20) DEFAULT NULL COMMENT '法人手机号码',
  ADD COLUMN  `legperson_mail` varchar(50) DEFAULT NULL COMMENT '法人邮箱'

-- zhangmingming 2018/4/18 0018 上午 11:08 添加还款项
insert into `data_dict` (`id`, `type_code`, `code`, `name`, `sort`) values('1188','0113',NULL,'剩余利息','24');
insert into `data_dict` (`id`, `type_code`, `code`, `name`, `sort`) values('1189','0113',NULL,'剩余罚息','25');
insert into `data_dict` (`id`, `type_code`, `code`, `name`, `sort`) values('1190','0113',NULL,'剩余本金','26');
insert into `data_dict` (`id`, `type_code`, `code`, `name`, `sort`) values('1191','0113',NULL,'剩余管理费','27');
insert into `data_dict` (`id`, `type_code`, `code`, `name`, `sort`) values('1192','0113',NULL,'剩余尾付款','28');
insert into `data_dict` (`id`, `type_code`, `code`, `name`, `sort`) values('1193','0113',NULL,'提前结清利息','29');
insert into `data_dict` (`id`, `type_code`, `code`, `name`, `sort`) values('1194','0113',NULL,'提前收回违约金','30');


-- 添加 待放款 数据项 zhangmingming 2018/4/24 0024 下午 9:40
insert into `data_dict` (`id`, `type_code`, `code`, `name`, `sort`) values('111','0103',NULL,'待放款','6');

--2018-04-19
--曹璞
--融资租赁申请产品信息新增产品备注字段
ALTER TABLE `product_order`
ADD COLUMN `product_remark`  VARCHAR(255) DEFAULT NULL COMMENT '产品备注';

-- zhangmingming 2018/4/19 0019 下午 3:55 添加是否草稿字段，用来回显先前选择的还款项
 ALTER TABLE `collect_money_history`
ADD COLUMN `draft_info` VARCHAR(800) DEFAULT NULL COMMENT '草稿项';
 ALTER TABLE `withdraw_application`
ADD COLUMN `draft_info` VARCHAR(800) DEFAULT NULL COMMENT '草稿项';
 ALTER TABLE `refund_application`
ADD COLUMN `draft_info` VARCHAR(800) DEFAULT NULL COMMENT '草稿项';

--2018-04-20
--党文祥
--新增pensonal_bank 表是否删除字段
ALTER TABLE `pensoanl_bank`
ADD COLUMN `is_delete`  int(4) NULL COMMENT '是否删除' AFTER `is_default`;
ADD COLUMN `deposit_province` int(4) NULL COMMENT '省份' AFTER `is_delete`;

-- zhangmingming 2018/4/23 0023 上午 10:48.前端传入的资料类型为字符串，因此将类型改为varchar。
alter table finance_upload_resource
change material_type material_type varchar(10) NULL  comment '资料类型';
--2018-04-23
--党文祥
--删除数据字典项模板配置管理名称
DELETE FROM data_dict WHERE id IN (1151,1152,1154,1164,1165,1166);

--2018-04-23
--曹璞
--新增车辆审核评估状态
INSERT INTO `carloan_dev`.`data_dict_type` (`id`, `code`, `name`, `type`) VALUES ('441', '0441', '车辆审核评估状态', '0');

INSERT INTO `carloan_dev`.`data_dict` (`id`, `type_code`, `code`, `name`, `sort`) VALUES ('1187', '0441', '', '草稿(待提交)', '0');
INSERT INTO `carloan_dev`.`data_dict` (`id`, `type_code`, `code`, `name`, `sort`) VALUES ('1188', '0441', '', '已提交', '1');
INSERT INTO `carloan_dev`.`data_dict` (`id`, `type_code`, `code`, `name`, `sort`) VALUES ('1189', '0441', '', '待领取', '2');
INSERT INTO `carloan_dev`.`data_dict` (`id`, `type_code`, `code`, `name`, `sort`) VALUES ('1190', '0441', '', '待评估', '3');
INSERT INTO `carloan_dev`.`data_dict` (`id`, `type_code`, `code`, `name`, `sort`) VALUES ('1191', '0441', '', '已评估', '5');
INSERT INTO `carloan_dev`.`data_dict` (`id`, `type_code`, `code`, `name`, `sort`) VALUES ('1192', '0441', '', '退件', '6');
INSERT INTO `carloan_dev`.`data_dict` (`id`, `type_code`, `code`, `name`, `sort`) VALUES ('1193', '0441', '', '已拒绝', '7');
INSERT INTO `carloan_dev`.`data_dict` (`id`, `type_code`, `code`, `name`, `sort`) VALUES ('1194', '0441', '', '已删除', '8');
INSERT INTO `carloan_dev`.`data_dict` (`id`, `type_code`, `code`, `name`, `sort`) VALUES ('1197', '0441', '', '待评估(草稿)', '4');


--2018-04-24
--胡开甲
--新增分期还款冲抵顺序表
DROP TABLE IF EXISTS `stages_match`;
CREATE TABLE `stages_match` (
  `id` bigint(20) NOT NULL COMMENT '主键',
  `type` int(4) DEFAULT NULL COMMENT '冲抵类型',
  `code` int(4) DEFAULT NULL COMMENT '费用项code',
  `cost_name` varchar(200) DEFAULT NULL COMMENT '费用名称',
  `remark` varchar(500) DEFAULT NULL COMMENT '费用项备注',
  `sort` int(4) DEFAULT NULL COMMENT '冲抵顺序',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--2018-04-25
--曹璞
--新增抵押入库出库表以及相应的数据字典
INSERT INTO `carloan_dev`.`data_dict_type` (`id`, `code`, `name`, `type`) VALUES ('443', '0443', '入库状态', '0');
INSERT INTO `carloan_dev`.`data_dict_type` (`id`, `code`, `name`, `type`) VALUES ('444', '0444', '出库状态', '0');
INSERT INTO `carloan_dev`.`data_dict_type` (`id`, `code`, `name`, `type`) VALUES ('445', '0445', '抵押车况', '0');
INSERT INTO `carloan_dev`.`data_dict_type` (`id`, `code`, `name`, `type`) VALUES ('446', '0446', '出库类型', '0');

INSERT INTO `carloan_dev`.`data_dict` (`id`, `type_code`, `code`, `name`, `sort`) VALUES ('1198', '0443', NULL, '待入库', '0');
INSERT INTO `carloan_dev`.`data_dict` (`id`, `type_code`, `code`, `name`, `sort`) VALUES ('1199', '0443', NULL, '已入库', '1');
INSERT INTO `carloan_dev`.`data_dict` (`id`, `type_code`, `code`, `name`, `sort`) VALUES ('1200', '0444', NULL, '可出库', '0');
INSERT INTO `carloan_dev`.`data_dict` (`id`, `type_code`, `code`, `name`, `sort`) VALUES ('1201', '0444', NULL, '已出库', '1');
INSERT INTO `carloan_dev`.`data_dict` (`id`, `type_code`, `code`, `name`, `sort`) VALUES ('1202', '0445', NULL, '正常', '0');
INSERT INTO `carloan_dev`.`data_dict` (`id`, `type_code`, `code`, `name`, `sort`) VALUES ('1203', '0445', NULL, '1级损伤', '1');
INSERT INTO `carloan_dev`.`data_dict` (`id`, `type_code`, `code`, `name`, `sort`) VALUES ('1204', '0445', NULL, '2级损伤', '2');
INSERT INTO `carloan_dev`.`data_dict` (`id`, `type_code`, `code`, `name`, `sort`) VALUES ('1205', '0445', NULL, '3级损伤', '3');
INSERT INTO `carloan_dev`.`data_dict` (`id`, `type_code`, `code`, `name`, `sort`) VALUES ('1206', '0446', NULL, '销售出库', '0');
INSERT INTO `carloan_dev`.`data_dict` (`id`, `type_code`, `code`, `name`, `sort`) VALUES ('1207', '0446', NULL, '结清出库', '1');

DROP TABLE IF EXISTS `assessment_placing`;
CREATE TABLE `assessment_placing` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `apply_id` bigint(20) DEFAULT NULL COMMENT '押品评估ID',
  `car_subjection` varchar(20) DEFAULT NULL COMMENT '车辆隶属',
  `car_source` varchar(20) DEFAULT NULL COMMENT '车辆来源',
  `car_no` varchar(12) DEFAULT NULL COMMENT '牌照号码',
  `cards_date` datetime DEFAULT NULL COMMENT '上牌日期',
  `odometer` int(8) DEFAULT NULL COMMENT '里程表值',
  `car_situation` int(4) DEFAULT NULL COMMENT '车况',
  `warehousing_person` bigint(20) DEFAULT NULL COMMENT '入库登记人',
  `placing_person` bigint(20) DEFAULT NULL COMMENT '出库登记人',
  `car_warehousing_explain` varchar(255) DEFAULT NULL COMMENT '入库车况说明',
  `warehousing_desc` varchar(255) DEFAULT NULL COMMENT '入库情况描述',
  `car_placing_explain` varchar(255) DEFAULT NULL COMMENT '出库车况说明',
  `placing_desc` varchar(255) DEFAULT NULL COMMENT '出库情况描述',
  `warehousing_date` datetime DEFAULT NULL COMMENT '入库日期',
  `placing_date` datetime DEFAULT NULL COMMENT '出库日期',
  `warehousing_id` bigint(20) DEFAULT NULL COMMENT '入库门店',
  `placing_id` bigint(20) DEFAULT NULL COMMENT '停放库位',
  `warehousing_status` int(4) DEFAULT NULL COMMENT '入库状态',
  `placing_status` int(4) DEFAULT NULL COMMENT '出库状态',
  `warehousing_operator` bigint(20) DEFAULT NULL COMMENT '入库操作人',
  `placing_operator` bigint(20) DEFAULT NULL COMMENT '出库操作人',
  `warehousing_operate_time` datetime DEFAULT NULL COMMENT '入库操作时间',
  `placing_operate_time` datetime DEFAULT NULL COMMENT '出库操作时间',
  `placing_type` varchar(255) DEFAULT NULL COMMENT '出库类型',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

DROP TABLE IF EXISTS `assessment_placing_file`;
CREATE TABLE `assessment_placing_file` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `placingid` bigint(20) DEFAULT NULL COMMENT '库存ID',
  `originname` varchar(100) DEFAULT NULL COMMENT '资料原名称',
  `filename` varchar(100) DEFAULT NULL COMMENT '资料上传名称',
  `datasize` int(4) DEFAULT NULL COMMENT '资料大小',
  `materialurl` varchar(255) DEFAULT NULL COMMENT '上传资料路径',
  `isdelete` int(4) DEFAULT NULL COMMENT '是否删除',
  `operator` bigint(20) DEFAULT NULL COMMENT '操作员',
  `operatetime` datetime DEFAULT NULL COMMENT '上传时间',
  `materialtype` int(4) DEFAULT NULL COMMENT '资料类型',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;


DROP TABLE IF EXISTS `assessment_placing_type`;
CREATE TABLE `assessment_placing_type` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键ID',
  `parke_status` int(4) DEFAULT NULL COMMENT '停放状态',
  `parke_attr` varchar(50) DEFAULT NULL COMMENT '措施内容',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;


DROP TABLE IF EXISTS `assessment_placing_type_value`;
CREATE TABLE `assessment_placing_type_value` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键ID',
  `placing_id` bigint(20) DEFAULT NULL COMMENT '库存ID',
  `placing_type_id` bigint(20) DEFAULT NULL COMMENT '库存状态名称ID',
  `placing_type_value` varchar(100) DEFAULT NULL COMMENT '库存名称值',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

ALTER TABLE `assessment_apply`
ADD COLUMN `brandid`  bigint(20) DEFAULT NULL COMMENT '品牌ID';

ALTER TABLE `assessment_apply`
ADD COLUMN `seriesid`  bigint(20) DEFAULT NULL COMMENT '系列ID';

INSERT INTO `carloan_dev`.`data_dict_type` (`id`, `code`, `name`, `type`) VALUES ('447', '0447', '车辆用途', '0');
INSERT INTO `carloan_dev`.`data_dict_type` (`id`, `code`, `name`, `type`) VALUES ('448', '0448', '变速箱形式', '0');
INSERT INTO `carloan_dev`.`data_dict_type` (`id`, `code`, `name`, `type`) VALUES ('449', '0449', '驱动形式', '0');
INSERT INTO `carloan_dev`.`data_dict_type` (`id`, `code`, `name`, `type`) VALUES ('450', '0450', '评估车况', '0');

INSERT INTO `carloan_dev`.`data_dict` (`id`, `type_code`, `code`, `name`, `sort`) VALUES ('1208', '0447', NULL, '自用', '0');
INSERT INTO `carloan_dev`.`data_dict` (`id`, `type_code`, `code`, `name`, `sort`) VALUES ('1209', '0447', NULL, '运营', '1');
INSERT INTO `carloan_dev`.`data_dict` (`id`, `type_code`, `code`, `name`, `sort`) VALUES ('1210', '0447', NULL, '政府用车', '2');
INSERT INTO `carloan_dev`.`data_dict` (`id`, `type_code`, `code`, `name`, `sort`) VALUES ('1211', '0448', NULL, 'MT', '0');
INSERT INTO `carloan_dev`.`data_dict` (`id`, `type_code`, `code`, `name`, `sort`) VALUES ('1212', '0448', NULL, 'AT', '1');
INSERT INTO `carloan_dev`.`data_dict` (`id`, `type_code`, `code`, `name`, `sort`) VALUES ('1213', '0448', NULL, 'CVT', '2');
INSERT INTO `carloan_dev`.`data_dict` (`id`, `type_code`, `code`, `name`, `sort`) VALUES ('1214', '0448', NULL, 'DCT', '3');
INSERT INTO `carloan_dev`.`data_dict` (`id`, `type_code`, `code`, `name`, `sort`) VALUES ('1215', '0449', NULL, '前驱', '0');
INSERT INTO `carloan_dev`.`data_dict` (`id`, `type_code`, `code`, `name`, `sort`) VALUES ('1216', '0449', NULL, '后驱', '1');
INSERT INTO `carloan_dev`.`data_dict` (`id`, `type_code`, `code`, `name`, `sort`) VALUES ('1217', '0449', NULL, '全时四驱', '2');
INSERT INTO `carloan_dev`.`data_dict` (`id`, `type_code`, `code`, `name`, `sort`) VALUES ('1218', '0449', NULL, '适时四驱', '3');
INSERT INTO `carloan_dev`.`data_dict` (`id`, `type_code`, `code`, `name`, `sort`) VALUES ('1219', '0450', NULL, '1级/综合车况较好', '0');
INSERT INTO `carloan_dev`.`data_dict` (`id`, `type_code`, `code`, `name`, `sort`) VALUES ('1220', '0450', NULL, '2级/综合车况一般', '1');
INSERT INTO `carloan_dev`.`data_dict` (`id`, `type_code`, `code`, `name`, `sort`) VALUES ('1221', '0450', NULL, '3级/综合车况较差', '2');
INSERT INTO `carloan_dev`.`data_dict` (`id`, `type_code`, `code`, `name`, `sort`) VALUES ('1222', '0450', NULL, '4级/综合车况很差', '3');

--2018-04-26
--曹璞
--新增入库停放状态、出库附件类型数据字典项
INSERT INTO `carloan_dev`.`data_dict_type` (`id`, `code`, `name`, `type`) VALUES ('451', '0451', '停放状态', '0');
INSERT INTO `carloan_dev`.`data_dict_type` (`id`, `code`, `name`, `type`) VALUES ('452', '0452', '入出库附件类型', '0');

INSERT INTO `carloan_dev`.`data_dict` (`id`, `type_code`, `code`, `name`, `sort`) VALUES ('1223', '0451', NULL, 'A 初期停放', '0');
INSERT INTO `carloan_dev`.`data_dict` (`id`, `type_code`, `code`, `name`, `sort`) VALUES ('1224', '0451', NULL, 'B 长期停放', '1');
INSERT INTO `carloan_dev`.`data_dict` (`id`, `type_code`, `code`, `name`, `sort`) VALUES ('1225', '0451', NULL, 'C 营销准备', '2');
INSERT INTO `carloan_dev`.`data_dict` (`id`, `type_code`, `code`, `name`, `sort`) VALUES ('1226', '0451', NULL, 'D 展厅展示', '3');
INSERT INTO `carloan_dev`.`data_dict` (`id`, `type_code`, `code`, `name`, `sort`) VALUES ('1227', '0451', NULL, 'E GPS监控', '4');
INSERT INTO `carloan_dev`.`data_dict` (`id`, `type_code`, `code`, `name`, `sort`) VALUES ('1228', '0452', NULL, '入库附件', '0');
INSERT INTO `carloan_dev`.`data_dict` (`id`, `type_code`, `code`, `name`, `sort`) VALUES ('1229', '0452', NULL, '车辆照片', '1');
INSERT INTO `carloan_dev`.`data_dict` (`id`, `type_code`, `code`, `name`, `sort`) VALUES ('1230', '0452', NULL, '合格证', '2');
INSERT INTO `carloan_dev`.`data_dict` (`id`, `type_code`, `code`, `name`, `sort`) VALUES ('1231', '0452', NULL, '保险单', '3');
INSERT INTO `carloan_dev`.`data_dict` (`id`, `type_code`, `code`, `name`, `sort`) VALUES ('1232', '0452', NULL, '交车单', '4');
INSERT INTO `carloan_dev`.`data_dict` (`id`, `type_code`, `code`, `name`, `sort`) VALUES ('1233', '0452', NULL, '交车照', '5');
INSERT INTO `carloan_dev`.`data_dict` (`id`, `type_code`, `code`, `name`, `sort`) VALUES ('1234', '0452', NULL, '行驶证', '7');
INSERT INTO `carloan_dev`.`data_dict` (`id`, `type_code`, `code`, `name`, `sort`) VALUES ('1235', '0452', NULL, '里程数', '8');
INSERT INTO `carloan_dev`.`data_dict` (`id`, `type_code`, `code`, `name`, `sort`) VALUES ('1236', '0452', NULL, '其他附件', '9');
INSERT INTO `carloan_dev`.`data_dict` (`id`, `type_code`, `code`, `name`, `sort`) VALUES ('1262', '0452', NULL, '出库单据', '6');

--2018-05-02
--牟亮
--新增个人客户信息相关的数据字典项
INSERT INTO `carloan_dev`.`data_dict_type` (`id`, `code`, `name`, `type`) VALUES ('453', '0453', '健康状态', '0');
INSERT INTO `carloan_dev`.`data_dict_type` (`id`, `code`, `name`, `type`) VALUES ('454', '0454', '居住状态', '0');
INSERT INTO `carloan_dev`.`data_dict_type` (`id`, `code`, `name`, `type`) VALUES ('455', '0455', '账号用途', '0');
INSERT INTO `carloan_dev`.`data_dict_type` (`id`, `code`, `name`, `type`) VALUES ('456', '0456', '开户银行', '0');
INSERT INTO `carloan_dev`.`data_dict_type` (`id`, `code`, `name`, `type`) VALUES ('457', '0457', '与客户的关系', '0');
INSERT INTO `carloan_dev`.`data_dict_type` (`id`, `code`, `name`, `type`) VALUES ('458', '0458', '职务', '0');
INSERT INTO `carloan_dev`.`data_dict_type` (`id`, `code`, `name`, `type`) VALUES ('459', '0459', '行业', '0');
INSERT INTO `carloan_dev`.`data_dict_type` (`id`, `code`, `name`, `type`) VALUES ('460', '0460', '账号类型', '0');

INSERT INTO `carloan_dev`.`data_dict` VALUES ('1237', '0453', null, '良好', '0');
INSERT INTO `carloan_dev`.`data_dict` VALUES ('1238', '0453', null, '一般', '1');
INSERT INTO `carloan_dev`.`data_dict` VALUES ('1239', '0454', null, '按揭', '0');
INSERT INTO `carloan_dev`.`data_dict` VALUES ('1240', '0454', null, '全款', '1');
INSERT INTO `carloan_dev`.`data_dict` VALUES ('1241', '0455', null, '贷款账号', '0');
INSERT INTO `carloan_dev`.`data_dict` VALUES ('1242', '0455', null, '其他', '1');
INSERT INTO `carloan_dev`.`data_dict` VALUES ('1243', '0456', null, '中国银行', '0');
INSERT INTO `carloan_dev`.`data_dict` VALUES ('1244', '0456', null, '招商银行', '1');
INSERT INTO `carloan_dev`.`data_dict` VALUES ('1245', '0456', null, '工商银行', '2');
INSERT INTO `carloan_dev`.`data_dict` VALUES ('1246', '0456', null, '人民银行', '3');
INSERT INTO `carloan_dev`.`data_dict` VALUES ('1247', '0456', null, '其它银行', '4');
INSERT INTO `carloan_dev`.`data_dict` VALUES ('1248', '0457', null, '父子', '0');
INSERT INTO `carloan_dev`.`data_dict` VALUES ('1249', '0457', null, '母子', '1');
INSERT INTO `carloan_dev`.`data_dict` VALUES ('1250', '0457', null, '夫妻', '2');
INSERT INTO `carloan_dev`.`data_dict` VALUES ('1251', '0457', null, '朋友', '3');
INSERT INTO `carloan_dev`.`data_dict` VALUES ('1252', '0457', null, '其他', '4');
INSERT INTO `carloan_dev`.`data_dict` VALUES ('1253', '0458', null, '总经理', '0');
INSERT INTO `carloan_dev`.`data_dict` VALUES ('1254', '0458', null, '人事', '1');
INSERT INTO `carloan_dev`.`data_dict` VALUES ('1255', '0458', null, '其他', '2');
INSERT INTO `carloan_dev`.`data_dict` VALUES ('1256', '0459', null, '金融业', '0');
INSERT INTO `carloan_dev`.`data_dict` VALUES ('1257', '0459', null, '计算机', '1');
INSERT INTO `carloan_dev`.`data_dict` VALUES ('1258', '0459', null, '汽车', '2');
INSERT INTO `carloan_dev`.`data_dict` VALUES ('1259', '0459', null, '其他', '3');
INSERT INTO `carloan_dev`.`data_dict` VALUES ('1260', '0460', null, '借记卡', '0');
INSERT INTO `carloan_dev`.`data_dict` VALUES ('1261', '0460', null, '信用卡', '1');

ALTER TABLE `personal`
ADD COLUMN `intentional_level`  float(10,1) DEFAULT '0.0' COMMENT '意向级别';
ALTER TABLE `personal`
ADD COLUMN `nation`  varchar(64) DEFAULT NULL COMMENT '民族';
ALTER TABLE `personal`
ADD COLUMN `health_status` int(4) DEFAULT NULL COMMENT '健康状态';
ALTER TABLE `personal`
ADD COLUMN `home_status`  int(4) DEFAULT NULL COMMENT '居住状态';
ALTER TABLE `personal`
ADD COLUMN `message_addr`  varchar(255) DEFAULT NULL COMMENT '通讯地址';
ALTER TABLE `personal`
ADD COLUMN `city`  int(4) DEFAULT NULL COMMENT '城市';

ALTER TABLE `personal_contact`
ADD COLUMN `level`  int(4) DEFAULT NULL COMMENT '第几联系人';

ALTER TABLE `personal_bank`
ADD COLUMN `account_use`  int(4) DEFAULT NULL COMMENT '账号用途';

ALTER TABLE `personal_job`
ADD COLUMN `family_count`  int(4) DEFAULT NULL COMMENT '家庭人数';
ALTER TABLE `personal_job`
ADD COLUMN `companyhost_name`  varchar(100) DEFAULT NULL COMMENT '经营单位名称';
ALTER TABLE `personal_job`
ADD COLUMN `companyhost_addr`  varchar(500) DEFAULT NULL COMMENT '经营单位的地址';
ALTER TABLE `personal_job`
ADD COLUMN `companyhost_creatTime`  datetime DEFAULT NULL COMMENT '经营公司的注册时间';
ALTER TABLE `personal_job`
ADD COLUMN `companyhost_number`  varchar(255) DEFAULT NULL COMMENT '经营公司的统一社会信用代码';
ALTER TABLE `personal_job`
ADD COLUMN `companyhost_bank`  int(4) DEFAULT NULL COMMENT '经营公司的开户行';
ALTER TABLE `personal_job`
ADD COLUMN `companyhost_basic`  varchar(255) DEFAULT NULL COMMENT '经营公司的基本户';
ALTER TABLE `personal_job`
ADD COLUMN `companyhost_checkTime`  datetime DEFAULT NULL COMMENT '经营公司的最新年检';


--2018-05-04
--董元
--新增省市新字段
ALTER TABLE `personal`
ADD COLUMN `province`  int(4) NULL COMMENT '身份证省份' AFTER `personal_url`,
ADD COLUMN `city`  int(4) NULL COMMENT '身份证城市' AFTER `province`,
ADD COLUMN `province1`  int(4) NULL COMMENT '现居住省市' AFTER `city`,
ADD COLUMN `city1`  int(4) NULL COMMENT '现居住城市' AFTER `province1`,
ADD COLUMN `province2`  int(4) NULL COMMENT '本市房产省市' AFTER `city1`,
ADD COLUMN `city2`  int(4) NULL COMMENT '本市房产城市' AFTER `province2`;

ALTER TABLE `personal_job`
ADD COLUMN `province`  int(4) NULL COMMENT '单位省份' AFTER `operate_time`,
ADD COLUMN `city`  int(4) NULL COMMENT '单位城市' AFTER `province`;

--2018-05-08
--曹璞
--新增入库停放状态GPS状态
INSERT INTO `carloan_dev`.`data_dict_type` (`id`, `code`, `name`, `type`) VALUES ('461', '0461', 'GPS状态', '0');
INSERT INTO `carloan_dev`.`data_dict` (`id`, `type_code`, `code`, `name`, `sort`) VALUES ('1266', '0461', NULL, '未安装', '0');
INSERT INTO `carloan_dev`.`data_dict` (`id`, `type_code`, `code`, `name`, `sort`) VALUES ('1267', '0461', NULL, '正常', '1');
INSERT INTO `carloan_dev`.`data_dict` (`id`, `type_code`, `code`, `name`, `sort`) VALUES ('1268', '0461', NULL, '离线', '2');
INSERT INTO `carloan_dev`.`data_dict` (`id`, `type_code`, `code`, `name`, `sort`) VALUES ('1269', '0461', NULL, '损坏', '3');

--2018-05-08
--牟亮
--修改和新增财务相关的字段
ALTER TABLE refund_application_item MODIFY refund_item VARCHAR(255) ;
ALTER TABLE refund_upload_resource MODIFY material_type VARCHAR(255) ;
ALTER TABLE refund_application ADD COLUMN `settlement_channel` int(4) DEFAULT NULL COMMENT '结算通道';
ALTER TABLE collect_money_history ADD COLUMN `collect_money_channel` int(4) DEFAULT NULL COMMENT '结算通道';

--2018-05-09
--杨鹏涛
--修改产品利率，罚息费率，合同违约金费率，提前还款费率的字段类型长度
ALTER TABLE `product_plan_issue` MODIFY `product_rate` decimal(20,8);
ALTER TABLE `product_plan_issue` MODIFY `penalty_rate` decimal(20,8);
ALTER TABLE `product_plan_issue` MODIFY `contract_break_rate` decimal(20,8);
ALTER TABLE `product_plan_issue` MODIFY `prepayment_rate` decimal(20,8);

--2018-05-09
--杨鹏涛
--修改所属行业数据类型，并添加新字段‘其他行业’

ALTER TABLE personal_job
ADD COLUMN other_industry VARCHAR (100) COMMENT '其他行业';
ALTER TABLE personal_job MODIFY COLUMN industry INT (4);

--2018-05-09
--牟亮
--personal表中加一个intention_home_addr 意向客户居住地址
ALTER TABLE personal ADD COLUMN `intention_home_addr` VARCHAR (255) DEFAULT NULL COMMENT '意向客户居住地址';

--2018-05-09
--曹璞
--新增意向抵押方式
INSERT INTO `carloan_test`.`data_dict_type` (`id`, `code`, `name`, `type`) VALUES ('462', '0462', '意向抵押方式', '0');
--新增抵押贷款订单异常状态备注
ALTER TABLE product_order
ADD COLUMN risk_remark VARCHAR (255) COMMENT '异常备注';

--2018-05-09
--牟亮
--productorder加两个流程，向数据字典表中加入两条数据
INSERT INTO `carloan_dev`.`data_dict` (`id`, `type_code`, `code`, `name`, `sort`) VALUES ('1270', '0302', NULL, '收款待确认', NULL);
INSERT INTO `carloan_dev`.`data_dict` (`id`, `type_code`, `code`, `name`, `sort`) VALUES ('1271', '0302', NULL, '放款待确认', NULL);

--2018-05-09
--牟亮
--productorder加已结案流程，向数据字典表中加入,并更新已归档状态为待结案
update `carloan_dev` set `name`='待结案' where `id`=324;
INSERT INTO `carloan_dev`.`data_dict` (`id`, `type_code`, `code`, `name`, `sort`) VALUES ('1272', '0302', NULL, '已结案', NULL);

--2018-05-15
--牟亮
--财务附件表中新增字段，用来区分财务开票对应的哪个收款明细
ALTER TABLE finance_upload_resource
ADD COLUMN collect_money_detail_id bigint (20) COMMENT '收款项id(财务开票用)';
--财务开票表中修改字段名称
alter table finance_invoice change  column invoice_title invoicing_title varchar(500);

-- 2018-05-30
-- dangwenxiang
-- 列配置添加
INSERT INTO  `user_reso` (`id`, `reso_id`, `reso_pid`, `reso_name`, `reso_code`, `sort`) VALUES ('469', '469', '485', '客户姓名', 'personalName', '1');
INSERT INTO  `user_reso` (`id`, `reso_id`, `reso_pid`, `reso_name`, `reso_code`, `sort`) VALUES ('470', '470', '485', '证件类型', 'certificateType', '2');
INSERT INTO  `user_reso` (`id`, `reso_id`, `reso_pid`, `reso_name`, `reso_code`, `sort`) VALUES ('471', '471', '485', '证件号码', 'idCard', '3');
INSERT INTO  `user_reso` (`id`, `reso_id`, `reso_pid`, `reso_name`, `reso_code`, `sort`) VALUES ('472', '472', '485', '手机号码', 'mobileMain', '4');
INSERT INTO  `user_reso` (`id`, `reso_id`, `reso_pid`, `reso_name`, `reso_code`, `sort`) VALUES ('473', '473', '485', '意向级别', 'intentionalLevel', '5');
INSERT INTO  `user_reso` (`id`, `reso_id`, `reso_pid`, `reso_name`, `reso_code`, `sort`) VALUES ('474', '474', '485', '所属地区', 'city', '6');
INSERT INTO  `user_reso` (`id`, `reso_id`, `reso_pid`, `reso_name`, `reso_code`, `sort`) VALUES ('475', '475', '485', '创建时间', 'createTime', '7');
INSERT INTO  `user_reso` (`id`, `reso_id`, `reso_pid`, `reso_name`, `reso_code`, `sort`) VALUES ('476', '476', '485', '归属业务员', 'operator', '8');
INSERT INTO  `user_reso` (`id`, `reso_id`, `reso_pid`, `reso_name`, `reso_code`, `sort`) VALUES ('477', '477', '486', '客户姓名', 'personalName', '1');
INSERT INTO  `user_reso` (`id`, `reso_id`, `reso_pid`, `reso_name`, `reso_code`, `sort`) VALUES ('478', '478', '486', '证件类型', 'certificateType', '2');
INSERT INTO  `user_reso` (`id`, `reso_id`, `reso_pid`, `reso_name`, `reso_code`, `sort`) VALUES ('479', '479', '486', '证件号码', 'idCard', '3');
INSERT INTO  `user_reso` (`id`, `reso_id`, `reso_pid`, `reso_name`, `reso_code`, `sort`) VALUES ('480', '480', '486', '手机号码', 'mobileMain', '4');
INSERT INTO  `user_reso` (`id`, `reso_id`, `reso_pid`, `reso_name`, `reso_code`, `sort`) VALUES ('481', '481', '486', '意向级别', 'intentionalLevel', '5');
INSERT INTO  `user_reso` (`id`, `reso_id`, `reso_pid`, `reso_name`, `reso_code`, `sort`) VALUES ('482', '482', '486', '所属地区', 'city', '6');
INSERT INTO  `user_reso` (`id`, `reso_id`, `reso_pid`, `reso_name`, `reso_code`, `sort`) VALUES ('483', '483', '486', '创建时间', 'createTime', '7');
INSERT INTO  `user_reso` (`id`, `reso_id`, `reso_pid`, `reso_name`, `reso_code`, `sort`) VALUES ('484', '484', '486', '归属业务员', 'operator', '8');
INSERT INTO  `user_reso` (`id`, `reso_id`, `reso_pid`, `reso_name`, `reso_code`, `sort`) VALUES ('485', '485', '487', '客户姓名', 'personalName', '1');
INSERT INTO  `user_reso` (`id`, `reso_id`, `reso_pid`, `reso_name`, `reso_code`, `sort`) VALUES ('486', '486', '487', '证件类型', 'certificateType', '2');
INSERT INTO  `user_reso` (`id`, `reso_id`, `reso_pid`, `reso_name`, `reso_code`, `sort`) VALUES ('487', '487', '487', '证件号码', 'idCard', '3');
INSERT INTO  `user_reso` (`id`, `reso_id`, `reso_pid`, `reso_name`, `reso_code`, `sort`) VALUES ('488', '488', '487', '手机号码', 'mobileMain', '4');
INSERT INTO  `user_reso` (`id`, `reso_id`, `reso_pid`, `reso_name`, `reso_code`, `sort`) VALUES ('489', '489', '487', '意向级别', 'intentionalLevel', '5');
INSERT INTO  `user_reso` (`id`, `reso_id`, `reso_pid`, `reso_name`, `reso_code`, `sort`) VALUES ('490', '490', '487', '所属地区', 'city', '6');
INSERT INTO  `user_reso` (`id`, `reso_id`, `reso_pid`, `reso_name`, `reso_code`, `sort`) VALUES ('491', '491', '487', '创建时间', 'createTime', '7');
INSERT INTO  `user_reso` (`id`, `reso_id`, `reso_pid`, `reso_name`, `reso_code`, `sort`) VALUES ('492', '492', '487', '归属业务员', 'operator', '8');
INSERT INTO  `user_reso` (`id`, `reso_id`, `reso_pid`, `reso_name`, `reso_code`, `sort`) VALUES ('493', '493', '475', '评估编号', 'assessmentNo', '1');
INSERT INTO  `user_reso` (`id`, `reso_id`, `reso_pid`, `reso_name`, `reso_code`, `sort`) VALUES ('494', '494', '475', '状态', 'assessmentStatus', '2');
INSERT INTO  `user_reso` (`id`, `reso_id`, `reso_pid`, `reso_name`, `reso_code`, `sort`) VALUES ('495', '495', '475', '品牌', 'brandName', '3');
INSERT INTO  `user_reso` (`id`, `reso_id`, `reso_pid`, `reso_name`, `reso_code`, `sort`) VALUES ('496', '496', '475', '系列', 'seriesName', '4');
INSERT INTO  `user_reso` (`id`, `reso_id`, `reso_pid`, `reso_name`, `reso_code`, `sort`) VALUES ('497', '497', '475', '车型', 'carName', '5');
INSERT INTO  `user_reso` (`id`, `reso_id`, `reso_pid`, `reso_name`, `reso_code`, `sort`) VALUES ('498', '498', '475', '颜色', 'carColor', '6');
INSERT INTO  `user_reso` (`id`, `reso_id`, `reso_pid`, `reso_name`, `reso_code`, `sort`) VALUES ('499', '499', '475', '车牌号码', 'carNo', '7');
INSERT INTO  `user_reso` (`id`, `reso_id`, `reso_pid`, `reso_name`, `reso_code`, `sort`) VALUES ('500', '500', '475', '车架号', 'frameNo', '8');
INSERT INTO  `user_reso` (`id`, `reso_id`, `reso_pid`, `reso_name`, `reso_code`, `sort`) VALUES ('501', '501', '475', '发动机号', 'engineNo', '9');
INSERT INTO  `user_reso` (`id`, `reso_id`, `reso_pid`, `reso_name`, `reso_code`, `sort`) VALUES ('502', '502', '475', '客户姓名', 'ownerName', '10');
INSERT INTO  `user_reso` (`id`, `reso_id`, `reso_pid`, `reso_name`, `reso_code`, `sort`) VALUES ('503', '503', '475', '手机号码', 'ownPhone', '11');
INSERT INTO  `user_reso` (`id`, `reso_id`, `reso_pid`, `reso_name`, `reso_code`, `sort`) VALUES ('504', '504', '475', '申请人', 'applicant', '12');
INSERT INTO  `user_reso` (`id`, `reso_id`, `reso_pid`, `reso_name`, `reso_code`, `sort`) VALUES ('505', '505', '475', '申请时间', 'applyTime', '13');
INSERT INTO  `user_reso` (`id`, `reso_id`, `reso_pid`, `reso_name`, `reso_code`, `sort`) VALUES ('506', '506', '475', '评估人', 'assessmentPerson', '14');
INSERT INTO  `user_reso` (`id`, `reso_id`, `reso_pid`, `reso_name`, `reso_code`, `sort`) VALUES ('507', '507', '476', '评估编号', 'assessmentNo', '1');
INSERT INTO  `user_reso` (`id`, `reso_id`, `reso_pid`, `reso_name`, `reso_code`, `sort`) VALUES ('508', '508', '476', '品牌', 'brandName', '2');
INSERT INTO  `user_reso` (`id`, `reso_id`, `reso_pid`, `reso_name`, `reso_code`, `sort`) VALUES ('509', '509', '476', '系列', 'seriesName', '3');
INSERT INTO  `user_reso` (`id`, `reso_id`, `reso_pid`, `reso_name`, `reso_code`, `sort`) VALUES ('510', '510', '476', '车型', 'carName', '4');
INSERT INTO  `user_reso` (`id`, `reso_id`, `reso_pid`, `reso_name`, `reso_code`, `sort`) VALUES ('511', '511', '476', '颜色', 'carColor', '5');
INSERT INTO  `user_reso` (`id`, `reso_id`, `reso_pid`, `reso_name`, `reso_code`, `sort`) VALUES ('512', '512', '476', '车牌号码', 'carNo', '6');
INSERT INTO  `user_reso` (`id`, `reso_id`, `reso_pid`, `reso_name`, `reso_code`, `sort`) VALUES ('513', '513', '476', '车架号', 'frameNo', '7');
INSERT INTO  `user_reso` (`id`, `reso_id`, `reso_pid`, `reso_name`, `reso_code`, `sort`) VALUES ('514', '514', '476', '发动机号', 'engineNo', '8');
INSERT INTO  `user_reso` (`id`, `reso_id`, `reso_pid`, `reso_name`, `reso_code`, `sort`) VALUES ('515', '515', '476', '客户姓名', 'ownerName', '9');
INSERT INTO  `user_reso` (`id`, `reso_id`, `reso_pid`, `reso_name`, `reso_code`, `sort`) VALUES ('516', '516', '476', '手机号', 'ownPhone', '10');
INSERT INTO  `user_reso` (`id`, `reso_id`, `reso_pid`, `reso_name`, `reso_code`, `sort`) VALUES ('517', '517', '477', '评估编号', 'assessmentNo', '1');
INSERT INTO  `user_reso` (`id`, `reso_id`, `reso_pid`, `reso_name`, `reso_code`, `sort`) VALUES ('518', '518', '477', '状态', 'assessmentStatus', '2');
INSERT INTO  `user_reso` (`id`, `reso_id`, `reso_pid`, `reso_name`, `reso_code`, `sort`) VALUES ('519', '519', '477', '品牌', 'brandName', '3');
INSERT INTO  `user_reso` (`id`, `reso_id`, `reso_pid`, `reso_name`, `reso_code`, `sort`) VALUES ('520', '520', '477', '系列', 'seriesName', '4');
INSERT INTO  `user_reso` (`id`, `reso_id`, `reso_pid`, `reso_name`, `reso_code`, `sort`) VALUES ('521', '521', '477', '车型', 'carName', '5');
INSERT INTO  `user_reso` (`id`, `reso_id`, `reso_pid`, `reso_name`, `reso_code`, `sort`) VALUES ('522', '522', '477', '颜色', 'carColor', '6');
INSERT INTO  `user_reso` (`id`, `reso_id`, `reso_pid`, `reso_name`, `reso_code`, `sort`) VALUES ('523', '523', '477', '车牌号码', 'carNo', '7');
INSERT INTO  `user_reso` (`id`, `reso_id`, `reso_pid`, `reso_name`, `reso_code`, `sort`) VALUES ('524', '524', '477', '车架号', 'frameNo', '8');
INSERT INTO  `user_reso` (`id`, `reso_id`, `reso_pid`, `reso_name`, `reso_code`, `sort`) VALUES ('525', '525', '477', '发动机号', 'engineNo', '9');
INSERT INTO  `user_reso` (`id`, `reso_id`, `reso_pid`, `reso_name`, `reso_code`, `sort`) VALUES ('526', '526', '477', '客户姓名', 'ownerName', '10');
INSERT INTO  `user_reso` (`id`, `reso_id`, `reso_pid`, `reso_name`, `reso_code`, `sort`) VALUES ('527', '527', '477', '手机号', 'ownPhone', '11');
INSERT INTO  `user_reso` (`id`, `reso_id`, `reso_pid`, `reso_name`, `reso_code`, `sort`) VALUES ('528', '528', '477', '车况级别', 'carSituation', '12');
INSERT INTO  `user_reso` (`id`, `reso_id`, `reso_pid`, `reso_name`, `reso_code`, `sort`) VALUES ('529', '529', '477', '估计（元）', 'evaluation', '13');
INSERT INTO  `user_reso` (`id`, `reso_id`, `reso_pid`, `reso_name`, `reso_code`, `sort`) VALUES ('530', '530', '477', '评估日期', 'assessmentTime', '14');
INSERT INTO  `user_reso` (`id`, `reso_id`, `reso_pid`, `reso_name`, `reso_code`, `sort`) VALUES ('531', '531', '477', '估计员', 'assessmentPerson', '15');
INSERT INTO  `user_reso` (`id`, `reso_id`, `reso_pid`, `reso_name`, `reso_code`, `sort`) VALUES ('532', '532', '481', '入库状态', 'warehousingStatus', '1');
INSERT INTO  `user_reso` (`id`, `reso_id`, `reso_pid`, `reso_name`, `reso_code`, `sort`) VALUES ('533', '533', '481', '操作时间', 'warehousingOperateTime', '2');
INSERT INTO  `user_reso` (`id`, `reso_id`, `reso_pid`, `reso_name`, `reso_code`, `sort`) VALUES ('534', '534', '481', '操作人', 'warehousingOperator', '3');
INSERT INTO  `user_reso` (`id`, `reso_id`, `reso_pid`, `reso_name`, `reso_code`, `sort`) VALUES ('535', '535', '481', '订单编号', 'assessmentNo', '4');
INSERT INTO  `user_reso` (`id`, `reso_id`, `reso_pid`, `reso_name`, `reso_code`, `sort`) VALUES ('536', '536', '481', '品牌', 'brandName', '5');
INSERT INTO  `user_reso` (`id`, `reso_id`, `reso_pid`, `reso_name`, `reso_code`, `sort`) VALUES ('537', '537', '481', '系列', 'seriesName', '6');
INSERT INTO  `user_reso` (`id`, `reso_id`, `reso_pid`, `reso_name`, `reso_code`, `sort`) VALUES ('538', '538', '481', '车型', 'carName', '7');
INSERT INTO  `user_reso` (`id`, `reso_id`, `reso_pid`, `reso_name`, `reso_code`, `sort`) VALUES ('539', '539', '481', '车身颜色', 'carColor', '8');
INSERT INTO  `user_reso` (`id`, `reso_id`, `reso_pid`, `reso_name`, `reso_code`, `sort`) VALUES ('540', '540', '481', '车牌号码', 'carNo', '9');
INSERT INTO  `user_reso` (`id`, `reso_id`, `reso_pid`, `reso_name`, `reso_code`, `sort`) VALUES ('541', '541', '481', '车架号', 'frameNo', '10');
INSERT INTO  `user_reso` (`id`, `reso_id`, `reso_pid`, `reso_name`, `reso_code`, `sort`) VALUES ('542', '542', '481', '发动机号', 'engineNo', '11');
INSERT INTO  `user_reso` (`id`, `reso_id`, `reso_pid`, `reso_name`, `reso_code`, `sort`) VALUES ('543', '543', '482', '状态', 'placingStatus', '1');
INSERT INTO  `user_reso` (`id`, `reso_id`, `reso_pid`, `reso_name`, `reso_code`, `sort`) VALUES ('544', '544', '482', '操作日期', 'placingOperateTime', '2');
INSERT INTO  `user_reso` (`id`, `reso_id`, `reso_pid`, `reso_name`, `reso_code`, `sort`) VALUES ('545', '545', '482', '操作人', 'placingOperator', '3');
INSERT INTO  `user_reso` (`id`, `reso_id`, `reso_pid`, `reso_name`, `reso_code`, `sort`) VALUES ('546', '546', '482', '订单编号', 'assessmentNo', '4');
INSERT INTO  `user_reso` (`id`, `reso_id`, `reso_pid`, `reso_name`, `reso_code`, `sort`) VALUES ('547', '547', '482', '品牌', 'brandName', '5');
INSERT INTO  `user_reso` (`id`, `reso_id`, `reso_pid`, `reso_name`, `reso_code`, `sort`) VALUES ('548', '548', '482', '系列', 'seriesName', '6');
INSERT INTO  `user_reso` (`id`, `reso_id`, `reso_pid`, `reso_name`, `reso_code`, `sort`) VALUES ('549', '549', '482', '车型', 'carName', '7');
INSERT INTO  `user_reso` (`id`, `reso_id`, `reso_pid`, `reso_name`, `reso_code`, `sort`) VALUES ('550', '550', '482', '车身颜色', 'carColor', '8');
INSERT INTO  `user_reso` (`id`, `reso_id`, `reso_pid`, `reso_name`, `reso_code`, `sort`) VALUES ('551', '551', '482', '车牌号码', 'carNo', '9');
INSERT INTO  `user_reso` (`id`, `reso_id`, `reso_pid`, `reso_name`, `reso_code`, `sort`) VALUES ('552', '552', '482', '车架号', 'frameNo', '10');
INSERT INTO  `user_reso` (`id`, `reso_id`, `reso_pid`, `reso_name`, `reso_code`, `sort`) VALUES ('553', '553', '482', '发动机号', 'engineNo', '11');
INSERT INTO  `user_reso` (`id`, `reso_id`, `reso_pid`, `reso_name`, `reso_code`, `sort`) VALUES ('554', '554', '482', '客户姓名', 'ownerName', '12');
INSERT INTO  `user_reso` (`id`, `reso_id`, `reso_pid`, `reso_name`, `reso_code`, `sort`) VALUES ('555', '555', '482', '手机号', 'ownPhone', '13');








