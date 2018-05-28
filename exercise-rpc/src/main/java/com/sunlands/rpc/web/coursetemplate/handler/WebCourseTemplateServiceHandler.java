package com.sunlands.rpc.web.coursetemplate.handler;

import com.sunlands.rpc.common.CourseTemplateConstants;
import com.sunlands.rpc.web.biz.dao.CourseTemplateDao;
import com.sunlands.rpc.web.coursetemplate.service.*;
import org.apache.thrift.TException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * @author gml
 */
@Component
public class WebCourseTemplateServiceHandler implements WebCourseTemplateService.Iface{
    @Autowired
    private CourseTemplateDao courseTemplateDao;
    @Override
    public List<KnowledgeTree> getCourseTemplateKnowledgeTreeListBySubjectAndType(int subjectId, String type) throws TException {
        checkType(type);
        List<KnowledgeTree> knowledgeTreeList = courseTemplateDao.queryKnowledgeTreeBySubjectAndType(subjectId, type);
        return knowledgeTreeList;
    }

    private void checkType(String type) throws TException {
        if (type == null || type.isEmpty() || (!type.equals(CourseTemplateConstants.MD_NORMAL) && !type.equals(CourseTemplateConstants.MD_CONSTRUE))) {
            throw new TException("type参数错误");
        }
    }

    @Override
    public List<CourseTemplate> getCourseTemplateListByCondition(int subjectId, String type, int knowledgeTreeId) throws TException {
        checkType(type);
        List<CourseTemplate> courseTemplateList = courseTemplateDao.queryCourseTemplateBySubjectAndType(subjectId, type, knowledgeTreeId);
        return courseTemplateList;
    }

    @Override
    public CourseTemplateDetail getCourseTemplateDetailById(int courseTemplateId) {
        CourseTemplateDetail courseTemplateDetail = courseTemplateDao.queryCourseTemplateById(courseTemplateId);
        if (courseTemplateDetail == null) {
            courseTemplateDetail = new CourseTemplateDetail();
            courseTemplateDetail.setCourseTemplateId(-1);
            return courseTemplateDetail;
        }
        return courseTemplateDetail;
    }

    @Override
    public int operateMockExam(ReqMockExam reqMockExam) throws TException{
        if (reqMockExam == null || reqMockExam.getOperateType() == null) {
            throw  new TException("reqMockExam参数错误");
        }

        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date startDate = null;
        Date endDate = null;
        try {
            startDate = df.parse(reqMockExam.getStartTime());
            endDate = df.parse(reqMockExam.getEndTime());
        } catch (ParseException e) {
            throw  new TException("时间参数解析异常");
        }
        Timestamp startTime = new Timestamp(startDate.getTime());
        Timestamp endTime = new Timestamp(endDate.getTime());
        String operatorType = reqMockExam.getOperateType();

        if (CourseTemplateConstants.CREATE.equals(operatorType)) {
            courseTemplateDao.insertMockExam(reqMockExam, startTime, endTime);
        }else if (CourseTemplateConstants.EDIT.equals(operatorType)){
            courseTemplateDao.updateMockExam(reqMockExam, startTime, endTime);
        }else if (CourseTemplateConstants.DELETE.equals(operatorType)){
            if (courseTemplateDao.deleteMockExam(reqMockExam, startTime, endTime) == 0) {
                throw  new TException("该模考正在被编辑");
            }
        }else {
            throw  new TException("reqMockExam.OperateType参数错误");
        }

        return reqMockExam.exerciseExamId;
    }
}
