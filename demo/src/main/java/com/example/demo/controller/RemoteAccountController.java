package com.example.demo.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 登录用户模拟返回
 */
@RestController
@RequestMapping("/modeler/app")
public class RemoteAccountController {
    @RequestMapping(value = "/rest/account")
    public String getAccount() {
        return "{\"id\":\"admin\",\"firstName\":\"BladeX\",\"lastName\":\"Flowable\",\"email\":\"admin@flowable.org\",\"fullName\":\"BladeX Flowable\",\"groups\":[],\"privileges\":[\"access-idm\",\"access-task\",\"access-modeler\",\"access-admin\"]}\n";
    }
}
