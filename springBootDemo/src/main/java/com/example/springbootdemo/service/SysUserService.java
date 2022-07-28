package com.example.springbootdemo.service;

import com.example.springbootdemo.pojo.dto.SysUser;

import java.util.List;

public interface SysUserService {

    List<SysUser> getAllUserIncludeRole();
}
