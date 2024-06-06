const Contato = ({nome, telefone, temZap, observacao, index, id, deleteFunc, editarFunc}) => {
    return (
        <>
            <div key={id}>
            <h1>{nome}</h1>
            <h2>{telefone}</h2>
            <h2>{temZap && "Tem WhatsApp"}</h2>
            <p>{observacao}</p>
            <button onClick={() => {
              deleteFunc(id)
            }}>X</button>
          </div>
        </>
    )
}

export default Contato