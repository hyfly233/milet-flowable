package com.example.springbootdemo.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.springbootdemo.pojo.dto.SysUser;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface SysUserMapper extends BaseMapper<SysUser> {
    List<SysUser> getAllUserIncludeRole();
}