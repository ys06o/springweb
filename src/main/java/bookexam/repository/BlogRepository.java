package bookexam.repository;

import bookexam.domain.Article;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BlogRepository  extends JpaRepository<Article,Long> {
}
