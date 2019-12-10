package com.wanxp.jiraexport.exporttomail.constant;

/**
 * jira数据相关类
 */
public class JiraDataConstant {
    /**
     * 本周工作jql 参数名
     */
    public static final String CURRENT_DATA_JQL = "currentDataJql";
    /**
     * 下周工作jql 参数名
     */
    public static final String NEXT_DATA_JQL = "nextDataJql";
    /**
     * 本周工作默认jql
     */
    public static final String DEV_LAST_WEEK_HANDLE_ISSUE_DEFAULT = "status changed after -1w by currentUser()";
    /**
     * 本周工作默认jql
     */
    public static final String DEV_NEXT_WEEK_HANDLE_ISSUE_DEFALUT = "assignee = currentUser() AND resolution = Unresolved order by updated DESC";

}
