package com.hyfly.milet.rewrite.pojo.vo;

import lombok.Data;

import java.io.Serializable;

@Data
public class TaskQueryParam implements Serializable {

    String taskId;

    String processInstanceId;

    String executionId;

    String businessKey;

    String processName;

    String taskName;

    String starter;

    String assignee;

    String startTime;

    String endTime;

    String createTime;

    String formKey;

    String comment;

    Integer pageSize;

    Integer pageNum;
}