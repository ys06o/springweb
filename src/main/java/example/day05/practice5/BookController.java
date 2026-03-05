package example.day05.practice5;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class BookController {
    @Autowired
    private BookService bookService;

    //도서 등록
    @PostMapping("/book")
    public boolean Create(@RequestBody BookDto bookDto) {
        boolean result = bookService.Create(bookDto);
        return result;
    }

    //도서 전체 조회

    @GetMapping("/book")
    public List<BookDto> Read() {
        List<BookDto> result = bookService.Read();
        return result;
    }


    //특정 도서 삭제
    @DeleteMapping("/book")
    public boolean Delete(@RequestParam int bookId) {
        boolean result = bookService.Delete(bookId);
        return result;
    }

    //특정 도서 수정
    @PutMapping("/book")
    public boolean Update(@RequestBody BookDto bookDto) {
        boolean result=bookService.Update(bookDto);
        return result;
    }
}
