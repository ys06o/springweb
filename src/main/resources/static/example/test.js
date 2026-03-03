//전체 조회 기능
const getAll=async()=>{//func end{
    const response=await axios.get("/attendance");
    const data=response.data;
    const test = document.querySelector("#test");
    let html = "";
    for (let item of data) {
        html += `번호: ${item.ano}, 이름: ${item.StudentName}, 상태: ${item.status} <br>`;
        test.innerHTML=html;
    }
} //func end



//개별 조회 기능
const get=async(ano)=>{
try{
const response=await axios.get(`/attendance/detail?ano=${ano}`);
const data=response.data;
console.log(data);
if(data==true){
    alert("성공!");
    const test = document.querySelector("#test");
    let html="";
    html += `번호: ${data.ano}, 이름: ${data.StudentName}, 상태: ${data.status} <br>`;
    test.innerHTML=html;
}
else{alert("실패");}
}catch(e){console.log(e);}


} //func end

// //출석 등록 기능
// const post=async()=>{
// try{
//
// const student={
// "ano":1
// "StudentName":"홍길동"
// "date":"2021-12-23"
// "status":"결석"
// }
// const response=await axios("/attendance")
// }




