package 종합.예제10.member.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface MemberRepository extends JpaRepository<종합.예제10.member.entity.MemberEntity,Long> {

    // [1] 아이디로 엔티티 찾기
    // findBy필드명( 값 ) : 필드명은 카멜 규칙!!!
    Optional<종합.예제10.member.entity.MemberEntity> findByMid(String mid );
    //vs
    // @Query(value = "select * from member where mid = :mid",nativeQuery = true)
    // MemberEntity query( String mid );
}








