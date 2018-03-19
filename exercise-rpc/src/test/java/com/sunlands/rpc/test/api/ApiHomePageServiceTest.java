package com.sunlands.rpc.test.api;

import com.sunlands.rpc.api.homepage.handler.ApiHomePageServiceHandler;
import com.sunlands.rpc.api.homepage.service.ApiHomePageService;
import com.sunlands.rpc.web.statistics.service.WebStatisticsService;
import org.apache.thrift.TException;
import org.apache.thrift.protocol.TProtocol;
import org.apache.thrift.protocol.TProtocolFactory;
import org.apache.thrift.transport.THttpClient;
import org.apache.thrift.transport.TTransport;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.embedded.LocalServerPort;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * <p>Title:</p>
 * <p>Description:</p>
 *
 * @author <a href="mailto:yinhang89@sunlands.com">尹行</a>
 * @date 2018年03月16日
 * @since v1.0
 */
@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@DirtiesContext
public class ApiHomePageServiceTest {

    @Autowired
    protected TProtocolFactory protocolFactory;

    @LocalServerPort
    protected int port;

    protected ApiHomePageService.Client client;

    @Autowired
    private ApiHomePageServiceHandler handler;

    @Before
    public void setUp() throws Exception {
        TTransport transport = new THttpClient("http://localhost:" + port + "/api/homePage");
        TProtocol protocol = protocolFactory.getProtocol(transport);
        client = new ApiHomePageService.Client(protocol);
    }
    @Test
    public void testGroupMember() throws Exception {

//        List<Member> members = client.getGroupMemberListByPerson(0, "wangzhuzhu");
//        Assert.assertEquals(2,members.size());
    }

    @Test
    public void testIsDailyIntelligentExerciseDone() throws TException {
        int done = client.isDailyIntelligentExerciseDone(1612069);
        System.out.println(done == 0 ? "未完成" : "完成");
    }
}
