package com.hyfly.milet.rewrite.service;

import com.example.flowable.pojo.dto.SysRole;
import com.example.flowable.pojo.dto.SysUser;

import java.util.List;

public interface CustomIdentityService {

    List<SysRole> getRoleByUserId(String userId);

    SysRole getRoleById(String roleId);

    SysUser getUserById(String userId);
}
