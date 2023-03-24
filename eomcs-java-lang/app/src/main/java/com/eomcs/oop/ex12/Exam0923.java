// List 와 forEach() - forEach() 사용 후
package com.eomcs.oop.ex12;

import java.util.ArrayList;

public class Exam0923 {

  public static void main(String[] args) {
    ArrayList<String> names = new ArrayList<>();
    names.add("홍길동");
    names.add("임꺽정");
    names.add("유관순");
    names.add("김구");
    names.add("안중근");

    //그럴바엔 람다도 에바쎼바다. 더 간결하게 System.out.println에 바로 넘겨준다.
    names.forEach(System.out::println);
  }
  //  names.forEach(new Consumer<String>() {
  //    @Override
  //    public void accept(String item) {
  //      System.out.println(item);
  //    }
}