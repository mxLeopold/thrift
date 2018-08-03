package com.sunlands.entrpc.service;

import org.apache.thrift.TException;

/**
 * @author: maxiao
 * @description:
 * @date: create in 16:50 2018/8/3
 * @modified By:
 * @copyright by sunlands
 */
public interface HealthService {

    String ping() throws TException;

}
