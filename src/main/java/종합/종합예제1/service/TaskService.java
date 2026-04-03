package 종합.종합예제1.service;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import 종합.종합예제1.dto.TaskDto;
import 종합.종합예제1.entity.TaskEntity;
import 종합.종합예제1.repository.TaskRepository;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
@RequiredArgsConstructor
public class TaskService {

    private final TaskRepository taskRepository;
    public TaskDto taskPost(TaskDto taskDto){
        return taskRepository.save(taskDto.toEntity()).toDto();
    }

    // [2] 전체조회
    public List<TaskDto> taskList(){
        return taskRepository.findAll().stream().map(TaskEntity::toDto).collect(Collectors.toList());
    }

    //[3]업무 요청 상세 조회
    public TaskDto getTaskDetail(Integer id) {
        TaskEntity taskEntity=taskRepository.findById(id).orElseThrow();
        return taskEntity.toDto();
    }

    //[4]업무 요청 수정
    @Transactional
    public TaskDto updateTask(Integer id,TaskDto updateRequest){
        TaskEntity taskEntity=taskRepository.findById(id).orElseThrow();
        taskEntity.setTitle(updateRequest.getTitle());
        taskEntity.setContent(updateRequest.getContent());
        taskEntity.setStatus(updateRequest.getStatus());
        return taskEntity.toDto();
    }


    //[5]업무 삭제 요청
    public void deleteTask(Integer id) {
        TaskEntity task = taskRepository.findById(id).orElseThrow();
        taskRepository.delete(task);
    }

} //class end
