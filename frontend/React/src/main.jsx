import { StrictMode } from 'react'
import { createRoot } from 'react-dom/client'
import App from './App.jsx'
import './index.css'
import Rouet from './Pagina/Rouet.jsx'

createRoot(document.getElementById('root')).render(
  <StrictMode>
    <Rouet />
  </StrictMode>,
)
