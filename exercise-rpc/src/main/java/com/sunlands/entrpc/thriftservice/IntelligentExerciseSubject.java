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
public class IntelligentExerciseSubject implements org.apache.thrift.TBase<IntelligentExerciseSubject, IntelligentExerciseSubject._Fields>, java.io.Serializable, Cloneable, Comparable<IntelligentExerciseSubject> {
  private static final org.apache.thrift.protocol.TStruct STRUCT_DESC = new org.apache.thrift.protocol.TStruct("IntelligentExerciseSubject");

  private static final org.apache.thrift.protocol.TField SUBJECT_ID_FIELD_DESC = new org.apache.thrift.protocol.TField("subjectId", org.apache.thrift.protocol.TType.I32, (short)1);
  private static final org.apache.thrift.protocol.TField SUBJECT_NAME_FIELD_DESC = new org.apache.thrift.protocol.TField("subjectName", org.apache.thrift.protocol.TType.STRING, (short)2);
  private static final org.apache.thrift.protocol.TField HAS_PASSED_UNIT_NUM_FIELD_DESC = new org.apache.thrift.protocol.TField("hasPassedUnitNum", org.apache.thrift.protocol.TType.I32, (short)3);
  private static final org.apache.thrift.protocol.TField TOTAL_UNIT_NUM_FIELD_DESC = new org.apache.thrift.protocol.TField("totalUnitNum", org.apache.thrift.protocol.TType.I32, (short)4);
  private static final org.apache.thrift.protocol.TField MODULE_TYPE_FIELD_DESC = new org.apache.thrift.protocol.TField("moduleType", org.apache.thrift.protocol.TType.STRING, (short)5);
  private static final org.apache.thrift.protocol.TField PROVINCE_ID_FIELD_DESC = new org.apache.thrift.protocol.TField("provinceId", org.apache.thrift.protocol.TType.I32, (short)6);
  private static final org.apache.thrift.protocol.TField PROJECT_SECOND_ID_FIELD_DESC = new org.apache.thrift.protocol.TField("projectSecondId", org.apache.thrift.protocol.TType.I32, (short)7);

  private static final Map<Class<? extends IScheme>, SchemeFactory> schemes = new HashMap<Class<? extends IScheme>, SchemeFactory>();
  static {
    schemes.put(StandardScheme.class, new IntelligentExerciseSubjectStandardSchemeFactory());
    schemes.put(TupleScheme.class, new IntelligentExerciseSubjectTupleSchemeFactory());
  }

  public int subjectId; // required
  public String subjectName; // required
  public int hasPassedUnitNum; // required
  public int totalUnitNum; // required
  public String moduleType; // required
  public int provinceId; // required
  public int projectSecondId; // required

  /** The set of fields this struct contains, along with convenience methods for finding and manipulating them. */
  public enum _Fields implements org.apache.thrift.TFieldIdEnum {
    SUBJECT_ID((short)1, "subjectId"),
    SUBJECT_NAME((short)2, "subjectName"),
    HAS_PASSED_UNIT_NUM((short)3, "hasPassedUnitNum"),
    TOTAL_UNIT_NUM((short)4, "totalUnitNum"),
    MODULE_TYPE((short)5, "moduleType"),
    PROVINCE_ID((short)6, "provinceId"),
    PROJECT_SECOND_ID((short)7, "projectSecondId");

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
        case 3: // HAS_PASSED_UNIT_NUM
          return HAS_PASSED_UNIT_NUM;
        case 4: // TOTAL_UNIT_NUM
          return TOTAL_UNIT_NUM;
        case 5: // MODULE_TYPE
          return MODULE_TYPE;
        case 6: // PROVINCE_ID
          return PROVINCE_ID;
        case 7: // PROJECT_SECOND_ID
          return PROJECT_SECOND_ID;
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
  private static final int __HASPASSEDUNITNUM_ISSET_ID = 1;
  private static final int __TOTALUNITNUM_ISSET_ID = 2;
  private static final int __PROVINCEID_ISSET_ID = 3;
  private static final int __PROJECTSECONDID_ISSET_ID = 4;
  private byte __isset_bitfield = 0;
  public static final Map<_Fields, org.apache.thrift.meta_data.FieldMetaData> metaDataMap;
  static {
    Map<_Fields, org.apache.thrift.meta_data.FieldMetaData> tmpMap = new EnumMap<_Fields, org.apache.thrift.meta_data.FieldMetaData>(_Fields.class);
    tmpMap.put(_Fields.SUBJECT_ID, new org.apache.thrift.meta_data.FieldMetaData("subjectId", org.apache.thrift.TFieldRequirementType.DEFAULT, 
        new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.I32)));
    tmpMap.put(_Fields.SUBJECT_NAME, new org.apache.thrift.meta_data.FieldMetaData("subjectName", org.apache.thrift.TFieldRequirementType.DEFAULT, 
        new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.STRING)));
    tmpMap.put(_Fields.HAS_PASSED_UNIT_NUM, new org.apache.thrift.meta_data.FieldMetaData("hasPassedUnitNum", org.apache.thrift.TFieldRequirementType.DEFAULT, 
        new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.I32)));
    tmpMap.put(_Fields.TOTAL_UNIT_NUM, new org.apache.thrift.meta_data.FieldMetaData("totalUnitNum", org.apache.thrift.TFieldRequirementType.DEFAULT, 
        new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.I32)));
    tmpMap.put(_Fields.MODULE_TYPE, new org.apache.thrift.meta_data.FieldMetaData("moduleType", org.apache.thrift.TFieldRequirementType.DEFAULT, 
        new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.STRING)));
    tmpMap.put(_Fields.PROVINCE_ID, new org.apache.thrift.meta_data.FieldMetaData("provinceId", org.apache.thrift.TFieldRequirementType.DEFAULT, 
        new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.I32)));
    tmpMap.put(_Fields.PROJECT_SECOND_ID, new org.apache.thrift.meta_data.FieldMetaData("projectSecondId", org.apache.thrift.TFieldRequirementType.DEFAULT, 
        new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.I32)));
    metaDataMap = Collections.unmodifiableMap(tmpMap);
    org.apache.thrift.meta_data.FieldMetaData.addStructMetaDataMap(IntelligentExerciseSubject.class, metaDataMap);
  }

  public IntelligentExerciseSubject() {
  }

  public IntelligentExerciseSubject(
    int subjectId,
    String subjectName,
    int hasPassedUnitNum,
    int totalUnitNum,
    String moduleType,
    int provinceId,
    int projectSecondId)
  {
    this();
    this.subjectId = subjectId;
    setSubjectIdIsSet(true);
    this.subjectName = subjectName;
    this.hasPassedUnitNum = hasPassedUnitNum;
    setHasPassedUnitNumIsSet(true);
    this.totalUnitNum = totalUnitNum;
    setTotalUnitNumIsSet(true);
    this.moduleType = moduleType;
    this.provinceId = provinceId;
    setProvinceIdIsSet(true);
    this.projectSecondId = projectSecondId;
    setProjectSecondIdIsSet(true);
  }

  /**
   * Performs a deep copy on <i>other</i>.
   */
  public IntelligentExerciseSubject(IntelligentExerciseSubject other) {
    __isset_bitfield = other.__isset_bitfield;
    this.subjectId = other.subjectId;
    if (other.isSetSubjectName()) {
      this.subjectName = other.subjectName;
    }
    this.hasPassedUnitNum = other.hasPassedUnitNum;
    this.totalUnitNum = other.totalUnitNum;
    if (other.isSetModuleType()) {
      this.moduleType = other.moduleType;
    }
    this.provinceId = other.provinceId;
    this.projectSecondId = other.projectSecondId;
  }

  public IntelligentExerciseSubject deepCopy() {
    return new IntelligentExerciseSubject(this);
  }

  @Override
  public void clear() {
    setSubjectIdIsSet(false);
    this.subjectId = 0;
    this.subjectName = null;
    setHasPassedUnitNumIsSet(false);
    this.hasPassedUnitNum = 0;
    setTotalUnitNumIsSet(false);
    this.totalUnitNum = 0;
    this.moduleType = null;
    setProvinceIdIsSet(false);
    this.provinceId = 0;
    setProjectSecondIdIsSet(false);
    this.projectSecondId = 0;
  }

  public int getSubjectId() {
    return this.subjectId;
  }

  public IntelligentExerciseSubject setSubjectId(int subjectId) {
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

  public IntelligentExerciseSubject setSubjectName(String subjectName) {
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

  public int getHasPassedUnitNum() {
    return this.hasPassedUnitNum;
  }

  public IntelligentExerciseSubject setHasPassedUnitNum(int hasPassedUnitNum) {
    this.hasPassedUnitNum = hasPassedUnitNum;
    setHasPassedUnitNumIsSet(true);
    return this;
  }

  public void unsetHasPassedUnitNum() {
    __isset_bitfield = EncodingUtils.clearBit(__isset_bitfield, __HASPASSEDUNITNUM_ISSET_ID);
  }

  /** Returns true if field hasPassedUnitNum is set (has been assigned a value) and false otherwise */
  public boolean isSetHasPassedUnitNum() {
    return EncodingUtils.testBit(__isset_bitfield, __HASPASSEDUNITNUM_ISSET_ID);
  }

  public void setHasPassedUnitNumIsSet(boolean value) {
    __isset_bitfield = EncodingUtils.setBit(__isset_bitfield, __HASPASSEDUNITNUM_ISSET_ID, value);
  }

  public int getTotalUnitNum() {
    return this.totalUnitNum;
  }

  public IntelligentExerciseSubject setTotalUnitNum(int totalUnitNum) {
    this.totalUnitNum = totalUnitNum;
    setTotalUnitNumIsSet(true);
    return this;
  }

  public void unsetTotalUnitNum() {
    __isset_bitfield = EncodingUtils.clearBit(__isset_bitfield, __TOTALUNITNUM_ISSET_ID);
  }

  /** Returns true if field totalUnitNum is set (has been assigned a value) and false otherwise */
  public boolean isSetTotalUnitNum() {
    return EncodingUtils.testBit(__isset_bitfield, __TOTALUNITNUM_ISSET_ID);
  }

  public void setTotalUnitNumIsSet(boolean value) {
    __isset_bitfield = EncodingUtils.setBit(__isset_bitfield, __TOTALUNITNUM_ISSET_ID, value);
  }

  public String getModuleType() {
    return this.moduleType;
  }

  public IntelligentExerciseSubject setModuleType(String moduleType) {
    this.moduleType = moduleType;
    return this;
  }

  public void unsetModuleType() {
    this.moduleType = null;
  }

  /** Returns true if field moduleType is set (has been assigned a value) and false otherwise */
  public boolean isSetModuleType() {
    return this.moduleType != null;
  }

  public void setModuleTypeIsSet(boolean value) {
    if (!value) {
      this.moduleType = null;
    }
  }

  public int getProvinceId() {
    return this.provinceId;
  }

  public IntelligentExerciseSubject setProvinceId(int provinceId) {
    this.provinceId = provinceId;
    setProvinceIdIsSet(true);
    return this;
  }

  public void unsetProvinceId() {
    __isset_bitfield = EncodingUtils.clearBit(__isset_bitfield, __PROVINCEID_ISSET_ID);
  }

  /** Returns true if field provinceId is set (has been assigned a value) and false otherwise */
  public boolean isSetProvinceId() {
    return EncodingUtils.testBit(__isset_bitfield, __PROVINCEID_ISSET_ID);
  }

  public void setProvinceIdIsSet(boolean value) {
    __isset_bitfield = EncodingUtils.setBit(__isset_bitfield, __PROVINCEID_ISSET_ID, value);
  }

  public int getProjectSecondId() {
    return this.projectSecondId;
  }

  public IntelligentExerciseSubject setProjectSecondId(int projectSecondId) {
    this.projectSecondId = projectSecondId;
    setProjectSecondIdIsSet(true);
    return this;
  }

  public void unsetProjectSecondId() {
    __isset_bitfield = EncodingUtils.clearBit(__isset_bitfield, __PROJECTSECONDID_ISSET_ID);
  }

  /** Returns true if field projectSecondId is set (has been assigned a value) and false otherwise */
  public boolean isSetProjectSecondId() {
    return EncodingUtils.testBit(__isset_bitfield, __PROJECTSECONDID_ISSET_ID);
  }

  public void setProjectSecondIdIsSet(boolean value) {
    __isset_bitfield = EncodingUtils.setBit(__isset_bitfield, __PROJECTSECONDID_ISSET_ID, value);
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

    case HAS_PASSED_UNIT_NUM:
      if (value == null) {
        unsetHasPassedUnitNum();
      } else {
        setHasPassedUnitNum((Integer)value);
      }
      break;

    case TOTAL_UNIT_NUM:
      if (value == null) {
        unsetTotalUnitNum();
      } else {
        setTotalUnitNum((Integer)value);
      }
      break;

    case MODULE_TYPE:
      if (value == null) {
        unsetModuleType();
      } else {
        setModuleType((String)value);
      }
      break;

    case PROVINCE_ID:
      if (value == null) {
        unsetProvinceId();
      } else {
        setProvinceId((Integer)value);
      }
      break;

    case PROJECT_SECOND_ID:
      if (value == null) {
        unsetProjectSecondId();
      } else {
        setProjectSecondId((Integer)value);
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

    case HAS_PASSED_UNIT_NUM:
      return getHasPassedUnitNum();

    case TOTAL_UNIT_NUM:
      return getTotalUnitNum();

    case MODULE_TYPE:
      return getModuleType();

    case PROVINCE_ID:
      return getProvinceId();

    case PROJECT_SECOND_ID:
      return getProjectSecondId();

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
    case HAS_PASSED_UNIT_NUM:
      return isSetHasPassedUnitNum();
    case TOTAL_UNIT_NUM:
      return isSetTotalUnitNum();
    case MODULE_TYPE:
      return isSetModuleType();
    case PROVINCE_ID:
      return isSetProvinceId();
    case PROJECT_SECOND_ID:
      return isSetProjectSecondId();
    }
    throw new IllegalStateException();
  }

  @Override
  public boolean equals(Object that) {
    if (that == null)
      return false;
    if (that instanceof IntelligentExerciseSubject)
      return this.equals((IntelligentExerciseSubject)that);
    return false;
  }

  public boolean equals(IntelligentExerciseSubject that) {
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

    boolean this_present_hasPassedUnitNum = true;
    boolean that_present_hasPassedUnitNum = true;
    if (this_present_hasPassedUnitNum || that_present_hasPassedUnitNum) {
      if (!(this_present_hasPassedUnitNum && that_present_hasPassedUnitNum))
        return false;
      if (this.hasPassedUnitNum != that.hasPassedUnitNum)
        return false;
    }

    boolean this_present_totalUnitNum = true;
    boolean that_present_totalUnitNum = true;
    if (this_present_totalUnitNum || that_present_totalUnitNum) {
      if (!(this_present_totalUnitNum && that_present_totalUnitNum))
        return false;
      if (this.totalUnitNum != that.totalUnitNum)
        return false;
    }

    boolean this_present_moduleType = true && this.isSetModuleType();
    boolean that_present_moduleType = true && that.isSetModuleType();
    if (this_present_moduleType || that_present_moduleType) {
      if (!(this_present_moduleType && that_present_moduleType))
        return false;
      if (!this.moduleType.equals(that.moduleType))
        return false;
    }

    boolean this_present_provinceId = true;
    boolean that_present_provinceId = true;
    if (this_present_provinceId || that_present_provinceId) {
      if (!(this_present_provinceId && that_present_provinceId))
        return false;
      if (this.provinceId != that.provinceId)
        return false;
    }

    boolean this_present_projectSecondId = true;
    boolean that_present_projectSecondId = true;
    if (this_present_projectSecondId || that_present_projectSecondId) {
      if (!(this_present_projectSecondId && that_present_projectSecondId))
        return false;
      if (this.projectSecondId != that.projectSecondId)
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

    boolean present_hasPassedUnitNum = true;
    list.add(present_hasPassedUnitNum);
    if (present_hasPassedUnitNum)
      list.add(hasPassedUnitNum);

    boolean present_totalUnitNum = true;
    list.add(present_totalUnitNum);
    if (present_totalUnitNum)
      list.add(totalUnitNum);

    boolean present_moduleType = true && (isSetModuleType());
    list.add(present_moduleType);
    if (present_moduleType)
      list.add(moduleType);

    boolean present_provinceId = true;
    list.add(present_provinceId);
    if (present_provinceId)
      list.add(provinceId);

    boolean present_projectSecondId = true;
    list.add(present_projectSecondId);
    if (present_projectSecondId)
      list.add(projectSecondId);

    return list.hashCode();
  }

  @Override
  public int compareTo(IntelligentExerciseSubject other) {
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
    lastComparison = Boolean.valueOf(isSetHasPassedUnitNum()).compareTo(other.isSetHasPassedUnitNum());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetHasPassedUnitNum()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.hasPassedUnitNum, other.hasPassedUnitNum);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    lastComparison = Boolean.valueOf(isSetTotalUnitNum()).compareTo(other.isSetTotalUnitNum());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetTotalUnitNum()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.totalUnitNum, other.totalUnitNum);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    lastComparison = Boolean.valueOf(isSetModuleType()).compareTo(other.isSetModuleType());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetModuleType()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.moduleType, other.moduleType);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    lastComparison = Boolean.valueOf(isSetProvinceId()).compareTo(other.isSetProvinceId());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetProvinceId()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.provinceId, other.provinceId);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    lastComparison = Boolean.valueOf(isSetProjectSecondId()).compareTo(other.isSetProjectSecondId());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetProjectSecondId()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.projectSecondId, other.projectSecondId);
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
    StringBuilder sb = new StringBuilder("IntelligentExerciseSubject(");
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
    if (!first) sb.append(", ");
    sb.append("hasPassedUnitNum:");
    sb.append(this.hasPassedUnitNum);
    first = false;
    if (!first) sb.append(", ");
    sb.append("totalUnitNum:");
    sb.append(this.totalUnitNum);
    first = false;
    if (!first) sb.append(", ");
    sb.append("moduleType:");
    if (this.moduleType == null) {
      sb.append("null");
    } else {
      sb.append(this.moduleType);
    }
    first = false;
    if (!first) sb.append(", ");
    sb.append("provinceId:");
    sb.append(this.provinceId);
    first = false;
    if (!first) sb.append(", ");
    sb.append("projectSecondId:");
    sb.append(this.projectSecondId);
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

  private static class IntelligentExerciseSubjectStandardSchemeFactory implements SchemeFactory {
    public IntelligentExerciseSubjectStandardScheme getScheme() {
      return new IntelligentExerciseSubjectStandardScheme();
    }
  }

  private static class IntelligentExerciseSubjectStandardScheme extends StandardScheme<IntelligentExerciseSubject> {

    public void read(org.apache.thrift.protocol.TProtocol iprot, IntelligentExerciseSubject struct) throws TException {
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
          case 3: // HAS_PASSED_UNIT_NUM
            if (schemeField.type == org.apache.thrift.protocol.TType.I32) {
              struct.hasPassedUnitNum = iprot.readI32();
              struct.setHasPassedUnitNumIsSet(true);
            } else {
              org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
            }
            break;
          case 4: // TOTAL_UNIT_NUM
            if (schemeField.type == org.apache.thrift.protocol.TType.I32) {
              struct.totalUnitNum = iprot.readI32();
              struct.setTotalUnitNumIsSet(true);
            } else {
              org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
            }
            break;
          case 5: // MODULE_TYPE
            if (schemeField.type == org.apache.thrift.protocol.TType.STRING) {
              struct.moduleType = iprot.readString();
              struct.setModuleTypeIsSet(true);
            } else {
              org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
            }
            break;
          case 6: // PROVINCE_ID
            if (schemeField.type == org.apache.thrift.protocol.TType.I32) {
              struct.provinceId = iprot.readI32();
              struct.setProvinceIdIsSet(true);
            } else {
              org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
            }
            break;
          case 7: // PROJECT_SECOND_ID
            if (schemeField.type == org.apache.thrift.protocol.TType.I32) {
              struct.projectSecondId = iprot.readI32();
              struct.setProjectSecondIdIsSet(true);
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

    public void write(org.apache.thrift.protocol.TProtocol oprot, IntelligentExerciseSubject struct) throws TException {
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
      oprot.writeFieldBegin(HAS_PASSED_UNIT_NUM_FIELD_DESC);
      oprot.writeI32(struct.hasPassedUnitNum);
      oprot.writeFieldEnd();
      oprot.writeFieldBegin(TOTAL_UNIT_NUM_FIELD_DESC);
      oprot.writeI32(struct.totalUnitNum);
      oprot.writeFieldEnd();
      if (struct.moduleType != null) {
        oprot.writeFieldBegin(MODULE_TYPE_FIELD_DESC);
        oprot.writeString(struct.moduleType);
        oprot.writeFieldEnd();
      }
      oprot.writeFieldBegin(PROVINCE_ID_FIELD_DESC);
      oprot.writeI32(struct.provinceId);
      oprot.writeFieldEnd();
      oprot.writeFieldBegin(PROJECT_SECOND_ID_FIELD_DESC);
      oprot.writeI32(struct.projectSecondId);
      oprot.writeFieldEnd();
      oprot.writeFieldStop();
      oprot.writeStructEnd();
    }

  }

  private static class IntelligentExerciseSubjectTupleSchemeFactory implements SchemeFactory {
    public IntelligentExerciseSubjectTupleScheme getScheme() {
      return new IntelligentExerciseSubjectTupleScheme();
    }
  }

  private static class IntelligentExerciseSubjectTupleScheme extends TupleScheme<IntelligentExerciseSubject> {

    @Override
    public void write(org.apache.thrift.protocol.TProtocol prot, IntelligentExerciseSubject struct) throws TException {
      TTupleProtocol oprot = (TTupleProtocol) prot;
      BitSet optionals = new BitSet();
      if (struct.isSetSubjectId()) {
        optionals.set(0);
      }
      if (struct.isSetSubjectName()) {
        optionals.set(1);
      }
      if (struct.isSetHasPassedUnitNum()) {
        optionals.set(2);
      }
      if (struct.isSetTotalUnitNum()) {
        optionals.set(3);
      }
      if (struct.isSetModuleType()) {
        optionals.set(4);
      }
      if (struct.isSetProvinceId()) {
        optionals.set(5);
      }
      if (struct.isSetProjectSecondId()) {
        optionals.set(6);
      }
      oprot.writeBitSet(optionals, 7);
      if (struct.isSetSubjectId()) {
        oprot.writeI32(struct.subjectId);
      }
      if (struct.isSetSubjectName()) {
        oprot.writeString(struct.subjectName);
      }
      if (struct.isSetHasPassedUnitNum()) {
        oprot.writeI32(struct.hasPassedUnitNum);
      }
      if (struct.isSetTotalUnitNum()) {
        oprot.writeI32(struct.totalUnitNum);
      }
      if (struct.isSetModuleType()) {
        oprot.writeString(struct.moduleType);
      }
      if (struct.isSetProvinceId()) {
        oprot.writeI32(struct.provinceId);
      }
      if (struct.isSetProjectSecondId()) {
        oprot.writeI32(struct.projectSecondId);
      }
    }

    @Override
    public void read(org.apache.thrift.protocol.TProtocol prot, IntelligentExerciseSubject struct) throws TException {
      TTupleProtocol iprot = (TTupleProtocol) prot;
      BitSet incoming = iprot.readBitSet(7);
      if (incoming.get(0)) {
        struct.subjectId = iprot.readI32();
        struct.setSubjectIdIsSet(true);
      }
      if (incoming.get(1)) {
        struct.subjectName = iprot.readString();
        struct.setSubjectNameIsSet(true);
      }
      if (incoming.get(2)) {
        struct.hasPassedUnitNum = iprot.readI32();
        struct.setHasPassedUnitNumIsSet(true);
      }
      if (incoming.get(3)) {
        struct.totalUnitNum = iprot.readI32();
        struct.setTotalUnitNumIsSet(true);
      }
      if (incoming.get(4)) {
        struct.moduleType = iprot.readString();
        struct.setModuleTypeIsSet(true);
      }
      if (incoming.get(5)) {
        struct.provinceId = iprot.readI32();
        struct.setProvinceIdIsSet(true);
      }
      if (incoming.get(6)) {
        struct.projectSecondId = iprot.readI32();
        struct.setProjectSecondIdIsSet(true);
      }
    }
  }

}
