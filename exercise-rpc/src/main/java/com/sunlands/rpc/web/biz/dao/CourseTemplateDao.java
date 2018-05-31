package com.sunlands.rpc.web.biz.dao;

import com.sunlands.rpc.web.coursetemplate.service.*;
import org.apache.ibatis.annotations.*;
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
            "INSERT INTO ent_exam (college_id, subject_id, name, start_time, end_time, paper_code, round_id, operator, exam_type) " +
            "VALUES(#{exam.collegeId}, #{exam.subjectId}, #{exam.name}, #{startTime}, #{endTime}, #{exam.paperCode}, " +
            "#{exam.roundId}, #{exam.operator}, 'MOCK_EXAM')"
    })
    @Options(useGeneratedKeys = true, keyProperty = "exam.exerciseExamId")
    int insertMockExam(@Param("exam") ReqMockExam exam, @Param("startTime")Timestamp startTime, @Param("endTime")Timestamp endTime);

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
}
