package example.day04.ch3;

import jakarta.persistence.*;
import lombok.*;

@NoArgsConstructor(access = AccessLevel.PROTECTED) //빈생성자 생성이면서 prodtected
@AllArgsConstructor(access = AccessLevel.PROTECTED) //전체 매개변수를 갖는 생성자
@Getter
@Entity //DB에 테이블의 레코드와 매핑(연결)하는 기술:ORM(자바 객체와 db레코드랑 연결)
public class Member {
    @Id //PK
    @GeneratedValue(strategy = GenerationType.IDENTITY) //auto_increment
    @Column(name = "id", updatable = false) //필드/속성명 설정, 수정 불가능
    private Long id;

    @Column(name = "name", nullable = false) //필드/속성명 설정 not null
    private String name;



} //class end


