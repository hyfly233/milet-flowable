package com.example.springbootdemo.service.impl;

import com.example.springbootdemo.service.LeaveProcessService;
import org.flowable.engine.TaskService;
import org.flowable.idm.api.IdmIdentityService;
import org.flowable.task.api.Task;
import org.flowable.task.api.TaskInfo;
import org.flowable.task.api.TaskQuery;
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

        TaskQuery taskQuery = taskService.createTaskQuery();

        taskQuery = taskQuery.taskCandidateUser("userId");

        List<Task> list = taskQuery.list();

        list.forEach(task -> {
            System.out.println(task.getName());
            System.out.println(task.getId());
            System.out.println(task.getAssignee());
            System.out.println(" ------------ ");
        });

//        UserQuery userQuery = idmIdentityService.createUserQuery();
//
//        userQuery = userQuery.userId("123");
//
//        userQuery.list();

        return null;
    }
}
