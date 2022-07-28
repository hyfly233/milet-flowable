package com.example.springbootdemo.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.springbootdemo.dao.SysUserMapper;
import com.example.springbootdemo.pojo.dto.SysUser;
import com.example.springbootdemo.service.SysUserService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class SysUserServiceImpl extends ServiceImpl<SysUserMapper, SysUser> implements SysUserService {

    @Autowired
    private SysUserMapper sysUserMapper;

    @Override
    public List<SysUser> getAllUserIncludeRole() {
        return sysUserMapper.getAllUserIncludeRole();
    }
}
