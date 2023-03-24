package bitcamp.bootapp.dao;

import java.sql.Date;
import java.util.Arrays;
import org.springframework.stereotype.Repository;
import bitcamp.bootapp.vo.Guest;
@Repository

public class GuestDao {

  private static final int SIZE = 100;

  private int no; // board 식별 번호
  private int count;
  private Guest[] guests = new Guest[SIZE];

  public void insert(Guest guest) {
    guest.setNo(++no);
    guest.setCreatedDate(new Date(System.currentTimeMillis()).toString());
    this.guests[this.count++] = guest;
  }

  public Guest[] findAll() {
    return Arrays.copyOf(guests, count);
  }

  public Guest findByNo(int no) {
    for (int i = 0; i < this.count; i++) {
      if (this.guests[i].getNo() == no) {
        return this.guests[i];
      }
    }
    return null;
  }
  public void update(Guest guest) {
    this.guests[this.indexOf(guest)] = guest;
  }

  public void delete(Guest guest) {
    for(int i = this.indexOf(guest) + 1; i < this.count; i++) {
      this.guests[i-1] = this.guests[i];
    }
    this.guests[--this.count] = null;
  }

  private int indexOf(Guest g) {
    for (int i = 0; i < this.count; i++) {
      if(this.guests[i].getNo() == g.getNo()) {
        return i;
      }
    }
    return -1;
  }






}
