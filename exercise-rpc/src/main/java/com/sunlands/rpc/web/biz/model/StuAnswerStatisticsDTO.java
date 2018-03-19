package com.sunlands.rpc.web.biz.model;

/**
 * 试卷统计数据
 */
public class StuAnswerStatisticsDTO {
    private Integer paperId; // 试卷id
    private Integer totalNum; // 答题人数
    private Integer totalTime; // 答题总用时

    public Integer getPaperId() {
        return paperId;
    }

    public void setPaperId(Integer paperId) {
        this.paperId = paperId;
    }

    public Integer getTotalNum() {
        return totalNum;
    }

    public void setTotalNum(Integer totalNum) {
        this.totalNum = totalNum;
    }

    public Integer getTotalTime() {
        return totalTime;
    }

    public void setTotalTime(Integer totalTime) {
        this.totalTime = totalTime;
    }

}
