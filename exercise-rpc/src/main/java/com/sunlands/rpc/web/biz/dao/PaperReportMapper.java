package com.sunlands.rpc.web.biz.dao;

import com.sunlands.rpc.web.biz.model.*;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface PaperReportMapper {
    /**
     * 查询B端试卷
     * @param code
     * @return
     */
    @Select({
            "select id,code,name,type,question_amount questionAmount,total_score totalScore,avg_difficulty_value avgDifficultyValue,",
            "create_time createTime,update_time updateTime,creator,operator,delete_flag deleteFlag",
            "from t_paper_code where delete_flag = 0 and code = #{code}"
    })
    PaperDTO selectPaperCodeByCode(@Param("code") String code);
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
    PaperDTO selectPaperByCode(@Param("paperCode") String paperCode);


    /**
     * 查询作业、随堂考--考试统计数据：参考人数、总答对题数，总用时
     * @param paperId
     * @param unitIds
     * @return
     */
    @Select({
            "<script>",
            "SELECT SUM(total_answer_num) answerNumber,SUM(total_correct_num) correct,SUM(total_answer_time) answerTime ",
            "from t_tiku_exam_statistics ",
            "where delete_flag = 0 and t_paper_id = #{paperId} AND unit_id in",
            "<foreach item=\"item\" index=\"index\" collection=\"unitIds\"  open=\"(\" separator=\",\" close=\")\"  >#{item}</foreach>",
            "</script>"
    })
    WorkPaperReportDTO selectPaperReport(@Param("paperId") Integer paperId, @Param("unitIds") List<String> unitIds);

    /**
     * 查询考试统计数据 
     * @param paperId
     * @param unitIdList
     * @return
     */
    @Select({
            "<script>",
            "select id,t_paper_id paperId,unit_id unitId,total_answer_num totalAnswerNum,total_answer_time totalAnswerTime,operator,delete_flag deleteFlag,create_time createTime,update_time updateTime  ",
            "from t_tiku_exam_statistics  ",
            "where delete_flag = 0 and t_paper_id = #{paperId} and unit_id in  ",
            "<foreach item=\"item\" index=\"index\" collection=\"unitIdList\"  open=\"(\" separator=\",\" close=\")\"  >#{item}</foreach>",
            "</script>"
    })
    List<TikuExamStatisticsDTO> selectByPaperIdAndUnitId(@Param("paperId") Integer paperId, @Param("unitIdList") List<String> unitIdList);

    /**
     * 查询参考人数
     * @param paperId
     * @param unitIdList
     * @return
     */
    @Select({
            "<script>",
            "select ifnull(sum(total_answer_num),0) ",
            "from t_tiku_exam_statistics  ",
            "where delete_flag = 0 and t_paper_id = #{paperId} and unit_id in  ",
            "<foreach item=\"item\" index=\"index\" collection=\"unitIdList\"  open=\"(\" separator=\",\" close=\")\"  >#{item}</foreach>",
            "</script>"
    })
    int selectTotalAnswerNum(@Param("paperId") Integer paperId, @Param("unitIdList") List<String> unitIdList);
    /**
     * 查询学员答题记录
     * @param index
     * @param paperId
     * @param unitIdStr
     * @param pageIndex
     * @param pageSize
     * @return
     */
    @Select({
            "<script>",
            "SELECT id,stu_id stuId,total_time totalTime,correct_question_num correctQuestionCount,question_num - correct_question_num wrongQuestionCount,record_id recordId,question_num questionNum, stu_total_score score",
            "from t_tiku_exam_user_statistics_${index} ",
            "where t_paper_id = #{paperId} AND unit_id in ",
            "<foreach item=\"item\" index=\"index\" collection=\"unitIdStr\"  open=\"(\" separator=\",\" close=\")\"  >#{item}</foreach>",
            " and delete_flag = 0",
            "ORDER BY correct_question_num DESC,create_time",
            "<if test = \"pageIndex != null and pageSize != null\">limit #{pageIndex},#{pageSize}</if>",
            "</script>"
    })
    List<StuAnswerDetailDTO> getStuAnswerDetails(@Param("index") Integer index, @Param("paperId") Integer paperId, @Param("unitIdStr") List<String> unitIdStr,
                                       @Param("pageIndex") Integer pageIndex, @Param("pageSize")Integer pageSize);

    @Select({
            "<script>",
            "SELECT count(id)",
            "from t_tiku_exam_user_statistics_${index} ",
            "where t_paper_id = #{paperId} AND unit_id in ",
            "<foreach item=\"item\" index=\"index\" collection=\"unitIdStr\"  open=\"(\" separator=\",\" close=\")\"  >#{item}</foreach>",
            " and delete_flag = 0",
            "</script>"
    })
    int getStuAnswerDetailsCount(@Param("index") Integer index, @Param("paperId") Integer paperId, @Param("unitIdStr") List<String> unitIdStr);

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

    /**
     * 查询选项分布
     * @param tableNameIndex
     * @param paperId
     * @param unitIdList
     * @param questionMainId
     * @return
     */
    @Select({
            "<script>",
            "SELECT `option` questionResult,sum(total_answer_num) answerTotal ",
            "from t_tiku_exam_question_answer_statistics_${tableNameIndex}  ",
            "WHERE delete_flag = 0 and t_paper_id = #{paperId} and unit_id in ",
            "<foreach item=\"item\" index=\"index\" collection=\"unitIdList\"  open=\"(\" separator=\",\" close=\")\"  >#{item}</foreach>",
            "and question_main_id = #{questionMainId} ",
            "GROUP BY `option`",
            "</script>"
    })
    List<OptionAnswerDTO> selectStuAnswers(@Param("tableNameIndex") Integer tableNameIndex,
                                           @Param("paperId") Integer paperId, @Param("unitIdList") List<String> unitIdList, @Param("questionMainId") Integer questionMainId);

    /**
     * 考试内排名根据答对题数排序
     * @param paperId
     * @param unitIdList
     * @return
     */
    @Select({
            "<script>",
            "SELECT stu_id stuId, correct_question_num correctQuestionCount, t_paper_id paperId ",
            "from t_tiku_exam_user_statistics_${tableNameIndex} ",
            "where delete_flag = 0 and t_paper_id = #{paperId} and unit_id in",
            "<foreach item=\"item\" index=\"index\" collection=\"unitIdList\"  open=\"(\" separator=\",\" close=\")\"  >#{item}</foreach>",
            "ORDER BY correct_question_num DESC,create_time LIMIT 20",
            "</script>"
    })
    List<StuAnswerDetailDTO> selectRankingList(@Param("tableNameIndex") Integer tableNameIndex,@Param("paperId") Integer paperId, @Param("unitIdList") List<String> unitIdList);

    @Select({
            "SELECT a.id,a.stu_id stuId,a.`name` name,a.sequence sequence,a.exercise_type exerciseType, ",
            "a.t_paper_id paperId,a.unit_id unitId,a.question_num questionNum,a.total_time totalTime,a.stu_total_score stuTotalScore ",
            "from t_tiku_user_record_view a where a.t_paper_id = #{paperId} and a.delete_flag = 0 and a.unit_id in (#{unitIdStr})"
    })
    List<TikuUserRecordDTO> selectUserRecord(@Param("paperId") Integer paperId, @Param("unitIdStr") String unitIdStr);

    /**
     * 查询学员答题详情
     * @param tableNameIndex
     * @param recordId
     * @return
     */
    @Select({
            "SELECT id,stu_id stuId,record_id recordId,sequence,t_paper_id tPaperId,t_knowledge_tree_id knowledgeTreeId, ",
            "t_knowledge_node_id knowledgeNodeId,question_type questionType,subject_id subjectId,question_main_id questionMainId, ",
            "question_sub_id questionSubId,stu_answer stuAnswer,answer_time answerTime,question_score questionScore,stu_score stuScore, ",
            "correct_flag correctFlag,create_time createTime,update_time updateTime,operator,delete_flag deleteFlag  ",
            "from t_tiku_user_question_${tableNameIndex} ",
            "where delete_flag = 0 and record_id = #{recordId}"
    })
    List<TikuUserQuestionDTO> selectUserQuestion(@Param("tableNameIndex") String tableNameIndex, @Param("recordId") Integer recordId);

    @Select({
            "SELECT g.sequence sequence,f.content questionContent,d.correct_flag correctFlag,SUM(d.total_answer_num) totalAnswerNum,e.id questionId " ,
            "FROM t_tiku_exam_statistics a " ,
            "INNER JOIN t_paper b On a.t_paper_id=b.id AND b.delete_flag=0 " ,
            "INNER JOIN t_paper_code c ON b.`code`=c.`code` AND c.code = #{paperCode} AND c.delete_flag=0 " ,
            "INNER JOIN t_tiku_exam_question_answer_statistics_0 d ON d.round_id=a.round_id AND d.t_paper_id=b.id AND d.delete_flag=0 " ,
            "INNER JOIN t_question_main e ON e.id = d.question_main_id AND e.question_type IN ('SINGLE_CHOICE','JUDGE_CHOICE','MULTI_CHOICE') AND e.delete_flag=0 " ,
            "INNER JOIN t_question_content_choice f ON f.id = e.question_id AND f.delete_flag=0 " ,
            "INNER JOIN t_paper_question_code_rel g ON g.paper_code = c.`code` AND g.question_code=e.`code` AND g.delete_flag=0 " ,
            "WHERE a.delete_flag=0 AND a.exercise_type='GROUP_EXERCISE' AND a.round_id = #{roundId} " ,
            "GROUP BY c.`code`,a.round_id,g.sequence,f.content,d.correct_flag,e.id "
    })
    List<QuestionAnswerDetailDTO> queryQuestionAnswerDetails(@Param("paperCode") String paperCode,
                                                          @Param("roundId") Integer roundId);


    @Select({
            "SELECT COUNT(0) FROM (" ,
            "SELECT COUNT(0) " ,
            "FROM t_tiku_exam_statistics a " ,
            "INNER JOIN t_paper b On a.t_paper_id=b.id AND b.delete_flag=0 " ,
            "INNER JOIN t_paper_code c ON b.`code`=c.`code` AND c.code = #{paperCode} AND c.delete_flag=0 " ,
            "INNER JOIN t_tiku_exam_question_answer_statistics_0 d ON d.round_id=a.round_id AND d.t_paper_id=b.id AND d.delete_flag=0 " ,
            "INNER JOIN t_question_main e ON e.id = d.question_main_id AND e.question_type IN ('SINGLE_CHOICE','JUDGE_CHOICE','MULTI_CHOICE') AND e.delete_flag=0 " ,
            "INNER JOIN t_question_content_choice f ON f.id = e.question_id AND f.delete_flag=0 " ,
            "INNER JOIN t_paper_question_code_rel g ON g.paper_code = c.`code` AND g.question_code=e.`code` AND g.delete_flag=0 " ,
            "WHERE a.delete_flag=0 AND a.exercise_type='GROUP_EXERCISE' AND a.round_id = #{roundId} " ,
            "GROUP BY c.`code`,a.round_id,g.sequence,f.content,e.id " ,
            ") t"
    })
    Integer queryQuestionAnswerTotal(@Param("paperCode") String paperCode,@Param("roundId") Integer roundId);

    /**
     * 批量查询轮次统计数据
     * @param roundIds
     * @return
     */
    @Select({
            "<script>",
            "SELECT round_id roundId, sum(total_answer_num) totalAnswerNum, SUM(total_question_answer_num) totalQuestionAnswerNum ",
            "FROM t_tiku_exam_statistics ",
            "WHERE delete_flag = 0 AND round_id IN ",
            "<foreach item=\"item\" index=\"index\" collection=\"roundIds\"  open=\"(\" separator=\",\" close=\")\"  >#{item}</foreach>",
            "GROUP BY round_id",
            "</script>"
    })
    List<RoundStatisticsDTO> getRoundStatistics(@Param("roundIds") List<Integer> roundIds);

}
