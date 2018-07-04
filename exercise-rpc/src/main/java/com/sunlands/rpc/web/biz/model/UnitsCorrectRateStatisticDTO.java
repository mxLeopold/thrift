package com.sunlands.rpc.web.biz.model;

/**
 * 课堂报告作业随堂考正确率统计数据
 *
 * @author <a herf="mailto:gaolei04@sunlands.com">Gao leilei</a>
 * @date 2018-06-26 16:35:57
 **/
public class UnitsCorrectRateStatisticDTO {
    /**
     * 课程单元ID
     */
    private String teachUnitIds;
    /**
     * 交作业人数
     */
    private Integer homeworkAnswerNum;
    /**
     * 随堂考答题人数
     */
    private Integer quizzesAnswerNum;
    /**
     *作业最大正确率
     */
    private Double homeworkMaxCorrectRate;
    /**
     *作业平均正确率
     */
    private Double homeworkAvgCorrectRate;
    /**
     *作业最小正确率
     */
    private Double homeworkMinCorrectRate;
    /**
     * 随堂考最大正确率
     */
    private Double quizzesMaxCorrectRate;
    /**
     * 随堂考平均正确率
     */
    private Double quizzesAvgCorrectRate;
    /**
     * 随堂考最小正确率
     */
    private Double quizzesMinCorrectRate;

    public String getTeachUnitIds() {
        return teachUnitIds;
    }

    public void setTeachUnitIds(String teachUnitIds) {
        this.teachUnitIds = teachUnitIds;
    }

    public Integer getHomeworkAnswerNum() {
        return homeworkAnswerNum;
    }

    public void setHomeworkAnswerNum(Integer homeworkAnswerNum) {
        this.homeworkAnswerNum = homeworkAnswerNum;
    }

    public Integer getQuizzesAnswerNum() {
        return quizzesAnswerNum;
    }

    public void setQuizzesAnswerNum(Integer quizzesAnswerNum) {
        this.quizzesAnswerNum = quizzesAnswerNum;
    }

    public Double getHomeworkMaxCorrectRate() {
        return homeworkMaxCorrectRate;
    }

    public void setHomeworkMaxCorrectRate(Double homeworkMaxCorrectRate) {
        this.homeworkMaxCorrectRate = homeworkMaxCorrectRate;
    }

    public Double getHomeworkAvgCorrectRate() {
        return homeworkAvgCorrectRate;
    }

    public void setHomeworkAvgCorrectRate(Double homeworkAvgCorrectRate) {
        this.homeworkAvgCorrectRate = homeworkAvgCorrectRate;
    }

    public Double getHomeworkMinCorrectRate() {
        return homeworkMinCorrectRate;
    }

    public void setHomeworkMinCorrectRate(Double homeworkMinCorrectRate) {
        this.homeworkMinCorrectRate = homeworkMinCorrectRate;
    }

    public Double getQuizzesMaxCorrectRate() {
        return quizzesMaxCorrectRate;
    }

    public void setQuizzesMaxCorrectRate(Double quizzesMaxCorrectRate) {
        this.quizzesMaxCorrectRate = quizzesMaxCorrectRate;
    }

    public Double getQuizzesAvgCorrectRate() {
        return quizzesAvgCorrectRate;
    }

    public void setQuizzesAvgCorrectRate(Double quizzesAvgCorrectRate) {
        this.quizzesAvgCorrectRate = quizzesAvgCorrectRate;
    }

    public Double getQuizzesMinCorrectRate() {
        return quizzesMinCorrectRate;
    }

    public void setQuizzesMinCorrectRate(Double quizzesMinCorrectRate) {
        this.quizzesMinCorrectRate = quizzesMinCorrectRate;
    }

    @Override
    public String toString() {
        return "UnitsCorrectRateStatisticDTO{" +
                "teachUnitIds='" + teachUnitIds + '\'' +
                ", homeworkAnswerNum=" + homeworkAnswerNum +
                ", quizzesAnswerNum=" + quizzesAnswerNum +
                ", homeworkMaxCorrectRate=" + homeworkMaxCorrectRate +
                ", homeworkAvgCorrectRate=" + homeworkAvgCorrectRate +
                ", homeworkMinCorrectRate=" + homeworkMinCorrectRate +
                ", quizzesMaxCorrectRate=" + quizzesMaxCorrectRate +
                ", quizzesAvgCorrectRate=" + quizzesAvgCorrectRate +
                ", quizzesMinCorrectRate=" + quizzesMinCorrectRate +
                '}';
    }
}
