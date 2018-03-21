package com.sunlands.rpc.test.web;

import com.sun.tools.corba.se.idl.StringGen;
import com.sunlands.rpc.common.Constant;
import com.sunlands.rpc.web.biz.dao.PaperReportMapper;
import com.sunlands.rpc.web.biz.model.*;
import com.sunlands.rpc.web.biz.service.PaperReportService;
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
import org.springframework.util.CollectionUtils;

import java.util.Arrays;
import java.util.List;

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
    protected PaperReportMapper paperReportMapper;

    @Autowired
    protected PaperReportService paperReportService;


    @LocalServerPort
    protected int port;

    protected com.sunlands.rpc.web.statistics.service.WebStatisticsService.Client client;


    @Before
    public void setUp() throws Exception {
        TTransport transport = new THttpClient("http://localhost:" + port + "/web/statistics");
        TProtocol protocol = protocolFactory.getProtocol(transport);
        client = new com.sunlands.rpc.web.statistics.service.WebStatisticsService.Client(protocol);
    }

    @Test
    public void testNew() {
        String paperCode = "2501";
        String unitIdStr = "167107,1";
//        PaperDTO paperDTO = paperReportMapper.selectPapeByCode(paperCode);
//        org.springframework.util.Assert.notNull(paperDTO, "试卷不存在");
////        Integer paperId = paperDTO.getId();  // 学员参考试卷版本id
//        PaperReportDTO paperReport = paperReportMapper.selectPaperReport(paperDTO.getId(), unitIdStr);
//        if (paperReport != null) {
//            Integer answerNum = paperReport.getAnswerNumber();
//            if (answerNum != null && !answerNum.equals(0)) {
//                paperReport.setAnswerTimeAve(paperReport.getAnswerTime() / answerNum);
//                paperReport.setCorrectAve(paperReport.getCorrect() / answerNum);
//                paperReport.setCorrectPercent((float) paperReport.getCorrect() / (answerNum * paperDTO.getQuestionAmount()));
//            }
//            paperReport.setPaperName(paperDTO.getName());
//            paperReport.setQuestionNum(paperDTO.getQuestionAmount());
//            System.out.println(paperReport);
//        }


//        List<StuAnswerDetailDTO> a = paperReportMapper.getStuAnswerDetails(paperDTO.getId(), unitIdStr);
//        System.out.println(a);

//        List<Integer> questionMainList = paperReportMapper.listRelatedQuestionByPaperId(paperDTO.getId());
//        System.out.println(questionMainList);

//        List<QuestionDetailDTO> questions = paperReportMapper.selectBigQuestionMainByPaperId(paperDTO.getId());
//        if (!CollectionUtils.isEmpty(questions)) {
//            for (QuestionDetailDTO questionDetailDTO : questions) {
//                Integer questionMainId = questionDetailDTO.getQuestionMainId();
//                // 选项
//                if (Constant.CONTENT_TYPE_CHOICE.equals(questionDetailDTO.getContentType())) {
//                    List<OptionDTO> optionDTOS = paperReportMapper.selectOptionsByQuestionId(questionDetailDTO.getQuestionId());
//                    questionDetailDTO.setOptionList(optionDTOS);
//                }
//                // 得分点
//                if (Constant.CONTENT_TYPE_ESSAY.equals(questionDetailDTO.getContentType())) {
//                    List<ScorePointDTO> scorePointDTOS = paperReportMapper.selectScorePointsByQuestionId(questionDetailDTO.getQuestionId());
//                    if (!CollectionUtils.isEmpty(scorePointDTOS)) {
//                        questionDetailDTO.setScorePointList(scorePointDTOS);
//                    }
//                }
//
//            }
//        }
//
//        System.out.println(questions);
//        PaperDetailDTO paperDetailDTO = paperReportService.getPaperDetail(paperCode, unitIdStr);
//        System.out.println(paperDetailDTO);

        List<PaperReportDTO> paperReportDTOS = paperReportService.getPaperReport(paperCode, unitIdStr);
        System.out.println(paperReportDTOS);

    }
}
