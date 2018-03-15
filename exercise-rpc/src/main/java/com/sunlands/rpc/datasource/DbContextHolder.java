package com.sunlands.rpc.datasource;

/**
 * <p>Title:数据源上下文</p>
 * <p>Description:</p>
 *
 * @author <a href="mailto:yinhang89@sunlands.com">尹行</a>
 * @date 2017年11月07日
 * @since v1.0
 */
public class DbContextHolder {

    public enum DbType {
        MASTER, SLAVE
    }

    private static final ThreadLocal<DbType> contextHolder = new ThreadLocal<>();

    public static void setDbType(DbType dbType) {
        if (dbType == null) throw new NullPointerException();
        contextHolder.set(dbType);
    }

    public static DbType getDbType() {
        return contextHolder.get() == null ? DbType.SLAVE : contextHolder.get();
    }

    public static void clearDbType() {
        contextHolder.remove();
    }
}
