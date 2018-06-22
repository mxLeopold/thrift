package com.sunlands.rpc.web.biz.dao;

import com.sunlands.rpc.web.biz.model.ReqSavePaperDTO;
import com.sunlands.rpc.web.biz.model.ResPaperQuestionRelationDTO;
import com.sunlands.rpc.web.biz.model.TeachPaperDTO;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.mapping.StatementType;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PaperDao {

    @Select({
            "SELECT DISTINCT pa.id, pa.code, pa.subject_id as subjectId, pa.name, pa.type, pa.invalid_flag as invalidFlag, pa.question_amount as questionAmount,  ",
            "pa.total_score as totalScore, pa.video_url as videoUrl, pa.source, pa.knowledge_tree_id as knowledgeTreeId,  ",
            "pa.exam_province as examProvince, pa.exam_session as examSession, pa.avg_difficulty_value as avgDifficultyValue,  ",
            "pa.create_time createTime, pa.creator, pa.update_time updateTime, pa.operator, pa.delete_flag as deleteFlag  ", // , pa.couldBeusedByStudents
            "from t_paper_code pa  ",
            "WHERE pa.code = #{code} and pa.delete_flag = 0 limit 1"
    })
    TeachPaperDTO selectBPaperByCode(@Param("code")String paperCode);

    @Select({
            "SELECT DISTINCT pa.id, pa.code, pa.subject_id as subjectId, pa.name, pa.type, pa.invalid_flag as invalidFlag, pa.question_amount as questionAmount,  ",
            "pa.total_score as totalScore, pa.video_url as videoUrl, pa.current_version as currentVersion, pa.source, pa.knowledge_tree_id as knowledgeTreeId,  ",
            "pa.exam_province as examProvince, pa.exam_session as examSession, pa.avg_difficulty_value as avgDifficultyValue,  ",
            "pa.create_time createTime, pa.creator, pa.update_time updateTime, pa.operator, pa.delete_flag as deleteFlag  ",
            "from t_paper pa  ",
            "WHERE pa.code = #{code} and pa.delete_flag = 0 and pa.current_version = 1 ORDER BY create_time DESC limit 1"
    })
    TeachPaperDTO selectCPaperByCode(@Param("code")String paperCode);

    @Insert({
            "INSERT INTO t_paper (`code`,subject_id,knowledge_tree_id,`name`,type,invalid_flag,question_amount,total_score,total_time,video_url,current_version,source,exam_province,exam_session,avg_difficulty_value,creator,operator,delete_flag)",
            "SELECT `code`,subject_id,knowledge_tree_id,`name`,type,invalid_flag,question_amount,total_score,total_time,video_url,1,source,exam_province,exam_session,avg_difficulty_value,creator,operator,delete_flag ",
            "from t_paper_code",
            "where `code` = #{code}"
    })
    @SelectKey(before = false, keyProperty = "paperId", resultType = Integer.class, statementType = StatementType.STATEMENT, statement = "SELECT LAST_INSERT_ID()")
    Integer insertPaper(ReqSavePaperDTO reqSavePaperDTO);

    @Insert({
            "INSERT INTO t_paper_head (paper_id,`code`,title,`value`,show_flag,show_title_flag,line_no,sequence,creator,operator,delete_flag)",
            "SELECT #{paperId},`code`,title,`value`,show_flag,show_title_flag,line_no,sequence,creator,operator,delete_flag",
            "from t_paper_code_head",
            "where paper_code = #{paperCode} and delete_flag = 0"
    })
    void insertPaperHeader(@Param("paperCode") String paperCode, @Param("paperId") Integer paperId);

    /**
     * 分id(版本)存储试卷试题关联关系-C端
     * @param paperCode
     */
    @Insert({
            "INSERT INTO t_paper_question_rel (paper_id,sequence,question_main_id,score,operator,delete_flag)",
            "SELECT #{paperId},a.sequence,b.id,a.score,a.operator,a.delete_flag",
            "from t_paper_question_code_rel a",
            "INNER JOIN t_question_main b on a.question_code = b.`code` and b.current_version = 1",
            "WHERE a.paper_code = #{paperCode} and a.delete_flag = 0 and b.delete_flag = 0"
    })
    void insertPaperQuestionRelation(@Param("paperCode") String paperCode, @Param("paperId") Integer paperId);

    @Update({
            "UPDATE t_paper SET current_version = 0, operator = #{operator} WHERE code = #{code} and current_version = 1"
    })
    Integer updatePaperByPrimaryKey(TeachPaperDTO paper);

    /**
     * 查询B端试卷内试题内容
     * @param paperCode
     * @return
     */
    @Select({
            "SELECT a.score,a.sequence,a.paper_code paperCode,b.id questionMainId",
            "from t_paper_question_code_rel a",
            "INNER JOIN t_question_main b on b.code = a.question_code and b.current_version =  1",
            "where a.paper_code = #{paperCode} ",
            "AND a.delete_flag = 0 AND b.delete_flag = 0",
            "ORDER BY a.sequence,b.id"
    })
    List<ResPaperQuestionRelationDTO> selectPaperQuestionRelations(@Param("paperCode") String paperCode);

    /**
     * 查询C端试卷内试题内容
     * @param paperId
     * @return
     */
    @Select({
            "SELECT score,sequence,paper_id paperId,question_main_id questionMainId",
            "from t_paper_question_rel",
            "where paper_id = #{paperId} AND delete_flag = 0",
            "ORDER BY sequence,question_main_id"
    })
    List<ResPaperQuestionRelationDTO> selectCurrentVersionRelations(@Param("paperId") Integer paperId);
}
