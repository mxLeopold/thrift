package com.sunlands.rpc.web.biz.model;

/**
 * 查询学员作业随堂考
 *
 * @author <a herf="mailto:gaolei04@sunlands.com">Gao leilei</a>
 * @date 2018-06-22 16:37:32
 **/
public class UnitReportConditionDTO {
    /**
     * 课程单元ID(用,分隔)
     */
    private String unitIds;
    /**
     * 课后作业试卷ID
     */
    private String homeworkId;
    /**
     * 随堂考试卷ID
     */
    private String quizzesGroupId;
    /**
     *学员名称
     */
    private String userName;
    /**
     *学员ID
     */
    private Integer userId;
    /**
     *出勤状态，ALL_ATTEND:全部，NOT_ATTEND:未出勤，IS_ATTEND:已出勤
     */
    private String attendStatus;
    /**
     *评价分数筛选条件，ALL_EVALUATE_SCORE:全部，LEVEL1_EVALUATE_SCORE:1-3分，LEVEL2_EVALUATE_SCORE:4-5分
     */
    private String evaluateScore;
    /**
     *随堂考正确率排序，RATE_SORT_ORIGIN:还原，RATE_SORT_ASC:升序，RATE_SORT_DESC:降序
     */
    private String quizzesSort;
    /**
     *作业正确率排序，RATE_SORT_ORIGIN:还原，RATE_SORT_ASC:升序，RATE_SORT_DESC:降序
     */
    private String homeworkSort;
    private Integer pageNo;
    private Integer pageSize ;

    public String getUnitIds() {
        return unitIds;
    }

    public void setUnitIds(String unitIds) {
        this.unitIds = unitIds;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getAttendStatus() {
        return attendStatus;
    }

    public void setAttendStatus(String attendStatus) {
        this.attendStatus = attendStatus;
    }

    public String getEvaluateScore() {
        return evaluateScore;
    }

    public void setEvaluateScore(String evaluateScore) {
        this.evaluateScore = evaluateScore;
    }

    public String getQuizzesSort() {
        return quizzesSort;
    }

    public void setQuizzesSort(String quizzesSort) {
        this.quizzesSort = quizzesSort;
    }

    public String getHomeworkSort() {
        return homeworkSort;
    }

    public void setHomeworkSort(String homeworkSort) {
        this.homeworkSort = homeworkSort;
    }

    public Integer getPageNo() {
        return pageNo;
    }

    public void setPageNo(Integer pageNo) {
        this.pageNo = pageNo;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

    public String getHomeworkId() {
        return homeworkId;
    }

    public void setHomeworkId(String homeworkId) {
        this.homeworkId = homeworkId;
    }

    public String getQuizzesGroupId() {
        return quizzesGroupId;
    }

    public void setQuizzesGroupId(String quizzesGroupId) {
        this.quizzesGroupId = quizzesGroupId;
    }
}
