package com.sunlands.rpc.web.biz.dao;

import com.sunlands.rpc.web.biz.model.TemplateUnitNodeDetailInfoDTO;
import com.sunlands.rpc.web.coursetemplate.service.*;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.mapping.FetchType;
import org.apache.ibatis.type.JdbcType;
import org.springframework.stereotype.Repository;

import java.sql.Timestamp;
import java.util.List;

/**
 * 课程模板数据库操作
 */
@Repository
public interface CourseTemplateDao {

    /**
     * 根据科目id和课程类型查询知识树
     * @param subjectId
     * @param type
     * @return
     */
    @Select({
            "select a.t_knowledge_tree_id as knowledgeTreeId, a.subject_id as subjectId, group_concat(d.province_name) as provinces from t_course_template a " +
            "inner join t_knowledge_tree b on a.t_knowledge_tree_id = b.id and b.delete_flag = 0 " +
            "inner join t_knowledge_tree_province_proj2nd_rel c on a.t_knowledge_tree_id = c.knowledge_tree_id and c.delete_flag = 0 " +
            "inner join sch_local_province d on c.province_id = d.id and d.delete_flag = 0 " +
            "where a.subject_id = #{subjectId} and a.type_code = #{type} and a.delete_flag = 0 and a.status_code = 'VALID' and a.current_version = 1 group by knowledgeTreeId"
    })
    List<KnowledgeTree> queryKnowledgeTreeBySubjectAndType(@Param("subjectId") int subjectId, @Param("type") String type);

    /**
     * 根据科目+类型+知识树（选填）获取知识模板列表
     * @param subjectId
     * @param type
     * @param knowledgeTreeId
     * @return
     */
    @Select({"<script>" +
             "select id courseTemplateId, code courseTemplateCode, subject_id subjectId, t_knowledge_tree_id knowledgeTreeId, " +
             "version, name courseTemplateName, total_unit_count totalUnitCount, mock_exam_paper_code mockExamPaperCode from t_course_template " +
            "where delete_flag = 0 and subject_id = #{subjectId} and status_code = 'VALID' and current_version = 1 and type_code = #{type} " +
             "<if test = \"knowledgeTreeId != 0\"> and t_knowledge_tree_id = #{knowledgeTreeId}</if>" +
             "</script>"
    })
    List<CourseTemplate> queryCourseTemplateBySubjectAndType(@Param("subjectId") int subjectId, @Param("type") String type, @Param("knowledgeTreeId") int knowledgeTreeId);

    /**
     * 根据课程模板Id获取课程模板内容
     * @param courseTemplateId
     * @return
     */
    @Select({
            "select id, code courseTemplateCode, subject_id subjectId, t_knowledge_tree_id knowledgeTreeId, version, " +
            "name courseTemplateName, total_unit_count totalUnitCount, mock_exam_paper_code mockExamPaperCode from t_course_template " +
            "where id = #{courseTemplateId} and delete_flag = 0 and status_code = 'VALID' and current_version = 1"
    })
    @Results({
            @Result(column = "id", property = "courseTemplateId", jdbcType = JdbcType.INTEGER),
            @Result(column = "id", property = "templateUnitList", javaType = List.class, many = @Many(select = "queryCourseTemplateUnitByCourseTemplateId"))
            })
    CourseTemplateDetail queryCourseTemplateById(@Param("courseTemplateId") int courseTemplateId);

    /**
     * 根据课程模板id获取课程模板单元列表
     * @param courseTemplateId
     * @return
     */
    @Select({
            "select id, template_id, unit_name, sequence from t_course_template_unit " +
            "where template_id = #{courseTemplateId} and delete_flag = 0 order by sequence"
    })
    @Results({
            @Result(column = "id", property = "templateUnitId", jdbcType = JdbcType.INTEGER),
            @Result(column = "template_id", property = "courseTemplateId", jdbcType = JdbcType.INTEGER),
            @Result(column = "unit_name", property = "templateUnitName", jdbcType = JdbcType.VARCHAR),
            @Result(column = "sequence", property = "sequence", jdbcType = JdbcType.INTEGER),
            @Result(column = "id", property = "knowledgeNodeList", javaType = List.class, many = @Many(select = "queryKnowledgeNodeByTemplateUnitId")),
            @Result(column = "id", property = "quizPaperCodeList", javaType = List.class, many = @Many(select = "queryQuizPaperByTemplateUnitId")),
            @Result(column = "id", property = "assignmentPaperCodeList", javaType = List.class, many = @Many(select = "queryAssignmentPaperByTemplateUnitId")),
            @Result(column = "id", property = "fileList", javaType = List.class, many = @Many(select = "queryCourseTemplateUnitFileByTemplateUnitId"))
    })
    List<CourseTemplateUnit>  queryCourseTemplateUnitByCourseTemplateId(@Param("courseTemplateId") int courseTemplateId);

    /**
     * 根据课程模板单元id查询关联的知识点id列表
     * @param templateUnitId
     * @return
     */
    @Select({
            "select a.knowledge_node_id knowledgeNodeId, b.serial_number serialNumber, b.name knowledgeNodeName " +
            "from t_course_template_unit_knowledge_node_rel a inner join t_knowledge_node b on a.knowledge_node_id = b.id and b.delete_flag = 0 " +
            "where a.template_unit_id = #{templateUnitId} and a.delete_flag = 0"
    })
    List<KnowledgeNode> queryKnowledgeNodeByTemplateUnitId(@Param("templateUnitId")int templateUnitId);

    /**
     * 根据课程模板单元id查询随堂考列表
     * @param templateUnitId
     * @return
     */
    @Select({
            "select paper_code from t_course_template_unit_paper_rel " +
            "where template_unit_id = #{templateUnitId} and paper_type = 'ASSIGNMENTS' and delete_flag = 0"
    })
    List<String> queryAssignmentPaperByTemplateUnitId(@Param("templateUnitId")int templateUnitId);

    /**
     * 根据课程模板单元id查询作业列表
     * @param templateUnitId
     * @return
     */
    @Select({
            "select paper_code from t_course_template_unit_paper_rel " +
                    "where template_unit_id = #{templateUnitId} and paper_type = 'QUIZ' and delete_flag = 0"
    })
    List<String> queryQuizPaperByTemplateUnitId(@Param("templateUnitId")int templateUnitId);

    /**
     * 根据课程模板单元id查询课件文件列表
     * @param templateUnitId
     * @return
     */
    @Select({
            "select a.template_unit_id templateUnitId, a.file_id fileId, b.file_url fileUrl, b.file_name fileName, b.file_size fileSize\n" +
            "from t_course_template_unit_file_rel a inner join t_course_template_file b on a.file_id = b.id where a.template_unit_id = #{templateUnitId} " +
            "and a.delete_flag = 0 and b.delete_flag = 0"
    })
    List<CourseTemplateUnitFile> queryCourseTemplateUnitFileByTemplateUnitId(@Param("templateUnitId")int templateUnitId);

    /**
     * 创建模考试卷
     * @param exam
     * @param startTime
     * @param endTime
     * @return
     */
    @Insert({
            "INSERT INTO ent_exam (college_id, subject_id, name, start_time, end_time, paper_code, round_id, operator, exam_type, paper_id) " +
            "VALUES(#{exam.collegeId}, #{exam.subjectId}, #{exam.name}, #{startTime}, #{endTime}, #{exam.paperCode}, " +
            "#{exam.roundId}, #{exam.operator}, 'MOCK_EXAM', #{paperId})"
    })
    @Options(useGeneratedKeys = true, keyProperty = "exam.exerciseExamId")
    int insertMockExam(@Param("exam") ReqMockExam exam, @Param("startTime")Timestamp startTime, @Param("endTime")Timestamp endTime, @Param("paperId")Integer paperId);

    /**
     * 编辑模拟考试信息
     * @param exam
     * @param startTime
     * @param endTime
     * @return
     */
    @Update({
            "update ent_exam set name = #{exam.name}, start_time = #{startTime}, end_time = #{endTime}, " +
            "operator = #{exam.operator} where id = #{exam.exerciseExamId} and delete_flag = 0"
    })
    @Options(useGeneratedKeys = true, keyProperty = "exam.exerciseExamId")
    int updateMockExam(@Param("exam") ReqMockExam exam, @Param("startTime")Timestamp startTime, @Param("endTime")Timestamp endTime);

    /**
     * 删除模拟考试信息
     * @param exam
     * @return
     */
    @Update({
            "update ent_exam set delete_flag = 1 where id = #{exam.exerciseExamId} and name = #{exam.name} " +
            "and start_time = #{startTime} and end_time = #{endTime} and delete_flag = 0"
    })
    @Options(useGeneratedKeys = true, keyProperty = "exam.exerciseExamId")
    int deleteMockExam(@Param("exam") ReqMockExam exam, @Param("startTime")Timestamp startTime, @Param("endTime")Timestamp endTime);

    @Select({"<script>SELECT t.id as id," ,
            "IFNULL(SUM(CASE t.frequency WHEN 0 THEN t.frequencyCount END),0) as midFrequencyCount," ,
            "IFNULL(SUM(CASE t.frequency WHEN 1 THEN t.frequencyCount END),0) as highFrequencyCount," ,
            "IFNULL(SUM(CASE t.frequency WHEN 2 THEN t.frequencyCount END),0) as extremelyHighFrequencyCount" ,
            "FROM (" ,
            "SELECT t1.id,t2.knowledge_node_frequentness as frequency, COUNT(*) as frequencyCount" ,
            "FROM (" ,
            "SELECT DISTINCT b.id,IFNULL(e.id,c.knowledge_node_id) as lastNodeId" ,
            "FROM t_course_template_unit as b" ,
            "INNER JOIN t_course_template_unit_knowledge_node_rel as c ON c.template_unit_id = b.id" ,
            "INNER JOIN t_knowledge_node as d ON d.id = c.knowledge_node_id" ,
            "LEFT JOIN t_knowledge_node as e ON e.id = d.parent_node_id AND e.`level` = 3" ,
            "lEFT JOIN t_last_knowledge_node as f ON f.knowledge_node_id = d.id" ,
            "LEFT JOIN t_last_knowledge_node as g ON g.knowledge_node_id = e.id" ,
            "WHERE b.id IN (" ,
            "<foreach collection=\"templateUnitIdList\" item=\"templateUnitId\" separator=\",\">#{templateUnitId}</foreach>" ,
            ")) as t1" ,
            "INNER JOIN t_course_template_unit as t3 ON t3.id = t1.id" ,
            "INNER JOIN t_last_knowledge_node as t2 ON t2.knowledge_node_id = t1.lastNodeId" ,
            "GROUP BY t2.knowledge_node_frequentness, t3.id ORDER BY t2.id) as t " ,
            "GROUP BY t.id</script>"})
    @Results({
        @Result(column = "id", property = "templateUnitId", jdbcType = JdbcType.INTEGER),
        @Result(column = "midFrequencyCount", property = "nodeFrequencyInfo.midFrequencyCount", jdbcType = JdbcType.INTEGER),
        @Result(column = "highFrequencyCount", property = "nodeFrequencyInfo.highFrequencyCount", jdbcType = JdbcType.INTEGER),
        @Result(column = "extremelyHighFrequencyCount", property = "nodeFrequencyInfo.extremelyHighFrequencyCount", jdbcType = JdbcType.INTEGER)
    })
    List<TemplateUnitNodeInfoIntermediate> retrieveCourseTemplateTeachUnitNodes(@Param("templateUnitIdList") List<Integer> templateUnitIdList);

    @Select({"SELECT * FROM (" ,
            "SELECT " ,
            "t.templateUnitId," ,
            "t.lastNodeId," ,
            "t.lastNodeLevel," ,
            "k3.knowledge_node_frequentness as lastNodeFreq," ,
            "IF(k3.`level` = 1, k3.knowledge_node_id, IF(k2.`level` = 1, k2.knowledge_node_id, k1.knowledge_node_id)) as firstLevelNodeId," ,
            "IF(k3.`level` = 1, k3.knowledge_node_name, IF(k2.`level` = 1, k2.knowledge_node_name, k1.knowledge_node_name)) as firstLevelNodeName," ,
            "IF(k3.`level` = 1, k3.serial_number, IF(k2.`level` = 1, k2.serial_number, k1.serial_number)) as firstLevelNodeSerial," ,
            "IF(k3.`level` = 2, k3.knowledge_node_id, IF(k2.`level` = 2, k2.knowledge_node_id, k1.knowledge_node_id)) as secondLevelNodeId," ,
            "IF(k3.`level` = 2, k3.knowledge_node_name, IF(k2.`level` = 2, k2.knowledge_node_name, k1.knowledge_node_name)) as secondLevelNodeName," ,
            "IF(k3.`level` = 2, k3.serial_number, IF(k2.`level` = 2, k2.serial_number, k1.serial_number)) as secondLevelNodeSerial," ,
            "IF(k3.`level` = 3, k3.knowledge_node_id, IF(k2.`level` = 3, k2.knowledge_node_id, k1.knowledge_node_id)) as thirdLevelNodeId," ,
            "IF(k3.`level` = 3, k3.knowledge_node_name, IF(k2.`level` = 3, k2.knowledge_node_name, k1.knowledge_node_name)) as thirdLevelNodeName," ,
            "IF(k3.`level` = 3, k3.serial_number, IF(k2.`level` = 3, k2.serial_number, k1.serial_number)) as thirdLevelNodeSerial" ,
            "FROM (" ,
            "SELECT " ,
            "b.id as templateUnitId," ,
            "d.id as relNodeId," ,
            "d.`level` as relNodeLevel," ,
            "IF(e.id is NULL, d.id, e.id) as lastNodeId," ,
            "IF(e.id is NULL, d.`level`, e.`level`) as lastNodeLevel" ,
            "FROM t_course_template as a" ,
            "INNER JOIN t_course_template_unit as b ON b.template_id = a.id AND b.delete_flag = 0" ,
            "INNER JOIN t_course_template_unit_knowledge_node_rel as c ON c.template_unit_id = b.id AND c.delete_flag = 0" ,
            "INNER JOIN t_knowledge_node as d ON d.id = c.knowledge_node_id" ,
            "LEFT JOIN t_knowledge_node as e ON e.id = d.parent_node_id AND d.`level` = 4 AND e.`level` = 3" ,
            "WHERE a.id = #{templateId}" ,
            ") as t" ,
            "INNER JOIN t_last_knowledge_node as k3 ON k3.knowledge_node_id = t.lastNodeId AND k3.delete_flag = 0" ,
            "LEFT JOIN t_last_knowledge_node as k2 ON k2.knowledge_node_id = k3.parent_node_id AND k2.delete_flag = 0" ,
            "LEFT JOIN t_last_knowledge_node as k1 ON k1.knowledge_node_id = k2.parent_node_id AND k1.delete_flag = 0" ,
            "GROUP BY t.templateUnitId, t.lastNodeId" ,
            ") as res " ,
            "ORDER BY res.templateUnitId, res.firstLevelNodeSerial, res.secondLevelNodeSerial, res.thirdLevelNodeSerial"})
    List<TemplateUnitNodeDetailInfoDTO> retrieveTemplateUnitNodeDetailList(@Param("templateId") int templateId);

    @Select({"SELECT DISTINCT " ,
            "c.knowledge_node_id as firstNodeId, c.knowledge_node_name as firstNodeName, c.`level` as firstNodeLevel, c.last_level_flag as firstLastLevelFlag,c.knowledge_node_frequentness as firstFreq," ,
            "e.knowledge_node_id as secondNodeId, e.knowledge_node_name as secondNodeName, e.`level` as secondNodeLevel, e.last_level_flag as secondLastLevelFlag,e.knowledge_node_frequentness as secondFreq," ,
            "g.knowledge_node_id as thirdNodeId, g.knowledge_node_name as thirdNodeName, g.`level` as thirdNodeLevel, g.last_level_flag as thirdLastLevelFlag,g.knowledge_node_frequentness as thirdFreq," ,
            "GROUP_CONCAT(h.id) as fourthNodeIds" ,
            "FROM t_knowledge_tree as a" ,
            "LEFT JOIN t_last_knowledge_node as c ON c.knowledge_tree_id = a.id AND c.`level` = 1 AND c.delete_flag = 0" ,
            "LEFT JOIN t_last_knowledge_node as e ON e.parent_node_id = c.knowledge_node_id AND e.`level` = 2 AND e.delete_flag = 0" ,
            "LEFT JOIN t_last_knowledge_node as g ON g.parent_node_id = e.knowledge_node_id AND g.`level` = 3 AND g.delete_flag = 0" ,
            "LEFT JOIN t_knowledge_node as h ON h.parent_node_id = g.knowledge_node_id AND h.delete_flag = 0 AND h.`level` = 4" ,
            "WHERE a.id = #{knowledgeTreeId} AND a.delete_flag = 0" ,
            "GROUP BY g.knowledge_node_id" ,
            "ORDER BY c.id, e.id, g.id"})
    List<KnowledgeSerialNodeInfoDTO> retrieveCourseTemplateTreeInfoNew(@Param("knowledgeTreeId") int knowledgeTreeId);

    /**
     * 根据课程模板Code获取课程模板内容
     * @param courseTemplateCode
     * @return
     */
    @Select({
            "select id, code courseTemplateCode, subject_id subjectId, t_knowledge_tree_id knowledgeTreeId, version, " ,
            "name courseTemplateName, total_unit_count totalUnitCount, mock_exam_paper_code mockExamPaperCode from t_course_template " ,
            "where code = #{courseTemplateCode} and delete_flag = 0 and status_code = 'VALID' and current_version = 1"
    })
    @Results({
            @Result(column = "id", property = "courseTemplateId", jdbcType = JdbcType.INTEGER),
            @Result(column = "id", property = "templateUnitList", javaType = List.class, many = @Many(select = "queryCourseTemplateUnitByCourseTemplateId"))
    })
    CourseTemplateDetail queryCourseTemplateByCode(@Param("courseTemplateCode") int courseTemplateCode);
}
