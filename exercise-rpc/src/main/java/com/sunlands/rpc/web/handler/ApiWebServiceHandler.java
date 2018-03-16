package com.sunlands.rpc.web.handler;

import com.sunlands.rpc.web.service.ApiWebService;
import com.sunlands.rpc.web.service.QuizzesPaperReport;
import org.apache.thrift.TException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

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


    @Override
    public List<QuizzesPaperReport> getQuizzesPaperReport(String paperId, String unitIdStr) throws TException {
        return null;
    }
}
