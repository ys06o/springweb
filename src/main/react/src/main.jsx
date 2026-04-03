import { createRoot } from 'react-dom/client'
// ** index.html 에서 root 가져오기 **
const root = document.querySelector('#root');

// reactweb
import App from './reactweb/App';
import {BrowserRouter} from 'react-router-dom'
createRoot( root ).render(
    <BrowserRouter>
        <App />
    </BrowserRouter>
)