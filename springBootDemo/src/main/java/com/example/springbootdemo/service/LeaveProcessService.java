package com.example.springbootdemo.service;

import org.flowable.task.api.TaskInfo;

import java.util.List;

public interface LeaveProcessService {
    List<TaskInfo> taskList();
}
