package com.sunlands.rpc.datasource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;

/**
 * <p>Title:自定义事务管理器</p>
 * <p>Description:</p>
 *
 * @author <a href="mailto:yinhang89@sunlands.com">尹行</a>
 * @date 2017年11月29日
 * @since v1.0
 */
@Configuration
@EnableTransactionManagement
public class DataSourceTransactionManagerAutoConfiguration
        extends org.springframework.boot.autoconfigure.jdbc.DataSourceTransactionManagerAutoConfiguration {

    @Bean(name = "transactionManager")
    public DataSourceTransactionManager transactionManagers() {
        return new DataSourceTransactionManager((DataSource) SpringContextHolder.getBean("roundRobinDataSourceProxy"));
    }
}