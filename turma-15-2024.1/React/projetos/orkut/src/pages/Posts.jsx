import { useEffect, useState } from "react"
import { api } from "../api/api"
import Post from "../components/Post/Post"

const Posts = () => {
    const [posts, setPosts] = useState([])

    useEffect(() => {
        getAll()
    }, [])

    const getAll = async () => {
        const response = await api.get("/posts")
        setPosts(response.data)
    }

    return (
        <>
            <h1>Posts Geral</h1>
            {posts.length > 0
            ? posts.map((post, index) =>
                <Post 
                    autor={post.autor}
                    comentario={post.comentario}
                    likes={post.likes}
                    id={post.id}
                    index={index}
                    temLink={true}
                />)
            : <h1>Nâo há publicacoes</h1>}
        </>
    )
}

export default Posts