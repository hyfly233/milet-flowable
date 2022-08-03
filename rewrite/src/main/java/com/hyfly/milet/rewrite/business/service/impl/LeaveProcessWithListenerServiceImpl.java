package com.hyfly.milet.rewrite.business.service.impl;

import com.hyfly.milet.rewrite.business.dao.LeaveProcessMapper;
import com.hyfly.milet.rewrite.pojo.dto.LeaveProcess.DeptApprovalDto;
import com.hyfly.milet.rewrite.pojo.dto.LeaveProcess.HrApprovalDto;
import com.hyfly.milet.rewrite.pojo.dto.LeaveProcess.LeaveApplyParam;
import com.hyfly.milet.rewrite.pojo.vo.TaskVo;
import com.hyfly.milet.rewrite.business.service.LeaveProcessWithListenerService;
import org.flowable.engine.RuntimeService;
import org.flowable.engine.TaskService;
import org.flowable.idm.api.IdmIdentityService;
import org.flowable.task.api.Task;
import org.flowable.task.api.TaskQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;

@Service
public class LeaveProcessWithListenerServiceImpl implements LeaveProcessWithListenerService {

    private static final String PROCESS_DEFINITION_KEY = "leave_process_listener";

    @Autowired
    private TaskService taskService;

    @Autowired
    private RuntimeService runtimeService;

    @Autowired
    private LeaveProcessMapper leaveProcessMapper;

    @Autowired
    private IdmIdentityService idmIdentityService;

    @Override
    public List<TaskVo> taskList(String userIdOrGroupId) {
        List<TaskVo> taskVoList = new ArrayList<>();
        TaskQuery taskQuery = taskService.createTaskQuery();

        if ("".equals(userIdOrGroupId)) {
            taskQuery = taskQuery.taskCandidateOrAssigned(userIdOrGroupId);
        }

        List<Task> list = taskQuery.list();

        list.forEach(task -> {
            TaskVo vo = new TaskVo();
            vo.setTaskId(task.getId());
            vo.setTaskName(task.getName());
            vo.setAssignee(task.getAssignee());
            vo.setCreateTime(task.getCreateTime());
            vo.setProcessDefinitionId(task.getProcessDefinitionId());
            vo.setProcessInstanceId(task.getProcessInstanceId());
            vo.setExecutionId(task.getExecutionId());
            vo.setTaskDefinitionKey(task.getTaskDefinitionKey());

            taskVoList.add(vo);
        });

        return taskVoList;
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public String startLeaveProcess(LeaveApplyParam param) {

        String uuid = UUID.randomUUID().toString();
        param.setId(uuid);
        leaveProcessMapper.insertLeaveProcess(param);

        idmIdentityService.setAuthenticatedUserId(param.getUserId());

        Map<String, Object> variables = new HashMap<>();
        variables.put("applyUser", param.getUserId());
        variables.put("taskId", uuid);

        if ("group".equalsIgnoreCase(param.getAssigneeType())) {
            variables.put("selectAssigneeType", param.getAssigneeType());
            variables.put("assignDeptGroup", param.getAssigneeDeptGroup());
        } else if ("user".equalsIgnoreCase(param.getAssigneeType())) {
            variables.put("selectAssigneeType", param.getAssigneeType());
            variables.put("assignDeptUser", param.getAssigneeDeptUser());
        }

        runtimeService.startProcessInstanceByKey(PROCESS_DEFINITION_KEY, uuid, variables);

        return null;
    }

    @Override
    public void doDeptGroupApproval(String taskId, DeptApprovalDto dto) {

        Map<String, Object> variables = new HashMap<>(1);
        variables.put("deptAgree", dto.getIsApproval());
        variables.put("assignHrName", dto.getAssigneeHr());

        String processInstanceId = taskService.createTaskQuery().taskId(taskId).singleResult().getProcessInstanceId();

        String comment = dto.getComment();

        if ("".equals(comment)) {
            taskService.addComment(taskId, processInstanceId, comment);
        }

        taskService.complete(taskId, variables);
    }

    @Override
    public void doDeptUserApproval(String taskId, DeptApprovalDto dto) {

        Map<String, Object> variables = new HashMap<>(1);
        variables.put("deptAgree", dto.getIsApproval());
        variables.put("assignHrName", dto.getAssigneeHr());

        String processInstanceId = taskService.createTaskQuery().taskId(taskId).singleResult().getProcessInstanceId();

        String comment = dto.getComment();

        if ("".equals(comment)) {
            taskService.addComment(taskId, processInstanceId, comment);
        }

        taskService.complete(taskId, variables);
    }

    @Override
    public void doHrApproval(String taskId, HrApprovalDto dto) {
        Map<String, Object> variables = new HashMap<>(1);
        variables.put("hrAgree", dto.getIsApproval());

        String processInstanceId = taskService.createTaskQuery().taskId(taskId).singleResult().getProcessInstanceId();

        String comment = dto.getComment();

        if ("".equals(comment)) {
            taskService.addComment(taskId, processInstanceId, comment);
        }

        taskService.complete(taskId, variables);
    }

    @Override
    public void claimTask(String taskId, String userId) {
        taskService.claim(taskId, userId);
    }
}
