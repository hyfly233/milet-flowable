package com.hyfly.milet.rewrite.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.flowable.dao.SysRoleMapper;
import com.example.flowable.pojo.dto.SysRole;
import com.example.flowable.service.SysRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SysRoleServiceImpl extends ServiceImpl<SysRoleMapper, SysRole> implements SysRoleService {

    @Autowired
    private SysRoleMapper sysRoleMapper;

    @Override
    public List<SysRole> getAllRoleIncludeUser() {
        return sysRoleMapper.getAllRoleIncludeUser();
    }
}
