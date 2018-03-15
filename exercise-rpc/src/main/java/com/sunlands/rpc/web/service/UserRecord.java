/**
 * Autogenerated by Thrift Compiler (0.9.3)
 *
 * DO NOT EDIT UNLESS YOU ARE SURE THAT YOU KNOW WHAT YOU ARE DOING
 *  @generated
 */
package com.sunlands.rpc.web.service;

import org.apache.thrift.scheme.IScheme;
import org.apache.thrift.scheme.SchemeFactory;
import org.apache.thrift.scheme.StandardScheme;

import org.apache.thrift.scheme.TupleScheme;
import org.apache.thrift.protocol.TTupleProtocol;
import org.apache.thrift.EncodingUtils;
import org.apache.thrift.TException;

import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;
import java.util.EnumMap;
import java.util.EnumSet;
import java.util.Collections;
import java.util.BitSet;
import javax.annotation.Generated;

@SuppressWarnings({"cast", "rawtypes", "serial", "unchecked"})
@Generated(value = "Autogenerated by Thrift Compiler (0.9.3)", date = "2018-03-15")
public class UserRecord implements org.apache.thrift.TBase<UserRecord, UserRecord._Fields>, java.io.Serializable, Cloneable, Comparable<UserRecord> {
  private static final org.apache.thrift.protocol.TStruct STRUCT_DESC = new org.apache.thrift.protocol.TStruct("UserRecord");

  private static final org.apache.thrift.protocol.TField ID_FIELD_DESC = new org.apache.thrift.protocol.TField("id", org.apache.thrift.protocol.TType.I32, (short)1);
  private static final org.apache.thrift.protocol.TField STU_ID_FIELD_DESC = new org.apache.thrift.protocol.TField("stuId", org.apache.thrift.protocol.TType.I32, (short)2);
  private static final org.apache.thrift.protocol.TField NAME_FIELD_DESC = new org.apache.thrift.protocol.TField("name", org.apache.thrift.protocol.TType.STRING, (short)3);
  private static final org.apache.thrift.protocol.TField EXERCISE_TYPE_FIELD_DESC = new org.apache.thrift.protocol.TField("exerciseType", org.apache.thrift.protocol.TType.STRING, (short)4);
  private static final org.apache.thrift.protocol.TField SUBJECT_ID_FIELD_DESC = new org.apache.thrift.protocol.TField("subjectId", org.apache.thrift.protocol.TType.I32, (short)5);

  private static final Map<Class<? extends IScheme>, SchemeFactory> schemes = new HashMap<Class<? extends IScheme>, SchemeFactory>();
  static {
    schemes.put(StandardScheme.class, new UserRecordStandardSchemeFactory());
    schemes.put(TupleScheme.class, new UserRecordTupleSchemeFactory());
  }

  public int id; // required
  public int stuId; // required
  public String name; // required
  public String exerciseType; // required
  public int subjectId; // required

  /** The set of fields this struct contains, along with convenience methods for finding and manipulating them. */
  public enum _Fields implements org.apache.thrift.TFieldIdEnum {
    ID((short)1, "id"),
    STU_ID((short)2, "stuId"),
    NAME((short)3, "name"),
    EXERCISE_TYPE((short)4, "exerciseType"),
    SUBJECT_ID((short)5, "subjectId");

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
        case 1: // ID
          return ID;
        case 2: // STU_ID
          return STU_ID;
        case 3: // NAME
          return NAME;
        case 4: // EXERCISE_TYPE
          return EXERCISE_TYPE;
        case 5: // SUBJECT_ID
          return SUBJECT_ID;
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
  private static final int __ID_ISSET_ID = 0;
  private static final int __STUID_ISSET_ID = 1;
  private static final int __SUBJECTID_ISSET_ID = 2;
  private byte __isset_bitfield = 0;
  public static final Map<_Fields, org.apache.thrift.meta_data.FieldMetaData> metaDataMap;
  static {
    Map<_Fields, org.apache.thrift.meta_data.FieldMetaData> tmpMap = new EnumMap<_Fields, org.apache.thrift.meta_data.FieldMetaData>(_Fields.class);
    tmpMap.put(_Fields.ID, new org.apache.thrift.meta_data.FieldMetaData("id", org.apache.thrift.TFieldRequirementType.DEFAULT, 
        new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.I32)));
    tmpMap.put(_Fields.STU_ID, new org.apache.thrift.meta_data.FieldMetaData("stuId", org.apache.thrift.TFieldRequirementType.DEFAULT, 
        new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.I32)));
    tmpMap.put(_Fields.NAME, new org.apache.thrift.meta_data.FieldMetaData("name", org.apache.thrift.TFieldRequirementType.DEFAULT, 
        new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.STRING)));
    tmpMap.put(_Fields.EXERCISE_TYPE, new org.apache.thrift.meta_data.FieldMetaData("exerciseType", org.apache.thrift.TFieldRequirementType.DEFAULT, 
        new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.STRING)));
    tmpMap.put(_Fields.SUBJECT_ID, new org.apache.thrift.meta_data.FieldMetaData("subjectId", org.apache.thrift.TFieldRequirementType.DEFAULT, 
        new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.I32)));
    metaDataMap = Collections.unmodifiableMap(tmpMap);
    org.apache.thrift.meta_data.FieldMetaData.addStructMetaDataMap(UserRecord.class, metaDataMap);
  }

  public UserRecord() {
  }

  public UserRecord(
    int id,
    int stuId,
    String name,
    String exerciseType,
    int subjectId)
  {
    this();
    this.id = id;
    setIdIsSet(true);
    this.stuId = stuId;
    setStuIdIsSet(true);
    this.name = name;
    this.exerciseType = exerciseType;
    this.subjectId = subjectId;
    setSubjectIdIsSet(true);
  }

  /**
   * Performs a deep copy on <i>other</i>.
   */
  public UserRecord(UserRecord other) {
    __isset_bitfield = other.__isset_bitfield;
    this.id = other.id;
    this.stuId = other.stuId;
    if (other.isSetName()) {
      this.name = other.name;
    }
    if (other.isSetExerciseType()) {
      this.exerciseType = other.exerciseType;
    }
    this.subjectId = other.subjectId;
  }

  public UserRecord deepCopy() {
    return new UserRecord(this);
  }

  @Override
  public void clear() {
    setIdIsSet(false);
    this.id = 0;
    setStuIdIsSet(false);
    this.stuId = 0;
    this.name = null;
    this.exerciseType = null;
    setSubjectIdIsSet(false);
    this.subjectId = 0;
  }

  public int getId() {
    return this.id;
  }

  public UserRecord setId(int id) {
    this.id = id;
    setIdIsSet(true);
    return this;
  }

  public void unsetId() {
    __isset_bitfield = EncodingUtils.clearBit(__isset_bitfield, __ID_ISSET_ID);
  }

  /** Returns true if field id is set (has been assigned a value) and false otherwise */
  public boolean isSetId() {
    return EncodingUtils.testBit(__isset_bitfield, __ID_ISSET_ID);
  }

  public void setIdIsSet(boolean value) {
    __isset_bitfield = EncodingUtils.setBit(__isset_bitfield, __ID_ISSET_ID, value);
  }

  public int getStuId() {
    return this.stuId;
  }

  public UserRecord setStuId(int stuId) {
    this.stuId = stuId;
    setStuIdIsSet(true);
    return this;
  }

  public void unsetStuId() {
    __isset_bitfield = EncodingUtils.clearBit(__isset_bitfield, __STUID_ISSET_ID);
  }

  /** Returns true if field stuId is set (has been assigned a value) and false otherwise */
  public boolean isSetStuId() {
    return EncodingUtils.testBit(__isset_bitfield, __STUID_ISSET_ID);
  }

  public void setStuIdIsSet(boolean value) {
    __isset_bitfield = EncodingUtils.setBit(__isset_bitfield, __STUID_ISSET_ID, value);
  }

  public String getName() {
    return this.name;
  }

  public UserRecord setName(String name) {
    this.name = name;
    return this;
  }

  public void unsetName() {
    this.name = null;
  }

  /** Returns true if field name is set (has been assigned a value) and false otherwise */
  public boolean isSetName() {
    return this.name != null;
  }

  public void setNameIsSet(boolean value) {
    if (!value) {
      this.name = null;
    }
  }

  public String getExerciseType() {
    return this.exerciseType;
  }

  public UserRecord setExerciseType(String exerciseType) {
    this.exerciseType = exerciseType;
    return this;
  }

  public void unsetExerciseType() {
    this.exerciseType = null;
  }

  /** Returns true if field exerciseType is set (has been assigned a value) and false otherwise */
  public boolean isSetExerciseType() {
    return this.exerciseType != null;
  }

  public void setExerciseTypeIsSet(boolean value) {
    if (!value) {
      this.exerciseType = null;
    }
  }

  public int getSubjectId() {
    return this.subjectId;
  }

  public UserRecord setSubjectId(int subjectId) {
    this.subjectId = subjectId;
    setSubjectIdIsSet(true);
    return this;
  }

  public void unsetSubjectId() {
    __isset_bitfield = EncodingUtils.clearBit(__isset_bitfield, __SUBJECTID_ISSET_ID);
  }

  /** Returns true if field subjectId is set (has been assigned a value) and false otherwise */
  public boolean isSetSubjectId() {
    return EncodingUtils.testBit(__isset_bitfield, __SUBJECTID_ISSET_ID);
  }

  public void setSubjectIdIsSet(boolean value) {
    __isset_bitfield = EncodingUtils.setBit(__isset_bitfield, __SUBJECTID_ISSET_ID, value);
  }

  public void setFieldValue(_Fields field, Object value) {
    switch (field) {
    case ID:
      if (value == null) {
        unsetId();
      } else {
        setId((Integer)value);
      }
      break;

    case STU_ID:
      if (value == null) {
        unsetStuId();
      } else {
        setStuId((Integer)value);
      }
      break;

    case NAME:
      if (value == null) {
        unsetName();
      } else {
        setName((String)value);
      }
      break;

    case EXERCISE_TYPE:
      if (value == null) {
        unsetExerciseType();
      } else {
        setExerciseType((String)value);
      }
      break;

    case SUBJECT_ID:
      if (value == null) {
        unsetSubjectId();
      } else {
        setSubjectId((Integer)value);
      }
      break;

    }
  }

  public Object getFieldValue(_Fields field) {
    switch (field) {
    case ID:
      return getId();

    case STU_ID:
      return getStuId();

    case NAME:
      return getName();

    case EXERCISE_TYPE:
      return getExerciseType();

    case SUBJECT_ID:
      return getSubjectId();

    }
    throw new IllegalStateException();
  }

  /** Returns true if field corresponding to fieldID is set (has been assigned a value) and false otherwise */
  public boolean isSet(_Fields field) {
    if (field == null) {
      throw new IllegalArgumentException();
    }

    switch (field) {
    case ID:
      return isSetId();
    case STU_ID:
      return isSetStuId();
    case NAME:
      return isSetName();
    case EXERCISE_TYPE:
      return isSetExerciseType();
    case SUBJECT_ID:
      return isSetSubjectId();
    }
    throw new IllegalStateException();
  }

  @Override
  public boolean equals(Object that) {
    if (that == null)
      return false;
    if (that instanceof UserRecord)
      return this.equals((UserRecord)that);
    return false;
  }

  public boolean equals(UserRecord that) {
    if (that == null)
      return false;

    boolean this_present_id = true;
    boolean that_present_id = true;
    if (this_present_id || that_present_id) {
      if (!(this_present_id && that_present_id))
        return false;
      if (this.id != that.id)
        return false;
    }

    boolean this_present_stuId = true;
    boolean that_present_stuId = true;
    if (this_present_stuId || that_present_stuId) {
      if (!(this_present_stuId && that_present_stuId))
        return false;
      if (this.stuId != that.stuId)
        return false;
    }

    boolean this_present_name = true && this.isSetName();
    boolean that_present_name = true && that.isSetName();
    if (this_present_name || that_present_name) {
      if (!(this_present_name && that_present_name))
        return false;
      if (!this.name.equals(that.name))
        return false;
    }

    boolean this_present_exerciseType = true && this.isSetExerciseType();
    boolean that_present_exerciseType = true && that.isSetExerciseType();
    if (this_present_exerciseType || that_present_exerciseType) {
      if (!(this_present_exerciseType && that_present_exerciseType))
        return false;
      if (!this.exerciseType.equals(that.exerciseType))
        return false;
    }

    boolean this_present_subjectId = true;
    boolean that_present_subjectId = true;
    if (this_present_subjectId || that_present_subjectId) {
      if (!(this_present_subjectId && that_present_subjectId))
        return false;
      if (this.subjectId != that.subjectId)
        return false;
    }

    return true;
  }

  @Override
  public int hashCode() {
    List<Object> list = new ArrayList<Object>();

    boolean present_id = true;
    list.add(present_id);
    if (present_id)
      list.add(id);

    boolean present_stuId = true;
    list.add(present_stuId);
    if (present_stuId)
      list.add(stuId);

    boolean present_name = true && (isSetName());
    list.add(present_name);
    if (present_name)
      list.add(name);

    boolean present_exerciseType = true && (isSetExerciseType());
    list.add(present_exerciseType);
    if (present_exerciseType)
      list.add(exerciseType);

    boolean present_subjectId = true;
    list.add(present_subjectId);
    if (present_subjectId)
      list.add(subjectId);

    return list.hashCode();
  }

  @Override
  public int compareTo(UserRecord other) {
    if (!getClass().equals(other.getClass())) {
      return getClass().getName().compareTo(other.getClass().getName());
    }

    int lastComparison = 0;

    lastComparison = Boolean.valueOf(isSetId()).compareTo(other.isSetId());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetId()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.id, other.id);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    lastComparison = Boolean.valueOf(isSetStuId()).compareTo(other.isSetStuId());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetStuId()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.stuId, other.stuId);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    lastComparison = Boolean.valueOf(isSetName()).compareTo(other.isSetName());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetName()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.name, other.name);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    lastComparison = Boolean.valueOf(isSetExerciseType()).compareTo(other.isSetExerciseType());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetExerciseType()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.exerciseType, other.exerciseType);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    lastComparison = Boolean.valueOf(isSetSubjectId()).compareTo(other.isSetSubjectId());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetSubjectId()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.subjectId, other.subjectId);
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
    StringBuilder sb = new StringBuilder("UserRecord(");
    boolean first = true;

    sb.append("id:");
    sb.append(this.id);
    first = false;
    if (!first) sb.append(", ");
    sb.append("stuId:");
    sb.append(this.stuId);
    first = false;
    if (!first) sb.append(", ");
    sb.append("name:");
    if (this.name == null) {
      sb.append("null");
    } else {
      sb.append(this.name);
    }
    first = false;
    if (!first) sb.append(", ");
    sb.append("exerciseType:");
    if (this.exerciseType == null) {
      sb.append("null");
    } else {
      sb.append(this.exerciseType);
    }
    first = false;
    if (!first) sb.append(", ");
    sb.append("subjectId:");
    sb.append(this.subjectId);
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

  private static class UserRecordStandardSchemeFactory implements SchemeFactory {
    public UserRecordStandardScheme getScheme() {
      return new UserRecordStandardScheme();
    }
  }

  private static class UserRecordStandardScheme extends StandardScheme<UserRecord> {

    public void read(org.apache.thrift.protocol.TProtocol iprot, UserRecord struct) throws TException {
      org.apache.thrift.protocol.TField schemeField;
      iprot.readStructBegin();
      while (true)
      {
        schemeField = iprot.readFieldBegin();
        if (schemeField.type == org.apache.thrift.protocol.TType.STOP) { 
          break;
        }
        switch (schemeField.id) {
          case 1: // ID
            if (schemeField.type == org.apache.thrift.protocol.TType.I32) {
              struct.id = iprot.readI32();
              struct.setIdIsSet(true);
            } else { 
              org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
            }
            break;
          case 2: // STU_ID
            if (schemeField.type == org.apache.thrift.protocol.TType.I32) {
              struct.stuId = iprot.readI32();
              struct.setStuIdIsSet(true);
            } else { 
              org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
            }
            break;
          case 3: // NAME
            if (schemeField.type == org.apache.thrift.protocol.TType.STRING) {
              struct.name = iprot.readString();
              struct.setNameIsSet(true);
            } else { 
              org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
            }
            break;
          case 4: // EXERCISE_TYPE
            if (schemeField.type == org.apache.thrift.protocol.TType.STRING) {
              struct.exerciseType = iprot.readString();
              struct.setExerciseTypeIsSet(true);
            } else { 
              org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
            }
            break;
          case 5: // SUBJECT_ID
            if (schemeField.type == org.apache.thrift.protocol.TType.I32) {
              struct.subjectId = iprot.readI32();
              struct.setSubjectIdIsSet(true);
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

    public void write(org.apache.thrift.protocol.TProtocol oprot, UserRecord struct) throws TException {
      struct.validate();

      oprot.writeStructBegin(STRUCT_DESC);
      oprot.writeFieldBegin(ID_FIELD_DESC);
      oprot.writeI32(struct.id);
      oprot.writeFieldEnd();
      oprot.writeFieldBegin(STU_ID_FIELD_DESC);
      oprot.writeI32(struct.stuId);
      oprot.writeFieldEnd();
      if (struct.name != null) {
        oprot.writeFieldBegin(NAME_FIELD_DESC);
        oprot.writeString(struct.name);
        oprot.writeFieldEnd();
      }
      if (struct.exerciseType != null) {
        oprot.writeFieldBegin(EXERCISE_TYPE_FIELD_DESC);
        oprot.writeString(struct.exerciseType);
        oprot.writeFieldEnd();
      }
      oprot.writeFieldBegin(SUBJECT_ID_FIELD_DESC);
      oprot.writeI32(struct.subjectId);
      oprot.writeFieldEnd();
      oprot.writeFieldStop();
      oprot.writeStructEnd();
    }

  }

  private static class UserRecordTupleSchemeFactory implements SchemeFactory {
    public UserRecordTupleScheme getScheme() {
      return new UserRecordTupleScheme();
    }
  }

  private static class UserRecordTupleScheme extends TupleScheme<UserRecord> {

    @Override
    public void write(org.apache.thrift.protocol.TProtocol prot, UserRecord struct) throws TException {
      TTupleProtocol oprot = (TTupleProtocol) prot;
      BitSet optionals = new BitSet();
      if (struct.isSetId()) {
        optionals.set(0);
      }
      if (struct.isSetStuId()) {
        optionals.set(1);
      }
      if (struct.isSetName()) {
        optionals.set(2);
      }
      if (struct.isSetExerciseType()) {
        optionals.set(3);
      }
      if (struct.isSetSubjectId()) {
        optionals.set(4);
      }
      oprot.writeBitSet(optionals, 5);
      if (struct.isSetId()) {
        oprot.writeI32(struct.id);
      }
      if (struct.isSetStuId()) {
        oprot.writeI32(struct.stuId);
      }
      if (struct.isSetName()) {
        oprot.writeString(struct.name);
      }
      if (struct.isSetExerciseType()) {
        oprot.writeString(struct.exerciseType);
      }
      if (struct.isSetSubjectId()) {
        oprot.writeI32(struct.subjectId);
      }
    }

    @Override
    public void read(org.apache.thrift.protocol.TProtocol prot, UserRecord struct) throws TException {
      TTupleProtocol iprot = (TTupleProtocol) prot;
      BitSet incoming = iprot.readBitSet(5);
      if (incoming.get(0)) {
        struct.id = iprot.readI32();
        struct.setIdIsSet(true);
      }
      if (incoming.get(1)) {
        struct.stuId = iprot.readI32();
        struct.setStuIdIsSet(true);
      }
      if (incoming.get(2)) {
        struct.name = iprot.readString();
        struct.setNameIsSet(true);
      }
      if (incoming.get(3)) {
        struct.exerciseType = iprot.readString();
        struct.setExerciseTypeIsSet(true);
      }
      if (incoming.get(4)) {
        struct.subjectId = iprot.readI32();
        struct.setSubjectIdIsSet(true);
      }
    }
  }

}

