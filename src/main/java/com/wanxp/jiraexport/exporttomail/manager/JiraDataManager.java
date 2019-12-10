package com.wanxp.jiraexport.exporttomail.manager;

import com.atlassian.jira.rest.client.api.JiraRestClient;
import com.atlassian.jira.rest.client.api.domain.Issue;
import com.atlassian.jira.rest.client.api.domain.SearchResult;
import io.atlassian.util.concurrent.Promise;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;

/**
 * jira数据管理类
 */
@Component
@Slf4j
public class JiraDataManager {

   @Autowired
    private JiraRestClient jiraRestClient;

    /**
     * 通过jql获取issue列表
     * @param jql
     * @return
     * @throws ExecutionException
     * @throws InterruptedException
     */
    public List<Issue> getIssuesByJql(String jql) throws ExecutionException, InterruptedException {
        Promise<SearchResult> issuePromise = jiraRestClient.getSearchClient().searchJql(jql);
        SearchResult searchResult = issuePromise.get();
        if (searchResult == null) {
            return new ArrayList<>();
        }
        return (List)searchResult.getIssues();
    }

}
