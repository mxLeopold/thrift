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
public class TeacherInfo implements org.apache.thrift.TBase<TeacherInfo, TeacherInfo._Fields>, java.io.Serializable, Cloneable, Comparable<TeacherInfo> {
  private static final org.apache.thrift.protocol.TStruct STRUCT_DESC = new org.apache.thrift.protocol.TStruct("TeacherInfo");

  private static final org.apache.thrift.protocol.TField PHONE_FIELD_DESC = new org.apache.thrift.protocol.TField("phone", org.apache.thrift.protocol.TType.STRING, (short)1);
  private static final org.apache.thrift.protocol.TField NAME_FIELD_DESC = new org.apache.thrift.protocol.TField("name", org.apache.thrift.protocol.TType.STRING, (short)2);
  private static final org.apache.thrift.protocol.TField FAMILY_ID_FIELD_DESC = new org.apache.thrift.protocol.TField("familyId", org.apache.thrift.protocol.TType.I32, (short)3);
  private static final org.apache.thrift.protocol.TField FAMILY_NAME_FIELD_DESC = new org.apache.thrift.protocol.TField("familyName", org.apache.thrift.protocol.TType.STRING, (short)4);
  private static final org.apache.thrift.protocol.TField COLLEGE_ID_FIELD_DESC = new org.apache.thrift.protocol.TField("collegeId", org.apache.thrift.protocol.TType.I32, (short)5);
  private static final org.apache.thrift.protocol.TField COLLEGE_NAME_FIELD_DESC = new org.apache.thrift.protocol.TField("collegeName", org.apache.thrift.protocol.TType.STRING, (short)6);
  private static final org.apache.thrift.protocol.TField EMAIL_FIELD_DESC = new org.apache.thrift.protocol.TField("email", org.apache.thrift.protocol.TType.STRING, (short)7);
  private static final org.apache.thrift.protocol.TField AVATAR_FIELD_DESC = new org.apache.thrift.protocol.TField("avatar", org.apache.thrift.protocol.TType.STRING, (short)8);

  private static final Map<Class<? extends IScheme>, SchemeFactory> schemes = new HashMap<Class<? extends IScheme>, SchemeFactory>();
  static {
    schemes.put(StandardScheme.class, new TeacherInfoStandardSchemeFactory());
    schemes.put(TupleScheme.class, new TeacherInfoTupleSchemeFactory());
  }

  public String phone; // required
  public String name; // required
  public int familyId; // required
  public String familyName; // required
  public int collegeId; // required
  public String collegeName; // required
  public String email; // required
  public String avatar; // required

  /** The set of fields this struct contains, along with convenience methods for finding and manipulating them. */
  public enum _Fields implements org.apache.thrift.TFieldIdEnum {
    PHONE((short)1, "phone"),
    NAME((short)2, "name"),
    FAMILY_ID((short)3, "familyId"),
    FAMILY_NAME((short)4, "familyName"),
    COLLEGE_ID((short)5, "collegeId"),
    COLLEGE_NAME((short)6, "collegeName"),
    EMAIL((short)7, "email"),
    AVATAR((short)8, "avatar");

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
        case 1: // PHONE
          return PHONE;
        case 2: // NAME
          return NAME;
        case 3: // FAMILY_ID
          return FAMILY_ID;
        case 4: // FAMILY_NAME
          return FAMILY_NAME;
        case 5: // COLLEGE_ID
          return COLLEGE_ID;
        case 6: // COLLEGE_NAME
          return COLLEGE_NAME;
        case 7: // EMAIL
          return EMAIL;
        case 8: // AVATAR
          return AVATAR;
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
  private static final int __FAMILYID_ISSET_ID = 0;
  private static final int __COLLEGEID_ISSET_ID = 1;
  private byte __isset_bitfield = 0;
  public static final Map<_Fields, org.apache.thrift.meta_data.FieldMetaData> metaDataMap;
  static {
    Map<_Fields, org.apache.thrift.meta_data.FieldMetaData> tmpMap = new EnumMap<_Fields, org.apache.thrift.meta_data.FieldMetaData>(_Fields.class);
    tmpMap.put(_Fields.PHONE, new org.apache.thrift.meta_data.FieldMetaData("phone", org.apache.thrift.TFieldRequirementType.DEFAULT, 
        new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.STRING)));
    tmpMap.put(_Fields.NAME, new org.apache.thrift.meta_data.FieldMetaData("name", org.apache.thrift.TFieldRequirementType.DEFAULT, 
        new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.STRING)));
    tmpMap.put(_Fields.FAMILY_ID, new org.apache.thrift.meta_data.FieldMetaData("familyId", org.apache.thrift.TFieldRequirementType.DEFAULT, 
        new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.I32)));
    tmpMap.put(_Fields.FAMILY_NAME, new org.apache.thrift.meta_data.FieldMetaData("familyName", org.apache.thrift.TFieldRequirementType.DEFAULT, 
        new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.STRING)));
    tmpMap.put(_Fields.COLLEGE_ID, new org.apache.thrift.meta_data.FieldMetaData("collegeId", org.apache.thrift.TFieldRequirementType.DEFAULT, 
        new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.I32)));
    tmpMap.put(_Fields.COLLEGE_NAME, new org.apache.thrift.meta_data.FieldMetaData("collegeName", org.apache.thrift.TFieldRequirementType.DEFAULT, 
        new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.STRING)));
    tmpMap.put(_Fields.EMAIL, new org.apache.thrift.meta_data.FieldMetaData("email", org.apache.thrift.TFieldRequirementType.DEFAULT, 
        new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.STRING)));
    tmpMap.put(_Fields.AVATAR, new org.apache.thrift.meta_data.FieldMetaData("avatar", org.apache.thrift.TFieldRequirementType.DEFAULT, 
        new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.STRING)));
    metaDataMap = Collections.unmodifiableMap(tmpMap);
    org.apache.thrift.meta_data.FieldMetaData.addStructMetaDataMap(TeacherInfo.class, metaDataMap);
  }

  public TeacherInfo() {
  }

  public TeacherInfo(
    String phone,
    String name,
    int familyId,
    String familyName,
    int collegeId,
    String collegeName,
    String email,
    String avatar)
  {
    this();
    this.phone = phone;
    this.name = name;
    this.familyId = familyId;
    setFamilyIdIsSet(true);
    this.familyName = familyName;
    this.collegeId = collegeId;
    setCollegeIdIsSet(true);
    this.collegeName = collegeName;
    this.email = email;
    this.avatar = avatar;
  }

  /**
   * Performs a deep copy on <i>other</i>.
   */
  public TeacherInfo(TeacherInfo other) {
    __isset_bitfield = other.__isset_bitfield;
    if (other.isSetPhone()) {
      this.phone = other.phone;
    }
    if (other.isSetName()) {
      this.name = other.name;
    }
    this.familyId = other.familyId;
    if (other.isSetFamilyName()) {
      this.familyName = other.familyName;
    }
    this.collegeId = other.collegeId;
    if (other.isSetCollegeName()) {
      this.collegeName = other.collegeName;
    }
    if (other.isSetEmail()) {
      this.email = other.email;
    }
    if (other.isSetAvatar()) {
      this.avatar = other.avatar;
    }
  }

  public TeacherInfo deepCopy() {
    return new TeacherInfo(this);
  }

  @Override
  public void clear() {
    this.phone = null;
    this.name = null;
    setFamilyIdIsSet(false);
    this.familyId = 0;
    this.familyName = null;
    setCollegeIdIsSet(false);
    this.collegeId = 0;
    this.collegeName = null;
    this.email = null;
    this.avatar = null;
  }

  public String getPhone() {
    return this.phone;
  }

  public TeacherInfo setPhone(String phone) {
    this.phone = phone;
    return this;
  }

  public void unsetPhone() {
    this.phone = null;
  }

  /** Returns true if field phone is set (has been assigned a value) and false otherwise */
  public boolean isSetPhone() {
    return this.phone != null;
  }

  public void setPhoneIsSet(boolean value) {
    if (!value) {
      this.phone = null;
    }
  }

  public String getName() {
    return this.name;
  }

  public TeacherInfo setName(String name) {
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

  public int getFamilyId() {
    return this.familyId;
  }

  public TeacherInfo setFamilyId(int familyId) {
    this.familyId = familyId;
    setFamilyIdIsSet(true);
    return this;
  }

  public void unsetFamilyId() {
    __isset_bitfield = EncodingUtils.clearBit(__isset_bitfield, __FAMILYID_ISSET_ID);
  }

  /** Returns true if field familyId is set (has been assigned a value) and false otherwise */
  public boolean isSetFamilyId() {
    return EncodingUtils.testBit(__isset_bitfield, __FAMILYID_ISSET_ID);
  }

  public void setFamilyIdIsSet(boolean value) {
    __isset_bitfield = EncodingUtils.setBit(__isset_bitfield, __FAMILYID_ISSET_ID, value);
  }

  public String getFamilyName() {
    return this.familyName;
  }

  public TeacherInfo setFamilyName(String familyName) {
    this.familyName = familyName;
    return this;
  }

  public void unsetFamilyName() {
    this.familyName = null;
  }

  /** Returns true if field familyName is set (has been assigned a value) and false otherwise */
  public boolean isSetFamilyName() {
    return this.familyName != null;
  }

  public void setFamilyNameIsSet(boolean value) {
    if (!value) {
      this.familyName = null;
    }
  }

  public int getCollegeId() {
    return this.collegeId;
  }

  public TeacherInfo setCollegeId(int collegeId) {
    this.collegeId = collegeId;
    setCollegeIdIsSet(true);
    return this;
  }

  public void unsetCollegeId() {
    __isset_bitfield = EncodingUtils.clearBit(__isset_bitfield, __COLLEGEID_ISSET_ID);
  }

  /** Returns true if field collegeId is set (has been assigned a value) and false otherwise */
  public boolean isSetCollegeId() {
    return EncodingUtils.testBit(__isset_bitfield, __COLLEGEID_ISSET_ID);
  }

  public void setCollegeIdIsSet(boolean value) {
    __isset_bitfield = EncodingUtils.setBit(__isset_bitfield, __COLLEGEID_ISSET_ID, value);
  }

  public String getCollegeName() {
    return this.collegeName;
  }

  public TeacherInfo setCollegeName(String collegeName) {
    this.collegeName = collegeName;
    return this;
  }

  public void unsetCollegeName() {
    this.collegeName = null;
  }

  /** Returns true if field collegeName is set (has been assigned a value) and false otherwise */
  public boolean isSetCollegeName() {
    return this.collegeName != null;
  }

  public void setCollegeNameIsSet(boolean value) {
    if (!value) {
      this.collegeName = null;
    }
  }

  public String getEmail() {
    return this.email;
  }

  public TeacherInfo setEmail(String email) {
    this.email = email;
    return this;
  }

  public void unsetEmail() {
    this.email = null;
  }

  /** Returns true if field email is set (has been assigned a value) and false otherwise */
  public boolean isSetEmail() {
    return this.email != null;
  }

  public void setEmailIsSet(boolean value) {
    if (!value) {
      this.email = null;
    }
  }

  public String getAvatar() {
    return this.avatar;
  }

  public TeacherInfo setAvatar(String avatar) {
    this.avatar = avatar;
    return this;
  }

  public void unsetAvatar() {
    this.avatar = null;
  }

  /** Returns true if field avatar is set (has been assigned a value) and false otherwise */
  public boolean isSetAvatar() {
    return this.avatar != null;
  }

  public void setAvatarIsSet(boolean value) {
    if (!value) {
      this.avatar = null;
    }
  }

  public void setFieldValue(_Fields field, Object value) {
    switch (field) {
    case PHONE:
      if (value == null) {
        unsetPhone();
      } else {
        setPhone((String)value);
      }
      break;

    case NAME:
      if (value == null) {
        unsetName();
      } else {
        setName((String)value);
      }
      break;

    case FAMILY_ID:
      if (value == null) {
        unsetFamilyId();
      } else {
        setFamilyId((Integer)value);
      }
      break;

    case FAMILY_NAME:
      if (value == null) {
        unsetFamilyName();
      } else {
        setFamilyName((String)value);
      }
      break;

    case COLLEGE_ID:
      if (value == null) {
        unsetCollegeId();
      } else {
        setCollegeId((Integer)value);
      }
      break;

    case COLLEGE_NAME:
      if (value == null) {
        unsetCollegeName();
      } else {
        setCollegeName((String)value);
      }
      break;

    case EMAIL:
      if (value == null) {
        unsetEmail();
      } else {
        setEmail((String)value);
      }
      break;

    case AVATAR:
      if (value == null) {
        unsetAvatar();
      } else {
        setAvatar((String)value);
      }
      break;

    }
  }

  public Object getFieldValue(_Fields field) {
    switch (field) {
    case PHONE:
      return getPhone();

    case NAME:
      return getName();

    case FAMILY_ID:
      return getFamilyId();

    case FAMILY_NAME:
      return getFamilyName();

    case COLLEGE_ID:
      return getCollegeId();

    case COLLEGE_NAME:
      return getCollegeName();

    case EMAIL:
      return getEmail();

    case AVATAR:
      return getAvatar();

    }
    throw new IllegalStateException();
  }

  /** Returns true if field corresponding to fieldID is set (has been assigned a value) and false otherwise */
  public boolean isSet(_Fields field) {
    if (field == null) {
      throw new IllegalArgumentException();
    }

    switch (field) {
    case PHONE:
      return isSetPhone();
    case NAME:
      return isSetName();
    case FAMILY_ID:
      return isSetFamilyId();
    case FAMILY_NAME:
      return isSetFamilyName();
    case COLLEGE_ID:
      return isSetCollegeId();
    case COLLEGE_NAME:
      return isSetCollegeName();
    case EMAIL:
      return isSetEmail();
    case AVATAR:
      return isSetAvatar();
    }
    throw new IllegalStateException();
  }

  @Override
  public boolean equals(Object that) {
    if (that == null)
      return false;
    if (that instanceof TeacherInfo)
      return this.equals((TeacherInfo)that);
    return false;
  }

  public boolean equals(TeacherInfo that) {
    if (that == null)
      return false;

    boolean this_present_phone = true && this.isSetPhone();
    boolean that_present_phone = true && that.isSetPhone();
    if (this_present_phone || that_present_phone) {
      if (!(this_present_phone && that_present_phone))
        return false;
      if (!this.phone.equals(that.phone))
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

    boolean this_present_familyId = true;
    boolean that_present_familyId = true;
    if (this_present_familyId || that_present_familyId) {
      if (!(this_present_familyId && that_present_familyId))
        return false;
      if (this.familyId != that.familyId)
        return false;
    }

    boolean this_present_familyName = true && this.isSetFamilyName();
    boolean that_present_familyName = true && that.isSetFamilyName();
    if (this_present_familyName || that_present_familyName) {
      if (!(this_present_familyName && that_present_familyName))
        return false;
      if (!this.familyName.equals(that.familyName))
        return false;
    }

    boolean this_present_collegeId = true;
    boolean that_present_collegeId = true;
    if (this_present_collegeId || that_present_collegeId) {
      if (!(this_present_collegeId && that_present_collegeId))
        return false;
      if (this.collegeId != that.collegeId)
        return false;
    }

    boolean this_present_collegeName = true && this.isSetCollegeName();
    boolean that_present_collegeName = true && that.isSetCollegeName();
    if (this_present_collegeName || that_present_collegeName) {
      if (!(this_present_collegeName && that_present_collegeName))
        return false;
      if (!this.collegeName.equals(that.collegeName))
        return false;
    }

    boolean this_present_email = true && this.isSetEmail();
    boolean that_present_email = true && that.isSetEmail();
    if (this_present_email || that_present_email) {
      if (!(this_present_email && that_present_email))
        return false;
      if (!this.email.equals(that.email))
        return false;
    }

    boolean this_present_avatar = true && this.isSetAvatar();
    boolean that_present_avatar = true && that.isSetAvatar();
    if (this_present_avatar || that_present_avatar) {
      if (!(this_present_avatar && that_present_avatar))
        return false;
      if (!this.avatar.equals(that.avatar))
        return false;
    }

    return true;
  }

  @Override
  public int hashCode() {
    List<Object> list = new ArrayList<Object>();

    boolean present_phone = true && (isSetPhone());
    list.add(present_phone);
    if (present_phone)
      list.add(phone);

    boolean present_name = true && (isSetName());
    list.add(present_name);
    if (present_name)
      list.add(name);

    boolean present_familyId = true;
    list.add(present_familyId);
    if (present_familyId)
      list.add(familyId);

    boolean present_familyName = true && (isSetFamilyName());
    list.add(present_familyName);
    if (present_familyName)
      list.add(familyName);

    boolean present_collegeId = true;
    list.add(present_collegeId);
    if (present_collegeId)
      list.add(collegeId);

    boolean present_collegeName = true && (isSetCollegeName());
    list.add(present_collegeName);
    if (present_collegeName)
      list.add(collegeName);

    boolean present_email = true && (isSetEmail());
    list.add(present_email);
    if (present_email)
      list.add(email);

    boolean present_avatar = true && (isSetAvatar());
    list.add(present_avatar);
    if (present_avatar)
      list.add(avatar);

    return list.hashCode();
  }

  @Override
  public int compareTo(TeacherInfo other) {
    if (!getClass().equals(other.getClass())) {
      return getClass().getName().compareTo(other.getClass().getName());
    }

    int lastComparison = 0;

    lastComparison = Boolean.valueOf(isSetPhone()).compareTo(other.isSetPhone());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetPhone()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.phone, other.phone);
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
    lastComparison = Boolean.valueOf(isSetFamilyId()).compareTo(other.isSetFamilyId());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetFamilyId()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.familyId, other.familyId);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    lastComparison = Boolean.valueOf(isSetFamilyName()).compareTo(other.isSetFamilyName());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetFamilyName()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.familyName, other.familyName);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    lastComparison = Boolean.valueOf(isSetCollegeId()).compareTo(other.isSetCollegeId());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetCollegeId()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.collegeId, other.collegeId);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    lastComparison = Boolean.valueOf(isSetCollegeName()).compareTo(other.isSetCollegeName());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetCollegeName()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.collegeName, other.collegeName);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    lastComparison = Boolean.valueOf(isSetEmail()).compareTo(other.isSetEmail());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetEmail()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.email, other.email);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    lastComparison = Boolean.valueOf(isSetAvatar()).compareTo(other.isSetAvatar());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetAvatar()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.avatar, other.avatar);
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
    StringBuilder sb = new StringBuilder("TeacherInfo(");
    boolean first = true;

    sb.append("phone:");
    if (this.phone == null) {
      sb.append("null");
    } else {
      sb.append(this.phone);
    }
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
    sb.append("familyId:");
    sb.append(this.familyId);
    first = false;
    if (!first) sb.append(", ");
    sb.append("familyName:");
    if (this.familyName == null) {
      sb.append("null");
    } else {
      sb.append(this.familyName);
    }
    first = false;
    if (!first) sb.append(", ");
    sb.append("collegeId:");
    sb.append(this.collegeId);
    first = false;
    if (!first) sb.append(", ");
    sb.append("collegeName:");
    if (this.collegeName == null) {
      sb.append("null");
    } else {
      sb.append(this.collegeName);
    }
    first = false;
    if (!first) sb.append(", ");
    sb.append("email:");
    if (this.email == null) {
      sb.append("null");
    } else {
      sb.append(this.email);
    }
    first = false;
    if (!first) sb.append(", ");
    sb.append("avatar:");
    if (this.avatar == null) {
      sb.append("null");
    } else {
      sb.append(this.avatar);
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

  private static class TeacherInfoStandardSchemeFactory implements SchemeFactory {
    public TeacherInfoStandardScheme getScheme() {
      return new TeacherInfoStandardScheme();
    }
  }

  private static class TeacherInfoStandardScheme extends StandardScheme<TeacherInfo> {

    public void read(org.apache.thrift.protocol.TProtocol iprot, TeacherInfo struct) throws TException {
      org.apache.thrift.protocol.TField schemeField;
      iprot.readStructBegin();
      while (true)
      {
        schemeField = iprot.readFieldBegin();
        if (schemeField.type == org.apache.thrift.protocol.TType.STOP) {
          break;
        }
        switch (schemeField.id) {
          case 1: // PHONE
            if (schemeField.type == org.apache.thrift.protocol.TType.STRING) {
              struct.phone = iprot.readString();
              struct.setPhoneIsSet(true);
            } else {
              org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
            }
            break;
          case 2: // NAME
            if (schemeField.type == org.apache.thrift.protocol.TType.STRING) {
              struct.name = iprot.readString();
              struct.setNameIsSet(true);
            } else {
              org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
            }
            break;
          case 3: // FAMILY_ID
            if (schemeField.type == org.apache.thrift.protocol.TType.I32) {
              struct.familyId = iprot.readI32();
              struct.setFamilyIdIsSet(true);
            } else {
              org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
            }
            break;
          case 4: // FAMILY_NAME
            if (schemeField.type == org.apache.thrift.protocol.TType.STRING) {
              struct.familyName = iprot.readString();
              struct.setFamilyNameIsSet(true);
            } else {
              org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
            }
            break;
          case 5: // COLLEGE_ID
            if (schemeField.type == org.apache.thrift.protocol.TType.I32) {
              struct.collegeId = iprot.readI32();
              struct.setCollegeIdIsSet(true);
            } else {
              org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
            }
            break;
          case 6: // COLLEGE_NAME
            if (schemeField.type == org.apache.thrift.protocol.TType.STRING) {
              struct.collegeName = iprot.readString();
              struct.setCollegeNameIsSet(true);
            } else {
              org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
            }
            break;
          case 7: // EMAIL
            if (schemeField.type == org.apache.thrift.protocol.TType.STRING) {
              struct.email = iprot.readString();
              struct.setEmailIsSet(true);
            } else {
              org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
            }
            break;
          case 8: // AVATAR
            if (schemeField.type == org.apache.thrift.protocol.TType.STRING) {
              struct.avatar = iprot.readString();
              struct.setAvatarIsSet(true);
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

    public void write(org.apache.thrift.protocol.TProtocol oprot, TeacherInfo struct) throws TException {
      struct.validate();

      oprot.writeStructBegin(STRUCT_DESC);
      if (struct.phone != null) {
        oprot.writeFieldBegin(PHONE_FIELD_DESC);
        oprot.writeString(struct.phone);
        oprot.writeFieldEnd();
      }
      if (struct.name != null) {
        oprot.writeFieldBegin(NAME_FIELD_DESC);
        oprot.writeString(struct.name);
        oprot.writeFieldEnd();
      }
      oprot.writeFieldBegin(FAMILY_ID_FIELD_DESC);
      oprot.writeI32(struct.familyId);
      oprot.writeFieldEnd();
      if (struct.familyName != null) {
        oprot.writeFieldBegin(FAMILY_NAME_FIELD_DESC);
        oprot.writeString(struct.familyName);
        oprot.writeFieldEnd();
      }
      oprot.writeFieldBegin(COLLEGE_ID_FIELD_DESC);
      oprot.writeI32(struct.collegeId);
      oprot.writeFieldEnd();
      if (struct.collegeName != null) {
        oprot.writeFieldBegin(COLLEGE_NAME_FIELD_DESC);
        oprot.writeString(struct.collegeName);
        oprot.writeFieldEnd();
      }
      if (struct.email != null) {
        oprot.writeFieldBegin(EMAIL_FIELD_DESC);
        oprot.writeString(struct.email);
        oprot.writeFieldEnd();
      }
      if (struct.avatar != null) {
        oprot.writeFieldBegin(AVATAR_FIELD_DESC);
        oprot.writeString(struct.avatar);
        oprot.writeFieldEnd();
      }
      oprot.writeFieldStop();
      oprot.writeStructEnd();
    }

  }

  private static class TeacherInfoTupleSchemeFactory implements SchemeFactory {
    public TeacherInfoTupleScheme getScheme() {
      return new TeacherInfoTupleScheme();
    }
  }

  private static class TeacherInfoTupleScheme extends TupleScheme<TeacherInfo> {

    @Override
    public void write(org.apache.thrift.protocol.TProtocol prot, TeacherInfo struct) throws TException {
      TTupleProtocol oprot = (TTupleProtocol) prot;
      BitSet optionals = new BitSet();
      if (struct.isSetPhone()) {
        optionals.set(0);
      }
      if (struct.isSetName()) {
        optionals.set(1);
      }
      if (struct.isSetFamilyId()) {
        optionals.set(2);
      }
      if (struct.isSetFamilyName()) {
        optionals.set(3);
      }
      if (struct.isSetCollegeId()) {
        optionals.set(4);
      }
      if (struct.isSetCollegeName()) {
        optionals.set(5);
      }
      if (struct.isSetEmail()) {
        optionals.set(6);
      }
      if (struct.isSetAvatar()) {
        optionals.set(7);
      }
      oprot.writeBitSet(optionals, 8);
      if (struct.isSetPhone()) {
        oprot.writeString(struct.phone);
      }
      if (struct.isSetName()) {
        oprot.writeString(struct.name);
      }
      if (struct.isSetFamilyId()) {
        oprot.writeI32(struct.familyId);
      }
      if (struct.isSetFamilyName()) {
        oprot.writeString(struct.familyName);
      }
      if (struct.isSetCollegeId()) {
        oprot.writeI32(struct.collegeId);
      }
      if (struct.isSetCollegeName()) {
        oprot.writeString(struct.collegeName);
      }
      if (struct.isSetEmail()) {
        oprot.writeString(struct.email);
      }
      if (struct.isSetAvatar()) {
        oprot.writeString(struct.avatar);
      }
    }

    @Override
    public void read(org.apache.thrift.protocol.TProtocol prot, TeacherInfo struct) throws TException {
      TTupleProtocol iprot = (TTupleProtocol) prot;
      BitSet incoming = iprot.readBitSet(8);
      if (incoming.get(0)) {
        struct.phone = iprot.readString();
        struct.setPhoneIsSet(true);
      }
      if (incoming.get(1)) {
        struct.name = iprot.readString();
        struct.setNameIsSet(true);
      }
      if (incoming.get(2)) {
        struct.familyId = iprot.readI32();
        struct.setFamilyIdIsSet(true);
      }
      if (incoming.get(3)) {
        struct.familyName = iprot.readString();
        struct.setFamilyNameIsSet(true);
      }
      if (incoming.get(4)) {
        struct.collegeId = iprot.readI32();
        struct.setCollegeIdIsSet(true);
      }
      if (incoming.get(5)) {
        struct.collegeName = iprot.readString();
        struct.setCollegeNameIsSet(true);
      }
      if (incoming.get(6)) {
        struct.email = iprot.readString();
        struct.setEmailIsSet(true);
      }
      if (incoming.get(7)) {
        struct.avatar = iprot.readString();
        struct.setAvatarIsSet(true);
      }
    }
  }

}
