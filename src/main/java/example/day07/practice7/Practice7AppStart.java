package example.day07.practice7;

import jakarta.persistence.EntityListeners;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

@SpringBootApplication
@EntityListeners(AuditingEntityListener.class)
public class Practice7AppStart {
    public static void main(String[] args) {
        SpringApplication.run(Practice7AppStart.class);
    }
}
