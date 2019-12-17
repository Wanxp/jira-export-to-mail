package com.wanxp.jiraexport.exporttomail;

import com.wanxp.jiraexport.exporttomail.properties.JiraProperties;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

@SpringBootApplication
public class JiraExportToMailApplication {

    public static void main(String[] args) {
        SpringApplication.run(JiraExportToMailApplication.class, args);
    }

}
