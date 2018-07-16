package com.sunlands.rpc.web.biz.dao;

/**
 * @author: maxiao
 * @description:
 * @date: create in 15:51 2018/7/13
 * @modified By:
 * @copyright by sunlands
 */
public class KnowledgeSerialNodeInfoDTO {
    /**
     * 一级知识点信息
     */
    private Integer firstNodeId;
    private String firstNodeName;
    private Integer firstNodeLevel;
    private Integer firstLastLevelFlag;
    private Integer firstFreq;

    /**
     * 二级子节点信息
     */
    private Integer secondNodeId;
    private String secondNodeName;
    private Integer secondNodeLevel;
    private Integer secondLastLevelFlag;
    private Integer secondFreq;

    /**
     * 三级子节点信息
     */
    private Integer thirdNodeId;
    private String thirdNodeName;
    private Integer thirdNodeLevel;
    private Integer thirdLastLevelFlag;
    private Integer thirdFreq;

    /**
     * 四级子节点列表以','相隔
     */
    private String fourthNodeIds;

    public Integer getFirstNodeId() {
        return firstNodeId;
    }

    public void setFirstNodeId(Integer firstNodeId) {
        this.firstNodeId = firstNodeId;
    }

    public String getFirstNodeName() {
        return firstNodeName;
    }

    public void setFirstNodeName(String firstNodeName) {
        this.firstNodeName = firstNodeName;
    }

    public Integer getFirstNodeLevel() {
        return firstNodeLevel;
    }

    public void setFirstNodeLevel(Integer firstNodeLevel) {
        this.firstNodeLevel = firstNodeLevel;
    }

    public Integer getFirstLastLevelFlag() {
        return firstLastLevelFlag;
    }

    public void setFirstLastLevelFlag(Integer firstLastLevelFlag) {
        this.firstLastLevelFlag = firstLastLevelFlag;
    }

    public Integer getFirstFreq() {
        return firstFreq;
    }

    public void setFirstFreq(Integer firstFreq) {
        this.firstFreq = firstFreq;
    }

    public Integer getSecondNodeId() {
        return secondNodeId;
    }

    public void setSecondNodeId(Integer secondNodeId) {
        this.secondNodeId = secondNodeId;
    }

    public String getSecondNodeName() {
        return secondNodeName;
    }

    public void setSecondNodeName(String secondNodeName) {
        this.secondNodeName = secondNodeName;
    }

    public Integer getSecondNodeLevel() {
        return secondNodeLevel;
    }

    public void setSecondNodeLevel(Integer secondNodeLevel) {
        this.secondNodeLevel = secondNodeLevel;
    }

    public Integer getSecondLastLevelFlag() {
        return secondLastLevelFlag;
    }

    public void setSecondLastLevelFlag(Integer secondLastLevelFlag) {
        this.secondLastLevelFlag = secondLastLevelFlag;
    }

    public Integer getSecondFreq() {
        return secondFreq;
    }

    public void setSecondFreq(Integer secondFreq) {
        this.secondFreq = secondFreq;
    }

    public Integer getThirdNodeId() {
        return thirdNodeId;
    }

    public void setThirdNodeId(Integer thirdNodeId) {
        this.thirdNodeId = thirdNodeId;
    }

    public String getThirdNodeName() {
        return thirdNodeName;
    }

    public void setThirdNodeName(String thirdNodeName) {
        this.thirdNodeName = thirdNodeName;
    }

    public Integer getThirdNodeLevel() {
        return thirdNodeLevel;
    }

    public void setThirdNodeLevel(Integer thirdNodeLevel) {
        this.thirdNodeLevel = thirdNodeLevel;
    }

    public Integer getThirdLastLevelFlag() {
        return thirdLastLevelFlag;
    }

    public void setThirdLastLevelFlag(Integer thirdLastLevelFlag) {
        this.thirdLastLevelFlag = thirdLastLevelFlag;
    }

    public Integer getThirdFreq() {
        return thirdFreq;
    }

    public void setThirdFreq(Integer thirdFreq) {
        this.thirdFreq = thirdFreq;
    }

    public String getFourthNodeIds() {
        return fourthNodeIds;
    }

    public void setFourthNodeIds(String fourthNodeIds) {
        this.fourthNodeIds = fourthNodeIds;
    }
}
