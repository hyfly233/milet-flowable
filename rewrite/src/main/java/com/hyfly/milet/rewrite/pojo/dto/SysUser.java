package com.hyfly.milet.rewrite.pojo.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;

/**
 * 用户表
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class SysUser {
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
    /**
     * 主键id
     */
    private String id;
    /**
     * 登录账号
     */
    private String username;
    /**
     * 真实姓名
     */
    private String realname;
    /**
     * 密码
     */
    private String password;
    /**
     * md5密码盐
     */
    private String salt;
    /**
     * 头像
     */
    private String avatar;
    /**
     * 生日
     */
    private Date birthday;
    /**
     * 性别(0-默认未知,1-男,2-女)
     */
    private Boolean sex;
    /**
     * 电子邮件
     */
    private String email;
    /**
     * 电话
     */
    private String phone;
    /**
     * 登录会话的机构编码
     */
    private String orgCode;
    /**
     * 性别(1-正常,2-冻结)
     */
    private Boolean status;
    /**
     * 删除状态(0-正常,1-已删除)
     */
    private Boolean delFlag;

    /**
     * 工号，唯一键
     */
    private String workNo;
    /**
     * 职务，关联职务表
     */
    private String post;
    /**
     * 座机号
     */
    private String telephone;
    /**
     * 创建人
     */
    private String createBy;
    /**
     * 创建时间
     */
    private Date createTime;
    /**
     * 更新人
     */
    private String updateBy;
    /**
     * 更新时间
     */
    private Date updateTime;
    /**
     * 身份（1普通成员 2上级）
     */
    private Boolean userIdentity;
    /**
     * 负责部门
     */
    private String departIds;
    /**
     * 多租户标识
     */
    private String relTenantIds;
    /**
     * 设备ID
     */
    private String clientId;


    private List<SysRole> roles;
}