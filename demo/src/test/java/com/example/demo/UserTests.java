package com.example.demo;

import org.flowable.engine.IdentityService;
import org.flowable.idm.api.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class UserTests {

    @Autowired
    private IdentityService identityService;

    @Test
    void contextLoads() {
    }


    @Test
    void createUser() {
        User user = identityService.newUser("user1");
        user.setFirstName("user1");
        user.setLastName("user1");
        user.setEmail("123@qq.com");
        identityService.saveUser(user);
    }
}
