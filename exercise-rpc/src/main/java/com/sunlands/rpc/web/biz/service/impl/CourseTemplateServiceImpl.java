package com.sunlands.rpc.web.biz.service.impl;

import com.sunlands.rpc.web.biz.dao.CourseTemplateDao;
import com.sunlands.rpc.web.biz.service.CourseTemplateService;
import com.sunlands.rpc.web.coursetemplate.service.LastKnowledgeNodeInfo;
import com.sunlands.rpc.web.coursetemplate.service.TemplateUnitInfo;
import com.sunlands.rpc.web.coursetemplate.service.TemplateUnitNodeDetailInfo;
import com.sunlands.rpc.web.coursetemplate.service.TemplateUnitNodeInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author: maxiao
 * @description:
 * @date: create in 14:13 2018/6/22
 * @modified By:
 * @copyright by sunlands
 */
@Service
public class CourseTemplateServiceImpl implements CourseTemplateService {

    @Autowired
    private CourseTemplateDao courseTemplateDao;

    @Override
    public List<LastKnowledgeNodeInfo> retrieveCourseTemplateTreeInfo(int knowledgeTreeId) {
        return courseTemplateDao.retrieveCourseTemplateTreeInfo(knowledgeTreeId);
    }

    @Override
    public TemplateUnitNodeInfo retrieveCourseTemplateTeachUnitNodes(int templateId, int templateUnitId) {
        return courseTemplateDao.retrieveCourseTemplateTeachUnitNodes(templateId, templateUnitId);
    }

    @Override
    public List<TemplateUnitInfo> retrieveTemplateUnitNodeDetailInfo(int templateId) {
        // 获取所有课次
        List<TemplateUnitInfo> templateUnitList = courseTemplateDao.retrieveTemplateUnitNodeDetailInfo(templateId);
        for (TemplateUnitInfo templateUnit : templateUnitList) {
            List<TemplateUnitNodeDetailInfo> unitFirstLevelNodes = courseTemplateDao.selectTemplateUnitFirstLevelNodes(templateId, templateUnit.getTemplateUnitId());
            for (TemplateUnitNodeDetailInfo firstNode : unitFirstLevelNodes) {
                TemplateUnitNodeInfo firstFrequencyInfo = courseTemplateDao.selectNodeFrequencyInfo(templateId, firstNode.getNodeId());
                if (firstFrequencyInfo == null) {
                    List<TemplateUnitNodeDetailInfo> secondLevelNodes = courseTemplateDao.selectTemplateUnitSecondLevelNodes(templateUnit.getTemplateUnitId(), firstNode.getNodeId());
                    for (TemplateUnitNodeDetailInfo secondNode : secondLevelNodes) {
                        TemplateUnitNodeInfo secondFrequencyInfo = courseTemplateDao.selectSecondNodeFrequencyInfo(templateId, templateUnit.getTemplateUnitId(), secondNode.getNodeId());
                        secondNode.setNodeFrequencyInfo(secondFrequencyInfo);
                    }
                    firstNode.setKnowledgeNodeList(secondLevelNodes);
                }
                firstNode.setNodeFrequencyInfo(firstFrequencyInfo);
            }
            templateUnit.setTemplateUnitNodeInfo(unitFirstLevelNodes);
        }
        return templateUnitList;
    }
}
