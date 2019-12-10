package com.wanxp.jiraexport.exporttomail.helper;

import com.atlassian.jira.rest.client.api.domain.Issue;
import org.springframework.util.StringUtils;

public class IssueHelper {

    /**
     * 获取完成率
     * @param issue
     * @return
     */
    public String getCompleteRate(Issue issue) {
        if (issue == null || issue.getStatus() == null || StringUtils.isEmpty(issue.getStatus().getName()))
            return "0%";
        return "";
    }
}
