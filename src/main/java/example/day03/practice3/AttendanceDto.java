package example.day03.practice3;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder //빌더패턴
class AttendanceDto {
    private Integer ano; //출석번호
    private String StudentName; //학생이름
    private String date; //출석일
    private String status; //출석상태(결석/출석)
}
