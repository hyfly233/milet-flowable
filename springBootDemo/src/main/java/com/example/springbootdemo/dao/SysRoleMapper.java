package com.example.springbootdemo.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.springbootdemo.pojo.dto.SysRole;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface SysRoleMapper extends BaseMapper<SysRole> {

    List<SysRole> getSysRoleByUserId(String userId);
}