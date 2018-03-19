package com.sunlands.rpc.api.homepage.handler;

import com.sunlands.rpc.api.biz.service.UserRecordStatisticsService;
import com.sunlands.rpc.api.homepage.service.ApiHomePageService;
import com.sunlands.rpc.common.Constant;
import com.sunlands.rpc.common.DateTimeUtil;
import com.sunlands.rpc.student.model.SubjectDTO;
import com.sunlands.rpc.student.model.TermSubjectDTO;
import com.sunlands.rpc.student.rpc.StudentRpcService;
import org.apache.thrift.TException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.*;

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
    private UserRecordStatisticsService userRecordStatisticsService;

    @Autowired
    private StudentRpcService studentRpcService;

    @Override
    public int getSubmitQuestionCount(int ordDetailId, int studentId) throws TException {
        List<TermSubjectDTO> termList = null;
        try {
            termList = studentRpcService.getAllTermSubjectByDetailId(ordDetailId);
        } catch (Exception e) {
            log.info("请求StudentRPC发生异常");
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
    public int isDailyIntelligentExerciseDone(int studentId) throws TException {
        return userRecordStatisticsService.isExerciseDone(studentId, DateTimeUtil.today(), Constant.TikuUserRecord.ExerciseTypeEnum.INTELLIGENT_EXERCISE.getCode());
    }

}
