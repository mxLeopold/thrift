package com.sunlands.rpc.test.web;

import com.sunlands.rpc.web.coursetemplate.handler.WebCourseTemplateServiceHandler;
import com.sunlands.rpc.web.coursetemplate.service.*;
import org.apache.thrift.TException;
import org.apache.thrift.protocol.TBinaryProtocol;
import org.apache.thrift.protocol.TProtocol;
import org.apache.thrift.transport.THttpClient;
import org.apache.thrift.transport.TTransport;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.junit4.SpringRunner;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@DirtiesContext
public class WebCourseTemplateServiceTest {
    @Autowired
    WebCourseTemplateServiceHandler webCourseTemplateServiceHandler;
    @Test
    public void getCourseTemplateKnowledgeTreeListBySubjectAndType(){
        try {
            List<KnowledgeTree> list = webCourseTemplateServiceHandler.getCourseTemplateKnowledgeTreeListBySubjectAndType(1, "MD_NORMAL");
            //System.out.println(list);
        } catch (TException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void getCourseTemplateListByCondition() {
        List<CourseTemplate> list = null;
        try {
            list = webCourseTemplateServiceHandler.getCourseTemplateListByCondition(1, "MD_NORMAL", 0);
        } catch (TException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void getCourseTemplateDetailById() {
        CourseTemplateDetail courseTemplateDetail = webCourseTemplateServiceHandler.getCourseTemplateDetailById(1);
    }

    @Test
    public void createMockExam() throws TException{
        ReqMockExam reqMockExam = new ReqMockExam();
        reqMockExam.setCollegeId(1);
        reqMockExam.setSubjectId(1);
        reqMockExam.setName("guomengli");
        reqMockExam.setOperateType("CREATE");
        reqMockExam.setOperator("guomengli");
        reqMockExam.setRoundId(1);

        Date date = new Date();
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        reqMockExam.setStartTime(df.format(date));

        String time = "2018-05-22 22:45:36.484";
        reqMockExam.setEndTime(time);
        int result = webCourseTemplateServiceHandler.operateMockExam(reqMockExam);
        System.out.println(result);
    }

    @Test
    public void editMockExam() throws TException{
        ReqMockExam reqMockExam = new ReqMockExam();
        reqMockExam.setExerciseExamId(4297);
        reqMockExam.setCollegeId(1);
        reqMockExam.setSubjectId(1);
        reqMockExam.setName("guomengli2");
        reqMockExam.setOperateType("EDIT");
        reqMockExam.setOperator("guomengli2");
        reqMockExam.setRoundId(1);

        Date date = new Date();
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        reqMockExam.setStartTime(df.format(date));

        String time = "2018-05-22 22:45:36.484";
        reqMockExam.setEndTime(time);
        int result = webCourseTemplateServiceHandler.operateMockExam(reqMockExam);
        System.out.println(result);
    }

    @Test
    public void deleteMockExam() throws TException{
        ReqMockExam reqMockExam = new ReqMockExam();
        reqMockExam.setExerciseExamId(4302);
        reqMockExam.setCollegeId(1);
        reqMockExam.setSubjectId(1);
        reqMockExam.setName("guomengli2");
        reqMockExam.setOperateType("DELETE");
        reqMockExam.setOperator("guomengli2");
        reqMockExam.setRoundId(1);

        Date date = new Date();
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        reqMockExam.setStartTime(df.format(date));

        String time = "2018-05-22 22:45:36.484";
        reqMockExam.setEndTime(time);
        int result = webCourseTemplateServiceHandler.operateMockExam(reqMockExam);
        System.out.println(result);
    }

    @Test
    public void rpcClient(){
        System.out.println("客户端启动。。。。。");

        String serverURL = "http://10.72.1.145:9094/web/courseTemplate";
        CourseTemplateDetail detail = null;
        try {
            TTransport transport = new THttpClient(serverURL);
            TProtocol protocol = new TBinaryProtocol.Factory().getProtocol(transport);
            WebCourseTemplateService.Client client = new WebCourseTemplateService.Client(protocol);
            detail = client.getCourseTemplateDetailById(1);
            Assert.assertEquals("111", detail.getCourseTemplateName());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
