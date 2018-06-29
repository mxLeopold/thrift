package com.sunlands.rpc.web.biz.service.impl;

import com.sunlands.rpc.web.biz.dao.CourseTemplateDao;
import com.sunlands.rpc.web.biz.service.CourseTemplateService;
import com.sunlands.rpc.web.coursetemplate.service.LastKnowledgeNodeInfo;
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
}
