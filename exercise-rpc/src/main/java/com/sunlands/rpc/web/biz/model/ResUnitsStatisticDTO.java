package com.sunlands.rpc.web.biz.model;

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
    private Double homeworkScoreRate;
    /**
     * 作业完成率
     */
    private Double homeworkCompleteRate;
    /**
     * 随堂考得分率
     */
    private Double quizzesScoreRate;
    /**
     * 随堂考完成率
     */
    private Double quizzesCompleteRate;

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

    public Double getHomeworkScoreRate() {
        return homeworkScoreRate;
    }

    public void setHomeworkScoreRate(Double homeworkScoreRate) {
        this.homeworkScoreRate = homeworkScoreRate;
    }

    public Double getHomeworkCompleteRate() {
        return homeworkCompleteRate;
    }

    public void setHomeworkCompleteRate(Double homeworkCompleteRate) {
        this.homeworkCompleteRate = homeworkCompleteRate;
    }

    public Double getQuizzesScoreRate() {
        return quizzesScoreRate;
    }

    public void setQuizzesScoreRate(Double quizzesScoreRate) {
        this.quizzesScoreRate = quizzesScoreRate;
    }

    public Double getQuizzesCompleteRate() {
        return quizzesCompleteRate;
    }

    public void setQuizzesCompleteRate(Double quizzesCompleteRate) {
        this.quizzesCompleteRate = quizzesCompleteRate;
    }

    @Override
    public String toString() {
        return "ResUnitsStatisticDTO{" +
                "roundId=" + roundId +
                ", teachUnitIds='" + teachUnitIds + '\'' +
                ", teacherId=" + teacherId +
                ", homeworkScoreRate=" + homeworkScoreRate +
                ", homeworkCompleteRate=" + homeworkCompleteRate +
                ", quizzesScoreRate=" + quizzesScoreRate +
                ", quizzesCompleteRate=" + quizzesCompleteRate +
                '}';
    }
}
