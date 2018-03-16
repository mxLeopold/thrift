namespace java com.sunlands.rpc.web.service

// 随堂考统计数据
struct QuizzesPaperReport {
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

service ApiWebService {
	// 查询随堂考列表
	list<QuizzesPaperReport> getQuizzesPaperReport(1: string paperId, 2: string unitIdStr);

}