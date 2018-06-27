namespace java com.sunlands.rpc.web.statistics.service
//刷题详情
struct QuestionAnswerDetail{
    1: i32 sequence;
    2: string questionContent;
    3: i32 totalAnswerNum;
    4: i32 correctFlag;
    5: i32 questionId;
    6: i32 correctNum;
    7: i32 wrongNum;
    8: string correctPercent;
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
struct StuAnswerResult {
    1: i32 countPerPage;
    2: i32 pageCount;
    3: i32 pageIndex;
    4: list<StuAnswerDetail> resultList;
    5: i32 totalCount;
    6: string paperId;
    7: string field1;
    8: string paperTypeCode;
    9: string systemNumber;
}
// 学员成绩详情
struct StuAnswerDetail {
    1: i32 userNumber;
    2: string username;
    3: i32 answeredTime; // 答题时间
    4: i32 rightNum;
    5: i32 wrongNum;
    6: string correctRate;
    7: double score; // 分值
}
// 答卷详情
struct PaperDetail {
    1: i32 paperId;
    2: string paperName;
    3: i32 finishCount;  // 答题人数
    4: list<QuestionDetail> questions; // 题目列表
    5: list<QuizzesOrWorkUserAnswers> quizzesOrWorkUserAnswersDTOList; // 排行榜
    6: i32 res; // 当返回对象为空时，res = -1
}

struct QuizzesOrWorkUserAnswers {
    1: i32 paperId;
    2: i32 userNumber;
    3: string userName;
    4: i32 correctCount;
}

// 题目详情
struct QuestionDetail {
    1: string questionContent;
    2: string expertContent;
    3: list<Option> questionOptions;
    4: list<OptionAnswer> optionAnswers;
    5: string questionType;
    6: list<ScorePoint> scorePoints;
}
// 得分点
struct ScorePoint {
    1: string score;
    2: string content;
}
// 选项  -- 根据sequence排序
struct Option {
    1: i32 rightAnswerFlag;// 是否为正确选项
    2: string sortOrderStr;// 选项
    3: string optioncolContent; // 选项内容
}
// 选项分布
struct OptionAnswer {
    1: string questionResult; // 选项
    2: i32 answerTotal; // 答题人数
}
// 轮次统计数据
struct RoundStatistics {
    1: i32 roundId;
    2: i32 totalAnswerNum; // 答题人数
    3: i32 totalQuestionAnswerNum; // 总刷题数
}
// 课程单元下学员的统计数据
struct QuizzesOrWorkUserCorrectRate {
    1: i32 stuId;
    2: i32 unitId;
    3: string exerciseType;
    4: double correctRate;//该学员在本课程下的正确率
}
//课程单元报告列表查询条件
struct UnitReportCondition {
    1: string unitIdStr;
    2: string userName;
    3: i32 userId;
    4: string attendStatus;
    5: string evaluateScoreLevel;
    6: string quizzesSort;
    7: string homeworkSort;
    8: i32 pageNo;
    9: i32 pageSize;
}
//课程单元报告列表统计数据
struct UnitsStatistic {
    1: i32 roundId;
    2: string teachUnitIds;
    3: i32 teacherId;
    4: double homeworkScoreRate;
    5: double homeworkCompleteRate;
    6: double quizzesScoreRate;
    7: double quizzesCompleteRate;
}
//课程单元报告首页统计数据
struct UnitsCorrectRateStatistic {
    1: string teachUnitIds;
    2: i32 homeworkAnswerNum;
    3: i32 quizzesAnswerNum;
    4: double homeworkMaxCorrectRate;
    5: double homeworkAvgCorrectRate;
    6: double homeworkMinCorrectRate;
    7: double quizzesMaxCorrectRate;
    8: double quizzesAvgCorrectRate;
    9: double quizzesMinCorrectRate;
}

service WebStatisticsService {
	// 查询作业、随堂考列表
	list<WorkPaperReport> getPaperReport(1: string paperId, 2: string unitIdStr);

    // 查询作业、随堂考详情
    PaperDetail getPaperDetail(1: string paperId, 2: string unitIdStr);

    // 学员成绩列表
    StuAnswerResult getStuAnswerResult(1: StuAnswerResult stuAnswerResult);

    // 校验随堂考ID
    i32 checkQuizId(1: string paperCode);

    // 校验作业ID
    i32 checkAssignmentId(1: string paperCode);

    // 刷题详情
    list<QuestionAnswerDetail> getQuestionAnswerDetails(1: string paperCode, 2: i32 roundId);

    //刷题详情总条目
    i32 getQuestionAnswerTotal(1: string paperCode, 2: i32 roundId);

    // 查询轮次统计数据
    list<RoundStatistics> getRoundStatistics(1: list<i32> roundIds);

    //查询作业随堂考正确率
    list<QuizzesOrWorkUserCorrectRate> getPaperStudentCorrectRate(1: UnitReportCondition unitReportCondition);

    //查询作业随堂考学员完成率和得分率
    UnitsStatistic retrieveQuizzesAndAssignmentsByUnitIds(1: i32 roundId, 2: string teachUnitIds, 3: i32 teacherId);

    //查询作业随堂考的正确率
    UnitsCorrectRateStatistic retrieveQuizzesAndAssignmentsCorrectRateByUnitIds(1: string teachUnitIds);

}