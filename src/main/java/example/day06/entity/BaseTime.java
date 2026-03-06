package example.day06.entity;

import jakarta.persistence.EntityListeners;
import jakarta.persistence.MappedSuperclass;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDateTime;
@Getter //2.상속받은 엔티티가 멤버변수를 사용
@Setter
@MappedSuperclass // 1]엔티티의 상속용도 클래스
@EntityListeners(AuditingEntityListener.class)
public class BaseTime {
    @CreatedDate //엔티티 생성날짜/시간 주입
    private LocalDateTime createDate;

    @LastModifiedDate //엔티티 수정날짜/시간 주입
    private LocalDateTime updateDate;
}
