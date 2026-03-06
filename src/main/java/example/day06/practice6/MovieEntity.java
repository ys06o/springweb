package example.day06.practice6;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "movie")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class MovieEntity extends BaseTime {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer movieId;

    @Column(name = "영화제목",nullable = false,length = 100,unique = true)
    private String title; //영화제목

    @Column(name = "영화감독",nullable = false,length = 50)
    private String director; //감독

    private String releasedate; //개봉일

    private Integer rating; //평점


    //Entity를 dto로 변환

    public MovieDto toDto() {
        return MovieDto.builder()
                .movieId(this.movieId)
                .title(this.title)
                .director(this.director)
                .releasedate(this.releasedate)
                .rating(this.rating)
                .build();
    }
}
