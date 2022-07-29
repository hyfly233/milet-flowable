package com.example.demo;

import org.flowable.engine.HistoryService;
import org.flowable.engine.RepositoryService;
import org.flowable.engine.RuntimeService;
import org.flowable.engine.TaskService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class GatewayTests {

    @Autowired
    private RepositoryService repositoryService;

    @Autowired
    private RuntimeService runtimeService;

    @Autowired
    private TaskService taskService;

    @Autowired
    private HistoryService historyService;

    @Test
    void contextLoads() {
    }

    @Test
    void initProcessInstance() {

    }

    @Test
    void completeTask() {

    }

    // -------------- 并行网关相关 --------------

    // -------------- 排它网关相关 --------------

    // -------------- 包容网关相关 --------------

    // -------------- 事件网关相关 --------------

    // -------------- 边界事件相关 --------------

    // -------------- 中间事件相关 --------------

    // -------------- 子流程相关 --------------
}
