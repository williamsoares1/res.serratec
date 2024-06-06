import { useEffect, useState } from 'react'
import reactLogo from './assets/react.svg'
import viteLogo from '/vite.svg'
import './App.css'
import Post from './components/Post/Post'
import { api } from "./api/api"

function App() {
  const [posts, setPosts] = useState([])
  const [autor, setAutor] = useState('')
  const [comentario, setComentario] = useState('')

  useEffect(() => {
    getAll()
  }, [])

  const getAll = async () => {
    const response = await api.get("/posts")
    setPosts(response.data)
  }

  const deletePorId = async (id) => {
    const response = await api.delete(`/posts/${id}`)
    if(response.status == 200)
      getAll()
  }

  const postPost = async () => {
    const response = await api.post("/posts",
    {
      autor,
      comentario,
      likes: 0
    })

    getAll()
  }

  const handleAutorChange = (e) => {
    setAutor(e.target.value)
  }

  const handleComentarioChange = (e) => {
    setComentario(e.target.value)
  }

  const handleLikeClick = (i) => {
    setPosts(posts.map((post, index) =>
      index == i ? {...post, likes: post.likes + 1} : post
    ))
  }

  return (
    <>
      <form onSubmit={postPost}>

        <label htmlFor="autor">Autor: </label>
        <input value={autor} onChange={handleAutorChange} id='autor' type="text" />
        <p />

        <label htmlFor="comentario">Comentario: </label>
        <textarea value={comentario} onChange={handleComentarioChange} id="comentario"></textarea>
        <p />

        <button type="submit">Publicar</button>

      </form>

      <div>
        {posts.map((post, index) => 
          <Post 
            key={index}
            id={post.id}
            autor={post.autor}
            comentario={post.comentario}

            //abordagem 1
            darLikeFunc={() => handleLikeClick(index)}

            //abordagem 2
            deleteFunc={deletePorId}
            
            likes={post.likes}
          />
        )}
      </div>
    </>
  )
}

export default App
