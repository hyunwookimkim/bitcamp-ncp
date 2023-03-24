package com.eomcs.algorithm.data_structure.array;

//1) 인스턴스/객체 (의 주소)를 담을 레퍼런스 배열을 준비한다.
//2) 인스턴스를 추가하는 add(Object) 메서드 정의한다.
//3) 특정 인덱스의 인스턴스를 리턴하는 get(int) 메서드 정의한다.
//4) 인스턴스를 특정 위치에 삽입하는 add(int,Object) 메서드 정의한다.
public class MyArrayList04 {

  static Object[] elementData = new Object[5];
  static int 저장된개수;

  static public boolean add(Object e) {
    elementData[저장된개수++] = e;
    return true;
  }

  static public void add(int 몇번째, Object element) {
    for (int i = 저장된개수; i > 몇번째 ; i--) {
      elementData[i] = elementData[i - 1];
    }
    elementData[몇번째] = element;
    저장된개수++;
  }

  static public Object get(int 몇번째) {
    return elementData[몇번째];
  }
}




