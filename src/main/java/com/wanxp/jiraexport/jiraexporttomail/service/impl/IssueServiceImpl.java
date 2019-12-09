package com.wanxp.jiraexport.jiraexporttomail.service.impl;

import com.atlassian.jira.rest.client.api.domain.Issue;
import com.wanxp.jiraexport.jiraexporttomail.manager.JiraDataManager;
import com.wanxp.jiraexport.jiraexporttomail.service.IssueService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;

/**
 * issue服务类
 */
@Service
@Slf4j
public class IssueServiceImpl implements IssueService {

    @Autowired
    private JiraDataManager jiraDataManager;

    @Override
    public List<Issue> getIssuesByJql(String username) {
        try {
            return jiraDataManager.getIssuesByJql(username);
        } catch (ExecutionException e) {
            log.error("queryDevLastWeekHandleIssue failed", e);
        } catch (InterruptedException e) {
            log.error("queryDevLastWeekHandleIssue failed", e);
        }
        return new ArrayList<>();
    }
}
