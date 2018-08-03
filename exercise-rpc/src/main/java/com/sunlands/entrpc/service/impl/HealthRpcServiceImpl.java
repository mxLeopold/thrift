package com.sunlands.entrpc.service.impl;

import com.sunlands.entrpc.service.HealthService;
import org.apache.thrift.TException;
import org.springframework.stereotype.Service;

@Service
public class HealthRpcServiceImpl implements HealthService {

    @Override
    public String ping() throws TException {
        return "pong";
    }
}
