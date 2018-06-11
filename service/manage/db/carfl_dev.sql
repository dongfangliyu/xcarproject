/*
Navicat MySQL Data Transfer

Source Server         : 192.168.3.2:3306
Source Server Version : 50721
Source Host           : 192.168.3.2:3306
Source Database       : carfl_dev

Target Server Type    : MYSQL
Target Server Version : 50721
File Encoding         : 65001

Date: 2018-04-23 10:26:40
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `approve_reason`
-- ----------------------------
DROP TABLE IF EXISTS `approve_reason`;
CREATE TABLE `approve_reason` (
  `id`  bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键ID' ,
  `type`  int(4) NULL DEFAULT NULL COMMENT '审批原因类型' ,
  `first`  varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '一级' ,
  `second`  varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '二级' ,
  `CRC`  varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT 'CRC编码' ,
  `detail`  varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '详细内容' ,
  `operator`  bigint(20) NULL DEFAULT NULL COMMENT '创建人' ,
  `operator_time`  datetime NULL DEFAULT NULL COMMENT '创建时间' ,
  `operator_name`  varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '操作人姓名' ,
  PRIMARY KEY (`id`)
)
  ENGINE=InnoDB
  DEFAULT CHARACTER SET=utf8 COLLATE=utf8_general_ci
  COMMENT='审批原因实体'
  AUTO_INCREMENT=483

;

-- ----------------------------
-- Table structure for `area_code`
-- ----------------------------
DROP TABLE IF EXISTS `area_code`;
CREATE TABLE `area_code` (
  `id`  int(11) NOT NULL AUTO_INCREMENT COMMENT '主键' ,
  `parent_id`  int(11) NULL DEFAULT NULL COMMENT '父级节点' ,
  `tree_path`  varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '地域路由' ,
  `area_code`  varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '地域编码' ,
  `area_name`  varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '地域名称' ,
  `area_english_name`  varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '地区名称拼音' ,
  `bank_code`  varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '银行地域支付编码' ,
  `zip_code`  varchar(10) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '地区邮编' ,
  `zone_code`  varchar(5) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '区号' ,
  `operator`  bigint(64) NULL DEFAULT NULL COMMENT '操作员' ,
  `operate_time`  datetime NULL DEFAULT NULL COMMENT '操作时间' ,
  PRIMARY KEY (`id`),
  UNIQUE INDEX `id_index` (`id`) USING BTREE
)
  ENGINE=InnoDB
  DEFAULT CHARACTER SET=utf8 COLLATE=utf8_general_ci
  COMMENT='区域码表'
  AUTO_INCREMENT=3891

;

-- ----------------------------
-- Table structure for `assessment_apply`
-- ----------------------------
DROP TABLE IF EXISTS `assessment_apply`;
CREATE TABLE `assessment_apply` (
  `id`  bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键id' ,
  `assessmentno`  varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '评估编号' ,
  `carid`  bigint(20) NULL DEFAULT NULL COMMENT '车辆表关联id' ,
  `ownername`  varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '车主姓名' ,
  `ownphone`  bigint(20) NULL DEFAULT NULL COMMENT '车主电话' ,
  `idcard`  varchar(18) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '身份证号' ,
  `province`  varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '省' ,
  `city`  varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '市' ,
  `carcolor`  varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '车身颜色' ,
  `engineno`  varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '发动机号' ,
  `frameno`  varchar(30) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '车架号' ,
  `carno`  varchar(10) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '车牌号' ,
  `applicant`  varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '申请人' ,
  `applytime`  datetime NULL DEFAULT NULL COMMENT '申请时间' ,
  `assessmentperson`  varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '评估人' ,
  `assessmenttime`  datetime NULL DEFAULT NULL COMMENT '评估时间' ,
  `assessmentstatus`  int(4) NULL DEFAULT NULL COMMENT '审核状态' ,
  `isdelete`  int(4) NULL DEFAULT NULL COMMENT '是否删除' ,
  PRIMARY KEY (`id`),
  INDEX `FK_Reference_1` (`carid`) USING BTREE
)
  ENGINE=InnoDB
  DEFAULT CHARACTER SET=utf8 COLLATE=utf8_general_ci
  AUTO_INCREMENT=1

;

-- ----------------------------
-- Table structure for `assessment_apply_record`
-- ----------------------------
DROP TABLE IF EXISTS `assessment_apply_record`;
CREATE TABLE `assessment_apply_record` (
  `id`  bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键' ,
  `applyid`  bigint(20) NULL DEFAULT NULL COMMENT '评估申请单id' ,
  `applystatus`  int(4) NULL DEFAULT NULL COMMENT '订单状态' ,
  `statusstatements`  varchar(500) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '状态说明' ,
  `approvaldate`  datetime NULL DEFAULT NULL COMMENT '审批日期' ,
  `intopooldate`  datetime NULL DEFAULT NULL COMMENT '进入审核资源池的时间' ,
  `receivedate`  datetime NULL DEFAULT NULL COMMENT '领取日期' ,
  `operator`  bigint(20) NULL DEFAULT NULL COMMENT '操作员' ,
  `operatetime`  datetime NULL DEFAULT NULL COMMENT '操作时间' ,
  PRIMARY KEY (`id`)
)
  ENGINE=InnoDB
  DEFAULT CHARACTER SET=utf8 COLLATE=utf8_general_ci
  AUTO_INCREMENT=1

;

-- ----------------------------
-- Table structure for `assessment_basic`
-- ----------------------------
DROP TABLE IF EXISTS `assessment_basic`;
CREATE TABLE `assessment_basic` (
  `id`  bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键id' ,
  `applyid`  bigint(20) NULL DEFAULT NULL COMMENT '车辆值_主键id' ,
  `firsttime`  datetime NULL DEFAULT NULL COMMENT '初登日期' ,
  `factorytime`  datetime NULL DEFAULT NULL COMMENT '出厂日期' ,
  `mileage`  int(10) NULL DEFAULT NULL COMMENT '行驶里程' ,
  `drivingno`  varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '行驶证号' ,
  `transferno`  int(2) NULL DEFAULT NULL COMMENT '过户次数' ,
  `carpurpose`  int(4) NULL DEFAULT NULL COMMENT '车辆用途' ,
  `transmission`  int(4) NULL DEFAULT NULL COMMENT '变速箱形式' ,
  `driver`  int(4) NULL DEFAULT NULL COMMENT '驱动形式' ,
  `displacement`  varchar(10) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '排量' ,
  `carsituation`  int(4) NULL DEFAULT NULL COMMENT '车况' ,
  `evaluation`  double(10,0) NULL DEFAULT NULL COMMENT '估价' ,
  `remarks`  varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '备注' ,
  PRIMARY KEY (`id`),
  INDEX `FK_Reference_3` (`applyid`) USING BTREE
)
  ENGINE=InnoDB
  DEFAULT CHARACTER SET=utf8 COLLATE=utf8_general_ci
  AUTO_INCREMENT=1

;

-- ----------------------------
-- Table structure for `backlog`
-- ----------------------------
DROP TABLE IF EXISTS `backlog`;
CREATE TABLE `backlog` (
  `id`  bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键id' ,
  `type`  int(11) NULL DEFAULT NULL COMMENT '待办事项类型' ,
  `operator`  bigint(20) NULL DEFAULT NULL ,
  `operate_time`  datetime NULL DEFAULT NULL ,
  `status`  int(4) NULL DEFAULT NULL COMMENT '是否启用 0 启用 1 停用' ,
  PRIMARY KEY (`id`)
)
  ENGINE=InnoDB
  DEFAULT CHARACTER SET=utf8 COLLATE=utf8_general_ci
  AUTO_INCREMENT=10

;

-- ----------------------------
-- Table structure for `bankcard_detail`
-- ----------------------------
DROP TABLE IF EXISTS `bankcard_detail`;
CREATE TABLE `bankcard_detail` (
  `id`  bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键' ,
  `companyaccount_id`  bigint(20) NULL DEFAULT NULL COMMENT '企业账户id' ,
  `companybaccount_name`  varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '企业账户名' ,
  `deposit_bank`  varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '开户行' ,
  `branch_name`  varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '支行名称' ,
  `account_province`  varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL ,
  `account_city`  varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL ,
  `isdefault`  bigint(20) NULL DEFAULT NULL ,
  PRIMARY KEY (`id`)
)
  ENGINE=InnoDB
  DEFAULT CHARACTER SET=utf8 COLLATE=utf8_general_ci
  COMMENT='银行卡信息'
  AUTO_INCREMENT=1

;

-- ----------------------------
-- Table structure for `batch_seq`
-- ----------------------------
DROP TABLE IF EXISTS `batch_seq`;
CREATE TABLE `batch_seq` (
  `seq_name`  varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '序列名称' ,
  `current_seq`  int(11) NOT NULL COMMENT '当前值' ,
  PRIMARY KEY (`seq_name`)
)
  ENGINE=InnoDB
  DEFAULT CHARACTER SET=utf8 COLLATE=utf8_general_ci

;

-- ----------------------------
-- Table structure for `car`
-- ----------------------------
DROP TABLE IF EXISTS `car`;
CREATE TABLE `car` (
  `id`  bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键' ,
  `series_id`  bigint(20) NULL DEFAULT NULL COMMENT '车辆系列id' ,
  `vehicle_id`  varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '进销存车辆id' ,
  `brand_id`  bigint(20) NULL DEFAULT NULL COMMENT '车辆品牌' ,
  `model_name`  varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '车辆型号' ,
  `car_colour`  varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '车身颜色' ,
  `car_emissions`  varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '车辆排量' ,
  `car_configuration`  varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '车辆配置' ,
  `registration_area`  varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '上牌地区' ,
  `car_licence`  varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '车辆牌照' ,
  `store`  varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '所在门店' ,
  `status`  int(4) NULL DEFAULT NULL COMMENT '状态' ,
  `car_amount`  decimal(18,4) NULL DEFAULT 0.0000 COMMENT '车辆金额' ,
  `other_expenses`  decimal(18,4) NULL DEFAULT 0.0000 COMMENT '其他费用' ,
  `amount`  decimal(18,4) NULL DEFAULT 0.0000 COMMENT '总金额' ,
  `remark`  varchar(500) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '备注' ,
  `operator`  bigint(20) NULL DEFAULT NULL COMMENT '操作人' ,
  `operate_time`  datetime NULL DEFAULT NULL COMMENT '操作时间' ,
  `model_code`  varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL ,
  `model_remark`  varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL ,
  PRIMARY KEY (`id`)
)
  ENGINE=InnoDB
  DEFAULT CHARACTER SET=utf8 COLLATE=utf8_general_ci
  COMMENT='车辆信息'
  AUTO_INCREMENT=3

;

-- ----------------------------
-- Table structure for `car_attr_value`
-- ----------------------------
DROP TABLE IF EXISTS `car_attr_value`;
CREATE TABLE `car_attr_value` (
  `id`  bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键id' ,
  `basicid`  bigint(20) NULL DEFAULT NULL COMMENT '申请id' ,
  `attrname`  varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '属性id' ,
  `attrvalue`  varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '属性值' ,
  PRIMARY KEY (`id`),
  INDEX `FK_Reference_3` (`basicid`) USING BTREE
)
  ENGINE=InnoDB
  DEFAULT CHARACTER SET=utf8 COLLATE=utf8_general_ci
  AUTO_INCREMENT=1

;

-- ----------------------------
-- Table structure for `car_attribute`
-- ----------------------------
DROP TABLE IF EXISTS `car_attribute`;
CREATE TABLE `car_attribute` (
  `id`  bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键id' ,
  `attrtype`  int(4) NULL DEFAULT NULL COMMENT '属性类型' ,
  `attrname`  varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '属性名称' ,
  `attrvalue`  varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '属性值' ,
  PRIMARY KEY (`id`)
)
  ENGINE=InnoDB
  DEFAULT CHARACTER SET=utf8 COLLATE=utf8_general_ci
  AUTO_INCREMENT=1

;

-- ----------------------------
-- Table structure for `car_basic_file`
-- ----------------------------
DROP TABLE IF EXISTS `car_basic_file`;
CREATE TABLE `car_basic_file` (
  `id`  bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键' ,
  `basicid`  bigint(20) NULL DEFAULT NULL COMMENT '评估信息id' ,
  `originname`  varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '资料原名称' ,
  `filename`  varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '资料上传名称' ,
  `datasize`  int(4) NULL DEFAULT NULL COMMENT '资料大小' ,
  `materialurl`  varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '上传资料路径' ,
  `isdelete`  int(4) NULL DEFAULT NULL COMMENT '是否删除' ,
  `operator`  bigint(20) NULL DEFAULT NULL COMMENT '操作员' ,
  `operatetime`  datetime NULL DEFAULT NULL COMMENT '上传时间' ,
  PRIMARY KEY (`id`),
  INDEX `FK_Reference_5` (`basicid`) USING BTREE
)
  ENGINE=InnoDB
  DEFAULT CHARACTER SET=utf8 COLLATE=utf8_general_ci
  AUTO_INCREMENT=1

;

-- ----------------------------
-- Table structure for `car_brand`
-- ----------------------------
DROP TABLE IF EXISTS `car_brand`;
CREATE TABLE `car_brand` (
  `id`  bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键' ,
  `brand_name`  varchar(60) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '车辆品牌' ,
  `brand_code`  varchar(60) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '品牌code' ,
  `remark`  varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '品牌描述' ,
  `operator`  bigint(20) NULL DEFAULT NULL COMMENT '操作人' ,
  `operator_time`  datetime NULL DEFAULT NULL COMMENT '操作时间' ,
  PRIMARY KEY (`id`)
)
  ENGINE=InnoDB
  DEFAULT CHARACTER SET=utf8 COLLATE=utf8_general_ci
  AUTO_INCREMENT=2

;

-- ----------------------------
-- Table structure for `car_param`
-- ----------------------------
DROP TABLE IF EXISTS `car_param`;
CREATE TABLE `car_param` (
  `id`  bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键' ,
  `type_code`  varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '类型code' ,
  `value`  varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL ,
  `name`  varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL ,
  `sort`  int(4) NULL DEFAULT NULL COMMENT '排序' ,
  PRIMARY KEY (`id`)
)
  ENGINE=InnoDB
  DEFAULT CHARACTER SET=utf8 COLLATE=utf8_general_ci
  COMMENT='车辆参数'
  AUTO_INCREMENT=5

;

-- ----------------------------
-- Table structure for `car_param_type`
-- ----------------------------
DROP TABLE IF EXISTS `car_param_type`;
CREATE TABLE `car_param_type` (
  `id`  bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键' ,
  `car_id`  bigint(20) NULL DEFAULT NULL COMMENT '车辆ID' ,
  `param_type`  int(4) NULL DEFAULT NULL COMMENT '参数类型' ,
  `param_code`  varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '参数code' ,
  `param_name`  varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '参数名称' ,
  `operator`  bigint(20) NULL DEFAULT NULL COMMENT '操作人' ,
  `operate_time`  datetime NULL DEFAULT NULL COMMENT '操作时间' ,
  PRIMARY KEY (`id`)
)
  ENGINE=InnoDB
  DEFAULT CHARACTER SET=utf8 COLLATE=utf8_general_ci
  COMMENT='车辆参数类型'
  AUTO_INCREMENT=8

;

-- ----------------------------
-- Table structure for `car_quotation`
-- ----------------------------
DROP TABLE IF EXISTS `car_quotation`;
CREATE TABLE `car_quotation` (
  `id`  bigint(20) NOT NULL AUTO_INCREMENT ,
  `quotation_name`  varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '供应商名称' ,
  `product_package_id`  bigint(20) NULL DEFAULT NULL COMMENT '产品包名称' ,
  `car_id`  bigint(20) NULL DEFAULT NULL COMMENT '车辆型号' ,
  `market_guiding_price`  decimal(12,0) NULL DEFAULT NULL COMMENT '市场指导价' ,
  `dealer_guiding_price`  decimal(12,0) NULL DEFAULT NULL COMMENT '经销商指导价' ,
  `first_payment`  decimal(12,0) NULL DEFAULT NULL COMMENT '产付款或保证金' ,
  `finance_amount`  decimal(12,0) NULL DEFAULT NULL COMMENT '融资金额' ,
  `periods`  int(4) NULL DEFAULT NULL COMMENT '期限；1 24月；2 36月' ,
  `month_pay`  decimal(12,0) NULL DEFAULT NULL COMMENT '月供' ,
  `purchase_tax_money`  decimal(12,0) NULL DEFAULT NULL COMMENT '购置税' ,
  `road_bridge_fee`  decimal(12,0) NULL DEFAULT NULL COMMENT '过桥费' ,
  `annual_amount`  decimal(12,0) NULL DEFAULT NULL COMMENT '保险费' ,
  `gps_fee`  decimal(12,0) NULL DEFAULT NULL COMMENT 'GPS费' ,
  `other_fee`  decimal(12,0) NULL DEFAULT NULL COMMENT '其它费用' ,
  `status`  int(2) NULL DEFAULT NULL ,
  `remark`  varchar(500) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL ,
  `operator`  bigint(20) NULL DEFAULT NULL COMMENT '操作人' ,
  `operate_time`  datetime NULL DEFAULT NULL COMMENT '操作时间' ,
  PRIMARY KEY (`id`)
)
  ENGINE=InnoDB
  DEFAULT CHARACTER SET=utf8 COLLATE=utf8_general_ci
  AUTO_INCREMENT=1

;

-- ----------------------------
-- Table structure for `car_series`
-- ----------------------------
DROP TABLE IF EXISTS `car_series`;
CREATE TABLE `car_series` (
  `id`  bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键ID' ,
  `dept_type`  int(4) NULL DEFAULT NULL COMMENT '机构类型' ,
  `dept_top`  varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '顶级机构' ,
  `brand_id`  bigint(20) NULL DEFAULT NULL COMMENT '品牌' ,
  `series_name`  varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '系列' ,
  `models`  varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '车型' ,
  `operator`  bigint(20) NULL DEFAULT NULL COMMENT '操作人' ,
  `operate_time`  datetime NULL DEFAULT NULL COMMENT '操作时间' ,
  `series_remark`  varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL ,
  `series_code`  varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL ,
  PRIMARY KEY (`id`)
)
  ENGINE=InnoDB
  DEFAULT CHARACTER SET=utf8 COLLATE=utf8_general_ci
  COMMENT='车辆系列表'
  AUTO_INCREMENT=3

;

-- ----------------------------
-- Table structure for `charge_back_recode`
-- ----------------------------
DROP TABLE IF EXISTS `charge_back_recode`;
CREATE TABLE `charge_back_recode` (
  `id`  bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键' ,
  `personal_id`  bigint(20) NULL DEFAULT NULL COMMENT '客户ID' ,
  `payment_date`  datetime NULL DEFAULT NULL COMMENT '支付日期' ,
  `payment_amount`  decimal(18,4) NULL DEFAULT 0.0000 COMMENT '支付金额' ,
  `order_number`  varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '订单号' ,
  `trading_status`  int(2) NULL DEFAULT NULL COMMENT '交易状态' ,
  `remark`  varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '备注' ,
  `operator`  bigint(20) NULL DEFAULT NULL COMMENT '操作员' ,
  `operator_time`  datetime NULL DEFAULT NULL COMMENT '操作时间' ,
  `deposit_bank`  varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '开户银行' ,
  `client_number`  varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '客户号' ,
  `card_number`  varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '银行卡号' ,
  PRIMARY KEY (`id`)
)
  ENGINE=InnoDB
  DEFAULT CHARACTER SET=utf8 COLLATE=utf8_general_ci
  COMMENT='划扣记录'
  AUTO_INCREMENT=1

;

-- ----------------------------
-- Table structure for `collect_money_detail`
-- ----------------------------
DROP TABLE IF EXISTS `collect_money_detail`;
CREATE TABLE `collect_money_detail` (
  `id`  bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键' ,
  `collect_money_id`  bigint(20) NULL DEFAULT NULL COMMENT '收款记录Id' ,
  `channel_type`  int(4) NULL DEFAULT NULL COMMENT '渠道类型' ,
  `collect_money_channel`  int(4) NULL DEFAULT NULL COMMENT '收款渠道' ,
  `collect_money_method`  int(4) NULL DEFAULT NULL COMMENT '收款方式' ,
  `collect_item`  int(2) NULL DEFAULT NULL COMMENT '收款项' ,
  `collect_money_amount`  decimal(18,4) NULL DEFAULT 0.0000 COMMENT '实收金额' ,
  `defray_bank`  varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '支付银行' ,
  `defray_card_number`  varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '交易卡号' ,
  `client_number`  varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '客户号' ,
  `online_deal_number`  varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '线上划扣交易号' ,
  `deal_status`  int(4) NULL DEFAULT NULL COMMENT '交易处理状态' ,
  `invoicing_status`  int(4) NULL DEFAULT NULL COMMENT '开票状态' ,
  `remark`  varchar(2000) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '备注' ,
  `is_account_checking`  int(4) NULL DEFAULT 0 COMMENT '财务对账的一个标识  0 是未 1是对了' ,
  `is_draft`  int(4) NULL DEFAULT NULL COMMENT '是否是草稿(29:是,30:不是)' ,
  PRIMARY KEY (`id`)
)
  ENGINE=InnoDB
  DEFAULT CHARACTER SET=utf8 COLLATE=utf8_general_ci
  COMMENT='收款记录明细表'
  AUTO_INCREMENT=1

;

-- ----------------------------
-- Table structure for `collect_money_history`
-- ----------------------------
DROP TABLE IF EXISTS `collect_money_history`;
CREATE TABLE `collect_money_history` (
  `id`  bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键' ,
  `order_id`  bigint(20) NULL DEFAULT NULL COMMENT '订单id' ,
  `business_id`  bigint(20) NULL DEFAULT NULL COMMENT '业务Id' ,
  `collect_money_phase`  int(4) NULL DEFAULT NULL COMMENT '收款阶段' ,
  `record_status`  int(4) NULL DEFAULT NULL COMMENT '记录状态 160-草稿 161-收款记录' ,
  `actual_collect_date`  datetime NULL DEFAULT NULL COMMENT '实际付款日' ,
  `collect_money_sum`  decimal(18,4) NULL DEFAULT 0.0000 COMMENT '还款金额' ,
  `start_term`  varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '提前结清分期开始期数' ,
  `periods`  int(4) NULL DEFAULT NULL COMMENT '还款期数' ,
  `remark`  varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '备注' ,
  `operator`  bigint(20) NULL DEFAULT NULL COMMENT '操作员' ,
  `operator_time`  datetime NULL DEFAULT NULL COMMENT '操作时间' ,
  PRIMARY KEY (`id`)
)
  ENGINE=InnoDB
  DEFAULT CHARACTER SET=utf8 COLLATE=utf8_general_ci
  COMMENT='收款记录表'
  AUTO_INCREMENT=1

;

-- ----------------------------
-- Table structure for `company`
-- ----------------------------
DROP TABLE IF EXISTS `company`;
CREATE TABLE `company` (
  `id`  bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键id' ,
  `company_chinaname`  varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '公司中文名称' ,
  `company_engname`  varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '公司英文名称' ,
  `company_city`  bigint(4) NULL DEFAULT NULL COMMENT '公司城市' ,
  `bank_account`  varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '户名' ,
  `deposit_bank`  varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '开户银行' ,
  `card_number`  varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '银行卡号' ,
  `branch_name`  varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '支行名称' ,
  `company_status`  int(4) NULL DEFAULT NULL COMMENT '状态' ,
  `company_legperson`  varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '公司法人' ,
  `company_address`  varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '公司地址' ,
  `company_phone`  varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '公司电话' ,
  `company_fax`  varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '公司传真' ,
  `company_linkman`  varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '公司联系人' ,
  `operator`  bigint(20) NULL DEFAULT NULL COMMENT '创建人' ,
  `operate_time`  datetime NULL DEFAULT NULL COMMENT '创建时间' ,
  `company_remark`  varchar(1000) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '备注' ,
  PRIMARY KEY (`id`)
)
  ENGINE=InnoDB
  DEFAULT CHARACTER SET=utf8 COLLATE=utf8_general_ci
  COMMENT='公司的信息'
  AUTO_INCREMENT=5

;

-- ----------------------------
-- Table structure for `company_account`
-- ----------------------------
DROP TABLE IF EXISTS `company_account`;
CREATE TABLE `company_account` (
  `id`  bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键' ,
  `account_channel`  bigint(20) NULL DEFAULT NULL ,
  `account_type`  bigint(20) NULL DEFAULT NULL ,
  `account_name`  varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '账户名' ,
  `account_number`  varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '账户号' ,
  `create_time`  datetime NULL DEFAULT NULL COMMENT '开户时间' ,
  `company_id`  bigint(100) NULL DEFAULT NULL COMMENT '企业id' ,
  `company_license_number`  varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '营业执照注册号' ,
  `organization_code`  varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '组织机构代码' ,
  `tax_registration`  varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '税务登记证号' ,
  `social_credit_code`  varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '统一社会信用代码' ,
  `certificate_type`  varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '企业证照类型' ,
  `company_type`  varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '企业类型' ,
  `license_begin_time`  date NULL DEFAULT NULL COMMENT '证照起始日期' ,
  `license_end_time`  date NULL DEFAULT NULL COMMENT '证照结束日期' ,
  `Controll_shareholder`  varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '控股股东' ,
  `regist_addr`  varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '企业注册地址' ,
  `busness_scope`  varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '经营范围' ,
  `legperson_Certificate`  varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '法人证件类型' ,
  `legperson_Certificate_number`  varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '法人证件号码' ,
  `legperson_Certificate_stime`  date NULL DEFAULT NULL COMMENT '法人证件起始日期' ,
  `legperson_Certificate_etime`  date NULL DEFAULT NULL COMMENT '法人证件结束日期' ,
  `legperson_phone_number`  bigint(20) NULL DEFAULT NULL COMMENT '法人手机号码' ,
  `legperson_mail`  varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '法人邮箱' ,
  PRIMARY KEY (`id`)
)
  ENGINE=InnoDB
  DEFAULT CHARACTER SET=utf8 COLLATE=utf8_general_ci
  COMMENT='企业开户信息'
  AUTO_INCREMENT=1

;

-- ----------------------------
-- Table structure for `contract_batch`
-- ----------------------------
DROP TABLE IF EXISTS `contract_batch`;
CREATE TABLE `contract_batch` (
  `id`  bigint(20) NOT NULL AUTO_INCREMENT COMMENT 'ID 标识 ' ,
  `type_code`  varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '类型编码：如ERP；BG；TB；' ,
  `contract_model_code`  varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL ,
  `batch_number`  varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '批次号，每次递增' ,
  `relation_number`  varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '关联编号（可以是订单号，可以是ID，用于关联信息）' ,
  `create_time`  varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '创建时间' ,
  `category_one`  varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '产品类型 (3助业、4工薪、5车贷、6零用、7赎楼、8消费金融、9U信、10宽贷)' ,
  `category_two`  varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '0：贝格，1：ERP，2：投呗' ,
  `category_three`  varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL ,
  `category_four`  varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL ,
  `category_five`  varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '0：poc,1:boc' ,
  `category_six`  varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL ,
  `category_seven`  varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL ,
  `ftp_status`  varchar(2) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '0:未上传，1：上传成功' ,
  `ca_channel`  varchar(30) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT 'CA签约通道(000023-0001:天威 ；000023-0002：易保全)' ,
  `issync`  varchar(10) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT 'async:异步,sync:同步' ,
  `need_pdf`  varchar(10) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '本批次需要生产的pdf数量' ,
  `need_ca`  varchar(10) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '本批次需要签章CA的数量' ,
  `need_succ_pdf`  varchar(10) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '本批次成功生产PDF的数量' ,
  `need_succ_ca`  varchar(10) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '本批次成功签章的数量' ,
  `status`  varchar(10) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '批次状态 0:数据生成中,1:合同生产中,2:CA签章中，3:批次完成，4:作废/失效' ,
  `is_call_back`  varchar(10) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '是否需要毁掉  0：不需要，1：需要 （需要回掉回掉rul必须有值' ,
  `cal_back_url`  varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '回调通知url' ,
  `back_count`  varchar(10) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '回调通知次数(每1小时通知一次，次数<=3)' ,
  `back_status`  varchar(10) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '回调状态(0：等待通知，1：通知成功，2：通知失败)' ,
  `isasyncSign`  varchar(10) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT 'async:异步,sync:同步' ,
  `async_pdf_status`  varchar(10) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '异步签章生成pdf是否全部成功（0:否，1，是）' ,
  `batch_data_json`  text CHARACTER SET utf8 COLLATE utf8_general_ci NULL COMMENT '合同生成必要json' ,
  `back_time`  varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '最后一次通知时间' ,
  `emp_id`  varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '操作人empId' ,
  PRIMARY KEY (`id`)
)
  ENGINE=InnoDB
  DEFAULT CHARACTER SET=utf8 COLLATE=utf8_general_ci
  AUTO_INCREMENT=1

;

-- ----------------------------
-- Table structure for `contract_info`
-- ----------------------------
DROP TABLE IF EXISTS `contract_info`;
CREATE TABLE `contract_info` (
  `id`  bigint(20) NOT NULL AUTO_INCREMENT COMMENT 'ID 标识 ' ,
  `contract_number`  varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '合同编号' ,
  `contract_batch_id`  varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '批次号信息' ,
  `contract_template_url`  varchar(300) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '模板地址' ,
  `contract_pdf_status`  varchar(2) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT 'pdf 生产状态 生成PDF状态（0不需要生成，1生成中，2生成成功，3生成失败，4上传失败）' ,
  `contract_ca_status`  varchar(2) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT 'CA签章状态 CA签章状态（0签章中，1签章成功，2签章失败，3不需要签章）' ,
  `order_number`  varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '订单编号 合同服务于那个订单' ,
  `crm_applay_id`  varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '申请单ID  暂时保留，后期删掉' ,
  `crm_order_id`  varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '订单ID  暂时保留，后期删掉' ,
  `pdf_status`  varchar(2) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT 'pdf生成状态 0:未上传，1：上传成功' ,
  `ca_status`  varchar(2) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT 'CA签章状态  0:未成功，1：签章成功' ,
  `pdf_url`  varchar(400) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT 'pdf保存地址' ,
  `ca_pdf_url`  varchar(400) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '签章后的PDF保存地址' ,
  `contract_name`  varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '合同名称' ,
  `contract_data_json`  text CHARACTER SET utf8 COLLATE utf8_general_ci NULL COMMENT '合同生成必要数据json' ,
  `create_time`  varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '创建时间' ,
  `status`  varchar(10) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '批次状态 0:数据生成中,1:合同生产中,2:CA签章中，3:批次完成，4:作废/失效' ,
  `signature_json`  varchar(500) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '签章相关信息json' ,
  `unique_code1`  varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL ,
  `unique_code2`  varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL ,
  `unique_code3`  varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL ,
  `unique_code4`  varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL ,
  `contract_enum`  varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL ,
  `isasyncSign`  varchar(10) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT 'async:异步,sync:同步' ,
  `num`  varchar(10) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT 'CA处理次数，超过2次，不在处理' ,
  `finish_time`  varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL ,
  PRIMARY KEY (`id`),
  INDEX `contract_batch_id` (`contract_batch_id`) USING BTREE
)
  ENGINE=InnoDB
  DEFAULT CHARACTER SET=utf8 COLLATE=utf8_general_ci
  AUTO_INCREMENT=1

;

-- ----------------------------
-- Table structure for `contract_record`
-- ----------------------------
DROP TABLE IF EXISTS `contract_record`;
CREATE TABLE `contract_record` (
  `id`  bigint(20) NOT NULL AUTO_INCREMENT COMMENT 'ID 标识 ' ,
  `contract_number`  varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '合同编号' ,
  `contract_info_id`  varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '合同信息ID' ,
  `create_time`  varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '创建时间' ,
  `pdf_status`  varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '0:本次需要重新创建,1：本次不需要创建' ,
  `ca_status`  varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '0:本次需要重新签章,1：本次不需要签章' ,
  `pdf_result`  text CHARACTER SET utf8 COLLATE utf8_general_ci NULL COMMENT 'pdf 创建返回结果，如果异常，记录异常代码' ,
  `ca_result`  text CHARACTER SET utf8 COLLATE utf8_general_ci NULL COMMENT 'CA 签章返回结果，如果异常，记录异常代码' ,
  PRIMARY KEY (`id`),
  INDEX `contract_info_id` (`contract_info_id`) USING BTREE
)
  ENGINE=InnoDB
  DEFAULT CHARACTER SET=utf8 COLLATE=utf8_general_ci
  AUTO_INCREMENT=1

;

-- ----------------------------
-- Table structure for `contract_upload_file`
-- ----------------------------
DROP TABLE IF EXISTS `contract_upload_file`;
CREATE TABLE `contract_upload_file` (
  `id`  bigint(64) NOT NULL AUTO_INCREMENT COMMENT '主键' ,
  `order_id`  bigint(20) NULL DEFAULT NULL COMMENT '订单id' ,
  `origin_name`  varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '资料原名称' ,
  `upload_name`  varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '资料上传名称' ,
  `material_type`  int(4) NULL DEFAULT NULL COMMENT '合同类型' ,
  `data_size`  int(4) NULL DEFAULT NULL COMMENT '资料大小' ,
  `material_url`  varchar(500) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '上传资料路径' ,
  `is_delete`  int(4) NULL DEFAULT NULL COMMENT '是否删除' ,
  `operator`  bigint(64) NULL DEFAULT NULL COMMENT '操作员' ,
  `operate_time`  datetime NULL DEFAULT NULL COMMENT '操作时间' ,
  PRIMARY KEY (`id`)
)
  ENGINE=InnoDB
  DEFAULT CHARACTER SET=utf8 COLLATE=utf8_general_ci
  COMMENT='合同上传资料'
  AUTO_INCREMENT=1

;

-- ----------------------------
-- Table structure for `data_dict`
-- ----------------------------
DROP TABLE IF EXISTS `data_dict`;
CREATE TABLE `data_dict` (
  `id`  int(11) NOT NULL AUTO_INCREMENT ,
  `type_code`  varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL ,
  `code`  varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL ,
  `name`  varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL ,
  `sort`  int(11) NULL DEFAULT NULL ,
  PRIMARY KEY (`id`)
)
  ENGINE=InnoDB
  DEFAULT CHARACTER SET=utf8 COLLATE=utf8_general_ci
  AUTO_INCREMENT=1193

;

-- ----------------------------
-- Table structure for `data_dict_type`
-- ----------------------------
DROP TABLE IF EXISTS `data_dict_type`;
CREATE TABLE `data_dict_type` (
  `id`  int(11) NOT NULL AUTO_INCREMENT ,
  `code`  varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL ,
  `name`  varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL ,
  `type`  int(11) NULL DEFAULT NULL COMMENT '0 代表业务  1 非业务' ,
  PRIMARY KEY (`id`)
)
  ENGINE=InnoDB
  DEFAULT CHARACTER SET=utf8 COLLATE=utf8_general_ci
  AUTO_INCREMENT=441

;

-- ----------------------------
-- Table structure for `department`
-- ----------------------------
DROP TABLE IF EXISTS `department`;
CREATE TABLE `department` (
  `id`  bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键id' ,
  `company_id`  bigint(20) NULL DEFAULT NULL COMMENT '部门的公司id' ,
  `dept_pid`  bigint(20) NULL DEFAULT NULL COMMENT '父id' ,
  `dept_name`  varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '机构名称' ,
  `dept_type`  int(4) NULL DEFAULT NULL COMMENT '机构类型' ,
  `dept_code`  varchar(500) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '机构编号' ,
  `dept_level`  int(4) NULL DEFAULT NULL COMMENT '机构等级' ,
  `dept_status`  int(4) NULL DEFAULT NULL COMMENT '状态' ,
  `dept_remark`  varchar(500) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '备注' ,
  `operator`  bigint(20) NULL DEFAULT NULL COMMENT '创建人' ,
  `operate_time`  datetime NULL DEFAULT NULL COMMENT '创建时间' ,
  PRIMARY KEY (`id`)
)
  ENGINE=InnoDB
  DEFAULT CHARACTER SET=utf8 COLLATE=utf8_general_ci
  COMMENT='组织机构'
  AUTO_INCREMENT=7

;

-- ----------------------------
-- Table structure for `device`
-- ----------------------------
DROP TABLE IF EXISTS `device`;
CREATE TABLE `device` (
  `id`  bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键id' ,
  `user_id`  bigint(20) NULL DEFAULT NULL COMMENT '用户id' ,
  `dev_code`  varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '设备编号' ,
  `dev_type`  int(4) NULL DEFAULT NULL COMMENT '设备类型' ,
  `dev_name`  varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '设备名称' ,
  `dev_validate`  int(4) NULL DEFAULT NULL COMMENT '是否开启设备验证' ,
  `dev_status`  int(4) NULL DEFAULT NULL COMMENT '状态（启用停用）' ,
  `operator`  bigint(20) NULL DEFAULT NULL COMMENT '创建人' ,
  `operate_time`  datetime NULL DEFAULT NULL COMMENT '创建日期' ,
  `field`  varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '备用字段' ,
  `mac`  varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL ,
  PRIMARY KEY (`id`)
)
  ENGINE=InnoDB
  DEFAULT CHARACTER SET=utf8 COLLATE=utf8_general_ci
  COMMENT='用户登录设备'
  AUTO_INCREMENT=8

;

-- ----------------------------
-- Table structure for `finance_approval_history`
-- ----------------------------
DROP TABLE IF EXISTS `finance_approval_history`;
CREATE TABLE `finance_approval_history` (
  `id`  bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键' ,
  `withdraw_id`  bigint(20) NULL DEFAULT NULL COMMENT '收款id' ,
  `approval_status`  int(4) NULL DEFAULT NULL COMMENT '审批状态' ,
  `remark`  varchar(500) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '备注说明' ,
  `operator`  bigint(20) NULL DEFAULT NULL COMMENT '操作员' ,
  `operator_time`  datetime NULL DEFAULT NULL COMMENT '操作时间' ,
  PRIMARY KEY (`id`)
)
  ENGINE=InnoDB
  DEFAULT CHARACTER SET=utf8 COLLATE=utf8_general_ci
  COMMENT='审批记录表'
  AUTO_INCREMENT=1

;

-- ----------------------------
-- Table structure for `finance_invoice`
-- ----------------------------
DROP TABLE IF EXISTS `finance_invoice`;
CREATE TABLE `finance_invoice` (
  `id`  bigint(20) NOT NULL COMMENT '主键' ,
  `collect_money_detail_id`  bigint(20) NULL DEFAULT NULL COMMENT '收款明细Id' ,
  `invoice_number`  varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '发票号' ,
  `invoicing_amount`  decimal(18,4) NULL DEFAULT NULL COMMENT '开票金额' ,
  `invoicing_date`  datetime NULL DEFAULT NULL COMMENT '开票日期' ,
  `invoice_title`  varchar(500) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '发票抬头' ,
  `is_undo`  tinyint(4) NULL DEFAULT NULL COMMENT '是否已撤销(0-正常，1-已撤销)' ,
  `remark`  varchar(2000) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '备注' ,
  `operator`  bigint(20) NULL DEFAULT NULL COMMENT '操作人' ,
  `operator_date`  datetime NULL DEFAULT NULL COMMENT '操作时间' ,
  PRIMARY KEY (`id`)
)
  ENGINE=InnoDB
  DEFAULT CHARACTER SET=utf8 COLLATE=utf8_general_ci
  COMMENT='财务开票'

;

-- ----------------------------
-- Table structure for `finance_upload_resource`
-- ----------------------------
DROP TABLE IF EXISTS `finance_upload_resource`;
CREATE TABLE `finance_upload_resource` (
  `id`  bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键' ,
  `order_id`  bigint(20) NULL DEFAULT NULL COMMENT '订单Id' ,
  `business_id`  bigint(20) NULL DEFAULT NULL COMMENT '业务id' ,
  `upload_phase`  int(4) NULL DEFAULT NULL COMMENT '上传阶段' ,
  `origin_name`  varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '资料原名称' ,
  `upload_name`  varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '资料上传名称' ,
  `material_type`  varchar(10) DEFAULT NULL COMMENT '资料类型',
  `data_size`  int(10) NULL DEFAULT NULL COMMENT '资料大小' ,
  `material_url`  varchar(500) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '上传资料路径' ,
  `is_delete`  int(4) NULL DEFAULT NULL COMMENT '是否删除' ,
  `operator`  bigint(20) NULL DEFAULT NULL COMMENT '操作员' ,
  `operator_time`  datetime NULL DEFAULT NULL COMMENT '操作时间' ,
  PRIMARY KEY (`id`)
)
  ENGINE=InnoDB
  DEFAULT CHARACTER SET=utf8 COLLATE=utf8_general_ci
  COMMENT='财务业务上传资料'
  AUTO_INCREMENT=1

;

-- ----------------------------
-- Table structure for `handover_record`
-- ----------------------------
DROP TABLE IF EXISTS `handover_record`;
CREATE TABLE `handover_record` (
  `id`  bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键ID' ,
  `order_id`  bigint(20) NULL DEFAULT NULL COMMENT '订单ID' ,
  `order_num`  varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '订单号' ,
  `transfer_id`  bigint(20) NULL DEFAULT NULL COMMENT '转交人ID' ,
  `transfer_name`  varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '转交人姓名' ,
  `recorder_id`  bigint(20) NULL DEFAULT NULL COMMENT '录单人ID' ,
  `recorder_name`  varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '录单员姓名' ,
  `create_time`  datetime NULL DEFAULT NULL COMMENT '创建时间' ,
  `operator`  bigint(20) NULL DEFAULT NULL COMMENT '操作人' ,
  PRIMARY KEY (`id`)
)
  ENGINE=InnoDB
  DEFAULT CHARACTER SET=utf8 COLLATE=utf8_general_ci
  AUTO_INCREMENT=1

;

-- ----------------------------
-- Table structure for `invoicing_allocation_record`
-- ----------------------------
DROP TABLE IF EXISTS `invoicing_allocation_record`;
CREATE TABLE `invoicing_allocation_record` (
  `id`  bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键ID' ,
  `allocation_order_id`  bigint(20) NULL DEFAULT NULL COMMENT '调拨申请ID' ,
  `vehicle_id`  bigint(20) NULL DEFAULT NULL COMMENT '车辆ID' ,
  `type`  int(10) NULL DEFAULT NULL COMMENT '调拨类型' ,
  `description`  varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '情况描述' ,
  `apply_time`  datetime NULL DEFAULT NULL COMMENT '申请时间' ,
  `handle_status`  int(4) NULL DEFAULT NULL COMMENT '处理状态' ,
  `handler`  bigint(20) NULL DEFAULT NULL COMMENT '处理人' ,
  `handle_remark`  varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '处理备注' ,
  `handle_time`  datetime NULL DEFAULT NULL COMMENT '处理时间' ,
  `storage_time`  datetime NULL DEFAULT NULL COMMENT '调拨出入库时间' ,
  `updater`  bigint(20) NULL DEFAULT NULL COMMENT '最后操作人' ,
  `update_time`  datetime NULL DEFAULT NULL COMMENT '最后操作时间' ,
  PRIMARY KEY (`id`)
)
  ENGINE=InnoDB
  DEFAULT CHARACTER SET=utf8 COLLATE=utf8_general_ci
  COMMENT='调拨出入库记录'
  AUTO_INCREMENT=6

;

-- ----------------------------
-- Table structure for `invoicing_allocation_request`
-- ----------------------------
DROP TABLE IF EXISTS `invoicing_allocation_request`;
CREATE TABLE `invoicing_allocation_request` (
  `id`  bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键ID' ,
  `allocation_order_number`  varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '调拨单号' ,
  `out_company_id`  bigint(20) NULL DEFAULT NULL COMMENT '调出门店ID' ,
  `in_company_id`  bigint(20) NULL DEFAULT NULL COMMENT '调入门店ID' ,
  `logistics_type`  int(10) NULL DEFAULT NULL COMMENT '物流方式' ,
  `applicant`  bigint(20) NULL DEFAULT NULL COMMENT '申请人' ,
  `apply_time`  datetime NULL DEFAULT NULL COMMENT '申请时间' ,
  `apply_department_id`  bigint(20) NULL DEFAULT NULL COMMENT '申请部门ID' ,
  `apply_status`  int(10) NULL DEFAULT NULL COMMENT '申请状态' ,
  `in_handle_status`  int(10) NULL DEFAULT NULL COMMENT '调入部门处理状态' ,
  `in_handle_remark`  varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '调入部门处理备注' ,
  `in_handler`  bigint(20) NULL DEFAULT NULL COMMENT '调入部门处理人' ,
  `in_handle_time`  datetime NULL DEFAULT NULL COMMENT '调入部门处理时间' ,
  `head_handle_status`  int(10) NULL DEFAULT NULL COMMENT '总部处理状态' ,
  `head_handle_remark`  varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '总部处理备注' ,
  `head_handler`  bigint(20) NULL DEFAULT NULL COMMENT '总部处理人' ,
  `head_handle_time`  datetime NULL DEFAULT NULL COMMENT '总部处理时间' ,
  `out_handle_status`  int(10) NULL DEFAULT NULL COMMENT '调出部门处理状态' ,
  `out_handle_remark`  varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '调出部门处理备注' ,
  `out_handler`  bigint(20) NULL DEFAULT NULL COMMENT '调出部门处理人' ,
  `out_handle_time`  datetime NULL DEFAULT NULL COMMENT '调出部门处理时间' ,
  `updater`  bigint(20) NULL DEFAULT NULL COMMENT '最后操作人' ,
  `update_time`  datetime NULL DEFAULT NULL COMMENT '最后操作时间' ,
  PRIMARY KEY (`id`)
)
  ENGINE=InnoDB
  DEFAULT CHARACTER SET=utf8 COLLATE=utf8_general_ci
  COMMENT='调拨申请'
  AUTO_INCREMENT=9

;

-- ----------------------------
-- Table structure for `invoicing_allocation_schedule`
-- ----------------------------
DROP TABLE IF EXISTS `invoicing_allocation_schedule`;
CREATE TABLE `invoicing_allocation_schedule` (
  `id`  bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键ID' ,
  `allocation_request_id`  bigint(20) NULL DEFAULT NULL COMMENT '调拨申请ID' ,
  `item`  int(10) NULL DEFAULT NULL COMMENT '事项' ,
  `remark`  varchar(1000) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '备注' ,
  `operator`  bigint(20) NULL DEFAULT NULL COMMENT '操作人' ,
  `operate_time`  datetime NULL DEFAULT NULL COMMENT '操作时间' ,
  PRIMARY KEY (`id`)
)
  ENGINE=InnoDB
  DEFAULT CHARACTER SET=utf8 COLLATE=utf8_general_ci
  COMMENT='调拨进度'
  AUTO_INCREMENT=7

;

-- ----------------------------
-- Table structure for `invoicing_allocation_vehicle`
-- ----------------------------
DROP TABLE IF EXISTS `invoicing_allocation_vehicle`;
CREATE TABLE `invoicing_allocation_vehicle` (
  `id`  bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键ID' ,
  `allocation_request_id`  bigint(20) NULL DEFAULT NULL COMMENT '调拨申请ID' ,
  `vehicle_id`  bigint(20) NULL DEFAULT NULL COMMENT '车辆ID' ,
  PRIMARY KEY (`id`)
)
  ENGINE=InnoDB
  DEFAULT CHARACTER SET=utf8 COLLATE=utf8_general_ci
  COMMENT='调拨申请车辆中间表'
  AUTO_INCREMENT=11

;

-- ----------------------------
-- Table structure for `invoicing_data_dict`
-- ----------------------------
DROP TABLE IF EXISTS `invoicing_data_dict`;
CREATE TABLE `invoicing_data_dict` (
  `id`  bigint(11) NOT NULL COMMENT ' ' ,
  `type_code`  varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '数据字典类别代码' ,
  `code`  varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '数据字典代码' ,
  `name`  varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '名称' ,
  `sort`  int(11) NULL DEFAULT NULL COMMENT '排序' ,
  `operator`  bigint(20) NULL DEFAULT NULL COMMENT '创建人' ,
  `operate_time`  datetime NULL DEFAULT NULL COMMENT '创建时间' ,
  `updater`  bigint(20) NULL DEFAULT NULL COMMENT '最后操作人' ,
  `update_time`  datetime NULL DEFAULT NULL COMMENT '最后操作时间' ,
  PRIMARY KEY (`id`)
)
  ENGINE=InnoDB
  DEFAULT CHARACTER SET=utf8 COLLATE=utf8_general_ci

;

-- ----------------------------
-- Table structure for `invoicing_data_dict_type`
-- ----------------------------
DROP TABLE IF EXISTS `invoicing_data_dict_type`;
CREATE TABLE `invoicing_data_dict_type` (
  `id`  bigint(11) NOT NULL ,
  `code`  varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '类别代码' ,
  `name`  varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '类别名称' ,
  `type`  int(4) NULL DEFAULT NULL COMMENT '类别类型' ,
  `operator`  bigint(20) NULL DEFAULT NULL COMMENT '创建人' ,
  `operate_time`  datetime NULL DEFAULT NULL COMMENT '创建时间' ,
  `updater`  bigint(20) NULL DEFAULT NULL COMMENT '最后操作人' ,
  `update_time`  datetime NULL DEFAULT NULL COMMENT '最后操作时间' ,
  PRIMARY KEY (`id`)
)
  ENGINE=InnoDB
  DEFAULT CHARACTER SET=utf8 COLLATE=utf8_general_ci

;

-- ----------------------------
-- Table structure for `invoicing_manufacturer`
-- ----------------------------
DROP TABLE IF EXISTS `invoicing_manufacturer`;
CREATE TABLE `invoicing_manufacturer` (
  `id`  bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键ID' ,
  `name`  varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '厂商名称' ,
  `is_delete`  int(4) NULL DEFAULT NULL COMMENT '是否删除 0-是 1-不是' ,
  `remark`  varchar(1000) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '备注' ,
  `operator`  bigint(20) NULL DEFAULT NULL COMMENT '创建人(外键)' ,
  `operate_time`  datetime NULL DEFAULT NULL COMMENT '创建时间' ,
  `updater`  bigint(20) NULL DEFAULT NULL COMMENT '最后操作人(外键)' ,
  `update_time`  datetime NULL DEFAULT NULL COMMENT '最后操作时间' ,
  PRIMARY KEY (`id`)
)
  ENGINE=InnoDB
  DEFAULT CHARACTER SET=utf8 COLLATE=utf8_general_ci
  COMMENT='汽车厂商'
  AUTO_INCREMENT=5

;

-- ----------------------------
-- Table structure for `invoicing_market_quotation`
-- ----------------------------
DROP TABLE IF EXISTS `invoicing_market_quotation`;
CREATE TABLE `invoicing_market_quotation` (
  `id`  bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键ID' ,
  `supplier_id`  bigint(20) NULL DEFAULT NULL COMMENT '供应商ID(外键)' ,
  `vehicle_brand_id`  bigint(20) NULL DEFAULT NULL COMMENT '车辆品牌ID(外键)' ,
  `vehicle_series_id`  bigint(20) NULL DEFAULT NULL COMMENT '车辆系列ID(外键)' ,
  `vehicle_model_id`  bigint(100) NULL DEFAULT NULL COMMENT '车辆型号ID(外键)' ,
  `guidance_price`  decimal(18,2) NULL DEFAULT NULL COMMENT '指导价' ,
  `purchase_price`  decimal(18,2) NULL DEFAULT NULL COMMENT '采购价' ,
  `remark`  varchar(1000) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '备注' ,
  `operator`  bigint(20) NULL DEFAULT NULL COMMENT '填报人(外键)' ,
  `operate_time`  datetime NULL DEFAULT NULL COMMENT '填报时间' ,
  `updater`  bigint(20) NULL DEFAULT NULL COMMENT '最后操作人(外键)' ,
  `update_time`  datetime NULL DEFAULT NULL COMMENT '最后操作时间' ,
  PRIMARY KEY (`id`)
)
  ENGINE=InnoDB
  DEFAULT CHARACTER SET=utf8 COLLATE=utf8_general_ci
  COMMENT='市场行情'
  AUTO_INCREMENT=1

;

-- ----------------------------
-- Table structure for `invoicing_material_category`
-- ----------------------------
DROP TABLE IF EXISTS `invoicing_material_category`;
CREATE TABLE `invoicing_material_category` (
  `id`  bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键ID' ,
  `name`  varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '类别名称' ,
  `operator`  bigint(20) NULL DEFAULT NULL COMMENT '创建人' ,
  `operate_time`  datetime NULL DEFAULT NULL COMMENT '创建时间' ,
  `updater`  bigint(20) NULL DEFAULT NULL COMMENT '最后操作人' ,
  `update_time`  datetime NULL DEFAULT NULL COMMENT '最后操作时间' ,
  PRIMARY KEY (`id`)
)
  ENGINE=InnoDB
  DEFAULT CHARACTER SET=utf8 COLLATE=utf8_general_ci
  COMMENT='车辆素材类别'
  AUTO_INCREMENT=6

;

-- ----------------------------
-- Table structure for `invoicing_material_item`
-- ----------------------------
DROP TABLE IF EXISTS `invoicing_material_item`;
CREATE TABLE `invoicing_material_item` (
  `id`  bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键ID' ,
  `material_category_id`  bigint(20) NULL DEFAULT NULL COMMENT '素材类别ID' ,
  `name`  varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '素材名称' ,
  `is_necessary`  int(4) NULL DEFAULT 1 COMMENT '是否必传' ,
  `operator`  bigint(20) NULL DEFAULT NULL COMMENT '创建人' ,
  `operate_time`  datetime NULL DEFAULT NULL COMMENT '创建时间' ,
  `updater`  bigint(20) NULL DEFAULT NULL COMMENT '最后操作人' ,
  `update_time`  datetime NULL DEFAULT NULL COMMENT '最后操作时间' ,
  PRIMARY KEY (`id`)
)
  ENGINE=InnoDB
  DEFAULT CHARACTER SET=utf8 COLLATE=utf8_general_ci
  COMMENT='车辆素材内容'
  AUTO_INCREMENT=4

;

-- ----------------------------
-- Table structure for `invoicing_measures_record`
-- ----------------------------
DROP TABLE IF EXISTS `invoicing_measures_record`;
CREATE TABLE `invoicing_measures_record` (
  `id`  bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键ID' ,
  `vehicle_id`  bigint(20) NULL DEFAULT NULL COMMENT '车辆ID(外键)' ,
  `odometer_number`  int(10) NULL DEFAULT NULL COMMENT '里程表数' ,
  `storage_status`  bigint(20) NULL DEFAULT NULL COMMENT '停放状态(数据字典)' ,
  `content`  varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '措施内容' ,
  `description`  varchar(1000) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '情况描述' ,
  `remark`  varchar(1000) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '备注' ,
  `operator`  bigint(20) NULL DEFAULT NULL COMMENT '操作人(外键)' ,
  `operate_time`  datetime NULL DEFAULT NULL COMMENT '操作日期' ,
  `updater`  bigint(20) NULL DEFAULT NULL COMMENT '最后操作人(外键)' ,
  `update_time`  datetime NULL DEFAULT NULL COMMENT '最后操作时间' ,
  PRIMARY KEY (`id`)
)
  ENGINE=InnoDB
  DEFAULT CHARACTER SET=utf8 COLLATE=utf8_general_ci
  COMMENT='技术状态与后续措施'
  AUTO_INCREMENT=3

;

-- ----------------------------
-- Table structure for `invoicing_measures_record_file`
-- ----------------------------
DROP TABLE IF EXISTS `invoicing_measures_record_file`;
CREATE TABLE `invoicing_measures_record_file` (
  `id`  bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键ID' ,
  `measures_id`  bigint(20) NULL DEFAULT NULL COMMENT '后续措施ID(外键)' ,
  `file_id`  varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '文件ID(外键)' ,
  `file_type`  bigint(10) NULL DEFAULT NULL COMMENT '文件类型(外键：数据字典)' ,
  `file_name`  varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '文件名称' ,
  `file_size`  varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '文件大小' ,
  `operator`  bigint(20) NULL DEFAULT NULL COMMENT '操作人(外键)' ,
  `operate_time`  datetime NULL DEFAULT NULL COMMENT '上传时间' ,
  PRIMARY KEY (`id`)
)
  ENGINE=InnoDB
  DEFAULT CHARACTER SET=utf8 COLLATE=utf8_general_ci
  COMMENT='后续措施附件'
  AUTO_INCREMENT=1

;

-- ----------------------------
-- Table structure for `invoicing_purchase_order`
-- ----------------------------
DROP TABLE IF EXISTS `invoicing_purchase_order`;
CREATE TABLE `invoicing_purchase_order` (
  `id`  bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键ID' ,
  `purchase_number`  varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '采购单号' ,
  `purchase_type`  bigint(10) NULL DEFAULT NULL COMMENT '采购类型(外键：数据字典)' ,
  `delivery_place`  varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '交货地点' ,
  `supplier_id`  bigint(20) NULL DEFAULT NULL COMMENT '供应商ID(外键)' ,
  `billing_way`  bigint(10) NULL DEFAULT NULL COMMENT '开票方式(外键：数据字典)' ,
  `pay_way`  bigint(10) NULL DEFAULT NULL COMMENT '付款方式(外键：数据字典)' ,
  `total_guidance_price`  decimal(18,2) NULL DEFAULT NULL COMMENT '总指导价' ,
  `total_purchase_price`  decimal(18,2) NULL DEFAULT NULL COMMENT '总进价' ,
  `has_pay_amount`  decimal(18,2) NULL DEFAULT NULL COMMENT '已付金额' ,
  `surplus_amount`  decimal(18,2) NULL DEFAULT NULL COMMENT '剩余总金额' ,
  `print_number`  int(5) NULL DEFAULT NULL COMMENT '打印次数' ,
  `remark`  varchar(1000) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '备注' ,
  `applicant`  bigint(20) NULL DEFAULT NULL COMMENT '申请人(外键)' ,
  `apply_time`  datetime NULL DEFAULT NULL COMMENT '申请时间' ,
  `apply_status`  bigint(10) NULL DEFAULT NULL COMMENT '申请状态(外键：数据字典)' ,
  `updater`  bigint(20) NULL DEFAULT NULL COMMENT '最后操作人(外键)' ,
  `update_time`  datetime NULL DEFAULT NULL COMMENT '最后操作时间' ,
  PRIMARY KEY (`id`)
)
  ENGINE=InnoDB
  DEFAULT CHARACTER SET=utf8 COLLATE=utf8_general_ci
  COMMENT='采购单'
  AUTO_INCREMENT=1

;

-- ----------------------------
-- Table structure for `invoicing_purchase_requisition`
-- ----------------------------
DROP TABLE IF EXISTS `invoicing_purchase_requisition`;
CREATE TABLE `invoicing_purchase_requisition` (
  `id`  bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键ID' ,
  `company_id`  bigint(20) NULL DEFAULT NULL COMMENT '门店ID(外键)' ,
  `vehicle_brand_id`  varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '车辆品牌ID(外键)' ,
  `vehicle_series_id`  varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '车辆系列ID(外键)' ,
  `vehicle_model_id`  varchar(30) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '车辆型号ID(外键)' ,
  `color`  varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '车辆颜色' ,
  `number`  int(4) NULL DEFAULT NULL COMMENT '数量' ,
  `remark`  varchar(1000) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '备注' ,
  `approver`  bigint(20) NULL DEFAULT NULL COMMENT '申请人(外键)' ,
  `approve_time`  datetime NULL DEFAULT NULL COMMENT '申请时间' ,
  `updater`  bigint(20) NULL DEFAULT NULL COMMENT '最后操作人(外键)' ,
  `update_time`  datetime NULL DEFAULT NULL COMMENT '最后操作时间' ,
  PRIMARY KEY (`id`)
)
  ENGINE=InnoDB
  DEFAULT CHARACTER SET=utf8 COLLATE=utf8_general_ci
  COMMENT='采购需求'
  AUTO_INCREMENT=2

;

-- ----------------------------
-- Table structure for `invoicing_supplier`
-- ----------------------------
DROP TABLE IF EXISTS `invoicing_supplier`;
CREATE TABLE `invoicing_supplier` (
  `id`  bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键ID' ,
  `name`  varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '供应商名称' ,
  `account_name`  varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '户名' ,
  `bank`  varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '开户银行' ,
  `bank_card_number`  varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '银行卡号' ,
  `branch`  varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '支行名称' ,
  `billing`  bigint(10) NULL DEFAULT NULL COMMENT '开票信息(外键：数据字典)' ,
  `is_delete`  int(4) NULL DEFAULT NULL COMMENT '是否删除 1-是 0-不是' ,
  `remark`  varchar(1000) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '备注' ,
  `operator`  bigint(20) NULL DEFAULT NULL COMMENT '创建人(外键)' ,
  `operate_time`  datetime NULL DEFAULT NULL COMMENT '创建时间' ,
  `updater`  bigint(20) NULL DEFAULT NULL COMMENT '最后操作人(外键)' ,
  `update_time`  datetime NULL DEFAULT NULL COMMENT '最后操作时间' ,
  PRIMARY KEY (`id`)
)
  ENGINE=InnoDB
  DEFAULT CHARACTER SET=utf8 COLLATE=utf8_general_ci
  COMMENT='供应商'
  AUTO_INCREMENT=1

;

-- ----------------------------
-- Table structure for `invoicing_vehicle`
-- ----------------------------
DROP TABLE IF EXISTS `invoicing_vehicle`;
CREATE TABLE `invoicing_vehicle` (
  `id`  bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键ID' ,
  `vehicle_series_id`  bigint(20) NULL DEFAULT NULL COMMENT '车辆系列ID(外键)' ,
  `vehicle_brand_id`  bigint(20) NULL DEFAULT NULL COMMENT '车辆品牌ID(外键)' ,
  `vehicle_model_id`  bigint(20) NULL DEFAULT NULL COMMENT '车辆型号ID(外键)' ,
  `manufacturer_id`  bigint(20) NULL DEFAULT NULL COMMENT '厂商ID(外键)' ,
  `purchase_order_id`  bigint(20) NULL DEFAULT NULL COMMENT '采购单ID(外键)' ,
  `frame_number`  varchar(30) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '车架号' ,
  `guidance_price`  decimal(18,2) NULL DEFAULT NULL COMMENT '车辆指导价' ,
  `purchase_price`  decimal(18,2) NULL DEFAULT NULL COMMENT '车辆进价' ,
  `color`  varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '车辆颜色' ,
  `selling_price`  decimal(18,2) NULL DEFAULT NULL COMMENT '车辆销售价' ,
  `production_date`  date NULL DEFAULT NULL COMMENT '生产日期' ,
  `plate_number`  varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '车牌号码' ,
  `plate_date`  date NULL DEFAULT NULL COMMENT '上牌日期' ,
  `emission_standard`  varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '排放标准' ,
  `certificate_number`  varchar(30) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '合格证号' ,
  `park_company_id`  bigint(20) NULL DEFAULT NULL COMMENT '停放库位(公司)' ,
  `odometer_number`  int(10) NULL DEFAULT NULL COMMENT '里程表数' ,
  `gps_status`  bigint(10) NULL DEFAULT NULL COMMENT 'GPS状态(外键：数据字典)' ,
  `subjection`  varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '车辆隶属' ,
  `engine_number`  varchar(30) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '发动机号' ,
  `properties`  bigint(10) NULL DEFAULT NULL COMMENT '车辆性质(外键：数据字典)' ,
  `vehicle_condition`  bigint(10) NULL DEFAULT NULL COMMENT '车况(外键：数据字典)' ,
  `abnormal_explain`  varchar(30) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '车况异常说明' ,
  `vehicle_status`  bigint(20) NULL DEFAULT NULL COMMENT '车辆状态(外键：数据字典)' ,
  `park_status`  bigint(20) NULL DEFAULT NULL COMMENT '停放状态(外键：数据字典)' ,
  `department_code`  varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '部门code' ,
  `department_id`  bigint(20) NULL DEFAULT NULL COMMENT '部门ID(外键)' ,
  `sale_date`  date NULL DEFAULT NULL COMMENT '销售日期' ,
  `remark`  varchar(1000) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '备注' ,
  `operator`  bigint(20) NULL DEFAULT NULL COMMENT '创建人(外键)' ,
  `operate_time`  datetime NULL DEFAULT NULL COMMENT '创建时间' ,
  `updater`  bigint(20) NULL DEFAULT NULL COMMENT '最后操作人(外键)' ,
  `update_time`  datetime NULL DEFAULT NULL COMMENT '最后操作时间' ,
  PRIMARY KEY (`id`)
)
  ENGINE=InnoDB
  DEFAULT CHARACTER SET=utf8 COLLATE=utf8_general_ci
  COMMENT='车辆信息'
  AUTO_INCREMENT=15

;

-- ----------------------------
-- Table structure for `invoicing_vehicle_brand`
-- ----------------------------
DROP TABLE IF EXISTS `invoicing_vehicle_brand`;
CREATE TABLE `invoicing_vehicle_brand` (
  `id`  bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键ID' ,
  `parent_id`  bigint(20) NULL DEFAULT NULL COMMENT '父级ID(自关联)' ,
  `name`  varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '品牌名称' ,
  `remark`  varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '品牌备注' ,
  `operator`  bigint(20) NULL DEFAULT NULL COMMENT '创建人(外键)' ,
  `operate_time`  datetime NULL DEFAULT NULL COMMENT '创建时间' ,
  `updater`  bigint(20) NULL DEFAULT NULL COMMENT '最后操作人(外键)' ,
  `update_time`  datetime NULL DEFAULT NULL COMMENT '最后操作时间' ,
  PRIMARY KEY (`id`)
)
  ENGINE=InnoDB
  DEFAULT CHARACTER SET=utf8 COLLATE=utf8_general_ci
  COMMENT='车辆品牌'
  AUTO_INCREMENT=3

;

-- ----------------------------
-- Table structure for `invoicing_vehicle_color`
-- ----------------------------
DROP TABLE IF EXISTS `invoicing_vehicle_color`;
CREATE TABLE `invoicing_vehicle_color` (
  `id`  bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键ID' ,
  `vehicle_model_id`  bigint(20) NULL DEFAULT NULL COMMENT '车辆型号ID(外键)' ,
  `name`  varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '颜色名称' ,
  `code`  varchar(10) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '颜色代码' ,
  `operator`  bigint(20) NULL DEFAULT NULL COMMENT '创建人(外键)' ,
  `operate_time`  datetime NULL DEFAULT NULL COMMENT '创建时间' ,
  PRIMARY KEY (`id`)
)
  ENGINE=InnoDB
  DEFAULT CHARACTER SET=utf8 COLLATE=utf8_general_ci
  AUTO_INCREMENT=1

;

-- ----------------------------
-- Table structure for `invoicing_vehicle_mileage_record`
-- ----------------------------
DROP TABLE IF EXISTS `invoicing_vehicle_mileage_record`;
CREATE TABLE `invoicing_vehicle_mileage_record` (
  `id`  bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键ID' ,
  `vehicle_id`  bigint(20) NULL DEFAULT NULL COMMENT '车辆ID(外键)' ,
  `type`  bigint(10) NULL DEFAULT NULL COMMENT '操作类型(外键：数据字典)' ,
  `storage_type`  bigint(10) NULL DEFAULT NULL COMMENT '出入类型(外键：数据字典)' ,
  `order_number`  varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '对应单号' ,
  `odometer_number`  int(10) NULL DEFAULT NULL COMMENT '里程数' ,
  `park_company_id`  bigint(20) NULL DEFAULT NULL COMMENT '仓库ID' ,
  `remark`  varchar(1000) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '备注' ,
  `operator`  bigint(20) NULL DEFAULT NULL COMMENT '创建人(外键)' ,
  `operate_time`  datetime NULL DEFAULT NULL COMMENT '创建时间' ,
  PRIMARY KEY (`id`)
)
  ENGINE=InnoDB
  DEFAULT CHARACTER SET=utf8 COLLATE=utf8_general_ci
  COMMENT='车辆里程记录'
  AUTO_INCREMENT=5

;

-- ----------------------------
-- Table structure for `invoicing_vehicle_model`
-- ----------------------------
DROP TABLE IF EXISTS `invoicing_vehicle_model`;
CREATE TABLE `invoicing_vehicle_model` (
  `id`  bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键ID' ,
  `vehicle_series_id`  bigint(20) NULL DEFAULT NULL COMMENT '车辆系列ID(外键)' ,
  `name`  varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '型号名称' ,
  `code`  varchar(40) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '型号代码' ,
  `color`  varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '颜色' ,
  `reference_price`  decimal(18,2) NULL DEFAULT NULL COMMENT '参考价' ,
  `guidance_price`  decimal(18,2) NULL DEFAULT NULL COMMENT '指导价' ,
  `displacement`  varchar(40) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '排量' ,
  `standard`  varchar(40) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '排放标准' ,
  `configure`  varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '配置' ,
  `manufacturer_id`  bigint(20) NULL DEFAULT NULL COMMENT '汽车厂商ID(外键)' ,
  `remark`  varchar(1000) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '备注' ,
  `operator`  bigint(20) NULL DEFAULT NULL COMMENT '创建人(外键)' ,
  `operate_time`  datetime NULL DEFAULT NULL COMMENT '创建时间' ,
  `updater`  bigint(20) NULL DEFAULT NULL COMMENT '最后操作人(外键)' ,
  `update_time`  datetime NULL DEFAULT NULL COMMENT '最后操作时间' ,
  PRIMARY KEY (`id`)
)
  ENGINE=InnoDB
  DEFAULT CHARACTER SET=utf8 COLLATE=utf8_general_ci
  COMMENT='车辆型号'
  AUTO_INCREMENT=2

;

-- ----------------------------
-- Table structure for `invoicing_vehicle_param`
-- ----------------------------
DROP TABLE IF EXISTS `invoicing_vehicle_param`;
CREATE TABLE `invoicing_vehicle_param` (
  `id`  bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键ID' ,
  `param_type_id`  bigint(20) NULL DEFAULT NULL COMMENT '参数类型ID(外键)' ,
  `name`  varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '参数名称' ,
  `value`  varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '参数值' ,
  `remark`  varchar(1000) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '备注' ,
  `operator`  bigint(20) NULL DEFAULT NULL COMMENT '创建人(外键)' ,
  `operate_time`  datetime NULL DEFAULT NULL COMMENT '创建时间' ,
  `updater`  bigint(20) NULL DEFAULT NULL COMMENT '最后操作人(外键)' ,
  `update_time`  datetime NULL DEFAULT NULL COMMENT '最后操作时间' ,
  PRIMARY KEY (`id`)
)
  ENGINE=InnoDB
  DEFAULT CHARACTER SET=utf8 COLLATE=utf8_general_ci
  AUTO_INCREMENT=3

;

-- ----------------------------
-- Table structure for `invoicing_vehicle_param_type`
-- ----------------------------
DROP TABLE IF EXISTS `invoicing_vehicle_param_type`;
CREATE TABLE `invoicing_vehicle_param_type` (
  `id`  bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键ID' ,
  `vehicle_model_id`  bigint(20) NULL DEFAULT NULL COMMENT '车辆型号ID(外键)' ,
  `name`  varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '类型名称' ,
  `remark`  varchar(1000) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '备注' ,
  `operator`  bigint(20) NULL DEFAULT NULL COMMENT '创建人(外键)' ,
  `operate_time`  datetime NULL DEFAULT NULL COMMENT '创建时间' ,
  `updater`  bigint(20) NULL DEFAULT NULL COMMENT '最后操作人(外键)' ,
  `update_time`  datetime NULL DEFAULT NULL COMMENT '最后操作时间' ,
  PRIMARY KEY (`id`)
)
  ENGINE=InnoDB
  DEFAULT CHARACTER SET=utf8 COLLATE=utf8_general_ci
  AUTO_INCREMENT=2

;

-- ----------------------------
-- Table structure for `invoicing_vehicle_pic`
-- ----------------------------
DROP TABLE IF EXISTS `invoicing_vehicle_pic`;
CREATE TABLE `invoicing_vehicle_pic` (
  `id`  bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键ID' ,
  `vehicle_model_id`  bigint(20) NULL DEFAULT NULL COMMENT '车辆型号ID(外键)' ,
  `file_id`  varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '文件ID(外键)' ,
  `file_name`  varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '文件名称' ,
  `file_size`  varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '文件大小' ,
  `file_type`  bigint(10) NULL DEFAULT NULL COMMENT '文件类型(外键：数据字典)' ,
  `operator`  bigint(20) NULL DEFAULT NULL COMMENT '操作人(外键)' ,
  `operate_time`  datetime NULL DEFAULT NULL COMMENT '上传时间' ,
  PRIMARY KEY (`id`)
)
  ENGINE=InnoDB
  DEFAULT CHARACTER SET=utf8 COLLATE=utf8_general_ci
  AUTO_INCREMENT=1

;

-- ----------------------------
-- Table structure for `invoicing_vehicle_series`
-- ----------------------------
DROP TABLE IF EXISTS `invoicing_vehicle_series`;
CREATE TABLE `invoicing_vehicle_series` (
  `id`  bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键ID' ,
  `parent_id`  bigint(20) NULL DEFAULT NULL COMMENT '父级ID(自关联)' ,
  `vehicle_brand_id`  bigint(20) NULL DEFAULT NULL COMMENT '车辆品牌ID(外键)' ,
  `name`  varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '系列名称' ,
  `models`  int(10) NULL DEFAULT NULL COMMENT '车型(外键：数据字典)' ,
  `remark`  varchar(1000) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '备注' ,
  `operator`  bigint(20) NULL DEFAULT NULL COMMENT '创建人(外键)' ,
  `operate_time`  datetime NULL DEFAULT NULL COMMENT '创建时间' ,
  `updater`  bigint(20) NULL DEFAULT NULL COMMENT '最后操作人(外键)' ,
  `update_time`  datetime NULL DEFAULT NULL COMMENT '最新操作时间' ,
  PRIMARY KEY (`id`)
)
  ENGINE=InnoDB
  DEFAULT CHARACTER SET=utf8 COLLATE=utf8_general_ci
  COMMENT='车辆系列'
  AUTO_INCREMENT=3

;

-- ----------------------------
-- Table structure for `invoicing_vehiclel_param`
-- ----------------------------
DROP TABLE IF EXISTS `invoicing_vehiclel_param`;
CREATE TABLE `invoicing_vehiclel_param` (
  `id`  bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键ID' ,
  `param_type_id`  bigint(20) NULL DEFAULT NULL COMMENT '参数类型ID(外键)' ,
  `name`  varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '参数名称' ,
  `value`  varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '参数值' ,
  `remark`  varchar(1000) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '备注' ,
  `operator`  bigint(20) NULL DEFAULT NULL COMMENT '创建人(外键)' ,
  `operate_time`  datetime NULL DEFAULT NULL COMMENT '创建时间' ,
  `updater`  bigint(20) NULL DEFAULT NULL COMMENT '最后操作人(外键)' ,
  `update_time`  datetime NULL DEFAULT NULL COMMENT '最后操作时间' ,
  PRIMARY KEY (`id`)
)
  ENGINE=InnoDB
  DEFAULT CHARACTER SET=utf8 COLLATE=utf8_general_ci
  AUTO_INCREMENT=1

;

-- ----------------------------
-- Table structure for `invoicing_vehiclel_param_type`
-- ----------------------------
DROP TABLE IF EXISTS `invoicing_vehiclel_param_type`;
CREATE TABLE `invoicing_vehiclel_param_type` (
  `id`  bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键ID' ,
  `vehicle_model_id`  bigint(20) NULL DEFAULT NULL COMMENT '车辆型号ID(外键)' ,
  `name`  varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '类型名称' ,
  `remark`  varchar(1000) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '备注' ,
  `operator`  bigint(20) NULL DEFAULT NULL COMMENT '创建人(外键)' ,
  `operate_time`  datetime NULL DEFAULT NULL COMMENT '创建时间' ,
  `updater`  bigint(20) NULL DEFAULT NULL COMMENT '最后操作人(外键)' ,
  `update_time`  datetime NULL DEFAULT NULL COMMENT '最后操作时间' ,
  PRIMARY KEY (`id`)
)
  ENGINE=InnoDB
  DEFAULT CHARACTER SET=utf8 COLLATE=utf8_general_ci
  AUTO_INCREMENT=1

;

-- ----------------------------
-- Table structure for `order_car`
-- ----------------------------
DROP TABLE IF EXISTS `order_car`;
CREATE TABLE `order_car` (
  `id`  bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键' ,
  `car_series_id`  bigint(20) NULL DEFAULT NULL COMMENT '车辆系列ID' ,
  `order_id`  bigint(20) NULL DEFAULT NULL COMMENT '订单id' ,
  `vehicle_id`  varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '进销存车辆id' ,
  `vehicle_brand`  varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '车辆品牌' ,
  `vehicle_models`  varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '车辆型号' ,
  `vehicle_colour`  varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '车身颜色' ,
  `vehicle_emissions`  varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '车辆排量' ,
  `vehicle_configuration`  varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '车辆配置' ,
  `registration_area`  varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '上牌地区' ,
  `vehicle_licence`  varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '车辆牌照' ,
  `store`  varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '所在门店' ,
  `status`  int(4) NULL DEFAULT NULL COMMENT '状态' ,
  `vehicle_amount`  decimal(18,4) NULL DEFAULT 0.0000 COMMENT '车辆金额' ,
  `other_expenses`  decimal(18,4) NULL DEFAULT 0.0000 COMMENT '其他费用' ,
  `amount`  decimal(18,4) NULL DEFAULT 0.0000 COMMENT '总金额' ,
  `remark`  varchar(500) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '备注' ,
  `operator`  bigint(20) NULL DEFAULT NULL COMMENT '操作人' ,
  `operator_time`  datetime NULL DEFAULT NULL COMMENT '操作时间' ,
  `car_number`  int(4) NULL DEFAULT NULL COMMENT '车辆数量' ,
  PRIMARY KEY (`id`)
)
  ENGINE=InnoDB
  DEFAULT CHARACTER SET=utf8 COLLATE=utf8_general_ci
  COMMENT='订单车辆'
  AUTO_INCREMENT=8

;

-- ----------------------------
-- Table structure for `order_process_record`
-- ----------------------------
DROP TABLE IF EXISTS `order_process_record`;
CREATE TABLE `order_process_record` (
  `id`  bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键' ,
  `approve_reason_id`  bigint(20) NULL DEFAULT NULL COMMENT '审批原因ID' ,
  `product_order_id`  bigint(20) NULL DEFAULT NULL COMMENT '产品订单id' ,
  `approval_type`  int(4) NULL DEFAULT NULL COMMENT '审批类型' ,
  `order_link`  int(4) NULL DEFAULT NULL COMMENT '订单环节' ,
  `order_status`  int(4) NULL DEFAULT NULL COMMENT '订单状态' ,
  `status_statements`  varchar(500) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '状态说明' ,
  `remark`  varchar(500) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '备注说明' ,
  `approval_date`  datetime NULL DEFAULT NULL COMMENT '审批日期' ,
  `into_pool_date`  datetime NULL DEFAULT NULL COMMENT '进入审核资源池的时间' ,
  `receive_date`  datetime NULL DEFAULT NULL COMMENT '领取日期' ,
  `operator`  bigint(20) NULL DEFAULT NULL COMMENT '操作员' ,
  `operate_time`  datetime NULL DEFAULT NULL COMMENT '操作时间' ,
  PRIMARY KEY (`id`)
)
  ENGINE=InnoDB
  DEFAULT CHARACTER SET=utf8 COLLATE=utf8_general_ci
  COMMENT='订单流程记录表'
  AUTO_INCREMENT=25

;

-- ----------------------------
-- Table structure for `order_service`
-- ----------------------------
DROP TABLE IF EXISTS `order_service`;
CREATE TABLE `order_service` (
  `id`  bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键' ,
  `order_id`  bigint(20) NULL DEFAULT NULL COMMENT '订单ID' ,
  `service_type`  int(4) NULL DEFAULT NULL COMMENT '服务类型' ,
  `service`  int(4) NULL DEFAULT NULL COMMENT '服务' ,
  `other_content`  varchar(500) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '其他内容' ,
  `operator`  bigint(20) NULL DEFAULT NULL COMMENT '操作员' ,
  `operate_time`  datetime NULL DEFAULT NULL COMMENT '操作时间' ,
  PRIMARY KEY (`id`)
)
  ENGINE=InnoDB
  DEFAULT CHARACTER SET=utf8 COLLATE=utf8_general_ci
  COMMENT='订单服务'
  AUTO_INCREMENT=10

;

-- ----------------------------
-- Table structure for `payment_history`
-- ----------------------------
DROP TABLE IF EXISTS `payment_history`;
CREATE TABLE `payment_history` (
  `id`  bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键' ,
  `order_id`  bigint(20) NULL DEFAULT NULL COMMENT '订单id' ,
  `customer_number`  varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '客户号' ,
  `withdraw_id`  bigint(20) NULL DEFAULT NULL COMMENT '还款申请id' ,
  `schedule_id`  bigint(20) NULL DEFAULT NULL COMMENT '还款计划id' ,
  `payment_type`  int(4) NULL DEFAULT NULL COMMENT '还款类型' ,
  `actual_payment_day`  datetime NULL DEFAULT NULL COMMENT '实际付款日' ,
  `payment_channel`  int(4) NULL DEFAULT NULL COMMENT '还款渠道' ,
  `payment_method`  int(4) NULL DEFAULT NULL COMMENT '还款方式' ,
  `payment_sum`  decimal(18,4) NULL DEFAULT NULL COMMENT '还款金额' ,
  `huifu_order_number`  varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '汇付交易订单号' ,
  `operator`  bigint(20) NULL DEFAULT NULL COMMENT '操作员' ,
  `operator_time`  datetime NULL DEFAULT NULL COMMENT '操作时间' ,
  PRIMARY KEY (`id`)
)
  ENGINE=InnoDB
  DEFAULT CHARACTER SET=utf8 COLLATE=utf8_general_ci
  COMMENT='还款记录表'
  AUTO_INCREMENT=1

;

-- ----------------------------
-- Table structure for `payment_schedule`
-- ----------------------------
DROP TABLE IF EXISTS `payment_schedule`;
CREATE TABLE `payment_schedule` (
  `id`  bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键' ,
  `order_id`  bigint(20) NULL DEFAULT NULL COMMENT '订单id' ,
  `periods`  int(4) NULL DEFAULT NULL COMMENT '期数' ,
  `payment_status`  int(4) NULL DEFAULT NULL COMMENT '还款状态' ,
  `payment_day`  datetime NULL DEFAULT NULL COMMENT '应付款日' ,
  `actual_payment_day`  datetime NULL DEFAULT NULL COMMENT '实际付款日' ,
  `overdue_day`  int(4) NULL DEFAULT 0 COMMENT '逾期天数' ,
  `penalty_rate`  decimal(18,4) NULL DEFAULT 0.0000 COMMENT '罚息费率' ,
  `penalty_day`  decimal(18,4) NULL DEFAULT 0.0000 COMMENT '每日罚息' ,
  `sum`  decimal(18,4) NULL DEFAULT 0.0000 COMMENT '金额' ,
  `penal_sum`  decimal(18,4) NULL DEFAULT 0.0000 COMMENT '罚金' ,
  `invoice_day`  datetime NULL DEFAULT NULL COMMENT '开票日' ,
  `rent_receivable`  decimal(18,4) NULL DEFAULT 0.0000 COMMENT '应收租金' ,
  `principal_receivable`  decimal(18,4) NULL DEFAULT 0.0000 COMMENT '应收本金' ,
  `interest_receivable`  decimal(18,4) NULL DEFAULT 0.0000 COMMENT '应收利息' ,
  `penalty_receivable`  decimal(18,4) NULL DEFAULT 0.0000 COMMENT '应收罚息' ,
  `manage_fee_receivable`  decimal(18,4) NULL DEFAULT 0.0000 COMMENT '应收管理费' ,
  `principal_derate`  decimal(18,4) NULL DEFAULT 0.0000 COMMENT '减免本金' ,
  `penalty_derate`  decimal(18,4) NULL DEFAULT 0.0000 COMMENT '减免罚息' ,
  `interest_derate`  decimal(18,4) NULL DEFAULT 0.0000 COMMENT '减免利息' ,
  `penalty_freeze`  decimal(18,4) NULL DEFAULT 0.0000 COMMENT '冻结罚息' ,
  `principal_received`  decimal(18,4) NULL DEFAULT 0.0000 COMMENT '实收本金' ,
  `interest_received`  decimal(18,4) NULL DEFAULT 0.0000 COMMENT '实收利息' ,
  `penalty_received`  decimal(18,4) NULL DEFAULT 0.0000 COMMENT '实收罚息' ,
  `manage_fee_received`  decimal(18,4) NULL DEFAULT 0.0000 COMMENT '实收管理费' ,
  `principal_surplus`  decimal(18,4) NULL DEFAULT 0.0000 COMMENT '剩余本金' ,
  `interest_surplus`  decimal(18,4) NULL DEFAULT 0.0000 COMMENT '剩余利息' ,
  `penalty_surplus`  decimal(18,4) NULL DEFAULT NULL COMMENT '剩余罚息' ,
  `manage_fee_surplus`  decimal(18,4) NULL DEFAULT 0.0000 COMMENT '剩余管理费' ,
  `remark`  varchar(500) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '备注' ,
  PRIMARY KEY (`id`)
)
  ENGINE=InnoDB
  DEFAULT CHARACTER SET=utf8 COLLATE=utf8_general_ci
  COMMENT='还款计划表'
  AUTO_INCREMENT=49

;

-- ----------------------------
-- Table structure for `personal`
-- ----------------------------
DROP TABLE IF EXISTS `personal`;
CREATE TABLE `personal` (
  `id`  bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键' ,
  `account_status`  int(4) NULL DEFAULT NULL COMMENT '开户状态' ,
  `name`  varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '姓名' ,
  `sex`  int(4) NULL DEFAULT NULL COMMENT '性别' ,
  `birth_time`  datetime NULL DEFAULT NULL COMMENT '出生日期' ,
  `qq`  varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT 'QQ号码' ,
  `wechat`  varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '微信号码' ,
  `facebook`  varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT 'facebook号码' ,
  `taobao`  varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT 'taobao号码' ,
  `email`  varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '电子邮箱地址' ,
  `mobile_main`  varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '手机号码（主）' ,
  `mobile_minor`  varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '手机号码（次）' ,
  `education`  int(4) NULL DEFAULT NULL COMMENT '教育程度' ,
  `school`  varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '毕业院校' ,
  `marital`  int(4) NULL DEFAULT NULL COMMENT '婚姻状况' ,
  `id_card`  varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '身份证号码' ,
  `issuer`  varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '发证机关' ,
  `id_card_address`  varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '身份证地址' ,
  `id_card_address_detail`  varchar(500) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '身份证地址门牌号' ,
  `id_card_validity_period_type`  int(4) NULL DEFAULT NULL COMMENT '身份证有效期类型' ,
  `id_card_validity_period_section`  varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '身份证有效期区间' ,
  `local_home_addr`  varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '现居住地址' ,
  `local_home_addr_detail`  varchar(500) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '现居住地址门牌号' ,
  `local_home_phone`  varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '居住地家庭座机' ,
  `city_live_time`  varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '本市生活时长' ,
  `local_live_time`  varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '现居住地生活时长' ,
  `local_live_house_owner`  int(4) NULL DEFAULT NULL COMMENT '现居住地房产归属' ,
  `local_live_house_money`  varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '现租房租金' ,
  `city_ownhouse_condition`  int(4) NULL DEFAULT NULL COMMENT '本市自有房产状况' ,
  `city_ownhouse_other`  varchar(500) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '本市自有房产状况其他' ,
  `electricity_account`  varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '电费账号' ,
  `electricity_password`  varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '电费密码' ,
  `reference_no`  varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '征信编号' ,
  `reference_pwd`  varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '征信密码' ,
  `reference_auth_code`  varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '征信验证码' ,
  `city_ownhouse_address_type`  int(4) NULL DEFAULT NULL COMMENT '本市自有房产地址类型' ,
  `city_ownhouse_address`  varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '本市自有房产地址' ,
  `city_ownhouse_address_detail`  varchar(500) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '本市自有房产地址门牌号' ,
  `house_prospecting`  int(4) NULL DEFAULT NULL COMMENT '是否接受勘查' ,
  `personal_type`  int(4) NULL DEFAULT NULL COMMENT '客户类型' ,
  `is_delete`  int(4) NULL DEFAULT NULL COMMENT '客户是否删除' ,
  `default_channel`  int(4) NULL DEFAULT NULL COMMENT '默认通道' ,
  `operator`  varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '操作员' ,
  `operate_time`  datetime NULL DEFAULT NULL COMMENT '操作时间' ,
  `company_code`  varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '公司code码' ,
  `personal_profile`  int(4) NULL DEFAULT NULL COMMENT '客户类别' ,
  `certificate_type`  varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '证件类型' ,
  `certificate_number`  varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '证件号码' ,
  `postal_code`  varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '邮政编码' ,
  `create_time`  datetime NULL DEFAULT NULL COMMENT '创建时间' ,
  `personal_password`  varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '客户app登录密码' ,
  `personal_url`  varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '客户上传头像' ,
  PRIMARY KEY (`id`)
)
  ENGINE=InnoDB
  DEFAULT CHARACTER SET=utf8 COLLATE=utf8_general_ci
  COMMENT='客户信息'
  AUTO_INCREMENT=4

;

-- ----------------------------
-- Table structure for `personal_bank`
-- ----------------------------
DROP TABLE IF EXISTS `personal_bank`;
CREATE TABLE `personal_bank` (
  `id`  bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键' ,
  `personal_id`  varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '客户ID' ,
  `open_account_status`  int(4) NULL DEFAULT NULL COMMENT '开户状态' ,
  `deposit_bank`  varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '开户银行' ,
  `deposit_branch`  varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '开户支行' ,
  `card_number`  varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '银行卡号' ,
  `client_number`  varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '客户号' ,
  `account_type`  int(4) NULL DEFAULT NULL COMMENT '账户类型' ,
  `deposit_city`  int(4) NULL DEFAULT NULL COMMENT '开户城市' ,
  `card_failure`  varchar(500) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '验卡失败原因' ,
  `settle_channel`  int(4) NULL DEFAULT NULL COMMENT '结算通道' ,
  `operator`  varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '操作员' ,
  `operator_time`  datetime NULL DEFAULT NULL COMMENT '操作时间' ,
  `reserved_phone_number`  varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '预留手机号' ,
  `is_default`  int(4) NULL DEFAULT NULL COMMENT '是否默认' ,
  `is_delete`  int(4) NULL DEFAULT NULL COMMENT '1-删除 0-不删除' ,
  `deposit_province`  int(4) NULL DEFAULT NULL COMMENT '省份' ,
  PRIMARY KEY (`id`)
)
  ENGINE=InnoDB
  DEFAULT CHARACTER SET=utf8 COLLATE=utf8_general_ci
  COMMENT='客户开户信息'
  AUTO_INCREMENT=2

;

-- ----------------------------
-- Table structure for `personal_car`
-- ----------------------------
DROP TABLE IF EXISTS `personal_car`;
CREATE TABLE `personal_car` (
  `id`  bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键' ,
  `personal_id`  varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '客户ID' ,
  `no`  varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '车牌号码' ,
  `prices`  decimal(18,4) NULL DEFAULT 0.0000 COMMENT '购车价格' ,
  `type`  int(4) NULL DEFAULT NULL COMMENT '车辆类型' ,
  `second_hand_flag`  int(4) NULL DEFAULT NULL COMMENT '是否二手车' ,
  `register_time`  datetime NULL DEFAULT NULL COMMENT '初次登记时间' ,
  `mortgage_num`  int(4) NULL DEFAULT NULL COMMENT '抵押登记次数' ,
  `color`  varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '车身颜色' ,
  `buy_type`  varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '购买方式' ,
  `loan_type`  varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '贷款方式' ,
  `insurance_type`  varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '保险单类型' ,
  `operator`  varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '操作员' ,
  `operator_time`  datetime NULL DEFAULT NULL COMMENT '操作时间' ,
  PRIMARY KEY (`id`)
)
  ENGINE=InnoDB
  DEFAULT CHARACTER SET=utf8 COLLATE=utf8_general_ci
  COMMENT='客户车产信息'
  AUTO_INCREMENT=1

;

-- ----------------------------
-- Table structure for `personal_contact`
-- ----------------------------
DROP TABLE IF EXISTS `personal_contact`;
CREATE TABLE `personal_contact` (
  `id`  bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键' ,
  `personal_id`  varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '客户id' ,
  `relation`  int(4) NULL DEFAULT NULL COMMENT '与本人的关系' ,
  `name`  varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '联系人姓名' ,
  `phone`  varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '联系电话' ,
  `phone_status`  int(4) NULL DEFAULT NULL COMMENT '联系电话状态' ,
  `email`  varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '电子邮件' ,
  `mobile`  varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '固定电话' ,
  `id_card`  varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '身份证号码' ,
  `address`  varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '家庭住址' ,
  `employer`  varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '工作单位' ,
  `department`  varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '部门' ,
  `position`  varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '职位' ,
  `data_source`  varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '数据来源' ,
  `work_phone`  varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '单位电话' ,
  `operator`  varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '操作员' ,
  `operator_time`  datetime NULL DEFAULT NULL COMMENT '操作时间' ,
  PRIMARY KEY (`id`)
)
  ENGINE=InnoDB
  DEFAULT CHARACTER SET=utf8 COLLATE=utf8_general_ci
  COMMENT='客户联系人'
  AUTO_INCREMENT=11

;

-- ----------------------------
-- Table structure for `personal_data`
-- ----------------------------
DROP TABLE IF EXISTS `personal_data`;
CREATE TABLE `personal_data` (
  `id`  bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键' ,
  `personal_id`  varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '客户id' ,
  `process_node`  int(4) NULL DEFAULT NULL COMMENT '流程节点' ,
  `origin_name`  varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '资料原名称' ,
  `upload_name`  varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '资料上传名称' ,
  `material_id`  bigint(20) NULL DEFAULT NULL COMMENT '对应产品素材ID' ,
  `material_name`  varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '客户素材名称' ,
  `material_type`  int(4) NULL DEFAULT NULL COMMENT '资料类型' ,
  `data_size`  int(4) NULL DEFAULT NULL COMMENT '资料大小' ,
  `material_url`  varchar(500) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '上传资料路径' ,
  `is_delete`  int(4) NULL DEFAULT NULL COMMENT '是否删除' ,
  `operator`  varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '操作员' ,
  `operate_time`  datetime NULL DEFAULT NULL COMMENT '操作时间' ,
  PRIMARY KEY (`id`)
)
  ENGINE=InnoDB
  DEFAULT CHARACTER SET=utf8 COLLATE=utf8_general_ci
  COMMENT='客户上传资料'
  AUTO_INCREMENT=7

;

-- ----------------------------
-- Table structure for `personal_job`
-- ----------------------------
DROP TABLE IF EXISTS `personal_job`;
CREATE TABLE `personal_job` (
  `id`  bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键' ,
  `personal_id`  varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '客户id' ,
  `job_type`  int(4) NULL DEFAULT NULL COMMENT '职业类型' ,
  `company_name`  varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '单位名称' ,
  `company_nature`  int(4) NULL DEFAULT NULL COMMENT '单位性质' ,
  `rank`  int(4) NULL DEFAULT NULL COMMENT '职级' ,
  `company_address`  int(4) NULL DEFAULT NULL COMMENT '单位地址' ,
  `company_address_detail`  varchar(500) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '单位地址详细' ,
  `company_phone`  varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '单位固定电话' ,
  `department`  varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '部门' ,
  `duty`  varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '职务' ,
  `access_company_time`  datetime NULL DEFAULT NULL COMMENT '何时进入公司' ,
  `basic_salary`  decimal(18,4) NULL DEFAULT 0.0000 COMMENT '基本月薪（元）' ,
  `pay_day`  int(4) NULL DEFAULT NULL COMMENT '每月发薪日' ,
  `pay_way`  varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '发薪方式' ,
  `yearly_salaries`  decimal(18,4) NULL DEFAULT 0.0000 COMMENT '年收入（万元）' ,
  `month_other_income`  decimal(18,4) NULL DEFAULT NULL COMMENT '每月其他收入（元）' ,
  `other_income_source`  varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '其他收入来源' ,
  `identity`  int(4) NULL DEFAULT NULL COMMENT '身份' ,
  `stock_scale`  decimal(18,4) NULL DEFAULT 0.0000 COMMENT '股占比' ,
  `enterprise_manage_years`  datetime NULL DEFAULT NULL COMMENT '企业经营年限' ,
  `enterprise_manage_belong`  varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '经营地归属' ,
  `employees_number`  int(4) NULL DEFAULT NULL COMMENT '员工人数' ,
  `registered_capital`  decimal(18,4) NULL DEFAULT 0.0000 COMMENT '注册资本（万元）' ,
  `industry`  varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '所属行业' ,
  `pastyear_income`  decimal(18,4) NULL DEFAULT 0.0000 COMMENT '过去一年营业收入（万元）' ,
  `pastyear_profit`  decimal(18,4) NULL DEFAULT 0.0000 COMMENT '过去一年利润' ,
  `operator`  varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '操作员' ,
  `operate_time`  datetime NULL DEFAULT NULL COMMENT '操作时间' ,
  PRIMARY KEY (`id`)
)
  ENGINE=InnoDB
  DEFAULT CHARACTER SET=utf8 COLLATE=utf8_general_ci
  COMMENT='客户职业信息'
  AUTO_INCREMENT=3

;

-- ----------------------------
-- Table structure for `personal_material`
-- ----------------------------
DROP TABLE IF EXISTS `personal_material`;
CREATE TABLE `personal_material` (
  `id`  bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键ID' ,
  `type`  int(4) NULL DEFAULT NULL COMMENT '素材类型' ,
  `name`  varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '名称' ,
  `is_necessary`  int(4) NULL DEFAULT 0 COMMENT '是否必传' ,
  `product_id`  varchar(2000) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '客户产品ID集合' ,
  `operator`  bigint(20) NULL DEFAULT NULL COMMENT '创建人' ,
  `operator_time`  datetime NULL DEFAULT NULL COMMENT '创建时间' ,
  `is_select`  int(4) NULL DEFAULT 0 COMMENT '是否勾选' ,
  PRIMARY KEY (`id`)
)
  ENGINE=InnoDB
  DEFAULT CHARACTER SET=utf8 COLLATE=utf8_general_ci
  COMMENT='客户素材表'
  AUTO_INCREMENT=25

;

-- ----------------------------
-- Table structure for `personal_resource_introduce`
-- ----------------------------
DROP TABLE IF EXISTS `personal_resource_introduce`;
CREATE TABLE `personal_resource_introduce` (
  `id`  bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键' ,
  `personal_id`  varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '客户id' ,
  `resource_type`  int(4) NULL DEFAULT NULL COMMENT '来源' ,
  `peer_name`  varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '同行姓名' ,
  `peer_company`  varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '同行公司' ,
  `peer_phone`  varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '同行联系方式' ,
  `customer_name`  varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '客户姓名' ,
  `customer_phone`  varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '联系方式' ,
  `is_buy_car`  int(4) NULL DEFAULT NULL COMMENT '是否在我公司购车' ,
  `organization_names`  varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '机构名称' ,
  `referrer`  varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '推荐人' ,
  `operator`  bigint(20) NULL DEFAULT NULL COMMENT '操作员' ,
  `operator_time`  datetime NULL DEFAULT NULL COMMENT '操作时间' ,
  PRIMARY KEY (`id`)
)
  ENGINE=InnoDB
  DEFAULT CHARACTER SET=utf8 COLLATE=utf8_general_ci
  COMMENT='客户来源介绍'
  AUTO_INCREMENT=3

;

-- ----------------------------
-- Table structure for `personal_resource_publicity`
-- ----------------------------
DROP TABLE IF EXISTS `personal_resource_publicity`;
CREATE TABLE `personal_resource_publicity` (
  `id`  bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键' ,
  `personal_id`  varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '客户id' ,
  `resource_type`  int(4) NULL DEFAULT NULL COMMENT '来源' ,
  `resource_content`  varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '来源内容' ,
  `operator`  varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '操作员' ,
  `operator_time`  datetime NULL DEFAULT NULL COMMENT '操作时间' ,
  PRIMARY KEY (`id`)
)
  ENGINE=InnoDB
  DEFAULT CHARACTER SET=utf8 COLLATE=utf8_general_ci
  COMMENT='客户来源宣传'
  AUTO_INCREMENT=8

;

-- ----------------------------
-- Table structure for `product`
-- ----------------------------
DROP TABLE IF EXISTS `product`;
CREATE TABLE `product` (
  `id`  bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键' ,
  `number`  varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '产品序号' ,
  `name`  varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '产品名称' ,
  `capita_channels`  int(4) NULL DEFAULT 382 COMMENT '资金渠道' ,
  `series_id`  bigint(20) NULL DEFAULT NULL COMMENT '系列id' ,
  `type`  int(4) NULL DEFAULT NULL COMMENT '产品类型' ,
  `status`  int(4) NULL DEFAULT NULL COMMENT '产品系列状态' ,
  `operator`  bigint(20) NULL DEFAULT NULL COMMENT '操作员' ,
  `operator_time`  datetime NULL DEFAULT NULL COMMENT '操作时间' ,
  `is_config`  int(4) NULL DEFAULT 1 COMMENT '客户素材是否配置' ,
  PRIMARY KEY (`id`)
)
  ENGINE=InnoDB
  DEFAULT CHARACTER SET=utf8 COLLATE=utf8_general_ci
  COMMENT='产品表'
  AUTO_INCREMENT=12

;

-- ----------------------------
-- Table structure for `product_match`
-- ----------------------------
DROP TABLE IF EXISTS `product_match`;
CREATE TABLE `product_match` (
  `id`  bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键' ,
  `payment_id`  bigint(20) NULL DEFAULT NULL COMMENT '还款记录id' ,
  `series_id`  bigint(20) NULL DEFAULT NULL COMMENT '产品系列id' ,
  `match_type`  int(4) NULL DEFAULT NULL COMMENT '冲抵类型' ,
  `match_order`  int(4) NULL DEFAULT NULL COMMENT '冲抵排序' ,
  `remark`  varchar(500) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '备注' ,
  `operator`  bigint(20) NULL DEFAULT NULL COMMENT '操作员' ,
  `operator_time`  datetime NULL DEFAULT NULL COMMENT '操作时间' ,
  PRIMARY KEY (`id`)
)
  ENGINE=InnoDB
  DEFAULT CHARACTER SET=utf8 COLLATE=utf8_general_ci
  AUTO_INCREMENT=1

;

-- ----------------------------
-- Table structure for `product_order`
-- ----------------------------
DROP TABLE IF EXISTS `product_order`;
CREATE TABLE `product_order` (
  `id`  bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键' ,
  `order_number`  varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '订单号' ,
  `salesman_name`  varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '业务员名字' ,
  `recorder_id`  bigint(20) NULL DEFAULT NULL COMMENT '录单员ID' ,
  `dept_code`  varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '部门code' ,
  `contract_num`  varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '合同号' ,
  `whether_sign`  bit(1) NULL DEFAULT NULL COMMENT '是否签约' ,
  `company_id`  bigint(20) NULL DEFAULT NULL COMMENT '公司id' ,
  `approval_date`  datetime NULL DEFAULT NULL COMMENT '最近审批日期' ,
  `receive_date`  datetime NULL DEFAULT NULL COMMENT '领取日期' ,
  `into_pool_date`  datetime NULL DEFAULT NULL COMMENT '进入资源池时间' ,
  `province`  int(200) NULL DEFAULT NULL COMMENT '省份' ,
  `city`  int(200) NULL DEFAULT NULL COMMENT '城市' ,
  `financing_use`  varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '融资用途' ,
  `intention_financing_amount`  decimal(18,4) NULL DEFAULT 0.0000 COMMENT '意向融资金额' ,
  `intention_periods`  varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '意向期限' ,
  `intention_payment_ratio`  decimal(18,4) NULL DEFAULT 0.0000 COMMENT '意向首付比例' ,
  `rent_payable`  decimal(18,4) NULL DEFAULT 0.0000 COMMENT '租金支付' ,
  `personal_id`  bigint(20) NULL DEFAULT NULL COMMENT '客户id' ,
  `order_type`  int(4) NULL DEFAULT NULL COMMENT '订单类型' ,
  `business_type`  int(4) NULL DEFAULT NULL COMMENT '业务类型' ,
  `series_id`  bigint(20) NULL DEFAULT NULL COMMENT '产品系列id' ,
  `product_id`  bigint(20) NULL DEFAULT NULL COMMENT '产品id' ,
  `product_issue_id`  bigint(20) NULL DEFAULT NULL COMMENT '产品期数id' ,
  `order_link`  int(4) NULL DEFAULT NULL COMMENT '订单环节' ,
  `order_status`  int(4) NULL DEFAULT NULL COMMENT '订单状态' ,
  `risk_status`  int(4) NULL DEFAULT NULL COMMENT '订单风险状态' ,
  `color`  int(4) NULL DEFAULT NULL COMMENT '颜色' ,
  `former_holder`  bigint(20) NULL DEFAULT NULL COMMENT '订单的上一个持有人' ,
  `current_holder`  bigint(20) NULL DEFAULT NULL COMMENT '订单现持有人' ,
  `periods`  int(4) NULL DEFAULT NULL COMMENT '期数(月)' ,
  `period_type`  int(4) NULL DEFAULT NULL COMMENT '周期类型' ,
  `payment_type`  int(4) NULL DEFAULT NULL COMMENT '账期类型' ,
  `payment_day`  int(4) NULL DEFAULT NULL COMMENT '账期日' ,
  `product_rate`  decimal(18,4) NULL DEFAULT 0.0000 COMMENT '产品利率(%/月)' ,
  `pay_way`  int(4) NULL DEFAULT NULL COMMENT '还款方式' ,
  `payment_scale`  decimal(18,4) NULL DEFAULT 0.0000 COMMENT '首付比例' ,
  `order_amount`  decimal(18,4) NULL DEFAULT 0.0000 COMMENT '订单总金额（包括其他所有费用）' ,
  `vehicle_amount`  decimal(18,4) NULL DEFAULT 0.0000 COMMENT '订单车辆成交价（开呗参考价）' ,
  `financing_amount`  decimal(18,4) NULL DEFAULT 0.0000 COMMENT '融资总额' ,
  `initial_payment`  decimal(18,4) NULL DEFAULT 0.0000 COMMENT '首付款' ,
  `monthly_supply`  decimal(18,4) NULL DEFAULT 0.0000 COMMENT '月供金额' ,
  `deposit_cash_type`  int(4) NULL DEFAULT NULL COMMENT '保证金缴纳方式' ,
  `deposit_percent`  decimal(18,4) NULL DEFAULT 0.0000 COMMENT '保证金比例' ,
  `deposit_cash`  decimal(18,4) NULL DEFAULT 0.0000 COMMENT '保证金金额' ,
  `final_cash`  decimal(18,4) NULL DEFAULT 0.0000 COMMENT '尾付款' ,
  `final_payment`  decimal(18,4) NULL DEFAULT 0.0000 COMMENT '尾款本金' ,
  `manage_cost`  decimal(18,4) NULL DEFAULT 0.0000 COMMENT '管理费金额' ,
  `manage_cost_type`  int(4) NULL DEFAULT NULL COMMENT '管理费收取方式' ,
  `manage_cost_percent`  decimal(18,4) NULL DEFAULT 0.0000 COMMENT '管理费比例' ,
  `staging_periods`  int(4) NULL DEFAULT NULL COMMENT '管理费期数' ,
  `insurance_expenses`  decimal(18,4) NULL DEFAULT 0.0000 COMMENT '保险费' ,
  `purchase_tax`  decimal(18,4) NULL DEFAULT 0.0000 COMMENT '购置税' ,
  `install_license_fee`  decimal(18,4) NULL DEFAULT 0.0000 COMMENT '上牌费' ,
  `gps_fee`  decimal(18,4) NULL DEFAULT 0.0000 COMMENT 'GPS费用' ,
  `other_fee`  decimal(18,4) NULL DEFAULT 0.0000 COMMENT '其他费用' ,
  `credit_protect_days`  int(4) NULL DEFAULT NULL COMMENT '征信保护天数' ,
  `overdue_protect_days`  int(4) NULL DEFAULT NULL COMMENT '逾期保护天数' ,
  `penalty_rate`  decimal(18,4) NULL DEFAULT 0.0000 COMMENT '罚息费率' ,
  `contract_break_rate`  decimal(18,4) NULL DEFAULT 0.0000 COMMENT '合同违约金费率' ,
  `prepayment_rate`  decimal(18,4) NULL DEFAULT 0.0000 COMMENT '提前还款费率' ,
  `contract_date`  datetime NULL DEFAULT NULL COMMENT '合同生效日' ,
  `interest_time`  datetime NULL DEFAULT NULL COMMENT '利息生效时间' ,
  `settlement_type`  int(4) NULL DEFAULT NULL COMMENT '结清类型' ,
  `settlement_channel`  int(4) NULL DEFAULT NULL COMMENT '结算通道' ,
  `settlement_day`  datetime NULL DEFAULT NULL COMMENT '结清日期' ,
  `operator`  bigint(20) NULL DEFAULT NULL COMMENT '操作员' ,
  `create_time`  datetime NULL DEFAULT NULL COMMENT '创建时间' ,
  `operate_time`  datetime NULL DEFAULT NULL COMMENT '操作时间' ,
  `remark`  varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '备注' ,
  `salesman_id`  bigint(20) NULL DEFAULT NULL COMMENT '销售员ID' ,
  `effective_type`  int(20) NULL DEFAULT NULL ,
  `final_ratio`  decimal(18,4) NULL DEFAULT 0.0000 COMMENT '尾付比例' ,
  `product_remark`  varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '产品备注' ,
  PRIMARY KEY (`id`)
)
  ENGINE=InnoDB
  DEFAULT CHARACTER SET=utf8 COLLATE=utf8_general_ci
  COMMENT='产品订单'
  AUTO_INCREMENT=10

;

-- ----------------------------
-- Table structure for `product_package`
-- ----------------------------
DROP TABLE IF EXISTS `product_package`;
CREATE TABLE `product_package` (
  `id`  bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键ID' ,
  `file_name`  varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '文件名' ,
  `file_id`  varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '文件ID' ,
  `upload_time`  datetime NULL DEFAULT NULL COMMENT '上传时间' ,
  `operator`  bigint(20) NULL DEFAULT NULL COMMENT '操作人' ,
  `operator_name`  varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '操作人姓名' ,
  `operator_time`  datetime NULL DEFAULT NULL COMMENT '操作时间' ,
  `remark`  varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '注释' ,
  `type`  int(4) NOT NULL COMMENT '上传包类型' ,
  `data_type`  int(4) NOT NULL COMMENT '资料类型' ,
  `is_delete`  int(4) NULL DEFAULT NULL ,
  PRIMARY KEY (`id`)
)
  ENGINE=InnoDB
  DEFAULT CHARACTER SET=utf8 COLLATE=utf8_general_ci
  COMMENT='产品包信息表'
  AUTO_INCREMENT=2

;

-- ----------------------------
-- Table structure for `product_plan_issue`
-- ----------------------------
DROP TABLE IF EXISTS `product_plan_issue`;
CREATE TABLE `product_plan_issue` (
  `id`  bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键' ,
  `product_id`  bigint(20) NULL DEFAULT NULL COMMENT '产品ID' ,
  `periods`  int(4) NULL DEFAULT NULL COMMENT '期数(月)' ,
  `period_type`  int(4) NULL DEFAULT NULL COMMENT '周期类型' ,
  `payment_type`  int(4) NULL DEFAULT NULL COMMENT '账期类型' ,
  `product_rate`  decimal(18,4) NULL DEFAULT NULL COMMENT '产品利率(%/月)' ,
  `pay_way`  int(4) NULL DEFAULT NULL COMMENT '还款方式' ,
  `financing_amount`  varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '融资金额' ,
  `initial_payment`  varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '首付款' ,
  `deposit_cash`  varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '保证金' ,
  `final_cash`  varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '尾付款' ,
  `manage_cost`  varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '管理费' ,
  `credit_protect_days`  int(4) NULL DEFAULT NULL COMMENT '征信保护天数' ,
  `overdue_protect_days`  int(4) NULL DEFAULT NULL COMMENT '逾期保护天数' ,
  `penalty_rate`  decimal(18,4) NULL DEFAULT NULL COMMENT '罚息费率' ,
  `contract_break_rate`  decimal(18,4) NULL DEFAULT NULL COMMENT '合同违约金费率' ,
  `prepayment_rate`  decimal(18,4) NULL DEFAULT NULL COMMENT '提前还款费率' ,
  `product_status`  int(4) NULL DEFAULT 0 COMMENT '产品状态' ,
  `is_publish`  int(4) NULL DEFAULT 361 COMMENT '是否发布' ,
  `operator`  bigint(20) NULL DEFAULT NULL COMMENT '操作员' ,
  `operator_time`  datetime NULL DEFAULT NULL COMMENT '操作时间' ,
  `payment_day`  int(4) NULL DEFAULT NULL COMMENT '账期日' ,
  `deposit_cash_type`  int(4) NULL DEFAULT NULL COMMENT '保证金缴纳方式' ,
  `manage_cost_type`  int(4) NULL DEFAULT NULL COMMENT '管理费收取方式' ,
  `staging_periods`  int(4) NULL DEFAULT NULL COMMENT '管理费期数' ,
  PRIMARY KEY (`id`)
)
  ENGINE=InnoDB
  DEFAULT CHARACTER SET=utf8 COLLATE=utf8_general_ci
  COMMENT='产品计划期数表'
  AUTO_INCREMENT=7

;

-- ----------------------------
-- Table structure for `product_price_config`
-- ----------------------------
DROP TABLE IF EXISTS `product_price_config`;
CREATE TABLE `product_price_config` (
  `id`  bigint(20) NOT NULL COMMENT '主键' ,
  `product_id`  bigint(20) NULL DEFAULT NULL COMMENT '产品ID' ,
  `brand_id`  bigint(20) NULL DEFAULT NULL COMMENT '车辆品牌ID' ,
  `series_id`  bigint(20) NULL DEFAULT NULL COMMENT '车辆系列ID' ,
  `car_id`  bigint(20) NULL DEFAULT NULL COMMENT '车辆型号ID' ,
  `car_color`  varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '车辆颜色' ,
  `car_price`  decimal(18,4) NULL DEFAULT 0.0000 COMMENT '市场指导价' ,
  `first_amount`  decimal(18,4) NULL DEFAULT 0.0000 COMMENT '首期金额' ,
  `financing_amount`  decimal(18,4) NULL DEFAULT 0.0000 COMMENT '融资金额' ,
  `periods`  int(20) NULL DEFAULT NULL COMMENT '融资期数' ,
  `purchase_tax`  decimal(18,4) NULL DEFAULT NULL COMMENT '购置税' ,
  `insurance_expenses`  decimal(18,4) NULL DEFAULT 0.0000 COMMENT '保险费' ,
  `gps_financing`  decimal(18,4) NULL DEFAULT 0.0000 COMMENT 'gps费用' ,
  `other_fee`  decimal(18,4) NULL DEFAULT 0.0000 COMMENT '其他费用' ,
  `current_status`  int(4) NULL DEFAULT NULL COMMENT '当前状态' ,
  `financial_rent`  decimal(18,4) NULL DEFAULT 0.0000 COMMENT '租金' ,
  `bridge_fee`  decimal(18,4) NULL DEFAULT 0.0000 COMMENT '路桥费' ,
  `operator`  varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '操作人' ,
  `operate_time`  datetime NULL DEFAULT NULL COMMENT '操作时间' ,
  PRIMARY KEY (`id`)
)
  ENGINE=InnoDB
  DEFAULT CHARACTER SET=utf8 COLLATE=utf8_general_ci

;

-- ----------------------------
-- Table structure for `product_process`
-- ----------------------------
DROP TABLE IF EXISTS `product_process`;
CREATE TABLE `product_process` (
  `id`  bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键' ,
  `order_id`  bigint(20) NULL DEFAULT NULL COMMENT '订单ID' ,
  `approve_reason_id`  bigint(20) NULL DEFAULT NULL COMMENT '审批原因ID' ,
  `process_order_number`  int(4) NULL DEFAULT NULL COMMENT '流程顺序号' ,
  `process_name`  varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '流程名称' ,
  `remark`  varchar(500) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '备注' ,
  `approval_status`  int(4) NULL DEFAULT NULL COMMENT '是否审批通过' ,
  `operator`  bigint(20) NULL DEFAULT NULL COMMENT '操作员' ,
  `operate_time`  datetime NULL DEFAULT NULL COMMENT '操作时间' ,
  `create_time`  datetime NULL DEFAULT NULL COMMENT '创建时间' ,
  PRIMARY KEY (`id`)
)
  ENGINE=InnoDB
  DEFAULT CHARACTER SET=utf8 COLLATE=utf8_general_ci
  COMMENT='产品流程'
  AUTO_INCREMENT=27

;

-- ----------------------------
-- Table structure for `product_process_configuration`
-- ----------------------------
DROP TABLE IF EXISTS `product_process_configuration`;
CREATE TABLE `product_process_configuration` (
  `id`  bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键' ,
  `product_id`  int(20) NULL DEFAULT NULL COMMENT '产品id' ,
  `process_order_number`  int(4) NULL DEFAULT NULL COMMENT '流程顺序号' ,
  `process_name`  varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '流程名称' ,
  `remark`  varchar(500) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '备注' ,
  `create_time`  datetime NULL DEFAULT NULL COMMENT '创建日期' ,
  `operator`  bigint(20) NULL DEFAULT NULL COMMENT '操作员' ,
  `operate_time`  datetime NULL DEFAULT NULL COMMENT '操作时间' ,
  PRIMARY KEY (`id`)
)
  ENGINE=InnoDB
  DEFAULT CHARACTER SET=utf8 COLLATE=utf8_general_ci
  COMMENT='产品流程配置'
  AUTO_INCREMENT=29

;

-- ----------------------------
-- Table structure for `product_series`
-- ----------------------------
DROP TABLE IF EXISTS `product_series`;
CREATE TABLE `product_series` (
  `id`  bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键' ,
  `parent_id`  varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '系列父id' ,
  `number`  varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '产品系列序号' ,
  `name`  varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '产品系列名称' ,
  `capita_channels`  varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '资金渠道' ,
  `type`  int(4) NULL DEFAULT NULL COMMENT '产品系列类型' ,
  `status`  int(4) NULL DEFAULT NULL COMMENT '产品系列状态' ,
  `operator`  bigint(20) NULL DEFAULT NULL COMMENT '操作员' ,
  `operator_time`  datetime NULL DEFAULT NULL COMMENT '操作时间' ,
  PRIMARY KEY (`id`)
)
  ENGINE=InnoDB
  DEFAULT CHARACTER SET=utf8 COLLATE=utf8_general_ci
  COMMENT='产品系列表'
  AUTO_INCREMENT=14

;

-- ----------------------------
-- Table structure for `qrtz_blob_triggers`
-- ----------------------------
DROP TABLE IF EXISTS `qrtz_blob_triggers`;
CREATE TABLE `qrtz_blob_triggers` (
  `SCHED_NAME`  varchar(120) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL ,
  `TRIGGER_NAME`  varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL ,
  `TRIGGER_GROUP`  varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL ,
  `BLOB_DATA`  blob NULL ,
  PRIMARY KEY (`SCHED_NAME`, `TRIGGER_NAME`, `TRIGGER_GROUP`),
  FOREIGN KEY (`SCHED_NAME`, `TRIGGER_NAME`, `TRIGGER_GROUP`) REFERENCES `qrtz_triggers` (`SCHED_NAME`, `TRIGGER_NAME`, `TRIGGER_GROUP`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  INDEX `SCHED_NAME` (`SCHED_NAME`, `TRIGGER_NAME`, `TRIGGER_GROUP`) USING BTREE
)
  ENGINE=InnoDB
  DEFAULT CHARACTER SET=utf8 COLLATE=utf8_general_ci

;

-- ----------------------------
-- Table structure for `qrtz_calendars`
-- ----------------------------
DROP TABLE IF EXISTS `qrtz_calendars`;
CREATE TABLE `qrtz_calendars` (
  `SCHED_NAME`  varchar(120) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL ,
  `CALENDAR_NAME`  varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL ,
  `CALENDAR`  blob NOT NULL ,
  PRIMARY KEY (`SCHED_NAME`, `CALENDAR_NAME`)
)
  ENGINE=InnoDB
  DEFAULT CHARACTER SET=utf8 COLLATE=utf8_general_ci

;

-- ----------------------------
-- Table structure for `qrtz_cron_triggers`
-- ----------------------------
DROP TABLE IF EXISTS `qrtz_cron_triggers`;
CREATE TABLE `qrtz_cron_triggers` (
  `SCHED_NAME`  varchar(120) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL ,
  `TRIGGER_NAME`  varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL ,
  `TRIGGER_GROUP`  varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL ,
  `CRON_EXPRESSION`  varchar(120) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL ,
  `TIME_ZONE_ID`  varchar(80) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL ,
  PRIMARY KEY (`SCHED_NAME`, `TRIGGER_NAME`, `TRIGGER_GROUP`),
  FOREIGN KEY (`SCHED_NAME`, `TRIGGER_NAME`, `TRIGGER_GROUP`) REFERENCES `qrtz_triggers` (`SCHED_NAME`, `TRIGGER_NAME`, `TRIGGER_GROUP`) ON DELETE RESTRICT ON UPDATE RESTRICT
)
  ENGINE=InnoDB
  DEFAULT CHARACTER SET=utf8 COLLATE=utf8_general_ci

;

-- ----------------------------
-- Table structure for `qrtz_fired_triggers`
-- ----------------------------
DROP TABLE IF EXISTS `qrtz_fired_triggers`;
CREATE TABLE `qrtz_fired_triggers` (
  `SCHED_NAME`  varchar(120) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL ,
  `ENTRY_ID`  varchar(140) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL ,
  `TRIGGER_NAME`  varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL ,
  `TRIGGER_GROUP`  varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL ,
  `INSTANCE_NAME`  varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL ,
  `FIRED_TIME`  bigint(19) NOT NULL ,
  `SCHED_TIME`  bigint(19) NOT NULL ,
  `PRIORITY`  int(11) NOT NULL ,
  `STATE`  varchar(16) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL ,
  `JOB_NAME`  varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL ,
  `JOB_GROUP`  varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL ,
  `IS_NONCONCURRENT`  tinyint(1) NULL DEFAULT NULL ,
  `REQUESTS_RECOVERY`  tinyint(1) NULL DEFAULT NULL ,
  PRIMARY KEY (`SCHED_NAME`, `ENTRY_ID`),
  INDEX `IDX_QRTZ_FT_TRIG_INST_NAME` (`SCHED_NAME`, `INSTANCE_NAME`) USING BTREE ,
  INDEX `IDX_QRTZ_FT_INST_JOB_REQ_RCVRY` (`SCHED_NAME`, `INSTANCE_NAME`, `REQUESTS_RECOVERY`) USING BTREE ,
  INDEX `IDX_QRTZ_FT_J_G` (`SCHED_NAME`, `JOB_NAME`, `JOB_GROUP`) USING BTREE ,
  INDEX `IDX_QRTZ_FT_JG` (`SCHED_NAME`, `JOB_GROUP`) USING BTREE ,
  INDEX `IDX_QRTZ_FT_T_G` (`SCHED_NAME`, `TRIGGER_NAME`, `TRIGGER_GROUP`) USING BTREE ,
  INDEX `IDX_QRTZ_FT_TG` (`SCHED_NAME`, `TRIGGER_GROUP`) USING BTREE
)
  ENGINE=InnoDB
  DEFAULT CHARACTER SET=utf8 COLLATE=utf8_general_ci

;

-- ----------------------------
-- Table structure for `qrtz_job_details`
-- ----------------------------
DROP TABLE IF EXISTS `qrtz_job_details`;
CREATE TABLE `qrtz_job_details` (
  `SCHED_NAME`  varchar(120) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL ,
  `JOB_NAME`  varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL ,
  `JOB_GROUP`  varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL ,
  `DESCRIPTION`  varchar(250) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL ,
  `JOB_CLASS_NAME`  varchar(250) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL ,
  `IS_DURABLE`  tinyint(1) NOT NULL ,
  `IS_NONCONCURRENT`  tinyint(1) NOT NULL ,
  `IS_UPDATE_DATA`  tinyint(1) NOT NULL ,
  `REQUESTS_RECOVERY`  tinyint(1) NOT NULL ,
  `JOB_DATA`  blob NULL ,
  PRIMARY KEY (`SCHED_NAME`, `JOB_NAME`, `JOB_GROUP`),
  INDEX `IDX_QRTZ_J_REQ_RECOVERY` (`SCHED_NAME`, `REQUESTS_RECOVERY`) USING BTREE ,
  INDEX `IDX_QRTZ_J_GRP` (`SCHED_NAME`, `JOB_GROUP`) USING BTREE
)
  ENGINE=InnoDB
  DEFAULT CHARACTER SET=utf8 COLLATE=utf8_general_ci

;

-- ----------------------------
-- Table structure for `qrtz_locks`
-- ----------------------------
DROP TABLE IF EXISTS `qrtz_locks`;
CREATE TABLE `qrtz_locks` (
  `SCHED_NAME`  varchar(120) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL ,
  `LOCK_NAME`  varchar(40) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL ,
  PRIMARY KEY (`SCHED_NAME`, `LOCK_NAME`)
)
  ENGINE=InnoDB
  DEFAULT CHARACTER SET=utf8 COLLATE=utf8_general_ci

;

-- ----------------------------
-- Table structure for `qrtz_paused_trigger_grps`
-- ----------------------------
DROP TABLE IF EXISTS `qrtz_paused_trigger_grps`;
CREATE TABLE `qrtz_paused_trigger_grps` (
  `SCHED_NAME`  varchar(120) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL ,
  `TRIGGER_GROUP`  varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL ,
  PRIMARY KEY (`SCHED_NAME`, `TRIGGER_GROUP`)
)
  ENGINE=InnoDB
  DEFAULT CHARACTER SET=utf8 COLLATE=utf8_general_ci

;

-- ----------------------------
-- Table structure for `qrtz_scheduler_state`
-- ----------------------------
DROP TABLE IF EXISTS `qrtz_scheduler_state`;
CREATE TABLE `qrtz_scheduler_state` (
  `SCHED_NAME`  varchar(120) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL ,
  `INSTANCE_NAME`  varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL ,
  `LAST_CHECKIN_TIME`  bigint(19) NOT NULL ,
  `CHECKIN_INTERVAL`  bigint(19) NOT NULL ,
  PRIMARY KEY (`SCHED_NAME`, `INSTANCE_NAME`)
)
  ENGINE=InnoDB
  DEFAULT CHARACTER SET=utf8 COLLATE=utf8_general_ci

;

-- ----------------------------
-- Table structure for `qrtz_simple_triggers`
-- ----------------------------
DROP TABLE IF EXISTS `qrtz_simple_triggers`;
CREATE TABLE `qrtz_simple_triggers` (
  `SCHED_NAME`  varchar(120) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL ,
  `TRIGGER_NAME`  varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL ,
  `TRIGGER_GROUP`  varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL ,
  `REPEAT_COUNT`  bigint(7) NOT NULL ,
  `REPEAT_INTERVAL`  bigint(12) NOT NULL ,
  `TIMES_TRIGGERED`  bigint(10) NOT NULL ,
  PRIMARY KEY (`SCHED_NAME`, `TRIGGER_NAME`, `TRIGGER_GROUP`),
  FOREIGN KEY (`SCHED_NAME`, `TRIGGER_NAME`, `TRIGGER_GROUP`) REFERENCES `qrtz_triggers` (`SCHED_NAME`, `TRIGGER_NAME`, `TRIGGER_GROUP`) ON DELETE RESTRICT ON UPDATE RESTRICT
)
  ENGINE=InnoDB
  DEFAULT CHARACTER SET=utf8 COLLATE=utf8_general_ci

;

-- ----------------------------
-- Table structure for `qrtz_simprop_triggers`
-- ----------------------------
DROP TABLE IF EXISTS `qrtz_simprop_triggers`;
CREATE TABLE `qrtz_simprop_triggers` (
  `SCHED_NAME`  varchar(120) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL ,
  `TRIGGER_NAME`  varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL ,
  `TRIGGER_GROUP`  varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL ,
  `STR_PROP_1`  varchar(512) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL ,
  `STR_PROP_2`  varchar(512) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL ,
  `STR_PROP_3`  varchar(512) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL ,
  `INT_PROP_1`  int(11) NULL DEFAULT NULL ,
  `INT_PROP_2`  int(11) NULL DEFAULT NULL ,
  `LONG_PROP_1`  bigint(20) NULL DEFAULT NULL ,
  `LONG_PROP_2`  bigint(20) NULL DEFAULT NULL ,
  `DEC_PROP_1`  decimal(13,4) NULL DEFAULT NULL ,
  `DEC_PROP_2`  decimal(13,4) NULL DEFAULT NULL ,
  `BOOL_PROP_1`  tinyint(1) NULL DEFAULT NULL ,
  `BOOL_PROP_2`  tinyint(1) NULL DEFAULT NULL ,
  PRIMARY KEY (`SCHED_NAME`, `TRIGGER_NAME`, `TRIGGER_GROUP`),
  FOREIGN KEY (`SCHED_NAME`, `TRIGGER_NAME`, `TRIGGER_GROUP`) REFERENCES `qrtz_triggers` (`SCHED_NAME`, `TRIGGER_NAME`, `TRIGGER_GROUP`) ON DELETE RESTRICT ON UPDATE RESTRICT
)
  ENGINE=InnoDB
  DEFAULT CHARACTER SET=utf8 COLLATE=utf8_general_ci

;

-- ----------------------------
-- Table structure for `qrtz_triggers`
-- ----------------------------
DROP TABLE IF EXISTS `qrtz_triggers`;
CREATE TABLE `qrtz_triggers` (
  `SCHED_NAME`  varchar(120) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL ,
  `TRIGGER_NAME`  varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL ,
  `TRIGGER_GROUP`  varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL ,
  `JOB_NAME`  varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL ,
  `JOB_GROUP`  varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL ,
  `DESCRIPTION`  varchar(250) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL ,
  `NEXT_FIRE_TIME`  bigint(19) NULL DEFAULT NULL ,
  `PREV_FIRE_TIME`  bigint(19) NULL DEFAULT NULL ,
  `PRIORITY`  int(11) NULL DEFAULT NULL ,
  `TRIGGER_STATE`  varchar(16) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL ,
  `TRIGGER_TYPE`  varchar(8) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL ,
  `START_TIME`  bigint(19) NOT NULL ,
  `END_TIME`  bigint(19) NULL DEFAULT NULL ,
  `CALENDAR_NAME`  varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL ,
  `MISFIRE_INSTR`  smallint(2) NULL DEFAULT NULL ,
  `JOB_DATA`  blob NULL ,
  PRIMARY KEY (`SCHED_NAME`, `TRIGGER_NAME`, `TRIGGER_GROUP`),
  FOREIGN KEY (`SCHED_NAME`, `JOB_NAME`, `JOB_GROUP`) REFERENCES `qrtz_job_details` (`SCHED_NAME`, `JOB_NAME`, `JOB_GROUP`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  INDEX `IDX_QRTZ_T_J` (`SCHED_NAME`, `JOB_NAME`, `JOB_GROUP`) USING BTREE ,
  INDEX `IDX_QRTZ_T_JG` (`SCHED_NAME`, `JOB_GROUP`) USING BTREE ,
  INDEX `IDX_QRTZ_T_C` (`SCHED_NAME`, `CALENDAR_NAME`) USING BTREE ,
  INDEX `IDX_QRTZ_T_G` (`SCHED_NAME`, `TRIGGER_GROUP`) USING BTREE ,
  INDEX `IDX_QRTZ_T_STATE` (`SCHED_NAME`, `TRIGGER_STATE`) USING BTREE ,
  INDEX `IDX_QRTZ_T_N_STATE` (`SCHED_NAME`, `TRIGGER_NAME`, `TRIGGER_GROUP`, `TRIGGER_STATE`) USING BTREE ,
  INDEX `IDX_QRTZ_T_N_G_STATE` (`SCHED_NAME`, `TRIGGER_GROUP`, `TRIGGER_STATE`) USING BTREE ,
  INDEX `IDX_QRTZ_T_NEXT_FIRE_TIME` (`SCHED_NAME`, `NEXT_FIRE_TIME`) USING BTREE ,
  INDEX `IDX_QRTZ_T_NFT_ST` (`SCHED_NAME`, `TRIGGER_STATE`, `NEXT_FIRE_TIME`) USING BTREE ,
  INDEX `IDX_QRTZ_T_NFT_MISFIRE` (`SCHED_NAME`, `MISFIRE_INSTR`, `NEXT_FIRE_TIME`) USING BTREE ,
  INDEX `IDX_QRTZ_T_NFT_ST_MISFIRE` (`SCHED_NAME`, `MISFIRE_INSTR`, `NEXT_FIRE_TIME`, `TRIGGER_STATE`) USING BTREE ,
  INDEX `IDX_QRTZ_T_NFT_ST_MISFIRE_GRP` (`SCHED_NAME`, `MISFIRE_INSTR`, `NEXT_FIRE_TIME`, `TRIGGER_GROUP`, `TRIGGER_STATE`) USING BTREE
)
  ENGINE=InnoDB
  DEFAULT CHARACTER SET=utf8 COLLATE=utf8_general_ci

;

-- ----------------------------
-- Table structure for `refund_application`
-- ----------------------------
DROP TABLE IF EXISTS `refund_application`;
CREATE TABLE `refund_application` (
  `id`  bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键' ,
  `order_id`  bigint(20) NULL DEFAULT NULL COMMENT '订单Id' ,
  `refund_type`  int(4) NULL DEFAULT NULL COMMENT '退款类型' ,
  `refund_total_amount`  decimal(18,4) NULL DEFAULT 0.0000 COMMENT '退款总额' ,
  `application_status`  int(4) NULL DEFAULT NULL COMMENT '申请状态' ,
  `record_status`  int(4) NULL DEFAULT NULL COMMENT '记录状态（草稿，申请记录）' ,
  `remark`  varchar(2000) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '备注' ,
  `operator`  bigint(20) NULL DEFAULT NULL COMMENT '操作人' ,
  `operator_time`  datetime NULL DEFAULT NULL COMMENT '操作时间' ,
  `process_status`  int(4) NULL DEFAULT NULL ,
  PRIMARY KEY (`id`)
)
  ENGINE=InnoDB
  DEFAULT CHARACTER SET=utf8 COLLATE=utf8_general_ci
  COMMENT='退款申请表'
  AUTO_INCREMENT=1

;

-- ----------------------------
-- Table structure for `refund_application_item`
-- ----------------------------
DROP TABLE IF EXISTS `refund_application_item`;
CREATE TABLE `refund_application_item` (
  `id`  bigint(20) NOT NULL AUTO_INCREMENT COMMENT '编号' ,
  `refund_application_id`  bigint(20) NULL DEFAULT NULL COMMENT '退款申请id' ,
  `refund_item`  int(4) NULL DEFAULT NULL COMMENT '退款项' ,
  `refund_amount`  decimal(18,4) NULL DEFAULT 0.0000 COMMENT '退款金额' ,
  PRIMARY KEY (`id`)
)
  ENGINE=InnoDB
  DEFAULT CHARACTER SET=utf8 COLLATE=utf8_general_ci
  COMMENT='退款申请明细表'
  AUTO_INCREMENT=1

;

-- ----------------------------
-- Table structure for `refund_approval`
-- ----------------------------
DROP TABLE IF EXISTS `refund_approval`;
CREATE TABLE `refund_approval` (
  `id`  bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键' ,
  `refund_application_id`  bigint(20) NULL DEFAULT NULL COMMENT '退款申请id' ,
  `application_status`  int(4) NULL DEFAULT NULL COMMENT '申请状态' ,
  `remark`  varchar(2000) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '备注' ,
  `operator`  bigint(20) NULL DEFAULT NULL COMMENT '操作人' ,
  `operator_time`  datetime NULL DEFAULT NULL COMMENT '操作时间' ,
  `process_status`  int(4) NULL DEFAULT NULL COMMENT '处理状态' ,
  PRIMARY KEY (`id`)
)
  ENGINE=InnoDB
  DEFAULT CHARACTER SET=utf8 COLLATE=utf8_general_ci
  COMMENT='退款审批'
  AUTO_INCREMENT=1

;

-- ----------------------------
-- Table structure for `refund_history`
-- ----------------------------
DROP TABLE IF EXISTS `refund_history`;
CREATE TABLE `refund_history` (
  `id`  bigint(20) NOT NULL AUTO_INCREMENT COMMENT '编号' ,
  `order_id`  bigint(20) NULL DEFAULT NULL COMMENT '订单id' ,
  `refund_application_id`  bigint(20) NULL DEFAULT NULL COMMENT '退款申请id' ,
  `refund_total_amount`  decimal(18,4) NULL DEFAULT 0.0000 ,
  `record_status`  int(4) NULL DEFAULT NULL COMMENT '记录状态（草稿，申请记录）' ,
  `remark`  varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '备注' ,
  `operator`  bigint(20) NULL DEFAULT NULL COMMENT '操作人' ,
  `operator_time`  datetime NULL DEFAULT NULL COMMENT '操作时间' ,
  PRIMARY KEY (`id`)
)
  ENGINE=InnoDB
  DEFAULT CHARACTER SET=utf8 COLLATE=utf8_general_ci
  COMMENT='退款记录表'
  AUTO_INCREMENT=1

;

-- ----------------------------
-- Table structure for `refund_record_item`
-- ----------------------------
DROP TABLE IF EXISTS `refund_record_item`;
CREATE TABLE `refund_record_item` (
  `id`  bigint(20) NOT NULL AUTO_INCREMENT COMMENT '编号' ,
  `refund_record_id`  bigint(20) NULL DEFAULT NULL COMMENT '退款记录id' ,
  `refund_item`  int(4) NULL DEFAULT NULL COMMENT '退款项' ,
  `refund_amount`  decimal(18,4) NULL DEFAULT 0.0000 COMMENT '退款金额' ,
  `channel_type`  int(4) NULL DEFAULT NULL COMMENT '渠道类型' ,
  `refund_channel`  int(4) NULL DEFAULT NULL COMMENT '退款渠道' ,
  `refund_type`  int(4) NULL DEFAULT NULL COMMENT '退款方式(手动，自动)' ,
  `deal_status`  int(4) NULL DEFAULT NULL COMMENT '交易状态' ,
  `online_deal_number`  varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '线上划扣交易号' ,
  `receipt_bank`  varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '收款行' ,
  `receipt_card_number`  varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '收款卡号' ,
  `remark`  varchar(2000) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '备注' ,
  PRIMARY KEY (`id`)
)
  ENGINE=InnoDB
  DEFAULT CHARACTER SET=utf8 COLLATE=utf8_general_ci
  COMMENT='退款记录明细表'
  AUTO_INCREMENT=1

;

-- ----------------------------
-- Table structure for `refund_upload_resource`
-- ----------------------------
DROP TABLE IF EXISTS `refund_upload_resource`;
CREATE TABLE `refund_upload_resource` (
  `id`  bigint(20) NOT NULL AUTO_INCREMENT COMMENT '编号' ,
  `order_id`  bigint(20) NULL DEFAULT NULL COMMENT '订单id' ,
  `business_id`  bigint(20) NULL DEFAULT NULL COMMENT '业务id' ,
  `upload_phase`  int(4) NULL DEFAULT NULL COMMENT '上传阶段' ,
  `material_type`  int(4) NULL DEFAULT NULL COMMENT '资料类型' ,
  `data_size`  int(10) NULL DEFAULT NULL COMMENT '资料大小' ,
  `material_url`  varchar(500) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '资料上传路径' ,
  `is_delete`  int(4) NULL DEFAULT NULL COMMENT '是否删除' ,
  `operator`  bigint(20) NULL DEFAULT NULL COMMENT '操作人' ,
  `operator_time`  datetime NULL DEFAULT NULL COMMENT '操作时间' ,
  PRIMARY KEY (`id`)
)
  ENGINE=InnoDB
  DEFAULT CHARACTER SET=utf8 COLLATE=utf8_general_ci
  COMMENT='退款上传资料表'
  AUTO_INCREMENT=1

;

-- ----------------------------
-- Table structure for `remit_application`
-- ----------------------------
DROP TABLE IF EXISTS `remit_application`;
CREATE TABLE `remit_application` (
  `id`  bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键' ,
  `order_id`  bigint(20) NULL DEFAULT NULL COMMENT '订单Id' ,
  `payment_schedule_id`  bigint(20) NULL DEFAULT NULL COMMENT '分期还款Id' ,
  `application_status`  int(4) NULL DEFAULT NULL COMMENT '申请状态' ,
  `remit_item`  int(4) NULL DEFAULT NULL COMMENT '减免项' ,
  `remit_amount`  decimal(18,4) NULL DEFAULT 0.0000 COMMENT '减免金额' ,
  `remark`  varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '备注' ,
  `operator`  bigint(20) NULL DEFAULT NULL COMMENT '操作员' ,
  `operator_date`  datetime NULL DEFAULT NULL COMMENT '操作时间' ,
  PRIMARY KEY (`id`)
)
  ENGINE=InnoDB
  DEFAULT CHARACTER SET=utf8 COLLATE=utf8_general_ci
  COMMENT='减免申请表'
  AUTO_INCREMENT=1

;

-- ----------------------------
-- Table structure for `remit_application_approval`
-- ----------------------------
DROP TABLE IF EXISTS `remit_application_approval`;
CREATE TABLE `remit_application_approval` (
  `id`  bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键' ,
  `application_id`  bigint(20) NULL DEFAULT NULL COMMENT '申请Id' ,
  `application_status`  int(4) NULL DEFAULT NULL COMMENT '申请状态' ,
  `remark`  varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT 'remark' ,
  `operator`  bigint(20) NULL DEFAULT NULL COMMENT '审批员' ,
  `operator_time`  datetime NULL DEFAULT NULL COMMENT '审批时间' ,
  PRIMARY KEY (`id`)
)
  ENGINE=InnoDB
  DEFAULT CHARACTER SET=utf8 COLLATE=utf8_general_ci
  COMMENT='减免申请审批表'
  AUTO_INCREMENT=1

;

-- ----------------------------
-- Table structure for `remit_apply`
-- ----------------------------
DROP TABLE IF EXISTS `remit_apply`;
CREATE TABLE `remit_apply` (
  `id`  bigint(20) NOT NULL COMMENT '主键' ,
  `order_id`  bigint(20) NULL DEFAULT NULL COMMENT '订单id' ,
  `apply_type`  int(4) NULL DEFAULT NULL COMMENT '申请类型' ,
  `remit_sum`  decimal(18,4) NULL DEFAULT NULL COMMENT '减免金额' ,
  `freeze_sum`  decimal(18,4) NULL DEFAULT NULL COMMENT '冻结金额' ,
  `operator`  bigint(20) NULL DEFAULT NULL COMMENT '操作员' ,
  `operator_time`  datetime NULL DEFAULT NULL COMMENT '操作时间' ,
  PRIMARY KEY (`id`)
)
  ENGINE=InnoDB
  DEFAULT CHARACTER SET=utf8 COLLATE=utf8_general_ci
  COMMENT='减免申请表'

;

-- ----------------------------
-- Table structure for `role`
-- ----------------------------
DROP TABLE IF EXISTS `role`;
CREATE TABLE `role` (
  `id`  bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键id' ,
  `role_name`  varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '名称' ,
  `role_status`  int(4) NULL DEFAULT NULL COMMENT '状态' ,
  `role_remark`  varchar(500) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '备注' ,
  `operator`  bigint(20) NULL DEFAULT NULL COMMENT '操作人id' ,
  `operate_time`  datetime NULL DEFAULT NULL COMMENT '操作时间' ,
  PRIMARY KEY (`id`)
)
  ENGINE=InnoDB
  DEFAULT CHARACTER SET=utf8 COLLATE=utf8_general_ci
  COMMENT='角色'
  AUTO_INCREMENT=4

;

-- ----------------------------
-- Table structure for `role_backlog`
-- ----------------------------
DROP TABLE IF EXISTS `role_backlog`;
CREATE TABLE `role_backlog` (
  `id`  bigint(20) NOT NULL AUTO_INCREMENT ,
  `role_id`  bigint(20) NULL DEFAULT NULL COMMENT '角色id' ,
  `backlog_id`  bigint(20) NULL DEFAULT NULL COMMENT '待办事项id' ,
  PRIMARY KEY (`id`)
)
  ENGINE=InnoDB
  DEFAULT CHARACTER SET=utf8 COLLATE=utf8_general_ci
  AUTO_INCREMENT=28

;

-- ----------------------------
-- Table structure for `role_reso`
-- ----------------------------
DROP TABLE IF EXISTS `role_reso`;
CREATE TABLE `role_reso` (
  `id`  bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键id' ,
  `reso_pid`  bigint(20) NULL DEFAULT NULL COMMENT '父id' ,
  `reso_sysname`  varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '系统名称' ,
  `reso_init_name`  varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '资源初始名称' ,
  `reso_name`  varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '资源名称' ,
  `reso_code`  varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '资源码' ,
  `reso_level`  int(4) NULL DEFAULT NULL COMMENT '资源级别' ,
  `reso_status`  int(4) NULL DEFAULT NULL COMMENT '状态' ,
  `reso_path`  varchar(500) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '资源路径' ,
  `reso_init_icon`  varchar(500) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '资源初始图标' ,
  `reso_icon`  varchar(500) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '资源图标' ,
  `reso_type`  int(4) NULL DEFAULT NULL COMMENT '资源类型' ,
  `reso_filetype`  int(4) NULL DEFAULT NULL COMMENT '资源文件类型' ,
  `reso_remark`  varchar(500) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '备注' ,
  `operator`  bigint(200) NULL DEFAULT NULL COMMENT '创建人' ,
  `operate_time`  datetime NULL DEFAULT NULL COMMENT '创建日期' ,
  `flag`  int(4) NULL DEFAULT NULL COMMENT '数据库排序标识' ,
  `color`  varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL ,
  `sort`  int(4) NULL DEFAULT NULL ,
  PRIMARY KEY (`id`)
)
  ENGINE=InnoDB
  DEFAULT CHARACTER SET=utf8 COLLATE=utf8_general_ci
  COMMENT='角色资源管理'
  AUTO_INCREMENT=475

;

-- ----------------------------
-- Table structure for `role_resource`
-- ----------------------------
DROP TABLE IF EXISTS `role_resource`;
CREATE TABLE `role_resource` (
  `role_id`  bigint(20) NULL DEFAULT NULL COMMENT '角色id' ,
  `resource_id`  bigint(20) NULL DEFAULT NULL COMMENT '资源id' ,
  `id`  bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键' ,
  PRIMARY KEY (`id`)
)
  ENGINE=InnoDB
  DEFAULT CHARACTER SET=utf8 COLLATE=utf8_general_ci
  COMMENT='角色资源中间表'
  AUTO_INCREMENT=28710

;

-- ----------------------------
-- Table structure for `schedule_job`
-- ----------------------------
DROP TABLE IF EXISTS `schedule_job`;
CREATE TABLE `schedule_job` (
  `id`  bigint(20) NOT NULL AUTO_INCREMENT COMMENT '编号' ,
  `job_name`  varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '任务名称' ,
  `job_group`  varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '任务分组' ,
  `job_description`  varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '任务描述' ,
  `cron`  varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '执行计划' ,
  `is_local`  bit(1) NULL DEFAULT NULL COMMENT '调度方式 false 远程 true 本地' ,
  `remote_request_method`  varchar(10) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '远程请求方式 只支持POST' ,
  `remote_url`  varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '远程执行url' ,
  `bean_class`  varchar(500) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '执行类名称 包名+类名' ,
  `method_name`  varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '执行方法名称' ,
  `params`  varchar(500) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '参数' ,
  `is_async`  bit(1) NULL DEFAULT NULL COMMENT '是否异步  0否 1是' ,
  `running`  smallint(4) NULL DEFAULT NULL COMMENT '是否正在跑批 0-未跑批 1-正在跑批' ,
  `create_by`  bigint(20) NULL DEFAULT NULL COMMENT '创建者' ,
  `modify_by`  bigint(20) NULL DEFAULT NULL COMMENT '修改者' ,
  `remarks`  varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '描述' ,
  `status`  int(11) NULL DEFAULT NULL COMMENT '任务状态 0禁用 1启用' ,
  `create_time`  datetime NULL DEFAULT NULL COMMENT '创建时间' ,
  `modify_time`  datetime NULL DEFAULT NULL COMMENT '修改时间' ,
  `creator`  bigint(20) NULL DEFAULT NULL COMMENT '创建人ID' ,
  PRIMARY KEY (`id`)
)
  ENGINE=InnoDB
  DEFAULT CHARACTER SET=utf8 COLLATE=utf8_general_ci
  COMMENT='任务调度'
  AUTO_INCREMENT=1

;

-- ----------------------------
-- Table structure for `schedule_job_log`
-- ----------------------------
DROP TABLE IF EXISTS `schedule_job_log`;
CREATE TABLE `schedule_job_log` (
  `id`  bigint(20) NOT NULL AUTO_INCREMENT COMMENT '编号' ,
  `job_id`  bigint(20) NULL DEFAULT NULL COMMENT '任务ID' ,
  `job_name`  varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '任务名称' ,
  `job_group`  varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '任务分组' ,
  `cron`  varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '执行计划' ,
  `is_local`  bit(1) NULL DEFAULT NULL COMMENT '调度方式 false 远程 true 本地' ,
  `remote_request_method`  varchar(10) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '远程请求方式 只支持POST' ,
  `remote_url`  varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '远程执行url' ,
  `bean_class`  varchar(500) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '执行类名称 包名+类名' ,
  `method_name`  varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '执行方法名称' ,
  `job_trigger`  varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '触发器' ,
  `params`  varchar(500) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '参数' ,
  `is_async`  bit(1) NULL DEFAULT NULL COMMENT '是否异步  0否 1是' ,
  `remarks`  varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '描述' ,
  `status`  int(11) NULL DEFAULT NULL COMMENT '执行状态 0失败 1成功' ,
  `error`  varchar(500) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '失败信息' ,
  `times`  bigint(20) NULL DEFAULT NULL COMMENT '耗时(单位：毫秒)' ,
  `create_time`  datetime NULL DEFAULT NULL COMMENT '创建时间' ,
  `modify_time`  datetime NULL DEFAULT NULL COMMENT '修改时间' ,
  `creator`  bigint(20) NULL DEFAULT NULL ,
  PRIMARY KEY (`id`)
)
  ENGINE=InnoDB
  DEFAULT CHARACTER SET=utf8 COLLATE=utf8_general_ci
  COMMENT='任务调度执行日志'
  AUTO_INCREMENT=3

;

-- ----------------------------
-- Table structure for `system_backup`
-- ----------------------------
DROP TABLE IF EXISTS `system_backup`;
CREATE TABLE `system_backup` (
  `id`  bigint(20) NOT NULL AUTO_INCREMENT ,
  `type`  int(4) NULL DEFAULT NULL COMMENT '备份类型 0：自动 1：手动' ,
  `mysql_name`  varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT 'mysql数据库文件名称' ,
  `mongdb_name`  varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT 'mongdb数据库名称' ,
  `operator`  bigint(20) NULL DEFAULT NULL COMMENT '操作人' ,
  `operate_time`  datetime NULL DEFAULT NULL COMMENT '备份时间' ,
  PRIMARY KEY (`id`)
)
  ENGINE=InnoDB
  DEFAULT CHARACTER SET=utf8 COLLATE=utf8_general_ci
  AUTO_INCREMENT=4

;

-- ----------------------------
-- Table structure for `system_logs`
-- ----------------------------
DROP TABLE IF EXISTS `system_logs`;
CREATE TABLE `system_logs` (
  `id`  bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键id' ,
  `client_ip`  varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '操作的用户端ip' ,
  `operator`  varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '操作人' ,
  `operate_time`  datetime NULL DEFAULT NULL COMMENT '操作时间' ,
  `log_remark`  varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '操作描述' ,
  `exe_time`  varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '执行时间' ,
  `exe_method`  varchar(1000) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '执行方法' ,
  `exe_params`  text CHARACTER SET utf8 COLLATE utf8_general_ci NULL COMMENT '执行参数' ,
  `exe_type`  varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '执行类型' ,
  PRIMARY KEY (`id`)
)
  ENGINE=InnoDB
  DEFAULT CHARACTER SET=utf8 COLLATE=utf8_general_ci
  COMMENT='系统操作日志'
  AUTO_INCREMENT=11850

;

-- ----------------------------
-- Table structure for `system_parameter`
-- ----------------------------
DROP TABLE IF EXISTS `system_parameter`;
CREATE TABLE `system_parameter` (
  `id`  bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键id' ,
  `param_name`  varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '参数名称' ,
  `param_code`  varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '参数自定义code' ,
  `param_status`  int(4) NULL DEFAULT NULL COMMENT '是否启用（0是启用 1是停用）' ,
  `param_type`  varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '参数类型（服务的端口号）' ,
  `param_value`  varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '参数值' ,
  `param_sign`  int(4) NULL DEFAULT NULL COMMENT '标识（0是可以修改 1是不能修改）' ,
  `operator`  bigint(20) NULL DEFAULT NULL COMMENT '创建人' ,
  `operate_time`  datetime NULL DEFAULT NULL COMMENT '创建时间' ,
  `param_remark`  varchar(500) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '备注' ,
  PRIMARY KEY (`id`)
)
  ENGINE=InnoDB
  DEFAULT CHARACTER SET=utf8 COLLATE=utf8_general_ci
  COMMENT='系统参数'
  AUTO_INCREMENT=11

;

-- ----------------------------
-- Table structure for `template`
-- ----------------------------
DROP TABLE IF EXISTS `template`;
CREATE TABLE `template` (
  `id`  bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键' ,
  `template_code`  varchar(40) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '模板编号' ,
  `template_name`  varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '模板名称' ,
  `is_default`  int(2) NULL DEFAULT NULL COMMENT '是否是默认模板' ,
  `template_style`  int(10) NULL DEFAULT NULL COMMENT '模板形式' ,
  `template_type`  int(10) NULL DEFAULT NULL COMMENT '模板类别' ,
  `template_status`  int(10) NULL DEFAULT NULL COMMENT '模板状态' ,
  `template_content`  varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '模板内容' ,
  `template_url`  varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL ,
  `operator`  bigint(20) NULL DEFAULT NULL COMMENT '操作人' ,
  `operate_time`  datetime NULL DEFAULT NULL COMMENT '操作时间' ,
  PRIMARY KEY (`id`)
)
  ENGINE=InnoDB
  DEFAULT CHARACTER SET=utf8 COLLATE=utf8_general_ci
  COMMENT='模板配置表'
  AUTO_INCREMENT=5

;

-- ----------------------------
-- Table structure for `transaction_detail`
-- ----------------------------
DROP TABLE IF EXISTS `transaction_detail`;
CREATE TABLE `transaction_detail` (
  `id`  bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键id' ,
  `bankcard_id`  bigint(20) NULL DEFAULT NULL COMMENT '银行卡id' ,
  `customer_name`  varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '交易客户名称' ,
  `transaction_time`  datetime NULL DEFAULT NULL COMMENT '交易日期' ,
  `account_number`  varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '企业账户号' ,
  `transbank`  varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '支付银行' ,
  `transbank_number`  int(50) NULL DEFAULT NULL COMMENT '交易卡号' ,
  `amount`  int(100) NULL DEFAULT NULL COMMENT '交易金额' ,
  `order_number`  varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '订单号' ,
  `transaction_status`  varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '交易状态' ,
  PRIMARY KEY (`id`)
)
  ENGINE=InnoDB
  DEFAULT CHARACTER SET=utf8 COLLATE=utf8_general_ci
  COMMENT='交易记录信息'
  AUTO_INCREMENT=1

;

-- ----------------------------
-- Table structure for `upload_information`
-- ----------------------------
DROP TABLE IF EXISTS `upload_information`;
CREATE TABLE `upload_information` (
  `id`  bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键' ,
  `business_id`  bigint(20) NULL DEFAULT NULL COMMENT ' 订单id' ,
  `process_node`  int(4) NULL DEFAULT NULL COMMENT '流程节点' ,
  `origin_name`  varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '资料原名称' ,
  `upload_name`  varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '资料上传名称' ,
  `material_type`  int(4) NULL DEFAULT NULL COMMENT '资料类型' ,
  `data_size`  int(4) NULL DEFAULT NULL COMMENT '资料大小' ,
  `material_url`  varchar(500) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '上传资料路径' ,
  `is_delete`  int(4) NULL DEFAULT NULL COMMENT '是否删除' ,
  `operator`  bigint(20) NULL DEFAULT NULL COMMENT '操作员' ,
  `operator_time`  datetime NULL DEFAULT NULL COMMENT '操作时间' ,
  `payment_schedule_id`  bigint(20) NULL DEFAULT NULL COMMENT '还款计划id' ,
  PRIMARY KEY (`id`)
)
  ENGINE=InnoDB
  DEFAULT CHARACTER SET=utf8 COLLATE=utf8_general_ci
  COMMENT='业务上传资料'
  AUTO_INCREMENT=1

;

-- ----------------------------
-- Table structure for `user_information`
-- ----------------------------
DROP TABLE IF EXISTS `user_information`;
CREATE TABLE `user_information` (
  `id`  bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键id' ,
  `user_type`  int(4) NULL DEFAULT NULL COMMENT '用户的类型' ,
  `trial_time`  int(4) NULL DEFAULT NULL COMMENT '试用时长' ,
  `login_type`  int(4) NULL DEFAULT NULL COMMENT '登录类型' ,
  `login_device`  int(4) NULL DEFAULT NULL COMMENT '登录设备类型' ,
  `login_address`  varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '登录地址' ,
  `password_time`  datetime NULL DEFAULT NULL COMMENT '密码过时时间' ,
  `dept_id`  bigint(20) NULL DEFAULT NULL COMMENT '部门id' ,
  `message_pushid`  varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '用户绑定的消息推送' ,
  `user_manager`  int(4) NULL DEFAULT NULL COMMENT '是否管理员' ,
  `user_username`  varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '用户名' ,
  `user_realname`  varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '姓名' ,
  `user_password`  varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '密码' ,
  `user_sex`  int(4) NULL DEFAULT NULL COMMENT '性别' ,
  `user_phone`  varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '电话' ,
  `user_email`  varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '邮箱' ,
  `user_status`  int(4) NULL DEFAULT NULL COMMENT '状态' ,
  `company`  varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '用户所属公司' ,
  `user_signature`  varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '签名' ,
  `user_remark`  varchar(500) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '备注' ,
  `user_photo`  varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '用户头像' ,
  `operator`  bigint(20) NULL DEFAULT NULL COMMENT '创建人id' ,
  `operate_time`  datetime NULL DEFAULT NULL COMMENT '创建时间' ,
  PRIMARY KEY (`id`)
)
  ENGINE=InnoDB
  DEFAULT CHARACTER SET=utf8 COLLATE=utf8_general_ci
  COMMENT='用户信息管理'
  AUTO_INCREMENT=10

;

-- ----------------------------
-- Table structure for `user_privilege`
-- ----------------------------
DROP TABLE IF EXISTS `user_privilege`;
CREATE TABLE `user_privilege` (
  `id`  bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键id' ,
  `user_id`  bigint(20) NULL DEFAULT NULL COMMENT '用户id' ,
  `dept_id`  bigint(20) NULL DEFAULT NULL COMMENT '部门id' ,
  `dept_code`  varchar(500) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '部门code' ,
  `remark`  varchar(500) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '备注' ,
  `operator`  bigint(20) NULL DEFAULT NULL COMMENT '创建人' ,
  `operate_time`  datetime NULL DEFAULT NULL COMMENT '创建日期' ,
  PRIMARY KEY (`id`)
)
  ENGINE=InnoDB
  DEFAULT CHARACTER SET=utf8 COLLATE=utf8_general_ci
  COMMENT='用户权限配置'
  AUTO_INCREMENT=1

;

-- ----------------------------
-- Table structure for `user_reso`
-- ----------------------------
DROP TABLE IF EXISTS `user_reso`;
CREATE TABLE `user_reso` (
  `id`  bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键id' ,
  `reso_id`  bigint(20) NULL DEFAULT NULL COMMENT '前端配置的资源id' ,
  `reso_pid`  bigint(20) NULL DEFAULT NULL COMMENT '父id' ,
  `reso_sysname`  varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '系统名称' ,
  `reso_init_name`  varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '资源初始名称' ,
  `reso_name`  varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '资源名称' ,
  `reso_code`  varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '资源码' ,
  `reso_level`  int(4) NULL DEFAULT NULL COMMENT '资源级别' ,
  `reso_status`  int(4) NULL DEFAULT NULL COMMENT '状态' ,
  `reso_path`  varchar(500) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '资源路径' ,
  `reso_init_icon`  varchar(500) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '资源初始图标' ,
  `reso_icon`  varchar(500) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '资源图标' ,
  `reso_type`  int(4) NULL DEFAULT NULL COMMENT '资源类型' ,
  `reso_filetype`  int(4) NULL DEFAULT NULL COMMENT '资源文件类型' ,
  `reso_remark`  varchar(500) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '备注' ,
  `operator`  bigint(20) NULL DEFAULT NULL COMMENT '创建人' ,
  `operate_time`  datetime NULL DEFAULT NULL COMMENT '创建日期' ,
  `flag`  int(4) NULL DEFAULT NULL COMMENT '数据库排序标识' ,
  `color`  varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL ,
  `sort`  int(4) NULL DEFAULT NULL ,
  PRIMARY KEY (`id`)
)
  ENGINE=InnoDB
  DEFAULT CHARACTER SET=utf8 COLLATE=utf8_general_ci
  COMMENT='用户资源管理'
  AUTO_INCREMENT=457

;

-- ----------------------------
-- Table structure for `user_resource`
-- ----------------------------
DROP TABLE IF EXISTS `user_resource`;
CREATE TABLE `user_resource` (
  `user_id`  bigint(20) NULL DEFAULT NULL COMMENT '用户id' ,
  `resource_id`  bigint(20) NULL DEFAULT NULL COMMENT '资源id' ,
  `id`  bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键' ,
  `is_check`  int(4) NULL DEFAULT NULL COMMENT '是否勾选 true 1 false 0' ,
  `sort`  int(4) NULL DEFAULT NULL ,
  `reso_pid`  bigint(20) NULL DEFAULT NULL COMMENT '父id' ,
  `reso_id`  bigint(20) NULL DEFAULT NULL ,
  `reso_code`  varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '资源code' ,
  PRIMARY KEY (`id`)
)
  ENGINE=InnoDB
  DEFAULT CHARACTER SET=utf8 COLLATE=utf8_general_ci
  COMMENT='用户资源中间表'
  AUTO_INCREMENT=588

;

-- ----------------------------
-- Table structure for `user_role`
-- ----------------------------
DROP TABLE IF EXISTS `user_role`;
CREATE TABLE `user_role` (
  `role_id`  bigint(20) NULL DEFAULT NULL COMMENT '角色id' ,
  `user_id`  bigint(20) NULL DEFAULT NULL COMMENT '用户id' ,
  `id`  bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键' ,
  PRIMARY KEY (`id`)
)
  ENGINE=InnoDB
  DEFAULT CHARACTER SET=utf8 COLLATE=utf8_general_ci
  COMMENT='用户角色中间表'
  AUTO_INCREMENT=10079

;

-- ----------------------------
-- Table structure for `withdraw_application`
-- ----------------------------
DROP TABLE IF EXISTS `withdraw_application`;
CREATE TABLE `withdraw_application` (
  `id`  bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键' ,
  `order_id`  bigint(20) NULL DEFAULT NULL COMMENT '订单id' ,
  `application_type`  int(4) NULL DEFAULT NULL COMMENT '申请类型' ,
  `approval_status`  int(4) NULL DEFAULT NULL COMMENT '审批状态' ,
  `approval_deal_status`  int(4) NULL DEFAULT NULL COMMENT '审核处理状态' ,
  `collect_money_deal_status`  int(4) NULL DEFAULT NULL COMMENT '收款处理状态' ,
  `initial_payment`  decimal(18,4) NULL DEFAULT 0.0000 COMMENT '首付款' ,
  `final_cash`  decimal(18,4) NULL DEFAULT NULL COMMENT '尾付款' ,
  `financing_amount`  decimal(18,4) NULL DEFAULT 0.0000 COMMENT '融资总额' ,
  `first_monthly_supply`  decimal(18,4) NULL DEFAULT 0.0000 COMMENT '首付月供' ,
  `deposit_cash`  decimal(18,4) NULL DEFAULT 0.0000 COMMENT '保证金' ,
  `manage_cost`  decimal(18,4) NULL DEFAULT 0.0000 COMMENT '管理费' ,
  `insurance_expenses`  decimal(18,4) NULL DEFAULT 0.0000 COMMENT '保险费' ,
  `purchase_tax`  decimal(18,4) NULL DEFAULT 0.0000 COMMENT '购置税' ,
  `install_license_fee`  decimal(18,4) NULL DEFAULT 0.0000 COMMENT '上牌费' ,
  `gps_fee`  decimal(18,4) NULL DEFAULT 0.0000 COMMENT 'GPS费用' ,
  `surplus_principal`  decimal(18,4) NULL DEFAULT 0.0000 COMMENT '剩余未还本金' ,
  `surplus_interest`  decimal(18,4) NULL DEFAULT 0.0000 COMMENT '剩余未还利息' ,
  `surplus_penalty`  decimal(18,4) NULL DEFAULT 0.0000 COMMENT '剩余未还罚息' ,
  `surplus_penalty_freeze`  decimal(18,4) NULL DEFAULT 0.0000 COMMENT '剩余冻结罚息' ,
  `surplus_manage_fee`  decimal(18,4) NULL DEFAULT 0.0000 COMMENT '剩余未还管理费' ,
  `advance_payoff_fee`  decimal(18,4) NULL DEFAULT 0.0000 COMMENT '提前结清手续费' ,
  `advance_revoke_fee`  decimal(18,4) NULL DEFAULT 0.0000 COMMENT '提前收回手续费' ,
  `violate_amount`  decimal(18,4) NULL DEFAULT 0.0000 COMMENT '违约金' ,
  `other_fee`  decimal(18,4) NULL DEFAULT 0.0000 COMMENT '其他费用' ,
  `total_payment`  decimal(18,4) NULL DEFAULT 0.0000 COMMENT '收款总额' ,
  `remark`  varchar(500) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '备注' ,
  `operator`  bigint(20) NULL DEFAULT NULL COMMENT '操作员' ,
  `operator_time`  datetime NULL DEFAULT NULL COMMENT '操作时间' ,
  `overage_amount`  decimal(18,4) NULL DEFAULT 0.0000 COMMENT '剩余未还款总额' ,
  `withdraw_type`  int(4) NULL DEFAULT NULL COMMENT '收回类型' ,
  `account_name`  varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '收款账户名' ,
  `repayment_account_name`  varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '还款账户名' ,
  `draft_info`  varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL ,
  `record_status`  int(4) NULL DEFAULT NULL COMMENT '记录状态（草稿，申请记录）' ,
  PRIMARY KEY (`id`)
)
  ENGINE=InnoDB
  DEFAULT CHARACTER SET=utf8 COLLATE=utf8_general_ci
  COMMENT='收款申请表'
  AUTO_INCREMENT=3

;

-- ----------------------------
-- Function structure for `next_seq`
-- ----------------------------
DROP FUNCTION IF EXISTS `next_seq`;
DELIMITER ;;
CREATE DEFINER=`root`@`%` FUNCTION `next_seq`(`seq_name` varchar(20),`seqLength` int) RETURNS varchar(20) CHARSET utf8
  BEGIN
    declare current integer;
    set current = 0;
    select t.current_seq into current from batch_seq t where t.seq_name =seq_name for update;
    update batch_seq t set t.current_seq = t.current_seq + 1 where t.seq_name = seq_name;
    set current = current + 1;
    /*如果订单号超出限制,产生一个错误*/
    IF seq_name ='orderSeq' && current >9999 THEN
      SIGNAL SQLSTATE 'HY000' SET MESSAGE_TEXT = "今日订单编号已到上限";
    END IF;
    RETURN LPAD(current,seqLength,'0');
  END
;;
DELIMITER ;

-- ----------------------------
-- Auto increment value for `approve_reason`
-- ----------------------------
ALTER TABLE `approve_reason` AUTO_INCREMENT=483;

-- ----------------------------
-- Auto increment value for `area_code`
-- ----------------------------
ALTER TABLE `area_code` AUTO_INCREMENT=3891;

-- ----------------------------
-- Auto increment value for `assessment_apply`
-- ----------------------------
ALTER TABLE `assessment_apply` AUTO_INCREMENT=1;

-- ----------------------------
-- Auto increment value for `assessment_apply_record`
-- ----------------------------
ALTER TABLE `assessment_apply_record` AUTO_INCREMENT=1;

-- ----------------------------
-- Auto increment value for `assessment_basic`
-- ----------------------------
ALTER TABLE `assessment_basic` AUTO_INCREMENT=1;

-- ----------------------------
-- Auto increment value for `backlog`
-- ----------------------------
ALTER TABLE `backlog` AUTO_INCREMENT=10;

-- ----------------------------
-- Auto increment value for `bankcard_detail`
-- ----------------------------
ALTER TABLE `bankcard_detail` AUTO_INCREMENT=1;

-- ----------------------------
-- Auto increment value for `car`
-- ----------------------------
ALTER TABLE `car` AUTO_INCREMENT=3;

-- ----------------------------
-- Auto increment value for `car_attr_value`
-- ----------------------------
ALTER TABLE `car_attr_value` AUTO_INCREMENT=1;

-- ----------------------------
-- Auto increment value for `car_attribute`
-- ----------------------------
ALTER TABLE `car_attribute` AUTO_INCREMENT=1;

-- ----------------------------
-- Auto increment value for `car_basic_file`
-- ----------------------------
ALTER TABLE `car_basic_file` AUTO_INCREMENT=1;

-- ----------------------------
-- Auto increment value for `car_brand`
-- ----------------------------
ALTER TABLE `car_brand` AUTO_INCREMENT=2;

-- ----------------------------
-- Auto increment value for `car_param`
-- ----------------------------
ALTER TABLE `car_param` AUTO_INCREMENT=5;

-- ----------------------------
-- Auto increment value for `car_param_type`
-- ----------------------------
ALTER TABLE `car_param_type` AUTO_INCREMENT=8;

-- ----------------------------
-- Auto increment value for `car_quotation`
-- ----------------------------
ALTER TABLE `car_quotation` AUTO_INCREMENT=1;

-- ----------------------------
-- Auto increment value for `car_series`
-- ----------------------------
ALTER TABLE `car_series` AUTO_INCREMENT=3;

-- ----------------------------
-- Auto increment value for `charge_back_recode`
-- ----------------------------
ALTER TABLE `charge_back_recode` AUTO_INCREMENT=1;

-- ----------------------------
-- Auto increment value for `collect_money_detail`
-- ----------------------------
ALTER TABLE `collect_money_detail` AUTO_INCREMENT=1;

-- ----------------------------
-- Auto increment value for `collect_money_history`
-- ----------------------------
ALTER TABLE `collect_money_history` AUTO_INCREMENT=1;

-- ----------------------------
-- Auto increment value for `company`
-- ----------------------------
ALTER TABLE `company` AUTO_INCREMENT=5;

-- ----------------------------
-- Auto increment value for `company_account`
-- ----------------------------
ALTER TABLE `company_account` AUTO_INCREMENT=1;

-- ----------------------------
-- Auto increment value for `contract_batch`
-- ----------------------------
ALTER TABLE `contract_batch` AUTO_INCREMENT=1;

-- ----------------------------
-- Auto increment value for `contract_info`
-- ----------------------------
ALTER TABLE `contract_info` AUTO_INCREMENT=1;

-- ----------------------------
-- Auto increment value for `contract_record`
-- ----------------------------
ALTER TABLE `contract_record` AUTO_INCREMENT=1;

-- ----------------------------
-- Auto increment value for `contract_upload_file`
-- ----------------------------
ALTER TABLE `contract_upload_file` AUTO_INCREMENT=1;

-- ----------------------------
-- Auto increment value for `data_dict`
-- ----------------------------
ALTER TABLE `data_dict` AUTO_INCREMENT=1193;

-- ----------------------------
-- Auto increment value for `data_dict_type`
-- ----------------------------
ALTER TABLE `data_dict_type` AUTO_INCREMENT=441;

-- ----------------------------
-- Auto increment value for `department`
-- ----------------------------
ALTER TABLE `department` AUTO_INCREMENT=7;

-- ----------------------------
-- Auto increment value for `device`
-- ----------------------------
ALTER TABLE `device` AUTO_INCREMENT=8;

-- ----------------------------
-- Auto increment value for `finance_approval_history`
-- ----------------------------
ALTER TABLE `finance_approval_history` AUTO_INCREMENT=1;

-- ----------------------------
-- Auto increment value for `finance_upload_resource`
-- ----------------------------
ALTER TABLE `finance_upload_resource` AUTO_INCREMENT=1;

-- ----------------------------
-- Auto increment value for `handover_record`
-- ----------------------------
ALTER TABLE `handover_record` AUTO_INCREMENT=1;

-- ----------------------------
-- Auto increment value for `invoicing_allocation_record`
-- ----------------------------
ALTER TABLE `invoicing_allocation_record` AUTO_INCREMENT=6;

-- ----------------------------
-- Auto increment value for `invoicing_allocation_request`
-- ----------------------------
ALTER TABLE `invoicing_allocation_request` AUTO_INCREMENT=9;

-- ----------------------------
-- Auto increment value for `invoicing_allocation_schedule`
-- ----------------------------
ALTER TABLE `invoicing_allocation_schedule` AUTO_INCREMENT=7;

-- ----------------------------
-- Auto increment value for `invoicing_allocation_vehicle`
-- ----------------------------
ALTER TABLE `invoicing_allocation_vehicle` AUTO_INCREMENT=11;

-- ----------------------------
-- Auto increment value for `invoicing_manufacturer`
-- ----------------------------
ALTER TABLE `invoicing_manufacturer` AUTO_INCREMENT=5;

-- ----------------------------
-- Auto increment value for `invoicing_market_quotation`
-- ----------------------------
ALTER TABLE `invoicing_market_quotation` AUTO_INCREMENT=1;

-- ----------------------------
-- Auto increment value for `invoicing_material_category`
-- ----------------------------
ALTER TABLE `invoicing_material_category` AUTO_INCREMENT=6;

-- ----------------------------
-- Auto increment value for `invoicing_material_item`
-- ----------------------------
ALTER TABLE `invoicing_material_item` AUTO_INCREMENT=4;

-- ----------------------------
-- Auto increment value for `invoicing_measures_record`
-- ----------------------------
ALTER TABLE `invoicing_measures_record` AUTO_INCREMENT=3;

-- ----------------------------
-- Auto increment value for `invoicing_measures_record_file`
-- ----------------------------
ALTER TABLE `invoicing_measures_record_file` AUTO_INCREMENT=1;

-- ----------------------------
-- Auto increment value for `invoicing_purchase_order`
-- ----------------------------
ALTER TABLE `invoicing_purchase_order` AUTO_INCREMENT=1;

-- ----------------------------
-- Auto increment value for `invoicing_purchase_requisition`
-- ----------------------------
ALTER TABLE `invoicing_purchase_requisition` AUTO_INCREMENT=2;

-- ----------------------------
-- Auto increment value for `invoicing_supplier`
-- ----------------------------
ALTER TABLE `invoicing_supplier` AUTO_INCREMENT=1;

-- ----------------------------
-- Auto increment value for `invoicing_vehicle`
-- ----------------------------
ALTER TABLE `invoicing_vehicle` AUTO_INCREMENT=15;

-- ----------------------------
-- Auto increment value for `invoicing_vehicle_brand`
-- ----------------------------
ALTER TABLE `invoicing_vehicle_brand` AUTO_INCREMENT=3;

-- ----------------------------
-- Auto increment value for `invoicing_vehicle_color`
-- ----------------------------
ALTER TABLE `invoicing_vehicle_color` AUTO_INCREMENT=1;

-- ----------------------------
-- Auto increment value for `invoicing_vehicle_mileage_record`
-- ----------------------------
ALTER TABLE `invoicing_vehicle_mileage_record` AUTO_INCREMENT=5;

-- ----------------------------
-- Auto increment value for `invoicing_vehicle_model`
-- ----------------------------
ALTER TABLE `invoicing_vehicle_model` AUTO_INCREMENT=2;

-- ----------------------------
-- Auto increment value for `invoicing_vehicle_param`
-- ----------------------------
ALTER TABLE `invoicing_vehicle_param` AUTO_INCREMENT=3;

-- ----------------------------
-- Auto increment value for `invoicing_vehicle_param_type`
-- ----------------------------
ALTER TABLE `invoicing_vehicle_param_type` AUTO_INCREMENT=2;

-- ----------------------------
-- Auto increment value for `invoicing_vehicle_pic`
-- ----------------------------
ALTER TABLE `invoicing_vehicle_pic` AUTO_INCREMENT=1;

-- ----------------------------
-- Auto increment value for `invoicing_vehicle_series`
-- ----------------------------
ALTER TABLE `invoicing_vehicle_series` AUTO_INCREMENT=3;

-- ----------------------------
-- Auto increment value for `invoicing_vehiclel_param`
-- ----------------------------
ALTER TABLE `invoicing_vehiclel_param` AUTO_INCREMENT=1;

-- ----------------------------
-- Auto increment value for `invoicing_vehiclel_param_type`
-- ----------------------------
ALTER TABLE `invoicing_vehiclel_param_type` AUTO_INCREMENT=1;

-- ----------------------------
-- Auto increment value for `order_car`
-- ----------------------------
ALTER TABLE `order_car` AUTO_INCREMENT=8;

-- ----------------------------
-- Auto increment value for `order_process_record`
-- ----------------------------
ALTER TABLE `order_process_record` AUTO_INCREMENT=25;

-- ----------------------------
-- Auto increment value for `order_service`
-- ----------------------------
ALTER TABLE `order_service` AUTO_INCREMENT=10;

-- ----------------------------
-- Auto increment value for `payment_history`
-- ----------------------------
ALTER TABLE `payment_history` AUTO_INCREMENT=1;

-- ----------------------------
-- Auto increment value for `payment_schedule`
-- ----------------------------
ALTER TABLE `payment_schedule` AUTO_INCREMENT=49;

-- ----------------------------
-- Auto increment value for `personal`
-- ----------------------------
ALTER TABLE `personal` AUTO_INCREMENT=4;

-- ----------------------------
-- Auto increment value for `personal_bank`
-- ----------------------------
ALTER TABLE `personal_bank` AUTO_INCREMENT=2;

-- ----------------------------
-- Auto increment value for `personal_car`
-- ----------------------------
ALTER TABLE `personal_car` AUTO_INCREMENT=1;

-- ----------------------------
-- Auto increment value for `personal_contact`
-- ----------------------------
ALTER TABLE `personal_contact` AUTO_INCREMENT=11;

-- ----------------------------
-- Auto increment value for `personal_data`
-- ----------------------------
ALTER TABLE `personal_data` AUTO_INCREMENT=7;

-- ----------------------------
-- Auto increment value for `personal_job`
-- ----------------------------
ALTER TABLE `personal_job` AUTO_INCREMENT=3;

-- ----------------------------
-- Auto increment value for `personal_material`
-- ----------------------------
ALTER TABLE `personal_material` AUTO_INCREMENT=25;

-- ----------------------------
-- Auto increment value for `personal_resource_introduce`
-- ----------------------------
ALTER TABLE `personal_resource_introduce` AUTO_INCREMENT=3;

-- ----------------------------
-- Auto increment value for `personal_resource_publicity`
-- ----------------------------
ALTER TABLE `personal_resource_publicity` AUTO_INCREMENT=8;

-- ----------------------------
-- Auto increment value for `product`
-- ----------------------------
ALTER TABLE `product` AUTO_INCREMENT=12;

-- ----------------------------
-- Auto increment value for `product_match`
-- ----------------------------
ALTER TABLE `product_match` AUTO_INCREMENT=1;

-- ----------------------------
-- Auto increment value for `product_order`
-- ----------------------------
ALTER TABLE `product_order` AUTO_INCREMENT=10;

-- ----------------------------
-- Auto increment value for `product_package`
-- ----------------------------
ALTER TABLE `product_package` AUTO_INCREMENT=2;

-- ----------------------------
-- Auto increment value for `product_plan_issue`
-- ----------------------------
ALTER TABLE `product_plan_issue` AUTO_INCREMENT=7;

-- ----------------------------
-- Auto increment value for `product_process`
-- ----------------------------
ALTER TABLE `product_process` AUTO_INCREMENT=27;

-- ----------------------------
-- Auto increment value for `product_process_configuration`
-- ----------------------------
ALTER TABLE `product_process_configuration` AUTO_INCREMENT=29;

-- ----------------------------
-- Auto increment value for `product_series`
-- ----------------------------
ALTER TABLE `product_series` AUTO_INCREMENT=14;

-- ----------------------------
-- Auto increment value for `refund_application`
-- ----------------------------
ALTER TABLE `refund_application` AUTO_INCREMENT=1;

-- ----------------------------
-- Auto increment value for `refund_application_item`
-- ----------------------------
ALTER TABLE `refund_application_item` AUTO_INCREMENT=1;

-- ----------------------------
-- Auto increment value for `refund_approval`
-- ----------------------------
ALTER TABLE `refund_approval` AUTO_INCREMENT=1;

-- ----------------------------
-- Auto increment value for `refund_history`
-- ----------------------------
ALTER TABLE `refund_history` AUTO_INCREMENT=1;

-- ----------------------------
-- Auto increment value for `refund_record_item`
-- ----------------------------
ALTER TABLE `refund_record_item` AUTO_INCREMENT=1;

-- ----------------------------
-- Auto increment value for `refund_upload_resource`
-- ----------------------------
ALTER TABLE `refund_upload_resource` AUTO_INCREMENT=1;

-- ----------------------------
-- Auto increment value for `remit_application`
-- ----------------------------
ALTER TABLE `remit_application` AUTO_INCREMENT=1;

-- ----------------------------
-- Auto increment value for `remit_application_approval`
-- ----------------------------
ALTER TABLE `remit_application_approval` AUTO_INCREMENT=1;

-- ----------------------------
-- Auto increment value for `role`
-- ----------------------------
ALTER TABLE `role` AUTO_INCREMENT=4;

-- ----------------------------
-- Auto increment value for `role_backlog`
-- ----------------------------
ALTER TABLE `role_backlog` AUTO_INCREMENT=28;

-- ----------------------------
-- Auto increment value for `role_reso`
-- ----------------------------
ALTER TABLE `role_reso` AUTO_INCREMENT=475;

-- ----------------------------
-- Auto increment value for `role_resource`
-- ----------------------------
ALTER TABLE `role_resource` AUTO_INCREMENT=28710;

-- ----------------------------
-- Auto increment value for `schedule_job`
-- ----------------------------
ALTER TABLE `schedule_job` AUTO_INCREMENT=1;

-- ----------------------------
-- Auto increment value for `schedule_job_log`
-- ----------------------------
ALTER TABLE `schedule_job_log` AUTO_INCREMENT=3;

-- ----------------------------
-- Auto increment value for `system_backup`
-- ----------------------------
ALTER TABLE `system_backup` AUTO_INCREMENT=4;

-- ----------------------------
-- Auto increment value for `system_logs`
-- ----------------------------
ALTER TABLE `system_logs` AUTO_INCREMENT=11850;

-- ----------------------------
-- Auto increment value for `system_parameter`
-- ----------------------------
ALTER TABLE `system_parameter` AUTO_INCREMENT=11;

-- ----------------------------
-- Auto increment value for `template`
-- ----------------------------
ALTER TABLE `template` AUTO_INCREMENT=5;

-- ----------------------------
-- Auto increment value for `transaction_detail`
-- ----------------------------
ALTER TABLE `transaction_detail` AUTO_INCREMENT=1;

-- ----------------------------
-- Auto increment value for `upload_information`
-- ----------------------------
ALTER TABLE `upload_information` AUTO_INCREMENT=1;

-- ----------------------------
-- Auto increment value for `user_information`
-- ----------------------------
ALTER TABLE `user_information` AUTO_INCREMENT=10;

-- ----------------------------
-- Auto increment value for `user_privilege`
-- ----------------------------
ALTER TABLE `user_privilege` AUTO_INCREMENT=1;

-- ----------------------------
-- Auto increment value for `user_reso`
-- ----------------------------
ALTER TABLE `user_reso` AUTO_INCREMENT=457;

-- ----------------------------
-- Auto increment value for `user_resource`
-- ----------------------------
ALTER TABLE `user_resource` AUTO_INCREMENT=588;

-- ----------------------------
-- Auto increment value for `user_role`
-- ----------------------------
ALTER TABLE `user_role` AUTO_INCREMENT=10079;

-- ----------------------------
-- Auto increment value for `withdraw_application`
-- ----------------------------
ALTER TABLE `withdraw_application` AUTO_INCREMENT=3;
