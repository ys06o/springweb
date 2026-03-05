package example.day05.mvc;

import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Transactional
@Service
public class ExamService {
    @Autowired
    private ExamRepository examRepository;

    //R:조회 select
    public List<ExamDto> 전체조회() {
        //*select 대신에 JPA함수 사용 //findAll:전체 엔티티/레코드/객체를 반환
        //findAll:전체조회 라는 뜻 entity라는 객체 반환
        List<ExamEntity> examEntityList=examRepository.findAll();


        //entity를 dto로 변경 <안전상/보안상> entity노출 방지
        //방법
        //1.여러개 dto를 저장할 리스트 선언
        //2.forEach(반복변수->{실행문;})
        //3.dto 선언
        //4.반복중인 entity객체내 멤버변수를 dto에 저장
        //5.dto를 리스트에 저장
        List<ExamDto> examDtoList=new ArrayList<>();
        examEntityList.forEach(entity->{
          ExamDto examDto=new ExamDto();
          examDto.setEno(entity.getEno());
          examDto.setEname(entity.getEname());
          examDtoList.add(examDto);
        }); //foreach end

        return examDtoList; //entity가 아닌 dto를 반환!
        //why? service개발자만 entity를 다룬다.


    } //전체조회 end


   //C:쓰기 insert
   public boolean 저장(ExamDto examDto) {
        //insert 대신에 JPA함수 사용
       // save(entity):해당엔티티를 insert
       //저장할 dto->entity로 변환
       ExamEntity examEntity=new ExamEntity();
       examEntity.setEname(examDto.getEname());
       //2.save를 이용한 insert 하고 처리한 entity 반환,pk여부로 확인
       ExamEntity savedEntity=examRepository.save(examEntity);
       //3.처리한 entity의 pk의 여부를
       if (savedEntity.getEno() >= 1) {
           return true;
       }
       else{
           return false;
       }

   } //저장 end


    //U:삭제 delete
    public boolean 삭제(int eno) {
        //delete 대신에 jpa함수 사용
       // .deleteById(삭제할pk번호):해당하는 pk가 존재하면 삭제
        examRepository.deleteById(eno);
        return true;

    } //삭제 end

    //U:수정 update
    @Transactional

    public boolean 수정(ExamDto UpdateDto) {
        //update 대신에 jpa 영속성을 사용한다.
        //영속성??(계속되는 성질/능력) 사용한다.
        //데이터베이스와 자바객체 간의 연동 계속적으로 유지
        //즉 자바객체가 수정되면 데이터베이스도 자동으로 수정
        //1.수정할 엔티티 찾기,pk
        java.util.Optional<ExamEntity> optional =examRepository.findById(UpdateDto.getEno());
        //2.만약에 엔티티가 존재하면? isPresent():조회 결과가 있으면 true,아니면 false
        if(optional.isPresent()){
            //**********영속성을 이용한 수정*************//
            ExamEntity examEntity=optional.get(); //존재한 엔티티 꺼내기
            examEntity.setEname(UpdateDto.getEname()); //입력받은 값을 엔티티에 setter를 이용하여 수정한다.
            return true;
        }
        return false;
    } //수정 end

}//class end

/*
    1.제네릭타입,객체 생성할때 타입 지정
    2.Optional:객체내 null값 제어 기능/함수 제공하는 클래스 , null에 따른 안전한 객체 사용
    3. isPresent():만약에 null이면 false,아니면 true 반환
    4. .get():만약에 존재하면  객체 반환
    5.  .orElse(null일때 값)
    6. .orElseThrow(예외값)

   사용처:JPA에서 findById 반환 타입 그외 몇몇 라이브러리에서 사용된다.
   사용법:
    1]optional<entity> 변수명=repository.findById()
    2]entity 변수명=repository.findById().orElse()


//-영속된 객체를 setter를 이용하여 여러개 수정함으로써 update들을 하나로 처리한다.

 */



//JPA CRUD 기본 제공
//1. .findAll(): 모드 레코드/객체/엔티티 조회 , 반환타입은 list
//2. .save(저장할 entity):특정 엔티티를 저장 ,반환타입은 entity   pk값 확인
//3. .deleteById(삭제할 pk번호):특정 pk번호에 entity를 삭제 ,반환타입 x
//4. 수정함수는 존재하지 않는다. 영속성의 특징때문에 필요가 없다.
//영속성? 데이터베이스와 자바객체를 연결하는 관계(save,findAll,findById)
//영속된 엔티티를 setter를 이용하여 객체를 수정하면 자동으로 데이터베이스에 반영된다.
//@Transactional를 갖는 클래스/메소드는 여러sql들을 하나의 묶음으로 한번에 처리한다.
//트랙잭션이란?여러 sql들을 묶어서 하나라도 실패하면 모두 실패(rollback) 모두 성공이면 최종성공(commit)


