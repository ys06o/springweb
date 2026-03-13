package example.day03.practice3;


import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.ArrayList;

@RestController
@RequestMapping("/attendance")
public class AttendanceController {

    @PostMapping
    public boolean 출석등록(@RequestBody AttendanceDto attendanceDto){
        return true;
    }

    @GetMapping()
    public List<AttendanceDto> 출석전체조회(){
        List<AttendanceDto> list=new ArrayList<>();
        AttendanceDto attendanceDto=new AttendanceDto(1,"홍길동","2022-12-11","출석");
        AttendanceDto attendanceDto2=new AttendanceDto(3,"유재석","2022-12-11","결석");
        list.add(attendanceDto);
        list.add(attendanceDto2);
        return list;
    }

    @GetMapping("/detail")
    public AttendanceDto 출석개별조회(@RequestParam int ano){
        AttendanceDto attendanceDto = new AttendanceDto(2, "김용성", "2022-12-11", "출석");
        return attendanceDto;
    }
    //

    @DeleteMapping
    public boolean 출석삭제(@RequestParam int ano){
        return true;
    }

    @PutMapping
    public boolean 출석수정(@RequestParam int ano,@RequestParam String status){
        return false;
    }


}











