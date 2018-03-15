package com.sunlands.rpc.test;

import com.sunlands.rpc.web.service.ApiWebService;
import org.apache.thrift.protocol.TProtocol;
import org.apache.thrift.protocol.TProtocolFactory;
import org.apache.thrift.transport.THttpClient;
import org.apache.thrift.transport.TTransport;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.embedded.LocalServerPort;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @author wangzhuzhu
 * @date 2018/1/23.
 */
@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@DirtiesContext
public class CommonServiceTest {
    private static final Logger log = LoggerFactory.getLogger(CommonServiceTest.class);

    @Autowired
    protected TProtocolFactory protocolFactory;

    @LocalServerPort
    protected int port;

    protected ApiWebService.Client client;


    @Before
    public void setUp() throws Exception {
        TTransport transport = new THttpClient("http://localhost:" + port + "/common");
        // TTransport transport = new THttpClient("http://172.16.100.194:9093/student");
        // TTransport transport = new  THttpClient("http://172.16.116.136:9094/student");
//         TTransport transport = new THttpClient("http://172.16.116.136:9099/common");
        TProtocol protocol = protocolFactory.getProtocol(transport);
        client = new ApiWebService.Client(protocol);
    }
    @Test
    public void testGroupMember() throws Exception {

//        List<Member> members = client.getGroupMemberListByPerson(0, "wangzhuzhu");
//        Assert.assertEquals(2,members.size());
    }

}
