package 종합.예제10.board.service;

import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import 종합.예제10.board.dto.BoardDto;
import 종합.예제10.board.entity.BoardEntity;
import 종합.예제10.board.repository.BoardRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class BoardService {
    @Autowired
    private BoardRepository boardRepository;




    //1. 등록 , 서비스는 HTTP 담당하지 않는다.
    public boolean 등록(BoardDto boardDto ){
        // 1. 저장할 dto --> entity 변환한다.
        BoardEntity saveEntity = boardDto.toEntity();
        // 2. JPA 이용한 entity 저장
        saveEntity = boardRepository.save( saveEntity );
        // 3. PK 생성여부 판단
        if( saveEntity.getBno() >=1 ) return true;
        return false;
    }

    //2.전체 조회
    public List<BoardDto> 전체조회() {
        //1.jpa를 이용한 모든 엔티티 조회
        List<BoardEntity> boardEntityList =boardRepository.findAll();
        List<BoardDto> newlist=new ArrayList<>();
        //2.조회된 모든 entity를 dto로 변환
        boardEntityList.forEach((boardEntity -> {
            BoardDto boardDto=boardEntity.toDto();
            newlist.add(boardDto);
        }));
        return newlist;

    } //func end


    //3.개별 조회
    public BoardDto 개별조회(int bno){
        //1.조회할 번호의 엔티티 찾기
        //2.만약에 엔티티가 존재하면
        java.util.Optional<BoardEntity> optional =boardRepository.findById(bno);
        if(optional.isPresent()){
            BoardEntity entity=optional.get();
            BoardDto boardDto=entity.toDto();
            return boardDto;
        }
        return null;

    } //class end


    //4.게시물 수정
    public boolean 개별수정(BoardDto boardDto) {
        //1.수정할 게시물번호로 엔티티 찾기
        java.util.Optional<BoardEntity> optional =boardRepository.findById(boardDto.getBno());
        if (optional.isPresent()) {
            BoardEntity entity =optional.get();
            entity.setBcontent(boardDto.getBcontent());
            entity.setBtitle(boardDto.getBtitle());
            entity.setBwriter(boardDto.getBwriter());
            return true;
        }
        return false;
        //2.만약에 엔티티가 존재하면 엔티티 수정
        //3.반환한다.

    } //func end


    //5.게시물 삭제
    public boolean 개별삭제(int bno) {
       boolean result=boardRepository.existsById(bno); //존재하면 true ,없으면 false
        if(result) {
            boardRepository.deleteById(bno);
            return true;
        }
        return false;

    } //func end



} //class end
