import { useEffect, useState } from "react"
import { useParams, useHistory } from "react-router-dom"
import api from "../api/api"

const Editar = () => {
    const { id } = useParams()
    const history = useHistory()
    //const [post, setPost] = useState({})
    
    const [autor, setAutor] = useState('')
    const [comentario, setComentario] = useState('')

    useEffect(() => {
        getPost()
    }, [])    

    const getPost = async () => {
        const response = await api.get(`/posts/${id}`)
        //setPost(response.data)
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

        const response = await api.patch(`/posts/${id}`, {
            autor, comentario
        })

        if(response.status == '200')
            history.push('/posts')
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