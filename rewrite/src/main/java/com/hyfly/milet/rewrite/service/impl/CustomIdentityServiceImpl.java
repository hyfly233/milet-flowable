package com.hyfly.milet.rewrite.service.impl;

import com.example.flowable.dao.SysRoleMapper;
import com.example.flowable.dao.SysUserMapper;
import com.example.flowable.pojo.dto.SysRole;
import com.example.flowable.pojo.dto.SysUser;
import com.example.flowable.service.CustomIdentityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CustomIdentityServiceImpl implements CustomIdentityService {
    @Autowired
    private SysRoleMapper sysRoleMapper;

    @Autowired
    private SysUserMapper sysUserMapper;

    @Override
    public List<SysRole> getRoleByUserId(String userId) {
        List<SysRole> list = new ArrayList<>();

        if (userId != null && userId.length() > 0) {
            return sysRoleMapper.getSysRoleByUserId(userId);
        }

        return list;
    }

    @Override
    public SysRole getRoleById(String roleId) {
        return sysRoleMapper.selectById(roleId);
    }

    @Override
    public SysUser getUserById(String userId) {
        return sysUserMapper.selectById(userId);
    }
}
