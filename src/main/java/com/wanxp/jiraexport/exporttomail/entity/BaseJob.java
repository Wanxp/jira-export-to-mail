package com.wanxp.jiraexport.exporttomail.entity;

import lombok.Data;

@Data
public class BaseJob {

    private String name;
    private String groupName;
    private String cron;
    private Integer status;//0 active,1 inactive
    private String jobFullClassName;
    private String springBeanName;
}
