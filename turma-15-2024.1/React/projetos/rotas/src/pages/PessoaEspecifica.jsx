import { useEffect } from "react"
import { Redirect, useParams } from "react-router-dom"

const PessoaEspecifica = () => {
    const { id } = useParams()
    const estaLogado = false

    useEffect(() => {
        alert('Fez o get')
    }, [id])

    return (
        <>
            {!estaLogado && <Redirect to={'/login'}/>}
            <h1>Olá {id}</h1>
        </>
    )
}

export default PessoaEspecifica