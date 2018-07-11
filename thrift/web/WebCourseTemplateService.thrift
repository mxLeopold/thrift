namespace java com.sunlands.rpc.web.coursetemplate.service

// 知识树
struct KnowledgeTree {
    1: i32 knowledgeTreeId; //知识树id
    2: i32 subjectId; // 科目id
    3: string provinces; // 省份
}

//知识点
struct KnowledgeNode {
    1: i32 knowledgeNodeId; //知识点id
    2: string serialNumber; //知识点序号
    3: string knowledgeNodeName; //知识点名称
}

// 课程模板教学单元文件
struct CourseTemplateUnitFile {
    1: i32 templateUnitId; //课程模板教学单元id
    2: i32 fileId; // 课程模板教学单元文件id
    3: string fileUrl; // 文件URL
    4: string fileName; //文件名称
    5: i32 fileSize; //文件大小
}

// 课程模板教学单元
struct CourseTemplateUnit {
    1: i32 courseTemplateId; //课程模板id
    2: i32 templateUnitId; // 课程模板教学单元id
    3: string templateUnitName; //课程模板教学单元名称
    4: i32 sequence; //课程模板教学单元序号
    5: list<KnowledgeNode> knowledgeNodeList; // 关联知识点列表
    6: list<string> quizPaperCodeList; //随堂考试卷列表
    7: list<string> assignmentPaperCodeList; //作业试卷列表
    8: list<CourseTemplateUnitFile> fileList; //教学单元文件列表
}

// 课程模板
struct CourseTemplate {
    1: i32 courseTemplateId; //课程模板id
    2: string courseTemplateCode; // 课程模板code
    3: i32 subjectId; // 科目id
    4: i32 knowledgeTreeId; // 知识树id
    5: i32 version; // 课程模板版本
    6: string courseTemplateName; // 课程模板名称
    7: i32 totalUnitCount; //课程单元数量
    8: string mockExamPaperCode; // 模考试卷code
}

// 课程模板
struct CourseTemplateDetail {
    1: i32 courseTemplateId; //课程模板id
    2: string courseTemplateCode; // 课程模板code
    3: i32 subjectId; // 科目id
    4: i32 knowledgeTreeId; // 知识树id
    5: i32 version; // 课程模板版本
    6: string courseTemplateName; // 课程模板名称
    7: i32 totalUnitCount; //课程单元数量
    8: string mockExamPaperCode; // 模考试卷code
    9: list<CourseTemplateUnit> templateUnitList; // 课程模板教学单元列表
}

// 操作模考请求信息
struct ReqMockExam {
    1: i32 roundId; //轮次Id
    2: string operateType; // 操作类型：CREATE 创建/EDIT 编辑/ DELETE 删除
    3: i32 exerciseExamId; // 教研库模考Id
    4: i32 collegeId; // 学院id
    5: i32 subjectId; // 科目id
    6: string name; // 模考名称
    7: string startTime; // 模考开始时间
    8: string endTime; // 模考结束时间
    9: string paperCode; // 模考试卷code
    10: string operator; // 操作人
}


// 课程模板知识树信息
struct LastKnowledgeNodeInfo {
    1: i32 knowledgeNodeId; // 知识点id
    2: string knowledgeNodeName; // 知识点名称
    3: i32 level; // 知识点层级
    4: i32 lastLevelFlag; // 是否为末级知识点（三级为末级，1是，0否）
    5: string lastLevelIds; // 末级知识点下的四级知识点
    6: i32 frequency; // 知识点频度（0-中频，1-高频，2-极高频）
    7: list<LastKnowledgeNodeInfo> knowledgeNodeList; //
}

// 课程标准化课次的知识点频度信息
struct TemplateUnitNodeInfo {
    1: i32 extremelyHighFrequencyCount; // 极高频知识点个数
    2: i32 highFrequencyCount; // 高频知识点个数
    3: i32 midFrequencyCount; // 中频知识点个数
}

// 带课次id的课程标准化课次的知识点频度信息
struct TemplateUnitNodeInfoIntermediate {
    1: i32 templateUnitId; // 标准课次id
    2: TemplateUnitNodeInfo nodeFrequencyInfo; // 知识点频度信息
}

// 课程标准化课次的一二级知识点频度信息
struct TemplateUnitNodeDetailInfo {
    1: i32 nodeId; // 知识点id
    2: string nodeName; // 知识点名称
    3: TemplateUnitNodeInfo nodeFrequencyInfo; // 知识点频度信息
    4: list<TemplateUnitNodeDetailInfo> knowledgeNodeList; // 知识点list
}

// 课程模板的课次
struct TemplateUnitInfo {
    1: i32 templateUnitId;  // 课程模板课次id
    2: list<TemplateUnitNodeDetailInfo> templateUnitNodeInfo; // 课次所含知识点
}

service WebCourseTemplateService {

    //根据科目+类型获取课程模板知识树列表
    list<KnowledgeTree> getCourseTemplateKnowledgeTreeListBySubjectAndType(1: i32 subjectId, 2: string type);

    //根据科目+类型+知识树（选填）获取知识模板列表
    list<CourseTemplate> getCourseTemplateListByCondition(1: i32 subjectId, 2: string type, 3: i32 knowledgeTreeId);

    //根据课程模板Id获取课程模板内容
    CourseTemplateDetail getCourseTemplateDetailById(1: i32 courseTemplateId);

    // 新建/编辑/删除模考
    i32 operateMockExam(1: ReqMockExam reqMockExam);

    // 查询课程模板的知识树信息
    list<LastKnowledgeNodeInfo> retrieveCourseTemplateTreeInfo(1: i32 knowledgeTreeId);

    // 查询课程标准化课程的知识点
    list<TemplateUnitNodeInfoIntermediate> retrieveTemplateTeachUnitNodeInfo(1: list<i32> templateUnitIdList);

    // 查询课程模板所有课次知识点信息
    list<TemplateUnitInfo> retrieveTemplateUnitNodeDetailInfo(1: i32 templateId);
}