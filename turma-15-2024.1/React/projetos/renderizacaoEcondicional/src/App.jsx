import { useState } from 'react'
import reactLogo from './assets/react.svg'
import viteLogo from '/vite.svg'
import './App.css'

function App() {
  const [nome, setNome] = useState('')
  const [nomeEscolhindo, setNomeEscolhido] = useState('')
  const ehSupervisor = true
  const validacao = null

  const handleNomeChange = (e) => {
    setNome(e.target.value)
  }

  const handleAlterarClick = (e) => {
    setNomeEscolhido(nome)
  }

  return (
    <>
      <div>
        <h1>Titulo do site</h1>
        <h2>{nomeEscolhindo}</h2>

        <hr />
        <h3>Ternario</h3>
        <p>{nomeEscolhindo == 'William' ? "Bem vindo" : "AAAAAAAAAA"}</p>

        <hr />
        <h3>Operado &&</h3>
        {ehSupervisor && <button>Ver painel</button>}

        <hr />
        <h3>Nullish Coalescing Operator</h3>
        {validacao ?? 'Requisicao nao realizada'}

        <hr />
        <input value={nome} onChange={handleNomeChange} type="text" />
        <button onClick={handleAlterarClick}>Alterar</button>
        <hr />
      </div>
    </>
  )
}

export default App
