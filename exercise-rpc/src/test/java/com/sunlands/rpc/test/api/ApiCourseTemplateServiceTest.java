package com.sunlands.rpc.test.api;

import com.sunlands.rpc.api.coursetemplate.handler.ApiCourseTemplateServiceHandler;
import com.sunlands.rpc.api.coursetemplate.service.ApiCourseTemplateService;
import com.sunlands.rpc.api.coursetemplate.service.UnitNodeInfo;
import org.apache.thrift.TException;
import org.apache.thrift.protocol.TProtocol;
import org.apache.thrift.protocol.TProtocolFactory;
import org.apache.thrift.transport.THttpClient;
import org.apache.thrift.transport.TTransport;
import org.joda.time.DateTime;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.embedded.LocalServerPort;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

/**
 * @author: maxiao
 * @description:
 * @date: create in 16:42 2018/6/26
 * @modified By:
 * @copyright by sunlands
 */
@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@DirtiesContext
public class ApiCourseTemplateServiceTest {

    @Autowired
    protected TProtocolFactory protocolFactory;

    @LocalServerPort
    protected int port;

    protected ApiCourseTemplateService.Client client;

    @Autowired
    private ApiCourseTemplateServiceHandler handler;

    @Before
    public void setUp() throws Exception {
        TTransport transport = new THttpClient("http://localhost:" + port + "/api/courseTemplate");
        TProtocol protocol = protocolFactory.getProtocol(transport);
        client = new ApiCourseTemplateService.Client(protocol);
    }

    @Test
    public void testRetrieveCourseTemplateInfoById() throws TException {
        DateTime before = DateTime.now();
        List<List<UnitNodeInfo>> res = client.retrieveCourseTemplateInfoById(180);
        DateTime end = DateTime.now();
        printTimeSpend(before, end, 1);
    }

    private void printTimeSpend(DateTime before, DateTime end, int size) {
        int millis = end.millisOfDay().get() - before.millisOfDay().get();
        System.out.println("总耗时: " + millis + "ms");
        System.out.println("平均耗时: " + (millis / size) + "." + (millis % size) + "ms");
    }
}
