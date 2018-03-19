package com.sunlands.rpc.api.biz.dao;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

/**
 * 类描述
 *
 * @Author: 吴雨佳
 * @since: 2018/3/19 10:10
 * @update: [变更日期yyyy-MM-dd][变更人姓名][变更描述]
 */
@Mapper
@Repository
public interface TikuUserRecordMapper {

    /**
     * 某日期, 某练习完成了多少次
     * @param tableName     表名
     * @param studentId     学员ID
     * @param date          统计日期
     * @param exerciseType  统计类型
     * @return
     */
    @Select({
            "SELECT COUNT(1) c FROM ${tableName} ",
            "WHERE stu_id = #{studentId} ",
            "AND status_code = 'COMPLETE' ",
            "AND DATE(end_time) = DATE(#{date})",
            "AND exercise_type = #{exerciseType}"
    })
    int countCompleteRecordByExerciseTypeAndDate(@Param("tableName") String tableName,
                                                 @Param("studentId") int studentId,
                                                 @Param("date") String date,
                                                 @Param("exerciseType") String exerciseType);
}
