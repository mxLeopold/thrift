package com.sunlands.rpc.test.web;

import com.sunlands.rpc.web.coursetemplate.handler.WebCourseTemplateServiceHandler;
import com.sunlands.rpc.web.coursetemplate.service.CourseTemplate;
import com.sunlands.rpc.web.coursetemplate.service.KnowledgeTree;
import org.apache.thrift.TException;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@DirtiesContext
public class WebCourseTemplateServiceTest {
    @Autowired
    WebCourseTemplateServiceHandler webCourseTemplateServiceHandler;
    @Test
    public void getCourseTemplateKnowledgeTreeListBySubjectAndType() throws TException {
        List<KnowledgeTree> list = webCourseTemplateServiceHandler.getCourseTemplateKnowledgeTreeListBySubjectAndType(1, "MD_NORMAL");
        System.out.println(list);
    }

    @Test
    public void getCourseTemplateListByCondition() {
        List<CourseTemplate> list = null;
        try {
            list = webCourseTemplateServiceHandler.getCourseTemplateListByCondition(1, "MD_NORMAL", 0);
        } catch (TException e) {
            e.printStackTrace();
        }
        System.out.println(list);
    }
}
