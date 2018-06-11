/*
清空表数据（保留资源、部门、用户、角色）
 */
TRUNCATE approve_reason;
TRUNCATE assessment_apply;
TRUNCATE assessment_apply_record;
TRUNCATE assessment_basic;
TRUNCATE assessment_placing;
TRUNCATE assessment_placing_file;
TRUNCATE assessment_placing_type_value;
TRUNCATE assessment_basic;
TRUNCATE bankcard_detail;
TRUNCATE car;
TRUNCATE car_attr_value;
TRUNCATE car_basic_file;
TRUNCATE car_brand;
TRUNCATE car_param;
TRUNCATE car_param_type;
TRUNCATE car_quotation;
TRUNCATE car_series;
TRUNCATE charge_back_recode;
TRUNCATE collect_money_detail;
TRUNCATE collect_money_history;
TRUNCATE company;
TRUNCATE company_account;
TRUNCATE contract_batch;
TRUNCATE contract_info;
TRUNCATE contract_record;
TRUNCATE contract_upload_file;
TRUNCATE finance_approval_history;
TRUNCATE finance_invoice;
TRUNCATE finance_upload_resource;
TRUNCATE handover_record;
TRUNCATE order_car;
TRUNCATE order_process_record;
TRUNCATE order_service;
TRUNCATE payment_history;
TRUNCATE payment_schedule;
TRUNCATE personal;
TRUNCATE personal_bank;
TRUNCATE personal_car;
TRUNCATE personal_contact;
TRUNCATE personal_data;
TRUNCATE personal_job;
TRUNCATE personal_material;
TRUNCATE personal_resource_introduce;
TRUNCATE personal_resource_publicity;
TRUNCATE product;
TRUNCATE product_match;
TRUNCATE product_order;
TRUNCATE product_package;
TRUNCATE product_plan_issue;
TRUNCATE product_price_config;
TRUNCATE product_process;
TRUNCATE product_process_configuration;
TRUNCATE product_series;
TRUNCATE refund_application;
TRUNCATE refund_application_item;
TRUNCATE refund_approval;
TRUNCATE refund_history;
TRUNCATE refund_record_item;
TRUNCATE refund_upload_resource;
TRUNCATE remit_application;
TRUNCATE remit_application_approval;
TRUNCATE remit_apply;
TRUNCATE role_backlog;
TRUNCATE schedule_job;
TRUNCATE schedule_job_log;
TRUNCATE system_backup;
TRUNCATE system_logs;
TRUNCATE template;
TRUNCATE transaction_detail;
TRUNCATE upload_information;
TRUNCATE user_privilege;
TRUNCATE user_resource;
TRUNCATE withdraw_application;

/*
 清空角色（保留超级管理员）
 */
 DELETE FROM role WHERE id != 1;
 /*
 清空角色资源（保留超级管理员的资源）
 */
 DELETE FROM role_resource WHERE role_id != 1;
  /*
 清空用户（保留超级管理员）
 */
 DELETE FROM user_information WHERE id != 1;
  /*
 清空用户角色（保留超级管理员）
 */
 DELETE FROM user_role WHERE user_id != 1;
  /*
 清空用户角色（保留超级管理员）
 */
 DELETE FROM department WHERE id != 1;
 /*
 清空设备管理（保留超级管理员）
 */
  DELETE FROM device WHERE id != 1;

