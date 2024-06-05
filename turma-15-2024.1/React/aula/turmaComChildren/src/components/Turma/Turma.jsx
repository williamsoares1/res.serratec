import Aluno from "../Aluno/Aluno"

const Turma = ({ nome, children }) => {
    return (
        <>
            <div>
                <h1>Turma: {nome}</h1>
                {children}
            </div>
        </>
    )
}

export default Turma