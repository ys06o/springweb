//컴포넌트 만드는방법
//1.해당 폴더를 오른쪽 클릭 ->new file클릭->
//2. .jsx 파일 확장자로 첫글자를 대문자로!
// ex) Exam1.jsx

//3.function 컴포넌트명
//4.컴포넌트내 return (<>jsx문법</>)
function MyComponent(props){
  //props에 존재하지 않는 속성명은 출력되지 않는다.
  return (<>  
  <p>
    {props.p1},{props.p2},{props.p3},{props.p4},{props.p5}
  </p>
  </>)
}

//구조분해 사용하여 필요한 속성만 받기
function MyComponent2({p1,p3}){
  return(<>
  <p>{p1},{p3}</p>
  </>)
}
function Exam1(){
  const frontData=['html5','css5','javascript','jquery'];
  const backData=['java','oracle','jsp','spring boot'];
  return (<>
  <h3>프롭스 예제</h3>
  <FrontComp propsData1={frontData} frTitle="프론트엔드"></FrontComp>
  <BackComp propsData2={backData} beTtile={"백엔드"}></BackComp>
  <h3>props 객체 예제 p.90</h3>
  <MyComponent p1={"html"} p2={"css"} p3={"javascript"} p4={"jquery"} ></MyComponent>
  <MyComponent2 p1={"html"} p2={"css"} p3={"javascript"} p4={"jquery"} ></MyComponent2>
  </>)
}


function FrontComp(props){ //props는 함수/컴포넌트이 매개변수이며 프롭스 객체이다.
  console.log(props);
  const liRows=[];
  for(let i=0; i<props.propsData1.length; i++){
    liRows.push(
      <li key={i}>{props.propsData1[i]}</li>
    );
  }
  return (<>
  <li>{props.frTitle}</li>
  <ul>
    {liRows}
  </ul>
  </>)
}

const BackComp=({propsData2,beTtile})=>{
const liRows=[];
let keyCnt=0;
for(let row of propsData2){
  liRows.push(
    <li key={keyCnt++}>{row}</li>
  );
}
return (
  <>
    <li>{beTtile}
      <ul>{liRows}</ul>
    </li>
  </>
)
} //func end
export default Exam1;


// const user = { name: "철수", age: 25, job: "개발자" };

// // 기존 방식
// const name = user.name;
// const age = user.age;

// // 구조 분해 할당
// const { name, age, job } = user;

// console.log(name); // "철수"
// console.log(age);  // 25