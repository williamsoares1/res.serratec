import { useState } from 'react'
import reactLogo from './assets/react.svg'
import viteLogo from '/vite.svg'
import './App.css'
import Turma from './components/Turma/Turma'
import Aluno from './components/Aluno/Aluno'

function App() {
  const [count, setCount] = useState(0)
  const listaDeAlunos = ['William', 'Raphael', 'Lauro', 'Rafaela']
  const listaDeAlunos2 = ['Juquinha', 'Brunin', 'Carlin', 'Ze Leleo']

  return (
    <>
      <Turma nome='A1'>
      {(listaDeAlunos && listaDeAlunos.length > 0) && listaDeAlunos.map((aluno, index) => <Aluno key={index} nome={aluno}/>)}
      </Turma>
      <Turma nome='A2'>
      {(listaDeAlunos2 && listaDeAlunos2.length > 0) && listaDeAlunos2.map((aluno, index) => <Aluno key={index} nome={aluno}/>)}
      </Turma>
    </>
    )
}

export default App
