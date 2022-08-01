package com.hyfly.milet.rewrite.service;

import com.hyfly.milet.rewrite.pojo.dto.LeaveProcess.DeptApprovalDto;
import com.hyfly.milet.rewrite.pojo.dto.LeaveProcess.HrApprovalDto;
import com.hyfly.milet.rewrite.pojo.dto.LeaveProcess.LeaveApplyParam;
import com.hyfly.milet.rewrite.pojo.vo.TaskVo;

import java.util.List;

public interface LeaveProcessWithListenerService {
    List<TaskVo> taskList(String userIdOrGroupId);

    String startLeaveProcess(LeaveApplyParam param);

    void doDeptGroupApproval(String taskId, DeptApprovalDto dto);

    void doDeptUserApproval(String taskId, DeptApprovalDto dto);

    void doHrApproval(String taskId, HrApprovalDto dto);

    void claimTask(String taskId, String userId);
}
