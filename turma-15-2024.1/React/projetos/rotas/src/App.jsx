import { useState } from 'react'
import reactLogo from './assets/react.svg'
import viteLogo from '/vite.svg'
import './App.css'
import { BrowserRouter, Switch, Route, Router } from 'react-router-dom/cjs/react-router-dom'
import Home from './pages/Home'
import Contato from './pages/Contato'
import Cadastro from './pages/Cadastro'
import PessoaEspecifica from './pages/PessoaEspecifica'
import Login from './pages/Login'
import Error404 from './pages/Error404'
import Whatsapp from './pages/Whatsapp'

function App() {
  return (
    <>
    <BrowserRouter>
      <Switch>
        <Route exact path={'/'} component={Home}/>
        <Route path='/login' component={Login}/>
        <Route exact path="/contato" component={Contato}/>
        <Route exact path="/contato/whatsapp" component={Whatsapp}/>
        <Route exact path="/cadastro" component={Cadastro}/>
        <Route exact path="/pessoa/:id" component={PessoaEspecifica}/>
        <Route path="*" component={Error404}/>
      </Switch>
    </BrowserRouter>
    </>
  )
}

export default App
