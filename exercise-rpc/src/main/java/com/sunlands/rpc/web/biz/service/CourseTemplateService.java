package com.sunlands.rpc.web.biz.service;

import com.sunlands.rpc.web.coursetemplate.service.LastKnowledgeNodeInfo;
import com.sunlands.rpc.web.coursetemplate.service.TemplateUnitInfo;
import com.sunlands.rpc.web.coursetemplate.service.TemplateUnitNodeInfo;

import java.util.List;

/**
 * @author: maxiao
 * @description:
 * @date: create in 14:13 2018/6/22
 * @modified By:
 * @copyright by sunlands
 */
public interface CourseTemplateService {

    List<LastKnowledgeNodeInfo> retrieveCourseTemplateTreeInfo(int knowledgeTreeId);

    /**
     * 获取课程模板单个课次的知识点频度的总分布信息
     * @param templateId
     * @param templateUnitId
     * @return
     */
    TemplateUnitNodeInfo retrieveCourseTemplateTeachUnitNodes(int templateId, int templateUnitId);

    /**
     * 获取课程模板所有课次的知识点频度的详细分布信息（统计到二级）
     * @param templateId
     * @return
     */
    List<TemplateUnitInfo> retrieveTemplateUnitNodeDetailInfo(int templateId);
}
