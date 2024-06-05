import { useState } from 'react'
import reactLogo from './assets/react.svg'
import viteLogo from '/vite.svg'
import './App.css'

function App() {
  const [novaTarefa, setNovaTarefa] = useState("")
  const [tarefas, setTarefas] = useState([])

  const handleNovaTarefaChange = (e) => {
    setNovaTarefa(e.target.value)
    console.log(novaTarefa)
  }

  const handleAdicionarTarefaClick = () => {
    if(novaTarefa != ""){
      setTarefas([novaTarefa, ...tarefas])
      setNovaTarefa('')
    }
  }

  const handleZerarClick = () => {
    setTarefas([])
  }

  const handleDeletarClick = (i) => {
    setTarefas(tarefas.filter((tarefa, index) => index != i))
  }

  return (
    <>
      <div>
        <h1>ToDo List</h1>
        <input value={novaTarefa} onChange={handleNovaTarefaChange} />
        <button onClick={handleAdicionarTarefaClick}>Adicionar</button>
        <hr />

      {tarefas.map((tarefa, index) => {
        
        tarefa = (
          <div className='item_box'>
            {tarefa}
            <button onClick={() => {
              handleDeletarClick(index)
            }}>X</button>
          </div>
        )

        return tarefa
      })}
      <button onClick={handleZerarClick}>Limpar lista</button>

      </div>
    </>
  )
}

export default App
