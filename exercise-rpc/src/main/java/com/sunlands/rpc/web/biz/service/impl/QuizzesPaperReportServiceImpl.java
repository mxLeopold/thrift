package com.sunlands.rpc.web.biz.service.impl;

import com.sunlands.rpc.web.biz.dao.PaperReportMapper;
import com.sunlands.rpc.web.biz.model.PaperDTO;
import com.sunlands.rpc.web.biz.model.PaperReportDTO;
import com.sunlands.rpc.web.biz.service.QuizzesPaperReportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import java.util.Arrays;
import java.util.List;

@Service
public class QuizzesPaperReportServiceImpl implements QuizzesPaperReportService{
    @Autowired
    private PaperReportMapper paperReportMapper;

    @Override
    public List<PaperReportDTO> getPaperReport(String paperCode, String unitIdStr) {
        PaperDTO paperDTO = paperReportMapper.selectPapeByCode(paperCode);
        Assert.notNull(paperDTO, "试卷不存在");
        PaperReportDTO quizzesPaperReportDTO = new PaperReportDTO();
        quizzesPaperReportDTO.setPaperName(paperDTO.getName());
        quizzesPaperReportDTO.setQuestionNum(paperDTO.getQuestionAmount());
        // TODO: 2018/3/16 查询学员答题统计信息
        return Arrays.asList(quizzesPaperReportDTO);
    }
}
