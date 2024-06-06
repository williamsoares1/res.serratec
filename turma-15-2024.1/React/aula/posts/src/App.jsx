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

  useEffect(() => {//=> alternativa ao componentDidMount
    if(posts.length == 0)
      alert('Bem vindo')
  }, [])// -> Array de dependencias vazio, executa apenas na criação do componente
  
  useEffect(() => {//=> alternativa ao componentDidUpdate
    if(posts.length == 0)
      alert('Posts atualizado')
  }, [posts])// -> Executa a funcao quando posts for alterado

  const handleSubmit = (e) => {
    e.preventDefault()
    setPosts([...posts, { autor, comentario, likes: 0 }])
    setAutor('')
    setComentario('')
    inputAutor.current.focus()
    alert(inputAutor.current.value)
  }

  const handleAutorChange = (e) => {    
    setAutor(e.target.value)
  }

  const handleComentarioChange = (e) => {
    setComentario(e.target.value)
  }

  const handleExcluirClick = (index) => {
    setPosts(posts.filter((post, i) => i != index))
  }

  const handleLike = (index) => {
    setPosts(posts.map((post, i) => {
      // return i == index ? getComLikes() : getPadrao()
      return i == index ? { ...post, likes: post.likes + 1 } : post

//       if (i == index){
//         return {
//         ...post,
//           likes: post.likes + 1
//         }
//       }
//       else
//         return post
    }))
  }

  return (
    <>
     <form onSubmit={handleSubmit}>
      <label htmlFor='autor'>Autor:</label>
      <p />
      <input ref={inputAutor} id='autor' value={autor} onChange={handleAutorChange}/>

      <p />
      <label htmlFor='comentario'>Comentário:</label>
      <p />
      <textarea id='comentario' value={comentario} onChange={handleComentarioChange}/>
      <p />
      <button type='submit'>Publicar</button>
      </form>
      <p />
      <hr />
      <p />

      <div>
        {posts.map((post, index) =>
          <Post
            key={index}
            autor={post.autor}
            comentario={post.comentario}
            likes={post.likes}
            index={index}
            darLike={() => { handleLike(index) }}
            funcaoDelete={handleExcluirClick}

          />
        )}
      </div>
     
    </>
  )
}

export default App
