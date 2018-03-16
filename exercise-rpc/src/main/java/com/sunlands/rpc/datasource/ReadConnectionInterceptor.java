package com.sunlands.rpc.datasource;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.Ordered;
import org.springframework.stereotype.Component;

/**
 * <p>Title:读拦截器</p>
 * <p>Description:</p>
 *
 * @author <a href="mailto:yinhang89@sunlands.com">尹行</a>
 * @date 2017年11月07日
 * @since v1.0
 */
@Aspect
@Component
public class ReadConnectionInterceptor implements Ordered {

    public static final Logger logger = LoggerFactory.getLogger(ReadConnectionInterceptor.class);

    @Around("@annotation(readConnection)")
    public Object proceed(ProceedingJoinPoint proceedingJoinPoint, ReadConnection readConnection) throws Throwable {
        try {
            logger.info("set database connection to read");
            DbContextHolder.setDbType(DbContextHolder.DbType.SLAVE);
            Object result = proceedingJoinPoint.proceed();
            return result;
        } finally {
            DbContextHolder.clearDbType();
            logger.info("restore database connection");
        }
    }

    @Override
    public int getOrder() {
        return 0;
    }
}
