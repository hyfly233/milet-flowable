package com.hyfly.milet.rewrite.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.flowable.dao.SysUserMapper;
import com.example.flowable.pojo.dto.SysUser;
import com.example.flowable.service.SysUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SysUserServiceImpl extends ServiceImpl<SysUserMapper, SysUser> implements SysUserService {

    @Autowired
    private SysUserMapper sysUserMapper;

    @Override
    public List<SysUser> getAllUserIncludeRole() {
        return sysUserMapper.getAllUserIncludeRole();
    }
}
