package example.day08;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class TodoController {
    @Autowired
    private TodoRepository todoRepository;
    @PostMapping("/")
    public boolean 등록하기(@RequestBody TodoEntity todoEntity){
        todoRepository.save(todoEntity); //입력받은 값 저장
        return true;
    }


    @GetMapping("/")
    public List<TodoEntity> 조회하기() {
        return todoRepository.findAll();
    }


 } //class end
