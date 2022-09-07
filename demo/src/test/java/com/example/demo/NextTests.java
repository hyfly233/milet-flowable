package com.example.demo;

import org.flowable.bpmn.model.*;
import org.flowable.engine.RepositoryService;
import org.flowable.engine.RuntimeService;
import org.flowable.engine.TaskService;
import org.flowable.task.api.Task;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@SpringBootTest
public class NextTests {

    public static final String PREFIX = "${";
    public static final String SUFFIX = "}";

    @Autowired
    private RuntimeService runtimeService;

    @Autowired
    private TaskService taskService;

    @Autowired
    private RepositoryService repositoryService;

    @Test
    void test() {

        String taskId = "ffd81c03-2475-11ed-9bc1-d03c1f5533c6";

        Set<String> expressionSet = new HashSet<>();

        Task task = taskService.createTaskQuery().taskId(taskId).singleResult();

        String processInstanceId = task.getProcessInstanceId();

        String processDefinitionId = runtimeService.createProcessInstanceQuery().processInstanceId(processInstanceId).singleResult().getProcessDefinitionId();

        BpmnModel bpmnModel = repositoryService.getBpmnModel(processDefinitionId);
        FlowNode currentFlowNode = (FlowNode) bpmnModel.getFlowElement(task.getTaskDefinitionKey());

//        System.out.println("当前节点Id " + currentFlowNode.getId());
//        System.out.println("当前节点名称 " + currentFlowNode.getName());

        List<SequenceFlow> outgoingFlows = currentFlowNode.getOutgoingFlows();

        for (SequenceFlow outgoingFlow : outgoingFlows) {

            FlowElement targetFlowElement = outgoingFlow.getTargetFlowElement();

            if (targetFlowElement instanceof ExclusiveGateway) {
//                System.out.println("targetFlowElement is exclusiveGateway");

                List<SequenceFlow> exclusiveGatewayOutgoingFlows = ((ExclusiveGateway) targetFlowElement).getOutgoingFlows();

                for (SequenceFlow flow : exclusiveGatewayOutgoingFlows) {
                    String expression = flow.getConditionExpression();
                    System.out.println(expression);

                    if (expression.contains(PREFIX) && expression.contains("==")) {
                        String substring = expression.substring(2, expression.indexOf("==")).trim();
                        System.out.println("substring => " + substring);
                        expressionSet.add(substring);
                    }
                }
            }
        }

        List<String> strings = new ArrayList<>(expressionSet);
        System.out.println(strings);
    }
}
