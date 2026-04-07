package 종합.예제10.member.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor @AllArgsConstructor @Data @Builder
public class MemberDto {
    private Long mno;
    private String mid;
    private String mpwd;
    private String mname;
    // + BaseTime 멤버변수
    private String createDate;
    private String updateDate;
    // + DTO --> ENTITY , 주로 저장/수정 일때 사용
    public 종합.예제10.member.entity.MemberEntity toEntity(){
        return 종합.예제10.member.entity.MemberEntity.builder()
                .mid( mid )
                .mpwd( mpwd )
                .mname( mname )
                .build();
    }
}












