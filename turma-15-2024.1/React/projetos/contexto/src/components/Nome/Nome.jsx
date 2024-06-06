import { useContext } from "react"
import { NomeContext } from "../../context/NomeContexto"

const Nome = () => {
    const { nome } = useContext(NomeContext)

    return (
        <>
            <h1>{nome}</h1>
        </>
    )
}

export default Nome