package com.wanxp.jiraexport.jiraexporttomail.job;

import com.wanxp.jiraexport.jiraexporttomail.export.DevWeeklyJobExporter;
import com.wanxp.jiraexport.jiraexporttomail.service.IssueService;
import lombok.extern.slf4j.Slf4j;
import org.joda.time.DateTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.io.*;
import java.util.HashMap;

/**
 * Job任务
 */
@Component
@Slf4j
public class SendWorkStatusExcelTask {

    @Autowired
    private IssueService issueService;

    @Autowired
    private DevWeeklyJobExporter devWeeklyJobExporter;

    @Autowired
    private JavaMailSender javaMailSender;

    /**
     * 任务执行体
     */
    @Scheduled(fixedDelay = 10000)
    public void sendWorkStatusExcelTask() {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        try {
            devWeeklyJobExporter.export(byteArrayOutputStream, new HashMap<>());
            sendDevWeeklyJobMail(byteArrayOutputStream);
        } catch (IOException e) {
            log.error(" sendWorkStatusExcelTask ", e);
        } catch (MessagingException e) {
            log.error(" sendWorkStatusExcelTask ", e);
        }
    }

    /**
     * 邮件发送
     * @param os
     * @throws MessagingException
     */
    private void sendDevWeeklyJobMail(ByteArrayOutputStream os) throws MessagingException {
        String fileName = DateTime.now().toString("周报_万旭平_yyyy年MM月dd日");
        MimeMessage mimeMessage = javaMailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(mimeMessage, true);
        helper.setFrom("hughwan@walltechsystem.cn");
        helper.setTo("977741432@qq.com");
        helper.setSubject(fileName);
        helper.setText("Dear All:\n" +
                "    你们好!\n" +
                "    这是我本周的周报和下周计划,在附件中请注意查收.\n" +
                "    如有任何问题,及时联系,谢谢!");
        helper.addAttachment(fileName + ".xlsx", new ByteArrayResource(os.toByteArray()));
        javaMailSender.send(mimeMessage);
    }
}
