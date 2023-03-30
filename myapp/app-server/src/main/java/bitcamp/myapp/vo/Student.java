package bitcamp.myapp.vo;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

// 회원 데이터를 담을 메모리를 설계한다.

@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class Student extends Member {
  private static final long serialVersionUID = 1L;

  private String postNo;
  private String basicAddress;
  private String detailAddress;
  private boolean working;
  private char gender;
  private byte level;

}
