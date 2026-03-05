package example.day05.practice5;


import example.day05.mvc.ExamEntity;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


@Service
@Transactional
public class BookService {
    @Autowired
    private BookRepository bookRepository;


    //모든 도서 조회
    public List<BookDto> Read() {
        List<BookEntity> bookEntities=bookRepository.findAll(); //db에서 모든 책 데이터를 엔티티로 가져옴
        List<BookDto> bookDtoList=new ArrayList<>(); //클라이언트에게 전달할 dto 리스트 생성
        //엔티티들을 하나씩꺼내서  반복
        bookEntities.forEach(bookEntity -> {
            BookDto bookDto=new BookDto(); //dto 생성
            bookDto.setBookId(bookEntity.getBookId()); //하나씩 담기 entity정보들을
            bookDto.setBookName(bookEntity.getBookName());
            bookDto.setPublisher(bookEntity.getPublisher());
            bookDto.setAuthor(bookEntity.getAuthor());
            bookDtoList.add(bookDto); //최종적으로 dtolist에 담기
        });

        return bookDtoList; //dtolist 반환
    } //read end


    //도서 등록기능
    public boolean Create(BookDto bookDto) {
        //저장할 dto를 entity로 변환
        BookEntity bookEntity=new BookEntity();
        bookEntity.setBookName(bookDto.getBookName()); //dto에 책이름을 엔티티에 책이름에 넣기
        bookEntity.setAuthor(bookDto.getAuthor());
        bookEntity.setPublisher(bookDto.getPublisher());
        //2.save를 이용해서 insert처리 하고 entity를 반환한다. 성공여부는 pk여부로 확인
        BookEntity saveEntity=bookRepository.save(bookEntity);
        //3.처리한 entity가 성공했는지 pk여부로 확인한다.
        if (saveEntity.getBookId() >= 1) {
            return true;
        }
        else{
            return false;
        }
    } //create end


    //도서 개별 삭제
    public boolean Delete(int bookId){
        bookRepository.deleteById(bookId);
        return true;
    }

    //도서 수정
    public boolean Update(BookDto bookDto) {
        java.util.Optional<BookEntity> optional =bookRepository.findById(bookDto.getBookId());
        if(optional.isPresent()){
            BookEntity examEntity=optional.get();
            examEntity.setBookName(bookDto.getBookName());
            return true;
        }
        return false;
    }


} //class end
