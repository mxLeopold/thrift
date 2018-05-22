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

        for (KnowledgeTree knowledgeTree : knowledgeTreeList) {
            List<Integer> provinceList = courseTemplateDao.queryProvinceByKnowledgeTreeId(knowledgeTree.getKnowledgeTreeId());
            String provinces = getProvinceString(provinceList);
            knowledgeTree.setProvinces(provinces);
        }
        return knowledgeTreeList;
    }

    private void checkType(String type) throws TException {
        if (type == null || type.isEmpty() || (!type.equals(CourseTemplateConstants.MD_NORMAL) && !type.equals(CourseTemplateConstants.MD_CONSTRUE))) {
            throw new TException("type参数错误");
        }
    }

    private String getProvinceString(List<Integer> provinces) {
        if (provinces == null) {
            return null;
        }
        StringBuilder builder = new StringBuilder();
        for (Integer id : provinces) {
            builder.append(id + " ");
        }
        String result = builder.toString();
        return result.substring(0, result.length());
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
        List<CourseTemplateUnit> courseTemplateUnitList = courseTemplateDao.queryCourseTemplateUnitByCourseTemplateId(courseTemplateId);

        for (CourseTemplateUnit unit : courseTemplateUnitList) {
            int templateUnitId = unit.getTemplateUnitId();
            List<Integer> knowledgeNodeList = courseTemplateDao.queryKnowledgeNodeIdByTemplateUnitId(templateUnitId);
            List<String> quizCodeList = courseTemplateDao.queryPaperByTemplateUnitId(templateUnitId, CourseTemplateConstants.QUIZ);
            List<String> assignmentsCodeList = courseTemplateDao.queryPaperByTemplateUnitId(templateUnitId, CourseTemplateConstants.ASSIGNMENTS);
            List<CourseTemplateUnitFile> courseTemplateUnitFileList = courseTemplateDao.queryCourseTemplateUnitFileByTemplateUnitId(templateUnitId);

            unit.setKnowledgeNodeIdList(knowledgeNodeList);
            unit.setQuizPaperCodeList(quizCodeList);
            unit.setAssignmentPaperCodeList(assignmentsCodeList);
            unit.setFileList(courseTemplateUnitFileList);
        }
        courseTemplateDetail.setTemplateUnitList(courseTemplateUnitList);

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
        int flag = -1;

        if (CourseTemplateConstants.CREATE.equals(operatorType)) {
            flag = courseTemplateDao.insertMockExam(reqMockExam, startTime, endTime);
        }else if (CourseTemplateConstants.EDIT.equals(operatorType)){
            flag = courseTemplateDao.updateMockExam(reqMockExam, startTime, endTime);
        }else if (CourseTemplateConstants.DELETE.equals(operatorType)){
            flag = courseTemplateDao.deleteMockExam(reqMockExam);
        }

        if (flag == -1) {
            throw  new TException("reqMockExam.OperateType参数错误");
        }
        return reqMockExam.exerciseExamId;
    }
}
