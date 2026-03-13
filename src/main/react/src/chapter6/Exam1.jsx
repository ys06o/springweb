//컴포넌트 만드는방법:
//1.폴더 클릭해서 jsx파일 생성
//2.export default function 컴포넌트명 (props){}
//3.컴포넌트내 return (<>jsx문법 작성</>)
//컴포넌트 하나당 jsx파일 한개 관례적으로

import BackendComp from "./Backendcomp";
import FrontComp from "./FrontComp";

export default function Exam1(props){
  return (<>
  <h3>Chapter6</h3>
  <FrontComp></FrontComp>
  <BackendComp onMyEvent2={(msg)=>{alert('msg');}}> </BackendComp>
  </>);
}