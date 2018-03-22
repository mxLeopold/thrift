package com.sunlands.entrpc.service;

import com.sunlands.entrpc.model.TermSubjectDTO;

import java.util.List;

/**
 * Student RPC服务
 *
 * @Author: 吴雨佳
 * @since: 2018/3/19 13:55
 * @update: [变更日期yyyy-MM-dd][变更人姓名][变更描述]
 */
public interface StudentRpcService {

    /**
     * 根据订单详情ID查询所有学期的所有科目集合
     *
     * @param detailId
     * @return
     * @throws Exception
     */
    List<TermSubjectDTO> getAllTermSubjectByDetailId(Integer detailId) throws Exception;

    /**
     * 是否有智能练习题
     *
     * @param studentId
     * @return
     * @throws Exception
     */
    boolean hasIntelligentExercise(Integer studentId) throws Exception;
}
