console.log("detail.js");
//1.쿼리스트링? URL뒤에 매개변수를 포함하는 경우
//2.JS에서 쿼리스트링을 가져오는 방법
const bno=new URLSearchParams(location.search).get("bno");
console.log(bno);
const 개별조회 = async()=>{
    //1.어디에 쿼리스트링이 존재하는 bno게시물 정보
    const boardBox = document.querySelector("#boardBox");
    //2.무엇을
    const response = await axios.get(`/board/detail?bno=${bno}`);
    const data=response.data; //조회된 게시물
    let html=`
    제목:<div>${data.btitle}</div>
    작성자/작성일:<div>${data.bwriter}/${data.createDate}</div>
    내용:<div>${data.bcontent}</div>
    <button onclick="수정(${data.bno})">수정</button>
    <button onclick="삭제(${data.bno})">삭제</button>
    `;
    //3.출력할지
    boardBox.innerHTML=html;

} //func end
개별조회();

//매개변수또는 쿼리스트링으로 bno를 가져올수있다
const 삭제=async(bno)=>{
    //1.현재 게시물을 삭제하기 위해 현재 게시물 번호를 확인(bno)
    //2.axios를 이용하여 서버에게 게시물 삭제 요청 결과받기
    const response=await axios.delete(`/board?bno=${bno}`);
    const data=response.data;
    if(data){
        alert("삭제성공!");
        location.href = "/종합예제11/index.html";
    }
    else{alert("삭제실패!");}
} //func end

//개별수정
const 수정=async(bno)=>{
   const btitle= prompt('수정할제목:');
   const bcontent= prompt('수정할내용:');
   const bwriter= prompt('수정할작성자:');
   const obj={bno,btitle,bcontent,bwriter};
    const response=await axios.put(`/board`,obj);
    const data  =response.data;
    if(data){
        alert("수정성공")
        location.reload();
    }
    else{
        alert("수정실패");
    }
}

const 댓글등록=async()=>{
    //1.사용자가 입력한 내용 가져오기
    const cwriterInput=document.querySelector("#cwriter");
    const ccontentInput=document.querySelector("#ccontent");
    //2.
    const cwriter=cwriterInput.value;
    const ccontent=ccontentInput.value;
    const obj={bno,cwriter,ccontent};
    const response=await axios.post(`/board/comment`,obj);
    const data=response.data;
    if (data) {
        alert("등록성공")
        location.reload();
    }
    else{
        alert("등록실패")
    }

}

const 댓글조회=async()=> {
    const replyBox = document.querySelector("#replyBox");
    let html = `<div>
        댓글작성자 : <input id="cwriter">
        댓글내용 :<textarea id="ccontent"> </textarea>
        <button onclick="댓글등록()">댓글등록</button>
    </div>`;
    const response = await axios.get(`/board/comment?bno=${bno}`);
    const data = response.data;


    for (let index = 0; index <= data.length - 1; index++) {
        const commentDto = data[index]; //반복문을이용해 게시물 하나씩 꺼내기
        html += `
<div><div style="margin: 20px 0px;">
            <div><span>작성자:${commentDto.cwriter}</span><br><span>${commentDto.createDate}</span><span> <button>수정</button> <button>삭제</button></span></div>
            <div>댓글내용:${commentDto.ccontent}</div>
        </div>
</div>`;
    }
    //3.출력을 할건지
    replyBox.innerHTML = html;

}

댓글조회();