package com.example.demo;

import com.example.demo.utils.RepositoryServiceUtil;
import org.flowable.engine.RepositoryService;
import org.flowable.engine.RuntimeService;
import org.flowable.engine.TaskService;
import org.flowable.idm.api.IdmIdentityService;
import org.flowable.task.api.Task;
import org.flowable.ui.modeler.serviceapi.ModelService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 会签测试
 */
@SpringBootTest
public class CountersignTests {

    private static final String PROCESS_KEY = "CountersignTest";

    @Autowired
    private TaskService taskService;

    @Autowired
    private ModelService modelService;

    @Autowired
    private RuntimeService runtimeService;

    @Autowired
    private RepositoryService repositoryService;

    @Autowired
    private IdmIdentityService idmIdentityService;

    @Test
    void contextLoads() {
    }

    @Test
    void deploy() {
        String modelId = "615257ef-13b8-11ed-8d49-d23c1f5533c2";
        RepositoryServiceUtil.deployByModel(modelId, repositoryService, modelService);
    }

    @Test
    void startPrecess() {
        String userId = "user1";
        String businessKey = "business_countersign_1";

        idmIdentityService.setAuthenticatedUserId(userId);

        Map<String, Object> variables = new HashMap<>(1);
        variables.put("applyUser", userId);

        runtimeService.startProcessInstanceByKey(PROCESS_KEY, businessKey, variables);
    }

    @Test
    void applyUserComplete() {
        String userId = "user1";
        String taskId = "f2e93f68-13c9-11ed-b142-d23c1f5533c2";

        List<String> managerUserIds = new ArrayList<>();
        managerUserIds.add("user10");
        managerUserIds.add("user11");
        managerUserIds.add("user12");

        Task task = taskService.createTaskQuery().taskId(taskId).singleResult();

        if (userId.equals(task.getAssignee())) {
            Map<String, Object> variables = new HashMap<>(1);
            variables.put("managerUserIds", managerUserIds);

            taskService.complete(taskId, variables);
        }
    }

    @Test
    void managerUserComplete() {
//        String userId = "user10";
//        String taskId = "3200d46a-13ca-11ed-bd3f-d23c1f5533c2";

//        String userId = "user11";
//        String taskId = "320170af-13ca-11ed-bd3f-d23c1f5533c2";

        String userId = "user12";
        String taskId = "320170b4-13ca-11ed-bd3f-d23c1f5533c2";

        String comment = "经理审批";

        Task task = taskService.createTaskQuery().taskId(taskId).singleResult();

        if (userId.equals(task.getAssignee())) {
            String processInstanceId = task.getProcessInstanceId();
            taskService.addComment(taskId, processInstanceId, comment);
            taskService.complete(taskId);
        }
    }
}
