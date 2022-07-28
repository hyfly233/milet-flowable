package com.example.springbootdemo.custom;

import com.example.springbootdemo.service.CustomIdentityService;
import org.flowable.idm.engine.impl.GroupQueryImpl;

public class CustomGroupQueryImpl extends GroupQueryImpl {
    private CustomIdentityService customIdentityService;

    public CustomGroupQueryImpl(CustomIdentityService customIdentityService) {
        this.customIdentityService = customIdentityService;
    }

}
