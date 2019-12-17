package com.wanxp.jiraexport.exporttomail.entity;

import lombok.Data;

import java.util.Date;

@Data
public class JobLog {
    private Date nextFireTime;
    private Date lastFireTime;
}
