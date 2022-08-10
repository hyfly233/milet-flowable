package com.hyfly.milet.rewrite;

import com.hyfly.milet.rewrite.business.service.LeaveProcessService;
import com.hyfly.milet.rewrite.pojo.dto.LeaveProcess.DeptApprovalDto;
import com.hyfly.milet.rewrite.pojo.dto.LeaveProcess.HrApprovalDto;
import com.hyfly.milet.rewrite.pojo.dto.LeaveProcess.LeaveApplyParam;
import org.flowable.engine.RepositoryService;
import org.flowable.engine.repository.ProcessDefinition;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.*;

@SpringBootTest
class LeaveProcessTests {
    @Autowired
    private LeaveProcessService leaveProcessService;

    @Autowired
    private RepositoryService repositoryService;

    @Test
    void contextLoads() {
    }

    @Test
    void startLeaveProcess() {
        LeaveApplyParam param = LeaveApplyParam.builder()
                .userId("4")
                .applyTime(new Date())
                .assigneeType("group")
                .assigneeDeptGroup("1")
                .build();

        leaveProcessService.startLeaveProcess(param);
    }

    @Test
    public void deptGroupApproval() {
        String taskId = "aafa4296-10eb-11ed-a13d-d23c1f5533c2";
        DeptApprovalDto dto = DeptApprovalDto.builder()
                .taskId(taskId)
                .isApproval("true")
                .comment("同意")
                .assigneeHr("3d464b4ea0d2491aab8a7bde74c57e95")
                .build();
        leaveProcessService.doDeptGroupApproval(taskId, dto);
    }

    @Test
    public void deptUserApproval() {
        String taskId = "";
        DeptApprovalDto dto = new DeptApprovalDto();
        leaveProcessService.doDeptUserApproval(taskId, dto);
    }

    @Test
    public void hrApproval() {
        String taskId = "0e18c0b6-10ed-11ed-91b0-d23c1f5533c2";
        HrApprovalDto dto = HrApprovalDto.builder()
                .taskId(taskId)
                .isApproval("true")
                .comment("同意")
                .build();
        leaveProcessService.doHrApproval(taskId, dto);
    }

    @Test
    public void list() {
        String userIdOrGroupId = "3";
        leaveProcessService.taskList(userIdOrGroupId).forEach(i -> {
            if ("指定部门组用户审核".equals(i.getTaskName())) {
                System.out.println(i);
            }

//            if ("人事审核".equals(i.getTaskName())) {
//                System.out.println(i);
//            }
        });
    }

    @Test
    public void claimTask() {
//        String taskId = "aafa4296-10eb-11ed-a13d-d23c1f5533c2";
//        String userId = "f0019fdebedb443c98dcb17d88222c38";

        String taskId = "0e18c0b6-10ed-11ed-91b0-d23c1f5533c2";
        String userId = "f0019fdebedb443c98dcb17d88222c38";


        leaveProcessService.claimTask(taskId, userId);
    }

    @Test
    void processKvList() {
        List<Map<String, String>> list = new ArrayList<>();

        List<ProcessDefinition> processDefinitions = repositoryService.createProcessDefinitionQuery().latestVersion().list();
        processDefinitions.forEach(p -> {
            Map<String, String> map = new HashMap<>(2);
            map.put("key", p.getKey());
            map.put("name", p.getName());
            list.add(map);
        });

        System.out.println(list);
    }
}
