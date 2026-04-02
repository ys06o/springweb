import { Routes, Route } from "react-router-dom"; // [1] 이거 필수!
import Home from "./components/Home";
import NotFound from "./components/NotFound";
import TopNavi from "./components/TopNavi";
import CommomLyaout from "./components/CommonLayout";
import LayoutIndex from "./components/LayoutIndex";
import RouterHooks from "./components/RouterHooks";

export default function RouterEx(props) {
    return (
        <>
            <TopNavi />
            <Routes>
    
                <Route path="/" element={<Home />} />


                <Route path="/intro" element={<CommomLyaout />}>
                <Route element={<LayoutIndex/>}></Route>
                <Route path="router" element={<RouterHooks />}></Route>
                </Route>

            
                <Route path="*" element={<NotFound />} />
            </Routes>
        </>
    );
} //func end