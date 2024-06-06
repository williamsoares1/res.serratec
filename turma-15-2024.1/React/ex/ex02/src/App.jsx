import { useEffect, useRef, useState } from 'react'
import reactLogo from './assets/react.svg'
import viteLogo from '/vite.svg'
import './App.css'
import { api } from "./api/api"
import Contato from "./components/Contato/Contato"

function App() {
  const [contatos, setContatos] = useState([])

  const [nome, setNome] = useState()
  const [telefone, setTelefone] = useState()
  const [observacao, setObservacao] = useState()
  const [temZap, setTemZap] = useState()

  useEffect(() => {
    getAll()
  }, [])

  const handleNomeChange = (e) => setNome(e.target.value)

  const handleObsChange = (e) => setObservacao(e.target.value)

  const handleTelefoneChange = (e) => setTelefone(e.target.value)

  const handleTemZapChange = (e) => setTemZap(e.target.checked)

  const handleSubmit = async (e) => {
    e.preventDefault()
    if(nome != undefined || telefone != undefined){
      const response = await api.post("/contatos",
    {
      nome,
      telefone,
      observacao,
      temZap
    })
    getAll()
    }
  }

  const handleExcluirClick = async (id) => {
    const response = await api.delete(`/contatos/${id}`)
    getAll()
  }

  const getAll = async () => {
    const response = await api.get("/contatos")
    setContatos(response.data)
  }

  return (
    <>
      <form onSubmit={handleSubmit}>
        <label htmlFor="nome">Nome: </label>
        <input id='nome' type="text" value={nome} onChange={handleNomeChange}/>
        <p />
        <label htmlFor="telefone">Telefone: </label>
        <input id='telefone' type="text" value={telefone} onChange={handleTelefoneChange}/>
        <p />
        <label htmlFor="textarea">Observacao: </label>
        <textarea id='textarea' value={observacao} onChange={handleObsChange}/>
        <p />
        <label htmlFor="check">Tem Zap: </label>
        <input type="checkbox" id="check" checked={temZap} onChange={handleTemZapChange}/>
        <p />
        <button type='submit'>Adicionar</button>
      </form>
      <hr />
      <div>
        {contatos.map((contato, index) =>
          <Contato
            index={index}
            nome={contato.nome}
            telefone={contato.telefone}
            temZap={contato.temZap}
            observacao={contato.observacao}
            id={contato.id}
            deleteFunc={handleExcluirClick}
          />
        )}
      </div>
    </>
  )
}

export default App
