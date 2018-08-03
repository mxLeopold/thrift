package com.sunlands.entrpc.service;

import com.sunlands.rpc.hello.service.DemoParam;
import com.sunlands.rpc.hello.service.DemoResult;
import org.apache.thrift.TException;

/**
 * @author: maxiao
 * @description:
 * @date: create in 16:50 2018/8/3
 * @modified By:
 * @copyright by sunlands
 */
public interface HelloRpcService {

    String hello(String msg) throws TException;

    DemoResult test(DemoParam param) throws TException;
}
