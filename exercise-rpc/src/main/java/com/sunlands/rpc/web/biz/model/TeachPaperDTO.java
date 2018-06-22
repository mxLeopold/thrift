package com.sunlands.rpc.web.biz.model;

/**
 * Created by lm on 2017/8/8.
 */

import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;

/**
 * 教研工作台试卷.
 */
@Data
public class TeachPaperDTO {
    private Integer id;//试卷id

    private String code;//试卷编号(对外)

    private Integer subjectId;//科目id

    private String name;//试卷名称

    private String type;//试卷类型

    private Integer invalidFlag;//试卷状态（0：启用，1：禁用（默认））

//    private Integer couldBeusedByStudents;

    private Integer questionAmount;//题量

    private BigDecimal totalScore;//总分

    private String videoUrl;//视频地址

    private Integer currentVersion;//当前版本标记

    private String source;//试卷来源

    private Integer knowledgeTreeId;//知识树id

    private String examProvince;//考试省份

    private Integer examSession;//考期（真题）

    private BigDecimal avgDifficultyValue;//平均难度值

    private Date createTime;//创建时间

    private String creator;//创建人263

    private Date updateTime;//更新时间

    private String operator;//操作人263

    private Integer deleteFlag;//逻辑删除位

    @Override
    public String toString() {
        return "Paper{" +
                "id=" + id +
                ", code='" + code + '\'' +
                ", subjectId=" + subjectId +
                ", name='" + name + '\'' +
                ", type='" + type + '\'' +
                ", invalidFlag='" + invalidFlag + "\'" +
//                ", couldBeusedByStudents='" + couldBeusedByStudents + "\'" +
                ", questionAoumnt=" + questionAmount +
                ", totalScore=" + totalScore +
                ", videoUrl='" + videoUrl + '\'' +
                ", currentVesion=" + currentVersion +
                ", source='" + source + '\'' +
                ", knowledgeTreeId=" + knowledgeTreeId +
                ", examProvince='" + examProvince + '\'' +
                ", examSession=" + examSession +
                ", avgDifficultyValue=" + avgDifficultyValue +
                ", createTime=" + createTime +
                ", creator='" + creator + '\'' +
                ", updateTime=" + updateTime +
                ", operator='" + operator + '\'' +
                ", deleteFlag=" + deleteFlag +
                '}';
    }
}
