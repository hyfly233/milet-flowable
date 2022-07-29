package com.hyfly.milet.rewrite.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.flowable.pojo.dto.SysRole;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface SysRoleMapper extends BaseMapper<SysRole> {

    List<SysRole> getAllRoleIncludeUser();

    List<SysRole> getSysRoleByUserId(String userId);
}