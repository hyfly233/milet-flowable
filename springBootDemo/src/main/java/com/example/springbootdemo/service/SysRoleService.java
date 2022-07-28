package com.example.springbootdemo.service;

import com.example.springbootdemo.pojo.dto.SysRole;

import java.util.List;

public interface SysRoleService {
    List<SysRole> getAllRoleIncludeUser();
}
