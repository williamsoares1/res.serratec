import { Link, useHistory } from "react-router-dom"

const Home = () => {
    const history = useHistory()

    return (
        <>
            <h1>Bem vindo a minha pagina</h1>
            <button onClick={() => {
                //save()
                history.push('/cadastro')
            }}>Cadastros</button>
            <Link to='/contato'>contato</Link>
        </>
    )
}

export default Home