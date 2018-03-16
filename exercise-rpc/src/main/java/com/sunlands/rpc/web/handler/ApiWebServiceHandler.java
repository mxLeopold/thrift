package com.sunlands.rpc.web.handler;

import com.sunlands.rpc.web.biz.model.QuizzesPaperReportDTO;
import com.sunlands.rpc.web.biz.service.QuizzesPaperReportService;
import com.sunlands.rpc.web.service.ApiWebService;
import com.sunlands.rpc.web.service.QuizzesPaperReport;
import org.apache.thrift.TException;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.Assert;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;

import javax.jws.Oneway;
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
public class ApiWebServiceHandler implements ApiWebService.Iface {
    @Autowired
    private QuizzesPaperReportService quizzesPaperReportService;
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
}
