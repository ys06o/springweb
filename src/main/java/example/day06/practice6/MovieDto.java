package example.day06.practice6;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class MovieDto {
    private Integer movieId;
    private String title; //영화제목
    private String director; //감독
    private String releasedate; //개봉일
    private Integer rating; //평점


    //Dto를 entity로 변환
    public MovieEntity toEntity() {
        return MovieEntity.builder()
                .movieId(this.movieId)
                .title(this.title)
                .director(this.director)
                .releasedate(this.releasedate)
                .rating(this.rating)
                .build();
    }

}
