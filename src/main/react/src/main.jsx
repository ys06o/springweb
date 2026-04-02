import { createRoot } from 'react-dom/client';
import { BrowserRouter } from 'react-router-dom';
import './index.css';

// 실행할 컴포넌트 import
import App from './Life-Cycle/App';

const root = document.querySelector('#root');

createRoot(root).render(
  <BrowserRouter>
    <App />
  </BrowserRouter>
);