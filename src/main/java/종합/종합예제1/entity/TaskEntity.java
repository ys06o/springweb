package 종합.종합예제1.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import 종합.종합예제1.dto.TaskDto;

@Entity
@Table(name = "task")
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class TaskEntity extends BaseTime{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String title;
    private String content;
    private String requester;
    private String status;

    public TaskDto toDto(){
        return TaskDto.builder()
                .id(this.id).title(this.title).content(this.content).requester(this.requester).status(this.status)
                .createAt(getCreateAt().toString()).updateAt(getUpdateAt().toString())
                .build();
    }

}