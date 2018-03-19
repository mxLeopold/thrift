package com.sunlands.rpc.api.biz.service;

/**
 * 用户做题记录统计
 *
 * @Author: 吴雨佳
 * @since: 2018/3/19 9:28
 */
public interface UserRecordStatisticsService {


    /**
     * 统计学员某日练习是否完成
     * @param studentId 学员ID
     * @param date 日期格式: yyyy-MM-dd
     * @param exerciseType 练习类型
     * @return 1. 完成  0. 未完成
     */
    int isExerciseDone(int studentId, String date, String exerciseType);
}