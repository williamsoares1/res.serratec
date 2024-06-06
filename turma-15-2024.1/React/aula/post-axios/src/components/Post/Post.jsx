import { useEffect } from "react"

const Post = ({ autor, comentario, likes, id, darLike, funcaoDelete }) => {
    return (
        <>
        <div>
            <p>Autor: {autor}</p>

            <p>Comentário: {comentario}</p>
            <button onClick={darLike}>Likes: {likes}</button>
            <button onClick={() => {
                funcaoDelete(id)
            }}>Excluir</button>
        </div>
        </>
    )
}

export default Post