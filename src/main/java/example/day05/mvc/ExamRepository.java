package example.day05.mvc;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ExamRepository extends JpaRepository<ExamEntity,Integer> {
    //extends JpaRepository<조작(crud)할 엔티티명,pk타입>

} //class end


//repository? db의 특정 테이블을 조작하는 인터페이스