package com.example.demo;

import org.flowable.engine.TaskService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class TaskServiceTests {

    @Autowired
    private TaskService taskService;

    @Test
    void contextLoads() {
    }

    @Test
    void createTaskQuery() {
        taskService.createTaskQuery().taskCandidateOrAssigned("userId").list().forEach(task -> System.out.println(task.getName()));
    }


}
