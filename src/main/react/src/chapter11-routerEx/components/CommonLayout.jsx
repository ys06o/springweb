import { Outlet } from "react-router-dom";

export default function CommomLyaout(props){
    return(<>
    <div>
    <header style={{background:'lightgray',padding:'10px'}}>
        outlet 컴포넌트 알아보기
    </header>
    <article>
        <Outlet />
    </article>
    <footer style={{background:'lightgray',padding:'10px'}}>
        공통 레아아웃
    </footer>
    </div>
    </>)
}