import { useEffect } from "react"

const Post = ({ autor, comentario, likes, index, darLike, funcaoDelete }) => {
    // useEffect(() => {
    //     alert('novo post')
    // }) // Executa sempre que um estado for alterado

    useEffect(() => {
        return () => {//=> alternativa ao componentDidUnmount
            alert('O post foi apagado')
        }
    }, [])

    return (
        <>
        <div>
            <p>Autor: {autor}</p>

            <p>Comentário: {comentario}</p>
            <button onClick={darLike}>Likes: {likes}</button>
            <button onClick={() => {
                funcaoDelete(index)
            }}>Excluir</button>
        </div>
        </>
    )
}

export default Post