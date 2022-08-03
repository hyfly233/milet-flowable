package com.hyfly.milet.rewrite.flowable.config.custom;

import com.hyfly.milet.rewrite.pojo.dto.SysUser;
import com.hyfly.milet.rewrite.flowable.service.CustomIdentityService;
import com.hyfly.milet.rewrite.utils.FlowableConvertUtils;
import org.flowable.idm.api.User;
import org.flowable.idm.engine.impl.UserQueryImpl;

import java.util.ArrayList;
import java.util.List;

public class CustomUserQueryImpl extends UserQueryImpl {

    private final CustomIdentityService customIdentityService;

    public CustomUserQueryImpl(CustomIdentityService customIdentityService) {
        this.customIdentityService = customIdentityService;
    }

    @Override
    public List<User> list() {
        List<User> list = new ArrayList<>();

        List<SysUser> users = customIdentityService.getUserByUserQuery(this);
        users.forEach(user -> list.add(FlowableConvertUtils.toUserEntity(user)));

        return list;
    }


}