// List 와 forEach() - forEach() 사용 후
package com.eomcs.oop.ex12;

import java.util.ArrayList;
import java.util.function.Consumer;

public class Exam0920 {

  public static void main(String[] args) {
    ArrayList<String> names = new ArrayList<>();
    names.add("홍길동");
    names.add("임꺽정");
    names.add("유관순");
    names.add("김구");
    names.add("안중근");

    class MyConsumer<T> implements Consumer<T> {
      @Override
      public void accept(T item) {
        System.out.println(item);
      }
    }
    //값을 하나씩 꺼내서 accept에 전달한다. 뭘할건지 accept에 담아놓는다
    //즉, 뭘할건지 꺼내놓는다
    names.forEach(new MyConsumer<String>());
  }
}