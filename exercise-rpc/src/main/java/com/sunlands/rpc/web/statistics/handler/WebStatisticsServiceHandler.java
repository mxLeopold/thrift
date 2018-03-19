package com.sunlands.rpc.web.statistics.handler;

import com.sunlands.rpc.web.biz.model.PaperReportDTO;
import com.sunlands.rpc.web.biz.service.PaperReportService;
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
    private PaperReportService paperReportService;

    @Override
    public boolean isPaperIdValid(String paperId) throws TException {
        return paperReportService.isPaperIdValid(paperId);
    }

    @Override
    public boolean checkPaperType(String paperId, String exerciseType) throws TException {
        return paperReportService.checkPaperType(paperId, exerciseType);
    }

    @Override
    public List<PaperReport> getPaperReport(String paperId, String unitIdStr) throws TException {
        if (paperId == null || StringUtils.isEmpty(paperId)) {
            throw new TException("paperId不能为空");
        }
        if (unitIdStr == null || StringUtils.isEmpty(unitIdStr)) {
            throw new TException("unitIdStr不能为空");
        }
        List<PaperReportDTO> quizzesPaperReportDTOS = paperReportService.getPaperReport(paperId, unitIdStr);
        if (!CollectionUtils.isEmpty(quizzesPaperReportDTOS)) {
            List<PaperReport> quizzesPaperReports = new ArrayList<PaperReport>();
            BeanUtils.copyProperties(quizzesPaperReportDTOS, quizzesPaperReports);
            return quizzesPaperReports;
        } else {
            return null;
        }
    }

    @Override
    public List<PaperDetail> getPaperDetail(String paperId, String unitIdStr) throws TException {
        return null;
    }

    @Override
    public List<StuAnswerDetail> getStuAnswerDetail(List<TikuUserRecord> recordList) throws TException {
        return null;
    }
}
