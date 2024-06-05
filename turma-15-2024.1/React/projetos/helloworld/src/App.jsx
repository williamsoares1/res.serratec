import { useState } from 'react'
import reactLogo from './assets/react.svg'
import viteLogo from '/vite.svg'
import './App.css'

function App() {
  const [count, setCount] = useState(0)

  return (
    <>
     <h1>Olá Mundoooooo!</h1>
      <div className="card">
        <button onClick={() => setCount((count) => count + 10)}>
          contador na situação: {count}
        </button>
      </div>
    </>
  )
}

export default App
