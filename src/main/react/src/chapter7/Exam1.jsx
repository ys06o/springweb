import { useState } from "react"
import FrontComp from "./FrontComp";
import BackendComp from "./Backendcomp";

export default function Exam1(props){

  //1.useState 선언:const[변수명,set변수명]=useState(초기값);
  const[mode,setMode]=useState('both');

  //2.상태 값 변경하는 함수
  //set변수명(새로운값) setter랑 비슷한 개념
  const handleSetmMode=(code)=>{setMode(code);}

  //3.컴포넌트 저장용 변수 분기에 따른  화면에 나오는 결과물
  let contents='';

  //4.상태에 따라 컴포넌트 그리기,분기(if)
  if(mode=='front'){
    contents=<> 
    <FrontComp onSetMode={(mode)=>{setMode(mode);}}/>
    </>
  }
  else if(mode=='back'){
    contents=<>
    <BackendComp setMode={setMode} />
    </>}
  else{ //둘다 아니면?
    contents=<>
    <FrontComp onSetMode={(mode)=>{handleSetmMode(mode);}}/>
    <BackendComp setMode={handleSetmMode} />
    </>
  }

  //5.분기에 따른결과물을 return해서 출력한다.
  return (<>
  <h3>Chapter7</h3>
  <a href="/" onClick={()=>{setMode('both')}}>react State</a>

  <ol>
    {contents}
  </ol>
  </>)

} //func end