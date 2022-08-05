package com.hyfly.milet.rewrite.flowable.listener;

import org.apache.commons.collections.CollectionUtils;
import org.flowable.common.engine.api.delegate.event.FlowableEvent;
import org.flowable.common.engine.api.delegate.event.FlowableEventListener;
import org.flowable.common.engine.impl.event.FlowableEntityEventImpl;
import org.flowable.engine.TaskService;
import org.flowable.identitylink.api.IdentityLink;
import org.flowable.task.service.impl.persistence.entity.TaskEntity;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

/**
 * 全局监听 - 工作流代办消息提醒
 */
@Component
public class GlobalTaskCreateListener implements FlowableEventListener {

    private final TaskService taskService;

    public GlobalTaskCreateListener(TaskService taskService) {
        this.taskService = taskService;
    }

    @Override
    public void onEvent(FlowableEvent event) {
        TaskEntity taskEntity = (TaskEntity) ((FlowableEntityEventImpl) event).getEntity();
        String taskId = taskEntity.getId();

        List<IdentityLink> linkList = taskService.getIdentityLinksForTask(taskId);
        if (linkList.isEmpty()) {
            return;
        }

        List<String> userIdList = new ArrayList<>();

        linkList.forEach(identityLink -> {
            String userId = identityLink.getUserId();
            if (userId != null && userId.length() > 0) {
                userIdList.add(userId);
            }
        });

        if (CollectionUtils.isNotEmpty(userIdList)) {
            // TODO 发送提醒消息
            System.out.println("发送提醒消息 userIdList.size() = " + userIdList.size());
        }
    }

    @Override
    public boolean isFailOnException() {
        return false;
    }

    @Override
    public boolean isFireOnTransactionLifecycleEvent() {
        return false;
    }

    @Override
    public String getOnTransaction() {
        return null;
    }
}
