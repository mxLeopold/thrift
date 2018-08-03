package com.sunlands.rpc.hello.handler;

import com.sunlands.rpc.hello.service.HealthService;
import org.apache.thrift.TException;
import org.springframework.stereotype.Component;

/**
 * @author: maxiao
 * @description:
 * @date: create in 16:54 2018/8/3
 * @modified By:
 * @copyright by sunlands
 */
@Component
public class HealthServiceHandler implements HealthService.Iface {
    @Override
    public String ping() throws TException {
        return null;
    }
}
