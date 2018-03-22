package com.sunlands.rpc.web.biz.model;

import java.util.List;

public class WorkPaperReportListDTO {
    protected String field1;  // unitIdStr
    protected String field2;
    protected String field3;
    protected String field4;
    protected String field5;
    protected String paperId;
    protected String paperName;
    protected String paperTypeCode;
    protected List<WorkPaperReportDTO> result;
    protected String systemNumber;
    protected String userNumber;
    protected Float userPaperPoint;
    protected String workGroupId; // paperCode

    public String getField1() {
        return field1;
    }

    public void setField1(String field1) {
        this.field1 = field1;
    }

    public String getField2() {
        return field2;
    }

    public void setField2(String field2) {
        this.field2 = field2;
    }

    public String getField3() {
        return field3;
    }

    public void setField3(String field3) {
        this.field3 = field3;
    }

    public String getField4() {
        return field4;
    }

    public void setField4(String field4) {
        this.field4 = field4;
    }

    public String getField5() {
        return field5;
    }

    public void setField5(String field5) {
        this.field5 = field5;
    }

    public String getPaperId() {
        return paperId;
    }

    public void setPaperId(String paperId) {
        this.paperId = paperId;
    }

    public String getPaperName() {
        return paperName;
    }

    public void setPaperName(String paperName) {
        this.paperName = paperName;
    }

    public String getPaperTypeCode() {
        return paperTypeCode;
    }

    public void setPaperTypeCode(String paperTypeCode) {
        this.paperTypeCode = paperTypeCode;
    }

    public List<WorkPaperReportDTO> getResult() {
        return result;
    }

    public void setResult(List<WorkPaperReportDTO> result) {
        this.result = result;
    }

    public String getSystemNumber() {
        return systemNumber;
    }

    public void setSystemNumber(String systemNumber) {
        this.systemNumber = systemNumber;
    }

    public String getUserNumber() {
        return userNumber;
    }

    public void setUserNumber(String userNumber) {
        this.userNumber = userNumber;
    }

    public Float getUserPaperPoint() {
        return userPaperPoint;
    }

    public void setUserPaperPoint(Float userPaperPoint) {
        this.userPaperPoint = userPaperPoint;
    }

    public String getWorkGroupId() {
        return workGroupId;
    }

    public void setWorkGroupId(String workGroupId) {
        this.workGroupId = workGroupId;
    }

}
