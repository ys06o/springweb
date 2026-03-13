function 출력함수(){ //선언적 함수
  alert("출력된메시지");
} //func end


//익명함수: function(){alert("출력된 메세지2");}
//이름이 없는 함수(재사용 불가)
//일회성 또는 이벤트함수에서 사용

//화살표 함수? 이름이없고 화살표 표현식을 사용하는 함수(변수에 저장하여 재사용한다.)

function FrontComp(props){
  return (<>
  <li>
    <a href="/" onClick={()=>{props.onMyEvent1();}}>프론트엔드</a>

  </li>
  <ul>
    <li>html5</li>
    <li>css</li>
    <li>javascript</li>
    <li>jquery</li>
  </ul>
  </>)
} //func end
function Exam2(){
  return (<>
  <h3>이벤트 처리 p.100</h3>
  <button onClick={출력함수}>리액트버튼</button>
  <button onClick={function(){alert("출력된 메세지2");}}>리액트2</button>
  <button onClick={()=>{alert('화살표함수')}}>화살표함수</button>
  <FrontComp onMyEvent1={()=>{alert('프론트번트 클릭됨')}}> </FrontComp>
  </>)
} //func end



export default Exam2;

//리액트 이벤트 주의할점
//1.onclick->onClick ,합성이벤트
//2.onClick에서 함수를 실행하는 구조가 아니고 *전달*하는 구조이다.

//함수란? 여러개 계산식/코드의 묶음
//변수? 하나의 값을 저장하는 공간