/**
 * Autogenerated by Thrift Compiler (0.9.3)
 *
 * DO NOT EDIT UNLESS YOU ARE SURE THAT YOU KNOW WHAT YOU ARE DOING
 *  @generated
 */
package com.sunlands.ent.thrift.service;


public enum DemoEnum implements org.apache.thrift.TEnum {
  A(0),
  B(1),
  C(2);

  private final int value;

  private DemoEnum(int value) {
    this.value = value;
  }

  /**
   * Get the integer value of this enum value, as defined in the Thrift IDL.
   */
  @Override
  public int getValue() {
    return value;
  }

  /**
   * Find a the enum type by its integer value, as defined in the Thrift IDL.
   * @return null if the value is not found.
   */
  public static DemoEnum findByValue(int value) { 
    switch (value) {
      case 0:
        return A;
      case 1:
        return B;
      case 2:
        return C;
      default:
        return null;
    }
  }
}