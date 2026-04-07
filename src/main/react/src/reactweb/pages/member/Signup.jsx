import axios from "axios";

const signup=async(e)=>{ e.preventDefault(); 
    const mid=e.target.mid.value;
    const mpwd=e.target.mpwd.value;
    const mname=e.target.mname.value;
    const obj={mid,mpwd,mname};
    const response=await axios.post("http://localhost:8080/api/member/signup",obj);

    const data=response.data;

    if(data){
        alert("회원가입 성공");
        location.href="/"; 
    }
    else{
         alert('회원가입 실패');
    }
}



export default function Signup(props){

    return(<>
    <div>
        <h3>회원가입</h3>
        <form onSubmit={signup}>
        <input type="text" name="mid" placeholder="아이디"></input> <br />
         <input type="password" name="mpwd" placeholder="비밀번호"></input> <br />
          <input type="text" name="mname" placeholder="닉네임"></input> <br />
          <button type="submit">회원가입</button>
          </form>
    </div>
    </>)
}