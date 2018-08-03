package com.sunlands.entrpc.proxy;

import com.google.common.util.concurrent.ThreadFactoryBuilder;
import lombok.extern.slf4j.Slf4j;
import org.apache.thrift.TProcessor;
import org.apache.thrift.protocol.TCompactProtocol;
import org.apache.thrift.server.TNonblockingServer;
import org.apache.thrift.server.TServer;
import org.apache.thrift.transport.TFramedTransport;
import org.apache.thrift.transport.TNonblockingServerSocket;
import org.apache.thrift.transport.TTransportException;
import org.springframework.util.StringUtils;

import java.lang.reflect.Constructor;
import java.util.concurrent.*;

/**
 * @author: maxiao
 * @description:
 * @date: create in 16:10 2018/8/3
 * @modified By:
 * @copyright by sunlands
 */
@Slf4j
public class ThriftServerProxy {

    /**
     * 端口
     */
    private int port;
    /**
     * 实现类接口
     */
    private String serviceInterface;
    /**
     * 实现类
     */
    private Object serviceImplObject;
    /**
     * thrift接口
     */
    private String serviceIface;

    public void start() {
        ThreadFactory namedThreadFactory = new ThreadFactoryBuilder()
                .setNameFormat("demo-pool-%d").build();
        ExecutorService singleThreadPool = new ThreadPoolExecutor(1, 1,
                0L, TimeUnit.MILLISECONDS,
                new LinkedBlockingQueue<Runnable>(1024), namedThreadFactory, new ThreadPoolExecutor.AbortPolicy());

        singleThreadPool.execute(
                new Runnable() {
                    @Override
                    public void run() {
                        try {
                            Class processorClazz = Class.forName(getServiceInterface() + "$Processor");
                            Class iface = Class.forName(StringUtils.hasText(getServiceIface()) ?
                                    getServiceIface() : getServiceInterface() + "$Iface");
                            Constructor constructor = processorClazz.getConstructor(iface);
                            TProcessor processor = (TProcessor) constructor.newInstance(serviceImplObject);

                            TNonblockingServerSocket transport = new TNonblockingServerSocket(getPort());
                            TNonblockingServer.Args tArgs = new TNonblockingServer.Args(transport);
                            tArgs.processor(processor);
                            tArgs.protocolFactory(new TCompactProtocol.Factory());
                            tArgs.transportFactory(new TFramedTransport.Factory());
                            TServer server = new TNonblockingServer(tArgs);

                            log.info(serviceInterface + "服务启动成功,端口:" + getPort());
                            server.serve();

                        } catch (TTransportException e) {
                            e.printStackTrace();
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                }
        );
        singleThreadPool.shutdown();
    }

    public Object getServiceImplObject() {
        return serviceImplObject;
    }

    public void setServiceImplObject(Object serviceImplObject) {
        this.serviceImplObject = serviceImplObject;
    }

    public int getPort() {
        return port;
    }

    public void setPort(int port) {
        this.port = port;
    }

    public String getServiceInterface() {
        return serviceInterface;
    }

    public void setServiceInterface(String serviceInterface) {
        this.serviceInterface = serviceInterface;
    }

    public String getServiceIface() {
        return serviceIface;
    }

    public void setServiceIface(String serviceIface) {
        this.serviceIface = serviceIface;
    }
}
