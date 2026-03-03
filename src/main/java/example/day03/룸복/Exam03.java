package example.day03.룸복;

import lombok.*;

public class Exam03 {
    public static void main(String[] args) {
        /*
        롬복 lombok:반복되는 코드들을 줄여주는 라이브러리
        1.인텔리제이
        2.프로젝트 의존성 추가
        1.https://start.spring.io
         */
        StudentDto studentDto=new StudentDto();
        StudentDto studentDto1 = new StudentDto(1, "유재석");
        studentDto1.getSname();
        studentDto1.setSname("강호동");
        studentDto1.toString();

        //생성자는 매개변수의 순서대로 인자값을 전달해야한다. 즉 유연성이 떨어진다.
        //        StudentDto studentDto2=new StudentDto("유재석",1);



        //해결책 :빌더패턴(객체를 만드는 패턴=유연성 제공)
        //클래스명.builder().멤버변수명(값).멤버변수명(값).build()
        StudentDto studentDto4=StudentDto.builder()
                .sno(1).sname("유재석").build();
        StudentDto studentDto6=StudentDto.builder().sname("유재석").build();

    } //main end
} //class end

@NoArgsConstructor //컴파일 될때 기본생성자 코드가 자동 생성
@AllArgsConstructor //컴파일 될때 풀생성자 코드가 자동 생성
//@RequiredArgsConstructor //final 매개변수 생성자 자동 생성
@Getter //getter 메소드 제공
@Setter //setter 메소드 제공
@ToString
@Data //@Getter+@Setter+@ToString+@AllArgsConstructor+@NoArgsConstructor+@RequiredArgsConstructor
@Builder //빌더패턴 사용
class StudentDto{
    //1. private 멤버변수
    private int sno;
    private String sname;
    //2.빈생성자,풀생성자
    //3.getter/setter
    //4.toString
}
