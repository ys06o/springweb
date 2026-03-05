package example.day05.mvc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ExamController {
    @Autowired
    private ExamService examService;

    //R:조회 select
    @GetMapping("/day05/exam")
    public List<ExamDto> 전체조회() {
        List<ExamDto> result = examService.전체조회();
        return result;
    } //end

    //C:쓰기 insert
    @PostMapping("/day05/exam")
    public boolean 저장(@RequestBody ExamDto examDto) {
        boolean result = examService.저장(examDto);
        return result;
    } //저장 end

    //D:삭제 delete
    @DeleteMapping("/day05/exam")
    public boolean 삭제(@RequestParam int eno) {
        boolean result = examService.삭제(eno);
        return result;
    } //삭제 end


    //U:수정 update
    @PutMapping("/day05/exam")
    public boolean 수정(@RequestBody ExamDto UpdateDto){
        boolean result=examService.수정(UpdateDto);
        return result;
    } //수정 end
} //class end
