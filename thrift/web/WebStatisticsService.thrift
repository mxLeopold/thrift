namespace java com.sunlands.rpc.web.statistics.service

// 统计答卷数据
struct PaperReport {
    1: i32 answerNumber;
    2: double answerTime;
    3: double answerTimeAve;
    4: string answerTimeAveString;
    5: string answerTimeString;
    6: i32 correct;
    7: i32 correctAve;
    8: double correctPercent;
    9: double evaluatedScore;
    10: string paperId;
    11: string paperName;
    12: double paperTotal;
    13: double paperTotalAve;
    14: double passRate;
    15: i32 questionNum;
    16: string subjectId;
    17: i32 userPaperId;
    18: i32 wrong;
}
// 学员成绩详情
struct StuAnswerDetail {
    1: i32 stuId;
    2: string stuName;
    3: i32 totalTime; // 答题时间
    4: i32 correctQuestionCount;
    5: i32 wrongQuestionCount;
    6: double accuracyRate;
    7: i32 recordId;
}
// 答卷详情
struct PaperDetail {
    1: string paperName;
    2: i32 answerNum; // 答卷人数
    3: list<StuAnswerDetail> ranking; // 排行榜
    4: list<QuestionDetail> questionDetailList;
}
// 题目详情
struct QuestionDetail {
    1: i32 questionId;
    2: i32 sequence;
    3: string questionType;
    4: string questionContent;
    5: string analysis;
    6: string scoreStr;
    7: string answer;
    8: list<Option> optionList; // 选项列表
    9: list<Blank> blankList; // 填空题-空列表
    10: list<StuQuestionAnswer> stuAnswers; // 学员答题信息
    11: list<QuestionDetail> subQuestionList; // 子题
}
// 填空题 - 空
struct Blank {
    1: i32 id;
    2: string answer;
}
// 选项
struct Option {
    1: i32 sequence;
    2: string optionTitle;
    3: string optionContent;
    4: i32 correct;
}
// 学员答题分布统计
struct StuQuestionAnswer {
    1: i32 questionId;
    2: i32 stuId;
    3: string stuAnswer;
    4: i32 correct; // 是否正确
    5: i32 stuScore; // 学员得分
}

service WebStatisticsService {
    // 校验试卷ID是否存在
    bool isPaperIdValid(1: string paperId);

    // 校验试卷类型是否与特定类型相符
    bool checkPaperType(1: string paperId, 2: string exerciseType);

	// 查询随堂考列表
	list<PaperReport> getPaperReport(1: string paperId, 2: string unitIdStr);

    // 查询随堂考详情
    PaperDetail getPaperDetail(1: string paperId, 2: string unitIdStr);

    // 成绩详情列表
    list<StuAnswerDetail> getStuAnswerDetail(1: i32 paperId, 2: string unitIdStr);
}