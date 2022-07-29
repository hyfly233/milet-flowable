package com.hyfly.milet.rewrite.service;

import com.example.flowable.pojo.dto.SysRole;

import java.util.List;

public interface SysRoleService {
    List<SysRole> getAllRoleIncludeUser();
}
