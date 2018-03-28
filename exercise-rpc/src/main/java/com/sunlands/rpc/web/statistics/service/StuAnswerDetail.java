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
@Generated(value = "Autogenerated by Thrift Compiler (0.9.3)", date = "2018-03-28")
public class StuAnswerDetail implements org.apache.thrift.TBase<StuAnswerDetail, StuAnswerDetail._Fields>, java.io.Serializable, Cloneable, Comparable<StuAnswerDetail> {
  private static final org.apache.thrift.protocol.TStruct STRUCT_DESC = new org.apache.thrift.protocol.TStruct("StuAnswerDetail");

  private static final org.apache.thrift.protocol.TField USER_NUMBER_FIELD_DESC = new org.apache.thrift.protocol.TField("userNumber", org.apache.thrift.protocol.TType.I32, (short)1);
  private static final org.apache.thrift.protocol.TField USERNAME_FIELD_DESC = new org.apache.thrift.protocol.TField("username", org.apache.thrift.protocol.TType.STRING, (short)2);
  private static final org.apache.thrift.protocol.TField ANSWERED_TIME_FIELD_DESC = new org.apache.thrift.protocol.TField("answeredTime", org.apache.thrift.protocol.TType.I32, (short)3);
  private static final org.apache.thrift.protocol.TField RIGHT_NUM_FIELD_DESC = new org.apache.thrift.protocol.TField("rightNum", org.apache.thrift.protocol.TType.I32, (short)4);
  private static final org.apache.thrift.protocol.TField WRONG_NUM_FIELD_DESC = new org.apache.thrift.protocol.TField("wrongNum", org.apache.thrift.protocol.TType.I32, (short)5);
  private static final org.apache.thrift.protocol.TField CORRECT_RATE_FIELD_DESC = new org.apache.thrift.protocol.TField("correctRate", org.apache.thrift.protocol.TType.DOUBLE, (short)6);

  private static final Map<Class<? extends IScheme>, SchemeFactory> schemes = new HashMap<Class<? extends IScheme>, SchemeFactory>();
  static {
    schemes.put(StandardScheme.class, new StuAnswerDetailStandardSchemeFactory());
    schemes.put(TupleScheme.class, new StuAnswerDetailTupleSchemeFactory());
  }

  public int userNumber; // required
  public String username; // required
  public int answeredTime; // required
  public int rightNum; // required
  public int wrongNum; // required
  public double correctRate; // required

  /** The set of fields this struct contains, along with convenience methods for finding and manipulating them. */
  public enum _Fields implements org.apache.thrift.TFieldIdEnum {
    USER_NUMBER((short)1, "userNumber"),
    USERNAME((short)2, "username"),
    ANSWERED_TIME((short)3, "answeredTime"),
    RIGHT_NUM((short)4, "rightNum"),
    WRONG_NUM((short)5, "wrongNum"),
    CORRECT_RATE((short)6, "correctRate");

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
        case 1: // USER_NUMBER
          return USER_NUMBER;
        case 2: // USERNAME
          return USERNAME;
        case 3: // ANSWERED_TIME
          return ANSWERED_TIME;
        case 4: // RIGHT_NUM
          return RIGHT_NUM;
        case 5: // WRONG_NUM
          return WRONG_NUM;
        case 6: // CORRECT_RATE
          return CORRECT_RATE;
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
  private static final int __USERNUMBER_ISSET_ID = 0;
  private static final int __ANSWEREDTIME_ISSET_ID = 1;
  private static final int __RIGHTNUM_ISSET_ID = 2;
  private static final int __WRONGNUM_ISSET_ID = 3;
  private static final int __CORRECTRATE_ISSET_ID = 4;
  private byte __isset_bitfield = 0;
  public static final Map<_Fields, org.apache.thrift.meta_data.FieldMetaData> metaDataMap;
  static {
    Map<_Fields, org.apache.thrift.meta_data.FieldMetaData> tmpMap = new EnumMap<_Fields, org.apache.thrift.meta_data.FieldMetaData>(_Fields.class);
    tmpMap.put(_Fields.USER_NUMBER, new org.apache.thrift.meta_data.FieldMetaData("userNumber", org.apache.thrift.TFieldRequirementType.DEFAULT, 
        new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.I32)));
    tmpMap.put(_Fields.USERNAME, new org.apache.thrift.meta_data.FieldMetaData("username", org.apache.thrift.TFieldRequirementType.DEFAULT, 
        new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.STRING)));
    tmpMap.put(_Fields.ANSWERED_TIME, new org.apache.thrift.meta_data.FieldMetaData("answeredTime", org.apache.thrift.TFieldRequirementType.DEFAULT, 
        new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.I32)));
    tmpMap.put(_Fields.RIGHT_NUM, new org.apache.thrift.meta_data.FieldMetaData("rightNum", org.apache.thrift.TFieldRequirementType.DEFAULT, 
        new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.I32)));
    tmpMap.put(_Fields.WRONG_NUM, new org.apache.thrift.meta_data.FieldMetaData("wrongNum", org.apache.thrift.TFieldRequirementType.DEFAULT, 
        new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.I32)));
    tmpMap.put(_Fields.CORRECT_RATE, new org.apache.thrift.meta_data.FieldMetaData("correctRate", org.apache.thrift.TFieldRequirementType.DEFAULT, 
        new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.DOUBLE)));
    metaDataMap = Collections.unmodifiableMap(tmpMap);
    org.apache.thrift.meta_data.FieldMetaData.addStructMetaDataMap(StuAnswerDetail.class, metaDataMap);
  }

  public StuAnswerDetail() {
  }

  public StuAnswerDetail(
    int userNumber,
    String username,
    int answeredTime,
    int rightNum,
    int wrongNum,
    double correctRate)
  {
    this();
    this.userNumber = userNumber;
    setUserNumberIsSet(true);
    this.username = username;
    this.answeredTime = answeredTime;
    setAnsweredTimeIsSet(true);
    this.rightNum = rightNum;
    setRightNumIsSet(true);
    this.wrongNum = wrongNum;
    setWrongNumIsSet(true);
    this.correctRate = correctRate;
    setCorrectRateIsSet(true);
  }

  /**
   * Performs a deep copy on <i>other</i>.
   */
  public StuAnswerDetail(StuAnswerDetail other) {
    __isset_bitfield = other.__isset_bitfield;
    this.userNumber = other.userNumber;
    if (other.isSetUsername()) {
      this.username = other.username;
    }
    this.answeredTime = other.answeredTime;
    this.rightNum = other.rightNum;
    this.wrongNum = other.wrongNum;
    this.correctRate = other.correctRate;
  }

  public StuAnswerDetail deepCopy() {
    return new StuAnswerDetail(this);
  }

  @Override
  public void clear() {
    setUserNumberIsSet(false);
    this.userNumber = 0;
    this.username = null;
    setAnsweredTimeIsSet(false);
    this.answeredTime = 0;
    setRightNumIsSet(false);
    this.rightNum = 0;
    setWrongNumIsSet(false);
    this.wrongNum = 0;
    setCorrectRateIsSet(false);
    this.correctRate = 0.0;
  }

  public int getUserNumber() {
    return this.userNumber;
  }

  public StuAnswerDetail setUserNumber(int userNumber) {
    this.userNumber = userNumber;
    setUserNumberIsSet(true);
    return this;
  }

  public void unsetUserNumber() {
    __isset_bitfield = EncodingUtils.clearBit(__isset_bitfield, __USERNUMBER_ISSET_ID);
  }

  /** Returns true if field userNumber is set (has been assigned a value) and false otherwise */
  public boolean isSetUserNumber() {
    return EncodingUtils.testBit(__isset_bitfield, __USERNUMBER_ISSET_ID);
  }

  public void setUserNumberIsSet(boolean value) {
    __isset_bitfield = EncodingUtils.setBit(__isset_bitfield, __USERNUMBER_ISSET_ID, value);
  }

  public String getUsername() {
    return this.username;
  }

  public StuAnswerDetail setUsername(String username) {
    this.username = username;
    return this;
  }

  public void unsetUsername() {
    this.username = null;
  }

  /** Returns true if field username is set (has been assigned a value) and false otherwise */
  public boolean isSetUsername() {
    return this.username != null;
  }

  public void setUsernameIsSet(boolean value) {
    if (!value) {
      this.username = null;
    }
  }

  public int getAnsweredTime() {
    return this.answeredTime;
  }

  public StuAnswerDetail setAnsweredTime(int answeredTime) {
    this.answeredTime = answeredTime;
    setAnsweredTimeIsSet(true);
    return this;
  }

  public void unsetAnsweredTime() {
    __isset_bitfield = EncodingUtils.clearBit(__isset_bitfield, __ANSWEREDTIME_ISSET_ID);
  }

  /** Returns true if field answeredTime is set (has been assigned a value) and false otherwise */
  public boolean isSetAnsweredTime() {
    return EncodingUtils.testBit(__isset_bitfield, __ANSWEREDTIME_ISSET_ID);
  }

  public void setAnsweredTimeIsSet(boolean value) {
    __isset_bitfield = EncodingUtils.setBit(__isset_bitfield, __ANSWEREDTIME_ISSET_ID, value);
  }

  public int getRightNum() {
    return this.rightNum;
  }

  public StuAnswerDetail setRightNum(int rightNum) {
    this.rightNum = rightNum;
    setRightNumIsSet(true);
    return this;
  }

  public void unsetRightNum() {
    __isset_bitfield = EncodingUtils.clearBit(__isset_bitfield, __RIGHTNUM_ISSET_ID);
  }

  /** Returns true if field rightNum is set (has been assigned a value) and false otherwise */
  public boolean isSetRightNum() {
    return EncodingUtils.testBit(__isset_bitfield, __RIGHTNUM_ISSET_ID);
  }

  public void setRightNumIsSet(boolean value) {
    __isset_bitfield = EncodingUtils.setBit(__isset_bitfield, __RIGHTNUM_ISSET_ID, value);
  }

  public int getWrongNum() {
    return this.wrongNum;
  }

  public StuAnswerDetail setWrongNum(int wrongNum) {
    this.wrongNum = wrongNum;
    setWrongNumIsSet(true);
    return this;
  }

  public void unsetWrongNum() {
    __isset_bitfield = EncodingUtils.clearBit(__isset_bitfield, __WRONGNUM_ISSET_ID);
  }

  /** Returns true if field wrongNum is set (has been assigned a value) and false otherwise */
  public boolean isSetWrongNum() {
    return EncodingUtils.testBit(__isset_bitfield, __WRONGNUM_ISSET_ID);
  }

  public void setWrongNumIsSet(boolean value) {
    __isset_bitfield = EncodingUtils.setBit(__isset_bitfield, __WRONGNUM_ISSET_ID, value);
  }

  public double getCorrectRate() {
    return this.correctRate;
  }

  public StuAnswerDetail setCorrectRate(double correctRate) {
    this.correctRate = correctRate;
    setCorrectRateIsSet(true);
    return this;
  }

  public void unsetCorrectRate() {
    __isset_bitfield = EncodingUtils.clearBit(__isset_bitfield, __CORRECTRATE_ISSET_ID);
  }

  /** Returns true if field correctRate is set (has been assigned a value) and false otherwise */
  public boolean isSetCorrectRate() {
    return EncodingUtils.testBit(__isset_bitfield, __CORRECTRATE_ISSET_ID);
  }

  public void setCorrectRateIsSet(boolean value) {
    __isset_bitfield = EncodingUtils.setBit(__isset_bitfield, __CORRECTRATE_ISSET_ID, value);
  }

  public void setFieldValue(_Fields field, Object value) {
    switch (field) {
    case USER_NUMBER:
      if (value == null) {
        unsetUserNumber();
      } else {
        setUserNumber((Integer)value);
      }
      break;

    case USERNAME:
      if (value == null) {
        unsetUsername();
      } else {
        setUsername((String)value);
      }
      break;

    case ANSWERED_TIME:
      if (value == null) {
        unsetAnsweredTime();
      } else {
        setAnsweredTime((Integer)value);
      }
      break;

    case RIGHT_NUM:
      if (value == null) {
        unsetRightNum();
      } else {
        setRightNum((Integer)value);
      }
      break;

    case WRONG_NUM:
      if (value == null) {
        unsetWrongNum();
      } else {
        setWrongNum((Integer)value);
      }
      break;

    case CORRECT_RATE:
      if (value == null) {
        unsetCorrectRate();
      } else {
        setCorrectRate((Double)value);
      }
      break;

    }
  }

  public Object getFieldValue(_Fields field) {
    switch (field) {
    case USER_NUMBER:
      return getUserNumber();

    case USERNAME:
      return getUsername();

    case ANSWERED_TIME:
      return getAnsweredTime();

    case RIGHT_NUM:
      return getRightNum();

    case WRONG_NUM:
      return getWrongNum();

    case CORRECT_RATE:
      return getCorrectRate();

    }
    throw new IllegalStateException();
  }

  /** Returns true if field corresponding to fieldID is set (has been assigned a value) and false otherwise */
  public boolean isSet(_Fields field) {
    if (field == null) {
      throw new IllegalArgumentException();
    }

    switch (field) {
    case USER_NUMBER:
      return isSetUserNumber();
    case USERNAME:
      return isSetUsername();
    case ANSWERED_TIME:
      return isSetAnsweredTime();
    case RIGHT_NUM:
      return isSetRightNum();
    case WRONG_NUM:
      return isSetWrongNum();
    case CORRECT_RATE:
      return isSetCorrectRate();
    }
    throw new IllegalStateException();
  }

  @Override
  public boolean equals(Object that) {
    if (that == null)
      return false;
    if (that instanceof StuAnswerDetail)
      return this.equals((StuAnswerDetail)that);
    return false;
  }

  public boolean equals(StuAnswerDetail that) {
    if (that == null)
      return false;

    boolean this_present_userNumber = true;
    boolean that_present_userNumber = true;
    if (this_present_userNumber || that_present_userNumber) {
      if (!(this_present_userNumber && that_present_userNumber))
        return false;
      if (this.userNumber != that.userNumber)
        return false;
    }

    boolean this_present_username = true && this.isSetUsername();
    boolean that_present_username = true && that.isSetUsername();
    if (this_present_username || that_present_username) {
      if (!(this_present_username && that_present_username))
        return false;
      if (!this.username.equals(that.username))
        return false;
    }

    boolean this_present_answeredTime = true;
    boolean that_present_answeredTime = true;
    if (this_present_answeredTime || that_present_answeredTime) {
      if (!(this_present_answeredTime && that_present_answeredTime))
        return false;
      if (this.answeredTime != that.answeredTime)
        return false;
    }

    boolean this_present_rightNum = true;
    boolean that_present_rightNum = true;
    if (this_present_rightNum || that_present_rightNum) {
      if (!(this_present_rightNum && that_present_rightNum))
        return false;
      if (this.rightNum != that.rightNum)
        return false;
    }

    boolean this_present_wrongNum = true;
    boolean that_present_wrongNum = true;
    if (this_present_wrongNum || that_present_wrongNum) {
      if (!(this_present_wrongNum && that_present_wrongNum))
        return false;
      if (this.wrongNum != that.wrongNum)
        return false;
    }

    boolean this_present_correctRate = true;
    boolean that_present_correctRate = true;
    if (this_present_correctRate || that_present_correctRate) {
      if (!(this_present_correctRate && that_present_correctRate))
        return false;
      if (this.correctRate != that.correctRate)
        return false;
    }

    return true;
  }

  @Override
  public int hashCode() {
    List<Object> list = new ArrayList<Object>();

    boolean present_userNumber = true;
    list.add(present_userNumber);
    if (present_userNumber)
      list.add(userNumber);

    boolean present_username = true && (isSetUsername());
    list.add(present_username);
    if (present_username)
      list.add(username);

    boolean present_answeredTime = true;
    list.add(present_answeredTime);
    if (present_answeredTime)
      list.add(answeredTime);

    boolean present_rightNum = true;
    list.add(present_rightNum);
    if (present_rightNum)
      list.add(rightNum);

    boolean present_wrongNum = true;
    list.add(present_wrongNum);
    if (present_wrongNum)
      list.add(wrongNum);

    boolean present_correctRate = true;
    list.add(present_correctRate);
    if (present_correctRate)
      list.add(correctRate);

    return list.hashCode();
  }

  @Override
  public int compareTo(StuAnswerDetail other) {
    if (!getClass().equals(other.getClass())) {
      return getClass().getName().compareTo(other.getClass().getName());
    }

    int lastComparison = 0;

    lastComparison = Boolean.valueOf(isSetUserNumber()).compareTo(other.isSetUserNumber());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetUserNumber()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.userNumber, other.userNumber);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    lastComparison = Boolean.valueOf(isSetUsername()).compareTo(other.isSetUsername());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetUsername()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.username, other.username);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    lastComparison = Boolean.valueOf(isSetAnsweredTime()).compareTo(other.isSetAnsweredTime());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetAnsweredTime()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.answeredTime, other.answeredTime);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    lastComparison = Boolean.valueOf(isSetRightNum()).compareTo(other.isSetRightNum());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetRightNum()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.rightNum, other.rightNum);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    lastComparison = Boolean.valueOf(isSetWrongNum()).compareTo(other.isSetWrongNum());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetWrongNum()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.wrongNum, other.wrongNum);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    lastComparison = Boolean.valueOf(isSetCorrectRate()).compareTo(other.isSetCorrectRate());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetCorrectRate()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.correctRate, other.correctRate);
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
    StringBuilder sb = new StringBuilder("StuAnswerDetail(");
    boolean first = true;

    sb.append("userNumber:");
    sb.append(this.userNumber);
    first = false;
    if (!first) sb.append(", ");
    sb.append("username:");
    if (this.username == null) {
      sb.append("null");
    } else {
      sb.append(this.username);
    }
    first = false;
    if (!first) sb.append(", ");
    sb.append("answeredTime:");
    sb.append(this.answeredTime);
    first = false;
    if (!first) sb.append(", ");
    sb.append("rightNum:");
    sb.append(this.rightNum);
    first = false;
    if (!first) sb.append(", ");
    sb.append("wrongNum:");
    sb.append(this.wrongNum);
    first = false;
    if (!first) sb.append(", ");
    sb.append("correctRate:");
    sb.append(this.correctRate);
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

  private static class StuAnswerDetailStandardSchemeFactory implements SchemeFactory {
    public StuAnswerDetailStandardScheme getScheme() {
      return new StuAnswerDetailStandardScheme();
    }
  }

  private static class StuAnswerDetailStandardScheme extends StandardScheme<StuAnswerDetail> {

    public void read(org.apache.thrift.protocol.TProtocol iprot, StuAnswerDetail struct) throws TException {
      org.apache.thrift.protocol.TField schemeField;
      iprot.readStructBegin();
      while (true)
      {
        schemeField = iprot.readFieldBegin();
        if (schemeField.type == org.apache.thrift.protocol.TType.STOP) { 
          break;
        }
        switch (schemeField.id) {
          case 1: // USER_NUMBER
            if (schemeField.type == org.apache.thrift.protocol.TType.I32) {
              struct.userNumber = iprot.readI32();
              struct.setUserNumberIsSet(true);
            } else { 
              org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
            }
            break;
          case 2: // USERNAME
            if (schemeField.type == org.apache.thrift.protocol.TType.STRING) {
              struct.username = iprot.readString();
              struct.setUsernameIsSet(true);
            } else { 
              org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
            }
            break;
          case 3: // ANSWERED_TIME
            if (schemeField.type == org.apache.thrift.protocol.TType.I32) {
              struct.answeredTime = iprot.readI32();
              struct.setAnsweredTimeIsSet(true);
            } else { 
              org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
            }
            break;
          case 4: // RIGHT_NUM
            if (schemeField.type == org.apache.thrift.protocol.TType.I32) {
              struct.rightNum = iprot.readI32();
              struct.setRightNumIsSet(true);
            } else { 
              org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
            }
            break;
          case 5: // WRONG_NUM
            if (schemeField.type == org.apache.thrift.protocol.TType.I32) {
              struct.wrongNum = iprot.readI32();
              struct.setWrongNumIsSet(true);
            } else { 
              org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
            }
            break;
          case 6: // CORRECT_RATE
            if (schemeField.type == org.apache.thrift.protocol.TType.DOUBLE) {
              struct.correctRate = iprot.readDouble();
              struct.setCorrectRateIsSet(true);
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

    public void write(org.apache.thrift.protocol.TProtocol oprot, StuAnswerDetail struct) throws TException {
      struct.validate();

      oprot.writeStructBegin(STRUCT_DESC);
      oprot.writeFieldBegin(USER_NUMBER_FIELD_DESC);
      oprot.writeI32(struct.userNumber);
      oprot.writeFieldEnd();
      if (struct.username != null) {
        oprot.writeFieldBegin(USERNAME_FIELD_DESC);
        oprot.writeString(struct.username);
        oprot.writeFieldEnd();
      }
      oprot.writeFieldBegin(ANSWERED_TIME_FIELD_DESC);
      oprot.writeI32(struct.answeredTime);
      oprot.writeFieldEnd();
      oprot.writeFieldBegin(RIGHT_NUM_FIELD_DESC);
      oprot.writeI32(struct.rightNum);
      oprot.writeFieldEnd();
      oprot.writeFieldBegin(WRONG_NUM_FIELD_DESC);
      oprot.writeI32(struct.wrongNum);
      oprot.writeFieldEnd();
      oprot.writeFieldBegin(CORRECT_RATE_FIELD_DESC);
      oprot.writeDouble(struct.correctRate);
      oprot.writeFieldEnd();
      oprot.writeFieldStop();
      oprot.writeStructEnd();
    }

  }

  private static class StuAnswerDetailTupleSchemeFactory implements SchemeFactory {
    public StuAnswerDetailTupleScheme getScheme() {
      return new StuAnswerDetailTupleScheme();
    }
  }

  private static class StuAnswerDetailTupleScheme extends TupleScheme<StuAnswerDetail> {

    @Override
    public void write(org.apache.thrift.protocol.TProtocol prot, StuAnswerDetail struct) throws TException {
      TTupleProtocol oprot = (TTupleProtocol) prot;
      BitSet optionals = new BitSet();
      if (struct.isSetUserNumber()) {
        optionals.set(0);
      }
      if (struct.isSetUsername()) {
        optionals.set(1);
      }
      if (struct.isSetAnsweredTime()) {
        optionals.set(2);
      }
      if (struct.isSetRightNum()) {
        optionals.set(3);
      }
      if (struct.isSetWrongNum()) {
        optionals.set(4);
      }
      if (struct.isSetCorrectRate()) {
        optionals.set(5);
      }
      oprot.writeBitSet(optionals, 6);
      if (struct.isSetUserNumber()) {
        oprot.writeI32(struct.userNumber);
      }
      if (struct.isSetUsername()) {
        oprot.writeString(struct.username);
      }
      if (struct.isSetAnsweredTime()) {
        oprot.writeI32(struct.answeredTime);
      }
      if (struct.isSetRightNum()) {
        oprot.writeI32(struct.rightNum);
      }
      if (struct.isSetWrongNum()) {
        oprot.writeI32(struct.wrongNum);
      }
      if (struct.isSetCorrectRate()) {
        oprot.writeDouble(struct.correctRate);
      }
    }

    @Override
    public void read(org.apache.thrift.protocol.TProtocol prot, StuAnswerDetail struct) throws TException {
      TTupleProtocol iprot = (TTupleProtocol) prot;
      BitSet incoming = iprot.readBitSet(6);
      if (incoming.get(0)) {
        struct.userNumber = iprot.readI32();
        struct.setUserNumberIsSet(true);
      }
      if (incoming.get(1)) {
        struct.username = iprot.readString();
        struct.setUsernameIsSet(true);
      }
      if (incoming.get(2)) {
        struct.answeredTime = iprot.readI32();
        struct.setAnsweredTimeIsSet(true);
      }
      if (incoming.get(3)) {
        struct.rightNum = iprot.readI32();
        struct.setRightNumIsSet(true);
      }
      if (incoming.get(4)) {
        struct.wrongNum = iprot.readI32();
        struct.setWrongNumIsSet(true);
      }
      if (incoming.get(5)) {
        struct.correctRate = iprot.readDouble();
        struct.setCorrectRateIsSet(true);
      }
    }
  }

}

