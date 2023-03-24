package bitcamp.bootapp.controller;

import java.util.HashMap;
import java.util.Map;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;
import bitcamp.bootapp.dao.StudentDao;
import bitcamp.bootapp.vo.Student;


@RestController
public class StudentController {

  StudentDao studentDao;

  public StudentController(StudentDao studentDao) {
    this.studentDao = studentDao;
  }

  @PostMapping("/students")
  public Object addStudent(Student student) {




    this.studentDao.insert(student);

    Map<String,Object> contentMap = new HashMap<>();
    contentMap.put("status", "success");

    return contentMap;
  }


  @GetMapping("/students")
  public Object getstudents() {

    Student[] students = this.studentDao.findAll();

    Map<String,Object> contentMap = new HashMap<>();
    contentMap.put("status", "success");
    contentMap.put("data", students);

    return contentMap;
  }


  @GetMapping("/students/{No}")
  public Object getStudent(@PathVariable int no) {

    Student b = this.studentDao.findByNo(no);

    Map<String,Object> contentMap = new HashMap<>();

    if (b == null) {
      contentMap.put("status", "failure");
      contentMap.put("data", "회원이 없습니다.");
    } else {
      contentMap.put("status", "success");
      contentMap.put("data", b);
    }

    return contentMap;
  }

  @PutMapping("/students/{no}")
  public Object updateStudent(
      //@PathVariable int no, // Student 인스턴스로 직접 받을 수 있다.
      Student Student) {

    Map<String,Object> contentMap = new HashMap<>();

    Student old = this.studentDao.findByNo(Student.getNo());
    if (old == null) {
      contentMap.put("status", "failure");
      contentMap.put("data", "회원이 없습니다.");
      return contentMap;
    }

    Student.setCreatedDate(old.getCreatedDate());

    this.studentDao.update(Student);

    contentMap.put("status", "success");

    return contentMap;
  }

  @DeleteMapping("/students/{no}")  // http://localhost:8080/students/2 주소를 쓴다는 행위가 요청이다
  public Object deleteStudent(
      // 낱개로 받을 때는 @PathVariable 애노테이션을 생략하면 안된다.
      @PathVariable int no) {

    Student m = this.studentDao.findByNo(no);

    Map<String,Object> contentMap = new HashMap<>();

    if (m == null) {
      contentMap.put("status", "failure");
      contentMap.put("data", "회원이 없습니다.");

    } else {
      this.studentDao.delete(m);
      contentMap.put("status", "success");
    }

    return contentMap;
  }
}
