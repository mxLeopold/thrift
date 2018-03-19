package com.sunlands.rpc.web.biz.dao;

import com.sunlands.rpc.web.biz.model.PaperDTO;
import com.sunlands.rpc.web.biz.model.PaperReportDTO;
import com.sunlands.rpc.web.biz.model.StuAnswerDetailDTO;
import com.sunlands.rpc.web.biz.model.StuAnswerStatisticsDTO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface PaperReportMapper {
    /**
     * 查询C端试卷
     * @param paperCode
     * @return
     */
    @Select({
            "select id,code,name,type,question_amount questionAmount,total_score totalScore,avg_difficulty_value avgDifficultyValue,",
            "create_time createTime,update_time updateTime,creator,operator,delete_flag deleteFlag",
            " from t_paper where delete_flag = 0 and code = #{paperCode} order by create_time desc limit 1"
    })
    PaperDTO selectPapeByCode(@Param("paperCode") String paperCode);


    /**
     * 查询作业、随堂考学员答题记录
     * @param paperId
     * @param unitIds
     * @return
     */
    @Select({
        "SELECT count(a.id) answerNumber,sum(a.correct_question_num) correct,sum(a.total_time) answerTime ",
        "from t_tiku_user_record_view a ",
        "where a.t_paper_id = #{paperId} and a.delete_flag = 0 ",
        "and a.unit_id in (#{unitIds})"
    })
    PaperReportDTO selectPaperReport(@Param("paperId") Integer paperId, @Param("unitIds") String unitIds);

    /**
     * 查询学员成绩详情
     * @param paperId
     * @param unitIds
     * @return
     */
    @Select({
            "SELECT a.stu_id stuId,a.total_time totalTime,a.correct_question_num correctQuestionCount,a.question_num - a.correct_question_num wrongQuestionCount,a.id recordId",
            "from t_tiku_user_record_view a ",
            "where a.delete_flag = 0 and a.t_paper_id = #{paperId} and a.unit_id in (#{unitIds})"
    })
    List<StuAnswerDetailDTO> getStuAnswerDetails(@Param("paperId") Integer paperId, @Param("unitIds") String unitIds);
}
