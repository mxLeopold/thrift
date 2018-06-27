package com.sunlands.rpc.web.biz.model;

/**
 * 学员在课程下作业随堂考的答题情况
 *
 * @author <a herf="mailto:gaolei04@sunlands.com">Gao leilei</a>
 * @date 2018-06-22 16:18:07
 **/
public class QuizzesOrWorkUserCorrectRateDTO {
    private Integer stuId;
    private Integer unitId;
    private String exerciseType;
    private Double correctRate;

    public Integer getStuId() {
        return stuId;
    }

    public void setStuId(Integer stuId) {
        this.stuId = stuId;
    }

    public Integer getUnitId() {
        return unitId;
    }

    public void setUnitId(Integer unitId) {
        this.unitId = unitId;
    }

    public String getExerciseType() {
        return exerciseType;
    }

    public void setExerciseType(String exerciseType) {
        this.exerciseType = exerciseType;
    }

    public Double getCorrectRate() {
        return correctRate;
    }

    public void setCorrectRate(Double correctRate) {
        this.correctRate = correctRate;
    }
}
