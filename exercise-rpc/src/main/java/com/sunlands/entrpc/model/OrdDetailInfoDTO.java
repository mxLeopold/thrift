package com.sunlands.entrpc.model;

/**
 * Created by tongbo on 2018/1/2.
 */
public class OrdDetailInfoDTO {

    private Integer packageId;

    private String packageName;

    private String stuPackageStatus;

    private Integer provinceId;

    private Integer ordDetailId;

    private Integer projectSecondId;

    public Integer getPackageId() {
        return packageId;
    }

    public void setPackageId(Integer packageId) {
        this.packageId = packageId;
    }

    public String getPackageName() {
        return packageName;
    }

    public void setPackageName(String packageName) {
        this.packageName = packageName;
    }

    public String getStuPackageStatus() {
        return stuPackageStatus;
    }

    public void setStuPackageStatus(String stuPackageStatus) {
        this.stuPackageStatus = stuPackageStatus;
    }

    public Integer getProvinceId() {
        return provinceId;
    }

    public void setProvinceId(Integer provinceId) {
        this.provinceId = provinceId;
    }

    public Integer getOrdDetailId() {
        return ordDetailId;
    }

    public void setOrdDetailId(Integer ordDetailId) {
        this.ordDetailId = ordDetailId;
    }

    public Integer getProjectSecondId() {
        return projectSecondId;
    }

    public void setProjectSecondId(Integer projectSecondId) {
        this.projectSecondId = projectSecondId;
    }

}
