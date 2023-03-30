package bitcamp.myapp.vo;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class Teacher extends Member {
  private static final long serialVersionUID = 1L;

  private int degree;
  private String school;
  private String major;
  private int wage;

}
