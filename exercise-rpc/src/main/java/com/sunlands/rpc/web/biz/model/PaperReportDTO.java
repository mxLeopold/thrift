package com.sunlands.rpc.web.biz.model;

/**
 * 随堂考统计数据
 */
public class PaperReportDTO {
    private Integer answerNumber; // 答题人数
    private Float answerTime; // 总答题时间
    private Float answerTimeAve; // 平均答题时间
    private String answerTimeAveString;
    private String answerTimeString;
    private Integer correct; // 总正确题数
    private Integer correctAve; // 平均正确题数
    private Float correctPercent; // 正确率
    private Float evaluatedScore;
    private String paperId; // 试卷id
    private String paperName; // 试卷名称
    private Float paperTotal;
    private Float paperTotalAve;
    private Float passRate;
    private Integer questionNum;  // 试题数量
    private String subjectId;
    private Integer userPaperId;
    private Integer wrong;

    public Integer getAnswerNumber() {
        return answerNumber;
    }

    public void setAnswerNumber(Integer answerNumber) {
        this.answerNumber = answerNumber;
    }

    public Float getAnswerTime() {
        return answerTime;
    }

    public void setAnswerTime(Float answerTime) {
        this.answerTime = answerTime;
    }

    public Float getAnswerTimeAve() {
        return answerTimeAve;
    }

    public void setAnswerTimeAve(Float answerTimeAve) {
        this.answerTimeAve = answerTimeAve;
    }

    public String getAnswerTimeAveString() {
        return answerTimeAveString;
    }

    public void setAnswerTimeAveString(String answerTimeAveString) {
        this.answerTimeAveString = answerTimeAveString;
    }

    public String getAnswerTimeString() {
        return answerTimeString;
    }

    public void setAnswerTimeString(String answerTimeString) {
        this.answerTimeString = answerTimeString;
    }

    public Integer getCorrect() {
        return correct;
    }

    public void setCorrect(Integer correct) {
        this.correct = correct;
    }

    public Integer getCorrectAve() {
        return correctAve;
    }

    public void setCorrectAve(Integer correctAve) {
        this.correctAve = correctAve;
    }

    public Float getCorrectPercent() {
        return correctPercent;
    }

    public void setCorrectPercent(Float correctPercent) {
        this.correctPercent = correctPercent;
    }

    public Float getEvaluatedScore() {
        return evaluatedScore;
    }

    public void setEvaluatedScore(Float evaluatedScore) {
        this.evaluatedScore = evaluatedScore;
    }

    public String getPaperId() {
        return paperId;
    }

    public void setPaperId(String paperId) {
        this.paperId = paperId;
    }

    public String getPaperName() {
        return paperName;
    }

    public void setPaperName(String paperName) {
        this.paperName = paperName;
    }

    public Float getPaperTotal() {
        return paperTotal;
    }

    public void setPaperTotal(Float paperTotal) {
        this.paperTotal = paperTotal;
    }

    public Float getPaperTotalAve() {
        return paperTotalAve;
    }

    public void setPaperTotalAve(Float paperTotalAve) {
        this.paperTotalAve = paperTotalAve;
    }

    public Float getPassRate() {
        return passRate;
    }

    public void setPassRate(Float passRate) {
        this.passRate = passRate;
    }

    public Integer getQuestionNum() {
        return questionNum;
    }

    public void setQuestionNum(Integer questionNum) {
        this.questionNum = questionNum;
    }

    public String getSubjectId() {
        return subjectId;
    }

    public void setSubjectId(String subjectId) {
        this.subjectId = subjectId;
    }

    public Integer getUserPaperId() {
        return userPaperId;
    }

    public void setUserPaperId(Integer userPaperId) {
        this.userPaperId = userPaperId;
    }

    public Integer getWrong() {
        return wrong;
    }

    public void setWrong(Integer wrong) {
        this.wrong = wrong;
    }

}
