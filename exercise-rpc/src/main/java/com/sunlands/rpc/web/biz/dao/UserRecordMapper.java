package com.sunlands.rpc.web.biz.dao;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

/**
 * <p>Title:用户答题记录Mapper</p>
 * <p>Description:</p>
 *
 * @author <a href="mailto:yinhang89@sunlands.com">尹行</a>
 * @date 2018年03月15日
 * @since v1.0
 */
@Mapper
public interface UserRecordMapper {

    /**
     * <p>Description:getRecordId</p>
     *
     * @param index
 * @param recordId
     * @return java.lang.Integer
     * @throw
     * @author <a href="mailto:yinhang89@sunlands.com">尹行</a>
     * @update [变更日期YYYY-MM-DD][变更人姓名][变更描述]
     * @since  2018年03月15日
     */
    @Select({
            "SELECT id FROM t_tiku_user_record_${index} WHERE id = #{recordId}"
    })
    Integer countDoneQuestionNum(@Param("index") String index, @Param("recordId") Integer recordId);
}
