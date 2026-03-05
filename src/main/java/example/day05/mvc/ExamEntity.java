package example.day05.mvc;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity //entity? 데이터베이스랑 연동하는 객체 실제 객체 실제 값
@Table(name = "exam") //db에서 테이블명 정의
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ExamEntity {
    @Id //pk
    @GeneratedValue(strategy = GenerationType.IDENTITY) //auto increment
    private Integer eno;

    @Column(name = "ename",length = 255,nullable = true) //필드 속성
    private String ename;
} //class end

//entity데이터베이스 와 객체간의 연동