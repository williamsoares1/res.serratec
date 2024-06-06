import { useEffect, useState } from "react"
import { useParams } from "react-router-dom"
import { api } from "../api/api"
import Post from "../components/Post/Post"

const PostEspecifico = () => {
    const { id } = useParams()
    const [post, setPost] = useState({})

    useEffect(() => {
        getPostEsp()
    }, [])

    const getPostEsp = async () => {
        const response = await api.get(`/posts/${id}`)
        setPost(response.data)
    }

    return (
        <>
            <Post 
                autor={post.autor}
                comentario={post.comentario}
                likes={post.likes}
                id={post.id}
                temLink={false}
            />
        </>
    )
}

export default PostEspecifico