/**
 * Autogenerated by Thrift Compiler (0.9.1)
 *
 * DO NOT EDIT UNLESS YOU ARE SURE THAT YOU KNOW WHAT YOU ARE DOING
 *  @generated
 */
package com.nercis.isscp.idl.rules;


import java.util.Map;
import java.util.HashMap;
import org.apache.thrift.TEnum;

/**
 * PrivacySteal 隐私窃取
 * RemoteControl 远程控制
 * RatesLoss 响应触屏事件
 * MaliceSpread 恶意传播
 * SystemDamage 系统破坏
 * TouchEvent 响应触屏事件
 */
public enum Activity implements org.apache.thrift.TEnum {
  PrivacySteal(0),
  RemoteControl(1),
  RatesLoss(2),
  MaliceSpread(3),
  SystemDamage(4),
  TouchEvent(5);

  private final int value;

  private Activity(int value) {
    this.value = value;
  }

  /**
   * Get the integer value of this enum value, as defined in the Thrift IDL.
   */
  public int getValue() {
    return value;
  }

  /**
   * Find a the enum type by its integer value, as defined in the Thrift IDL.
   * @return null if the value is not found.
   */
  public static Activity findByValue(int value) { 
    switch (value) {
      case 0:
        return PrivacySteal;
      case 1:
        return RemoteControl;
      case 2:
        return RatesLoss;
      case 3:
        return MaliceSpread;
      case 4:
        return SystemDamage;
      case 5:
        return TouchEvent;
      default:
        return null;
    }
  }
}
