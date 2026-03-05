package example.day05.practice5;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class BookDto {
    private Integer bookId;
    private String bookName;
    private String author;
    private String publisher;

} //class end
