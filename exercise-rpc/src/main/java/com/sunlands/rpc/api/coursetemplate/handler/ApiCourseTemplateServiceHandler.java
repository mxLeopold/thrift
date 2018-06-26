package com.sunlands.rpc.api.coursetemplate.handler;

import com.alibaba.druid.sql.visitor.functions.If;
import com.sunlands.rpc.api.biz.model.UnitNodeFrequencyInfoDTO;
import com.sunlands.rpc.api.biz.model.UnitNodeInfoDTO;
import com.sunlands.rpc.api.biz.service.CourseTemplateService;
import com.sunlands.rpc.api.coursetemplate.service.ApiCourseTemplateService;
import com.sunlands.rpc.api.coursetemplate.service.NodeFrequencyInfo;
import com.sunlands.rpc.api.coursetemplate.service.UnitNodeInfo;
import org.apache.thrift.TException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * @author: maxiao
 * @description:
 * @date: create in 11:42 2018/6/22
 * @modified By:
 * @copyright by sunlands
 */
@Component
public class ApiCourseTemplateServiceHandler implements ApiCourseTemplateService.Iface {

    private static final Logger log = LoggerFactory.getLogger(ApiCourseTemplateService.class);

    @Autowired
    private CourseTemplateService courseTemplateService;


    @Override
    public List<List<UnitNodeInfo>> retrieveCourseTemplateInfoById(int courseTemplateId) throws TException {
        List<List<UnitNodeInfo>> rst = new ArrayList<>();
        List<List<UnitNodeInfoDTO>> unitsNodeInfo = courseTemplateService.retrieveCourseTemplateInfoById(courseTemplateId);
        Iterator<List<UnitNodeInfoDTO>> iterator = unitsNodeInfo.iterator();
        for (; iterator.hasNext(); ) {
            List<UnitNodeInfoDTO> unitNodeInfo = iterator.next();
            List<UnitNodeInfo> svUnitNodeInfo = this.transferUnitsToSvUnits(unitNodeInfo);
            rst.add(svUnitNodeInfo);
        }
        return rst;
    }

    private List<UnitNodeInfo> transferUnitsToSvUnits(List<UnitNodeInfoDTO> req) {
        List<UnitNodeInfo> res = new ArrayList<>();
        Iterator<UnitNodeInfoDTO> iterator = req.iterator();
        for ( ; iterator.hasNext(); ) {
            UnitNodeInfoDTO unitFirstLevelNode = iterator.next();
            UnitNodeInfo svUnitNode = new UnitNodeInfo();
            svUnitNode.setKnowledgeNodeId(unitFirstLevelNode.getKnowledgeNodeId());
            svUnitNode.setKnowledgeNodeName(unitFirstLevelNode.getKnowledgeNodeName());
            UnitNodeFrequencyInfoDTO reqNodeFrequency = unitFirstLevelNode.getNodeFrequencyInfo();
            NodeFrequencyInfo svNodeFrequencyInfo = transferNodeFrequencyToSvNodeFrequency(reqNodeFrequency);
            svUnitNode.setNodeFrequencyInfo(svNodeFrequencyInfo);
            List<UnitNodeInfo> svKnowledgeNodeList = new ArrayList<>();
            List<UnitNodeInfoDTO> knowledgeNodeList = unitFirstLevelNode.getKnowledgeNodeList();
            if (knowledgeNodeList != null && knowledgeNodeList.size() > 0) {
                Iterator<UnitNodeInfoDTO> unitNodeIterator = knowledgeNodeList.iterator();
                for ( ; unitNodeIterator.hasNext(); ) {
                    UnitNodeInfoDTO unitSecondNode = unitNodeIterator.next();
                    UnitNodeInfo svUnitSecondNode = new UnitNodeInfo();
                    svUnitSecondNode.setKnowledgeNodeId(unitSecondNode.getKnowledgeNodeId());
                    svUnitSecondNode.setKnowledgeNodeName(unitSecondNode.getKnowledgeNodeName());
                    svUnitSecondNode.setNodeFrequencyInfo(transferNodeFrequencyToSvNodeFrequency(unitSecondNode.getNodeFrequencyInfo()));
                    svKnowledgeNodeList.add(svUnitSecondNode);
                }
            }
            svUnitNode.setKnowledgeNodeList(svKnowledgeNodeList);
            res.add(svUnitNode);
        }
        return res;
    }

    private NodeFrequencyInfo transferNodeFrequencyToSvNodeFrequency(UnitNodeFrequencyInfoDTO req) {
        NodeFrequencyInfo res = null;
        if (req != null
                &&
                    !(new Integer(0).equals(req.getMidFrequencyCount())
                    && new Integer(0).equals(req.getHighFrequencyCount())
                    && new Integer(0).equals(req.getExtremelyHighFrequencyCount()))) {
            res = new NodeFrequencyInfo();
            res.setMidFrequencyCount(req.getMidFrequencyCount());
            res.setHighFrequencyCount(req.getHighFrequencyCount());
            res.setExtremelyHighFrequencyCount(req.getExtremelyHighFrequencyCount());
        }
        return res;
    }
}
