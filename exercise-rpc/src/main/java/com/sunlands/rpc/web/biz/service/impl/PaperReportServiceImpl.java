package com.sunlands.rpc.web.biz.service.impl;

import com.sunlands.rpc.web.biz.dao.PaperReportMapper;
import com.sunlands.rpc.web.biz.model.PaperDTO;
import com.sunlands.rpc.web.biz.model.PaperReportDTO;
import com.sunlands.rpc.web.biz.model.StuAnswerDetailDTO;
import com.sunlands.rpc.web.biz.service.PaperReportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import java.util.Arrays;
import java.util.List;

@Service
public class PaperReportServiceImpl implements PaperReportService {
    @Autowired
    private PaperReportMapper paperReportMapper;

    @Override
    public List<PaperReportDTO> getPaperReport(String paperCode, String unitIdStr) {
        PaperDTO paperDTO = paperReportMapper.selectPapeByCode(paperCode);
        Assert.notNull(paperDTO, "试卷不存在");
//        Integer paperId = paperDTO.getId();  // 学员参考试卷版本id
        PaperReportDTO paperReport = paperReportMapper.selectPaperReport(paperDTO.getId(), unitIdStr);
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
        return Arrays.asList(paperReport);
    }

    @Override
    public Boolean isPaperIdValid(String paperCode) {
        PaperDTO paperDTO = paperReportMapper.selectPapeByCode(paperCode);
        return  (paperDTO == null) ? false : true;
    }

    @Override
    public Boolean checkPaperType(String paperCode, String type) {
        PaperDTO paperDTO = paperReportMapper.selectPapeByCode(paperCode);
        if (paperDTO != null && paperDTO.getType().equals(type)) {
            return true;
        }
        return false;
    }

    @Override
    public List<StuAnswerDetailDTO> getStuAnswerDetails(Integer paperId, String unitIdStr) {
        return paperReportMapper.getStuAnswerDetails(paperId, unitIdStr);
    }
}
