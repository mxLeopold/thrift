package com.sunlands.rpc.web.biz.model;

import java.util.Date;

/**
 * 考试统计信息
 *
 * addby chenqiuxia 20180328
 */
public class TikuExamStatisticsDTO {
    private Integer id;
    private Integer paperId;
    private Integer unitId;
    private Integer totalAnswerNum;
    private Integer totalAnswerTime;
    private Integer totalCorrectNum;
    private String operator;
    private Integer deleteFlag;
    private Date createTime;
    private Date updateTime;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getPaperId() {
        return paperId;
    }

    public void setPaperId(Integer paperId) {
        this.paperId = paperId;
    }

    public Integer getUnitId() {
        return unitId;
    }

    public void setUnitId(Integer unitId) {
        this.unitId = unitId;
    }

    public Integer getTotalAnswerNum() {
        return totalAnswerNum;
    }

    public void setTotalAnswerNum(Integer totalAnswerNum) {
        this.totalAnswerNum = totalAnswerNum;
    }

    public Integer getTotalAnswerTime() {
        return totalAnswerTime;
    }

    public void setTotalAnswerTime(Integer totalAnswerTime) {
        this.totalAnswerTime = totalAnswerTime;
    }

    public Integer getTotalCorrectNum() {
        return totalCorrectNum;
    }

    public void setTotalCorrectNum(Integer totalCorrectNum) {
        this.totalCorrectNum = totalCorrectNum;
    }

    public String getOperator() {
        return operator;
    }

    public void setOperator(String operator) {
        this.operator = operator;
    }

    public Integer getDeleteFlag() {
        return deleteFlag;
    }

    public void setDeleteFlag(Integer deleteFlag) {
        this.deleteFlag = deleteFlag;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

}
