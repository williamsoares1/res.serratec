import { createContext, createElement, useState } from "react";

const NomeContext = createContext({})

const NomeProvider = ({ children }) => {
    const [nome, setNome] = useState('')

    return (
        <NomeContext.Provider value={{ nome, setNome }}>
            {children}
        </NomeContext.Provider>
    )
}

export { NomeContext, NomeProvider }