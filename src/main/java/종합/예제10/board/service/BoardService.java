package 종합.예제10.board.service;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;
import 종합.예제10.board.dto.BoardDto;
import 종합.예제10.board.entity.BoardEntity;

import java.util.List;
import java.util.Optional;

@Service @Transactional @RequiredArgsConstructor
public class BoardService {

    private final 종합.예제10.board.respository.BoardRepository boardRepository;
    private final 종합.예제10.member.repository.MemberRepository memberRepository; // + 회원리포지토리
    private final FileService fileService; // + 파일서비스

    // [1] 글쓰기
    public boolean write(종합.예제10.board.dto.BoardDto boardDto , String loginMid ){
        종합.예제10.board.entity.BoardEntity saveEntity = boardDto.toEntity(); // 1] dto --> entity 변환한다.
        // ****** 저장하기 전에 FK 대입하기 , FK의 엔티티를 찾아서 대입 *******//
        // 현재 로그인중인 mid로 엔티티 찾기
        Optional<종합.예제10.member.entity.MemberEntity> entityOptional = memberRepository.findByMid( loginMid );
        if( !entityOptional.isPresent() ){ // ! 부정문 , isPresnet() 아니면
            return false; // 존재하지않은 회원 으로 실패
        }
        // 저장할 게시물 엔티티에 set참조엔티티( 회원엔티티 );
        saveEntity.setMemberEntity( entityOptional.get() );

        // +++++++++ 최종 DB에 엔티티를 SAVE 하기 전에 첨부파일이 존재하면 업로드 +++++++++++//
        String fileName =  fileService.upload( boardDto.getUploadFile() ); // dto내 multipartFile 대입한다.
        // 만약에 업로드 했다면 저장할 엔티티에 업로드된 파일명 저장하기
        if( fileName != null ){ saveEntity.setBfile( fileName ); }

        종합.예제10.board.entity.BoardEntity savedEntity = boardRepository.save( saveEntity ); // 2] entity 저장한다.
        if( savedEntity.getBno() > 0 ){ return true; }
        else{ return false; }
    }


    //[2]전체 조회
    public List<BoardDto> findAll() {
        return boardRepository.findAll(Sort.by(Sort.Direction.DESC,"bno"))
                .stream().map(BoardEntity::toDto).toList();
    }



    //[3]개별 조회
    public BoardDto findById(@RequestParam Long bno) {
        return boardRepository.findById(bno).orElse(null)
                .toDto();
    }

} // class end






