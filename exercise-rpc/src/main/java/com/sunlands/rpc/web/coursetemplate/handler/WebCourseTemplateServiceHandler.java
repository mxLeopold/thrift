package com.sunlands.rpc.web.coursetemplate.handler;

import com.sunlands.rpc.web.biz.dao.KnowledgeTreeDao;
import com.sunlands.rpc.web.biz.model.KnowledgeTreeDTO;
import com.sunlands.rpc.web.coursetemplate.service.*;
import org.apache.thrift.TException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * @author gml
 */
@Component
public class WebCourseTemplateServiceHandler implements WebCourseTemplateService.Iface{
    @Autowired
    private KnowledgeTreeDao knowledgeTreeDao;
    @Override
    public List<KnowledgeTree> getCourseTemplateKnowledgeTreeListBySubjectAndType(int subjectId, String type) throws TException {
        if (type == null || type.isEmpty()) {
            throw new TException("type错误");
        }
        List<KnowledgeTree> knowledgeTreeList = knowledgeTreeDao.queryKnowledgeTreeBySubjectAndType(subjectId, type);

        for (KnowledgeTree knowledgeTree : knowledgeTreeList) {
            List<Integer> provinceList = knowledgeTreeDao.queryProvinceByKnowledgeTreeId(knowledgeTree.getKnowledgeTreeId());
            String provinces = getProvinceString(provinceList);
            knowledgeTree.setProvinces(provinces);
        }
        return knowledgeTreeList;
    }

    private String getProvinceString(List<Integer> provinces) {
        if (provinces == null) {
            return null;
        }
        StringBuilder builder = new StringBuilder();
        for (Integer id : provinces) {
            builder.append(id + " ");
        }
        String result = builder.toString();
        return result.substring(0, result.length());
    }

    @Override
    public List<CourseTemplate> getCourseTemplateListByCondition(int subjectId, String type, int knowledgeTreeId) throws TException {
        return null;
    }

    @Override
    public CourseTemplateDetail getCourseTemplateDetailById(int courseTemplateId) throws TException {
        return null;
    }

    @Override
    public int operateMockExam(ReqMockExam reqMockExam) throws TException {
        return 0;
    }
}
