package com.sunlands.rpc.web.biz.dao;

import com.sunlands.rpc.web.biz.model.*;
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
            "where a.delete_flag = 0 and a.t_paper_id = #{paperId} and a.unit_id in (#{unitIds})",
            "ORDER BY correct_question_num DESC,create_time "
    })
    List<StuAnswerDetailDTO> getStuAnswerDetails(@Param("paperId") Integer paperId, @Param("unitIds") String unitIds); // TODO: 2018/3/20 分页？

    @Select({
            "SELECT rel.question_main_id id " ,
            "from t_paper_question_rel rel,t_question_main b ",
            "WHERE rel.paper_id = #{paperId} and rel.delete_flag = 0 and rel.question_main_id=b.id and b.delete_flag=0 and b.parent_question_id=0"
    })
    List<Integer> listRelatedQuestionByPaperId(@Param("paperId") Integer paperId);

    @Select({
            "SELECT a.id questionMainId,b.sequence,a.question_type questionType,",
            "case when a.content_type='ESSAY' then (select content from t_question_content_essay where id=a.question_id)  ",
            "when a.content_type='CHOICE' then (select content from t_question_content_choice where id=a.question_id) else '' end questionContent,  ",
            "case when a.content_type='ESSAY' then (select correct_answer from t_question_content_essay where id=a.question_id)  ",
            "when a.content_type='CHOICE' then (select correct_answer from t_question_content_choice where id=a.question_id) else '' end answer,  ",
            "case when a.content_type='ESSAY' then (select analysis from t_question_content_essay where id=a.question_id)  ",
            "when a.content_type='CHOICE' then (select analysis from t_question_content_choice where id=a.question_id) else '' end analysis, ",
            "a.score,a.content_type contentType,a.question_id questionId",
            "from t_question_main a",
            "INNER JOIN t_paper_question_rel b on a.id = b.question_main_id ",
            "where a.delete_flag = 0 and b.delete_flag = 0 ",
            "and a.parent_question_id = 0 and b.paper_id = #{paperId}",
            "ORDER BY sequence"
    })
    List<QuestionDetailDTO> selectBigQuestionMainByPaperId(@Param("paperId") Integer paperId);

    @Select({
            "select a.`id`, a.`question_id` questionId, a.`sequence`, a.`option_title` optionTitle, a.`content` optionContent, a.`is_correct` correct",
            "from `t_question_content_choice_option` a  ",
            "where a.question_id= #{questionId} and a.delete_flag=0 "
    })
    List<OptionDTO> selectOptionsByQuestionId(@Param("questionId") Integer questionId);

    @Select({
            "SELECT content,score,id,essay_id questionId from t_question_content_essay_score_point where essay_id = #{questionId} and delete_flag = 0"
    })
    List<ScorePointDTO> selectScorePointsByQuestionId(@Param("questionId") Integer questionId);

    @Select({
            "SELECT id recordId,stu_id stuId,correct_question_num correctQuestionCount ",
            "from t_tiku_user_record_view ",
            "where t_paper_id = #{paperId} and unit_id in (#{unitIdStr}) ",
            "ORDER BY correct_question_num DESC,create_time LIMIT 20"
    })
    List<StuAnswerDetailDTO> selectRankingList(@Param("paperId") Integer paperId, @Param("unitIdStr") String unitIdStr);
}
