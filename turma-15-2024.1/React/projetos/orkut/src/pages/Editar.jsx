import { useEffect, useState } from "react"
import { useHistory, useParams } from "react-router-dom/cjs/react-router-dom.min"
import { api } from "../api/api"

const Editar = () => {
    const [autor, setAutor] = useState('')
    const [comentario, setComentario] = useState('')
    const { id } = useParams()
    const history = useHistory()

    useEffect(() => {
        getPostEsp()
    }, [])

    const getPostEsp = async () => {
        const response = await api.get(`/posts/${id}`)
        setAutor(response.data.autor)
        setComentario(response.data.comentario)
    }

    const handleAutorChange = (e) => {
        setAutor(e.target.value)
    }

    const handleComentarioChange = (e) => {
        setComentario(e.target.value)
    }

    const handleSubmit = async (e) => {
        e.preventDefault()
        const response = await api.patch(`/posts/${id}`, {autor, comentario})
        history.push("/posts")
    }
    
    return (
        <>
            <form onSubmit={handleSubmit}>
                <label htmlFor="autor">Autor:</label>
                <br />
                <input id='autor' value={autor} onChange={handleAutorChange} />

                <p />

                <label htmlFor="comentario">Comentário:</label>
                <br />
                <textarea id='comentario' value={comentario} onChange={handleComentarioChange} />
                <p />
                <button type='submit'>Editar</button>
                
            </form>
        </>
    )
}

export default Editar