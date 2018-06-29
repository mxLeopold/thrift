package com.sunlands.rpc.web.biz.model;

import java.util.List;

/**
 * @author: maxiao
 * @description:
 * @date: create in 11:56 2018/6/25
 * @modified By:
 * @copyright by sunlands
 */
public class UnitNodeInfoDTO {
    private Integer knowledgeNodeId;
    private String knowledgeNodeName;
    private UnitNodeFrequencyInfoDTO nodeFrequencyInfo;
    private List<UnitNodeInfoDTO> knowledgeNodeList;

    public Integer getKnowledgeNodeId() {
        return knowledgeNodeId;
    }

    public void setKnowledgeNodeId(Integer knowledgeNodeId) {
        this.knowledgeNodeId = knowledgeNodeId;
    }

    public String getKnowledgeNodeName() {
        return knowledgeNodeName;
    }

    public void setKnowledgeNodeName(String knowledgeNodeName) {
        this.knowledgeNodeName = knowledgeNodeName;
    }

    public UnitNodeFrequencyInfoDTO getNodeFrequencyInfo() {
        return nodeFrequencyInfo;
    }

    public void setNodeFrequencyInfo(UnitNodeFrequencyInfoDTO nodeFrequencyInfo) {
        this.nodeFrequencyInfo = nodeFrequencyInfo;
    }

    public List<UnitNodeInfoDTO> getKnowledgeNodeList() {
        return knowledgeNodeList;
    }

    public void setKnowledgeNodeList(List<UnitNodeInfoDTO> knowledgeNodeList) {
        this.knowledgeNodeList = knowledgeNodeList;
    }
}
