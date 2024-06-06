import { useState } from 'react'
import reactLogo from './assets/react.svg'
import viteLogo from '/vite.svg'
import './App.css'
import { BrowserRouter, Route, Router, Switch } from 'react-router-dom'
import Home from './pages/Home'
import Contato from './pages/Contato'
import Cadastro from './pages/Cadastro'
import PessoaEspecifica from './pages/PessoaEspecifica'
import Login from './pages/Login'
import Error404 from './pages/Error404'
import Zap from './pages/Zap'

function App() {
  const [count, setCount] = useState(0)

  return (
    <>
     <BrowserRouter>
      <Switch>
        <Route path='/login' component={Login}/>
        <Route exact path={'/'} component={Home}/>
        <Route exact path='/contato' component={Contato}/>
        <Route exact path='/contato/whatsapp' component={Zap}/>
        <Route exact path='/cadastro'component={Cadastro} />       
        <Route exact path='/pessoa/:id' component={PessoaEspecifica}/>
        <Route path='*' component={Error404}/>        
      </Switch>
     </BrowserRouter>
    </>
  )
}

export default App

