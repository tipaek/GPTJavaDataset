/**
 * Autogenerated by Thrift Compiler (0.9.1)
 *
 * DO NOT EDIT UNLESS YOU ARE SURE THAT YOU KNOW WHAT YOU ARE DOING
 *  @generated
 */
package com.nercis.isscp.engine;

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
 * 1:string cpuVendor cpu制造商
 * 2:string cpuModel  cpu型号
 * 3:i32 cpuCores  cpu核心数
 * 4:i32 cpuMhz    cpu主频
 * 5:i32 memSize  内存大小
 * 6:i32 fsSize  文件系统大小
 */
public class Hardware implements org.apache.thrift.TBase<Hardware, Hardware._Fields>, java.io.Serializable, Cloneable, Comparable<Hardware> {
  private static final org.apache.thrift.protocol.TStruct STRUCT_DESC = new org.apache.thrift.protocol.TStruct("Hardware");

  private static final org.apache.thrift.protocol.TField CPU_VENDOR_FIELD_DESC = new org.apache.thrift.protocol.TField("cpuVendor", org.apache.thrift.protocol.TType.STRING, (short)1);
  private static final org.apache.thrift.protocol.TField CPU_MODEL_FIELD_DESC = new org.apache.thrift.protocol.TField("cpuModel", org.apache.thrift.protocol.TType.STRING, (short)2);
  private static final org.apache.thrift.protocol.TField CPU_CORES_FIELD_DESC = new org.apache.thrift.protocol.TField("cpuCores", org.apache.thrift.protocol.TType.I32, (short)3);
  private static final org.apache.thrift.protocol.TField CPU_MHZ_FIELD_DESC = new org.apache.thrift.protocol.TField("cpuMhz", org.apache.thrift.protocol.TType.I32, (short)4);
  private static final org.apache.thrift.protocol.TField MEM_SIZE_FIELD_DESC = new org.apache.thrift.protocol.TField("memSize", org.apache.thrift.protocol.TType.I32, (short)5);
  private static final org.apache.thrift.protocol.TField FS_SIZE_FIELD_DESC = new org.apache.thrift.protocol.TField("fsSize", org.apache.thrift.protocol.TType.I32, (short)6);

  private static final Map<Class<? extends IScheme>, SchemeFactory> schemes = new HashMap<Class<? extends IScheme>, SchemeFactory>();
  static {
    schemes.put(StandardScheme.class, new HardwareStandardSchemeFactory());
    schemes.put(TupleScheme.class, new HardwareTupleSchemeFactory());
  }

  public String cpuVendor; // required
  public String cpuModel; // required
  public int cpuCores; // required
  public int cpuMhz; // required
  public int memSize; // required
  public int fsSize; // required

  /** The set of fields this struct contains, along with convenience methods for finding and manipulating them. */
  public enum _Fields implements org.apache.thrift.TFieldIdEnum {
    CPU_VENDOR((short)1, "cpuVendor"),
    CPU_MODEL((short)2, "cpuModel"),
    CPU_CORES((short)3, "cpuCores"),
    CPU_MHZ((short)4, "cpuMhz"),
    MEM_SIZE((short)5, "memSize"),
    FS_SIZE((short)6, "fsSize");

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
        case 1: // CPU_VENDOR
          return CPU_VENDOR;
        case 2: // CPU_MODEL
          return CPU_MODEL;
        case 3: // CPU_CORES
          return CPU_CORES;
        case 4: // CPU_MHZ
          return CPU_MHZ;
        case 5: // MEM_SIZE
          return MEM_SIZE;
        case 6: // FS_SIZE
          return FS_SIZE;
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
  private static final int __CPUCORES_ISSET_ID = 0;
  private static final int __CPUMHZ_ISSET_ID = 1;
  private static final int __MEMSIZE_ISSET_ID = 2;
  private static final int __FSSIZE_ISSET_ID = 3;
  private byte __isset_bitfield = 0;
  public static final Map<_Fields, org.apache.thrift.meta_data.FieldMetaData> metaDataMap;
  static {
    Map<_Fields, org.apache.thrift.meta_data.FieldMetaData> tmpMap = new EnumMap<_Fields, org.apache.thrift.meta_data.FieldMetaData>(_Fields.class);
    tmpMap.put(_Fields.CPU_VENDOR, new org.apache.thrift.meta_data.FieldMetaData("cpuVendor", org.apache.thrift.TFieldRequirementType.DEFAULT, 
        new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.STRING)));
    tmpMap.put(_Fields.CPU_MODEL, new org.apache.thrift.meta_data.FieldMetaData("cpuModel", org.apache.thrift.TFieldRequirementType.DEFAULT, 
        new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.STRING)));
    tmpMap.put(_Fields.CPU_CORES, new org.apache.thrift.meta_data.FieldMetaData("cpuCores", org.apache.thrift.TFieldRequirementType.DEFAULT, 
        new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.I32)));
    tmpMap.put(_Fields.CPU_MHZ, new org.apache.thrift.meta_data.FieldMetaData("cpuMhz", org.apache.thrift.TFieldRequirementType.DEFAULT, 
        new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.I32)));
    tmpMap.put(_Fields.MEM_SIZE, new org.apache.thrift.meta_data.FieldMetaData("memSize", org.apache.thrift.TFieldRequirementType.DEFAULT, 
        new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.I32)));
    tmpMap.put(_Fields.FS_SIZE, new org.apache.thrift.meta_data.FieldMetaData("fsSize", org.apache.thrift.TFieldRequirementType.DEFAULT, 
        new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.I32)));
    metaDataMap = Collections.unmodifiableMap(tmpMap);
    org.apache.thrift.meta_data.FieldMetaData.addStructMetaDataMap(Hardware.class, metaDataMap);
  }

  public Hardware() {
  }

  public Hardware(
    String cpuVendor,
    String cpuModel,
    int cpuCores,
    int cpuMhz,
    int memSize,
    int fsSize)
  {
    this();
    this.cpuVendor = cpuVendor;
    this.cpuModel = cpuModel;
    this.cpuCores = cpuCores;
    setCpuCoresIsSet(true);
    this.cpuMhz = cpuMhz;
    setCpuMhzIsSet(true);
    this.memSize = memSize;
    setMemSizeIsSet(true);
    this.fsSize = fsSize;
    setFsSizeIsSet(true);
  }

  /**
   * Performs a deep copy on <i>other</i>.
   */
  public Hardware(Hardware other) {
    __isset_bitfield = other.__isset_bitfield;
    if (other.isSetCpuVendor()) {
      this.cpuVendor = other.cpuVendor;
    }
    if (other.isSetCpuModel()) {
      this.cpuModel = other.cpuModel;
    }
    this.cpuCores = other.cpuCores;
    this.cpuMhz = other.cpuMhz;
    this.memSize = other.memSize;
    this.fsSize = other.fsSize;
  }

  public Hardware deepCopy() {
    return new Hardware(this);
  }

  @Override
  public void clear() {
    this.cpuVendor = null;
    this.cpuModel = null;
    setCpuCoresIsSet(false);
    this.cpuCores = 0;
    setCpuMhzIsSet(false);
    this.cpuMhz = 0;
    setMemSizeIsSet(false);
    this.memSize = 0;
    setFsSizeIsSet(false);
    this.fsSize = 0;
  }

  public String getCpuVendor() {
    return this.cpuVendor;
  }

  public Hardware setCpuVendor(String cpuVendor) {
    this.cpuVendor = cpuVendor;
    return this;
  }

  public void unsetCpuVendor() {
    this.cpuVendor = null;
  }

  /** Returns true if field cpuVendor is set (has been assigned a value) and false otherwise */
  public boolean isSetCpuVendor() {
    return this.cpuVendor != null;
  }

  public void setCpuVendorIsSet(boolean value) {
    if (!value) {
      this.cpuVendor = null;
    }
  }

  public String getCpuModel() {
    return this.cpuModel;
  }

  public Hardware setCpuModel(String cpuModel) {
    this.cpuModel = cpuModel;
    return this;
  }

  public void unsetCpuModel() {
    this.cpuModel = null;
  }

  /** Returns true if field cpuModel is set (has been assigned a value) and false otherwise */
  public boolean isSetCpuModel() {
    return this.cpuModel != null;
  }

  public void setCpuModelIsSet(boolean value) {
    if (!value) {
      this.cpuModel = null;
    }
  }

  public int getCpuCores() {
    return this.cpuCores;
  }

  public Hardware setCpuCores(int cpuCores) {
    this.cpuCores = cpuCores;
    setCpuCoresIsSet(true);
    return this;
  }

  public void unsetCpuCores() {
    __isset_bitfield = EncodingUtils.clearBit(__isset_bitfield, __CPUCORES_ISSET_ID);
  }

  /** Returns true if field cpuCores is set (has been assigned a value) and false otherwise */
  public boolean isSetCpuCores() {
    return EncodingUtils.testBit(__isset_bitfield, __CPUCORES_ISSET_ID);
  }

  public void setCpuCoresIsSet(boolean value) {
    __isset_bitfield = EncodingUtils.setBit(__isset_bitfield, __CPUCORES_ISSET_ID, value);
  }

  public int getCpuMhz() {
    return this.cpuMhz;
  }

  public Hardware setCpuMhz(int cpuMhz) {
    this.cpuMhz = cpuMhz;
    setCpuMhzIsSet(true);
    return this;
  }

  public void unsetCpuMhz() {
    __isset_bitfield = EncodingUtils.clearBit(__isset_bitfield, __CPUMHZ_ISSET_ID);
  }

  /** Returns true if field cpuMhz is set (has been assigned a value) and false otherwise */
  public boolean isSetCpuMhz() {
    return EncodingUtils.testBit(__isset_bitfield, __CPUMHZ_ISSET_ID);
  }

  public void setCpuMhzIsSet(boolean value) {
    __isset_bitfield = EncodingUtils.setBit(__isset_bitfield, __CPUMHZ_ISSET_ID, value);
  }

  public int getMemSize() {
    return this.memSize;
  }

  public Hardware setMemSize(int memSize) {
    this.memSize = memSize;
    setMemSizeIsSet(true);
    return this;
  }

  public void unsetMemSize() {
    __isset_bitfield = EncodingUtils.clearBit(__isset_bitfield, __MEMSIZE_ISSET_ID);
  }

  /** Returns true if field memSize is set (has been assigned a value) and false otherwise */
  public boolean isSetMemSize() {
    return EncodingUtils.testBit(__isset_bitfield, __MEMSIZE_ISSET_ID);
  }

  public void setMemSizeIsSet(boolean value) {
    __isset_bitfield = EncodingUtils.setBit(__isset_bitfield, __MEMSIZE_ISSET_ID, value);
  }

  public int getFsSize() {
    return this.fsSize;
  }

  public Hardware setFsSize(int fsSize) {
    this.fsSize = fsSize;
    setFsSizeIsSet(true);
    return this;
  }

  public void unsetFsSize() {
    __isset_bitfield = EncodingUtils.clearBit(__isset_bitfield, __FSSIZE_ISSET_ID);
  }

  /** Returns true if field fsSize is set (has been assigned a value) and false otherwise */
  public boolean isSetFsSize() {
    return EncodingUtils.testBit(__isset_bitfield, __FSSIZE_ISSET_ID);
  }

  public void setFsSizeIsSet(boolean value) {
    __isset_bitfield = EncodingUtils.setBit(__isset_bitfield, __FSSIZE_ISSET_ID, value);
  }

  public void setFieldValue(_Fields field, Object value) {
    switch (field) {
    case CPU_VENDOR:
      if (value == null) {
        unsetCpuVendor();
      } else {
        setCpuVendor((String)value);
      }
      break;

    case CPU_MODEL:
      if (value == null) {
        unsetCpuModel();
      } else {
        setCpuModel((String)value);
      }
      break;

    case CPU_CORES:
      if (value == null) {
        unsetCpuCores();
      } else {
        setCpuCores((Integer)value);
      }
      break;

    case CPU_MHZ:
      if (value == null) {
        unsetCpuMhz();
      } else {
        setCpuMhz((Integer)value);
      }
      break;

    case MEM_SIZE:
      if (value == null) {
        unsetMemSize();
      } else {
        setMemSize((Integer)value);
      }
      break;

    case FS_SIZE:
      if (value == null) {
        unsetFsSize();
      } else {
        setFsSize((Integer)value);
      }
      break;

    }
  }

  public Object getFieldValue(_Fields field) {
    switch (field) {
    case CPU_VENDOR:
      return getCpuVendor();

    case CPU_MODEL:
      return getCpuModel();

    case CPU_CORES:
      return Integer.valueOf(getCpuCores());

    case CPU_MHZ:
      return Integer.valueOf(getCpuMhz());

    case MEM_SIZE:
      return Integer.valueOf(getMemSize());

    case FS_SIZE:
      return Integer.valueOf(getFsSize());

    }
    throw new IllegalStateException();
  }

  /** Returns true if field corresponding to fieldID is set (has been assigned a value) and false otherwise */
  public boolean isSet(_Fields field) {
    if (field == null) {
      throw new IllegalArgumentException();
    }

    switch (field) {
    case CPU_VENDOR:
      return isSetCpuVendor();
    case CPU_MODEL:
      return isSetCpuModel();
    case CPU_CORES:
      return isSetCpuCores();
    case CPU_MHZ:
      return isSetCpuMhz();
    case MEM_SIZE:
      return isSetMemSize();
    case FS_SIZE:
      return isSetFsSize();
    }
    throw new IllegalStateException();
  }

  @Override
  public boolean equals(Object that) {
    if (that == null)
      return false;
    if (that instanceof Hardware)
      return this.equals((Hardware)that);
    return false;
  }

  public boolean equals(Hardware that) {
    if (that == null)
      return false;

    boolean this_present_cpuVendor = true && this.isSetCpuVendor();
    boolean that_present_cpuVendor = true && that.isSetCpuVendor();
    if (this_present_cpuVendor || that_present_cpuVendor) {
      if (!(this_present_cpuVendor && that_present_cpuVendor))
        return false;
      if (!this.cpuVendor.equals(that.cpuVendor))
        return false;
    }

    boolean this_present_cpuModel = true && this.isSetCpuModel();
    boolean that_present_cpuModel = true && that.isSetCpuModel();
    if (this_present_cpuModel || that_present_cpuModel) {
      if (!(this_present_cpuModel && that_present_cpuModel))
        return false;
      if (!this.cpuModel.equals(that.cpuModel))
        return false;
    }

    boolean this_present_cpuCores = true;
    boolean that_present_cpuCores = true;
    if (this_present_cpuCores || that_present_cpuCores) {
      if (!(this_present_cpuCores && that_present_cpuCores))
        return false;
      if (this.cpuCores != that.cpuCores)
        return false;
    }

    boolean this_present_cpuMhz = true;
    boolean that_present_cpuMhz = true;
    if (this_present_cpuMhz || that_present_cpuMhz) {
      if (!(this_present_cpuMhz && that_present_cpuMhz))
        return false;
      if (this.cpuMhz != that.cpuMhz)
        return false;
    }

    boolean this_present_memSize = true;
    boolean that_present_memSize = true;
    if (this_present_memSize || that_present_memSize) {
      if (!(this_present_memSize && that_present_memSize))
        return false;
      if (this.memSize != that.memSize)
        return false;
    }

    boolean this_present_fsSize = true;
    boolean that_present_fsSize = true;
    if (this_present_fsSize || that_present_fsSize) {
      if (!(this_present_fsSize && that_present_fsSize))
        return false;
      if (this.fsSize != that.fsSize)
        return false;
    }

    return true;
  }

  @Override
  public int hashCode() {
    return 0;
  }

  @Override
  public int compareTo(Hardware other) {
    if (!getClass().equals(other.getClass())) {
      return getClass().getName().compareTo(other.getClass().getName());
    }

    int lastComparison = 0;

    lastComparison = Boolean.valueOf(isSetCpuVendor()).compareTo(other.isSetCpuVendor());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetCpuVendor()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.cpuVendor, other.cpuVendor);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    lastComparison = Boolean.valueOf(isSetCpuModel()).compareTo(other.isSetCpuModel());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetCpuModel()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.cpuModel, other.cpuModel);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    lastComparison = Boolean.valueOf(isSetCpuCores()).compareTo(other.isSetCpuCores());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetCpuCores()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.cpuCores, other.cpuCores);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    lastComparison = Boolean.valueOf(isSetCpuMhz()).compareTo(other.isSetCpuMhz());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetCpuMhz()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.cpuMhz, other.cpuMhz);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    lastComparison = Boolean.valueOf(isSetMemSize()).compareTo(other.isSetMemSize());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetMemSize()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.memSize, other.memSize);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    lastComparison = Boolean.valueOf(isSetFsSize()).compareTo(other.isSetFsSize());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetFsSize()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.fsSize, other.fsSize);
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
    StringBuilder sb = new StringBuilder("Hardware(");
    boolean first = true;

    sb.append("cpuVendor:");
    if (this.cpuVendor == null) {
      sb.append("null");
    } else {
      sb.append(this.cpuVendor);
    }
    first = false;
    if (!first) sb.append(", ");
    sb.append("cpuModel:");
    if (this.cpuModel == null) {
      sb.append("null");
    } else {
      sb.append(this.cpuModel);
    }
    first = false;
    if (!first) sb.append(", ");
    sb.append("cpuCores:");
    sb.append(this.cpuCores);
    first = false;
    if (!first) sb.append(", ");
    sb.append("cpuMhz:");
    sb.append(this.cpuMhz);
    first = false;
    if (!first) sb.append(", ");
    sb.append("memSize:");
    sb.append(this.memSize);
    first = false;
    if (!first) sb.append(", ");
    sb.append("fsSize:");
    sb.append(this.fsSize);
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

  private static class HardwareStandardSchemeFactory implements SchemeFactory {
    public HardwareStandardScheme getScheme() {
      return new HardwareStandardScheme();
    }
  }

  private static class HardwareStandardScheme extends StandardScheme<Hardware> {

    public void read(org.apache.thrift.protocol.TProtocol iprot, Hardware struct) throws org.apache.thrift.TException {
      org.apache.thrift.protocol.TField schemeField;
      iprot.readStructBegin();
      while (true)
      {
        schemeField = iprot.readFieldBegin();
        if (schemeField.type == org.apache.thrift.protocol.TType.STOP) { 
          break;
        }
        switch (schemeField.id) {
          case 1: // CPU_VENDOR
            if (schemeField.type == org.apache.thrift.protocol.TType.STRING) {
              struct.cpuVendor = iprot.readString();
              struct.setCpuVendorIsSet(true);
            } else { 
              org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
            }
            break;
          case 2: // CPU_MODEL
            if (schemeField.type == org.apache.thrift.protocol.TType.STRING) {
              struct.cpuModel = iprot.readString();
              struct.setCpuModelIsSet(true);
            } else { 
              org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
            }
            break;
          case 3: // CPU_CORES
            if (schemeField.type == org.apache.thrift.protocol.TType.I32) {
              struct.cpuCores = iprot.readI32();
              struct.setCpuCoresIsSet(true);
            } else { 
              org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
            }
            break;
          case 4: // CPU_MHZ
            if (schemeField.type == org.apache.thrift.protocol.TType.I32) {
              struct.cpuMhz = iprot.readI32();
              struct.setCpuMhzIsSet(true);
            } else { 
              org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
            }
            break;
          case 5: // MEM_SIZE
            if (schemeField.type == org.apache.thrift.protocol.TType.I32) {
              struct.memSize = iprot.readI32();
              struct.setMemSizeIsSet(true);
            } else { 
              org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
            }
            break;
          case 6: // FS_SIZE
            if (schemeField.type == org.apache.thrift.protocol.TType.I32) {
              struct.fsSize = iprot.readI32();
              struct.setFsSizeIsSet(true);
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

    public void write(org.apache.thrift.protocol.TProtocol oprot, Hardware struct) throws org.apache.thrift.TException {
      struct.validate();

      oprot.writeStructBegin(STRUCT_DESC);
      if (struct.cpuVendor != null) {
        oprot.writeFieldBegin(CPU_VENDOR_FIELD_DESC);
        oprot.writeString(struct.cpuVendor);
        oprot.writeFieldEnd();
      }
      if (struct.cpuModel != null) {
        oprot.writeFieldBegin(CPU_MODEL_FIELD_DESC);
        oprot.writeString(struct.cpuModel);
        oprot.writeFieldEnd();
      }
      oprot.writeFieldBegin(CPU_CORES_FIELD_DESC);
      oprot.writeI32(struct.cpuCores);
      oprot.writeFieldEnd();
      oprot.writeFieldBegin(CPU_MHZ_FIELD_DESC);
      oprot.writeI32(struct.cpuMhz);
      oprot.writeFieldEnd();
      oprot.writeFieldBegin(MEM_SIZE_FIELD_DESC);
      oprot.writeI32(struct.memSize);
      oprot.writeFieldEnd();
      oprot.writeFieldBegin(FS_SIZE_FIELD_DESC);
      oprot.writeI32(struct.fsSize);
      oprot.writeFieldEnd();
      oprot.writeFieldStop();
      oprot.writeStructEnd();
    }

  }

  private static class HardwareTupleSchemeFactory implements SchemeFactory {
    public HardwareTupleScheme getScheme() {
      return new HardwareTupleScheme();
    }
  }

  private static class HardwareTupleScheme extends TupleScheme<Hardware> {

    @Override
    public void write(org.apache.thrift.protocol.TProtocol prot, Hardware struct) throws org.apache.thrift.TException {
      TTupleProtocol oprot = (TTupleProtocol) prot;
      BitSet optionals = new BitSet();
      if (struct.isSetCpuVendor()) {
        optionals.set(0);
      }
      if (struct.isSetCpuModel()) {
        optionals.set(1);
      }
      if (struct.isSetCpuCores()) {
        optionals.set(2);
      }
      if (struct.isSetCpuMhz()) {
        optionals.set(3);
      }
      if (struct.isSetMemSize()) {
        optionals.set(4);
      }
      if (struct.isSetFsSize()) {
        optionals.set(5);
      }
      oprot.writeBitSet(optionals, 6);
      if (struct.isSetCpuVendor()) {
        oprot.writeString(struct.cpuVendor);
      }
      if (struct.isSetCpuModel()) {
        oprot.writeString(struct.cpuModel);
      }
      if (struct.isSetCpuCores()) {
        oprot.writeI32(struct.cpuCores);
      }
      if (struct.isSetCpuMhz()) {
        oprot.writeI32(struct.cpuMhz);
      }
      if (struct.isSetMemSize()) {
        oprot.writeI32(struct.memSize);
      }
      if (struct.isSetFsSize()) {
        oprot.writeI32(struct.fsSize);
      }
    }

    @Override
    public void read(org.apache.thrift.protocol.TProtocol prot, Hardware struct) throws org.apache.thrift.TException {
      TTupleProtocol iprot = (TTupleProtocol) prot;
      BitSet incoming = iprot.readBitSet(6);
      if (incoming.get(0)) {
        struct.cpuVendor = iprot.readString();
        struct.setCpuVendorIsSet(true);
      }
      if (incoming.get(1)) {
        struct.cpuModel = iprot.readString();
        struct.setCpuModelIsSet(true);
      }
      if (incoming.get(2)) {
        struct.cpuCores = iprot.readI32();
        struct.setCpuCoresIsSet(true);
      }
      if (incoming.get(3)) {
        struct.cpuMhz = iprot.readI32();
        struct.setCpuMhzIsSet(true);
      }
      if (incoming.get(4)) {
        struct.memSize = iprot.readI32();
        struct.setMemSizeIsSet(true);
      }
      if (incoming.get(5)) {
        struct.fsSize = iprot.readI32();
        struct.setFsSizeIsSet(true);
      }
    }
  }

}

