package bitcamp.bootapp.vo;

public class Teacher extends Member {
  private int no;
  private String name;
  private String tel;
  private String createdDate;

  @Override
  public int getNo() {
    return no;
  }
  @Override
  public void setNo(int no) {
    this.no = no;
  }
  @Override
  public String getName() {
    return name;
  }
  @Override
  public void setName(String name) {
    this.name = name;
  }
  @Override
  public String getTel() {
    return tel;
  }
  @Override
  public void setTel(String tel) {
    this.tel = tel;
  }

  @Override
  public String getCreatedDate() {
    return createdDate;
  }
  @Override
  public void setCreatedDate(String createdDate) {
    this.createdDate = createdDate;
  }


}
