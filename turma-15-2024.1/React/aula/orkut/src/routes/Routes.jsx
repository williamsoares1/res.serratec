import { BrowserRouter, Switch, Route, Link } from 'react-router-dom'
import { Home } from '../pages/Home'
import Posts from '../pages/Posts'
import PostEspecifico from '../pages/PostEspecifico'
import Publicar from '../pages/Publicar'
import Editar from '../pages/Editar'

const Routes = () => {
    return (
        <>
            <BrowserRouter>

                <div style={{ backgroundColor: 'red' }}>
                    <Link to='/posts'>Ver posts</Link>
                    <br />
                    <Link to='/publicar'>Criar um post</Link>
                </div>

                <Switch>
                    <Route exact path='/' component={Home} />
                    <Route exact path='/posts' component={Posts} />
                    <Route exact path='/post/:id' component={PostEspecifico} />
                    <Route exact path='/publicar' component={Publicar} />
                    <Route exact path='/editar/:id' component={Editar} />
                </Switch>

                <footer>Direitos reservados</footer>
            </BrowserRouter>
        </>
    )
}

export default Routes