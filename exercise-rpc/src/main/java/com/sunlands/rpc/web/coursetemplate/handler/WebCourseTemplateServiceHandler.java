package com.sunlands.rpc.web.coursetemplate.handler;

import com.sunlands.rpc.web.biz.model.UnitNodeFrequencyInfoDTO;
import com.sunlands.rpc.web.biz.model.UnitNodeInfoDTO;
import com.sunlands.rpc.common.CourseTemplateConstants;
import com.sunlands.rpc.web.biz.dao.CourseTemplateDao;
import com.sunlands.rpc.web.biz.service.CourseTemplateService;
import com.sunlands.rpc.web.biz.service.PaperService;
import com.sunlands.rpc.web.coursetemplate.service.*;
import org.apache.thrift.TException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

/**
 * @author gml
 */
@Component
public class WebCourseTemplateServiceHandler implements WebCourseTemplateService.Iface{
    @Autowired
    private CourseTemplateDao courseTemplateDao;
    @Autowired
    private PaperService paperService;

    @Autowired
    private CourseTemplateService courseTemplateService;

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
            Integer paperId = paperService.getCurrentPaperId(reqMockExam.getPaperCode());
            courseTemplateDao.insertMockExam(reqMockExam, startTime, endTime, paperId);
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

    @Override
    public List<List<UnitNodeInfo>> retrieveCourseTemplateInfoById(int courseTemplateId) throws TException {
        List<List<UnitNodeInfo>> rst = new ArrayList<>();
        List<List<UnitNodeInfoDTO>> unitsNodeInfo = courseTemplateService.retrieveCourseTemplateInfoById(courseTemplateId);
        Iterator<List<UnitNodeInfoDTO>> iterator = unitsNodeInfo.iterator();
        for (; iterator.hasNext(); ) {
            List<UnitNodeInfoDTO> unitNodeInfo = iterator.next();
            List<UnitNodeInfo> svUnitNodeInfo = this.transferUnitsToSvUnits(unitNodeInfo);
            rst.add(svUnitNodeInfo);
        }
        return rst;
    }

    private List<UnitNodeInfo> transferUnitsToSvUnits(List<UnitNodeInfoDTO> req) {
        List<UnitNodeInfo> res = new ArrayList<>();
        Iterator<UnitNodeInfoDTO> iterator = req.iterator();
        for ( ; iterator.hasNext(); ) {
            UnitNodeInfoDTO unitFirstLevelNode = iterator.next();
            UnitNodeInfo svUnitNode = new UnitNodeInfo();
            svUnitNode.setKnowledgeNodeId(unitFirstLevelNode.getKnowledgeNodeId());
            svUnitNode.setKnowledgeNodeName(unitFirstLevelNode.getKnowledgeNodeName());
            UnitNodeFrequencyInfoDTO reqNodeFrequency = unitFirstLevelNode.getNodeFrequencyInfo();
            NodeFrequencyInfo svNodeFrequencyInfo = transferNodeFrequencyToSvNodeFrequency(reqNodeFrequency);
            svUnitNode.setNodeFrequencyInfo(svNodeFrequencyInfo);
            List<UnitNodeInfo> svKnowledgeNodeList = new ArrayList<>();
            List<UnitNodeInfoDTO> knowledgeNodeList = unitFirstLevelNode.getKnowledgeNodeList();
            if (knowledgeNodeList != null && knowledgeNodeList.size() > 0) {
                Iterator<UnitNodeInfoDTO> unitNodeIterator = knowledgeNodeList.iterator();
                for ( ; unitNodeIterator.hasNext(); ) {
                    UnitNodeInfoDTO unitSecondNode = unitNodeIterator.next();
                    UnitNodeInfo svUnitSecondNode = new UnitNodeInfo();
                    svUnitSecondNode.setKnowledgeNodeId(unitSecondNode.getKnowledgeNodeId());
                    svUnitSecondNode.setKnowledgeNodeName(unitSecondNode.getKnowledgeNodeName());
                    svUnitSecondNode.setNodeFrequencyInfo(transferNodeFrequencyToSvNodeFrequency(unitSecondNode.getNodeFrequencyInfo()));
                    svKnowledgeNodeList.add(svUnitSecondNode);
                }
            }
            svUnitNode.setKnowledgeNodeList(svKnowledgeNodeList);
            res.add(svUnitNode);
        }
        return res;
    }

    private NodeFrequencyInfo transferNodeFrequencyToSvNodeFrequency(UnitNodeFrequencyInfoDTO req) {
        NodeFrequencyInfo res = null;
        if (req != null
                &&
                !(new Integer(0).equals(req.getMidFrequencyCount())
                        && new Integer(0).equals(req.getHighFrequencyCount())
                        && new Integer(0).equals(req.getExtremelyHighFrequencyCount()))) {
            res = new NodeFrequencyInfo();
            res.setMidFrequencyCount(req.getMidFrequencyCount());
            res.setHighFrequencyCount(req.getHighFrequencyCount());
            res.setExtremelyHighFrequencyCount(req.getExtremelyHighFrequencyCount());
        }
        return res;
    }
}
