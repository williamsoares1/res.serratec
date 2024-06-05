import Aluno from "../Aluno/Aluno"

const Turma = ({nome, listaDeAlunos}) => {
    return (
        <>
            <div>
                <h1>Turma {nome}</h1>
                <div>
                    {(listaDeAlunos && listaDeAlunos.length > 0) && listaDeAlunos.map((aluno, index) => <Aluno key={index} nome={aluno}/>)}
                </div>
            </div>
        </>
    )
}

export default Turma