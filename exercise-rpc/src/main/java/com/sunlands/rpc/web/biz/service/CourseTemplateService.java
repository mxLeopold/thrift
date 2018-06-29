package com.sunlands.rpc.web.biz.service;

import com.sunlands.rpc.web.biz.model.UnitNodeInfoDTO;
import com.sunlands.rpc.web.coursetemplate.service.LastKnowledgeNodeInfo;

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

    List<Integer> retrieveCourseTemplateTeachUnitNodes(int templateId, int unitSequence);
}
