package com.hyfly.milet.rewrite.custom;

import com.example.flowable.pojo.dto.SysUser;
import com.example.flowable.service.CustomIdentityService;
import com.example.flowable.utils.FlowableConvertUtils;
import org.flowable.idm.api.User;
import org.flowable.idm.engine.impl.UserQueryImpl;
import org.flowable.idm.engine.impl.persistence.entity.UserEntity;

import java.util.List;

public class CustomUserQueryImpl extends UserQueryImpl {

    private CustomIdentityService customIdentityService;

    public CustomUserQueryImpl(CustomIdentityService customIdentityService) {
        this.customIdentityService = customIdentityService;
    }

    @Override
    public List<User> list() {

        SysUser user = customIdentityService.getUserById(id);

        UserEntity userEntity = FlowableConvertUtils.toUserEntity(user);

        return List.of(userEntity);
    }
}