package com.hyfly.milet.rewrite.config.custom;

import com.hyfly.milet.rewrite.pojo.dto.SysRole;
import com.hyfly.milet.rewrite.service.CustomIdentityService;
import com.hyfly.milet.rewrite.utils.FlowableConvertUtils;
import org.flowable.idm.api.Group;
import org.flowable.idm.engine.impl.GroupQueryImpl;

import java.util.ArrayList;
import java.util.List;

public class CustomGroupQueryImpl extends GroupQueryImpl {
    private final CustomIdentityService customIdentityService;

    public CustomGroupQueryImpl(CustomIdentityService customIdentityService) {
        this.customIdentityService = customIdentityService;
    }

    @Override
    public List<Group> list() {
        List<Group> list = new ArrayList<>();

        List<SysRole> roles = customIdentityService.selectSysRoleByGroupQuery(this);
        roles.forEach(role -> list.add(FlowableConvertUtils.toGroupEntity(role)));

        return list;
    }
}