// List 와 forEach() - forEach() 사용 후
package com.eomcs.oop.ex12;

import java.util.ArrayList;

public class Exam0922 {

  public static void main(String[] args) {
    ArrayList<String> names = new ArrayList<>();
    names.add("홍길동");
    names.add("임꺽정");
    names.add("유관순");
    names.add("김구");
    names.add("안중근");

    // 값을 꺼내서 파라미터로 넘겨주면 System.out.println 로 넘겨준다
    names.forEach(item -> System.out.println(item));
  }
}