
package example.종합.예제8.model.dao;
import example.종합.예제8.model.dto.BoardDto;

import java.sql.*;
import java.util.ArrayList;
public class BoardDao {
    //싱글톤 생성
    private BoardDao() {
        connect();
    }

    private static final BoardDao instance = new BoardDao();

    public static BoardDao getInstance() {
        return instance;
    }

    //========= 데이터베이스 연동==========//
    //1)연동할  db서버의 정보
    private String url = "jdbc:mysql://localhost:3306/boardservice7";
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

    //[1] 게시물 등록 dao
    public boolean write(String bcontent, String bwriter) {

        try {
            // 1.SQL 작성한다. 저장->c->insert
            String sql = "insert into board(bcontent,bwriter)values(?,?)";  //변수값이 들어갈 자리
            //2.연동된 (Conn)인터페이스에 기재한다. 내가 작성한 sql을 기재한다. 반환 preparedStatement
            PreparedStatement ps = conn.prepareStatement(sql);
            //3.sql이 기재된(ps) 인터페이스에 sql매개변수 대입
            ps.setString(1, bcontent); //ps.set타입명(?순서번호,값)  //String 타입으로 1번 ?에 bcontent 값을 대입
            ps.setString(2, bwriter); //String 타입으로 sql내 2번 ?에 bwriter를 대입한다.
            //4.매개변수까지 대입하여 준비가 끝났으면  sql 실행
            int count = ps.executeUpdate();  //ps.executeUpdate(); 반환값은 반영된 레코드수
            System.out.println("결과 레코드 수: " + count);
            //5.sql 실행 후 반영된 레코드 수에 따른 결과 제어
            if (count == 1) {
                return true;
            } else {
                return false;
            }
        } catch (SQLException e) {
            System.out.println("sql 문법 문제 발생" + e.getMessage());
        }
        return false; //실패
    } // write end

    //[2]게시물 삭제 dao
    public boolean delete(int bno) {
        try {
            //1]sql 작성 ?는 매개변수가 들어갈 자리
            String sql = "delete from board where bno=?";
            // 2]연동된[Conn]인터페이스에 sql을 기재한다.+일반예외
            PreparedStatement ps = conn.prepareStatement(sql);
            //와일드카드 ?에 매개변수 대입  ps.set타입명(순서번호,값)
            ps.setInt(1, bno);
            //4.sql 실행 실행후 반영된 레코드 수 반영
            int count = ps.executeUpdate();
            if (count == 1) {
                return true; //삭제된 레코드수가 1이면 삭제 성공
            } else {
                return false;
            }
        } catch (SQLException e) {
            System.out.println("sql 문법 오류" + e.getMessage());
        }
        return false; //실패
    } //delete end

    //게시물 수정 dao
    public boolean update(int bno, String bcontent) {
        try {
            //1.sql작성
            String sql = "update board set bcontent=? where bno=?";
            //2.sql 기재
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, bcontent);
            ps.setInt(2, bno);
            //4.sql 실행
            int count = ps.executeUpdate();
            if (count == 1) {
                return true;
            } else {
                return false;
            }
        } catch (SQLException e) {
            System.out.println("sql 문법 오류 발생" + e.getMessage());
        }
        return false;
    }

    //[2]게시물 전체 조회 dao

    public ArrayList<BoardDto> findAll() {
        ArrayList<BoardDto> boards = new ArrayList<>(); //조회 결과들을 레코드들을 리스트/배열 선언
        try {
            String sql = "select*from board";
            PreparedStatement ps = conn.prepareStatement(sql);
            //매개변수 없으므로 생략
            ResultSet rs=ps.executeQuery(); //sql실행후 몇개 조회 했는지가 아닌 조회 결과 제어
//            ps.executeUpdate(); // ps.executeUpdate()는 insert,update,delete vs ps.executeQuery():select
            // ResultSet:select 결과물을 제어 하는 인터페이스
            while (rs.next()) { //while(논리) {}반복문 //rs.next():조회 결과에서 다음레코드로 1번 이동
                // rs.get타입명(속성명):현재 레코드의 속성 값 호출
                int bno = rs.getInt("bno");
                String bcontent = rs.getString("bcontent");
                String bwriter=rs.getString("bwriter");
                String bdate = rs.getString("bdate");
                // DTO 만들기
                BoardDto boardDto = new BoardDto(bno, bcontent, bwriter, bdate);
                //리스트에 저장
                boards.add(boardDto);
            } //while end
        } catch (Exception e) {
            System.out.println("sql 문법 오류"+e.getMessage());
        } //
        return boards; //리스트를 반환한다.
    }  //finaAll end

} //class end
