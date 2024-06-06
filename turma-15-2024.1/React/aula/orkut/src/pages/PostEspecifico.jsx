import { useEffect, useState } from 'react'
import { useParams } from 'react-router-dom'
import api from '../api/api'
import Post from '../components/Post/Post'

const PostEspecifico = () => {
    const { id } = useParams()
    const [post, setPost] = useState({})

    useEffect(() => {
        getPost()
    }, [])

    const getPost = async () => {
        const response = await api.get(`/posts/${id}`)
        setPost(response.data)
    }

    return (
        <>
            <Post
                id={post.id}
                autor={post.autor}
                comentario={post.comentario}
                likes={post.likes}          
            />
        </>
    )
}

export default PostEspecifico