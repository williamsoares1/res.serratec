import { useState } from 'react'
import reactLogo from './assets/react.svg'
import viteLogo from '/vite.svg'
import './App.css'
import Input from './components/Input/Input'
import Nome from './components/Nome/Nome'
import { NomeContext, NomeProvider } from './context/NomeContexto'

function App() {

  return (
    <>
      <NomeProvider>
        <Input/>
        <Nome/>
      </NomeProvider>
    </>
  )
}

export default App
