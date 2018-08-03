package com.sunlands.entrpc.listener;

import com.sunlands.entrpc.proxy.ThriftServerProxy;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.ApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;
import java.util.List;

/**
 * @author: maxiao
 * @description: thrift服务监听器
 * @date: create in 16:07 2018/8/3
 * @modified By:
 * @copyright by sunlands
 */
@Slf4j
@WebListener
public class ThriftServerStartListener implements ServletContextListener {
    @Override
    public void contextInitialized(ServletContextEvent event) {
        System.out.println("thrift server ----------------------- start begin");

        try {
            ApplicationContext context = WebApplicationContextUtils.getWebApplicationContext(event.getServletContext());

            List<ThriftServerProxy> list = ((List<ThriftServerProxy>) context.getBean("thriftServerList"));
            if (list != null && list.size() > 0) {
                for (ThriftServerProxy proxy : list) {
                    proxy.start();
                }
            }
            log.info("Thrift Server监听器启动成功!");
        } catch (Exception e) {
            log.error("Thrift Server监听器启动错误", e);
            e.printStackTrace();
        }
        System.out.println("thrift server ----------------------- start end");
    }

    @Override
    public void contextDestroyed(ServletContextEvent event) {

    }
}
