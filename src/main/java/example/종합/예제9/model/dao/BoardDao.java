package example.종합.예제9.model.dao;

import example.종합.예제9.model.dto.BoardDto;
import org.springframework.stereotype.Component;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@Component  //bean 등록
public class BoardDao {
    public BoardDao(){connect();}
    //========= 데이터베이스 연동==========//
    //1)연동할  db서버의 정보
    private String url = "jdbc:mysql://localhost:3306/boardservice9";
    private String user = "root";
    private String password = "1234";
    //2)연동 인터페이스 선언
    private Connection conn;

    //3)연동 함수 정의,dao 생성자에서 실행(dao 싱글톤이 생성되면서 db연동 실행)

    private void connect() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver"); //mysql 라이브러리 객체 메모리 할당/불러오기
            conn = DriverManager.getConnection(url, user, password); //mysql 구현체로 db연동 후 연동 인터페이스의 반환
            System.out.println("[준비] 데이터베이스 연동 성공");
        } catch (Exception e) {
            System.out.println("[경고] 데이터베이스 연동 실패!" + e.getMessage());
        }
    } //connect end


    //1.전체 조회
    public List<BoardDto> findAll(){
        List<BoardDto> list=new ArrayList<>();
        try{
            String sql="select*from board";
            PreparedStatement ps=conn.prepareStatement(sql);
            ResultSet rs=ps.executeQuery();
            while (rs.next()){
                BoardDto boardDto=new BoardDto(rs.getInt("bno"),rs.getString("bcontent")
                        ,rs.getString("bwriter"),rs.getString("bdate"));
                list.add(boardDto);
            }
        }catch(Exception e){
            System.out.println(e);
        }
            return list;

    } //findAll() end


    //2.게시물 등록
    public boolean write(BoardDto boardDto){
        try{
            String sql="insert into board(bcontent,bwriter) values(?,?)"; //1.sql 작성
            PreparedStatement ps=conn.prepareStatement(sql); //2.sql 등록
            ps.setString(1, boardDto.getBcontent()); ///3.첫번째 매개변수 값에 대입
            ps.setString(2, boardDto.getBwriter());  ///3.두번째 매개변수 값에 대입
            int count=ps.executeUpdate(); //sql 실행하고 반영한 레코드 수를 저장한다.
            if(count==1){
                return true;
            }
        }catch(Exception e){
            System.out.println(e);
        }
        return false;
    } //write() end


    //3.게시물 수정
    public boolean update(BoardDto boardDto){
        try {
            String sql = "update board set bcontent=? where bno=?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, boardDto.getBcontent());
            ps.setInt(2,boardDto.getBno());
            int count=ps.executeUpdate();
            if(count==1) return true;
        }catch(Exception e){System.out.println(e);}
        return false;
    } //update() end    


    //게시물 삭제
    public boolean delete(int bno){
        try{
            String sql="delete from board where bno=?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1,bno);
            int count=ps.executeUpdate();
            if(count==1){
                return true;
            }
        }catch(Exception e){
            System.out.println(e);
        }
        return false;
    } //delete() end



    }//class end
