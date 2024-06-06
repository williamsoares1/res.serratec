import { useState } from "react"
import { api } from "../api/api"
import { useHistory } from "react-router-dom"

const Publicar = () => {
    const [autor, setAutor] = useState()
    const [comentario, setComentario] = useState()
    const history = useHistory()

    const handleSubmit = async (e) => {
        e.preventDefault()
        const response = await api.post("/posts", {
            autor,
            comentario,
            likes: 0
        })

        if(response.status == "201")
            history.push("/posts")
    }

    const handleAutorChange = (e) => setAutor(e.target.value)

    const handleComentarioChange = (e) => setComentario(e.target.value)

    return (
        <>
            <form onSubmit={handleSubmit}>
                <label htmlFor="autor">Autor: </label>
                <input type="text" id="autor" value={autor} onChange={handleAutorChange}/>
                <hr />
                <label htmlFor="comentario">Comentario: </label>
                <textarea id="comentario" value={comentario} onChange={handleComentarioChange}/>
                <hr />
                <button type="submit">Adicionar</button>
            </form>
        </>
    )
}

export default Publicar