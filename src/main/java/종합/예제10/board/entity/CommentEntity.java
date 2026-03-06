package 종합.예제10.board.entity;

import jakarta.persistence.*;
import lombok.*;
import 종합.예제10.board.dto.CommentDto;

@Entity
@Table(name="comment")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@EqualsAndHashCode(callSuper = false)
public class CommentEntity extends BaseTime {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer cno; //댓글 번호

    @ManyToOne
    @JoinColumn(name = "bno")
    private BoardEntity boardEntity;

    @Column(length = 100)
    private String cwriter;

    @Column(nullable = false,length = 400)
    private String ccontent;


    //entity->dto로 변환
    public CommentDto toDto() {
        return CommentDto.builder()
                .cno(cno)
                .bno(boardEntity.getBno())
                .cwriter(cwriter).ccontent(ccontent).createDate(getCreateDate().toString()).updateDate(getUpdateDate().toString())
                .build();
    }

}
