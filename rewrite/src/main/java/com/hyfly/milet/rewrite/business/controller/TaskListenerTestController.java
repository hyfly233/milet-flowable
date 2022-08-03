package com.hyfly.milet.rewrite.business.controller;

import org.flowable.engine.RuntimeService;
import org.flowable.engine.TaskService;
import org.flowable.idm.api.IdmIdentityService;
import org.flowable.task.api.Task;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

@RestController
@RequestMapping("/taskListener")
public class TaskListenerTestController {

    private static final String PROCESS_DEFINITION_KEY = "taskTest";

    @Autowired
    private RuntimeService runtimeService;

    @Autowired
    private IdmIdentityService idmIdentityService;

    @Autowired
    private TaskService taskService;

    @GetMapping("/list")
    public String list() {
        taskService.createTaskQuery()
//                .taskCandidateOrAssigned("user3")
                .list().forEach(task -> {
            System.out.println("task.getId() = " + task.getId());
            System.out.println("task.getName() = " + task.getName());
            System.out.println("task.getOwner() = " + task.getOwner());
            System.out.println("task.getAssignee() = " + task.getAssignee());
        });
        return "taskListener";
    }

    @PostMapping("/start/{userId}")
    public String start(@PathVariable("userId") String userId) {

        String uuid = "start:" + UUID.randomUUID();

        idmIdentityService.setAuthenticatedUserId(uuid);

        Map<String, Object> variables = new HashMap<>(1);
        variables.put("applyUser", userId);

        runtimeService.startProcessInstanceByKey(PROCESS_DEFINITION_KEY, uuid, variables);

        return "start";
    }

    @PostMapping("/{userId}/fillIn/{taskId}")
    public String fillIn(@PathVariable("userId") String userId, @PathVariable("taskId") String taskId) {

        String comment = "申请信息填写";

        Map<String, Object> variables = new HashMap<>(1);
        variables.put("selectSuperiorApprovalType", "user/dept");

        Task task = taskService.createTaskQuery().taskId(taskId).singleResult();

        if (userId.equals(task.getAssignee())) {
            String processInstanceId = task.getProcessInstanceId();
            taskService.addComment(taskId, processInstanceId, comment);
            taskService.complete(taskId, variables);
        }

        return "travelReimbursement";
    }

    @PutMapping("/manager/{userId}/claim/{taskId}")
    public String managerClaim(@PathVariable("userId") String userId, @PathVariable("taskId") String taskId) {

        taskService.createTaskQuery().taskCandidateOrAssigned(userId).list()
                .stream()
                .filter(t -> taskId.equals(t.getId()))
                .findFirst()
                .ifPresent(task -> taskService.claim(taskId, userId));

        return "manager";
    }

    @PostMapping("/manager/{userId}/complete/{taskId}")
    public String manager(@PathVariable("taskId") String taskId) {
        String comment = "经理审批";
        Map<String, Object> variables = new HashMap<>(1);
        variables.put("managerAgree", "true");
        taskService.addComment(taskId, taskService.createTaskQuery().taskId(taskId).singleResult().getProcessInstanceId(), comment);
        taskService.complete(taskId, variables);
        return "manager";
    }
}
