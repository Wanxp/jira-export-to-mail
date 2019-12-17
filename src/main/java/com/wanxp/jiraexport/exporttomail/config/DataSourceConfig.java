package com.wanxp.jiraexport.exporttomail.config;

import com.zaxxer.hikari.HikariDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.jdbc.DataSourceProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

@Configuration
public class DataSourceConfig {

    @Autowired
    private DataSourceProperties  dataSourceProperties;

    @Bean
    public DataSource dataSource() {
        return DataSourceBuilder.create().url("jdbc:mysql://127.0.0.1:3306/jira_export_job?setUnicode=true&characterEncoding=utf8")
                .username("root")
                .password("0001")
                .driverClassName("com.mysql.jdbc.Driver")
                .type(HikariDataSource.class)
                .build();
    }

}
