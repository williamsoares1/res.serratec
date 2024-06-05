import { useState } from 'react'
import reactLogo from './assets/react.svg'
import viteLogo from '/vite.svg'
import './App.css'
import Turma from "./components/Turma/Turma"
import Aluno from './components/Aluno/Aluno'

function App() {
  const [count, setCount] = useState(0)
  const listaAlunosUm = ['Raphael', 'Raphael', "Luna", "Mauro", "jose"]
  const listaAlunosDois = ["Antonia", "Paula", "beatriz"]

  const soma = (n1, n2) => {
    return n1 + n2
  }
  
  return (
    <>
      <Turma nome="2024.1">
        {(listaAlunosUm && listaAlunosUm.length > 0) &&
        listaAlunosUm.map((aluno, index) => <Aluno key={index} nome={aluno} />)}
      </Turma>
      <Turma nome='2024.2'>
      {(listaAlunosDois && listaAlunosDois.length > 0) &&
        listaAlunosDois.map((aluno, index) => <Aluno key={index} nome={aluno} />)}
      </Turma>     

      <Turma nome='Turma especial'>
        <Aluno nome='Raphael'/>
        <Aluno nome='Raphael'/>
        <Aluno nome='Raphael'/>
      </Turma>



    </>
  )
}

export default App
