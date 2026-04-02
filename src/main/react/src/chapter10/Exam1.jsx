import { useState } from 'react';

export default function Exam1() {
    const [myData, setMyData] = useState({
        font: ['html', 'css3', 'java'],
        back: ['javascript', 'clan'] // 오타 수정: javascrpic -> javascript
    });

    return (
        <>
            {/* 자식 컴포넌트에게 데이터를 전달하며 호출 */}
            <Topcomp MYData={myData} />
        </>
    );
}

const Topcomp = ({ MYData }) => {
    return (
        <ol>
            <li>프론트엔드</li>
            <ul>
                {MYData.font.map((item, i) => <li key={i}>{item}</li>)}
            </ul>
            <li>백엔드</li>
            <ul>
                {/* 중괄호{} 사용 및 태그 닫기 확인 */}
                {MYData.back.map((item, i) => <li key={i}>{item}</li>)}
            </ul>
        </ol>
    );
}

//1.렌더링 안되는 코드
const addFront=()=>{const newBack=[...myData.back]}
const addBack=()=>{const newBack=[]}