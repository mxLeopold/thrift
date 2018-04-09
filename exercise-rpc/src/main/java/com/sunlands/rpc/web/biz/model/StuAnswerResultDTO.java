package com.sunlands.rpc.web.biz.model;

import java.util.List;

public class StuAnswerResultDTO {
    private Integer countPerPage;
    private Integer pageCount;
    private Integer pageIndex;
    private List<StuAnswerDetailDTO> resultList;
    private Integer totalCount;
    private String paperId;
    private String field1;
    private String paperTypeCode;
    private String systemNumber;

    public Integer getCountPerPage() {
        return countPerPage;
    }

    public void setCountPerPage(Integer countPerPage) {
        this.countPerPage = countPerPage;
    }

    public Integer getPageCount() {
        return pageCount;
    }

    public void setPageCount(Integer pageCount) {
        this.pageCount = pageCount;
    }

    public Integer getPageIndex() {
        return pageIndex;
    }

    public void setPageIndex(Integer pageIndex) {
        this.pageIndex = pageIndex;
    }

    public List<StuAnswerDetailDTO> getResultList() {
        return resultList;
    }

    public void setResultList(List<StuAnswerDetailDTO> resultList) {
        this.resultList = resultList;
    }

    public Integer getTotalCount() {
        return totalCount;
    }

    public void setTotalCount(Integer totalCount) {
        this.totalCount = totalCount;
    }

    public String getPaperId() {
        return paperId;
    }

    public void setPaperId(String paperId) {
        this.paperId = paperId;
    }

    public String getField1() {
        return field1;
    }

    public void setField1(String field1) {
        this.field1 = field1;
    }

    public String getPaperTypeCode() {
        return paperTypeCode;
    }

    public void setPaperTypeCode(String paperTypeCode) {
        this.paperTypeCode = paperTypeCode;
    }

    public String getSystemNumber() {
        return systemNumber;
    }

    public void setSystemNumber(String systemNumber) {
        this.systemNumber = systemNumber;
    }

}
