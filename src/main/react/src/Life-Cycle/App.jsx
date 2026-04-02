import { Route, Routes } from "react-router-dom";
import TopNavi from "./components/TopNavi";
import Lifecycle from "./components/Lifecycle";
import LocalJsonFethcer from "./components/LocalJsonFetcher";
import ExternalApiFetcher from "./components/ExternalApiFetcher";

export default function App(props){
    return(<>
    {/*새로운 컴포넌트 페이지를 만들면 라우터에 연결 */}
    <TopNavi></TopNavi>
    <Routes>
        <Route path="/" element={<Lifecycle />}></Route>
        <Route path="/local" element={<LocalJsonFethcer/>}></Route>
        <Route path="/external" element={<ExternalApiFetcher/>}></Route>
    </Routes>
    </>)

    
}