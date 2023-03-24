package bitcamp.bootapp.Config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
//글로벌설정: 클래스마다 같은 크로스 오리진 애노테이션으로 쓸거면 글로버 설정으로 한번에 하기

@Configuration
// 이 클래스는 설정에 관련된 일을 하는 클래스임을 선언한다.
// 즉 스프링 컴포넌트로 표시하는 것이다.
//Spring Ioc 컨테이너는 이설정이 붙은 클래스의 인스턴스를 자동 생성한다.

//@EnableWebMvc
//Spring 프레임워크에서 WebMvc에서 관련기능을 사용할 수 있도록 관련 객체를 준비시키라고 선언한다.
//웹 애플리케이션을 제작할때 사용할 도구가 완전하게 구비되는 것이다.
//SpringBoot의 경우 이 애노테이션을 생략해도 된다.

public class Webconfig implements  WebMvcConfigurer{ //WebMvcConfigurer의 요구조건을 채운다.
  //이 클래스는 WebMvcConfigurer 규칙에 따라 메서드를 만들었음을 선언한다.
  //단 오버로드시 모든 메서드를 정의할 필요는 없다.
  //이 프로젝트에 맞춰 필요한 것만 설정하면 된다.(customizing; 고객화)
  //Spring WebMVC 프레임워크는 이클래스의 정의된 메서드를 호출하여 설정을 완성한다.

  public Webconfig() {
    System.out.println("web Config 생성이 됨");
  }
  //Cross-Origin 관련해서 기본 값 외에 추가로 설정할게 있다면 이 메서드를 정의한다.
  //즉 ctrl+shift를 해서 나온것중에 필요한것들만 골라서 만들어서 쓴다.
  //스프링 부트가 시작되면 이메서드를 호출하여 CrossOrigin을 설정할 것이다
  @Override
  public void addCorsMappings(CorsRegistry registry) {
    //체인방식을로
    registry.addMapping("/**") //하위의 하위
    .allowedOrigins("https://localhost:5500","http://127.0.0.1:5500")
    .allowedMethods("*");

  }

}
