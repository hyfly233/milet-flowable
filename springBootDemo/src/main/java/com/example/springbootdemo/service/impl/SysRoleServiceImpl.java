package com.example.springbootdemo.service.impl;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.extension.service.IService;
import com.example.springbootdemo.pojo.dto.SysRole;
import com.example.springbootdemo.service.SysRoleService;

import java.util.Collection;
import java.util.Map;
import java.util.function.Function;

public class SysRoleServiceImpl implements SysRoleService, IService<SysRole> {
    @Override
    public boolean saveBatch(Collection<SysRole> entityList, int batchSize) {
        return false;
    }

    @Override
    public boolean saveOrUpdateBatch(Collection<SysRole> entityList, int batchSize) {
        return false;
    }

    @Override
    public boolean updateBatchById(Collection<SysRole> entityList, int batchSize) {
        return false;
    }

    @Override
    public boolean saveOrUpdate(SysRole entity) {
        return false;
    }

    @Override
    public SysRole getOne(Wrapper<SysRole> queryWrapper, boolean throwEx) {
        return null;
    }

    @Override
    public Map<String, Object> getMap(Wrapper<SysRole> queryWrapper) {
        return null;
    }

    @Override
    public <V> V getObj(Wrapper<SysRole> queryWrapper, Function<? super Object, V> mapper) {
        return null;
    }

    @Override
    public BaseMapper<SysRole> getBaseMapper() {
        return null;
    }

    @Override
    public Class<SysRole> getEntityClass() {
        return null;
    }
}
