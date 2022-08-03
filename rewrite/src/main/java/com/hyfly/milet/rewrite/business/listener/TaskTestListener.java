package com.hyfly.milet.rewrite.business.listener;

import com.hyfly.milet.rewrite.flowable.service.CustomIdentityService;
import com.hyfly.milet.rewrite.pojo.dto.SysRole;
import org.flowable.engine.TaskService;
import org.flowable.engine.delegate.TaskListener;
import org.flowable.task.api.Task;
import org.flowable.task.service.delegate.DelegateTask;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Component
public class TaskTestListener implements TaskListener, ApplicationContextAware {

    private static ApplicationContext applicationContext;

    private CustomIdentityService customIdentityService;

    private TaskService taskService;

    @Override
    public void setApplicationContext(ApplicationContext ac) throws BeansException {
        applicationContext = ac;
    }

    @Override
    public void notify(DelegateTask delegateTask) {

        if (this.taskService == null || this.customIdentityService == null) {
            init();
        }

        List<Task> tasks = taskService.createTaskQuery().list();

        List<SysRole> roleList = customIdentityService.getRoleByUserId("1");

        Map<String, Object> variables = delegateTask.getVariables();

        String type = (String) variables.get("selectSuperiorApprovalType");

        if ("user/dept".equals(type)) {
            List<String> list = new ArrayList<>();
            list.add("user10");
            list.add("user11");
            list.add("user12");
            list.add("user13");
            list.add("user14");
            list.add("user15");

            delegateTask.addCandidateUsers(list);
            System.out.println("delegateTask.addCandidateUsers(list)");
        }

        System.out.println("TaskTestListener.notify()");
    }

    private void init() {
        this.customIdentityService = applicationContext.getBean(CustomIdentityService.class);
        this.taskService = applicationContext.getBean(TaskService.class);
    }
}
