import { useState } from 'react'
import reactLogo from './assets/react.svg'
import viteLogo from '/vite.svg'
import './App.css'

function App() {
  const [nome, setNome] = useState('')
  const [nomeEscolhido, setNomeEscolhido] = useState('')
  const EhSupervisor = true
  const validacao = <button>Clique aqui</button>
  const handleNomeChange = (e) => {
    setNome(e.target.value)
  }

  const handleAlterarClick = () => {
    setNomeEscolhido(nome)
  }

  return (
    <>
     <div>
      <h1>Titulo do site</h1>
      
      <input value={nome} onChange={handleNomeChange}/>
      <button onClick={handleAlterarClick}>Alterar</button>
      <hr />
      <h3>Ternário</h3>
      {nomeEscolhido == 'Raphael' ? <p>Bem vindo</p> : <p>Sai daqui</p>}
      <p>{nomeEscolhido == 'Raphael' ? 'Bem-vindo' : '' }</p>

      <h3>Operador &&</h3>
      {false && <button>Olá</button>}
      {EhSupervisor && <button>Ver painel</button>}
      {nomeEscolhido == 'Raphael' && <h1>Vc é top!</h1>}
      {nomeEscolhido != 'Raphael' && <h1>Vc NÃO é top!</h1>}

      <h3>nulish Coalescing operator</h3>
      {validacao ?? 'Requisição ainda não realizada'}
     </div>
    </>
  )
}

export default App
