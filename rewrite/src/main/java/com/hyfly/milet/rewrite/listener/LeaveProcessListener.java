package com.hyfly.milet.rewrite.listener;

import lombok.extern.slf4j.Slf4j;
import org.flowable.engine.delegate.TaskListener;
import org.flowable.task.service.delegate.DelegateTask;

/**
 * 仅供 LeaveProcessWithListener 使用
 */
@Slf4j
public class LeaveProcessListener
//        implements TaskListener
{
//    @Override
//    public void notify(DelegateTask delegateTask) {
//        log.info(" ---- LeaveProcessListener notify executed ---- ");
//        log.info("delegateTask.getName() = {}", delegateTask.getName());
//        log.info("delegateTask.getAssignee() = {}", delegateTask.getAssignee());
//        log.info("delegateTask.getEventName() = {}", delegateTask.getEventName());
//        log.info("delegateTask.getExecutionId() = {}", delegateTask.getExecutionId());
//
//        log.info("delegateTask.getTaskDefinitionKey() = {}", delegateTask.getTaskDefinitionKey());
//        log.info("delegateTask.getProcessInstanceId() = {}", delegateTask.getProcessInstanceId());
//        log.info("delegateTask.getProcessDefinitionId() = {}", delegateTask.getProcessDefinitionId());
//
//        log.error("演示事件执行顺序===========================================================");
//
//        String eventName = delegateTask.getEventName();
//
//        if ("create".endsWith(eventName)) {
//            log.info("创建：create=========");
//        } else if ("assignment".endsWith(eventName)) {
//            log.info("指派：assignment========");
//        } else if ("complete".endsWith(eventName)) {
//            log.info("完成：complete===========");
//        } else if ("delete".endsWith(eventName)) {
//            log.info("销毁：delete=============");
//        }
//
//        log.info(" ---- LeaveProcessListener notify end ---- ");
//    }
}
