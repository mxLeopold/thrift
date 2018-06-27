package com.sunlands.rpc.web.biz.service;

import com.sunlands.rpc.web.biz.model.*;

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

    StuAnswerResultDTO getStuAnswerResult(StuAnswerResultDTO stuAnswerResultDTO);

    //刷题详情
    List<QuestionAnswerDetailDTO> getQuestionAnswerDetails(String paperCode,Integer roundId);
    //刷题详情总数目
    Integer getQuestionAnswerTotal(String paperCode,Integer roundId);

    List<RoundStatisticsDTO> getRoundStatistics(List<Integer> roundIds);

    /**
     * 查询课堂报告列表的学员课后作业/随堂考正确率
     * @param unitReportConditionDTO
     * @return
     */
    List<QuizzesOrWorkUserCorrectRateDTO> getQuizzesOrWorkUserCorrectRate(UnitReportConditionDTO unitReportConditionDTO);

    /**
     * 根据该轮次下的课程单元ID查询该轮次下的统计数据
     * @param roundId
     * @param teachUnitIds
     * @return
     */
    ResUnitsStatisticDTO retrieveQuizOrHomeworkInfo(Integer roundId, String teachUnitIds,Integer teacherId);
    /**
     * 根据课程单元ID查询该轮次下的作业随堂考正确率的统计数据
     * @param teachUnitIds
     * @return
     */
    UnitsCorrectRateStatisticDTO retrieveQuizOrHomeworkCorrectInfo(String teachUnitIds);

}
