package com.sunlands.rpc.web.biz.service;

import com.sunlands.rpc.web.biz.model.PaperDetailDTO;
import com.sunlands.rpc.web.biz.model.PaperReportDTO;
import com.sunlands.rpc.web.biz.model.StuAnswerDetailDTO;

import java.util.List;

/**
 * 新题库 - 随堂考统计数据
 * add by chenqiuxia 20180316
 */
public interface PaperReportService {

    /**
     * 作业、随堂考列表
     * @param paperCode
     * @param unitIdStr
     * @return
     */
    List<PaperReportDTO> getPaperReport(String paperCode, String unitIdStr);

    Boolean isPaperIdValid(String paperCode);

    Boolean checkPaperType(String paperCode, String type);

    List<StuAnswerDetailDTO> getStuAnswerDetails(Integer paperId, String unitIdStr);

    /**
     * 作业、随堂考详情
     * @param paperId
     * @param unitIdStr
     * @return
     */
    PaperDetailDTO getPaperDetail(String paperId, String unitIdStr);

}
