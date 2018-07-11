package com.sunlands.rpc.test.api;

import com.sunlands.rpc.web.coursetemplate.handler.WebCourseTemplateServiceHandler;
import com.sunlands.rpc.web.coursetemplate.service.LastKnowledgeNodeInfo;
import com.sunlands.rpc.web.coursetemplate.service.TemplateUnitInfo;
import com.sunlands.rpc.web.coursetemplate.service.TemplateUnitNodeInfo;
import com.sunlands.rpc.web.coursetemplate.service.WebCourseTemplateService;
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
public class WebCourseTemplateServiceTest {

    @Autowired
    protected TProtocolFactory protocolFactory;

    @LocalServerPort
    protected int port;

    protected WebCourseTemplateService.Client client;

    @Autowired
    private WebCourseTemplateServiceHandler handler;

    @Before
    public void setUp() throws Exception {
        TTransport transport = new THttpClient("http://localhost:" + port + "/web/courseTemplate");
        TProtocol protocol = protocolFactory.getProtocol(transport);
        client = new WebCourseTemplateService.Client(protocol);
    }

    @Test
    public void testRetrieveCourseTemplateInfoById() throws TException {
        DateTime before = DateTime.now();
        List<LastKnowledgeNodeInfo> lastKnowledgeNodeInfo =
                client.retrieveCourseTemplateTreeInfo(71);
        DateTime end = DateTime.now();
        printTimeSpend(before, end, 1);
    }

    @Test
    public void testRetrieveCourseTemplateTeachUnitNodes() throws TException {
        DateTime before = DateTime.now();
        Integer templateId = 36;
        Integer templateUnitId = 124;
        TemplateUnitNodeInfo res =
                client.retrieveTemplateTeachUnitNodeInfo(templateId, templateUnitId);
        DateTime end = DateTime.now();
        printTimeSpend(before, end, 1);
    }

    @Test
    public void testRetrieveTemplateUnitNodeDetailInfo() throws TException {
        DateTime before = DateTime.now();
        Integer templateId = 36;
        List<TemplateUnitInfo> res =
                client.retrieveTemplateUnitNodeDetailInfo(templateId);
        DateTime end = DateTime.now();
        printTimeSpend(before, end, 1);
    }

    private void printTimeSpend(DateTime before, DateTime end, int size) {
        int millis = end.millisOfDay().get() - before.millisOfDay().get();
        System.out.println("总耗时: " + millis + "ms");
        System.out.println("平均耗时: " + (millis / size) + "." + (millis % size) + "ms");
    }
}
