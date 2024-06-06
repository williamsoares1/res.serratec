import { useState } from "react"

const Cadastro = () => {
    const [nome, setNome] = useState('')

    return (
        <>
            <label htmlFor="inputNome">Nome: </label>
            <input value={nome} type="text" id="inputNome" onChange={(e) => {
                setNome(e.target.value)
            }}/>
            <h1>{nome}</h1>
        </>
    )
}

export default Cadastro