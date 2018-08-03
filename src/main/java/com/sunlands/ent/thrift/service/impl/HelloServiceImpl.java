package com.sunlands.ent.thrift.service.impl;

import com.sunlands.ent.thrift.service.DemoParam;
import com.sunlands.ent.thrift.service.DemoResult;
import com.sunlands.ent.thrift.service.HelloService;
import org.apache.thrift.TException;
import org.springframework.stereotype.Service;


@Service("helloServiceImpl")
public class HelloServiceImpl implements HelloService.Iface {
    @Override
    public String hello(String msg) throws TException {
        return "hello," + msg;
    }

    @Override
    public DemoResult test(DemoParam param) throws TException {
        return new DemoResult("200", param.toString());
    }
}
