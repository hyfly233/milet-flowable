package com.hyfly.milet.rewrite.pojo.vo;

import lombok.Data;
import lombok.ToString;

import java.io.Serializable;
import java.util.Date;

@Data
@ToString
public class TaskVo implements Serializable {

    String taskId;

    String taskDefinitionKey;

    String processInstanceId;

    String processDefinitionId;

    String executionId;

    String businessKey;

    String processName;

    String taskName;

    String starter;

    String assignee;

    Date startTime;

    Date endTime;

    Date createTime;

    String formKey;

    String comment;

    Integer pageSize;

    Integer pageNum;
}
