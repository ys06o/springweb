package bookexam.dto;


import bookexam.domain.Article;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class ArticleListViewResponse {
    private  Long id;
    private  String title;
    private  String content;
    private LocalDateTime createAt;

    public ArticleListViewResponse(Article article) {
        this.id = article.getId(); //엔티티에 값을 dto값에 대입
        this.title = article.getTitle();
        this.content = article.getContent();
        this.createAt=article.getCreateAt();
    }


    public ArticleListViewResponse() {

    }
}

