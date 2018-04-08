package com.sunlands.rpc.api.biz.dao;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.Collection;

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
            "SELECT COUNT(1) c FROM ${tableName}",
            "WHERE stu_id = #{studentId}",
            "AND status_code = 'COMPLETE'",
            "AND DATE(end_time) = DATE(#{date})",
            "AND exercise_type = #{exerciseType}",
            "AND delete_flag = 0"
    })
    int countCompleteRecordByExerciseTypeAndDate(@Param("tableName") String tableName,
                                                 @Param("studentId") int studentId,
                                                 @Param("date") String date,
                                                 @Param("exerciseType") String exerciseType
    );

    /**
     * 统计学员做题数量, 不去重
     *
     * @author 吴雨佳
     * @since 2018/4/8 18:30
     * @param knowledgeTreeIds
     * @param studentId
     * @param indexStr
     * @return int
     */
    @Select({
            "<script>",
            "SELECT SUM(question_num) ",
            "FROM t_tiku_user_record_${indexStr} ",
            "WHERE stu_id = #{studentId} AND t_knowledge_tree_id IN ",
            "<foreach item=\"item\" index=\"index\" collection=\"knowledgeTreeIds\"  open=\"(\" separator=\",\" close=\")\"  >",
            "#{item}",
            "</foreach>",
            "AND delete_flag = 0 ",
            "</script>",
    })
    int countDoneQuestionOfKnowledgeIds(@Param("knowledgeTreeIds") Collection<Integer> knowledgeTreeIds,
                                        @Param("studentId") int studentId,
                                        @Param("indexStr") String indexStr);
}
