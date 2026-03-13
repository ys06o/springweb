package example.day02.practice2;

import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/board")
public class BoardController {



    private List<BoardDto> boardList = new ArrayList<>();

    // 1. 게시물 등록
    @PostMapping
    public boolean boardWrite(@RequestBody BoardDto boardDto) {
        return boardList.add(boardDto);
    }

    // 2. 게시물 전체 조회
    @GetMapping
    public List<BoardDto> boardPrint() {
        return boardList;
    }

    // 3. 게시물 개별 조회
    @GetMapping("/detail")
    public BoardDto boardDetail(@RequestParam("bno") int bno) {
        return boardList.stream()
                .filter(b -> b.getBno() == bno)
                .findFirst()
                .orElse(null);
    }

    // 3. 게시물 삭제
    @DeleteMapping
    public boolean boardDelete(@RequestParam("bno") int bno) {
        return boardList.removeIf(b -> b.getBno() == bno);
    }

    // 4. 게시물 수정
    @PutMapping
    public boolean boardUpdate(@RequestBody BoardDto boardDto) {
        for (BoardDto b : boardList) {
            if (b.getBno() == boardDto.getBno()) {
                b.setBcontent(boardDto.getBcontent());
                return true;
            }
        }
        return false;
    }

} //class end
