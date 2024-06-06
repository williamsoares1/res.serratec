import { useEffect, useState } from 'react'
import reactLogo from './assets/react.svg'
import viteLogo from '/vite.svg'
import './App.css'
import Post from './components/Post/Post'
import { api } from './api/api'

function App() {
  const [posts, setPosts] = useState([])
  const [autor, setAutor] = useState('')
  const [comentario, setComentario] = useState('')

  useEffect(() => {
    getAll()
  }, [])
  
  const getAll = async () => {
    const response = await api.get('/posts')
    setPosts(response.data)
  }
  
  const handleSubmit = async (e) => {
    e.preventDefault()
    const response = await api.post('/posts',
    {
      autor,
      comentario,
      likes: 0
    })
    getAll()

    zerarForm()
  }

  const zerarForm = () => {
    setAutor('')
    setComentario('')
  }

  const handleAutorChange = (e) => {    
    setAutor(e.target.value)
  }

  const handleComentarioChange = (e) => {
    setComentario(e.target.value)
  }
  
  const handleExcluirClick = async (id) => {
    const response = await api.delete(`/posts/${id}`)
    if (response.status == 200)
      getAll()
  }

  return (
    <>
    <form onSubmit={handleSubmit}>
      <label htmlFor='autor'>Autor:</label>
      <p />
      <input id='autor' value={autor} onChange={handleAutorChange}/>

      <p />
      <label htmlFor='comentario'>Comentário:</label>
      <p />
      <textarea id='comentario' value={comentario} onChange={handleComentarioChange}/>
      <p />
      <button type='submit'>Publicar</button>
      </form>
      <div>
        {posts.map((post) =>
          <Post
            key={post.id}
            autor={post.autor}
            comentario={post.comentario}
            likes={post.likes}
            id={post.id}
            darLike={() => { handleLike(post.id) }}
            funcaoDelete={handleExcluirClick}

          />
        )}
      </div>
    </>
  )
}

export default App
