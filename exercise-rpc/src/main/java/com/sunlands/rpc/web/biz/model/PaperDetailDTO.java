package com.sunlands.rpc.web.biz.model;

import java.util.List;

/**
 * 作业、随堂考详情
 * add by chenqiuxia 20180319
 */
public class PaperDetailDTO {
    private Integer paperId;
    private String code; // 试卷code
    private String paperName;
    private Integer answerNum;
    private List<StuAnswerDetailDTO> ranking;
    private List<QuestionDetailDTO> questionDetailList;

    public Integer getPaperId() {
        return paperId;
    }

    public void setPaperId(Integer paperId) {
        this.paperId = paperId;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getPaperName() {
        return paperName;
    }

    public void setPaperName(String paperName) {
        this.paperName = paperName;
    }

    public Integer getAnswerNum() {
        return answerNum;
    }

    public void setAnswerNum(Integer answerNum) {
        this.answerNum = answerNum;
    }

    public List<StuAnswerDetailDTO> getRanking() {
        return ranking;
    }

    public void setRanking(List<StuAnswerDetailDTO> ranking) {
        this.ranking = ranking;
    }

    public List<QuestionDetailDTO> getQuestionDetailList() {
        return questionDetailList;
    }

    public void setQuestionDetailList(List<QuestionDetailDTO> questionDetailList) {
        this.questionDetailList = questionDetailList;
    }

}
