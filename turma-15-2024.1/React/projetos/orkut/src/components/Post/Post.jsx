import { api } from "../../api/api"
import { Link } from "react-router-dom"

const Post = ({ autor, comentario, likes, id, temLink}) => {

    const refresh = () => {
        window.location.reload()
    }

    const handleDeletePost = async () => {
        const response = await api.delete(`/posts/${id}`)
        if(response.status == "200")
            refresh()
    }

    const handleLikesClick = async () => {
        const response = await api.patch(`/posts/${id}`, {likes: likes + 1})
        if(response.status == "200")
            refresh()
    }

    return (
        <>
        <div key={id}>
            <p>Autor: {autor}</p>
            <p>Comentário: {comentario}</p>
            <hr />
            {temLink && <Link to={`/posts/${id}`}><button>Ver post</button></Link>}
            <button onClick={handleLikesClick}>Likes: {likes}</button>
            <hr />
            <Link to={`/editar/${id}`}><button>Editar</button></Link>
            <button onClick={handleDeletePost}>Excluir</button>
        </div>
        </>
    )
}

export default Post