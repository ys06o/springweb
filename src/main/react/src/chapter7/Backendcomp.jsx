const BackendComp=({Setmode})=>{
  return(<>
  <li>
    <a href="/" onClick={()=>
    {event.preventDefault;
      Setmode('back')}}>백엔드</a>
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