package com.sunlands.rpc.web.biz.dao;

import com.sunlands.rpc.web.coursetemplate.service.*;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.sql.Timestamp;
import java.util.List;

@Repository
public interface CourseTemplateDao {

    /**
     * 根据科目id和课程类型查询知识树
     * @param subjectId
     * @param type
     * @return
     */
    @Select({
            "select distinct t_knowledge_tree_id as knowledgeTreeId, subject_id as subjectId from t_course_template" +
            " where subject_id = #{subjectId} and type_code = #{type} and delete_flag = 0"
    })
    List<KnowledgeTree> queryKnowledgeTreeBySubjectAndType(@Param("subjectId") int subjectId, @Param("type") String type);

    /**
     * 根据知识树id查询省份列表
     * @param knowledgeId
     * @return
     */
    @Select({
            "select distinct province_id from t_knowledge_tree_province_proj2nd_rel " +
            "where knowledge_tree_id = #{knowledgeId} and delete_flag = 0 order by province_id"
    })
    List<Integer> queryProvinceByKnowledgeTreeId(@Param("knowledgeId") int knowledgeId);

    /**
     * 根据科目+类型+知识树（选填）获取知识模板列表
     * @param subjectId
     * @param type
     * @param knowledgeTreeId
     * @return
     */
    @Select({"<script>" +
             "select id courseTemplateId, code courseTemplateCode, subject_id subjectId, t_knowledge_tree_id knowledgeTreeId, " +
             "version, name courseTemplateName, total_unit_count totalUnitCount, mock_exam_paper_code mockExamPaperCode " +
             "from t_course_template where delete_flag = 0 and subject_id = #{subjectId} and type_code = #{type}" +
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
            "select id courseTemplateId, code courseTemplateCode, subject_id subjectId, t_knowledge_tree_id knowledgeTreeId, version, " +
            "name courseTemplateName, total_unit_count totalUnitCount, mock_exam_paper_code mockExamPaperCode from t_course_template " +
            "where id = #{courseTemplateId} and delete_flag = 0"
    })
    CourseTemplateDetail queryCourseTemplateById(@Param("courseTemplateId") int courseTemplateId);

    /**
     * 根据课程模板id获取课程模板单元列表
     * @param courseTemplateId
     * @return
     */
    @Select({
            "select id templateUnitId, template_id courseTemplateId from t_course_template_unit " +
            "where template_id = #{courseTemplateId} and delete_flag = 0"
    })
    List<CourseTemplateUnit>  queryCourseTemplateUnitByCourseTemplateId(@Param("courseTemplateId") int courseTemplateId);

    /**
     * 根据课程模板单元id查询关联的知识点id列表
     * @param templateUnitId
     * @return
     */
    @Select({
            "select knowledge_node_id from t_course_template_unit_knowledge_node_rel " +
            "where template_unit_id = #{templateUnitId} and delete_flag = 0"
    })
    List<Integer> queryKnowledgeNodeIdByTemplateUnitId(@Param("templateUnitId")int templateUnitId);

    /**
     * 根据课程模板单元id查询随堂考/作业列表
     * @param templateUnitId
     * @param paperType
     * @return
     */
    @Select({
            "select paper_code from t_course_template_unit_paper_rel " +
            "where template_unit_id = #{templateUnitId} and paper_type = #{paperType} and delete_flag = 0"
    })
    List<String> queryPaperByTemplateUnitId(@Param("templateUnitId")int templateUnitId, @Param("paperType") String paperType);

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
            "update ent_exam set college_id = #{exam.collegeId}, subject_id = #{exam.subjectId}, name = #{exam.name}, start_time = #{startTime}, " +
            "end_time = #{endTime}, paper_code = #{exam.paperCode}, round_id = #{exam.roundId}, operator = #{exam.operator} where id = #{exam.exerciseExamId} and delete_flag = 0"
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
