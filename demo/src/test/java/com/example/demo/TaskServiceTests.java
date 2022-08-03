package com.example.demo;

import org.flowable.engine.HistoryService;
import org.flowable.engine.TaskService;
import org.flowable.engine.history.HistoricActivityInstance;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class TaskServiceTests {

    @Autowired
    private TaskService taskService;

    @Autowired
    private HistoryService historyService;

    @Test
    void contextLoads() {
    }

    @Test
    void createTaskQuery() {
        taskService.createTaskQuery()
                .taskCandidateOrAssigned("user12")
                .list().forEach(task -> {
            System.out.println("task.getId() = " + task.getId());
            System.out.println("task.getName() = " + task.getName());
            System.out.println("task.getOwner() = " + task.getOwner());
            System.out.println("task.getAssignee() = " + task.getAssignee());
        });
    }

    @Test
    void taskHistory() {
        String taskId = "9ab5a8b3-10a8-11ed-a8a9-d23c1f5533c2";

//        String processInstanceId = taskService.createTaskQuery().taskId(taskId).singleResult().getProcessInstanceId();
        List<HistoricActivityInstance> list = historyService.createHistoricActivityInstanceQuery()
                .processInstanceId("1bbdbcc4-0fb5-11ed-906a-d23c1f5533c2")
                .orderByHistoricActivityInstanceStartTime()
                .asc()
                .list();

        list.forEach(i -> {
            System.out.println("i.getActivityId() = " + i.getActivityId());
            System.out.println("i.getActivityName() = " + i.getActivityName());
            System.out.println("i.getStartTime() = " + i.getStartTime());
            System.out.println("i.getEndTime() = " + i.getEndTime());
            System.out.println("i.getDurationInMillis() = " + i.getDurationInMillis());
            System.out.println("i.getAssignee() = " + i.getAssignee());
            System.out.println("i.getTaskId() = " + i.getTaskId());
            System.out.println("i.getProcessInstanceId() = " + i.getProcessInstanceId());
            System.out.println("i.getProcessDefinitionId() = " + i.getProcessDefinitionId());
            System.out.println(" ------------------ ");
        });
    }

    @Test
    void test() {
        System.out.println(Runtime.getRuntime().availableProcessors());
    }
}
