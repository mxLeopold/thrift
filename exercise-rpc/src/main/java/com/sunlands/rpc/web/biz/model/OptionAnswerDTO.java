package com.sunlands.rpc.web.biz.model;

/**
 * 选项分布
 *
 *
 */
public class OptionAnswerDTO {
    private String questionResult; // 选项
    private Integer answerTotal; // 答题人数

    public String getQuestionResult() {
        return questionResult;
    }

    public void setQuestionResult(String questionResult) {
        this.questionResult = questionResult;
    }

    public Integer getAnswerTotal() {
        return answerTotal;
    }

    public void setAnswerTotal(Integer answerTotal) {
        this.answerTotal = answerTotal;
    }

}
