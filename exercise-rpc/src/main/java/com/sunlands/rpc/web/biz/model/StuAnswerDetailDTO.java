package com.sunlands.rpc.web.biz.model;

import com.sun.tools.corba.se.idl.StringGen;

/**
 * 学员成绩详情
 * add by chenqiuxia 20180319
 */
public class StuAnswerDetailDTO {
    private Integer stuId;
    private String stuName;
    private Integer totalTime;
    private Integer correctQuestionCount;
    private Integer wrongQuestionCount;
    private String accuracyRate;
    private Integer recordId;
    private Integer questionNum;
    private double score;
    private Integer paperId;

    public Integer getPaperId() {
        return paperId;
    }

    public void setPaperId(Integer paperId) {
        this.paperId = paperId;
    }

    public double getScore() {
        return score;
    }

    public void setScore(double score) {
        this.score = score;
    }

    public Integer getStuId() {
        return stuId;
    }

    public void setStuId(Integer stuId) {
        this.stuId = stuId;
    }

    public String getStuName() {
        return stuName;
    }

    public void setStuName(String stuName) {
        this.stuName = stuName;
    }

    public Integer getTotalTime() {
        return totalTime;
    }

    public void setTotalTime(Integer totalTime) {
        this.totalTime = totalTime;
    }

    public Integer getCorrectQuestionCount() {
        return correctQuestionCount;
    }

    public void setCorrectQuestionCount(Integer correctQuestionCount) {
        this.correctQuestionCount = correctQuestionCount;
    }

    public Integer getWrongQuestionCount() {
        return wrongQuestionCount;
    }

    public void setWrongQuestionCount(Integer wrongQuestionCount) {
        this.wrongQuestionCount = wrongQuestionCount;
    }

    public String getAccuracyRate() {
        return accuracyRate;
    }

    public void setAccuracyRate(String accuracyRate) {
        this.accuracyRate = accuracyRate;
    }

    public Integer getRecordId() {
        return recordId;
    }

    public void setRecordId(Integer recordId) {
        this.recordId = recordId;
    }

    public Integer getQuestionNum() {
        return questionNum;
    }

    public void setQuestionNum(Integer questionNum) {
        this.questionNum = questionNum;
    }

}
