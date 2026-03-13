package bookexam.service;

import bookexam.domain.Article;
import bookexam.dto.AddArticleRequestDto;
import bookexam.dto.UpdateArticleRequest;
import bookexam.repository.BlogRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BlogService {
    private final BlogRepository blogRepository;

    //블로그 글 추가
    public Article save(AddArticleRequestDto requestDto){
        return blogRepository.save(requestDto.toEntity());
    }

    //블로그 글 모두 가져오기
    public List<Article> findAll(){
        return blogRepository.findAll();
    }

    public Article findById(long id){
        return blogRepository.findById(id)
                .orElseThrow(()->new IllegalArgumentException("not found"+id));
    }

    public void delete(long id){
        blogRepository.deleteById(id);
    }



     //블로그 글 수정하기


    @Transactional
    public Article update(long id, UpdateArticleRequest request){
        Article article=blogRepository.findById(id)
                .orElseThrow(()->new IllegalArgumentException("not found"+id));
        article.update(request.getTitle(),request.getContent());
        return article;
    }



} //class end