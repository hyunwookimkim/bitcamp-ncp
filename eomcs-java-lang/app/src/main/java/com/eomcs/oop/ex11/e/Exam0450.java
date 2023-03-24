// anonymous class - 익명 클래스가 놓이는 장소: 파라미터
package com.eomcs.oop.ex11.e;

class My {
  static void m1() {
    System.out.println("오호라!!!!");
  }

  void m2() {
    System.out.println("와우~~~~!");
  }
}

public class Exam0450 {
  // 인터페이스의 경우 static으로 선언하지 않아도 스태틱 멤버에서 사용할 수 있다.
  interface A {
    void print();
  }

  static A create0() {
    class X implements A {
      @Override
      public void print() {
        System.out.println("Hello!0");
      }
    }
    return new X();
  }
  static A create1() {
    A a = new A() {
      @Override
      public void print() {
        System.out.println("Hello!1");
      }
    };
    return a;
  }

  static A create2() {
    return new A() {
      @Override
      public void print() {
        System.out.println("Hello2!");
      }
    };
  }


  //추상클래스나 , 클래스는 안되고, 인터페이스만 가능하다.
  //함수가 1개 일때만 람다문법이 가능하다.


  //람다문법은.class 파일에 바이트 코드로 따로 컴파일이 되는게 아니라 함수로 만들어진다.
  static A create22() {
    return ()-> System.out.println("Hello2!");
  }




  //람다문법은.class 파일에 바이트 코드로 따로 컴파일이 되는게 아니라 함수로 만들어진다.
  static A create3() {
    return () -> System.out.println("Hello3!");
  }
  //스테틱메서드 인터페이스 구현체로 활용하는법
  static A create4() {
    return My::m1;//메서드 레퍼런스
  }
  //인스턴스메서드 인터페이스 구현체로 활용하는법
  static A create5() {
    return new My()::m2;//메서드 레퍼런스
  }

  public static void main(String[] args) {
    A obj0 = create0();
    obj0.print();

    A obj1 = create1();
    obj1.print();

    A obj2 = create2();
    obj2.print();

    A obj3 = create3();
    obj3.print();

    A obj4 = create4();
    obj4.print();

    A obj5 = create5();
    obj5.print();
  }
}
