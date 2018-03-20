package com.sunlands.rpc.common;

import org.joda.time.DateTime;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;

/**
 * 基于JodaTime封装的时间工具类
 *
 * @Author: 吴雨佳
 * @since: 2018/3/19 9:48
 */
public class DateTimeUtil {

    /**
     * 时间格式枚举类型
     */
    public enum DateFormatter {
        DATE("yyyy-MM-dd"),
        DATE_TIME("yyyy-MM-dd HH:mm:ss");

        private String fmt;

        DateFormatter(String fmt) {
            this.fmt = fmt;
        }

        public DateTimeFormatter getFmt() {
            return getFormatter(fmt);
        }
    }

    /**
     * 获取今天的日期
     * @return
     */
    public static String today() {
        DateTime dt = DateTime.now();
        return dt.toString(DateFormatter.DATE.getFmt());
    }

    /**
     * 获取时间格式化对象, 用于格式化时间
     * @param fmt
     * @return
     */
    private static DateTimeFormatter getFormatter(String fmt) {
        return DateTimeFormat.forPattern(fmt);
    }

}
