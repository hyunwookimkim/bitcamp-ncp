package bitcamp.myapp;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@PropertySource("classpath:/naver.properties")
@Configuration
@ConfigurationProperties(prefix="ncp")
@Getter
@Setter
@ToString
public class NaverConfig {
  //  Logger log = LogManager.getLogger(getClass());
  //
  //  public NaverConfig() {
  //    log.debug("NaverConfig객체생성됨");
  //  }
  //프로퍼티 파일에서 선언된 값중에서 ncp.*이름으로 된 프로퍼티 값을 받을 필드를 선언한다.
  private String endPoint; //ncp.*
  private String regionName;//ncp.*
  private String accessKey;//ncp.*
  private String secretKey;//ncp.*
}
