package 종합.예제10.board.respository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BoardRepository extends JpaRepository<종합.예제10.board.entity.BoardEntity,Long> {
}
