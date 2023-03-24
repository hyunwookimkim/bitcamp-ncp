package bitcamp.bootapp.controller;

import java.sql.Date;
import java.util.HashMap;
import java.util.Map;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;
import bitcamp.bootapp.dao.GuestDao;
import bitcamp.bootapp.vo.Guest;


@RestController
public class GuestController {

  GuestDao guestDao = new GuestDao();

  public GuestController(GuestDao guestDao) {
    this.guestDao = guestDao;
  }

  @PostMapping("/guests")
  public Object addGuest(Guest guest) {

    guest.setCreatedDate(new Date(System.currentTimeMillis()).toString());
    this.guestDao.insert(guest);

    Map<String,Object> contentMap = new HashMap<>();
    contentMap.put("status", "success");

    return contentMap;
  }

  @GetMapping("/guests")
  public Object getGuests() {

    Guest[] guests = this.guestDao.findAll();

    Map<String,Object> contentMap = new HashMap<>();
    contentMap.put("status", "success");
    contentMap.put("data", guests);

    return contentMap;
  }
  @GetMapping("/guests/{no}")
  public Object getGuest(@PathVariable int no) {

    Guest g =this.guestDao.findByNo(no);

    Map<String,Object> contentMap = new HashMap<>();

    if (g == null) {
      contentMap.put("status", "failure");
      contentMap.put("data", "회원이 없습니다.");
    } else {
      contentMap.put("status", "success");
      contentMap.put("data", g);
    }
    return contentMap;
  }

  @PutMapping("/guests/{no}")
  public Object updateGuest(Guest guest) {

    Map<String,Object> contentMap = new HashMap<>();

    Guest old = this.guestDao.findByNo(guest.getNo());
    if (old == null) {
      contentMap.put("status", "failure");
      contentMap.put("data", "회원이 없습니다.");
      return contentMap;
    }

    guest.setCreatedDate(old.getCreatedDate());
    guest.setViewCount(old.getViewCount());

    this.guestDao.update(guest);

    contentMap.put("status", "success");

    return contentMap;
  }

  @DeleteMapping("/guests/{no}")
  public Object deleteGuest(
      @PathVariable int no) {

    Guest g = this.guestDao.findByNo(no);
    Map<String,Object> contentMap = new HashMap<>();

    if (g == null) {
      contentMap.put("status", "failure");
      contentMap.put("data", "회원이 없습니다.");
    } else {
      this.guestDao.delete(g);
      contentMap.put("status", "success");
    }
    return contentMap;
  }
}




