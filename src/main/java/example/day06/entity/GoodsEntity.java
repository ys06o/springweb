package example.day06.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder // 롬복
@Entity// + 영속성
@Table(name = "goods") // 생략시 클래스명으로 자동설정
public class GoodsEntity extends BaseTime {
    @Id // JPA는 엔티티내 1개 이상의 primary key 필수로 한다.
    @GeneratedValue( strategy = GenerationType.IDENTITY ) // auto_increment
    private Integer gno; // 제품번호
    @Column( name = "제품명" , nullable = false , length = 100 , unique = true , insertable = true , updatable = true  )
    private String gname; // 제품명
    @Column( columnDefinition = "varchar(100) default '제품설명' not null" )
    private String gdesc; // 제품설명
    // @Column // 생략가능시 : 자바의 타입--> SQL 타입 , 자바의 변수명 --> SQL 필드명
    private Integer gprice; // 제품가격


    //entity->dto로 변환하는 함수
    public GoodsDto toGoodsDto() {
        return GoodsDto.builder()
                .gno(this.gno)
                .gname(this.gname)
                .gprice(this.gprice)
                .gdesc(this.gdesc)
                .updateDate(getUpdateDate().toString())
                .createDate(getCreateDate().toString())
                .build();
    }
} // class end
/*
    @Id :  primary key
    @GeneratedValue( strategy = GenerationType.IDENTITY ) : auto_increment
    @Column( ) , 생략시 기본값 적용
        name = "필드명"               , 기본값은 자바필드명
        nullable = false             , 기본값은 true , not null
        length = 길이                 , 기본값은 255 , varchar(길이)
        unique = true                , 기본값은 false , 중복여부
        insertable = true ,         , 기본값은 true , insert 할 때 적용여부
        updatable = true            , 기본값은 true , update 할 때 적용여부
        columnDefinition = "SQL"    , JPA가 아닌 네이티브(실제SQL) 쿼리 작성

    레코드 생성( 회원가입/등록일/주문일/작성일 등등)날짜 / 수정날짜

*/













