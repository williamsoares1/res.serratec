package org.br.serratec.api.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.br.serratec.api.dtos.LivroDTO;
import org.br.serratec.api.model.Autor;
import org.br.serratec.api.model.Editora;
import org.br.serratec.api.model.Livro;
import org.br.serratec.api.repository.AutorRepository;
import org.br.serratec.api.repository.EditoraRepository;
import org.br.serratec.api.repository.LivroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LivroService {

    @Autowired
    private LivroRepository livroRepositorio;

    @Autowired
    private AutorRepository autorRepositorio;

    @Autowired
    private EditoraRepository editoraRepositorio;

    public List<Livro> obterTodos() {
        return livroRepositorio.findAll();
    }

    public Livro adicionar(LivroDTO dto) {
        Livro entity = new Livro();

        entity.setTitulo(dto.titulo());
        entity.setIsbn(dto.isbn());
        entity.setAnoLancamento(dto.anoLancamento());
        Optional<Editora> editora = editoraRepositorio.findById(dto.editoraId());
        entity.setEditora(editora.get());

        List<Autor> autores = new ArrayList<>();

        for(Long autorID : dto.autorId()){
            Optional<Autor> autor = autorRepositorio.findById(autorID);
            autores.add(autor.get());
        }
        entity.setAutores(autores);
        livroRepositorio.save(entity);

        return entity;
    }


}
