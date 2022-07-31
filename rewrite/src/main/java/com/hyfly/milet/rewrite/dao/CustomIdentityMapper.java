package com.hyfly.milet.rewrite.dao;

import com.hyfly.milet.rewrite.pojo.dto.SysRole;
import com.hyfly.milet.rewrite.pojo.dto.SysUser;
import org.apache.ibatis.annotations.Mapper;
import org.flowable.idm.engine.impl.GroupQueryImpl;
import org.flowable.idm.engine.impl.UserQueryImpl;

import java.util.List;

@Mapper
public interface CustomIdentityMapper {
    List<SysRole> selectSysRoleByUserId(String userId);

    List<SysUser> selectSysUserByUserQuery(UserQueryImpl userQuery);

    List<SysRole> selectSysRoleByGroupQuery(GroupQueryImpl groupQuery);
}
