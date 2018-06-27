package com.sunlands.rpc.web.biz.model;

import java.math.BigDecimal;

/**
 * 一个轮次下的多个课程单元的综合统计数据
 *
 * @author <a herf="mailto:gaolei04@sunlands.com">Gao leilei</a>
 * @date 2018-06-25 11:45:14
 **/
public class ResUnitsStatisticDTO {
    /**
     * 轮次ID
     */
    private Integer roundId;
    /**
     * 该轮次下所有的课程单元ID（用,分隔）
     */
    private String teachUnitIds;
    /**
     * 老师ID
     */
    private Integer teacherId;
    /**'
     * 作业得分率
     */
    private BigDecimal homeworkScoreRate;
    /**
     * 作业完成率
     */
    private BigDecimal homeworkCompleteRate;
    /**
     * 随堂考得分率
     */
    private BigDecimal quizzesScoreRate;
    /**
     * 随堂考完成率
     */
    private BigDecimal quizzesCompleteRate;

    public Integer getRoundId() {
        return roundId;
    }

    public void setRoundId(Integer roundId) {
        this.roundId = roundId;
    }

    public String getTeachUnitIds() {
        return teachUnitIds;
    }

    public void setTeachUnitIds(String teachUnitIds) {
        this.teachUnitIds = teachUnitIds;
    }

    public Integer getTeacherId() {
        return teacherId;
    }

    public void setTeacherId(Integer teacherId) {
        this.teacherId = teacherId;
    }

    public BigDecimal getHomeworkScoreRate() {
        return homeworkScoreRate;
    }

    public void setHomeworkScoreRate(BigDecimal homeworkScoreRate) {
        this.homeworkScoreRate = homeworkScoreRate;
    }

    public BigDecimal getHomeworkCompleteRate() {
        return homeworkCompleteRate;
    }

    public void setHomeworkCompleteRate(BigDecimal homeworkCompleteRate) {
        this.homeworkCompleteRate = homeworkCompleteRate;
    }

    public BigDecimal getQuizzesScoreRate() {
        return quizzesScoreRate;
    }

    public void setQuizzesScoreRate(BigDecimal quizzesScoreRate) {
        this.quizzesScoreRate = quizzesScoreRate;
    }

    public BigDecimal getQuizzesCompleteRate() {
        return quizzesCompleteRate;
    }

    public void setQuizzesCompleteRate(BigDecimal quizzesCompleteRate) {
        this.quizzesCompleteRate = quizzesCompleteRate;
    }
}
