package example.day07.자바참조;


import lombok.Data;
import lombok.ToString;

import java.util.ArrayList;
import java.util.List;

public class Exam1 {
    public static void main(String[] args) {


        //자바는 객체지향언어이다.
        //System:클래스
        //System.out:객체
        //System.out.println:함수/메소드
        //특정한 객체가 특정한 함수를 실행한다.  .은 참조
        System.out.println("출력");

        //[1]카테고리 객체 생성=클래스로 메모리 생성
        //동일한 클래스로 서로다른 객체를 생성함
        Category category=new Category();
        category.setCno(1);
        category.setCname("공지사항");

        Category category2=new Category();
        category2.setCno(2);
        category2.setCname("자유게시판");


        //[2]게시물 객체 생성
        // 참조란? 다른 곳에 위치한값 참고한다. 대조한다.
        //단방향:FK객체를 통해 PK를 참조하는것 처럼 ,특정한 객체를 통해 참조 객체를 참조한다.
        //즉 게시물 객체를 통해 카테고리 객체를 참조한다.
        //카테고리 객체를 통해 게시물 객체는 참조못한다.
        //2-1: 첫번째 게시물은 공지사항이다.
        //board가 카테고리를 참조하는것
        Board board=new Board();  //201호
        board.setBno(1);
        board.setBcontent("첫번째 게시물");
        board.setCategory(category); //첫번째 카테고리 객체를 게시물 객체에 대입한다.
        //201호안에 101호를 참조하겟다는 뜻 board안에 category가 들어가있다.

        //2-2두번째 게시물은 자유게시판이다. [FK]
        //즉 ORM기술은 이러한 객체 참조로 데이터베이스의 PK-FK 구현
        Board board2=new Board();  //202호
        board2.setBno(1);
        board2.setBcontent("두번째 게시물");
        board2.setCategory(category2); //202호안에 102호를 참조한다.




        //[3]카테고리가 게시물을 참조(양방향)
        //양방향:두 객체간의 서로 참조하는 관계,db에는 존재하지 않는다.
        //즉 ORM(JPA)는 단방향과 양방향 모두 지원한다. 특징:조회가 빠르다.
        //1.순환참조 문제점
        //2.복잡한 JOIN 고려
        //3.LAZY 지연로딩 고려

        category.getBoardList().add(board);  //101호안에 201호 참조를 대입한다.
        category2.getBoardList().add(board2); //102호안에 202호 참조를 대입한다.


        // .StackOverflowError:순환참조
        //해결방안:두 객체 간의 한쪽 필드에 @ToString.Exclude 적용
        //확인
        System.out.println(board2.getCategory());
        System.out.println(category.getBoardList());
    } //main end
} //class end


@Data
class Category{
    private int cno; //카테고리번호
    private String cname; //카테고리이름
    @ToString.Exclude //순환 참조 방지
    private List<Board> boardList=new ArrayList<>(); //양방향 게시물 목록

} //class end


@Data
class Board{
    private int bno;
    private String bcontent;
    private Category category; //참조

} //class end