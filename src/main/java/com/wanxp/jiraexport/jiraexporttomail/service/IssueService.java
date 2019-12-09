package com.wanxp.jiraexport.jiraexporttomail.service;

import com.atlassian.jira.rest.client.api.domain.Issue;

import java.util.List;

/**
 * issue服务类 接口
 */
public interface IssueService {
    List<Issue> getIssuesByJql(String jql);
}
