package com.example.springbootdemo.service;

import com.example.springbootdemo.pojo.dto.SysRole;

import java.util.List;

public interface CustomIdentityService {

    List<SysRole> getRoleByUserId(String userId);

    SysRole getRoleById(String roleId);
}
