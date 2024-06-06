import { Link, useHistory } from 'react-router-dom'

const Home = () => {
    const history = useHistory()

    return (
        <>
            <h1>Hello Woooooorld!</h1>
            <button onClick={() => {history.push('/cadastro')}}>Cadastros</button>
            <Link to='/contato'>Contatos</Link>
        </>
    )
}

export default Home