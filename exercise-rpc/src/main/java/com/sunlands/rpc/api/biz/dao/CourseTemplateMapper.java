package com.sunlands.rpc.api.biz.dao;

import com.sunlands.rpc.api.biz.model.CourseTemplateUnitDTO;
import com.sunlands.rpc.api.biz.model.CourseTemplateUnitFirstLevelNodeDTO;
import com.sunlands.rpc.api.biz.model.UnitNodeFrequencyInfoDTO;
import com.sunlands.rpc.api.biz.model.UnitNodeInfoDTO;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.mapping.FetchType;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author: maxiao
 * @description:
 * @date: create in 14:19 2018/6/22
 * @modified By:
 * @copyright by sunlands
 */
@Mapper
@Repository
public interface CourseTemplateMapper {

    @Select({"SELECT DISTINCT b.id, b.id as templateUnitId" ,
            "FROM t_course_template as a" ,
            "INNER JOIN t_course_template as b ON b.`code` = a.`code` AND b.current_version = 1 AND b.delete_flag = 0" ,
            "INNER JOIN t_course_template_unit as c ON c.template_id = b.id AND c.delete_flag = 0" ,
            "WHERE a.id = #{courseTemplateId} AND a.delete_flag = 0"})
    @Results({
            @Result(column = "id", property = "firstLevelNodes",
                    many = @Many(select = "getUnitFirstLevelNodes", fetchType = FetchType.EAGER))
    })
    List<CourseTemplateUnitDTO> getCourseTemplateKnowledgeFirstNodes(@Param("courseTemplateId") int courseTemplateId);

    @Select({"SELECT DISTINCT d.id, d.id as firstLevelNodeId, d.`name` as firstLevelNodeName" ,
            "FROM `t_course_template_unit` as a" ,
            "INNER JOIN `t_course_template_unit_knowledge_node_rel` as b ON b.template_unit_id = a.id AND b.delete_flag = 0" ,
            "INNER JOIN `t_knowledge_node` as c ON c.id = b.knowledge_node_id AND c.delete_flag = 0" ,
            "INNER JOIN `t_knowledge_node` as d ON d.`level` = 1 AND d.serial_number = SUBSTRING(c.serial_number,1,1) AND d.knowledge_tree_id = c.knowledge_tree_id AND d.delete_flag = 0" ,
            "WHERE a.id = #{templateUnitId} AND a.delete_flag = 0 ORDER BY a.id"})
    List<CourseTemplateUnitFirstLevelNodeDTO> getUnitFirstLevelNodes(@Param("templateUnitId") Integer templateUnitId);

    @Select({"SELECT COUNT( b.knowledge_node_frequentness = 0 OR NULL ) AS midFrequencyCount," ,
            "COUNT( b.knowledge_node_frequentness = 1 OR NULL ) AS highFrequencyCount," ,
            "COUNT( b.knowledge_node_frequentness = 2 OR NULL ) AS extremelyHighFrequencyCount" ,
            "FROM t_knowledge_node as a" ,
            "INNER JOIN t_last_knowledge_node as b ON b.knowledge_node_id = a.id AND b.delete_flag = 0" ,
            "INNER JOIN t_course_template_unit_knowledge_node_rel as c ON c.knowledge_node_id = b.id AND c.delete_flag = 0" ,
            "INNER JOIN t_course_template_unit as d ON d.id = c.template_unit_id AND d.delete_flag = 0" ,
            "WHERE a.id = #{nodeId} AND a.`level` = 1 AND d.id = #{templateUnitId}"})
    UnitNodeFrequencyInfoDTO checkLastLevelNode(@Param("templateUnitId") int templateUnitId, @Param("nodeId") Integer nodeId);

    @Select({"SELECT DISTINCT d.id as knowledgeNodeId, d.`name` as knowledgeNodeName," ,
            "COUNT(e.knowledge_node_frequentness = 0 OR NULL) as midFrequencyCount," ,
            "COUNT(e.knowledge_node_frequentness = 1 OR NULL) as highFrequencyCount," ,
            "COUNT(e.knowledge_node_frequentness = 2 OR NULL) as extremelyHighFrequencyCount" ,
            "FROM t_course_template_unit as a" ,
            "INNER JOIN t_course_template_unit_knowledge_node_rel as b ON b.template_unit_id = a.id" ,
            "INNER JOIN t_knowledge_node as c ON c.`level` = 1 AND c.delete_flag = 0" ,
            "INNER JOIN t_knowledge_node as d ON d.knowledge_tree_id = c.knowledge_tree_id AND d.`level` != 1 AND SUBSTRING(d.serial_number,1,1) = c.serial_number AND d.id = b.knowledge_node_id AND d.delete_flag = 0" ,
            "INNER JOIN t_last_knowledge_node as e ON e.knowledge_node_id = d.id AND e.delete_flag = 0" ,
            "WHERE a.id = #{templateUnitId} AND c.id = #{unitFirstLevelNodeId} AND a.delete_flag = 0 GROUP BY e.knowledge_node_frequentness"})
    @Results({
            @Result(column = "midFrequencyCount", property = "nodeFrequencyInfo.midFrequencyCount"),
            @Result(column = "highFrequencyCount", property = "nodeFrequencyInfo.highFrequencyCount"),
            @Result(column = "extremelyHighFrequencyCount", property = "nodeFrequencyInfo.extremelyHighFrequencyCount")
    })
    List<UnitNodeInfoDTO> retrieveLastLevelNode(@Param("templateUnitId") Integer templateUnitId, @Param("unitFirstLevelNodeId") Integer unitFirstLevelNodeId);
}
