namespace java com.sunlands.rpc.api.homepage.service

// 做题记录
struct Test {
	1: i32 id;
	2: string name; 
}

service ApiHomePageService {
	// 学期
	// list<UserRecord> getUserRecord(1: i32 id, 2: i32 stuId);

    // 获取学员做题总数量
    i32 getSubmitQuestionCount(1: i32 ordDetailId, 2: i32 studentId);

    // 获取今日智能练习是否完成
    i32 isDailyIntelligentExerciseDone(1: i32 studentId);
}