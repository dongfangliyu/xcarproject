package com.fintecher.sims.util;

/**
 * Created by jwdstef on 2017/5/18.
 */
public class Constant {

    /**
     * 定时任务状态
     */
    public enum JobStatus {

        /**
         * 暂停
         */
        PAUSE(0),
        /**
         * 正常
         */
        NORMAL(1);


        private int value;

        private JobStatus(int value) {
            this.value = value;
        }

        public int getValue() {
            return value;
        }
    }

    public enum Status {
        // 0-启用 1-禁用
        ENABLE(0), DISABLE(1);
        private Integer status;

        Status(Integer status) {
            this.status = status;
        }

        public Integer getStatus() {
            return status;
        }
    }

    public enum Type {
        //414 pc端 415 app端
        TYPEPC(414), TYPEAPP(415);
        private Integer type;

        Type(Integer type) {
            this.type = type;
        }

        public Integer getType() {
            return type;
        }
    }

    /**
     * 表单token
     */
    public static final String TOKEN_FORM = "tokenForm";

    /**
     * Ajax操作验证表单重复后的响应头key
     */
    public static final String HEAD_TOKEN_FORM_KEY = "X-Form-Token";

    /**
     * Ajax操作验证表单重复后的响应头value
     */
    public static final String HEAD_TOKEN_FORM_VALUE = "Repeat-Submit";
    public static final String SESSION_USER = "X-UserToken";

    /**
     * Ajax操作没有权限的响应头key
     */
    public static final String HEAD_NO_PERMISSION_KEY = "X-No-Permission";

    /**
     * Ajax操作没有权限的响应头value
     */
    public static final String HEAD_NO_PERMISSION_VALUE = "No-Permission";

    /**
     * Ajax操作登陆超时的响应头key
     */
    public static final String HEAD_SESSION_STATUS_KEY = "X-Session-Status";

    /**
     * Ajax操作登陆超时的响应头value
     */
    public static final String HEAD_SESSION_STATUS_VALUE = "Session-Timeout";

    /**
     * 存储当前登录用户id的字段名
     */
    public static final String CURRENT_USER_ID = "CURRENT_USER_ID";

    /**
     * token有效期（小时）
     */
    public static final int TOKEN_EXPIRES_HOUR = 24;

    /**
     * 存放Authorization的header字段
     */
    public static final String AUTHORIZATION = "authorization";
    /**
     * 申请用户默认密码
     */
    public static final String USER_DEFAULT_PASSWORD_NAME = "申请用户默认密码";
    public static final String USER_DEFAULT_PASSWORD_CODE = "UserDefaultPassword";
    /**
     * 重置用户密码
     */
    public static final String USER_RESET_PASSWORD_NAME = "重置用户默认密码";
    public static final String USER_RESET_PASSWORD_CODE = "UserResetPassword";
/**
 * 软件注册
 */
    public static final  String REGISTER_SOFTWARE_NAME ="软件注册返回码";
    public static final String REGISTER_SOFTWARE_CODE  = "SoftwareRegistrationReturnCode";
    /**
     * mysql备份脚本地址
     */
    public static final String MYSQL_BACKUP_ADDRESS_NAME = "mysql数据库脚本地址";
    public static final String MYSQL_BACKUP_ADDRESS_CODE = "SysBackupAddress";
    /**
     * 密码过时月数
     */
    public static final String PASSWORD_OBSOLETE_MONTHS_NAME = "密码过时月数";
    public static final String PASSWORD_OBSOLETE_MONTHS_CODE = "PasswordObsoleteMonths";
    /**
     * 超级管理员id
     */
    public static final long ADMINISTRATOR_USER_ID = 1;
    /**
     * 超级管理员角色id
     */
    public static final long ADMINISTRATOR_ROLE_ID = 1;
    /**
     * 顶级部门id
     */
    public static final long ADMINISTRATOR_DEPARTMENT_ID = 1;

    /**
     * 时间格式
     */
    public static final String DATE_FORMAT = "yyyy-MM-dd HH:mm:ss";
}
