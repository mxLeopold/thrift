package com.sunlands.rpc.common;

/**
 * 常量
 *
 * @Author: 吴雨佳
 * @since: 2018/3/19 9:40
 * @update: [变更日期yyyy-MM-dd][变更人姓名][变更描述]
 */
public class Constant {
    /**
     * question_id 来源
     */
    public static final String CONTENT_TYPE_ESSAY = "ESSAY";
    public static final String CONTENT_TYPE_BLANK = "BLANK";
    public static final String CONTENT_TYPE_CHOICE = "CHOICE";

    public static class TikuUserQuestion {

        public static final String TABLE_NAME = "t_tiku_user_question_";

        public static final String TABLE_NAME_FORMAT = "t_tiku_user_question_%02d";

        public static String getTableName(int studentId) {
            return String.format(TABLE_NAME_FORMAT, studentId % 100);
        }
    }

    /**
     * t_tiku_user_record_xx 常量
     *
     * @author 吴雨佳
     */
    public static class TikuUserRecord {

        public static final String TABLE_NAME = "t_tiku_user_record_";

        private static final String TABLE_NAME_FORMAT = "t_tiku_user_record_%02d";

        public static String getTableName(int studentId) {
            return String.format(TABLE_NAME_FORMAT, studentId % 100);
        }

        public enum ExerciseTypeEnum {
            INTELLIGENT_EXERCISE("INTELLIGENT_EXERCISE", "智能练习"),
            CHAPTER_EXERCISE("CHAPTER_EXERCISE", "章节练习"),
            REAL_EXAM("REAL_EXAM", "真题练习"),
            ASSIGNMENTS("ASSIGNMENTS", "课后作业"),
            QUIZ("QUIZ", "随堂考"),
            MODEL_EXAM("MODEL_EXAM", "考前模拟");

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

            ExerciseTypeEnum(String code, String name) {
                this.code = code;
                this.name = name;
            }

            public static String getNameByCode(String code) {
                for (ExerciseTypeEnum c : ExerciseTypeEnum.values()) {
                    if (c.getCode().equalsIgnoreCase(code)) {
                        return c.name;
                    }
                }
                return null;
            }

            public static String getCodeByName(String name) {
                for (ExerciseTypeEnum c : ExerciseTypeEnum.values()) {
                    if (c.getName().equalsIgnoreCase(name)) {
                        return c.code;
                    }
                }
                return null;
            }

        }
    }
}
