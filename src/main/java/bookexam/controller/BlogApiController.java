package bookexam.controller;

import bookexam.domain.Article;
import bookexam.dto.AddArticleRequestDto;
import bookexam.dto.ArticleResponse;
import bookexam.dto.UpdateArticleRequest;
import bookexam.service.BlogService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class BlogApiController {
    private final BlogService blogService;



    @PostMapping("/api/articles")
    public ResponseEntity<Article> addArticle(@RequestBody AddArticleRequestDto requestDto){
        //ResponseEntity<반환타입>:HTTP 응답 객체 수정/커스텀 가능하다. 응답정보 수정,포장하기,응답객체 포장
        Article saveArticle=blogService.save(requestDto);

        return ResponseEntity.status(HttpStatus.CREATED).body(saveArticle);

    } //



    //
    @GetMapping("/api/articles")
    public ResponseEntity<List<ArticleResponse>> findAllArticles(){
        List<ArticleResponse> articleResponses=blogService.findAll()
                .stream().map(ArticleResponse::new).toList();

        return ResponseEntity.ok().body(articleResponses);
    }


    @GetMapping("/api/articles/{id}")
    public ResponseEntity<ArticleResponse> findArticle(@PathVariable long id){

        Article article=blogService.findById(id);

        return ResponseEntity.ok().body(new ArticleResponse(article));
    }




    @DeleteMapping("/api/articles/{id}")
    public ResponseEntity<Void> deleteArticle(@PathVariable long id){
        blogService.delete(id);

        return ResponseEntity.ok().build();
    }


    @PutMapping("/api/articles/{id}")
    public ResponseEntity<Article> updateArticle(@PathVariable long id, @RequestBody UpdateArticleRequest request){
        Article updateArticle=blogService.update(id,request);

        return ResponseEntity.ok().body(updateArticle);
    }
} //class end
