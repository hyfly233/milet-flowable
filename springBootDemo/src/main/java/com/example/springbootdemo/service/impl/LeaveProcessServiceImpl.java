package com.example.springbootdemo.service.impl;

import com.example.springbootdemo.service.LeaveProcessService;
import org.flowable.engine.TaskService;
import org.flowable.idm.api.IdmIdentityService;
import org.flowable.idm.api.UserQuery;
import org.flowable.task.api.TaskInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LeaveProcessServiceImpl implements LeaveProcessService {
    @Autowired
    private TaskService taskService;

    @Autowired
    private IdmIdentityService idmIdentityService;

    @Override
    public List<TaskInfo> taskList() {

        UserQuery userQuery = idmIdentityService.createUserQuery();

        userQuery = userQuery.userId("123");

        userQuery.list();

        return null;
    }
}
