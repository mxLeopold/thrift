package com.sunlands.rpc.web.biz.service.impl;

import com.sunlands.rpc.common.CourseTemplateConstants;
import com.sunlands.rpc.web.biz.dao.CourseTemplateDao;
import com.sunlands.rpc.web.biz.model.TemplateUnitNodeDetailInfoDTO;
import com.sunlands.rpc.web.biz.service.CourseTemplateService;
import com.sunlands.rpc.web.coursetemplate.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
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
    public List<TemplateUnitNodeInfoIntermediate> retrieveCourseTemplateTeachUnitNodes(List<Integer> templateUnitIdList) {
        return courseTemplateDao.retrieveCourseTemplateTeachUnitNodes(templateUnitIdList);
    }

    @Override
    public List<TemplateUnitInfo> retrieveTemplateUnitNodeDetailInfo(int templateId) {
        // 获取所有课次的知识点详情
        List<TemplateUnitNodeDetailInfoDTO> templateUnitList = courseTemplateDao.retrieveTemplateUnitNodeDetailList(templateId);
        if (templateUnitList == null || templateUnitList.isEmpty()) {
            throw new RuntimeException("该课程模板下有效课次为0！");
        }

        List<TemplateUnitInfo> res = new ArrayList<>();
        // 上一个课次id
        Integer preTemplateUnitId = 0;
        // 上一个一级知识点id
        Integer preFirstLevelNodeId = 0;

        for (TemplateUnitNodeDetailInfoDTO reqUnit : templateUnitList) {
            Integer reqUnitId = reqUnit.getTemplateUnitId();
            if (reqUnitId == null || "".equals(reqUnitId)) {
                throw new RuntimeException("课程模板关联课次id为空！");
            }
            if (reqUnit.getFirstLevelNodeId() == null || "".equals(reqUnit.getFirstLevelNodeId())) {
                throw new RuntimeException("获取标准课程化课次知识点失败！课次id：" + reqUnit.getTemplateUnitId());
            }
            // 课次id不同
            if (!preTemplateUnitId.equals(reqUnitId)) {
                // 组装新课
                TemplateUnitInfo resUnit = new TemplateUnitInfo();
                // 设置id
                resUnit.setTemplateUnitId(reqUnitId);
                // 组装一级知识点List
                List<TemplateUnitNodeDetailInfo> resFirstNodes = new ArrayList<>();
                TemplateUnitNodeDetailInfo resFirstNode = new TemplateUnitNodeDetailInfo();
                resFirstNode.setNodeId(reqUnit.getFirstLevelNodeId());
                resFirstNode.setNodeName(reqUnit.getFirstLevelNodeName());
                resFirstNodes.add(resFirstNode);
                resUnit.setTemplateUnitNodeInfo(resFirstNodes);
                // 如果同行记录的二级知识点id为空 && 末级知识点为1，设置一级的频度
                if (reqUnit.getSecondLevelNodeId() != null && "".equals(reqUnit.getSecondLevelNodeId())
                        && reqUnit.getLastNodeLevel() != null && new Integer(1).equals(reqUnit.getLastNodeLevel())) {
                    TemplateUnitNodeInfo resFirstNodeFreq = this.constructNodeFreqInfo(reqUnit);
                    resFirstNode.setNodeFrequencyInfo(resFirstNodeFreq);
                } else {
                    // 组装二级知识点
                    List<TemplateUnitNodeDetailInfo> resSecondNodes = new ArrayList<>();
                    TemplateUnitNodeDetailInfo resSecondNode = new TemplateUnitNodeDetailInfo();
                    resSecondNode.setNodeId(reqUnit.getSecondLevelNodeId());
                    resSecondNode.setNodeName(reqUnit.getSecondLevelNodeName());

                    TemplateUnitNodeInfo resSecondNodeFreq = this.constructNodeFreqInfo(reqUnit);
                    resSecondNode.setNodeFrequencyInfo(resSecondNodeFreq);
                    resSecondNodes.add(resSecondNode);
                    resFirstNode.setKnowledgeNodeList(resSecondNodes);
                }
                res.add(resUnit);
            } else {
                // 课次id相同，取出上一课次
                TemplateUnitInfo preUnit = res.get(res.size() - 1);
                List<TemplateUnitNodeDetailInfo> preUnitFirstNodes = preUnit.getTemplateUnitNodeInfo();
                boolean sameFirstSecondFlag = false;
                // 遍历一级知识点，注意如果有不同的一级知识点，需要add进list（add后立刻break循环），小心并发修改异常
                for (int i = 0; i < preUnitFirstNodes.size(); i++) {
                    TemplateUnitNodeDetailInfo preUnitFirstNode = preUnitFirstNodes.get(i);
                    int preUnitFirstNodeId = preUnitFirstNode.getNodeId();
                    if (preFirstLevelNodeId.equals(reqUnit.getFirstLevelNodeId())) {
                        // 如果相同，遍历二级
                        List<TemplateUnitNodeDetailInfo> preUnitSecondNodes = preUnitFirstNode.getKnowledgeNodeList();
                        for (int j = 0; j < preUnitSecondNodes.size(); j++) {
                            TemplateUnitNodeDetailInfo preUnitSecondNode = preUnitSecondNodes.get(j);
                            // 如果二级相同，添加频次
                            if (reqUnit.getSecondLevelNodeId().equals(preUnitSecondNode.getNodeId())) {
                                TemplateUnitNodeInfo preUnitSecondNodeFreq = preUnitSecondNode.getNodeFrequencyInfo();
                                if (reqUnit.getLastNodeFreq().equals(0)) {
                                    preUnitSecondNodeFreq.setMidFrequencyCount(preUnitSecondNodeFreq.getMidFrequencyCount() + 1);
                                } else if (reqUnit.getLastNodeFreq().equals(1)) {
                                    preUnitSecondNodeFreq.setHighFrequencyCount(preUnitSecondNodeFreq.getHighFrequencyCount() + 1);
                                } else if (reqUnit.getLastNodeFreq().equals(2)) {
                                    preUnitSecondNodeFreq.setExtremelyHighFrequencyCount(preUnitSecondNodeFreq.getExtremelyHighFrequencyCount() + 1);
                                }
                                sameFirstSecondFlag = true;
                            }
                        }
                        // 一级相同，二级不同，组装二级
                        if (!sameFirstSecondFlag) {
                            TemplateUnitNodeDetailInfo resSecondNode = new TemplateUnitNodeDetailInfo();
                            resSecondNode.setNodeId(reqUnit.getSecondLevelNodeId());
                            resSecondNode.setNodeName(reqUnit.getSecondLevelNodeName());
                            TemplateUnitNodeInfo resSecondNodeFreq = this.constructNodeFreqInfo(reqUnit);
                            resSecondNode.setNodeFrequencyInfo(resSecondNodeFreq);
                            preUnitFirstNode.getKnowledgeNodeList().add(resSecondNode);
                        }
                    } else {
                        // 如果不同，组装一级和二级
                        TemplateUnitNodeDetailInfo resFirstNode = new TemplateUnitNodeDetailInfo();
                        resFirstNode.setNodeId(reqUnit.getFirstLevelNodeId());
                        resFirstNode.setNodeName(reqUnit.getFirstLevelNodeName());
                        preUnitFirstNodes.add(resFirstNode);
                        // 如果同行记录的二级知识点id为空 && 末级知识点为1，设置一级的频度
                        if (reqUnit.getSecondLevelNodeId() != null && "".equals(reqUnit.getSecondLevelNodeId())
                                && reqUnit.getLastNodeLevel() != null && new Integer(1).equals(reqUnit.getLastNodeLevel())) {
                            TemplateUnitNodeInfo resFirstNodeFreq = this.constructNodeFreqInfo(reqUnit);
                            resFirstNode.setNodeFrequencyInfo(resFirstNodeFreq);
                            break;
                        } else {
                            // 组装二级知识点
                            List<TemplateUnitNodeDetailInfo> resSecondNodes = new ArrayList<>();
                            TemplateUnitNodeDetailInfo resSecondNode = new TemplateUnitNodeDetailInfo();
                            resSecondNode.setNodeId(reqUnit.getSecondLevelNodeId());
                            resSecondNode.setNodeName(reqUnit.getSecondLevelNodeName());

                            TemplateUnitNodeInfo resSecondNodeFreq = this.constructNodeFreqInfo(reqUnit);
                            resSecondNode.setNodeFrequencyInfo(resSecondNodeFreq);
                            resSecondNodes.add(resSecondNode);
                            resFirstNode.setKnowledgeNodeList(resSecondNodes);
                            break;
                        }
                    }
                }
            }
            preTemplateUnitId = reqUnit.getTemplateUnitId();
            preFirstLevelNodeId = reqUnit.getFirstLevelNodeId();
        }
        return res;
    }

    private TemplateUnitNodeInfo constructNodeFreqInfo(TemplateUnitNodeDetailInfoDTO reqUnit) {
        TemplateUnitNodeInfo resNodeFreq = new TemplateUnitNodeInfo();
        resNodeFreq.setMidFrequencyCount(0);
        resNodeFreq.setHighFrequencyCount(0);
        resNodeFreq.setExtremelyHighFrequencyCount(0);

        if (reqUnit.getLastNodeFreq().equals(CourseTemplateConstants.FREQUENCY_MIDDLE)) {
            resNodeFreq.setMidFrequencyCount(1);
        } else if (reqUnit.getLastNodeFreq().equals(CourseTemplateConstants.FREQUENCY_HIGH)) {
            resNodeFreq.setHighFrequencyCount(1);
        } else if (reqUnit.getLastNodeFreq().equals(CourseTemplateConstants.FREQUENCY_EXTREMELY_HIGH)) {
            resNodeFreq.setExtremelyHighFrequencyCount(1);
        }

        return resNodeFreq;
    }
}
