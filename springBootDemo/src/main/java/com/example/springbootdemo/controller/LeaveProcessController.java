package com.example.springbootdemo.controller;

import com.example.springbootdemo.service.LeaveProcessService;
import org.flowable.task.api.TaskInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/leave")
public class LeaveProcessController {

    @Autowired
    private LeaveProcessService leaveProcessService;

    @GetMapping("/task/list")
    public List<TaskInfo> taskList() {
        return leaveProcessService.taskList();
    }
}
