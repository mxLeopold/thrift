package com.sunlands.rpc.web.statistics.handler;

import com.sunlands.rpc.common.CommonUtils;
import com.sunlands.rpc.common.Constant;
import com.sunlands.rpc.web.biz.model.PaperDetailDTO;
import com.sunlands.rpc.web.biz.model.StuAnswerDetailDTO;
import com.sunlands.rpc.web.biz.model.WorkPaperReportDTO;
import com.sunlands.rpc.web.biz.model.WorkPaperReportListDTO;
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

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.Delayed;

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
        BeanUtils.copyProperties(paperDetailDTO, paperDetail); // TODO: 2018/3/19 后续直接传文件？
        return paperDetail;
    }

    @Override
    public StuAnswerResult getStuAnswerResult(StuAnswerResult stuAnswerResult) throws TException {
        logger.debug("getStuAnswerResult(stuAnswerResult:{}) -------- begin", stuAnswerResult.toString());
//        Integer paperId = stuAnswerResult.getPaperId();
//        String unitIdStr = stuAnswerResult.getField1();
        // TODO: 2018/3/23 根据paperID(CODE) 查询C端试卷id
        // TODO: 2018/3/23 查询总条数，当前页学员答题详情列表
        StuAnswerDetail detail = new StuAnswerDetail();
        detail.setUserNumber(705981);
//        detail.setUsername("1111");
        detail.setAnsweredTime(80);
        detail.setRightNum(1);
        detail.setCorrectRate(111);
        detail.setRightNum(23);
        ArrayList<StuAnswerDetail> stuAnswerDetails = new ArrayList<>();
        StuAnswerDetail stuAnswerDetail;
        for (int i = 0 ; i < 35; i++) {
            stuAnswerDetail = new StuAnswerDetail();
            BeanUtils.copyProperties(detail, stuAnswerDetail);
            stuAnswerDetails.add(stuAnswerDetail);
        }
        stuAnswerResult.setResultList(stuAnswerDetails);
        stuAnswerResult.setTotalCount(stuAnswerDetails.size()); // 总数
        if (stuAnswerResult.getCountPerPage() != 0) {
            stuAnswerResult.setPageCount(stuAnswerDetails.size() / stuAnswerResult.getCountPerPage() + 1);
        }
        logger.debug("getStuAnswerResult(stuAnswerResult) -------- end, return {}", stuAnswerResult.toString());
        return stuAnswerResult;
    }

    private List<StuAnswerDetail> getStuAnswerDetail(int paperId, String unitIdStr) throws TException {
        List<StuAnswerDetailDTO> stuAnswerDetailDTOs = paperReportService.getStuAnswerDetails(paperId, unitIdStr, null, null);
        if (CollectionUtils.isEmpty(stuAnswerDetailDTOs)) {
            return null;
        }
        List<StuAnswerDetail> stuAnswerDetails = new ArrayList<StuAnswerDetail>();
        StuAnswerDetail detail;
        for (StuAnswerDetailDTO stuAnswerDetailDTO : stuAnswerDetailDTOs) {
            detail = new StuAnswerDetail();
            CommonUtils.copyPropertiesIgnoreNull(stuAnswerDetailDTO, detail);
            stuAnswerDetails.add(detail);
        }
        return stuAnswerDetails;
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
