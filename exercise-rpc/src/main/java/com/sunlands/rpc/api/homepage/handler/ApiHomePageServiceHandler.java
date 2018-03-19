package com.sunlands.rpc.api.homepage.handler;

import com.sunlands.rpc.api.biz.service.UserRecordStatisticsService;
import com.sunlands.rpc.api.homepage.service.ApiHomePageService;
import com.sunlands.rpc.common.Constant;
import com.sunlands.rpc.common.DateTimeUtil;
import org.apache.thrift.TException;
import org.joda.time.DateTimeUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * B端首页服务处理器
 *
 * @Author: 吴雨佳
 * @since: 2018/3/16 20:35
 * @update: [变更日期yyyy-MM-dd][变更人姓名][变更描述]
 */
@Component
public class ApiHomePageServiceHandler implements ApiHomePageService.Iface {

    @Autowired
    private UserRecordStatisticsService userRecordStatisticsService;

    @Override
    public int getSubmitQuestionCount(int ordDetailId, int studentId) throws TException {
        return 0;
    }

    @Override
    public int isDailyIntelligentExerciseDone(int studentId) throws TException {
        return userRecordStatisticsService.isExerciseDone(studentId, "2018-03-16", Constant.UserRecord.ExerciseTypeEnum.INTELLIGENT_EXERCISE.getCode());
    }

}
