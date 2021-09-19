package hello.servlet.basic;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter //이렇게 사용하면 알아서 getter setter를 생성 , 일종의 VO 같은 느낌
public class HelloData {
    //json 데이터 형식으로 통신하기위해서 객체로 바꿔서 사용, 보통 json를 사용하려면 객체 생성 필수
    private String username;
    private int age;



}
