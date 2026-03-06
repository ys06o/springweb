console.log("i");

//js 함수 function 함수명(){} vs const 변수명()=> {}
//전체함수 정의


//1.전체조회
const 전체조회=async()=>{
    //1.어디에
    const tbody=document.querySelector('#boardTable');
    //2.무엇을,스프링 서버에게 전달받은 데이터
    let html='';

    //1.서버랑 axios를 사용해서 통신
    const response=await axios.get('/board');
    const data=response.data; //통신 결과 내용물 확인
    for (let index = 0; index <= data.length - 1; index++) {
        const boardDto=data[index]; //반복문을이용해 게시물 하나씩 꺼내기
        html+=`<tr>
            <td>${boardDto.bno}</td>
            <td><a href="/종합예제11/detail.html?bno=${boardDto.bno}">${boardDto.btitle}</a></td>
            <td>${boardDto.bwriter}</td>
            <td>${boardDto.createDate}</td>
            </tr>`
    }
    //3.출력을 할건지
    tbody.innerHTML=html;
} //func end
전체조회();