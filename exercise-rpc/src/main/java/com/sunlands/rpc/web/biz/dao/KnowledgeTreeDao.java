package com.sunlands.rpc.web.biz.dao;

import com.sunlands.rpc.web.biz.model.KnowledgeTreeDTO;
import com.sunlands.rpc.web.coursetemplate.service.CourseTemplate;
import com.sunlands.rpc.web.coursetemplate.service.KnowledgeTree;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.ResultType;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface KnowledgeTreeDao {

    /**
     * 根据科目id和课程类型查询知识树
     * @param subjectId
     * @param type
     * @return
     */
    @Select({
            "select distinct t_knowledge_tree_id as knowledgeTreeId, subject_id as subjectId from t_course_template where subject_id = #{subjectId} and type_code = #{type}"
    })
    List<KnowledgeTree> queryKnowledgeTreeBySubjectAndType(@Param("subjectId") int subjectId, @Param("type") String type);

    /**
     * 根据知识树id查询省份列表
     * @param knowledgeId
     * @return
     */
    @Select({
            "select distinct province_id from t_knowledge_tree_province_proj2nd_rel where knowledge_tree_id = #{knowledgeId} order by province_id"
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
             "from t_course_template where subject_id = #{subjectId} and type_code = #{type}" +
             "<if test = \"knowledgeTreeId != 0\"> and t_knowledge_tree_id = #{knowledgeTreeId}</if>" +
             "</script>"
    })
    List<CourseTemplate> queryCourseTemplateBySubjectAndType(@Param("subjectId") int subjectId, @Param("type") String type, @Param("knowledgeTreeId") int knowledgeTreeId);
}
