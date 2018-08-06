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
@Generated(value = "Autogenerated by Thrift Compiler (0.9.3)", date = "2018-05-03")
public class PaperDetail implements org.apache.thrift.TBase<PaperDetail, PaperDetail._Fields>, java.io.Serializable, Cloneable, Comparable<PaperDetail> {
  private static final org.apache.thrift.protocol.TStruct STRUCT_DESC = new org.apache.thrift.protocol.TStruct("PaperDetail");

  private static final org.apache.thrift.protocol.TField PAPER_ID_FIELD_DESC = new org.apache.thrift.protocol.TField("paperId", org.apache.thrift.protocol.TType.I32, (short)1);
  private static final org.apache.thrift.protocol.TField PAPER_NAME_FIELD_DESC = new org.apache.thrift.protocol.TField("paperName", org.apache.thrift.protocol.TType.STRING, (short)2);
  private static final org.apache.thrift.protocol.TField FINISH_COUNT_FIELD_DESC = new org.apache.thrift.protocol.TField("finishCount", org.apache.thrift.protocol.TType.I32, (short)3);
  private static final org.apache.thrift.protocol.TField QUESTIONS_FIELD_DESC = new org.apache.thrift.protocol.TField("questions", org.apache.thrift.protocol.TType.LIST, (short)4);
  private static final org.apache.thrift.protocol.TField QUIZZES_OR_WORK_USER_ANSWERS_DTOLIST_FIELD_DESC = new org.apache.thrift.protocol.TField("quizzesOrWorkUserAnswersDTOList", org.apache.thrift.protocol.TType.LIST, (short)5);
  private static final org.apache.thrift.protocol.TField RES_FIELD_DESC = new org.apache.thrift.protocol.TField("res", org.apache.thrift.protocol.TType.I32, (short)6);

  private static final Map<Class<? extends IScheme>, SchemeFactory> schemes = new HashMap<Class<? extends IScheme>, SchemeFactory>();
  static {
    schemes.put(StandardScheme.class, new PaperDetailStandardSchemeFactory());
    schemes.put(TupleScheme.class, new PaperDetailTupleSchemeFactory());
  }

  public int paperId; // required
  public String paperName; // required
  public int finishCount; // required
  public List<QuestionDetail> questions; // required
  public List<QuizzesOrWorkUserAnswers> quizzesOrWorkUserAnswersDTOList; // required
  public int res; // required

  /** The set of fields this struct contains, along with convenience methods for finding and manipulating them. */
  public enum _Fields implements org.apache.thrift.TFieldIdEnum {
    PAPER_ID((short)1, "paperId"),
    PAPER_NAME((short)2, "paperName"),
    FINISH_COUNT((short)3, "finishCount"),
    QUESTIONS((short)4, "questions"),
    QUIZZES_OR_WORK_USER_ANSWERS_DTOLIST((short)5, "quizzesOrWorkUserAnswersDTOList"),
    RES((short)6, "res");

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
        case 1: // PAPER_ID
          return PAPER_ID;
        case 2: // PAPER_NAME
          return PAPER_NAME;
        case 3: // FINISH_COUNT
          return FINISH_COUNT;
        case 4: // QUESTIONS
          return QUESTIONS;
        case 5: // QUIZZES_OR_WORK_USER_ANSWERS_DTOLIST
          return QUIZZES_OR_WORK_USER_ANSWERS_DTOLIST;
        case 6: // RES
          return RES;
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
  private static final int __PAPERID_ISSET_ID = 0;
  private static final int __FINISHCOUNT_ISSET_ID = 1;
  private static final int __RES_ISSET_ID = 2;
  private byte __isset_bitfield = 0;
  public static final Map<_Fields, org.apache.thrift.meta_data.FieldMetaData> metaDataMap;
  static {
    Map<_Fields, org.apache.thrift.meta_data.FieldMetaData> tmpMap = new EnumMap<_Fields, org.apache.thrift.meta_data.FieldMetaData>(_Fields.class);
    tmpMap.put(_Fields.PAPER_ID, new org.apache.thrift.meta_data.FieldMetaData("paperId", org.apache.thrift.TFieldRequirementType.DEFAULT, 
        new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.I32)));
    tmpMap.put(_Fields.PAPER_NAME, new org.apache.thrift.meta_data.FieldMetaData("paperName", org.apache.thrift.TFieldRequirementType.DEFAULT, 
        new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.STRING)));
    tmpMap.put(_Fields.FINISH_COUNT, new org.apache.thrift.meta_data.FieldMetaData("finishCount", org.apache.thrift.TFieldRequirementType.DEFAULT, 
        new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.I32)));
    tmpMap.put(_Fields.QUESTIONS, new org.apache.thrift.meta_data.FieldMetaData("questions", org.apache.thrift.TFieldRequirementType.DEFAULT, 
        new org.apache.thrift.meta_data.ListMetaData(org.apache.thrift.protocol.TType.LIST, 
            new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.STRUCT            , "QuestionDetail"))));
    tmpMap.put(_Fields.QUIZZES_OR_WORK_USER_ANSWERS_DTOLIST, new org.apache.thrift.meta_data.FieldMetaData("quizzesOrWorkUserAnswersDTOList", org.apache.thrift.TFieldRequirementType.DEFAULT, 
        new org.apache.thrift.meta_data.ListMetaData(org.apache.thrift.protocol.TType.LIST, 
            new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.STRUCT            , "QuizzesOrWorkUserAnswers"))));
    tmpMap.put(_Fields.RES, new org.apache.thrift.meta_data.FieldMetaData("res", org.apache.thrift.TFieldRequirementType.DEFAULT, 
        new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.I32)));
    metaDataMap = Collections.unmodifiableMap(tmpMap);
    org.apache.thrift.meta_data.FieldMetaData.addStructMetaDataMap(PaperDetail.class, metaDataMap);
  }

  public PaperDetail() {
  }

  public PaperDetail(
    int paperId,
    String paperName,
    int finishCount,
    List<QuestionDetail> questions,
    List<QuizzesOrWorkUserAnswers> quizzesOrWorkUserAnswersDTOList,
    int res)
  {
    this();
    this.paperId = paperId;
    setPaperIdIsSet(true);
    this.paperName = paperName;
    this.finishCount = finishCount;
    setFinishCountIsSet(true);
    this.questions = questions;
    this.quizzesOrWorkUserAnswersDTOList = quizzesOrWorkUserAnswersDTOList;
    this.res = res;
    setResIsSet(true);
  }

  /**
   * Performs a deep copy on <i>other</i>.
   */
  public PaperDetail(PaperDetail other) {
    __isset_bitfield = other.__isset_bitfield;
    this.paperId = other.paperId;
    if (other.isSetPaperName()) {
      this.paperName = other.paperName;
    }
    this.finishCount = other.finishCount;
    if (other.isSetQuestions()) {
      List<QuestionDetail> __this__questions = new ArrayList<QuestionDetail>(other.questions.size());
      for (QuestionDetail other_element : other.questions) {
        __this__questions.add(other_element);
      }
      this.questions = __this__questions;
    }
    if (other.isSetQuizzesOrWorkUserAnswersDTOList()) {
      List<QuizzesOrWorkUserAnswers> __this__quizzesOrWorkUserAnswersDTOList = new ArrayList<QuizzesOrWorkUserAnswers>(other.quizzesOrWorkUserAnswersDTOList.size());
      for (QuizzesOrWorkUserAnswers other_element : other.quizzesOrWorkUserAnswersDTOList) {
        __this__quizzesOrWorkUserAnswersDTOList.add(other_element);
      }
      this.quizzesOrWorkUserAnswersDTOList = __this__quizzesOrWorkUserAnswersDTOList;
    }
    this.res = other.res;
  }

  public PaperDetail deepCopy() {
    return new PaperDetail(this);
  }

  @Override
  public void clear() {
    setPaperIdIsSet(false);
    this.paperId = 0;
    this.paperName = null;
    setFinishCountIsSet(false);
    this.finishCount = 0;
    this.questions = null;
    this.quizzesOrWorkUserAnswersDTOList = null;
    setResIsSet(false);
    this.res = 0;
  }

  public int getPaperId() {
    return this.paperId;
  }

  public PaperDetail setPaperId(int paperId) {
    this.paperId = paperId;
    setPaperIdIsSet(true);
    return this;
  }

  public void unsetPaperId() {
    __isset_bitfield = EncodingUtils.clearBit(__isset_bitfield, __PAPERID_ISSET_ID);
  }

  /** Returns true if field paperId is set (has been assigned a value) and false otherwise */
  public boolean isSetPaperId() {
    return EncodingUtils.testBit(__isset_bitfield, __PAPERID_ISSET_ID);
  }

  public void setPaperIdIsSet(boolean value) {
    __isset_bitfield = EncodingUtils.setBit(__isset_bitfield, __PAPERID_ISSET_ID, value);
  }

  public String getPaperName() {
    return this.paperName;
  }

  public PaperDetail setPaperName(String paperName) {
    this.paperName = paperName;
    return this;
  }

  public void unsetPaperName() {
    this.paperName = null;
  }

  /** Returns true if field paperName is set (has been assigned a value) and false otherwise */
  public boolean isSetPaperName() {
    return this.paperName != null;
  }

  public void setPaperNameIsSet(boolean value) {
    if (!value) {
      this.paperName = null;
    }
  }

  public int getFinishCount() {
    return this.finishCount;
  }

  public PaperDetail setFinishCount(int finishCount) {
    this.finishCount = finishCount;
    setFinishCountIsSet(true);
    return this;
  }

  public void unsetFinishCount() {
    __isset_bitfield = EncodingUtils.clearBit(__isset_bitfield, __FINISHCOUNT_ISSET_ID);
  }

  /** Returns true if field finishCount is set (has been assigned a value) and false otherwise */
  public boolean isSetFinishCount() {
    return EncodingUtils.testBit(__isset_bitfield, __FINISHCOUNT_ISSET_ID);
  }

  public void setFinishCountIsSet(boolean value) {
    __isset_bitfield = EncodingUtils.setBit(__isset_bitfield, __FINISHCOUNT_ISSET_ID, value);
  }

  public int getQuestionsSize() {
    return (this.questions == null) ? 0 : this.questions.size();
  }

  public java.util.Iterator<QuestionDetail> getQuestionsIterator() {
    return (this.questions == null) ? null : this.questions.iterator();
  }

  public void addToQuestions(QuestionDetail elem) {
    if (this.questions == null) {
      this.questions = new ArrayList<QuestionDetail>();
    }
    this.questions.add(elem);
  }

  public List<QuestionDetail> getQuestions() {
    return this.questions;
  }

  public PaperDetail setQuestions(List<QuestionDetail> questions) {
    this.questions = questions;
    return this;
  }

  public void unsetQuestions() {
    this.questions = null;
  }

  /** Returns true if field questions is set (has been assigned a value) and false otherwise */
  public boolean isSetQuestions() {
    return this.questions != null;
  }

  public void setQuestionsIsSet(boolean value) {
    if (!value) {
      this.questions = null;
    }
  }

  public int getQuizzesOrWorkUserAnswersDTOListSize() {
    return (this.quizzesOrWorkUserAnswersDTOList == null) ? 0 : this.quizzesOrWorkUserAnswersDTOList.size();
  }

  public java.util.Iterator<QuizzesOrWorkUserAnswers> getQuizzesOrWorkUserAnswersDTOListIterator() {
    return (this.quizzesOrWorkUserAnswersDTOList == null) ? null : this.quizzesOrWorkUserAnswersDTOList.iterator();
  }

  public void addToQuizzesOrWorkUserAnswersDTOList(QuizzesOrWorkUserAnswers elem) {
    if (this.quizzesOrWorkUserAnswersDTOList == null) {
      this.quizzesOrWorkUserAnswersDTOList = new ArrayList<QuizzesOrWorkUserAnswers>();
    }
    this.quizzesOrWorkUserAnswersDTOList.add(elem);
  }

  public List<QuizzesOrWorkUserAnswers> getQuizzesOrWorkUserAnswersDTOList() {
    return this.quizzesOrWorkUserAnswersDTOList;
  }

  public PaperDetail setQuizzesOrWorkUserAnswersDTOList(List<QuizzesOrWorkUserAnswers> quizzesOrWorkUserAnswersDTOList) {
    this.quizzesOrWorkUserAnswersDTOList = quizzesOrWorkUserAnswersDTOList;
    return this;
  }

  public void unsetQuizzesOrWorkUserAnswersDTOList() {
    this.quizzesOrWorkUserAnswersDTOList = null;
  }

  /** Returns true if field quizzesOrWorkUserAnswersDTOList is set (has been assigned a value) and false otherwise */
  public boolean isSetQuizzesOrWorkUserAnswersDTOList() {
    return this.quizzesOrWorkUserAnswersDTOList != null;
  }

  public void setQuizzesOrWorkUserAnswersDTOListIsSet(boolean value) {
    if (!value) {
      this.quizzesOrWorkUserAnswersDTOList = null;
    }
  }

  public int getRes() {
    return this.res;
  }

  public PaperDetail setRes(int res) {
    this.res = res;
    setResIsSet(true);
    return this;
  }

  public void unsetRes() {
    __isset_bitfield = EncodingUtils.clearBit(__isset_bitfield, __RES_ISSET_ID);
  }

  /** Returns true if field res is set (has been assigned a value) and false otherwise */
  public boolean isSetRes() {
    return EncodingUtils.testBit(__isset_bitfield, __RES_ISSET_ID);
  }

  public void setResIsSet(boolean value) {
    __isset_bitfield = EncodingUtils.setBit(__isset_bitfield, __RES_ISSET_ID, value);
  }

  public void setFieldValue(_Fields field, Object value) {
    switch (field) {
    case PAPER_ID:
      if (value == null) {
        unsetPaperId();
      } else {
        setPaperId((Integer)value);
      }
      break;

    case PAPER_NAME:
      if (value == null) {
        unsetPaperName();
      } else {
        setPaperName((String)value);
      }
      break;

    case FINISH_COUNT:
      if (value == null) {
        unsetFinishCount();
      } else {
        setFinishCount((Integer)value);
      }
      break;

    case QUESTIONS:
      if (value == null) {
        unsetQuestions();
      } else {
        setQuestions((List<QuestionDetail>)value);
      }
      break;

    case QUIZZES_OR_WORK_USER_ANSWERS_DTOLIST:
      if (value == null) {
        unsetQuizzesOrWorkUserAnswersDTOList();
      } else {
        setQuizzesOrWorkUserAnswersDTOList((List<QuizzesOrWorkUserAnswers>)value);
      }
      break;

    case RES:
      if (value == null) {
        unsetRes();
      } else {
        setRes((Integer)value);
      }
      break;

    }
  }

  public Object getFieldValue(_Fields field) {
    switch (field) {
    case PAPER_ID:
      return getPaperId();

    case PAPER_NAME:
      return getPaperName();

    case FINISH_COUNT:
      return getFinishCount();

    case QUESTIONS:
      return getQuestions();

    case QUIZZES_OR_WORK_USER_ANSWERS_DTOLIST:
      return getQuizzesOrWorkUserAnswersDTOList();

    case RES:
      return getRes();

    }
    throw new IllegalStateException();
  }

  /** Returns true if field corresponding to fieldID is set (has been assigned a value) and false otherwise */
  public boolean isSet(_Fields field) {
    if (field == null) {
      throw new IllegalArgumentException();
    }

    switch (field) {
    case PAPER_ID:
      return isSetPaperId();
    case PAPER_NAME:
      return isSetPaperName();
    case FINISH_COUNT:
      return isSetFinishCount();
    case QUESTIONS:
      return isSetQuestions();
    case QUIZZES_OR_WORK_USER_ANSWERS_DTOLIST:
      return isSetQuizzesOrWorkUserAnswersDTOList();
    case RES:
      return isSetRes();
    }
    throw new IllegalStateException();
  }

  @Override
  public boolean equals(Object that) {
    if (that == null)
      return false;
    if (that instanceof PaperDetail)
      return this.equals((PaperDetail)that);
    return false;
  }

  public boolean equals(PaperDetail that) {
    if (that == null)
      return false;

    boolean this_present_paperId = true;
    boolean that_present_paperId = true;
    if (this_present_paperId || that_present_paperId) {
      if (!(this_present_paperId && that_present_paperId))
        return false;
      if (this.paperId != that.paperId)
        return false;
    }

    boolean this_present_paperName = true && this.isSetPaperName();
    boolean that_present_paperName = true && that.isSetPaperName();
    if (this_present_paperName || that_present_paperName) {
      if (!(this_present_paperName && that_present_paperName))
        return false;
      if (!this.paperName.equals(that.paperName))
        return false;
    }

    boolean this_present_finishCount = true;
    boolean that_present_finishCount = true;
    if (this_present_finishCount || that_present_finishCount) {
      if (!(this_present_finishCount && that_present_finishCount))
        return false;
      if (this.finishCount != that.finishCount)
        return false;
    }

    boolean this_present_questions = true && this.isSetQuestions();
    boolean that_present_questions = true && that.isSetQuestions();
    if (this_present_questions || that_present_questions) {
      if (!(this_present_questions && that_present_questions))
        return false;
      if (!this.questions.equals(that.questions))
        return false;
    }

    boolean this_present_quizzesOrWorkUserAnswersDTOList = true && this.isSetQuizzesOrWorkUserAnswersDTOList();
    boolean that_present_quizzesOrWorkUserAnswersDTOList = true && that.isSetQuizzesOrWorkUserAnswersDTOList();
    if (this_present_quizzesOrWorkUserAnswersDTOList || that_present_quizzesOrWorkUserAnswersDTOList) {
      if (!(this_present_quizzesOrWorkUserAnswersDTOList && that_present_quizzesOrWorkUserAnswersDTOList))
        return false;
      if (!this.quizzesOrWorkUserAnswersDTOList.equals(that.quizzesOrWorkUserAnswersDTOList))
        return false;
    }

    boolean this_present_res = true;
    boolean that_present_res = true;
    if (this_present_res || that_present_res) {
      if (!(this_present_res && that_present_res))
        return false;
      if (this.res != that.res)
        return false;
    }

    return true;
  }

  @Override
  public int hashCode() {
    List<Object> list = new ArrayList<Object>();

    boolean present_paperId = true;
    list.add(present_paperId);
    if (present_paperId)
      list.add(paperId);

    boolean present_paperName = true && (isSetPaperName());
    list.add(present_paperName);
    if (present_paperName)
      list.add(paperName);

    boolean present_finishCount = true;
    list.add(present_finishCount);
    if (present_finishCount)
      list.add(finishCount);

    boolean present_questions = true && (isSetQuestions());
    list.add(present_questions);
    if (present_questions)
      list.add(questions);

    boolean present_quizzesOrWorkUserAnswersDTOList = true && (isSetQuizzesOrWorkUserAnswersDTOList());
    list.add(present_quizzesOrWorkUserAnswersDTOList);
    if (present_quizzesOrWorkUserAnswersDTOList)
      list.add(quizzesOrWorkUserAnswersDTOList);

    boolean present_res = true;
    list.add(present_res);
    if (present_res)
      list.add(res);

    return list.hashCode();
  }

  @Override
  public int compareTo(PaperDetail other) {
    if (!getClass().equals(other.getClass())) {
      return getClass().getName().compareTo(other.getClass().getName());
    }

    int lastComparison = 0;

    lastComparison = Boolean.valueOf(isSetPaperId()).compareTo(other.isSetPaperId());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetPaperId()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.paperId, other.paperId);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    lastComparison = Boolean.valueOf(isSetPaperName()).compareTo(other.isSetPaperName());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetPaperName()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.paperName, other.paperName);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    lastComparison = Boolean.valueOf(isSetFinishCount()).compareTo(other.isSetFinishCount());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetFinishCount()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.finishCount, other.finishCount);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    lastComparison = Boolean.valueOf(isSetQuestions()).compareTo(other.isSetQuestions());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetQuestions()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.questions, other.questions);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    lastComparison = Boolean.valueOf(isSetQuizzesOrWorkUserAnswersDTOList()).compareTo(other.isSetQuizzesOrWorkUserAnswersDTOList());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetQuizzesOrWorkUserAnswersDTOList()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.quizzesOrWorkUserAnswersDTOList, other.quizzesOrWorkUserAnswersDTOList);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    lastComparison = Boolean.valueOf(isSetRes()).compareTo(other.isSetRes());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetRes()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.res, other.res);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    return 0;
  }

  public _Fields fieldForId(int fieldId) {
    return _Fields.findByThriftId(fieldId);
  }

  public void read(org.apache.thrift.protocol.TProtocol iprot) throws org.apache.thrift.TException {
    schemes.get(iprot.getScheme()).getScheme().read(iprot, this);
  }

  public void write(org.apache.thrift.protocol.TProtocol oprot) throws org.apache.thrift.TException {
    schemes.get(oprot.getScheme()).getScheme().write(oprot, this);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder("PaperDetail(");
    boolean first = true;

    sb.append("paperId:");
    sb.append(this.paperId);
    first = false;
    if (!first) sb.append(", ");
    sb.append("paperName:");
    if (this.paperName == null) {
      sb.append("null");
    } else {
      sb.append(this.paperName);
    }
    first = false;
    if (!first) sb.append(", ");
    sb.append("finishCount:");
    sb.append(this.finishCount);
    first = false;
    if (!first) sb.append(", ");
    sb.append("questions:");
    if (this.questions == null) {
      sb.append("null");
    } else {
      sb.append(this.questions);
    }
    first = false;
    if (!first) sb.append(", ");
    sb.append("quizzesOrWorkUserAnswersDTOList:");
    if (this.quizzesOrWorkUserAnswersDTOList == null) {
      sb.append("null");
    } else {
      sb.append(this.quizzesOrWorkUserAnswersDTOList);
    }
    first = false;
    if (!first) sb.append(", ");
    sb.append("res:");
    sb.append(this.res);
    first = false;
    sb.append(")");
    return sb.toString();
  }

  public void validate() throws org.apache.thrift.TException {
    // check for required fields
    // check for sub-struct validity
  }

  private void writeObject(java.io.ObjectOutputStream out) throws java.io.IOException {
    try {
      write(new org.apache.thrift.protocol.TCompactProtocol(new org.apache.thrift.transport.TIOStreamTransport(out)));
    } catch (org.apache.thrift.TException te) {
      throw new java.io.IOException(te);
    }
  }

  private void readObject(java.io.ObjectInputStream in) throws java.io.IOException, ClassNotFoundException {
    try {
      // it doesn't seem like you should have to do this, but java serialization is wacky, and doesn't call the default constructor.
      __isset_bitfield = 0;
      read(new org.apache.thrift.protocol.TCompactProtocol(new org.apache.thrift.transport.TIOStreamTransport(in)));
    } catch (org.apache.thrift.TException te) {
      throw new java.io.IOException(te);
    }
  }

  private static class PaperDetailStandardSchemeFactory implements SchemeFactory {
    public PaperDetailStandardScheme getScheme() {
      return new PaperDetailStandardScheme();
    }
  }

  private static class PaperDetailStandardScheme extends StandardScheme<PaperDetail> {

    public void read(org.apache.thrift.protocol.TProtocol iprot, PaperDetail struct) throws org.apache.thrift.TException {
      org.apache.thrift.protocol.TField schemeField;
      iprot.readStructBegin();
      while (true)
      {
        schemeField = iprot.readFieldBegin();
        if (schemeField.type == org.apache.thrift.protocol.TType.STOP) { 
          break;
        }
        switch (schemeField.id) {
          case 1: // PAPER_ID
            if (schemeField.type == org.apache.thrift.protocol.TType.I32) {
              struct.paperId = iprot.readI32();
              struct.setPaperIdIsSet(true);
            } else { 
              org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
            }
            break;
          case 2: // PAPER_NAME
            if (schemeField.type == org.apache.thrift.protocol.TType.STRING) {
              struct.paperName = iprot.readString();
              struct.setPaperNameIsSet(true);
            } else { 
              org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
            }
            break;
          case 3: // FINISH_COUNT
            if (schemeField.type == org.apache.thrift.protocol.TType.I32) {
              struct.finishCount = iprot.readI32();
              struct.setFinishCountIsSet(true);
            } else { 
              org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
            }
            break;
          case 4: // QUESTIONS
            if (schemeField.type == org.apache.thrift.protocol.TType.LIST) {
              {
                org.apache.thrift.protocol.TList _list8 = iprot.readListBegin();
                struct.questions = new ArrayList<QuestionDetail>(_list8.size);
                QuestionDetail _elem9;
                for (int _i10 = 0; _i10 < _list8.size; ++_i10)
                {
                  _elem9 = new QuestionDetail();
                  _elem9.read(iprot);
                  struct.questions.add(_elem9);
                }
                iprot.readListEnd();
              }
              struct.setQuestionsIsSet(true);
            } else { 
              org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
            }
            break;
          case 5: // QUIZZES_OR_WORK_USER_ANSWERS_DTOLIST
            if (schemeField.type == org.apache.thrift.protocol.TType.LIST) {
              {
                org.apache.thrift.protocol.TList _list11 = iprot.readListBegin();
                struct.quizzesOrWorkUserAnswersDTOList = new ArrayList<QuizzesOrWorkUserAnswers>(_list11.size);
                QuizzesOrWorkUserAnswers _elem12;
                for (int _i13 = 0; _i13 < _list11.size; ++_i13)
                {
                  _elem12 = new QuizzesOrWorkUserAnswers();
                  _elem12.read(iprot);
                  struct.quizzesOrWorkUserAnswersDTOList.add(_elem12);
                }
                iprot.readListEnd();
              }
              struct.setQuizzesOrWorkUserAnswersDTOListIsSet(true);
            } else { 
              org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
            }
            break;
          case 6: // RES
            if (schemeField.type == org.apache.thrift.protocol.TType.I32) {
              struct.res = iprot.readI32();
              struct.setResIsSet(true);
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

    public void write(org.apache.thrift.protocol.TProtocol oprot, PaperDetail struct) throws org.apache.thrift.TException {
      struct.validate();

      oprot.writeStructBegin(STRUCT_DESC);
      oprot.writeFieldBegin(PAPER_ID_FIELD_DESC);
      oprot.writeI32(struct.paperId);
      oprot.writeFieldEnd();
      if (struct.paperName != null) {
        oprot.writeFieldBegin(PAPER_NAME_FIELD_DESC);
        oprot.writeString(struct.paperName);
        oprot.writeFieldEnd();
      }
      oprot.writeFieldBegin(FINISH_COUNT_FIELD_DESC);
      oprot.writeI32(struct.finishCount);
      oprot.writeFieldEnd();
      if (struct.questions != null) {
        oprot.writeFieldBegin(QUESTIONS_FIELD_DESC);
        {
          oprot.writeListBegin(new org.apache.thrift.protocol.TList(org.apache.thrift.protocol.TType.STRUCT, struct.questions.size()));
          for (QuestionDetail _iter14 : struct.questions)
          {
            _iter14.write(oprot);
          }
          oprot.writeListEnd();
        }
        oprot.writeFieldEnd();
      }
      if (struct.quizzesOrWorkUserAnswersDTOList != null) {
        oprot.writeFieldBegin(QUIZZES_OR_WORK_USER_ANSWERS_DTOLIST_FIELD_DESC);
        {
          oprot.writeListBegin(new org.apache.thrift.protocol.TList(org.apache.thrift.protocol.TType.STRUCT, struct.quizzesOrWorkUserAnswersDTOList.size()));
          for (QuizzesOrWorkUserAnswers _iter15 : struct.quizzesOrWorkUserAnswersDTOList)
          {
            _iter15.write(oprot);
          }
          oprot.writeListEnd();
        }
        oprot.writeFieldEnd();
      }
      oprot.writeFieldBegin(RES_FIELD_DESC);
      oprot.writeI32(struct.res);
      oprot.writeFieldEnd();
      oprot.writeFieldStop();
      oprot.writeStructEnd();
    }

  }

  private static class PaperDetailTupleSchemeFactory implements SchemeFactory {
    public PaperDetailTupleScheme getScheme() {
      return new PaperDetailTupleScheme();
    }
  }

  private static class PaperDetailTupleScheme extends TupleScheme<PaperDetail> {

    @Override
    public void write(org.apache.thrift.protocol.TProtocol prot, PaperDetail struct) throws org.apache.thrift.TException {
      TTupleProtocol oprot = (TTupleProtocol) prot;
      BitSet optionals = new BitSet();
      if (struct.isSetPaperId()) {
        optionals.set(0);
      }
      if (struct.isSetPaperName()) {
        optionals.set(1);
      }
      if (struct.isSetFinishCount()) {
        optionals.set(2);
      }
      if (struct.isSetQuestions()) {
        optionals.set(3);
      }
      if (struct.isSetQuizzesOrWorkUserAnswersDTOList()) {
        optionals.set(4);
      }
      if (struct.isSetRes()) {
        optionals.set(5);
      }
      oprot.writeBitSet(optionals, 6);
      if (struct.isSetPaperId()) {
        oprot.writeI32(struct.paperId);
      }
      if (struct.isSetPaperName()) {
        oprot.writeString(struct.paperName);
      }
      if (struct.isSetFinishCount()) {
        oprot.writeI32(struct.finishCount);
      }
      if (struct.isSetQuestions()) {
        {
          oprot.writeI32(struct.questions.size());
          for (QuestionDetail _iter16 : struct.questions)
          {
            _iter16.write(oprot);
          }
        }
      }
      if (struct.isSetQuizzesOrWorkUserAnswersDTOList()) {
        {
          oprot.writeI32(struct.quizzesOrWorkUserAnswersDTOList.size());
          for (QuizzesOrWorkUserAnswers _iter17 : struct.quizzesOrWorkUserAnswersDTOList)
          {
            _iter17.write(oprot);
          }
        }
      }
      if (struct.isSetRes()) {
        oprot.writeI32(struct.res);
      }
    }

    @Override
    public void read(org.apache.thrift.protocol.TProtocol prot, PaperDetail struct) throws org.apache.thrift.TException {
      TTupleProtocol iprot = (TTupleProtocol) prot;
      BitSet incoming = iprot.readBitSet(6);
      if (incoming.get(0)) {
        struct.paperId = iprot.readI32();
        struct.setPaperIdIsSet(true);
      }
      if (incoming.get(1)) {
        struct.paperName = iprot.readString();
        struct.setPaperNameIsSet(true);
      }
      if (incoming.get(2)) {
        struct.finishCount = iprot.readI32();
        struct.setFinishCountIsSet(true);
      }
      if (incoming.get(3)) {
        {
          org.apache.thrift.protocol.TList _list18 = new org.apache.thrift.protocol.TList(org.apache.thrift.protocol.TType.STRUCT, iprot.readI32());
          struct.questions = new ArrayList<QuestionDetail>(_list18.size);
          QuestionDetail _elem19;
          for (int _i20 = 0; _i20 < _list18.size; ++_i20)
          {
            _elem19 = new QuestionDetail();
            _elem19.read(iprot);
            struct.questions.add(_elem19);
          }
        }
        struct.setQuestionsIsSet(true);
      }
      if (incoming.get(4)) {
        {
          org.apache.thrift.protocol.TList _list21 = new org.apache.thrift.protocol.TList(org.apache.thrift.protocol.TType.STRUCT, iprot.readI32());
          struct.quizzesOrWorkUserAnswersDTOList = new ArrayList<QuizzesOrWorkUserAnswers>(_list21.size);
          QuizzesOrWorkUserAnswers _elem22;
          for (int _i23 = 0; _i23 < _list21.size; ++_i23)
          {
            _elem22 = new QuizzesOrWorkUserAnswers();
            _elem22.read(iprot);
            struct.quizzesOrWorkUserAnswersDTOList.add(_elem22);
          }
        }
        struct.setQuizzesOrWorkUserAnswersDTOListIsSet(true);
      }
      if (incoming.get(5)) {
        struct.res = iprot.readI32();
        struct.setResIsSet(true);
      }
    }
  }

}
