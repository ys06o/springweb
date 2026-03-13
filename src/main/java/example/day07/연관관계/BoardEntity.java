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
@Table(name = "board")
public class BoardEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer bno; //게시물 번호

    private String bcontent; //게시물 내용

    //단방향 FK만들기
    @JoinColumn(name ="cno") //관례적으로 fk필드명도 pk필드명과 동일하게 한다.
    @ManyToOne //다수가 하나에게 , 일대다 관계 여러개 게시물이 하나의 카테고리를 참조한다.
    private CategoryEntity categoryEntity;


    //양방향 설계:자바에 조회용도로만 사용한다.
    @OneToMany(mappedBy = "boardEntity")
    @ToString.Exclude
    @Builder.Default
    private List<ReplyEntity> replyEntityList=new ArrayList<>();


} //class end
