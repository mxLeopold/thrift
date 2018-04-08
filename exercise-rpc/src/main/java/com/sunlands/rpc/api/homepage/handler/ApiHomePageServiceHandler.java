package com.sunlands.rpc.api.homepage.handler;

import com.sunlands.entrpc.model.OrdDetailInfoDTO;
import com.sunlands.entrpc.model.SubjectDTO;
import com.sunlands.entrpc.model.TermSubjectDTO;
import com.sunlands.entrpc.service.StudentRpcService;
import com.sunlands.rpc.api.biz.service.UserRecordStatisticsService;
import com.sunlands.rpc.api.homepage.service.ApiHomePageService;
import com.sunlands.rpc.api.homepage.service.DailyIntelligentExerciseDTO;
import com.sunlands.rpc.common.Constant;
import com.sunlands.rpc.common.DateTimeUtil;
import org.apache.thrift.TException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * B端首页服务处理器
 *
 * @Author: 吴雨佳
 * @since: 2018/3/16 20:35
 * @update: [变更日期yyyy-MM-dd][变更人姓名][变更描述]
 */
@Component
public class ApiHomePageServiceHandler implements ApiHomePageService.Iface {

    private static final Logger log = LoggerFactory.getLogger(ApiHomePageServiceHandler.class);

    @Autowired
    UserRecordStatisticsService userRecordStatisticsService;

    @Autowired
    StudentRpcService studentRpcService;

    @Override
    public int getSubmitQuestionCount(int ordDetailId, int studentId) throws TException {
        OrdDetailInfoDTO detailInfo = null;
        try {
            detailInfo = studentRpcService.getStuValidOrdDetail(studentId, ordDetailId);
        } catch (Exception e) {
            log.error("请求StudentRPC.getStuValidOrdDetail 发生异常, message: {}", e.getMessage());
            throw new RuntimeException("请求StudentRPC.getStuValidOrdDetail 发生异常, message: " + e.getMessage());
        }
        Integer provinceId = 0;
        Integer projectSecondId = 0;
        if (detailInfo != null) {
            provinceId = detailInfo.getProvinceId();
            projectSecondId = detailInfo.getProjectSecondId();
        }
        // 获取用户对应子订单的全部科目
        List<TermSubjectDTO> termSubjectList = null;
        try {
            termSubjectList = studentRpcService.getAllTermSubjectByDetailId(ordDetailId);
        } catch (Exception e) {
            log.error("请求StudentRPC.getAllTermSubjectByDetailId 发生异常, message: {}", e.getMessage());
            throw new RuntimeException("请求StudentRPC.getAllTermSubjectByDetailId发生异常, message: " + e.getMessage());
        }
        // 科目ID集合(可能有科目跨学期的情况)-查询科目上课时长使用
        Set<Integer> subjectIdSet = new HashSet<>(32);
        // 科目对应的知识树ID集合-查询科目下题目数量和做题数量使用
        Set<Integer> knowledgeTreeIdSet = new HashSet<>(32);

        for (TermSubjectDTO termSubjectDTO : termSubjectList) {
            List<SubjectDTO> termSubjects = termSubjectDTO.getTermSubjects();
            if (CollectionUtils.isEmpty(termSubjects)) {
                continue;
            }
            for (SubjectDTO termSubject : termSubjects) {
                subjectIdSet.add(termSubject.getSubjectId());
                Integer knowledgeTreeId = userRecordStatisticsService.queryKnowledgeTreeIdByCondition(termSubject.getSubjectId(),
                        provinceId, projectSecondId);
                if (knowledgeTreeId != null) {
                    knowledgeTreeIdSet.add(knowledgeTreeId);
                }
            }
        }
        return userRecordStatisticsService.countQuestionCountByKnowledgeIdsAndStuId(knowledgeTreeIdSet, studentId);
    }

    @Override
    public DailyIntelligentExerciseDTO isDailyIntelligentExerciseDone(int studentId) throws TException {
        // 说明, 返回结果集里的TIKU是董森下游需要用的字段. 本RPC直接返回默认值TIKU
        final String type = "tiku";
        // 查询今日智能练习是否完成
        int exerciseDone = userRecordStatisticsService.isExerciseDone(studentId, DateTimeUtil.today(), Constant.TikuUserRecord.ExerciseTypeEnum.INTELLIGENT_EXERCISE.getCode());
        boolean hasIntelligentExercise = true;
        if (exerciseDone == 0) {
            try {
                hasIntelligentExercise = studentRpcService.hasIntelligentExercise(studentId);
            } catch (Exception e) {
                log.error("请求StudentRPC.getSubjectIdsByStudentId 发生异常, message: {}", e.getMessage());
                return new DailyIntelligentExerciseDTO(0, 0,  type);
            }
        }
        return new DailyIntelligentExerciseDTO(exerciseDone, hasIntelligentExercise ? 1 : 0, type);
    }
}
