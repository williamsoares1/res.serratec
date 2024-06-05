import { useState } from 'react'
import reactLogo from './assets/react.svg'
import viteLogo from '/vite.svg'
import './App.css'
import Turma from './components/Turma/Turma'

function App() {
  const [count, setCount] = useState(0)
  const listaAlunos = ['William', 'Raphael', 'Lauro', 'Rafaela']

  return (
    <>
      <Turma nome="A1" listaDeAlunos={listaAlunos}/>
      <Turma nome="A2"/>
    </>
  )
}

export default App
