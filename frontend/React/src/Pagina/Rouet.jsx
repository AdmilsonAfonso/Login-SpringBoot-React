import React from 'react'
import Entrar from './Entrar'
import App from '../App'
import {BrowserRouter,Route,Routes} from 'react-router-dom'

function Rouet() {
  return (
    <BrowserRouter>
        <Routes>
            <Route path='/entra' element={<Entrar/>}></Route>
            <Route path='/admin' element={<App/>}></Route>
        </Routes>
    </BrowserRouter>
  )
}

export default Rouet