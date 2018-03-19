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
@Generated(value = "Autogenerated by Thrift Compiler (0.9.3)", date = "2018-03-19")
public class Option implements org.apache.thrift.TBase<Option, Option._Fields>, java.io.Serializable, Cloneable, Comparable<Option> {
  private static final org.apache.thrift.protocol.TStruct STRUCT_DESC = new org.apache.thrift.protocol.TStruct("Option");

  private static final org.apache.thrift.protocol.TField SEQUENCE_FIELD_DESC = new org.apache.thrift.protocol.TField("sequence", org.apache.thrift.protocol.TType.I32, (short)1);
  private static final org.apache.thrift.protocol.TField OPTION_TITLE_FIELD_DESC = new org.apache.thrift.protocol.TField("optionTitle", org.apache.thrift.protocol.TType.STRING, (short)2);
  private static final org.apache.thrift.protocol.TField OPTION_CONTENT_FIELD_DESC = new org.apache.thrift.protocol.TField("optionContent", org.apache.thrift.protocol.TType.STRING, (short)3);
  private static final org.apache.thrift.protocol.TField CORRECT_FIELD_DESC = new org.apache.thrift.protocol.TField("correct", org.apache.thrift.protocol.TType.I32, (short)4);

  private static final Map<Class<? extends IScheme>, SchemeFactory> schemes = new HashMap<Class<? extends IScheme>, SchemeFactory>();
  static {
    schemes.put(StandardScheme.class, new OptionStandardSchemeFactory());
    schemes.put(TupleScheme.class, new OptionTupleSchemeFactory());
  }

  public int sequence; // required
  public String optionTitle; // required
  public String optionContent; // required
  public int correct; // required

  /** The set of fields this struct contains, along with convenience methods for finding and manipulating them. */
  public enum _Fields implements org.apache.thrift.TFieldIdEnum {
    SEQUENCE((short)1, "sequence"),
    OPTION_TITLE((short)2, "optionTitle"),
    OPTION_CONTENT((short)3, "optionContent"),
    CORRECT((short)4, "correct");

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
        case 1: // SEQUENCE
          return SEQUENCE;
        case 2: // OPTION_TITLE
          return OPTION_TITLE;
        case 3: // OPTION_CONTENT
          return OPTION_CONTENT;
        case 4: // CORRECT
          return CORRECT;
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
  private static final int __SEQUENCE_ISSET_ID = 0;
  private static final int __CORRECT_ISSET_ID = 1;
  private byte __isset_bitfield = 0;
  public static final Map<_Fields, org.apache.thrift.meta_data.FieldMetaData> metaDataMap;
  static {
    Map<_Fields, org.apache.thrift.meta_data.FieldMetaData> tmpMap = new EnumMap<_Fields, org.apache.thrift.meta_data.FieldMetaData>(_Fields.class);
    tmpMap.put(_Fields.SEQUENCE, new org.apache.thrift.meta_data.FieldMetaData("sequence", org.apache.thrift.TFieldRequirementType.DEFAULT, 
        new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.I32)));
    tmpMap.put(_Fields.OPTION_TITLE, new org.apache.thrift.meta_data.FieldMetaData("optionTitle", org.apache.thrift.TFieldRequirementType.DEFAULT, 
        new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.STRING)));
    tmpMap.put(_Fields.OPTION_CONTENT, new org.apache.thrift.meta_data.FieldMetaData("optionContent", org.apache.thrift.TFieldRequirementType.DEFAULT, 
        new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.STRING)));
    tmpMap.put(_Fields.CORRECT, new org.apache.thrift.meta_data.FieldMetaData("correct", org.apache.thrift.TFieldRequirementType.DEFAULT, 
        new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.I32)));
    metaDataMap = Collections.unmodifiableMap(tmpMap);
    org.apache.thrift.meta_data.FieldMetaData.addStructMetaDataMap(Option.class, metaDataMap);
  }

  public Option() {
  }

  public Option(
    int sequence,
    String optionTitle,
    String optionContent,
    int correct)
  {
    this();
    this.sequence = sequence;
    setSequenceIsSet(true);
    this.optionTitle = optionTitle;
    this.optionContent = optionContent;
    this.correct = correct;
    setCorrectIsSet(true);
  }

  /**
   * Performs a deep copy on <i>other</i>.
   */
  public Option(Option other) {
    __isset_bitfield = other.__isset_bitfield;
    this.sequence = other.sequence;
    if (other.isSetOptionTitle()) {
      this.optionTitle = other.optionTitle;
    }
    if (other.isSetOptionContent()) {
      this.optionContent = other.optionContent;
    }
    this.correct = other.correct;
  }

  public Option deepCopy() {
    return new Option(this);
  }

  @Override
  public void clear() {
    setSequenceIsSet(false);
    this.sequence = 0;
    this.optionTitle = null;
    this.optionContent = null;
    setCorrectIsSet(false);
    this.correct = 0;
  }

  public int getSequence() {
    return this.sequence;
  }

  public Option setSequence(int sequence) {
    this.sequence = sequence;
    setSequenceIsSet(true);
    return this;
  }

  public void unsetSequence() {
    __isset_bitfield = EncodingUtils.clearBit(__isset_bitfield, __SEQUENCE_ISSET_ID);
  }

  /** Returns true if field sequence is set (has been assigned a value) and false otherwise */
  public boolean isSetSequence() {
    return EncodingUtils.testBit(__isset_bitfield, __SEQUENCE_ISSET_ID);
  }

  public void setSequenceIsSet(boolean value) {
    __isset_bitfield = EncodingUtils.setBit(__isset_bitfield, __SEQUENCE_ISSET_ID, value);
  }

  public String getOptionTitle() {
    return this.optionTitle;
  }

  public Option setOptionTitle(String optionTitle) {
    this.optionTitle = optionTitle;
    return this;
  }

  public void unsetOptionTitle() {
    this.optionTitle = null;
  }

  /** Returns true if field optionTitle is set (has been assigned a value) and false otherwise */
  public boolean isSetOptionTitle() {
    return this.optionTitle != null;
  }

  public void setOptionTitleIsSet(boolean value) {
    if (!value) {
      this.optionTitle = null;
    }
  }

  public String getOptionContent() {
    return this.optionContent;
  }

  public Option setOptionContent(String optionContent) {
    this.optionContent = optionContent;
    return this;
  }

  public void unsetOptionContent() {
    this.optionContent = null;
  }

  /** Returns true if field optionContent is set (has been assigned a value) and false otherwise */
  public boolean isSetOptionContent() {
    return this.optionContent != null;
  }

  public void setOptionContentIsSet(boolean value) {
    if (!value) {
      this.optionContent = null;
    }
  }

  public int getCorrect() {
    return this.correct;
  }

  public Option setCorrect(int correct) {
    this.correct = correct;
    setCorrectIsSet(true);
    return this;
  }

  public void unsetCorrect() {
    __isset_bitfield = EncodingUtils.clearBit(__isset_bitfield, __CORRECT_ISSET_ID);
  }

  /** Returns true if field correct is set (has been assigned a value) and false otherwise */
  public boolean isSetCorrect() {
    return EncodingUtils.testBit(__isset_bitfield, __CORRECT_ISSET_ID);
  }

  public void setCorrectIsSet(boolean value) {
    __isset_bitfield = EncodingUtils.setBit(__isset_bitfield, __CORRECT_ISSET_ID, value);
  }

  public void setFieldValue(_Fields field, Object value) {
    switch (field) {
    case SEQUENCE:
      if (value == null) {
        unsetSequence();
      } else {
        setSequence((Integer)value);
      }
      break;

    case OPTION_TITLE:
      if (value == null) {
        unsetOptionTitle();
      } else {
        setOptionTitle((String)value);
      }
      break;

    case OPTION_CONTENT:
      if (value == null) {
        unsetOptionContent();
      } else {
        setOptionContent((String)value);
      }
      break;

    case CORRECT:
      if (value == null) {
        unsetCorrect();
      } else {
        setCorrect((Integer)value);
      }
      break;

    }
  }

  public Object getFieldValue(_Fields field) {
    switch (field) {
    case SEQUENCE:
      return getSequence();

    case OPTION_TITLE:
      return getOptionTitle();

    case OPTION_CONTENT:
      return getOptionContent();

    case CORRECT:
      return getCorrect();

    }
    throw new IllegalStateException();
  }

  /** Returns true if field corresponding to fieldID is set (has been assigned a value) and false otherwise */
  public boolean isSet(_Fields field) {
    if (field == null) {
      throw new IllegalArgumentException();
    }

    switch (field) {
    case SEQUENCE:
      return isSetSequence();
    case OPTION_TITLE:
      return isSetOptionTitle();
    case OPTION_CONTENT:
      return isSetOptionContent();
    case CORRECT:
      return isSetCorrect();
    }
    throw new IllegalStateException();
  }

  @Override
  public boolean equals(Object that) {
    if (that == null)
      return false;
    if (that instanceof Option)
      return this.equals((Option)that);
    return false;
  }

  public boolean equals(Option that) {
    if (that == null)
      return false;

    boolean this_present_sequence = true;
    boolean that_present_sequence = true;
    if (this_present_sequence || that_present_sequence) {
      if (!(this_present_sequence && that_present_sequence))
        return false;
      if (this.sequence != that.sequence)
        return false;
    }

    boolean this_present_optionTitle = true && this.isSetOptionTitle();
    boolean that_present_optionTitle = true && that.isSetOptionTitle();
    if (this_present_optionTitle || that_present_optionTitle) {
      if (!(this_present_optionTitle && that_present_optionTitle))
        return false;
      if (!this.optionTitle.equals(that.optionTitle))
        return false;
    }

    boolean this_present_optionContent = true && this.isSetOptionContent();
    boolean that_present_optionContent = true && that.isSetOptionContent();
    if (this_present_optionContent || that_present_optionContent) {
      if (!(this_present_optionContent && that_present_optionContent))
        return false;
      if (!this.optionContent.equals(that.optionContent))
        return false;
    }

    boolean this_present_correct = true;
    boolean that_present_correct = true;
    if (this_present_correct || that_present_correct) {
      if (!(this_present_correct && that_present_correct))
        return false;
      if (this.correct != that.correct)
        return false;
    }

    return true;
  }

  @Override
  public int hashCode() {
    List<Object> list = new ArrayList<Object>();

    boolean present_sequence = true;
    list.add(present_sequence);
    if (present_sequence)
      list.add(sequence);

    boolean present_optionTitle = true && (isSetOptionTitle());
    list.add(present_optionTitle);
    if (present_optionTitle)
      list.add(optionTitle);

    boolean present_optionContent = true && (isSetOptionContent());
    list.add(present_optionContent);
    if (present_optionContent)
      list.add(optionContent);

    boolean present_correct = true;
    list.add(present_correct);
    if (present_correct)
      list.add(correct);

    return list.hashCode();
  }

  @Override
  public int compareTo(Option other) {
    if (!getClass().equals(other.getClass())) {
      return getClass().getName().compareTo(other.getClass().getName());
    }

    int lastComparison = 0;

    lastComparison = Boolean.valueOf(isSetSequence()).compareTo(other.isSetSequence());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetSequence()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.sequence, other.sequence);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    lastComparison = Boolean.valueOf(isSetOptionTitle()).compareTo(other.isSetOptionTitle());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetOptionTitle()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.optionTitle, other.optionTitle);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    lastComparison = Boolean.valueOf(isSetOptionContent()).compareTo(other.isSetOptionContent());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetOptionContent()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.optionContent, other.optionContent);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    lastComparison = Boolean.valueOf(isSetCorrect()).compareTo(other.isSetCorrect());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetCorrect()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.correct, other.correct);
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
    StringBuilder sb = new StringBuilder("Option(");
    boolean first = true;

    sb.append("sequence:");
    sb.append(this.sequence);
    first = false;
    if (!first) sb.append(", ");
    sb.append("optionTitle:");
    if (this.optionTitle == null) {
      sb.append("null");
    } else {
      sb.append(this.optionTitle);
    }
    first = false;
    if (!first) sb.append(", ");
    sb.append("optionContent:");
    if (this.optionContent == null) {
      sb.append("null");
    } else {
      sb.append(this.optionContent);
    }
    first = false;
    if (!first) sb.append(", ");
    sb.append("correct:");
    sb.append(this.correct);
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

  private static class OptionStandardSchemeFactory implements SchemeFactory {
    public OptionStandardScheme getScheme() {
      return new OptionStandardScheme();
    }
  }

  private static class OptionStandardScheme extends StandardScheme<Option> {

    public void read(org.apache.thrift.protocol.TProtocol iprot, Option struct) throws TException {
      org.apache.thrift.protocol.TField schemeField;
      iprot.readStructBegin();
      while (true)
      {
        schemeField = iprot.readFieldBegin();
        if (schemeField.type == org.apache.thrift.protocol.TType.STOP) { 
          break;
        }
        switch (schemeField.id) {
          case 1: // SEQUENCE
            if (schemeField.type == org.apache.thrift.protocol.TType.I32) {
              struct.sequence = iprot.readI32();
              struct.setSequenceIsSet(true);
            } else { 
              org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
            }
            break;
          case 2: // OPTION_TITLE
            if (schemeField.type == org.apache.thrift.protocol.TType.STRING) {
              struct.optionTitle = iprot.readString();
              struct.setOptionTitleIsSet(true);
            } else { 
              org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
            }
            break;
          case 3: // OPTION_CONTENT
            if (schemeField.type == org.apache.thrift.protocol.TType.STRING) {
              struct.optionContent = iprot.readString();
              struct.setOptionContentIsSet(true);
            } else { 
              org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
            }
            break;
          case 4: // CORRECT
            if (schemeField.type == org.apache.thrift.protocol.TType.I32) {
              struct.correct = iprot.readI32();
              struct.setCorrectIsSet(true);
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

    public void write(org.apache.thrift.protocol.TProtocol oprot, Option struct) throws TException {
      struct.validate();

      oprot.writeStructBegin(STRUCT_DESC);
      oprot.writeFieldBegin(SEQUENCE_FIELD_DESC);
      oprot.writeI32(struct.sequence);
      oprot.writeFieldEnd();
      if (struct.optionTitle != null) {
        oprot.writeFieldBegin(OPTION_TITLE_FIELD_DESC);
        oprot.writeString(struct.optionTitle);
        oprot.writeFieldEnd();
      }
      if (struct.optionContent != null) {
        oprot.writeFieldBegin(OPTION_CONTENT_FIELD_DESC);
        oprot.writeString(struct.optionContent);
        oprot.writeFieldEnd();
      }
      oprot.writeFieldBegin(CORRECT_FIELD_DESC);
      oprot.writeI32(struct.correct);
      oprot.writeFieldEnd();
      oprot.writeFieldStop();
      oprot.writeStructEnd();
    }

  }

  private static class OptionTupleSchemeFactory implements SchemeFactory {
    public OptionTupleScheme getScheme() {
      return new OptionTupleScheme();
    }
  }

  private static class OptionTupleScheme extends TupleScheme<Option> {

    @Override
    public void write(org.apache.thrift.protocol.TProtocol prot, Option struct) throws TException {
      TTupleProtocol oprot = (TTupleProtocol) prot;
      BitSet optionals = new BitSet();
      if (struct.isSetSequence()) {
        optionals.set(0);
      }
      if (struct.isSetOptionTitle()) {
        optionals.set(1);
      }
      if (struct.isSetOptionContent()) {
        optionals.set(2);
      }
      if (struct.isSetCorrect()) {
        optionals.set(3);
      }
      oprot.writeBitSet(optionals, 4);
      if (struct.isSetSequence()) {
        oprot.writeI32(struct.sequence);
      }
      if (struct.isSetOptionTitle()) {
        oprot.writeString(struct.optionTitle);
      }
      if (struct.isSetOptionContent()) {
        oprot.writeString(struct.optionContent);
      }
      if (struct.isSetCorrect()) {
        oprot.writeI32(struct.correct);
      }
    }

    @Override
    public void read(org.apache.thrift.protocol.TProtocol prot, Option struct) throws TException {
      TTupleProtocol iprot = (TTupleProtocol) prot;
      BitSet incoming = iprot.readBitSet(4);
      if (incoming.get(0)) {
        struct.sequence = iprot.readI32();
        struct.setSequenceIsSet(true);
      }
      if (incoming.get(1)) {
        struct.optionTitle = iprot.readString();
        struct.setOptionTitleIsSet(true);
      }
      if (incoming.get(2)) {
        struct.optionContent = iprot.readString();
        struct.setOptionContentIsSet(true);
      }
      if (incoming.get(3)) {
        struct.correct = iprot.readI32();
        struct.setCorrectIsSet(true);
      }
    }
  }

}
