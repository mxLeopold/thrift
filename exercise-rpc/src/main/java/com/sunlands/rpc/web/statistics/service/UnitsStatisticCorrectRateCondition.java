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
@Generated(value = "Autogenerated by Thrift Compiler (0.9.3)", date = "2018-07-30")
public class UnitsStatisticCorrectRateCondition implements org.apache.thrift.TBase<UnitsStatisticCorrectRateCondition, UnitsStatisticCorrectRateCondition._Fields>, java.io.Serializable, Cloneable, Comparable<UnitsStatisticCorrectRateCondition> {
  private static final org.apache.thrift.protocol.TStruct STRUCT_DESC = new org.apache.thrift.protocol.TStruct("UnitsStatisticCorrectRateCondition");

  private static final org.apache.thrift.protocol.TField TEACH_UNIT_IDS_LIST_FIELD_DESC = new org.apache.thrift.protocol.TField("teachUnitIdsList", org.apache.thrift.protocol.TType.STRING, (short)1);
  private static final org.apache.thrift.protocol.TField HOMEWORK_ID_FIELD_DESC = new org.apache.thrift.protocol.TField("homeworkId", org.apache.thrift.protocol.TType.STRING, (short)2);
  private static final org.apache.thrift.protocol.TField QUIZZES_GROUP_ID_FIELD_DESC = new org.apache.thrift.protocol.TField("quizzesGroupId", org.apache.thrift.protocol.TType.STRING, (short)3);

  private static final Map<Class<? extends IScheme>, SchemeFactory> schemes = new HashMap<Class<? extends IScheme>, SchemeFactory>();
  static {
    schemes.put(StandardScheme.class, new UnitsStatisticCorrectRateConditionStandardSchemeFactory());
    schemes.put(TupleScheme.class, new UnitsStatisticCorrectRateConditionTupleSchemeFactory());
  }

  public String teachUnitIdsList; // required
  public String homeworkId; // required
  public String quizzesGroupId; // required

  /** The set of fields this struct contains, along with convenience methods for finding and manipulating them. */
  public enum _Fields implements org.apache.thrift.TFieldIdEnum {
    TEACH_UNIT_IDS_LIST((short)1, "teachUnitIdsList"),
    HOMEWORK_ID((short)2, "homeworkId"),
    QUIZZES_GROUP_ID((short)3, "quizzesGroupId");

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
        case 1: // TEACH_UNIT_IDS_LIST
          return TEACH_UNIT_IDS_LIST;
        case 2: // HOMEWORK_ID
          return HOMEWORK_ID;
        case 3: // QUIZZES_GROUP_ID
          return QUIZZES_GROUP_ID;
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
  public static final Map<_Fields, org.apache.thrift.meta_data.FieldMetaData> metaDataMap;
  static {
    Map<_Fields, org.apache.thrift.meta_data.FieldMetaData> tmpMap = new EnumMap<_Fields, org.apache.thrift.meta_data.FieldMetaData>(_Fields.class);
    tmpMap.put(_Fields.TEACH_UNIT_IDS_LIST, new org.apache.thrift.meta_data.FieldMetaData("teachUnitIdsList", org.apache.thrift.TFieldRequirementType.DEFAULT, 
        new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.STRING)));
    tmpMap.put(_Fields.HOMEWORK_ID, new org.apache.thrift.meta_data.FieldMetaData("homeworkId", org.apache.thrift.TFieldRequirementType.DEFAULT, 
        new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.STRING)));
    tmpMap.put(_Fields.QUIZZES_GROUP_ID, new org.apache.thrift.meta_data.FieldMetaData("quizzesGroupId", org.apache.thrift.TFieldRequirementType.DEFAULT, 
        new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.STRING)));
    metaDataMap = Collections.unmodifiableMap(tmpMap);
    org.apache.thrift.meta_data.FieldMetaData.addStructMetaDataMap(UnitsStatisticCorrectRateCondition.class, metaDataMap);
  }

  public UnitsStatisticCorrectRateCondition() {
  }

  public UnitsStatisticCorrectRateCondition(
    String teachUnitIdsList,
    String homeworkId,
    String quizzesGroupId)
  {
    this();
    this.teachUnitIdsList = teachUnitIdsList;
    this.homeworkId = homeworkId;
    this.quizzesGroupId = quizzesGroupId;
  }

  /**
   * Performs a deep copy on <i>other</i>.
   */
  public UnitsStatisticCorrectRateCondition(UnitsStatisticCorrectRateCondition other) {
    if (other.isSetTeachUnitIdsList()) {
      this.teachUnitIdsList = other.teachUnitIdsList;
    }
    if (other.isSetHomeworkId()) {
      this.homeworkId = other.homeworkId;
    }
    if (other.isSetQuizzesGroupId()) {
      this.quizzesGroupId = other.quizzesGroupId;
    }
  }

  public UnitsStatisticCorrectRateCondition deepCopy() {
    return new UnitsStatisticCorrectRateCondition(this);
  }

  @Override
  public void clear() {
    this.teachUnitIdsList = null;
    this.homeworkId = null;
    this.quizzesGroupId = null;
  }

  public String getTeachUnitIdsList() {
    return this.teachUnitIdsList;
  }

  public UnitsStatisticCorrectRateCondition setTeachUnitIdsList(String teachUnitIdsList) {
    this.teachUnitIdsList = teachUnitIdsList;
    return this;
  }

  public void unsetTeachUnitIdsList() {
    this.teachUnitIdsList = null;
  }

  /** Returns true if field teachUnitIdsList is set (has been assigned a value) and false otherwise */
  public boolean isSetTeachUnitIdsList() {
    return this.teachUnitIdsList != null;
  }

  public void setTeachUnitIdsListIsSet(boolean value) {
    if (!value) {
      this.teachUnitIdsList = null;
    }
  }

  public String getHomeworkId() {
    return this.homeworkId;
  }

  public UnitsStatisticCorrectRateCondition setHomeworkId(String homeworkId) {
    this.homeworkId = homeworkId;
    return this;
  }

  public void unsetHomeworkId() {
    this.homeworkId = null;
  }

  /** Returns true if field homeworkId is set (has been assigned a value) and false otherwise */
  public boolean isSetHomeworkId() {
    return this.homeworkId != null;
  }

  public void setHomeworkIdIsSet(boolean value) {
    if (!value) {
      this.homeworkId = null;
    }
  }

  public String getQuizzesGroupId() {
    return this.quizzesGroupId;
  }

  public UnitsStatisticCorrectRateCondition setQuizzesGroupId(String quizzesGroupId) {
    this.quizzesGroupId = quizzesGroupId;
    return this;
  }

  public void unsetQuizzesGroupId() {
    this.quizzesGroupId = null;
  }

  /** Returns true if field quizzesGroupId is set (has been assigned a value) and false otherwise */
  public boolean isSetQuizzesGroupId() {
    return this.quizzesGroupId != null;
  }

  public void setQuizzesGroupIdIsSet(boolean value) {
    if (!value) {
      this.quizzesGroupId = null;
    }
  }

  public void setFieldValue(_Fields field, Object value) {
    switch (field) {
    case TEACH_UNIT_IDS_LIST:
      if (value == null) {
        unsetTeachUnitIdsList();
      } else {
        setTeachUnitIdsList((String)value);
      }
      break;

    case HOMEWORK_ID:
      if (value == null) {
        unsetHomeworkId();
      } else {
        setHomeworkId((String)value);
      }
      break;

    case QUIZZES_GROUP_ID:
      if (value == null) {
        unsetQuizzesGroupId();
      } else {
        setQuizzesGroupId((String)value);
      }
      break;

    }
  }

  public Object getFieldValue(_Fields field) {
    switch (field) {
    case TEACH_UNIT_IDS_LIST:
      return getTeachUnitIdsList();

    case HOMEWORK_ID:
      return getHomeworkId();

    case QUIZZES_GROUP_ID:
      return getQuizzesGroupId();

    }
    throw new IllegalStateException();
  }

  /** Returns true if field corresponding to fieldID is set (has been assigned a value) and false otherwise */
  public boolean isSet(_Fields field) {
    if (field == null) {
      throw new IllegalArgumentException();
    }

    switch (field) {
    case TEACH_UNIT_IDS_LIST:
      return isSetTeachUnitIdsList();
    case HOMEWORK_ID:
      return isSetHomeworkId();
    case QUIZZES_GROUP_ID:
      return isSetQuizzesGroupId();
    }
    throw new IllegalStateException();
  }

  @Override
  public boolean equals(Object that) {
    if (that == null)
      return false;
    if (that instanceof UnitsStatisticCorrectRateCondition)
      return this.equals((UnitsStatisticCorrectRateCondition)that);
    return false;
  }

  public boolean equals(UnitsStatisticCorrectRateCondition that) {
    if (that == null)
      return false;

    boolean this_present_teachUnitIdsList = true && this.isSetTeachUnitIdsList();
    boolean that_present_teachUnitIdsList = true && that.isSetTeachUnitIdsList();
    if (this_present_teachUnitIdsList || that_present_teachUnitIdsList) {
      if (!(this_present_teachUnitIdsList && that_present_teachUnitIdsList))
        return false;
      if (!this.teachUnitIdsList.equals(that.teachUnitIdsList))
        return false;
    }

    boolean this_present_homeworkId = true && this.isSetHomeworkId();
    boolean that_present_homeworkId = true && that.isSetHomeworkId();
    if (this_present_homeworkId || that_present_homeworkId) {
      if (!(this_present_homeworkId && that_present_homeworkId))
        return false;
      if (!this.homeworkId.equals(that.homeworkId))
        return false;
    }

    boolean this_present_quizzesGroupId = true && this.isSetQuizzesGroupId();
    boolean that_present_quizzesGroupId = true && that.isSetQuizzesGroupId();
    if (this_present_quizzesGroupId || that_present_quizzesGroupId) {
      if (!(this_present_quizzesGroupId && that_present_quizzesGroupId))
        return false;
      if (!this.quizzesGroupId.equals(that.quizzesGroupId))
        return false;
    }

    return true;
  }

  @Override
  public int hashCode() {
    List<Object> list = new ArrayList<Object>();

    boolean present_teachUnitIdsList = true && (isSetTeachUnitIdsList());
    list.add(present_teachUnitIdsList);
    if (present_teachUnitIdsList)
      list.add(teachUnitIdsList);

    boolean present_homeworkId = true && (isSetHomeworkId());
    list.add(present_homeworkId);
    if (present_homeworkId)
      list.add(homeworkId);

    boolean present_quizzesGroupId = true && (isSetQuizzesGroupId());
    list.add(present_quizzesGroupId);
    if (present_quizzesGroupId)
      list.add(quizzesGroupId);

    return list.hashCode();
  }

  @Override
  public int compareTo(UnitsStatisticCorrectRateCondition other) {
    if (!getClass().equals(other.getClass())) {
      return getClass().getName().compareTo(other.getClass().getName());
    }

    int lastComparison = 0;

    lastComparison = Boolean.valueOf(isSetTeachUnitIdsList()).compareTo(other.isSetTeachUnitIdsList());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetTeachUnitIdsList()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.teachUnitIdsList, other.teachUnitIdsList);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    lastComparison = Boolean.valueOf(isSetHomeworkId()).compareTo(other.isSetHomeworkId());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetHomeworkId()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.homeworkId, other.homeworkId);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    lastComparison = Boolean.valueOf(isSetQuizzesGroupId()).compareTo(other.isSetQuizzesGroupId());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetQuizzesGroupId()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.quizzesGroupId, other.quizzesGroupId);
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
    StringBuilder sb = new StringBuilder("UnitsStatisticCorrectRateCondition(");
    boolean first = true;

    sb.append("teachUnitIdsList:");
    if (this.teachUnitIdsList == null) {
      sb.append("null");
    } else {
      sb.append(this.teachUnitIdsList);
    }
    first = false;
    if (!first) sb.append(", ");
    sb.append("homeworkId:");
    if (this.homeworkId == null) {
      sb.append("null");
    } else {
      sb.append(this.homeworkId);
    }
    first = false;
    if (!first) sb.append(", ");
    sb.append("quizzesGroupId:");
    if (this.quizzesGroupId == null) {
      sb.append("null");
    } else {
      sb.append(this.quizzesGroupId);
    }
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
      read(new org.apache.thrift.protocol.TCompactProtocol(new org.apache.thrift.transport.TIOStreamTransport(in)));
    } catch (TException te) {
      throw new java.io.IOException(te);
    }
  }

  private static class UnitsStatisticCorrectRateConditionStandardSchemeFactory implements SchemeFactory {
    public UnitsStatisticCorrectRateConditionStandardScheme getScheme() {
      return new UnitsStatisticCorrectRateConditionStandardScheme();
    }
  }

  private static class UnitsStatisticCorrectRateConditionStandardScheme extends StandardScheme<UnitsStatisticCorrectRateCondition> {

    public void read(org.apache.thrift.protocol.TProtocol iprot, UnitsStatisticCorrectRateCondition struct) throws TException {
      org.apache.thrift.protocol.TField schemeField;
      iprot.readStructBegin();
      while (true)
      {
        schemeField = iprot.readFieldBegin();
        if (schemeField.type == org.apache.thrift.protocol.TType.STOP) { 
          break;
        }
        switch (schemeField.id) {
          case 1: // TEACH_UNIT_IDS_LIST
            if (schemeField.type == org.apache.thrift.protocol.TType.STRING) {
              struct.teachUnitIdsList = iprot.readString();
              struct.setTeachUnitIdsListIsSet(true);
            } else { 
              org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
            }
            break;
          case 2: // HOMEWORK_ID
            if (schemeField.type == org.apache.thrift.protocol.TType.STRING) {
              struct.homeworkId = iprot.readString();
              struct.setHomeworkIdIsSet(true);
            } else { 
              org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
            }
            break;
          case 3: // QUIZZES_GROUP_ID
            if (schemeField.type == org.apache.thrift.protocol.TType.STRING) {
              struct.quizzesGroupId = iprot.readString();
              struct.setQuizzesGroupIdIsSet(true);
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

    public void write(org.apache.thrift.protocol.TProtocol oprot, UnitsStatisticCorrectRateCondition struct) throws TException {
      struct.validate();

      oprot.writeStructBegin(STRUCT_DESC);
      if (struct.teachUnitIdsList != null) {
        oprot.writeFieldBegin(TEACH_UNIT_IDS_LIST_FIELD_DESC);
        oprot.writeString(struct.teachUnitIdsList);
        oprot.writeFieldEnd();
      }
      if (struct.homeworkId != null) {
        oprot.writeFieldBegin(HOMEWORK_ID_FIELD_DESC);
        oprot.writeString(struct.homeworkId);
        oprot.writeFieldEnd();
      }
      if (struct.quizzesGroupId != null) {
        oprot.writeFieldBegin(QUIZZES_GROUP_ID_FIELD_DESC);
        oprot.writeString(struct.quizzesGroupId);
        oprot.writeFieldEnd();
      }
      oprot.writeFieldStop();
      oprot.writeStructEnd();
    }

  }

  private static class UnitsStatisticCorrectRateConditionTupleSchemeFactory implements SchemeFactory {
    public UnitsStatisticCorrectRateConditionTupleScheme getScheme() {
      return new UnitsStatisticCorrectRateConditionTupleScheme();
    }
  }

  private static class UnitsStatisticCorrectRateConditionTupleScheme extends TupleScheme<UnitsStatisticCorrectRateCondition> {

    @Override
    public void write(org.apache.thrift.protocol.TProtocol prot, UnitsStatisticCorrectRateCondition struct) throws TException {
      TTupleProtocol oprot = (TTupleProtocol) prot;
      BitSet optionals = new BitSet();
      if (struct.isSetTeachUnitIdsList()) {
        optionals.set(0);
      }
      if (struct.isSetHomeworkId()) {
        optionals.set(1);
      }
      if (struct.isSetQuizzesGroupId()) {
        optionals.set(2);
      }
      oprot.writeBitSet(optionals, 3);
      if (struct.isSetTeachUnitIdsList()) {
        oprot.writeString(struct.teachUnitIdsList);
      }
      if (struct.isSetHomeworkId()) {
        oprot.writeString(struct.homeworkId);
      }
      if (struct.isSetQuizzesGroupId()) {
        oprot.writeString(struct.quizzesGroupId);
      }
    }

    @Override
    public void read(org.apache.thrift.protocol.TProtocol prot, UnitsStatisticCorrectRateCondition struct) throws TException {
      TTupleProtocol iprot = (TTupleProtocol) prot;
      BitSet incoming = iprot.readBitSet(3);
      if (incoming.get(0)) {
        struct.teachUnitIdsList = iprot.readString();
        struct.setTeachUnitIdsListIsSet(true);
      }
      if (incoming.get(1)) {
        struct.homeworkId = iprot.readString();
        struct.setHomeworkIdIsSet(true);
      }
      if (incoming.get(2)) {
        struct.quizzesGroupId = iprot.readString();
        struct.setQuizzesGroupIdIsSet(true);
      }
    }
  }

}
