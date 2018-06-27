package com.sunlands.rpc.web.biz.model;

import java.math.BigDecimal;

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
    private BigDecimal homeworkMaxCorrectRate;
    /**
     *作业平均正确率
     */
    private BigDecimal homeworkAvgCorrectRate;
    /**
     *作业最小正确率
     */
    private BigDecimal homeworkMinCorrectRate;
    /**
     * 随堂考最大正确率
     */
    private BigDecimal quizzesMaxCorrectRate;
    /**
     * 随堂考平均正确率
     */
    private BigDecimal quizzesAvgCorrectRate;
    /**
     * 随堂考最小正确率
     */
    private BigDecimal quizzesMinCorrectRate;

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

    public BigDecimal getHomeworkMaxCorrectRate() {
        return homeworkMaxCorrectRate;
    }

    public void setHomeworkMaxCorrectRate(BigDecimal homeworkMaxCorrectRate) {
        this.homeworkMaxCorrectRate = homeworkMaxCorrectRate;
    }

    public BigDecimal getHomeworkAvgCorrectRate() {
        return homeworkAvgCorrectRate;
    }

    public void setHomeworkAvgCorrectRate(BigDecimal homeworkAvgCorrectRate) {
        this.homeworkAvgCorrectRate = homeworkAvgCorrectRate;
    }

    public BigDecimal getHomeworkMinCorrectRate() {
        return homeworkMinCorrectRate;
    }

    public void setHomeworkMinCorrectRate(BigDecimal homeworkMinCorrectRate) {
        this.homeworkMinCorrectRate = homeworkMinCorrectRate;
    }

    public BigDecimal getQuizzesMaxCorrectRate() {
        return quizzesMaxCorrectRate;
    }

    public void setQuizzesMaxCorrectRate(BigDecimal quizzesMaxCorrectRate) {
        this.quizzesMaxCorrectRate = quizzesMaxCorrectRate;
    }

    public BigDecimal getQuizzesAvgCorrectRate() {
        return quizzesAvgCorrectRate;
    }

    public void setQuizzesAvgCorrectRate(BigDecimal quizzesAvgCorrectRate) {
        this.quizzesAvgCorrectRate = quizzesAvgCorrectRate;
    }

    public BigDecimal getQuizzesMinCorrectRate() {
        return quizzesMinCorrectRate;
    }

    public void setQuizzesMinCorrectRate(BigDecimal quizzesMinCorrectRate) {
        this.quizzesMinCorrectRate = quizzesMinCorrectRate;
    }
}
