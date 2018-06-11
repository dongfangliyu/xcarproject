package com.fintecher.contract.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.util.Date;

/**
 * @System: 车贷金融
 * @Auther: hukaijia
 * @Description: 用户实体类
 * @Date:Created on 2017/12/25/025 13:13
 * @Modified By:
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@ApiModel(description = "用户实体类")
@EqualsAndHashCode(callSuper = false)
@Table(name = "user_information")
public class User extends BaseEntity {
    /**
     * 用户类型  409 正式用户  410试用账户
     */
    @ApiModelProperty(value = "用户类型", notes = "409 正式用户  410试用账户")
    @Column(name = "user_type")
    private Integer userType;
    /**
     * 试用时长 402试用账户 单位:月
     */
    @ApiModelProperty(value = "试用时长", notes = "单位（月）")
    @Column(name = "trial_time")
    private Integer trialTime;
    /**
     * 411 密码登录 412 二维码登录 413 人脸识别登录
     */

    @ApiModelProperty(value = "登录类型", notes = "411 密码登录 412 二维码登录 413 人脸识别登录")
    @Column(name = "login_type")
    private Integer loginType;
    /**
     * 登录设备类型  414 pc端 415 app端
     */

    @ApiModelProperty(value = "登录设备类型", notes = "414 pc端 415 app端 ")
    @Column(name = "login_device")
    private Integer loginDevice;
    /**
     * 登录地址
     */
    @ApiModelProperty(value = "登录地址", notes = "登录地址")
    @Column(name = "login_address")
    private String loginAddress;
    /**
     * 密码过时时间
     */
    @ApiModelProperty(value = "密码过时时间", notes = "密码过时时间")
    @Column(name = "password_time")
    private Date passwordTime;
    /**
     * 部门id
     */
    @NotNull
    @ApiModelProperty(value = "部门id", notes = "部门id")
    @Column(name = "dept_id")
    private Long deptId;
    /**
     * 用户绑定的消息推送id
     */
    @ApiModelProperty(value = "用户绑定的消息推送id", notes = "用户绑定的消息推送id")
    @Column(name = "message_pushid")
    private String messagePushid;
    /**
     * 是否管理员 416 个人权限 417 部门权限 418 公司权限
     */
    @NotNull
    @ApiModelProperty(value = "是否管理员", notes = "416 个人权限 417 部门管理员 418 公司管理员")
    @Column(name = "user_manager")
    private Integer userManager;
    /**
     * 用户名
     */
    @NotNull
    @Size(min = 6, max = 50, message = "用户名长度不能小于6位大于50位")
    @ApiModelProperty(value = "用户名", notes = "用户名")
    @Column(name = "user_username")
    private String userUsername;
    /**
     * 真实姓名
     */
    @NotNull
    @Pattern(regexp = "^([\\u4e00-\\u9fa5]+|([a-zA-Z]+\\s?)+)$", message = "姓名只能汉字或者英文")
    @ApiModelProperty(value = "姓名", notes = "姓名")
    @Size(min = 1, max = 50, message = "姓名不能超过五十个字符")
    @Column(name = "user_realname")
    private String userRealname;
    /**
     * 密码
     */
    @Size(min = 6, max = 64, message = "密码长度不能小于6位大于64位")
    @ApiModelProperty(value = "密码", notes = "密码")
    @Column(name = "user_password")
    private String userPassword;
    /**
     * 性别  419 男  420 女
     */
    @ApiModelProperty(value = "性别", notes = "419 男  420 女")
    @Column(name = "user_sex")
    private Integer userSex;
    /**
     * 电话
     */
    @Pattern(regexp = "[0-9-()（）]{7,18}", message = "电话格式错误")
    @ApiModelProperty(value = "手机号", notes = "手机号")
    @Column(name = "user_phone")
    private String userPhone;
    /**
     * 邮箱
     */
    @ApiModelProperty(value = "邮箱", notes = "邮箱")
    @Column(name = "user_email")
    private String userEmail;
    /**
     * 用户状态 0 启用 1 停用
     */
    @ApiModelProperty(value = "用户状态", notes = "0 启用 1 停用")
    @Column(name = "user_status")
    private Integer userStatus;
    /**
     * 用户所属公司
     */
    @ApiModelProperty(value = "用户所属公司", notes = "用户所属公司")
    @Column(name = "company")
    private String company;
    /**
     * 用户签名
     */
    @ApiModelProperty(value = "用户签名", notes = "用户签名")
    @Column(name = "user_signature")
    private String userSignature;
    /**
     * 备注
     */
    @ApiModelProperty(value = "备注", notes = "备注")
    @Column(name = "user_remark")
    private String userRemark;
    /**
     * 用户头像
     */
    @ApiModelProperty(value = "用户头像", notes = "用户头像")
    @Column(name = "user_photo")
    private String userPhoto;
    /**
     * 用户所属角色
     */
    @Transient
    @ApiModelProperty(value = "角色名", notes = "角色名")
    private String roleName;

    @ApiModelProperty(notes = "操作员")
    @Column(name = "operator")
    private Long operator;
    @ApiModelProperty(notes = "操作时间")
    @Column(name = "operate_time")
    private Date operateTime;

    /**
     * 用户状态
     */
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

    public enum UserManager {
        //416 个人权限 417 部门权限 418 公司权限
        PERSONAL("个人权限", 416), DEPARTMENT("部门权限", 417), COMPANY("公司权限", 418);

        private String name;
        private Integer value;

        UserManager(String name, Integer value) {
            this.name = name;
            this.value = value;
        }

        public String getName() {
            return name;
        }

        public Integer getValue() {
            return value;
        }
    }

    public enum UserType {
        // 409 正式用户  410试用账户
        FORMAL(409), PRACTISE(410);
        private Integer userType;

        UserType(Integer userType) {
            this.userType = userType;
        }

        public Integer getUserType() {
            return userType;
        }
    }

}
