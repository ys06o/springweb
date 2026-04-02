import { useEffect, useState } from "react"
import axios from 'axios'
function RandomUser(props){

    //1.상태변수 선언.객체(배열)초기값
    const [MyJSON,setMYJSON]=useState({results:[]});
    const axiosA=async()=>{
        const response=await axios.get('https://api.randomuser.me?results=100')
        const 응답=response.data;
        setMYJSON(응답);
    }
    useEffect(function(){
        axiosA();
    },[]);

    //[2]<table>마크업내 tr구성하는 함수
    let trTag=MyJSON.results.map((data)=>{
        return(<>
        <tr key={data.login.md5}>
            <td><img src={data.picture.thumbnail} alt={data.login.username} /></td>
            <td><a href="/"></a></td>
            <td>{data.name.title}{data.name.first}{data.name.last}</td>
            <td>{data.nat}</td>
            <td>{data.email}</td>
        </tr>
        </>)
    });

    return(<>
    <div>
        <table border='1'>
            <thead>
                <tr>
                    <th>사진</th> <th>로그인</th> <th>이름</th>
                    <th>국가</th> <th>이메일</th>
                </tr>
            </thead>
            <tbody>
                {trTag}
            </tbody>
        </table>
    </div>
    </>)

} //func end




export default function ExternalApiFetcher(props){
    return(<>
    <h2>외부 서버 통신</h2>
    <RandomUser on></RandomUser>
    </>)
}