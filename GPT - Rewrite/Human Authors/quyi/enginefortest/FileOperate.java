/**
 * Autogenerated by Thrift Compiler (0.9.1)
 *
 * DO NOT EDIT UNLESS YOU ARE SURE THAT YOU KNOW WHAT YOU ARE DOING
 *  @generated
 */
package com.nercis.isscp.idl;

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
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 定义动态检测文件操作记录
 * 1:string pidName 进程编号
 * 2:string fileDescription 进程描述/文件描述
 * 3:string filePath 文件路径
 * 4:string operateContent 操作内容
 * 5:string operateTime 操作时间
 * 6:string operateType 操作类型
 */
public class FileOperate implements org.apache.thrift.TBase<FileOperate, FileOperate._Fields>, java.io.Serializable, Cloneable, Comparable<FileOperate> {
  private static final org.apache.thrift.protocol.TStruct STRUCT_DESC = new org.apache.thrift.protocol.TStruct("FileOperate");

  private static final org.apache.thrift.protocol.TField PID_NAME_FIELD_DESC = new org.apache.thrift.protocol.TField("pidName", org.apache.thrift.protocol.TType.STRING, (short)1);
  private static final org.apache.thrift.protocol.TField FILE_DESCRIPTION_FIELD_DESC = new org.apache.thrift.protocol.TField("fileDescription", org.apache.thrift.protocol.TType.STRING, (short)2);
  private static final org.apache.thrift.protocol.TField FILE_PATH_FIELD_DESC = new org.apache.thrift.protocol.TField("filePath", org.apache.thrift.protocol.TType.STRING, (short)3);
  private static final org.apache.thrift.protocol.TField OPERATE_CONTENT_FIELD_DESC = new org.apache.thrift.protocol.TField("operateContent", org.apache.thrift.protocol.TType.STRING, (short)4);
  private static final org.apache.thrift.protocol.TField OPERATE_TIME_FIELD_DESC = new org.apache.thrift.protocol.TField("operateTime", org.apache.thrift.protocol.TType.STRING, (short)5);
  private static final org.apache.thrift.protocol.TField OPERATE_TYPE_FIELD_DESC = new org.apache.thrift.protocol.TField("operateType", org.apache.thrift.protocol.TType.STRING, (short)6);

  private static final Map<Class<? extends IScheme>, SchemeFactory> schemes = new HashMap<Class<? extends IScheme>, SchemeFactory>();
  static {
    schemes.put(StandardScheme.class, new FileOperateStandardSchemeFactory());
    schemes.put(TupleScheme.class, new FileOperateTupleSchemeFactory());
  }

  public String pidName; // required
  public String fileDescription; // required
  public String filePath; // required
  public String operateContent; // required
  public String operateTime; // required
  public String operateType; // required

  /** The set of fields this struct contains, along with convenience methods for finding and manipulating them. */
  public enum _Fields implements org.apache.thrift.TFieldIdEnum {
    PID_NAME((short)1, "pidName"),
    FILE_DESCRIPTION((short)2, "fileDescription"),
    FILE_PATH((short)3, "filePath"),
    OPERATE_CONTENT((short)4, "operateContent"),
    OPERATE_TIME((short)5, "operateTime"),
    OPERATE_TYPE((short)6, "operateType");

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
        case 1: // PID_NAME
          return PID_NAME;
        case 2: // FILE_DESCRIPTION
          return FILE_DESCRIPTION;
        case 3: // FILE_PATH
          return FILE_PATH;
        case 4: // OPERATE_CONTENT
          return OPERATE_CONTENT;
        case 5: // OPERATE_TIME
          return OPERATE_TIME;
        case 6: // OPERATE_TYPE
          return OPERATE_TYPE;
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
    tmpMap.put(_Fields.PID_NAME, new org.apache.thrift.meta_data.FieldMetaData("pidName", org.apache.thrift.TFieldRequirementType.DEFAULT, 
        new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.STRING)));
    tmpMap.put(_Fields.FILE_DESCRIPTION, new org.apache.thrift.meta_data.FieldMetaData("fileDescription", org.apache.thrift.TFieldRequirementType.DEFAULT, 
        new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.STRING)));
    tmpMap.put(_Fields.FILE_PATH, new org.apache.thrift.meta_data.FieldMetaData("filePath", org.apache.thrift.TFieldRequirementType.DEFAULT, 
        new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.STRING)));
    tmpMap.put(_Fields.OPERATE_CONTENT, new org.apache.thrift.meta_data.FieldMetaData("operateContent", org.apache.thrift.TFieldRequirementType.DEFAULT, 
        new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.STRING)));
    tmpMap.put(_Fields.OPERATE_TIME, new org.apache.thrift.meta_data.FieldMetaData("operateTime", org.apache.thrift.TFieldRequirementType.DEFAULT, 
        new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.STRING)));
    tmpMap.put(_Fields.OPERATE_TYPE, new org.apache.thrift.meta_data.FieldMetaData("operateType", org.apache.thrift.TFieldRequirementType.DEFAULT, 
        new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.STRING)));
    metaDataMap = Collections.unmodifiableMap(tmpMap);
    org.apache.thrift.meta_data.FieldMetaData.addStructMetaDataMap(FileOperate.class, metaDataMap);
  }

  public FileOperate() {
  }

  public FileOperate(
    String pidName,
    String fileDescription,
    String filePath,
    String operateContent,
    String operateTime,
    String operateType)
  {
    this();
    this.pidName = pidName;
    this.fileDescription = fileDescription;
    this.filePath = filePath;
    this.operateContent = operateContent;
    this.operateTime = operateTime;
    this.operateType = operateType;
  }

  /**
   * Performs a deep copy on <i>other</i>.
   */
  public FileOperate(FileOperate other) {
    if (other.isSetPidName()) {
      this.pidName = other.pidName;
    }
    if (other.isSetFileDescription()) {
      this.fileDescription = other.fileDescription;
    }
    if (other.isSetFilePath()) {
      this.filePath = other.filePath;
    }
    if (other.isSetOperateContent()) {
      this.operateContent = other.operateContent;
    }
    if (other.isSetOperateTime()) {
      this.operateTime = other.operateTime;
    }
    if (other.isSetOperateType()) {
      this.operateType = other.operateType;
    }
  }

  public FileOperate deepCopy() {
    return new FileOperate(this);
  }

  @Override
  public void clear() {
    this.pidName = null;
    this.fileDescription = null;
    this.filePath = null;
    this.operateContent = null;
    this.operateTime = null;
    this.operateType = null;
  }

  public String getPidName() {
    return this.pidName;
  }

  public FileOperate setPidName(String pidName) {
    this.pidName = pidName;
    return this;
  }

  public void unsetPidName() {
    this.pidName = null;
  }

  /** Returns true if field pidName is set (has been assigned a value) and false otherwise */
  public boolean isSetPidName() {
    return this.pidName != null;
  }

  public void setPidNameIsSet(boolean value) {
    if (!value) {
      this.pidName = null;
    }
  }

  public String getFileDescription() {
    return this.fileDescription;
  }

  public FileOperate setFileDescription(String fileDescription) {
    this.fileDescription = fileDescription;
    return this;
  }

  public void unsetFileDescription() {
    this.fileDescription = null;
  }

  /** Returns true if field fileDescription is set (has been assigned a value) and false otherwise */
  public boolean isSetFileDescription() {
    return this.fileDescription != null;
  }

  public void setFileDescriptionIsSet(boolean value) {
    if (!value) {
      this.fileDescription = null;
    }
  }

  public String getFilePath() {
    return this.filePath;
  }

  public FileOperate setFilePath(String filePath) {
    this.filePath = filePath;
    return this;
  }

  public void unsetFilePath() {
    this.filePath = null;
  }

  /** Returns true if field filePath is set (has been assigned a value) and false otherwise */
  public boolean isSetFilePath() {
    return this.filePath != null;
  }

  public void setFilePathIsSet(boolean value) {
    if (!value) {
      this.filePath = null;
    }
  }

  public String getOperateContent() {
    return this.operateContent;
  }

  public FileOperate setOperateContent(String operateContent) {
    this.operateContent = operateContent;
    return this;
  }

  public void unsetOperateContent() {
    this.operateContent = null;
  }

  /** Returns true if field operateContent is set (has been assigned a value) and false otherwise */
  public boolean isSetOperateContent() {
    return this.operateContent != null;
  }

  public void setOperateContentIsSet(boolean value) {
    if (!value) {
      this.operateContent = null;
    }
  }

  public String getOperateTime() {
    return this.operateTime;
  }

  public FileOperate setOperateTime(String operateTime) {
    this.operateTime = operateTime;
    return this;
  }

  public void unsetOperateTime() {
    this.operateTime = null;
  }

  /** Returns true if field operateTime is set (has been assigned a value) and false otherwise */
  public boolean isSetOperateTime() {
    return this.operateTime != null;
  }

  public void setOperateTimeIsSet(boolean value) {
    if (!value) {
      this.operateTime = null;
    }
  }

  public String getOperateType() {
    return this.operateType;
  }

  public FileOperate setOperateType(String operateType) {
    this.operateType = operateType;
    return this;
  }

  public void unsetOperateType() {
    this.operateType = null;
  }

  /** Returns true if field operateType is set (has been assigned a value) and false otherwise */
  public boolean isSetOperateType() {
    return this.operateType != null;
  }

  public void setOperateTypeIsSet(boolean value) {
    if (!value) {
      this.operateType = null;
    }
  }

  public void setFieldValue(_Fields field, Object value) {
    switch (field) {
    case PID_NAME:
      if (value == null) {
        unsetPidName();
      } else {
        setPidName((String)value);
      }
      break;

    case FILE_DESCRIPTION:
      if (value == null) {
        unsetFileDescription();
      } else {
        setFileDescription((String)value);
      }
      break;

    case FILE_PATH:
      if (value == null) {
        unsetFilePath();
      } else {
        setFilePath((String)value);
      }
      break;

    case OPERATE_CONTENT:
      if (value == null) {
        unsetOperateContent();
      } else {
        setOperateContent((String)value);
      }
      break;

    case OPERATE_TIME:
      if (value == null) {
        unsetOperateTime();
      } else {
        setOperateTime((String)value);
      }
      break;

    case OPERATE_TYPE:
      if (value == null) {
        unsetOperateType();
      } else {
        setOperateType((String)value);
      }
      break;

    }
  }

  public Object getFieldValue(_Fields field) {
    switch (field) {
    case PID_NAME:
      return getPidName();

    case FILE_DESCRIPTION:
      return getFileDescription();

    case FILE_PATH:
      return getFilePath();

    case OPERATE_CONTENT:
      return getOperateContent();

    case OPERATE_TIME:
      return getOperateTime();

    case OPERATE_TYPE:
      return getOperateType();

    }
    throw new IllegalStateException();
  }

  /** Returns true if field corresponding to fieldID is set (has been assigned a value) and false otherwise */
  public boolean isSet(_Fields field) {
    if (field == null) {
      throw new IllegalArgumentException();
    }

    switch (field) {
    case PID_NAME:
      return isSetPidName();
    case FILE_DESCRIPTION:
      return isSetFileDescription();
    case FILE_PATH:
      return isSetFilePath();
    case OPERATE_CONTENT:
      return isSetOperateContent();
    case OPERATE_TIME:
      return isSetOperateTime();
    case OPERATE_TYPE:
      return isSetOperateType();
    }
    throw new IllegalStateException();
  }

  @Override
  public boolean equals(Object that) {
    if (that == null)
      return false;
    if (that instanceof FileOperate)
      return this.equals((FileOperate)that);
    return false;
  }

  public boolean equals(FileOperate that) {
    if (that == null)
      return false;

    boolean this_present_pidName = true && this.isSetPidName();
    boolean that_present_pidName = true && that.isSetPidName();
    if (this_present_pidName || that_present_pidName) {
      if (!(this_present_pidName && that_present_pidName))
        return false;
      if (!this.pidName.equals(that.pidName))
        return false;
    }

    boolean this_present_fileDescription = true && this.isSetFileDescription();
    boolean that_present_fileDescription = true && that.isSetFileDescription();
    if (this_present_fileDescription || that_present_fileDescription) {
      if (!(this_present_fileDescription && that_present_fileDescription))
        return false;
      if (!this.fileDescription.equals(that.fileDescription))
        return false;
    }

    boolean this_present_filePath = true && this.isSetFilePath();
    boolean that_present_filePath = true && that.isSetFilePath();
    if (this_present_filePath || that_present_filePath) {
      if (!(this_present_filePath && that_present_filePath))
        return false;
      if (!this.filePath.equals(that.filePath))
        return false;
    }

    boolean this_present_operateContent = true && this.isSetOperateContent();
    boolean that_present_operateContent = true && that.isSetOperateContent();
    if (this_present_operateContent || that_present_operateContent) {
      if (!(this_present_operateContent && that_present_operateContent))
        return false;
      if (!this.operateContent.equals(that.operateContent))
        return false;
    }

    boolean this_present_operateTime = true && this.isSetOperateTime();
    boolean that_present_operateTime = true && that.isSetOperateTime();
    if (this_present_operateTime || that_present_operateTime) {
      if (!(this_present_operateTime && that_present_operateTime))
        return false;
      if (!this.operateTime.equals(that.operateTime))
        return false;
    }

    boolean this_present_operateType = true && this.isSetOperateType();
    boolean that_present_operateType = true && that.isSetOperateType();
    if (this_present_operateType || that_present_operateType) {
      if (!(this_present_operateType && that_present_operateType))
        return false;
      if (!this.operateType.equals(that.operateType))
        return false;
    }

    return true;
  }

  @Override
  public int hashCode() {
    return 0;
  }

  @Override
  public int compareTo(FileOperate other) {
    if (!getClass().equals(other.getClass())) {
      return getClass().getName().compareTo(other.getClass().getName());
    }

    int lastComparison = 0;

    lastComparison = Boolean.valueOf(isSetPidName()).compareTo(other.isSetPidName());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetPidName()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.pidName, other.pidName);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    lastComparison = Boolean.valueOf(isSetFileDescription()).compareTo(other.isSetFileDescription());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetFileDescription()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.fileDescription, other.fileDescription);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    lastComparison = Boolean.valueOf(isSetFilePath()).compareTo(other.isSetFilePath());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetFilePath()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.filePath, other.filePath);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    lastComparison = Boolean.valueOf(isSetOperateContent()).compareTo(other.isSetOperateContent());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetOperateContent()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.operateContent, other.operateContent);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    lastComparison = Boolean.valueOf(isSetOperateTime()).compareTo(other.isSetOperateTime());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetOperateTime()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.operateTime, other.operateTime);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    lastComparison = Boolean.valueOf(isSetOperateType()).compareTo(other.isSetOperateType());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetOperateType()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.operateType, other.operateType);
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
    StringBuilder sb = new StringBuilder("FileOperate(");
    boolean first = true;

    sb.append("pidName:");
    if (this.pidName == null) {
      sb.append("null");
    } else {
      sb.append(this.pidName);
    }
    first = false;
    if (!first) sb.append(", ");
    sb.append("fileDescription:");
    if (this.fileDescription == null) {
      sb.append("null");
    } else {
      sb.append(this.fileDescription);
    }
    first = false;
    if (!first) sb.append(", ");
    sb.append("filePath:");
    if (this.filePath == null) {
      sb.append("null");
    } else {
      sb.append(this.filePath);
    }
    first = false;
    if (!first) sb.append(", ");
    sb.append("operateContent:");
    if (this.operateContent == null) {
      sb.append("null");
    } else {
      sb.append(this.operateContent);
    }
    first = false;
    if (!first) sb.append(", ");
    sb.append("operateTime:");
    if (this.operateTime == null) {
      sb.append("null");
    } else {
      sb.append(this.operateTime);
    }
    first = false;
    if (!first) sb.append(", ");
    sb.append("operateType:");
    if (this.operateType == null) {
      sb.append("null");
    } else {
      sb.append(this.operateType);
    }
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
      read(new org.apache.thrift.protocol.TCompactProtocol(new org.apache.thrift.transport.TIOStreamTransport(in)));
    } catch (org.apache.thrift.TException te) {
      throw new java.io.IOException(te);
    }
  }

  private static class FileOperateStandardSchemeFactory implements SchemeFactory {
    public FileOperateStandardScheme getScheme() {
      return new FileOperateStandardScheme();
    }
  }

  private static class FileOperateStandardScheme extends StandardScheme<FileOperate> {

    public void read(org.apache.thrift.protocol.TProtocol iprot, FileOperate struct) throws org.apache.thrift.TException {
      org.apache.thrift.protocol.TField schemeField;
      iprot.readStructBegin();
      while (true)
      {
        schemeField = iprot.readFieldBegin();
        if (schemeField.type == org.apache.thrift.protocol.TType.STOP) { 
          break;
        }
        switch (schemeField.id) {
          case 1: // PID_NAME
            if (schemeField.type == org.apache.thrift.protocol.TType.STRING) {
              struct.pidName = iprot.readString();
              struct.setPidNameIsSet(true);
            } else { 
              org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
            }
            break;
          case 2: // FILE_DESCRIPTION
            if (schemeField.type == org.apache.thrift.protocol.TType.STRING) {
              struct.fileDescription = iprot.readString();
              struct.setFileDescriptionIsSet(true);
            } else { 
              org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
            }
            break;
          case 3: // FILE_PATH
            if (schemeField.type == org.apache.thrift.protocol.TType.STRING) {
              struct.filePath = iprot.readString();
              struct.setFilePathIsSet(true);
            } else { 
              org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
            }
            break;
          case 4: // OPERATE_CONTENT
            if (schemeField.type == org.apache.thrift.protocol.TType.STRING) {
              struct.operateContent = iprot.readString();
              struct.setOperateContentIsSet(true);
            } else { 
              org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
            }
            break;
          case 5: // OPERATE_TIME
            if (schemeField.type == org.apache.thrift.protocol.TType.STRING) {
              struct.operateTime = iprot.readString();
              struct.setOperateTimeIsSet(true);
            } else { 
              org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
            }
            break;
          case 6: // OPERATE_TYPE
            if (schemeField.type == org.apache.thrift.protocol.TType.STRING) {
              struct.operateType = iprot.readString();
              struct.setOperateTypeIsSet(true);
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

    public void write(org.apache.thrift.protocol.TProtocol oprot, FileOperate struct) throws org.apache.thrift.TException {
      struct.validate();

      oprot.writeStructBegin(STRUCT_DESC);
      if (struct.pidName != null) {
        oprot.writeFieldBegin(PID_NAME_FIELD_DESC);
        oprot.writeString(struct.pidName);
        oprot.writeFieldEnd();
      }
      if (struct.fileDescription != null) {
        oprot.writeFieldBegin(FILE_DESCRIPTION_FIELD_DESC);
        oprot.writeString(struct.fileDescription);
        oprot.writeFieldEnd();
      }
      if (struct.filePath != null) {
        oprot.writeFieldBegin(FILE_PATH_FIELD_DESC);
        oprot.writeString(struct.filePath);
        oprot.writeFieldEnd();
      }
      if (struct.operateContent != null) {
        oprot.writeFieldBegin(OPERATE_CONTENT_FIELD_DESC);
        oprot.writeString(struct.operateContent);
        oprot.writeFieldEnd();
      }
      if (struct.operateTime != null) {
        oprot.writeFieldBegin(OPERATE_TIME_FIELD_DESC);
        oprot.writeString(struct.operateTime);
        oprot.writeFieldEnd();
      }
      if (struct.operateType != null) {
        oprot.writeFieldBegin(OPERATE_TYPE_FIELD_DESC);
        oprot.writeString(struct.operateType);
        oprot.writeFieldEnd();
      }
      oprot.writeFieldStop();
      oprot.writeStructEnd();
    }

  }

  private static class FileOperateTupleSchemeFactory implements SchemeFactory {
    public FileOperateTupleScheme getScheme() {
      return new FileOperateTupleScheme();
    }
  }

  private static class FileOperateTupleScheme extends TupleScheme<FileOperate> {

    @Override
    public void write(org.apache.thrift.protocol.TProtocol prot, FileOperate struct) throws org.apache.thrift.TException {
      TTupleProtocol oprot = (TTupleProtocol) prot;
      BitSet optionals = new BitSet();
      if (struct.isSetPidName()) {
        optionals.set(0);
      }
      if (struct.isSetFileDescription()) {
        optionals.set(1);
      }
      if (struct.isSetFilePath()) {
        optionals.set(2);
      }
      if (struct.isSetOperateContent()) {
        optionals.set(3);
      }
      if (struct.isSetOperateTime()) {
        optionals.set(4);
      }
      if (struct.isSetOperateType()) {
        optionals.set(5);
      }
      oprot.writeBitSet(optionals, 6);
      if (struct.isSetPidName()) {
        oprot.writeString(struct.pidName);
      }
      if (struct.isSetFileDescription()) {
        oprot.writeString(struct.fileDescription);
      }
      if (struct.isSetFilePath()) {
        oprot.writeString(struct.filePath);
      }
      if (struct.isSetOperateContent()) {
        oprot.writeString(struct.operateContent);
      }
      if (struct.isSetOperateTime()) {
        oprot.writeString(struct.operateTime);
      }
      if (struct.isSetOperateType()) {
        oprot.writeString(struct.operateType);
      }
    }

    @Override
    public void read(org.apache.thrift.protocol.TProtocol prot, FileOperate struct) throws org.apache.thrift.TException {
      TTupleProtocol iprot = (TTupleProtocol) prot;
      BitSet incoming = iprot.readBitSet(6);
      if (incoming.get(0)) {
        struct.pidName = iprot.readString();
        struct.setPidNameIsSet(true);
      }
      if (incoming.get(1)) {
        struct.fileDescription = iprot.readString();
        struct.setFileDescriptionIsSet(true);
      }
      if (incoming.get(2)) {
        struct.filePath = iprot.readString();
        struct.setFilePathIsSet(true);
      }
      if (incoming.get(3)) {
        struct.operateContent = iprot.readString();
        struct.setOperateContentIsSet(true);
      }
      if (incoming.get(4)) {
        struct.operateTime = iprot.readString();
        struct.setOperateTimeIsSet(true);
      }
      if (incoming.get(5)) {
        struct.operateType = iprot.readString();
        struct.setOperateTypeIsSet(true);
      }
    }
  }

}

