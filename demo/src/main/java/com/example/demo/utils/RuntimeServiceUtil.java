package com.example.demo.utils;

import org.flowable.engine.RuntimeService;
import org.flowable.engine.runtime.ProcessInstance;

import java.util.Map;

public class RuntimeServiceUtil {

    /**
     * 初始化流程实例
     *
     * @param runtimeService       流程运行时服务
     * @param processDefinitionKey 流程定义key
     * @param businessKey          业务key
     */
    public static void initProcessInstance(RuntimeService runtimeService, String processDefinitionKey, String businessKey, Map<String, Object> variables) {
        ProcessInstance processInstance = runtimeService.startProcessInstanceByKey(processDefinitionKey, businessKey, variables);
        System.out.println("流程实例ID：" + processInstance.getId());
        System.out.println("流程定义ID：" + processInstance.getProcessDefinitionId());
        System.out.println("流程实例名称：" + processInstance.getName());
        System.out.println("流程实例key：" + processInstance.getProcessDefinitionKey());
        System.out.println("流程实例版本：" + processInstance.getProcessDefinitionVersion());
        System.out.println("业务key：" + processInstance.getBusinessKey());
    }
}
