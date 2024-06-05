const Contato = ({ nome, telefone, temWhatsapp, observacoes, index, handleEditarContato, handleExcluirContato }) => {
  const style = {
    borderWidth: '2px',
    border: 'solid',
    borderRadius: '10px',
    marginBottom: '10px',
    padding: '10px',
    backgroundColor: 'black'
    }
  
  return (
        <>
            <div>
            <h3 style={{color: 'blue'}}>{nome}</h3>
            <p>{telefone}</p>
            <p>{temWhatsapp ? 
              <a href={`https://wa.me/${telefone}`}>Conversar</a>
            : 'Não'}</p>
            <p>{observacoes == '' ? '-' : observacoes}</p>
            <button onClick={() => {
              handleEditarContato({ nome, telefone, temWhatsapp, observacoes }, index)
            }}>Editar</button>
            <button onClick={() => {
              handleExcluirContato(index)
            }}>Excluir</button>
          </div>
        </>
    )
}

export default Contato