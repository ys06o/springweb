package 종합.예제10.board.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import 종합.예제10.board.dto.CommentDto;
import 종합.예제10.board.service.CommentService;

import java.util.List;

@RestController
public class CommentController {

    @Autowired
    private CommentService commentService;
    //댓글 생성
    @PostMapping("/board/comment")
    public boolean 댓글생성(@RequestBody CommentDto commentDto) {
        boolean result=commentService.댓글생성(commentDto);
        return result;
    }

    //댓글 삭제

    //댓글 수정

    //댓글 조회
    @GetMapping("/board/comment")
    public List<CommentDto> 댓글조회(@RequestParam int bno) {
        List<CommentDto> result=commentService.댓글조회(bno);
        return result;
    }

}
