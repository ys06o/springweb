//FrontComp
//p.110 컴포넌트 내보내기? 다른jsx에서 해당하는 컴포넌트를 사용하기 위해서!
export default function FrontComp(props){
  return(<>
  <li>
    <a href="/" onClick={()=>{
      event.preventDefault;
      props.onSetMode('front')}}>프론트엔드</a>

  </li>
  <ul>
    <li>HTML5</li>
    <li>CSS5</li>
    <li>JAVA</li>
    <li>SPRING</li>
  </ul>
  </>);
}
