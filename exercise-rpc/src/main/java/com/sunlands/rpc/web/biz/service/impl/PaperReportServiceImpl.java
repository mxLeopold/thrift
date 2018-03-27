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

import java.util.Arrays;
import java.util.List;

@Service
public class PaperReportServiceImpl implements PaperReportService {
    @Autowired
    private PaperReportMapper paperReportMapper;

    @Override
    public WorkPaperReportDTO getPaperReport(String paperCode, String unitIdStr) {
        PaperDTO paperDTO = paperReportMapper.selectPaperByCode(paperCode);
        Assert.notNull(paperDTO, "试卷不存在");
//        Integer paperId = paperDTO.getId();  // 学员参考试卷版本id
        WorkPaperReportDTO paperReport = paperReportMapper.selectPaperReport(paperDTO.getId(), unitIdStr);
        if (paperReport == null) {
            return null;
        }
        Integer answerNum = paperReport.getAnswerNumber();
        if (answerNum != null && !answerNum.equals(0) ) {
            paperReport.setAnswerTimeAve(paperReport.getAnswerTime() / answerNum);
            paperReport.setCorrectAve(paperReport.getCorrect() / answerNum);
            paperReport.setCorrectPercent((float) paperReport.getCorrect() / (answerNum * paperDTO.getQuestionAmount()));
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
    public PaperDetailDTO getPaperDetail(String paperId, String unitIdStr) {
        PaperDTO paperDTO = paperReportMapper.selectPaperByCode(paperId);
        Assert.notNull(paperDTO, "试卷不存在");

        PaperDetailDTO paperDetailDTO = new PaperDetailDTO();
        paperDetailDTO.setPaperId(paperDTO.getId());
        paperDetailDTO.setCode(paperDTO.getCode());
        paperDetailDTO.setPaperName(paperDTO.getName());
        // 查询答题人数
        WorkPaperReportDTO paperReportDTO = paperReportMapper.selectPaperReport(paperDTO.getId(), unitIdStr);
        if (paperReportDTO != null) {
            paperDetailDTO.setAnswerNum(paperReportDTO.getAnswerNumber());
        }
        // 排行榜
        paperDetailDTO.setRanking(paperReportMapper.selectRankingList(paperDTO.getId(), unitIdStr)); // TODO: 2018/3/20 取ES数据？
        // 题目详情
        paperDetailDTO.setQuestionDetailList(getRelatedQuestionMain(paperDTO.getId()));
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
     * 查询试卷内试题详情
     * @param paperId
     * @return
     */
    List<QuestionDetailDTO> getRelatedQuestionMain(Integer paperId) {
        List<QuestionDetailDTO> questions = paperReportMapper.selectBigQuestionMainByPaperId(paperId);
        if (!CollectionUtils.isEmpty(questions)) {
            for (QuestionDetailDTO questionDetailDTO : questions) {
                // 选项
                if (Constant.CONTENT_TYPE_CHOICE.equals(questionDetailDTO.getContentType())) {
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
                // 空
                // 小题
                // 学员答题分布  todo 存库？
            }
        }
        return questions;
    }

    @Override
    public StuAnswerResultDTO getStuAnswerResult(StuAnswerResultDTO stuAnswerResultDTO) {
        String paperCode = stuAnswerResultDTO.getPaperId();
        String unitIdStr = stuAnswerResultDTO.getField1();
//        String paperCode = "2504";
//        String unitIdStr = "166529,156718,157810,157810";
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
            // TODO: 2018/3/27 计算正确率


            stuAnswerResultDTO.setResultList(stuAnswerDetailDTOS);
            if (!CollectionUtils.isEmpty(stuAnswerDetailDTOS) &&
                    !stuAnswerResultDTO.getCountPerPage().equals(0)) {
                stuAnswerResultDTO.setPageCount(stuAnswerDetailDTOS.size() / stuAnswerResultDTO.getCountPerPage() + 1);
            }
        }
        return stuAnswerResultDTO;
    }

}
