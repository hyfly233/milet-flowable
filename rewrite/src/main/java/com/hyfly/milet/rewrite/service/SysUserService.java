package com.hyfly.milet.rewrite.service;

import com.example.flowable.pojo.dto.SysUser;

import java.util.List;

public interface SysUserService {

    List<SysUser> getAllUserIncludeRole();
}
