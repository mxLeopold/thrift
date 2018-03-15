package com.sunlands.rpc.datasource;

import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

/**
 * <p>Title:Spring上下文</p>
 * <p>Description:</p>
 *
 * @author <a href="mailto:yinhang89@sunlands.com">尹行</a>
 * @date 2017年11月29日
 * @since v1.0
 */
@Component
public class SpringContextHolder implements ApplicationContextAware {

    /**
     * .以静态变量保存ApplicationContext,可在任意代码中取出ApplicationContext.
     */
    private static ApplicationContext context;

    /**
     * <p>Description:实现ApplicationContextAware接口的context注入函数, 将其存入静态变量.</p>
     *
     * @param context
     * @return void
     * @throw
     * @author <a href="mailto:yinhang89@sunlands.com">尹行</a>
     * @update [变更日期YYYY-MM-DD][变更人姓名][变更描述]
     * @since 2017年11月29日
     */
    public void setApplicationContext(ApplicationContext context) {
        SpringContextHolder.context = context;
    }

    public static ApplicationContext getApplicationContext() {
        return context;
    }

    /**
     * <p>Description:从静态变量ApplicationContext中取得Bean, 自动转型为所赋值对象的类型.</p>
     *
     * @param name
     * @return T
     * @throw
     * @author <a href="mailto:yinhang89@sunlands.com">尹行</a>
     * @update [变更日期YYYY-MM-DD][变更人姓名][变更描述]
     * @since 2017年11月29日
     */
    public static <T> T getBean(String name) {
        return (T) context.getBean(name);
    }
}
