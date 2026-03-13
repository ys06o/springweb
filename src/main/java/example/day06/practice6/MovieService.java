package example.day06.practice6;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class MovieService {
    @Autowired
    private MovieRepository movieRepository;
    //영화 등록
    public boolean 등록(MovieDto movieDto){
        //1.dto->entity로 변환 why? db에 저장해야하니까
        MovieEntity saved=movieRepository.save(movieDto.toEntity());
        boolean result=saved.getMovieId()>=1 ? true:false;
        return result;
    }


    //영화 수정
    public MovieDto 수정하기(int movieId, MovieDto movieDto) {
        Optional<MovieEntity> movieEntity=movieRepository.findById(movieId);
        if(movieEntity.isPresent()){
            MovieEntity entity=movieEntity.get();
            entity.setDirector(movieDto.getDirector());
            entity.setRating(movieDto.getRating());
            entity.setTitle(movieDto.getTitle());
            entity.setReleasedate(movieDto.getReleasedate());

            movieRepository.save(entity);
            return entity.toDto();
        }
        return null;
    } //class end



    //영화 삭제
    public boolean 삭제(int bookId){
        movieRepository.deleteById(bookId);
        return true;
    }

    //영화 개별 조회
    public MovieDto 개별조회(int bookId){
         Optional<MovieEntity> movie =movieRepository.findById(bookId);
         if(movie.isPresent()){
             //존재하면?
             MovieEntity entity = movie.get();
             return entity.toDto();
         }
         else{
             return null;
         }
    }

    //전체 조회
    public List<MovieDto> 전체조회() {
        //1.db에서 모든 영화목록을 엔티티로 가져옴
        List<MovieEntity> movieEntities=movieRepository.findAll();
        List<MovieDto> movieDtos=new ArrayList<>();
        //2.entity를 dto로 변환
        movieEntities.forEach((movieEntity -> {
            movieDtos.add(movieEntity.toDto());
        }));
        return movieDtos;
    }



} //class end
