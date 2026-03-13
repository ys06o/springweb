const BackendComp=({onMyEvent2})=>{
  return(<>
  <li>
    <a href="/" onClick={
      ()=>{onMyEvent2('백엔드클릭됨')}
      }>백엔드</a>
  </li>
  <ul>
    <li>HTML5</li>
    <li>CSS5</li>
    <li>JAVA</li>
    <li>SPRING</li>
  </ul>
  </>);


} //func end
export default BackendComp;