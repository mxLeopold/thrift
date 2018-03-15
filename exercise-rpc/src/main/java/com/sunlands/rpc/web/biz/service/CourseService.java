package com.sunlands.rpc.web.biz.service;

import com.sunlands.rpc.web.service.UserRecord;

import java.util.List;

/**
 * <p>Title:APP-我的课程服务接口</p>
 * <p>Description:</p>
 *
 * @author <a href="mailto:yinhang89@sunlands.com">尹行</a>
 * @date 2018年03月15日
 * @since v1.0
 */
public interface CourseService {

    /**
     * <p>Description:getUserRecord</p>
     *
     * @param id
     * @param stuId
     * @return java.util.List<com.sunlands.rpc.web.service.UserRecord>
     * @throw
     * @author <a href="mailto:yinhang89@sunlands.com">尹行</a>
     * @update [变更日期YYYY-MM-DD][变更人姓名][变更描述]
     * @since  2018年03月15日
     */
    List<UserRecord> getUserRecord(int id, int stuId);

}
