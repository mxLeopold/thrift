package com.sunlands.rpc.api.biz.dao;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

/**
 * 类描述
 *
 * @Author: 吴雨佳
 * @since: 2018/3/19 14:45
 * @update: [变更日期yyyy-MM-dd][变更人姓名][变更描述]
 */
@Mapper
@Repository
public interface TikuUserQuestionMapper {

    /**
     * 统计学员在目标科目id下的做题数量
     *
     * @param tableName     表名
     * @param subjectIds           科目id逗号拼接集合
     * @param studentId     学员ID
     * @return  做题数量
     */
    @Select({
            "SELECT", "COUNT(DISTINCT question_main_id)",
            "FROM", "${tableName}",
            "WHERE", "subject_id IN (${subjectIds})",
            "AND", "stu_id = #{studentId}",
            "AND delete_flag = 0"
    })
    int countQuestionCountBySubjectIdsAndStuId(@Param("tableName") String tableName,
                                               @Param("subjectIds") String subjectIds,
                                               @Param("studentId") int studentId);
}
