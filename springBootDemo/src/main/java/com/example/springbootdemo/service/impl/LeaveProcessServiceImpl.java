package com.example.springbootdemo.service.impl;

import com.example.springbootdemo.service.LeaveProcessService;
import org.flowable.engine.TaskService;
import org.flowable.task.api.Task;
import org.flowable.task.api.TaskInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LeaveProcessServiceImpl implements LeaveProcessService {
    @Autowired
    private TaskService taskService;

    @Override
    public List<TaskInfo> taskList() {

        List<Task> list = taskService.createTaskQuery()
                .list();

        return null;
    }
}
