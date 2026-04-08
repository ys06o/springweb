import { useEffect, useState } from "react";
import { Link } from "react-router-dom";
import axios from "axios";

export default function Header(props) {

    // [2] 로그인 상태를 저장하는 상태변수
    const [login, setLogin] = useState(false); 

    // [3] 로그인중인 회원 정보를 담는 상태변수
    const [user, setUser] = useState(null);


    // [1] 로그인 상태에 따라 메뉴 분기
    const getMyInfo = async () => {
        
        // 3. 헤더에 표시할 로그인아이디 정보
        const response = await axios.get(
            'http://localhost:8080/api/member3/my/info'
            , {withCredentials: true} //header에 토큰 전송이 아닌 쿠키 안에 토큰 전송으로 변경
        );
        // 4. 통신 결과 갖고오기
        const data = response.data;
    
        if (data != null && data != false) { 
            setLogin(true); 
            setUser(data); 
        } else {
            setLogin(false);
        }
    } 

    // 헤더가 열리면 최초 1번 실행
    useEffect(() => { getMyInfo(); }, []); 


    //[5]로그아웃
    const logout =async()=>{
        //1.axios 활용
        const response=await axios.get("http://localhost:8080/api/member3/logout", //통신할 서버의 경로
            {withCredentials:true}) //쿠키 전송
        setLogin(false);
        alert('로그아웃');
        location.href="/";
    } 

    return (
        <div>
            <Link to="/">홈|</Link>
            <Link to="/board">게시물</Link>
            {/* 비로그인 메뉴 */}
            {!login && (<>
                <Link to="/member/login">로그인</Link>
                <Link to="/member/signup">회원가입</Link>           
            </>)}   

            {/* 로그인 메뉴 */}
            {login && user && (<> {/* user가 null일 경우를 대비해 && user 추가 */}
                <span>{user.mid} 님</span>
                <Link to="/member/page">내정보</Link>
                <Link to="/board/write">글쓰기</Link>
                <button onClick={logout}>로그아웃</button>
            </>)}
            <hr />
        </div>
    )
}