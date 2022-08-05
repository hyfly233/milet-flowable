package com.hyfly.milet.rewrite.flowable.config;

import com.hyfly.milet.rewrite.flowable.listener.GlobalTaskCreateListener;
import lombok.RequiredArgsConstructor;
import org.flowable.common.engine.api.delegate.event.FlowableEngineEventType;
import org.flowable.common.engine.api.delegate.event.FlowableEventDispatcher;
import org.flowable.spring.SpringProcessEngineConfiguration;
import org.springframework.context.ApplicationListener;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.event.ContextRefreshedEvent;

@Configuration
@RequiredArgsConstructor
public class FlowableGlobalListenerConfig implements ApplicationListener<ContextRefreshedEvent> {

    private final SpringProcessEngineConfiguration configuration;

    private final GlobalTaskCreateListener taskCreateListener;

    @Override
    public void onApplicationEvent(ContextRefreshedEvent event) {
        FlowableEventDispatcher dispatcher = configuration.getEventDispatcher();
        // 任务创建全局监听-待办消息发送
        dispatcher.addEventListener(taskCreateListener, FlowableEngineEventType.TASK_CREATED);
    }
}
