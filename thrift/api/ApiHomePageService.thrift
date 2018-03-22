namespace java com.sunlands.rpc.api.homepage.service

// 今日智能练习结果
struct DailyIntelligentExerciseDTO {
    // 返回1 已完成  0 未完成
	1: i32 done;
	// 返回1 有题库, 0 没有题库
	2: i32 hasTiku;
	// type 写死为tiku, 下游调用直接使用这个DTO, 董森要求添加
	3: string type;
}

service ApiHomePageService {
	// 学期
	// list<UserRecord> getUserRecord(1: i32 id, 2: i32 stuId);

    // 获取学员做题总数量
    i32 getSubmitQuestionCount(1: i32 ordDetailId, 2: i32 studentId);

    // 获取今日智能练习是否完成
    DailyIntelligentExerciseDTO isDailyIntelligentExerciseDone(1: i32 studentId);
}