import { useState } from "react"
import api from "../api/api"
import { useHistory } from 'react-router-dom'

const Publicar = () => {
    const history = useHistory()

    const [autor, setAutor] = useState('')
    const [comentario, setComentario] = useState('')

    const handleAutorChange = (e) => {
        setAutor(e.target.value)
    }

    const handleComentarioChange = (e) => {
        setComentario(e.target.value)
    }

    const handleSubmit = async (e) => {
        e.preventDefault()

        const response = await api.post('/posts', {
            autor,
            comentario,
            likes: 0
        })

        if (response.status == '201')
            history.push('/posts')

    }

    return (
        <>
            <form onSubmit={handleSubmit}>
                <label htmlFor="autor">Autor:</label>
                <br />
                <input id='autor' value={autor} onChange={handleAutorChange}/>

                <p />

                <label htmlFor="comentario">Comentário:</label>
                <br />
                <textarea id='comentario' value={comentario} onChange={handleComentarioChange}/>
                <p />
                <button type='submit'>Publicar</button>
            </form>
        </>
    )
}

export default Publicar