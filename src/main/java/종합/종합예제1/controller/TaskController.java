package 종합.종합예제1.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import 종합.종합예제1.dto.TaskDto;
import 종합.종합예제1.service.TaskService;

@RestController
@CrossOrigin(origins = "http://localhost:5173") // 서로 다른 port(프로그램식별번호) 간의 통신 허용
// SOP 정책으로 서로 다른 도메인은 통신이 불가능하다. HTTP 보안 정책
// CORS : 교차 출처 리소스 공유 , 즉] 서로 다른 도메인(8080스프링,5173리액트) 통신 공유 허용
@RequiredArgsConstructor // final 멤버변수 생성자 자동(  @Autowired )
@RequestMapping("/api/task") // 리액트 경로 = /task vs 스프링 경로 = /api/task 중복될 수 있으므로 구분한다.
public class TaskController {
    private final TaskService taskService;


    // [1] 등록
    @PostMapping
    public ResponseEntity<?> taskPost(@RequestBody TaskDto taskDto) {
        return ResponseEntity.ok(taskService.taskPost(taskDto));
    }

    // [2] 전체조회
    @GetMapping
    public ResponseEntity<?> taskList() {
        return ResponseEntity.ok(taskService.taskList());
    }

    //[3]업무 요청 상세 조회
    @GetMapping("/detail")
    public ResponseEntity<?> getTaskDetail(@RequestParam Integer id) {
        return ResponseEntity.ok(taskService.getTaskDetail(id));
    }

    //[4] 업무 요청 수정
    @PutMapping
    public ResponseEntity<?> updateTask(@RequestParam Integer id, @RequestBody TaskDto updateRequest) {
        return ResponseEntity.ok(taskService.updateTask(id,updateRequest));
    }

    //[5]업무 요청 삭제
    @DeleteMapping
    public ResponseEntity<?> delete(@RequestParam Integer id) {
        taskService.deleteTask(id);
        return ResponseEntity.noContent().build();
    }
}