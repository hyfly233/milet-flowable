package com.hyfly.milet.rewrite.business.listener;

import org.flowable.common.engine.api.delegate.Expression;
import org.flowable.engine.delegate.TaskListener;
import org.flowable.task.service.delegate.DelegateTask;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Component
public class FixedValueTestListener implements TaskListener, ApplicationContextAware {

    private static ApplicationContext applicationContext;

    private Expression testFieldName;

    @Override
    public void setApplicationContext(ApplicationContext ac) throws BeansException {
        applicationContext = ac;
    }

    @Override
    public void notify(DelegateTask delegateTask) {

        Map<String, Object> variables = delegateTask.getVariables();

        String value = (String) testFieldName.getValue(delegateTask);

        System.out.println("testFieldName = " + value);

        List<String> list = new ArrayList<>();
        list.add("user10");
        list.add("user11");
        list.add("user12");
        list.add("user13");
        list.add("user14");
        list.add("user15");

        delegateTask.addCandidateUsers(list);

        System.out.println("TaskTestListener.notify()");
    }

}
