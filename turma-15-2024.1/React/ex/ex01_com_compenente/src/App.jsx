import { useState } from 'react'
import reactLogo from './assets/react.svg'
import viteLogo from '/vite.svg'
import './App.css'
import Contato from './components/Contato/Contato'

function App() {  
  const [contato, setContato] = useState({nome: '', telefone: '', temZap: false, observacao: ''})
  const [contatos, setContatos] = useState([])

  const handleAdicionarChange = {
    nome: (e) => {
      setContato({...contato, nome: e.target.value})
    },

    telefone: (e) => {
      setContato({...contato, telefone: e.target.value})
    },

    temZap: (e) => {
      setContato({...contato, temZap: e.target.value})
    },

    observacao: (e) => {
      setContato({...contato, observacao: e.target.value})
    },
  }

  const handleAdicionarClick = (e) => {
    e.preventDefault()
    if(contato.nome && contato.telefone && contato.observacao != ''){
      setContatos([contato, ...contatos])
      setContato({nome: '', telefone: '', temZap: false, observacao: ''})
    }
  }

  const handleExcluirClick = (i) => {
    setContatos(contatos.filter((contato, index) => index != i))
  }

  const handleEditarClick = (i) => {
    let contato = contatos.find((contato, index) => index == i)
    console.log(contato)

    setContato({nome: contato.nome, telefone: contato.telefone, temZap: false, observacao: contato.observacao})

    handleExcluirClick(i)
  }

  return (
    <>
    <form onSubmit={handleAdicionarClick}>
    <label htmlFor='nome'>Nome: </label>
    <input id='nome' value={contato.nome} onChange={handleAdicionarChange.nome}/>
    <hr />
    <label htmlFor='telefone' >Telefone: </label>
    <input id='telefone' value={contato.telefone} onChange={handleAdicionarChange.telefone}/>
    <hr />
    <label htmlFor="check">O contato possui WhatsApp?</label>
    <input type='checkbox' id='check' checked={contato.temZap} onChange={handleAdicionarChange.temZap}/>
    <hr />
    <label htmlFor='obs' >Observação: </label>
    <input id='obs' value={contato.observacao} onChange={handleAdicionarChange.observacao}/>
    <hr />
    <button type='submit'>Clique aqui</button>
    </form>

    <div className='container'>
    {contatos.map((contato, index) => {
      return <Contato
      nome={contato.nome}
      telefone={contato.telefone}
      temZap={contato.temZap}
      observacao={contato.observacao} 
      excluirFunc={handleExcluirClick}
      editarFunc={handleEditarClick}
      index={index}/>
    })}
    </div>

    </>
  )
}

export default App
