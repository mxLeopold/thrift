namespace java com.sunlands.rpc.web.service

// 做题记录
struct UserRecord {
	1: i32 id;
	2: i32 stuId;
	3: string name; 
	4: string exerciseType;
	5: i32 subjectId;
}

service ApiCourseService {
	// 学期
	list<UserRecord> getUserRecord(1: i32 id, 2: i32 stuId);

}