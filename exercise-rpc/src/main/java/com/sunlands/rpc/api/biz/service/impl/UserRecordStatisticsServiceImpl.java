package com.sunlands.rpc.api.biz.service.impl;

import com.sunlands.rpc.api.biz.dao.TikuUserRecordMapper;
import com.sunlands.rpc.api.biz.service.UserRecordStatisticsService;
import com.sunlands.rpc.common.Constant;
import com.sunlands.rpc.datasource.ReadConnection;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 用户做题记录统计
 *
 * @Author: 吴雨佳
 * @since: 2018/3/19 10:07
 * @update: [变更日期yyyy-MM-dd][变更人姓名][变更描述]
 */
@Service
public class UserRecordStatisticsServiceImpl implements UserRecordStatisticsService {

    private static final Logger log = LoggerFactory.getLogger(UserRecordStatisticsServiceImpl.class);

    @Autowired
    private TikuUserRecordMapper tikuUserRecordMapper;

    @Override
    @ReadConnection
    public int isExerciseDone(int studentId, String date, String exerciseType) {
        log.info("<--- isExerciseDone(studentId: {}, date: {}, exerciseType: {}) start --->", studentId, date, exerciseType);
        String tableName = Constant.UserRecord.getTableName(studentId);
        int count = tikuUserRecordMapper.countCompleteRecordByExerciseTypeAndDate(tableName, studentId, date, exerciseType);
        count = count == 0 ? 0 : 1;
        log.info("<--- isExerciseDone result {}: {}", count, count == 0 ? "未完成" : "完成");
        return count;
    }
}
