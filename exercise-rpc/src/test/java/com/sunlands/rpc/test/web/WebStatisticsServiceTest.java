package com.sunlands.rpc.test.web;

import com.sunlands.rpc.web.biz.dao.PaperReportMapper;
import com.sunlands.rpc.web.biz.model.*;
import com.sunlands.rpc.web.biz.service.PaperReportService;
import com.sunlands.rpc.web.statistics.handler.WebStatisticsServiceHandler;
import com.sunlands.rpc.web.statistics.service.StuAnswerResult;
import com.sunlands.rpc.web.statistics.service.WorkPaperReport;
import org.apache.thrift.protocol.TProtocolFactory;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.util.CollectionUtils;

import java.math.BigDecimal;
import java.text.DecimalFormat;
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


    @Autowired
    protected WebStatisticsServiceHandler webStatisticsServiceHandler;

    @Test
    public void testNew() {
        String paperCode = "2536";
        String unitIdStr = "1579208,1";
        PaperDTO paperDTO = paperReportMapper.selectPaperByCode(paperCode);
        org.springframework.util.Assert.notNull(paperDTO, "试卷不存在");
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

//        List<WorkPaperReportDTO> paperReportDTOS = paperReportService.getPaperReport(paperCode, unitIdStr);
//        System.out.println(paperReportDTOS);

//        WorkPaperReportListDTO workPaperReportListDTO = new WorkPaperReportListDTO();
//        workPaperReportListDTO.setField1("167107,1");
//        workPaperReportListDTO.setWorkGroupId("2501");
//        paperReportService.selectWorkPaperReport(workPaperReportListDTO);
    }


    @Test
    public void test() {
        String paperCode = "2527";
        String unitIdStr = "352923";
        PaperDTO paperDTO = paperReportMapper.selectPaperByCode(paperCode);
        org.springframework.util.Assert.notNull(paperDTO, "试卷不存在");

        List<TikuUserRecordDTO> tikuUserRecordDTOS = paperReportMapper.selectUserRecord(paperDTO.getId(), unitIdStr);
        if (!CollectionUtils.isEmpty(tikuUserRecordDTOS)) {
            for (TikuUserRecordDTO recordDTO : tikuUserRecordDTOS) {
                List<TikuUserQuestionDTO> tikuUserQuestionDTOS = paperReportMapper.selectUserQuestion(getTableNameIndex(recordDTO.getStuId()), recordDTO.getId());
            }
        }
    }

    private String getTableNameIndex(Integer studentId) {
        org.springframework.util.Assert.notNull(studentId);
        return String.format("%02d", studentId % 100);
    }

    @Test
    public void testStuAnswerResult() {
        StuAnswerResult stuAnswerResult = new StuAnswerResult();
        try {
            stuAnswerResult  = webStatisticsServiceHandler.getStuAnswerResult(stuAnswerResult);

        } catch (Exception e) {
        }

        System.out.println(stuAnswerResult);

    }

    @Test
    public void testStuAnswerDetails() {
        Integer paperId = 8130;
        String unitIdStr = "156718,157810,157810";
        String str[] = unitIdStr.split(",");

        int totalNum = paperReportMapper.getStuAnswerDetailsCount(paperId % 10,paperId, Arrays.asList(str));
        if (totalNum != 0) {
            List<StuAnswerDetailDTO> stuAnswerDetailDTOS = paperReportMapper.getStuAnswerDetails(0,paperId,Arrays.asList(str),0,1);//= paperReportMapper.getStuAnswerDetails(0,8130,"166529,156718,157810,157810",1,1);
            System.out.println(stuAnswerDetailDTOS);
        }
    }

    @Test
    public void testSelectByPaperIdAndUnitId() {
        List<TikuExamStatisticsDTO> tikuExamStatisticsDTO = paperReportMapper.selectByPaperIdAndUnitId(1, Arrays.asList("1"));
        System.out.println(tikuExamStatisticsDTO);

        int num = paperReportMapper.selectTotalAnswerNum(1,Arrays.asList("1","2"));
        System.out.println(num);
    }

    @Test
    public void testSelectRankingList() {
        List<StuAnswerDetailDTO> stuAnswerDetailDTOS = paperReportMapper.selectRankingList(8130 %10,8130, Arrays.asList("166529","156718","157810","157810"));
        System.out.println(stuAnswerDetailDTOS);
    }

    @Test
    public void testSelectStuAnswers() {
        Integer paperId = 8130;

        List<OptionAnswerDTO> optionAnswerDTOS = paperReportMapper.selectStuAnswers(paperId % 10,
                paperId, Arrays.asList("166529","156718","157810","157810"), 111);
        System.out.println(optionAnswerDTOS);

    }

    @Test
    public void testGetPaperDetail() {
        String paperCode = "2504";
        String unitIdStr = "1579208,166529,156718,157810,157810";
        PaperDetailDTO paperDetail = paperReportService.getPaperDetail(paperCode, unitIdStr);
        System.out.println(paperDetail);
    }

    @Test
    public void testReplaceCharacter() {
        String a = "1404-江苏省-人力资源管理（一）";
        String b = "";
        a = a.replaceAll("-(.*?)-", "-北京市-");
        System.out.println(a);
    }

    @Test
    public void testDiv() {
        // 没效果
        DecimalFormat df = new DecimalFormat("######0.00");
        double a = 0.001;
        double b = 1.327;
        double c = 1;
        double d = 4.3216324;
        df.format(a);
        df.format(b);
        df.format(c);
        df.format(d);
        System.out.println("a:" +a+",b:"+b+",c:"+c+",d:"+d);
    }

    @Test
    public void testDecimal() {
        double a = (double) 946 / 316;
        double b = gradeRateToDouble(a, 0);
        System.out.println("a="+a+",b="+Integer.parseInt(gradeRate(a)));
    }

    private String gradeRate(double d) {
        BigDecimal b = new BigDecimal(d);
        return b.setScale(0, BigDecimal.ROUND_HALF_UP).toString();
    }

    private double gradeRateToDouble(double d, int scale) {
        BigDecimal b = new BigDecimal(d);
        return b.setScale(scale, BigDecimal.ROUND_HALF_UP).doubleValue();
    }

    @Test
    public void testChangeHtml() {
        String htmlContent = "<img src=\"/F:/ent/ent_parent/ent-op-war/target/ent-op-war-0.0.1-SNAPSHOT/pdfCfg/img//img1.png\" />";
        htmlContent = htmlContent.replaceAll("(<img.*?)(>|/>)", "$1/>");
        System.out.println(htmlContent);
    }

    @Test
    public void testGetRoundStatistics() {
        List<RoundStatisticsDTO> roundStatistics = paperReportMapper.getRoundStatistics(Arrays.asList(1, 2, 3));
        if (roundStatistics != null && roundStatistics.size() >0) {
            System.out.println(roundStatistics);
        }
    }
}
