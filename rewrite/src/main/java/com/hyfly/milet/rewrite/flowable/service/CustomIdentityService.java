package com.hyfly.milet.rewrite.flowable.service;

import com.hyfly.milet.rewrite.pojo.dto.SysRole;
import com.hyfly.milet.rewrite.pojo.dto.SysUser;
import org.flowable.idm.engine.impl.GroupQueryImpl;
import org.flowable.idm.engine.impl.UserQueryImpl;

import java.util.List;

public interface CustomIdentityService {
    List<SysRole> getRoleByUserId(String userId);

    SysRole getRoleById(String roleId);

    SysUser getUserById(String userId);

    List<SysUser> getUserByUserQuery(UserQueryImpl userQuery);

    List<SysRole> selectSysRoleByGroupQuery(GroupQueryImpl groupQuery);
}