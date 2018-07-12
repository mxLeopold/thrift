package com.sunlands.rpc.web.biz.service.impl;

import com.sunlands.rpc.common.Constant;
import com.sunlands.rpc.web.biz.dao.PaperReportMapper;
import com.sunlands.rpc.web.biz.model.*;
import com.sunlands.rpc.web.biz.service.PaperReportService;
import com.sunlands.rpc.web.statistics.service.UnitsStatisticCondition;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;

import java.math.BigDecimal;
import java.util.*;

@Service
public class PaperReportServiceImpl implements PaperReportService {

    @Autowired
    private PaperReportMapper paperReportMapper;

    @Override
    public WorkPaperReportDTO getPaperReport(String paperCode, String unitIdStr) {
        PaperDTO paper = paperReportMapper.selectPaperCodeByCode(paperCode);
        if (paper == null) {
            return null;
        }
        PaperDTO paperDTO = paperReportMapper.selectPaperByCode(paperCode);
        // 未答题
        if (paperDTO == null) {
            return null;
        }
        Integer paperId = paperDTO.getId();  // 学员参考试卷版本id
        List<String> unitIds = Arrays.asList(unitIdStr.split(","));
        WorkPaperReportDTO paperReport = paperReportMapper.selectPaperReport(paperId, unitIds);
        if (paperReport == null) {  // 此班未答题
            return null;
        }

        Integer answerNum = paperReport.getAnswerNumber();
        if (answerNum != null && !answerNum.equals(0) ) {
            Double answerTime = paperReport.getAnswerTime();
            Double answerTimeAve = answerTime / answerNum;
            paperReport.setAnswerTimeString(answerTime.toString());
            paperReport.setAnswerTimeAve(answerTimeAve);
            paperReport.setAnswerTimeAveString(answerTimeAve.toString());
            double correctAve = (double) paperReport.getCorrect() / answerNum;
            paperReport.setCorrectAve(gradeAve(correctAve));
            double correctRate = gradeRateToDouble(((double) paperReport.getCorrect() / (answerNum * paperDTO.getQuestionAmount())), 4) * 100;
            paperReport.setCorrectPercent(correctRate);
        }
        paperReport.setPaperName(paperDTO.getName());
        paperReport.setQuestionNum(paperDTO.getQuestionAmount());
        paperReport.setPaperId(paperCode);
        return paperReport;
    }

    @Override
    public List<StuAnswerDetailDTO> getStuAnswerDetails(Integer paperId, String unitIdStr, Integer pageIndex, Integer pageSize) {
//        int totalCount = paperReportMapper.getStuAnswerDetailsCount(paperId % 10, paperId, unitIdStr);
//        if (totalCount == 0) {
//            return null;
//        }
        String str[] = unitIdStr.split(",");
        return paperReportMapper.getStuAnswerDetails(paperId % 10,paperId, Arrays.asList(str), pageIndex, pageSize);
    }

    @Override
    public PaperDetailDTO getPaperDetail(String paperCode, String unitIdStr) {
        PaperDTO paperDTO = paperReportMapper.selectPaperByCode(paperCode);
        // 没有生成C端试卷，未答题
        if (paperDTO == null) {
            return null;
        }
        // 试卷版本id
        Integer paperId = paperDTO.getId();
        // 课程单元id列表
        List<String> unitIds = Arrays.asList(unitIdStr.split(","));
        // 查询答题人数
        int num = paperReportMapper.selectTotalAnswerNum(paperId, unitIds);  // 默认答题人数为正确数据
        if (num == 0) {
            return null;
        }

        PaperDetailDTO paperDetailDTO = new PaperDetailDTO();
        paperDetailDTO.setPaperId(paperId);
        paperDetailDTO.setCode(paperDTO.getCode());
        paperDetailDTO.setPaperName(paperDTO.getName());
        paperDetailDTO.setAnswerNum(num);
        // 排行榜
        paperDetailDTO.setRanking(paperReportMapper.selectRankingList(paperId % 10, paperId, unitIds));
        // 题目详情
        List<QuestionDetailDTO> questions = getRelatedQuestionMain(paperDTO.getId());
        // 学员答案 - 选项分布
        if (!CollectionUtils.isEmpty(questions)) {
            for (QuestionDetailDTO questionDetailDTO : questions) {
                if (Constant.CONTENT_TYPE_CHOICE.equals(questionDetailDTO.getContentType())) {
                    List<OptionAnswerDTO> optionAnswerDTOS = paperReportMapper.selectStuAnswers(paperId % 10, paperId, unitIds, questionDetailDTO.getQuestionMainId());
                    questionDetailDTO.setStuAnswers(optionAnswerDTOS);
                }
            }
        }
        paperDetailDTO.setQuestionDetailList(questions);
        return paperDetailDTO;
    }

    @Override
    public int checkPaperId(String paperCode, String type) {
        PaperDTO paperDTO = paperReportMapper.selectPaperCodeByCode(paperCode); // 配置作业、随堂考时未生成C端试卷，校验B端试卷
        if (paperDTO == null) {  // 试卷ID不存在
            return 1;
        }
        if (paperDTO.getType() == null || !type.equals(paperDTO.getType())) {  // ID与类型不符
            return 2;
        }
        return 0;
    }

    @Override
    public void selectWorkPaperReport(WorkPaperReportListDTO workPaperReportListDTO) {
        String paperCode = workPaperReportListDTO.getWorkGroupId();
        String unitIdStr = workPaperReportListDTO.getField1();
        WorkPaperReportDTO paperReport = getPaperReport(paperCode, unitIdStr);
        workPaperReportListDTO.setResult(Arrays.asList(paperReport));
    }

    /**
     * 查询试卷内试题详情 -- 作业、随堂考只统计了选择、文字
     * @param paperId
     * @return
     */
    List<QuestionDetailDTO> getRelatedQuestionMain(Integer paperId) {
        List<QuestionDetailDTO> questions = paperReportMapper.selectBigQuestionMainByPaperId(paperId);
        if (!CollectionUtils.isEmpty(questions)) {
            for (QuestionDetailDTO questionDetailDTO : questions) {
                if (Constant.CONTENT_TYPE_CHOICE.equals(questionDetailDTO.getContentType())) {
                    // 选项
                    List<OptionDTO> optionDTOS = paperReportMapper.selectOptionsByQuestionId(questionDetailDTO.getQuestionId());
                    questionDetailDTO.setOptionList(optionDTOS);
                }
                // 得分点
                if (Constant.CONTENT_TYPE_ESSAY.equals(questionDetailDTO.getContentType())) {
                    List<ScorePointDTO> scorePointDTOS = paperReportMapper.selectScorePointsByQuestionId(questionDetailDTO.getQuestionId());
                    if (!CollectionUtils.isEmpty(scorePointDTOS)) {
                        questionDetailDTO.setScorePointList(scorePointDTOS);
                    }
                }
            }
        }
        return questions;
    }

    @Override
    public StuAnswerResultDTO getStuAnswerResult(StuAnswerResultDTO stuAnswerResultDTO) {
        String paperCode = stuAnswerResultDTO.getPaperId();
        String unitIdStr = stuAnswerResultDTO.getField1();
        if (StringUtils.isEmpty(paperCode)) {
            throw new RuntimeException("paperId不能为空");
        }
        if (StringUtils.isEmpty(unitIdStr)) {
            throw new RuntimeException("unitIdStr不能为空");
        }
        PaperDTO paperDTO= paperReportMapper.selectPaperByCode(paperCode);
        Integer paperId = paperDTO.getId();
        List<String> unitIds = Arrays.asList(unitIdStr.split(","));
        int totalCount = paperReportMapper.getStuAnswerDetailsCount(paperId % 10, paperId, unitIds);
        stuAnswerResultDTO.setTotalCount(totalCount);
        if (totalCount != 0) {
            Integer start = null;
            if (stuAnswerResultDTO.getPageIndex() != null && stuAnswerResultDTO.getCountPerPage() != null
                    && !stuAnswerResultDTO.getPageIndex().equals(0) && !stuAnswerResultDTO.getCountPerPage().equals(0)) {
                start = (stuAnswerResultDTO.getPageIndex() - 1) * stuAnswerResultDTO.getCountPerPage();
            }
            List<StuAnswerDetailDTO> stuAnswerDetailDTOS = paperReportMapper.getStuAnswerDetails(paperId % 10, paperId, unitIds, start, stuAnswerResultDTO.getCountPerPage());

            // 计算正确率
            if (!CollectionUtils.isEmpty(stuAnswerDetailDTOS)) {
                double accuracyRate = 0;
                for (StuAnswerDetailDTO detailDTO : stuAnswerDetailDTOS) {
                    if (detailDTO.getCorrectQuestionCount() != null && detailDTO.getQuestionNum() != null
                            && !detailDTO.getQuestionNum().equals(0)) {
                        accuracyRate = (double)detailDTO.getCorrectQuestionCount() / detailDTO.getQuestionNum();
                    }
                    detailDTO.setAccuracyRate(gradeRate(accuracyRate, 2));
                }
            }
            stuAnswerResultDTO.setResultList(stuAnswerDetailDTOS);
            if (!CollectionUtils.isEmpty(stuAnswerDetailDTOS) &&
                    !stuAnswerResultDTO.getCountPerPage().equals(0)) {
                Integer a = totalCount % stuAnswerResultDTO.getCountPerPage() == 0 ? 0 : 1;
                Integer pageCount = totalCount / stuAnswerResultDTO.getCountPerPage() + a;
                stuAnswerResultDTO.setPageCount(pageCount);
            }
        }
        return stuAnswerResultDTO;
    }

    /**
     * double --> string
     * @param d
     * @param scale
     * @return
     */
    private String gradeRate(double d, int scale) {
        BigDecimal b = new BigDecimal(d * 100);
        return b.setScale(scale, BigDecimal.ROUND_HALF_UP).toString() + "%";
    }

    private Integer gradeAve(double d) {
        BigDecimal b = new BigDecimal(d);
        return Integer.parseInt(b.setScale(0, BigDecimal.ROUND_HALF_UP).toString());
    }

    /**
     *
     * @param d
     * @param scale
     * @return
     */
    private double gradeRateToDouble(double d, int scale) {
        BigDecimal b = new BigDecimal(d);
        return b.setScale(scale, BigDecimal.ROUND_HALF_UP).doubleValue();
    }

    @Override
    public List<QuestionAnswerDetailDTO> getQuestionAnswerDetails(String paperCode,Integer roundId) {
        List<QuestionAnswerDetailDTO> questionAnswerDetails = new ArrayList<>();
        if (paperCode == null || "".equals(paperCode)){
            throw new RuntimeException("试卷编码不能为空");
        }
        if (roundId == null || "".equals(roundId)){
            throw new RuntimeException("轮次ID不能为空");
        }
        PaperDTO paperDTO = paperReportMapper.selectPaperByCode(paperCode);
        //若改试卷存在t_paper表中，就代表已经存在刷题详情
        if (!(paperDTO == null || paperDTO.getId() ==null || "".equals(paperDTO.getId()))){
            questionAnswerDetails = paperReportMapper.queryQuestionAnswerDetails(paperCode,roundId,paperDTO.getId()%10);
        }
        Map<Integer,QuestionAnswerDetailDTO> questionAnswerDetailMap = new HashMap<>();
        Map<Integer,QuestionAnswerDetailDTO> valueSortMap = new TreeMap<>(new QuestionSequenceComparator().new ValueComparator(questionAnswerDetailMap));
        //遍历每个题的答题情况，计算每个题的正确率
        for (QuestionAnswerDetailDTO questionAnswerDetail : questionAnswerDetails){
            //过滤掉questionContent中的html标签
            questionAnswerDetail.setQuestionContent(trimHtmlTag(questionAnswerDetail.getQuestionContent()));
            //以questionId为单元计算，若该题已被记录信息，则更新正确率等参数
            if (questionAnswerDetailMap.containsKey(questionAnswerDetail.getQuestionId())){
                QuestionAnswerDetailDTO mapQuestionAnswerDetail = questionAnswerDetailMap.get(questionAnswerDetail.getQuestionId());
                if (questionAnswerDetail.getCorrectFlag()==1){
                    mapQuestionAnswerDetail.setCorrectNum(questionAnswerDetail.getTotalAnswerNum());
                    mapQuestionAnswerDetail.setTotalAnswerNum(mapQuestionAnswerDetail.getTotalAnswerNum()+questionAnswerDetail.getTotalAnswerNum());
                    mapQuestionAnswerDetail.setCorrectPercent(floatToPercent((float) mapQuestionAnswerDetail.getCorrectNum()/mapQuestionAnswerDetail.getTotalAnswerNum()));
                }else{
                    mapQuestionAnswerDetail.setWrongNum(questionAnswerDetail.getTotalAnswerNum());
                    mapQuestionAnswerDetail.setTotalAnswerNum(mapQuestionAnswerDetail.getTotalAnswerNum()+questionAnswerDetail.getTotalAnswerNum());
                    mapQuestionAnswerDetail.setCorrectPercent(floatToPercent((float) mapQuestionAnswerDetail.getCorrectNum()/mapQuestionAnswerDetail.getTotalAnswerNum()));
                }
            } else{//若该题未被记录信息，则在map中新增该题的正确率等参数
                if (questionAnswerDetail.getCorrectFlag()==1){
                    questionAnswerDetail.setCorrectNum(questionAnswerDetail.getTotalAnswerNum());
                    questionAnswerDetail.setWrongNum(0);
                    questionAnswerDetail.setTotalAnswerNum(questionAnswerDetail.getTotalAnswerNum());
                    questionAnswerDetail.setCorrectPercent(floatToPercent(1));
                }else{
                    questionAnswerDetail.setCorrectNum(0);
                    questionAnswerDetail.setWrongNum(questionAnswerDetail.getTotalAnswerNum());
                    questionAnswerDetail.setTotalAnswerNum(questionAnswerDetail.getTotalAnswerNum());
                    questionAnswerDetail.setCorrectPercent(floatToPercent(0));
                }
                questionAnswerDetailMap.put(questionAnswerDetail.getQuestionId(),questionAnswerDetail);
            }
        }
        //排序
        valueSortMap.putAll(questionAnswerDetailMap);
        //返回更新完数据后的刷题详情LIST
        return new ArrayList<>(valueSortMap.values());
    }

    /**
     * 代码描述 : 去除字符串中的html标签
     * @author subo
     * modified by : [变更日期YYYY-MM-DD][更改人姓名][变更描述]
     * date :  2018/4/8
     */
    private String trimHtmlTag(String str) {
        return str.replaceAll("<[^>]+>", "").replaceAll("&nbsp;", "");
    }

    public class QuestionSequenceComparator {
        class ValueComparator implements Comparator<Integer> {
            Map<Integer, QuestionAnswerDetailDTO> base;

            //Comparator外部比较器
            public ValueComparator(Map<Integer, QuestionAnswerDetailDTO> base) {
                this.base = base;
            }

            //根据Map的值进行比较
            public int compare(Integer a, Integer b) {
                return base.get(a).getSequence().compareTo(base.get(b).getSequence());
            }
        }
    }

    @Override
    public Integer getQuestionAnswerTotal(String paperCode, Integer roundId) {
        return paperReportMapper.queryQuestionAnswerTotal(paperCode,roundId);
    }

    @Override
    public List<RoundStatisticsDTO> getRoundStatistics(List<Integer> roundIds) {
        return paperReportMapper.getRoundStatistics(roundIds);
    }

    @Override
    public List<QuizzesOrWorkUserCorrectRateDTO> getQuizzesOrWorkUserCorrectRate(UnitReportConditionDTO unitReportConditionDTO,List<Integer> stuIds) {
        List<QuizzesOrWorkUserCorrectRateDTO> quizzesOrWorkUserCorrectRateDTOS;
        Integer pageIndex =(unitReportConditionDTO.getPageNo() - 1) * unitReportConditionDTO.getPageSize();
        Integer countPerPage = unitReportConditionDTO.getPageSize();
        if (unitReportConditionDTO.getUnitIds() == null || "".equals(unitReportConditionDTO.getUnitIds())){
            throw new RuntimeException("课程单元ID不能为空");
        }
        //RPC不支持基本类型空值传递，因此设置-1代表默认为空
        if (unitReportConditionDTO.getUserId() == -1){
            unitReportConditionDTO.setUserId( null );
        }

        List<Integer> unitIdList = stringToIntegerList(unitReportConditionDTO.getUnitIds());
        //根据paper_id分表的
        List<String> paperIndexList = new ArrayList<>();
        List<Integer> paperIdList = paperReportMapper.getPaperIdsByUnitIds(unitIdList);
        if (paperIdList==null || paperIdList.size()==0){
            return null;
//            throw new RuntimeException("该课程单元下没有配置试卷！");
        }
        for (Integer paperId:paperIdList){
            paperIndexList.add(String.format("%01d",paperId%10));
        }
        if (stuIds==null || stuIds.size()==0){
            stuIds = null;
        }

        quizzesOrWorkUserCorrectRateDTOS = paperReportMapper.getQuizzesOrWorkUserCorrectRate(unitReportConditionDTO,unitIdList,stuIds,paperIndexList,pageIndex,countPerPage);

        //RPC不支持基本类型空值传递，因此设置-1代表为空,在调用方需解析
        for (QuizzesOrWorkUserCorrectRateDTO quizzesOrWorkUserCorrectRateDTO : quizzesOrWorkUserCorrectRateDTOS){
            quizzesOrWorkUserCorrectRateDTO.setHomeworkCorrectRate(setDefaultValueToNull(quizzesOrWorkUserCorrectRateDTO.getHomeworkCorrectRate()));
            quizzesOrWorkUserCorrectRateDTO.setQuizzesCorrectRate(setDefaultValueToNull(quizzesOrWorkUserCorrectRateDTO.getQuizzesCorrectRate()));
        }
        return quizzesOrWorkUserCorrectRateDTOS;
    }

    @Override
    public ResUnitsStatisticDTO retrieveQuizOrHomeworkInfo(Integer roundId, String teachUnitIds,Integer teacherId) {
        ResUnitsStatisticDTO resUnitsStatisticDTO = new ResUnitsStatisticDTO();
        List<Integer> unitIdList = stringToIntegerList(teachUnitIds);
        //根据paper_id分表的
        List<String> paperIndexList = new ArrayList<>();
        List<Integer> paperIdList = paperReportMapper.getPaperIdsByUnitIds(unitIdList);
        for (Integer paperId:paperIdList){
            paperIndexList.add(String.format("%01d",paperId%10));
        }
        if (!CollectionUtils.isEmpty(paperIndexList)){
            resUnitsStatisticDTO = paperReportMapper.retrieveQuizOrHomeworkInfo(unitIdList,paperIndexList,getIndexList());
        }
        resUnitsStatisticDTO.setRoundId(roundId);
        resUnitsStatisticDTO.setTeachUnitIds(teachUnitIds);
        resUnitsStatisticDTO.setTeacherId(teacherId);
        resUnitsStatisticDTO.setHomeworkCompleteRate(setDefaultValueToNull(resUnitsStatisticDTO.getHomeworkCompleteRate()));
        resUnitsStatisticDTO.setHomeworkScoreRate(setDefaultValueToNull(resUnitsStatisticDTO.getHomeworkScoreRate()));
        resUnitsStatisticDTO.setQuizzesCompleteRate(setDefaultValueToNull(resUnitsStatisticDTO.getQuizzesCompleteRate()));
        resUnitsStatisticDTO.setQuizzesScoreRate(setDefaultValueToNull(resUnitsStatisticDTO.getQuizzesScoreRate()));
        return resUnitsStatisticDTO;
    }

    @Override
    public Map<String, ResUnitsStatisticDTO> retrieveQuizOrHomeworkInfoMap(List<UnitsStatisticCondition> unitsStatisticConditionList) {
        Map<String, ResUnitsStatisticDTO> resMap = new HashMap<>();
        for (UnitsStatisticCondition unitsStatisticCondition : unitsStatisticConditionList){
            ResUnitsStatisticDTO resUnitsStatisticDTO = new ResUnitsStatisticDTO();
            List<Integer> unitIdList = stringToIntegerList(unitsStatisticCondition.getTeachUnitIds());
            //根据paper_id分表的
            List<String> paperIndexList = new ArrayList<>();
            List<Integer> paperIdList = paperReportMapper.getPaperIdsByUnitIds(unitIdList);
            for (Integer paperId:paperIdList){
                paperIndexList.add(String.format("%01d",paperId%10));
            }
            ResUnitsStatisticDTO resUnitsStatisticScoreRateDTO = new ResUnitsStatisticDTO();
            ResUnitsStatisticDTO resUnitsStatisticCompleteRateDTO = new ResUnitsStatisticDTO();
            if (!CollectionUtils.isEmpty(paperIndexList)){
//                resUnitsStatisticDTO = paperReportMapper.retrieveQuizOrHomeworkInfo(unitIdList,paperIndexList,getIndexList());
                //取得分率
                resUnitsStatisticScoreRateDTO = paperReportMapper.retrieveQuizOrHomeworkScoreRateInfo(unitIdList,paperIndexList);
                //取完成率
                resUnitsStatisticCompleteRateDTO = paperReportMapper.retrieveQuizOrHomeworkCompleteRateInfo(unitIdList,paperIndexList);
            }
            resUnitsStatisticDTO.setRoundId(unitsStatisticCondition.getRoundId());
            resUnitsStatisticDTO.setTeachUnitIds(unitsStatisticCondition.getTeachUnitIds());
            resUnitsStatisticDTO.setTeacherId(unitsStatisticCondition.getTeacherId());
            resUnitsStatisticDTO.setHomeworkCompleteRate(setDefaultValueToNull(resUnitsStatisticCompleteRateDTO.getHomeworkCompleteRate()));
            resUnitsStatisticDTO.setHomeworkScoreRate(setDefaultValueToNull(resUnitsStatisticScoreRateDTO.getHomeworkScoreRate()));
            resUnitsStatisticDTO.setQuizzesCompleteRate(setDefaultValueToNull(resUnitsStatisticCompleteRateDTO.getQuizzesCompleteRate()));
            resUnitsStatisticDTO.setQuizzesScoreRate(setDefaultValueToNull(resUnitsStatisticScoreRateDTO.getQuizzesScoreRate()));
            resMap.put(unitsStatisticCondition.getTeachUnitIds(),resUnitsStatisticDTO);
        }
        return resMap;
    }

    @Override
    public UnitsCorrectRateStatisticDTO retrieveQuizOrHomeworkCorrectInfo(String teachUnitIds) {
        UnitsCorrectRateStatisticDTO unitsCorrectRateStatisticDTO = new UnitsCorrectRateStatisticDTO();
        List<Integer> unitIdList = stringToIntegerList(teachUnitIds);
        List<Integer> paperIdList = paperReportMapper.getPaperIdList(unitIdList);
        List<String> paperIndexList = getPaperIndexList(paperIdList);
        if (!CollectionUtils.isEmpty(paperIndexList)){
            unitsCorrectRateStatisticDTO = paperReportMapper.retrieveQuizOrHomeworkCorrectInfo(unitIdList,paperIndexList);
        }
        unitsCorrectRateStatisticDTO.setTeachUnitIds(teachUnitIds);
        unitsCorrectRateStatisticDTO.setHomeworkAnswerNum(unitsCorrectRateStatisticDTO.getHomeworkAnswerNum()==null ? 0 :unitsCorrectRateStatisticDTO.getHomeworkAnswerNum());
        unitsCorrectRateStatisticDTO.setQuizzesAnswerNum(unitsCorrectRateStatisticDTO.getQuizzesAnswerNum()==null ? 0 : unitsCorrectRateStatisticDTO.getQuizzesAnswerNum());
        unitsCorrectRateStatisticDTO.setHomeworkAvgCorrectRate(setDefaultValueToNull(unitsCorrectRateStatisticDTO.getHomeworkAvgCorrectRate()));
        unitsCorrectRateStatisticDTO.setHomeworkMaxCorrectRate(setDefaultValueToNull(unitsCorrectRateStatisticDTO.getHomeworkMaxCorrectRate()));
        unitsCorrectRateStatisticDTO.setHomeworkMinCorrectRate(setDefaultValueToNull(unitsCorrectRateStatisticDTO.getHomeworkMinCorrectRate()));
        unitsCorrectRateStatisticDTO.setHomeworkAvgCorrectRate(setDefaultValueToNull(unitsCorrectRateStatisticDTO.getHomeworkAvgCorrectRate()));
        unitsCorrectRateStatisticDTO.setHomeworkMaxCorrectRate(setDefaultValueToNull(unitsCorrectRateStatisticDTO.getHomeworkMaxCorrectRate()));
        unitsCorrectRateStatisticDTO.setHomeworkMinCorrectRate(setDefaultValueToNull(unitsCorrectRateStatisticDTO.getHomeworkMinCorrectRate()));
        return unitsCorrectRateStatisticDTO;
    }

    @Override
    public Map<String, UnitsCorrectRateStatisticDTO> retrieveQuizOrHomeworkCorrectInfoMap(List<String> teachUnitIdsList) {
        Map<String, UnitsCorrectRateStatisticDTO> resMap = new HashMap<>();
        for (String teachUnitIds : teachUnitIdsList){
            UnitsCorrectRateStatisticDTO unitsCorrectRateStatisticDTO = new UnitsCorrectRateStatisticDTO();
            List<Integer> unitIdList = stringToIntegerList(teachUnitIds);
            List<Integer> paperIdList = paperReportMapper.getPaperIdList(unitIdList);
            List<String> paperIndexList = getPaperIndexList(paperIdList);
            if (!CollectionUtils.isEmpty(paperIndexList)){
                unitsCorrectRateStatisticDTO = paperReportMapper.retrieveQuizOrHomeworkCorrectInfo(unitIdList,paperIndexList);
            }
            unitsCorrectRateStatisticDTO.setTeachUnitIds(teachUnitIds);
            unitsCorrectRateStatisticDTO.setHomeworkAnswerNum(unitsCorrectRateStatisticDTO.getHomeworkAnswerNum()==null ? 0 :unitsCorrectRateStatisticDTO.getHomeworkAnswerNum());
            unitsCorrectRateStatisticDTO.setQuizzesAnswerNum(unitsCorrectRateStatisticDTO.getQuizzesAnswerNum()==null ? 0 : unitsCorrectRateStatisticDTO.getQuizzesAnswerNum());
            unitsCorrectRateStatisticDTO.setHomeworkAvgCorrectRate(setDefaultValueToNull(unitsCorrectRateStatisticDTO.getHomeworkAvgCorrectRate()));
            unitsCorrectRateStatisticDTO.setHomeworkMaxCorrectRate(setDefaultValueToNull(unitsCorrectRateStatisticDTO.getHomeworkMaxCorrectRate()));
            unitsCorrectRateStatisticDTO.setHomeworkMinCorrectRate(setDefaultValueToNull(unitsCorrectRateStatisticDTO.getHomeworkMinCorrectRate()));
            unitsCorrectRateStatisticDTO.setHomeworkAvgCorrectRate(setDefaultValueToNull(unitsCorrectRateStatisticDTO.getHomeworkAvgCorrectRate()));
            unitsCorrectRateStatisticDTO.setHomeworkMaxCorrectRate(setDefaultValueToNull(unitsCorrectRateStatisticDTO.getHomeworkMaxCorrectRate()));
            unitsCorrectRateStatisticDTO.setHomeworkMinCorrectRate(setDefaultValueToNull(unitsCorrectRateStatisticDTO.getHomeworkMinCorrectRate()));
            resMap.put(teachUnitIds,unitsCorrectRateStatisticDTO);
        }
        return resMap;
    }

    private List<String> getIndexList(){
        List<String> indexList = new ArrayList<>();
        for(int i=0;i<100;i++){
            indexList.add(String.format("%02d",i));
        }
        return indexList;
    }

    private List<String> getPaperIndexList(List<Integer> paperIdList){
        List<String> paperIndexList = new ArrayList<>();
        for (Integer paperId : paperIdList){
            paperIndexList.add(String.format("%01d", paperId % 10));
        }
        return paperIndexList;
    }

    private List<Integer> stringToIntegerList(String strs){
        List<Integer> integerList = new ArrayList<Integer>();
        if (!StringUtils.isEmpty(strs)) {
            String[] arr = strs.split(",");
            List<String> unitStrList = java.util.Arrays.asList(arr);
            for(String str : unitStrList) {
                int i = Integer.parseInt(str);
                integerList.add(i);
            }
        }
        return integerList;
    }

    private Double setDefaultValueToNull(Double d){
        if (d == null){
            return new Double(Constant.DEFAULT_DOUBLE_VALUE);
        }
        return d;
    }

    private String floatToPercent(float num){
        return String.format("%.2f%%", num * 100) ;
    }

}
