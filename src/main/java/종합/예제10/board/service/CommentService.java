package 종합.예제10.board.service;


import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import 종합.예제10.board.dto.CommentDto;
import 종합.예제10.board.entity.BoardEntity;
import 종합.예제10.board.entity.CommentEntity;
import 종합.예제10.board.repository.BoardRepository;
import 종합.예제10.board.repository.CommentRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Transactional
@Service
public class CommentService {
    @Autowired
    private CommentRepository commentRepository;
    @Autowired
    private BoardRepository boardRepository;
    //댓글생성
    public boolean 댓글생성(CommentDto commentDto) {

        //1.dto->entity로 변환하기
        CommentEntity saveCommentEntity=commentDto.toEntity();
        //2.어떤게시물에 달 댓글인지 확인
        java.util.Optional<BoardEntity> boardoptional =boardRepository.findById(commentDto.getBno());
        //3.게시물이 존재하면?
        if(boardoptional.isPresent()){
            saveCommentEntity.setBoardEntity(boardoptional.get());
            commentRepository.save(saveCommentEntity);
            return true;
        }
        return false;
    } //func end

    public List<CommentDto> 댓글조회(int bno) {

        //1.db에 있는 모든 댓글 목록을 가져오기
        List<CommentEntity> commentEntityList=commentRepository.findAll();

        List<CommentDto> commentDtoList=new ArrayList<>();
        commentEntityList.forEach((commentEntity -> {
            if (commentEntity.getBoardEntity().getBno().equals(bno)) {
                commentDtoList.add(commentEntity.toDto());
            }
        }));
        return  commentDtoList;
    }




} //class end
