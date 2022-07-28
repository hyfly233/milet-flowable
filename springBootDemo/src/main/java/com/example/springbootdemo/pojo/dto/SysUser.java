package com.example.springbootdemo.pojo.dto;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.util.Date;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
    * 用户表
    */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@TableName(value = "sys_user")
public class SysUser {
    /**
     * 主键id
     */
    @TableId(value = "id", type = IdType.ASSIGN_ID)
    private String id;

    /**
     * 登录账号
     */
    @TableField(value = "username")
    private String username;

    /**
     * 真实姓名
     */
    @TableField(value = "realname")
    private String realname;

    /**
     * 密码
     */
    @TableField(value = "`password`")
    private String password;

    /**
     * md5密码盐
     */
    @TableField(value = "salt")
    private String salt;

    /**
     * 头像
     */
    @TableField(value = "avatar")
    private String avatar;

    /**
     * 生日
     */
    @TableField(value = "birthday")
    private Date birthday;

    /**
     * 性别(0-默认未知,1-男,2-女)
     */
    @TableField(value = "sex")
    private Boolean sex;

    /**
     * 电子邮件
     */
    @TableField(value = "email")
    private String email;

    /**
     * 电话
     */
    @TableField(value = "phone")
    private String phone;

    /**
     * 登录会话的机构编码
     */
    @TableField(value = "org_code")
    private String orgCode;

    /**
     * 性别(1-正常,2-冻结)
     */
    @TableField(value = "`status`")
    private Boolean status;

    /**
     * 删除状态(0-正常,1-已删除)
     */
    @TableField(value = "del_flag")
    private Boolean delFlag;

    /**
     * 第三方登录的唯一标识
     */
    @TableField(value = "third_id")
    private String thirdId;

    /**
     * 第三方类型
     */
    @TableField(value = "third_type")
    private String thirdType;

    /**
     * 同步工作流引擎(1-同步,0-不同步)
     */
    @TableField(value = "activiti_sync")
    private Boolean activitiSync;

    /**
     * 工号，唯一键
     */
    @TableField(value = "work_no")
    private String workNo;

    /**
     * 职务，关联职务表
     */
    @TableField(value = "post")
    private String post;

    /**
     * 座机号
     */
    @TableField(value = "telephone")
    private String telephone;

    /**
     * 创建人
     */
    @TableField(value = "create_by")
    private String createBy;

    /**
     * 创建时间
     */
    @TableField(value = "create_time")
    private Date createTime;

    /**
     * 更新人
     */
    @TableField(value = "update_by")
    private String updateBy;

    /**
     * 更新时间
     */
    @TableField(value = "update_time")
    private Date updateTime;

    /**
     * 身份（1普通成员 2上级）
     */
    @TableField(value = "user_identity")
    private Boolean userIdentity;

    /**
     * 负责部门
     */
    @TableField(value = "depart_ids")
    private String departIds;

    /**
     * 多租户标识
     */
    @TableField(value = "rel_tenant_ids")
    private String relTenantIds;

    /**
     * 设备ID
     */
    @TableField(value = "client_id")
    private String clientId;

    private List<SysRole> roles;

    public static final String COL_ID = "id";

    public static final String COL_USERNAME = "username";

    public static final String COL_REALNAME = "realname";

    public static final String COL_PASSWORD = "password";

    public static final String COL_SALT = "salt";

    public static final String COL_AVATAR = "avatar";

    public static final String COL_BIRTHDAY = "birthday";

    public static final String COL_SEX = "sex";

    public static final String COL_EMAIL = "email";

    public static final String COL_PHONE = "phone";

    public static final String COL_ORG_CODE = "org_code";

    public static final String COL_STATUS = "status";

    public static final String COL_DEL_FLAG = "del_flag";

    public static final String COL_THIRD_ID = "third_id";

    public static final String COL_THIRD_TYPE = "third_type";

    public static final String COL_ACTIVITI_SYNC = "activiti_sync";

    public static final String COL_WORK_NO = "work_no";

    public static final String COL_POST = "post";

    public static final String COL_TELEPHONE = "telephone";

    public static final String COL_CREATE_BY = "create_by";

    public static final String COL_CREATE_TIME = "create_time";

    public static final String COL_UPDATE_BY = "update_by";

    public static final String COL_UPDATE_TIME = "update_time";

    public static final String COL_USER_IDENTITY = "user_identity";

    public static final String COL_DEPART_IDS = "depart_ids";

    public static final String COL_REL_TENANT_IDS = "rel_tenant_ids";

    public static final String COL_CLIENT_ID = "client_id";
}