package example.day07.practice7.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "student")
public class StudentEntity extends BaseTime {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer studentId; //학생번호

    private String studentName; //학생이름


    //한 학생은 여러 과정 수강 가능
    @OneToMany(mappedBy = "studentEntity")
    @ToString.Exclude
    private List<EnrollEntity> enrollEntityList=new ArrayList<>();


}
