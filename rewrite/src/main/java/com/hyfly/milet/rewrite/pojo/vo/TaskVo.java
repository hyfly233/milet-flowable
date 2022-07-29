package com.hyfly.milet.rewrite.pojo.vo;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
public class TaskVo implements Serializable {
    private String id;
    private String tenantId;
    private String name;
    private String key;
    private String category;
    private String categoryName;
    private Integer version;
    private String deploymentId;
    private String resourceName;
    private String diagramResourceName;
    private Integer suspensionState;
    private Date deploymentTime;
}
