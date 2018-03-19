package com.sunlands.rpc.student.model;

import java.util.List;

/**
 * Created by tongbo on 2018/1/2.
 */
public class TermSubjectDTO {

    private Integer term;

    /**
     * 是否当前学期 1-是，0-不是
     */
    private Integer currentTermFlag;

    private List<SubjectDTO> termSubjects;

    public Integer getTerm() {
        return term;
    }

    public void setTerm(Integer term) {
        this.term = term;
    }

    public Integer getCurrentTermFlag() {
        return currentTermFlag;
    }

    public void setCurrentTermFlag(Integer currentTermFlag) {
        this.currentTermFlag = currentTermFlag;
    }

    public List<SubjectDTO> getTermSubjects() {
        return termSubjects;
    }

    public void setTermSubjects(List<SubjectDTO> termSubjects) {
        this.termSubjects = termSubjects;
    }

}
