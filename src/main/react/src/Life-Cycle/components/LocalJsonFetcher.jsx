import { useEffect, useState } from "react";
import axios from 'axios';

// 1. 실제로 화면을 그릴 컴포넌트 하나로 합치기
export default function LocalJsonFetcher(props) {
    console.log("[1] 컴포넌트 실행");
    
    const [myList, setMyList] = useState([]); // 빈 배열 상태

    // 2. 데이터 가져오는 함수 (컴포넌트 내부 위치)
    const axios1 = async () => {
        try {
            // public/json/myData.json 경로 확인 필수!
            const response = await axios.get('./json/myData.json');
            setMyList(response.data);
        } catch (error) {
            console.error("데이터 로딩 실패:", error);
        }
    };

    // 3. 최초 1회 실행
    useEffect(() => {
        console.log('[3] useEffect 실행');
        axios1();
    }, []);

    // 4. 데이터 반복해서 태그 만들기 (함수 내부, return 바로 직전)
    const listTag = myList.map((data) => {
        return (
            <li key={data.id}>
                <a 
                    href={data.id} 
                    data-id={data.num}
                    onClick={(e) => {
                        e.preventDefault(); // 페이지 이동 방지
                        props.myListClcik(e.target.dataset.id);
                    }}
                >
                    {data.id}
                </a>
            </li>
        );
    });

    console.log('[2] return 실행');

    // 5. 최종 결과물 반환
    return (
        <>
            <h3>내부 서버 통신</h3>
            <nav>
                <ul>
                    {listTag}
                </ul>
            </nav>
        </>
    );
}