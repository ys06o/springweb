  console.log("index js open");

  //1.전체조회 js가 열렸을때 , 수정/등록/삭제 성공했을때;
  const onFindAll=async()=>{
    //1.어디에
    const tbody=document.querySelector("#boardTable tbody");
    //2.무엇을, 출력할 내용물 정의
    let html="";
      //동기화 1.현재 함수명 앞에 async 키워드 붙인다.
      //2.axios 앞에 await 키워드
      const response=await axios.get("/board");
      console.log(response);
      const data=response.data;
      for(let index=0; index<=data.length-1; index++){
        const board=data[index];
        html+=`<tr>
        <td>${board.bno}</td>
        <td>${board.bcontent}</td>
        <td>${board.bwriter}</td>
        <td>${board.bdate}</td>
        <td>
    <button type="button" onclick="onDelete(${board.bno})">삭제</button>
     <button type="button" onclick="onUpdate(${board.bno})">수정</button>
        </td>
            </tr>`
      }
    //3.출력,출력할 위치에 innerHTML 내용 대입한다.
    tbody.innerHTML=html;
  } //func end
    onFindAll();


  //2.등록
  //실행조건:등록버튼을 클릭했을때

  const onWrite=async()=>{
    //1.입력받은 dom객체를 가져온다.
    const bcontentInput=document.querySelector("#bcontent");
    const bwriterInput=document.querySelector("#bwriter");

    const bcontent=bcontentInput.value;
    const bwriter=bwriterInput.value;

    //2.입력받은 값으로객체 생성
    const obj={"bcontent":bcontent,"bwriter":bwriter};
    //3.배열 저장(axios를 이용하여 서버에게 저장을 요청한다.)

      //동기화 axios 1.현재 함수 앞에 async 키워드 추가 2.axios 앞에 await 키워드를 붙인다.
    const response=await axios.post("/board",obj); //axios.HTTP메소드명("URL통신할 주소",body본문)
    const data=response.data;
    if(data==true){
      alert("등록성공");
      bcontentInput.value='';
      bwriterInput.value='';
    }
    else{alert("등록실패")}
    onFindAll();
    //4.성공 안내
    console.log(response);
  } //func end








  //3.개별 수정
  const onUpdate=async(bno)=>{  //1.수정할 게시물번호를 매개변수로 받는다.


    //1.새로운 수정할 내용 입력받기
    const newContent = prompt("수정할 내용을 입력하세요.");
    //2.객체(body) 구성
    const obj={bno,"bcontent":newContent};  //속성명과 대입할 변수명이 같다면 속성명 생략 가능!
    //3.axios를 이용하여 서버에게 수정할 요청 후 응답 받기
    const response=await axios.put("/board",obj); //put방식으로 board주소에 obj를 전달
    const data=response.data;

    if(data==true){
      alert("수정 성공");
      onFindAll();
    }else{
      alert("수정 실패");
    }
  } //func end













  //4.개별 삭제
  const onDelete=async(bno)=>{          //1.삭제할 번호를 매개변수로받는다.

    //2.axios를 활용하여 삭제할 번호를 서버에게 쿼리스트링으로 요청하고 응답 받는다
    const response=await axios.delete(`/board?bno=${bno}`);
    const data=response.data;


    //결과에 따른 흐름제어
    if(data==true){
      alert("삭제성공");
      onFindAll();
    }else{
      alert("삭제실패");
    }

  } //func end
