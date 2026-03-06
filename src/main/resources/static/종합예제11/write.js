

//등록 함수정의
const 등록=async ()=>{
    //1.입력받은 dom을 가져온다.
    const writerInput=document.querySelector('.writerInput');
    const contentInput=document.querySelector('.contentInput');
    const titleInput=document.querySelector('.titleInput');
    //2.dom에서 입력받은 값 가져오기
    const bwriter=writerInput.value;
    const bcontent=contentInput.value;
    const btitle=titleInput.value;
    //3.객체 구성
    const obj={bwriter,bcontent,btitle};
    //4.axios를 이용하여 서버에게 저장을 요청하고 응답받기
    const response = await axios.post("/board", obj);
    const data=response.data;
    //5.결과 확인
    if(data==true){
        alert("등록성공");
        location.href="/종합예제11/index.html"
    } //페이지 이동 js에서 페이지 이동할때씀
    else{
        alert("등록실패");
    }


} //func end