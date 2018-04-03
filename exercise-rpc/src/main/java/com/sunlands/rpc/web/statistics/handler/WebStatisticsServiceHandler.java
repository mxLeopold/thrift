package com.sunlands.rpc.web.statistics.handler;

import com.sunlands.rpc.common.CommonUtils;
import com.sunlands.rpc.common.Constant;
import com.sunlands.rpc.web.biz.model.*;
import com.sunlands.rpc.web.biz.service.PaperReportService;
import com.sunlands.rpc.web.statistics.service.*;
import org.apache.thrift.TException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * <p>Title:</p>
 * <p>Description:</p>
 *
 * @author <a href="mailto:yinhang89@sunlands.com">尹行</a>
 * @date 2017年11月07日
 * @since v1.0
 */
@Component
public class WebStatisticsServiceHandler implements WebStatisticsService.Iface {
    private static final Logger logger = LoggerFactory.getLogger(WebStatisticsServiceHandler.class);

    @Autowired
    private PaperReportService paperReportService;


    @Override
    public List<WorkPaperReport> getPaperReport(String paperId, String unitIdStr) throws TException {
        logger.debug("getPaperReport(paperId:{}, unitIdStr:{}) --------- start", paperId, unitIdStr);
        if (StringUtils.isEmpty(unitIdStr) || StringUtils.isEmpty(paperId)) {
            logger.error("入参不能为空");
            return new ArrayList<WorkPaperReport>();
        }
        WorkPaperReportDTO quizzesPaperReportDTO = paperReportService.getPaperReport(paperId, unitIdStr);
        if (quizzesPaperReportDTO == null) {  // rpc不传空值
            return new ArrayList<WorkPaperReport>();
        }
        WorkPaperReport report = new WorkPaperReport();
        CommonUtils.copyPropertiesIgnoreNull(quizzesPaperReportDTO, report);
        List<WorkPaperReport> reports = new ArrayList<WorkPaperReport>();
        reports.add(report);
        logger.debug("getPaperReport(paperId:{}, unitIdStr:{}) --------- end, return: {}", paperId, unitIdStr, reports);
        return reports;
    }

    @Override
    public PaperDetail getPaperDetail(String paperId, String unitIdStr) throws TException {
        logger.debug("getPaperDetail(paperId:{}, unitIdStr:{}) --------- start", paperId, unitIdStr);
        if (StringUtils.isEmpty(paperId)) {
            throw new TException("paperId不能为空");
        }
        if (StringUtils.isEmpty(unitIdStr)) {
            throw new TException("unitIdStr不能为空");
        }
        PaperDetailDTO paperDetailDTO = paperReportService.getPaperDetail(paperId, unitIdStr);
        PaperDetail paperDetail = new PaperDetail();
        if (paperDetailDTO == null) {
            paperDetail.setRes(-1);
            return paperDetail;
        }
        paperDetail.setRes(1);
        paperDetail.setPaperId(paperDetailDTO.getPaperId());
        paperDetail.setPaperName(paperDetailDTO.getPaperName());
        paperDetail.setFinishCount(paperDetailDTO.getAnswerNum());
        // 排行榜
        List<StuAnswerDetailDTO> ranking = paperDetailDTO.getRanking();
        if (!CollectionUtils.isEmpty(ranking)) {
            List<QuizzesOrWorkUserAnswers> answers = new ArrayList<QuizzesOrWorkUserAnswers>();
            QuizzesOrWorkUserAnswers answer;
            for (StuAnswerDetailDTO answerDetailDTO : ranking) {
                answer = new QuizzesOrWorkUserAnswers();
                answer.setUserNumber(answerDetailDTO.getStuId());
                answer.setCorrectCount(answerDetailDTO.getCorrectQuestionCount());
                answer.setPaperId(answerDetailDTO.getPaperId());
                answers.add(answer);
            }
            paperDetail.setQuizzesOrWorkUserAnswersDTOList(answers);
        }
        // 题目详情
        List<QuestionDetailDTO> questions = paperDetailDTO.getQuestionDetailList();
        if (!CollectionUtils.isEmpty(questions)) {
            paperDetail.setQuestions(getQuestionDetailList(questions));
        }
        logger.debug("getPaperDetail(paperId:{}, unitIdStr:{}) --------- end, return: {}", paperId, unitIdStr, paperDetail);
        return paperDetail;
    }

    /**
     * 数据转换 QuestionDetailDTO -- > QuestionDetail
     * @param questions
     * @return
     */
    private List<QuestionDetail> getQuestionDetailList(List<QuestionDetailDTO> questions) {
        List<QuestionDetail> questionDetails = new ArrayList<QuestionDetail>();
        QuestionDetail questionDetail;
        for (QuestionDetailDTO question : questions) {
            questionDetail = new QuestionDetail();
            questionDetail.setQuestionType(question.getQuestionType());
            questionDetail.setQuestionContent(question.getQuestionContent());
            questionDetail.setExpertContent(question.getAnalysis());
            // 选项
            List<OptionDTO> optionList = question.getOptionList();
            if (!CollectionUtils.isEmpty(optionList)) {
                ArrayList<Option> options = new ArrayList<>();
                Option option;
                for (OptionDTO optionDTO : optionList) {
                    option = new Option();
                    option.setRightAnswerFlag(optionDTO.getCorrect());
                    option.setOptioncolContent(optionDTO.getOptionContent());
                    option.setSortOrderStr(optionDTO.getOptionTitle());
                    options.add(option);
                }
                questionDetail.setQuestionOptions(options);
            }
            // 选项分布
            List<OptionAnswerDTO> optionAnswerDTOS = question.getStuAnswers();
            if (!CollectionUtils.isEmpty(optionAnswerDTOS)) {
                ArrayList<OptionAnswer> optionAnswers = new ArrayList<>();
                OptionAnswer optionAnswer;
                for (OptionAnswerDTO optionAnswerDTO : optionAnswerDTOS) {
                    optionAnswer = new OptionAnswer();
                    optionAnswer.setQuestionResult(optionAnswerDTO.getQuestionResult());
                    optionAnswer.setAnswerTotal(optionAnswerDTO.getAnswerTotal());
                    optionAnswers.add(optionAnswer);
                }
                questionDetail.setOptionAnswers(optionAnswers);
            }
            // 得分点
            ArrayList<ScorePointDTO> scorePointDTOS = new ArrayList<>();
            if (!CollectionUtils.isEmpty(scorePointDTOS)) {
                ArrayList<ScorePoint> scorePoints = new ArrayList<>();
                ScorePoint scorePoint;
                for (ScorePointDTO scorePointDTO : scorePointDTOS) {
                    scorePoint = new ScorePoint();
                    scorePoint.setContent(scorePointDTO.getContent());
                    scorePoint.setScore(scorePointDTO.getScore());
                    scorePoints.add(scorePoint);
                }
                questionDetail.setScorePoints(scorePoints);
            }
            questionDetails.add(questionDetail);
        }
        return questionDetails;
    }

    @Override
    public StuAnswerResult getStuAnswerResult(StuAnswerResult stuAnswerResult) throws TException {
        logger.debug("getStuAnswerResult(stuAnswerResult:{}) -------- begin", stuAnswerResult.toString());
        StuAnswerResultDTO stuAnswerResultDTO = new StuAnswerResultDTO();
        BeanUtils.copyProperties(stuAnswerResult, stuAnswerResultDTO);
        stuAnswerResultDTO = paperReportService.getStuAnswerResult(stuAnswerResultDTO);
        stuAnswerResult.setPageCount(stuAnswerResultDTO.getPageCount());
        stuAnswerResult.setTotalCount(stuAnswerResultDTO.getTotalCount());
        List<StuAnswerDetailDTO> details = stuAnswerResultDTO.getResultList();
        if (!CollectionUtils.isEmpty(details)) {
            List<StuAnswerDetail> resultList = new ArrayList<StuAnswerDetail>();
            StuAnswerDetail detail ;
            for (StuAnswerDetailDTO detailDTO : details) {
                detail = new StuAnswerDetail();
                detail.setUserNumber(detailDTO.getStuId());
                detail.setAnsweredTime(detailDTO.getTotalTime());
                detail.setRightNum(detailDTO.getCorrectQuestionCount());
                detail.setWrongNum(detailDTO.getWrongQuestionCount());
                detail.setCorrectRate(detailDTO.getAccuracyRate());
                detail.setScore(detailDTO.getScore());
                resultList.add(detail);
            }
            stuAnswerResult.setResultList(resultList);
        }
        logger.debug("getStuAnswerResult(stuAnswerResult) -------- end, return {}", stuAnswerResult.toString());
        return stuAnswerResult;
    }

    @Override
    public int checkQuizId(String paperCode) throws TException {
        logger.debug("checkQuizId(paperCode:{}) -------- start", paperCode);
        int checkPaperId = paperReportService.checkPaperId(paperCode, Constant.PAPER_TYPE_QUIZ);
        logger.debug("checkQuizId(paperCode:{}) -------- end, return {}", paperCode, checkPaperId);
        return checkPaperId;

    }

    @Override
    public int checkAssignmentId(String paperCode) throws TException {
        logger.debug("checkAssignmentId(paperCode:{}) -------- start", paperCode);
        int checkPaperId = paperReportService.checkPaperId(paperCode, Constant.PAPER_TYPE_ASSIGNMENTS);
        logger.debug("checkAssignmentId(paperCode:{}) -------- end, return {}", paperCode, checkPaperId);
        return checkPaperId;
    }

}
