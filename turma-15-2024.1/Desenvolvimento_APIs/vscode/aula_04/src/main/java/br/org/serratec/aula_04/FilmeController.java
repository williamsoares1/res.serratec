package br.org.serratec.aula_04;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/filmes")
public class FilmeController {

    @Autowired
    private FilmeRepository repositorio;

    @GetMapping
    public ResponseEntity<List<Filme>> obterTodos() {
        return ResponseEntity.ok(repositorio.findAll());
    }

    @PostMapping
    // @ResponseStatus(HttpStatus.CREATED) ou coloca o STATUS ou coloca o
    // ResponseEntity
    public ResponseEntity<Filme> adicionar(@RequestBody Filme filme) {
        repositorio.save(filme);
        // no lugar do new Response e blablabla - URI endpoint =
        // uriBuilder.path("/filmes/{id}").buildAndExpand(filme.getId()).toUri();
        // return ResponseEntity.created(endpoint).body(filme);
        return new ResponseEntity<Filme>(filme, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Filme> obterPorId(@PathVariable Long id) {
        Optional<Filme> filme = repositorio.findById(id);

        if (filme.isPresent()) {
            return ResponseEntity.ok(filme.get());
        }

        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> excluirPorId(@PathVariable Long id) {
        repositorio.deleteById(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<Filme> alterar(@PathVariable Long id, @RequestBody Filme filme) {
        if (repositorio.existsById(id)) {
            filme.setId(id);
            repositorio.save(filme);
            return ResponseEntity.ok(filme);
        }

        return ResponseEntity.badRequest().build();
    }
}
