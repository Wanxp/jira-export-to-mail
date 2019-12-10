package com.wanxp.jiraexport.exporttomail.model;

import lombok.Data;

import java.util.Date;

/**
 * excelData模型
 */
@Data
public class WeekJobDetail {
    private String id;
    private String title;
    private Integer completeRate;
    private Date dateOfHeadLine;
    private Date dateOfComplete;
    private String result;
    private String risk;
    private String nextJob;
    private String remark;
}
