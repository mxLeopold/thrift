package com.sunlands.entrpc.service.impl;

import com.sunlands.entrpc.model.EntSubjectIdListDTO;
import com.sunlands.entrpc.model.SubjectDTO;
import com.sunlands.entrpc.model.TermSubjectDTO;
import com.sunlands.entrpc.service.StudentRpcService;
import com.sunlands.entrpc.thriftservice.ApiStudentService;
import com.sunlands.entrpc.thriftservice.Subject;
import com.sunlands.entrpc.thriftservice.SubjectKnowledgeTreeDTO;
import com.sunlands.entrpc.thriftservice.termSubject;
import org.apache.thrift.TException;
import org.apache.thrift.protocol.TBinaryProtocol;
import org.apache.thrift.protocol.TProtocol;
import org.apache.thrift.protocol.TProtocolFactory;
import org.apache.thrift.transport.THttpClient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * 类描述
 *
 * @Author: 吴雨佳
 * @since: 2018/3/19 13:59
 * @update: [变更日期yyyy-MM-dd][变更人姓名][变更描述]
 */
@Service
public class StudentRpcServiceImpl implements StudentRpcService {

    private static final Logger log = LoggerFactory.getLogger(StudentRpcServiceImpl.class);

    @Value("${service.student-service-url:}")
    private String rpcServerUrl;

    private static TProtocol protocol = null;

    /**
     * 获取RPC客户端实例
     * @return
     */
    private ApiStudentService.Client getClientInstance() {
        if (null == protocol) {
            try {
                TProtocolFactory protocolFactory = new TBinaryProtocol.Factory();
                protocol = protocolFactory.getProtocol(new THttpClient(rpcServerUrl));
            } catch (Exception e) {
                log.error(e.getMessage());
            }
        }
        return new ApiStudentService.Client(protocol);
    }

    @Override
    public List<TermSubjectDTO> getAllTermSubjectByDetailId(Integer detailId) throws Exception {
        if (detailId == null) {
            throw new RuntimeException("传入参数detailId为空!");
        }
        List<TermSubjectDTO> res = new ArrayList<>();
        try {
            log.info("请求RPC接口getAllTermSubjectByDetailId");
            ApiStudentService.Client client = getClientInstance();
            List<termSubject> rstList = client.getAllTermSubjectByDetailId(detailId);
            if (null != rstList) {
                log.info("共获取到" + rstList.size() + "条结果");
                formatTermSubjectList(res, rstList);
            } else {
                log.info("请求RPC接口返回结果NULL");
            }
        } catch (Exception e) {
            log.error("调用接口失败！" + e.getMessage(), e);
            throw new RuntimeException("调用RPC接口getAllTermSubjectByDetailId失败！传入参数:" + "detailId=" + detailId + ";报错信息:" + e.getMessage());
        }
        return res;
    }

    @Override
    public EntSubjectIdListDTO getSubjectIdsByDetailId(Integer detailId) throws Exception {
        if (detailId == null) {
            throw new RuntimeException("传入参数detailId为空!");
        }
        SubjectKnowledgeTreeDTO subjectHasKnowledgeTree = null;
        try {
            log.info("请求RPC接口 getSubjectIdsByDetailId");
            ApiStudentService.Client client = getClientInstance();
            subjectHasKnowledgeTree = client.getSubjectHasKnowledgeTree(detailId);
        } catch (TException e) {
            log.error("调用接口失败！" + e.getMessage(), e);
            throw new RuntimeException("调用RPC接口 getSubjectIdsByDetailId 失败！传入参数:" + "detailId=" + detailId + ";报错信息:" + e.getMessage());
        }
        if (null == subjectHasKnowledgeTree) {
            return new EntSubjectIdListDTO();
        }
        EntSubjectIdListDTO result = new EntSubjectIdListDTO();
        result.setHasKnowledgeTree(subjectHasKnowledgeTree.getHasKnowledgeTree());
        result.setSubjectIds(subjectHasKnowledgeTree.getSubjectIdList());
        return result;
    }

    private void formatTermSubjectList(List<TermSubjectDTO> res, List<termSubject> rsts) {
        for (termSubject item : rsts) {
            TermSubjectDTO resItem = getTermSubjectDTO(item);
            res.add(resItem);
        }
    }

    private TermSubjectDTO getTermSubjectDTO(termSubject item) {
        TermSubjectDTO resItem = new TermSubjectDTO();
        resItem.setTerm(item.getTerm());
        resItem.setCurrentTermFlag(item.getCurrentTerm());
        List<SubjectDTO> subjectList = new ArrayList<>();
        for (Subject subjectItem : item.getTermSubjects()) {
            subjectList.add(formatSubjectDTO(subjectItem));
        }
        resItem.setTermSubjects(subjectList);
        return resItem;
    }

    private SubjectDTO formatSubjectDTO(Subject item) {
        SubjectDTO resItem = new SubjectDTO();
        resItem.setSubjectId(item.getSubjectId());
        resItem.setSubjectName(item.getSubjectName());
        return resItem;
    }
}
