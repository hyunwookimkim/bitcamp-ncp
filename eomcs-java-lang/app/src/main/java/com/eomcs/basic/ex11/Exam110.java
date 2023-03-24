package com.eomcs.basic.ex11;

import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Exam110 {

  public static void main(String[] args) {

    //1)패턴정의
    Pattern pattern =  Pattern.compile("\\d+|[\\+\\-\\*/]",Pattern.CASE_INSENSITIVE);
    // [0-9]+    0에서 9까지의 모든숫자? 그리고 \\d  쓰면 앞에 [0-9 까지의] 효과를 볼수 있다
    // \\*      자바는 역슬래스 한번은 불가해서 두번쓴다
    //[0-9]+|[\\+\\-\\*/]  여기서 or설정은 값을 두번 조회하기 위해서
    // \\D 를 사용시 숫자와 공백을 같이 뽑아낸다.

    //2)패턴에 따라 콘텐트를 검사할 도구 준비
    Matcher matcher = pattern.matcher("123+    2* 98 -24/  19");

    //3)패턴의 결과를 담을 컬렉션 준비
    ArrayList<String> items = new ArrayList<>();

    //4)패턴검사
    while (matcher.find()) {
      items.add(matcher.group());
    }
    //5)패턴과 일치하는 항목을 추출하여 컬레선에 담기
    for (String item : items) {
      System.out.println(item);
    }
  }
}

