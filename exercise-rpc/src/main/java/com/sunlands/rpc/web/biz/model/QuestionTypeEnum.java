package com.sunlands.rpc.web.biz.model;

/**
 * 试题类型
 */
public enum QuestionTypeEnum {

    SINGLE_CHOICE("SINGLE_CHOICE", "单选题"),
    MULTI_CHOICE("MULTI_CHOICE", "多选题"),
    JUDGE_CHOICE("JUDGE_CHOICE", "判断题"),
    SUBJECTIVE("SUBJECTIVE", "主观题"),
    ORDER_FILL_BLANK("ORDER_FILL_BLANK", "填空题"), //有序填空题
    DISORDER_FILL_BLANK("DISORDER_FILL_BLANK", "填空题"), //无序填空题
    FILL_BLANK("FILL_BLANK","填空题"), //统一的填空题,包含上述两种类型
    JUDGE_ESSAY("JUDGE_ESSAY", "判断论述题"),
    ESSAY("ESSAY", "文字题"),
    COMPREHENSIVE("COMPREHENSIVE", "综合题"),
    READING_COMPREHENSION("READING_COMPREHENSION", "完形填空题"),
    MANY_TO_MANY("MANY_TO_MANY", "多选多");

    private String code;
    private String name;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    // 构造方法
    QuestionTypeEnum(String code, String name) {
        this.code = code;
        this.name = name;
    }

    public static String getNameByCode(String code) {
        for (QuestionTypeEnum c : QuestionTypeEnum.values()) {
            if (c.getCode().equalsIgnoreCase(code)) {
                return c.name;
            }
        }
        return null;
    }

    public static String getCodeByName(String name){
        for (QuestionTypeEnum c : QuestionTypeEnum.values()) {
            if (c.getName().equalsIgnoreCase(name)) {
                return c.code;
            }
        }
        return null;
    }

    public static boolean isBigQuestion(String name){
        if (QuestionTypeEnum.MANY_TO_MANY.getCode().equals(name) ||
                QuestionTypeEnum.READING_COMPREHENSION.getCode().equals(name) ||
                QuestionTypeEnum.COMPREHENSIVE.getCode().equals(name)){
            return true;
        }
        return false;
    }

}
