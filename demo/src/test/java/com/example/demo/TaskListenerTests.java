package com.example.demo;

import com.example.demo.utils.RepositoryServiceUtil;
import org.flowable.engine.RepositoryService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class TaskListenerTests {

    @Autowired
    private RepositoryService repositoryService;

    @Test
    void contextLoads() {
    }

    @Test
    void deployment() {
        RepositoryServiceUtil.deployment(repositoryService, "beanTest.bpmn20.xml");
    }
}
