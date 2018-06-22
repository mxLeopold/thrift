package com.sunlands.rpc.web.biz.model;

import java.math.BigDecimal;
import java.util.Date;

/**
 * Created by Administrator on 2017/8/9.
 */
public class ReqPaperQuestionDTO {
    private Integer id;
    private String code;
    private Integer sequence;
    private BigDecimal score;
    private Integer difficultyValue;
    private Integer parentQuestionId = 0;

    private Integer paperId;
    private Date createTime;
    private Date updateTime;
    private String operator;
    private Integer deleteFlag;
    private String questionType;  // 新增试题类型，用于试题分组
    private String sourceType; // 试题来源，用于区分真题和非真题

    public String getQuestionType() {
        return questionType;
    }

    public void setQuestionType(String questionType) {
        this.questionType = questionType;
    }

    public ReqPaperQuestionDTO() {
    }

    public ReqPaperQuestionDTO(Integer id, String code, Integer sequence, BigDecimal score, Integer difficultyValue) {
        this.id = id;
        this.code = code;
        this.sequence = sequence;
        this.score = score;
        this.difficultyValue = difficultyValue;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public Integer getSequence() {
        return sequence;
    }

    public void setSequence(Integer sequence) {
        this.sequence = sequence;
    }

    public BigDecimal getScore() {
        return score;
    }

    public void setScore(BigDecimal score) {
        this.score = score;
    }

    public Integer getDifficultyValue() {
        return difficultyValue;
    }

    public void setDifficultyValue(Integer difficultyValue) {
        this.difficultyValue = difficultyValue;
    }

    public Integer getPaperId() {
        return paperId;
    }

    public void setPaperId(Integer paperId) {
        this.paperId = paperId;
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

    public Integer getParentQuestionId() {
        return parentQuestionId;
    }

    public void setParentQuestionId(Integer parentQuestionId) {
        this.parentQuestionId = parentQuestionId;
    }

    public String getSourceType() {
        return sourceType;
    }

    public void setSourceType(String sourceType) {
        this.sourceType = sourceType;
    }

    @Override
    public String toString() {
        return "ReqPaperQuestionDTO{" +
                "id=" + id +
                ", code=" + code +
                ", sequence=" + sequence +
                ", score=" + score +
                ", difficultyValue=" + difficultyValue +
                ", parentQuestionId=" + parentQuestionId +
                ", paperId=" + paperId +
                ", createTime=" + createTime +
                ", updateTime=" + updateTime +
                ", operator='" + operator + '\'' +
                ", deleteFlag=" + deleteFlag +
                ", questionType=" + questionType +
                ", sourceType=" + sourceType +
                '}';
    }
}
