package com.example.demo;

import org.flowable.engine.IdentityService;
import org.flowable.idm.api.Group;
import org.flowable.idm.api.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class IdentityTests {

    @Autowired
    private IdentityService identityService;

    @Test
    void contextLoads() {
    }

    @Test
    void createUser() {
        for (int i = 2; i < 12; i++) {
            User user = identityService.newUser("user" + i);
            user.setFirstName("user" + i);
            user.setLastName("user" + i);
            user.setEmail("123@qq.com");
            identityService.saveUser(user);
        }
    }

    @Test
    void createGroup() {
        for (int i = 2; i < 4; i++) {
            Group group = identityService.newGroup("group" + i);
            group.setName("group" + i);
            group.setType("groupType" + i);
            identityService.saveGroup(group);
        }
    }

    @Test
    void createMembership() {
        for (int i = 1; i < 4; i++) {
            identityService.createMembership("user" + (i + 5), "group" + i);
        }
    }
}
