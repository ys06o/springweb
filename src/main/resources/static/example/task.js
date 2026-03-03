console.log("js 실행");
let sdf=1;
console.log(sdf);

//[1]타입:js는 동적타입이므로 
console.log(3);
console.log(true);
console.log("안녕하세요");
//[2]배열
console.log([3,true,3.14]);

//[3]객체/JSON
console.log({"name":"유재석","age":40});

//[4]함수
function func1(){}

//[2]다양한 함수 형식
function func2(){} //선언적 함수
// function( ){} //익명함수
()=>{} //람다표현식 -3개월차(react 표현식)

//[3]화살표 함수는 익명이므로 변수/상수에 저장한다.
const func3=( )=>{ }

//=================================================================//

/*[1]AXIOS
    1.정의:대표적으로 비동기/동기 통신을 하는 함수
      AXIOS(react) vs JS(FETCH) vsJQUERY(AJAX) 등
    2.목적:JS환경에서 서버와의 통신
    3.설치:HTML에 CDN 코드를 추가한다.
     <script src="https://cdn.jsdelivr.net/npm/axios/dist/axios.min.js"></script>
    4.사용법
*/

//axios.HTTP메소드명("통신할주소")
//프론트서버와 백엔드서버가 같다면 도메인 생략가능
//[2]axios.HTTP메소드명("통신할주소").then((response)=>{response.data})
axios.get("http://localhost:8080/day03/task")
axios.delete("/day03/task?name=유재석")
.then((response)=>{console.log(response.data);});

//[3]axios.HTTP메소드명
axios.post("/day03/task?age=10")
.then((response)=>{console.log(response.data);})
.catch((error)=>{console.log(error);});


//[4]axios.HTTP메소드명("통신할주소",body)
const obj={"name":"유재석","age":40}; //객체 하나 생성
axios.put("/day03/task",obj)
.then((r)=>{console.log(r.data);})
.catch((error)=>{console.log(error);});


//비동기통신 이란? 요청을 여러개 했을때 먼처 처리된 응답부터 실행
//즉] 먼처처리된 로직부터 실행된다. 순서 보장 x
//*동기통신이란? 여러개 요청 했을때 먼저 요청한 로직이 응답하는 순서대로 실행
//    즉]먼저 요청한 로직이 먼저 응답 실행된다.  순서 보장함.

//[5]         //async 동기화키워드
const func5=async()=>{
    try{  //1.예외처리를 한다.

      //2.axios 앞에 await 키워드를 사용해 동기화 처리
      //3.axios 결과를 변수/상수에 대입한다.
      const response=await axios("/day03/task/axios?name=강호동")
      //4.결과 확인

      console.log(response.data);
    }catch(e){console.log(e);}
} //func end

func5(); //함수 실행