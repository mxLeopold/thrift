package com.sunlands;

import com.sunlands.rpc.api.homepage.handler.ApiHomePageServiceHandler;
import com.sunlands.rpc.api.homepage.service.ApiHomePageService;
import com.sunlands.rpc.web.coursetemplate.handler.WebCourseTemplateServiceHandler;
import com.sunlands.rpc.web.coursetemplate.service.WebCourseTemplateService;
import com.sunlands.rpc.web.statistics.handler.WebStatisticsServiceHandler;
import com.sunlands.rpc.web.statistics.service.WebStatisticsService;
import com.ulisesbocchio.jasyptspringboot.annotation.EnableEncryptableProperties;
import org.apache.thrift.protocol.TBinaryProtocol;
import org.apache.thrift.protocol.TProtocolFactory;
import org.apache.thrift.server.TServlet;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@EnableCaching
@EnableEncryptableProperties
public class Application {

    private static final Logger log = LoggerFactory.getLogger(Application.class);

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    @Bean
    public ServletRegistrationBean courseTemplateServletRegistrationBean(TProtocolFactory protocolFactory,
                                                           WebCourseTemplateServiceHandler handler){
        ServletRegistrationBean courseTemplate = new ServletRegistrationBean(
                new TServlet(new WebCourseTemplateService.Processor<>(handler), protocolFactory),
                "/web/courseTemplate/*");
        courseTemplate.setName("courseTemplate");
        return courseTemplate;
    }

    @Bean
    public ServletRegistrationBean statisticsServletRegistrationBean(TProtocolFactory protocolFactory,
                                                           WebStatisticsServiceHandler handler) {
        // 在spring boot里当只有一个servlet时，spring boot默认将映射到/*路径。否则bean名称将作为映射路径
        // 参见官网文档 《27.3.1 Servlets, Filters, and listeners》
        ServletRegistrationBean statistics = new ServletRegistrationBean(
                new TServlet(new WebStatisticsService.Processor<>(handler), protocolFactory),
                "/web/statistics/*");
        statistics.setName("statistics");
        return statistics;
    }

    @Bean
    public ServletRegistrationBean homePageServletRegistrationBean(TProtocolFactory protocolFactory,
                                                           ApiHomePageServiceHandler handler) {
        ServletRegistrationBean homePage = new ServletRegistrationBean(
                new TServlet(new ApiHomePageService.Processor<>(handler), protocolFactory),
                "/api/homePage/*");
        homePage.setName("homePage");
        return homePage;
    }

    @Bean
    public TProtocolFactory tProtocolFactory() {
        return new TBinaryProtocol.Factory();
    }
}