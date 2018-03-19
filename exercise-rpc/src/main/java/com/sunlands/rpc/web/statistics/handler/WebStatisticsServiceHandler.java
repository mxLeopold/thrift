package com.sunlands.rpc.web.statistics.handler;

import com.sunlands.rpc.web.biz.model.PaperDetailDTO;
import com.sunlands.rpc.web.biz.model.PaperReportDTO;
import com.sunlands.rpc.web.biz.model.StuAnswerDetailDTO;
import com.sunlands.rpc.web.biz.service.PaperReportService;
import com.sunlands.rpc.web.statistics.service.*;
import org.apache.thrift.TException;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
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
    public List<PaperReport> getPaperReport(String paperId, String unitIdStr) throws TException { // TODO: 2018/3/19 加数据，以满足jsp文件跳转逻辑
        if (paperId == null || StringUtils.isEmpty(paperId)) {
            throw new TException("paperId不能为空");
        }
        if (unitIdStr == null || StringUtils.isEmpty(unitIdStr)) { // 必须是逗号分隔
            throw new TException("unitIdStr不能为空");
        }
        List<PaperReportDTO> quizzesPaperReportDTOS = paperReportService.getPaperReport(paperId, unitIdStr);
        if (CollectionUtils.isEmpty(quizzesPaperReportDTOS)) {
            return null;
        }
        List<PaperReport> quizzesPaperReports = new ArrayList<PaperReport>();
        BeanUtils.copyProperties(quizzesPaperReportDTOS, quizzesPaperReports);
        return quizzesPaperReports;
    }

    @Override
    public PaperDetail getPaperDetail(String paperId, String unitIdStr) throws TException {
        PaperDetailDTO paperDetailDTO = paperReportService.getPaperDetail(paperId, unitIdStr);
        if (paperDetailDTO == null) {
            return null;
        }
        PaperDetail paperDetail = new PaperDetail();
        BeanUtils.copyProperties(paperDetailDTO, paperDetail); // TODO: 2018/3/19 后续直接传文件？
        return paperDetail;
    }

    @Override
    public List<StuAnswerDetail> getStuAnswerDetail(int paperId, String unitIdStr) throws TException {
        List<StuAnswerDetailDTO> stuAnswerDetailDTOs = paperReportService.getStuAnswerDetails(paperId, unitIdStr); // TODO: 2018/3/19 企业家根据学员id查询学员姓名
        if (CollectionUtils.isEmpty(stuAnswerDetailDTOs)) {
            return null;
        }
        List<StuAnswerDetail> stuAnswerDetails = new ArrayList<StuAnswerDetail>();
        BeanUtils.copyProperties(stuAnswerDetailDTOs, stuAnswerDetails);
        return stuAnswerDetails;
    }

}
