package com.hyfly.milet.rewrite.business.service.impl;

import com.hyfly.milet.rewrite.business.service.BeanTestService;
import com.hyfly.milet.rewrite.flowable.service.CustomIdentityService;
import com.hyfly.milet.rewrite.pojo.dto.SysRole;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BeanTestServiceImpl implements BeanTestService {
    @Autowired
    private CustomIdentityService customIdentityService;

    @Override
    public String getName(String name) {
        List<SysRole> role = customIdentityService.getRoleByUserId("1");
        System.out.println(role.size());
        return name;
    }
}
