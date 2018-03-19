package com.sunlands.rpc.web.statistics.handler;

import com.sunlands.rpc.web.biz.model.QuizzesPaperReportDTO;
import com.sunlands.rpc.web.biz.service.QuizzesPaperReportService;
import com.sunlands.rpc.web.statistics.service.*;
import org.apache.thrift.TException;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
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
    @Autowired
    private QuizzesPaperReportService quizzesPaperReportService;

    @Override
    public boolean isPaperIdValid(String paperId) throws TException {
        return false;
    }

    @Override
    public boolean checkPaperType(String paperId, String exerciseType) throws TException {
        return false;
    }

    @Override
    public List<QuizzesPaperReport> getQuizzesPaperReport(String paperId, String unitIdStr) throws TException {
        if (paperId == null || StringUtils.isEmpty(paperId)) {
            throw new TException("paperId不能为空");
        }
        if (unitIdStr == null || StringUtils.isEmpty(unitIdStr)) {
            throw new TException("unitIdStr不能为空");
        }
        List<QuizzesPaperReportDTO> quizzesPaperReportDTOS = quizzesPaperReportService.getQuizzesPaperReport(paperId, unitIdStr);
        if (!CollectionUtils.isEmpty(quizzesPaperReportDTOS)) {
            List<QuizzesPaperReport> quizzesPaperReports = new ArrayList<QuizzesPaperReport>();
            BeanUtils.copyProperties(quizzesPaperReportDTOS, quizzesPaperReports);
            return quizzesPaperReports;
        } else {
            return null;
        }
    }

    @Override
    public List<QuizzesPaperDetail> getQuizzesPaperDetail(String paperId, String unitIdStr) throws TException {
        return null;
    }

    @Override
    public List<StuAnswerDetail> getStuAnswerDetail(List<TikuUserRecord> recordList) throws TException {
        return null;
    }
}
