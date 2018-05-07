package com.sunlands.rpc.web.biz.model;

public class RoundStatisticsDTO {
    private Integer roundId;
    private Integer totalAnswerNum; // 刷题人数
    private Integer totalQuestionAnswerNum; // 总刷题数

    public Integer getRoundId() {
        return roundId;
    }

    public void setRoundId(Integer roundId) {
        this.roundId = roundId;
    }

    public Integer getTotalAnswerNum() {
        return totalAnswerNum;
    }

    public void setTotalAnswerNum(Integer totalAnswerNum) {
        this.totalAnswerNum = totalAnswerNum;
    }

    public Integer getTotalQuestionAnswerNum() {
        return totalQuestionAnswerNum;
    }

    public void setTotalQuestionAnswerNum(Integer totalQuestionAnswerNum) {
        this.totalQuestionAnswerNum = totalQuestionAnswerNum;
    }

    @Override
    public String toString() {
        return "RoundStatistics{" +
                "roundId=" + roundId +
                ", totalAnswerNum=" + totalAnswerNum +
                ", totalQuestionAnswerNum=" + totalQuestionAnswerNum +
                '}';
    }
}
