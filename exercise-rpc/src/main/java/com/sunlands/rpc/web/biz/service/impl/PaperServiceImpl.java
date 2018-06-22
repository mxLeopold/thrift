package com.sunlands.rpc.web.biz.service.impl;

import com.sunlands.rpc.web.biz.dao.PaperDao;
import com.sunlands.rpc.web.biz.model.ReqSavePaperDTO;
import com.sunlands.rpc.web.biz.model.ResPaperQuestionRelationDTO;
import com.sunlands.rpc.web.biz.model.TeachPaperDTO;
import com.sunlands.rpc.web.biz.service.PaperService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.List;

@Service("paperService")
public class PaperServiceImpl implements PaperService {
    @Autowired
    PaperDao paperDao;
    @Override
    public Integer getCurrentPaperId(String paperCode) {
        TeachPaperDTO bPaper = paperDao.selectBPaperByCode(paperCode);
        if (bPaper == null) {
            return null;
        }

        TeachPaperDTO cPaper = paperDao.selectCPaperByCode(paperCode);
        Integer currentPaperId = null;
        if (cPaper == null) {
            // 新增试卷
            currentPaperId = insertCurrentVersionPaper(paperCode);
        }else {
            if (isModified(bPaper, cPaper)) {
                //之前的试卷当前版本标志设置为0
                updateOldVersionPaper(cPaper);
                // 新增试卷
                currentPaperId = insertCurrentVersionPaper(paperCode);
            } else {
                currentPaperId = cPaper.getId();
            }
        }

        return currentPaperId;
    }

    /**
     * 更新上一个版本的试卷，currentVersion标志设置为0
     * @param paper 试卷对象
     */
    private void updateOldVersionPaper(TeachPaperDTO paper) {
        paper.setOperator("sys-同步B端数据");
        paperDao.updatePaperByPrimaryKey(paper);
    }

    /**
     *
     * @param paper  B端试卷
     * @param currentVersionPaper  C端当前版本试卷
     * 判断是否有改动的依据：
     *     编辑试卷--试卷和试题关联关系变动（①试卷名称、类型；②试卷和试题关联关系-试题在试卷中分值、试题题序、试题是否被删除、是否有新增试题）
     *     编辑试题--试题本身改动
     * @return
     */
    private boolean isModified(TeachPaperDTO paper, TeachPaperDTO currentVersionPaper) {
        if (!paper.getName().equals(currentVersionPaper.getName()) || !paper.getType().equals(currentVersionPaper.getType())) {
            return true;
        } else {
            List<ResPaperQuestionRelationDTO> Relations = paperDao.selectPaperQuestionRelations(paper.getCode());
            List<ResPaperQuestionRelationDTO> currentVersionRelations = paperDao.selectCurrentVersionRelations(currentVersionPaper.getId());
            if (!CollectionUtils.isEmpty(Relations) && !CollectionUtils.isEmpty(currentVersionRelations)) {
                if (Relations.size() != currentVersionRelations.size()) {
                    return true;
                } else {
                    for (int i = 0; i < Relations.size() - 1; i++) {
                        ResPaperQuestionRelationDTO relation = Relations.get(i);
                        ResPaperQuestionRelationDTO currentVersionRelation = currentVersionRelations.get(i);
                        if (!relation.getQuestionMainId().equals(currentVersionRelation.getQuestionMainId())
                                || !relation.getScore().equals(currentVersionRelation.getScore())
                                || !relation.getSequence().equals(currentVersionRelation.getSequence())) {
                            return true;
                        }
                    }
                }
            }
        }
        return false;
    }

    /**
     * 根据B端试卷新增C端试卷
     * 单元操作：t_paper，t_paper_question_rel,t_paper_head三者 捆绑新增
     * @param paperCode 试卷code
     * @return
     */
    private Integer insertCurrentVersionPaper(String paperCode) {
        ReqSavePaperDTO reqSavePaperDTO = new ReqSavePaperDTO();
        reqSavePaperDTO.setCode(paperCode);
        paperDao.insertPaper(reqSavePaperDTO);

        Integer paperId = reqSavePaperDTO.getPaperId();
        paperDao.insertPaperHeader(paperCode, paperId);
        paperDao.insertPaperQuestionRelation(paperCode, paperId);
        return paperId;
    }
}
