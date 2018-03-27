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
        if (StringUtils.isEmpty(paperId)) {
            throw new TException("paperId不能为空");
        }
        if (StringUtils.isEmpty(unitIdStr)) { // 必须是逗号分隔
            throw new TException("unitIdStr不能为空");
        }
        WorkPaperReportDTO quizzesPaperReportDTO = paperReportService.getPaperReport(paperId, unitIdStr);
        if (quizzesPaperReportDTO == null) {
            return null;
        }
        WorkPaperReport report = new WorkPaperReport();
        CommonUtils.copyPropertiesIgnoreNull(quizzesPaperReportDTO, report);
        return Arrays.asList(report);
    }

    @Override
    public PaperDetail getPaperDetail(String paperId, String unitIdStr) throws TException {
        PaperDetailDTO paperDetailDTO = paperReportService.getPaperDetail(paperId, unitIdStr);
        if (paperDetailDTO == null) {
            return null;
        }
        PaperDetail paperDetail = new PaperDetail();
        BeanUtils.copyProperties(paperDetailDTO, paperDetail);
        return paperDetail;
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
                resultList.add(detail);
            }
            stuAnswerResult.setResultList(resultList);
        } else {
            stuAnswerResult.setResultList(null);
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

    @Override
    public WorkPaperReportList selectWorkPaperReport(WorkPaperReportList workPaperReportList) throws TException {
        List<WorkPaperReport> paperReport = getPaperReport(workPaperReportList.getWorkGroupId(), workPaperReportList.getField1());
        workPaperReportList.setResult(paperReport);
        workPaperReportList.setPaperId(workPaperReportList.getWorkGroupId());
        return workPaperReportList;
    }

}
