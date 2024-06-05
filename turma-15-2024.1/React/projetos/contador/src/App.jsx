import { useState } from 'react'
import reactLogo from './assets/react.svg'
import viteLogo from '/vite.svg'
import './App.css'

function App() {
  const [contador, setContador] = useState(0)
  const [novoValor, setNovoValor] = useState()

  const handleDecrementarClick = () => {
    setContador(contador - 1)
  }

  const handleIncrementarClick = () => {
    setContador(contador + 1)
  }

  const handleZerarClick = () => {
    setContador(0)
  }

  const handleInputChange = (e) => {
    setNovoValor(Number(e.target.value));
  }

  const handleAlterarClick = () => {
    setContador(novoValor);
  }

  return (
    <>
    <p>{contador}</p>
    <hr />
    <button onClick={handleDecrementarClick}> - </button>
    <button onClick={handleZerarClick}>Zerar</button>
    <button onClick={handleIncrementarClick}> + </button>
    <hr />
    <input type='number' placeholder='informe um valor:' onChange={handleInputChange}/>
    <button onClick={handleAlterarClick}>Confirmar</button>
    </>
  )
}

export default App
