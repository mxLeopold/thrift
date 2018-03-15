package com.sunlands;

import com.sunlands.rpc.web.handler.ApiWebServiceHandler;
import com.sunlands.rpc.web.service.ApiWebService;
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
    public ServletRegistrationBean servletRegistrationBean(TProtocolFactory protocolFactory,
                                                           ApiWebServiceHandler handler) {
        // 在spring boot里当只有一个servlet时，spring boot默认将映射到/*路径。否则bean名称将作为映射路径
        // 参见官网文档 《27.3.1 Servlets, Filters, and listeners》
        ServletRegistrationBean web = new ServletRegistrationBean(
                new TServlet(new ApiWebService.Processor<>(handler), protocolFactory),
                "/web/*");
        web.setName("web");
        return web;
    }

    @Bean
    public TProtocolFactory tProtocolFactory() {
        return new TBinaryProtocol.Factory();
    }
}