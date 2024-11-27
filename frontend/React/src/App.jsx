import { useState } from 'react'
import './App.css'
import { Rotas } from './Pagina/axios/api'
import { useNavigate } from 'react-router-dom'

function App() {
  const [email,setEmail] = useState('')
  const[password,setPass] = useState('')
  const navegate = useNavigate()

  const handleSubmit = async (e) =>{
      e.preventDefault()

      try {
        const response = await Rotas.post('/login',{email,password})
        console.log(response)
        if(response.status  == 200){
          alert(response.data);
          navegate('/entra')
        }
      } catch (error) {
          if (error.response && error.response.status === 401) {
            alert('Usuário ou senha inválidos!');
          } else {
            console.error('Erro no login:', error);
            alert('Erro ao realizar o login.');
          }
      }
      }
  

  return (
    <>
      <form onSubmit={handleSubmit}>
        <input type="email" placeholder='Email' value={email} onChange={(e)=>setEmail(e.target.value)}/>
        <input type="password" placeholder='PASSWORD' value={password} onChange={(e)=>setPass(e.target.value)}/>
        <button type="submit">Login</button>
      </form>
    </>
  )
}

export default App
