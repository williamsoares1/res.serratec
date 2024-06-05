const Contato = ({ nome, telefone, temWhatsapp, observacoes, index, handleEditarContato, handleExcluirContato }) => {
    return (
        <>
            <div>
            <h3>{nome}</h3>
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
            <p>=============================</p>
          </div>
        </>
    )
}

export default Contato