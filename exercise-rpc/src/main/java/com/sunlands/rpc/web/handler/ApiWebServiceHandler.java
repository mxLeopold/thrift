package com.sunlands.rpc.web.handler;

import com.sunlands.rpc.app.biz.service.CourseService;
import com.sunlands.rpc.web.service.ApiWebService;
import com.sunlands.rpc.web.service.UserRecord;
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

    @Autowired
    private CourseService courseService;

    @Override
    public List<UserRecord> getUserRecord(int id, int stuId) throws TException {
        List<UserRecord> recordList = courseService.getUserRecord(id, stuId);
        // TODO: 2018/3/15

        return null;
    }
}
