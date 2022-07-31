package com.example.demo;

import com.example.demo.utils.RepositoryServiceUtil;
import com.example.demo.utils.RuntimeServiceUtil;
import org.flowable.engine.IdentityService;
import org.flowable.engine.RepositoryService;
import org.flowable.engine.RuntimeService;
import org.flowable.engine.TaskService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.HashMap;
import java.util.Map;

@SpringBootTest
public class LeaveTests {

    @Autowired
    private RepositoryService repositoryService;

    @Autowired
    private RuntimeService runtimeService;

    @Autowired
    private IdentityService identityService;

    @Autowired
    private TaskService taskService;

    /**
     * 第一步
     * 将 holiday-request 进行部署，在表 act_re_deployment 中查看部署的信息
     */
    @Test
    void deployment() {
        RepositoryServiceUtil.deployment(repositoryService, "Leave.bpmn20.xml");
    }

    @Test
    void startProcess() {
        String businessKey = "business_leave_1";

        Map<String, Object> variables = new HashMap<>(1);
        variables.put("applyUser", "user10");
        variables.put("selectAssigneeType", "group");
        variables.put("assignDeptGroup", "group1");

        identityService.setAuthenticatedUserId("user10");

//        流程实例ID：1bbdbcc4-0fb5-11ed-906a-d23c1f5533c2
//        流程定义ID：leave_process:3:0c8da25d-0fb1-11ed-977a-d23c1f5533c2
//        流程实例名称：null
//        流程实例key：leave_process
//        流程实例版本：3
//        业务key：business_leave_1
        RuntimeServiceUtil.initProcessInstance(runtimeService, "leave_process", businessKey, variables);
    }

    @Test
    void claimTask() {
        taskService.claim("9ab5a8b3-10a8-11ed-a8a9-d23c1f5533c2", "user2");
    }

    @Test
    void assigneeTask() {
        taskService.setAssignee("9ab5a8b3-10a8-11ed-a8a9-d23c1f5533c2", "user3");
    }

    @Test
    void completeTask() {
        String taskId = "9ab5a8b3-10a8-11ed-a8a9-d23c1f5533c2";
        String userId = "user10";
        String comment = "审批结果同意";
        String outcome = "agree";

        Map<String, Object> variables = new HashMap<>(1);
//        variables.put("deptAgree", "true");
//        variables.put("assignHrName", "user2");

        variables.put("hrAgree", "true");

        String processInstanceId = taskService.createTaskQuery().taskId(taskId).singleResult().getProcessInstanceId();
        taskService.addComment(taskId, processInstanceId, comment);
        taskService.complete(taskId, variables);


//        SysUser user = getSysUser();
//        String username = user.getLoginName();
//        taskService.setAssignee(taskId, username);
//        // 查出流程实例id
//        String processInstanceId = taskService.createTaskQuery().taskId(taskId).singleResult().getProcessInstanceId();
//        if (variables == null) {
//            taskService.complete(taskId);
//        } else {
//            // 添加审批意见
//            if (variables.get("comment") != null) {
//                taskService.addComment(taskId, processInstanceId, (String) variables.get("comment"));
//                variables.remove("comment");
//            }
//            taskService.complete(taskId, variables);
//        }
//        return AjaxResult.success();
    }
}
