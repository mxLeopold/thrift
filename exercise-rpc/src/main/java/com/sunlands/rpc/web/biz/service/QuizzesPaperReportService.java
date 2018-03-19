package com.sunlands.rpc.web.biz.service;

import com.sunlands.rpc.web.biz.model.PaperReportDTO;

import java.util.List;

/**
 * 新题库 - 随堂考统计数据
 * add by chenqiuxia 20180316
 */
public interface QuizzesPaperReportService {

    /**
     * 随堂考列表
     * @param paperCode
     * @param unitIdStr
     * @return
     */
    List<PaperReportDTO> getPaperReport(String paperCode, String unitIdStr);

}
