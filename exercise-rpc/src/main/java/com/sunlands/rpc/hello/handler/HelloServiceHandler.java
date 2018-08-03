package com.sunlands.rpc.hello.handler;

import com.sunlands.entrpc.service.HelloRpcService;
import com.sunlands.rpc.hello.service.DemoParam;
import com.sunlands.rpc.hello.service.DemoResult;
import com.sunlands.rpc.hello.service.HelloService;
import org.apache.thrift.TException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author: maxiao
 * @description:
 * @date: create in 16:53 2018/8/3
 * @modified By:
 * @copyright by sunlands
 */
@Component
public class HelloServiceHandler implements HelloService.Iface {

    @Autowired
    private HelloRpcService helloService;

    @Override
    public String hello(String msg) throws TException {
        return helloService.hello(msg);
    }

    @Override
    public DemoResult test(DemoParam param) throws TException {
        return helloService.test(param);
    }
}
