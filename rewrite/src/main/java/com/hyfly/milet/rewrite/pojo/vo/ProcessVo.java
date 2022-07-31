package com.hyfly.milet.rewrite.pojo.vo;

import lombok.Data;

import java.io.Serializable;

@Data
public class ProcessVo implements Serializable {
    private String deploymentId;

    private String id;

    private String name;

    private String key;

    private String diagramResourceName;

    private String resourceName;
}