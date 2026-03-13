package example.day07.연관관계;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "reply")
public class ReplyEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer rno; //댓글 번호

    private String rcontent; //댓글 내용

    //단방향 FK만들기
    @ManyToOne(cascade =CascadeType.ALL,fetch =FetchType.EAGER ) //fk설정 제약조건
    @JoinColumn(name = "bno")  //fk 필드명
    private BoardEntity boardEntity;

} //class end

/*
    영속성이란? 자바객체와 데이터베이스와 데이터 간 매핑/연결 상태
    -영속성 해제? 자바객체와 데이터베이스 데이터 간 매핑/연결 해제한다는 뜻
    cascade 속성이란? pk와 fk제약조건 옵션
        CascadeType.ALL:부모가 삭제/수정/저장되면 자식도 같이 삭제/수정/저장에 같이 반영됨
        ex)board테이블이 삭제되면 reply테이블도 같이 삭제된다.
        CascadeType.REMOVE:부모가 삭제되면 자식도 같이 삭제가 반영된다. on delete cascade랑 동일하다.
        CascadeType.MERGE:부모가 수정되면 자식도 같이 수정된다. on update cascade랑 동일하다.
        CascadeType.DETACH:부모가 영속 해제되면 자식도 같이 영속 해제 된다.
        CascadeType.REFRESH:부모가 재호출(갱신)되면 자식도 같이 재호출 한다.
        CascadeType.PERSIST:부모가 저장되면 자식도 같이 저장된다. //참조중일때


       (CascadeType.ALL,fetch =FetchType.EAGER )
       fetch:부모 조회시 자식 관계에서 엔티티 조회여부 선택
       FetchType.EAGER:기본값 해당 엔티티 조회시 참조 엔티티 모두 즉시 조회한다.
        특징:초기 로딩 느리다. 재사용시 빠르다 불필요한 정보까지 있을경우 성능 저하
       FetchType.LAZY:지연 로딩 해당 엔티티 조회시 참조 엔티티는 조회하지 않는다.<참조 엔티티 호출시에만 조회한다.>
        특징:초기 로딩 빠르다. 재사용성 느리다. 필요한 정보만 호출가능




         단방향/양방향 활용
         -만약에 1번 카테고리에 게시물을  등록할 경우
         주의할점: fk필ㄷ에 fk값이 아닌 fk엔티티를 대입한다.
         Category category=repository.findById(1).get();

         BoardEntity saveEntity =new BoardEntity(); //
         saveEntity.SetCategory(1); X
         saveEntity.SetCategory(category); O
         repository.save(saveEntity);
 */


