package com.sunlands.rpc.web.biz.dao;

import com.sunlands.rpc.web.biz.model.PaperDTO;
import com.sunlands.rpc.web.biz.model.QuizzesPaperReportDTO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface QuizzesPaperReportMapper {
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
     * 查询随堂考列表
     * @param paperId
     * @param unitIds
     * @return
     */
    @Select({
        ""
    })
    List<QuizzesPaperReportDTO> selectQuizzesPaperReport(@Param("paperId") Integer paperId, @Param("unitIds") List<String> unitIds);
}
