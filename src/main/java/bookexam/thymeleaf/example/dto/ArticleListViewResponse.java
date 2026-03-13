package bookexam.thymeleaf.example.dto;


import bookexam.domain.Article;
import lombok.Getter;
@Getter
public class ArticleListViewResponse {
    private final Long id;
    private final String title;
    private final String content;

    public ArticleListViewResponse(Article article) {
        this.id = article.getId(); //엔티티에 값을 dto값에 대입
        this.title = article.getTitle();
        this.content = article.getContent();
    }




}

