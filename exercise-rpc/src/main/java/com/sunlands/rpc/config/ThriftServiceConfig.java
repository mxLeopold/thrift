package com.sunlands.rpc.config;

import com.sunlands.entrpc.proxy.ThriftServerProxy;
import com.sunlands.entrpc.proxy.ThriftServletProxy;
import com.sunlands.rpc.hello.ThriftSerivceDTO;
import com.sunlands.rpc.hello.handler.HealthServiceHandler;
import com.sunlands.rpc.hello.handler.HelloServiceHandler;
import com.sunlands.rpc.hello.service.HelloService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: maxiao
 * @description:
 * @date: create in 17:47 2018/8/3
 * @modified By:
 * @copyright by sunlands
 */
@Configuration
public class ThriftServiceConfig {

    @Bean
    public ThriftServerProxy helloProxy(@Autowired @Qualifier("helloServiceHandler")HelloServiceHandler helloServiceHandler) {
        ThriftServerProxy helloProxy = new ThriftServerProxy();
        helloProxy.setPort(33201);
        helloProxy.setServiceInterface("com.sunlands.rpc.hello.service.HelloService");
        helloProxy.setServiceImplObject(helloServiceHandler);
        return helloProxy;
    }

    @Bean(name = "helloService")
    public ThriftServletProxy helloService(@Autowired @Qualifier("helloServiceHandler")HelloServiceHandler helloServiceHandler) throws Exception {
        ThriftServletProxy thriftServletProxy = new ThriftServletProxy("com.sunlands.rpc.hello.service.HelloService", helloServiceHandler);
        return thriftServletProxy;
    }

    @Bean
    public ThriftServerProxy healthProxy(@Autowired @Qualifier("healthServiceHandler")HealthServiceHandler healthServiceHandler) {
        ThriftServerProxy helloProxy = new ThriftServerProxy();
        helloProxy.setPort(33202);
        helloProxy.setServiceInterface("com.sunlands.rpc.hello.service.HealthService");
        helloProxy.setServiceImplObject(healthServiceHandler);
        return helloProxy;
    }

    @Bean(name = "healthService")
    public ThriftServletProxy healthService(@Autowired @Qualifier("healthServiceHandler")HealthServiceHandler healthServiceHandler) throws Exception {
        ThriftServletProxy thriftServletProxy = new ThriftServletProxy("com.sunlands.rpc.hello.service.HealthService", healthServiceHandler);
        return thriftServletProxy;
    }

    @Bean
    public List<ThriftServerProxy> thriftServerList(@Autowired @Qualifier("helloProxy") ThriftServerProxy helloProxy,
                                                    @Autowired @Qualifier("healthProxy") ThriftServerProxy healthProxy) {
        List<ThriftServerProxy> thriftServerList = new ArrayList<>();
        thriftServerList.add(helloProxy);
        thriftServerList.add(healthProxy);
        return thriftServerList;
    }
}
