package br.org.serratec.ex_02.controller;

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

import br.org.serratec.ex_02.model.Cliente;
import br.org.serratec.ex_02.repository.ClienteRepository;

@RestController
@RequestMapping("/clientes")
public class ClienteController {

    @Autowired
    private ClienteRepository repositorio;

    @GetMapping
    public ResponseEntity<List<Cliente>> obterTodos() {
        return ResponseEntity.ok(repositorio.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Cliente> obterPorId(@PathVariable Long id) {
        Optional<Cliente> cliente = repositorio.findById(id);

        if (cliente.isPresent()) {
            return ResponseEntity.ok(cliente.get());
        }

        return ResponseEntity.notFound().build();
    }

    @PostMapping
    public ResponseEntity<Cliente> cadastrarCliente(@RequestBody Cliente cliente) {
        repositorio.save(cliente);

        return new ResponseEntity<Cliente>(cliente, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Cliente> alterarCliente(@PathVariable Long id, @RequestBody Cliente cliente) {

        if (repositorio.existsById(id)) {
            cliente.setId(id);
            repositorio.save(cliente);
            return ResponseEntity.ok(cliente);
        }

        return ResponseEntity.badRequest().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> excluirCliente(@PathVariable Long id) {
        repositorio.deleteById(id);

        return ResponseEntity.noContent().build();
    }
}
