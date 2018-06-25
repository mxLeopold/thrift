package com.sunlands.rpc.api.biz.dao;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Component;

/**
 * 类描述
 *
 * @Author: 吴雨佳
 * @since: 2018/4/8 18:23
 * @update: [变更日期yyyy-MM-dd][变更人姓名][变更描述]
 */
@Mapper
@Component
public interface TikuCommonMapper {


    @Select({"SELECT t.id FROM ( ",
            "SELECT a.id FROM t_knowledge_tree as a ",
            "INNER JOIN t_knowledge_tree_province_proj2nd_rel as b ON b.knowledge_tree_id = a.id AND b.province_id = #{provinceId} AND b.project_2nd_id = #{projectSecondId} AND b.delete_flag = 0 ",
            "WHERE a.subject_id = #{subjectId} AND a.delete_flag = 0 ",
            "UNION ",
            "SELECT a.id FROM t_knowledge_tree as a ",
            "INNER JOIN t_knowledge_tree_province_proj2nd_rel as b ON b.knowledge_tree_id = a.id AND b.province_id = #{provinceId} AND b.delete_flag = 0 ",
            "WHERE a.subject_id = #{subjectId} AND a.delete_flag = 0 ",
            ") as t ",
            "LIMIT 1 "})
    Integer getKnowledgeTreeIdWithProvinceAndProjectSecond(
            @Param("subjectId") Integer subjectId,@Param("provinceId") Integer provinceId,@Param("projectSecondId") Integer projectSecondId);

    @Select({"SELECT t.id FROM ( ",
            "SELECT a.id, COUNT(DISTINCT b.province_id) as provinceCount FROM t_knowledge_tree as a ",
            "INNER JOIN t_knowledge_tree_province_proj2nd_rel as b ON b.knowledge_tree_id = a.id AND b.delete_flag = 0 ",
            "WHERE a.subject_id = #{subjectId} AND a.delete_flag = 0 ",
            "GROUP BY a.id ",
            ") as t ",
            "ORDER BY t.provinceCount DESC LIMIT 1 "})
    Integer getKnowledgeTreeIdWithoutProvince(@Param("subjectId") Integer subjectId);
}
