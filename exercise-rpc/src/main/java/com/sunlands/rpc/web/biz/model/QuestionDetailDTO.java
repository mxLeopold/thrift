package com.sunlands.rpc.web.biz.model;

import java.math.BigDecimal;
import java.util.List;

/**
 * 试题详情 ：试题 + 解析 + 学员答题分布
 */
public class QuestionDetailDTO {
    private Integer questionMainId;
    private Integer sequence;
    private String questionType;
    private String questionContent;
    private String analysis;
    private BigDecimal score;
    private String scoreStr; //分值 -- 后续无需再处理，thrift没有decimal类型，用str代替
    private String answer;
    private String contentType;
    private Integer questionId;
    private List<OptionDTO> optionList;
    private List<ScorePointDTO> scorePointList;
    private List<OptionAnswerDTO> stuAnswers;

    public List<OptionAnswerDTO> getStuAnswers() {
        return stuAnswers;
    }

    public void setStuAnswers(List<OptionAnswerDTO> stuAnswers) {
        this.stuAnswers = stuAnswers;
    }

    public List<ScorePointDTO> getScorePointList() {
        return scorePointList;
    }

    public void setScorePointList(List<ScorePointDTO> scorePointList) {
        this.scorePointList = scorePointList;
    }

    public Integer getQuestionId() {
        return questionId;
    }

    public void setQuestionId(Integer questionId) {
        this.questionId = questionId;
    }

    public Integer getQuestionMainId() {
        return questionMainId;
    }

    public void setQuestionMainId(Integer questionMainId) {
        this.questionMainId = questionMainId;
    }

    public Integer getSequence() {
        return sequence;
    }

    public void setSequence(Integer sequence) {
        this.sequence = sequence;
    }

    public String getQuestionType() {
        return questionType;
    }

    public void setQuestionType(String questionType) {
        this.questionType = questionType;
    }

    public String getQuestionContent() {
        return questionContent;
    }

    public void setQuestionContent(String questionContent) {
        this.questionContent = questionContent;
    }

    public String getAnalysis() {
        return analysis;
    }

    public void setAnalysis(String analysis) {
        this.analysis = analysis;
    }

    public BigDecimal getScore() {
        return score;
    }

    public void setScore(BigDecimal score) {
        this.score = score;
    }

    public String getScoreStr() {
        return scoreStr;
    }

    public void setScoreStr(String scoreStr) {
        this.scoreStr = scoreStr;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }

    public List<OptionDTO> getOptionList() {
        return optionList;
    }

    public void setOptionList(List<OptionDTO> optionList) {
        this.optionList = optionList;
    }

    public String getContentType() {
        return contentType;
    }

    public void setContentType(String contentType) {
        this.contentType = contentType;
    }

}
