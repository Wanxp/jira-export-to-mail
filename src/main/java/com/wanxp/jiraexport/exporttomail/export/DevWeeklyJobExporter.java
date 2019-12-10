package com.wanxp.jiraexport.exporttomail.export;

import com.atlassian.jira.rest.client.api.domain.Issue;
import com.wanxp.jiraexport.exporttomail.model.WeekJobDetail;
import com.wanxp.jiraexport.exporttomail.service.IssueService;
import com.wanxp.jiraexport.exporttomail.util.JxlsTemplate;
import org.joda.time.DateTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;

import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import static com.wanxp.jiraexport.exporttomail.constant.JiraDataConstant.*;

/**
 * issue导出excel
 */
@Component
public class DevWeeklyJobExporter {

    @Autowired
    private IssueService issueService;

    private static final String TEMPLATE_FILE_NAME = "job_weekly_template.xlsx";


    /**
     * 导出
     * @param outputStream
     * @param parameters
     * @throws IOException
     */
    public void export(OutputStream outputStream, Map<String, String> parameters) throws IOException {
        List<WeekJobDetail> currentWeekJobDetails = getCurrentWeekJobDetails(parameters);
        List<WeekJobDetail> nextWeekJobDetails = getNextWeekJobDetails(parameters);
        Map<String, Object> data = new HashMap<>();
        data.put("currentWeekJobs", currentWeekJobDetails);
        data.put("nextWeekJobs", nextWeekJobDetails);
        data.put("dateStart", DateTime.now().toString("yyyy-MM-dd"));
        data.put("dateEnd", DateTime.now().plus(-4).toString("yyyy-MM-dd"));
        JxlsTemplate.processTemplate(TEMPLATE_FILE_NAME, outputStream, data);
    }

    /**
     * 下周数据构建
     * @param parameters
     * @return
     */
    private List<WeekJobDetail> getNextWeekJobDetails(Map<String, String> parameters) {
        String currentJql = parameters.get(CURRENT_DATA_JQL);
        List<Issue> issues = issueService.getIssuesByJql(
                StringUtils.isEmpty(currentJql) ? DEV_LAST_WEEK_HANDLE_ISSUE_DEFAULT : currentJql);
        return convertIssueToWeekJobDetail(issues);
    }

    /**
     * 本周数据构建
     * @param parameters
     * @return
     */
    private List<WeekJobDetail> getCurrentWeekJobDetails(Map<String, String> parameters) {
        String nextJql = parameters.get(NEXT_DATA_JQL);
        List<Issue> issues = issueService.getIssuesByJql(
                StringUtils.isEmpty(nextJql) ? DEV_NEXT_WEEK_HANDLE_ISSUE_DEFALUT : nextJql);
        return convertIssueToWeekJobDetail(issues);
    }

    /**
     * 数据转换issue -> excelData
     * @param issues
     * @return
     */
    private List<WeekJobDetail> convertIssueToWeekJobDetail(List<Issue> issues) {
        if (!CollectionUtils.isEmpty(issues)) {
            return issues.stream().map(issue->{
               WeekJobDetail weekJobDetail = new WeekJobDetail();
               weekJobDetail.setId(issue.getKey());
               weekJobDetail.setTitle(issue.getSummary());
               weekJobDetail.setDateOfHeadLine(issue.getDueDate() != null ? issue.getDueDate().toDate() : null);
               weekJobDetail.setDateOfComplete(issue.getDueDate() != null ? issue.getDueDate().toDate() : null);
               return weekJobDetail;
            }).collect(Collectors.toList());
        }
        return new ArrayList<>();
    }
}
