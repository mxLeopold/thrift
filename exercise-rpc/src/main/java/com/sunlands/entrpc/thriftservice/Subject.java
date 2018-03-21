/**
 * Autogenerated by Thrift Compiler (0.9.3)
 *
 * DO NOT EDIT UNLESS YOU ARE SURE THAT YOU KNOW WHAT YOU ARE DOING
 *  @generated
 */
package com.sunlands.entrpc.thriftservice;

import org.apache.thrift.EncodingUtils;
import org.apache.thrift.TException;
import org.apache.thrift.protocol.TTupleProtocol;
import org.apache.thrift.scheme.IScheme;
import org.apache.thrift.scheme.SchemeFactory;
import org.apache.thrift.scheme.StandardScheme;
import org.apache.thrift.scheme.TupleScheme;

import javax.annotation.Generated;
import java.util.*;

@SuppressWarnings({"cast", "rawtypes", "serial", "unchecked"})
@Generated(value = "Autogenerated by Thrift Compiler (0.9.3)", date = "2018-02-24")
public class Subject implements org.apache.thrift.TBase<Subject, Subject._Fields>, java.io.Serializable, Cloneable, Comparable<Subject> {
  private static final org.apache.thrift.protocol.TStruct STRUCT_DESC = new org.apache.thrift.protocol.TStruct("Subject");

  private static final org.apache.thrift.protocol.TField SUBJECT_ID_FIELD_DESC = new org.apache.thrift.protocol.TField("subjectId", org.apache.thrift.protocol.TType.I32, (short)1);
  private static final org.apache.thrift.protocol.TField SUBJECT_NAME_FIELD_DESC = new org.apache.thrift.protocol.TField("subjectName", org.apache.thrift.protocol.TType.STRING, (short)2);

  private static final Map<Class<? extends IScheme>, SchemeFactory> schemes = new HashMap<Class<? extends IScheme>, SchemeFactory>();
  static {
    schemes.put(StandardScheme.class, new SubjectStandardSchemeFactory());
    schemes.put(TupleScheme.class, new SubjectTupleSchemeFactory());
  }

  public int subjectId; // required
  public String subjectName; // required

  /** The set of fields this struct contains, along with convenience methods for finding and manipulating them. */
  public enum _Fields implements org.apache.thrift.TFieldIdEnum {
    SUBJECT_ID((short)1, "subjectId"),
    SUBJECT_NAME((short)2, "subjectName");

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
        case 1: // SUBJECT_ID
          return SUBJECT_ID;
        case 2: // SUBJECT_NAME
          return SUBJECT_NAME;
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
  private static final int __SUBJECTID_ISSET_ID = 0;
  private byte __isset_bitfield = 0;
  public static final Map<_Fields, org.apache.thrift.meta_data.FieldMetaData> metaDataMap;
  static {
    Map<_Fields, org.apache.thrift.meta_data.FieldMetaData> tmpMap = new EnumMap<_Fields, org.apache.thrift.meta_data.FieldMetaData>(_Fields.class);
    tmpMap.put(_Fields.SUBJECT_ID, new org.apache.thrift.meta_data.FieldMetaData("subjectId", org.apache.thrift.TFieldRequirementType.DEFAULT, 
        new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.I32)));
    tmpMap.put(_Fields.SUBJECT_NAME, new org.apache.thrift.meta_data.FieldMetaData("subjectName", org.apache.thrift.TFieldRequirementType.DEFAULT, 
        new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.STRING)));
    metaDataMap = Collections.unmodifiableMap(tmpMap);
    org.apache.thrift.meta_data.FieldMetaData.addStructMetaDataMap(Subject.class, metaDataMap);
  }

  public Subject() {
  }

  public Subject(
    int subjectId,
    String subjectName)
  {
    this();
    this.subjectId = subjectId;
    setSubjectIdIsSet(true);
    this.subjectName = subjectName;
  }

  /**
   * Performs a deep copy on <i>other</i>.
   */
  public Subject(Subject other) {
    __isset_bitfield = other.__isset_bitfield;
    this.subjectId = other.subjectId;
    if (other.isSetSubjectName()) {
      this.subjectName = other.subjectName;
    }
  }

  public Subject deepCopy() {
    return new Subject(this);
  }

  @Override
  public void clear() {
    setSubjectIdIsSet(false);
    this.subjectId = 0;
    this.subjectName = null;
  }

  public int getSubjectId() {
    return this.subjectId;
  }

  public Subject setSubjectId(int subjectId) {
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

  public String getSubjectName() {
    return this.subjectName;
  }

  public Subject setSubjectName(String subjectName) {
    this.subjectName = subjectName;
    return this;
  }

  public void unsetSubjectName() {
    this.subjectName = null;
  }

  /** Returns true if field subjectName is set (has been assigned a value) and false otherwise */
  public boolean isSetSubjectName() {
    return this.subjectName != null;
  }

  public void setSubjectNameIsSet(boolean value) {
    if (!value) {
      this.subjectName = null;
    }
  }

  public void setFieldValue(_Fields field, Object value) {
    switch (field) {
    case SUBJECT_ID:
      if (value == null) {
        unsetSubjectId();
      } else {
        setSubjectId((Integer)value);
      }
      break;

    case SUBJECT_NAME:
      if (value == null) {
        unsetSubjectName();
      } else {
        setSubjectName((String)value);
      }
      break;

    }
  }

  public Object getFieldValue(_Fields field) {
    switch (field) {
    case SUBJECT_ID:
      return getSubjectId();

    case SUBJECT_NAME:
      return getSubjectName();

    }
    throw new IllegalStateException();
  }

  /** Returns true if field corresponding to fieldID is set (has been assigned a value) and false otherwise */
  public boolean isSet(_Fields field) {
    if (field == null) {
      throw new IllegalArgumentException();
    }

    switch (field) {
    case SUBJECT_ID:
      return isSetSubjectId();
    case SUBJECT_NAME:
      return isSetSubjectName();
    }
    throw new IllegalStateException();
  }

  @Override
  public boolean equals(Object that) {
    if (that == null)
      return false;
    if (that instanceof Subject)
      return this.equals((Subject)that);
    return false;
  }

  public boolean equals(Subject that) {
    if (that == null)
      return false;

    boolean this_present_subjectId = true;
    boolean that_present_subjectId = true;
    if (this_present_subjectId || that_present_subjectId) {
      if (!(this_present_subjectId && that_present_subjectId))
        return false;
      if (this.subjectId != that.subjectId)
        return false;
    }

    boolean this_present_subjectName = true && this.isSetSubjectName();
    boolean that_present_subjectName = true && that.isSetSubjectName();
    if (this_present_subjectName || that_present_subjectName) {
      if (!(this_present_subjectName && that_present_subjectName))
        return false;
      if (!this.subjectName.equals(that.subjectName))
        return false;
    }

    return true;
  }

  @Override
  public int hashCode() {
    List<Object> list = new ArrayList<Object>();

    boolean present_subjectId = true;
    list.add(present_subjectId);
    if (present_subjectId)
      list.add(subjectId);

    boolean present_subjectName = true && (isSetSubjectName());
    list.add(present_subjectName);
    if (present_subjectName)
      list.add(subjectName);

    return list.hashCode();
  }

  @Override
  public int compareTo(Subject other) {
    if (!getClass().equals(other.getClass())) {
      return getClass().getName().compareTo(other.getClass().getName());
    }

    int lastComparison = 0;

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
    lastComparison = Boolean.valueOf(isSetSubjectName()).compareTo(other.isSetSubjectName());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetSubjectName()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.subjectName, other.subjectName);
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
    StringBuilder sb = new StringBuilder("Subject(");
    boolean first = true;

    sb.append("subjectId:");
    sb.append(this.subjectId);
    first = false;
    if (!first) sb.append(", ");
    sb.append("subjectName:");
    if (this.subjectName == null) {
      sb.append("null");
    } else {
      sb.append(this.subjectName);
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
      // it doesn't seem like you should have to do this, but java serialization is wacky, and doesn't call the default constructor.
      __isset_bitfield = 0;
      read(new org.apache.thrift.protocol.TCompactProtocol(new org.apache.thrift.transport.TIOStreamTransport(in)));
    } catch (TException te) {
      throw new java.io.IOException(te);
    }
  }

  private static class SubjectStandardSchemeFactory implements SchemeFactory {
    public SubjectStandardScheme getScheme() {
      return new SubjectStandardScheme();
    }
  }

  private static class SubjectStandardScheme extends StandardScheme<Subject> {

    public void read(org.apache.thrift.protocol.TProtocol iprot, Subject struct) throws TException {
      org.apache.thrift.protocol.TField schemeField;
      iprot.readStructBegin();
      while (true)
      {
        schemeField = iprot.readFieldBegin();
        if (schemeField.type == org.apache.thrift.protocol.TType.STOP) {
          break;
        }
        switch (schemeField.id) {
          case 1: // SUBJECT_ID
            if (schemeField.type == org.apache.thrift.protocol.TType.I32) {
              struct.subjectId = iprot.readI32();
              struct.setSubjectIdIsSet(true);
            } else {
              org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
            }
            break;
          case 2: // SUBJECT_NAME
            if (schemeField.type == org.apache.thrift.protocol.TType.STRING) {
              struct.subjectName = iprot.readString();
              struct.setSubjectNameIsSet(true);
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

    public void write(org.apache.thrift.protocol.TProtocol oprot, Subject struct) throws TException {
      struct.validate();

      oprot.writeStructBegin(STRUCT_DESC);
      oprot.writeFieldBegin(SUBJECT_ID_FIELD_DESC);
      oprot.writeI32(struct.subjectId);
      oprot.writeFieldEnd();
      if (struct.subjectName != null) {
        oprot.writeFieldBegin(SUBJECT_NAME_FIELD_DESC);
        oprot.writeString(struct.subjectName);
        oprot.writeFieldEnd();
      }
      oprot.writeFieldStop();
      oprot.writeStructEnd();
    }

  }

  private static class SubjectTupleSchemeFactory implements SchemeFactory {
    public SubjectTupleScheme getScheme() {
      return new SubjectTupleScheme();
    }
  }

  private static class SubjectTupleScheme extends TupleScheme<Subject> {

    @Override
    public void write(org.apache.thrift.protocol.TProtocol prot, Subject struct) throws TException {
      TTupleProtocol oprot = (TTupleProtocol) prot;
      BitSet optionals = new BitSet();
      if (struct.isSetSubjectId()) {
        optionals.set(0);
      }
      if (struct.isSetSubjectName()) {
        optionals.set(1);
      }
      oprot.writeBitSet(optionals, 2);
      if (struct.isSetSubjectId()) {
        oprot.writeI32(struct.subjectId);
      }
      if (struct.isSetSubjectName()) {
        oprot.writeString(struct.subjectName);
      }
    }

    @Override
    public void read(org.apache.thrift.protocol.TProtocol prot, Subject struct) throws TException {
      TTupleProtocol iprot = (TTupleProtocol) prot;
      BitSet incoming = iprot.readBitSet(2);
      if (incoming.get(0)) {
        struct.subjectId = iprot.readI32();
        struct.setSubjectIdIsSet(true);
      }
      if (incoming.get(1)) {
        struct.subjectName = iprot.readString();
        struct.setSubjectNameIsSet(true);
      }
    }
  }

}

