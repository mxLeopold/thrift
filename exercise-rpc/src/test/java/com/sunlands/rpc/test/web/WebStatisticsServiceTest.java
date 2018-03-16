package com.sunlands.rpc.test.web;

import com.sunlands.rpc.web.biz.dao.QuizzesPaperReportMapper;
import com.sunlands.rpc.web.biz.model.PaperDTO;
import org.apache.thrift.protocol.TProtocol;
import org.apache.thrift.protocol.TProtocolFactory;
import org.apache.thrift.transport.THttpClient;
import org.apache.thrift.transport.TTransport;
import org.junit.Assert;
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
public class WebStatisticsServiceTest {
    private static final Logger log = LoggerFactory.getLogger(WebStatisticsServiceTest.class);

    @Autowired
    protected TProtocolFactory protocolFactory;

    @Autowired
    protected QuizzesPaperReportMapper quizzesPaperReportMapper;


    @LocalServerPort
    protected int port;

    protected com.sunlands.rpc.web.service.WebStatisticsService.Client client;


    @Before
    public void setUp() throws Exception {
        TTransport transport = new THttpClient("http://localhost:" + port + "/web/statistics");
        TProtocol protocol = protocolFactory.getProtocol(transport);
        client = new com.sunlands.rpc.web.service.WebStatisticsService.Client(protocol);
    }

    @Test
    public void testNew() {
        PaperDTO paperDTO = quizzesPaperReportMapper.selectPapeByCode("45");
        Assert.assertNotNull(paperDTO);
    }
}
