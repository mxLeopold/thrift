package com.sunlands.rpc.web.biz.service.impl;

import com.sunlands.rpc.common.Constant;
import com.sunlands.rpc.web.biz.dao.PaperReportMapper;
import com.sunlands.rpc.web.biz.model.*;
import com.sunlands.rpc.web.biz.service.PaperReportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;

@Service
public class PaperReportServiceImpl implements PaperReportService {
    @Autowired
    private PaperReportMapper paperReportMapper;

    @Override
    public WorkPaperReportDTO getPaperReport(String paperCode, String unitIdStr) {
        PaperDTO paper = paperReportMapper.selectPaperCodeByCode(paperCode);
        if (paper == null) {
            return null;
        }
        PaperDTO paperDTO = paperReportMapper.selectPaperByCode(paperCode);
        // 未答题
        if (paperDTO == null) {
            return null;
        }
        Integer paperId = paperDTO.getId();  // 学员参考试卷版本id
        List<String> unitIds = Arrays.asList(unitIdStr.split(","));
        WorkPaperReportDTO paperReport = paperReportMapper.selectPaperReport(paperId, unitIds);
        if (paperReport == null) {  // 此班未答题
            return null;
        }

        Integer answerNum = paperReport.getAnswerNumber();
        if (answerNum != null && !answerNum.equals(0) ) {
            Double answerTime = paperReport.getAnswerTime();
            Double answerTimeAve = answerTime / answerNum;
            paperReport.setAnswerTimeString(answerTime.toString());
            paperReport.setAnswerTimeAve(answerTimeAve);
            paperReport.setAnswerTimeAveString(answerTimeAve.toString());
            paperReport.setCorrectAve(paperReport.getCorrect() / answerNum);
            double correctRate = gradeRateToDouble(((double) paperReport.getCorrect() / (answerNum * paperDTO.getQuestionAmount())), 3) * 100;
            paperReport.setCorrectPercent(correctRate);
        }
        paperReport.setPaperName(paperDTO.getName());
        paperReport.setQuestionNum(paperDTO.getQuestionAmount());
        paperReport.setPaperId(paperCode);
        return paperReport;
    }

    @Override
    public List<StuAnswerDetailDTO> getStuAnswerDetails(Integer paperId, String unitIdStr, Integer pageIndex, Integer pageSize) {
//        int totalCount = paperReportMapper.getStuAnswerDetailsCount(paperId % 10, paperId, unitIdStr);
//        if (totalCount == 0) {
//            return null;
//        }
        String str[] = unitIdStr.split(",");
        return paperReportMapper.getStuAnswerDetails(paperId % 10,paperId, Arrays.asList(str), pageIndex, pageSize);
    }

    @Override
    public PaperDetailDTO getPaperDetail(String paperCode, String unitIdStr) {
        PaperDTO paperDTO = paperReportMapper.selectPaperByCode(paperCode);
        // 没有生成C端试卷，未答题
        if (paperDTO == null) {
            return null;
        }
        // 试卷版本id
        Integer paperId = paperDTO.getId();
        // 课程单元id列表
        List<String> unitIds = Arrays.asList(unitIdStr.split(","));
        // 查询答题人数
        int num = paperReportMapper.selectTotalAnswerNum(paperId, unitIds);  // 默认答题人数为正确数据
        if (num == 0) {
            return null;
        }

        PaperDetailDTO paperDetailDTO = new PaperDetailDTO();
        paperDetailDTO.setPaperId(paperId);
        paperDetailDTO.setCode(paperDTO.getCode());
        paperDetailDTO.setPaperName(paperDTO.getName());
        paperDetailDTO.setAnswerNum(num);
        // 排行榜
        paperDetailDTO.setRanking(paperReportMapper.selectRankingList(paperId % 10, paperId, unitIds));
        // 题目详情
        List<QuestionDetailDTO> questions = getRelatedQuestionMain(paperDTO.getId());
        // 学员答案 - 选项分布
        if (!CollectionUtils.isEmpty(questions)) {
            for (QuestionDetailDTO questionDetailDTO : questions) {
                if (Constant.CONTENT_TYPE_CHOICE.equals(questionDetailDTO.getContentType())) {
                    List<OptionAnswerDTO> optionAnswerDTOS = paperReportMapper.selectStuAnswers(paperId % 10, paperId, unitIds, questionDetailDTO.getQuestionMainId());
                    questionDetailDTO.setStuAnswers(optionAnswerDTOS);
                }
            }
        }
        paperDetailDTO.setQuestionDetailList(questions);
        return paperDetailDTO;
    }

    @Override
    public int checkPaperId(String paperCode, String type) {
        PaperDTO paperDTO = paperReportMapper.selectPaperCodeByCode(paperCode); // 配置作业、随堂考时未生成C端试卷，校验B端试卷
        if (paperDTO == null) {  // 试卷ID不存在
            return 1;
        }
        if (paperDTO.getType() == null || !type.equals(paperDTO.getType())) {  // ID与类型不符
            return 2;
        }
        return 0;
    }

    @Override
    public void selectWorkPaperReport(WorkPaperReportListDTO workPaperReportListDTO) {
        String paperCode = workPaperReportListDTO.getWorkGroupId();
        String unitIdStr = workPaperReportListDTO.getField1();
        WorkPaperReportDTO paperReport = getPaperReport(paperCode, unitIdStr);
        workPaperReportListDTO.setResult(Arrays.asList(paperReport));
    }

    /**
     * 查询试卷内试题详情 -- 作业、随堂考只统计了选择、文字
     * @param paperId
     * @return
     */
    List<QuestionDetailDTO> getRelatedQuestionMain(Integer paperId) {
        List<QuestionDetailDTO> questions = paperReportMapper.selectBigQuestionMainByPaperId(paperId);
        if (!CollectionUtils.isEmpty(questions)) {
            for (QuestionDetailDTO questionDetailDTO : questions) {
                if (Constant.CONTENT_TYPE_CHOICE.equals(questionDetailDTO.getContentType())) {
                    // 选项
                    List<OptionDTO> optionDTOS = paperReportMapper.selectOptionsByQuestionId(questionDetailDTO.getQuestionId());
                    questionDetailDTO.setOptionList(optionDTOS);
                }
                // 得分点
                if (Constant.CONTENT_TYPE_ESSAY.equals(questionDetailDTO.getContentType())) {
                    List<ScorePointDTO> scorePointDTOS = paperReportMapper.selectScorePointsByQuestionId(questionDetailDTO.getQuestionId());
                    if (!CollectionUtils.isEmpty(scorePointDTOS)) {
                        questionDetailDTO.setScorePointList(scorePointDTOS);
                    }
                }
            }
        }
        return questions;
    }

    @Override
    public StuAnswerResultDTO getStuAnswerResult(StuAnswerResultDTO stuAnswerResultDTO) {
        String paperCode = stuAnswerResultDTO.getPaperId();
        String unitIdStr = stuAnswerResultDTO.getField1();
        if (StringUtils.isEmpty(paperCode)) {
            throw new RuntimeException("paperId不能为空");
        }
        if (StringUtils.isEmpty(unitIdStr)) {
            throw new RuntimeException("unitIdStr不能为空");
        }
        PaperDTO paperDTO= paperReportMapper.selectPaperByCode(paperCode);
        Integer paperId = paperDTO.getId();
        List<String> unitIds = Arrays.asList(unitIdStr.split(","));
        int totalCount = paperReportMapper.getStuAnswerDetailsCount(paperId % 10, paperId, unitIds);
        stuAnswerResultDTO.setTotalCount(totalCount);
        if (totalCount != 0) {
            Integer start = null;
            if (stuAnswerResultDTO.getPageIndex() != null && stuAnswerResultDTO.getCountPerPage() != null
                    && !stuAnswerResultDTO.getPageIndex().equals(0) && !stuAnswerResultDTO.getCountPerPage().equals(0)) {
                start = (stuAnswerResultDTO.getPageIndex() - 1) * stuAnswerResultDTO.getCountPerPage();
            }
            List<StuAnswerDetailDTO> stuAnswerDetailDTOS = paperReportMapper.getStuAnswerDetails(paperId % 10, paperId, unitIds, start, stuAnswerResultDTO.getCountPerPage());

            // 计算正确率
            if (!CollectionUtils.isEmpty(stuAnswerDetailDTOS)) {
                double accuracyRate = 0;
                for (StuAnswerDetailDTO detailDTO : stuAnswerDetailDTOS) {
                    if (detailDTO.getCorrectQuestionCount() != null && detailDTO.getQuestionNum() != null
                            && !detailDTO.getQuestionNum().equals(0)) {
                        accuracyRate = (double)detailDTO.getCorrectQuestionCount() / detailDTO.getQuestionNum();
                    }
                    detailDTO.setAccuracyRate(gradeRate(accuracyRate, 3));
                }
            }
            stuAnswerResultDTO.setResultList(stuAnswerDetailDTOS);
            if (!CollectionUtils.isEmpty(stuAnswerDetailDTOS) &&
                    !stuAnswerResultDTO.getCountPerPage().equals(0)) {
                stuAnswerResultDTO.setPageCount(stuAnswerDetailDTOS.size() / stuAnswerResultDTO.getCountPerPage() + 1);
            }
        }
        return stuAnswerResultDTO;
    }

    /**
     * double --> string
     * @param d
     * @param scale
     * @return
     */
    private String gradeRate(double d, int scale) {
        BigDecimal b = new BigDecimal(d);
        return b.setScale(scale, BigDecimal.ROUND_HALF_UP).toString();
    }

    /**
     *
     * @param d
     * @param scale
     * @return
     */
    private double gradeRateToDouble(double d, int scale) {
        BigDecimal b = new BigDecimal(d);
        return b.setScale(scale, BigDecimal.ROUND_HALF_UP).doubleValue();
    }

}
