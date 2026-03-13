import { createRoot } from 'react-dom/client'
import './index.css'
import App from './App.jsx'
// import Exam1 from './chapter4/Exam1.jsx';
// import Exam2 from './chapter5/Exam2.jsx';
// import Exam1 from './chapter6/Exam1.jsx';
import Exam1 from './chapter7/Exam1.jsx';
import Chapter8 from './chapter8/Chapter8.jsx';
//기존코드
// createRoot(document.getElementById('root')).render(
//   <h1>안녕하세요</h1>
//     )
//
const root=document.querySelector('#root'); //index.html 에서 root 가져오기 


//chapter 4 예제
// createRoot(root).render(<Exam1/>);


//chapter5 예제
// createRoot(root).render(<Exam2/>);
// createRoot(root).render(<Exam1/>);
// createRoot(root).render(<Exam1/>);
// createRoot(root).render(<Chapter8/>);
import Exam2 from './chapter9/Exam02.jsx'
createRoot(root).render(<Exam2/>)