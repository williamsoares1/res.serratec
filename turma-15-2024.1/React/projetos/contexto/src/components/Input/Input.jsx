import { useContext } from "react"
import { NomeContext } from "../../context/NomeContexto"

const Input = () => {
    const { nome, setNome } = useContext(NomeContext)

    return (
        <>
            <input type="text" value={nome} onChange={e => setNome(e.target.value)}/>
        </>
    )
}

export default Input