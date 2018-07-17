package com.sunlands.rpc.web.biz.service.impl;

import com.sunlands.rpc.common.CourseTemplateConstants;
import com.sunlands.rpc.web.biz.dao.CourseTemplateDao;
import com.sunlands.rpc.web.biz.dao.KnowledgeSerialNodeInfoDTO;
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
        List<LastKnowledgeNodeInfo> resData = new ArrayList<>();

        // 获取树的所有节点信息
        List<KnowledgeSerialNodeInfoDTO> knowledgeSerialNodeInfoDTO = courseTemplateDao.retrieveCourseTemplateTreeInfoNew(knowledgeTreeId);
        // 上一个一级知识点id
        Integer pre1stNodeId = 0;
        // 上一个二级知识点id
        Integer pre2ndNodeId = 0;

        for (KnowledgeSerialNodeInfoDTO serialNode : knowledgeSerialNodeInfoDTO) {
            // 如果1stNodeId不同
            if (!serialNode.getFirstNodeId().equals(pre1stNodeId)) {
                LastKnowledgeNodeInfo firstNode = this.constructNodeLastInfo(serialNode);
                resData.add(firstNode);
            } else {
                // 一级二级知识点相同标记
                boolean same1st2ndFlag = false;

                LastKnowledgeNodeInfo preFirstNode = resData.get(resData.size() - 1);
                if (serialNode.getSecondNodeId() == null) {
                    throw new RuntimeException("查询结果有误，与上一知识点属于同一个一级知识点，其二级知识点为空！");
                }
                // 一级相同，遍历二级。如果一级相同，正确的查询结果必定有二级及以下
                List<LastKnowledgeNodeInfo> secondNodeList = preFirstNode.getKnowledgeNodeList();
                if (secondNodeList != null && !secondNodeList.isEmpty()) {
                    for (int i = 0; i < secondNodeList.size(); i ++) {
                        LastKnowledgeNodeInfo secondNode = secondNodeList.get(i);
                        if (new Integer(secondNode.getKnowledgeNodeId()).equals(pre2ndNodeId) && pre2ndNodeId.equals(serialNode.getSecondNodeId())) {
                            // 如果二级相同，设置三级（三级都是一行一个）
                            if (serialNode.getThirdNodeId() != null && !"".equals(serialNode.getThirdNodeId())) {
                                LastKnowledgeNodeInfo thirdNode = new LastKnowledgeNodeInfo();
                                this.constructNodeInfoByLevel(thirdNode, serialNode, 3);
                                secondNode.getKnowledgeNodeList().add(thirdNode);
                                same1st2ndFlag = true;
                            } else {
                                throw new RuntimeException("二级知识点相同的下一条记录，三级知识点不能为空！");
                            }
                        }
                    }
                    if (!same1st2ndFlag) {
                        // 二级不同，实例化二级和三级
                        LastKnowledgeNodeInfo nextSecondNode = new LastKnowledgeNodeInfo();
                        this.constructNodeInfoByLevel(nextSecondNode, serialNode, 2);
                        if (serialNode.getThirdNodeId() != null && !"".equals(serialNode.getThirdNodeId())) {
                            List<LastKnowledgeNodeInfo> thirdNodeList = new ArrayList<>();
                            LastKnowledgeNodeInfo thirdNode = new LastKnowledgeNodeInfo();
                            this.constructNodeInfoByLevel(thirdNode, serialNode, 3);
                            thirdNodeList.add(thirdNode);
                            nextSecondNode.setKnowledgeNodeList(thirdNodeList);
                        }
                        secondNodeList.add(nextSecondNode);
                        same1st2ndFlag = false;
                    }
                }

            }
            pre1stNodeId = serialNode.getFirstNodeId();
            pre2ndNodeId = serialNode.getSecondNodeId() == null ? 0 : serialNode.getSecondNodeId();
        }

        return resData;
    }

    private LastKnowledgeNodeInfo constructNodeLastInfo(KnowledgeSerialNodeInfoDTO serialNode) {
        LastKnowledgeNodeInfo res = new LastKnowledgeNodeInfo();
        this.constructNodeInfoByLevel(res, serialNode, 1);
        if (!new Integer(1).equals(serialNode.getFirstLastLevelFlag())
                && serialNode.getSecondNodeId() != null
                && !"".equals(serialNode.getSecondNodeId())) {
            List<LastKnowledgeNodeInfo> secondNodeList = new ArrayList<>();
            LastKnowledgeNodeInfo secondNode = new LastKnowledgeNodeInfo();
            this.constructNodeInfoByLevel(secondNode, serialNode, 2);
            secondNodeList.add(secondNode);
            res.setKnowledgeNodeList(secondNodeList);
            if (!new Integer(1).equals(serialNode.getSecondLastLevelFlag())
                    && serialNode.getThirdNodeId() != null
                    && !"".equals(serialNode.getThirdNodeId())) {
                List<LastKnowledgeNodeInfo> thirdNodeList = new ArrayList<>();
                LastKnowledgeNodeInfo thirdNode = new LastKnowledgeNodeInfo();
                this.constructNodeInfoByLevel(thirdNode, serialNode, 3);
                thirdNodeList.add(thirdNode);
                secondNode.setKnowledgeNodeList(thirdNodeList);
            }
        }
        return res;
    }

    private void constructNodeInfoByLevel(LastKnowledgeNodeInfo res, KnowledgeSerialNodeInfoDTO serialNode, Integer level) {
        if (new Integer(1).equals(level)) {
            res.setKnowledgeNodeId(serialNode.getFirstNodeId());
            res.setKnowledgeNodeName(serialNode.getFirstNodeName());
            res.setLastLevelFlag(serialNode.getFirstLastLevelFlag());
            res.setLevel(serialNode.getFirstNodeLevel());
            res.setFrequency(serialNode.getFirstFreq());
        } else if (new Integer(2).equals(level)) {
            res.setKnowledgeNodeId(serialNode.getSecondNodeId());
            res.setKnowledgeNodeName(serialNode.getSecondNodeName());
            res.setLastLevelFlag(serialNode.getSecondLastLevelFlag());
            res.setLevel(serialNode.getSecondNodeLevel());
            res.setFrequency(serialNode.getSecondFreq());
        } else if (new Integer(3).equals(level)) {
            res.setKnowledgeNodeId(serialNode.getThirdNodeId());
            res.setKnowledgeNodeName(serialNode.getThirdNodeName());
            res.setLevel(serialNode.getThirdNodeLevel());
            res.setLastLevelFlag(serialNode.getThirdLastLevelFlag());
            res.setFrequency(serialNode.getThirdFreq());
            res.setLastLevelIds(serialNode.getFourthNodeIds());
        }
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
        // 上一个二级知识点id
        Integer preSecondLevelNodeId = 0;

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
                            }
                        }
                        // 一级相同，二级不同，组装二级
                        if (preFirstLevelNodeId.equals(reqUnit.getFirstLevelNodeId()) && !preSecondLevelNodeId.equals(reqUnit.getSecondLevelNodeId())) {
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
            preSecondLevelNodeId = reqUnit.getSecondLevelNodeId() == null ? reqUnit.getSecondLevelNodeId() : 0;
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
