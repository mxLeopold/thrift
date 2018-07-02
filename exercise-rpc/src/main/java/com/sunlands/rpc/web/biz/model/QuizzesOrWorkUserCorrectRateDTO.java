package com.sunlands.rpc.web.biz.model;

/**
 * 学员在课程下作业随堂考的答题情况
 *
 * @author <a herf="mailto:gaolei04@sunlands.com">Gao leilei</a>
 * @date 2018-06-22 16:18:07
 **/
public class QuizzesOrWorkUserCorrectRateDTO {
    private Integer stuId;
    private Double quizzesCorrectRate;
    private Double homeworkCorrectRate;

    public Integer getStuId() {
        return stuId;
    }

    public void setStuId(Integer stuId) {
        this.stuId = stuId;
    }

    public Double getQuizzesCorrectRate() {
        return quizzesCorrectRate;
    }

    public void setQuizzesCorrectRate(Double quizzesCorrectRate) {
        this.quizzesCorrectRate = quizzesCorrectRate;
    }

    public Double getHomeworkCorrectRate() {
        return homeworkCorrectRate;
    }

    public void setHomeworkCorrectRate(Double homeworkCorrectRate) {
        this.homeworkCorrectRate = homeworkCorrectRate;
    }
}
