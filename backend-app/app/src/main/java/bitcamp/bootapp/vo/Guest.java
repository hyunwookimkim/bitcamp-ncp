package bitcamp.bootapp.vo;

public class Guest {
  private int no;
  private  String title;
  private String name;
  private String createdDate;
  private int viewCount;
  private String content;
  private int weather;
  private int emotion;
  private char late;
  private byte justpush;

  public int getNo() {
    return no;
  }
  public void setNo(int no) {
    this.no = no;
  }
  public String getTitle() {
    return title;
  }
  public void setTitle(String title) {
    this.title = title;
  }
  public String getName() {
    return name;
  }
  public void setName(String name) {
    this.name = name;
  }
  public String getCreatedDate() {
    return createdDate;
  }
  public void setCreatedDate(String createdDate) {
    this.createdDate = createdDate;
  }
  public int getViewCount() {
    return viewCount;
  }
  public void setViewCount(int viewCount) {
    this.viewCount = viewCount;
  }
  public String getContent() {
    return content;
  }
  public void setContent(String content) {
    this.content = content;
  }
  public int getWeather() {
    return weather;
  }
  public void setWeather(int weather) {
    this.weather = weather;
  }
  public int getEmotion() {
    return emotion;
  }
  public void setEmotion(int emotion) {
    this.emotion = emotion;
  }
  public char getLate() {
    return late;
  }
  public void setLate(char late) {
    this.late = late;
  }
  public byte getJustpush() {
    return justpush;
  }
  public void setJustpush(byte justpush) {
    this.justpush = justpush;
  }



}
