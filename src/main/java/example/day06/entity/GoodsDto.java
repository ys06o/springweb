package example.day06.entity;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class GoodsDto {
    private Integer gno; // 제품번호
    private String gname; // 제품명
    private String gdesc; // 제품설명
    private Integer gprice; // 제품가격


    //*baseTime
    private String createDate;
    private String updateDate;

    //** Dto->entity로 변환 함수
    public GoodsEntity toEntity(){
        //this란? 해당 함수를 실행한 객체
        return GoodsEntity.builder() //빌더 시작
                .gno(this.gno)
                .gname(this.gname)
                .gprice(this.gprice)
                .gdesc(this.gdesc)
                .build(); //빌더 끝
    } //func end


} //class end
