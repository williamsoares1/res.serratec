const Post = ({index, autor, comentario, deleteFunc, likes, darLikeFunc}) => {
    return (
        <>
            <div>
                <h1>Autor: {autor}</h1>
                <p>Comentario: {comentario}</p>
                <button onClick={darLikeFunc}>Likes: {likes}</button>
                <button onClick={() => {
                    deleteFunc(index)
                }}>X</button>
            </div>
        </>
    )
}

export default Post