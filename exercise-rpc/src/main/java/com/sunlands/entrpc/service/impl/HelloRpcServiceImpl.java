package com.sunlands.entrpc.service.impl;

import com.sunlands.entrpc.service.HelloRpcService;
import com.sunlands.rpc.hello.service.DemoParam;
import com.sunlands.rpc.hello.service.DemoResult;
import org.apache.thrift.TException;
import org.springframework.stereotype.Service;


@Service
public class HelloRpcServiceImpl implements HelloRpcService {
    @Override
    public String hello(String msg) throws TException {
        return "hello," + msg;
    }

    @Override
    public DemoResult test(DemoParam param) throws TException {
        return new DemoResult("200", param.toString());
    }
}
