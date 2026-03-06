package example.day06.practice6;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/movie")
public class MovieController {

    @Autowired
    private MovieService movieService;
    //영화 등록 기능
    @PostMapping()
    public boolean 등록(@RequestBody MovieDto movieDto){
        boolean result= movieService.등록(movieDto);
        return result;
    }



    //수정



    //삭제
    @DeleteMapping
    public boolean 삭제(@RequestParam int movieId){
        boolean result=movieService.삭제(movieId);
        return result;
    }


    //조회
    @GetMapping
    public List<MovieDto> 전체조회(){
        List<MovieDto> result=movieService.전체조회();
        return result;
    }

} //class end
