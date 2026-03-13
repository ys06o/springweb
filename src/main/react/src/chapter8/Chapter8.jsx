
import img2 from "../assets/이미지2.jpg";
import "./index.css"
export default function Chapter8(props){
  const myStyle={color:"white",backgroundcolor:"DodgerBlue",padding:"10px","fontfamily":"Verdana"}
  const iWidth={maxWidth:"300px"}
  return(<>
  <h3>스타일과 이미지 127p</h3>
  <ol>
    <li style={{color:"red"}}>프론트엔드</li>
    <ul>
      <li><img src="/img/이미지1.jpg" style={iWidth}></img></li>
      <li><img src={img2}></img></li>
      <li><img src="https://placehold.co/600*400"></img></li>
    </ul>
    <li className="backEnd">백엔드</li>
    <ul>
      <li id="backEndSub">java</li>
      <li className='warning'>oracle</li>
      <li style={myStyle}>jsp</li>
      <li>spring boot</li>
    </ul>
  </ol>
  </>)
}