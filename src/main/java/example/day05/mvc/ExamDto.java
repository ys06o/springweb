package example.day05.mvc;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ExamDto {
    private Integer eno; //int 대신에 Integer
    private String ename; //이름
} //class end

//dto? 이동 객체
