package 종합.예제10.board.dto;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import 종합.예제10.board.entity.BoardEntity;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder // 롬복
public class BoardDto {
    private Integer bno;
    private String btitle;
    private String bcontent;
    private String bwriter;
    private String createDate;
    private String updateDate;

    // + dto --> entity 변환함수 : 주로 저장 *
    public BoardEntity toEntity(){
        return BoardEntity.builder()
                // bno , createDate, updateDate 자동이라서 생략가능
                .btitle( btitle )
                .bcontent( bcontent )
                .bwriter( bwriter )
                .build();
    }
}