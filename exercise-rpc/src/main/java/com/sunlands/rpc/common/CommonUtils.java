package com.sunlands.rpc.common;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.BeanWrapper;
import org.springframework.beans.BeanWrapperImpl;

import java.util.HashSet;
import java.util.Set;

/**
 * <p>Title:公共工具类</p>
 * <p>Description:</p>
 *
 * @author <a href="mailto:yinhang89@sunlands.com">尹行</a>
 * @date 2018年03月20日
 * @since v1.0
 */
public class CommonUtils {

    /**
     * <p>Description:忽略空值使用</p>
     *
     * @param source
     * @return java.lang.String[]
     * @throw
     * @author <a href="mailto:yinhang89@sunlands.com">尹行</a>
     * @update [变更日期YYYY-MM-DD][变更人姓名][变更描述]
     * @since 2017年11月14日
     */
    public static String[] getNullPropertyNames(Object source) {
        final BeanWrapper src = new BeanWrapperImpl(source);
        java.beans.PropertyDescriptor[] pds = src.getPropertyDescriptors();

        Set<String> emptyNames = new HashSet<>();
        for (java.beans.PropertyDescriptor pd : pds) {
            Object srcValue = src.getPropertyValue(pd.getName());
            if (srcValue == null) emptyNames.add(pd.getName());
        }
        String[] result = new String[emptyNames.size()];
        return emptyNames.toArray(result);
    }

    /**
     * <p>Description:忽略空值</p>
     *
     * @param src
     * @param target
     * @return void
     * @throw
     * @author <a href="mailto:yinhang89@sunlands.com">尹行</a>
     * @update [变更日期YYYY-MM-DD][变更人姓名][变更描述]
     * @since 2017年11月14日
     */
    public static void copyPropertiesIgnoreNull(Object src, Object target) {
        BeanUtils.copyProperties(src, target, getNullPropertyNames(src));
    }
}
