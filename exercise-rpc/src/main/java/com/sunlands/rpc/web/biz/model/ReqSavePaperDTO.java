package com.sunlands.rpc.web.biz.model;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

/**
 * Created by Administrator on 2017/8/9.
 */
public class ReqSavePaperDTO {

    private Integer paperId;

    private String paperName;

    private String paperType;

    private Integer knowledgeTreeId;

    private Integer examProvinceId;

    private Integer examSessionId;

    private List<ReqPaperQuestionDTO> questionList;

    private List<ReqPaperHeadDTO> paperHead;

    private String code; // 试卷编号

    private Integer invalidFlag;

    private Integer subjectId;

    private Integer questionAmount;

    private BigDecimal totalScore;

    private Integer totalTime;

    private Integer currentVersion;

    private BigDecimal avgDifficultyValue;

    private String creator;

    private String operator;

    private Date createTime;

    private Date updateTime;

    private Integer deleteFlag;

    private String source;

    private String videoUrl;

    public Integer getPaperId() {
        return paperId;
    }

    public void setPaperId(Integer paperId) {
        this.paperId = paperId;
    }

    public String getPaperName() {
        return paperName;
    }

    public void setPaperName(String paperName) {
        this.paperName = paperName;
    }

    public String getPaperType() {
        return paperType;
    }

    public void setPaperType(String paperType) {
        this.paperType = paperType;
    }

    public Integer getKnowledgeTreeId() {
        return knowledgeTreeId;
    }

    public void setKnowledgeTreeId(Integer knowledgeTreeId) {
        this.knowledgeTreeId = knowledgeTreeId;
    }

    public Integer getExamProvinceId() {
        return examProvinceId;
    }

    public void setExamProvinceId(Integer examProvinceId) {
        this.examProvinceId = examProvinceId;
    }

    public Integer getExamSessionId() {
        return examSessionId;
    }

    public void setExamSessionId(Integer examSessionId) {
        this.examSessionId = examSessionId;
    }

    public List<ReqPaperQuestionDTO> getQuestionList() {
        return questionList;
    }

    public void setQuestionList(List<ReqPaperQuestionDTO> questionList) {
        this.questionList = questionList;
    }

    public List<ReqPaperHeadDTO> getPaperHead() {
        return paperHead;
    }

    public void setPaperHead(List<ReqPaperHeadDTO> paperHead) {
        this.paperHead = paperHead;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public Integer getInvalidFlag() {
        return invalidFlag;
    }

    public void setInvalidFlag(Integer invalidFlag) {
        this.invalidFlag = invalidFlag;
    }

    public Integer getSubjectId() {
        return subjectId;
    }

    public void setSubjectId(Integer subjectId) {
        this.subjectId = subjectId;
    }

    public Integer getQuestionAmount() {
        return questionAmount;
    }

    public void setQuestionAmount(Integer questionAmount) {
        this.questionAmount = questionAmount;
    }

    public BigDecimal getTotalScore() {
        return totalScore;
    }

    public void setTotalScore(BigDecimal totalScore) {
        this.totalScore = totalScore;
    }

    public Integer getTotalTime() {
        return totalTime;
    }

    public void setTotalTime(Integer totalTime) {
        this.totalTime = totalTime;
    }

    public Integer getCurrentVersion() {
        return currentVersion;
    }

    public void setCurrentVersion(Integer currentVersion) {
        this.currentVersion = currentVersion;
    }

    public BigDecimal getAvgDifficultyValue() {
        return avgDifficultyValue;
    }

    public void setAvgDifficultyValue(BigDecimal avgDifficultyValue) {
        this.avgDifficultyValue = avgDifficultyValue;
    }

    public String getCreator() {
        return creator;
    }

    public void setCreator(String creator) {
        this.creator = creator;
    }

    public String getOperator() {
        return operator;
    }

    public void setOperator(String operator) {
        this.operator = operator;
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

    public Integer getDeleteFlag() {
        return deleteFlag;
    }

    public void setDeleteFlag(Integer deleteFlag) {
        this.deleteFlag = deleteFlag;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public String getVideoUrl() {
        return videoUrl;
    }

    public void setVideoUrl(String videoUrl) {
        this.videoUrl = videoUrl;
    }
}
