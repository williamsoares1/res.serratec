import { useState } from 'react'
import reactLogo from './assets/react.svg'
import viteLogo from '/vite.svg'
import Contato from './components/Contato/Contato'
import { MeuButton, Input } from './components/MeuButton/MeuButton'
import { Button } from '@chakra-ui/react'

function App() {  

  const [novoContato, setNovoContato] = useState({})
  // const [nome, setNome] = useState('')
  // const [telefone, setTelefone] = useState('')
  // const [temWhatsapp, setTemWhatsapp] = useState(false)
  // const [observacoes, setObservacoes] = useState('')

  const [listaDeContatos, setListaDeContatos] = useState([
    // {
    //   nome: "Raphael",
    //   telefone: 21995453140,
    //   temWhatsapp: false,
    //   observacoes: ''
    // },
    // {
    //   nome: "Raphael",
    //   telefone: 21995453140,
    //   temWhatsapp: false,
    //   observacoes: ''
    // }
  ])

  const handleSubmit = (e) => {
    e.preventDefault()
    setListaDeContatos([ ...listaDeContatos, novoContato])
    handleZerar()
  }

  const handleExcluirContato = (index) => {
    setListaDeContatos(listaDeContatos.filter((contatos, i) => i != index))
  }

  function handleEditarContato(contato , index){
    setNovoContato({ ...novoContato, contato })
    handleExcluirContato(index)
  }

  const handleZerar = () => {
    setNovoContato({ nome: '', telefone: '', temWhatsapp: '', observacoes: '' })
  }

  return (
    <>
    <MeuButton>Teste</MeuButton>
    <Input />
      <form onSubmit={handleSubmit} onReset={(e) => {
        handleZerar()
      }}>
        <label htmlFor='nome'>Nome: </label>
        <input required id='nome' value={novoContato.nome} onChange={(e) => {
          setNovoContato({ ...novoContato, nome: e.target.value })
        }} />
        <p />
        <label htmlFor='telefone'>Telefone:</label>
        <input required id='telefone' value={novoContato.telefone} onChange={(e) => {
          setNovoContato({ ...novoContato, telefone: e.target.value })
        }}/>
        <p />
        <label htmlFor='wpp'>Tem whatsapp:</label>
        <input id='wpp' type='checkbox' checked={novoContato.temWhatsapp}
          onChange={(e) => {
            setNovoContato({ ...novoContato, temWhatsapp: e.target.checked })
          }}
        />
        <p />
        <label htmlFor='obs'>Observações:</label>
        <textarea id='obs' value={novoContato.observacoes} onChange={(e) => {
          setNovoContato({ ...novoContato, observacoes: e.target.value })
        }}/>

        <p />
        <Button colorScheme='green' type='submit'>Salvar</Button>        
        <Button colorScheme='orange' type='reset'>Limpar formulario</Button>
      </form>
      <br />
      <hr />
      <br />
      <div>
        {listaDeContatos.map((contato, index) =>
          <Contato
            key={index}
            nome={contato.nome}
            telefone={contato.telefone}
            temWhatsapp={contato.temWhatsapp}
            index={index}
            observacoes={contato.observacoes}
            handleEditarContato={handleEditarContato}
            handleExcluirContato={handleExcluirContato}
            />
        )}
      </div>
    </>
  )
}

export default App
