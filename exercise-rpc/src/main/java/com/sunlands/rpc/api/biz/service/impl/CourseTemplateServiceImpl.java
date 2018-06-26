package com.sunlands.rpc.api.biz.service.impl;

import com.sunlands.rpc.api.biz.dao.CourseTemplateMapper;
import com.sunlands.rpc.api.biz.model.UnitNodeFrequencyInfoDTO;
import com.sunlands.rpc.api.biz.service.CourseTemplateService;
import com.sunlands.rpc.api.biz.model.CourseTemplateUnitDTO;
import com.sunlands.rpc.api.biz.model.CourseTemplateUnitFirstLevelNodeDTO;
import com.sunlands.rpc.api.biz.model.UnitNodeInfoDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Iterator;
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
    private CourseTemplateMapper courseTemplateMapper;

    @Override
    public List<List<UnitNodeInfoDTO>> retrieveCourseTemplateInfoById(int courseTemplateId) {
        List<CourseTemplateUnitDTO> templateUnits = courseTemplateMapper.getCourseTemplateKnowledgeFirstNodes(courseTemplateId);
        List<List<UnitNodeInfoDTO>> res = new ArrayList<>(templateUnits.size());

        // 遍历课程单元
        Iterator<CourseTemplateUnitDTO> unitIterator = templateUnits.iterator();
        for (; unitIterator.hasNext(); ) {
            CourseTemplateUnitDTO templateUnit = unitIterator.next();
            Integer templateUnitId = templateUnit.getTemplateUnitId();

            // 遍历每一节课的一级知识点list
            List<CourseTemplateUnitFirstLevelNodeDTO> unitFirstLevelNodes = templateUnit.getFirstLevelNodes();
            Iterator<CourseTemplateUnitFirstLevelNodeDTO> nodeIterator = unitFirstLevelNodes.iterator();
            List<UnitNodeInfoDTO> unitNodes = new ArrayList<>();
            for (; nodeIterator.hasNext(); ) {
                CourseTemplateUnitFirstLevelNodeDTO unitFirstLevelNode = nodeIterator.next();
                // 判断一级知识点是否为课程模板末级知识点，
                Integer unitFirstLevelNodeId = unitFirstLevelNode.getFirstLevelNodeId();
                UnitNodeInfoDTO unitFirstLevelNodeInfo = new UnitNodeInfoDTO();
                unitFirstLevelNodeInfo.setKnowledgeNodeId(unitFirstLevelNodeId);
                unitFirstLevelNodeInfo.setKnowledgeNodeName(unitFirstLevelNode.getFirstLevelNodeName());
                UnitNodeFrequencyInfoDTO unitNodeFrequency = courseTemplateMapper.checkLastLevelNode(templateUnitId, unitFirstLevelNodeId);
                // 如果一级知识点非课程模板末级知识点。查找到二级知识点，统计二级以下的中高极高频知识点个数
                if (unitNodeFrequency.getMidFrequencyCount() == 0
                        && unitNodeFrequency.getHighFrequencyCount() == 0
                        && unitNodeFrequency.getExtremelyHighFrequencyCount() == 0) {
                    List<UnitNodeInfoDTO> lastLevelNodeInfo = courseTemplateMapper.retrieveLastLevelNode(templateUnitId, unitFirstLevelNodeId);
                    unitFirstLevelNodeInfo.setKnowledgeNodeList(lastLevelNodeInfo);
                }
                unitNodes.add(unitFirstLevelNodeInfo);
            }
            res.add(unitNodes);
        }
        return res;
    }
}
