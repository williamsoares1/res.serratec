import { useState } from 'react'
import reactLogo from './assets/react.svg'
import viteLogo from '/vite.svg'
import './App.css'
import { Route, BrowserRouter, Switch } from 'react-router-dom'
import Home from './pages/Home'
import Posts from './pages/Posts'
import PostEspecifico from './pages/PostEspecifico'
import Publicar from './pages/Publicar'
import Editar from './pages/Editar'

function App() {

  return (
    <>
      <BrowserRouter>
        <Switch>
          <Route exact path={"/"} component={Home}/>
          <Route exact path="/posts" component={Posts}/>
          <Route exact path="/posts/:id" component={PostEspecifico}/>
          <Route exact path="/publicar" component={Publicar}/>
          <Route exact path="/editar/:id" component={Editar}/>
        </Switch>
      </BrowserRouter>
    </>
  )
}

export default App
