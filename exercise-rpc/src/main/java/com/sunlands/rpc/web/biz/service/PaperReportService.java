package com.sunlands.rpc.web.biz.service;

import com.sunlands.rpc.web.biz.model.PaperDetailDTO;
import com.sunlands.rpc.web.biz.model.StuAnswerDetailDTO;
import com.sunlands.rpc.web.biz.model.WorkPaperReportDTO;
import com.sunlands.rpc.web.biz.model.WorkPaperReportListDTO;

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
    WorkPaperReportDTO getPaperReport(String paperCode, String unitIdStr);

    List<StuAnswerDetailDTO> getStuAnswerDetails(Integer paperId, String unitIdStr, Integer pageIndex, Integer pageSize);

    /**
     * 下载学员成绩详情
     * @param paperId
     * @param unitIdStr
     */
    void downloadStuAnswerDetails(Integer paperId, String unitIdStr);
    /**
     * 作业、随堂考详情
     * @param paperId
     * @param unitIdStr
     * @return
     */
    PaperDetailDTO getPaperDetail(String paperId, String unitIdStr);

    /**
     * 校验试卷ID、类型
     * @param paperCode
     * @param type
     */
    int checkPaperId(String paperCode, String type);

    /**
     * 查询作业、随堂考统计数据
     * @param workPaperReportListDTO
     */
    void selectWorkPaperReport(WorkPaperReportListDTO workPaperReportListDTO);

}
