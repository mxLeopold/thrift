namespace java com.sunlands.rpc.web.statistics.service

// 作业统计详情
struct WorkPaperReportList {
    1: string field1;
    2: string field2;
    3: string field3;
    4: string field4;
    5: string field5;
    6: string paperId;
    7: string paperName;
    8: string paperTypeCode;
    9: list<WorkPaperReport> result;
    10: string systemNumber;
    11: string userNumber;
    12: double userPaperPoint;
    13: string workGroupId;
}
// 作业统计数据
struct WorkPaperReport {
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
// 学员成绩列表
struct StuAnswerResult {  // StudentsScoreResultForWorkDTO
    1: i32 countPerPage;
    2: i32 pageCount;
    3: i32 pageIndex;
    4: list<StuAnswerDetail> resultList;
    5: i32 totalCount;
    6: i32 paperId;
    7: string field1;
    8: string paperTypeCode;
    9: string systemNumber;
}
// 学员成绩详情
struct StuAnswerDetail {   // StudentsScoreInfoForWorkDTO
    1: i32 userNumber;
    2: string username;
    3: i32 answeredTime; // 答题时间
    4: i32 rightNum;
    5: i32 wrongNum;
    6: double correctRate;
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
    1: i32 questionMainId;
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
    12: list<ScorePoint> scorePointList; // 得分点信息
}
// 得分点
struct ScorePoint {
    1: i32 id;
    2: i32 questionId;
    3: string content;
    4: string score;
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
	// 查询随堂考列表
	list<WorkPaperReport> getPaperReport(1: string paperId, 2: string unitIdStr);

    // 查询随堂考详情
    PaperDetail getPaperDetail(1: string paperId, 2: string unitIdStr);

    // 学员成绩列表
    StuAnswerResult getStuAnswerResult(1: StuAnswerResult stuAnswerResult);

    // 校验随堂考ID
    i32 checkQuizId(1: string paperCode);

    // 校验作业ID
    i32 checkAssignmentId(1: string paperCode);

    // 查询作业统计数据
    WorkPaperReportList selectWorkPaperReport(1: WorkPaperReportList workPaperReportList);


}