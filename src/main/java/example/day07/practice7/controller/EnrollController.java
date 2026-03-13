package example.day07.practice7.controller;

import example.day07.practice7.service.EnrollService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController


public class EnrollController {
    @Autowired
    private EnrollService enrollService;


    //1.과정등록
    @PostMapping("/course")
    public boolean 과정등록(@RequestBody Map<String, Object> map) {
        boolean result = enrollService.과정등록(map);
        return result;
    }

    //2.학생등록
    @PostMapping("/student")
    public boolean 학생등록(@RequestBody Map<String, Object> map) {
        boolean result = enrollService.학생등록(map);
        return result;
    } //func end

    //3.수강신청 등록
    //매개변수:status,courseId,studentId, {status:"신청","course":1,studentId:1}
    //반환값 boolean
    @PostMapping("/enroll")
    public boolean 수강등록(@RequestBody Map<String, Object> map) {
        boolean result = enrollService.수강등록(map);
        return result;
    } //func end


    //4. 개별 수강정보 조회
    @GetMapping("/get")
    public Map<String, Object> get(@RequestParam int enrollId) {
        return enrollService.get(enrollId);
    }
} //class end
