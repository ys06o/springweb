package 종합.예제10.board.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import 종합.예제10.board.entity.BoardEntity;
import 종합.예제10.board.entity.CommentEntity;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CommentDto {
    private Integer cno;      // 댓글 번호
    private Integer bno;      // 게시물 번호
    private String cwriter;   // 작성자
    private String ccontent;  // 내용
    private String createDate;   // 작성일
    private String updateDate;   //수정일


    //dto->entity로 변환
    public CommentEntity toEntity() {
        return CommentEntity.builder()
                .cno(cno).cwriter(cwriter).ccontent(ccontent).build();
    }




} //class end
