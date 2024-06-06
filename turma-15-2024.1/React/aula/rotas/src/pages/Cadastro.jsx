import { useState } from "react"

const Cadastro = () => {
    const [nome, setNome] = useState('')

    return (
        <>
        <input value={nome} onChange={(e) => {
            setNome(e.target.value)
        }}/>
        </>
    )
}

export default Cadastro