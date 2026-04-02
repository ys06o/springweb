import { Link,NavLink } from "react-router-dom";

export default function TopNavi(props){
    //<a>:a마크업은 클락하면 브라우저 전체 새로고침(깜빡임)
    //Link:클릭하면 새로고침 없이 URL 변경
    return(<>
    <nav>
        <a href="">Home</a><br/>
        <NavLink to="/intro">인트로</NavLink> <br/>
        <NavLink to="/intro/router">router관련 hook</NavLink><br/>
        <Link to="xyz">잘못된 예</Link>
    </nav>
    </>)
}