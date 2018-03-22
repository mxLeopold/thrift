package com.sunlands.rpc.web.biz.model;

import java.math.BigDecimal;
import java.util.Date;

/**
 * 学员答题实体类 对应t_tiku_user_question（分表）
 *
 * @author Chen WeiJie
 * @date 2018-01-10 19:08
 **/
public class TikuUserQuestionDTO {

    /**
     * 主键id
     */
    private Integer id;

    /**
     * 学员id
     */
    private Integer stuId;

    /**
     * 答题记录id
     */
    private Integer recordId;

    /**
     * 题序号
     */
    private Integer sequence;

    /**
     * 试卷id，当为真题练习时填入，默认为0
     */
    private Integer tPaperId;

    /**
     * 所属知识树id
     */
    private Integer knowledgeTreeId;

    /**
     * 题型
     */
    private String questionType;

    /**
     * 所属知识树节点id
     */
    private Integer knowledgeNodeId;

    /**
     * 科目id
     */
    private Integer subjectId;

    /**
     * 所做题目（大题）id
     */
    private Integer questionMainId;

    /**
     * 所做题目（具体作答小题）id
     */
    private Integer questionSubId;

    /**
     * 学员答案
     */
    private String stuAnswer;

    /**
     * 作答用时,单位为s
     */
    private Integer answerTime;

    /**
     * 试题分数
     */
    private BigDecimal questionScore;

    /**
     * 学员得分
     */
    private BigDecimal stuScore;

    /**
     * 是否正确
     */
    private Integer correctFlag;

    /**
     * 创建时间
     */
    private Date createTime;

    /**
     * 修改时间
     */
    private Date updateTime;

    /**
     * 操作人
     */
    private String operator;

    /**
     * 逻辑删除位
     */
    private Integer deleteFlag;

    /**
     * 阅卷方式
     */
    private Integer markPaperWay;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getStuId() {
        return stuId;
    }

    public void setStuId(Integer stuId) {
        this.stuId = stuId;
    }

    public Integer getRecordId() {
        return recordId;
    }

    public void setRecordId(Integer recordId) {
        this.recordId = recordId;
    }

    public Integer getSequence() {
        return sequence;
    }

    public void setSequence(Integer sequence) {
        this.sequence = sequence;
    }

    public Integer gettPaperId() {
        return tPaperId;
    }

    public void settPaperId(Integer tPaperId) {
        this.tPaperId = tPaperId;
    }

    public Integer getKnowledgeTreeId() {
        return knowledgeTreeId;
    }

    public void setKnowledgeTreeId(Integer knowledgeTreeId) {
        this.knowledgeTreeId = knowledgeTreeId;
    }

    public String getQuestionType() {
        return questionType;
    }

    public void setQuestionType(String questionType) {
        this.questionType = questionType;
    }

    public Integer getKnowledgeNodeId() {
        return knowledgeNodeId;
    }

    public void setKnowledgeNodeId(Integer knowledgeNodeId) {
        this.knowledgeNodeId = knowledgeNodeId;
    }

    public Integer getSubjectId() {
        return subjectId;
    }

    public void setSubjectId(Integer subjectId) {
        this.subjectId = subjectId;
    }

    public Integer getQuestionMainId() {
        return questionMainId;
    }

    public void setQuestionMainId(Integer questionMainId) {
        this.questionMainId = questionMainId;
    }

    public Integer getQuestionSubId() {
        return questionSubId;
    }

    public void setQuestionSubId(Integer questionSubId) {
        this.questionSubId = questionSubId;
    }

    public String getStuAnswer() {
        return stuAnswer;
    }

    public void setStuAnswer(String stuAnswer) {
        this.stuAnswer = stuAnswer;
    }

    public Integer getAnswerTime() {
        return answerTime;
    }

    public void setAnswerTime(Integer answerTime) {
        this.answerTime = answerTime;
    }

    public BigDecimal getQuestionScore() {
        return questionScore;
    }

    public void setQuestionScore(BigDecimal questionScore) {
        this.questionScore = questionScore;
    }

    public BigDecimal getStuScore() {
        return stuScore;
    }

    public void setStuScore(BigDecimal stuScore) {
        this.stuScore = stuScore;
    }

    public Integer getCorrectFlag() {
        return correctFlag;
    }

    public void setCorrectFlag(Integer correctFlag) {
        this.correctFlag = correctFlag;
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

    public Integer getMarkPaperWay() {
        return markPaperWay;
    }

    public void setMarkPaperWay(Integer markPaperWay) {
        this.markPaperWay = markPaperWay;
    }

    @Override
    public String toString() {
        return "TikuUserQuestion{" +
                "id=" + id +
                ", stuId=" + stuId +
                ", recordId=" + recordId +
                ", sequence=" + sequence +
                ", tPaperId=" + tPaperId +
                ", knowledgeTreeId=" + knowledgeTreeId +
                ", questionType='" + questionType + '\'' +
                ", knowledgeNodeId=" + knowledgeNodeId +
                ", subjectId=" + subjectId +
                ", questionMainId=" + questionMainId +
                ", questionSubId=" + questionSubId +
                ", stuAnswer='" + stuAnswer + '\'' +
                ", answerTime=" + answerTime +
                ", questionScore=" + questionScore +
                ", stuScore=" + stuScore +
                ", correctFlag=" + correctFlag +
                ", createTime=" + createTime +
                ", updateTime=" + updateTime +
                ", operator='" + operator + '\'' +
                ", deleteFlag=" + deleteFlag +
                ", markPaperWay=" + markPaperWay +
                '}';
    }
}
