package bookexam.domain;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Builder
public class Article {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id",updatable = false)
    private Long id;


    @Column(name = "title",nullable = false)
    private String title;


    @Column(name = "content",nullable = false)
    private String content;


    public void update(String title, String content) {
        this.title = title;
        this.content = content;
    }
}
