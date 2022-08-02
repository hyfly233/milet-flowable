package com.hyfly.milet.rewrite.controller;

import com.hyfly.milet.rewrite.pojo.dto.LeaveProcess.DeptApprovalDto;
import com.hyfly.milet.rewrite.pojo.dto.LeaveProcess.HrApprovalDto;
import com.hyfly.milet.rewrite.pojo.dto.LeaveProcess.LeaveApplyParam;
import com.hyfly.milet.rewrite.pojo.vo.Result;
import com.hyfly.milet.rewrite.service.LeaveProcessService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;

@RestController
@RequestMapping("/leave")
public class LeaveProcessController {

    @Autowired
    private LeaveProcessService leaveProcessService;

    @GetMapping("/list")
    public Result<?> list() {
//        return Result.success(leaveProcessService.list());
        return null;
    }

    /**
     * 发起请假流程
     */
    @PostMapping("/add")
    public Result<?> startLeaveProcess(LeaveApplyParam param) {
        param.setApplyTime(new Date());
        return Result.OK(leaveProcessService.startLeaveProcess(param));
    }

    /**
     * 部门审批
     */
    @PutMapping("/deptGroupApproval")
    public void deptGroupApproval(String taskId, DeptApprovalDto dto) {
        leaveProcessService.doDeptGroupApproval(taskId, dto);
    }

    /**
     * 部门审批
     */
    @PutMapping("/deptUserApproval")
    public void deptUserApproval(String taskId, DeptApprovalDto dto) {
        leaveProcessService.doDeptUserApproval(taskId, dto);
    }

    /**
     * 部门审批
     */
    @PutMapping("/hrApproval")
    public void hrApproval(String taskId, HrApprovalDto dto) {
        leaveProcessService.doHrApproval(taskId, dto);
    }

    @PutMapping("/claimTask")
    public void claimTask(String taskId, String userId) {
        leaveProcessService.claimTask(taskId, userId);
    }
}
