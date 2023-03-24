package com.eomcs.exception.ex3;

public class GT {
  //  static void m() {
  //    throw new RuntimeException ("예외발생!!");
  //  }
  //  static void test() {
  //    m();
  //    System.out.println("test 호출됨");
  //  }
  //  public static void main(String[] args) {
  //    try {
  //      test();
  //
  //    }catch (RuntimeException e) {
  //      System.out.println(e.getMessage());
  //    }
  static void m() {
    throw new RuntimeException("예외발생!");
  }
  static void test() {
    m();
    System.out.println("호출됨");
  }
}

