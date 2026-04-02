import { useLocation, useSearchParams } from "react-router-dom"

export default function(props){

    const location=useLocation();
    //1.useSearchparams를 선언한다. 목적:url 상의 쿼리스트링 값 가져오기
    const [searchParams,setSearchParams]=useSearchParams();
    const mode=searchParams.get('mode'); //쿼리스트링내 mode 변수값 가져오기
    const pageNum=searchParams.get('pageNum'); //쿼리스트링내 pageNum변수값 가져오기
    

    //2.만약에 mode가 list이면 view변경 아니면 list
    const changeMode=()=>{
        const nextMode=(mode==list)?'view':'list';
        searchParams({mode:nextMode,pageNum:pageNum})
    }

    //[3]nextPage,만약에 pageNum가 null 이면 1페이지 아니면 페이지+1
    const nextPage=()=>{
        let pageTemp=(pageNum==null||isNaN(pageNum)? 1:parseInt(pageNum)+1)
        setSearchParams({mode:mode,pageNum:pageTemp})
    }

    //[4]prevPage,만약에
    const prevPage=()=>{
        let pageTemp=(pageNum==null||isNaN(pageNum)? 1:parseInt(pageNum)-1)
        setSearchParams({mode:mode,pageNum:pageTemp})
    }
    return(<>
    <h2>라우터 관련 hook</h2>
    <div>
        <ul>
        <li>URL:{location.pathname}</li>
        <li>{location.search}</li>
        <li>{mode}</li>
        <li>pageNum:{pageNum}</li>
        </ul>
        <button onClick={changeMode}>체인지</button>
        <button onClick={prevPage}>전페이지</button>
        <button onClick={nextPage}>다음</button>
    </div>
    </>)
}