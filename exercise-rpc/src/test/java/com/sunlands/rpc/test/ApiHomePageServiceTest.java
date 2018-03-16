package com.sunlands.rpc.test;

import com.sunlands.rpc.web.service.WebStatisticsService;
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

    protected WebStatisticsService.Client client;

    @Before
    public void setUp() throws Exception {
        TTransport transport = new THttpClient("http://localhost:" + port + "/web/statistics");
        TProtocol protocol = protocolFactory.getProtocol(transport);
        client = new WebStatisticsService.Client(protocol);
    }
    @Test
    public void testGroupMember() throws Exception {

//        List<Member> members = client.getGroupMemberListByPerson(0, "wangzhuzhu");
//        Assert.assertEquals(2,members.size());
    }
}
