package com.hyfly.milet.rewrite.service.impl;

import com.hyfly.milet.rewrite.dao.CustomIdentityMapper;
import com.hyfly.milet.rewrite.pojo.dto.SysRole;
import com.hyfly.milet.rewrite.pojo.dto.SysUser;
import com.hyfly.milet.rewrite.service.CustomIdentityService;
import org.flowable.idm.engine.impl.GroupQueryImpl;
import org.flowable.idm.engine.impl.UserQueryImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CustomIdentityServiceImpl implements CustomIdentityService {
    @Autowired
    private CustomIdentityMapper identityMapper;

    @Autowired
    private SysRoleServiceImpl roleService;

    @Autowired
    private SysUserServiceImpl userService;

    @Override
    public List<SysRole> getRoleByUserId(String userId) {
        List<SysRole> list = new ArrayList<>();

        if (userId != null && !"".equals(userId)) {
            list = identityMapper.selectSysRoleByUserId(userId);
        }
        return list;
    }

    @Override
    public SysRole getRoleById(String roleId) {
        return roleService.getById(roleId);
    }

    @Override
    public SysUser getUserById(String userId) {
        return userService.getById(userId);
    }

    @Override
    public List<SysUser> getUserByUserQuery(UserQueryImpl userQuery) {
        List<SysUser> list = new ArrayList<>();
        if (userQuery != null) {
            list = identityMapper.selectSysUserByUserQuery(userQuery);
        }
        return list;
    }

    @Override
    public List<SysRole> selectSysRoleByGroupQuery(GroupQueryImpl groupQuery) {
        List<SysRole> list = new ArrayList<>();
        if (groupQuery != null) {
            list = identityMapper.selectSysRoleByGroupQuery(groupQuery);
        }
        return list;
    }
}