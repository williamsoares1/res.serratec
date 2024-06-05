import { useState } from 'react'
import reactLogo from './assets/react.svg'
import viteLogo from '/vite.svg'
import './App.css'
import Turma from "./components/Turma/Turma"

function App() {
  const [count, setCount] = useState(0)
  const listaAlunosUm = ['Raphael', 'Raphael', "Luna", "Mauro", "jose"]
  const listaAlunosDois = ["Antonia", "Paula", "beatriz"]

  return (
    <>
      <Turma nome="2024.1" listaDeAlunos={listaAlunosUm}/>
      <Turma nome='2024.2' listaDeAlunos={listaAlunosDois}/>
    </>
  )
}

export default App
