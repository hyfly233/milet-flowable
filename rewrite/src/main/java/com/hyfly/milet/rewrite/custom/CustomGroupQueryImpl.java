package com.hyfly.milet.rewrite.custom;

import com.example.flowable.service.CustomIdentityService;
import org.flowable.idm.engine.impl.GroupQueryImpl;

public class CustomGroupQueryImpl extends GroupQueryImpl {
    private CustomIdentityService customIdentityService;

    public CustomGroupQueryImpl(CustomIdentityService customIdentityService) {
        this.customIdentityService = customIdentityService;
    }

}
