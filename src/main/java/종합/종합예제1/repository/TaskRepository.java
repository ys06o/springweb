package 종합.종합예제1.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import 종합.종합예제1.entity.TaskEntity;

@Repository
public interface TaskRepository extends JpaRepository<TaskEntity,Integer> {

}
