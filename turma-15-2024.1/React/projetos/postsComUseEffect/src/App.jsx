import { useEffect, useRef, useState } from 'react'
import reactLogo from './assets/react.svg'
import viteLogo from '/vite.svg'
import './App.css'
import Post from './components/Post/Post'

function App() {
  const [posts, setPosts] = useState([])
  const [autor, setAutor] = useState('')
  const [comentario, setComentario] = useState('')
  const inputAutor = useRef(null)

  // useEffect(()=>{
  //   alert('Seja bem vindo!')
  // }, [])

  // useEffect(() => {
  //   if(posts.length == 0){
  //     alert('Não há posts aqui')
  //   }
  // }, [posts])

  const handleSubmit = (e) => {
    e.preventDefault()
    setPosts([{autor, comentario, likes: 0}, ...posts])
    setAutor('')
    setComentario('')
    inputAutor.current.focus()
  }

  const handleAutorChange = (e) => {
    setAutor(e.target.value)
  }

  const handleComentarioChange = (e) => {
    setComentario(e.target.value)
  }

  const handleDeleteClick = (i) => {
    setPosts(posts.filter((post, index) => index != i))
  }

  const handleLikeClick = (i) => {
    setPosts(posts.map((post, index) =>
      index == i ? {...post, likes: post.likes + 1} : post
    ))
  }

  return (
    <>
      <form onSubmit={handleSubmit}>

        <label htmlFor="autor">Autor: </label>
        <input ref={inputAutor} value={autor} onChange={handleAutorChange} id='autor' type="text" />
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
            index={index}
            autor={post.autor}
            comentario={post.comentario}

            //abordagem 1
            darLikeFunc={() => handleLikeClick(index)}

            //abordagem 2
            deleteFunc={handleDeleteClick}
            
            likes={post.likes}
          />
        )}
      </div>
    </>
  )
}

export default App
