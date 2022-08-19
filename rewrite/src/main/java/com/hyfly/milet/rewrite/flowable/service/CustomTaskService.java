package com.hyfly.milet.rewrite.flowable.service;

public interface CustomTaskService {

    /**
     * 驳回任务
     *
     * @param taskId 任务ID
     * @return 是否成功
     */
    String rejectTask(String taskId);
}
