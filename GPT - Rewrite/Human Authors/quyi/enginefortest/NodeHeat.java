/**
 * Autogenerated by Thrift Compiler (0.9.1)
 *
 * DO NOT EDIT UNLESS YOU ARE SURE THAT YOU KNOW WHAT YOU ARE DOING
 *  @generated
 */
package com.nercis.isscp.ts;

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
 * node 心跳数据结构
 * 1:string nodeId 引擎标示符
 * 2:double cpuUsedPerc  CPU使用量百分比
 * 3:double freeMem 空余内存 百分比
 * 4:double jvmFreeMem JVM剩余内存 百分比
 * 5:i32 taskQueueLimit 任务队列最大长度
 * 6:i32 taskQueueNume 任务队列中等待任务长度
 */
public class NodeHeat implements org.apache.thrift.TBase<NodeHeat, NodeHeat._Fields>, java.io.Serializable, Cloneable, Comparable<NodeHeat> {
  private static final org.apache.thrift.protocol.TStruct STRUCT_DESC = new org.apache.thrift.protocol.TStruct("NodeHeat");

  private static final org.apache.thrift.protocol.TField NODE_ID_FIELD_DESC = new org.apache.thrift.protocol.TField("nodeId", org.apache.thrift.protocol.TType.STRING, (short)1);
  private static final org.apache.thrift.protocol.TField CPU_USED_PERC_FIELD_DESC = new org.apache.thrift.protocol.TField("cpuUsedPerc", org.apache.thrift.protocol.TType.DOUBLE, (short)2);
  private static final org.apache.thrift.protocol.TField FREE_MEM_FIELD_DESC = new org.apache.thrift.protocol.TField("freeMem", org.apache.thrift.protocol.TType.DOUBLE, (short)3);
  private static final org.apache.thrift.protocol.TField JVM_FREE_MEM_FIELD_DESC = new org.apache.thrift.protocol.TField("jvmFreeMem", org.apache.thrift.protocol.TType.DOUBLE, (short)4);
  private static final org.apache.thrift.protocol.TField TASK_QUEUE_LIMIT_FIELD_DESC = new org.apache.thrift.protocol.TField("taskQueueLimit", org.apache.thrift.protocol.TType.I32, (short)5);
  private static final org.apache.thrift.protocol.TField TASK_QUEUE_NUME_FIELD_DESC = new org.apache.thrift.protocol.TField("taskQueueNume", org.apache.thrift.protocol.TType.I32, (short)6);

  private static final Map<Class<? extends IScheme>, SchemeFactory> schemes = new HashMap<Class<? extends IScheme>, SchemeFactory>();
  static {
    schemes.put(StandardScheme.class, new NodeHeatStandardSchemeFactory());
    schemes.put(TupleScheme.class, new NodeHeatTupleSchemeFactory());
  }

  public String nodeId; // required
  public double cpuUsedPerc; // required
  public double freeMem; // required
  public double jvmFreeMem; // required
  public int taskQueueLimit; // required
  public int taskQueueNume; // required

  /** The set of fields this struct contains, along with convenience methods for finding and manipulating them. */
  public enum _Fields implements org.apache.thrift.TFieldIdEnum {
    NODE_ID((short)1, "nodeId"),
    CPU_USED_PERC((short)2, "cpuUsedPerc"),
    FREE_MEM((short)3, "freeMem"),
    JVM_FREE_MEM((short)4, "jvmFreeMem"),
    TASK_QUEUE_LIMIT((short)5, "taskQueueLimit"),
    TASK_QUEUE_NUME((short)6, "taskQueueNume");

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
        case 1: // NODE_ID
          return NODE_ID;
        case 2: // CPU_USED_PERC
          return CPU_USED_PERC;
        case 3: // FREE_MEM
          return FREE_MEM;
        case 4: // JVM_FREE_MEM
          return JVM_FREE_MEM;
        case 5: // TASK_QUEUE_LIMIT
          return TASK_QUEUE_LIMIT;
        case 6: // TASK_QUEUE_NUME
          return TASK_QUEUE_NUME;
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
  private static final int __CPUUSEDPERC_ISSET_ID = 0;
  private static final int __FREEMEM_ISSET_ID = 1;
  private static final int __JVMFREEMEM_ISSET_ID = 2;
  private static final int __TASKQUEUELIMIT_ISSET_ID = 3;
  private static final int __TASKQUEUENUME_ISSET_ID = 4;
  private byte __isset_bitfield = 0;
  public static final Map<_Fields, org.apache.thrift.meta_data.FieldMetaData> metaDataMap;
  static {
    Map<_Fields, org.apache.thrift.meta_data.FieldMetaData> tmpMap = new EnumMap<_Fields, org.apache.thrift.meta_data.FieldMetaData>(_Fields.class);
    tmpMap.put(_Fields.NODE_ID, new org.apache.thrift.meta_data.FieldMetaData("nodeId", org.apache.thrift.TFieldRequirementType.DEFAULT, 
        new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.STRING)));
    tmpMap.put(_Fields.CPU_USED_PERC, new org.apache.thrift.meta_data.FieldMetaData("cpuUsedPerc", org.apache.thrift.TFieldRequirementType.DEFAULT, 
        new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.DOUBLE)));
    tmpMap.put(_Fields.FREE_MEM, new org.apache.thrift.meta_data.FieldMetaData("freeMem", org.apache.thrift.TFieldRequirementType.DEFAULT, 
        new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.DOUBLE)));
    tmpMap.put(_Fields.JVM_FREE_MEM, new org.apache.thrift.meta_data.FieldMetaData("jvmFreeMem", org.apache.thrift.TFieldRequirementType.DEFAULT, 
        new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.DOUBLE)));
    tmpMap.put(_Fields.TASK_QUEUE_LIMIT, new org.apache.thrift.meta_data.FieldMetaData("taskQueueLimit", org.apache.thrift.TFieldRequirementType.DEFAULT, 
        new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.I32)));
    tmpMap.put(_Fields.TASK_QUEUE_NUME, new org.apache.thrift.meta_data.FieldMetaData("taskQueueNume", org.apache.thrift.TFieldRequirementType.DEFAULT, 
        new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.I32)));
    metaDataMap = Collections.unmodifiableMap(tmpMap);
    org.apache.thrift.meta_data.FieldMetaData.addStructMetaDataMap(NodeHeat.class, metaDataMap);
  }

  public NodeHeat() {
  }

  public NodeHeat(
    String nodeId,
    double cpuUsedPerc,
    double freeMem,
    double jvmFreeMem,
    int taskQueueLimit,
    int taskQueueNume)
  {
    this();
    this.nodeId = nodeId;
    this.cpuUsedPerc = cpuUsedPerc;
    setCpuUsedPercIsSet(true);
    this.freeMem = freeMem;
    setFreeMemIsSet(true);
    this.jvmFreeMem = jvmFreeMem;
    setJvmFreeMemIsSet(true);
    this.taskQueueLimit = taskQueueLimit;
    setTaskQueueLimitIsSet(true);
    this.taskQueueNume = taskQueueNume;
    setTaskQueueNumeIsSet(true);
  }

  /**
   * Performs a deep copy on <i>other</i>.
   */
  public NodeHeat(NodeHeat other) {
    __isset_bitfield = other.__isset_bitfield;
    if (other.isSetNodeId()) {
      this.nodeId = other.nodeId;
    }
    this.cpuUsedPerc = other.cpuUsedPerc;
    this.freeMem = other.freeMem;
    this.jvmFreeMem = other.jvmFreeMem;
    this.taskQueueLimit = other.taskQueueLimit;
    this.taskQueueNume = other.taskQueueNume;
  }

  public NodeHeat deepCopy() {
    return new NodeHeat(this);
  }

  @Override
  public void clear() {
    this.nodeId = null;
    setCpuUsedPercIsSet(false);
    this.cpuUsedPerc = 0.0;
    setFreeMemIsSet(false);
    this.freeMem = 0.0;
    setJvmFreeMemIsSet(false);
    this.jvmFreeMem = 0.0;
    setTaskQueueLimitIsSet(false);
    this.taskQueueLimit = 0;
    setTaskQueueNumeIsSet(false);
    this.taskQueueNume = 0;
  }

  public String getNodeId() {
    return this.nodeId;
  }

  public NodeHeat setNodeId(String nodeId) {
    this.nodeId = nodeId;
    return this;
  }

  public void unsetNodeId() {
    this.nodeId = null;
  }

  /** Returns true if field nodeId is set (has been assigned a value) and false otherwise */
  public boolean isSetNodeId() {
    return this.nodeId != null;
  }

  public void setNodeIdIsSet(boolean value) {
    if (!value) {
      this.nodeId = null;
    }
  }

  public double getCpuUsedPerc() {
    return this.cpuUsedPerc;
  }

  public NodeHeat setCpuUsedPerc(double cpuUsedPerc) {
    this.cpuUsedPerc = cpuUsedPerc;
    setCpuUsedPercIsSet(true);
    return this;
  }

  public void unsetCpuUsedPerc() {
    __isset_bitfield = EncodingUtils.clearBit(__isset_bitfield, __CPUUSEDPERC_ISSET_ID);
  }

  /** Returns true if field cpuUsedPerc is set (has been assigned a value) and false otherwise */
  public boolean isSetCpuUsedPerc() {
    return EncodingUtils.testBit(__isset_bitfield, __CPUUSEDPERC_ISSET_ID);
  }

  public void setCpuUsedPercIsSet(boolean value) {
    __isset_bitfield = EncodingUtils.setBit(__isset_bitfield, __CPUUSEDPERC_ISSET_ID, value);
  }

  public double getFreeMem() {
    return this.freeMem;
  }

  public NodeHeat setFreeMem(double freeMem) {
    this.freeMem = freeMem;
    setFreeMemIsSet(true);
    return this;
  }

  public void unsetFreeMem() {
    __isset_bitfield = EncodingUtils.clearBit(__isset_bitfield, __FREEMEM_ISSET_ID);
  }

  /** Returns true if field freeMem is set (has been assigned a value) and false otherwise */
  public boolean isSetFreeMem() {
    return EncodingUtils.testBit(__isset_bitfield, __FREEMEM_ISSET_ID);
  }

  public void setFreeMemIsSet(boolean value) {
    __isset_bitfield = EncodingUtils.setBit(__isset_bitfield, __FREEMEM_ISSET_ID, value);
  }

  public double getJvmFreeMem() {
    return this.jvmFreeMem;
  }

  public NodeHeat setJvmFreeMem(double jvmFreeMem) {
    this.jvmFreeMem = jvmFreeMem;
    setJvmFreeMemIsSet(true);
    return this;
  }

  public void unsetJvmFreeMem() {
    __isset_bitfield = EncodingUtils.clearBit(__isset_bitfield, __JVMFREEMEM_ISSET_ID);
  }

  /** Returns true if field jvmFreeMem is set (has been assigned a value) and false otherwise */
  public boolean isSetJvmFreeMem() {
    return EncodingUtils.testBit(__isset_bitfield, __JVMFREEMEM_ISSET_ID);
  }

  public void setJvmFreeMemIsSet(boolean value) {
    __isset_bitfield = EncodingUtils.setBit(__isset_bitfield, __JVMFREEMEM_ISSET_ID, value);
  }

  public int getTaskQueueLimit() {
    return this.taskQueueLimit;
  }

  public NodeHeat setTaskQueueLimit(int taskQueueLimit) {
    this.taskQueueLimit = taskQueueLimit;
    setTaskQueueLimitIsSet(true);
    return this;
  }

  public void unsetTaskQueueLimit() {
    __isset_bitfield = EncodingUtils.clearBit(__isset_bitfield, __TASKQUEUELIMIT_ISSET_ID);
  }

  /** Returns true if field taskQueueLimit is set (has been assigned a value) and false otherwise */
  public boolean isSetTaskQueueLimit() {
    return EncodingUtils.testBit(__isset_bitfield, __TASKQUEUELIMIT_ISSET_ID);
  }

  public void setTaskQueueLimitIsSet(boolean value) {
    __isset_bitfield = EncodingUtils.setBit(__isset_bitfield, __TASKQUEUELIMIT_ISSET_ID, value);
  }

  public int getTaskQueueNume() {
    return this.taskQueueNume;
  }

  public NodeHeat setTaskQueueNume(int taskQueueNume) {
    this.taskQueueNume = taskQueueNume;
    setTaskQueueNumeIsSet(true);
    return this;
  }

  public void unsetTaskQueueNume() {
    __isset_bitfield = EncodingUtils.clearBit(__isset_bitfield, __TASKQUEUENUME_ISSET_ID);
  }

  /** Returns true if field taskQueueNume is set (has been assigned a value) and false otherwise */
  public boolean isSetTaskQueueNume() {
    return EncodingUtils.testBit(__isset_bitfield, __TASKQUEUENUME_ISSET_ID);
  }

  public void setTaskQueueNumeIsSet(boolean value) {
    __isset_bitfield = EncodingUtils.setBit(__isset_bitfield, __TASKQUEUENUME_ISSET_ID, value);
  }

  public void setFieldValue(_Fields field, Object value) {
    switch (field) {
    case NODE_ID:
      if (value == null) {
        unsetNodeId();
      } else {
        setNodeId((String)value);
      }
      break;

    case CPU_USED_PERC:
      if (value == null) {
        unsetCpuUsedPerc();
      } else {
        setCpuUsedPerc((Double)value);
      }
      break;

    case FREE_MEM:
      if (value == null) {
        unsetFreeMem();
      } else {
        setFreeMem((Double)value);
      }
      break;

    case JVM_FREE_MEM:
      if (value == null) {
        unsetJvmFreeMem();
      } else {
        setJvmFreeMem((Double)value);
      }
      break;

    case TASK_QUEUE_LIMIT:
      if (value == null) {
        unsetTaskQueueLimit();
      } else {
        setTaskQueueLimit((Integer)value);
      }
      break;

    case TASK_QUEUE_NUME:
      if (value == null) {
        unsetTaskQueueNume();
      } else {
        setTaskQueueNume((Integer)value);
      }
      break;

    }
  }

  public Object getFieldValue(_Fields field) {
    switch (field) {
    case NODE_ID:
      return getNodeId();

    case CPU_USED_PERC:
      return Double.valueOf(getCpuUsedPerc());

    case FREE_MEM:
      return Double.valueOf(getFreeMem());

    case JVM_FREE_MEM:
      return Double.valueOf(getJvmFreeMem());

    case TASK_QUEUE_LIMIT:
      return Integer.valueOf(getTaskQueueLimit());

    case TASK_QUEUE_NUME:
      return Integer.valueOf(getTaskQueueNume());

    }
    throw new IllegalStateException();
  }

  /** Returns true if field corresponding to fieldID is set (has been assigned a value) and false otherwise */
  public boolean isSet(_Fields field) {
    if (field == null) {
      throw new IllegalArgumentException();
    }

    switch (field) {
    case NODE_ID:
      return isSetNodeId();
    case CPU_USED_PERC:
      return isSetCpuUsedPerc();
    case FREE_MEM:
      return isSetFreeMem();
    case JVM_FREE_MEM:
      return isSetJvmFreeMem();
    case TASK_QUEUE_LIMIT:
      return isSetTaskQueueLimit();
    case TASK_QUEUE_NUME:
      return isSetTaskQueueNume();
    }
    throw new IllegalStateException();
  }

  @Override
  public boolean equals(Object that) {
    if (that == null)
      return false;
    if (that instanceof NodeHeat)
      return this.equals((NodeHeat)that);
    return false;
  }

  public boolean equals(NodeHeat that) {
    if (that == null)
      return false;

    boolean this_present_nodeId = true && this.isSetNodeId();
    boolean that_present_nodeId = true && that.isSetNodeId();
    if (this_present_nodeId || that_present_nodeId) {
      if (!(this_present_nodeId && that_present_nodeId))
        return false;
      if (!this.nodeId.equals(that.nodeId))
        return false;
    }

    boolean this_present_cpuUsedPerc = true;
    boolean that_present_cpuUsedPerc = true;
    if (this_present_cpuUsedPerc || that_present_cpuUsedPerc) {
      if (!(this_present_cpuUsedPerc && that_present_cpuUsedPerc))
        return false;
      if (this.cpuUsedPerc != that.cpuUsedPerc)
        return false;
    }

    boolean this_present_freeMem = true;
    boolean that_present_freeMem = true;
    if (this_present_freeMem || that_present_freeMem) {
      if (!(this_present_freeMem && that_present_freeMem))
        return false;
      if (this.freeMem != that.freeMem)
        return false;
    }

    boolean this_present_jvmFreeMem = true;
    boolean that_present_jvmFreeMem = true;
    if (this_present_jvmFreeMem || that_present_jvmFreeMem) {
      if (!(this_present_jvmFreeMem && that_present_jvmFreeMem))
        return false;
      if (this.jvmFreeMem != that.jvmFreeMem)
        return false;
    }

    boolean this_present_taskQueueLimit = true;
    boolean that_present_taskQueueLimit = true;
    if (this_present_taskQueueLimit || that_present_taskQueueLimit) {
      if (!(this_present_taskQueueLimit && that_present_taskQueueLimit))
        return false;
      if (this.taskQueueLimit != that.taskQueueLimit)
        return false;
    }

    boolean this_present_taskQueueNume = true;
    boolean that_present_taskQueueNume = true;
    if (this_present_taskQueueNume || that_present_taskQueueNume) {
      if (!(this_present_taskQueueNume && that_present_taskQueueNume))
        return false;
      if (this.taskQueueNume != that.taskQueueNume)
        return false;
    }

    return true;
  }

  @Override
  public int hashCode() {
    return 0;
  }

  @Override
  public int compareTo(NodeHeat other) {
    if (!getClass().equals(other.getClass())) {
      return getClass().getName().compareTo(other.getClass().getName());
    }

    int lastComparison = 0;

    lastComparison = Boolean.valueOf(isSetNodeId()).compareTo(other.isSetNodeId());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetNodeId()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.nodeId, other.nodeId);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    lastComparison = Boolean.valueOf(isSetCpuUsedPerc()).compareTo(other.isSetCpuUsedPerc());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetCpuUsedPerc()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.cpuUsedPerc, other.cpuUsedPerc);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    lastComparison = Boolean.valueOf(isSetFreeMem()).compareTo(other.isSetFreeMem());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetFreeMem()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.freeMem, other.freeMem);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    lastComparison = Boolean.valueOf(isSetJvmFreeMem()).compareTo(other.isSetJvmFreeMem());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetJvmFreeMem()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.jvmFreeMem, other.jvmFreeMem);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    lastComparison = Boolean.valueOf(isSetTaskQueueLimit()).compareTo(other.isSetTaskQueueLimit());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetTaskQueueLimit()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.taskQueueLimit, other.taskQueueLimit);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    lastComparison = Boolean.valueOf(isSetTaskQueueNume()).compareTo(other.isSetTaskQueueNume());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetTaskQueueNume()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.taskQueueNume, other.taskQueueNume);
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
    StringBuilder sb = new StringBuilder("NodeHeat(");
    boolean first = true;

    sb.append("nodeId:");
    if (this.nodeId == null) {
      sb.append("null");
    } else {
      sb.append(this.nodeId);
    }
    first = false;
    if (!first) sb.append(", ");
    sb.append("cpuUsedPerc:");
    sb.append(this.cpuUsedPerc);
    first = false;
    if (!first) sb.append(", ");
    sb.append("freeMem:");
    sb.append(this.freeMem);
    first = false;
    if (!first) sb.append(", ");
    sb.append("jvmFreeMem:");
    sb.append(this.jvmFreeMem);
    first = false;
    if (!first) sb.append(", ");
    sb.append("taskQueueLimit:");
    sb.append(this.taskQueueLimit);
    first = false;
    if (!first) sb.append(", ");
    sb.append("taskQueueNume:");
    sb.append(this.taskQueueNume);
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

  private static class NodeHeatStandardSchemeFactory implements SchemeFactory {
    public NodeHeatStandardScheme getScheme() {
      return new NodeHeatStandardScheme();
    }
  }

  private static class NodeHeatStandardScheme extends StandardScheme<NodeHeat> {

    public void read(org.apache.thrift.protocol.TProtocol iprot, NodeHeat struct) throws org.apache.thrift.TException {
      org.apache.thrift.protocol.TField schemeField;
      iprot.readStructBegin();
      while (true)
      {
        schemeField = iprot.readFieldBegin();
        if (schemeField.type == org.apache.thrift.protocol.TType.STOP) { 
          break;
        }
        switch (schemeField.id) {
          case 1: // NODE_ID
            if (schemeField.type == org.apache.thrift.protocol.TType.STRING) {
              struct.nodeId = iprot.readString();
              struct.setNodeIdIsSet(true);
            } else { 
              org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
            }
            break;
          case 2: // CPU_USED_PERC
            if (schemeField.type == org.apache.thrift.protocol.TType.DOUBLE) {
              struct.cpuUsedPerc = iprot.readDouble();
              struct.setCpuUsedPercIsSet(true);
            } else { 
              org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
            }
            break;
          case 3: // FREE_MEM
            if (schemeField.type == org.apache.thrift.protocol.TType.DOUBLE) {
              struct.freeMem = iprot.readDouble();
              struct.setFreeMemIsSet(true);
            } else { 
              org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
            }
            break;
          case 4: // JVM_FREE_MEM
            if (schemeField.type == org.apache.thrift.protocol.TType.DOUBLE) {
              struct.jvmFreeMem = iprot.readDouble();
              struct.setJvmFreeMemIsSet(true);
            } else { 
              org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
            }
            break;
          case 5: // TASK_QUEUE_LIMIT
            if (schemeField.type == org.apache.thrift.protocol.TType.I32) {
              struct.taskQueueLimit = iprot.readI32();
              struct.setTaskQueueLimitIsSet(true);
            } else { 
              org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
            }
            break;
          case 6: // TASK_QUEUE_NUME
            if (schemeField.type == org.apache.thrift.protocol.TType.I32) {
              struct.taskQueueNume = iprot.readI32();
              struct.setTaskQueueNumeIsSet(true);
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

    public void write(org.apache.thrift.protocol.TProtocol oprot, NodeHeat struct) throws org.apache.thrift.TException {
      struct.validate();

      oprot.writeStructBegin(STRUCT_DESC);
      if (struct.nodeId != null) {
        oprot.writeFieldBegin(NODE_ID_FIELD_DESC);
        oprot.writeString(struct.nodeId);
        oprot.writeFieldEnd();
      }
      oprot.writeFieldBegin(CPU_USED_PERC_FIELD_DESC);
      oprot.writeDouble(struct.cpuUsedPerc);
      oprot.writeFieldEnd();
      oprot.writeFieldBegin(FREE_MEM_FIELD_DESC);
      oprot.writeDouble(struct.freeMem);
      oprot.writeFieldEnd();
      oprot.writeFieldBegin(JVM_FREE_MEM_FIELD_DESC);
      oprot.writeDouble(struct.jvmFreeMem);
      oprot.writeFieldEnd();
      oprot.writeFieldBegin(TASK_QUEUE_LIMIT_FIELD_DESC);
      oprot.writeI32(struct.taskQueueLimit);
      oprot.writeFieldEnd();
      oprot.writeFieldBegin(TASK_QUEUE_NUME_FIELD_DESC);
      oprot.writeI32(struct.taskQueueNume);
      oprot.writeFieldEnd();
      oprot.writeFieldStop();
      oprot.writeStructEnd();
    }

  }

  private static class NodeHeatTupleSchemeFactory implements SchemeFactory {
    public NodeHeatTupleScheme getScheme() {
      return new NodeHeatTupleScheme();
    }
  }

  private static class NodeHeatTupleScheme extends TupleScheme<NodeHeat> {

    @Override
    public void write(org.apache.thrift.protocol.TProtocol prot, NodeHeat struct) throws org.apache.thrift.TException {
      TTupleProtocol oprot = (TTupleProtocol) prot;
      BitSet optionals = new BitSet();
      if (struct.isSetNodeId()) {
        optionals.set(0);
      }
      if (struct.isSetCpuUsedPerc()) {
        optionals.set(1);
      }
      if (struct.isSetFreeMem()) {
        optionals.set(2);
      }
      if (struct.isSetJvmFreeMem()) {
        optionals.set(3);
      }
      if (struct.isSetTaskQueueLimit()) {
        optionals.set(4);
      }
      if (struct.isSetTaskQueueNume()) {
        optionals.set(5);
      }
      oprot.writeBitSet(optionals, 6);
      if (struct.isSetNodeId()) {
        oprot.writeString(struct.nodeId);
      }
      if (struct.isSetCpuUsedPerc()) {
        oprot.writeDouble(struct.cpuUsedPerc);
      }
      if (struct.isSetFreeMem()) {
        oprot.writeDouble(struct.freeMem);
      }
      if (struct.isSetJvmFreeMem()) {
        oprot.writeDouble(struct.jvmFreeMem);
      }
      if (struct.isSetTaskQueueLimit()) {
        oprot.writeI32(struct.taskQueueLimit);
      }
      if (struct.isSetTaskQueueNume()) {
        oprot.writeI32(struct.taskQueueNume);
      }
    }

    @Override
    public void read(org.apache.thrift.protocol.TProtocol prot, NodeHeat struct) throws org.apache.thrift.TException {
      TTupleProtocol iprot = (TTupleProtocol) prot;
      BitSet incoming = iprot.readBitSet(6);
      if (incoming.get(0)) {
        struct.nodeId = iprot.readString();
        struct.setNodeIdIsSet(true);
      }
      if (incoming.get(1)) {
        struct.cpuUsedPerc = iprot.readDouble();
        struct.setCpuUsedPercIsSet(true);
      }
      if (incoming.get(2)) {
        struct.freeMem = iprot.readDouble();
        struct.setFreeMemIsSet(true);
      }
      if (incoming.get(3)) {
        struct.jvmFreeMem = iprot.readDouble();
        struct.setJvmFreeMemIsSet(true);
      }
      if (incoming.get(4)) {
        struct.taskQueueLimit = iprot.readI32();
        struct.setTaskQueueLimitIsSet(true);
      }
      if (incoming.get(5)) {
        struct.taskQueueNume = iprot.readI32();
        struct.setTaskQueueNumeIsSet(true);
      }
    }
  }

}
