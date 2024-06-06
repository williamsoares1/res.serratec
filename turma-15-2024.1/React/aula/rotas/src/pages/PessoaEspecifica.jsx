import { useEffect } from "react"
import { useParams, Redirect, useHistory } from "react-router-dom"

const PessoaEspecifica = () => {
    // const history = useHistory()
    const { id } = useParams()
    const estaLogado = false
        
    useEffect(() => {
        alert('fezo get')
    }, [id])

    // useEffect(() => {
    //     if (!estaLogado)
    //         history.push('/login')
    // }, [])

    return (
        <>
        {estaLogado ?
        <>
            <h1>voce é o: {id}</h1>
        </>
        :
            <Redirect to={'/login'}/>
        }
        </>
    )
}

export default PessoaEspecifica