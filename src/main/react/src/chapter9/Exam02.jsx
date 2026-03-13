import { useState } from "react";

function WriteForm(props){
  return(<>
  <form onSubmit={(event)=>{
    console.log('이벤트 객체 확인:',event);
    console.log(event.target);
    console.log(event.target.gubun);
    let gubun=event.target.gubun.value;
    let title=event.target.title.value;
    props.writeAction(gubun,title); //부모 컴포넌트로부터 받은 함수의 입력받은 구분과 타이틀을 대입하여 실행
    }}>
    <select name="gubun" id="">
  <option value="front">front</option>
  <option value="backend">backend</option>
    </select>
    <input type="text" name="title"/>
    <input type="submit" value="추가" />
  </form>
  </>)
}

export default function Exam2(props){
  //상태변수? 하나의 값을 저장하고 변경되면 해당 컴포넌트 재호출
  const [message,setMessage]=useState("폼값 전송 진행 중");
  const writeAction=(gubun,title)=>{
    if(gubun!=''&&title!=''){
      let frmValue=`검증완료 폼값:${gubun},${title}`;
      setMessage(frmValue);
    }
    else{
      alert('빈 칸 있음');
    }
  }
  return(<>
  <h3>135</h3>
  <WriteForm writeAction={writeAction}> </WriteForm>
  </>)
}