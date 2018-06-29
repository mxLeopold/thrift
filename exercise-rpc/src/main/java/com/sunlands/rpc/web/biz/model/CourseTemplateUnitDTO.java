package com.sunlands.rpc.web.biz.model;

import java.io.Serializable;
import java.util.List;

/**
 * @author: maxiao
 * @description:
 * @date: create in 10:46 2018/6/25
 * @modified By:
 * @copyright by sunlands
 */
public class CourseTemplateUnitDTO implements Serializable {

    private Integer templateUnitId;
    private List<CourseTemplateUnitFirstLevelNodeDTO> firstLevelNodes;

    public Integer getTemplateUnitId() {
        return templateUnitId;
    }

    public void setTemplateUnitId(Integer templateUnitId) {
        this.templateUnitId = templateUnitId;
    }

    public List<CourseTemplateUnitFirstLevelNodeDTO> getFirstLevelNodes() {
        return firstLevelNodes;
    }

    public void setFirstLevelNodes(List<CourseTemplateUnitFirstLevelNodeDTO> firstLevelNodes) {
        this.firstLevelNodes = firstLevelNodes;
    }
}
