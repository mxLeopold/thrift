package com.sunlands.rpc.web.biz.model;

import java.io.Serializable;

/**
 * @author: maxiao
 * @description:
 * @date: create in 10:48 2018/6/25
 * @modified By:
 * @copyright by sunlands
 */
public class CourseTemplateUnitFirstLevelNodeDTO implements Serializable {
    private Integer firstLevelNodeId;
    private String firstLevelNodeName;

    public Integer getFirstLevelNodeId() {
        return firstLevelNodeId;
    }

    public void setFirstLevelNodeId(Integer firstLevelNodeId) {
        this.firstLevelNodeId = firstLevelNodeId;
    }

    public String getFirstLevelNodeName() {
        return firstLevelNodeName;
    }

    public void setFirstLevelNodeName(String firstLevelNodeName) {
        this.firstLevelNodeName = firstLevelNodeName;
    }
}
