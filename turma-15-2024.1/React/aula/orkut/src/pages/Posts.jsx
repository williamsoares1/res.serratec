import { useEffect, useState } from "react"
import api from './../api/api'
import Post from "../components/Post/Post"

const Posts = () => {
    const [posts, setPosts] = useState([])
    const [loading, setLoading] = useState(false)

    useEffect(() => {
        getTodosOsPosts()
    }, [])

    const getTodosOsPosts = async () => {
        
        try{
            setLoading(true)
            const response = await api.get('/posts')
            setPosts(response.data)
        }
        finally{
            setLoading(false)
        }
    }
    
    return (
        <>
        {loading && 'lendo'}
            {posts && posts.length > 0 ? posts.map((post) => 
                <Post
                    key={post.id}
                    id={post.id}
                    autor={post.autor}
                    comentario={post.comentario}
                    likes={post.likes}
                    temLink
                />
            ) : <p>não há publicações...</p>}
        </>
    )
}

export default Posts