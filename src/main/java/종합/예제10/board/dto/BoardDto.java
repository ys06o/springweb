package 종합.예제10.board.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.web.multipart.MultipartFile;

@NoArgsConstructor @AllArgsConstructor @Data @Builder
public class BoardDto {
    private Long bno; // 게시물번호
    private String btitle; // 게시물제목
    private String bcontent; // 게시물내용
    private String bfile; // DB용도
    // + Dto에는 엔티티 정보를 포함하지 않고 필요한 정보만 멤버변수 구성한다.
    private Long mno; // 회원번호
    private String mname; // 회원닉네임
    // + BaseTime 멤버변수
    private String createDate;
    private String updateDate;
    // + 첨부파일 매핑 , 여러개 이면 : List< MultipartFile >
    private MultipartFile uploadFile; // 업로드용도

    // + toEntity
    public 종합.예제10.board.entity.BoardEntity toEntity( ){
        return 종합.예제10.board.entity.BoardEntity.builder()
                .btitle( btitle )
                .bcontent( bcontent )
                .bfile( bfile )
                //.memberEntity( ) fk는 서비스에서 대입
                .build();
    }
}









