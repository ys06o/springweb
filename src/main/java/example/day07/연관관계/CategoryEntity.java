package example.day07.연관관계;


import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name ="categoty")
public class CategoryEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer cno; //카테고리 번호


    private String cname; //카테고리 이름

    //양방향: 데이터베이스에는 존재하지 않는다. mappedBy:매핑할 fk필드명
    @OneToMany(mappedBy ="categoryEntity") //하나의 다수에게 1:m 관계  //자바에서만 사용한다. 조회용도로 사용한다.
    @ToString.Exclude //순환 참조 방지
    @Builder.Default //new 생성자 대신에 빌더 객체 생성시 초기값 사용
    private List<BoardEntity> boardEntityList=new ArrayList<>(); //boardEntity list생성

} //class end
