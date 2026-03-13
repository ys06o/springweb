/* [1]프론트 관련 컴포넌트*/

function FrontComp(){ //컴포넌트 생성방법 1 function 컴포넌트명(){}
                      //생성방법 2:함수내 return (<>HTML 코드</>)    
  return (<>
  <li>프론트엔드</li>
      <ul>
        <li>HTML 5</li>
        <li>CSS3</li>
        <li>JavaScript</li>
        <li>jQuery</li>
      </ul>
  </>)
}
/*[2]백엔드 관련 컴포넌트*/
const BackComp=()=>{
  return (<>
  <li>백엔드</li>
      <ul>
        <li>java</li>
        <li>oracle</li>
        <li>jsp</li>
        <li>spring boot</li>
      </ul>
  </>)
}


//[3]form관련 컴포넌트
let FormComp=function(){
  return (<>
  <form action="">
      <select>
        <option value="front">프론트엔드</option>
        <option value="backend">백엔드</option>
      </select>
      <input type="text" name="title"/>
      <input type="submit" value="추가"/>
  </form>
  </>)
}

function App() {

  return (<>
   <h2>react-기본</h2>
   <ol>
    <FrontComp/>
    <BackComp/>
   </ol>
   <FormComp></FormComp>
      </>)
}

export default App
