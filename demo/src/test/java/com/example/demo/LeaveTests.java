package com.example.demo;

import com.example.demo.utils.RepositoryServiceUtil;
import com.example.demo.utils.RuntimeServiceUtil;
import org.flowable.engine.IdentityService;
import org.flowable.engine.RepositoryService;
import org.flowable.engine.RuntimeService;
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
}
