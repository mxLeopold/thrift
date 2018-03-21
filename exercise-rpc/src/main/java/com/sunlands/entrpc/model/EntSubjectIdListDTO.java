package com.sunlands.entrpc.model;

import java.util.List;

/**
 * 产品包下的科目ID集合
 *
 * @Author: 吴雨佳
 * @since: 2018/3/21 14:22
 * @update: [变更日期yyyy-MM-dd][变更人姓名][变更描述]
 */
public class EntSubjectIdListDTO {

    /**
     * 1 有知识树, 0 没有知识树
     */
    private Integer hasKnowledgeTree;

    /**
     * 科目ids, 产品包下的科目集合
     */
    private List<Integer> subjectIds;

    /**
     * 判断是否有题库
     * @return
     */
    public boolean hasTiku() {
        if (null == this.hasKnowledgeTree) {
            return false;
        }
        return this.hasKnowledgeTree > 0;
    }

    public Integer getHasKnowledgeTree() {
        return hasKnowledgeTree;
    }

    public void setHasKnowledgeTree(Integer hasKnowledgeTree) {
        this.hasKnowledgeTree = hasKnowledgeTree;
    }

    public List<Integer> getSubjectIds() {
        return subjectIds;
    }

    public void setSubjectIds(List<Integer> subjectIds) {
        this.subjectIds = subjectIds;
    }

    @Override
    public String toString() {
        return "EntSubjectIdListDTO{" +
                "hasKnowledgeTree=" + hasKnowledgeTree +
                ", subjectIds=" + subjectIds +
                '}';
    }
}
