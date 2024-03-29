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
 * 定义样本的数据结构
 * 1:missionId 任务批号
 * 2:userAppId 用户应用ID
 * 3:plotsStatus 检测策略（动|静|病毒） (已定义的数据结构)
 * 4:checkStartTime 检测开始时间
 * 5:checkStopTime 预测结束时间
 */
public class Sample implements org.apache.thrift.TBase<Sample, Sample._Fields>, java.io.Serializable, Cloneable, Comparable<Sample> {
  private static final org.apache.thrift.protocol.TStruct STRUCT_DESC = new org.apache.thrift.protocol.TStruct("Sample");

  private static final org.apache.thrift.protocol.TField MISSION_ID_FIELD_DESC = new org.apache.thrift.protocol.TField("missionId", org.apache.thrift.protocol.TType.STRING, (short)1);
  private static final org.apache.thrift.protocol.TField USER_APP_ID_FIELD_DESC = new org.apache.thrift.protocol.TField("userAppId", org.apache.thrift.protocol.TType.STRING, (short)2);
  private static final org.apache.thrift.protocol.TField PLOTS_STATUS_FIELD_DESC = new org.apache.thrift.protocol.TField("plotsStatus", org.apache.thrift.protocol.TType.MAP, (short)3);
  private static final org.apache.thrift.protocol.TField CHECK_START_TIME_FIELD_DESC = new org.apache.thrift.protocol.TField("checkStartTime", org.apache.thrift.protocol.TType.STRING, (short)4);
  private static final org.apache.thrift.protocol.TField CHECK_STOP_TIME_FIELD_DESC = new org.apache.thrift.protocol.TField("checkStopTime", org.apache.thrift.protocol.TType.STRING, (short)5);

  private static final Map<Class<? extends IScheme>, SchemeFactory> schemes = new HashMap<Class<? extends IScheme>, SchemeFactory>();
  static {
    schemes.put(StandardScheme.class, new SampleStandardSchemeFactory());
    schemes.put(TupleScheme.class, new SampleTupleSchemeFactory());
  }

  public String missionId; // required
  public String userAppId; // required
  public Map<PlotsType,CheckResultStatus> plotsStatus; // required
  public String checkStartTime; // required
  public String checkStopTime; // required

  /** The set of fields this struct contains, along with convenience methods for finding and manipulating them. */
  public enum _Fields implements org.apache.thrift.TFieldIdEnum {
    MISSION_ID((short)1, "missionId"),
    USER_APP_ID((short)2, "userAppId"),
    PLOTS_STATUS((short)3, "plotsStatus"),
    CHECK_START_TIME((short)4, "checkStartTime"),
    CHECK_STOP_TIME((short)5, "checkStopTime");

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
        case 1: // MISSION_ID
          return MISSION_ID;
        case 2: // USER_APP_ID
          return USER_APP_ID;
        case 3: // PLOTS_STATUS
          return PLOTS_STATUS;
        case 4: // CHECK_START_TIME
          return CHECK_START_TIME;
        case 5: // CHECK_STOP_TIME
          return CHECK_STOP_TIME;
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
    tmpMap.put(_Fields.MISSION_ID, new org.apache.thrift.meta_data.FieldMetaData("missionId", org.apache.thrift.TFieldRequirementType.DEFAULT, 
        new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.STRING)));
    tmpMap.put(_Fields.USER_APP_ID, new org.apache.thrift.meta_data.FieldMetaData("userAppId", org.apache.thrift.TFieldRequirementType.DEFAULT, 
        new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.STRING)));
    tmpMap.put(_Fields.PLOTS_STATUS, new org.apache.thrift.meta_data.FieldMetaData("plotsStatus", org.apache.thrift.TFieldRequirementType.DEFAULT, 
        new org.apache.thrift.meta_data.MapMetaData(org.apache.thrift.protocol.TType.MAP, 
            new org.apache.thrift.meta_data.EnumMetaData(org.apache.thrift.protocol.TType.ENUM, PlotsType.class), 
            new org.apache.thrift.meta_data.EnumMetaData(org.apache.thrift.protocol.TType.ENUM, CheckResultStatus.class))));
    tmpMap.put(_Fields.CHECK_START_TIME, new org.apache.thrift.meta_data.FieldMetaData("checkStartTime", org.apache.thrift.TFieldRequirementType.DEFAULT, 
        new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.STRING)));
    tmpMap.put(_Fields.CHECK_STOP_TIME, new org.apache.thrift.meta_data.FieldMetaData("checkStopTime", org.apache.thrift.TFieldRequirementType.DEFAULT, 
        new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.STRING)));
    metaDataMap = Collections.unmodifiableMap(tmpMap);
    org.apache.thrift.meta_data.FieldMetaData.addStructMetaDataMap(Sample.class, metaDataMap);
  }

  public Sample() {
  }

  public Sample(
    String missionId,
    String userAppId,
    Map<PlotsType,CheckResultStatus> plotsStatus,
    String checkStartTime,
    String checkStopTime)
  {
    this();
    this.missionId = missionId;
    this.userAppId = userAppId;
    this.plotsStatus = plotsStatus;
    this.checkStartTime = checkStartTime;
    this.checkStopTime = checkStopTime;
  }

  /**
   * Performs a deep copy on <i>other</i>.
   */
  public Sample(Sample other) {
    if (other.isSetMissionId()) {
      this.missionId = other.missionId;
    }
    if (other.isSetUserAppId()) {
      this.userAppId = other.userAppId;
    }
    if (other.isSetPlotsStatus()) {
      Map<PlotsType,CheckResultStatus> __this__plotsStatus = new HashMap<PlotsType,CheckResultStatus>(other.plotsStatus.size());
      for (Map.Entry<PlotsType, CheckResultStatus> other_element : other.plotsStatus.entrySet()) {

        PlotsType other_element_key = other_element.getKey();
        CheckResultStatus other_element_value = other_element.getValue();

        PlotsType __this__plotsStatus_copy_key = other_element_key;

        CheckResultStatus __this__plotsStatus_copy_value = other_element_value;

        __this__plotsStatus.put(__this__plotsStatus_copy_key, __this__plotsStatus_copy_value);
      }
      this.plotsStatus = __this__plotsStatus;
    }
    if (other.isSetCheckStartTime()) {
      this.checkStartTime = other.checkStartTime;
    }
    if (other.isSetCheckStopTime()) {
      this.checkStopTime = other.checkStopTime;
    }
  }

  public Sample deepCopy() {
    return new Sample(this);
  }

  @Override
  public void clear() {
    this.missionId = null;
    this.userAppId = null;
    this.plotsStatus = null;
    this.checkStartTime = null;
    this.checkStopTime = null;
  }

  public String getMissionId() {
    return this.missionId;
  }

  public Sample setMissionId(String missionId) {
    this.missionId = missionId;
    return this;
  }

  public void unsetMissionId() {
    this.missionId = null;
  }

  /** Returns true if field missionId is set (has been assigned a value) and false otherwise */
  public boolean isSetMissionId() {
    return this.missionId != null;
  }

  public void setMissionIdIsSet(boolean value) {
    if (!value) {
      this.missionId = null;
    }
  }

  public String getUserAppId() {
    return this.userAppId;
  }

  public Sample setUserAppId(String userAppId) {
    this.userAppId = userAppId;
    return this;
  }

  public void unsetUserAppId() {
    this.userAppId = null;
  }

  /** Returns true if field userAppId is set (has been assigned a value) and false otherwise */
  public boolean isSetUserAppId() {
    return this.userAppId != null;
  }

  public void setUserAppIdIsSet(boolean value) {
    if (!value) {
      this.userAppId = null;
    }
  }

  public int getPlotsStatusSize() {
    return (this.plotsStatus == null) ? 0 : this.plotsStatus.size();
  }

  public void putToPlotsStatus(PlotsType key, CheckResultStatus val) {
    if (this.plotsStatus == null) {
      this.plotsStatus = new HashMap<PlotsType,CheckResultStatus>();
    }
    this.plotsStatus.put(key, val);
  }

  public Map<PlotsType,CheckResultStatus> getPlotsStatus() {
    return this.plotsStatus;
  }

  public Sample setPlotsStatus(Map<PlotsType,CheckResultStatus> plotsStatus) {
    this.plotsStatus = plotsStatus;
    return this;
  }

  public void unsetPlotsStatus() {
    this.plotsStatus = null;
  }

  /** Returns true if field plotsStatus is set (has been assigned a value) and false otherwise */
  public boolean isSetPlotsStatus() {
    return this.plotsStatus != null;
  }

  public void setPlotsStatusIsSet(boolean value) {
    if (!value) {
      this.plotsStatus = null;
    }
  }

  public String getCheckStartTime() {
    return this.checkStartTime;
  }

  public Sample setCheckStartTime(String checkStartTime) {
    this.checkStartTime = checkStartTime;
    return this;
  }

  public void unsetCheckStartTime() {
    this.checkStartTime = null;
  }

  /** Returns true if field checkStartTime is set (has been assigned a value) and false otherwise */
  public boolean isSetCheckStartTime() {
    return this.checkStartTime != null;
  }

  public void setCheckStartTimeIsSet(boolean value) {
    if (!value) {
      this.checkStartTime = null;
    }
  }

  public String getCheckStopTime() {
    return this.checkStopTime;
  }

  public Sample setCheckStopTime(String checkStopTime) {
    this.checkStopTime = checkStopTime;
    return this;
  }

  public void unsetCheckStopTime() {
    this.checkStopTime = null;
  }

  /** Returns true if field checkStopTime is set (has been assigned a value) and false otherwise */
  public boolean isSetCheckStopTime() {
    return this.checkStopTime != null;
  }

  public void setCheckStopTimeIsSet(boolean value) {
    if (!value) {
      this.checkStopTime = null;
    }
  }

  public void setFieldValue(_Fields field, Object value) {
    switch (field) {
    case MISSION_ID:
      if (value == null) {
        unsetMissionId();
      } else {
        setMissionId((String)value);
      }
      break;

    case USER_APP_ID:
      if (value == null) {
        unsetUserAppId();
      } else {
        setUserAppId((String)value);
      }
      break;

    case PLOTS_STATUS:
      if (value == null) {
        unsetPlotsStatus();
      } else {
        setPlotsStatus((Map<PlotsType,CheckResultStatus>)value);
      }
      break;

    case CHECK_START_TIME:
      if (value == null) {
        unsetCheckStartTime();
      } else {
        setCheckStartTime((String)value);
      }
      break;

    case CHECK_STOP_TIME:
      if (value == null) {
        unsetCheckStopTime();
      } else {
        setCheckStopTime((String)value);
      }
      break;

    }
  }

  public Object getFieldValue(_Fields field) {
    switch (field) {
    case MISSION_ID:
      return getMissionId();

    case USER_APP_ID:
      return getUserAppId();

    case PLOTS_STATUS:
      return getPlotsStatus();

    case CHECK_START_TIME:
      return getCheckStartTime();

    case CHECK_STOP_TIME:
      return getCheckStopTime();

    }
    throw new IllegalStateException();
  }

  /** Returns true if field corresponding to fieldID is set (has been assigned a value) and false otherwise */
  public boolean isSet(_Fields field) {
    if (field == null) {
      throw new IllegalArgumentException();
    }

    switch (field) {
    case MISSION_ID:
      return isSetMissionId();
    case USER_APP_ID:
      return isSetUserAppId();
    case PLOTS_STATUS:
      return isSetPlotsStatus();
    case CHECK_START_TIME:
      return isSetCheckStartTime();
    case CHECK_STOP_TIME:
      return isSetCheckStopTime();
    }
    throw new IllegalStateException();
  }

  @Override
  public boolean equals(Object that) {
    if (that == null)
      return false;
    if (that instanceof Sample)
      return this.equals((Sample)that);
    return false;
  }

  public boolean equals(Sample that) {
    if (that == null)
      return false;

    boolean this_present_missionId = true && this.isSetMissionId();
    boolean that_present_missionId = true && that.isSetMissionId();
    if (this_present_missionId || that_present_missionId) {
      if (!(this_present_missionId && that_present_missionId))
        return false;
      if (!this.missionId.equals(that.missionId))
        return false;
    }

    boolean this_present_userAppId = true && this.isSetUserAppId();
    boolean that_present_userAppId = true && that.isSetUserAppId();
    if (this_present_userAppId || that_present_userAppId) {
      if (!(this_present_userAppId && that_present_userAppId))
        return false;
      if (!this.userAppId.equals(that.userAppId))
        return false;
    }

    boolean this_present_plotsStatus = true && this.isSetPlotsStatus();
    boolean that_present_plotsStatus = true && that.isSetPlotsStatus();
    if (this_present_plotsStatus || that_present_plotsStatus) {
      if (!(this_present_plotsStatus && that_present_plotsStatus))
        return false;
      if (!this.plotsStatus.equals(that.plotsStatus))
        return false;
    }

    boolean this_present_checkStartTime = true && this.isSetCheckStartTime();
    boolean that_present_checkStartTime = true && that.isSetCheckStartTime();
    if (this_present_checkStartTime || that_present_checkStartTime) {
      if (!(this_present_checkStartTime && that_present_checkStartTime))
        return false;
      if (!this.checkStartTime.equals(that.checkStartTime))
        return false;
    }

    boolean this_present_checkStopTime = true && this.isSetCheckStopTime();
    boolean that_present_checkStopTime = true && that.isSetCheckStopTime();
    if (this_present_checkStopTime || that_present_checkStopTime) {
      if (!(this_present_checkStopTime && that_present_checkStopTime))
        return false;
      if (!this.checkStopTime.equals(that.checkStopTime))
        return false;
    }

    return true;
  }

  @Override
  public int hashCode() {
    return 0;
  }

  @Override
  public int compareTo(Sample other) {
    if (!getClass().equals(other.getClass())) {
      return getClass().getName().compareTo(other.getClass().getName());
    }

    int lastComparison = 0;

    lastComparison = Boolean.valueOf(isSetMissionId()).compareTo(other.isSetMissionId());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetMissionId()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.missionId, other.missionId);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    lastComparison = Boolean.valueOf(isSetUserAppId()).compareTo(other.isSetUserAppId());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetUserAppId()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.userAppId, other.userAppId);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    lastComparison = Boolean.valueOf(isSetPlotsStatus()).compareTo(other.isSetPlotsStatus());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetPlotsStatus()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.plotsStatus, other.plotsStatus);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    lastComparison = Boolean.valueOf(isSetCheckStartTime()).compareTo(other.isSetCheckStartTime());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetCheckStartTime()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.checkStartTime, other.checkStartTime);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    lastComparison = Boolean.valueOf(isSetCheckStopTime()).compareTo(other.isSetCheckStopTime());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetCheckStopTime()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.checkStopTime, other.checkStopTime);
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
    StringBuilder sb = new StringBuilder("Sample(");
    boolean first = true;

    sb.append("missionId:");
    if (this.missionId == null) {
      sb.append("null");
    } else {
      sb.append(this.missionId);
    }
    first = false;
    if (!first) sb.append(", ");
    sb.append("userAppId:");
    if (this.userAppId == null) {
      sb.append("null");
    } else {
      sb.append(this.userAppId);
    }
    first = false;
    if (!first) sb.append(", ");
    sb.append("plotsStatus:");
    if (this.plotsStatus == null) {
      sb.append("null");
    } else {
      sb.append(this.plotsStatus);
    }
    first = false;
    if (!first) sb.append(", ");
    sb.append("checkStartTime:");
    if (this.checkStartTime == null) {
      sb.append("null");
    } else {
      sb.append(this.checkStartTime);
    }
    first = false;
    if (!first) sb.append(", ");
    sb.append("checkStopTime:");
    if (this.checkStopTime == null) {
      sb.append("null");
    } else {
      sb.append(this.checkStopTime);
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

  private static class SampleStandardSchemeFactory implements SchemeFactory {
    public SampleStandardScheme getScheme() {
      return new SampleStandardScheme();
    }
  }

  private static class SampleStandardScheme extends StandardScheme<Sample> {

    public void read(org.apache.thrift.protocol.TProtocol iprot, Sample struct) throws org.apache.thrift.TException {
      org.apache.thrift.protocol.TField schemeField;
      iprot.readStructBegin();
      while (true)
      {
        schemeField = iprot.readFieldBegin();
        if (schemeField.type == org.apache.thrift.protocol.TType.STOP) { 
          break;
        }
        switch (schemeField.id) {
          case 1: // MISSION_ID
            if (schemeField.type == org.apache.thrift.protocol.TType.STRING) {
              struct.missionId = iprot.readString();
              struct.setMissionIdIsSet(true);
            } else { 
              org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
            }
            break;
          case 2: // USER_APP_ID
            if (schemeField.type == org.apache.thrift.protocol.TType.STRING) {
              struct.userAppId = iprot.readString();
              struct.setUserAppIdIsSet(true);
            } else { 
              org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
            }
            break;
          case 3: // PLOTS_STATUS
            if (schemeField.type == org.apache.thrift.protocol.TType.MAP) {
              {
                org.apache.thrift.protocol.TMap _map80 = iprot.readMapBegin();
                struct.plotsStatus = new HashMap<PlotsType,CheckResultStatus>(2*_map80.size);
                for (int _i81 = 0; _i81 < _map80.size; ++_i81)
                {
                  PlotsType _key82;
                  CheckResultStatus _val83;
                  _key82 = PlotsType.findByValue(iprot.readI32());
                  _val83 = CheckResultStatus.findByValue(iprot.readI32());
                  struct.plotsStatus.put(_key82, _val83);
                }
                iprot.readMapEnd();
              }
              struct.setPlotsStatusIsSet(true);
            } else { 
              org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
            }
            break;
          case 4: // CHECK_START_TIME
            if (schemeField.type == org.apache.thrift.protocol.TType.STRING) {
              struct.checkStartTime = iprot.readString();
              struct.setCheckStartTimeIsSet(true);
            } else { 
              org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
            }
            break;
          case 5: // CHECK_STOP_TIME
            if (schemeField.type == org.apache.thrift.protocol.TType.STRING) {
              struct.checkStopTime = iprot.readString();
              struct.setCheckStopTimeIsSet(true);
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

    public void write(org.apache.thrift.protocol.TProtocol oprot, Sample struct) throws org.apache.thrift.TException {
      struct.validate();

      oprot.writeStructBegin(STRUCT_DESC);
      if (struct.missionId != null) {
        oprot.writeFieldBegin(MISSION_ID_FIELD_DESC);
        oprot.writeString(struct.missionId);
        oprot.writeFieldEnd();
      }
      if (struct.userAppId != null) {
        oprot.writeFieldBegin(USER_APP_ID_FIELD_DESC);
        oprot.writeString(struct.userAppId);
        oprot.writeFieldEnd();
      }
      if (struct.plotsStatus != null) {
        oprot.writeFieldBegin(PLOTS_STATUS_FIELD_DESC);
        {
          oprot.writeMapBegin(new org.apache.thrift.protocol.TMap(org.apache.thrift.protocol.TType.I32, org.apache.thrift.protocol.TType.I32, struct.plotsStatus.size()));
          for (Map.Entry<PlotsType, CheckResultStatus> _iter84 : struct.plotsStatus.entrySet())
          {
            oprot.writeI32(_iter84.getKey().getValue());
            oprot.writeI32(_iter84.getValue().getValue());
          }
          oprot.writeMapEnd();
        }
        oprot.writeFieldEnd();
      }
      if (struct.checkStartTime != null) {
        oprot.writeFieldBegin(CHECK_START_TIME_FIELD_DESC);
        oprot.writeString(struct.checkStartTime);
        oprot.writeFieldEnd();
      }
      if (struct.checkStopTime != null) {
        oprot.writeFieldBegin(CHECK_STOP_TIME_FIELD_DESC);
        oprot.writeString(struct.checkStopTime);
        oprot.writeFieldEnd();
      }
      oprot.writeFieldStop();
      oprot.writeStructEnd();
    }

  }

  private static class SampleTupleSchemeFactory implements SchemeFactory {
    public SampleTupleScheme getScheme() {
      return new SampleTupleScheme();
    }
  }

  private static class SampleTupleScheme extends TupleScheme<Sample> {

    @Override
    public void write(org.apache.thrift.protocol.TProtocol prot, Sample struct) throws org.apache.thrift.TException {
      TTupleProtocol oprot = (TTupleProtocol) prot;
      BitSet optionals = new BitSet();
      if (struct.isSetMissionId()) {
        optionals.set(0);
      }
      if (struct.isSetUserAppId()) {
        optionals.set(1);
      }
      if (struct.isSetPlotsStatus()) {
        optionals.set(2);
      }
      if (struct.isSetCheckStartTime()) {
        optionals.set(3);
      }
      if (struct.isSetCheckStopTime()) {
        optionals.set(4);
      }
      oprot.writeBitSet(optionals, 5);
      if (struct.isSetMissionId()) {
        oprot.writeString(struct.missionId);
      }
      if (struct.isSetUserAppId()) {
        oprot.writeString(struct.userAppId);
      }
      if (struct.isSetPlotsStatus()) {
        {
          oprot.writeI32(struct.plotsStatus.size());
          for (Map.Entry<PlotsType, CheckResultStatus> _iter85 : struct.plotsStatus.entrySet())
          {
            oprot.writeI32(_iter85.getKey().getValue());
            oprot.writeI32(_iter85.getValue().getValue());
          }
        }
      }
      if (struct.isSetCheckStartTime()) {
        oprot.writeString(struct.checkStartTime);
      }
      if (struct.isSetCheckStopTime()) {
        oprot.writeString(struct.checkStopTime);
      }
    }

    @Override
    public void read(org.apache.thrift.protocol.TProtocol prot, Sample struct) throws org.apache.thrift.TException {
      TTupleProtocol iprot = (TTupleProtocol) prot;
      BitSet incoming = iprot.readBitSet(5);
      if (incoming.get(0)) {
        struct.missionId = iprot.readString();
        struct.setMissionIdIsSet(true);
      }
      if (incoming.get(1)) {
        struct.userAppId = iprot.readString();
        struct.setUserAppIdIsSet(true);
      }
      if (incoming.get(2)) {
        {
          org.apache.thrift.protocol.TMap _map86 = new org.apache.thrift.protocol.TMap(org.apache.thrift.protocol.TType.I32, org.apache.thrift.protocol.TType.I32, iprot.readI32());
          struct.plotsStatus = new HashMap<PlotsType,CheckResultStatus>(2*_map86.size);
          for (int _i87 = 0; _i87 < _map86.size; ++_i87)
          {
            PlotsType _key88;
            CheckResultStatus _val89;
            _key88 = PlotsType.findByValue(iprot.readI32());
            _val89 = CheckResultStatus.findByValue(iprot.readI32());
            struct.plotsStatus.put(_key88, _val89);
          }
        }
        struct.setPlotsStatusIsSet(true);
      }
      if (incoming.get(3)) {
        struct.checkStartTime = iprot.readString();
        struct.setCheckStartTimeIsSet(true);
      }
      if (incoming.get(4)) {
        struct.checkStopTime = iprot.readString();
        struct.setCheckStopTimeIsSet(true);
      }
    }
  }

}

