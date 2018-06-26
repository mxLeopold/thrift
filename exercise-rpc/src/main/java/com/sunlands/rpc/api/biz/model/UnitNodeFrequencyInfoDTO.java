package com.sunlands.rpc.api.biz.model;

/**
 * @author: maxiao
 * @description:
 * @date: create in 12:00 2018/6/25
 * @modified By:
 * @copyright by sunlands
 */
public class UnitNodeFrequencyInfoDTO {
    private Integer extremelyHighFrequencyCount;
    private Integer highFrequencyCount;
    private Integer midFrequencyCount;

    public Integer getExtremelyHighFrequencyCount() {
        return extremelyHighFrequencyCount;
    }

    public void setExtremelyHighFrequencyCount(Integer extremelyHighFrequencyCount) {
        this.extremelyHighFrequencyCount = extremelyHighFrequencyCount;
    }

    public Integer getHighFrequencyCount() {
        return highFrequencyCount;
    }

    public void setHighFrequencyCount(Integer highFrequencyCount) {
        this.highFrequencyCount = highFrequencyCount;
    }

    public Integer getMidFrequencyCount() {
        return midFrequencyCount;
    }

    public void setMidFrequencyCount(Integer midFrequencyCount) {
        this.midFrequencyCount = midFrequencyCount;
    }
}
