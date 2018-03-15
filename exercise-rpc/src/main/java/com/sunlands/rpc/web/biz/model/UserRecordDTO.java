package com.sunlands.rpc.web.biz.model;

/**
 * <p>Title:做题记录</p>
 * <p>Description:</p>
 *
 * @author <a href="mailto:yinhang89@sunlands.com">尹行</a>
 * @date 2018年03月15日
 * @since v1.0
 */
public class UserRecordDTO {

    private Integer id; // 做题记录ID

    private String name; // 做题记录名称

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
