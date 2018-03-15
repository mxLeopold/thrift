package com.sunlands;

import java.io.IOException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cache.CacheManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.cache.RedisCacheManager;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.StringRedisSerializer;

@Configuration
public class RedisCacheConfig {

	private static final Logger log = LoggerFactory.getLogger(RedisCacheConfig.class);

	@Value("${spring.redis.expires}")
	private long expiresTimes;

	@Bean(name = "redisCacheManager")
	public CacheManager cacheManager(@SuppressWarnings("rawtypes") RedisTemplate redisTemplate) throws IOException {
		redisTemplate.setHashValueSerializer(new StringRedisSerializer());
		redisTemplate.setKeySerializer(new StringRedisSerializer());
		redisTemplate.setHashKeySerializer(new StringRedisSerializer());
		redisTemplate.afterPropertiesSet();

		RedisCacheManager manage = new RedisCacheManager(redisTemplate);
		log.info("redis 默认过期时间 {} 秒", expiresTimes);
		manage.setDefaultExpiration(this.expiresTimes);
		return manage;
	}
}
