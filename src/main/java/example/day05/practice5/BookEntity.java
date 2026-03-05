package example.day05.practice5;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "book")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class BookEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) //auto_increment
    @Column(name = "bookid")
    private Integer bookId;

    @Column(name = "bookname",length = 100,nullable = false)
    private String bookName;

    @Column(name = "author",length = 100,nullable = false)
    private String author;

    @Column(name = "publisher",length = 100,nullable = false)
    private String publisher;

} //class end
