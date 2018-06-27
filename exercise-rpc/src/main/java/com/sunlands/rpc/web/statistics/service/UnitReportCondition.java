/**
 * Autogenerated by Thrift Compiler (0.9.3)
 *
 * DO NOT EDIT UNLESS YOU ARE SURE THAT YOU KNOW WHAT YOU ARE DOING
 *  @generated
 */
package com.sunlands.rpc.web.statistics.service;

import org.apache.thrift.scheme.IScheme;
import org.apache.thrift.scheme.SchemeFactory;
import org.apache.thrift.scheme.StandardScheme;

import org.apache.thrift.scheme.TupleScheme;
import org.apache.thrift.protocol.TTupleProtocol;
import org.apache.thrift.protocol.TProtocolException;
import org.apache.thrift.EncodingUtils;
import org.apache.thrift.TException;
import org.apache.thrift.async.AsyncMethodCallback;
import org.apache.thrift.server.AbstractNonblockingServer.*;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;
import java.util.EnumMap;
import java.util.Set;
import java.util.HashSet;
import java.util.EnumSet;
import java.util.Collections;
import java.util.BitSet;
import java.nio.ByteBuffer;
import java.util.Arrays;
import javax.annotation.Generated;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@SuppressWarnings({"cast", "rawtypes", "serial", "unchecked"})
@Generated(value = "Autogenerated by Thrift Compiler (0.9.3)", date = "2018-06-27")
public class UnitReportCondition implements org.apache.thrift.TBase<UnitReportCondition, UnitReportCondition._Fields>, java.io.Serializable, Cloneable, Comparable<UnitReportCondition> {
  private static final org.apache.thrift.protocol.TStruct STRUCT_DESC = new org.apache.thrift.protocol.TStruct("UnitReportCondition");

  private static final org.apache.thrift.protocol.TField UNIT_ID_STR_FIELD_DESC = new org.apache.thrift.protocol.TField("unitIdStr", org.apache.thrift.protocol.TType.STRING, (short)1);
  private static final org.apache.thrift.protocol.TField USER_NAME_FIELD_DESC = new org.apache.thrift.protocol.TField("userName", org.apache.thrift.protocol.TType.STRING, (short)2);
  private static final org.apache.thrift.protocol.TField USER_ID_FIELD_DESC = new org.apache.thrift.protocol.TField("userId", org.apache.thrift.protocol.TType.I32, (short)3);
  private static final org.apache.thrift.protocol.TField ATTEND_STATUS_FIELD_DESC = new org.apache.thrift.protocol.TField("attendStatus", org.apache.thrift.protocol.TType.STRING, (short)4);
  private static final org.apache.thrift.protocol.TField EVALUATE_SCORE_LEVEL_FIELD_DESC = new org.apache.thrift.protocol.TField("evaluateScoreLevel", org.apache.thrift.protocol.TType.STRING, (short)5);
  private static final org.apache.thrift.protocol.TField QUIZZES_SORT_FIELD_DESC = new org.apache.thrift.protocol.TField("quizzesSort", org.apache.thrift.protocol.TType.STRING, (short)6);
  private static final org.apache.thrift.protocol.TField HOMEWORK_SORT_FIELD_DESC = new org.apache.thrift.protocol.TField("homeworkSort", org.apache.thrift.protocol.TType.STRING, (short)7);
  private static final org.apache.thrift.protocol.TField PAGE_NO_FIELD_DESC = new org.apache.thrift.protocol.TField("pageNo", org.apache.thrift.protocol.TType.I32, (short)8);
  private static final org.apache.thrift.protocol.TField PAGE_SIZE_FIELD_DESC = new org.apache.thrift.protocol.TField("pageSize", org.apache.thrift.protocol.TType.I32, (short)9);

  private static final Map<Class<? extends IScheme>, SchemeFactory> schemes = new HashMap<Class<? extends IScheme>, SchemeFactory>();
  static {
    schemes.put(StandardScheme.class, new UnitReportConditionStandardSchemeFactory());
    schemes.put(TupleScheme.class, new UnitReportConditionTupleSchemeFactory());
  }

  public String unitIdStr; // required
  public String userName; // required
  public int userId; // required
  public String attendStatus; // required
  public String evaluateScoreLevel; // required
  public String quizzesSort; // required
  public String homeworkSort; // required
  public int pageNo; // required
  public int pageSize; // required

  /** The set of fields this struct contains, along with convenience methods for finding and manipulating them. */
  public enum _Fields implements org.apache.thrift.TFieldIdEnum {
    UNIT_ID_STR((short)1, "unitIdStr"),
    USER_NAME((short)2, "userName"),
    USER_ID((short)3, "userId"),
    ATTEND_STATUS((short)4, "attendStatus"),
    EVALUATE_SCORE_LEVEL((short)5, "evaluateScoreLevel"),
    QUIZZES_SORT((short)6, "quizzesSort"),
    HOMEWORK_SORT((short)7, "homeworkSort"),
    PAGE_NO((short)8, "pageNo"),
    PAGE_SIZE((short)9, "pageSize");

    private static final Map<String, _Fields> byName = new HashMap<String, _Fields>();

    static {
      for (_Fields field : EnumSet.allOf(_Fields.class)) {
        byName.put(field.getFieldName(), field);
      }
    }

    /**
     * Find the _Fields constant that matches fieldId, or null if its not found.
     */
    public static _Fields findByThriftId(int fieldId) {
      switch(fieldId) {
        case 1: // UNIT_ID_STR
          return UNIT_ID_STR;
        case 2: // USER_NAME
          return USER_NAME;
        case 3: // USER_ID
          return USER_ID;
        case 4: // ATTEND_STATUS
          return ATTEND_STATUS;
        case 5: // EVALUATE_SCORE_LEVEL
          return EVALUATE_SCORE_LEVEL;
        case 6: // QUIZZES_SORT
          return QUIZZES_SORT;
        case 7: // HOMEWORK_SORT
          return HOMEWORK_SORT;
        case 8: // PAGE_NO
          return PAGE_NO;
        case 9: // PAGE_SIZE
          return PAGE_SIZE;
        default:
          return null;
      }
    }

    /**
     * Find the _Fields constant that matches fieldId, throwing an exception
     * if it is not found.
     */
    public static _Fields findByThriftIdOrThrow(int fieldId) {
      _Fields fields = findByThriftId(fieldId);
      if (fields == null) throw new IllegalArgumentException("Field " + fieldId + " doesn't exist!");
      return fields;
    }

    /**
     * Find the _Fields constant that matches name, or null if its not found.
     */
    public static _Fields findByName(String name) {
      return byName.get(name);
    }

    private final short _thriftId;
    private final String _fieldName;

    _Fields(short thriftId, String fieldName) {
      _thriftId = thriftId;
      _fieldName = fieldName;
    }

    public short getThriftFieldId() {
      return _thriftId;
    }

    public String getFieldName() {
      return _fieldName;
    }
  }

  // isset id assignments
  private static final int __USERID_ISSET_ID = 0;
  private static final int __PAGENO_ISSET_ID = 1;
  private static final int __PAGESIZE_ISSET_ID = 2;
  private byte __isset_bitfield = 0;
  public static final Map<_Fields, org.apache.thrift.meta_data.FieldMetaData> metaDataMap;
  static {
    Map<_Fields, org.apache.thrift.meta_data.FieldMetaData> tmpMap = new EnumMap<_Fields, org.apache.thrift.meta_data.FieldMetaData>(_Fields.class);
    tmpMap.put(_Fields.UNIT_ID_STR, new org.apache.thrift.meta_data.FieldMetaData("unitIdStr", org.apache.thrift.TFieldRequirementType.DEFAULT, 
        new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.STRING)));
    tmpMap.put(_Fields.USER_NAME, new org.apache.thrift.meta_data.FieldMetaData("userName", org.apache.thrift.TFieldRequirementType.DEFAULT, 
        new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.STRING)));
    tmpMap.put(_Fields.USER_ID, new org.apache.thrift.meta_data.FieldMetaData("userId", org.apache.thrift.TFieldRequirementType.DEFAULT, 
        new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.I32)));
    tmpMap.put(_Fields.ATTEND_STATUS, new org.apache.thrift.meta_data.FieldMetaData("attendStatus", org.apache.thrift.TFieldRequirementType.DEFAULT, 
        new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.STRING)));
    tmpMap.put(_Fields.EVALUATE_SCORE_LEVEL, new org.apache.thrift.meta_data.FieldMetaData("evaluateScoreLevel", org.apache.thrift.TFieldRequirementType.DEFAULT, 
        new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.STRING)));
    tmpMap.put(_Fields.QUIZZES_SORT, new org.apache.thrift.meta_data.FieldMetaData("quizzesSort", org.apache.thrift.TFieldRequirementType.DEFAULT, 
        new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.STRING)));
    tmpMap.put(_Fields.HOMEWORK_SORT, new org.apache.thrift.meta_data.FieldMetaData("homeworkSort", org.apache.thrift.TFieldRequirementType.DEFAULT, 
        new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.STRING)));
    tmpMap.put(_Fields.PAGE_NO, new org.apache.thrift.meta_data.FieldMetaData("pageNo", org.apache.thrift.TFieldRequirementType.DEFAULT, 
        new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.I32)));
    tmpMap.put(_Fields.PAGE_SIZE, new org.apache.thrift.meta_data.FieldMetaData("pageSize", org.apache.thrift.TFieldRequirementType.DEFAULT, 
        new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.I32)));
    metaDataMap = Collections.unmodifiableMap(tmpMap);
    org.apache.thrift.meta_data.FieldMetaData.addStructMetaDataMap(UnitReportCondition.class, metaDataMap);
  }

  public UnitReportCondition() {
  }

  public UnitReportCondition(
    String unitIdStr,
    String userName,
    int userId,
    String attendStatus,
    String evaluateScoreLevel,
    String quizzesSort,
    String homeworkSort,
    int pageNo,
    int pageSize)
  {
    this();
    this.unitIdStr = unitIdStr;
    this.userName = userName;
    this.userId = userId;
    setUserIdIsSet(true);
    this.attendStatus = attendStatus;
    this.evaluateScoreLevel = evaluateScoreLevel;
    this.quizzesSort = quizzesSort;
    this.homeworkSort = homeworkSort;
    this.pageNo = pageNo;
    setPageNoIsSet(true);
    this.pageSize = pageSize;
    setPageSizeIsSet(true);
  }

  /**
   * Performs a deep copy on <i>other</i>.
   */
  public UnitReportCondition(UnitReportCondition other) {
    __isset_bitfield = other.__isset_bitfield;
    if (other.isSetUnitIdStr()) {
      this.unitIdStr = other.unitIdStr;
    }
    if (other.isSetUserName()) {
      this.userName = other.userName;
    }
    this.userId = other.userId;
    if (other.isSetAttendStatus()) {
      this.attendStatus = other.attendStatus;
    }
    if (other.isSetEvaluateScoreLevel()) {
      this.evaluateScoreLevel = other.evaluateScoreLevel;
    }
    if (other.isSetQuizzesSort()) {
      this.quizzesSort = other.quizzesSort;
    }
    if (other.isSetHomeworkSort()) {
      this.homeworkSort = other.homeworkSort;
    }
    this.pageNo = other.pageNo;
    this.pageSize = other.pageSize;
  }

  public UnitReportCondition deepCopy() {
    return new UnitReportCondition(this);
  }

  @Override
  public void clear() {
    this.unitIdStr = null;
    this.userName = null;
    setUserIdIsSet(false);
    this.userId = 0;
    this.attendStatus = null;
    this.evaluateScoreLevel = null;
    this.quizzesSort = null;
    this.homeworkSort = null;
    setPageNoIsSet(false);
    this.pageNo = 0;
    setPageSizeIsSet(false);
    this.pageSize = 0;
  }

  public String getUnitIdStr() {
    return this.unitIdStr;
  }

  public UnitReportCondition setUnitIdStr(String unitIdStr) {
    this.unitIdStr = unitIdStr;
    return this;
  }

  public void unsetUnitIdStr() {
    this.unitIdStr = null;
  }

  /** Returns true if field unitIdStr is set (has been assigned a value) and false otherwise */
  public boolean isSetUnitIdStr() {
    return this.unitIdStr != null;
  }

  public void setUnitIdStrIsSet(boolean value) {
    if (!value) {
      this.unitIdStr = null;
    }
  }

  public String getUserName() {
    return this.userName;
  }

  public UnitReportCondition setUserName(String userName) {
    this.userName = userName;
    return this;
  }

  public void unsetUserName() {
    this.userName = null;
  }

  /** Returns true if field userName is set (has been assigned a value) and false otherwise */
  public boolean isSetUserName() {
    return this.userName != null;
  }

  public void setUserNameIsSet(boolean value) {
    if (!value) {
      this.userName = null;
    }
  }

  public int getUserId() {
    return this.userId;
  }

  public UnitReportCondition setUserId(int userId) {
    this.userId = userId;
    setUserIdIsSet(true);
    return this;
  }

  public void unsetUserId() {
    __isset_bitfield = EncodingUtils.clearBit(__isset_bitfield, __USERID_ISSET_ID);
  }

  /** Returns true if field userId is set (has been assigned a value) and false otherwise */
  public boolean isSetUserId() {
    return EncodingUtils.testBit(__isset_bitfield, __USERID_ISSET_ID);
  }

  public void setUserIdIsSet(boolean value) {
    __isset_bitfield = EncodingUtils.setBit(__isset_bitfield, __USERID_ISSET_ID, value);
  }

  public String getAttendStatus() {
    return this.attendStatus;
  }

  public UnitReportCondition setAttendStatus(String attendStatus) {
    this.attendStatus = attendStatus;
    return this;
  }

  public void unsetAttendStatus() {
    this.attendStatus = null;
  }

  /** Returns true if field attendStatus is set (has been assigned a value) and false otherwise */
  public boolean isSetAttendStatus() {
    return this.attendStatus != null;
  }

  public void setAttendStatusIsSet(boolean value) {
    if (!value) {
      this.attendStatus = null;
    }
  }

  public String getEvaluateScoreLevel() {
    return this.evaluateScoreLevel;
  }

  public UnitReportCondition setEvaluateScoreLevel(String evaluateScoreLevel) {
    this.evaluateScoreLevel = evaluateScoreLevel;
    return this;
  }

  public void unsetEvaluateScoreLevel() {
    this.evaluateScoreLevel = null;
  }

  /** Returns true if field evaluateScoreLevel is set (has been assigned a value) and false otherwise */
  public boolean isSetEvaluateScoreLevel() {
    return this.evaluateScoreLevel != null;
  }

  public void setEvaluateScoreLevelIsSet(boolean value) {
    if (!value) {
      this.evaluateScoreLevel = null;
    }
  }

  public String getQuizzesSort() {
    return this.quizzesSort;
  }

  public UnitReportCondition setQuizzesSort(String quizzesSort) {
    this.quizzesSort = quizzesSort;
    return this;
  }

  public void unsetQuizzesSort() {
    this.quizzesSort = null;
  }

  /** Returns true if field quizzesSort is set (has been assigned a value) and false otherwise */
  public boolean isSetQuizzesSort() {
    return this.quizzesSort != null;
  }

  public void setQuizzesSortIsSet(boolean value) {
    if (!value) {
      this.quizzesSort = null;
    }
  }

  public String getHomeworkSort() {
    return this.homeworkSort;
  }

  public UnitReportCondition setHomeworkSort(String homeworkSort) {
    this.homeworkSort = homeworkSort;
    return this;
  }

  public void unsetHomeworkSort() {
    this.homeworkSort = null;
  }

  /** Returns true if field homeworkSort is set (has been assigned a value) and false otherwise */
  public boolean isSetHomeworkSort() {
    return this.homeworkSort != null;
  }

  public void setHomeworkSortIsSet(boolean value) {
    if (!value) {
      this.homeworkSort = null;
    }
  }

  public int getPageNo() {
    return this.pageNo;
  }

  public UnitReportCondition setPageNo(int pageNo) {
    this.pageNo = pageNo;
    setPageNoIsSet(true);
    return this;
  }

  public void unsetPageNo() {
    __isset_bitfield = EncodingUtils.clearBit(__isset_bitfield, __PAGENO_ISSET_ID);
  }

  /** Returns true if field pageNo is set (has been assigned a value) and false otherwise */
  public boolean isSetPageNo() {
    return EncodingUtils.testBit(__isset_bitfield, __PAGENO_ISSET_ID);
  }

  public void setPageNoIsSet(boolean value) {
    __isset_bitfield = EncodingUtils.setBit(__isset_bitfield, __PAGENO_ISSET_ID, value);
  }

  public int getPageSize() {
    return this.pageSize;
  }

  public UnitReportCondition setPageSize(int pageSize) {
    this.pageSize = pageSize;
    setPageSizeIsSet(true);
    return this;
  }

  public void unsetPageSize() {
    __isset_bitfield = EncodingUtils.clearBit(__isset_bitfield, __PAGESIZE_ISSET_ID);
  }

  /** Returns true if field pageSize is set (has been assigned a value) and false otherwise */
  public boolean isSetPageSize() {
    return EncodingUtils.testBit(__isset_bitfield, __PAGESIZE_ISSET_ID);
  }

  public void setPageSizeIsSet(boolean value) {
    __isset_bitfield = EncodingUtils.setBit(__isset_bitfield, __PAGESIZE_ISSET_ID, value);
  }

  public void setFieldValue(_Fields field, Object value) {
    switch (field) {
    case UNIT_ID_STR:
      if (value == null) {
        unsetUnitIdStr();
      } else {
        setUnitIdStr((String)value);
      }
      break;

    case USER_NAME:
      if (value == null) {
        unsetUserName();
      } else {
        setUserName((String)value);
      }
      break;

    case USER_ID:
      if (value == null) {
        unsetUserId();
      } else {
        setUserId((Integer)value);
      }
      break;

    case ATTEND_STATUS:
      if (value == null) {
        unsetAttendStatus();
      } else {
        setAttendStatus((String)value);
      }
      break;

    case EVALUATE_SCORE_LEVEL:
      if (value == null) {
        unsetEvaluateScoreLevel();
      } else {
        setEvaluateScoreLevel((String)value);
      }
      break;

    case QUIZZES_SORT:
      if (value == null) {
        unsetQuizzesSort();
      } else {
        setQuizzesSort((String)value);
      }
      break;

    case HOMEWORK_SORT:
      if (value == null) {
        unsetHomeworkSort();
      } else {
        setHomeworkSort((String)value);
      }
      break;

    case PAGE_NO:
      if (value == null) {
        unsetPageNo();
      } else {
        setPageNo((Integer)value);
      }
      break;

    case PAGE_SIZE:
      if (value == null) {
        unsetPageSize();
      } else {
        setPageSize((Integer)value);
      }
      break;

    }
  }

  public Object getFieldValue(_Fields field) {
    switch (field) {
    case UNIT_ID_STR:
      return getUnitIdStr();

    case USER_NAME:
      return getUserName();

    case USER_ID:
      return getUserId();

    case ATTEND_STATUS:
      return getAttendStatus();

    case EVALUATE_SCORE_LEVEL:
      return getEvaluateScoreLevel();

    case QUIZZES_SORT:
      return getQuizzesSort();

    case HOMEWORK_SORT:
      return getHomeworkSort();

    case PAGE_NO:
      return getPageNo();

    case PAGE_SIZE:
      return getPageSize();

    }
    throw new IllegalStateException();
  }

  /** Returns true if field corresponding to fieldID is set (has been assigned a value) and false otherwise */
  public boolean isSet(_Fields field) {
    if (field == null) {
      throw new IllegalArgumentException();
    }

    switch (field) {
    case UNIT_ID_STR:
      return isSetUnitIdStr();
    case USER_NAME:
      return isSetUserName();
    case USER_ID:
      return isSetUserId();
    case ATTEND_STATUS:
      return isSetAttendStatus();
    case EVALUATE_SCORE_LEVEL:
      return isSetEvaluateScoreLevel();
    case QUIZZES_SORT:
      return isSetQuizzesSort();
    case HOMEWORK_SORT:
      return isSetHomeworkSort();
    case PAGE_NO:
      return isSetPageNo();
    case PAGE_SIZE:
      return isSetPageSize();
    }
    throw new IllegalStateException();
  }

  @Override
  public boolean equals(Object that) {
    if (that == null)
      return false;
    if (that instanceof UnitReportCondition)
      return this.equals((UnitReportCondition)that);
    return false;
  }

  public boolean equals(UnitReportCondition that) {
    if (that == null)
      return false;

    boolean this_present_unitIdStr = true && this.isSetUnitIdStr();
    boolean that_present_unitIdStr = true && that.isSetUnitIdStr();
    if (this_present_unitIdStr || that_present_unitIdStr) {
      if (!(this_present_unitIdStr && that_present_unitIdStr))
        return false;
      if (!this.unitIdStr.equals(that.unitIdStr))
        return false;
    }

    boolean this_present_userName = true && this.isSetUserName();
    boolean that_present_userName = true && that.isSetUserName();
    if (this_present_userName || that_present_userName) {
      if (!(this_present_userName && that_present_userName))
        return false;
      if (!this.userName.equals(that.userName))
        return false;
    }

    boolean this_present_userId = true;
    boolean that_present_userId = true;
    if (this_present_userId || that_present_userId) {
      if (!(this_present_userId && that_present_userId))
        return false;
      if (this.userId != that.userId)
        return false;
    }

    boolean this_present_attendStatus = true && this.isSetAttendStatus();
    boolean that_present_attendStatus = true && that.isSetAttendStatus();
    if (this_present_attendStatus || that_present_attendStatus) {
      if (!(this_present_attendStatus && that_present_attendStatus))
        return false;
      if (!this.attendStatus.equals(that.attendStatus))
        return false;
    }

    boolean this_present_evaluateScoreLevel = true && this.isSetEvaluateScoreLevel();
    boolean that_present_evaluateScoreLevel = true && that.isSetEvaluateScoreLevel();
    if (this_present_evaluateScoreLevel || that_present_evaluateScoreLevel) {
      if (!(this_present_evaluateScoreLevel && that_present_evaluateScoreLevel))
        return false;
      if (!this.evaluateScoreLevel.equals(that.evaluateScoreLevel))
        return false;
    }

    boolean this_present_quizzesSort = true && this.isSetQuizzesSort();
    boolean that_present_quizzesSort = true && that.isSetQuizzesSort();
    if (this_present_quizzesSort || that_present_quizzesSort) {
      if (!(this_present_quizzesSort && that_present_quizzesSort))
        return false;
      if (!this.quizzesSort.equals(that.quizzesSort))
        return false;
    }

    boolean this_present_homeworkSort = true && this.isSetHomeworkSort();
    boolean that_present_homeworkSort = true && that.isSetHomeworkSort();
    if (this_present_homeworkSort || that_present_homeworkSort) {
      if (!(this_present_homeworkSort && that_present_homeworkSort))
        return false;
      if (!this.homeworkSort.equals(that.homeworkSort))
        return false;
    }

    boolean this_present_pageNo = true;
    boolean that_present_pageNo = true;
    if (this_present_pageNo || that_present_pageNo) {
      if (!(this_present_pageNo && that_present_pageNo))
        return false;
      if (this.pageNo != that.pageNo)
        return false;
    }

    boolean this_present_pageSize = true;
    boolean that_present_pageSize = true;
    if (this_present_pageSize || that_present_pageSize) {
      if (!(this_present_pageSize && that_present_pageSize))
        return false;
      if (this.pageSize != that.pageSize)
        return false;
    }

    return true;
  }

  @Override
  public int hashCode() {
    List<Object> list = new ArrayList<Object>();

    boolean present_unitIdStr = true && (isSetUnitIdStr());
    list.add(present_unitIdStr);
    if (present_unitIdStr)
      list.add(unitIdStr);

    boolean present_userName = true && (isSetUserName());
    list.add(present_userName);
    if (present_userName)
      list.add(userName);

    boolean present_userId = true;
    list.add(present_userId);
    if (present_userId)
      list.add(userId);

    boolean present_attendStatus = true && (isSetAttendStatus());
    list.add(present_attendStatus);
    if (present_attendStatus)
      list.add(attendStatus);

    boolean present_evaluateScoreLevel = true && (isSetEvaluateScoreLevel());
    list.add(present_evaluateScoreLevel);
    if (present_evaluateScoreLevel)
      list.add(evaluateScoreLevel);

    boolean present_quizzesSort = true && (isSetQuizzesSort());
    list.add(present_quizzesSort);
    if (present_quizzesSort)
      list.add(quizzesSort);

    boolean present_homeworkSort = true && (isSetHomeworkSort());
    list.add(present_homeworkSort);
    if (present_homeworkSort)
      list.add(homeworkSort);

    boolean present_pageNo = true;
    list.add(present_pageNo);
    if (present_pageNo)
      list.add(pageNo);

    boolean present_pageSize = true;
    list.add(present_pageSize);
    if (present_pageSize)
      list.add(pageSize);

    return list.hashCode();
  }

  @Override
  public int compareTo(UnitReportCondition other) {
    if (!getClass().equals(other.getClass())) {
      return getClass().getName().compareTo(other.getClass().getName());
    }

    int lastComparison = 0;

    lastComparison = Boolean.valueOf(isSetUnitIdStr()).compareTo(other.isSetUnitIdStr());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetUnitIdStr()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.unitIdStr, other.unitIdStr);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    lastComparison = Boolean.valueOf(isSetUserName()).compareTo(other.isSetUserName());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetUserName()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.userName, other.userName);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    lastComparison = Boolean.valueOf(isSetUserId()).compareTo(other.isSetUserId());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetUserId()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.userId, other.userId);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    lastComparison = Boolean.valueOf(isSetAttendStatus()).compareTo(other.isSetAttendStatus());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetAttendStatus()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.attendStatus, other.attendStatus);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    lastComparison = Boolean.valueOf(isSetEvaluateScoreLevel()).compareTo(other.isSetEvaluateScoreLevel());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetEvaluateScoreLevel()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.evaluateScoreLevel, other.evaluateScoreLevel);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    lastComparison = Boolean.valueOf(isSetQuizzesSort()).compareTo(other.isSetQuizzesSort());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetQuizzesSort()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.quizzesSort, other.quizzesSort);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    lastComparison = Boolean.valueOf(isSetHomeworkSort()).compareTo(other.isSetHomeworkSort());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetHomeworkSort()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.homeworkSort, other.homeworkSort);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    lastComparison = Boolean.valueOf(isSetPageNo()).compareTo(other.isSetPageNo());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetPageNo()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.pageNo, other.pageNo);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    lastComparison = Boolean.valueOf(isSetPageSize()).compareTo(other.isSetPageSize());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetPageSize()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.pageSize, other.pageSize);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    return 0;
  }

  public _Fields fieldForId(int fieldId) {
    return _Fields.findByThriftId(fieldId);
  }

  public void read(org.apache.thrift.protocol.TProtocol iprot) throws TException {
    schemes.get(iprot.getScheme()).getScheme().read(iprot, this);
  }

  public void write(org.apache.thrift.protocol.TProtocol oprot) throws TException {
    schemes.get(oprot.getScheme()).getScheme().write(oprot, this);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder("UnitReportCondition(");
    boolean first = true;

    sb.append("unitIdStr:");
    if (this.unitIdStr == null) {
      sb.append("null");
    } else {
      sb.append(this.unitIdStr);
    }
    first = false;
    if (!first) sb.append(", ");
    sb.append("userName:");
    if (this.userName == null) {
      sb.append("null");
    } else {
      sb.append(this.userName);
    }
    first = false;
    if (!first) sb.append(", ");
    sb.append("userId:");
    sb.append(this.userId);
    first = false;
    if (!first) sb.append(", ");
    sb.append("attendStatus:");
    if (this.attendStatus == null) {
      sb.append("null");
    } else {
      sb.append(this.attendStatus);
    }
    first = false;
    if (!first) sb.append(", ");
    sb.append("evaluateScoreLevel:");
    if (this.evaluateScoreLevel == null) {
      sb.append("null");
    } else {
      sb.append(this.evaluateScoreLevel);
    }
    first = false;
    if (!first) sb.append(", ");
    sb.append("quizzesSort:");
    if (this.quizzesSort == null) {
      sb.append("null");
    } else {
      sb.append(this.quizzesSort);
    }
    first = false;
    if (!first) sb.append(", ");
    sb.append("homeworkSort:");
    if (this.homeworkSort == null) {
      sb.append("null");
    } else {
      sb.append(this.homeworkSort);
    }
    first = false;
    if (!first) sb.append(", ");
    sb.append("pageNo:");
    sb.append(this.pageNo);
    first = false;
    if (!first) sb.append(", ");
    sb.append("pageSize:");
    sb.append(this.pageSize);
    first = false;
    sb.append(")");
    return sb.toString();
  }

  public void validate() throws TException {
    // check for required fields
    // check for sub-struct validity
  }

  private void writeObject(java.io.ObjectOutputStream out) throws java.io.IOException {
    try {
      write(new org.apache.thrift.protocol.TCompactProtocol(new org.apache.thrift.transport.TIOStreamTransport(out)));
    } catch (TException te) {
      throw new java.io.IOException(te);
    }
  }

  private void readObject(java.io.ObjectInputStream in) throws java.io.IOException, ClassNotFoundException {
    try {
      // it doesn't seem like you should have to do this, but java serialization is wacky, and doesn't call the default constructor.
      __isset_bitfield = 0;
      read(new org.apache.thrift.protocol.TCompactProtocol(new org.apache.thrift.transport.TIOStreamTransport(in)));
    } catch (TException te) {
      throw new java.io.IOException(te);
    }
  }

  private static class UnitReportConditionStandardSchemeFactory implements SchemeFactory {
    public UnitReportConditionStandardScheme getScheme() {
      return new UnitReportConditionStandardScheme();
    }
  }

  private static class UnitReportConditionStandardScheme extends StandardScheme<UnitReportCondition> {

    public void read(org.apache.thrift.protocol.TProtocol iprot, UnitReportCondition struct) throws TException {
      org.apache.thrift.protocol.TField schemeField;
      iprot.readStructBegin();
      while (true)
      {
        schemeField = iprot.readFieldBegin();
        if (schemeField.type == org.apache.thrift.protocol.TType.STOP) { 
          break;
        }
        switch (schemeField.id) {
          case 1: // UNIT_ID_STR
            if (schemeField.type == org.apache.thrift.protocol.TType.STRING) {
              struct.unitIdStr = iprot.readString();
              struct.setUnitIdStrIsSet(true);
            } else { 
              org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
            }
            break;
          case 2: // USER_NAME
            if (schemeField.type == org.apache.thrift.protocol.TType.STRING) {
              struct.userName = iprot.readString();
              struct.setUserNameIsSet(true);
            } else { 
              org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
            }
            break;
          case 3: // USER_ID
            if (schemeField.type == org.apache.thrift.protocol.TType.I32) {
              struct.userId = iprot.readI32();
              struct.setUserIdIsSet(true);
            } else { 
              org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
            }
            break;
          case 4: // ATTEND_STATUS
            if (schemeField.type == org.apache.thrift.protocol.TType.STRING) {
              struct.attendStatus = iprot.readString();
              struct.setAttendStatusIsSet(true);
            } else { 
              org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
            }
            break;
          case 5: // EVALUATE_SCORE_LEVEL
            if (schemeField.type == org.apache.thrift.protocol.TType.STRING) {
              struct.evaluateScoreLevel = iprot.readString();
              struct.setEvaluateScoreLevelIsSet(true);
            } else { 
              org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
            }
            break;
          case 6: // QUIZZES_SORT
            if (schemeField.type == org.apache.thrift.protocol.TType.STRING) {
              struct.quizzesSort = iprot.readString();
              struct.setQuizzesSortIsSet(true);
            } else { 
              org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
            }
            break;
          case 7: // HOMEWORK_SORT
            if (schemeField.type == org.apache.thrift.protocol.TType.STRING) {
              struct.homeworkSort = iprot.readString();
              struct.setHomeworkSortIsSet(true);
            } else { 
              org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
            }
            break;
          case 8: // PAGE_NO
            if (schemeField.type == org.apache.thrift.protocol.TType.I32) {
              struct.pageNo = iprot.readI32();
              struct.setPageNoIsSet(true);
            } else { 
              org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
            }
            break;
          case 9: // PAGE_SIZE
            if (schemeField.type == org.apache.thrift.protocol.TType.I32) {
              struct.pageSize = iprot.readI32();
              struct.setPageSizeIsSet(true);
            } else { 
              org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
            }
            break;
          default:
            org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
        }
        iprot.readFieldEnd();
      }
      iprot.readStructEnd();

      // check for required fields of primitive type, which can't be checked in the validate method
      struct.validate();
    }

    public void write(org.apache.thrift.protocol.TProtocol oprot, UnitReportCondition struct) throws TException {
      struct.validate();

      oprot.writeStructBegin(STRUCT_DESC);
      if (struct.unitIdStr != null) {
        oprot.writeFieldBegin(UNIT_ID_STR_FIELD_DESC);
        oprot.writeString(struct.unitIdStr);
        oprot.writeFieldEnd();
      }
      if (struct.userName != null) {
        oprot.writeFieldBegin(USER_NAME_FIELD_DESC);
        oprot.writeString(struct.userName);
        oprot.writeFieldEnd();
      }
      oprot.writeFieldBegin(USER_ID_FIELD_DESC);
      oprot.writeI32(struct.userId);
      oprot.writeFieldEnd();
      if (struct.attendStatus != null) {
        oprot.writeFieldBegin(ATTEND_STATUS_FIELD_DESC);
        oprot.writeString(struct.attendStatus);
        oprot.writeFieldEnd();
      }
      if (struct.evaluateScoreLevel != null) {
        oprot.writeFieldBegin(EVALUATE_SCORE_LEVEL_FIELD_DESC);
        oprot.writeString(struct.evaluateScoreLevel);
        oprot.writeFieldEnd();
      }
      if (struct.quizzesSort != null) {
        oprot.writeFieldBegin(QUIZZES_SORT_FIELD_DESC);
        oprot.writeString(struct.quizzesSort);
        oprot.writeFieldEnd();
      }
      if (struct.homeworkSort != null) {
        oprot.writeFieldBegin(HOMEWORK_SORT_FIELD_DESC);
        oprot.writeString(struct.homeworkSort);
        oprot.writeFieldEnd();
      }
      oprot.writeFieldBegin(PAGE_NO_FIELD_DESC);
      oprot.writeI32(struct.pageNo);
      oprot.writeFieldEnd();
      oprot.writeFieldBegin(PAGE_SIZE_FIELD_DESC);
      oprot.writeI32(struct.pageSize);
      oprot.writeFieldEnd();
      oprot.writeFieldStop();
      oprot.writeStructEnd();
    }

  }

  private static class UnitReportConditionTupleSchemeFactory implements SchemeFactory {
    public UnitReportConditionTupleScheme getScheme() {
      return new UnitReportConditionTupleScheme();
    }
  }

  private static class UnitReportConditionTupleScheme extends TupleScheme<UnitReportCondition> {

    @Override
    public void write(org.apache.thrift.protocol.TProtocol prot, UnitReportCondition struct) throws TException {
      TTupleProtocol oprot = (TTupleProtocol) prot;
      BitSet optionals = new BitSet();
      if (struct.isSetUnitIdStr()) {
        optionals.set(0);
      }
      if (struct.isSetUserName()) {
        optionals.set(1);
      }
      if (struct.isSetUserId()) {
        optionals.set(2);
      }
      if (struct.isSetAttendStatus()) {
        optionals.set(3);
      }
      if (struct.isSetEvaluateScoreLevel()) {
        optionals.set(4);
      }
      if (struct.isSetQuizzesSort()) {
        optionals.set(5);
      }
      if (struct.isSetHomeworkSort()) {
        optionals.set(6);
      }
      if (struct.isSetPageNo()) {
        optionals.set(7);
      }
      if (struct.isSetPageSize()) {
        optionals.set(8);
      }
      oprot.writeBitSet(optionals, 9);
      if (struct.isSetUnitIdStr()) {
        oprot.writeString(struct.unitIdStr);
      }
      if (struct.isSetUserName()) {
        oprot.writeString(struct.userName);
      }
      if (struct.isSetUserId()) {
        oprot.writeI32(struct.userId);
      }
      if (struct.isSetAttendStatus()) {
        oprot.writeString(struct.attendStatus);
      }
      if (struct.isSetEvaluateScoreLevel()) {
        oprot.writeString(struct.evaluateScoreLevel);
      }
      if (struct.isSetQuizzesSort()) {
        oprot.writeString(struct.quizzesSort);
      }
      if (struct.isSetHomeworkSort()) {
        oprot.writeString(struct.homeworkSort);
      }
      if (struct.isSetPageNo()) {
        oprot.writeI32(struct.pageNo);
      }
      if (struct.isSetPageSize()) {
        oprot.writeI32(struct.pageSize);
      }
    }

    @Override
    public void read(org.apache.thrift.protocol.TProtocol prot, UnitReportCondition struct) throws TException {
      TTupleProtocol iprot = (TTupleProtocol) prot;
      BitSet incoming = iprot.readBitSet(9);
      if (incoming.get(0)) {
        struct.unitIdStr = iprot.readString();
        struct.setUnitIdStrIsSet(true);
      }
      if (incoming.get(1)) {
        struct.userName = iprot.readString();
        struct.setUserNameIsSet(true);
      }
      if (incoming.get(2)) {
        struct.userId = iprot.readI32();
        struct.setUserIdIsSet(true);
      }
      if (incoming.get(3)) {
        struct.attendStatus = iprot.readString();
        struct.setAttendStatusIsSet(true);
      }
      if (incoming.get(4)) {
        struct.evaluateScoreLevel = iprot.readString();
        struct.setEvaluateScoreLevelIsSet(true);
      }
      if (incoming.get(5)) {
        struct.quizzesSort = iprot.readString();
        struct.setQuizzesSortIsSet(true);
      }
      if (incoming.get(6)) {
        struct.homeworkSort = iprot.readString();
        struct.setHomeworkSortIsSet(true);
      }
      if (incoming.get(7)) {
        struct.pageNo = iprot.readI32();
        struct.setPageNoIsSet(true);
      }
      if (incoming.get(8)) {
        struct.pageSize = iprot.readI32();
        struct.setPageSizeIsSet(true);
      }
    }
  }

}
