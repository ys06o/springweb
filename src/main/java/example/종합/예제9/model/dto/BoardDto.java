package example.종합.예제9.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor //매개변수가 없는 생성자 자동 생성
@AllArgsConstructor //전체 매개변수 생성자 자동 생성
@Data //  getter/setter/toString/RequriedArgsConstructor(final 맴버변수 생성자)
public class BoardDto {
    //멤버변수:데이터베이스의 속성명과 일치,+기능에 따라 추가
    private Integer bno; //게시물 번호  //int->Integer로 사용하여 null 값 대응 int는 null이 저장이 안됨
    private String bcontent; //작성 내용
    private String bwriter; //작성자
    private String bdate; //작성날짜
} //class end
