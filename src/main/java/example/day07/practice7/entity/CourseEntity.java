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
@Table(name = "course")
public class CourseEntity extends BaseTime {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer courseId; //과정번호

    private String courseName; //과정명


    //한 과정에는 여러 학생 등록 가능
    @OneToMany(mappedBy = "courseEntity")
    @ToString.Exclude
    private List<EnrollEntity> enrollEntityList = new ArrayList<>();

}
