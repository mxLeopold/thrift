package com.sunlands.rpc.api.homepage.handler;

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
        List<TermSubjectDTO> termList = null;
        try {
            termList = studentRpcService.getAllTermSubjectByDetailId(ordDetailId);
        } catch (Exception e) {
            log.error("请求StudentRPC.getAllTermSubjectByDetailId发生异常, message: {}", e.getMessage());
            return 0;
        }
        Set<Integer> subjectIdList = new HashSet<>();
        for (TermSubjectDTO term : termList) {
            for (SubjectDTO subjectDTO : term.getTermSubjects()) {
                subjectIdList.add(subjectDTO.getSubjectId());
            }
        }
        return userRecordStatisticsService.countQuestionCountBySubjectIdsAndStuId(subjectIdList, studentId);
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
                // APP那边要求董森处理RPC返回的null值, 这边不在返回hasTiku了, 如果题库没有直接返回null
                return null;
            }
        }
        if (!hasIntelligentExercise) {
            return null;
        }
        return new DailyIntelligentExerciseDTO(exerciseDone, 1, type);
    }
}
