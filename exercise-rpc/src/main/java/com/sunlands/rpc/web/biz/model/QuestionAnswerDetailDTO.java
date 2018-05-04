package com.sunlands.rpc.web.biz.model;

/**
 * 刷题详情
 *
 * @author Gao leilei
 * @date 2018-05-02 11:33:47
 **/
public class QuestionAnswerDetailDTO {

    //题号
    private Integer sequence;
    //题干内容
    private String questionContent;
    //答题人数
    private Integer totalAnswerNum;
    //正确情况 1正确，2错误
    private Integer correctFlag;
    //问题ID
    private Integer questionId;
    //正确人数
    private Integer correctNum;
    //错误人数
    private Integer wrongNum;
    //正确率
    private String correctPercent;

    public Integer getSequence() {
        return sequence;
    }

    public void setSequence(Integer sequence) {
        this.sequence = sequence;
    }

    public String getQuestionContent() {
        return questionContent;
    }

    public void setQuestionContent(String questionContent) {
        this.questionContent = questionContent;
    }

    public Integer getTotalAnswerNum() {
        return totalAnswerNum;
    }

    public void setTotalAnswerNum(Integer totalAnswerNum) {
        this.totalAnswerNum = totalAnswerNum;
    }

    public Integer getCorrectNum() {
        return correctNum;
    }

    public void setCorrectNum(Integer correctNum) {
        this.correctNum = correctNum;
    }

    public Integer getWrongNum() {
        return wrongNum;
    }

    public void setWrongNum(Integer wrongNum) {
        this.wrongNum = wrongNum;
    }

    public String getCorrectPercent() {
        return correctPercent;
    }

    public void setCorrectPercent(String correctPercent) {
        this.correctPercent = correctPercent;
    }

    public Integer getCorrectFlag() {
        return correctFlag;
    }

    public void setCorrectFlag(Integer correctFlag) {
        this.correctFlag = correctFlag;
    }

    public Integer getQuestionId() {
        return questionId;
    }

    public void setQuestionId(Integer questionId) {
        this.questionId = questionId;
    }
}
