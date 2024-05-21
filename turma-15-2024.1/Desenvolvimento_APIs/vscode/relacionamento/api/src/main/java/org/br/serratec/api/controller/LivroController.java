package org.br.serratec.api.controller;

import java.util.List;

import org.br.serratec.api.dtos.LivroDTO;
import org.br.serratec.api.model.Livro;
import org.br.serratec.api.service.LivroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/livro")
public class LivroController {

    @Autowired
    private LivroService servico;

    @GetMapping
    public List<Livro> buscarTodos(){
        return servico.obterTodos();
    }

    @PostMapping
    public Livro adicionar(@RequestBody LivroDTO livro){
        return servico.adicionar(livro);
    }
}
