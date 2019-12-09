## 功能
定时导出jira数据并生成excel发送至指定邮箱，并对任务队列进行监控
## 要点
* 定时任务
* 异步非阻塞的方式调用第三方接口
* 使用excel模板导出excel
* 发送emal

## 使用了以下组件
* [Official Apache Maven documentation](https://maven.apache.org/guides/index.html)
* [Spring Boot Maven Plugin Reference Guide](https://docs.spring.io/spring-boot/docs/2.2.2.RELEASE/maven-plugin/)
* [Spring Security](https://docs.spring.io/spring-boot/docs/2.2.2.RELEASE/reference/htmlsingle/#boot-features-security)
* [Java Mail Sender](https://docs.spring.io/spring-boot/docs/2.2.2.RELEASE/reference/htmlsingle/#boot-features-email)
* [Spring Configuration Processor](https://docs.spring.io/spring-boot/docs/2.2.2.RELEASE/reference/htmlsingle/#configuration-metadata-annotation-processor)
* [Spring Web](https://docs.spring.io/spring-boot/docs/2.2.2.RELEASE/reference/htmlsingle/#boot-features-developing-web-applications)
* [Spring Data JPA](https://docs.spring.io/spring-boot/docs/2.2.2.RELEASE/reference/htmlsingle/#boot-features-jpa-and-spring-data)
* [Spring Boot DevTools](https://docs.spring.io/spring-boot/docs/2.2.2.RELEASE/reference/htmlsingle/#using-boot-devtools)
* [Thymeleaf](https://docs.spring.io/spring-boot/docs/2.2.2.RELEASE/reference/htmlsingle/#boot-features-spring-mvc-template-engines)
## 参考以下文档
### restTemplate
* [SpringBoot RestTemplate 使用说明](https://my.oschina.net/sdlvzg/blog/1800395)
* [springboot项目间接口调用实现：RestTemplate](https://blog.csdn.net/zhanglf02/article/details/89842372)
* [springboot集成restTemplate实现rest接口调用](https://zhuanlan.zhihu.com/p/87479515)
* [spring boot2 (25)-RestTemplate客户端](https://blog.csdn.net/wangb_java/article/details/79832070)
### jira
#### jira rest java client
* [JIRA REST java client API实际应用](https://yq.aliyun.com/articles/331683)
* [AsynchronousJiraRestClientFactory](https://docs.atlassian.com/jira-rest-java-client/2.0.0-m2/xref/com/atlassian/jira/rest/client/internal/async/AsynchronousJiraRestClientFactory.html)
* [jira-rest-java-client](https://bitbucket.org/atlassian/jira-rest-java-client/src/master/)
* [Examples for AsynchronousJiraRestClientFactory](https://www.programcreek.com/java-api-examples/?api=com.atlassian.jira.rest.client.internal.async.AsynchronousJiraRestClientFactory)
* [connect-java-rest-api-to-jira](https://stackoverflow.com/questions/38639642/connect-java-rest-api-to-jira)
* [JIRA REST Java Client Library](https://ecosystem.atlassian.net/wiki/spaces/JRJC/overview)
* [JIRA REST API Integration](https://www.baeldung.com/jira-rest-api)
* [JIRA REST Java Client Tutorial](https://ecosystem.atlassian.net/wiki/spaces/JRJC/pages/27164680/Tutorial)
* [JIRA REST Java Client Frameworks and tools](https://developer.atlassian.com/cloud/jira/platform/frameworks-and-tools/)
* [atlassian-connect-spring-boot](https://bitbucket.org/atlassian/atlassian-connect-spring-boot/src/master/)
* [atlassian-connect-spring-boot-jira-rest-java-client-example](https://bitbucket.org/epehrson/atlassian-connect-spring-boot-jira-rest-java-client-example/src/master/)
## excel
### jxls
* [Spring Boot 使用JXLS导出Excel](https://www.jianshu.com/p/07c17cd80f57)
* [Spring boot集成jxls实现导出excel功能](https://blog.csdn.net/syilt/article/details/91473055)
* [Getting Started Guide](http://jxls.sourceforge.net/getting_started.html)
## job
### schedule
* [基于Spring Boot 实现定时任务](https://www.tianmaying.com/tutorial/spring-scheduling-task)
### job-monitor
* [spring-boot-in-action](git@github.com:qq1311256696/Spring-Boot-in-Action.git)
* [spring-boot-quartz-demo](git@github.com:javabypatel/spring-boot-quartz-demo.git)