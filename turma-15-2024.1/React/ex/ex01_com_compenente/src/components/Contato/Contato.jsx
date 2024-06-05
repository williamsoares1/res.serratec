const Contato = ({nome, telefone, temZap, observacao, excluirFunc, editarFunc, index}) => {
    return(
        <div className='boxContato' key={index}>
        <h1>{nome}</h1>
        <h2>{telefone}</h2>
        <h2>{temZap ? 'Possui WhatsApp' : 'Não possui WhatsApp'}</h2>
        <p>{observacao == '' ? '-' : observacao}</p>
        <div className='btns'>
        <button onClick={() => excluirFunc(index)}>X</button>
        <button onClick={() => editarFunc(index)}>Editar</button>
        </div>
      </div>
     )
}

export default Contato