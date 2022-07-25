package com.example.springbootdemo;

import org.flowable.common.engine.api.FlowableException;
import org.flowable.engine.HistoryService;
import org.flowable.engine.RepositoryService;
import org.flowable.engine.RuntimeService;
import org.flowable.engine.TaskService;
import org.flowable.engine.repository.Deployment;
import org.flowable.engine.runtime.ProcessInstance;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class ProcessesTests {

    @Autowired
    private RepositoryService repositoryService;

    @Autowired
    private RuntimeService runtimeService;

    @Autowired
    private TaskService taskService;

    @Autowired
    private HistoryService historyService;

    @Test
    void contextLoads() {
    }

    // -------------- 流程部署相关 --------------

    /**
     * 第一步
     * 将 holiday-request 进行部署，在表 act_re_deployment 中查看部署的信息
     */
    @Test
    void deployment() {
        String filePath = "processes";
//        String fileName = "holiday-request.bpmn20.xml";
        String fileName = "报销审核.bpmn20.xml";

        Deployment deploy = repositoryService.createDeployment()
                .addClasspathResource(filePath + "/" + fileName)
                .deploy();

        // f3ff45c2-0bc1-11ed-818f-d03c1f5533c6
        System.out.println(deploy.getId());
        System.out.println(deploy.getName());
    }

    // -------------- 流程实例的定义消息相关 --------------

    /**
     * 第二步
     * 获取流程实例的定义信息
     */
    @Test
    void getProcessDefinition() {
        repositoryService.createDeploymentQuery().list().forEach(i -> {
            System.out.println("Id: " + i.getId());
            System.out.println("Name: " + i.getName());
        });
    }

    /**
     * 删除流程实例的定义信息
     */
    @Test
    void deleteProcessDefinition() {
        repositoryService.deleteDeployment("deploymentId", true);
    }

    // -------------- 流程实例相关 --------------

    /**
     * 第三步
     * 初始化 holiday-request 流程实例，在表 act_ru_execution 中查看流程实例的信息
     * <p>
     * 大致业务流程如下：
     * 1、用户根据 holiday-request 的申请页面填写表单，fromData
     * 2、将 fromData 数据写入业务表，如 t_holiday_request，返回业务表的主键 id（businessKey：holiday-request-1）
     * 3、把业务表的主键 id 写入流程实例的变量，变量名为 businessKey，及将业务与 flowable 的流程实例关联起来
     */
    @Test
    void initProcessInstance() {
        // 对应 holiday-request.bpmn20.xml 中的 process 标签的 id 属性
        String processDefinitionKey = "reimbursementAudit";
        // 每个流程实例的 id 唯一
        String businessKey = "reimbursementAudit-1";

        ProcessInstance processInstance = runtimeService.startProcessInstanceByKey(processDefinitionKey, businessKey);

        // ad3751d4-0bc5-11ed-bdd7-d03c1f5533c6
        System.out.println(processInstance.getId());
    }

    @Test
    void getProcessInstance() {
        runtimeService.createProcessInstanceQuery()
                .list()
                .forEach(i -> {
                    System.out.println("ProcessInstanceId: " + i.getProcessInstanceId());
                    System.out.println("ProcessDefinitionId: " + i.getProcessDefinitionId());
                    System.out.println("ProcessDefinitionName: " + i.getProcessDefinitionName());
                    System.out.println("isEnded: " + i.isEnded());
                    System.out.println("isSuspended: " + i.isSuspended());
                    System.out.println("------------------------");
                });
    }

    /**
     * 挂起流程实例，已挂起的流程实例不能再次挂起，会抛异常
     */
    @Test
    void suspendProcessInstance() {
        try {
            runtimeService.suspendProcessInstanceById("d9f617a6-0bf5-11ed-aebf-d23c1f5533c2");
        } catch (FlowableException e) {
            e.printStackTrace();
        }
    }

    /**
     * 激活流程实例，已激活的流程实例不能再次激活，会抛异常
     */
    @Test
    void activateProcessInstance() {
        try {
            runtimeService.activateProcessInstanceById("d9f617a6-0bf5-11ed-aebf-d23c1f5533c2");
        } catch (FlowableException e) {
            e.printStackTrace();
        }
    }

    /**
     * 删除流程实例
     */
    @Test
    void deleteProcessInstance() {
        runtimeService.deleteProcessInstance("processInstanceId", "流程实例删除原因");
    }

    // -------------- 任务处理相关 --------------

    /**
     * 获取任务信息
     */
    @Test
    void getTasks() {
        taskService.createTaskQuery()
//                .taskAssignee("wukong")
                .list().forEach(i -> {
            System.out.println("TaskId: " + i.getId());
            System.out.println("TaskName: " + i.getName());
            System.out.println("TaskAssignee: " + i.getAssignee());
            System.out.println("isSuspended: " + i.isSuspended());
            System.out.println("------------------------");
        });
    }

    /**
     * 完成任务
     */
    @Test
    void completeTask() {
        taskService.complete("0daa903b-0bf8-11ed-a2bc-d23c1f5533c2");
    }

    /**
     * 认领任务
     */
    @Test
    void claimTask() {
        taskService.claim("taskId", "userId");

        // 归还任务
        taskService.claim("taskId", "null");
    }

    // -------------- 历史任务相关 --------------

    @Test
    void getHistoryTaskInstance() {
        historyService.createHistoricTaskInstanceQuery()
                .orderByHistoricTaskInstanceEndTime().asc()
//                .taskAssignee("bajie")
                .list()
                .forEach(i -> {
                    System.out.println("Id: " + i.getId());
                    System.out.println("Name: " + i.getName());
                    System.out.println("Assignee: " + i.getAssignee());
                });
    }
}
