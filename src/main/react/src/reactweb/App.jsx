import { Routes, Route } from "react-router-dom";
// 경로 해석: 현재 폴더(./) -> pages -> member -> login
import Login from "./pages/member/Login"
import Header from "./components/Header";
import Write from "./pages/board/Write";
import Signup from "./pages/member/Signup";
import Board from "./pages/board/Board";
import View from "./pages/board/View"
export default function App(props) {
    return (
        <div id="wrap">
            <Header />
            {/* 헤더 위치 (필요 시 추가) */}
            <Routes>
                {/* Route 컴포넌트를 사용하여 경로와 컴포넌트 연결 */}
                <Route path="/member/login" element={<Login />} />
                <Route path="/board/Write" element={<Write/>}></Route>
                <Route path="/member/Signup" element={<Signup/>}></Route>
                <Route path="/board" element={<Board/>}></Route>
                <Route path="/board/view" element={<View/>}></Route>
                {/* 추가적인 페이지가 있다면 아래에 작성 */}
                {/* <Route path="/member/signup" element={<Signup />} /> */}
            </Routes>

            {/* 푸터 위치 (필요 시 추가) */}
        </div>
    );
}