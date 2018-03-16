namespace java com.sunlands.rpc.api.service

// 做题记录
struct Test {
	1: i32 id;
	2: string name; 
}

service ApiService {
	// 学期
	list<UserRecord> getUserRecord(1: i32 id, 2: i32 stuId);

}