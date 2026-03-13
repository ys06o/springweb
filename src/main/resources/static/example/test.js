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
} ;//func end



//개별 조회 기능
const get=async(ano)=>{
try{
const response=await axios.get(`/attendance/detail?ano=${ano}`);
const data=response.data;
console.log(data);
if(data){
    alert("성공!");
    const test = document.querySelector("#test");
    let html="";
    html += `번호: ${data.ano}, 이름: ${data.StudentName}, 상태: ${data.status} <br>`;
    test.innerHTML=html;
}
else{alert("실패");}
}catch(e){console.log(e);}


} ;//func end

// 출석 등록 기능
const post = async () => {
    try {
        const nameInput = document.querySelector("#studentName");

        const student = {
            "ano": 4,
            "StudentName": nameInput.value,
            "date": "2021-12-23",
            "status": "출석"
        };

        const response = await axios.post("/attendance", student);
        const data = response.data;

        if (data) {
            alert("출석 등록 성공!");
        } else {
            alert("등록 실패");
        }
    } catch (e) {
        console.log(e);
    }
};

//출석 삭제
const del = async () => {
    try {
        const response = await axios.delete("/attendance?ano=1");
        console.log(response.data);
    } catch(e) { console.log(e); }
};

//출석 수정
const put = async () => {
    try {
        const response = await axios.put("/attendance", {
            ano: 4,
            status: "지각"
        });
        console.log(response.data);
    } catch(e) { console.log(e); }
};


