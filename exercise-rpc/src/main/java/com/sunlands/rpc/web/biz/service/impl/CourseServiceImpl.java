package com.sunlands.rpc.web.biz.service.impl;

import com.sunlands.rpc.web.biz.service.CourseService;
import com.sunlands.rpc.web.service.UserRecord;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>Title:APP-我的课程服务实现类</p>
 * <p>Description:</p>
 *
 * @author <a href="mailto:yinhang89@sunlands.com">尹行</a>
 * @date 2018年03月15日
 * @since v1.0
 */
@CacheConfig(cacheNames = "course")
@Service
public class CourseServiceImpl implements CourseService {

    @Override
    public List<UserRecord> getUserRecord(int id, int stuId) {
        return null;
    }
}